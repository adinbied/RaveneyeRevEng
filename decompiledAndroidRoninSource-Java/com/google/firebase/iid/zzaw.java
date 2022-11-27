package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;

public final class zzaw
{
  private static zzaw zza;
  private String zzb = null;
  private Boolean zzc = null;
  private Boolean zzd = null;
  private final Queue<Intent> zze = new ArrayDeque();
  
  public static zzaw zza()
  {
    try
    {
      if (zza == null) {
        zza = new zzaw();
      }
      zzaw localzzaw = zza;
      return localzzaw;
    }
    finally {}
  }
  
  private final int zzb(Context paramContext, Intent paramIntent)
  {
    String str2 = zzc(paramContext, paramIntent);
    if (str2 != null)
    {
      if (Log.isLoggable("FirebaseInstanceId", 3))
      {
        String str1 = String.valueOf(str2);
        if (str1.length() != 0) {
          str1 = "Restricting intent to a specific service: ".concat(str1);
        } else {
          str1 = new String("Restricting intent to a specific service: ");
        }
        Log.d("FirebaseInstanceId", str1);
      }
      paramIntent.setClassName(paramContext.getPackageName(), str2);
    }
    try
    {
      if (zza(paramContext))
      {
        paramContext = zzbd.zza(paramContext, paramIntent);
      }
      else
      {
        paramContext = paramContext.startService(paramIntent);
        Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
      }
      if (paramContext == null)
      {
        Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
        return 404;
      }
      return -1;
    }
    catch (IllegalStateException paramContext)
    {
      paramContext = String.valueOf(paramContext);
      paramIntent = new StringBuilder(String.valueOf(paramContext).length() + 45);
      paramIntent.append("Failed to start service while in background: ");
      paramIntent.append(paramContext);
      Log.e("FirebaseInstanceId", paramIntent.toString());
      return 402;
    }
    catch (SecurityException paramContext)
    {
      Log.e("FirebaseInstanceId", "Error while delivering the message to the serviceIntent", paramContext);
    }
    return 401;
  }
  
  private final String zzc(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (this.zzb != null)
      {
        paramContext = this.zzb;
        return paramContext;
      }
      paramIntent = paramContext.getPackageManager().resolveService(paramIntent, 0);
      if ((paramIntent != null) && (paramIntent.serviceInfo != null))
      {
        paramIntent = paramIntent.serviceInfo;
        if ((paramContext.getPackageName().equals(paramIntent.packageName)) && (paramIntent.name != null))
        {
          if (paramIntent.name.startsWith("."))
          {
            paramContext = String.valueOf(paramContext.getPackageName());
            paramIntent = String.valueOf(paramIntent.name);
            if (paramIntent.length() != 0) {
              paramContext = paramContext.concat(paramIntent);
            } else {
              paramContext = new String(paramContext);
            }
            this.zzb = paramContext;
          }
          else
          {
            this.zzb = paramIntent.name;
          }
          paramContext = this.zzb;
          return paramContext;
        }
        paramContext = paramIntent.packageName;
        paramIntent = paramIntent.name;
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramContext).length() + 94 + String.valueOf(paramIntent).length());
        localStringBuilder.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
        localStringBuilder.append(paramContext);
        localStringBuilder.append("/");
        localStringBuilder.append(paramIntent);
        Log.e("FirebaseInstanceId", localStringBuilder.toString());
        return null;
      }
      Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
      return null;
    }
    finally {}
  }
  
  public final int zza(Context paramContext, Intent paramIntent)
  {
    if (Log.isLoggable("FirebaseInstanceId", 3)) {
      Log.d("FirebaseInstanceId", "Starting service");
    }
    this.zze.offer(paramIntent);
    paramIntent = new Intent("com.google.firebase.MESSAGING_EVENT");
    paramIntent.setPackage(paramContext.getPackageName());
    return zzb(paramContext, paramIntent);
  }
  
  final boolean zza(Context paramContext)
  {
    if (this.zzc == null)
    {
      boolean bool;
      if (paramContext.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.zzc = Boolean.valueOf(bool);
    }
    if ((!this.zzc.booleanValue()) && (Log.isLoggable("FirebaseInstanceId", 3))) {
      Log.d("FirebaseInstanceId", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
    }
    return this.zzc.booleanValue();
  }
  
  public final Intent zzb()
  {
    return (Intent)this.zze.poll();
  }
  
  final boolean zzb(Context paramContext)
  {
    if (this.zzd == null)
    {
      boolean bool;
      if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.zzd = Boolean.valueOf(bool);
    }
    if ((!this.zzc.booleanValue()) && (Log.isLoggable("FirebaseInstanceId", 3))) {
      Log.d("FirebaseInstanceId", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
    }
    return this.zzd.booleanValue();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\iid\zzaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */