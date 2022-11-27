package dji.internal.logics;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import dji.midware.data.model.P3.DataRcSetCalibration;
import dji.midware.data.model.P3.DataRcSetCalibration.MODE;
import dji.midware.interfaces.DJIDataCallBack;
import java.util.ArrayList;

public class RemoteControllerCalibrationLogics
{
  private static final int MSG_ID_SETMODE_CB = 0;
  private static RemoteControllerCalibrationLogics instance;
  private ArrayList<CalibrationCallback> callbacks;
  private Controller controller = new Controller(null);
  private Handler handler = new Handler(new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      return false;
    }
  });
  
  private Controller getController()
  {
    return null;
  }
  
  public static RemoteControllerCalibrationLogics getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new RemoteControllerCalibrationLogics();
      }
      RemoteControllerCalibrationLogics localRemoteControllerCalibrationLogics = instance;
      return localRemoteControllerCalibrationLogics;
    }
    finally {}
  }
  
  /* Error */
  public void addCalibrationCallback(CalibrationCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataRcSetCalibration.MODE getMode()
  {
    return this.controller.getRcMode(false);
  }
  
  /* Error */
  public void handleDataEvent(dji.midware.data.manager.P3.DataEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void removeCalibrationCallback(CalibrationCallback paramCalibrationCallback)
  {
    ArrayList localArrayList = this.callbacks;
    if (localArrayList != null) {
      localArrayList.remove(paramCalibrationCallback);
    }
  }
  
  /* Error */
  public void startCalibration()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static abstract interface CalibrationCallback
  {
    public abstract void update(DataRcSetCalibration.MODE paramMODE);
  }
  
  private final class Controller
  {
    private boolean hasTimeOut = false;
    private DataRcSetCalibration.MODE mRcMode = DataRcSetCalibration.MODE.OTHER;
    private DataRcSetCalibration mSetDataInstance = null;
    private DJIDataCallBack mSetModeCB = null;
    private boolean mbConnected = false;
    private boolean mbStart = false;
    
    private Controller() {}
    
    /* Error */
    private void doNext(boolean arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    private DataRcSetCalibration.MODE getRcMode(boolean paramBoolean)
    {
      return null;
    }
    
    private boolean hasStart()
    {
      return this.mbStart;
    }
    
    /* Error */
    private void start()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void stop()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\RemoteControllerCalibrationLogics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */