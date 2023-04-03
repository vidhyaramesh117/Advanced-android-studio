package com.example.advanced_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class validations extends AppCompatActivity
{

    private EditText name_et,job_et,gmail_et,password_et;
    private Button proceed_btn,cancel_btn;
    boolean is_all_fields_checked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validations);

        name_et = findViewById(R.id.name);
        job_et = findViewById(R.id.job);
        gmail_et = findViewById(R.id.gmail);
        password_et = findViewById(R.id.password);
        proceed_btn = findViewById(R.id.btn_proceed);
        cancel_btn = findViewById(R.id.btn_cancel);

        proceed_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                is_all_fields_checked = checked_all_fields();
                if (is_all_fields_checked)
                {
                    Intent intent = new Intent(getApplication(),valid_proceed_page.class);
                    startActivity(intent);
                }
            }
        });

        cancel_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                validations.this.finish();
                System.exit(0);
            }
        });

    }

    private boolean checked_all_fields()
    {
        if (name_et.length() == 0)
        {
            name_et.setError("Name is required");
            return false;
        }
        if (job_et.length() == 0)
        {
            job_et.setError("Job is required");
            return false;
        }
        if (gmail_et.length() == 0)
        {
            gmail_et.setError("Gmail is required");
            return false;
        }
        if (password_et.length() == 0)
        {
            password_et.setError("Password is required");
            return false;
        }
        else if (password_et.length() < 5)
        {
            password_et.setError("Password must be atleast 5 characters");
            return false;
        }
        return true;
    }

}