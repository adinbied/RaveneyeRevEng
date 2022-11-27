package com.huawei.hms.support.api.push.a.c;

import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;

public class e
{
  public static void a(Context paramContext, Notification.Builder paramBuilder, int paramInt, Bitmap paramBitmap, com.huawei.hms.support.api.push.a.b.a parama)
  {
    if ((parama != null) && (parama.l() != null))
    {
      if (!TextUtils.isEmpty(parama.l()))
      {
        if (!parama.l().contains("##")) {
          return;
        }
        paramBuilder.setTicker(parama.l().replace("##", "，"));
        if (!com.huawei.hms.support.api.push.a.d.a.b())
        {
          paramBuilder.setContentText(parama.l().replace("##", "，"));
          return;
        }
        paramBuilder.setLargeIcon(paramBitmap);
        paramBuilder.setContentTitle(c.a(paramContext, parama));
        paramBitmap = new Notification.InboxStyle();
        String[] arrayOfString = parama.l().split("##");
        int j = arrayOfString.length;
        int i = j;
        if (j > 4) {
          i = 4;
        }
        j = i;
        if (!TextUtils.isEmpty(parama.x()))
        {
          paramBitmap.setBigContentTitle(parama.x());
          paramBuilder.setContentText(parama.x());
          j = i;
          if (4 == i) {
            j = i - 1;
          }
        }
        i = 0;
        while (i < j)
        {
          paramBitmap.addLine(arrayOfString[i]);
          i += 1;
        }
        if ((parama.v() != null) && (parama.v().length > 0))
        {
          j = parama.v().length;
          i = 0;
          while (i < j)
          {
            if ((!TextUtils.isEmpty(parama.v()[i])) && (!TextUtils.isEmpty(parama.w()[i]))) {
              paramBuilder.addAction(0, parama.v()[i], c.a(paramContext, paramInt, parama.w()[i]));
            }
            i += 1;
          }
        }
        paramBuilder.setStyle(paramBitmap);
      }
      return;
    }
    com.huawei.hms.support.log.a.b("PushSelfShowLog", "msg is null");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\a\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */