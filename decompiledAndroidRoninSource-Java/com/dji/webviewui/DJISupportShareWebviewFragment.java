package com.dji.webviewui;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.constraintlayout.widget.ConstraintLayout;
import dji.publics.DJIUI.DJIStateImageView;
import dji.publics.DJIUI.DJITextView;

public class DJISupportShareWebviewFragment
  extends DJIWebviewFragment
{
  public static final String EXPLORE_TAG = "explore";
  private boolean isFirstLoad = true;
  private DJIStateImageView mBackBtn;
  private DJIStateImageView mCloseBtn;
  private boolean mIsSyncCompleted = false;
  private String mPostData;
  private View mRootView;
  private boolean mShareInfoInited = false;
  private boolean mSupportedSpecialShare = false;
  private ConstraintLayout mTitleLayout;
  private DJITextView mTitleTv;
  private String mWebUrl;
  
  /* Error */
  private void checkOrientation()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void handleCloseBtn()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void handleGoBack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void initListeners()
  {
    this.mOnSetActivityTitleListener = new DJIWebBaseFragment.OnSetActivityTitleListener()
    {
      /* Error */
      public void setActivityTitle(String arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    };
  }
  
  /* Error */
  private void initWidgets()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void injectView(View arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void loadUrl()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static DJISupportShareWebviewFragment newInstance(Bundle paramBundle)
  {
    DJISupportShareWebviewFragment localDJISupportShareWebviewFragment = new DJISupportShareWebviewFragment();
    localDJISupportShareWebviewFragment.setArguments(paramBundle);
    return localDJISupportShareWebviewFragment;
  }
  
  public static DJISupportShareWebviewFragment newInstance(String paramString)
  {
    DJISupportShareWebviewFragment localDJISupportShareWebviewFragment = new DJISupportShareWebviewFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString(DJIWebviewFragment.KEY_URL, paramString);
    localDJISupportShareWebviewFragment.setArguments(localBundle);
    return localDJISupportShareWebviewFragment;
  }
  
  private String trimDoubleQuotes(String paramString)
  {
    return null;
  }
  
  protected View createView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.v2_main_explore_fragment, null);
    getBundleArgs();
    injectView(paramLayoutInflater);
    initListeners();
    initWidgets();
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
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  /* Error */
  protected void onIsWhatsnewFlightJournal()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private class SecExploreWebChromeClient
    extends DJIWebBaseFragment.DJIBaseWebChromeClient
  {
    private SecExploreWebChromeClient()
    {
      super();
    }
    
    /* Error */
    public void onGeolocationPermissionsShowPrompt(String arg1, android.webkit.GeolocationPermissions.Callback arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onReceivedTitle(WebView arg1, String arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  private final class SecExploreWebViewClient
    extends DJIWebBaseFragment.DJIBaseWebViewClient
  {
    private SecExploreWebViewClient()
    {
      super();
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      DJISupportShareWebviewFragment.this.handleCloseBtn();
      if (DJISupportShareWebviewFragment.this.isFirstLoad) {
        DJISupportShareWebviewFragment.this.checkOrientation();
      }
      DJISupportShareWebviewFragment.access$602(DJISupportShareWebviewFragment.this, false);
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      DJISupportShareWebviewFragment.access$502(DJISupportShareWebviewFragment.this, false);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\webviewui\DJISupportShareWebviewFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */