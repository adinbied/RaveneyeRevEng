package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseArray;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class ai
{
  private static volatile ai jdField_a_of_type_ComXiaomiPushAi;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private SparseArray<ScheduledFuture> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ScheduledThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
  
  private ai(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramContext.getSharedPreferences("mipush_extra", 0);
  }
  
  public static ai a(Context paramContext)
  {
    if (jdField_a_of_type_ComXiaomiPushAi == null) {
      try
      {
        if (jdField_a_of_type_ComXiaomiPushAi == null) {
          jdField_a_of_type_ComXiaomiPushAi = new ai(paramContext);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComXiaomiPushAi;
  }
  
  private static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("last_job_time");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  private ScheduledFuture a(a parama)
  {
    return null;
  }
  
  public void a(Runnable paramRunnable)
  {
    a(paramRunnable, 0);
  }
  
  /* Error */
  public void a(Runnable arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(a parama, int paramInt)
  {
    return a(parama, paramInt, 0);
  }
  
  public boolean a(a parama, int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean b(a parama, int paramInt)
  {
    return false;
  }
  
  public static abstract class a
    implements Runnable
  {
    public abstract int a();
  }
  
  private static class b
    implements Runnable
  {
    ai.a a;
    
    public b(ai.a parama)
    {
      this.a = parama;
    }
    
    void a() {}
    
    void b() {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */