package dji.midware.data.model.extension;

import android.os.Handler;
import dji.midware.data.config.P3.Ccode;
import dji.midware.data.model.P3.DataOsdGetPushConfig;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.util.BackgroundLooper;
import org.greenrobot.eventbus.EventBus;

public class DataOsdConfigEx
  implements Runnable, DJIDataCallBack
{
  private static DataOsdConfigEx dataOsdConfigEx;
  public final String TAG = "DataOsdConfigEx";
  private int bandwidth = -1;
  private DataOsdGetPushConfig dataOsdGetPushConfig = DataOsdGetPushConfig.getInstance();
  private Handler handler = new Handler(BackgroundLooper.getLooper());
  
  private DataOsdConfigEx()
  {
    EventBus.getDefault().register(this);
    refresh();
  }
  
  public static DataOsdConfigEx get()
  {
    if (dataOsdConfigEx == null) {
      dataOsdConfigEx = new DataOsdConfigEx();
    }
    return dataOsdConfigEx;
  }
  
  public DataOsdGetPushConfig getDataOsdGetPushConfig()
  {
    return this.dataOsdGetPushConfig;
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.manager.P3.DataEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataOsdGetPushConfig arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onFailure(Ccode paramCcode) {}
  
  /* Error */
  public void onSuccess(Object arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void refresh()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\extension\DataOsdConfigEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */