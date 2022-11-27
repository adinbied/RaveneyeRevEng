package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataOsdGetPushChannalStatus
  extends DataBase
{
  private static DataOsdGetPushChannalStatus instance;
  
  public static DataOsdGetPushChannalStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdGetPushChannalStatus();
      }
      DataOsdGetPushChannalStatus localDataOsdGetPushChannalStatus = instance;
      return localDataOsdGetPushChannalStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public CHANNEL_STATUS getChannelStatus()
  {
    return null;
  }
  
  protected void setPushRecData(byte[] paramArrayOfByte)
  {
    super.setPushRecData(paramArrayOfByte);
  }
  
  public static enum CHANNEL_STATUS
  {
    private int data;
    
    static
    {
      CHANNEL_STATUS localCHANNEL_STATUS = new CHANNEL_STATUS("OTHER", 4, 100);
      OTHER = localCHANNEL_STATUS;
      $VALUES = new CHANNEL_STATUS[] { Excellent, Good, Medium, Poor, localCHANNEL_STATUS };
    }
    
    private CHANNEL_STATUS(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static CHANNEL_STATUS find(int paramInt)
    {
      CHANNEL_STATUS localCHANNEL_STATUS = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localCHANNEL_STATUS;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdGetPushChannalStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */