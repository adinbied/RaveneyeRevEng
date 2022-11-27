package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataCameraSetFileStar
  extends DataBase
{
  private static DataCameraSetFileStar ourInstance = new DataCameraSetFileStar();
  private int mFileIndex = -1;
  private int[] mFilesIndex = null;
  boolean mIsAddStar = true;
  
  public static DataCameraSetFileStar getInstance()
  {
    return ourInstance;
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int[] getFailList()
  {
    return null;
  }
  
  public int getFailNum()
  {
    return 0;
  }
  
  public DataCameraSetFileStar isAddStar(boolean paramBoolean)
  {
    this.mIsAddStar = paramBoolean;
    return this;
  }
  
  public DataCameraSetFileStar setFileIndex(int paramInt)
  {
    this.mFileIndex = paramInt;
    return this;
  }
  
  public DataCameraSetFileStar setFilesIndex(int[] paramArrayOfInt)
  {
    this.mFilesIndex = paramArrayOfInt;
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetFileStar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */