package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class zzal
  extends zzgr
{
  private long zza;
  private String zzb;
  private Boolean zzc;
  private AccountManager zzd;
  private Boolean zze;
  private long zzf;
  
  zzal(zzfv paramzzfv)
  {
    super(paramzzfv);
  }
  
  public final boolean zza(Context paramContext)
  {
    if (this.zzc == null) {
      this.zzc = Boolean.valueOf(false);
    }
    try
    {
      paramContext = paramContext.getPackageManager();
      if (paramContext != null)
      {
        paramContext.getPackageInfo("com.google.android.gms", 128);
        this.zzc = Boolean.valueOf(true);
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    return this.zzc.booleanValue();
  }
  
  protected final boolean zzd()
  {
    Object localObject1 = Calendar.getInstance();
    this.zza = TimeUnit.MINUTES.convert(((Calendar)localObject1).get(15) + ((Calendar)localObject1).get(16), TimeUnit.MILLISECONDS);
    Object localObject2 = Locale.getDefault();
    localObject1 = ((Locale)localObject2).getLanguage().toLowerCase(Locale.ENGLISH);
    localObject2 = ((Locale)localObject2).getCountry().toLowerCase(Locale.ENGLISH);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject1).length() + 1 + String.valueOf(localObject2).length());
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("-");
    localStringBuilder.append((String)localObject2);
    this.zzb = localStringBuilder.toString();
    return false;
  }
  
  public final long zze()
  {
    zzaa();
    return this.zza;
  }
  
  public final String zzf()
  {
    zzaa();
    return this.zzb;
  }
  
  final long zzg()
  {
    zzc();
    return this.zzf;
  }
  
  final void zzh()
  {
    zzc();
    this.zze = null;
    this.zzf = 0L;
  }
  
  final boolean zzi()
  {
    zzc();
    long l = zzl().currentTimeMillis();
    if (l - this.zzf > 86400000L) {
      this.zze = null;
    }
    Object localObject = this.zze;
    if (localObject != null) {
      return ((Boolean)localObject).booleanValue();
    }
    if (ContextCompat.checkSelfPermission(zzm(), "android.permission.GET_ACCOUNTS") != 0)
    {
      zzq().zzi().zza("Permission error checking for dasher/unicorn accounts");
      this.zzf = l;
      this.zze = Boolean.valueOf(false);
      return false;
    }
    if (this.zzd == null) {
      this.zzd = AccountManager.get(zzm());
    }
    try
    {
      localObject = (Account[])this.zzd.getAccountsByTypeAndFeatures("com.google", new String[] { "service_HOSTED" }, null, null).getResult();
      if ((localObject != null) && (localObject.length > 0))
      {
        this.zze = Boolean.valueOf(true);
        this.zzf = l;
        return true;
      }
      localObject = (Account[])this.zzd.getAccountsByTypeAndFeatures("com.google", new String[] { "service_uca" }, null, null).getResult();
      if ((localObject == null) || (localObject.length <= 0)) {
        break label231;
      }
      this.zze = Boolean.valueOf(true);
      this.zzf = l;
      return true;
    }
    catch (OperationCanceledException localOperationCanceledException) {}catch (IOException localIOException) {}catch (AuthenticatorException localAuthenticatorException) {}
    zzq().zzf().zza("Exception checking account types", localAuthenticatorException);
    label231:
    this.zzf = l;
    this.zze = Boolean.valueOf(false);
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */