package com.xiaomi.push.service;

import android.content.Context;
import android.os.IBinder.DeathRecipient;
import android.os.Messenger;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class am
{
  private static am jdField_a_of_type_ComXiaomiPushServiceAm;
  private List<a> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ConcurrentHashMap<String, HashMap<String, b>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static am a()
  {
    try
    {
      if (jdField_a_of_type_ComXiaomiPushServiceAm == null) {
        jdField_a_of_type_ComXiaomiPushServiceAm = new am();
      }
      am localam = jdField_a_of_type_ComXiaomiPushServiceAm;
      return localam;
    }
    finally {}
  }
  
  private String a(String paramString)
  {
    return null;
  }
  
  public int a()
  {
    return 0;
  }
  
  public b a(String paramString1, String paramString2)
  {
    return null;
  }
  
  public ArrayList<b> a()
  {
    return null;
  }
  
  public Collection<b> a(String paramString)
  {
    return null;
  }
  
  public List<String> a(String paramString)
  {
    return null;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(Context arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(a arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(b arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(String arg1, String arg2)
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
  
  public static abstract interface a
  {
    public abstract void a();
  }
  
  public static class b
  {
    private int jdField_a_of_type_Int = 0;
    public Context a;
    IBinder.DeathRecipient jdField_a_of_type_AndroidOsIBinder$DeathRecipient = null;
    Messenger jdField_a_of_type_AndroidOsMessenger;
    private XMPushService.b jdField_a_of_type_ComXiaomiPushServiceXMPushService$b = new XMPushService.b(this);
    private XMPushService jdField_a_of_type_ComXiaomiPushServiceXMPushService;
    final b jdField_a_of_type_ComXiaomiPushServiceAm$b$b = new b();
    am.c jdField_a_of_type_ComXiaomiPushServiceAm$c = am.c.jdField_a_of_type_ComXiaomiPushServiceAm$c;
    public d a;
    public String a;
    private List<a> jdField_a_of_type_JavaUtilList = new ArrayList();
    public boolean a;
    am.c jdField_b_of_type_ComXiaomiPushServiceAm$c = null;
    public String b;
    private boolean jdField_b_of_type_Boolean = false;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    
    public b() {}
    
    public b(XMPushService paramXMPushService)
    {
      this.jdField_a_of_type_ComXiaomiPushServiceXMPushService = paramXMPushService;
      a(new an(this));
    }
    
    public static String a(String paramString)
    {
      boolean bool = TextUtils.isEmpty(paramString);
      String str = "";
      if (bool) {
        return "";
      }
      int j = paramString.lastIndexOf("/");
      if (j != -1) {
        str = paramString.substring(j + 1);
      }
      return str;
    }
    
    /* Error */
    private void a(int arg1, int arg2, String arg3, String arg4)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: return
    }
    
    private boolean a(int paramInt1, int paramInt2, String paramString)
    {
      return false;
    }
    
    private boolean b(int paramInt1, int paramInt2, String paramString)
    {
      return false;
    }
    
    public long a()
    {
      return 1006647432L;
    }
    
    public String a(int paramInt)
    {
      return null;
    }
    
    /* Error */
    void a()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void a(Messenger arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void a(a arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void a(am.c arg1, int arg2, int arg3, String arg4, String arg5)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void b(a arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public static abstract interface a
    {
      public abstract void a(am.c paramc1, am.c paramc2, int paramInt);
    }
    
    class b
      extends XMPushService.i
    {
      String jdField_a_of_type_JavaLangString;
      int jdField_b_of_type_Int;
      String jdField_b_of_type_JavaLangString;
      int c;
      
      public b()
      {
        super();
      }
      
      public XMPushService.i a(int paramInt1, int paramInt2, String paramString1, String paramString2)
      {
        this.jdField_b_of_type_Int = paramInt1;
        this.c = paramInt2;
        this.jdField_b_of_type_JavaLangString = paramString2;
        this.jdField_a_of_type_JavaLangString = paramString1;
        return this;
      }
      
      public String a()
      {
        return "notify job";
      }
      
      /* Error */
      public void a()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    }
    
    class c
      implements IBinder.DeathRecipient
    {
      final Messenger jdField_a_of_type_AndroidOsMessenger;
      final am.b jdField_a_of_type_ComXiaomiPushServiceAm$b;
      
      c(am.b paramb, Messenger paramMessenger)
      {
        this.jdField_a_of_type_ComXiaomiPushServiceAm$b = paramb;
        this.jdField_a_of_type_AndroidOsMessenger = paramMessenger;
      }
      
      /* Error */
      public void binderDied()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    }
  }
  
  public static enum c
  {
    static
    {
      jdField_a_of_type_ComXiaomiPushServiceAm$c = new c("unbind", 0);
      b = new c("binding", 1);
      c localc = new c("binded", 2);
      c = localc;
      jdField_a_of_type_ArrayOfComXiaomiPushServiceAm$c = new c[] { jdField_a_of_type_ComXiaomiPushServiceAm$c, b, localc };
    }
    
    private c() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */