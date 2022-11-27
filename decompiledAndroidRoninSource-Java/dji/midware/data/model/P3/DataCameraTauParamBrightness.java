package dji.midware.data.model.P3;

import dji.midware.util.BytesUtil;

public class DataCameraTauParamBrightness
  extends DataCameraTauParamer
{
  public DataCameraTauParamBrightness()
  {
    this.mParamCmd = DataCameraTauParamer.ParamCmd.BRIGHTNESS;
  }
  
  public int getValue()
  {
    return 0;
  }
  
  public DataCameraTauParamBrightness setValue(int paramInt)
  {
    this.mParams = BytesUtil.getBytes((short)paramInt);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraTauParamBrightness.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */