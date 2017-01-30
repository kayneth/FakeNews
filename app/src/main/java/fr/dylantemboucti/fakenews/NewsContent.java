package fr.dylantemboucti.fakenews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NewsContent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);

        String title;
        String content;

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                title= null;
                content= null;
            } else {
                title= extras.getString("title");
                content= extras.getString("content");
            }
        } else {
            title= (String) savedInstanceState.getSerializable("title");
            content= (String) savedInstanceState.getSerializable("content");
        }


        setTitle(title);
        loadData(content);
        
    }

    private void loadData(String content){
        WebView webView = (WebView) findViewById(R.id.webview);
        webView.loadData(content, "text/html; charset=UTF-8", null);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.toString());
                return false;
            }
        });
    }
}
