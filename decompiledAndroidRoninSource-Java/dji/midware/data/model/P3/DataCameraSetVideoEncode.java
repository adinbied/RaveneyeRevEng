package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetVideoEncode
  extends DataBase
  implements DJIDataSyncListener
{
  private VideoEncodeType mPrimaryType = VideoEncodeType.H264;
  private VideoEncodeType mSecondaryType = VideoEncodeType.H264;
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataCameraSetVideoEncode resetAll()
  {
    return null;
  }
  
  public DataCameraSetVideoEncode setPrimaryEncodeType(VideoEncodeType paramVideoEncodeType)
  {
    this.mPrimaryType = paramVideoEncodeType;
    return this;
  }
  
  public DataCameraSetVideoEncode setSecondaryEncodeType(VideoEncodeType paramVideoEncodeType)
  {
    this.mSecondaryType = paramVideoEncodeType;
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
  
  public static enum VideoEncodeType
  {
    private final int data;
    
    static
    {
      VideoEncodeType localVideoEncodeType = new VideoEncodeType("OTHER", 2, 100);
      OTHER = localVideoEncodeType;
      $VALUES = new VideoEncodeType[] { H264, H265, localVideoEncodeType };
    }
    
    private VideoEncodeType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static VideoEncodeType find(int paramInt)
    {
      VideoEncodeType localVideoEncodeType1 = H264;
      VideoEncodeType[] arrayOfVideoEncodeType = values();
      int j = arrayOfVideoEncodeType.length;
      int i = 0;
      while (i < j)
      {
        VideoEncodeType localVideoEncodeType2 = arrayOfVideoEncodeType[i];
        if (localVideoEncodeType2._equals(paramInt)) {
          return localVideoEncodeType2;
        }
        i += 1;
      }
      return localVideoEncodeType1;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetVideoEncode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */