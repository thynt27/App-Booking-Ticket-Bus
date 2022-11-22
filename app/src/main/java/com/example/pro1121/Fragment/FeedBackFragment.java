package com.example.pro1121.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pro1121.R;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedBackFragment extends Fragment {
    private FirebaseDatabase db;
    private DatabaseReference ref;
    private Button btnFeedBack;
    private EditText edtFeedBack, edtFeedBackEmail;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feedback, container, false);

        btnFeedBack = view.findViewById(R.id.btnFeedBack);
        edtFeedBack = view.findViewById(R.id.edtFeedBack);
        edtFeedBackEmail = view.findViewById(R.id.edtFeedBackEmail);

        db = FirebaseDatabase.getInstance();
        ref = db.getReference();

        btnFeedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref.setValue(edtFeedBackEmail.getText().toString());
                ref.setValue(edtFeedBack.getText().toString());
            }
        });

        return view;
    }
}
