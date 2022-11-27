package com.google.android.gms.common.internal;

import android.content.Intent;
import androidx.fragment.app.Fragment;

final class zad
  extends DialogRedirect
{
  zad(Intent paramIntent, Fragment paramFragment, int paramInt) {}
  
  public final void redirect()
  {
    Intent localIntent = this.zaoh;
    if (localIntent != null) {
      this.val$fragment.startActivityForResult(localIntent, this.val$requestCode);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\internal\zad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */