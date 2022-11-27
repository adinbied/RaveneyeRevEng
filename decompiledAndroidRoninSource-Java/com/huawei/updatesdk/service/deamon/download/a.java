package com.huawei.updatesdk.service.deamon.download;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.updatesdk.sdk.service.download.bean.DownloadTask;
import com.huawei.updatesdk.support.d.c;

public final class a
{
  public static final String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.huawei.updatesdk.support.a.a.a());
    localStringBuilder.append(".service.downloadservice.Receiver");
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext, DownloadTask paramDownloadTask, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent();
    String str = a();
    paramContext = str;
    if (paramDownloadTask != null)
    {
      paramContext = new Bundle();
      Bundle localBundle = new Bundle();
      paramDownloadTask.b(localBundle);
      paramContext.putBundle("downloadtask.all", localBundle);
      paramContext.putInt("downloadtask.status", paramInt);
      localIntent.putExtras(paramContext);
      paramContext = str;
      if (paramInt == 2) {
        paramContext = b();
      }
    }
    paramDownloadTask = com.huawei.updatesdk.sdk.service.secure.a.a(localIntent);
    if (a().equals(paramContext))
    {
      c.a().a(paramDownloadTask);
      return;
    }
    c.a().b(paramDownloadTask);
  }
  
  public static final String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.huawei.updatesdk.support.a.a.a());
    localStringBuilder.append(".service.downloadservice.progress.Receiver");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\service\deamon\download\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */