package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataEyeGetPushFrontAvoidance
  extends DataBase
{
  private static DataEyeGetPushFrontAvoidance instance;
  private int[] mCacheData = null;
  private int[] mCacheLevels = null;
  
  public DataEyeGetPushFrontAvoidance(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public static DataEyeGetPushFrontAvoidance getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeGetPushFrontAvoidance(true);
      }
      DataEyeGetPushFrontAvoidance localDataEyeGetPushFrontAvoidance = instance;
      return localDataEyeGetPushFrontAvoidance;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getObserveCount()
  {
    return 0;
  }
  
  public int[] getObserveLevels()
  {
    return null;
  }
  
  public int[] getObserveValues()
  {
    return null;
  }
  
  public SensorType getSensorType()
  {
    return null;
  }
  
  protected boolean isWantPush()
  {
    return super.isWantPush();
  }
  
  /* Error */
  protected void setPushRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum SensorType
  {
    private final int data;
    
    static
    {
      Back = new SensorType("Back", 1, 1);
      Right = new SensorType("Right", 2, 2);
      Left = new SensorType("Left", 3, 3);
      Top = new SensorType("Top", 4, 4);
      Bottom = new SensorType("Bottom", 5, 5);
      SensorType localSensorType = new SensorType("OTHER", 6, 100);
      OTHER = localSensorType;
      $VALUES = new SensorType[] { Front, Back, Right, Left, Top, Bottom, localSensorType };
    }
    
    private SensorType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static SensorType find(int paramInt)
    {
      SensorType localSensorType1 = Front;
      SensorType[] arrayOfSensorType = values();
      int j = arrayOfSensorType.length;
      int i = 0;
      while (i < j)
      {
        SensorType localSensorType2 = arrayOfSensorType[i];
        if (localSensorType2._equals(paramInt)) {
          return localSensorType2;
        }
        i += 1;
      }
      return localSensorType1;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeGetPushFrontAvoidance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */