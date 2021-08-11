package com.example.moneytransfer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class TransferToAnother extends AppCompatActivity {
    Integer amoont111;
    Integer amoont222;
    SharedPreferences sharedpreferences;
    Button button2;
    EditText nameOther, numOther, amountOther;
    RadioButton abcCheck, xyzCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_to_another);

        abcCheck = findViewById(R.id.abcCheck);
        xyzCheck = findViewById(R.id.xyzCheck);

        nameOther = findViewById(R.id.nameOther);
        numOther = findViewById(R.id.numOther);
        amountOther = findViewById(R.id.amountOther);


        button2 = findViewById(R.id.button2);

        button2.setOnClickListener(v->{
            if(nameOther.getText().toString().isEmpty() && numOther.getText().toString().isEmpty() && amountOther.getText().toString().isEmpty()){
                Toast.makeText(this, "Please fill all details", Toast.LENGTH_SHORT).show();
            }else if(abcCheck.isChecked() == true){
                abcCheck.setChecked(true);
                xyzCheck.setChecked(false);
                if(Integer.parseInt(amountOther.getText().toString()) > amoont222){
                    Toast.makeText(this, "Insufficient balance", Toast.LENGTH_SHORT).show();
                }else {
                    amoont222 = amoont222 - Integer.parseInt(amountOther.getText().toString());
                    Toast.makeText(this, ""+amoont222, Toast.LENGTH_SHORT).show();
                    sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();

                    editor.putString("amount2", ""+amoont222);


                    editor.commit();
                }
            } else if(xyzCheck.isChecked()){
                abcCheck.setChecked(false);
                xyzCheck.setChecked(true);
                if(Integer.parseInt(amountOther.getText().toString()) > amoont111){
                    Toast.makeText(this, "Insufficient balance", Toast.LENGTH_SHORT).show();
                }else {
                    amoont111 = amoont111 - Integer.parseInt(amountOther.getText().toString());
                    Toast.makeText(this, ""+amoont111, Toast.LENGTH_SHORT).show();
                    sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();

                    editor.putString("amount1", ""+amoont111);


                    editor.commit();
                }
            }
            else {
                startActivity(new Intent(TransferToAnother.this, Dashboard.class));
            }
        });

        SharedPreferences sharedpreferencesa = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        String amount1 = sharedpreferencesa.getString("amount1","100");
        String amount2 = sharedpreferencesa.getString("amount2","100");

        try {
            amoont111 = Integer.parseInt(amount1);
            amoont222 = Integer.parseInt(amount2);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}