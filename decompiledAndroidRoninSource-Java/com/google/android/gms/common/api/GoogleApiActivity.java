package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import com.fort.andjni.JniLib;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;

public class GoogleApiActivity
  extends Activity
  implements DialogInterface.OnCancelListener
{
  private int zabp = 0;
  
  public static PendingIntent zaa(Context paramContext, PendingIntent paramPendingIntent, int paramInt)
  {
    return PendingIntent.getActivity(paramContext, 0, zaa(paramContext, paramPendingIntent, paramInt, true), 134217728);
  }
  
  public static Intent zaa(Context paramContext, PendingIntent paramPendingIntent, int paramInt, boolean paramBoolean)
  {
    paramContext = new Intent(paramContext, GoogleApiActivity.class);
    paramContext.putExtra("pending_intent", paramPendingIntent);
    paramContext.putExtra("failing_client_id", paramInt);
    paramContext.putExtra("notify_manager", paramBoolean);
    return paramContext;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      boolean bool = getIntent().getBooleanExtra("notify_manager", true);
      this.zabp = 0;
      setResult(paramInt2, paramIntent);
      if (bool)
      {
        paramIntent = GoogleApiManager.zab(this);
        if (paramInt2 != -1)
        {
          if (paramInt2 == 0) {
            paramIntent.zaa(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
          }
        }
        else {
          paramIntent.zao();
        }
      }
    }
    else if (paramInt1 == 2)
    {
      this.zabp = 0;
      setResult(paramInt2, paramIntent);
    }
    finish();
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.zabp = 0;
    setResult(0);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    JniLib.cV(new Object[] { this, paramBundle, Integer.valueOf(11) });
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putInt("resolution", this.zabp);
    super.onSaveInstanceState(paramBundle);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\GoogleApiActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */