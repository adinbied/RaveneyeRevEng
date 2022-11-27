package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.model.common.DJIMonitorFreqSupportType;

public class DataWifiGetPushSweepFrequency
  extends DataBase
{
  private static final int CHN_SET_HEADER_LENGTH = 6;
  private static final int CHN_SET_LENGTH_BYTE_LENGTH = 2;
  private static final int CHN_SET_ONE_ITEM_CHANNEL_LENGTH = 4;
  private static final int CHN_SET_ONE_ITEM_INDEX_LENGTH = 4;
  private static final int CHN_SET_ONE_ITEM_LENGTH = 8;
  private static final int CHN_SET_ONE_ITEM_RSSI_LENGTH = 4;
  private static final int CHN_SET_TYPE_FREQ_LENGTH = 4;
  private static final int MIN_CHANNEL_IN_5_8_G = 149;
  private static final String TAG = "GetPushSweepFrequency";
  private static final int TOTAL_HEADER_LENGTH = 4;
  private static DataWifiGetPushSweepFrequency instance;
  private boolean mSupport24G = false;
  private boolean mSupport5G = false;
  
  private int[] get24GChnList()
  {
    return null;
  }
  
  private int[] get5GChnList()
  {
    return null;
  }
  
  public static DataWifiGetPushSweepFrequency getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataWifiGetPushSweepFrequency();
      }
      DataWifiGetPushSweepFrequency localDataWifiGetPushSweepFrequency = instance;
      return localDataWifiGetPushSweepFrequency;
    }
    finally {}
  }
  
  private int getLength24G()
  {
    return 0;
  }
  
  protected void doPack() {}
  
  public int[] get24GRssiList()
  {
    return null;
  }
  
  public int[] get5GRssiList()
  {
    return null;
  }
  
  public int[] getChannelList()
  {
    return null;
  }
  
  public int getFirstChannelType()
  {
    return 0;
  }
  
  public DJIMonitorFreqSupportType getFreqSupportType()
  {
    return null;
  }
  
  public int[] getRssiList()
  {
    return null;
  }
  
  public int getTotal()
  {
    return 0;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataWifiGetPushSweepFrequency.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */