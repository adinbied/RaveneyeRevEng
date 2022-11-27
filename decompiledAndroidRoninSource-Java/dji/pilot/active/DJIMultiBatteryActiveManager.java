package dji.pilot.active;

public class DJIMultiBatteryActiveManager
{
  private static DJIMultiBatteryActiveManager instance;
  private static boolean isInit;
  private boolean[] isBatteryRecorded = { 0, 0 };
  private int mCurActiveBattery = 0;
  private String mCurActiveSn = "";
  private boolean mOneBatteryActiving = false;
  
  public static DJIMultiBatteryActiveManager getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DJIMultiBatteryActiveManager();
      }
      if (!isInit) {
        instance.init();
      }
      DJIMultiBatteryActiveManager localDJIMultiBatteryActiveManager = instance;
      return localDJIMultiBatteryActiveManager;
    }
    finally {}
  }
  
  public int getCurActiveBattery()
  {
    return this.mCurActiveBattery;
  }
  
  public String getCurActiveSn()
  {
    return this.mCurActiveSn;
  }
  
  /* Error */
  public void init()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isBatteryRecordedByIndex(int paramInt)
  {
    return false;
  }
  
  public boolean isOneBatteryActiving()
  {
    return this.mOneBatteryActiving;
  }
  
  public void resetState()
  {
    isInit = false;
  }
  
  /* Error */
  public void setBatteryRecordedByIndex(int arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void setCurActiveSn(String paramString)
  {
    this.mCurActiveSn = paramString;
  }
  
  public void setOneBatteryActiving(boolean paramBoolean)
  {
    this.mOneBatteryActiving = paramBoolean;
  }
  
  public static enum ActivedOneofMultiBattery
  {
    static
    {
      ActivedOneofMultiBattery localActivedOneofMultiBattery = new ActivedOneofMultiBattery("TRUE", 0);
      TRUE = localActivedOneofMultiBattery;
      $VALUES = new ActivedOneofMultiBattery[] { localActivedOneofMultiBattery };
    }
    
    private ActivedOneofMultiBattery() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilot\active\DJIMultiBatteryActiveManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */