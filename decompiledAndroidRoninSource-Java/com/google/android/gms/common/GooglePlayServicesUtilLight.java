package com.google.android.gms.common;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.zzb;
import java.util.concurrent.atomic.AtomicBoolean;

public class GooglePlayServicesUtilLight
{
  static final int GMS_AVAILABILITY_NOTIFICATION_ID = 10436;
  static final int GMS_GENERAL_ERROR_NOTIFICATION_ID = 39789;
  public static final String GOOGLE_PLAY_GAMES_PACKAGE = "com.google.android.play.games";
  @Deprecated
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  @Deprecated
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  static final AtomicBoolean sCanceledAvailabilityNotification = new AtomicBoolean();
  private static boolean zzah;
  private static boolean zzai;
  private static boolean zzaj;
  private static boolean zzak;
  private static final AtomicBoolean zzal = new AtomicBoolean();
  
  @Deprecated
  public static void cancelAvailabilityErrorNotifications(Context paramContext)
  {
    if (sCanceledAvailabilityNotification.getAndSet(true)) {
      return;
    }
    try
    {
      paramContext = (NotificationManager)paramContext.getSystemService("notification");
      if (paramContext != null) {
        paramContext.cancel(10436);
      }
      return;
    }
    catch (SecurityException paramContext) {}
  }
  
  public static void enableUsingApkIndependentContext()
  {
    zzal.set(true);
  }
  
