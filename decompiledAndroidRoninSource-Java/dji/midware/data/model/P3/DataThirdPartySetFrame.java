package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJICameraDataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataThirdPartySetFrame
  extends DJICameraDataBase
  implements DJIDataSyncListener
{
  private static final String TAG = "DataThirdPartySetFrame";
  private int mFrame;
  
  public static DataThirdPartySetFrame getInstance()
  {
    return SingletonHolder.mInstance;
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataThirdPartySetFrame setFrame(int paramInt)
  {
    this.mFrame = paramInt;
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
  
  private static final class SingletonHolder
  {
    private static final DataThirdPartySetFrame mInstance = new DataThirdPartySetFrame();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataThirdPartySetFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */