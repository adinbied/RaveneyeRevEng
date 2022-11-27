package dji.midware.data.model.P3;

import java.util.ArrayList;

public class DataCameraTauExterParams
  extends DataCameraTauParamer
{
  private final ArrayList<ExterParamInfo> mCmdParams = new ArrayList(1);
  private int mDataLength = 0;
  
  public DataCameraTauExterParams()
  {
    this.mParamCmd = DataCameraTauParamer.ParamCmd.EXTER_PARAMS;
  }
  
  public DataCameraTauExterParams addParam(ExterParamId paramExterParamId, short paramShort)
  {
    return null;
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum ExterParamId
  {
    private final int _value;
    
    static
    {
      BACKGROUND_TEMP = new ExterParamId("BACKGROUND_TEMP", 2, 4);
      ATMOSPHERE_TRANSMISSION = new ExterParamId("ATMOSPHERE_TRANSMISSION", 3, 2);
      ATMOSPHERE_TEMP = new ExterParamId("ATMOSPHERE_TEMP", 4, 3);
      WINDOW_TRANSMISSION = new ExterParamId("WINDOW_TRANSMISSION", 5, 5);
      WINDOW_REFLECTION = new ExterParamId("WINDOW_REFLECTION", 6, 7);
      WINDOW_TEMP = new ExterParamId("WINDOW_TEMP", 7, 6);
      WINDOW_REFLECTED_TEMP = new ExterParamId("WINDOW_REFLECTED_TEMP", 8, 8);
      ExterParamId localExterParamId = new ExterParamId("OTHER", 9, 99);
      OTHER = localExterParamId;
      $VALUES = new ExterParamId[] { DEFAULT, TARGET_EMISSIVITY, BACKGROUND_TEMP, ATMOSPHERE_TRANSMISSION, ATMOSPHERE_TEMP, WINDOW_TRANSMISSION, WINDOW_REFLECTION, WINDOW_TEMP, WINDOW_REFLECTED_TEMP, localExterParamId };
    }
    
    private ExterParamId(int paramInt)
    {
      this._value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return paramInt == this._value;
    }
    
    public static ExterParamId find(int paramInt)
    {
      ExterParamId[] arrayOfExterParamId = values();
      int j = arrayOfExterParamId.length;
      int i = 0;
      while (i < j)
      {
        ExterParamId localExterParamId = arrayOfExterParamId[i];
        if (localExterParamId._equals(paramInt)) {
          return localExterParamId;
        }
        i += 1;
      }
      return DEFAULT;
    }
    
    public int value()
    {
      return this._value;
    }
  }
  
  private static final class ExterParamInfo
  {
    private DataCameraTauExterParams.ExterParamId mParamId = DataCameraTauExterParams.ExterParamId.DEFAULT;
    private short mValue = 0;
    
    private ExterParamInfo(DataCameraTauExterParams.ExterParamId paramExterParamId, short paramShort)
    {
      this.mParamId = paramExterParamId;
      this.mValue = paramShort;
    }
    
    private int dataLength()
    {
      if (DataCameraTauExterParams.ExterParamId.DEFAULT == this.mParamId) {}
      return 4;
    }
    
    private byte[] toBytes()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraTauExterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */