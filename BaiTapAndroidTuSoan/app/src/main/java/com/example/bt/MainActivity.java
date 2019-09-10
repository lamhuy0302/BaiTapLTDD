package com.example.bt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvContact;
    Button btnThem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        final String value = intent.getStringExtra("key");
        lvContact = (ListView) findViewById(R.id.lvContact);
        ArrayList<Contact> arrContact = new ArrayList<>();

        Contact contact1 = new Contact( Color.RED,"Trương Đình Chiến","0123456789");
        Contact contact2 = new Contact( Color.RED,"Trương Đình Chiến","0123456789");

        arrContact.add(contact1);
        arrContact.add(contact2);

        CustomAdapter customAdaper = new CustomAdapter(this,R.layout.row,arrContact);
        lvContact.setAdapter(customAdaper);

        btnThem = (Button)findViewById(R.id.btnAdd);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add = new Intent(MainActivity.this,add_contact.class);
                startActivity(add);
            }
        });

    }
}
