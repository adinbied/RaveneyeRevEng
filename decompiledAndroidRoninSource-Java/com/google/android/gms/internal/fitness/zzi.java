package com.google.android.gms.internal.fitness;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.DeviceProperties;

public final class zzi
{
  private static int zzek = -1;
  
  public static int zza(Context paramContext)
  {
    if (zzek == -1) {
      if (DeviceProperties.isWearable(paramContext))
      {
        zzek = 3;
      }
      else
      {
        boolean bool = DeviceProperties.isTv(paramContext);
        int j = 0;
        if ((!bool) && (!DeviceProperties.isAuto(paramContext)))
        {
          int i;
          if ((DeviceProperties.isTablet(paramContext.getResources())) && (!zzb(paramContext))) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            zzek = 2;
          }
          else
          {
            i = j;
            if (!TextUtils.isEmpty(Build.PRODUCT))
            {
              i = j;
              if (Build.PRODUCT.startsWith("glass_")) {
                i = 1;
              }
            }
            if (i != 0) {
              zzek = 6;
            } else {
              zzek = 1;
            }
          }
        }
        else
        {
          zzek = 0;
        }
      }
    }
    return zzek;
  }
  
  private static boolean zzb(Context paramContext)
  {
    try
    {
      int i = ((TelephonyManager)paramContext.getSystemService("phone")).getPhoneType();
      return i != 0;
    }
    catch (Resources.NotFoundException paramContext)
    {
      Log.wtf("Fitness", "Unable to determine type of device, assuming phone.", paramContext);
    }
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */