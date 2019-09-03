package com.example.student.bai1;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ActivityBai4 extends AppCompatActivity {

    AlertDialog msg = new AlertDialog.Builder(ActivityBai4.this).create();
    Button Gui;
    String bangcap;
    String sothich;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
    }

    public void GuiThongTin(View v){

        Gui = (Button)findViewById(R.id.btnGui);
        if((((EditText)findViewById(R.id.etName)).getText().toString().length()<3)){
            msg.setMessage("Ten phai >=3");
            msg.show();
            return;
        }
        if((((EditText)findViewById(R.id.etCMND)).getText().toString().length()!=9)){
            msg.setMessage("CMND phai co 9 so");
            msg.show();
            return;
        }
        if(((RadioButton)findViewById(R.id.rbTrungcap)).isChecked()==true)
            bangcap = "Trung cap";
        else  if(((RadioButton)findViewById(R.id.rbCaodang)).isChecked()==true)
            bangcap = "Cao dang";
        else bangcap = "Dai hoc";
        //----
        if(((CheckBox)findViewById(R.id.cbDocbao)).isChecked()==true)
            sothich = "Doc bao";
        else  if(((CheckBox)findViewById(R.id.cbDocsach)).isChecked()==true)
            sothich = "Doc sach";
        else sothich = "Doc coding";
        Gui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg.setTitle("Thong bao");
                msg.setMessage(((EditText)findViewById(R.id.etName)).getText().toString()+"\n"+((EditText)findViewById(R.id.etCMND)).getText().toString()+"\n"+bangcap+" "+sothich);
                msg.show();
            }
        });
    }
}