  @Deprecated
  public static void ensurePlayServicesAvailable(Context paramContext, int paramInt)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    paramInt = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(paramContext, paramInt);
    if (paramInt != 0)
    {
      paramContext = GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(paramContext, paramInt, "e");
      StringBuilder localStringBuilder = new StringBuilder(57);
      localStringBuilder.append("GooglePlayServices not available due to error ");
      localStringBuilder.append(paramInt);
      Log.e("GooglePlayServicesUtil", localStringBuilder.toString());
      if (paramContext == null) {
        throw new GooglePlayServicesNotAvailableException(paramInt);
      }
      throw new GooglePlayServicesRepairableException(paramInt, "Google Play Services not available", paramContext);
    }
  }
  
  @Deprecated
  public static int getApkVersion(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.google.android.gms", 0);
      return paramContext.versionCode;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
    return 0;
  }
  
  @Deprecated
  public static int getClientVersion(Context paramContext)
  {
    Preconditions.checkState(true);
    return ClientLibraryUtils.getClientVersion(paramContext, paramContext.getPackageName());
  }
  
  @Deprecated
  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2)
  {
    return GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
  }
  
  @Deprecated
  public static String getErrorString(int paramInt)
  {
    return ConnectionResult.zza(paramInt);
  }
  
  @Deprecated
  public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int paramInt)
  {
    return GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(null, paramInt, null);
  }
  
  public static Context getRemoteContext(Context paramContext)
  {
    try
    {
      paramContext = paramContext.createPackageContext("com.google.android.gms", 3);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static Resources getRemoteResource(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getResourcesForApplication("com.google.android.gms");
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    return null;
  }
  
  /* Error */
  public static boolean honorsDebugCertificates(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 193	com/google/android/gms/common/GooglePlayServicesUtilLight:zzak	Z
    //   3: ifne +85 -> 88
    //   6: aload_0
    //   7: invokestatic 199	com/google/android/gms/common/wrappers/Wrappers:packageManager	(Landroid/content/Context;)Lcom/google/android/gms/common/wrappers/PackageManagerWrapper;
    //   10: ldc 16
    //   12: bipush 64
    //   14: invokevirtual 202	com/google/android/gms/common/wrappers/PackageManagerWrapper:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   17: astore_1
    //   18: aload_0
    //   19: invokestatic 207	com/google/android/gms/common/GoogleSignatureVerifier:getInstance	(Landroid/content/Context;)Lcom/google/android/gms/common/GoogleSignatureVerifier;
    //   22: pop
    //   23: aload_1
    //   24: ifnull +26 -> 50
    //   27: aload_1
    //   28: iconst_0
    //   29: invokestatic 210	com/google/android/gms/common/GoogleSignatureVerifier:zza	(Landroid/content/pm/PackageInfo;Z)Z
    //   32: ifne +18 -> 50
    //   35: aload_1
    //   36: iconst_1
    //   37: invokestatic 210	com/google/android/gms/common/GoogleSignatureVerifier:zza	(Landroid/content/pm/PackageInfo;Z)Z
    //   40: ifeq +10 -> 50
    //   43: iconst_1
    //   44: putstatic 212	com/google/android/gms/common/GooglePlayServicesUtilLight:zzaj	Z
    //   47: goto +7 -> 54
    //   50: iconst_0
    //   51: putstatic 212	com/google/android/gms/common/GooglePlayServicesUtilLight:zzaj	Z
    //   54: iconst_1
    //   55: putstatic 193	com/google/android/gms/common/GooglePlayServicesUtilLight:zzak	Z
    //   58: goto +30 -> 88
    //   61: astore_0
    //   62: goto +20 -> 82
    //   65: astore_0
    //   66: ldc 108
    //   68: ldc -42
    //   70: aload_0
    //   71: invokestatic 217	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   74: pop
    //   75: iconst_1
    //   76: putstatic 193	com/google/android/gms/common/GooglePlayServicesUtilLight:zzak	Z
    //   79: goto +9 -> 88
    //   82: iconst_1
    //   83: putstatic 193	com/google/android/gms/common/GooglePlayServicesUtilLight:zzak	Z
    //   86: aload_0
    //   87: athrow
    //   88: getstatic 212	com/google/android/gms/common/GooglePlayServicesUtilLight:zzaj	Z
    //   91: ifne +13 -> 104
    //   94: invokestatic 223	com/google/android/gms/common/util/DeviceProperties:isUserBuild	()Z
    //   97: ifne +5 -> 102
    //   100: iconst_1
    //   101: ireturn
    //   102: iconst_0
    //   103: ireturn
    //   104: iconst_1
    //   105: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	paramContext	Context
    //   17	19	1	localPackageInfo	PackageInfo
    // Exception table:
    //   from	to	target	type
    //   6	23	61	finally
    //   27	47	61	finally
    //   50	54	61	finally
    //   66	75	61	finally
    //   6	23	65	android/content/pm/PackageManager$NameNotFoundException
    //   27	47	65	android/content/pm/PackageManager$NameNotFoundException
    //   50	54	65	android/content/pm/PackageManager$NameNotFoundException
  }
  
  @Deprecated
  public static int isGooglePlayServicesAvailable(Context paramContext)
  {
    return isGooglePlayServicesAvailable(paramContext, GOOGLE_PLAY_SERVICES_VERSION_CODE);
  }
  
  @Deprecated
  public static int isGooglePlayServicesAvailable(Context paramContext, int paramInt)
  {
    try
    {
      paramContext.getResources().getString(R.string.common_google_play_services_unknown_issue);
    }
    finally
    {
      int i;
      boolean bool;
      for (;;) {}
    }
    Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
    if ((!"com.google.android.gms".equals(paramContext.getPackageName())) && (!zzal.get()))
    {
      i = zzp.zzd(paramContext);
      if (i != 0)
      {
        if (i != GOOGLE_PLAY_SERVICES_VERSION_CODE)
        {
          paramInt = GOOGLE_PLAY_SERVICES_VERSION_CODE;
          paramContext = new StringBuilder(320);
          paramContext.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
          paramContext.append(paramInt);
          paramContext.append(" but found ");
          paramContext.append(i);
          paramContext.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
          throw new IllegalStateException(paramContext.toString());
        }
      }
      else {
        throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
      }
    }
    if ((!DeviceProperties.isWearableWithoutPlayStore(paramContext)) && (!DeviceProperties.zzf(paramContext))) {
      bool = true;
    } else {
      bool = false;
    }
    return zza(paramContext, bool, paramInt);
  }
  
  @Deprecated
  public static boolean isGooglePlayServicesUid(Context paramContext, int paramInt)
  {
    return UidVerifier.isGooglePlayServicesUid(paramContext, paramInt);
  }
  
  @Deprecated
  public static boolean isPlayServicesPossiblyUpdating(Context paramContext, int paramInt)
  {
    if (paramInt == 18) {
      return true;
    }
    if (paramInt == 1) {
      return isUninstalledAppPossiblyUpdating(paramContext, "com.google.android.gms");
    }
    return false;
  }
  
  @Deprecated
  public static boolean isPlayStorePossiblyUpdating(Context paramContext, int paramInt)
  {
    if (paramInt == 9) {
      return isUninstalledAppPossiblyUpdating(paramContext, "com.android.vending");
    }
    return false;
  }
  
  public static boolean isRestrictedUserProfile(Context paramContext)
  {
    if (PlatformVersion.isAtLeastJellyBeanMR2())
    {
      paramContext = ((UserManager)paramContext.getSystemService("user")).getApplicationRestrictions(paramContext.getPackageName());
      if ((paramContext != null) && ("true".equals(paramContext.getString("restricted_profile")))) {
        return true;
      }
    }
    return false;
  }
  
  @Deprecated
  public static boolean isSidewinderDevice(Context paramContext)
  {
    return DeviceProperties.isSidewinder(paramContext);
  }
  
  /* Error */
  static boolean isUninstalledAppPossiblyUpdating(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 16
    //   3: invokevirtual 248	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: istore_2
    //   7: invokestatic 322	com/google/android/gms/common/util/PlatformVersion:isAtLeastLollipop	()Z
    //   10: ifeq +51 -> 61
    //   13: aload_0
    //   14: invokevirtual 132	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   17: invokevirtual 326	android/content/pm/PackageManager:getPackageInstaller	()Landroid/content/pm/PackageInstaller;
    //   20: invokevirtual 332	android/content/pm/PackageInstaller:getAllSessions	()Ljava/util/List;
    //   23: astore_3
    //   24: aload_3
    //   25: invokeinterface 338 1 0
    //   30: astore_3
    //   31: aload_3
    //   32: invokeinterface 343 1 0
    //   37: ifeq +24 -> 61
    //   40: aload_1
    //   41: aload_3
    //   42: invokeinterface 347 1 0
    //   47: checkcast 349	android/content/pm/PackageInstaller$SessionInfo
    //   50: invokevirtual 352	android/content/pm/PackageInstaller$SessionInfo:getAppPackageName	()Ljava/lang/String;
    //   53: invokevirtual 248	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   56: ifeq -25 -> 31
    //   59: iconst_1
    //   60: ireturn
    //   61: aload_0
    //   62: invokevirtual 132	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   65: astore_3
    //   66: aload_3
    //   67: aload_1
    //   68: sipush 8192
    //   71: invokevirtual 356	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   74: astore_1
    //   75: iload_2
    //   76: ifeq +8 -> 84
    //   79: aload_1
    //   80: getfield 361	android/content/pm/ApplicationInfo:enabled	Z
    //   83: ireturn
    //   84: aload_1
    //   85: getfield 361	android/content/pm/ApplicationInfo:enabled	Z
    //   88: ifeq +14 -> 102
    //   91: aload_0
    //   92: invokestatic 363	com/google/android/gms/common/GooglePlayServicesUtilLight:isRestrictedUserProfile	(Landroid/content/Context;)Z
    //   95: istore_2
    //   96: iload_2
    //   97: ifne +5 -> 102
    //   100: iconst_1
    //   101: ireturn
    //   102: iconst_0
    //   103: ireturn
    //   104: astore_0
    //   105: iconst_0
    //   106: ireturn
    //   107: astore_0
    //   108: iconst_0
    //   109: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramContext	Context
    //   0	110	1	paramString	String
    //   6	91	2	bool	boolean
    //   23	44	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	24	104	java/lang/Exception
    //   66	75	107	android/content/pm/PackageManager$NameNotFoundException
    //   79	84	107	android/content/pm/PackageManager$NameNotFoundException
    //   84	96	107	android/content/pm/PackageManager$NameNotFoundException
  }
  
  @Deprecated
  public static boolean isUserRecoverableError(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 9);
  }
  
  @Deprecated
  public static boolean uidHasPackageName(Context paramContext, int paramInt, String paramString)
  {
    return UidVerifier.uidHasPackageName(paramContext, paramInt, paramString);
  }
  
  private static int zza(Context paramContext, boolean paramBoolean, int paramInt)
  {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    PackageManager localPackageManager = paramContext.getPackageManager();
    Object localObject = null;
    if (paramBoolean) {}
    try
    {
      localObject = localPackageManager.getPackageInfo("com.android.vending", 8256);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
    return 9;
    try
    {
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo("com.google.android.gms", 64);
      GoogleSignatureVerifier.getInstance(paramContext);
      if (!GoogleSignatureVerifier.zza(localPackageInfo, true))
      {
        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
        return 9;
      }
      if ((paramBoolean) && ((!GoogleSignatureVerifier.zza((PackageInfo)localObject, true)) || (!localObject.signatures[0].equals(localPackageInfo.signatures[0]))))
      {
        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
        return 9;
      }
      if (zzb.zzc(localPackageInfo.versionCode) < zzb.zzc(paramInt))
      {
        int i = localPackageInfo.versionCode;
        paramContext = new StringBuilder(77);
        paramContext.append("Google Play services out of date.  Requires ");
        paramContext.append(paramInt);
        paramContext.append(" but found ");
        paramContext.append(i);
        Log.w("GooglePlayServicesUtil", paramContext.toString());
        return 2;
      }
      localObject = localPackageInfo.applicationInfo;
      paramContext = (Context)localObject;
      if (localObject == null) {
        try
        {
          paramContext = localPackageManager.getApplicationInfo("com.google.android.gms", 0);
        }
        catch (PackageManager.NameNotFoundException paramContext)
        {
          Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", paramContext);
          return 1;
        }
      }
      if (!paramContext.enabled) {
        return 3;
      }
      return 0;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
    return 1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\GooglePlayServicesUtilLight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */