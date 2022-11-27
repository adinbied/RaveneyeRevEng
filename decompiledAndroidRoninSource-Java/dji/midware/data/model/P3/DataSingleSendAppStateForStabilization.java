package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataSingleSendAppStateForStabilization
  extends DataBase
  implements DJIDataSyncListener
{
  private CameraState cameraState = CameraState.NORMAL;
  private GimbalState gimbalState = GimbalState.NORMAL;
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataSingleSendAppStateForStabilization setCameraState(CameraState paramCameraState)
  {
    this.gimbalState = GimbalState.NORMAL;
    this.cameraState = paramCameraState;
    return this;
  }
  
  public DataSingleSendAppStateForStabilization setGimbalState(GimbalState paramGimbalState)
  {
    this.cameraState = CameraState.NORMAL;
    this.gimbalState = paramGimbalState;
    return this;
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum CameraState
  {
    private int data;
    
    static
    {
      CHANGING_FOCUS = new CameraState("CHANGING_FOCUS", 3, 3);
      CameraState localCameraState = new CameraState("OTHER", 4, 8);
      OTHER = localCameraState;
      $VALUES = new CameraState[] { NORMAL, ZOOM_IN, ZOOM_OUT, CHANGING_FOCUS, localCameraState };
    }
    
    private CameraState(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static CameraState find(int paramInt)
    {
      CameraState localCameraState = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localCameraState;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
  
  public static enum GimbalState
  {
    private int data;
    
    static
    {
      GimbalState localGimbalState = new GimbalState("OTHER", 2, 8);
      OTHER = localGimbalState;
      $VALUES = new GimbalState[] { NORMAL, START, localGimbalState };
    }
    
    private GimbalState(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static GimbalState find(int paramInt)
    {
      GimbalState localGimbalState = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localGimbalState;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSingleSendAppStateForStabilization.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */