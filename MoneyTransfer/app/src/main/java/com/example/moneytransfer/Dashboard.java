package com.example.moneytransfer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {

    TextView checkBankAccount, phone, gas, water, hydro, trans, transtoanother;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    TextView add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        trans = findViewById(R.id.trans);
        trans.setOnClickListener(v->{
            startActivity(new Intent(Dashboard.this, TransferToAccount.class));
        });

        add = findViewById(R.id.add);
        add.setOnClickListener(v->{
            sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpreferences.edit();

            editor.putString("amount1", "100");
            editor.putString("amount2", "100");

            editor.commit();

            Toast.makeText(this, "Money added $100", Toast.LENGTH_SHORT).show();
        });



        checkBankAccount = findViewById(R.id.checkBankAccount);
        checkBankAccount.setOnClickListener(v->{
            startActivity(new Intent(Dashboard.this, Account.class));
        });

        phone = findViewById(R.id.phone);
        phone.setOnClickListener(v->{
            Intent intent = new Intent(Dashboard.this, PaymentDeduct.class);
            intent.putExtra("title","phone");
            startActivity(intent);
        });

        gas = findViewById(R.id.gas);
        gas.setOnClickListener(v->{
            Intent intent = new Intent(Dashboard.this, PaymentDeduct.class);
            intent.putExtra("title","gas");
            startActivity(intent);
        });

        water = findViewById(R.id.water);
        water.setOnClickListener(v->{
            Intent intent = new Intent(Dashboard.this, PaymentDeduct.class);
            intent.putExtra("title","water");
            startActivity(intent);
        });

        hydro = findViewById(R.id.hydro);
        hydro.setOnClickListener(v->{
            Intent intent = new Intent(Dashboard.this, PaymentDeduct.class);
            intent.putExtra("title","hydro");
            startActivity(intent);
        });

        transtoanother = findViewById(R.id.transtoanother);
        transtoanother.setOnClickListener(v->{
            Intent intent = new Intent(Dashboard.this, TransferToAnother.class);
//            intent.putExtra("title","hydro");
            startActivity(intent);
        });

    }
}