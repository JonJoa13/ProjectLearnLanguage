package com.example.jon.projectlearnlanguage;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.provider.SyncStateContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jon.projectlearnlanguage.EditorZone.ChoiceView;
import com.example.jon.projectlearnlanguage.EditorZone.ModifyDeleteChoice;

import java.util.Locale;

import db.object.object.Choice;

public class VocabulaireTest extends AppCompatActivity {
    public EditText et_answer1,
            et_answer2,
            et_answer3,
            et_answer4,
            et_answer5;

    public String rep1_fr, rep2_fr, rep3_fr, rep4_fr, rep5_fr,
            rep1_en, rep2_en, rep3_en, rep4_en, rep5_en;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_vocabulaire_test);
    }

    public void onClickBackToVoc(View w){
        Intent intent = new Intent(VocabulaireTest.this,Vocabulaire.class);
        startActivity(intent);
    }

    public void onClickControlVoc(View w) {
        et_answer1 = (EditText) findViewById(R.id.et_rep1);
        et_answer2 = (EditText) findViewById(R.id.et_rep2);
        et_answer3 = (EditText) findViewById(R.id.et_rep3);
        et_answer4 = (EditText) findViewById(R.id.et_rep4);
        et_answer5 = (EditText) findViewById(R.id.et_rep5);

        rep1_fr = "rouge";
        rep2_fr = "bleu";
        rep3_fr = "blanc";
        rep4_fr = "vert";
        rep5_fr = "orange";

        rep1_en = "red";
        rep2_en = "blue";
        rep3_en = "white";
        rep4_en = "green";
        rep5_en = "orange";


//
//
//        Locale current = getResources().getConfiguration().locale;
//        if (current.equals("en")){
//            if(et_answer1.getText().toString().equalsIgnoreCase(rep1_fr)){
//                if(et_answer2.getText().toString().equalsIgnoreCase(rep2_fr)){
//                    if(et_answer3.getText().toString().equalsIgnoreCase(rep3_fr)){
//                        if(et_answer4.getText().toString().equalsIgnoreCase(rep4_fr)){
//                            if(et_answer5.getText().toString().equalsIgnoreCase(rep5_fr)){
//                                AlertDialog.Builder alert = new AlertDialog.Builder (this);
//                                // Setting Dialog Title
//                                alert.setTitle(R.string.da_editTitelResult);
//
//                                // Setting Dialog Message
//                                alert.setMessage(R.string.da_editCongrats);
//
//                                // Setting Positive "Yes" Button
//                                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                                    public void onClick(DialogInterface dialog, int which) {
//
//                                        Intent intent = new Intent(VocabulaireTest.this, ChoixExercices.class);
//                                        startActivity(intent);
//                                    }
//                                });
//
//                                // Showing Alert Message
//                                alert.show();
//                                Intent intent = new Intent(VocabulaireTest.this,ChoixExercices.class);
//                                startActivity(intent);
//
//
//                            }else{
//
//                                // do something else
//                            }
//
//
//                        }else{
//
//                            // do something else
//                        }
//
//
//                    }else{
//
//                        // do something else
//                    }
//
//
//                }else{
//
//                    // do something else
//                }
//
//
//            }else{
//
//                // do something else
//            }
//
//
//        }else
//        {
//            if(et_answer1.getText().toString().equalsIgnoreCase(rep1_en)){
//                if(et_answer2.getText().toString().equalsIgnoreCase(rep2_en)){
//                    if(et_answer3.getText().toString().equalsIgnoreCase(rep3_en)){
//                        if(et_answer4.getText().toString().equalsIgnoreCase(rep4_en)){
//                            if(et_answer5.getText().toString().equalsIgnoreCase(rep5_en)){
//                                AlertDialog.Builder alert = new AlertDialog.Builder (this);
//                                // Setting Dialog Title
//                                alert.setTitle(R.string.da_editTitelResult);
//
//                                // Setting Dialog Message
//                                alert.setMessage(R.string.da_editCongrats);
//
//                                // Setting Positive "Yes" Button
//                                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                                    public void onClick(DialogInterface dialog, int which) {
//
//                                        Intent intent = new Intent(VocabulaireTest.this, ChoixExercices.class);
//                                        startActivity(intent);
//                                    }
//                                });
//
//                                // Showing Alert Message
//                                alert.show();
//                                Intent intent = new Intent(VocabulaireTest.this,ChoixExercices.class);
//                                startActivity(intent);
//
//
//                            }else{
//
//                                // do something else
//                            }
//
//
//                        }else{
//
//                            // do something else
//                        }
//
//
//                    }else{
//
//                        // do something else
//                    }
//
//
//                }else{
//
//                    // do something else
//                }
//
//
//            }else{
//
//                // do something else
//            }
//
//
//        }


    }

}
