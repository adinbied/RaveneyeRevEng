package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataOsdGetPushWirelessState
  extends DataBase
{
  private static DataOsdGetPushWirelessState instance;
  
  public static DataOsdGetPushWirelessState getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdGetPushWirelessState();
      }
      DataOsdGetPushWirelessState localDataOsdGetPushWirelessState = instance;
      return localDataOsdGetPushWirelessState;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public SdrWirelessState getEventCode()
  {
    return null;
  }
  
  public String getInternalEvent()
  {
    return null;
  }
  
  public static enum SdrWirelessState
  {
    private int mValue;
    
    static
    {
      RC_DISTURBANCE = new SdrWirelessState("RC_DISTURBANCE", 2, 2);
      LOW_SIGNAL_POWER = new SdrWirelessState("LOW_SIGNAL_POWER", 3, 3);
      CUSTOM_SIGNAL_DISTURBANCE = new SdrWirelessState("CUSTOM_SIGNAL_DISTURBANCE", 4, 4);
      RC_TO_GLASS_DIST = new SdrWirelessState("RC_TO_GLASS_DIST", 5, 5);
      UAV_HAL_RESTART = new SdrWirelessState("UAV_HAL_RESTART", 6, 6);
      GLASS_DIST_RC_ANTENNA = new SdrWirelessState("GLASS_DIST_RC_ANTENNA", 7, 7);
      DISCONNECT_RC_DISTURB = new SdrWirelessState("DISCONNECT_RC_DISTURB", 8, 8);
      DISCONNECT_UAV_DISTURB = new SdrWirelessState("DISCONNECT_UAV_DISTURB", 9, 9);
      DISCONNECT_WEEK_SIGNAL = new SdrWirelessState("DISCONNECT_WEEK_SIGNAL", 10, 10);
      INTERNAL_EVENT = new SdrWirelessState("INTERNAL_EVENT", 11, 255);
      SdrWirelessState localSdrWirelessState = new SdrWirelessState("NONE", 12, 256);
      NONE = localSdrWirelessState;
      $VALUES = new SdrWirelessState[] { STRONG_DISTURBANCE, VIDEO_DISTURBANCE, RC_DISTURBANCE, LOW_SIGNAL_POWER, CUSTOM_SIGNAL_DISTURBANCE, RC_TO_GLASS_DIST, UAV_HAL_RESTART, GLASS_DIST_RC_ANTENNA, DISCONNECT_RC_DISTURB, DISCONNECT_UAV_DISTURB, DISCONNECT_WEEK_SIGNAL, INTERNAL_EVENT, localSdrWirelessState };
    }
    
    private SdrWirelessState(int paramInt)
    {
      this.mValue = paramInt;
    }
    
    public static SdrWirelessState find(int paramInt)
    {
      SdrWirelessState[] arrayOfSdrWirelessState = values();
      int j = arrayOfSdrWirelessState.length;
      int i = 0;
      while (i != j)
      {
        if (paramInt == arrayOfSdrWirelessState[i].value()) {
          return arrayOfSdrWirelessState[i];
        }
        i += 1;
      }
      return NONE;
    }
    
    public int value()
    {
      return this.mValue;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdGetPushWirelessState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */