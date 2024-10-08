package com.example.lab1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Загружаем OnboardFragment по умолчанию
        if (savedInstanceState == null) {
            navigateToOnboard();
        }
    }

    public void navigateToOnboard() {
        replaceFragment(new OnboardFragment());
    }

    public void navigateToSignIn() {
        replaceFragment(new SignInFragment());
    }

    public void navigateToHome() {
        replaceFragment(new HomeFragment());
    }

    public void navigateToSignUp() {
        replaceFragment(new SignUpFragment());
    }

    public void navigateToSignInWithData(SignInFragment fragment) {
        replaceFragment(fragment);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null); // Добавляем в стек переходов
        transaction.commit();
    }
}
