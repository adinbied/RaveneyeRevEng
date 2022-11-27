package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DJIGimbalParamInfoManager;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.params.P3.ParamInfo;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataGimbalSetUserParams
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataGimbalSetUserParams instance;
  private String[] indexs = null;
  private int mRepeatTimes = -1;
  private int mTimeOut = -1;
  private ParamInfo paramInfo;
  private String strValue;
  private Number value;
  private Number[] values = null;
  
  public static DataGimbalSetUserParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataGimbalSetUserParams();
      }
      DataGimbalSetUserParams localDataGimbalSetUserParams = instance;
      return localDataGimbalSetUserParams;
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
  
  public DataGimbalSetUserParams setIndexs(String... paramVarArgs)
  {
    this.indexs = paramVarArgs;
    return this;
  }
  
  public DataGimbalSetUserParams setInfo(String paramString)
  {
    paramString = DJIGimbalParamInfoManager.read(paramString);
    this.paramInfo = paramString;
    this.value = paramString.setvalue;
    return this;
  }
  
  public DataGimbalSetUserParams setInfo(String paramString, Number paramNumber)
  {
    this.paramInfo = DJIGimbalParamInfoManager.read(paramString);
    this.value = paramNumber;
    return this;
  }
  
  /* Error */
  public void setRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setRepeatTimes(int paramInt)
  {
    this.mRepeatTimes = paramInt;
  }
  
  public DataGimbalSetUserParams setStrValueInfo(String paramString1, String paramString2)
  {
    this.paramInfo = DJIGimbalParamInfoManager.read(paramString1);
    this.strValue = paramString2;
    return this;
  }
  
  public DataGimbalSetUserParams setTimeOut(int paramInt)
  {
    this.mTimeOut = paramInt;
    return this;
  }
  
  public DataGimbalSetUserParams setValues(Number... paramVarArgs)
  {
    this.values = paramVarArgs;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalSetUserParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */