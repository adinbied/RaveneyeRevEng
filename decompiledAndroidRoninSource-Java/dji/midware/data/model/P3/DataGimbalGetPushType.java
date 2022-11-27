package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataGimbalGetPushType
  extends DataBase
{
  private static final int PUSH_LOST_DELAY_MILLIS = 3000;
  private static final String TAG = "DataGimbalGetPushType";
  private static DataGimbalGetPushType instance;
  
  private DataGimbalGetPushType()
  {
    this.isNeedPushLosed = true;
  }
  
  public DataGimbalGetPushType(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public static DataGimbalGetPushType getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataGimbalGetPushType();
      }
      DataGimbalGetPushType localDataGimbalGetPushType = instance;
      return localDataGimbalGetPushType;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public DJIGimbalType getType()
  {
    return null;
  }
  
  /* Error */
  protected void setPushLose()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void setPushRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void setPushRecPack(dji.midware.data.packages.P3.Pack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum DJIGimbalType
  {
    private int data;
    
    static
    {
      FAULT = new DJIGimbalType("FAULT", 1, 1);
      FC550 = new DJIGimbalType("FC550", 2, 2);
      FC300SX = new DJIGimbalType("FC300SX", 3, 3);
      FC260 = new DJIGimbalType("FC260", 4, 4);
      FC350 = new DJIGimbalType("FC350", 5, 5);
      FC350Z = new DJIGimbalType("FC350Z", 6, 6);
      Z15 = new DJIGimbalType("Z15", 7, 7);
      P4 = new DJIGimbalType("P4", 8, 8);
      Ronin = new DJIGimbalType("Ronin", 9, 10);
      D5 = new DJIGimbalType("D5", 10, 11);
      GH4 = new DJIGimbalType("GH4", 11, 12);
      A7 = new DJIGimbalType("A7", 12, 13);
      BMPCC = new DJIGimbalType("BMPCC", 13, 14);
      WM330 = new DJIGimbalType("WM330", 14, 15);
      WM331 = new DJIGimbalType("WM331", 15, 16);
      WM620_X5S = new DJIGimbalType("WM620_X5S", 16, 17);
      WM620_OneInch = new DJIGimbalType("WM620_OneInch", 17, 18);
      GD600 = new DJIGimbalType("GD600", 18, 19);
      WM220 = new DJIGimbalType("WM220", 19, 20);
      WM620_FullFrame = new DJIGimbalType("WM620_FullFrame", 20, 21);
      Ronin2 = new DJIGimbalType("Ronin2", 21, 23);
      RoninS = new DJIGimbalType("RoninS", 22, 25);
      RoninSC = new DJIGimbalType("RoninSC", 23, 40);
      HG702 = new DJIGimbalType("HG702", 24, 48);
      HG710 = new DJIGimbalType("HG710", 25, 49);
      DJIGimbalType localDJIGimbalType = new DJIGimbalType("OTHER", 26, 100);
      OTHER = localDJIGimbalType;
      $VALUES = new DJIGimbalType[] { TIMEOUT, FAULT, FC550, FC300SX, FC260, FC350, FC350Z, Z15, P4, Ronin, D5, GH4, A7, BMPCC, WM330, WM331, WM620_X5S, WM620_OneInch, GD600, WM220, WM620_FullFrame, Ronin2, RoninS, RoninSC, HG702, HG710, localDJIGimbalType };
    }
    
    private DJIGimbalType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static DJIGimbalType find(int paramInt)
    {
      DJIGimbalType localDJIGimbalType = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localDJIGimbalType;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalGetPushType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */