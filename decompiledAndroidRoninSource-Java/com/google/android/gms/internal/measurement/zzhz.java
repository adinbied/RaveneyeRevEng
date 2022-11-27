package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzhz<MessageType extends zzhz<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>>
  extends zzgh<MessageType, BuilderType>
{
  private static Map<Object, zzhz<?, ?>> zzd = new ConcurrentHashMap();
  protected zzku zzb = zzku.zza();
  private int zzc = -1;
  
  static <T extends zzhz<?, ?>> T zza(Class<T> paramClass)
  {
    zzhz localzzhz2 = (zzhz)zzd.get(paramClass);
    zzhz localzzhz1 = localzzhz2;
    if (localzzhz2 == null) {
      try
      {
        Class.forName(paramClass.getName(), true, paramClass.getClassLoader());
        localzzhz1 = (zzhz)zzd.get(paramClass);
      }
      catch (ClassNotFoundException paramClass)
      {
        throw new IllegalStateException("Class initialization cannot fail.", paramClass);
      }
    }
    if (localzzhz1 == null)
    {
      localzzhz1 = (zzhz)((zzhz)zzkx.zza(paramClass)).zza(zzf.zzf, null, null);
      if (localzzhz1 != null)
      {
        zzd.put(paramClass, localzzhz1);
        return localzzhz1;
      }
      throw new IllegalStateException();
    }
    return localzzhz1;
  }
  
  protected static zzif zza(zzif paramzzif)
  {
    int i = paramzzif.size();
    if (i == 0) {
      i = 10;
    } else {
      i <<= 1;
    }
    return paramzzif.zzc(i);
  }
  
  protected static <E> zzii<E> zza(zzii<E> paramzzii)
  {
    int i = paramzzii.size();
    if (i == 0) {
      i = 10;
    } else {
      i <<= 1;
    }
    return paramzzii.zza(i);
  }
  
  protected static Object zza(zzjh paramzzjh, String paramString, Object[] paramArrayOfObject)
  {
    return new zzjx(paramzzjh, paramString, paramArrayOfObject);
  }
  
  static Object zza(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    try
    {
      paramMethod = paramMethod.invoke(paramObject, paramVarArgs);
      return paramMethod;
    }
    catch (InvocationTargetException paramMethod)
    {
      paramMethod = paramMethod.getCause();
      if (!(paramMethod instanceof RuntimeException))
      {
        if ((paramMethod instanceof Error)) {
          throw ((Error)paramMethod);
        }
        throw new RuntimeException("Unexpected exception thrown by generated accessor method.", paramMethod);
      }
      throw ((RuntimeException)paramMethod);
    }
    catch (IllegalAccessException paramMethod)
    {
      throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", paramMethod);
    }
  }
  
  protected static <T extends zzhz<?, ?>> void zza(Class<T> paramClass, T paramT)
  {
    zzd.put(paramClass, paramT);
  }
  
  protected static final <T extends zzhz<T, ?>> boolean zza(T paramT, boolean paramBoolean)
  {
    int i = ((Byte)paramT.zza(zzf.zza, null, null)).byteValue();
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    boolean bool = zzjv.zza().zza(paramT).zzd(paramT);
    if (paramBoolean)
    {
      i = zzf.zzb;
      T ?;
      if (bool) {
        ? = paramT;
      } else {
        ? = null;
      }
      paramT.zza(i, ?, null);
    }
    return bool;
  }
  
  protected static zzig zzbp()
  {
    return zzia.zzd();
  }
  
  protected static zzif zzbq()
  {
    return zziv.zzd();
  }
  
  protected static <E> zzii<E> zzbr()
  {
    return zzjy.zzd();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    return zzjv.zza().zza(this).zza(this, (zzhz)paramObject);
  }
  
  public int hashCode()
  {
    if (this.zza != 0) {
      return this.zza;
    }
    this.zza = zzjv.zza().zza(this).zza(this);
    return this.zza;
  }
  
  public final boolean i_()
  {
    return zza(this, Boolean.TRUE.booleanValue());
  }
  
  public String toString()
  {
    return zzjm.zza(this, super.toString());
  }
  
  protected abstract Object zza(int paramInt, Object paramObject1, Object paramObject2);
  
  public final void zza(zzhg paramzzhg)
    throws IOException
  {
    zzjv.zza().zza(this).zza(this, zzhj.zza(paramzzhg));
  }
  
  final int zzbl()
  {
    return this.zzc;
  }
  
  protected final <MessageType extends zzhz<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzbm()
  {
    return (zza)zza(zzf.zze, null, null);
  }
  
  public final BuilderType zzbn()
  {
    zza localzza = (zza)zza(zzf.zze, null, null);
    localzza.zza(this);
    return localzza;
  }
  
  public final int zzbo()
  {
    if (this.zzc == -1) {
      this.zzc = zzjv.zza().zza(this).zzb(this);
    }
    return this.zzc;
  }
  
  final void zzc(int paramInt)
  {
    this.zzc = paramInt;
  }
  
  public static class zza<MessageType extends zzhz<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>>
    extends zzgg<MessageType, BuilderType>
  {
    protected MessageType zza;
    protected boolean zzb;
    private final MessageType zzc;
    
    protected zza(MessageType paramMessageType)
    {
      this.zzc = paramMessageType;
      this.zza = ((zzhz)paramMessageType.zza(zzhz.zzf.zzd, null, null));
      this.zzb = false;
    }
    
    private static void zza(MessageType paramMessageType1, MessageType paramMessageType2)
    {
      zzjv.zza().zza(paramMessageType1).zzb(paramMessageType1, paramMessageType2);
    }
    
    private final BuilderType zzb(zzhd paramzzhd, zzhm paramzzhm)
      throws IOException
    {
      if (this.zzb)
      {
        zzu();
        this.zzb = false;
      }
      try
      {
        zzjv.zza().zza(this.zza).zza(this.zza, zzhe.zza(paramzzhd), paramzzhm);
        return this;
      }
      catch (RuntimeException paramzzhd)
      {
        if ((paramzzhd.getCause() instanceof IOException)) {
          throw ((IOException)paramzzhd.getCause());
        }
        throw paramzzhd;
      }
    }
    
    private final BuilderType zzb(byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzhm paramzzhm)
      throws zzih
    {
      if (this.zzb)
      {
        zzu();
        this.zzb = false;
      }
      try
      {
        zzjv.zza().zza(this.zza).zza(this.zza, paramArrayOfByte, 0, paramInt2, new zzgm(paramzzhm));
        return this;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new RuntimeException("Reading from byte array should not throw IOException.", paramArrayOfByte);
        throw zzih.zza();
      }
      catch (zzih paramArrayOfByte)
      {
        throw paramArrayOfByte;
      }
      catch (IndexOutOfBoundsException paramArrayOfByte)
      {
        for (;;) {}
      }
    }
    
    public final boolean i_()
    {
      return zzhz.zza(this.zza, false);
    }
    
    public final BuilderType zza(MessageType paramMessageType)
    {
      if (this.zzb)
      {
        zzu();
        this.zzb = false;
      }
      zza(this.zza, paramMessageType);
      return this;
    }
    
    protected void zzu()
    {
      zzhz localzzhz = (zzhz)this.zza.zza(zzhz.zzf.zzd, null, null);
      zza(localzzhz, this.zza);
      this.zza = localzzhz;
    }
    
    public MessageType zzw()
    {
      if (this.zzb) {
        return this.zza;
      }
      zzhz localzzhz = this.zza;
      zzjv.zza().zza(localzzhz).zzc(localzzhz);
      this.zzb = true;
      return this.zza;
    }
    
    public final MessageType zzx()
    {
      zzhz localzzhz = (zzhz)zzy();
      if (localzzhz.i_()) {
        return localzzhz;
      }
      throw new zzks(localzzhz);
    }
  }
  
  public static abstract class zzb<MessageType extends zzb<MessageType, BuilderType>, BuilderType>
    extends zzhz<MessageType, BuilderType>
    implements zzjj
  {
    protected zzhp<zzhz.zze> zzc = zzhp.zza();
    
    final zzhp<zzhz.zze> zza()
    {
      if (this.zzc.zzc()) {
        this.zzc = ((zzhp)this.zzc.clone());
      }
      return this.zzc;
    }
  }
  
  protected static final class zzc<T extends zzhz<T, ?>>
    extends zzgi<T>
  {
    private final T zza;
    
    public zzc(T paramT)
    {
      this.zza = paramT;
    }
  }
  
  public static final class zzd<ContainingType extends zzjh, Type>
    extends zzhk<ContainingType, Type>
  {}
  
  static final class zze
    implements zzhr<zze>
  {
    public final int zza()
    {
      throw new NoSuchMethodError();
    }
    
    public final zzjk zza(zzjk paramzzjk, zzjh paramzzjh)
    {
      throw new NoSuchMethodError();
    }
    
    public final zzjq zza(zzjq paramzzjq1, zzjq paramzzjq2)
    {
      throw new NoSuchMethodError();
    }
    
    public final zzli zzb()
    {
      throw new NoSuchMethodError();
    }
    
    public final zzll zzc()
    {
      throw new NoSuchMethodError();
    }
    
    public final boolean zzd()
    {
      throw new NoSuchMethodError();
    }
    
    public final boolean zze()
    {
      throw new NoSuchMethodError();
    }
  }
  
  public static enum zzf
  {
    public static int[] zza()
    {
      return (int[])zzh.clone();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzhz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */