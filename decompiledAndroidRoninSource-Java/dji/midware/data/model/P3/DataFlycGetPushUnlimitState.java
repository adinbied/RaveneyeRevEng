package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import java.util.ArrayList;
import java.util.List;

public class DataFlycGetPushUnlimitState
  extends DataBase
{
  private static DataFlycGetPushUnlimitState instance;
  private List<UnlimitArea> mUnlimitAreas = new ArrayList();
  
  public static DataFlycGetPushUnlimitState getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetPushUnlimitState();
      }
      DataFlycGetPushUnlimitState localDataFlycGetPushUnlimitState = instance;
      return localDataFlycGetPushUnlimitState;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getUnlimitAreasAction()
  {
    return 0;
  }
  
  public int getUnlimitAreasEnabled()
  {
    return 0;
  }
  
  public List<UnlimitArea> getUnlimitAreasList()
  {
    return null;
  }
  
  public int getUnlimitAreasSize()
  {
    return 0;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return true;
  }
  
  public int isInUnlimitArea()
  {
    return 0;
  }
  
  public static class UnlimitArea
  {
    public double lat;
    public double lng;
    public double radius;
    public long startTime;
    public long stopTime;
    public int type;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetPushUnlimitState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */