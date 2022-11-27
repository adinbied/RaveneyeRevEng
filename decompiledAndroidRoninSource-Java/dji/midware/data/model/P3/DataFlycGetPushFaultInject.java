package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataFlycGetPushFaultInject
  extends DataBase
{
  private static DataFlycGetPushFaultInject instance;
  
  public static DataFlycGetPushFaultInject getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetPushFaultInject();
      }
      DataFlycGetPushFaultInject localDataFlycGetPushFaultInject = instance;
      return localDataFlycGetPushFaultInject;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public INJECT_STATUS getStatus()
  {
    return null;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return true;
  }
  
  public static enum INJECT_STATUS
  {
    private int data;
    
    static
    {
      FIT_OPEN_FAILED = new INJECT_STATUS("FIT_OPEN_FAILED", 1, 2);
      FIT_OPEN_SUCCESS = new INJECT_STATUS("FIT_OPEN_SUCCESS", 2, 3);
      FIT_CLOSE_SUCCESS = new INJECT_STATUS("FIT_CLOSE_SUCCESS", 3, 4);
      FIT_INJECT_SUCCESS = new INJECT_STATUS("FIT_INJECT_SUCCESS", 4, 5);
      FIT_INJECT_FAILED = new INJECT_STATUS("FIT_INJECT_FAILED", 5, 6);
      FIT_FDI_DETECT_SUCCESS = new INJECT_STATUS("FIT_FDI_DETECT_SUCCESS", 6, 7);
      FIT_FDI_DETECT_FAILED = new INJECT_STATUS("FIT_FDI_DETECT_FAILED", 7, 8);
      FIT_AUTO_STOP_FOR_SAFE = new INJECT_STATUS("FIT_AUTO_STOP_FOR_SAFE", 8, 9);
      FIT_TIME_PARA_INVALID = new INJECT_STATUS("FIT_TIME_PARA_INVALID", 9, 10);
      FIT_DENY_FOR_UNSAFE = new INJECT_STATUS("FIT_DENY_FOR_UNSAFE", 10, 11);
      FIT_DENY_FOR_FAULT = new INJECT_STATUS("FIT_DENY_FOR_FAULT", 11, 12);
      FIT_DENY_FOR_DISCONNECT = new INJECT_STATUS("FIT_DENY_FOR_DISCONNECT", 12, 13);
      FIT_UNKNOWN_FAULT_TYPE = new INJECT_STATUS("FIT_UNKNOWN_FAULT_TYPE", 13, 14);
      FIT_INVALID_SYSTEM_ID = new INJECT_STATUS("FIT_INVALID_SYSTEM_ID", 14, 15);
      FIT_UNKNOWN_MODULE_TYPE = new INJECT_STATUS("FIT_UNKNOWN_MODULE_TYPE", 15, 16);
      FIT_MODULE_CANNOT_FOUND = new INJECT_STATUS("FIT_MODULE_CANNOT_FOUND", 16, 17);
      FIT_UNKNOWN_CMD_ID = new INJECT_STATUS("FIT_UNKNOWN_CMD_ID", 17, 18);
      FIT_UNSUPPORT_NOW = new INJECT_STATUS("FIT_UNSUPPORT_NOW", 18, 19);
      FIT_DENY_FOR_UNOPEN = new INJECT_STATUS("FIT_DENY_FOR_UNOPEN", 19, 20);
      FIT_DENY_FOR_FUNC_CLOSED = new INJECT_STATUS("FIT_DENY_FOR_FUNC_CLOSED", 20, 21);
      FIT_MSG_LEN_ERR = new INJECT_STATUS("FIT_MSG_LEN_ERR", 21, 22);
      INJECT_STATUS localINJECT_STATUS = new INJECT_STATUS("FIT_ROUTE_FAILED", 22, 23);
      FIT_ROUTE_FAILED = localINJECT_STATUS;
      $VALUES = new INJECT_STATUS[] { FIT_VERSION_UNMATCH, FIT_OPEN_FAILED, FIT_OPEN_SUCCESS, FIT_CLOSE_SUCCESS, FIT_INJECT_SUCCESS, FIT_INJECT_FAILED, FIT_FDI_DETECT_SUCCESS, FIT_FDI_DETECT_FAILED, FIT_AUTO_STOP_FOR_SAFE, FIT_TIME_PARA_INVALID, FIT_DENY_FOR_UNSAFE, FIT_DENY_FOR_FAULT, FIT_DENY_FOR_DISCONNECT, FIT_UNKNOWN_FAULT_TYPE, FIT_INVALID_SYSTEM_ID, FIT_UNKNOWN_MODULE_TYPE, FIT_MODULE_CANNOT_FOUND, FIT_UNKNOWN_CMD_ID, FIT_UNSUPPORT_NOW, FIT_DENY_FOR_UNOPEN, FIT_DENY_FOR_FUNC_CLOSED, FIT_MSG_LEN_ERR, localINJECT_STATUS };
    }
    
    private INJECT_STATUS(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static INJECT_STATUS find(int paramInt)
    {
      INJECT_STATUS localINJECT_STATUS = FIT_VERSION_UNMATCH;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localINJECT_STATUS;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetPushFaultInject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */