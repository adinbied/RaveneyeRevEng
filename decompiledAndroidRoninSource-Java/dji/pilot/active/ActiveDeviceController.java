package dji.pilot.active;

import android.content.Context;
import com.dji.ronin.publics.AssistUIHandler;
import dji.midware.data.config.P3.Ccode;
import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.model.P3.DataBatteryActiveStatus;
import dji.midware.data.model.P3.DataCenterActiveStatus;
import dji.midware.data.model.P3.DataGimbalActiveStatus;
import dji.midware.data.model.common.DataAbstractGetPushActiveStatus;
import dji.midware.interfaces.DJIDataCallBack;
import java.util.ArrayList;

public class ActiveDeviceController
{
  private static final String ACTIVE = "/verify";
  private static final String ERRORLOG = "/errorlog";
  private static final String SKYPIXEL = "/getem";
  private final String TAG = getClass().getSimpleName();
  private int activeFailNum = 0;
  private int activeModelCount = 0;
  private DJIActiveSnModel activeSnModel;
  private int activeSucNum = 0;
  private DataBatteryActiveStatus batteryActiveStatus = DataBatteryActiveStatus.getInstance();
  private DataAbstractGetPushActiveStatus centerActiveStatus = DataCenterActiveStatus.getInstance();
  private Context context;
  private int day;
  private ArrayList<DeviceType> devicesSuc = new ArrayList(4);
  private ActiveWebController.DJIActiveWebFailType failType = ActiveWebController.DJIActiveWebFailType.NoStart;
  private boolean flycSuc = false;
  private DataGimbalActiveStatus gimbalActiveStatus = DataGimbalActiveStatus.getInstance();
  private int hour;
  private boolean isOnline = true;
  private DJIActiveDeviceListener listener;
  private DJIMultiBatteryActiveManager mMultiBatteryActiveManager = DJIMultiBatteryActiveManager.getInstance();
  private int min;
  private int month;
  private int second;
  private int year;
  
  public ActiveDeviceController(Context paramContext, DJIActiveDeviceListener paramDJIActiveDeviceListener)
  {
    this.context = paramContext;
    this.listener = paramDJIActiveDeviceListener;
  }
  
  /* Error */
  private void activeBattery(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void activeCenter(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void activeFailOne(DeviceType arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void activeGimbal(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void activeSuccessOne(DeviceType arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void doActive(int arg1, String arg2, long arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void onActiveOver()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void activeOnline(DJIActiveSnModel arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public ActiveWebController.DJIActiveWebFailType getFailedType()
  {
    return this.failType;
  }
  
  public static abstract interface DJIActiveDeviceListener
  {
    public abstract void onFailed();
    
    public abstract void onSuccess();
  }
  
  public static class DJIActiveLocalModel
  {
    public long addtime;
    public String content;
    public String description;
    public int id;
    public boolean isSuccess;
    public boolean isUploaded;
    public String registerPhone;
    public String uid;
    public long updatetime;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilot\active\ActiveDeviceController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */