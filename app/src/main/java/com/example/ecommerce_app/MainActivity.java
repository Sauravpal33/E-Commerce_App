package com.example.ecommerce_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.ecommerce_app.Fragments.Addtocart_fragment;
import com.example.ecommerce_app.Fragments.Favorite_list;
import com.example.ecommerce_app.Fragments.Product_list;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.razorpay.PaymentResultListener;

import java.util.Objects;


public class MainActivity extends AppCompatActivity implements PaymentResultListener{

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    FrameLayout container;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        container = findViewById(R.id.container);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.container,new Product_list());
        ft.addToBackStack(null);
        ft.commit();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("E-Commerce App");

        navigationView = findViewById(R.id.navMenu);
        drawerLayout = findViewById(R.id.openDrawer);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.home){
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.container,new Product_list());
                    ft.addToBackStack(null);
                    ft.commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (itemId == R.id.logout) {
                    FirebaseAuth.getInstance().signOut();
                    Intent intent = new Intent(MainActivity.this, Login_Activity.class);
                    startActivity(intent);
                    finish();
                }
                else if (itemId == R.id.drawerFavorite) {
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.container,new Favorite_list());
                    ft.addToBackStack(null);
                    ft.commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.favorite){
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.container,new Favorite_list());
            ft.addToBackStack(null);
            ft.commit();
        }
        if (itemId == R.id.cart){
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.container,new Addtocart_fragment());
            ft.addToBackStack(null);
            ft.commit();
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onPaymentSuccess(String razorpayPaymentId) {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.container);
        if (currentFragment instanceof Addtocart_fragment) {
            ((Addtocart_fragment) currentFragment).onPaymentSuccess(razorpayPaymentId);
        }
    }

    @Override
    public void onPaymentError(int code, String response) {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.container);
        if (currentFragment instanceof Addtocart_fragment) {
            ((Addtocart_fragment) currentFragment).onPaymentError(code, response);
        }
    }
}