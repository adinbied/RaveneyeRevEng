package dagger.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;

public final class SetFactory<T>
  implements Factory<Set<T>>
{
  private static final Factory<Set<Object>> EMPTY_FACTORY = InstanceFactory.create(Collections.emptySet());
  private final List<Provider<Collection<T>>> collectionProviders;
  private final List<Provider<T>> individualProviders;
  
  private SetFactory(List<Provider<T>> paramList, List<Provider<Collection<T>>> paramList1)
  {
    this.individualProviders = paramList;
    this.collectionProviders = paramList1;
  }
  
  public static <T> Builder<T> builder(int paramInt1, int paramInt2)
  {
    return new Builder(paramInt1, paramInt2, null);
  }
  
  public static <T> Factory<Set<T>> empty()
  {
    return EMPTY_FACTORY;
  }
  
  public Set<T> get()
  {
    return null;
  }
  
  public static final class Builder<T>
  {
    private final List<Provider<Collection<T>>> collectionProviders;
    private final List<Provider<T>> individualProviders;
    
    private Builder(int paramInt1, int paramInt2)
    {
      this.individualProviders = DaggerCollections.presizedList(paramInt1);
      this.collectionProviders = DaggerCollections.presizedList(paramInt2);
    }
    
    public Builder<T> addCollectionProvider(Provider<? extends Collection<? extends T>> paramProvider)
    {
      this.collectionProviders.add(paramProvider);
      return this;
    }
    
    public Builder<T> addProvider(Provider<? extends T> paramProvider)
    {
      this.individualProviders.add(paramProvider);
      return this;
    }
    
    public SetFactory<T> build()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dagger\internal\SetFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */