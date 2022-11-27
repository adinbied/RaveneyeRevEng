package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.Window;
import com.huawei.hms.c.j;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BridgeActivity
  extends Activity
{
  public static final String EXTRA_DELEGATE_CLASS_NAME = "intent.extra.DELEGATE_CLASS_OBJECT";
  public static final String EXTRA_DELEGATE_UPDATE_INFO = "intent.extra.update.info";
  public static final String EXTRA_INTENT = "intent.extra.intent";
  public static final String EXTRA_IS_FULLSCREEN = "intent.extra.isfullscreen";
  public static final String EXTRA_RESULT = "intent.extra.RESULT";
  private a a;
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static void a(Window paramWindow, boolean paramBoolean)
  {
    try
    {
      paramWindow.getClass().getMethod("setHwFloating", new Class[] { Boolean.TYPE }).invoke(paramWindow, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (InvocationTargetException paramWindow) {}catch (IllegalArgumentException paramWindow) {}catch (IllegalAccessException paramWindow) {}catch (NoSuchMethodException paramWindow) {}
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("In setHwFloating, Failed to call Window.setHwFloating().");
    localStringBuilder.append(paramWindow.getMessage());
    com.huawei.hms.support.log.a.d("BridgeActivity", localStringBuilder.toString());
  }
  
  private boolean b()
  {
    return false;
  }
  
  public static Intent getIntentStartBridgeActivity(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, BridgeActivity.class);
    localIntent.putExtra("intent.extra.DELEGATE_CLASS_OBJECT", paramString);
    localIntent.putExtra("intent.extra.isfullscreen", j.a(paramActivity));
    return localIntent;
  }
  
  /* Error */
  public void finish()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onActivityResult(int arg1, int arg2, Intent arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = this.a;
    if (paramConfiguration != null) {
      paramConfiguration.onBridgeConfigurationChanged();
    }
  }
  
  /* Error */
  protected void onCreate(android.os.Bundle arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onDestroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\activity\BridgeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */