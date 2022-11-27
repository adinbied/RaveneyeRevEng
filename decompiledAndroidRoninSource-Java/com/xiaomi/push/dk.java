package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.util.concurrent.ConcurrentLinkedQueue;

public class dk
{
  private static volatile dk jdField_a_of_type_ComXiaomiPushDk;
  private Context jdField_a_of_type_AndroidContentContext;
  private final ConcurrentLinkedQueue<b> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
  
  private dk(Context paramContext)
  {
    ConcurrentLinkedQueue localConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = localConcurrentLinkedQueue;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    localConcurrentLinkedQueue.add(new a());
    b(0L);
  }
  
  public static dk a(Context paramContext)
  {
    if (jdField_a_of_type_ComXiaomiPushDk == null) {
      try
      {
        if (jdField_a_of_type_ComXiaomiPushDk == null) {
          jdField_a_of_type_ComXiaomiPushDk = new dk(paramContext);
        }
      }
      finally {}
    }
    jdField_a_of_type_ComXiaomiPushDk.jdField_a_of_type_AndroidContentContext = paramContext;
    return jdField_a_of_type_ComXiaomiPushDk;
  }
  
  /* Error */
  private void a(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void b(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(String arg1, String arg2, java.util.Date arg3, java.util.Date arg4, int arg5, boolean arg6)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  class a
    extends dk.b
  {
    a()
    {
      super();
    }
    
    public void b()
    {
      dk.a(dk.this);
    }
  }
  
  class b
    extends al.b
  {
    long a = System.currentTimeMillis();
    
    b() {}
    
    public boolean a()
    {
      return true;
    }
    
    public void b() {}
    
    final boolean b()
    {
      return false;
    }
  }
  
  class c
    extends dk.b
  {
    int jdField_a_of_type_Int;
    File jdField_a_of_type_JavaIoFile;
    String jdField_a_of_type_JavaLangString;
    boolean jdField_a_of_type_Boolean;
    String jdField_b_of_type_JavaLangString;
    boolean jdField_b_of_type_Boolean;
    
    c(String paramString1, String paramString2, File paramFile, boolean paramBoolean)
    {
      super();
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_JavaIoFile = paramFile;
      this.jdField_b_of_type_Boolean = paramBoolean;
    }
    
    private boolean c()
    {
      return false;
    }
    
    public boolean a()
    {
      return false;
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
    public void c()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\dk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */