package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataEyeSetPushTrackingStatus
  extends DataBase
  implements DJIDataSyncListener
{
  private VisionPushTrackingLockObjectStatus mObjectStatus = VisionPushTrackingLockObjectStatus.UNLOCKED;
  private VisionPushTrackingRuningStatus mRuningStatus = VisionPushTrackingRuningStatus.OFF;
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataEyeSetPushTrackingStatus setVisionPushTrackingLockObjectStatus(VisionPushTrackingLockObjectStatus paramVisionPushTrackingLockObjectStatus)
  {
    this.mObjectStatus = paramVisionPushTrackingLockObjectStatus;
    return this;
  }
  
  public DataEyeSetPushTrackingStatus setVisionPushTrackingRuningStatus(VisionPushTrackingRuningStatus paramVisionPushTrackingRuningStatus)
  {
    this.mRuningStatus = paramVisionPushTrackingRuningStatus;
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
  
  public static enum VisionPushTrackingLockObjectStatus
  {
    private final int data;
    
    static
    {
      VisionPushTrackingLockObjectStatus localVisionPushTrackingLockObjectStatus = new VisionPushTrackingLockObjectStatus("LOCKED", 1, 1);
      LOCKED = localVisionPushTrackingLockObjectStatus;
      $VALUES = new VisionPushTrackingLockObjectStatus[] { UNLOCKED, localVisionPushTrackingLockObjectStatus };
    }
    
    private VisionPushTrackingLockObjectStatus(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static VisionPushTrackingLockObjectStatus find(int paramInt)
    {
      VisionPushTrackingLockObjectStatus localVisionPushTrackingLockObjectStatus1 = UNLOCKED;
      VisionPushTrackingLockObjectStatus[] arrayOfVisionPushTrackingLockObjectStatus = values();
      int j = arrayOfVisionPushTrackingLockObjectStatus.length;
      int i = 0;
      while (i < j)
      {
        VisionPushTrackingLockObjectStatus localVisionPushTrackingLockObjectStatus2 = arrayOfVisionPushTrackingLockObjectStatus[i];
        if (localVisionPushTrackingLockObjectStatus2._equals(paramInt)) {
          return localVisionPushTrackingLockObjectStatus2;
        }
        i += 1;
      }
      return localVisionPushTrackingLockObjectStatus1;
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
  
  public static enum VisionPushTrackingRuningStatus
  {
    private final int data;
    
    static
    {
      VisionPushTrackingRuningStatus localVisionPushTrackingRuningStatus = new VisionPushTrackingRuningStatus("ON", 1, 1);
      ON = localVisionPushTrackingRuningStatus;
      $VALUES = new VisionPushTrackingRuningStatus[] { OFF, localVisionPushTrackingRuningStatus };
    }
    
    private VisionPushTrackingRuningStatus(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static VisionPushTrackingRuningStatus find(int paramInt)
    {
      VisionPushTrackingRuningStatus localVisionPushTrackingRuningStatus1 = OFF;
      VisionPushTrackingRuningStatus[] arrayOfVisionPushTrackingRuningStatus = values();
      int j = arrayOfVisionPushTrackingRuningStatus.length;
      int i = 0;
      while (i < j)
      {
        VisionPushTrackingRuningStatus localVisionPushTrackingRuningStatus2 = arrayOfVisionPushTrackingRuningStatus[i];
        if (localVisionPushTrackingRuningStatus2._equals(paramInt)) {
          return localVisionPushTrackingRuningStatus2;
        }
        i += 1;
      }
      return localVisionPushTrackingRuningStatus1;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeSetPushTrackingStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */