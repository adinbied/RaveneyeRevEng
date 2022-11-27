package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public class Lazy<T>
  implements Provider<T>
{
  private static final Object UNINITIALIZED = new Object();
  private volatile Object instance = UNINITIALIZED;
  private volatile Provider<T> provider;
  
  public Lazy(Provider<T> paramProvider)
  {
    this.provider = paramProvider;
  }
  
  Lazy(T paramT)
  {
    this.instance = paramT;
  }
  
  public T get()
  {
    Object localObject1 = this.instance;
    if (localObject1 == UNINITIALIZED) {
      try
      {
        Object localObject2 = this.instance;
        localObject1 = localObject2;
        if (localObject2 == UNINITIALIZED)
        {
          localObject1 = this.provider.get();
          this.instance = localObject1;
          this.provider = null;
        }
        return (T)localObject1;
      }
      finally {}
    }
    return ?;
  }
  
  boolean isInitialized()
  {
    return this.instance != UNINITIALIZED;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\components\Lazy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */