package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycUploadWayPointMissionMsg
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycUploadWayPointMissionMsg instance;
  private ACTION_ON_RC_LOST actionOnRCLost = ACTION_ON_RC_LOST.EXIT_WP;
  private float cmdSpeed = 3.0F;
  private FINISH_ACTION finishAction;
  private GIMBAL_PITCH_MODE gimbalPitchMode = GIMBAL_PITCH_MODE.PITCH_SMOOTH;
  private GOTO_FIRST_POINT_ACTION gotoFirstFlag = GOTO_FIRST_POINT_ACTION.MAX_HEIGHT;
  private double hpHeight = 0.0D;
  private double hpLat = 0.0D;
  private double hpLng = 0.0D;
  private float idleSpeed = 10.0F;
  private int repeatNum;
  private TRACE_MODE traceMode;
  private int wayPointsCount = 0;
  private YAW_MODE yawMode;
  
  public static DataFlycUploadWayPointMissionMsg getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycUploadWayPointMissionMsg();
      }
      DataFlycUploadWayPointMissionMsg localDataFlycUploadWayPointMissionMsg = instance;
      return localDataFlycUploadWayPointMissionMsg;
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
  
  public int getResult()
  {
    return 0;
  }
  
  public DataFlycUploadWayPointMissionMsg seGimbalPitchMode(GIMBAL_PITCH_MODE paramGIMBAL_PITCH_MODE)
  {
    this.gimbalPitchMode = paramGIMBAL_PITCH_MODE;
    return this;
  }
  
  public DataFlycUploadWayPointMissionMsg seGotoFirstFlag(GOTO_FIRST_POINT_ACTION paramGOTO_FIRST_POINT_ACTION)
  {
    this.gotoFirstFlag = paramGOTO_FIRST_POINT_ACTION;
    return this;
  }
  
  public DataFlycUploadWayPointMissionMsg seHPHeight(double paramDouble)
  {
    this.hpHeight = paramDouble;
    return this;
  }
  
  public DataFlycUploadWayPointMissionMsg seHPLat(double paramDouble)
  {
    this.hpLat = paramDouble;
    return this;
  }
  
  public DataFlycUploadWayPointMissionMsg seHPLng(double paramDouble)
  {
    this.hpLng = paramDouble;
    return this;
  }
  
  public DataFlycUploadWayPointMissionMsg setActionOnRCLost(ACTION_ON_RC_LOST paramACTION_ON_RC_LOST)
  {
    this.actionOnRCLost = paramACTION_ON_RC_LOST;
    return this;
  }
  
  public DataFlycUploadWayPointMissionMsg setCmdSpeed(float paramFloat)
  {
    this.cmdSpeed = paramFloat;
    return this;
  }
  
  public DataFlycUploadWayPointMissionMsg setFinishAction(FINISH_ACTION paramFINISH_ACTION)
  {
    this.finishAction = paramFINISH_ACTION;
    return this;
  }
  
  public DataFlycUploadWayPointMissionMsg setIdleSpeed(float paramFloat)
  {
    this.idleSpeed = paramFloat;
    return this;
  }
  
  public DataFlycUploadWayPointMissionMsg setRepeatNum(int paramInt)
  {
    this.repeatNum = paramInt;
    return this;
  }
  
  public DataFlycUploadWayPointMissionMsg setTraceMOde(TRACE_MODE paramTRACE_MODE)
  {
    this.traceMode = paramTRACE_MODE;
    return this;
  }
  
  public DataFlycUploadWayPointMissionMsg setWayPointCount(int paramInt)
  {
    this.wayPointsCount = paramInt;
    return this;
  }
  
  public DataFlycUploadWayPointMissionMsg setYawMode(YAW_MODE paramYAW_MODE)
  {
    this.yawMode = paramYAW_MODE;
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
  
  public static enum ACTION_ON_RC_LOST
  {
    private int data;
    
    static
    {
      ACTION_ON_RC_LOST localACTION_ON_RC_LOST = new ACTION_ON_RC_LOST("CONTINUE_WP", 1, 1);
      CONTINUE_WP = localACTION_ON_RC_LOST;
      $VALUES = new ACTION_ON_RC_LOST[] { EXIT_WP, localACTION_ON_RC_LOST };
    }
    
    private ACTION_ON_RC_LOST(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static ACTION_ON_RC_LOST find(int paramInt)
    {
      ACTION_ON_RC_LOST localACTION_ON_RC_LOST = EXIT_WP;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localACTION_ON_RC_LOST;
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
  
  public static enum FINISH_ACTION
  {
    private int data;
    
    static
    {
      GOHOME = new FINISH_ACTION("GOHOME", 1, 1);
      LAND = new FINISH_ACTION("LAND", 2, 2);
      BACK_TO_FIRST_WAY_POINT = new FINISH_ACTION("BACK_TO_FIRST_WAY_POINT", 3, 3);
      FINISH_ACTION localFINISH_ACTION = new FINISH_ACTION("NO_LIMIT", 4, 4);
      NO_LIMIT = localFINISH_ACTION;
      $VALUES = new FINISH_ACTION[] { NONE, GOHOME, LAND, BACK_TO_FIRST_WAY_POINT, localFINISH_ACTION };
    }
    
    private FINISH_ACTION(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static FINISH_ACTION find(int paramInt)
    {
      FINISH_ACTION localFINISH_ACTION = NONE;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localFINISH_ACTION;
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
  
  public static enum GIMBAL_PITCH_MODE
  {
    private int data;
    
    static
    {
      GIMBAL_PITCH_MODE localGIMBAL_PITCH_MODE = new GIMBAL_PITCH_MODE("PITCH_SMOOTH", 1, 1);
      PITCH_SMOOTH = localGIMBAL_PITCH_MODE;
      $VALUES = new GIMBAL_PITCH_MODE[] { PITCH_FREE, localGIMBAL_PITCH_MODE };
    }
    
    private GIMBAL_PITCH_MODE(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static GIMBAL_PITCH_MODE find(int paramInt)
    {
      GIMBAL_PITCH_MODE localGIMBAL_PITCH_MODE = PITCH_SMOOTH;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localGIMBAL_PITCH_MODE;
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
  
  public static enum GOTO_FIRST_POINT_ACTION
  {
    private int data;
    
    static
    {
      GOTO_FIRST_POINT_ACTION localGOTO_FIRST_POINT_ACTION = new GOTO_FIRST_POINT_ACTION("POINT_TO_POINT", 1, 1);
      POINT_TO_POINT = localGOTO_FIRST_POINT_ACTION;
      $VALUES = new GOTO_FIRST_POINT_ACTION[] { MAX_HEIGHT, localGOTO_FIRST_POINT_ACTION };
    }
    
    private GOTO_FIRST_POINT_ACTION(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static GOTO_FIRST_POINT_ACTION find(int paramInt)
    {
      GOTO_FIRST_POINT_ACTION localGOTO_FIRST_POINT_ACTION = MAX_HEIGHT;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localGOTO_FIRST_POINT_ACTION;
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
  
  public static enum TRACE_MODE
  {
    private int data;
    
    static
    {
      TRACE_MODE localTRACE_MODE = new TRACE_MODE("SMOOTH_PATH", 1, 1);
      SMOOTH_PATH = localTRACE_MODE;
      $VALUES = new TRACE_MODE[] { EXEC_MESSION, localTRACE_MODE };
    }
    
    private TRACE_MODE(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static TRACE_MODE find(int paramInt)
    {
      TRACE_MODE localTRACE_MODE = EXEC_MESSION;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localTRACE_MODE;
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
  
  public static enum YAW_MODE
  {
    private int data;
    
    static
    {
      PATH_COURSE = new YAW_MODE("PATH_COURSE", 3, 3);
      YAW_MODE localYAW_MODE = new YAW_MODE("HP_MODE", 4, 4);
      HP_MODE = localYAW_MODE;
      $VALUES = new YAW_MODE[] { AUTO_COURSE, FREE_COURSE, REMOTE_CONTROL, PATH_COURSE, localYAW_MODE };
    }
    
    private YAW_MODE(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static YAW_MODE find(int paramInt)
    {
      YAW_MODE localYAW_MODE = AUTO_COURSE;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localYAW_MODE;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycUploadWayPointMissionMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */