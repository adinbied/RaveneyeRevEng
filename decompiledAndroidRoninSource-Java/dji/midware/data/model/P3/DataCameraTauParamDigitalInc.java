package dji.midware.data.model.P3;

import dji.midware.util.BytesUtil;

public class DataCameraTauParamDigitalInc
  extends DataCameraTauParamer
{
  public DataCameraTauParamDigitalInc()
  {
    this.mParamCmd = DataCameraTauParamer.ParamCmd.DIGITAL_INC;
  }
  
  public int getValue()
  {
    return 0;
  }
  
  public DataCameraTauParamDigitalInc setValue(int paramInt)
  {
    this.mParams = BytesUtil.getBytes((short)paramInt);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraTauParamDigitalInc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */