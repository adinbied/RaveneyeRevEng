package com.xiaomi.mipush.sdk;

import com.xiaomi.push.ht;
import java.util.HashMap;

public class k
{
  private static HashMap<d, a> a = new HashMap();
  
  static
  {
    a(d.a, new a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
    a(d.b, new a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
    a(d.c, new a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
    a(d.d, new a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
  }
  
  public static bb a(d paramd)
  {
    int i = l.a[paramd.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return null;
          }
          return bb.f;
        }
        return bb.e;
      }
      return bb.d;
    }
    return bb.c;
  }
  
  public static a a(d paramd)
  {
    return (a)a.get(paramd);
  }
  
  public static ht a(d paramd)
  {
    return ht.ao;
  }
  
  private static void a(d paramd, a parama)
  {
    if (parama != null) {
      a.put(paramd, parama);
    }
  }
  
  static class a
  {
    public String a;
    public String b;
    
    public a(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */