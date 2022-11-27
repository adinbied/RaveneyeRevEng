package com.huawei.hms.api;

import android.app.Activity;
import android.content.Context;
import com.huawei.hianalytics.v2.HiAnalytics;
import com.huawei.hianalytics.v2.HiAnalyticsConf.Builder;
import com.huawei.hms.c.h;
import com.huawei.hms.c.j;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class HuaweiApiClient
  implements ApiClient
{
  public abstract void checkUpdate(Activity paramActivity, CheckUpdatelistener paramCheckUpdatelistener);
  
  public abstract void connect(Activity paramActivity);
  
  public abstract void disconnect();
  
  public abstract Activity getTopActivity();
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
  
  public abstract void onPause(Activity paramActivity);
  
  public abstract void onResume(Activity paramActivity);
  
  public abstract void setConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void setConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public abstract boolean setSubAppInfo(SubAppInfo paramSubAppInfo);
  
  public static final class Builder
  {
    private final Context a;
    private final List<Scope> b = new ArrayList();
    private final List<PermissionInfo> c = new ArrayList();
    private final Map<Api<?>, Api.ApiOptions> d = new HashMap();
    private HuaweiApiClient.OnConnectionFailedListener e;
    private HuaweiApiClient.ConnectionCallbacks f;
    
    public Builder(Context paramContext)
      throws NullPointerException
    {
      com.huawei.hms.c.a.a(paramContext, "context must not be null.");
      Object localObject = paramContext.getApplicationContext();
      this.a = ((Context)localObject);
      h.a((Context)localObject);
      boolean bool1 = HiAnalytics.getInitFlag();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Builder->biInitFlag :");
      ((StringBuilder)localObject).append(bool1);
      com.huawei.hms.support.log.a.a("HMS BI", ((StringBuilder)localObject).toString());
      boolean bool2 = j.d(paramContext);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Builder->biSetting :");
      ((StringBuilder)localObject).append(bool2);
      com.huawei.hms.support.log.a.a("HMS BI", ((StringBuilder)localObject).toString());
      if ((!bool1) && (!bool2)) {
        new HiAnalyticsConf.Builder(paramContext).setEnableImei(true).setEnableUDID(true).setEnableSN(true).setCollectURL(0, "https://metrics1.data.hicloud.com:6447").create();
      }
    }
    
    public Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi)
    {
      return null;
    }
    
    public <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> paramApi, O paramO)
    {
      return null;
    }
    
    public Builder addConnectionCallbacks(HuaweiApiClient.ConnectionCallbacks paramConnectionCallbacks)
    {
      com.huawei.hms.c.a.a(paramConnectionCallbacks, "listener must not be null.");
      this.f = paramConnectionCallbacks;
      return this;
    }
    
    public Builder addOnConnectionFailedListener(HuaweiApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      com.huawei.hms.c.a.a(paramOnConnectionFailedListener, "listener must not be null.");
      this.e = paramOnConnectionFailedListener;
      return this;
    }
    
    public Builder addScope(Scope paramScope)
    {
      return null;
    }
    
    public HuaweiApiClient build()
    {
      return null;
    }
  }
  
  public static abstract interface ConnectionCallbacks
  {
    public static final int CAUSE_API_CLIENT_EXPIRED = 3;
    public static final int CAUSE_NETWORK_LOST = 2;
    public static final int CAUSE_SERVICE_DISCONNECTED = 1;
    
    public abstract void onConnected();
    
    public abstract void onConnectionSuspended(int paramInt);
  }
  
  public static abstract interface OnConnectionFailedListener
  {
    public abstract void onConnectionFailed(ConnectionResult paramConnectionResult);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\api\HuaweiApiClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */