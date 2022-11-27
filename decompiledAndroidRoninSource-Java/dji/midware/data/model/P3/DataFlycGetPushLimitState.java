package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataFlycGetPushLimitState
  extends DataBase
{
  private static DataFlycGetPushLimitState instance;
  
  public static DataFlycGetPushLimitState getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetPushLimitState();
      }
      DataFlycGetPushLimitState localDataFlycGetPushLimitState = instance;
      return localDataFlycGetPushLimitState;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getActionState()
  {
    return 0;
  }
  
  public int getAreaState()
  {
    return 0;
  }
  
  public int getInnerRadius()
  {
    return 0;
  }
  
  public double getLatitude()
  {
    return 1.37188305E-315D;
  }
  
  public double getLongitude()
  {
    return 1.37188307E-315D;
  }
  
  public int getOuterRadius()
  {
    return 0;
  }
  
  public int getType()
  {
    return 0;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return true;
  }
  
  public boolean isEnable()
  {
    return false;
  }
  
  public static enum DJILimitsAreaStatus
  {
    private int data;
    
    static
    {
      NearLimit = new DJILimitsAreaStatus("NearLimit", 1, 1);
      InnerHeightLimit = new DJILimitsAreaStatus("InnerHeightLimit", 2, 2);
      InnerLimit = new DJILimitsAreaStatus("InnerLimit", 3, 3);
      DJILimitsAreaStatus localDJILimitsAreaStatus = new DJILimitsAreaStatus("OTHER", 4, 100);
      OTHER = localDJILimitsAreaStatus;
      $VALUES = new DJILimitsAreaStatus[] { None, NearLimit, InnerHeightLimit, InnerLimit, localDJILimitsAreaStatus };
    }
    
    private DJILimitsAreaStatus(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static DJILimitsAreaStatus find(int paramInt)
    {
      DJILimitsAreaStatus localDJILimitsAreaStatus = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localDJILimitsAreaStatus;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetPushLimitState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */