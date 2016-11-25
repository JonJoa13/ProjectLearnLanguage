package com.example.jon.projectlearnlanguage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ChangePWD extends AppCompatActivity implements View.OnClickListener {
    public EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_change_pwd);

        editText = (EditText)findViewById(R.id.et_mdpactuel);

        editText.setOnClickListener(this);
    }

    public void onClickModifyMDP(View w){

    }

    public void onClickBackToParam(View w){
        Intent intent = new Intent(ChangePWD.this,Parametres.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        editText.setText("");
    }
}
