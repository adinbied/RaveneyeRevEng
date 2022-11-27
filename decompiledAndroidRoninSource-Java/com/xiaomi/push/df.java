package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class df
{
  static int a(int paramInt1, int paramInt2)
  {
    return (paramInt2 + 243) / 1448 * 132 + 1080 + paramInt1 + paramInt2;
  }
  
  static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt2 + 200) / 1448 * 132 + 1011 + paramInt2 + paramInt1 + paramInt3;
  }
  
  private static int a(de paramde, String paramString1, List<ay> paramList, String paramString2)
  {
    if (paramde.a() == 1) {
      return a(paramString1.length(), a(paramString2));
    }
    if (paramde.a() == 2)
    {
      int i = a(paramList);
      return a(paramString1.length(), i, a(paramString2));
    }
    return -1;
  }
  
  static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      int i = paramString.getBytes("UTF-8").length;
      return i;
    }
    catch (UnsupportedEncodingException paramString) {}
    return 0;
  }
  
  static int a(List<ay> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      ay localay = (ay)paramList.next();
      int j = i;
      if (!TextUtils.isEmpty(localay.a())) {
        j = i + localay.a().length();
      }
      i = j;
      if (!TextUtils.isEmpty(localay.b())) {
        i = j + localay.b().length();
      }
    }
    return i * 2;
  }
  
  public static String a(Context paramContext, String paramString, List<ay> paramList)
  {
    return a(paramContext, paramString, paramList, new a(), true);
  }
  
  public static String a(Context paramContext, String paramString, List<ay> paramList, de paramde, boolean paramBoolean)
  {
    cx localcx;
    label71:
    ArrayList localArrayList;
    if (az.b(paramContext))
    {
      try
      {
        localObject = new ArrayList();
        if (!paramBoolean) {
          break label320;
        }
        localcx = db.a().a(paramString);
        if (localcx == null) {
          break label317;
        }
        localObject = localcx.a(paramString);
      }
      catch (MalformedURLException paramContext)
      {
        Object localObject;
        Iterator localIterator;
        String str2;
        paramContext.printStackTrace();
      }
      if (!((ArrayList)localObject).contains(paramString)) {
        ((ArrayList)localObject).add(paramString);
      }
      localIterator = ((ArrayList)localObject).iterator();
      paramString = null;
      if (localIterator.hasNext())
      {
        str2 = (String)localIterator.next();
        if (paramList == null) {
          break label326;
        }
        localArrayList = new ArrayList(paramList);
      }
    }
    for (;;)
    {
      long l1 = System.currentTimeMillis();
      try
      {
        if (!paramde.a(paramContext, str2, localArrayList)) {
          return paramString;
        }
        localObject = paramde.a(paramContext, str2, localArrayList);
        try
        {
          paramBoolean = TextUtils.isEmpty((CharSequence)localObject);
          if (!paramBoolean)
          {
            if (localcx != null) {
              try
              {
                localcx.a(str2, System.currentTimeMillis() - l1, a(paramde, str2, localArrayList, (String)localObject));
              }
              catch (IOException localIOException2)
              {
                paramString = (String)localObject;
                localObject = localIOException2;
                break label270;
              }
            }
            return (String)localObject;
          }
          if (localcx != null)
          {
            long l2 = System.currentTimeMillis();
            int i = a(paramde, str2, localArrayList, (String)localObject);
            long l3 = i;
            try
            {
              localcx.a(str2, l2 - l1, l3, null);
            }
            catch (IOException paramString)
            {
              break label255;
            }
          }
          paramString = (String)localObject;
        }
        catch (IOException paramString)
        {
          label255:
          String str1 = paramString;
          paramString = (String)localObject;
          localObject = str1;
        }
        if (localcx == null) {
          break label300;
        }
      }
      catch (IOException localIOException1) {}
      label270:
      localcx.a(str2, System.currentTimeMillis() - l1, a(paramde, str2, localArrayList, paramString), localIOException1);
      label300:
      localIOException1.printStackTrace();
      break label71;
      return paramString;
      return null;
      label317:
      break;
      label320:
      localcx = null;
      break;
      label326:
      localArrayList = null;
    }
  }
  
  public static class a
    extends de
  {
    public a()
    {
      super();
    }
    
    public String a(Context paramContext, String paramString, List<ay> paramList)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */