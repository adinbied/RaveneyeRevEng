package com.huawei.hms.support.api.push.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;

public class HmsMsgService
  extends Service
{
  private static void c(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.huawei.android.push.intent.RECEIVE");
    localIntent.putExtra("msg_data", paramBundle.getByteArray("msg_data"));
    localIntent.putExtra("device_token", paramBundle.getByteArray("device_token"));
    localIntent.putExtra("msgIdStr", paramBundle.getString("msgIdStr"));
    localIntent.setFlags(32);
    localIntent.setPackage(paramBundle.getString("push_package"));
    paramBundle = new StringBuilder();
    paramBundle.append(paramContext.getPackageName());
    paramBundle.append(".permission.PROCESS_PUSH_MSG");
    paramContext.sendBroadcast(localIntent, paramBundle.toString());
    com.huawei.hms.support.log.a.b("HmsMsgService", "send broadcast passby done");
  }
  
  private static void d(Context paramContext, Bundle paramBundle)
  {
    if (!com.huawei.hms.support.api.push.b.a.a.a(paramContext))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext.getPackageName());
      ((StringBuilder)localObject).append(" disable display notification.");
      com.huawei.hms.support.log.a.b("HmsMsgService", ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("com.huawei.push.msg.NOTIFY_MSG");
    ((Intent)localObject).putExtra("selfshow_info", paramBundle.getByteArray("selfshow_info"));
    ((Intent)localObject).putExtra("selfshow_token", paramBundle.getByteArray("selfshow_token"));
    ((Intent)localObject).setPackage(paramBundle.getString("push_package"));
    new com.huawei.hms.support.api.push.a.a().a(paramContext, (Intent)localObject);
    com.huawei.hms.support.log.a.b("HmsMsgService", "invokeSelfShow done");
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    com.huawei.hms.support.log.a.b("HmsMsgService", "Enter onStartCommand.");
    return 2;
  }
  
  private static class a
    extends Handler
  {
    private Context a;
    
    a(Context paramContext)
    {
      this.a = paramContext;
    }
    
    /* Error */
    public void handleMessage(android.os.Message arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\service\HmsMsgService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */