package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public final class ConstructorConstructor
{
  private final ReflectionAccessor accessor = ReflectionAccessor.getInstance();
  private final Map<Type, InstanceCreator<?>> instanceCreators;
  
  public ConstructorConstructor(Map<Type, InstanceCreator<?>> paramMap)
  {
    this.instanceCreators = paramMap;
  }
  
  private <T> ObjectConstructor<T> newDefaultConstructor(final Class<? super T> paramClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredConstructor(new Class[0]);
      if (!paramClass.isAccessible()) {
        this.accessor.makeAccessible(paramClass);
      }
      paramClass = new ObjectConstructor()
      {
        public T construct()
        {
          try
          {
            Object localObject = paramClass.newInstance(null);
            return (T)localObject;
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            throw new AssertionError(localIllegalAccessException);
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Failed to invoke ");
            localStringBuilder.append(paramClass);
            localStringBuilder.append(" with no args");
            throw new RuntimeException(localStringBuilder.toString(), localInvocationTargetException.getTargetException());
          }
          catch (InstantiationException localInstantiationException)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Failed to invoke ");
            localStringBuilder.append(paramClass);
            localStringBuilder.append(" with no args");
            throw new RuntimeException(localStringBuilder.toString(), localInstantiationException);
          }
        }
      };
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      for (;;) {}
    }
    return null;
  }
  
  private <T> ObjectConstructor<T> newDefaultImplementationConstructor(final Type paramType, Class<? super T> paramClass)
  {
    if (Collection.class.isAssignableFrom(paramClass))
    {
      if (SortedSet.class.isAssignableFrom(paramClass)) {
        new ObjectConstructor()
        {
          public T construct()
          {
            return new TreeSet();
          }
        };
      }
      if (EnumSet.class.isAssignableFrom(paramClass)) {
        new ObjectConstructor()
        {
          public T construct()
          {
            Object localObject = paramType;
            if ((localObject instanceof ParameterizedType))
            {
              localObject = ((ParameterizedType)localObject).getActualTypeArguments()[0];
              if ((localObject instanceof Class)) {
                return EnumSet.noneOf((Class)localObject);
              }
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("Invalid EnumSet type: ");
              ((StringBuilder)localObject).append(paramType.toString());
              throw new JsonIOException(((StringBuilder)localObject).toString());
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Invalid EnumSet type: ");
            ((StringBuilder)localObject).append(paramType.toString());
            throw new JsonIOException(((StringBuilder)localObject).toString());
          }
        };
      }
      if (Set.class.isAssignableFrom(paramClass)) {
        new ObjectConstructor()
        {
          public T construct()
          {
            return new LinkedHashSet();
          }
        };
      }
      if (Queue.class.isAssignableFrom(paramClass)) {
        new ObjectConstructor()
        {
          public T construct()
          {
            return new ArrayDeque();
          }
        };
      }
      new ObjectConstructor()
      {
        public T construct()
        {
          return new ArrayList();
        }
      };
    }
    if (Map.class.isAssignableFrom(paramClass))
    {
      if (ConcurrentNavigableMap.class.isAssignableFrom(paramClass)) {
        new ObjectConstructor()
        {
          public T construct()
          {
            return new ConcurrentSkipListMap();
          }
        };
      }
      if (ConcurrentMap.class.isAssignableFrom(paramClass)) {
        new ObjectConstructor()
        {
          public T construct()
          {
            return new ConcurrentHashMap();
          }
        };
      }
      if (SortedMap.class.isAssignableFrom(paramClass)) {
        new ObjectConstructor()
        {
          public T construct()
          {
            return new TreeMap();
          }
        };
      }
      if (((paramType instanceof ParameterizedType)) && (!String.class.isAssignableFrom(TypeToken.get(((ParameterizedType)paramType).getActualTypeArguments()[0]).getRawType()))) {
        new ObjectConstructor()
        {
          public T construct()
          {
            return new LinkedHashMap();
          }
        };
      }
      new ObjectConstructor()
      {
        public T construct()
        {
          return new LinkedTreeMap();
        }
      };
    }
    return null;
  }
  
  private <T> ObjectConstructor<T> newUnsafeAllocator(final Type paramType, final Class<? super T> paramClass)
  {
    new ObjectConstructor()
    {
      private final UnsafeAllocator unsafeAllocator = UnsafeAllocator.create();
      
      public T construct()
      {
        try
        {
          Object localObject = this.unsafeAllocator.newInstance(paramClass);
          return (T)localObject;
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unable to invoke no-args constructor for ");
          localStringBuilder.append(paramType);
          localStringBuilder.append(". Registering an InstanceCreator with Gson for this type may fix this problem.");
          throw new RuntimeException(localStringBuilder.toString(), localException);
        }
      }
    };
  }
  
  public <T> ObjectConstructor<T> get(TypeToken<T> paramTypeToken)
  {
    final Type localType = paramTypeToken.getType();
    paramTypeToken = paramTypeToken.getRawType();
    final Object localObject = (InstanceCreator)this.instanceCreators.get(localType);
    if (localObject != null) {
      new ObjectConstructor()
      {
        public T construct()
        {
          return (T)localObject.createInstance(localType);
        }
      };
    }
    localObject = (InstanceCreator)this.instanceCreators.get(paramTypeToken);
    if (localObject != null) {
      new ObjectConstructor()
      {
        public T construct()
        {
          return (T)localObject.createInstance(localType);
        }
      };
    }
    localObject = newDefaultConstructor(paramTypeToken);
    if (localObject != null) {
      return (ObjectConstructor<T>)localObject;
    }
    localObject = newDefaultImplementationConstructor(localType, paramTypeToken);
    if (localObject != null) {
      return (ObjectConstructor<T>)localObject;
    }
    return newUnsafeAllocator(localType, paramTypeToken);
  }
  
  public String toString()
  {
    return this.instanceCreators.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\gson\internal\ConstructorConstructor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */