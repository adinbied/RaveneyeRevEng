package com.google.firebase.iid;

import android.os.Bundle;

final class zzak
  extends zzan<Void>
{
  zzak(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    super(paramInt1, 2, paramBundle);
  }
  
  final void zza(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("ack", false))
    {
      zza(null);
      return;
    }
    zza(new zzam(4, "Invalid response to one way request"));
  }
  
  final boolean zza()
  {
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\iid\zzak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */