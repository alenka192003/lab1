package com.example.lab1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInFragment extends Fragment {
    private EditText emailInput;
    private EditText passwordInput;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        emailInput = view.findViewById(R.id.email_input);
        passwordInput = view.findViewById(R.id.password_input);
        Button loginButton = view.findViewById(R.id.login_button);
        Button registerButton = view.findViewById(R.id.register_button);

        // Получение данных из предыдущего фрагмента (если есть)
        if (getArguments() != null) {
            String email = getArguments().getString("email");
            emailInput.setText(email);
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();

                SharedPreferences preferences = getActivity().getSharedPreferences("user_data", Context.MODE_PRIVATE);
                String savedEmail = preferences.getString("email", null);
                String savedPassword = preferences.getString("password", null);

                // Проверка введенных данных
                if (email.equals(savedEmail) && password.equals(savedPassword)) {
                    // Переход на HomeFragment
                    ((MainActivity) getActivity()).navigateToHome();
                } else {
                    Toast.makeText(getActivity(), "Неправильный email или пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Переход на SignUpFragment
                ((MainActivity) getActivity()).navigateToSignUp();
            }
        });

        return view;
    }
}
