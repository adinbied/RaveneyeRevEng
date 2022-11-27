package dji.midware.data.model.litchis;

import dji.midware.data.config.litchis.DataConfig.SubType;

public class DataRequestFile
  extends DataAppRequest
{
  private static DataRequestFile instance;
  private int index;
  private int num;
  private long offset;
  private long size;
  private int subIndex;
  private DataConfig.SubType subType;
  
  public static DataRequestFile getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRequestFile();
      }
      DataRequestFile localDataRequestFile = instance;
      return localDataRequestFile;
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
  
  public DataRequestFile setIndex(int paramInt)
  {
    this.index = paramInt;
    return this;
  }
  
  public DataRequestFile setNum(int paramInt)
  {
    this.num = paramInt;
    return this;
  }
  
  public DataRequestFile setOffset(long paramLong)
  {
    this.offset = paramLong;
    return this;
  }
  
  public DataRequestFile setSize(long paramLong)
  {
    this.size = paramLong;
    return this;
  }
  
  public DataRequestFile setSubIndex(int paramInt)
  {
    this.subIndex = paramInt;
    return this;
  }
  
  public DataRequestFile setSubType(DataConfig.SubType paramSubType)
  {
    this.subType = paramSubType;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\litchis\DataRequestFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */