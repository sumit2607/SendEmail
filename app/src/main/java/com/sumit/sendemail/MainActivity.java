package com.sumit.sendemail;

import androidx.appcompat.app.AppCompatActivity;
import javax.mail.Message;
import  javax.mail.MessagingException;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {
private Button mBtnSend;
private EditText mBtnEditText, mBtnEditText3;
private EditText mBtnEditText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnEditText = findViewById(R.id.mBtnEditText);
        mBtnEditText2 = findViewById(R.id.mBtnEditText2);
        mBtnEditText3 = findViewById(R.id.mBtnEditText3);;
        mBtnSend = findViewById(R.id.mBtnSend);

        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implicit intent example
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
               emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, " email subject");
                emailIntent.putExtra(Intent.EXTRA_CC, new String[]{"dcosta123@gmail.com , nrupul456@masai.com"});
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Hi Sir, This mail is regarding my leaves as I won’t be able to attend the team meetings due to health issues. Kindly excuse my absence");

                // Handle Activity not found exception here

                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activitiesList = packageManager.queryIntentActivities(emailIntent, 0);
                if (((List<?>) activitiesList).size() >= 1) {
                    startActivity(emailIntent);
                } else {
                    // No activity found to handle email intent
                }
            }
        });
    }
}
