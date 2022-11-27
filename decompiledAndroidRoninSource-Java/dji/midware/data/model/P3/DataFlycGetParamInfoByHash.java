package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.params.P3.ParamInfo;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycGetParamInfoByHash
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycGetParamInfoByHash mInstance;
  private long hash;
  private String mIndex = null;
  
  public static DataFlycGetParamInfoByHash getInstance()
  {
    if (mInstance == null) {
      mInstance = new DataFlycGetParamInfoByHash();
    }
    return mInstance;
  }
  
  /* Error */
  private void setRange(dji.midware.data.params.P3.RangeModel arg1, Class<? extends Number> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public ParamInfo getParamInfo()
  {
    return null;
  }
  
  public DataFlycGetParamInfoByHash setIndex(String paramString)
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetParamInfoByHash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */