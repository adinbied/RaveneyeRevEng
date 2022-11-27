package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJICameraDataBase;

public class DataThirdPartyCameraGetPuchInfo
  extends DJICameraDataBase
{
  private static int DEFAULT_FOCUS_SPEED = 1;
  private static final String TAG = "ThirdPartyCameraPush";
  private int mFocusSpeed;
  private int mLinearFocusSpeed;
  private int mLinearZoomSpeed;
  private boolean mSuccess;
  private boolean mSupportLinearFocusSpeed;
  private boolean mSupportLinearZoomSpeed;
  private int mUsbType;
  private int mZoomSpeed = DataThirdPartyCameraSetInfo.CameraZoomSpeed.SLOW.value();
  
  public DataThirdPartyCameraGetPuchInfo()
  {
    int i = DEFAULT_FOCUS_SPEED;
    this.mFocusSpeed = i;
    this.mSupportLinearFocusSpeed = false;
    this.mLinearFocusSpeed = i;
    this.mSupportLinearZoomSpeed = false;
    this.mLinearZoomSpeed = 1;
    this.mUsbType = CameraUsbType.Panosonic_OTHER.value();
  }
  
  public static DataThirdPartyCameraGetPuchInfo getInstance()
  {
    return SingletonHolder.mInstance;
  }
  
  protected void doPack() {}
  
  public DataThirdPartyCameraSetInfo.CameraFocusSpeedCanon getCameraFocusSpeedCanon()
  {
    return DataThirdPartyCameraSetInfo.CameraFocusSpeedCanon.find(this.mFocusSpeed);
  }
  
  public DataThirdPartyCameraSetInfo.CameraFocusSpeedNikon getCameraFocusSpeedNikon()
  {
    return DataThirdPartyCameraSetInfo.CameraFocusSpeedNikon.find(this.mFocusSpeed);
  }
  
  public DataThirdPartyCameraSetInfo.CameraFocusSpeedPanasonic getCameraFocusSpeedPanasonic()
  {
    return DataThirdPartyCameraSetInfo.CameraFocusSpeedPanasonic.find(this.mFocusSpeed);
  }
  
  public DataThirdPartyCameraSetInfo.CameraFocusSpeedSony getCameraFocusSpeedSony()
  {
    return DataThirdPartyCameraSetInfo.CameraFocusSpeedSony.find(this.mFocusSpeed);
  }
  
  public CameraUsbType getCameraUsbType()
  {
    return CameraUsbType.find(this.mUsbType);
  }
  
  public DataThirdPartyCameraSetInfo.CameraZoomSpeed getCameraZoomSpeed()
  {
    return DataThirdPartyCameraSetInfo.CameraZoomSpeed.find(this.mZoomSpeed);
  }
  
  public int getLinearFocusSpeed()
  {
    return this.mLinearFocusSpeed;
  }
  
  public int getLinearZoomSpeed()
  {
    return this.mLinearZoomSpeed;
  }
  
  public boolean getSupportLinearFocusSpeed()
  {
    return this.mSupportLinearFocusSpeed;
  }
  
  public boolean getSupportLinearZoomSpeed()
  {
    return this.mSupportLinearZoomSpeed;
  }
  
  public boolean isSuccess()
  {
    return this.mSuccess;
  }
  
  /* Error */
  protected void setPushRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum CameraUsbType
  {
    private int data;
    
    static
    {
      Panosonic_S1H = new CameraUsbType("Panosonic_S1H", 4, 5);
      CameraUsbType localCameraUsbType = new CameraUsbType("Panosonic_OTHER", 5, 100);
      Panosonic_OTHER = localCameraUsbType;
      $VALUES = new CameraUsbType[] { Panosonic_GH5, Panosonic_GH5S, Panosonic_S1, Panosonic_S1R, Panosonic_S1H, localCameraUsbType };
    }
    
    private CameraUsbType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static CameraUsbType find(int paramInt)
    {
      CameraUsbType localCameraUsbType = Panosonic_OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localCameraUsbType;
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
  
  private static final class SingletonHolder
  {
    private static final DataThirdPartyCameraGetPuchInfo mInstance = new DataThirdPartyCameraGetPuchInfo();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataThirdPartyCameraGetPuchInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */