package com.example.appcontacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.appcontacts.contact.Contact;
import com.example.appcontacts.contact.ContactSource;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements AddContactDialogListener {

    ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView view = findViewById(R.id.recycler_view);

        adapter = new ContactAdapter(ContactSource.getContacts());

        view.setAdapter(adapter);
        view.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton button = findViewById(R.id.floatingActionButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                AddContactFragment addContactFragment = AddContactFragment.newInstance();
                addContactFragment.show(fm,"fragment_add_contact");
            }
        });
    }

    @Override
    public void addContact(Contact contact) {
            adapter.addContact(contact);
    }
}
