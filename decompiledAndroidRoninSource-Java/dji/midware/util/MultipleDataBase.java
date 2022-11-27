package dji.midware.util;

import dji.midware.data.config.P3.Ccode;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.interfaces.DJIDataSyncListener;

public class MultipleDataBase
  implements DJIDataCallBack
{
  public final String TAG = "MultipleDataBase";
  private Callback cb;
  private int index = 0;
  private DJIDataSyncListener[] listeners;
  
  public MultipleDataBase(DJIDataSyncListener... paramVarArgs)
  {
    this.listeners = paramVarArgs;
  }
  
  /* Error */
  public void onFailure(Ccode arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onSuccess(Object arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void start(Callback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static abstract interface Callback
  {
    public abstract void onFails(int paramInt, Ccode paramCcode);
    
    public abstract void onSuccess();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\util\MultipleDataBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */