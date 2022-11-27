package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataOnboardGetPushMixInfo
  extends DataBase
{
  private static DataOnboardGetPushMixInfo instance;
  
  public static DataOnboardGetPushMixInfo getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOnboardGetPushMixInfo();
      }
      DataOnboardGetPushMixInfo localDataOnboardGetPushMixInfo = instance;
      return localDataOnboardGetPushMixInfo;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getFpvPercent()
  {
    return 0;
  }
  
  public int getMainCameraPercent()
  {
    return 0;
  }
  
  public int getMainCameraPercentRelativeToWholeCameraBandwidth()
  {
    return 0;
  }
  
  public int getMappedGimbal()
  {
    return 0;
  }
  
  public int getSecondaryCameraPercent()
  {
    return 0;
  }
  
  public boolean isSimultaneousControlGimbal()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOnboardGetPushMixInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */