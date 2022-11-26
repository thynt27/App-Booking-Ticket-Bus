package com.example.pro1121.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.pro1121.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedBackFragment extends Fragment {
    private Button btnFeedBack;
    private EditText edtFeedBack, edtFeedBackEmail, edtSDT;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feedback, container, false);

        btnFeedBack = view.findViewById(R.id.btnFeedBack);
        edtFeedBack = view.findViewById(R.id.edtFeedBack);
        edtFeedBackEmail = view.findViewById(R.id.edtFeedBackEmail);
        edtSDT = view.findViewById(R.id.edtSDT);

        setProFile();

        btnFeedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickFeedBack();
            }
        });

        return view;
    }

    private void onClickFeedBack(){
        String feedback ="feedback/";
        int id=0;
        id+=1;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(feedback + id + "/email");
        myRef.setValue(edtFeedBackEmail.getText().toString().trim());
        DatabaseReference myRef1 = database.getReference(feedback + id + "/phone");
        myRef1.setValue(edtSDT.getText().toString().trim());
        DatabaseReference myRef2 = database.getReference(feedback + id + "/cmt");
        myRef2.setValue(edtFeedBack.getText().toString().trim(), new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                Toast.makeText(getActivity(), "Gửi thành công !!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setProFile(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null){
            return;
        }
        edtFeedBackEmail.setText(user.getEmail());
        edtSDT.setText(user.getPhoneNumber());
        Glide.with(getActivity()).load(user.getPhotoUrl()).error(R.drawable.ic_avatar);
        Log.d("<><><><><>TAG", "setProFile: ");
    }

}
