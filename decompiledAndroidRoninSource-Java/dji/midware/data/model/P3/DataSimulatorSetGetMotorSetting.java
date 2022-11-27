package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataSimulatorSetGetMotorSetting
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataSimulatorSetGetMotorSetting instance;
  private float[] mCl;
  private float[] mCq;
  private int mFlag;
  private int[] mIMax;
  private int[] mIMin;
  private float[] mInertiaMotor;
  private float[] mInertiaProp;
  private int[] mKV;
  private int mMarkBits;
  private int[] mMotorTiltAngle;
  private boolean mReqFlag = false;
  private int[] mRm;
  private int[] mVoltMax;
  
  public static DataSimulatorSetGetMotorSetting getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataSimulatorSetGetMotorSetting();
      }
      return null;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public float[] getmCl()
  {
    return this.mCl;
  }
  
  public float[] getmCq()
  {
    return this.mCq;
  }
  
  public int[] getmIMax()
  {
    return this.mIMax;
  }
  
  public int[] getmIMin()
  {
    return this.mIMin;
  }
  
  public float[] getmInertiaMotor()
  {
    return this.mInertiaMotor;
  }
  
  public float[] getmInertiaProp()
  {
    return this.mInertiaProp;
  }
  
  public int[] getmKV()
  {
    return this.mKV;
  }
  
  public int[] getmMotorTiltAngle()
  {
    return this.mMotorTiltAngle;
  }
  
  public int[] getmRm()
  {
    return this.mRm;
  }
  
  public int[] getmVoltMax()
  {
    return this.mVoltMax;
  }
  
  public DataSimulatorSetGetMotorSetting setAckFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mFlag |= 0x1;
      return this;
    }
    this.mFlag |= 0x0;
    return this;
  }
  
  public DataSimulatorSetGetMotorSetting setMarkBits(int paramInt)
  {
    this.mMarkBits = paramInt;
    return this;
  }
  
  public DataSimulatorSetGetMotorSetting setReqFlag(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mFlag |= 0x2;
    } else {
      this.mFlag |= 0x0;
    }
    this.mReqFlag = true;
    return this;
  }
  
  public void setmCl(float[] paramArrayOfFloat)
  {
    this.mCl = paramArrayOfFloat;
  }
  
  public void setmCq(float[] paramArrayOfFloat)
  {
    this.mCq = paramArrayOfFloat;
  }
  
  public void setmIMax(int[] paramArrayOfInt)
  {
    this.mIMax = paramArrayOfInt;
  }
  
  public void setmIMin(int[] paramArrayOfInt)
  {
    this.mIMin = paramArrayOfInt;
  }
  
  public void setmInertiaMotor(float[] paramArrayOfFloat)
  {
    this.mInertiaMotor = paramArrayOfFloat;
  }
  
  public void setmInertiaProp(float[] paramArrayOfFloat)
  {
    this.mInertiaProp = paramArrayOfFloat;
  }
  
  public void setmKV(int[] paramArrayOfInt)
  {
    this.mKV = paramArrayOfInt;
  }
  
  public void setmMotorTiltAngle(int[] paramArrayOfInt)
  {
    this.mMotorTiltAngle = paramArrayOfInt;
  }
  
  public void setmRm(int[] paramArrayOfInt)
  {
    this.mRm = paramArrayOfInt;
  }
  
  public void setmVoltMax(int[] paramArrayOfInt)
  {
    this.mVoltMax = paramArrayOfInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSimulatorSetGetMotorSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */