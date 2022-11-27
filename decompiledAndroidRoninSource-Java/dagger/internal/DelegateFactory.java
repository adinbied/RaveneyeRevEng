package dagger.internal;

import javax.inject.Provider;

public final class DelegateFactory<T>
  implements Factory<T>
{
  private Provider<T> delegate;
  
  public static <T> void setDelegate(Provider<T> paramProvider1, Provider<T> paramProvider2)
  {
    Preconditions.checkNotNull(paramProvider2);
    paramProvider1 = (DelegateFactory)paramProvider1;
    if (paramProvider1.delegate == null)
    {
      paramProvider1.delegate = paramProvider2;
      return;
    }
    throw new IllegalStateException();
  }
  
  public T get()
  {
    return null;
  }
  
  Provider<T> getDelegate()
  {
    return null;
  }
  
  @Deprecated
  public void setDelegatedProvider(Provider<T> paramProvider)
  {
    setDelegate(this, paramProvider);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dagger\internal\DelegateFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */