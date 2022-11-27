package com.huawei.android.hms.agent.common;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks;
import com.huawei.hms.api.HuaweiApiClient.OnConnectionFailedListener;
import java.util.ArrayList;
import java.util.List;

public final class ApiClientMgr
  implements HuaweiApiClient.ConnectionCallbacks, HuaweiApiClient.OnConnectionFailedListener, IActivityResumeCallback, IActivityPauseCallback, IActivityDestroyedCallback
{
  private static final int APICLIENT_CONNECT_TIMEOUT = 30000;
  private static final Object APICLIENT_LOCK = new Object();
  private static final int APICLIENT_STARTACTIVITY_TIMEOUT = 3000;
  private static final int APICLIENT_STARTACTIVITY_TIMEOUT_HANDLE_MSG = 4;
  private static final int APICLIENT_TIMEOUT_HANDLE_MSG = 3;
  private static final Object CALLBACK_LOCK;
  public static final ApiClientMgr INST = new ApiClientMgr();
  private static final int MAX_RESOLVE_TIMES = 3;
  private static final String PACKAGE_NAME_HIAPP = "com.huawei.appmarket";
  private static final Object STATIC_CALLBACK_LOCK;
  private static final int UPDATE_OVER_ACTIVITY_CHECK_TIMEOUT = 3000;
  private static final int UPDATE_OVER_ACTIVITY_CHECK_TIMEOUT_HANDLE_MSG = 5;
  private boolean allowResolveConnectError = false;
  private HuaweiApiClient apiClient;
  private List<IClientConnectCallback> connCallbacks = new ArrayList();
  private Context context;
  private String curAppPackageName;
  private int curLeftResolveTimes = 3;
  private boolean hasOverActivity = false;
  private boolean isResolving;
  private BridgeActivity resolveActivity;
  private List<IClientConnectCallback> staticCallbacks = new ArrayList();
  private Handler timeoutHandler = new Handler(new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      return false;
    }
  });
  
  static
  {
    CALLBACK_LOCK = new Object();
    STATIC_CALLBACK_LOCK = new Object();
  }
  
  /* Error */
  private void aSysnCallback(int arg1, IClientConnectCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private static void disConnectClientDelay(HuaweiApiClient paramHuaweiApiClient, int paramInt)
  {
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        this.val$clientTmp.disconnect();
      }
    }, paramInt);
  }
  
  /* Error */
  private void onConnectEnd(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  private HuaweiApiClient resetApiClient()
  {
    return null;
  }
  
  /* Error */
  private void startConnect()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void connect(IClientConnectCallback arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public HuaweiApiClient getApiClient()
  {
    return null;
  }
  
  /* Error */
  public void init(android.app.Application arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isConnect(HuaweiApiClient paramHuaweiApiClient)
  {
    return (paramHuaweiApiClient != null) && (paramHuaweiApiClient.isConnected());
  }
  
  public void onActivityDestroyed(Activity paramActivity1, Activity paramActivity2)
  {
    if (paramActivity2 == null) {
      resetApiClient();
    }
  }
  
  /* Error */
  void onActivityLunched()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onActivityPause(Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onActivityResume(Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onConnected()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onConnectionFailed(com.huawei.hms.api.ConnectionResult arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void onConnectionSuspended(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void onResolveErrorRst(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void registerClientConnect(IClientConnectCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void removeClientConnectCallback(IClientConnectCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\android\hms\agent\common\ApiClientMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */