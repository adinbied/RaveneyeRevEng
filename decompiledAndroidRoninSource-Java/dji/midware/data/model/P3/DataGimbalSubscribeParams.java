package dji.midware.data.model.P3;

import dji.midware.data.config.P3.CmdIdGimbal.CmdIdType;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataGimbalSubscribeParams
  extends DataBase
  implements DJIDataSyncListener
{
  private static final String TAG = "DataGimbalSubscribeParams";
  private Map<CmdIdGimbal.CmdIdType, List<Integer>> mCmdMap = new HashMap();
  
  public static DataGimbalSubscribeParams getInstance()
  {
    return InstanceHolder.sInstance;
  }
  
  private byte[] mergeList(List<Integer> paramList)
  {
    return null;
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean hasChannelSubscribed()
  {
    return false;
  }
  
  public boolean isCmdChannelSubscribed(CmdIdGimbal.CmdIdType paramCmdIdType, int paramInt)
  {
    return false;
  }
  
  public boolean isCmdSubscribed(CmdIdGimbal.CmdIdType paramCmdIdType)
  {
    return false;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void subscribeCmdChannel(CmdIdGimbal.CmdIdType arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void unsubscribeCmdChannel(CmdIdGimbal.CmdIdType arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private static class InstanceHolder
  {
    static final DataGimbalSubscribeParams sInstance = new DataGimbalSubscribeParams(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalSubscribeParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */