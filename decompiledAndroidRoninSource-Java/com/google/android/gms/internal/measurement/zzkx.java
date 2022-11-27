package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzkx
{
  static final boolean zza;
  private static final Logger zzb = Logger.getLogger(zzkx.class.getName());
  private static final Unsafe zzc = zzc();
  private static final Class<?> zzd = zzgk.zzb();
  private static final boolean zze = zzd(Long.TYPE);
  private static final boolean zzf = zzd(Integer.TYPE);
  private static final zzd zzg;
  private static final boolean zzh;
  private static final boolean zzi;
  private static final long zzj;
  private static final long zzk;
  private static final long zzl;
  private static final long zzm;
  private static final long zzn;
  private static final long zzo;
  private static final long zzp;
  private static final long zzq;
  private static final long zzr;
  private static final long zzs;
  private static final long zzt;
  private static final long zzu;
  private static final long zzv;
  private static final long zzw;
  private static final int zzx;
  
  static
  {
    Object localObject2 = zzc;
    Object localObject1 = null;
    if (localObject2 != null) {
      if (zzgk.zza())
      {
        if (zze) {
          localObject1 = new zzc(zzc);
        } else if (zzf) {
          localObject1 = new zza(zzc);
        }
      }
      else {
        localObject1 = new zzb(zzc);
      }
    }
    zzg = (zzd)localObject1;
    zzh = zze();
    zzi = zzd();
    zzj = zzb(byte[].class);
    zzk = zzb(boolean[].class);
    zzl = zzc(boolean[].class);
    zzm = zzb(int[].class);
    zzn = zzc(int[].class);
    zzo = zzb(long[].class);
    zzp = zzc(long[].class);
    zzq = zzb(float[].class);
    zzr = zzc(float[].class);
    zzs = zzb(double[].class);
    zzt = zzc(double[].class);
    zzu = zzb(Object[].class);
    zzv = zzc(Object[].class);
    localObject1 = zzf();
    if (localObject1 != null)
    {
      localObject2 = zzg;
      if (localObject2 != null)
      {
        l = ((zzd)localObject2).zza.objectFieldOffset((Field)localObject1);
        break label284;
      }
    }
    long l = -1L;
    label284:
    zzw = l;
    zzx = (int)(zzj & 0x7);
    boolean bool;
    if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
      bool = true;
    } else {
      bool = false;
    }
    zza = bool;
  }
  
  static byte zza(byte[] paramArrayOfByte, long paramLong)
  {
    return zzg.zza(paramArrayOfByte, zzj + paramLong);
  }
  
  static int zza(Object paramObject, long paramLong)
  {
    return zzg.zze(paramObject, paramLong);
  }
  
  static <T> T zza(Class<T> paramClass)
  {
    try
    {
      paramClass = zzc.allocateInstance(paramClass);
      return paramClass;
    }
    catch (InstantiationException paramClass)
    {
      throw new IllegalStateException(paramClass);
    }
  }
  
  private static Field zza(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      return paramClass;
    }
    finally
    {
      for (;;) {}
    }
    return null;
  }
  
  static void zza(Object paramObject, long paramLong, double paramDouble)
  {
    zzg.zza(paramObject, paramLong, paramDouble);
  }
  
  static void zza(Object paramObject, long paramLong, float paramFloat)
  {
    zzg.zza(paramObject, paramLong, paramFloat);
  }
  
  static void zza(Object paramObject, long paramLong, int paramInt)
  {
    zzg.zza(paramObject, paramLong, paramInt);
  }
  
  static void zza(Object paramObject, long paramLong1, long paramLong2)
  {
    zzg.zza(paramObject, paramLong1, paramLong2);
  }
  
  static void zza(Object paramObject1, long paramLong, Object paramObject2)
  {
    zzg.zza.putObject(paramObject1, paramLong, paramObject2);
  }
  
  static void zza(Object paramObject, long paramLong, boolean paramBoolean)
  {
    zzg.zza(paramObject, paramLong, paramBoolean);
  }
  
  static void zza(byte[] paramArrayOfByte, long paramLong, byte paramByte)
  {
    zzg.zza(paramArrayOfByte, zzj + paramLong, paramByte);
  }
  
  static boolean zza()
  {
    return zzi;
  }
  
  private static int zzb(Class<?> paramClass)
  {
    if (zzi) {
      return zzg.zza.arrayBaseOffset(paramClass);
    }
    return -1;
  }
  
  static long zzb(Object paramObject, long paramLong)
  {
    return zzg.zzf(paramObject, paramLong);
  }
  
  static boolean zzb()
  {
    return zzh;
  }
  
  private static int zzc(Class<?> paramClass)
  {
    if (zzi) {
      return zzg.zza.arrayIndexScale(paramClass);
    }
    return -1;
  }
  
  static Unsafe zzc()
  {
    try
    {
      Unsafe localUnsafe = (Unsafe)AccessController.doPrivileged(new zzkz());
      return localUnsafe;
    }
    finally
    {
      for (;;) {}
    }
    return null;
  }
  
  private static void zzc(Object paramObject, long paramLong, byte paramByte)
  {
    long l = 0xFFFFFFFFFFFFFFFC & paramLong;
    int i = zza(paramObject, l);
    int j = ((int)paramLong & 0x3) << 3;
    zza(paramObject, l, (0xFF & paramByte) << j | i & 255 << j);
  }
  
  static boolean zzc(Object paramObject, long paramLong)
  {
    return zzg.zzb(paramObject, paramLong);
  }
  
  static float zzd(Object paramObject, long paramLong)
  {
    return zzg.zzc(paramObject, paramLong);
  }
  
  private static void zzd(Object paramObject, long paramLong, byte paramByte)
  {
    long l = 0xFFFFFFFFFFFFFFFC & paramLong;
    int i = zza(paramObject, l);
    int j = ((int)paramLong & 0x3) << 3;
    zza(paramObject, l, (0xFF & paramByte) << j | i & 255 << j);
  }
  
  private static void zzd(Object paramObject, long paramLong, boolean paramBoolean)
  {
    zzc(paramObject, paramLong, (byte)paramBoolean);
  }
  
  private static boolean zzd()
  {
    Object localObject1 = zzc;
    if (localObject1 == null) {
      return false;
    }
    try
    {
      localObject1 = localObject1.getClass();
      ((Class)localObject1).getMethod("objectFieldOffset", new Class[] { Field.class });
      ((Class)localObject1).getMethod("arrayBaseOffset", new Class[] { Class.class });
      ((Class)localObject1).getMethod("arrayIndexScale", new Class[] { Class.class });
      ((Class)localObject1).getMethod("getInt", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject1).getMethod("putInt", new Class[] { Object.class, Long.TYPE, Integer.TYPE });
      ((Class)localObject1).getMethod("getLong", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject1).getMethod("putLong", new Class[] { Object.class, Long.TYPE, Long.TYPE });
      ((Class)localObject1).getMethod("getObject", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject1).getMethod("putObject", new Class[] { Object.class, Long.TYPE, Object.class });
      if (zzgk.zza()) {
        return true;
      }
      ((Class)localObject1).getMethod("getByte", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject1).getMethod("putByte", new Class[] { Object.class, Long.TYPE, Byte.TYPE });
      ((Class)localObject1).getMethod("getBoolean", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject1).getMethod("putBoolean", new Class[] { Object.class, Long.TYPE, Boolean.TYPE });
      ((Class)localObject1).getMethod("getFloat", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject1).getMethod("putFloat", new Class[] { Object.class, Long.TYPE, Float.TYPE });
      ((Class)localObject1).getMethod("getDouble", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject1).getMethod("putDouble", new Class[] { Object.class, Long.TYPE, Double.TYPE });
      return true;
    }
    finally
    {
      localObject1 = zzb;
      Level localLevel = Level.WARNING;
      String str = String.valueOf(localObject2);
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 71);
      localStringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
      localStringBuilder.append(str);
      ((Logger)localObject1).logp(localLevel, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", localStringBuilder.toString());
    }
    return false;
  }
  
  private static boolean zzd(Class<?> paramClass)
  {
    if (!zzgk.zza()) {
      return false;
    }
    try
    {
      Class localClass = zzd;
      localClass.getMethod("peekLong", new Class[] { paramClass, Boolean.TYPE });
      localClass.getMethod("pokeLong", new Class[] { paramClass, Long.TYPE, Boolean.TYPE });
      localClass.getMethod("pokeInt", new Class[] { paramClass, Integer.TYPE, Boolean.TYPE });
      localClass.getMethod("peekInt", new Class[] { paramClass, Boolean.TYPE });
      localClass.getMethod("pokeByte", new Class[] { paramClass, Byte.TYPE });
      localClass.getMethod("peekByte", new Class[] { paramClass });
      localClass.getMethod("pokeByteArray", new Class[] { paramClass, byte[].class, Integer.TYPE, Integer.TYPE });
      localClass.getMethod("peekByteArray", new Class[] { paramClass, byte[].class, Integer.TYPE, Integer.TYPE });
      return true;
    }
    finally {}
    return false;
  }
  
  static double zze(Object paramObject, long paramLong)
  {
    return zzg.zzd(paramObject, paramLong);
  }
  
  private static void zze(Object paramObject, long paramLong, boolean paramBoolean)
  {
    zzd(paramObject, paramLong, (byte)paramBoolean);
  }
  
  private static boolean zze()
  {
    Object localObject1 = zzc;
    if (localObject1 == null) {
      return false;
    }
    try
    {
      localObject1 = localObject1.getClass();
      ((Class)localObject1).getMethod("objectFieldOffset", new Class[] { Field.class });
      ((Class)localObject1).getMethod("getLong", new Class[] { Object.class, Long.TYPE });
      if (zzf() == null) {
        return false;
      }
      if (zzgk.zza()) {
        return true;
      }
      ((Class)localObject1).getMethod("getByte", new Class[] { Long.TYPE });
      ((Class)localObject1).getMethod("putByte", new Class[] { Long.TYPE, Byte.TYPE });
      ((Class)localObject1).getMethod("getInt", new Class[] { Long.TYPE });
      ((Class)localObject1).getMethod("putInt", new Class[] { Long.TYPE, Integer.TYPE });
      ((Class)localObject1).getMethod("getLong", new Class[] { Long.TYPE });
      ((Class)localObject1).getMethod("putLong", new Class[] { Long.TYPE, Long.TYPE });
      ((Class)localObject1).getMethod("copyMemory", new Class[] { Long.TYPE, Long.TYPE, Long.TYPE });
      ((Class)localObject1).getMethod("copyMemory", new Class[] { Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE });
      return true;
    }
    finally
    {
      localObject1 = zzb;
      Level localLevel = Level.WARNING;
      String str = String.valueOf(localObject2);
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 71);
      localStringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
      localStringBuilder.append(str);
      ((Logger)localObject1).logp(localLevel, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", localStringBuilder.toString());
    }
    return false;
  }
  
  static Object zzf(Object paramObject, long paramLong)
  {
    return zzg.zza.getObject(paramObject, paramLong);
  }
  
  private static Field zzf()
  {
    if (zzgk.zza())
    {
      localField = zza(Buffer.class, "effectiveDirectAddress");
      if (localField != null) {
        return localField;
      }
    }
    Field localField = zza(Buffer.class, "address");
    if ((localField != null) && (localField.getType() == Long.TYPE)) {
      return localField;
    }
    return null;
  }
  
  private static byte zzk(Object paramObject, long paramLong)
  {
    return (byte)(zza(paramObject, 0xFFFFFFFFFFFFFFFC & paramLong) >>> (int)((paramLong & 0x3) << 3));
  }
  
  private static byte zzl(Object paramObject, long paramLong)
  {
    return (byte)(zza(paramObject, 0xFFFFFFFFFFFFFFFC & paramLong) >>> (int)((paramLong & 0x3) << 3));
  }
  
  private static boolean zzm(Object paramObject, long paramLong)
  {
    return zzk(paramObject, paramLong) != 0;
  }
  
  private static boolean zzn(Object paramObject, long paramLong)
  {
    return zzl(paramObject, paramLong) != 0;
  }
  
  private static final class zza
    extends zzkx.zzd
  {
    zza(Unsafe paramUnsafe)
    {
      super();
    }
    
    public final byte zza(Object paramObject, long paramLong)
    {
      if (zzkx.zza) {
        return zzkx.zzg(paramObject, paramLong);
      }
      return zzkx.zzh(paramObject, paramLong);
    }
    
    public final void zza(Object paramObject, long paramLong, byte paramByte)
    {
      if (zzkx.zza)
      {
        zzkx.zza(paramObject, paramLong, paramByte);
        return;
      }
      zzkx.zzb(paramObject, paramLong, paramByte);
    }
    
    public final void zza(Object paramObject, long paramLong, double paramDouble)
    {
      zza(paramObject, paramLong, Double.doubleToLongBits(paramDouble));
    }
    
    public final void zza(Object paramObject, long paramLong, float paramFloat)
    {
      zza(paramObject, paramLong, Float.floatToIntBits(paramFloat));
    }
    
    public final void zza(Object paramObject, long paramLong, boolean paramBoolean)
    {
      if (zzkx.zza)
      {
        zzkx.zzb(paramObject, paramLong, paramBoolean);
        return;
      }
      zzkx.zzc(paramObject, paramLong, paramBoolean);
    }
    
    public final boolean zzb(Object paramObject, long paramLong)
    {
      if (zzkx.zza) {
        return zzkx.zzi(paramObject, paramLong);
      }
      return zzkx.zzj(paramObject, paramLong);
    }
    
    public final float zzc(Object paramObject, long paramLong)
    {
      return Float.intBitsToFloat(zze(paramObject, paramLong));
    }
    
    public final double zzd(Object paramObject, long paramLong)
    {
      return Double.longBitsToDouble(zzf(paramObject, paramLong));
    }
  }
  
  private static final class zzb
    extends zzkx.zzd
  {
    zzb(Unsafe paramUnsafe)
    {
      super();
    }
    
    public final byte zza(Object paramObject, long paramLong)
    {
      return this.zza.getByte(paramObject, paramLong);
    }
    
    public final void zza(Object paramObject, long paramLong, byte paramByte)
    {
      this.zza.putByte(paramObject, paramLong, paramByte);
    }
    
    public final void zza(Object paramObject, long paramLong, double paramDouble)
    {
      this.zza.putDouble(paramObject, paramLong, paramDouble);
    }
    
    public final void zza(Object paramObject, long paramLong, float paramFloat)
    {
      this.zza.putFloat(paramObject, paramLong, paramFloat);
    }
    
    public final void zza(Object paramObject, long paramLong, boolean paramBoolean)
    {
      this.zza.putBoolean(paramObject, paramLong, paramBoolean);
    }
    
    public final boolean zzb(Object paramObject, long paramLong)
    {
      return this.zza.getBoolean(paramObject, paramLong);
    }
    
    public final float zzc(Object paramObject, long paramLong)
    {
      return this.zza.getFloat(paramObject, paramLong);
    }
    
    public final double zzd(Object paramObject, long paramLong)
    {
      return this.zza.getDouble(paramObject, paramLong);
    }
  }
  
  private static final class zzc
    extends zzkx.zzd
  {
    zzc(Unsafe paramUnsafe)
    {
      super();
    }
    
    public final byte zza(Object paramObject, long paramLong)
    {
      if (zzkx.zza) {
        return zzkx.zzg(paramObject, paramLong);
      }
      return zzkx.zzh(paramObject, paramLong);
    }
    
    public final void zza(Object paramObject, long paramLong, byte paramByte)
    {
      if (zzkx.zza)
      {
        zzkx.zza(paramObject, paramLong, paramByte);
        return;
      }
      zzkx.zzb(paramObject, paramLong, paramByte);
    }
    
    public final void zza(Object paramObject, long paramLong, double paramDouble)
    {
      zza(paramObject, paramLong, Double.doubleToLongBits(paramDouble));
    }
    
    public final void zza(Object paramObject, long paramLong, float paramFloat)
    {
      zza(paramObject, paramLong, Float.floatToIntBits(paramFloat));
    }
    
    public final void zza(Object paramObject, long paramLong, boolean paramBoolean)
    {
      if (zzkx.zza)
      {
        zzkx.zzb(paramObject, paramLong, paramBoolean);
        return;
      }
      zzkx.zzc(paramObject, paramLong, paramBoolean);
    }
    
    public final boolean zzb(Object paramObject, long paramLong)
    {
      if (zzkx.zza) {
        return zzkx.zzi(paramObject, paramLong);
      }
      return zzkx.zzj(paramObject, paramLong);
    }
    
    public final float zzc(Object paramObject, long paramLong)
    {
      return Float.intBitsToFloat(zze(paramObject, paramLong));
    }
    
    public final double zzd(Object paramObject, long paramLong)
    {
      return Double.longBitsToDouble(zzf(paramObject, paramLong));
    }
  }
  
  private static abstract class zzd
  {
    Unsafe zza;
    
    zzd(Unsafe paramUnsafe)
    {
      this.zza = paramUnsafe;
    }
    
    public abstract byte zza(Object paramObject, long paramLong);
    
    public abstract void zza(Object paramObject, long paramLong, byte paramByte);
    
    public abstract void zza(Object paramObject, long paramLong, double paramDouble);
    
    public abstract void zza(Object paramObject, long paramLong, float paramFloat);
    
    public final void zza(Object paramObject, long paramLong, int paramInt)
    {
      this.zza.putInt(paramObject, paramLong, paramInt);
    }
    
    public final void zza(Object paramObject, long paramLong1, long paramLong2)
    {
      this.zza.putLong(paramObject, paramLong1, paramLong2);
    }
    
    public abstract void zza(Object paramObject, long paramLong, boolean paramBoolean);
    
    public abstract boolean zzb(Object paramObject, long paramLong);
    
    public abstract float zzc(Object paramObject, long paramLong);
    
    public abstract double zzd(Object paramObject, long paramLong);
    
    public final int zze(Object paramObject, long paramLong)
    {
      return this.zza.getInt(paramObject, paramLong);
    }
    
    public final long zzf(Object paramObject, long paramLong)
    {
      return this.zza.getLong(paramObject, paramLong);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzkx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */