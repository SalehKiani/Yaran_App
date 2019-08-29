package com.example.yaran;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class login_code extends AppCompatActivity {

    TextView phone_in_code_tv;
    EditText edittext;
    Login login = new Login();
    String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_code);



        phone_in_code_tv=findViewById(R.id.phone_in_code_TV);
        phone_in_code_tv.setText(login_phone.phone_number);
        edittext=findViewById(R.id.verify_ET);

        login.Login_Register(getApplicationContext());
    }

    public void change_phone_Click(View view) {
        this.finish();
    }

    public void verify_BTN(View view){
        this.code=edittext.getText().toString();
        login.verifynum(getApplicationContext(),code);
    }
}
