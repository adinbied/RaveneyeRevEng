package dji.midware.data.model.litchis;

import dji.midware.data.config.litchis.DataConfig.CmdId;

public class DataRequestAck
  extends DataAppRequest
{
  private static DataRequestAck instance;
  private DataConfig.CmdId cmdId;
  private int num;
  private int seq;
  
  public static DataRequestAck getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRequestAck();
      }
      DataRequestAck localDataRequestAck = instance;
      return localDataRequestAck;
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
  
  public DataRequestAck setCmdId(DataConfig.CmdId paramCmdId)
  {
    this.cmdId = paramCmdId;
    return this;
  }
  
  public DataRequestAck setMissNum(int paramInt)
  {
    this.num = paramInt;
    return this;
  }
  
  public DataRequestAck setSeq(int paramInt)
  {
    this.seq = paramInt;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\litchis\DataRequestAck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */