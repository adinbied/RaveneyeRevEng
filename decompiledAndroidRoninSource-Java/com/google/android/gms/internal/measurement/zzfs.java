package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzfs<E>
  extends zzfg<E>
{
  static final zzfs<Object> zza = new zzfs(new Object[0], 0, null, 0, 0);
  private final transient Object[] zzb;
  private final transient Object[] zzc;
  private final transient int zzd;
  private final transient int zze;
  private final transient int zzf;
  
  zzfs(Object[] paramArrayOfObject1, int paramInt1, Object[] paramArrayOfObject2, int paramInt2, int paramInt3)
  {
    this.zzb = paramArrayOfObject1;
    this.zzc = paramArrayOfObject2;
    this.zzd = paramInt2;
    this.zze = paramInt1;
    this.zzf = paramInt3;
  }
  
  public final boolean contains(@NullableDecl Object paramObject)
  {
    Object[] arrayOfObject = this.zzc;
    if (paramObject != null)
    {
      if (arrayOfObject == null) {
        return false;
      }
      int i = zzez.zza(paramObject);
      for (;;)
      {
        i &= this.zzd;
        Object localObject = arrayOfObject[i];
        if (localObject == null) {
          return false;
        }
        if (localObject.equals(paramObject)) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    return this.zze;
  }
  
  public final int size()
  {
    return this.zzf;
  }
  
  final int zza(Object[] paramArrayOfObject, int paramInt)
  {
    System.arraycopy(this.zzb, 0, paramArrayOfObject, paramInt, this.zzf);
    return paramInt + this.zzf;
  }
  
  public final zzfx<E> zza()
  {
    return (zzfx)zze().iterator();
  }
  
  final Object[] zzb()
  {
    return this.zzb;
  }
  
  final int zzc()
  {
    return 0;
  }
  
  final int zzd()
  {
    return this.zzf;
  }
  
  final boolean zzf()
  {
    return false;
  }
  
  final boolean zzg()
  {
    return true;
  }
  
  final zzfb<E> zzh()
  {
    return zzfb.zzb(this.zzb, this.zzf);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */