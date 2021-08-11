package com.example.moneytransfer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TransferToAccount extends AppCompatActivity {
    EditText enterBank, enterAmount;
    TextView otherBank;
    Button Done;
    Integer amoont111;
    Integer amoont222;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_to_account);


        enterBank = findViewById(R.id.enterBank);
        otherBank = findViewById(R.id.otherBank);
        Done = findViewById(R.id.Done);
        enterAmount = findViewById(R.id.enterAmount);

        SharedPreferences sharedpreferencesa = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        String amount1 = sharedpreferencesa.getString("amount1","100");
        String amount2 = sharedpreferencesa.getString("amount2","100");

        try {
            amoont111 = Integer.parseInt(amount1);
            amoont222 = Integer.parseInt(amount2);
        }catch (Exception e){
            e.printStackTrace();
        }



        Done.setOnClickListener(v->{
            if(enterBank.getText().toString().isEmpty()){
                Toast.makeText(this, "Please enter amount", Toast.LENGTH_SHORT).show();
            }else if(Integer.parseInt(enterAmount.getText().toString()) < 1){
                Toast.makeText(this, "Please enter valid amount", Toast.LENGTH_SHORT).show();
            }else if(enterBank.getText().toString().contains("xyz") || enterBank.getText().toString().contains("XYZ")){
                otherBank.setText("ABC Bank");
                if((Integer.parseInt(enterAmount.getText().toString()) > amoont222)){
                    Toast.makeText(this, "Insuffisient balance", Toast.LENGTH_SHORT).show();
                }else {
                    amoont222 = amoont222 - Integer.parseInt(enterAmount.getText().toString());
                    amoont111 = amoont111 + Integer.parseInt(enterAmount.getText().toString());
                    Toast.makeText(this, ""+amoont222, Toast.LENGTH_SHORT).show();
                    sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();

                    editor.putString("amount2", ""+amoont222);
                    editor.putString("amount1", ""+amoont111);


                    editor.commit();
                }
            }else if(enterBank.getText().toString().contains("abc") || enterBank.getText().toString().contains("ABC")){
                otherBank.setText("XYZ BAnk");
                if((Integer.parseInt(enterAmount.getText().toString()) > amoont111)){
                    Toast.makeText(this, "Insuffisient balance", Toast.LENGTH_SHORT).show();
                }else {
                    amoont111 = amoont111 - Integer.parseInt(enterAmount.getText().toString());
                    amoont222 = amoont222 + Integer.parseInt(enterAmount.getText().toString());
                    Toast.makeText(this, ""+amoont111, Toast.LENGTH_SHORT).show();
                    sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();

                    editor.putString("amount1", ""+amoont111);
                    editor.putString("amount2", ""+amoont222);


                    editor.commit();
                }
            }
            else{
                Toast.makeText(this, "Payment done", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(TransferToAccount.this, Dashboard.class));
            }
        });

    }
}