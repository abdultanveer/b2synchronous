package com.example.b2synchronous.webvu;

import android.content.Context;
import android.content.Intent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.b2synchronous.MainActivity;

public class MyWebViewClient extends WebViewClient {
     Context mContext;
     public MyWebViewClient(Context context) {
         mContext = context;
     }


     @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        if ("www.example.com".equals(request.getUrl().getHost())) {
      // This is my website, so do not override; let my WebView load the page
      return false;
    }
    // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
    Intent intent = new Intent(mContext, MainActivity.class);
    mContext.startActivity(intent);
    return true;
  }
}