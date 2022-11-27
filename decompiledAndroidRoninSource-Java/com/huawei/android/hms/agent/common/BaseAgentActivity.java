package com.huawei.android.hms.agent.common;

import android.app.Activity;
import android.os.Bundle;

public class BaseAgentActivity
  extends Activity
{
  public static final String EXTRA_IS_FULLSCREEN = "should_be_fullscreen";
  
  /* Error */
  private void requestActivityTransparent()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestActivityTransparent();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\android\hms\agent\common\BaseAgentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */