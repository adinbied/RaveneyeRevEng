package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataEyeGetPushFlatCheck
  extends DataBase
{
  private static DataEyeGetPushFlatCheck instance;
  
  public static DataEyeGetPushFlatCheck getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeGetPushFlatCheck();
      }
      DataEyeGetPushFlatCheck localDataEyeGetPushFlatCheck = instance;
      return localDataEyeGetPushFlatCheck;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public FlatStatus getFlatStatus()
  {
    return null;
  }
  
  public int getTinkCount()
  {
    return 0;
  }
  
  public static enum FlatStatus
  {
    private static FlatStatus[] sValues = null;
    private final int data;
    
    static
    {
      Calculating = new FlatStatus("Calculating", 1, 1);
      SafeForLanding = new FlatStatus("SafeForLanding", 2, 2);
      UnsafeToHover = new FlatStatus("UnsafeToHover", 3, 3);
      WaterSurfaceToHover = new FlatStatus("WaterSurfaceToHover", 4, 4);
      EnterCheckArea = new FlatStatus("EnterCheckArea", 5, 10);
      UnderExposure = new FlatStatus("UnderExposure", 6, -1);
      DriftMuchWhenLanding = new FlatStatus("DriftMuchWhenLanding", 7, -2);
      MoveStickWhenCalculating = new FlatStatus("MoveStickWhenCalculating", 8, -3);
      TooLow = new FlatStatus("TooLow", 9, -4);
      TooHigh = new FlatStatus("TooHigh", 10, -5);
      BadResult = new FlatStatus("BadResult", 11, -10);
      FlatStatus localFlatStatus = new FlatStatus("OTHER", 12, 100);
      OTHER = localFlatStatus;
      $VALUES = new FlatStatus[] { None, Calculating, SafeForLanding, UnsafeToHover, WaterSurfaceToHover, EnterCheckArea, UnderExposure, DriftMuchWhenLanding, MoveStickWhenCalculating, TooLow, TooHigh, BadResult, localFlatStatus };
    }
    
    private FlatStatus(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static FlatStatus find(int paramInt)
    {
      if (sValues == null) {
        sValues = values();
      }
      FlatStatus localFlatStatus1 = None;
      FlatStatus[] arrayOfFlatStatus = sValues;
      int j = arrayOfFlatStatus.length;
      int i = 0;
      while (i < j)
      {
        FlatStatus localFlatStatus2 = arrayOfFlatStatus[i];
        if (localFlatStatus2._equals(paramInt)) {
          return localFlatStatus2;
        }
        i += 1;
      }
      return localFlatStatus1;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeGetPushFlatCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */