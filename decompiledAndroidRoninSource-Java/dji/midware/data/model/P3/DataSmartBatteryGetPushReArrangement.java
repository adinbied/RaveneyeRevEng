package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataSmartBatteryGetPushReArrangement
  extends DataBase
{
  private static DataSmartBatteryGetPushReArrangement mInstance;
  
  public static DataSmartBatteryGetPushReArrangement getInstance()
  {
    if (mInstance == null) {
      mInstance = new DataSmartBatteryGetPushReArrangement();
    }
    return mInstance;
  }
  
  protected void doPack() {}
  
  public ReArrangement[] getReArrangement()
  {
    return null;
  }
  
  public static class ReArrangement
  {
    public int dstIndex;
    public DataSmartBatteryGetPushReArrangement.ReArrangementOption option;
    public int srcIndex;
  }
  
  public static enum ReArrangementOption
  {
    static
    {
      ReArrangementOption localReArrangementOption = new ReArrangementOption("Move", 3);
      Move = localReArrangementOption;
      $VALUES = new ReArrangementOption[] { None, PlugOut, Switch, localReArrangementOption };
    }
    
    private ReArrangementOption() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSmartBatteryGetPushReArrangement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */