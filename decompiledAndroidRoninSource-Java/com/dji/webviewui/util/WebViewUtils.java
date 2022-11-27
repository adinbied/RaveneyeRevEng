package com.dji.webviewui.util;

import android.os.Build.VERSION;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;

public final class WebViewUtils
{
  public static void setupWebView(WebView paramWebView)
  {
    if (paramWebView == null) {
      return;
    }
    paramWebView.getSettings().setDomStorageEnabled(true);
    paramWebView.getSettings().setSupportZoom(true);
    paramWebView.getSettings().setBuiltInZoomControls(true);
    paramWebView.getSettings().setDisplayZoomControls(false);
    paramWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
    paramWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
    paramWebView.getSettings().setAllowFileAccess(false);
    paramWebView.getSettings().setAllowFileAccessFromFileURLs(false);
    paramWebView.getSettings().setAllowUniversalAccessFromFileURLs(false);
    paramWebView.getSettings().setUseWideViewPort(true);
    paramWebView.getSettings().setLoadWithOverviewMode(true);
    paramWebView.getSettings().setSupportMultipleWindows(false);
    paramWebView.getSettings().setCacheMode(-1);
    if (Build.VERSION.SDK_INT >= 21) {
      paramWebView.getSettings().setMixedContentMode(0);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\webviewu\\util\WebViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */