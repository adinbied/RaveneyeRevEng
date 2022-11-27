package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycGetFsAction
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycGetFsAction instance;
  
  public static DataFlycGetFsAction getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetFsAction();
      }
      DataFlycGetFsAction localDataFlycGetFsAction = instance;
      return localDataFlycGetFsAction;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public FS_ACTION getFsAction()
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
  
  public static enum FS_ACTION
  {
    private int data;
    
    static
    {
      GoHome = new FS_ACTION("GoHome", 2, 2);
      FS_ACTION localFS_ACTION = new FS_ACTION("OTHER", 3, 100);
      OTHER = localFS_ACTION;
      $VALUES = new FS_ACTION[] { Hover, Landing, GoHome, localFS_ACTION };
    }
    
    private FS_ACTION(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static FS_ACTION find(int paramInt)
    {
      FS_ACTION localFS_ACTION = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localFS_ACTION;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetFsAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */