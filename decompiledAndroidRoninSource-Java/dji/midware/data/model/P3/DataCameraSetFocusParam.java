package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetFocusParam
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraSetFocusParam instance;
  private boolean mDigitalConZoomIn = true;
  private int mDigitalConZoomSpeed = 1;
  private ZoomMode mDigitalMode = ZoomMode.POSITION;
  private float mDigitalPosScale = 0.0F;
  private float mDigitalStepScale = 0.0F;
  private boolean mDigitalStepZoomIn = true;
  private boolean mOpticalConZoomIn = true;
  private int mOpticalConZoomSpeed = 1;
  private ZoomMode mOpticalMode = ZoomMode.POSITION;
  private float mOpticalPosScale = 0.0F;
  private float mOpticalStepScale = 0.0F;
  private boolean mOpticalStepZoomIn = true;
  private boolean mbDigitalZoom = false;
  private boolean mbOpticalZoom = false;
  
  public static DataCameraSetFocusParam getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraSetFocusParam();
      }
      DataCameraSetFocusParam localDataCameraSetFocusParam = instance;
      return localDataCameraSetFocusParam;
    }
    finally {}
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public float getDigitalScale()
  {
    return 0.0F;
  }
  
  public float getOpticalScale()
  {
    return 0.0F;
  }
  
  public DataCameraSetFocusParam setDigitalConSpeed(int paramInt)
  {
    this.mDigitalConZoomSpeed = paramInt;
    return this;
  }
  
  public DataCameraSetFocusParam setDigitalConZoom(boolean paramBoolean)
  {
    this.mDigitalConZoomIn = paramBoolean;
    return this;
  }
  
  public DataCameraSetFocusParam setDigitalMode(ZoomMode paramZoomMode)
  {
    this.mDigitalMode = paramZoomMode;
    return this;
  }
  
  public DataCameraSetFocusParam setDigitalPosScale(float paramFloat)
  {
    this.mDigitalPosScale = paramFloat;
    return this;
  }
  
  public DataCameraSetFocusParam setDigitalStepScale(float paramFloat)
  {
    this.mDigitalStepScale = paramFloat;
    return this;
  }
  
  public DataCameraSetFocusParam setDigitalStepZoomIn(boolean paramBoolean)
  {
    this.mDigitalStepZoomIn = paramBoolean;
    return this;
  }
  
  public DataCameraSetFocusParam setDigitalZoom(boolean paramBoolean)
  {
    this.mbDigitalZoom = paramBoolean;
    return this;
  }
  
  public DataCameraSetFocusParam setOpticalConSpeed(int paramInt)
  {
    this.mOpticalConZoomSpeed = paramInt;
    return this;
  }
  
  public DataCameraSetFocusParam setOpticalConZoom(boolean paramBoolean)
  {
    this.mOpticalConZoomIn = paramBoolean;
    return this;
  }
  
  public DataCameraSetFocusParam setOpticalMode(ZoomMode paramZoomMode)
  {
    this.mOpticalMode = paramZoomMode;
    return this;
  }
  
  public DataCameraSetFocusParam setOpticalPosScale(float paramFloat)
  {
    this.mOpticalPosScale = paramFloat;
    return this;
  }
  
  public DataCameraSetFocusParam setOpticalStepScale(float paramFloat)
  {
    this.mOpticalStepScale = paramFloat;
    return this;
  }
  
  public DataCameraSetFocusParam setOpticalStepZoomIn(boolean paramBoolean)
  {
    this.mOpticalStepZoomIn = paramBoolean;
    return this;
  }
  
  public DataCameraSetFocusParam setOpticalZoom(boolean paramBoolean)
  {
    this.mbOpticalZoom = paramBoolean;
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
  
  public static enum ZoomMode
  {
    private int data;
    
    static
    {
      POSITION = new ZoomMode("POSITION", 1, 1);
      ZoomMode localZoomMode = new ZoomMode("CONTINUOUS", 2, 2);
      CONTINUOUS = localZoomMode;
      $VALUES = new ZoomMode[] { STEP, POSITION, localZoomMode };
    }
    
    private ZoomMode(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static ZoomMode find(int paramInt)
    {
      ZoomMode localZoomMode = POSITION;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localZoomMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetFocusParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */