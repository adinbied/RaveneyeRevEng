package com.xiaomi.push.service;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import com.xiaomi.push.ba;

public class XMJobService
  extends Service
{
  static Service jdField_a_of_type_AndroidAppService;
  private IBinder jdField_a_of_type_AndroidOsIBinder = null;
  
  static Service a()
  {
    return jdField_a_of_type_AndroidAppService;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    paramIntent = this.jdField_a_of_type_AndroidOsIBinder;
    if (paramIntent != null) {
      return paramIntent;
    }
    return new Binder();
  }
  
  /* Error */
  public void onCreate()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    jdField_a_of_type_AndroidAppService = null;
  }
  
  static class a
    extends JobService
  {
    Binder jdField_a_of_type_AndroidOsBinder;
    private Handler jdField_a_of_type_AndroidOsHandler;
    
    a(Service paramService)
    {
      this.a = null;
      this.a = ((Binder)ba.a(this, "onBind", new Object[] { new Intent() }));
      ba.a(this, "attachBaseContext", new Object[] { paramService });
    }
    
    public boolean onStartJob(JobParameters paramJobParameters)
    {
      return false;
    }
    
    public boolean onStopJob(JobParameters paramJobParameters)
    {
      return false;
    }
    
    private static class a
      extends Handler
    {
      JobService a;
      
      a(JobService paramJobService)
      {
        super();
        this.a = paramJobService;
      }
      
      /* Error */
      public void handleMessage(android.os.Message arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\XMJobService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */