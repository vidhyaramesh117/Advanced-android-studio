package com.example.advanced_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class q_r_code extends AppCompatActivity implements View.OnClickListener
{
    Button scanner;
    TextView qr_content,qr_format;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);

        scanner = findViewById(R.id.scan);
        qr_content = findViewById(R.id.qr_content);
        qr_format = findViewById(R.id.qr_format);

        scanner.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        IntentIntegrator intentIntegrator = new IntentIntegrator(this);
        intentIntegrator.setPrompt("Scan a QR code");
        intentIntegrator.setOrientationLocked(true);
        intentIntegrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(intentResult != null)
        {
            if (intentResult.getContents() == null)
            {
                Toast.makeText(getBaseContext(), "Cancelled", Toast.LENGTH_SHORT).show();
            }
            else
            {
                qr_content.setText(intentResult.getContents());
                qr_format.setText(intentResult.getFormatName());
            }
        }
        else
        {
            super.onActivityResult(requestCode,resultCode,data);
        }
    }
}