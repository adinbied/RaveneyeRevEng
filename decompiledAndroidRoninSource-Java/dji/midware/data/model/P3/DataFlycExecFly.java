package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;
import dji.midware.util.BytesUtil;

public class DataFlycExecFly
  extends DataBase
  implements DJIDataSyncListener
{
  private TYPE type;
  
  public static DataFlycExecFly factory()
  {
    return new DataFlycExecFly();
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getAckStatus()
  {
    return BytesUtil.getInt(this._recData);
  }
  
  public DataFlycExecFly setType(TYPE paramTYPE)
  {
    this.type = paramTYPE;
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
  
  public static enum TYPE
  {
    private int data;
    
    static
    {
      AUTO_LANDING = new TYPE("AUTO_LANDING", 2, 3);
      ENTER_SINGAL = new TYPE("ENTER_SINGAL", 3, 4);
      OUT_SINGAL = new TYPE("OUT_SINGAL", 4, 5);
      START_FLY = new TYPE("START_FLY", 5, 7);
      START_TURN = new TYPE("START_TURN", 6, 8);
      TYPE localTYPE = new TYPE("OTHER", 7, 100);
      OTHER = localTYPE;
      $VALUES = new TYPE[] { PAUSE_FLY, RESUME_FLY, AUTO_LANDING, ENTER_SINGAL, OUT_SINGAL, START_FLY, START_TURN, localTYPE };
    }
    
    private TYPE(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static TYPE find(int paramInt)
    {
      TYPE localTYPE = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localTYPE;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycExecFly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */