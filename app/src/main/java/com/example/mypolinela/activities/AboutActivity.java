package com.example.mypolinela.activities;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mypolinela.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView tvContact = (TextView) findViewById(R.id.tvContact);

        tvContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto :"));
                email.setType("massage/rfc822");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"adedimas778@gmail.com, ainuddinfadil@gmail.com"});

                startActivity(Intent.createChooser(email, "Send Mail"));
            }
        });

    }
}
