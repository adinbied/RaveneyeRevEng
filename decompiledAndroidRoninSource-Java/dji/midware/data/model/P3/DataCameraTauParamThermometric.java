package dji.midware.data.model.P3;

public class DataCameraTauParamThermometric
  extends DataCameraTauParamer
{
  public DataCameraTauParamThermometric()
  {
    this.mParamCmd = DataCameraTauParamer.ParamCmd.REGION_THERMOMETRIC;
  }
  
  public float getXAxis()
  {
    return 0.0F;
  }
  
  public float getYAxis()
  {
    return 0.0F;
  }
  
  public DataCameraTauParamThermometric setValue(float paramFloat1, float paramFloat2)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraTauParamThermometric.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */