package com.huawei.hms.support.api.push.a.c;

import android.app.Notification.Builder;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.huawei.hms.support.api.push.a.d.b;

public class f
{
  public static Notification.Builder a(Context paramContext, Notification.Builder paramBuilder, int paramInt, com.huawei.hms.support.api.push.a.b.a parama, Bitmap paramBitmap)
  {
    com.huawei.hms.support.log.a.a("PushSelfShowLog", "Notification addStyle");
    if ((paramContext != null) && (paramBuilder != null))
    {
      if (parama == null) {
        return paramBuilder;
      }
      a locala2 = a.b;
      a locala1 = locala2;
      if (parama.u() >= 0)
      {
        locala1 = locala2;
        if (parama.u() < a.values().length) {
          locala1 = a.values()[parama.u()];
        }
      }
      int i = g.a[locala1.ordinal()];
      if (i != 1)
      {
        if (i != 2) {
          return paramBuilder;
        }
        e.a(paramContext, paramBuilder, paramInt, paramBitmap, parama);
        return paramBuilder;
      }
      paramBuilder.setContent(a(paramContext, paramInt, paramBitmap, parama));
    }
    return paramBuilder;
  }
  
  private static RemoteViews a(Context paramContext, int paramInt, Bitmap paramBitmap, com.huawei.hms.support.api.push.a.b.a parama)
  {
    RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), b.a(paramContext, "hwpush_layout2"));
    c.a(paramContext, paramBitmap, localRemoteViews);
    c.a(paramContext, paramInt, localRemoteViews, parama);
    localRemoteViews.setTextViewText(b.b(paramContext, "title"), c.a(paramContext, parama));
    localRemoteViews.setTextViewText(b.b(paramContext, "text"), parama.l());
    return localRemoteViews;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\a\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */