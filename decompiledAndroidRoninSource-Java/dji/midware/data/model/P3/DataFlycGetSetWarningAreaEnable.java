package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

@Deprecated
public class DataFlycGetSetWarningAreaEnable
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycGetSetWarningAreaEnable instance;
  private boolean isEnable = false;
  private boolean isToGetData = false;
  private int mAreaId = 0;
  
  public static DataFlycGetSetWarningAreaEnable getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetSetWarningAreaEnable();
      }
      DataFlycGetSetWarningAreaEnable localDataFlycGetSetWarningAreaEnable = instance;
      return localDataFlycGetSetWarningAreaEnable;
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
  
  public long getAckAreaId()
  {
    return 277672870L;
  }
  
  public boolean isAckAreaEnbale()
  {
    return false;
  }
  
  public DataFlycGetSetWarningAreaEnable setAreaId(int paramInt)
  {
    this.mAreaId = paramInt;
    return this;
  }
  
  public DataFlycGetSetWarningAreaEnable setEnable(boolean paramBoolean)
  {
    this.isEnable = paramBoolean;
    return this;
  }
  
  public DataFlycGetSetWarningAreaEnable setToGetData(boolean paramBoolean)
  {
    this.isToGetData = paramBoolean;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetSetWarningAreaEnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */