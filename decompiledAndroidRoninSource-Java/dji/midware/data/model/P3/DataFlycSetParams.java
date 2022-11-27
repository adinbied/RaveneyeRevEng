package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DJIFlycParamInfoManager;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.params.P3.ParamInfo;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycSetParams
  extends DataBase
  implements DJIDataSyncListener
{
  private String[] indexs = null;
  private ParamInfo paramInfo;
  private Number value;
  private Number[] values = null;
  
  protected void LogPack(String paramString)
  {
    super.LogPack(paramString);
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setIndexs(String... paramVarArgs)
  {
    this.indexs = paramVarArgs;
  }
  
  public DataFlycSetParams setInfo(String paramString)
  {
    paramString = DJIFlycParamInfoManager.read(paramString);
    this.paramInfo = paramString;
    this.value = paramString.setvalue;
    return this;
  }
  
  public DataFlycSetParams setInfo(String paramString, Number paramNumber)
  {
    this.paramInfo = DJIFlycParamInfoManager.read(paramString);
    this.value = paramNumber;
    return this;
  }
  
  public void setRecData(byte[] paramArrayOfByte) {}
  
  /* Error */
  public void setRecPack(dji.midware.data.packages.P3.RecvPack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setValues(Number... paramVarArgs)
  {
    this.values = paramVarArgs;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycSetParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */