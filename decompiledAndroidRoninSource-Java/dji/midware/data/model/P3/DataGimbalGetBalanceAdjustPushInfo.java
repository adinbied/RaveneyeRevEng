package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataGimbalGetBalanceAdjustPushInfo
  extends DataBase
{
  private static final String TAG = "BalanceAdjustPushInfo";
  private static int mGimbalTestStatus = GimbalTestStatus.TEST_NOT_IN_PROCESS.value();
  private static int mPitchAdjustAdvice = GimbalBalanceAdjustAdvice.OTHER.value();
  private static int mPitchTestResult = GimbalTestResult.DEFAULT.value();
  private static int mRollAdjustAdvice = GimbalBalanceAdjustAdvice.OTHER.value();
  private static int mRollTestResult = GimbalTestResult.DEFAULT.value();
  private static int mYawAdjustAdvice = GimbalBalanceAdjustAdvice.OTHER.value();
  private static int mYawTestResult = GimbalTestResult.DEFAULT.value();
  private boolean mSuccess;
  
  public static DataGimbalGetBalanceAdjustPushInfo getInstance()
  {
    return SingletonHolder.mInstance;
  }
  
  protected void doPack() {}
  
  public GimbalTestStatus getGimbalTestStatus()
  {
    return GimbalTestStatus.find(mGimbalTestStatus);
  }
  
  public GimbalBalanceAdjustAdvice getPitchAdjustAdvice()
  {
    return GimbalBalanceAdjustAdvice.find(mPitchAdjustAdvice);
  }
  
  public GimbalTestResult getPitchTestResult()
  {
    return GimbalTestResult.find(mPitchTestResult);
  }
  
  public GimbalBalanceAdjustAdvice getRollAdjustAdvice()
  {
    return GimbalBalanceAdjustAdvice.find(mRollAdjustAdvice);
  }
  
  public GimbalTestResult getRollTestResult()
  {
    return GimbalTestResult.find(mRollTestResult);
  }
  
  public GimbalBalanceAdjustAdvice getYawAdjustAdvice()
  {
    return GimbalBalanceAdjustAdvice.find(mYawAdjustAdvice);
  }
  
  public GimbalTestResult getYawTestResult()
  {
    return GimbalTestResult.find(mYawTestResult);
  }
  
  /* Error */
  protected void setPushRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum GimbalBalanceAdjustAdvice
  {
    private int data;
    
    static
    {
      DOWN = new GimbalBalanceAdjustAdvice("DOWN", 2, 12);
      FORWARD = new GimbalBalanceAdjustAdvice("FORWARD", 3, 16);
      BACK = new GimbalBalanceAdjustAdvice("BACK", 4, 48);
      UP_FORWARD = new GimbalBalanceAdjustAdvice("UP_FORWARD", 5, 20);
      UP_BACK = new GimbalBalanceAdjustAdvice("UP_BACK", 6, 52);
      DOWN_FORWARD = new GimbalBalanceAdjustAdvice("DOWN_FORWARD", 7, 28);
      DOWN_BACK = new GimbalBalanceAdjustAdvice("DOWN_BACK", 8, 60);
      LEFT = new GimbalBalanceAdjustAdvice("LEFT", 9, 1);
      RIGHT = new GimbalBalanceAdjustAdvice("RIGHT", 10, 3);
      GimbalBalanceAdjustAdvice localGimbalBalanceAdjustAdvice = new GimbalBalanceAdjustAdvice("OTHER", 11, 100);
      OTHER = localGimbalBalanceAdjustAdvice;
      $VALUES = new GimbalBalanceAdjustAdvice[] { NONE, UP, DOWN, FORWARD, BACK, UP_FORWARD, UP_BACK, DOWN_FORWARD, DOWN_BACK, LEFT, RIGHT, localGimbalBalanceAdjustAdvice };
    }
    
    private GimbalBalanceAdjustAdvice(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static GimbalBalanceAdjustAdvice find(int paramInt)
    {
      GimbalBalanceAdjustAdvice localGimbalBalanceAdjustAdvice = OTHER;
      GimbalBalanceAdjustAdvice[] arrayOfGimbalBalanceAdjustAdvice = values();
      int i = 0;
      while (i < arrayOfGimbalBalanceAdjustAdvice.length)
      {
        if (arrayOfGimbalBalanceAdjustAdvice[i]._equals(paramInt)) {
          return arrayOfGimbalBalanceAdjustAdvice[i];
        }
        i += 1;
      }
      return localGimbalBalanceAdjustAdvice;
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
  
  public static enum GimbalTestResult
  {
    private int data;
    
    static
    {
      OKAY = new GimbalTestResult("OKAY", 2, 10);
      GimbalTestResult localGimbalTestResult = new GimbalTestResult("BAD", 3, 11);
      BAD = localGimbalTestResult;
      $VALUES = new GimbalTestResult[] { DEFAULT, PERFECT, OKAY, localGimbalTestResult };
    }
    
    private GimbalTestResult(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static GimbalTestResult find(int paramInt)
    {
      GimbalTestResult localGimbalTestResult = DEFAULT;
      GimbalTestResult[] arrayOfGimbalTestResult = values();
      int i = 0;
      while (i < arrayOfGimbalTestResult.length)
      {
        if (arrayOfGimbalTestResult[i]._equals(paramInt)) {
          return arrayOfGimbalTestResult[i];
        }
        i += 1;
      }
      return localGimbalTestResult;
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
  
  public static enum GimbalTestStatus
  {
    private int data;
    
    static
    {
      TEST_IN_PROCESS = new GimbalTestStatus("TEST_IN_PROCESS", 1, 1);
      TEST_FINISHED = new GimbalTestStatus("TEST_FINISHED", 2, 10);
      GimbalTestStatus localGimbalTestStatus = new GimbalTestStatus("TEST_ERROR", 3, 11);
      TEST_ERROR = localGimbalTestStatus;
      $VALUES = new GimbalTestStatus[] { TEST_NOT_IN_PROCESS, TEST_IN_PROCESS, TEST_FINISHED, localGimbalTestStatus };
    }
    
    private GimbalTestStatus(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static GimbalTestStatus find(int paramInt)
    {
      GimbalTestStatus localGimbalTestStatus = TEST_NOT_IN_PROCESS;
      GimbalTestStatus[] arrayOfGimbalTestStatus = values();
      int i = 0;
      while (i < arrayOfGimbalTestStatus.length)
      {
        if (arrayOfGimbalTestStatus[i]._equals(paramInt)) {
          return arrayOfGimbalTestStatus[i];
        }
        i += 1;
      }
      return localGimbalTestStatus;
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
  
  private static final class SingletonHolder
  {
    private static final DataGimbalGetBalanceAdjustPushInfo mInstance = new DataGimbalGetBalanceAdjustPushInfo();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalGetBalanceAdjustPushInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */