package dji.midware.data.model.P3;

import dji.midware.data.config.P3.CmdIdGimbal.CmdIdType;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataGimbalGetPushExternalStatus
  extends DataBase
  implements DJIDataSyncListener
{
  private CmdIdGimbal.CmdIdType mCmdId;
  private int mPanoCurPictures;
  private int mPanoStatus;
  private int mPanoTotalPictures;
  private RequestType mRequestType = RequestType.StartContinuePush;
  private boolean mSuccess;
  private int mTimelapseCurRoadPercent;
  private int mTimelapseFinishedPoints;
  private int mTimelapseRecordingOrPreview;
  private int mTimelapseStatus;
  private int mTimelapseTotalRoadPercent;
  private int mTrackCurPercent;
  private int mTrackFinishedPoints;
  private int mTrackStatus;
  private int mTrackTotalPercent;
  
  public static DataGimbalGetPushExternalStatus getInstance()
  {
    return InstanceHolder.sINSTANCE;
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public CmdIdGimbal.CmdIdType getCmdId()
  {
    return this.mCmdId;
  }
  
  public int getPanoCurPicture()
  {
    return this.mPanoCurPictures;
  }
  
  public int getPanoStatus()
  {
    return this.mPanoStatus;
  }
  
  public int getPanoTotalPictures()
  {
    return this.mPanoTotalPictures;
  }
  
  public int getTimelapseCurRoadPercent()
  {
    return this.mTimelapseCurRoadPercent;
  }
  
  public int getTimelapseFinishedPoints()
  {
    return this.mTimelapseFinishedPoints;
  }
  
  public int getTimelapseRecordingOrPreview()
  {
    return this.mTimelapseRecordingOrPreview;
  }
  
  public int getTimelapseStatus()
  {
    return this.mTimelapseStatus;
  }
  
  public int getTimelapseTotalRoadPercent()
  {
    return this.mTimelapseTotalRoadPercent;
  }
  
  public int getTrackCurPercent()
  {
    return this.mTrackCurPercent;
  }
  
  public int getTrackFinishedPoints()
  {
    return this.mTrackFinishedPoints;
  }
  
  public int getTrackStatus()
  {
    return this.mTrackStatus;
  }
  
  public int getTrackTotalPercent()
  {
    return this.mTrackTotalPercent;
  }
  
  public boolean isSuccess()
  {
    return this.mSuccess;
  }
  
  public DataGimbalGetPushExternalStatus setCmdId(CmdIdGimbal.CmdIdType paramCmdIdType)
  {
    this.mCmdId = paramCmdIdType;
    return this;
  }
  
  /* Error */
  protected void setPushRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataGimbalGetPushExternalStatus setRequestType(RequestType paramRequestType)
  {
    this.mRequestType = paramRequestType;
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
  
  private static class InstanceHolder
  {
    private static final DataGimbalGetPushExternalStatus sINSTANCE = new DataGimbalGetPushExternalStatus(null);
  }
  
  public static enum RequestType
  {
    int data;
    
    static
    {
      RequestType localRequestType = new RequestType("RequestSinglePush", 2, 2);
      RequestSinglePush = localRequestType;
      $VALUES = new RequestType[] { StartContinuePush, StopContinuePush, localRequestType };
    }
    
    private RequestType(int paramInt)
    {
      this.data = paramInt;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalGetPushExternalStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */