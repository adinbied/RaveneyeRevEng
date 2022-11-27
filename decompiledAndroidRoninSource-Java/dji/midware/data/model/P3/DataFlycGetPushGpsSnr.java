package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataFlycGetPushGpsSnr
  extends DataBase
{
  public static final int MAX_LENGTH = 32;
  private static DataFlycGetPushGpsSnr instance;
  private final int[] mGlonassSnr = new int[32];
  private final int[] mSnrValue = new int[32];
  
  public static DataFlycGetPushGpsSnr getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetPushGpsSnr();
      }
      DataFlycGetPushGpsSnr localDataFlycGetPushGpsSnr = instance;
      return localDataFlycGetPushGpsSnr;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getGlonassSnrUsed()
  {
    return 0;
  }
  
  public int[] getGlonassValues()
  {
    return null;
  }
  
  public int getSnrUsed()
  {
    return 0;
  }
  
  public int[] getSnrValues()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetPushGpsSnr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */