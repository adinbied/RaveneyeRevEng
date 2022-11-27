package com.huawei.hms.support.api.push.a.c;

import android.R.drawable;
import android.app.Notification.Builder;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import java.lang.reflect.Field;

public class b
{
  public static int a(Context paramContext, com.huawei.hms.support.api.push.a.b.a parama)
  {
    if ((paramContext != null) && (parama != null))
    {
      int j = paramContext.getApplicationInfo().icon;
      int i = j;
      if (j == 0)
      {
        j = paramContext.getResources().getIdentifier("btn_star_big_on", "drawable", "android");
        com.huawei.hms.support.log.a.a("PushSelfShowLog", "icon is btn_star_big_on ");
        i = j;
        if (j == 0)
        {
          i = 17301651;
          com.huawei.hms.support.log.a.a("PushSelfShowLog", "icon is sym_def_app_icon ");
        }
      }
      return i;
    }
    com.huawei.hms.support.log.a.b("PushSelfShowLog", "enter getSmallIconId, context or msg is null");
    return 0;
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2, Object paramObject)
  {
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    int i2 = 0;
    int j = i2;
    int k = i3;
    int m = i4;
    int n = i5;
    int i1 = i6;
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = new StringBuilder();
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        ((StringBuilder)localObject1).append(paramContext.getPackageName());
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        ((StringBuilder)localObject1).append(".R");
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        String str1 = ((StringBuilder)localObject1).toString();
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        localObject1 = new StringBuilder();
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        ((StringBuilder)localObject1).append("try to refrect ");
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        ((StringBuilder)localObject1).append(str1);
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        ((StringBuilder)localObject1).append(" typeName is ");
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        ((StringBuilder)localObject1).append(paramString2);
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        com.huawei.hms.support.log.a.a("PushSelfShowLog", ((StringBuilder)localObject1).toString());
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        Class[] arrayOfClass = Class.forName(str1).getClasses();
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        localObject1 = new StringBuilder();
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        ((StringBuilder)localObject1).append("sonClassArr length ");
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        ((StringBuilder)localObject1).append(arrayOfClass.length);
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        com.huawei.hms.support.log.a.a("PushSelfShowLog", ((StringBuilder)localObject1).toString());
        Object localObject2 = null;
        i = 0;
        localObject1 = localObject2;
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        if (i < arrayOfClass.length)
        {
          localObject1 = arrayOfClass[i];
          j = i2;
          k = i3;
          m = i4;
          n = i5;
          i1 = i6;
          String str2 = ((Class)localObject1).getName().substring(str1.length() + 1);
          j = i2;
          k = i3;
          m = i4;
          n = i5;
          i1 = i6;
          StringBuilder localStringBuilder = new StringBuilder();
          j = i2;
          k = i3;
          m = i4;
          n = i5;
          i1 = i6;
          localStringBuilder.append("sonTypeClass,query sonclass is ");
          j = i2;
          k = i3;
          m = i4;
          n = i5;
          i1 = i6;
          localStringBuilder.append(str2);
          j = i2;
          k = i3;
          m = i4;
          n = i5;
          i1 = i6;
          localStringBuilder.append(" sonClass.getName() is");
          j = i2;
          k = i3;
          m = i4;
          n = i5;
          i1 = i6;
          localStringBuilder.append(((Class)localObject1).getName());
          j = i2;
          k = i3;
          m = i4;
          n = i5;
          i1 = i6;
          com.huawei.hms.support.log.a.a("PushSelfShowLog", localStringBuilder.toString());
          j = i2;
          k = i3;
          m = i4;
          n = i5;
          i1 = i6;
          if (!paramString2.equals(str2)) {
            break label1428;
          }
        }
        if (localObject1 != null)
        {
          j = i2;
          k = i3;
          m = i4;
          n = i5;
          i1 = i6;
          i = ((Class)localObject1).getField(paramString1).getInt(paramObject);
          j = i;
          k = i;
          m = i;
          n = i;
          i1 = i;
          paramContext = new StringBuilder();
          j = i;
          k = i;
          m = i;
          n = i;
          i1 = i;
          paramContext.append("refect res id is ");
          j = i;
          k = i;
          m = i;
          n = i;
          i1 = i;
          paramContext.append(i);
          j = i;
          k = i;
          m = i;
          n = i;
          i1 = i;
          com.huawei.hms.support.log.a.a("PushSelfShowLog", paramContext.toString());
          return i;
        }
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        com.huawei.hms.support.log.a.a("PushSelfShowLog", "sonTypeClass is null");
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        localObject1 = new StringBuilder();
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        ((StringBuilder)localObject1).append(paramContext.getPackageName());
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        ((StringBuilder)localObject1).append(".R$");
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        ((StringBuilder)localObject1).append(paramString2);
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        paramContext = ((StringBuilder)localObject1).toString();
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        localObject1 = new StringBuilder();
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        ((StringBuilder)localObject1).append("try to refrect 2 ");
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        ((StringBuilder)localObject1).append(paramContext);
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        ((StringBuilder)localObject1).append(" typeName is ");
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        ((StringBuilder)localObject1).append(paramString2);
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        com.huawei.hms.support.log.a.a("PushSelfShowLog", ((StringBuilder)localObject1).toString());
        j = i2;
        k = i3;
        m = i4;
        n = i5;
        i1 = i6;
        i = Class.forName(paramContext).getField(paramString1).getInt(paramObject);
        j = i;
        k = i;
        m = i;
        n = i;
        i1 = i;
        paramContext = new StringBuilder();
        j = i;
        k = i;
        m = i;
        n = i;
        i1 = i;
        paramContext.append(" refect res id 2 is ");
        j = i;
        k = i;
        m = i;
        n = i;
        i1 = i;
        paramContext.append(i);
        j = i;
        k = i;
        m = i;
        n = i;
        i1 = i;
        com.huawei.hms.support.log.a.a("PushSelfShowLog", paramContext.toString());
        return i;
      }
      catch (IndexOutOfBoundsException paramContext)
      {
        com.huawei.hms.support.log.a.a("PushSelfShowLog", "IndexOutOfBoundsException failed,", paramContext);
        return j;
      }
      catch (IllegalArgumentException paramContext)
      {
        com.huawei.hms.support.log.a.a("PushSelfShowLog", "IllegalArgumentException failed,", paramContext);
        return k;
      }
      catch (IllegalAccessException paramContext)
      {
        com.huawei.hms.support.log.a.a("PushSelfShowLog", "IllegalAccessException failed,", paramContext);
        return m;
      }
      catch (NoSuchFieldException paramContext)
      {
        com.huawei.hms.support.log.a.a("PushSelfShowLog", "NoSuchFieldException failed,", paramContext);
        return n;
      }
      catch (ClassNotFoundException paramContext)
      {
        com.huawei.hms.support.log.a.a("PushSelfShowLog", "ClassNotFound failed,", paramContext);
        return i1;
      }
      label1428:
      i += 1;
    }
  }
  
  public static void a(Context paramContext, Notification.Builder paramBuilder, com.huawei.hms.support.api.push.a.b.a parama)
  {
    if ((paramContext != null) && (paramBuilder != null) && (parama != null))
    {
      if (d(paramContext, parama))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("get small icon from ");
        ((StringBuilder)localObject).append(parama.i());
        com.huawei.hms.support.log.a.b("PushSelfShowLog", ((StringBuilder)localObject).toString());
        localObject = c(paramContext, parama);
        if (localObject != null)
        {
          paramBuilder.setSmallIcon((Icon)localObject);
          return;
        }
        paramBuilder.setSmallIcon(a(paramContext, parama));
        return;
      }
      paramBuilder.setSmallIcon(a(paramContext, parama));
      return;
    }
    com.huawei.hms.support.log.a.d("PushSelfShowLog", "msg is null");
  }
  
  public static Bitmap b(Context paramContext, com.huawei.hms.support.api.push.a.b.a parama)
  {
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject3 = null;
    Object localObject5 = null;
    if (paramContext != null)
    {
      if (parama == null) {
        return null;
      }
      Object localObject1 = localObject5;
      Object localObject4 = localObject6;
      Object localObject2 = localObject7;
      try
      {
        if (parama.m() != null)
        {
          localObject1 = localObject5;
          localObject4 = localObject6;
          localObject2 = localObject7;
          if (parama.m().length() > 0)
          {
            int i = 0;
            localObject4 = localObject6;
            localObject2 = localObject7;
            localObject1 = parama.m();
            localObject4 = localObject6;
            localObject2 = localObject7;
            localObject3 = new StringBuilder();
            localObject4 = localObject6;
            localObject2 = localObject7;
            ((StringBuilder)localObject3).append("");
            localObject4 = localObject6;
            localObject2 = localObject7;
            ((StringBuilder)localObject3).append(parama.a());
            localObject4 = localObject6;
            localObject2 = localObject7;
            if (!((String)localObject1).equals(((StringBuilder)localObject3).toString()))
            {
              localObject4 = localObject6;
              localObject2 = localObject7;
              int j = a(paramContext, parama.m(), "drawable", new R.drawable());
              i = j;
              if (j == 0)
              {
                localObject4 = localObject6;
                localObject2 = localObject7;
                i = paramContext.getResources().getIdentifier(parama.m(), "drawable", "android");
              }
              localObject4 = localObject6;
              localObject2 = localObject7;
              localObject1 = new StringBuilder();
              localObject4 = localObject6;
              localObject2 = localObject7;
              ((StringBuilder)localObject1).append("msg.notifyIcon is ");
              localObject4 = localObject6;
              localObject2 = localObject7;
              ((StringBuilder)localObject1).append(parama.m());
              localObject4 = localObject6;
              localObject2 = localObject7;
              ((StringBuilder)localObject1).append(",and defaultIcon is ");
              localObject4 = localObject6;
              localObject2 = localObject7;
              ((StringBuilder)localObject1).append(i);
              localObject4 = localObject6;
              localObject2 = localObject7;
              com.huawei.hms.support.log.a.a("PushSelfShowLog", ((StringBuilder)localObject1).toString());
            }
            localObject1 = localObject5;
            if (i != 0)
            {
              localObject4 = localObject6;
              localObject2 = localObject7;
              localObject1 = BitmapFactory.decodeResource(paramContext.getResources(), i);
            }
          }
        }
        localObject4 = localObject1;
        localObject2 = localObject1;
        if (com.huawei.hms.support.api.push.b.a.a.a.a() >= 11)
        {
          localObject4 = localObject1;
          localObject2 = localObject1;
          com.huawei.hms.support.log.a.b("PushSelfShowLog", "huawei phone, and emui5.0, need not show large icon.");
          return (Bitmap)localObject1;
        }
        localObject3 = localObject1;
        if (localObject1 == null)
        {
          localObject4 = localObject1;
          localObject2 = localObject1;
          localObject3 = localObject1;
          if (!"com.huawei.android.pushagent".equals(parama.i()))
          {
            localObject4 = localObject1;
            localObject2 = localObject1;
            localObject3 = new StringBuilder();
            localObject4 = localObject1;
            localObject2 = localObject1;
            ((StringBuilder)localObject3).append("get left bitmap from ");
            localObject4 = localObject1;
            localObject2 = localObject1;
            ((StringBuilder)localObject3).append(parama.i());
            localObject4 = localObject1;
            localObject2 = localObject1;
            com.huawei.hms.support.log.a.b("PushSelfShowLog", ((StringBuilder)localObject3).toString());
            localObject4 = localObject1;
            localObject2 = localObject1;
            paramContext = ((BitmapDrawable)paramContext.getPackageManager().getApplicationIcon(parama.i())).getBitmap();
            return paramContext;
          }
        }
      }
      catch (Exception paramContext)
      {
        parama = new StringBuilder();
        parama.append("");
        parama.append(paramContext.toString());
        com.huawei.hms.support.log.a.a("PushSelfShowLog", parama.toString(), paramContext);
        return (Bitmap)localObject4;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        parama = new StringBuilder();
        parama.append("");
        parama.append(paramContext.toString());
        com.huawei.hms.support.log.a.a("PushSelfShowLog", parama.toString(), paramContext);
        localObject3 = localObject2;
      }
    }
    return (Bitmap)localObject3;
  }
  
  public static Icon c(Context paramContext, com.huawei.hms.support.api.push.a.b.a parama)
  {
    if ((paramContext != null) && (parama != null))
    {
      if (Build.VERSION.SDK_INT < 23)
      {
        com.huawei.hms.support.log.a.b("PushSelfShowLog", "getSmallIcon failed, Build.VERSION less than 23");
        return null;
      }
      paramContext = paramContext.getPackageManager();
      try
      {
        paramContext = Icon.createWithResource(parama.i(), paramContext.getApplicationInfo(parama.i(), 0).icon);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        com.huawei.hms.support.log.a.a("PushSelfShowLog", paramContext.toString(), paramContext);
        return null;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        com.huawei.hms.support.log.a.d("PushSelfShowLog", paramContext.toString());
        return null;
      }
    }
    com.huawei.hms.support.log.a.d("PushSelfShowLog", "getSmallIcon, context is null");
    return null;
  }
  
  private static boolean d(Context paramContext, com.huawei.hms.support.api.push.a.b.a parama)
  {
    return (!"com.huawei.android.pushagent".equals(parama.i())) && (Build.VERSION.SDK_INT >= 23) && ((com.huawei.hms.support.api.push.a.d.a.b(paramContext)) || (com.huawei.hms.support.api.push.a.d.a.c(paramContext)));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\a\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */