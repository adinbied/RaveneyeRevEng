package com.huawei.hms.api;

import android.app.Activity;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import com.huawei.hms.c.j;
import com.huawei.hms.core.aidl.e;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.BundleResult;
import com.huawei.hms.support.api.client.InnerApiClient;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class HuaweiApiClientImpl
  extends HuaweiApiClient
  implements ServiceConnection, InnerApiClient
{
  private static final Object t = new Object();
  private final Context a;
  private String b;
  private String c;
  private final String d;
  private volatile e e;
  private String f;
  private WeakReference<Activity> g;
  private WeakReference<Activity> h;
  private boolean i = false;
  private AtomicInteger j = new AtomicInteger(1);
  private List<Scope> k;
  private List<PermissionInfo> l;
  private Map<Api<?>, Api.ApiOptions> m;
  private SubAppInfo n;
  private long o = 0L;
  private int p = 0;
  private HuaweiApiClient.ConnectionCallbacks q;
  private HuaweiApiClient.OnConnectionFailedListener r;
  private Handler s = null;
  private CheckUpdatelistener u = null;
  private CheckUpdateCallBack v = new f(this);
  
  public HuaweiApiClientImpl(Context paramContext)
  {
    this.a = paramContext;
    String str = j.a(paramContext);
    this.d = str;
    this.b = str;
    this.c = j.c(paramContext);
  }
  
  private int a()
  {
    return 0;
  }
  
  private void a(int paramInt)
  {
    this.j.set(paramInt);
  }
  
  /* Error */
  private void a(ResolveResult<DisconnectResp> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private int b()
  {
    return 0;
  }
  
  /* Error */
  private void b(ResolveResult<ConnectResp> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean c()
  {
    return false;
  }
  
  private boolean d()
  {
    return false;
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private DisconnectInfo i()
  {
    return null;
  }
  
  /* Error */
  private void j()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private ConnectInfo k()
  {
    return null;
  }
  
  private void l()
  {
    j.a(this.a, this);
  }
  
  /* Error */
  private void m()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int asyncRequest(Bundle paramBundle, String paramString, int paramInt, ResultCallback<BundleResult> paramResultCallback)
  {
    return 0;
  }
  
  /* Error */
  public void checkUpdate(Activity arg1, CheckUpdatelistener arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void connect(Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void disconnect()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Map<Api<?>, Api.ApiOptions> getApiMap()
  {
    return this.m;
  }
  
  public List<String> getApiNameList()
  {
    return null;
  }
  
  public String getAppID()
  {
    return this.b;
  }
  
  public Context getContext()
  {
    return this.a;
  }
  
  public String getCpID()
  {
    return this.c;
  }
  
  public String getPackageName()
  {
    return this.a.getPackageName();
  }
  
  public List<PermissionInfo> getPermissionInfos()
  {
    return this.l;
  }
  
  public List<Scope> getScopes()
  {
    return this.k;
  }
  
  public e getService()
  {
    return this.e;
  }
  
  public String getSessionId()
  {
    return this.f;
  }
  
  public final SubAppInfo getSubAppInfo()
  {
    return this.n;
  }
  
  public Activity getTopActivity()
  {
    return null;
  }
  
  public String getTransportName()
  {
    return IPCTransport.class.getName();
  }
  
  public boolean innerIsConnected()
  {
    return false;
  }
  
  public boolean isConnected()
  {
    return false;
  }
  
  public boolean isConnecting()
  {
    return false;
  }
  
  /* Error */
  public void onPause(Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onResume(Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
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
  
  public void setApiMap(Map<Api<?>, Api.ApiOptions> paramMap)
  {
    this.m = paramMap;
  }
  
  public void setConnectionCallbacks(HuaweiApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.q = paramConnectionCallbacks;
  }
  
  public void setConnectionFailedListener(HuaweiApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.r = paramOnConnectionFailedListener;
  }
  
  public void setHasShowNotice(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setPermissionInfos(List<PermissionInfo> paramList)
  {
    this.l = paramList;
  }
  
  public void setScopes(List<Scope> paramList)
  {
    this.k = paramList;
  }
  
  public boolean setSubAppInfo(SubAppInfo paramSubAppInfo)
  {
    return false;
  }
  
  private class a
    implements ResultCallback<ResolveResult<ConnectResp>>
  {
    private a() {}
    
    /* Error */
    public void a(ResolveResult<ConnectResp> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  private class b
    implements ResultCallback<ResolveResult<DisconnectResp>>
  {
    private b() {}
    
    /* Error */
    public void a(ResolveResult<DisconnectResp> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  private class c
    implements ResultCallback<ResolveResult<JosGetNoticeResp>>
  {
    private c() {}
    
    /* Error */
    public void a(ResolveResult<JosGetNoticeResp> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\api\HuaweiApiClientImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */