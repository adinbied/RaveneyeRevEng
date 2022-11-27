package com.xiaomi.push;

import android.app.job.JobScheduler;
import android.content.Context;

public class fg
  implements fe.a
{
  JobScheduler jdField_a_of_type_AndroidAppJobJobScheduler;
  Context jdField_a_of_type_AndroidContentContext;
  private boolean jdField_a_of_type_Boolean = false;
  
  fg(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidAppJobJobScheduler = ((JobScheduler)paramContext.getSystemService("jobscheduler"));
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
  void a(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\fg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */