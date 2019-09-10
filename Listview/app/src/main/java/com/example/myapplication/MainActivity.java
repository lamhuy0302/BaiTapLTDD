package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText etTen;
    Button btnThem,btnXoa,btnSua,btnTim,btnVoice;
    ListView lvItem;
    ArrayList<String> lstArr;
    ArrayAdapter apt;
    int pos = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTen = (EditText)findViewById(R.id.etTen);
        btnThem = (Button)findViewById(R.id.btnAdd);
        btnXoa = (Button)findViewById(R.id.btnRemove);
        btnSua = (Button)findViewById(R.id.btnEdit);
        btnTim = (Button)findViewById(R.id.btnSearch);
        lvItem = (ListView)findViewById(R.id.lvItem);
        btnVoice = (Button)findViewById(R.id.btnVoice);
        lstArr = new ArrayList<>();
        apt = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,lstArr);
        lvItem.setAdapter(apt);
        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int i, long l) {
                etTen.setText(lstArr.get(i));
                pos = i;
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lstArr.add(etTen.getText().toString());
                apt.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),"Thêm thành công!!!",Toast.LENGTH_LONG).show();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lstArr.remove(pos);
                apt.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),"Xoá thành công!!!",Toast.LENGTH_LONG).show();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lstArr.set(pos,etTen.getText().toString());
                apt.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),"Sửa thành công!!!",Toast.LENGTH_LONG).show();
            }
        });
        btnTim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apt.getFilter().filter(etTen.getText().toString());
                Toast.makeText(getApplicationContext(),"Tìm thành công!!!",Toast.LENGTH_LONG).show();
            }
        });
        btnVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                if (intent.resolveActivity(getPackageManager())!=null){
                    startActivityForResult(intent,10);
                }else Toast.makeText(getApplicationContext(),"Không hỗ trợ giọng bạn!!!",Toast.LENGTH_LONG).show();

            }
        });

    }
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        switch (requestCode){
            case 10:
                if(resultCode==RESULT_OK&&data!=null){
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    etTen.setText(result.get(0));
                }
                break;
        }
    }
}
