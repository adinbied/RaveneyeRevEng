package com.google.firebase.components;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class ComponentDiscovery<T>
{
  private static final String COMPONENT_KEY_PREFIX = "com.google.firebase.components:";
  private static final String COMPONENT_SENTINEL_VALUE = "com.google.firebase.components.ComponentRegistrar";
  private static final String TAG = "ComponentDiscovery";
  private final T context;
  private final RegistrarNameRetriever<T> retriever;
  
  ComponentDiscovery(T paramT, RegistrarNameRetriever<T> paramRegistrarNameRetriever)
  {
    this.context = paramT;
    this.retriever = paramRegistrarNameRetriever;
  }
  
  public static ComponentDiscovery<Context> forContext(Context paramContext, Class<? extends Service> paramClass)
  {
    return new ComponentDiscovery(paramContext, new MetadataRegistrarNameRetriever(paramClass, null));
  }
  
  private static List<ComponentRegistrar> instantiate(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      try
      {
        Class localClass = Class.forName(str);
        if (!ComponentRegistrar.class.isAssignableFrom(localClass)) {
          Log.w("ComponentDiscovery", String.format("Class %s is not an instance of %s", new Object[] { str, "com.google.firebase.components.ComponentRegistrar" }));
        } else {
          localArrayList.add((ComponentRegistrar)localClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        Log.w("ComponentDiscovery", String.format("Could not instantiate %s", new Object[] { str }), localInvocationTargetException);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.w("ComponentDiscovery", String.format("Could not instantiate %s", new Object[] { str }), localNoSuchMethodException);
      }
      catch (InstantiationException localInstantiationException)
      {
        Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", new Object[] { str }), localInstantiationException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", new Object[] { str }), localIllegalAccessException);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Log.w("ComponentDiscovery", String.format("Class %s is not an found.", new Object[] { str }), localClassNotFoundException);
      }
    }
    return localArrayList;
  }
  
  public List<ComponentRegistrar> discover()
  {
    return instantiate(this.retriever.retrieve(this.context));
  }
  
  private static class MetadataRegistrarNameRetriever
    implements ComponentDiscovery.RegistrarNameRetriever<Context>
  {
    private final Class<? extends Service> discoveryService;
    
    private MetadataRegistrarNameRetriever(Class<? extends Service> paramClass)
    {
      this.discoveryService = paramClass;
    }
    
    private Bundle getMetadata(Context paramContext)
    {
      try
      {
        PackageManager localPackageManager = paramContext.getPackageManager();
        if (localPackageManager == null)
        {
          Log.w("ComponentDiscovery", "Context has no PackageManager.");
          return null;
        }
        paramContext = localPackageManager.getServiceInfo(new ComponentName(paramContext, this.discoveryService), 128);
        if (paramContext == null)
        {
          paramContext = new StringBuilder();
          paramContext.append(this.discoveryService);
          paramContext.append(" has no service info.");
          Log.w("ComponentDiscovery", paramContext.toString());
          return null;
        }
        paramContext = paramContext.metaData;
        return paramContext;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;) {}
      }
      Log.w("ComponentDiscovery", "Application info not found.");
      return null;
    }
    
    public List<String> retrieve(Context paramContext)
    {
      paramContext = getMetadata(paramContext);
      if (paramContext == null)
      {
        Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
        return Collections.emptyList();
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramContext.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (("com.google.firebase.components.ComponentRegistrar".equals(paramContext.get(str))) && (str.startsWith("com.google.firebase.components:"))) {
          localArrayList.add(str.substring(31));
        }
      }
      return localArrayList;
    }
  }
  
  static abstract interface RegistrarNameRetriever<T>
  {
    public abstract List<String> retrieve(T paramT);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\components\ComponentDiscovery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */