package com.worldinova.open.javamailapi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.worldinova.open.javamailapi.gmailbackgroundlibrary.BackgroundMail;

public class MainActivity extends AppCompatActivity {

    String sEmail, sPassword;
    Button send_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send_btn = findViewById(R.id.send_btn);

        /*

        before use sender email.you must do following steps

             1.https://accounts.google.com/b/0/DisplayUnlockCaptcha Click This Link And Allow It
             2.https://myaccount.google.com/u/6/lesssecureapps Click This Link And Turn On It

          */


        //Enter the email and password of the above activated accounts above
        sEmail = "youremail@gmail.com";
        sPassword = "sender_password";

        send_btn.setOnClickListener(v -> {
            BackgroundMail.newBuilder(this)
                    .withUsername(sEmail)
                    .withPassword(sPassword)
                    .withMailTo("customerworldinova@gmail.com")
                    .withType(BackgroundMail.TYPE_PLAIN)
                    .withSubject("this is the subject")
                    .withBody("this is the body")
                    .withOnSuccessCallback(() -> {
                        //do some magic
                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                    })
                    .withOnFailCallback(() -> {
                        //do some magic
                        Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_SHORT).show();
                    })
                    .send();
        });


    }
}