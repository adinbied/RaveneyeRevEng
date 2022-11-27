package com.xiaomi.push;

import android.content.Context;
import java.lang.ref.WeakReference;

public class bw
  implements Runnable
{
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bw(String paramString, WeakReference<Context> paramWeakReference)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */