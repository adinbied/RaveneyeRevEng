package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataOsdGetPushSdrUpwardSelectChannel
  extends DataBase
{
  private static DataOsdGetPushSdrUpwardSelectChannel instance;
  private int mSelectChannelCnt = 0;
  
  public static DataOsdGetPushSdrUpwardSelectChannel getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdGetPushSdrUpwardSelectChannel();
      }
      DataOsdGetPushSdrUpwardSelectChannel localDataOsdGetPushSdrUpwardSelectChannel = instance;
      return localDataOsdGetPushSdrUpwardSelectChannel;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getSelectChannelCount()
  {
    return 0;
  }
  
  public float[] getSelectChannelList()
  {
    return null;
  }
  
  public float getSelectChannelType()
  {
    return 0.0F;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdGetPushSdrUpwardSelectChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */