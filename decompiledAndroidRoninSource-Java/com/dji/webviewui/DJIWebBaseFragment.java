package com.dji.webviewui;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import dji.publics.DJIUI.DJIImageView;
import dji.publics.DJIUI.DJIRelativeLayout;
import dji.publics.DJIUI.DJIStateTextView;

public abstract class DJIWebBaseFragment
  extends Fragment
{
  public static final String CUSTOM_DJI_USER_AGENT = "DJI-App-pilot";
  public static final String DPAD_CUSTOM_DJI_USER_AGENT = "DJI-App-pilot-pad-dpad";
  public static final int FILE_CHOOSER_REQUEST_CODE = 1;
  public static final String JS_INTERFACE_NAME = "ibg_js_manager";
  public static final String PAD_CUSTOM_DJI_USER_AGENT = "DJI-App-pilot-pad";
  public static final String USE_APP_LANGUAGE = "use_app_language";
  private final int PAD_TITLE_LENGTH = 30;
  private final int PHONE_TITLE_LENGTH = 18;
  protected ValueCallback<Uri[]> mChooseFileValueCallback;
  protected View mCustomView;
  protected WebChromeClient.CustomViewCallback mCustomViewCallback;
  protected ViewGroup mCustomViewContainer;
  protected View mFullScreenHeader;
  protected fullScreenListener mFullScreenListener;
  private String mHostUrl = null;
  protected View mIvFullScreenBack;
  private HTTP_REQUEST_TYPE mLoadType = HTTP_REQUEST_TYPE.HTTP_GET;
  private int mMaxTitleLength = 18;
  protected OnSetActivityTitleListener mOnSetActivityTitleListener = null;
  protected int mOriginalOrientation;
  protected int mOriginalSystemUiVisibility;
  protected DJIRelativeLayout mPageErrorLy;
  protected String mPageErrorTitle = null;
  protected ProgressBar mPgbLoading = null;
  private String mPostData = null;
  protected DJIStateTextView mReloadBtn;
  protected View mRootView = null;
  protected DJIImageView mRoundPgb;
  protected boolean mSetDJIUserAgent = false;
  protected boolean mUseAppLanguage = false;
  protected DJIBaseWebChromeClient mWebChromeClient;
  protected WebView mWebView = null;
  
  /* Error */
  private void convertRequestUrlForLogin()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void destroyWebView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private void hideRoundPgb()
  {
    this.mRoundPgb.go();
  }
  
  /* Error */
  private void loadPage()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void loadPageByLoginAuthUrl()
  {
    setCookie(false);
    loadPage();
  }
  
  private void loadPageByOldWay()
  {
    setCookie(true);
    loadPage();
  }
  
  /* Error */
  private void loadWebPage()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void pauseWebTimers()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void pauseWebView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void resumeWebTimers()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void resumeWebView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void setCookie(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setTitle(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void showRoundPgb()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void showSystemUI()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected abstract View createView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle);
  
  public void exitFullScreen()
  {
    this.mWebChromeClient.onHideCustomView();
  }
  
  public boolean goBack()
  {
    return false;
  }
  
  /* Error */
  public void hideErrorLy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void hideSystemUI()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void initWebView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected abstract void injectWebBaseView(View paramView);
  
  public boolean isFullScreenVideo()
  {
    return this.mCustomView != null;
  }
  
  public void loadUrl(String paramString)
  {
    this.mHostUrl = paramString;
    this.mLoadType = HTTP_REQUEST_TYPE.HTTP_GET;
    loadWebPage();
  }
  
  /* Error */
  public void onActivityResult(int arg1, int arg2, Intent arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return null;
  }
  
  public void onDestroy()
  {
    destroyWebView();
    super.onDestroy();
  }
  
  public void onPause()
  {
    pauseWebView();
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    resumeWebView();
    resumeWebTimers();
  }
  
  @Deprecated
  public void postUrl(String paramString1, String paramString2)
  {
    this.mHostUrl = paramString1;
    this.mPostData = paramString2;
    this.mLoadType = HTTP_REQUEST_TYPE.HTTP_POST;
    loadWebPage();
  }
  
  public void setFullScreenListener(fullScreenListener paramfullScreenListener)
  {
    this.mFullScreenListener = paramfullScreenListener;
  }
  
  public void setOnSetActivityTitleListener(OnSetActivityTitleListener paramOnSetActivityTitleListener)
  {
    this.mOnSetActivityTitleListener = paramOnSetActivityTitleListener;
  }
  
  protected class DJIBaseWebChromeClient
    extends WebChromeClient
  {
    public static final int TOGGLE = 1;
    Handler.Callback mFullScreenHeaderCallback = new Handler.Callback()
    {
      boolean mHeaderIsShowing = true;
      
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        return false;
      }
    };
    protected Handler mHeaderHandler;
    
    protected DJIBaseWebChromeClient() {}
    
    /* Error */
    public void onHideCustomView()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      super.onProgressChanged(paramWebView, paramInt);
      if (DJIWebBaseFragment.this.mPgbLoading != null) {
        DJIWebBaseFragment.this.mPgbLoading.setProgress(paramInt);
      }
    }
    
    /* Error */
    public void onReceivedTitle(WebView arg1, String arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onShowCustomView(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      onShowCustomView(paramView, paramCustomViewCallback);
    }
    
    /* Error */
    public void onShowCustomView(View arg1, WebChromeClient.CustomViewCallback arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean onShowFileChooser(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
    {
      DJIWebBaseFragment.this.mChooseFileValueCallback = paramValueCallback;
      paramWebView = new Intent("android.intent.action.GET_CONTENT");
      paramWebView.addCategory("android.intent.category.OPENABLE");
      paramWebView.setType("image/*");
      paramValueCallback = DJIWebBaseFragment.this;
      paramValueCallback.startActivityForResult(Intent.createChooser(paramWebView, paramValueCallback.getString(R.string.webview_library_select_item)), 1);
      return true;
    }
  }
  
  protected class DJIBaseWebViewClient
    extends WebViewClient
  {
    private String startUrl;
    
    protected DJIBaseWebViewClient() {}
    
    /* Error */
    public void onPageFinished(WebView arg1, String arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      if (DJIWebBaseFragment.this.mPgbLoading != null) {
        DJIWebBaseFragment.this.mPgbLoading.setVisibility(8);
      }
      this.startUrl = paramString;
    }
    
    /* Error */
    public void onReceivedError(WebView arg1, WebResourceRequest arg2, android.webkit.WebResourceError arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onReceivedSslError(WebView arg1, android.webkit.SslErrorHandler arg2, android.net.http.SslError arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      return false;
    }
  }
  
  protected class DJIWebviewDownloadListener
    implements DownloadListener
  {
    protected DJIWebviewDownloadListener() {}
    
    public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
    {
      try
      {
        paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
        DJIWebBaseFragment.this.startActivity(paramString1);
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public static enum HTTP_REQUEST_TYPE
  {
    static
    {
      HTTP_REQUEST_TYPE localHTTP_REQUEST_TYPE = new HTTP_REQUEST_TYPE("HTTP_POST", 1);
      HTTP_POST = localHTTP_REQUEST_TYPE;
      $VALUES = new HTTP_REQUEST_TYPE[] { HTTP_GET, localHTTP_REQUEST_TYPE };
    }
    
    private HTTP_REQUEST_TYPE() {}
  }
  
  public static abstract interface OnSetActivityTitleListener
  {
    public abstract void setActivityTitle(String paramString);
  }
  
  public static abstract interface fullScreenListener
  {
    public abstract void onFullScreen(boolean paramBoolean);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\webviewui\DJIWebBaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */