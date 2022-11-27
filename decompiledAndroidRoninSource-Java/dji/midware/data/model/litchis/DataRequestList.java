package dji.midware.data.model.litchis;

import dji.midware.data.config.litchis.DataConfig.SubType;

public class DataRequestList
  extends DataAppRequest
{
  private static DataRequestList instance;
  private int index;
  private int num;
  private DataConfig.SubType subType;
  
  public static DataRequestList getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRequestList();
      }
      DataRequestList localDataRequestList = instance;
      return localDataRequestList;
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
  
  public DataRequestList setIndex(int paramInt)
  {
    this.index = paramInt;
    return this;
  }
  
  public DataRequestList setNum(int paramInt)
  {
    this.num = paramInt;
    return this;
  }
  
  public DataRequestList setSubType(DataConfig.SubType paramSubType)
  {
    this.subType = paramSubType;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\litchis\DataRequestList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */