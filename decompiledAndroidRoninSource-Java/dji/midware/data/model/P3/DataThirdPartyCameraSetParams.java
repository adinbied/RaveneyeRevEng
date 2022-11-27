package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.model.base.IExpApertureSetter;
import dji.midware.data.model.base.IExpEVSetter;
import dji.midware.data.model.base.IExpISOSetter;
import dji.midware.data.model.base.IExpModeSetter;
import dji.midware.data.model.base.IExpShutterSetter;
import dji.midware.data.model.common.CameraShutterSpeed;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataThirdPartyCameraSetParams
  extends DataBase
  implements DJIDataSyncListener, IExpModeSetter, IExpShutterSetter, IExpApertureSetter, IExpISOSetter, IExpEVSetter
{
  private static DataThirdPartyCameraSetParams instance;
  ThirdPartyCameraParamsID mParamsID;
  
  public static DataThirdPartyCameraSetParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataThirdPartyCameraSetParams();
      }
      DataThirdPartyCameraSetParams localDataThirdPartyCameraSetParams = instance;
      return localDataThirdPartyCameraSetParams;
    }
    finally {}
  }
  
  /* Error */
  private void setSendData(ThirdPartyCameraParamsID arg1, int arg2, byte[] arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void doPack() {}
  
  public IExpISOSetter setAbsValue(DataCameraGetIso.TYPE paramTYPE)
  {
    setISO(paramTYPE.value());
    return this;
  }
  
  public IExpShutterSetter setAbsolute(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public DataThirdPartyCameraSetParams setAperture(short paramShort)
  {
    return null;
  }
  
  public DataThirdPartyCameraSetParams setColorTemp(int paramInt)
  {
    return null;
  }
  
  public DataThirdPartyCameraSetParams setEV(int paramInt)
  {
    return null;
  }
  
  public IExpModeSetter setExpMode(int paramInt)
  {
    setExposureMode(DataCameraSetExposureMode.ExposureMode.find(paramInt));
    return this;
  }
  
  public DataThirdPartyCameraSetParams setExposureMode(DataCameraSetExposureMode.ExposureMode paramExposureMode)
  {
    return null;
  }
  
  public DataThirdPartyCameraSetParams setFocusMode(DataCameraGetPushShotInfo.ShotFocusMode paramShotFocusMode)
  {
    return null;
  }
  
  public DataThirdPartyCameraSetParams setFocusValue(int paramInt)
  {
    return null;
  }
  
  public DataThirdPartyCameraSetParams setISO(int paramInt)
  {
    return null;
  }
  
  public DataThirdPartyCameraSetParams setISO(DataCameraGetIso.TYPE paramTYPE)
  {
    return null;
  }
  
  public DataThirdPartyCameraSetParams setShutterSpeed(CameraShutterSpeed paramCameraShutterSpeed)
  {
    return null;
  }
  
  public DataThirdPartyCameraSetParams setWhiteBalanceType(int paramInt)
  {
    return null;
  }
  
  public DataThirdPartyCameraSetParams setWorkMode(DataCameraGetMode.MODE paramMODE)
  {
    return null;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum ThirdPartyCameraParamsID
  {
    private int data;
    
    static
    {
      EXPOSURE_MODE = new ThirdPartyCameraParamsID("EXPOSURE_MODE", 1, 2);
      SHUTTER_SPEED = new ThirdPartyCameraParamsID("SHUTTER_SPEED", 2, 3);
      APERTURE = new ThirdPartyCameraParamsID("APERTURE", 3, 4);
      ISO = new ThirdPartyCameraParamsID("ISO", 4, 5);
      FOCUS_MODE = new ThirdPartyCameraParamsID("FOCUS_MODE", 5, 6);
      MANUAL_FUCOS_VALUE = new ThirdPartyCameraParamsID("MANUAL_FUCOS_VALUE", 6, 7);
      EV = new ThirdPartyCameraParamsID("EV", 7, 8);
      WHITE_BALANCE = new ThirdPartyCameraParamsID("WHITE_BALANCE", 8, 9);
      COLOR_TEMP = new ThirdPartyCameraParamsID("COLOR_TEMP", 9, 10);
      ThirdPartyCameraParamsID localThirdPartyCameraParamsID = new ThirdPartyCameraParamsID("OTHER", 10, 100);
      OTHER = localThirdPartyCameraParamsID;
      $VALUES = new ThirdPartyCameraParamsID[] { WORK_MODE, EXPOSURE_MODE, SHUTTER_SPEED, APERTURE, ISO, FOCUS_MODE, MANUAL_FUCOS_VALUE, EV, WHITE_BALANCE, COLOR_TEMP, localThirdPartyCameraParamsID };
    }
    
    private ThirdPartyCameraParamsID(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static ThirdPartyCameraParamsID find(int paramInt)
    {
      ThirdPartyCameraParamsID localThirdPartyCameraParamsID = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localThirdPartyCameraParamsID;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataThirdPartyCameraSetParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */