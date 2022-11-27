package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataOsdSetConfig
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataOsdSetConfig instance;
  private int bandwidth;
  private int channelId;
  private int downwardFreqType;
  private int isAuto;
  private boolean isDouble;
  private int mcs;
  private int receiverType = 0;
  private int upwardFreqType;
  
  public static DataOsdSetConfig getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdSetConfig();
      }
      DataOsdSetConfig localDataOsdSetConfig = instance;
      return localDataOsdSetConfig;
    }
    finally {}
  }
  
  /* Error */
  private void reset()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void doPack() {}
  
  public DataOsdSetConfig setAutoChannel(boolean paramBoolean)
  {
    return null;
  }
  
  public DataOsdSetConfig setBandWidth(int paramInt)
  {
    return null;
  }
  
  public DataOsdSetConfig setChannel(int paramInt)
  {
    return null;
  }
  
  public DataOsdSetConfig setFreqType(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public DataOsdSetConfig setMcs(int paramInt)
  {
    return null;
  }
  
  public DataOsdSetConfig setOutputModeChange(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public DataOsdSetConfig setReceiverType(int paramInt)
  {
    this.receiverType = paramInt;
    return this;
  }
  
  public DataOsdSetConfig setSdrBandwidth(int paramInt)
  {
    return null;
  }
  
  public DataOsdSetConfig setSdrConfig(int paramInt1, int paramInt2, int paramInt3)
  {
    return null;
  }
  
  public DataOsdSetConfig setSdrMcs(int paramInt)
  {
    return null;
  }
  
  public DataOsdSetConfig setSingleOrDouble(boolean paramBoolean)
  {
    return null;
  }
  
  public DataOsdSetConfig setVideoSource(int paramInt)
  {
    return null;
  }
  
  public DataOsdSetConfig setWorkingFreq(int paramInt)
  {
    return null;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum KEY
  {
    private int data;
    
    static
    {
      BandWidthPercentage = new KEY("BandWidthPercentage", 4, 12);
      VideoSource = new KEY("VideoSource", 5, 13);
      WorkingFreq = new KEY("WorkingFreq", 6, 16);
      KEY localKEY = new KEY("OTHER", 7, 6);
      OTHER = localKEY;
      $VALUES = new KEY[] { Channel, FreqStep, Mcs, SingleOrDouble, BandWidthPercentage, VideoSource, WorkingFreq, localKEY };
    }
    
    private KEY(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static KEY find(int paramInt)
    {
      KEY localKEY = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localKEY;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdSetConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */