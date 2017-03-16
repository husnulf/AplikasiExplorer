package com.husnulfikrah.blogspot.aplikasibaru;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class DetAct extends AppCompatActivity {
    ImageView imageView;
    WebView webView;

    String gambar,keterangan, judul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_det);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        judul = getIntent().getStringExtra("merk");
        getSupportActionBar().setTitle(judul);
        imageView= (ImageView) findViewById(R.id.ivgambar);
        webView = (WebView)findViewById(R.id.webV);
        webView.getSettings().setJavaScriptEnabled(true);
        keterangan = getIntent().getStringExtra("keterangan");
        String contentwvContent = "<html><body>" + keterangan + "</body></html>";
        webView.loadData(contentwvContent, "text/html", null);


        keterangan = getIntent().getStringExtra("keterangan");

        gambar = getIntent().getStringExtra("gambar");


        Glide.with(this)
                .load("http://31.220.55.37/muhammadhusnul/uploads/" + gambar )
                .crossFade()
                .into(imageView);


    }
}

