package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCommonGetSN
  extends DataBase
  implements DJIDataSyncListener
{
  private static final int SN_LENGTH_PARAM_SIZE = 2;
  private static final String TAG = "DataCommonGetSN";
  
  private String getRevertSN(int paramInt1, int paramInt2)
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
  
  public int getDataLen()
  {
    return 0;
  }
  
  public String getSN()
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
  
  public static enum SerialType
  {
    private int data;
    
    static
    {
      SerialType localSerialType = new SerialType("PRODUCT_ID", 3, 4);
      PRODUCT_ID = localSerialType;
      $VALUES = new SerialType[] { BOARD_NUMBER, CHIP_ID, SN, localSerialType };
    }
    
    private SerialType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCommonGetSN.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */