package dji.midware.data.model.P3;

import dji.logic.vision.DJITrajectoryHelper;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataAsync2Listener;

public class DataEyeGetPushTrajectory
  extends DataBase
  implements DJIDataAsync2Listener
{
  private static final int POLY_PARAM_LENGTH = 6;
  private static DataEyeGetPushTrajectory instance;
  
  public static DataEyeGetPushTrajectory getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeGetPushTrajectory();
      }
      DataEyeGetPushTrajectory localDataEyeGetPushTrajectory = instance;
      return localDataEyeGetPushTrajectory;
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
  
  public int getCount()
  {
    return 0;
  }
  
  public int getFragmentIndex()
  {
    return 0;
  }
  
  public PolynomialTrajectory[] getPolynomialTrajectory()
  {
    return null;
  }
  
  public int getSessionId()
  {
    return 0;
  }
  
  public boolean isLastFragment()
  {
    return false;
  }
  
  protected void setPushRecData(byte[] paramArrayOfByte)
  {
    super.setPushRecData(paramArrayOfByte);
    DJITrajectoryHelper.getInstance().updateTrajectory(this);
    start();
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static final class PolynomialTrajectory
  {
    public float[] mPolyXAxis;
    public float[] mPolyYAxis;
    public float[] mPolyZAxis;
    
    public PolynomialTrajectory()
    {
      this.mPolyXAxis = new float[6];
      this.mPolyYAxis = new float[6];
      this.mPolyZAxis = new float[6];
    }
    
    public PolynomialTrajectory(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
    {
      float[] arrayOfFloat = new float[6];
      this.mPolyXAxis = arrayOfFloat;
      this.mPolyYAxis = new float[6];
      this.mPolyZAxis = new float[6];
      if (paramArrayOfFloat1 != null) {
        System.arraycopy(paramArrayOfFloat1, 0, arrayOfFloat, 0, Math.min(paramArrayOfFloat1.length, arrayOfFloat.length));
      }
      if (paramArrayOfFloat2 != null)
      {
        paramArrayOfFloat1 = this.mPolyYAxis;
        System.arraycopy(paramArrayOfFloat2, 0, paramArrayOfFloat1, 0, Math.min(paramArrayOfFloat2.length, paramArrayOfFloat1.length));
      }
      if (paramArrayOfFloat3 != null)
      {
        paramArrayOfFloat1 = this.mPolyZAxis;
        System.arraycopy(paramArrayOfFloat3, 0, paramArrayOfFloat1, 0, Math.min(paramArrayOfFloat3.length, paramArrayOfFloat1.length));
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeGetPushTrajectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */