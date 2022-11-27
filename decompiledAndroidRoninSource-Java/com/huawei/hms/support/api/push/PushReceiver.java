package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public abstract class PushReceiver
  extends BroadcastReceiver
{
  /* Error */
  private void a(Context arg1, Intent arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void a(Context arg1, Intent arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void b(Context arg1, Intent arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void c(Context arg1, Intent arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static void d(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.hasExtra("selfshow_info"))
    {
      if (!com.huawei.hms.support.api.push.b.a.a.a(paramContext))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramContext.getPackageName());
        localStringBuilder.append(" disable display notification.");
        com.huawei.hms.support.log.a.b("PushReceiver", localStringBuilder.toString());
      }
      new com.huawei.hms.support.api.push.a.a().a(paramContext, paramIntent);
    }
  }
  
  public void onEvent(Context paramContext, Event paramEvent, Bundle paramBundle) {}
  
  public void onPushMsg(Context paramContext, byte[] paramArrayOfByte, String paramString) {}
  
  public boolean onPushMsg(Context paramContext, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    return false;
  }
  
  public void onPushState(Context paramContext, boolean paramBoolean) {}
  
  /* Error */
  public final void onReceive(Context arg1, Intent arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void onToken(Context paramContext, String paramString) {}
  
  public void onToken(Context paramContext, String paramString, Bundle paramBundle)
  {
    onToken(paramContext, paramString);
  }
  
  public static abstract interface BOUND_KEY
  {
    public static final String deviceTokenKey = "deviceToken";
    public static final String pushMsgKey = "pushMsg";
    public static final String pushNotifyId = "pushNotifyId";
  }
  
  public static enum Event
  {
    static
    {
      Event localEvent = new Event("NOTIFICATION_CLICK_BTN", 1);
      NOTIFICATION_CLICK_BTN = localEvent;
      a = new Event[] { NOTIFICATION_OPENED, localEvent };
    }
    
    private Event() {}
  }
  
  private class a
    implements Runnable
  {
    private Context b;
    private Intent c;
    
    private a(Context paramContext, Intent paramIntent)
    {
      this.b = paramContext;
      this.c = paramIntent;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  private class b
    implements Runnable
  {
    private Context b;
    private Intent c;
    
    private b(Context paramContext, Intent paramIntent)
    {
      this.b = paramContext;
      this.c = paramIntent;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  private class c
    implements Runnable
  {
    private Context b;
    private Intent c;
    
    private c(Context paramContext, Intent paramIntent)
    {
      this.b = paramContext;
      this.c = paramIntent;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  private class d
    implements Runnable
  {
    private Context b;
    private Intent c;
    
    private d(Context paramContext, Intent paramIntent)
    {
      this.b = paramContext;
      this.c = paramIntent;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  private class e
    implements Runnable
  {
    private Context b;
    private Intent c;
    
    private e(Context paramContext, Intent paramIntent)
    {
      this.b = paramContext;
      this.c = paramIntent;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\PushReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */