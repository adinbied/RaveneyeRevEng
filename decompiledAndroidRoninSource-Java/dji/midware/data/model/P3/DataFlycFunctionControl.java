package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycFunctionControl
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycFunctionControl instance;
  private FLYC_COMMAND type;
  
  public static DataFlycFunctionControl getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycFunctionControl();
      }
      DataFlycFunctionControl localDataFlycFunctionControl = instance;
      return localDataFlycFunctionControl;
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
  
  public DataFlycFunctionControl setCommand(FLYC_COMMAND paramFLYC_COMMAND)
  {
    this.type = paramFLYC_COMMAND;
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
  
  public static enum FLYC_COMMAND
  {
    private int data;
    
    static
    {
      HOMEPOINT_HOT = new FLYC_COMMAND("HOMEPOINT_HOT", 3, 4);
      HOMEPOINT_LOC = new FLYC_COMMAND("HOMEPOINT_LOC", 4, 5);
      GOHOME = new FLYC_COMMAND("GOHOME", 5, 6);
      START_MOTOR = new FLYC_COMMAND("START_MOTOR", 6, 7);
      STOP_MOTOR = new FLYC_COMMAND("STOP_MOTOR", 7, 8);
      Calibration = new FLYC_COMMAND("Calibration", 8, 9);
      DeformProtecClose = new FLYC_COMMAND("DeformProtecClose", 9, 10);
      DeformProtecOpen = new FLYC_COMMAND("DeformProtecOpen", 10, 11);
      DropGohome = new FLYC_COMMAND("DropGohome", 11, 12);
      DropTakeOff = new FLYC_COMMAND("DropTakeOff", 12, 13);
      DropLanding = new FLYC_COMMAND("DropLanding", 13, 14);
      DynamicHomePointOpen = new FLYC_COMMAND("DynamicHomePointOpen", 14, 15);
      DynamicHomePointClose = new FLYC_COMMAND("DynamicHomePointClose", 15, 16);
      FollowFunctioonOpen = new FLYC_COMMAND("FollowFunctioonOpen", 16, 17);
      FollowFunctionClose = new FLYC_COMMAND("FollowFunctionClose", 17, 18);
      IOCOpen = new FLYC_COMMAND("IOCOpen", 18, 19);
      IOCClose = new FLYC_COMMAND("IOCClose", 19, 20);
      DropCalibration = new FLYC_COMMAND("DropCalibration", 20, 21);
      PackMode = new FLYC_COMMAND("PackMode", 21, 22);
      UnPackMode = new FLYC_COMMAND("UnPackMode", 22, 23);
      EnterManaualMode = new FLYC_COMMAND("EnterManaualMode", 23, 24);
      StopDeform = new FLYC_COMMAND("StopDeform", 24, 25);
      DownDeform = new FLYC_COMMAND("DownDeform", 25, 28);
      UpDeform = new FLYC_COMMAND("UpDeform", 26, 29);
      ForceLanding = new FLYC_COMMAND("ForceLanding", 27, 30);
      ForceLanding2 = new FLYC_COMMAND("ForceLanding2", 28, 31);
      PRECISION_TAKE_OFF = new FLYC_COMMAND("PRECISION_TAKE_OFF", 29, 34);
      FLYC_COMMAND localFLYC_COMMAND = new FLYC_COMMAND("OTHER", 30, 100);
      OTHER = localFLYC_COMMAND;
      $VALUES = new FLYC_COMMAND[] { AUTO_FLY, AUTO_LANDING, HOMEPOINT_NOW, HOMEPOINT_HOT, HOMEPOINT_LOC, GOHOME, START_MOTOR, STOP_MOTOR, Calibration, DeformProtecClose, DeformProtecOpen, DropGohome, DropTakeOff, DropLanding, DynamicHomePointOpen, DynamicHomePointClose, FollowFunctioonOpen, FollowFunctionClose, IOCOpen, IOCClose, DropCalibration, PackMode, UnPackMode, EnterManaualMode, StopDeform, DownDeform, UpDeform, ForceLanding, ForceLanding2, PRECISION_TAKE_OFF, localFLYC_COMMAND };
    }
    
    private FLYC_COMMAND(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static FLYC_COMMAND find(int paramInt)
    {
      FLYC_COMMAND localFLYC_COMMAND = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localFLYC_COMMAND;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycFunctionControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */