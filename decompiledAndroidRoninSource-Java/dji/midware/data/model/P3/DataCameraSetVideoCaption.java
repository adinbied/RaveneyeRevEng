package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetVideoCaption
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraSetVideoCaption mInstance;
  private byte mValue = 0;
  
  public static DataCameraSetVideoCaption getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DataCameraSetVideoCaption();
      }
      DataCameraSetVideoCaption localDataCameraSetVideoCaption = mInstance;
      return localDataCameraSetVideoCaption;
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
  
  public DataCameraSetVideoCaption reset()
  {
    this.mValue = 0;
    return this;
  }
  
  public DataCameraSetVideoCaption setGenerateVideoCaption(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mValue = ((byte)(this.mValue | 0x80));
      return this;
    }
    this.mValue = ((byte)(this.mValue & 0xFF7F));
    return this;
  }
  
  public void setShowCameraEVParam(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mValue = ((byte)(this.mValue | 0x1));
      return;
    }
    this.mValue = ((byte)(this.mValue & 0xFFFFFFFE));
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetVideoCaption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */