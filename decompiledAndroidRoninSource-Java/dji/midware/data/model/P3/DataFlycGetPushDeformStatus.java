package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataFlycGetPushDeformStatus
  extends DataBase
{
  private static DataFlycGetPushDeformStatus instance;
  
  public DataFlycGetPushDeformStatus() {}
  
  public DataFlycGetPushDeformStatus(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public static DataFlycGetPushDeformStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetPushDeformStatus();
      }
      DataFlycGetPushDeformStatus localDataFlycGetPushDeformStatus = instance;
      return localDataFlycGetPushDeformStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public boolean errReasionFixing()
  {
    return false;
  }
  
  public DEFORM_MODE getDeformMode()
  {
    return null;
  }
  
  public DataOsdGetPushCommon.TRIPOD_STATUS getDeformStatus()
  {
    return null;
  }
  
  public boolean isDeformProtected()
  {
    return false;
  }
  
  public boolean isExceptionState()
  {
    return false;
  }
  
  public static enum DEFORM_MODE
  {
    private int data;
    
    static
    {
      Normal = new DEFORM_MODE("Normal", 2, 2);
      DEFORM_MODE localDEFORM_MODE = new DEFORM_MODE("OTHER", 3, 3);
      OTHER = localDEFORM_MODE;
      $VALUES = new DEFORM_MODE[] { Pack, Protect, Normal, localDEFORM_MODE };
    }
    
    private DEFORM_MODE(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static DEFORM_MODE find(int paramInt)
    {
      DEFORM_MODE localDEFORM_MODE = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localDEFORM_MODE;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetPushDeformStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */