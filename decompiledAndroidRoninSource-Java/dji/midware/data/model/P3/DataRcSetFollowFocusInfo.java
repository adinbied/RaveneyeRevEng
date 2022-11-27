package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataRcSetFollowFocusInfo
  extends DataBase
{
  private static DataRcSetFollowFocusInfo instance;
  private final String TAG = DataRcSetFollowFocusInfo.class.getSimpleName();
  private int mCtrDirction = -1;
  private int mCtrType = -1;
  
  public static DataRcSetFollowFocusInfo getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcSetFollowFocusInfo();
      }
      DataRcSetFollowFocusInfo localDataRcSetFollowFocusInfo = instance;
      return localDataRcSetFollowFocusInfo;
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
  
  public DataRcSetFollowFocusInfo setCtrDirection(int paramInt)
  {
    this.mCtrDirction = paramInt;
    return this;
  }
  
  public DataRcSetFollowFocusInfo setCtrType(int paramInt)
  {
    this.mCtrType = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcSetFollowFocusInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */