package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
public class GoogleSignatureVerifier
{
  private static GoogleSignatureVerifier zzam;
  private final Context mContext;
  private volatile String zzan;
  
  private GoogleSignatureVerifier(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
  }
  
  public static GoogleSignatureVerifier getInstance(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    try
    {
      if (zzam == null)
      {
        zzc.zza(paramContext);
        zzam = new GoogleSignatureVerifier(paramContext);
      }
      return zzam;
    }
    finally {}
  }
  
  private static zze zza(PackageInfo paramPackageInfo, zze... paramVarArgs)
  {
    if (paramPackageInfo.signatures == null) {
      return null;
    }
    if (paramPackageInfo.signatures.length != 1)
    {
      Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
      return null;
    }
    paramPackageInfo = paramPackageInfo.signatures;
    int i = 0;
    paramPackageInfo = new zzf(paramPackageInfo[0].toByteArray());
    while (i < paramVarArgs.length)
    {
      if (paramVarArgs[i].equals(paramPackageInfo)) {
        return paramVarArgs[i];
      }
      i += 1;
    }
    return null;
  }
  
  private final zzm zza(String paramString, int paramInt)
  {
    try
    {
      Object localObject = Wrappers.packageManager(this.mContext).zza(paramString, 64, paramInt);
      boolean bool = GooglePlayServicesUtilLight.honorsDebugCertificates(this.mContext);
      if (localObject == null) {
        return zzm.zzb("null pkg");
      }
      if (((PackageInfo)localObject).signatures.length != 1) {
        return zzm.zzb("single cert required");
      }
      zzf localzzf = new zzf(localObject.signatures[0].toByteArray());
      String str = ((PackageInfo)localObject).packageName;
      zzm localzzm = zzc.zza(str, localzzf, bool, false);
      if ((localzzm.zzad) && (((PackageInfo)localObject).applicationInfo != null) && ((((PackageInfo)localObject).applicationInfo.flags & 0x2) != 0) && (zzc.zza(str, localzzf, false, true).zzad))
      {
        localObject = zzm.zzb("debuggable release cert app rejected");
        return (zzm)localObject;
      }
      return localzzm;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;) {}
    }
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "no pkg ".concat(paramString);
    } else {
      paramString = new String("no pkg ");
    }
    return zzm.zzb(paramString);
  }
  
  public static boolean zza(PackageInfo paramPackageInfo, boolean paramBoolean)
  {
    if ((paramPackageInfo != null) && (paramPackageInfo.signatures != null))
    {
      if (paramBoolean) {
        paramPackageInfo = zza(paramPackageInfo, zzh.zzx);
      } else {
        paramPackageInfo = zza(paramPackageInfo, new zze[] { zzh.zzx[0] });
      }
      if (paramPackageInfo != null) {
        return true;
      }
    }
    return false;
  }
  
  private final zzm zzc(String paramString)
  {
    if (paramString == null) {
      return zzm.zzb("null pkg");
    }
    if (paramString.equals(this.zzan)) {
      return zzm.zze();
    }
    try
    {
      PackageInfo localPackageInfo = Wrappers.packageManager(this.mContext).getPackageInfo(paramString, 64);
      boolean bool = GooglePlayServicesUtilLight.honorsDebugCertificates(this.mContext);
      zzm localzzm;
      if (localPackageInfo == null)
      {
        localzzm = zzm.zzb("null pkg");
      }
      else if (localPackageInfo.signatures.length != 1)
      {
        localzzm = zzm.zzb("single cert required");
      }
      else
      {
        zzf localzzf = new zzf(localPackageInfo.signatures[0].toByteArray());
        String str = localPackageInfo.packageName;
        localzzm = zzc.zza(str, localzzf, bool, false);
        if ((localzzm.zzad) && (localPackageInfo.applicationInfo != null) && ((localPackageInfo.applicationInfo.flags & 0x2) != 0) && (zzc.zza(str, localzzf, false, true).zzad)) {
          localzzm = zzm.zzb("debuggable release cert app rejected");
        }
      }
      if (localzzm.zzad) {
        this.zzan = paramString;
      }
      return localzzm;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;) {}
    }
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "no pkg ".concat(paramString);
    } else {
      paramString = new String("no pkg ");
    }
    return zzm.zzb(paramString);
  }
  
  public boolean isGooglePublicSignedPackage(PackageInfo paramPackageInfo)
  {
    if (paramPackageInfo == null) {
      return false;
    }
    if (zza(paramPackageInfo, false)) {
      return true;
    }
    if (zza(paramPackageInfo, true))
    {
      if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.mContext)) {
        return true;
      }
      Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
    }
    return false;
  }
  
  public boolean isPackageGoogleSigned(String paramString)
  {
    paramString = zzc(paramString);
    paramString.zzf();
    return paramString.zzad;
  }
  
  public boolean isUidGoogleSigned(int paramInt)
  {
    String[] arrayOfString = Wrappers.packageManager(this.mContext).getPackagesForUid(paramInt);
    Object localObject;
    int j;
    int i;
    if ((arrayOfString != null) && (arrayOfString.length != 0))
    {
      localObject = null;
      j = arrayOfString.length;
      i = 0;
    }
    while (i < j)
    {
      zzm localzzm = zza(arrayOfString[i], paramInt);
      localObject = localzzm;
      if (!localzzm.zzad)
      {
        i += 1;
        localObject = localzzm;
        continue;
        localObject = zzm.zzb("no pkgs");
      }
    }
    ((zzm)localObject).zzf();
    return ((zzm)localObject).zzad;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\GoogleSignatureVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */