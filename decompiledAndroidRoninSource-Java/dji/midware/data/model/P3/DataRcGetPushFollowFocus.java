package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataRcGetPushFollowFocus
  extends DataBase
{
  private static DataRcGetPushFollowFocus instance;
  
  public static DataRcGetPushFollowFocus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcGetPushFollowFocus();
      }
      DataRcGetPushFollowFocus localDataRcGetPushFollowFocus = instance;
      return localDataRcGetPushFollowFocus;
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
      CtrlType localCtrlType = new CtrlType("OTHER", 2, 10);
      OTHER = localCtrlType;
      $VALUES = new CtrlType[] { APERTURE, FOCAL_LENGTH, localCtrlType };
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcGetPushFollowFocus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */