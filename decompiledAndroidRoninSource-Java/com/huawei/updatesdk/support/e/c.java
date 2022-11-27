package com.huawei.updatesdk.support.e;

import com.huawei.updatesdk.sdk.a.c.a.a.a;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private static final Map<Integer, String> a;
  private static c d = new c();
  private int b = 0;
  private String c = "";
  
  static
  {
    Object localObject = new HashMap();
    a = (Map)localObject;
    ((Map)localObject).put(Integer.valueOf(1), "1.0");
    a.put(Integer.valueOf(2), "1.5");
    a.put(Integer.valueOf(3), "1.6");
    a.put(Integer.valueOf(4), "2.0");
    a.put(Integer.valueOf(5), "2.0");
    a.put(Integer.valueOf(6), "2.3");
    a.put(Integer.valueOf(7), "3.0");
    localObject = a;
    Integer localInteger = Integer.valueOf(8);
    ((Map)localObject).put(localInteger, "3.0.5");
    a.put(localInteger, "3.1");
    a.put(Integer.valueOf(9), "4.0");
    a.put(Integer.valueOf(10), "4.1");
    a.put(Integer.valueOf(11), "5.0");
    a.put(Integer.valueOf(12), "5.1");
  }
  
  private c()
  {
    int i = d();
    this.b = i;
    if (i == 0) {
      this.b = e();
    }
    this.c = f();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("emuiVersion:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",emuiVersionName:");
    localStringBuilder.append(this.c);
    a.a("EMUISupportUtil", localStringBuilder.toString());
  }
  
  public static c a()
  {
    return d;
  }
  
  private String a(String paramString)
  {
    return null;
  }
  
  private int d()
  {
    return 0;
  }
  
  private int e()
  {
    return 0;
  }
  
  private String f()
  {
    return null;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\support\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */