package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataWifiGetPushElecSignal
  extends DataBase
{
  private static DataWifiGetPushElecSignal mInstance;
  
  public static DataWifiGetPushElecSignal getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DataWifiGetPushElecSignal();
      }
      DataWifiGetPushElecSignal localDataWifiGetPushElecSignal = mInstance;
      return localDataWifiGetPushElecSignal;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public SIGNAL_STATUS getSignalStatus()
  {
    return null;
  }
  
  protected void setPushRecData(byte[] paramArrayOfByte)
  {
    super.setPushRecData(paramArrayOfByte);
  }
  
  public static enum SIGNAL_STATUS
  {
    private int data;
    
    static
    {
      SIGNAL_STATUS localSIGNAL_STATUS = new SIGNAL_STATUS("OTHER", 3, 100);
      OTHER = localSIGNAL_STATUS;
      $VALUES = new SIGNAL_STATUS[] { Good, Medium, Poor, localSIGNAL_STATUS };
    }
    
    private SIGNAL_STATUS(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static SIGNAL_STATUS find(int paramInt)
    {
      SIGNAL_STATUS localSIGNAL_STATUS = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localSIGNAL_STATUS;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataWifiGetPushElecSignal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */