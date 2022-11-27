package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;

public final class zzer
  extends zzgr
{
  private char zza = '\000';
  private long zzb = -1L;
  private String zzc;
  private final zzet zzd = new zzet(this, 6, false, false);
  private final zzet zze = new zzet(this, 6, true, false);
  private final zzet zzf = new zzet(this, 6, false, true);
  private final zzet zzg = new zzet(this, 5, false, false);
  private final zzet zzh = new zzet(this, 5, true, false);
  private final zzet zzi = new zzet(this, 5, false, true);
  private final zzet zzj = new zzet(this, 4, false, false);
  private final zzet zzk = new zzet(this, 3, false, false);
  private final zzet zzl = new zzet(this, 2, false, false);
  
  zzer(zzfv paramzzfv)
  {
    super(paramzzfv);
  }
  
  protected static Object zza(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return new zzes(paramString);
  }
  
  private static String zza(boolean paramBoolean, Object paramObject)
  {
    String str1 = "";
    if (paramObject == null) {
      return "";
    }
    Object localObject = paramObject;
    if ((paramObject instanceof Integer)) {
      localObject = Long.valueOf(((Integer)paramObject).intValue());
    }
    boolean bool = localObject instanceof Long;
    int i = 0;
    Long localLong;
    if (bool)
    {
      if (!paramBoolean) {
        return String.valueOf(localObject);
      }
      localLong = (Long)localObject;
      if (Math.abs(localLong.longValue()) < 100L) {
        return String.valueOf(localObject);
      }
      paramObject = str1;
      if (String.valueOf(localObject).charAt(0) == '-') {
        paramObject = "-";
      }
      localObject = String.valueOf(Math.abs(localLong.longValue()));
      long l1 = Math.round(Math.pow(10.0D, ((String)localObject).length() - 1));
      long l2 = Math.round(Math.pow(10.0D, ((String)localObject).length()) - 1.0D);
      localObject = new StringBuilder(((String)paramObject).length() + 43 + ((String)paramObject).length());
      ((StringBuilder)localObject).append((String)paramObject);
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("...");
      ((StringBuilder)localObject).append((String)paramObject);
      ((StringBuilder)localObject).append(l2);
      return ((StringBuilder)localObject).toString();
    }
    if ((localObject instanceof Boolean)) {
      return String.valueOf(localObject);
    }
    if ((localObject instanceof Throwable))
    {
      localObject = (Throwable)localObject;
      if (paramBoolean) {
        paramObject = localObject.getClass().getName();
      } else {
        paramObject = ((Throwable)localObject).toString();
      }
      paramObject = new StringBuilder((String)paramObject);
      str1 = zzb(zzfv.class.getCanonicalName());
      localObject = ((Throwable)localObject).getStackTrace();
      int j = localObject.length;
      while (i < j)
      {
        localLong = localObject[i];
        if (!localLong.isNativeMethod())
        {
          String str2 = localLong.getClassName();
          if ((str2 != null) && (zzb(str2).equals(str1)))
          {
            ((StringBuilder)paramObject).append(": ");
            ((StringBuilder)paramObject).append(localLong);
            break;
          }
        }
        i += 1;
      }
      return ((StringBuilder)paramObject).toString();
    }
    if ((localObject instanceof zzes)) {
      return zzes.zza((zzes)localObject);
    }
    if (paramBoolean) {
      return "-";
    }
    return String.valueOf(localObject);
  }
  
  static String zza(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    String str2 = "";
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    String str3 = zza(paramBoolean, paramObject1);
    String str4 = zza(paramBoolean, paramObject2);
    paramObject3 = zza(paramBoolean, paramObject3);
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = str2;
    if (!TextUtils.isEmpty(str1))
    {
      localStringBuilder.append(str1);
      paramString = ": ";
    }
    paramBoolean = TextUtils.isEmpty(str3);
    paramObject2 = ", ";
    paramObject1 = paramString;
    if (!paramBoolean)
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(str3);
      paramObject1 = ", ";
    }
    if (!TextUtils.isEmpty(str4))
    {
      localStringBuilder.append((String)paramObject1);
      localStringBuilder.append(str4);
      paramObject1 = paramObject2;
    }
    if (!TextUtils.isEmpty((CharSequence)paramObject3))
    {
      localStringBuilder.append((String)paramObject1);
      localStringBuilder.append((String)paramObject3);
    }
    return localStringBuilder.toString();
  }
  
  private static String zzb(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = paramString.lastIndexOf('.');
    if (i == -1) {
      return paramString;
    }
    return paramString.substring(0, i);
  }
  
  private final String zzy()
  {
    for (;;)
    {
      try
      {
        String str1;
        if (this.zzc == null)
        {
          if (this.zzy.zzr() != null)
          {
            str1 = this.zzy.zzr();
            this.zzc = str1;
          }
        }
        else
        {
          str1 = this.zzc;
          return str1;
        }
      }
      finally {}
      String str2 = "FA";
    }
  }
  
  protected final void zza(int paramInt, String paramString)
  {
    Log.println(paramInt, zzy(), paramString);
  }
  
  protected final void zza(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((!paramBoolean1) && (zza(paramInt))) {
      zza(paramInt, zza(false, paramString, paramObject1, paramObject2, paramObject3));
    }
    if ((!paramBoolean2) && (paramInt >= 5))
    {
      Preconditions.checkNotNull(paramString);
      zzfo localzzfo = this.zzy.zzf();
      if (localzzfo == null)
      {
        zza(6, "Scheduler not set. Not logging error/warn");
        return;
      }
      if (!localzzfo.zzz())
      {
        zza(6, "Scheduler not initialized. Not logging error/warn");
        return;
      }
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      if (i >= 9) {
        i = 8;
      }
      localzzfo.zza(new zzeq(this, i, paramString, paramObject1, paramObject2, paramObject3));
    }
  }
  
  protected final boolean zza(int paramInt)
  {
    return Log.isLoggable(zzy(), paramInt);
  }
  
  protected final boolean zzd()
  {
    return false;
  }
  
  public final zzet zze()
  {
    return this.zzd;
  }
  
  public final zzet zzf()
  {
    return this.zze;
  }
  
  public final zzet zzg()
  {
    return this.zzf;
  }
  
  public final zzet zzh()
  {
    return this.zzg;
  }
  
  public final zzet zzi()
  {
    return this.zzh;
  }
  
  public final zzet zzj()
  {
    return this.zzi;
  }
  
  public final zzet zzu()
  {
    return this.zzj;
  }
  
  public final zzet zzv()
  {
    return this.zzk;
  }
  
  public final zzet zzw()
  {
    return this.zzl;
  }
  
  public final String zzx()
  {
    Object localObject = zzr().zzb.zza();
    if ((localObject != null) && (localObject != zzfd.zza))
    {
      String str = String.valueOf(((Pair)localObject).second);
      localObject = (String)((Pair)localObject).first;
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(localObject).length());
      localStringBuilder.append(str);
      localStringBuilder.append(":");
      localStringBuilder.append((String)localObject);
      return localStringBuilder.toString();
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */