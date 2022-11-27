package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataRcGetPushFollowFocus2
  extends DataBase
{
  private static DataRcGetPushFollowFocus2 instance;
  
  public static DataRcGetPushFollowFocus2 getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcGetPushFollowFocus2();
      }
      DataRcGetPushFollowFocus2 localDataRcGetPushFollowFocus2 = instance;
      return localDataRcGetPushFollowFocus2;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public CtrlDirection getCtrlDirection()
  {
    return null;
  }
  
  public CtrlType getCtrlType()
  {
    return null;
  }
  
  public int getCurCtrlStatus()
  {
    return 0;
  }
  
  public int getCurrentValue()
  {
    return 0;
  }
  
  public int getHandWheelType()
  {
    return 0;
  }
  
  protected void setPushRecData(byte[] paramArrayOfByte)
  {
    setRecData(paramArrayOfByte);
    post();
  }
  
  public static enum CtrlDirection
  {
    private int data;
    
    static
    {
      CCW = new CtrlDirection("CCW", 1, 1);
      CtrlDirection localCtrlDirection = new CtrlDirection("OTHER", 2, 10);
      OTHER = localCtrlDirection;
      $VALUES = new CtrlDirection[] { CW, CCW, localCtrlDirection };
    }
    
    private CtrlDirection(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static CtrlDirection find(int paramInt)
    {
      CtrlDirection localCtrlDirection = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localCtrlDirection;
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
  
  public static enum CtrlType
  {
    private int data;
    
    static
    {
      FOCUS_LENGTH = new CtrlType("FOCUS_LENGTH", 2, 2);
      CtrlType localCtrlType = new CtrlType("OTHER", 3, 10);
      OTHER = localCtrlType;
      $VALUES = new CtrlType[] { APERTURE, FOCUS_POSITION, FOCUS_LENGTH, localCtrlType };
    }
    
    private CtrlType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static CtrlType find(int paramInt)
    {
      CtrlType localCtrlType = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localCtrlType;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcGetPushFollowFocus2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */