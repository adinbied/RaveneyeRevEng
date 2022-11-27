package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.common.zzg;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AndroidUtilsLight
{
  private static volatile int zzgf = -1;
  
  @Deprecated
  public static Context getDeviceProtectedStorageContext(Context paramContext)
  {
    Context localContext = paramContext;
    if (zzg.zzam()) {
      localContext = zzg.getDeviceProtectedStorageContext(paramContext);
    }
    return localContext;
  }
  
  public static byte[] getPackageCertificateHashBytes(Context paramContext, String paramString)
    throws PackageManager.NameNotFoundException
  {
    paramContext = Wrappers.packageManager(paramContext).getPackageInfo(paramString, 64);
    if ((paramContext.signatures != null) && (paramContext.signatures.length == 1))
    {
      paramString = zzj("SHA1");
      if (paramString != null) {
        return paramString.digest(paramContext.signatures[0].toByteArray());
      }
    }
    return null;
  }
  
  public static MessageDigest zzj(String paramString)
  {
    int i = 0;
    while (i < 2)
    {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
        if (localMessageDigest != null) {
          return localMessageDigest;
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;) {}
      }
      i += 1;
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\commo\\util\AndroidUtilsLight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */