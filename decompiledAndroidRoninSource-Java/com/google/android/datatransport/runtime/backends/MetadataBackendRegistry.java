package com.google.android.datatransport.runtime.backends;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
class MetadataBackendRegistry
  implements BackendRegistry
{
  private static final String BACKEND_KEY_PREFIX = "backend:";
  private static final String TAG = "BackendRegistry";
  private final BackendFactoryProvider backendFactoryProvider;
  private final Map<String, TransportBackend> backends = new HashMap();
  private final CreationContextFactory creationContextFactory;
  
  @Inject
  MetadataBackendRegistry(Context paramContext, CreationContextFactory paramCreationContextFactory)
  {
    this(new BackendFactoryProvider(paramContext), paramCreationContextFactory);
  }
  
  MetadataBackendRegistry(BackendFactoryProvider paramBackendFactoryProvider, CreationContextFactory paramCreationContextFactory)
  {
    this.backendFactoryProvider = paramBackendFactoryProvider;
    this.creationContextFactory = paramCreationContextFactory;
  }
  
  public TransportBackend get(String paramString)
  {
    try
    {
      if (this.backends.containsKey(paramString))
      {
        paramString = (TransportBackend)this.backends.get(paramString);
        return paramString;
      }
      Object localObject = this.backendFactoryProvider.get(paramString);
      if (localObject == null) {
        return null;
      }
      localObject = ((BackendFactory)localObject).create(this.creationContextFactory.create(paramString));
      this.backends.put(paramString, localObject);
      return (TransportBackend)localObject;
    }
    finally {}
  }
  
  static class BackendFactoryProvider
  {
    private final Context applicationContext;
    private Map<String, String> backendProviders = null;
    
    BackendFactoryProvider(Context paramContext)
    {
      this.applicationContext = paramContext;
    }
    
    private Map<String, String> discover(Context paramContext)
    {
      paramContext = getMetadata(paramContext);
      if (paramContext == null)
      {
        Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
        return Collections.emptyMap();
      }
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramContext.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        Object localObject = paramContext.get(str1);
        if (((localObject instanceof String)) && (str1.startsWith("backend:")))
        {
          localObject = ((String)localObject).split(",", -1);
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            String str2 = localObject[i].trim();
            if (!str2.isEmpty()) {
              localHashMap.put(str2, str1.substring(8));
            }
            i += 1;
          }
        }
      }
      return localHashMap;
    }
    
    private Map<String, String> getBackendProviders()
    {
      if (this.backendProviders == null) {
        this.backendProviders = discover(this.applicationContext);
      }
      return this.backendProviders;
    }
    
    private static Bundle getMetadata(Context paramContext)
    {
      try
      {
        PackageManager localPackageManager = paramContext.getPackageManager();
        if (localPackageManager == null)
        {
          Log.w("BackendRegistry", "Context has no PackageManager.");
          return null;
        }
        paramContext = localPackageManager.getServiceInfo(new ComponentName(paramContext, TransportBackendDiscovery.class), 128);
        if (paramContext == null)
        {
          Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
          return null;
        }
        paramContext = paramContext.metaData;
        return paramContext;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;) {}
      }
      Log.w("BackendRegistry", "Application info not found.");
      return null;
    }
    
    BackendFactory get(String paramString)
    {
      paramString = (String)getBackendProviders().get(paramString);
      if (paramString == null) {
        return null;
      }
      try
      {
        BackendFactory localBackendFactory = (BackendFactory)Class.forName(paramString).asSubclass(BackendFactory.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        return localBackendFactory;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        Log.w("BackendRegistry", String.format("Could not instantiate %s", new Object[] { paramString }), localInvocationTargetException);
        return null;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.w("BackendRegistry", String.format("Could not instantiate %s", new Object[] { paramString }), localNoSuchMethodException);
        return null;
      }
      catch (InstantiationException localInstantiationException)
      {
        Log.w("BackendRegistry", String.format("Could not instantiate %s.", new Object[] { paramString }), localInstantiationException);
        return null;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        Log.w("BackendRegistry", String.format("Could not instantiate %s.", new Object[] { paramString }), localIllegalAccessException);
        return null;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Log.w("BackendRegistry", String.format("Class %s is not found.", new Object[] { paramString }), localClassNotFoundException);
      }
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\backends\MetadataBackendRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */