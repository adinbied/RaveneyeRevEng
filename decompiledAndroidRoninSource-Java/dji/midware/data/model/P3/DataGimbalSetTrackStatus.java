package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;
import java.util.ArrayList;
import java.util.List;

public class DataGimbalSetTrackStatus
  extends DataBase
  implements DJIDataSyncListener
{
  private static final int MAX_POINTS = 10;
  private static final String TAG = "DataGimbalSetTrackStatus";
  private static DataGimbalSetTrackStatus instance;
  private int mIsTripod;
  private int mRecordOrPreview;
  private List<RoadPoint> mRoadList = new ArrayList();
  private int mStartOrStop;
  
  public static DataGimbalSetTrackStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataGimbalSetTrackStatus();
      }
      DataGimbalSetTrackStatus localDataGimbalSetTrackStatus = instance;
      return localDataGimbalSetTrackStatus;
    }
    finally {}
  }
  
  public DataGimbalSetTrackStatus addRoadPoint(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    return null;
  }
  
  /* Error */
  public void clearPoint()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataGimbalSetTrackStatus setIsTripod(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public DataGimbalSetTrackStatus setRecordOrPreview(int paramInt)
  {
    this.mRecordOrPreview = paramInt;
    return this;
  }
  
  public DataGimbalSetTrackStatus setStartOrStop(int paramInt)
  {
    this.mStartOrStop = paramInt;
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
  
  private static class RoadPoint
  {
    float moveTime;
    float pitch;
    float roll;
    float stopTime;
    float yaw;
    
    public RoadPoint(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
    {
      this.yaw = paramFloat1;
      this.pitch = paramFloat2;
      this.roll = paramFloat3;
      this.moveTime = paramFloat4;
      this.stopTime = paramFloat5;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalSetTrackStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */