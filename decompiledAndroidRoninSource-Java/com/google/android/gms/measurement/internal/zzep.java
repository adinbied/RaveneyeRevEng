package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public final class zzep
  extends zzgr
{
  private static final AtomicReference<String[]> zza = new AtomicReference();
  private static final AtomicReference<String[]> zzb = new AtomicReference();
  private static final AtomicReference<String[]> zzc = new AtomicReference();
  
  zzep(zzfv paramzzfv)
  {
    super(paramzzfv);
  }
  
  private static String zza(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, AtomicReference<String[]> paramAtomicReference)
  {
    Preconditions.checkNotNull(paramArrayOfString1);
    Preconditions.checkNotNull(paramArrayOfString2);
    Preconditions.checkNotNull(paramAtomicReference);
    int j = paramArrayOfString1.length;
    int k = paramArrayOfString2.length;
    int i = 0;
    boolean bool;
    if (j == k) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    while (i < paramArrayOfString1.length)
    {
      if (zzkw.zzc(paramString, paramArrayOfString1[i])) {
        try
        {
          Object localObject = (String[])paramAtomicReference.get();
          paramString = (String)localObject;
          if (localObject == null)
          {
            paramString = new String[paramArrayOfString2.length];
            paramAtomicReference.set(paramString);
          }
          if (paramString[i] == null)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramArrayOfString2[i]);
            ((StringBuilder)localObject).append("(");
            ((StringBuilder)localObject).append(paramArrayOfString1[i]);
            ((StringBuilder)localObject).append(")");
            paramString[i] = ((StringBuilder)localObject).toString();
          }
          paramString = paramString[i];
          return paramString;
        }
        finally {}
      }
      i += 1;
    }
    return paramString;
  }
  
  private final String zza(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      return "[]";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfObject[i];
      if ((localObject instanceof Bundle)) {
        localObject = zza((Bundle)localObject);
      } else {
        localObject = String.valueOf(localObject);
      }
      if (localObject != null)
      {
        if (localStringBuilder.length() != 1) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append((String)localObject);
      }
      i += 1;
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  private final boolean zzf()
  {
    return (this.zzy.zzk()) && (this.zzy.zzq().zza(3));
  }
  
  protected final String zza(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    if (!zzf()) {
      return paramBundle.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bundle[{");
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (localStringBuilder.length() != 8) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(zzb((String)localObject));
      localStringBuilder.append("=");
      localObject = paramBundle.get((String)localObject);
      if ((localObject instanceof Bundle)) {
        localObject = zza(new Object[] { localObject });
      } else if ((localObject instanceof Object[])) {
        localObject = zza((Object[])localObject);
      } else if ((localObject instanceof ArrayList)) {
        localObject = zza(((ArrayList)localObject).toArray());
      } else {
        localObject = String.valueOf(localObject);
      }
      localStringBuilder.append((String)localObject);
    }
    localStringBuilder.append("}]");
    return localStringBuilder.toString();
  }
  
  protected final String zza(zzar paramzzar)
  {
    Object localObject = null;
    if (paramzzar == null) {
      return null;
    }
    if (!zzf()) {
      return paramzzar.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("origin=");
    localStringBuilder.append(paramzzar.zzc);
    localStringBuilder.append(",name=");
    localStringBuilder.append(zza(paramzzar.zza));
    localStringBuilder.append(",params=");
    paramzzar = paramzzar.zzb;
    if (paramzzar == null) {
      paramzzar = (zzar)localObject;
    } else if (!zzf()) {
      paramzzar = paramzzar.toString();
    } else {
      paramzzar = zza(paramzzar.zzb());
    }
    localStringBuilder.append(paramzzar);
    return localStringBuilder.toString();
  }
  
  protected final String zza(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (!zzf()) {
      return paramString;
    }
    return zza(paramString, zzgs.zzc, zzgs.zza, zza);
  }
  
  protected final String zzb(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (!zzf()) {
      return paramString;
    }
    return zza(paramString, zzgv.zzb, zzgv.zza, zzb);
  }
  
  protected final String zzc(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (!zzf()) {
      return paramString;
    }
    if (paramString.startsWith("_exp_"))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("experiment_id");
      localStringBuilder.append("(");
      localStringBuilder.append(paramString);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
    return zza(paramString, zzgu.zzb, zzgu.zza, zzc);
  }
  
  protected final boolean zzd()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */