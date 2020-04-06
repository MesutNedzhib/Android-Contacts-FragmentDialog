package com.example.appcontacts;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.appcontacts.contact.Contact;

public class AddContactFragment extends DialogFragment implements View.OnClickListener {

    private EditText name;
    private EditText phone;
    private Button add;
    AddContactDialogListener listener;

    public AddContactFragment() {}

    public static AddContactFragment newInstance(){
        return new AddContactFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.editTextName);
        phone = view.findViewById(R.id.editTextPhone);
        add = view.findViewById(R.id.Button);
        add.setOnClickListener(this);

        name.requestFocus();

        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener=(AddContactDialogListener)context;
    }

    @Override
    public void onClick(View v) {
        Contact contact = new Contact(name.getText().toString(),phone.getText().toString());
        listener.addContact(contact);
        dismiss();
    }
}
