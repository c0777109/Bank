package com.example.moneytransfer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Account extends AppCompatActivity {
    TextView xyzBal, abcBal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        xyzBal = findViewById(R.id.xyzBal);
        abcBal = findViewById(R.id.abcBal);

        SharedPreferences sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        String amount1 = sharedpreferences.getString("amount1","");
        String amount2 = sharedpreferences.getString("amount2","");

        xyzBal.setText("$"+amount1);
        abcBal.setText("$"+amount2);


//        AccountDetails accountDetails = new AccountDetails("adam", "123456789", 100);
//        AccountDetails2 accountDetails2 = new AccountDetails2("som", "00112233", 150);



    }
}