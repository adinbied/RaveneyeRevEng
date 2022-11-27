package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataGimbalGetPushTutorialStatus
  extends DataBase
{
  private static DataGimbalGetPushTutorialStatus instance;
  
  public static DataGimbalGetPushTutorialStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataGimbalGetPushTutorialStatus();
      }
      DataGimbalGetPushTutorialStatus localDataGimbalGetPushTutorialStatus = instance;
      return localDataGimbalGetPushTutorialStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public TutorialStatus getCurStep()
  {
    return null;
  }
  
  public int getIsAppControlFinish()
  {
    return 0;
  }
  
  public int getIsFollowFinish()
  {
    return 0;
  }
  
  public int getIsHandlePushFinish()
  {
    return 0;
  }
  
  public int getIsLockDirectionFinish()
  {
    return 0;
  }
  
  public int getIsRecentFinish()
  {
    return 0;
  }
  
  public int getIsSelfieFinish()
  {
    return 0;
  }
  
  public int getIsStickFinish()
  {
    return 0;
  }
  
  public int getIsUnlock()
  {
    return 0;
  }
  
  public int getIsUpright()
  {
    return 0;
  }
  
  public boolean getStepStatus(TutorialStatus paramTutorialStatus)
  {
    return false;
  }
  
  public static enum TutorialStatus
  {
    private int data;
    
    static
    {
      STEP_HOLD_GIMBAL_UPRIGHT = new TutorialStatus("STEP_HOLD_GIMBAL_UPRIGHT", 3, 3);
      STEP_FOLLOW = new TutorialStatus("STEP_FOLLOW", 4, 4);
      STEP_STICK = new TutorialStatus("STEP_STICK", 5, 5);
      STEP_LOCK_DIRECTION = new TutorialStatus("STEP_LOCK_DIRECTION", 6, 6);
      STEP_RECENTER = new TutorialStatus("STEP_RECENTER", 7, 7);
      STEP_SELFIE = new TutorialStatus("STEP_SELFIE", 8, 8);
      STEP_PUSH = new TutorialStatus("STEP_PUSH", 9, 9);
      TutorialStatus localTutorialStatus = new TutorialStatus("STEP_APP_CONTROL", 10, 10);
      STEP_APP_CONTROL = localTutorialStatus;
      $VALUES = new TutorialStatus[] { STEP_FINISH, STEP_START, STEP_UNLOCK_GIMBAL, STEP_HOLD_GIMBAL_UPRIGHT, STEP_FOLLOW, STEP_STICK, STEP_LOCK_DIRECTION, STEP_RECENTER, STEP_SELFIE, STEP_PUSH, localTutorialStatus };
    }
    
    private TutorialStatus(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static TutorialStatus find(int paramInt)
    {
      TutorialStatus localTutorialStatus = STEP_FINISH;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localTutorialStatus;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalGetPushTutorialStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */