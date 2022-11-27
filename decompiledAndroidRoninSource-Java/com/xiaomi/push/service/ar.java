package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.da;
import com.xiaomi.push.db;
import com.xiaomi.push.db.a;
import com.xiaomi.push.db.b;
import com.xiaomi.push.el.a;
import java.util.ArrayList;

public class ar
  extends bb.a
  implements db.a
{
  private long jdField_a_of_type_Long;
  private XMPushService jdField_a_of_type_ComXiaomiPushServiceXMPushService;
  
  ar(XMPushService paramXMPushService)
  {
    this.a = paramXMPushService;
  }
  
  public static void a(XMPushService paramXMPushService)
  {
    ar localar = new ar(paramXMPushService);
    bb.a().a(localar);
    try
    {
      db.a(localar);
      db.a(paramXMPushService, null, new a(), "0", "push", "2.2");
      return;
    }
    finally {}
  }
  
  public db a(Context paramContext, da paramda, db.b paramb, String paramString)
  {
    return new b(paramContext, paramda, paramb, paramString);
  }
  
  public void a(el.a parama) {}
  
  /* Error */
  public void a(com.xiaomi.push.em.b arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static class a
    implements db.b
  {
    public String a(String paramString)
    {
      return null;
    }
  }
  
  static class b
    extends db
  {
    protected b(Context paramContext, da paramda, db.b paramb, String paramString)
    {
      super(paramda, paramb, paramString);
    }
    
    protected String a(ArrayList<String> paramArrayList, String paramString1, String paramString2, boolean paramBoolean)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */