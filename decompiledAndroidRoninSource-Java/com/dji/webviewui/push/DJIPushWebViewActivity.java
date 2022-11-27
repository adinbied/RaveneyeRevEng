package com.dji.webviewui.push;

import android.os.Bundle;
import com.dji.webviewui.DJIRoninBaseWebViewActivity;

public class DJIPushWebViewActivity
  extends DJIRoninBaseWebViewActivity<PushWebViewModel>
{
  private static final String KEY_INTENT_DATA_URL = "url";
  
  public String getLoadUrl()
  {
    return null;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\webviewui\push\DJIPushWebViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */