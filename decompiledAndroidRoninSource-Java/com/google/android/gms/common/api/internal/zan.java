package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Dialog;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

final class zan
  implements Runnable
{
  private final zam zadj;
  
  zan(zal paramzal, zam paramzam)
  {
    this.zadj = paramzam;
  }
  
  public final void run()
  {
    if (!this.zadk.mStarted) {
      return;
    }
    Object localObject = this.zadj.getConnectionResult();
    if (((ConnectionResult)localObject).hasResolution())
    {
      this.zadk.mLifecycleFragment.startActivityForResult(GoogleApiActivity.zaa(this.zadk.getActivity(), ((ConnectionResult)localObject).getResolution(), this.zadj.zar(), false), 1);
      return;
    }
    if (this.zadk.zacd.isUserResolvableError(((ConnectionResult)localObject).getErrorCode()))
    {
      this.zadk.zacd.zaa(this.zadk.getActivity(), this.zadk.mLifecycleFragment, ((ConnectionResult)localObject).getErrorCode(), 2, this.zadk);
      return;
    }
    if (((ConnectionResult)localObject).getErrorCode() == 18)
    {
      localObject = GoogleApiAvailability.zaa(this.zadk.getActivity(), this.zadk);
      this.zadk.zacd.zaa(this.zadk.getActivity().getApplicationContext(), new zao(this, (Dialog)localObject));
      return;
    }
    this.zadk.zaa((ConnectionResult)localObject, this.zadj.zar());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */