package com.example.moneytransfer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicInteger;

public class PaymentDeduct extends AppCompatActivity {
    TextView accountA, accountB, Title;
    String title;
    EditText subNum, amountNum;
    Button button;
    public static final String MyPREFERENCES = "MyPrefs1" ;
    SharedPreferences sharedpreferences;
    Integer amoont11;
    Integer amoont22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_deduct);

        AccountDetails accountDetails = new AccountDetails();
        AccountDetails2 accountDetails2 = new AccountDetails2();

        SharedPreferences sharedpreferencesa = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        String amount1 = sharedpreferencesa.getString("amount1","100");
        String amount2 = sharedpreferencesa.getString("amount2","100");

        try {
            amoont11 = Integer.parseInt(amount1);
            amoont22 = Integer.parseInt(amount2);
        }catch (Exception e){
            e.printStackTrace();
        }

        title = getIntent().getStringExtra("title");

        subNum = findViewById(R.id.subNum);
        amountNum = findViewById(R.id.amountNum);
        Toast.makeText(this, ""+amoont11, Toast.LENGTH_SHORT).show();

        accountA = findViewById(R.id.accountA);
        accountA.setOnClickListener(v->{

            accountA.setBackgroundColor(Color.parseColor("#aaaaaa"));
            accountB.setBackgroundColor(Color.parseColor("#ffffff"));

            if(amoont11 < Integer.parseInt(amountNum.getText().toString())){
                Toast.makeText(this, "Account balance is low", Toast.LENGTH_SHORT).show();
            }else {
                amoont11 = amoont11 - Integer.parseInt(amountNum.getText().toString());
                Toast.makeText(this, ""+amoont11, Toast.LENGTH_SHORT).show();
                sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("amount1", ""+amoont11);


                editor.commit();
            }

        });
        accountB = findViewById(R.id.accountB);
        accountB.setOnClickListener(v->{
            accountB.setBackgroundColor(Color.parseColor("#aaaaaa"));
            accountA.setBackgroundColor(Color.parseColor("#ffffff"));
            if(amoont22 < Integer.parseInt(amountNum.getText().toString())){
                Toast.makeText(this, "Account balance is low", Toast.LENGTH_SHORT).show();
            }else {
                amoont22 = amoont22 - Integer.parseInt(amountNum.getText().toString());
                Toast.makeText(this, ""+amoont22, Toast.LENGTH_SHORT).show();
                sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("amount2", ""+amoont22);


                editor.commit();
            }

        });
        Title = findViewById(R.id.Title);

        Title.setText(title);

        button = findViewById(R.id.button);
        button.setOnClickListener(v->{

            startActivity(new Intent(PaymentDeduct.this, Dashboard.class));

        });

    }
}