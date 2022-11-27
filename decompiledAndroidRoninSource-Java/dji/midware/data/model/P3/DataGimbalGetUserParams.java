package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataGimbalGetUserParams
  extends DataBase
  implements DJIDataSyncListener
{
  public static final int CONFIG_NAME_SUB_CMDID = 45;
  private static DataGimbalGetUserParams instance;
  private String[] indexs = null;
  private String[] mGimbalNameIndexs = new String[0];
  private int mRepeatTimes = -1;
  private int mTimeOut = -1;
  
  public static DataGimbalGetUserParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataGimbalGetUserParams();
      }
      DataGimbalGetUserParams localDataGimbalGetUserParams = instance;
      return localDataGimbalGetUserParams;
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
  
  /* Error */
  protected void post()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataGimbalGetUserParams setGimbalNameIndexs(String[] paramArrayOfString)
  {
    this.mGimbalNameIndexs = paramArrayOfString;
    return this;
  }
  
  public DataGimbalGetUserParams setInfos(String[] paramArrayOfString)
  {
    this.indexs = paramArrayOfString;
    return this;
  }
  
  /* Error */
  public void setRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void setRepeatTimes(int paramInt)
  {
    this.mRepeatTimes = paramInt;
  }
  
  public DataGimbalGetUserParams setTimeOut(int paramInt)
  {
    this.mTimeOut = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalGetUserParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */