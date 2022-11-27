package com.huawei.hms.support.api.hwid;

import android.app.Activity;
import android.content.Intent;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.support.api.client.PendingResult;

public abstract interface HuaweiIdApi
{
  public abstract SignInResult getSignInResultFromIntent(Intent paramIntent);
  
  public abstract PendingResult<SignInResult> signIn(Activity paramActivity, HuaweiApiClient paramHuaweiApiClient);
  
  public abstract PendingResult<SignInResult> signInBackend(HuaweiApiClient paramHuaweiApiClient);
  
  public abstract PendingResult<SignOutResult> signOut(HuaweiApiClient paramHuaweiApiClient);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\hwid\HuaweiIdApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */