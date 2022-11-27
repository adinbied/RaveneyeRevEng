package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DJIGimbalParamInfoManager;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.params.P3.ParamInfo;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataGimbalRoninSetUserParams
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataGimbalRoninSetUserParams instance;
  private String[] indexs = null;
  private int mTimeOut = -1;
  private ParamInfo paramInfo;
  private Number value;
  private Number[] values = null;
  
  public static DataGimbalRoninSetUserParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataGimbalRoninSetUserParams();
      }
      DataGimbalRoninSetUserParams localDataGimbalRoninSetUserParams = instance;
      return localDataGimbalRoninSetUserParams;
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
  
  public DataGimbalRoninSetUserParams setIndexs(String... paramVarArgs)
  {
    this.indexs = paramVarArgs;
    return this;
  }
  
  public DataGimbalRoninSetUserParams setInfo(String paramString)
  {
    paramString = DJIGimbalParamInfoManager.read(paramString);
    this.paramInfo = paramString;
    this.value = paramString.setvalue;
    return this;
  }
  
  public DataGimbalRoninSetUserParams setInfo(String paramString, Number paramNumber)
  {
    this.paramInfo = DJIGimbalParamInfoManager.read(paramString);
    this.value = paramNumber;
    return this;
  }
  
  /* Error */
  public void setRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataGimbalRoninSetUserParams setTimeOut(int paramInt)
  {
    this.mTimeOut = paramInt;
    return this;
  }
  
  public DataGimbalRoninSetUserParams setValues(Number... paramVarArgs)
  {
    this.values = paramVarArgs;
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
  
  public static enum HoldType
  {
    int id;
    
    static
    {
      CAR = new HoldType("CAR", 1, 1);
      HAND = new HoldType("HAND", 2, 2);
      MACHINE = new HoldType("MACHINE", 3, 3);
      HoldType localHoldType = new HoldType("TRIPOD", 4, 4);
      TRIPOD = localHoldType;
      $VALUES = new HoldType[] { NONE, CAR, HAND, MACHINE, localHoldType };
    }
    
    private HoldType(int paramInt)
    {
      this.id = paramInt;
    }
    
    public static HoldType find(int paramInt)
    {
      Object localObject = NONE;
      HoldType[] arrayOfHoldType = values();
      int j = arrayOfHoldType.length;
      int i = 0;
      while (i < j)
      {
        HoldType localHoldType = arrayOfHoldType[i];
        if (localHoldType.id == paramInt) {
          localObject = localHoldType;
        }
        i += 1;
      }
      return (HoldType)localObject;
    }
  }
  
  public static enum WorkMode
  {
    int id;
    
    static
    {
      FOLLOW = new WorkMode("FOLLOW", 1, 1);
      FPV = new WorkMode("FPV", 2, 2);
      CENTER = new WorkMode("CENTER", 3, 3);
      WorkMode localWorkMode = new WorkMode("UNKNOWN", 4, 127);
      UNKNOWN = localWorkMode;
      $VALUES = new WorkMode[] { FREE, FOLLOW, FPV, CENTER, localWorkMode };
    }
    
    private WorkMode(int paramInt)
    {
      this.id = paramInt;
    }
    
    public static WorkMode find(int paramInt)
    {
      Object localObject = UNKNOWN;
      WorkMode[] arrayOfWorkMode = values();
      int j = arrayOfWorkMode.length;
      int i = 0;
      while (i < j)
      {
        WorkMode localWorkMode = arrayOfWorkMode[i];
        if (localWorkMode.id == paramInt) {
          localObject = localWorkMode;
        }
        i += 1;
      }
      return (WorkMode)localObject;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalRoninSetUserParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */