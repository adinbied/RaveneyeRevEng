package dji.midware.data.model.litchis;

import dji.midware.data.config.litchis.DataConfig.CmdId;

public class DataRequestAbort
  extends DataAppRequest
{
  private static DataRequestAbort instance;
  private DataConfig.CmdId cmdId;
  private AbortReason reason;
  
  public static DataRequestAbort getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRequestAbort();
      }
      DataRequestAbort localDataRequestAbort = instance;
      return localDataRequestAbort;
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
  
  public DataRequestAbort setCmdId(DataConfig.CmdId paramCmdId)
  {
    this.cmdId = paramCmdId;
    return this;
  }
  
  public DataRequestAbort setReason(AbortReason paramAbortReason)
  {
    this.reason = paramAbortReason;
    return this;
  }
  
  public static enum AbortReason
  {
    private int data;
    
    static
    {
      ReadFail = new AbortReason("ReadFail", 3, 3);
      Seek = new AbortReason("Seek", 4, 4);
      AbortReason localAbortReason = new AbortReason("UNDEFINED", 5, 100);
      UNDEFINED = localAbortReason;
      $VALUES = new AbortReason[] { Error, Force, SizeErr, ReadFail, Seek, localAbortReason };
    }
    
    private AbortReason(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static AbortReason find(int paramInt)
    {
      AbortReason localAbortReason = UNDEFINED;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localAbortReason;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\litchis\DataRequestAbort.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */