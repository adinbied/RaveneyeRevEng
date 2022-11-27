package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRcCoachMode
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcCoachMode instance;
  private CoachMode mCoachMode = CoachMode.DISABLE;
  private OptMode mOptMode = OptMode.GET;
  private byte[] mSnBytes = null;
  
  public static DataRcCoachMode getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcCoachMode();
      }
      DataRcCoachMode localDataRcCoachMode = instance;
      return localDataRcCoachMode;
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
  
  public CoachMode getCoachMode()
  {
    return null;
  }
  
  public DataRcCoachMode setCoachMode(CoachMode paramCoachMode)
  {
    this.mCoachMode = paramCoachMode;
    return this;
  }
  
  public DataRcCoachMode setOptMode(OptMode paramOptMode)
  {
    this.mOptMode = paramOptMode;
    return this;
  }
  
  public DataRcCoachMode setSnBytes(byte[] paramArrayOfByte)
  {
    this.mSnBytes = paramArrayOfByte;
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
  
  public static enum CoachMode
  {
    private int _value = 0;
    
    static
    {
      DISABLE = new CoachMode("DISABLE", 1, 1);
      CoachMode localCoachMode = new CoachMode("ENABLE", 2, 2);
      ENABLE = localCoachMode;
      $VALUES = new CoachMode[] { UNACTIVE, DISABLE, localCoachMode };
    }
    
    private CoachMode(int paramInt)
    {
      this._value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this._value == paramInt;
    }
    
    public static CoachMode find(int paramInt)
    {
      CoachMode[] arrayOfCoachMode = values();
      int j = arrayOfCoachMode.length;
      int i = 0;
      while (i < j)
      {
        CoachMode localCoachMode = arrayOfCoachMode[i];
        if (localCoachMode._equals(paramInt)) {
          return localCoachMode;
        }
        i += 1;
      }
      return DISABLE;
    }
    
    public int value()
    {
      return this._value;
    }
  }
  
  public static enum OptMode
  {
    private int _value = 0;
    
    static
    {
      OptMode localOptMode = new OptMode("ACTIVE", 2, 2);
      ACTIVE = localOptMode;
      $VALUES = new OptMode[] { GET, SET, localOptMode };
    }
    
    private OptMode(int paramInt)
    {
      this._value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this._value == paramInt;
    }
    
    public static OptMode find(int paramInt)
    {
      OptMode[] arrayOfOptMode = values();
      int j = arrayOfOptMode.length;
      int i = 0;
      while (i < j)
      {
        OptMode localOptMode = arrayOfOptMode[i];
        if (localOptMode._equals(paramInt)) {
          return localOptMode;
        }
        i += 1;
      }
      return GET;
    }
    
    public int value()
    {
      return this._value;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcCoachMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */