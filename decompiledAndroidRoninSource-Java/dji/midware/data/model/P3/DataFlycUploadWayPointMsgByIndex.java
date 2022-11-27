package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;
import java.util.ArrayList;

public class DataFlycUploadWayPointMsgByIndex
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycUploadWayPointMsgByIndex instance;
  private ArrayList<ACTION> actionList;
  private int actionNum;
  private int actionRepeat;
  private int actionTimeTimit = 999;
  private float altitude;
  private int cameraActionInterval;
  private int cameraActionType;
  private float dampingDis = 0.0F;
  private boolean hasAction;
  private boolean hasSpeed;
  private int index;
  private double latitude;
  private double longitude;
  private ArrayList<Integer> paramsList;
  private short tgtPitch = 0;
  private short tgtYaw;
  private TURNMODE turnMode;
  private int wpSpeed;
  
  public static DataFlycUploadWayPointMsgByIndex getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycUploadWayPointMsgByIndex();
      }
      DataFlycUploadWayPointMsgByIndex localDataFlycUploadWayPointMsgByIndex = instance;
      return localDataFlycUploadWayPointMsgByIndex;
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
  
  public DataFlycUploadWayPointMsgByIndex isHasSpeed(boolean paramBoolean)
  {
    this.hasSpeed = paramBoolean;
    return this;
  }
  
  public DataFlycUploadWayPointMsgByIndex setActionList(ArrayList<ACTION> paramArrayList)
  {
    this.actionList = paramArrayList;
    return this;
  }
  
  public DataFlycUploadWayPointMsgByIndex setActionNum(int paramInt)
  {
    this.actionNum = paramInt;
    return this;
  }
  
  public DataFlycUploadWayPointMsgByIndex setActionRepeat(int paramInt)
  {
    this.actionRepeat = paramInt;
    return this;
  }
  
  public DataFlycUploadWayPointMsgByIndex setActionTimeTimit(short paramShort)
  {
    this.actionTimeTimit = paramShort;
    return this;
  }
  
  public DataFlycUploadWayPointMsgByIndex setAltitude(float paramFloat)
  {
    this.altitude = paramFloat;
    return this;
  }
  
  public DataFlycUploadWayPointMsgByIndex setCameraActionInterval(int paramInt)
  {
    this.cameraActionInterval = paramInt;
    return this;
  }
  
  public DataFlycUploadWayPointMsgByIndex setCameraActionType(int paramInt)
  {
    this.cameraActionType = paramInt;
    return this;
  }
  
  public DataFlycUploadWayPointMsgByIndex setDampingDis(float paramFloat)
  {
    this.dampingDis = paramFloat;
    return this;
  }
  
  public DataFlycUploadWayPointMsgByIndex setHasAction(boolean paramBoolean)
  {
    this.hasAction = paramBoolean;
    return this;
  }
  
  public DataFlycUploadWayPointMsgByIndex setIndex(int paramInt)
  {
    this.index = paramInt;
    return this;
  }
  
  public DataFlycUploadWayPointMsgByIndex setLatitude(double paramDouble)
  {
    this.latitude = paramDouble;
    return this;
  }
  
  public DataFlycUploadWayPointMsgByIndex setLongtitude(double paramDouble)
  {
    this.longitude = paramDouble;
    return this;
  }
  
  public DataFlycUploadWayPointMsgByIndex setParamsList(ArrayList<Integer> paramArrayList)
  {
    this.paramsList = paramArrayList;
    return this;
  }
  
  public DataFlycUploadWayPointMsgByIndex setTgtPitch(short paramShort)
  {
    this.tgtPitch = paramShort;
    return this;
  }
  
  public DataFlycUploadWayPointMsgByIndex setTgtYaw(short paramShort)
  {
    this.tgtYaw = paramShort;
    return this;
  }
  
  public DataFlycUploadWayPointMsgByIndex setTurnMode(TURNMODE paramTURNMODE)
  {
    this.turnMode = paramTURNMODE;
    return this;
  }
  
  public DataFlycUploadWayPointMsgByIndex setWpSpeed(int paramInt)
  {
    this.wpSpeed = paramInt;
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
  
  public static enum ACTION
  {
    private int data;
    
    static
    {
      WP_ACTION_SIMPLE_SHOT = new ACTION("WP_ACTION_SIMPLE_SHOT", 1, 1);
      WP_ACTION_VIDEO_START = new ACTION("WP_ACTION_VIDEO_START", 2, 2);
      WP_ACTION_VIDEO_STOP = new ACTION("WP_ACTION_VIDEO_STOP", 3, 3);
      WP_ACTION_CRAFT_YAW = new ACTION("WP_ACTION_CRAFT_YAW", 4, 4);
      WP_ACTION_GIMBAL_YAW = new ACTION("WP_ACTION_GIMBAL_YAW", 5, 5);
      ACTION localACTION = new ACTION("WP_ACTION_GIMBAL_PITCH", 6, 6);
      WP_ACTION_GIMBAL_PITCH = localACTION;
      $VALUES = new ACTION[] { WP_ACTION_STAY, WP_ACTION_SIMPLE_SHOT, WP_ACTION_VIDEO_START, WP_ACTION_VIDEO_STOP, WP_ACTION_CRAFT_YAW, WP_ACTION_GIMBAL_YAW, localACTION };
    }
    
    private ACTION(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static ACTION find(int paramInt)
    {
      ACTION localACTION = WP_ACTION_STAY;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localACTION;
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
  
  public static enum TURNMODE
  {
    private int data;
    
    static
    {
      TURNMODE localTURNMODE = new TURNMODE("ANTI_CLOSEWISE", 1, 1);
      ANTI_CLOSEWISE = localTURNMODE;
      $VALUES = new TURNMODE[] { CLOCKWISE, localTURNMODE };
    }
    
    private TURNMODE(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static TURNMODE find(int paramInt)
    {
      TURNMODE localTURNMODE = CLOCKWISE;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localTURNMODE;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycUploadWayPointMsgByIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */