package com.google.android.gms.internal.measurement;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class zzhy<T extends zzhm>
{
  private static final Logger zza = Logger.getLogger(zzhg.class.getName());
  private static String zzb = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";
  
  static <T extends zzhm> T zza(Class<T> paramClass)
  {
    Object localObject2 = zzhy.class.getClassLoader();
    Object localObject1;
    if (paramClass.equals(zzhm.class))
    {
      localObject1 = zzb;
    }
    else
    {
      if (!paramClass.getPackage().equals(zzhy.class.getPackage())) {
        break label346;
      }
      localObject1 = String.format("%s.BlazeGenerated%sLoader", new Object[] { paramClass.getPackage().getName(), paramClass.getSimpleName() });
    }
    try
    {
      localObject1 = Class.forName((String)localObject1, true, (ClassLoader)localObject2);
      try
      {
        localObject1 = (zzhy)((Class)localObject1).getConstructor(new Class[0]).newInstance(new Object[0]);
        return (zzhm)paramClass.cast(((zzhy)localObject1).zza());
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new IllegalStateException(localInvocationTargetException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new IllegalStateException(localIllegalAccessException);
      }
      catch (InstantiationException localInstantiationException)
      {
        throw new IllegalStateException(localInstantiationException);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        throw new IllegalStateException(localNoSuchMethodException);
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      ArrayList localArrayList;
      for (;;) {}
    }
    localObject2 = ServiceLoader.load(zzhy.class, (ClassLoader)localObject2).iterator();
    localArrayList = new ArrayList();
    while (((Iterator)localObject2).hasNext()) {
      try
      {
        localArrayList.add(paramClass.cast(((zzhy)((Iterator)localObject2).next()).zza()));
      }
      catch (ServiceConfigurationError localServiceConfigurationError)
      {
        Logger localLogger = zza;
        Level localLevel = Level.SEVERE;
        String str = String.valueOf(paramClass.getSimpleName());
        if (str.length() != 0) {
          str = "Unable to load ".concat(str);
        } else {
          str = new String("Unable to load ");
        }
        localLogger.logp(localLevel, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", str, localServiceConfigurationError);
      }
    }
    if (localArrayList.size() == 1) {
      return (zzhm)localArrayList.get(0);
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    try
    {
      paramClass = (zzhm)paramClass.getMethod("combine", new Class[] { Collection.class }).invoke(null, new Object[] { localArrayList });
      return paramClass;
    }
    catch (InvocationTargetException paramClass)
    {
      throw new IllegalStateException(paramClass);
    }
    catch (IllegalAccessException paramClass)
    {
      throw new IllegalStateException(paramClass);
    }
    catch (NoSuchMethodException paramClass)
    {
      throw new IllegalStateException(paramClass);
    }
    label346:
    throw new IllegalArgumentException(paramClass.getName());
  }
  
  protected abstract T zza();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzhy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */