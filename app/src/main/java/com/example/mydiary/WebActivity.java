package com.example.mydiary;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.cookandroid.finish.R;

public class WebActivity extends AppCompatActivity {
    ImageView back;
    WebView web;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        back = (ImageView) findViewById(R.id.back);

        web = (WebView) findViewById(R.id.wh);
        web.setWebViewClient(new CookWebViewClient());
        WebSettings webSet = web.getSettings();
        webSet.setBuiltInZoomControls(true);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        web.loadUrl("https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EB%82%A0%EC%94%A8");
    }
}

class CookWebViewClient extends WebViewClient {
    public boolean shouldOverrindeUrlLoading (WebView view, String url) {
        return super.shouldOverrideUrlLoading(view, url);
    }
}
