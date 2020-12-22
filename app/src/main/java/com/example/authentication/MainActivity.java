package com.example.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.authentication.database.StoreDatabase;


import static com.example.authentication.database.StoreDatabase.COLUMN_USER_CITY;
import static com.example.authentication.database.StoreDatabase.COLUMN_USER_EMAIL;
import static com.example.authentication.database.StoreDatabase.COLUMN_USER_NAME;
import static com.example.authentication.database.StoreDatabase.COLUMN_USER_PASSWORD;
import static com.example.authentication.database.StoreDatabase.COLUMN_USER_PHONE;
import static com.example.authentication.database.StoreDatabase.TABLE_USERS;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private StoreDatabase storeDb;
    private SQLiteDatabase sqdb;

    EditText et_username;
    EditText et_email;
    EditText et_city;
    EditText et_phone;
    EditText et_password;

    Button reg_button;
    Button log_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storeDb = new StoreDatabase(this);
        sqdb = storeDb.getWritableDatabase();

        et_username = findViewById(R.id.et_username);
        et_email = findViewById(R.id.et_email);
        et_city = findViewById(R.id.et_city);
        et_phone = findViewById(R.id.et_phone);
        et_password = findViewById(R.id.et_password);
        reg_button = findViewById(R.id.reg_button);
        log_button = findViewById(R.id.log_button);

        reg_button.setOnClickListener(this);
        log_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.reg_button:
                if (TextUtils.isEmpty(et_username.getText())){
                    et_username.setError("Fill again");
                    return;
                }

                if (TextUtils.isEmpty(et_email.getText())){
                    et_email.setError("Fill again");
                    return;
                }

                if (TextUtils.isEmpty(et_city.getText())){
                    et_city.setError("Fill again");
                    return;
                }

                if (TextUtils.isEmpty(et_phone.getText())){
                    et_phone.setError("Fill again");
                    return;
                }

                if (TextUtils.isEmpty(et_password.getText())){
                    et_password.setError("Fill again");
                    return;
                }

                ContentValues versionValues = new ContentValues();
                versionValues.put(COLUMN_USER_NAME, et_username.getText().toString());
                versionValues.put(COLUMN_USER_EMAIL, et_email.getText().toString());
                versionValues.put(COLUMN_USER_CITY, et_city.getText().toString());
                versionValues.put(COLUMN_USER_PHONE, et_phone.getText().toString());
                versionValues.put(COLUMN_USER_PASSWORD, et_password.getText().toString());


                sqdb.insert(TABLE_USERS, null, versionValues);
                Toast.makeText(this, "Info is exported to database", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;

            case R.id.log_button:
                Intent intent2 = new Intent(this, LoginActivity.class);
                startActivity(intent2);

                break;
            }


        
    }
}