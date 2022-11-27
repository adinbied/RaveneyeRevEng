package com.huawei.hms.support.api.hwid;

import android.app.Activity;
import android.content.Intent;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.api.HuaweiApiClientImpl;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.c;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.api.entity.hwid.SignOutResp;
import java.lang.ref.WeakReference;
import java.util.List;

public class HuaweiIdApiImpl
  implements HuaweiIdApi
{
  private HuaweiApiClient a = null;
  private WeakReference<Activity> b = null;
  
  static List<Scope> a(HuaweiApiClient paramHuaweiApiClient)
  {
    return ((HuaweiApiClientImpl)paramHuaweiApiClient).getScopes();
  }
  
  /* Error */
  private void a(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  static List<PermissionInfo> b(HuaweiApiClient paramHuaweiApiClient)
  {
    return ((HuaweiApiClientImpl)paramHuaweiApiClient).getPermissionInfos();
  }
  
  public SignInResult getSignInResultFromIntent(Intent paramIntent)
  {
    return null;
  }
  
  public PendingResult<SignInResult> signIn(Activity paramActivity, HuaweiApiClient paramHuaweiApiClient)
  {
    return null;
  }
  
  public PendingResult<SignInResult> signInBackend(HuaweiApiClient paramHuaweiApiClient)
  {
    return null;
  }
  
  public PendingResult<SignOutResult> signOut(HuaweiApiClient paramHuaweiApiClient)
  {
    return null;
  }
  
  private class a
    implements ResultCallback<ResolveResult<JosGetNoticeResp>>
  {
    private a() {}
    
    /* Error */
    public void a(ResolveResult<JosGetNoticeResp> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static class b
    extends c<SignOutResult, SignOutResp>
  {
    public b(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
    {
      super(paramString, paramIMessageEntity);
    }
    
    public SignOutResult a(SignOutResp paramSignOutResp)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\hwid\HuaweiIdApiImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */