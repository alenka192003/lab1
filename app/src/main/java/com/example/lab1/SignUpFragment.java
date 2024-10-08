package com.example.lab1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SignUpFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        // Инициализация элементов
        EditText nameInput = view.findViewById(R.id.name_input);
        EditText emailInput = view.findViewById(R.id.email_input);
        EditText passwordInput = view.findViewById(R.id.password_input);
        Button signUpButton = view.findViewById(R.id.sign_up_button);

        // Обработка нажатия на кнопку регистрации
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString();
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();

                // Сохраняем данные пользователя в SharedPreferences
                SharedPreferences preferences = getActivity().getSharedPreferences("user_data", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("name", name);
                editor.putString("email", email);
                editor.putString("password", password);
                editor.apply();  // Сохраняем изменения

                // Переход к фрагменту входа
                SignInFragment signInFragment = new SignInFragment();
                // Передача email для автозаполнения
                Bundle result = new Bundle();
                result.putString("email", email);
                signInFragment.setArguments(result);

                // Навигация к фрагменту входа
                ((MainActivity) getActivity()).navigateToSignInWithData(signInFragment);
            }
        });

        return view;
    }
}
