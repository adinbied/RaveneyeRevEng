package dji.midware.util;

import dji.midware.data.config.P3.Ccode;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.interfaces.DJIDataSyncListener;

public class RepeatDataBase
  implements DJIDataCallBack, Runnable
{
  public final String TAG = "RepeatDataBase";
  private DJIDataCallBack callback;
  private int count;
  private DJIDataSyncListener listener;
  private int repeatDelayTime;
  private int repeatTime;
  
  public RepeatDataBase(DJIDataSyncListener paramDJIDataSyncListener, int paramInt1, int paramInt2, DJIDataCallBack paramDJIDataCallBack)
  {
    this.listener = paramDJIDataSyncListener;
    this.repeatTime = paramInt1;
    this.repeatDelayTime = paramInt2;
    this.callback = paramDJIDataCallBack;
    this.count = 0;
  }
  
  public RepeatDataBase(DJIDataSyncListener paramDJIDataSyncListener, int paramInt, DJIDataCallBack paramDJIDataCallBack)
  {
    this.listener = paramDJIDataSyncListener;
    this.repeatTime = paramInt;
    this.repeatDelayTime = 1000;
    this.callback = paramDJIDataCallBack;
    this.count = 0;
  }
  
  public RepeatDataBase(DJIDataSyncListener paramDJIDataSyncListener, DJIDataCallBack paramDJIDataCallBack)
  {
    this.listener = paramDJIDataSyncListener;
    this.repeatTime = 3;
    this.repeatDelayTime = 1000;
    this.callback = paramDJIDataCallBack;
    this.count = 0;
  }
  
  /* Error */
  private void demo1()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void demo2()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onFailure(Ccode arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onSuccess(Object paramObject)
  {
    DJIDataCallBack localDJIDataCallBack = this.callback;
    if (localDJIDataCallBack != null) {
      localDJIDataCallBack.onSuccess(paramObject);
    }
  }
  
  public void run()
  {
    start();
  }
  
  public void start()
  {
    this.listener.start(this);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\util\RepeatDataBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */