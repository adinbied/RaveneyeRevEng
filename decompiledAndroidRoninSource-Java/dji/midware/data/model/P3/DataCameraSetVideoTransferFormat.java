package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetVideoTransferFormat
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraSetVideoTransferFormat instance;
  private VideoTransferFormat mTransferFormat;
  
  public static DataCameraSetVideoTransferFormat getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraSetVideoTransferFormat();
      }
      DataCameraSetVideoTransferFormat localDataCameraSetVideoTransferFormat = instance;
      return localDataCameraSetVideoTransferFormat;
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
  
  public DataCameraSetVideoTransferFormat setVideoFormat(VideoTransferFormat paramVideoTransferFormat)
  {
    this.mTransferFormat = paramVideoTransferFormat;
    return this;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum VideoTransferFormat
  {
    private final int mData;
    
    static
    {
      VideoTransferFormat localVideoTransferFormat = new VideoTransferFormat("H265", 1, 2);
      H265 = localVideoTransferFormat;
      $VALUES = new VideoTransferFormat[] { H264, localVideoTransferFormat };
    }
    
    private VideoTransferFormat(int paramInt)
    {
      this.mData = paramInt;
    }
    
    public static VideoTransferFormat find(int paramInt)
    {
      VideoTransferFormat localVideoTransferFormat1 = H264;
      VideoTransferFormat[] arrayOfVideoTransferFormat = values();
      int j = arrayOfVideoTransferFormat.length;
      int i = 0;
      while (i < j)
      {
        VideoTransferFormat localVideoTransferFormat2 = arrayOfVideoTransferFormat[i];
        if (localVideoTransferFormat2._equals(paramInt)) {
          return localVideoTransferFormat2;
        }
        i += 1;
      }
      return localVideoTransferFormat1;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.mData == paramInt;
    }
    
    public int value()
    {
      return this.mData;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetVideoTransferFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */