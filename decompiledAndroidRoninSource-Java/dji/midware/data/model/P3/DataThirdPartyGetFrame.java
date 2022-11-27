package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJICameraDataBase;
import dji.midware.interfaces.DJIDataSyncListener;
import java.util.ArrayList;
import java.util.List;

public class DataThirdPartyGetFrame
  extends DJICameraDataBase
  implements DJIDataSyncListener
{
  private static final String TAG = "DataThirdPartyGetFrame";
  private int mCurFrame;
  private List<Integer> mFrameList = new ArrayList();
  private int mSupportedFrameNum;
  
  public static DataThirdPartyGetFrame getInstance()
  {
    return SingletonHolder.mInstance;
  }
  
  protected void doPack() {}
  
  public int getCurFrame()
  {
    return this.mCurFrame;
  }
  
  public List<Integer> getSupportedFrameList()
  {
    return this.mFrameList;
  }
  
  public int getSupportedFrameNum()
  {
    return this.mSupportedFrameNum;
  }
  
  /* Error */
  public void setRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
    private static final DataThirdPartyGetFrame mInstance = new DataThirdPartyGetFrame();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataThirdPartyGetFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */