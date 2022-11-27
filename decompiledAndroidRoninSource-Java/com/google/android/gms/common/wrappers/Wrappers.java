package com.google.android.gms.common.wrappers;

import android.content.Context;

public class Wrappers
{
  private static Wrappers zzhz = new Wrappers();
  private PackageManagerWrapper zzhy = null;
  
  public static PackageManagerWrapper packageManager(Context paramContext)
  {
    return zzhz.zzi(paramContext);
  }
  
  private final PackageManagerWrapper zzi(Context paramContext)
  {
    try
    {
      if (this.zzhy == null)
      {
        if (paramContext.getApplicationContext() != null) {
          paramContext = paramContext.getApplicationContext();
        }
        this.zzhy = new PackageManagerWrapper(paramContext);
      }
      paramContext = this.zzhy;
      return paramContext;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\wrappers\Wrappers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */