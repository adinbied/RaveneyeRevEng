package com.xiaomi.push;

import android.content.Context;
import java.io.File;

public abstract class v
  implements Runnable
{
  private Context jdField_a_of_type_AndroidContentContext;
  private File jdField_a_of_type_JavaIoFile;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  
  private v(Context paramContext, File paramFile)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaIoFile = paramFile;
  }
  
  public static void a(Context paramContext, File paramFile, Runnable paramRunnable)
  {
    new w(paramContext, paramFile, paramRunnable).run();
  }
  
  protected abstract void a(Context paramContext);
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */