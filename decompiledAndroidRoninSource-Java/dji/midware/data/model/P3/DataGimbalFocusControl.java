package dji.midware.data.model.P3;

import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataGimbalFocusControl
  extends DataBase
  implements DJIDataSyncListener
{
  private static final int FOCUS_MOTOR_SENDER_ID_DUAL_MODE = 5;
  private static final String TAG = "DataGimbalFocusControl";
  private static final int ZOOM_MOTOR_SENDER_ID_DUAL_MODE = 6;
  private CaliCommand mCaliCommand = CaliCommand.NONE;
  private int mCaliStatus = 0;
  private ControlMethod mControlMethod = ControlMethod.SPEED_CONTROL;
  private ControlType mControlType = ControlType.FOCUS;
  private int mCreatePositionEnd;
  private int mCreatePositionStart;
  private int mCreateProgress;
  private CreateSetCommand mCreateSetCommand = CreateSetCommand.DEFAULT;
  private int mFocusMotorPosition = 0;
  private int mFocusPosition = 0;
  private int mFocusSpeed = 0;
  private boolean mHasDualMotor;
  private int mMaxPosition = 0;
  private int mMinPosition = 0;
  private int mReceiverId = 0;
  private DeviceType mReceiverType = DeviceType.GIMBAL;
  private int mTofStatus = 0;
  
  public DataGimbalFocusControl()
  {
    this.isNeedPushLosed = true;
    this.delayPushLoseTime = 3000;
    setPushLose(5);
    setPushLose(6);
  }
  
  public static DataGimbalFocusControl getInstance()
  {
    return SingletonHolder.mInstance;
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getCaliStatus()
  {
    return this.mCaliStatus;
  }
  
  public int getCreatePositionEnd()
  {
    return this.mCreatePositionEnd;
  }
  
  public int getCreatePositionStart()
  {
    return this.mCreatePositionStart;
  }
  
  public int getCreateProgress()
  {
    return this.mCreateProgress;
  }
  
  public int getFocusMotorPosition()
  {
    return this.mFocusMotorPosition;
  }
  
  public int getMaxPosition()
  {
    return this.mMaxPosition;
  }
  
  public int getMinPosition()
  {
    return this.mMinPosition;
  }
  
  public boolean getMotorConnected()
  {
    return this.isPushLosed ^ true;
  }
  
  public int getTofStatus()
  {
    return this.mTofStatus;
  }
  
  public DataGimbalFocusControl setCaliCommand(CaliCommand paramCaliCommand)
  {
    this.mCaliCommand = paramCaliCommand;
    return this;
  }
  
  public DataGimbalFocusControl setControlMethod(ControlMethod paramControlMethod)
  {
    this.mControlMethod = paramControlMethod;
    return this;
  }
  
  public DataGimbalFocusControl setControlType(ControlType paramControlType)
  {
    this.mControlType = paramControlType;
    return this;
  }
  
  public DataGimbalFocusControl setCreateSetCommand(CreateSetCommand paramCreateSetCommand)
  {
    this.mCreateSetCommand = paramCreateSetCommand;
    return this;
  }
  
  public DataGimbalFocusControl setFocusMotorControl(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mReceiverType = DeviceType.BROADCAST;
      int i;
      if (this.mHasDualMotor) {
        i = 5;
      } else {
        i = getSenderId();
      }
      this.mReceiverId = i;
      return this;
    }
    this.mReceiverType = DeviceType.GIMBAL;
    this.mReceiverId = 0;
    return this;
  }
  
  public DataGimbalFocusControl setFocusPosition(int paramInt)
  {
    this.mFocusPosition = paramInt;
    return this;
  }
  
  public DataGimbalFocusControl setFocusSpeed(int paramInt)
  {
    this.mFocusSpeed = paramInt;
    return this;
  }
  
  /* Error */
  protected void setPushRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum CaliCommand
  {
    private int data;
    
    static
    {
      START_LENS = new CaliCommand("START_LENS", 3, 3);
      SET_MAX_POSITION = new CaliCommand("SET_MAX_POSITION", 4, 4);
      SET_MIN_POSITION = new CaliCommand("SET_MIN_POSITION", 5, 5);
      CaliCommand localCaliCommand = new CaliCommand("STOP", 6, 6);
      STOP = localCaliCommand;
      $VALUES = new CaliCommand[] { NONE, START_AUTO, START_MANUAL, START_LENS, SET_MAX_POSITION, SET_MIN_POSITION, localCaliCommand };
    }
    
    private CaliCommand(int paramInt)
    {
      this.data = paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
  
  public static enum CaliStatus
  {
    private int data;
    
    static
    {
      SETTING_MAX_POS = new CaliStatus("SETTING_MAX_POS", 2, 2);
      CaliStatus localCaliStatus = new CaliStatus("COMPLETE", 3, 3);
      COMPLETE = localCaliStatus;
      $VALUES = new CaliStatus[] { NOT_CALIBRATED, SETTING_MIN_POS, SETTING_MAX_POS, localCaliStatus };
    }
    
    private CaliStatus(int paramInt)
    {
      this.data = paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
  
  public static enum ClearCommand
  {
    private int data;
    
    static
    {
      DISTANCE_PARAM = new ClearCommand("DISTANCE_PARAM", 2, 2);
      TOF_FOCUS_PARAM = new ClearCommand("TOF_FOCUS_PARAM", 3, 3);
      ClearCommand localClearCommand = new ClearCommand("DOLLY_ZOOM", 4, 4);
      DOLLY_ZOOM = localClearCommand;
      $VALUES = new ClearCommand[] { DEFAULT, USER_PARAM, DISTANCE_PARAM, TOF_FOCUS_PARAM, localClearCommand };
    }
    
    private ClearCommand(int paramInt)
    {
      this.data = paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
  
  public static enum ControlMethod
  {
    private int data;
    
    static
    {
      POSITION_CONTROL = new ControlMethod("POSITION_CONTROL", 1, 1);
      CALIBRATE = new ControlMethod("CALIBRATE", 2, 2);
      STATUS_PUSH = new ControlMethod("STATUS_PUSH", 3, 9);
      SPEED_CONTROL = new ControlMethod("SPEED_CONTROL", 4, 11);
      CREATE_START_END_SET = new ControlMethod("CREATE_START_END_SET", 5, 15);
      CREATE_START_END_PUSH = new ControlMethod("CREATE_START_END_PUSH", 6, 16);
      TOF_STATUS_PUSH = new ControlMethod("TOF_STATUS_PUSH", 7, 18);
      ControlMethod localControlMethod = new ControlMethod("STATUS_CLEAR", 8, 20);
      STATUS_CLEAR = localControlMethod;
      $VALUES = new ControlMethod[] { RESERVED, POSITION_CONTROL, CALIBRATE, STATUS_PUSH, SPEED_CONTROL, CREATE_START_END_SET, CREATE_START_END_PUSH, TOF_STATUS_PUSH, localControlMethod };
    }
    
    private ControlMethod(int paramInt)
    {
      this.data = paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
  
  public static enum ControlType
  {
    private int data;
    
    static
    {
      ControlType localControlType = new ControlType("ZOOM", 2, 2);
      ZOOM = localControlType;
      $VALUES = new ControlType[] { FOCUS, IRIS, localControlType };
    }
    
    private ControlType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
  
  public static enum CreateSetCommand
  {
    private int data;
    
    static
    {
      SET_CURRENT_AS_CREATE_END = new CreateSetCommand("SET_CURRENT_AS_CREATE_END", 2, 2);
      CreateSetCommand localCreateSetCommand = new CreateSetCommand("SET_CREATE_START_END_MANUALLY", 3, 3);
      SET_CREATE_START_END_MANUALLY = localCreateSetCommand;
      $VALUES = new CreateSetCommand[] { DEFAULT, SET_CURRENT_AS_CREATE_START, SET_CURRENT_AS_CREATE_END, localCreateSetCommand };
    }
    
    private CreateSetCommand(int paramInt)
    {
      this.data = paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
  
  private static final class SingletonHolder
  {
    private static final DataGimbalFocusControl mInstance = new DataGimbalFocusControl();
  }
  
  public static enum TOFStatus
  {
    private int data;
    
    static
    {
      CALIBRATING = new TOFStatus("CALIBRATING", 1, 1);
      AF = new TOFStatus("AF", 2, 2);
      MF = new TOFStatus("MF", 3, 3);
      TOFStatus localTOFStatus = new TOFStatus("FAIL", 4, 4);
      FAIL = localTOFStatus;
      $VALUES = new TOFStatus[] { DEFAULT, CALIBRATING, AF, MF, localTOFStatus };
    }
    
    private TOFStatus(int paramInt)
    {
      this.data = paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalFocusControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */