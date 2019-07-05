package com.example.realmdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private EditText name;
    private EditText dept;
    private EditText phone;
    private EditText roll;
    Button button;
    Button display;
    Switch aSwitch;
    String gender = "Male" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
//        Realm.init(this);
        name = findViewById(R.id.editText);
        dept = findViewById(R.id.editText2);
        roll = findViewById(R.id.editText3);
        phone = findViewById(R.id.editText4);
        button=findViewById(R.id.button);
        display=findViewById(R.id.button2);
        aSwitch = findViewById(R.id.switch1);

    }
    public void onSwitch(View view){

        if(aSwitch.isChecked()){
            gender="Female";
        }
        else
            gender="Male";

    }
    public void onSave(View view) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        try {
            Student student = realm.createObject(Student.class, System.currentTimeMillis() / 1000);
            student.setName(name.getText().toString());
            student.setDept(dept.getText().toString());
            student.setPhn(Long.parseLong(phone.getText().toString()));
            student.setRollno(Long.parseLong(roll.getText().toString()));
            student.setGender(gender);
            realm.commitTransaction();
            Toast.makeText(mContext, "Success", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            realm.cancelTransaction();
            Toast.makeText(mContext, "Failure" + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
        public void onDisplay(View view){
            Intent intent = new Intent(this,DisplayActivity.class);
            startActivity(intent);
        }
}