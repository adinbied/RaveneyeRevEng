package com.dji.webviewui;

import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import com.dji.livedatabase.live.BaseViewModelActivtiy;

public abstract class DJIRoninBaseWebViewActivity<T extends ViewModel>
  extends BaseViewModelActivtiy
{
  private static final String APP_UA_PREFIX = "DJI-app-ronin-android-";
  private static final String TAG = "DJIRoninBaseWebViewActivity";
  private static final String URL_END_PDF = "pdf";
  private static final String URL_START_ALIPAY = "alipays://";
  private static final String URL_START_CMBPAY = "cmblife://pay?";
  private static final String URL_START_JDPAY = "openapp.jdmobile://";
  private static final String URL_START_WXPAY = "weixin://wap/pay?";
  private ImageView mBackBtn;
  private RelativeLayout mPageErrorLy;
  private ProgressBar mProgressBar;
  private TextView mReloadBtn;
  private ViewGroup mTitleLayout;
  private WebView mWebView;
  
  /* Error */
  private void initView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean isPaymentPage(String paramString)
  {
    return false;
  }
  
  public abstract String getLoadUrl();
  
  /* Error */
  public void onBackPressed()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onCreate(android.os.Bundle arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  /* Error */
  public void onWindowFocusChanged(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  protected class BuyMonitorWebChromeClient
    extends WebChromeClient
  {
    protected BuyMonitorWebChromeClient() {}
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      super.onProgressChanged(paramWebView, paramInt);
      if (DJIRoninBaseWebViewActivity.this.mProgressBar != null)
      {
        DJIRoninBaseWebViewActivity.this.mProgressBar.setProgress(paramInt);
        if (DJIRoninBaseWebViewActivity.this.mProgressBar.getProgress() != DJIRoninBaseWebViewActivity.this.mProgressBar.getMax())
        {
          DJIRoninBaseWebViewActivity.this.mProgressBar.setVisibility(0);
          return;
        }
        DJIRoninBaseWebViewActivity.this.mProgressBar.setVisibility(8);
      }
    }
  }
  
  protected class BuyMonitorWebviewClient
    extends WebViewClient
  {
    protected BuyMonitorWebviewClient() {}
    
    public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
    {
      super.onReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
      DJIRoninBaseWebViewActivity.this.mPageErrorLy.setVisibility(0);
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\webviewui\DJIRoninBaseWebViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */