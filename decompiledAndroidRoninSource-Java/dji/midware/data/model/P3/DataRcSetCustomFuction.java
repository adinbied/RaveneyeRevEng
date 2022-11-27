package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRcSetCustomFuction
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcSetCustomFuction instance;
  private int c1value;
  private int c2value;
  
  public static DataRcSetCustomFuction getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcSetCustomFuction();
      }
      DataRcSetCustomFuction localDataRcSetCustomFuction = instance;
      return localDataRcSetCustomFuction;
    }
    finally {}
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataRcSetCustomFuction setC1(int paramInt)
  {
    this.c1value = paramInt;
    return this;
  }
  
  public DataRcSetCustomFuction setC2(int paramInt)
  {
    this.c2value = paramInt;
    return this;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum DJICustomType
  {
    private int data;
    
    static
    {
      MapSwitch = new DJICustomType("MapSwitch", 3, 3);
      ClearRote = new DJICustomType("ClearRote", 4, 4);
      Bettery = new DJICustomType("Bettery", 5, 5);
      GimbalDirec = new DJICustomType("GimbalDirec", 6, 6);
      CenterMetering = new DJICustomType("CenterMetering", 7, 7);
      AeLock = new DJICustomType("AeLock", 8, 8);
      ForeArm = new DJICustomType("ForeArm", 9, 9);
      Vision1 = new DJICustomType("Vision1", 10, 10);
      Vision2 = new DJICustomType("Vision2", 11, 11);
      GimbalRecenter = new DJICustomType("GimbalRecenter", 12, 12);
      LiveViewExpand = new DJICustomType("LiveViewExpand", 13, 13);
      QuickCircle = new DJICustomType("QuickCircle", 14, 14);
      Navigation = new DJICustomType("Navigation", 15, 15);
      PlayBack = new DJICustomType("PlayBack", 16, 16);
      CenterFocus = new DJICustomType("CenterFocus", 17, 17);
      IndexShutterISOSwitch = new DJICustomType("IndexShutterISOSwitch", 18, 20);
      FixWing = new DJICustomType("FixWing", 19, 21);
      OneKeyTakeOffLanding = new DJICustomType("OneKeyTakeOffLanding", 20, 22);
      EnterGSMode = new DJICustomType("EnterGSMode", 21, 64);
      ExitGSMode = new DJICustomType("ExitGSMode", 22, 65);
      ForceMapSwitch = new DJICustomType("ForceMapSwitch", 23, 66);
      ExitFixWing = new DJICustomType("ExitFixWing", 24, 67);
      DJICustomType localDJICustomType = new DJICustomType("OTHER", 25, 119);
      OTHER = localDJICustomType;
      $VALUES = new DJICustomType[] { CameraSetting, GimbalCenter, SwitchGimbalMode, MapSwitch, ClearRote, Bettery, GimbalDirec, CenterMetering, AeLock, ForeArm, Vision1, Vision2, GimbalRecenter, LiveViewExpand, QuickCircle, Navigation, PlayBack, CenterFocus, IndexShutterISOSwitch, FixWing, OneKeyTakeOffLanding, EnterGSMode, ExitGSMode, ForceMapSwitch, ExitFixWing, localDJICustomType };
    }
    
    private DJICustomType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static DJICustomType find(int paramInt)
    {
      DJICustomType localDJICustomType = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localDJICustomType;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcSetCustomFuction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */