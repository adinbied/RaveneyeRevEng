package dji.midware.data.model.litchis;

import dji.midware.data.config.litchis.DataConfig.SubType;

public class DataRequestStream
  extends DataAppRequest
{
  private static DataRequestStream instance;
  private int index;
  private byte rateCtrl;
  private byte subIndex;
  private DataConfig.SubType subType;
  private long timeLen;
  private long timeOffset;
  
  public static DataRequestStream getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRequestStream();
      }
      DataRequestStream localDataRequestStream = instance;
      return localDataRequestStream;
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
  
  public DataRequestStream setIndex(int paramInt)
  {
    this.index = paramInt;
    return this;
  }
  
  public DataRequestStream setTimeLen(long paramLong)
  {
    this.timeLen = paramLong;
    return this;
  }
  
  public DataRequestStream setTimeOffset(long paramLong)
  {
    this.timeOffset = paramLong;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\litchis\DataRequestStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */