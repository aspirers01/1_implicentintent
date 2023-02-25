package com.example.a10implicentintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
 Button btnmail,btnshare,btnweb,btndial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btndial=findViewById(R.id.btndail);
        btnshare=findViewById(R.id.btnshare);
        btnmail=findViewById(R.id.btnmail);
        btnweb=findViewById(R.id.btnweb);

        btnweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="google.com";
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

            }
        });
        btndial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent idial=new Intent(Intent.ACTION_DIAL);
                idial.setData(Uri.parse("tel:" +"7387243423"));
//
                    startActivity(idial);
//
            }
        });
        btnmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imail=new Intent(Intent.ACTION_SEND);
                     imail.setType("message/rfc822");
                     imail.putExtra(Intent.EXTRA_EMAIL,"pankajrana0908@gamail.com");
                     imail.putExtra(Intent.EXTRA_SUBJECT,"hello0");
                     imail.putExtra(Intent.EXTRA_TEXT,"my testx sd;lkfsjdf;lk");
                     startActivity(imail);
            }
        });
        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ishare=new Intent(Intent.ACTION_SEND);
                 ishare.setType("message/plaintxt");
                 ishare.putExtra(Intent.EXTRA_TEXT,"heello this is my txt");
                 startActivity(Intent.createChooser(ishare,"share via"));

            }
        });
    }
}