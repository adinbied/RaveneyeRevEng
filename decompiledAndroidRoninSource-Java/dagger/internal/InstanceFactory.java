package dagger.internal;

import dagger.Lazy;

public final class InstanceFactory<T>
  implements Factory<T>, Lazy<T>
{
  private static final InstanceFactory<Object> NULL_INSTANCE_FACTORY = new InstanceFactory(null);
  private final T instance;
  
  private InstanceFactory(T paramT)
  {
    this.instance = paramT;
  }
  
  public static <T> Factory<T> create(T paramT)
  {
    return new InstanceFactory(Preconditions.checkNotNull(paramT, "instance cannot be null"));
  }
  
  public static <T> Factory<T> createNullable(T paramT)
  {
    if (paramT == null) {
      return nullInstanceFactory();
    }
    return new InstanceFactory(paramT);
  }
  
  private static <T> InstanceFactory<T> nullInstanceFactory()
  {
    return NULL_INSTANCE_FACTORY;
  }
  
  public T get()
  {
    return (T)this.instance;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dagger\internal\InstanceFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */