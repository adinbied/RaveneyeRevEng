package dagger.internal;

import dagger.Lazy;
import javax.inject.Provider;

public final class ProviderOfLazy<T>
  implements Provider<Lazy<T>>
{
  private final Provider<T> provider;
  
  private ProviderOfLazy(Provider<T> paramProvider)
  {
    this.provider = paramProvider;
  }
  
  public static <T> Provider<Lazy<T>> create(Provider<T> paramProvider)
  {
    return new ProviderOfLazy((Provider)Preconditions.checkNotNull(paramProvider));
  }
  
  public Lazy<T> get()
  {
    return DoubleCheck.lazy(this.provider);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dagger\internal\ProviderOfLazy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */