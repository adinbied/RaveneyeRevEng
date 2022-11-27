package dji.midware.data.model.P3;

import dji.midware.util.BytesUtil;

public class DataCameraTauParamOptizate
  extends DataCameraTauParamer
{
  public DataCameraTauParamOptizate()
  {
    this.mParamCmd = DataCameraTauParamer.ParamCmd.SCENE_OPTIMIZATE;
  }
  
  public int getValue()
  {
    return 0;
  }
  
  public DataCameraTauParamOptizate setValue(int paramInt)
  {
    this.mParams = BytesUtil.getBytes((short)paramInt);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraTauParamOptizate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */