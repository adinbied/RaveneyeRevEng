package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataOsdGetPushSDRNfParams
  extends DataBase
{
  private static DataOsdGetPushSDRNfParams instance;
  
  public static DataOsdGetPushSDRNfParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdGetPushSDRNfParams();
      }
      DataOsdGetPushSDRNfParams localDataOsdGetPushSDRNfParams = instance;
      return localDataOsdGetPushSDRNfParams;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int get1KmOffset()
  {
    return 0;
  }
  
  public DisLossEvent getDisLossInd()
  {
    return null;
  }
  
  public int getDlPwrAccu()
  {
    return 0;
  }
  
  public int getMaxNf10M()
  {
    return 0;
  }
  
  public int getMaxNf20M()
  {
    return 0;
  }
  
  public int getMinNf10M()
  {
    return 0;
  }
  
  public int getMinNf20M()
  {
    return 0;
  }
  
  public int getPathLossOffset()
  {
    return 0;
  }
  
  public int getRcLinkOffset()
  {
    return 0;
  }
  
  public int getSigBarInd()
  {
    return 0;
  }
  
  public int getTxPowerOffset()
  {
    return 0;
  }
  
  public static enum DisLossEvent
  {
    private int value;
    
    static
    {
      GROUND_INTERFERED = new DisLossEvent("GROUND_INTERFERED", 1, 1);
      UAV_INTERFERED = new DisLossEvent("UAV_INTERFERED", 2, 2);
      DisLossEvent localDisLossEvent = new DisLossEvent("SIGNAL_BLOCK", 3, 3);
      SIGNAL_BLOCK = localDisLossEvent;
      $VALUES = new DisLossEvent[] { NONE, GROUND_INTERFERED, UAV_INTERFERED, localDisLossEvent };
    }
    
    private DisLossEvent(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static DisLossEvent find(int paramInt)
    {
      DisLossEvent localDisLossEvent = NONE;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localDisLossEvent;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public int value()
    {
      return this.value;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdGetPushSDRNfParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */