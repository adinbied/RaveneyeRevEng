package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJICameraDataBase;
import dji.midware.data.model.common.CameraShutterSpeed;
import dji.midware.data.model.common.DJICameraShutterSpeedType;
import dji.midware.data.model.extension.ThirdPartyCameraDataConverter;

public class DataThirdPartyCameraGetPushParams
  extends DJICameraDataBase
{
  private static DataThirdPartyCameraGetPushParams instance;
  
  public static DataThirdPartyCameraGetPushParams getInstance()
  {
    try
    {
      if (instance == null)
      {
        localDataThirdPartyCameraGetPushParams = new DataThirdPartyCameraGetPushParams();
        instance = localDataThirdPartyCameraGetPushParams;
        localDataThirdPartyCameraGetPushParams.isNeedPushLosed = true;
        instance.isRemoteModel = true;
      }
      DataThirdPartyCameraGetPushParams localDataThirdPartyCameraGetPushParams = instance;
      return localDataThirdPartyCameraGetPushParams;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getBatteryPercent()
  {
    return 0;
  }
  
  public CameraCtrlType getCameraCtrlType()
  {
    return null;
  }
  
  public DataCameraGetPushStateInfo.CameraType getCameraType()
  {
    return null;
  }
  
  public DataCameraGetMode.MODE getCameraWorkMode()
  {
    return null;
  }
  
  public DataCameraGetStateInfo.PhotoState getCaptureState()
  {
    return null;
  }
  
  public DataCameraSetPhoto.TYPE getCaptureType()
  {
    return null;
  }
  
  public DataCameraSetExposureMode.ExposureMode getExposureMode()
  {
    return null;
  }
  
  public DataCameraGetPushShotInfo.ShotFocusMode getFucosMode()
  {
    return null;
  }
  
  public int getHighExposureCompensationThreshold()
  {
    return 0;
  }
  
  public boolean getIsCaptureDisabled()
  {
    return false;
  }
  
  public boolean getIsStoring()
  {
    return false;
  }
  
  public int getLowExposureCompensationThreshold()
  {
    return 0;
  }
  
  public int getPhotoRemainCount()
  {
    return 0;
  }
  
  public int getRealApertureSize()
  {
    return 0;
  }
  
  public int getRealColorTemp()
  {
    return 0;
  }
  
  public int getRealExposureCompensation()
  {
    return 0;
  }
  
  public int getRealISO()
  {
    return 0;
  }
  
  public CameraShutterSpeed getRealShutterSpeed()
  {
    return null;
  }
  
  public DataCameraGetPushStateInfo.RecordType getRecordState()
  {
    return null;
  }
  
  public DJICameraShutterSpeedType getShutterSpeedType()
  {
    return null;
  }
  
  public DataCameraGetStateInfo.SDCardState getStorageStatus0()
  {
    return null;
  }
  
  public DataCameraGetStateInfo.SDCardState getStorageStatus1()
  {
    return null;
  }
  
  public DataCameraGetStateInfo.SDCardState getStorageStatus2()
  {
    return null;
  }
  
  public int getUserSetApertureSize()
  {
    return 0;
  }
  
  public int getUserSetExposureCompensation()
  {
    return 0;
  }
  
  public DataCameraGetIso.TYPE getUserSetISO()
  {
    return null;
  }
  
  public CameraShutterSpeed getUserSetShutterSpeed()
  {
    return null;
  }
  
  public int getUserSetWhiteBalanceType()
  {
    return 0;
  }
  
  protected void setPushRecData(byte[] paramArrayOfByte)
  {
    super.setPushRecData(paramArrayOfByte);
    ThirdPartyCameraDataConverter.getInstance().converterData();
  }
  
  public static enum CameraCtrlType
  {
    private static volatile CameraCtrlType[] sValues = null;
    private int data;
    
    static
    {
      RSS = new CameraCtrlType("RSS", 1, 1);
      MULTI = new CameraCtrlType("MULTI", 2, 2);
      CameraCtrlType localCameraCtrlType = new CameraCtrlType("OTHER", 3, 255);
      OTHER = localCameraCtrlType;
      $VALUES = new CameraCtrlType[] { USB, RSS, MULTI, localCameraCtrlType };
    }
    
    private CameraCtrlType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static CameraCtrlType find(int paramInt)
    {
      if (sValues == null) {
        sValues = values();
      }
      CameraCtrlType localCameraCtrlType = USB;
      int i = 0;
      while (i < sValues.length)
      {
        if (sValues[i]._equals(paramInt)) {
          return sValues[i];
        }
        i += 1;
      }
      return localCameraCtrlType;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataThirdPartyCameraGetPushParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */