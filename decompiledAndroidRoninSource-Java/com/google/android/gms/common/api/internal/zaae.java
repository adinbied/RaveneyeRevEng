package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

public class zaae
  extends zal
{
  private GoogleApiManager zabm;
  private final ArraySet<zai<?>> zafp = new ArraySet();
  
  private zaae(LifecycleFragment paramLifecycleFragment)
  {
    super(paramLifecycleFragment);
    this.mLifecycleFragment.addCallback("ConnectionlessLifecycleHelper", this);
  }
  
  public static void zaa(Activity paramActivity, GoogleApiManager paramGoogleApiManager, zai<?> paramzai)
  {
    LifecycleFragment localLifecycleFragment = getFragment(paramActivity);
    zaae localzaae = (zaae)localLifecycleFragment.getCallbackOrNull("ConnectionlessLifecycleHelper", zaae.class);
    paramActivity = localzaae;
    if (localzaae == null) {
      paramActivity = new zaae(localLifecycleFragment);
    }
    paramActivity.zabm = paramGoogleApiManager;
    Preconditions.checkNotNull(paramzai, "ApiKey cannot be null");
    paramActivity.zafp.add(paramzai);
    paramGoogleApiManager.zaa(paramActivity);
  }
  
  private final void zaak()
  {
    if (!this.zafp.isEmpty()) {
      this.zabm.zaa(this);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    zaak();
  }
  
  public void onStart()
  {
    super.onStart();
    zaak();
  }
  
  public void onStop()
  {
    super.onStop();
    this.zabm.zab(this);
  }
  
  protected final void zaa(ConnectionResult paramConnectionResult, int paramInt)
  {
    this.zabm.zaa(paramConnectionResult, paramInt);
  }
  
  final ArraySet<zai<?>> zaaj()
  {
    return this.zafp;
  }
  
  protected final void zao()
  {
    this.zabm.zao();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zaae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */