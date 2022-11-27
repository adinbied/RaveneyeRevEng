package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetRawVideoFormat
  extends DataBase
  implements DJIDataSyncListener
{
  private int FOVType = -1;
  private int playSpeedType;
  private int playSpeedValue;
  private DataCameraGetPushRawParams.RawMode rawMode = DataCameraGetPushRawParams.RawMode.Unknow;
  private int rawVideoFrameRate = Integer.MAX_VALUE;
  private int rawVideoResolution = Integer.MAX_VALUE;
  private int secondVideoResolution;
  private int secondVideoSetting;
  private int videoFrameRate = -1;
  private int videoResolution = -1;
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataCameraSetRawVideoFormat setFOV(int paramInt)
  {
    this.FOVType = paramInt;
    return this;
  }
  
  public DataCameraSetRawVideoFormat setRawMode(int paramInt)
  {
    this.rawMode = DataCameraGetPushRawParams.RawMode.find(paramInt);
    return this;
  }
  
  public DataCameraSetRawVideoFormat setRawVideoFrameRate(int paramInt)
  {
    this.rawVideoFrameRate = paramInt;
    return this;
  }
  
  public DataCameraSetRawVideoFormat setRawVideoResolution(int paramInt)
  {
    this.rawVideoResolution = paramInt;
    return this;
  }
  
  public DataCameraSetRawVideoFormat setVideoFrameRate(int paramInt)
  {
    this.videoFrameRate = paramInt;
    return this;
  }
  
  public DataCameraSetRawVideoFormat setVideoResolution(int paramInt)
  {
    this.videoResolution = paramInt;
    return this;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetRawVideoFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */