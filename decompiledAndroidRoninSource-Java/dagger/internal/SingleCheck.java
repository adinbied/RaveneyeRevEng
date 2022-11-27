package dagger.internal;

import javax.inject.Provider;

public final class SingleCheck<T>
  implements Provider<T>
{
  private static final Object UNINITIALIZED = new Object();
  private volatile Object instance = UNINITIALIZED;
  private volatile Provider<T> provider;
  
  private SingleCheck(Provider<T> paramProvider)
  {
    this.provider = paramProvider;
  }
  
  public static <P extends Provider<T>, T> Provider<T> provider(P paramP)
  {
    if (!(paramP instanceof SingleCheck))
    {
      if ((paramP instanceof DoubleCheck)) {
        return paramP;
      }
      return new SingleCheck((Provider)Preconditions.checkNotNull(paramP));
    }
    return paramP;
  }
  
  public T get()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dagger\internal\SingleCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */