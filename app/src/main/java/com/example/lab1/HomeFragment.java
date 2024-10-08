package com.example.lab1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView chatList = view.findViewById(R.id.chat_list);
        chatList.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<Chat> chats = Arrays.asList(
                new Chat("John", "Привет!", "12:00"),
                new Chat("Alice", "Как дела?", "12:30")
        );

        ChatAdapter adapter = new ChatAdapter(chats);
        chatList.setAdapter(adapter);

        return view;
    }
}
