package dji.midware.data.model.P3;

import dji.midware.data.model.common.DataAbstractGetPushActiveStatus;
import dji.midware.data.packages.P3.Pack;

public class DataFlycActiveStatus
  extends DataAbstractGetPushActiveStatus
{
  private static DataFlycActiveStatus instance;
  
  public static DataFlycActiveStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycActiveStatus();
      }
      DataFlycActiveStatus localDataFlycActiveStatus = instance;
      return localDataFlycActiveStatus;
    }
    finally {}
  }
  
  public int getFirstByteWhenGet()
  {
    return 0;
  }
  
  public boolean isActive()
  {
    return false;
  }
  
  protected void setPushRecPack(Pack paramPack)
  {
    super.setPushRecPack(paramPack);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycActiveStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */