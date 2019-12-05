package com.sample.foo.simplerssreader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

public class ItemDetail extends AppCompatActivity {

    WebView webView;
    private TextView tvContent, tvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

//        tvTitle = (TextView) findViewById(R.id.tvTitle);
//        tvContent = (TextView) findViewById(R.id.tvContent);
        Intent intent = getIntent();
        String content = intent.getStringExtra("link");
        String title = intent.getStringExtra("title");
        this.setTitle(title);
        WebView webview = (WebView) findViewById(R.id.help_webview);
        webview.loadUrl(content);


    }

    public void quaylai(View view) {
        Intent in = new Intent(this,MainActivity.class);
        startActivity(in);
    }


}
