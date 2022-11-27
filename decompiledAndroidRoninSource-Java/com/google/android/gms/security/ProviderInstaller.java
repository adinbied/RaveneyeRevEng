package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.NotFoundException;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import java.lang.reflect.Method;

public class ProviderInstaller
{
  public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
  private static final Object lock = new Object();
  private static final GoogleApiAvailabilityLight zziv = ;
  private static Method zziw = null;
  
  public static void installIfNeeded(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    Preconditions.checkNotNull(paramContext, "Context must not be null");
    zziv.verifyGooglePlayServicesIsAvailable(paramContext, 11925000);
    Context localContext = zzk(paramContext);
    Object localObject1 = localContext;
    if (localContext == null) {
      localObject1 = zzl(paramContext);
    }
    if (localObject1 != null) {}
    Throwable localThrowable;
    label214:
    synchronized (lock)
    {
      try
      {
        if (zziw == null) {
          zziw = ((Context)localObject1).getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[] { Context.class });
        }
        zziw.invoke(null, new Object[] { localObject1 });
        return;
      }
      catch (Exception localException)
      {
        localThrowable = localException.getCause();
        if (!Log.isLoggable("ProviderInstaller", 6)) {
          break label214;
        }
      }
      if (localThrowable == null) {
        localObject1 = localException.getMessage();
      } else {
        localObject1 = localThrowable.getMessage();
      }
      localObject1 = String.valueOf(localObject1);
      if (((String)localObject1).length() != 0) {
        localObject1 = "Failed to install provider: ".concat((String)localObject1);
      } else {
        localObject1 = new String("Failed to install provider: ");
      }
      Log.e("ProviderInstaller", (String)localObject1);
      break label214;
      CrashUtils.addDynamiteErrorToDropBox(paramContext, (Throwable)localObject1);
      throw new GooglePlayServicesNotAvailableException(8);
      throw paramContext;
      Log.e("ProviderInstaller", "Failed to get remote context");
      throw new GooglePlayServicesNotAvailableException(8);
    }
  }
  
  public static void installIfNeededAsync(Context paramContext, ProviderInstallListener paramProviderInstallListener)
  {
    Preconditions.checkNotNull(paramContext, "Context must not be null");
    Preconditions.checkNotNull(paramProviderInstallListener, "Listener must not be null");
    Preconditions.checkMainThread("Must be called on the UI thread");
    new zza(paramContext, paramProviderInstallListener).execute(new Void[0]);
  }
  
  private static Context zzk(Context paramContext)
  {
    try
    {
      paramContext = DynamiteModule.load(paramContext, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "providerinstaller").getModuleContext();
      return paramContext;
    }
    catch (DynamiteModule.LoadingException paramContext)
    {
      paramContext = String.valueOf(paramContext.getMessage());
      if (paramContext.length() != 0) {
        paramContext = "Failed to load providerinstaller module: ".concat(paramContext);
      } else {
        paramContext = new String("Failed to load providerinstaller module: ");
      }
      Log.w("ProviderInstaller", paramContext);
    }
    return null;
  }
  
  private static Context zzl(Context paramContext)
  {
    try
    {
      localObject = GooglePlayServicesUtilLight.getRemoteContext(paramContext);
      return (Context)localObject;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      Object localObject = String.valueOf(localNotFoundException.getMessage());
      if (((String)localObject).length() != 0) {
        localObject = "Failed to load GMS Core context for providerinstaller: ".concat((String)localObject);
      } else {
        localObject = new String("Failed to load GMS Core context for providerinstaller: ");
      }
      Log.w("ProviderInstaller", (String)localObject);
      CrashUtils.addDynamiteErrorToDropBox(paramContext, localNotFoundException);
    }
    return null;
  }
  
  public static abstract interface ProviderInstallListener
  {
    public abstract void onProviderInstallFailed(int paramInt, Intent paramIntent);
    
    public abstract void onProviderInstalled();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\security\ProviderInstaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */