package com.huawei.hms.support.api.push.a.c;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.huawei.hms.support.api.push.a.d.b;
import java.security.SecureRandom;
import java.util.Date;

public class c
{
  public static PendingIntent a(Context paramContext, int paramInt, String paramString)
  {
    Intent localIntent = new Intent("com.huawei.android.push.intent.CLICK").setPackage(paramContext.getPackageName()).setFlags(32);
    localIntent.putExtra("notifyId", paramInt);
    localIntent.putExtra("clickBtn", paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getPackageName());
    localStringBuilder.append(paramString);
    localStringBuilder.append(new SecureRandom().nextInt());
    localStringBuilder.append(new Date().toString());
    paramInt = localStringBuilder.toString().hashCode();
    paramString = new StringBuilder();
    paramString.append("getPendingIntent,requestCode:");
    paramString.append(paramInt);
    com.huawei.hms.support.log.a.a("PushSelfShowLog", paramString.toString());
    return PendingIntent.getBroadcast(paramContext, paramInt, localIntent, 134217728);
  }
  
  public static String a(Context paramContext, com.huawei.hms.support.api.push.a.b.a parama)
  {
    if ((paramContext != null) && (parama != null))
    {
      if (!TextUtils.isEmpty(parama.n())) {
        return parama.n();
      }
      int i = paramContext.getApplicationInfo().labelRes;
      return paramContext.getResources().getString(i);
    }
    return "";
  }
  
  public static void a(Context paramContext, int paramInt, RemoteViews paramRemoteViews, com.huawei.hms.support.api.push.a.b.a parama)
  {
    if ((paramContext != null) && (paramRemoteViews != null) && (parama != null))
    {
      if (((a.c.ordinal() == parama.u()) || (a.d.ordinal() == parama.u()) || (a.e.ordinal() == parama.u())) && (!TextUtils.isEmpty(parama.v()[0])) && (!TextUtils.isEmpty(parama.w()[0])))
      {
        int i = b.a(paramContext, "id", "right_btn");
        paramRemoteViews.setViewVisibility(i, 0);
        paramRemoteViews.setTextViewText(i, parama.v()[0]);
        paramRemoteViews.setOnClickPendingIntent(i, a(paramContext, paramInt, parama.w()[0]));
      }
      return;
    }
    com.huawei.hms.support.log.a.c("PushSelfShowLog", "showRightBtn error");
  }
  
  public static void a(Context paramContext, Bitmap paramBitmap, RemoteViews paramRemoteViews)
  {
    if (paramContext != null)
    {
      if (paramRemoteViews == null) {
        return;
      }
      if (!com.huawei.hms.support.api.push.a.d.a.a()) {
        return;
      }
      if (paramBitmap == null)
      {
        int j = paramContext.getApplicationInfo().icon;
        int i = j;
        if (j == 0)
        {
          j = paramContext.getResources().getIdentifier("btn_star_big_on", "drawable", "android");
          i = j;
          if (j == 0) {
            i = 17301651;
          }
        }
        paramRemoteViews.setImageViewResource(b.a(paramContext, "id", "icon"), i);
        return;
      }
      paramRemoteViews.setImageViewBitmap(b.a(paramContext, "id", "icon"), paramBitmap);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\a\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */