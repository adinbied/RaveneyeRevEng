package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRcSetSlavePermission
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcSetSlavePermission instance;
  private RcSlavePermission permission = new RcSlavePermission();
  
  public static DataRcSetSlavePermission getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcSetSlavePermission();
      }
      DataRcSetSlavePermission localDataRcSetSlavePermission = instance;
      return localDataRcSetSlavePermission;
    }
    finally {}
  }
  
  private int getInt(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataRcSetSlavePermission setId(int paramInt)
  {
    this.permission.id = paramInt;
    return this;
  }
  
  public DataRcSetSlavePermission setpitch(boolean paramBoolean)
  {
    this.permission.pitch = paramBoolean;
    return this;
  }
  
  public DataRcSetSlavePermission setplayback(boolean paramBoolean)
  {
    this.permission.playback = paramBoolean;
    return this;
  }
  
  public DataRcSetSlavePermission setrecord(boolean paramBoolean)
  {
    this.permission.record = paramBoolean;
    return this;
  }
  
  public DataRcSetSlavePermission setroll(boolean paramBoolean)
  {
    this.permission.roll = paramBoolean;
    return this;
  }
  
  public DataRcSetSlavePermission settakephoto(boolean paramBoolean)
  {
    this.permission.takephoto = paramBoolean;
    return this;
  }
  
  public DataRcSetSlavePermission setyaw(boolean paramBoolean)
  {
    this.permission.yaw = paramBoolean;
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
  
  public static class RcSlavePermission
  {
    public int id;
    public boolean pitch;
    public boolean playback;
    public boolean record;
    public boolean roll;
    public boolean takephoto;
    public boolean yaw;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcSetSlavePermission.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */