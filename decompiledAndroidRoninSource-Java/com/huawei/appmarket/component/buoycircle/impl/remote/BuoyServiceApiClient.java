package com.huawei.appmarket.component.buoycircle.impl.remote;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.huawei.gamebox.plugin.gameservice.service.ICallback;
import com.huawei.gamebox.plugin.gameservice.service.ICallback.Stub;
import com.huawei.gamebox.plugin.gameservice.service.IGameBuoyService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

public class BuoyServiceApiClient
{
  private static final int DELAY_START_SERVICE = 300;
  private static final int MSG_CONN_TIMEOUT = 2;
  private static final String TAG = "BuoyServiceApiClient";
  private static volatile BuoyServiceApiClient instance = new BuoyServiceApiClient();
  private int isBind = 0;
  private ICallback mCallBack = new ICallback.Stub()
  {
    /* Error */
    public void onInit(int arg1)
      throws android.os.RemoteException
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void openView(String arg1)
      throws android.os.RemoteException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void response(String arg1, String arg2)
      throws android.os.RemoteException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  };
  private Handler mConnectTimeoutHandler = null;
  private WeakReference<Context> mContext;
  private List<GameServiceApiHandler> mInitHandlerList = new ArrayList();
  private boolean mNeedRetryAidl = false;
  private Map<String, GameServiceApiHandler> mReqHandlerTasks = new HashMap();
  private IGameBuoyService remoteService = null;
  private ServiceConnection serverConnection = new ServiceConnection()
  {
    /* Error */
    public void onServiceConnected(android.content.ComponentName arg1, android.os.IBinder arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onServiceDisconnected(android.content.ComponentName arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  private String showBuoyApp;
  private String targetApp;
  
  /* Error */
  private void bindService()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void cancelConnDelayHandle()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static BuoyServiceApiClient getInstance()
  {
    return instance;
  }
  
  /* Error */
  private void notifyInitResult(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void postConnDelayHandle()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void retryAidl()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public Context getContext()
  {
    return null;
  }
  
  public String getShowBuoyApp()
  {
    return this.showBuoyApp;
  }
  
  public String getTargetApp()
  {
    return null;
  }
  
  /* Error */
  public void init(Context arg1, boolean arg2, GameServiceApiHandler arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void registerHandler(String paramString, GameServiceApiHandler paramGameServiceApiHandler)
  {
    this.mReqHandlerTasks.put(paramString, paramGameServiceApiHandler);
  }
  
  /* Error */
  public void request(com.huawei.gamebox.plugin.gameservice.service.RequestInfo arg1, GameServiceApiHandler arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void setShowBuoyApp(String paramString)
  {
    this.showBuoyApp = paramString;
  }
  
  public void setTargetApp(String paramString)
  {
    this.targetApp = paramString;
  }
  
  /* Error */
  public void terminate()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private static abstract interface BIND_STATUS
  {
    public static final int BINDING = 1;
    public static final int BOUND = 2;
    public static final int NOT_BIND = 0;
  }
  
  public static abstract interface GameServiceApiHandler
  {
    public abstract void onResult(int paramInt, String paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\remote\BuoyServiceApiClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */