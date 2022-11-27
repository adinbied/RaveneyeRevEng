package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataEyeGetPushPalmControlState
  extends DataBase
{
  private static DataEyeGetPushPalmControlState instance;
  
  public static DataEyeGetPushPalmControlState getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeGetPushPalmControlState();
      }
      DataEyeGetPushPalmControlState localDataEyeGetPushPalmControlState = instance;
      return localDataEyeGetPushPalmControlState;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getPalmControllingState()
  {
    return 0;
  }
  
  public int getPalmDetectionState()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeGetPushPalmControlState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */