package com.dji.webviewui;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;

public class DJIWebviewFragment
  extends DJIWebBaseFragment
{
  public static String KEY_DJICARE_CSN = "DJIWevviewFragment_DJICARE_CSN";
  public static String KEY_DJICARE_GSN = "DJIWevviewFragment_DJICARE_GSN";
  public static String KEY_IS_2015_PAGE = "DJIWevviewFragment_Is2015Page";
  public static String KEY_IS_BANNER_ADS = "DJIWebviewFragment_IsBannerAds";
  public static String KEY_IS_ENTER_FROM_EXPLORE = "DJIWebviewFragment_IsEnterFromExplore";
  public static final String KEY_IS_NEED_ROTATE_TIP = "DJIWebviewFragment_is_need_rotate_tip";
  public static String KEY_IS_NEED_TITLE = "DJIWevviewFragment_IsNeedTitle";
  public static String KEY_IS_WEBVIEW_SUPPORT_GEO = "DJIWebviewFragment_IssWebViewSupportGeo";
  public static String KEY_IS_WHATSNEWFLIGHTJOURNAL = "DJIWebviewFragment_IsWhatsnewFlightJournal";
  public static final String KEY_LOCAL_TITLE = "DJIWebviewFragment_local_title";
  public static String KEY_NEED_RETURN_MAIN_PAGE = "key_need_return_main_page";
  public static String KEY_NEED_UPLOADFLIGHTRECORD = "DJIWebviewFragment_NeedUpload";
  public static String KEY_POST_DATA = "DJIWebviewFragment_PostData";
  @Deprecated
  public static String KEY_SET_DJI_USER_AGENT = "DJIWebviewFragment_SetDJIUserAgent";
  public static String KEY_SHARE_BRIDGE = "DJIWebviewFragment_ShareBridge";
  public static String KEY_URL = "DJIWebviewFragment_Url";
  String cSn;
  String gSn;
  protected boolean isNeedRotateTip = true;
  protected boolean isWebViewSupportGeo = false;
  protected boolean mBannerAds = false;
  protected boolean mEnterFromExplore = false;
  protected boolean mIs2015Page = false;
  protected boolean mIsNeedTitle = true;
  protected boolean mIsWhatsnewFlightJournal = false;
  protected WebBaseJsHandler mJsHandler = null;
  protected String mLocalTitle = "";
  protected boolean mNeedUploadFlightRecord = false;
  
  /* Error */
  private void careLog(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static DJIWebviewFragment newInstance(Bundle paramBundle)
  {
    DJIWebviewFragment localDJIWebviewFragment = new DJIWebviewFragment();
    localDJIWebviewFragment.setArguments(paramBundle);
    return localDJIWebviewFragment;
  }
  
  public static DJIWebviewFragment newInstance(String paramString)
  {
    DJIWebviewFragment localDJIWebviewFragment = new DJIWebviewFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString(KEY_URL, paramString);
    localDJIWebviewFragment.setArguments(localBundle);
    return localDJIWebviewFragment;
  }
  
  protected View createView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.v2_fragment_base_webview, null);
    getBundleArgs();
    return paramLayoutInflater;
  }
  
  /* Error */
  protected void getBundleArgs()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean hasLocalTitle()
  {
    return false;
  }
  
  /* Error */
  protected void initWebView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void injectWebBaseView(View arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  protected void onIsWhatsnewFlightJournal() {}
  
  private final class CommonWebViewClient
    extends DJIWebBaseFragment.DJIBaseWebViewClient
  {
    private CommonWebViewClient()
    {
      super();
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      return super.shouldOverrideUrlLoading(paramWebView, paramWebResourceRequest);
    }
  }
  
  protected class WebBaseJsHandler
  {
    public static final String AIRMAP_CALLBACK_URL = "djinfj://verifyCallBack#1";
    public static final String GET_LOGOUT_STATE_JS_FUNCTION_NAME = "getLogoutStateFromApp";
    public static final String SET_UP_AIRMAP_WITH_KEY = "var personal_info = {user_id: '%s'}; function callback(verified){if(verified){var url = 'djinfj://verifyCallBack#1'; window.location=url}};setup('%s', '%s', personal_info, callback);";
    protected String TAG = "JsHandler";
    protected Activity mActivity;
    protected WebView mJSWebView;
    protected String mLoginFailUrl = null;
    protected String mLoginSucceedUrl = null;
    
    public WebBaseJsHandler(Activity paramActivity, WebView paramWebView)
    {
      this.mActivity = paramActivity;
      this.mJSWebView = paramWebView;
    }
    
    /* Error */
    private void sendLogoutCmdToJS(boolean arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    @JavascriptInterface
    public void app_upload_photo(String paramString) {}
    
    @JavascriptInterface
    public String getCraftSn()
    {
      return null;
    }
    
    @JavascriptInterface
    public String getGimbalSn()
    {
      return null;
    }
    
    /* Error */
    @JavascriptInterface
    public void onCareCheckoutFinish(int arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    /* Error */
    @JavascriptInterface
    public void openInBrowser(String arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    @JavascriptInterface
    public void user_login(String paramString1, String paramString2)
    {
      this.mLoginSucceedUrl = paramString1;
      this.mLoginFailUrl = paramString2;
    }
    
    /* Error */
    @JavascriptInterface
    public void user_logout()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\webviewui\DJIWebviewFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */