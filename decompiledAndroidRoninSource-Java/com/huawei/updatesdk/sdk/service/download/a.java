package com.huawei.updatesdk.sdk.service.download;

import android.util.SparseIntArray;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a
{
  private static a g = new a();
  private static SparseIntArray h;
  public List<String> a = new ArrayList();
  public Map<String, SparseIntArray> b = new HashMap();
  private String c = null;
  private String d = null;
  private String e = null;
  private String f = null;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    h = localSparseIntArray;
    localSparseIntArray.put(1, 3000);
    h.put(2, 6000);
  }
  
  public static a a()
  {
    return g;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    try
    {
      localObject = new URL(paramString1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(((URL)localObject).getFile());
      paramString2 = localStringBuilder.toString();
      return paramString2;
    }
    catch (MalformedURLException paramString2)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updataIP exception:");
      ((StringBuilder)localObject).append(paramString2.getMessage());
      com.huawei.updatesdk.sdk.a.c.a.a.a.d("ConnectionParam", ((StringBuilder)localObject).toString());
    }
    return paramString1;
  }
  
  /* Error */
  private void a(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(int arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  public void a(android.content.Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void b(android.content.Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String c()
  {
    return null;
  }
  
  public List<String> d()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\service\download\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */