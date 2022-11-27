package com.huawei.appmarket.component.buoycircle.impl.remote;

import com.huawei.gamebox.plugin.gameservice.service.RequestInfo;

public class RemoteApiManager
{
  public static final String GAMESERVICE_SDK_VERSION_CODE = "70301300";
  public static final String GAMESERVICE_SDK_VERSION_NAME = "7.3.1.300";
  private static final String TAG = "RemoteApiManager";
  private static RemoteApiManager instance = new RemoteApiManager();
  private RunTask onServiceDisconnectTask;
  private RunTask removeSmallBuoyTask;
  
  /* Error */
  private void callBuoy(android.content.Context arg1, RequestInfo arg2, SequentialTaskManager.RunTaskResultHandler arg3, boolean arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static RemoteApiManager getInstance()
  {
    return instance;
  }
  
  private RequestInfo getRequestInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    return null;
  }
  
  /* Error */
  public void finishBuoyDialog(android.content.Context arg1, SequentialTaskManager.RunTaskResultHandler arg2, String arg3, String arg4, String arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void getBuoyEntryInfo(android.content.Context arg1, SequentialTaskManager.RunTaskResultHandler arg2, String arg3, String arg4, String arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void getBuoyNewRedNotice(android.content.Context arg1, SequentialTaskManager.RunTaskResultHandler arg2, String arg3, String arg4, String arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void getBuoyRedInfo(android.content.Context arg1, SequentialTaskManager.RunTaskResultHandler arg2, String arg3, String arg4, String arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public RunTask getOnServiceDisconnectTask()
  {
    return this.onServiceDisconnectTask;
  }
  
  public RunTask getRemoveSmallBuoyTask()
  {
    return this.removeSmallBuoyTask;
  }
  
  public void setOnServiceDisconnectTask(RunTask paramRunTask)
  {
    this.onServiceDisconnectTask = paramRunTask;
  }
  
  public void setRemoveSmallBuoyTask(RunTask paramRunTask)
  {
    this.removeSmallBuoyTask = paramRunTask;
  }
  
  /* Error */
  public void showBuoyDialog(android.content.Context arg1, SequentialTaskManager.RunTaskResultHandler arg2, int arg3, String arg4, String arg5, String arg6)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void switchGameSubAcct(BuoyServiceApiClient.GameServiceApiHandler arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static abstract interface Method
  {
    public static final String FINISH_BUOY_DIALOG = "finishBuoyDialog";
    public static final String GET_BUOY_ENTRY_INFO = "getGameBuoyEntryInfo";
    public static final String GET_BUOY_NEW_RED_NOTICE = "getBuoyNewRedNotice";
    public static final String GET_BUOY_RED_INFO = "getBuoyRedInfo";
    public static final String SHOW_BUOY_DIALOG = "showBuoyDialog";
    public static final String SWITCH_GAME_SUBACCT = "switchGameSubAcct";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\remote\RemoteApiManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */