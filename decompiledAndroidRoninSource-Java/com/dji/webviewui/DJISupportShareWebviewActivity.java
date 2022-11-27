package com.dji.webviewui;

import android.app.Activity;
import android.view.KeyEvent;

public class DJISupportShareWebviewActivity
  extends Activity
{
  public static final String KEY_FORCE_LANDSCAP = "key_force_landscap";
  public boolean FORCE_LANDSCAPE = false;
  String cSn;
  String gSn;
  private boolean isNeedRotateTip = true;
  private boolean isWebViewSupportGeo = false;
  private boolean mBannerAds = false;
  private boolean mEnterFromExplore = false;
  private boolean mIs2015Page = false;
  private boolean mIsNeedReturntoMainPage = false;
  private boolean mIsNeedTitle = true;
  private boolean mIsWhatsnewFlightJournal = false;
  private String mLoadUrl = null;
  private String mLocalTitle = "";
  private boolean mNeedUploadFlightRecord = false;
  private String mPostData = null;
  private boolean mSetDJIUserAgent = false;
  private boolean mUseAppLanguage = false;
  protected DJIWebviewFragment mWebviewFragment = null;
  
  /* Error */
  private void checkBackToMain()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void getIntentData()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void finish()
  {
    checkBackToMain();
    super.finish();
  }
  
  /* Error */
  protected void onCreate(android.os.Bundle arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  protected void onPause()
  {
    super.onPause();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\webviewui\DJISupportShareWebviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */