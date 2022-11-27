package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;

public class dh
{
  public static int a(Context paramContext, int paramInt)
  {
    int i = gz.a(paramContext);
    if (-1 == i) {
      return -1;
    }
    if (i == 0) {
      i = 13;
    } else {
      i = 11;
    }
    return paramInt * i / 10;
  }
  
  public static int a(ho paramho)
  {
    return fc.a(paramho.a());
  }
  
  public static int a(iz paramiz, ho paramho)
  {
    int j;
    switch (di.a[paramho.ordinal()])
    {
    default: 
      return -1;
    case 12: 
      j = fc.a(paramho.a());
      i = j;
      if (paramiz == null) {
        break;
      }
    }
    try
    {
      if ((paramiz instanceof ij))
      {
        paramiz = ((ij)paramiz).a();
        i = j;
        if (TextUtils.isEmpty(paramiz)) {
          break label180;
        }
        i = j;
        if (fi.a(paramiz) == -1) {
          break label180;
        }
        i = fi.a(paramiz);
        break label180;
      }
      i = j;
      if (!(paramiz instanceof ii)) {
        break label180;
      }
      paramiz = ((ii)paramiz).a();
      i = j;
      if (TextUtils.isEmpty(paramiz)) {
        break label180;
      }
      i = j;
      if (fi.a(paramiz) == -1) {
        break label180;
      }
      i = fi.a(paramiz);
      return i;
    }
    catch (Exception paramiz)
    {
      for (;;) {}
    }
    b.d("PERF_ERROR : parse Command type error");
    int i = j;
    for (;;)
    {
      label180:
      return i;
      j = fc.a(paramho.a());
      i = j;
      int k;
      if (paramiz != null) {
        k = j;
      }
      try
      {
        if ((paramiz instanceof if))
        {
          k = j;
          paramiz = ((if)paramiz).d;
          i = j;
          k = j;
          if (!TextUtils.isEmpty(paramiz))
          {
            i = j;
            k = j;
            if (fc.a(fc.a(paramiz)) != -1)
            {
              k = j;
              i = fc.a(fc.a(paramiz));
            }
          }
        }
        else
        {
          i = j;
          k = j;
          if ((paramiz instanceof in))
          {
            k = j;
            paramiz = ((in)paramiz).d;
            i = j;
            k = j;
            if (!TextUtils.isEmpty(paramiz))
            {
              i = j;
              k = j;
              if (fc.a(fc.a(paramiz)) != -1)
              {
                k = j;
                i = fc.a(fc.a(paramiz));
              }
              k = i;
              boolean bool = hy.B.equals(fc.a(paramiz));
              if (bool) {
                return -1;
              }
            }
          }
        }
      }
      catch (Exception paramiz)
      {
        for (;;) {}
      }
    }
    b.d("PERF_ERROR : parse Notification type error");
    return k;
    return fc.a(paramho.a());
  }
  
  public static void a(String paramString, Context paramContext, int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      paramInt2 = a(paramContext, paramInt2);
      if (paramInt1 != fc.a(hy.B)) {
        fd.a(paramContext.getApplicationContext()).a(paramString, paramInt1, 1L, paramInt2);
      }
    }
  }
  
  public static void a(String paramString, Context paramContext, ik paramik, int paramInt)
  {
    if (paramContext != null)
    {
      if (paramik == null) {
        return;
      }
      ho localho = paramik.a();
      if (localho != null)
      {
        int j = a(localho);
        int i = paramInt;
        if (paramInt <= 0)
        {
          paramik = iy.a(paramik);
          if (paramik != null) {
            i = paramik.length;
          } else {
            i = 0;
          }
        }
        a(paramString, paramContext, j, i);
      }
    }
  }
  
  public static void a(String paramString, Context paramContext, iz paramiz, ho paramho, int paramInt)
  {
    a(paramString, paramContext, a(paramiz, paramho), paramInt);
  }
  
  public static void a(String paramString, Context paramContext, byte[] paramArrayOfByte)
  {
    ik localik;
    if ((paramContext != null) && (paramArrayOfByte != null))
    {
      if (paramArrayOfByte.length <= 0) {
        return;
      }
      localik = new ik();
    }
    try
    {
      iy.a(localik, paramArrayOfByte);
      a(paramString, paramContext, localik, paramArrayOfByte.length);
      return;
    }
    catch (je paramString)
    {
      for (;;) {}
    }
    b.a("fail to convert bytes to container");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */