package dagger.internal;

import dagger.Lazy;
import java.util.Map;
import javax.inject.Provider;

public final class MapProviderFactory<K, V>
  extends AbstractMapFactory<K, V, Provider<V>>
  implements Lazy<Map<K, Provider<V>>>
{
  private MapProviderFactory(Map<K, Provider<V>> paramMap)
  {
    super(paramMap);
  }
  
  public static <K, V> Builder<K, V> builder(int paramInt)
  {
    return new Builder(paramInt, null);
  }
  
  public Map<K, Provider<V>> get()
  {
    return contributingMap();
  }
  
  public static final class Builder<K, V>
    extends AbstractMapFactory.Builder<K, V, Provider<V>>
  {
    private Builder(int paramInt)
    {
      super();
    }
    
    public MapProviderFactory<K, V> build()
    {
      return null;
    }
    
    public Builder<K, V> put(K paramK, Provider<V> paramProvider)
    {
      super.put(paramK, paramProvider);
      return this;
    }
    
    public Builder<K, V> putAll(Provider<Map<K, Provider<V>>> paramProvider)
    {
      super.putAll(paramProvider);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dagger\internal\MapProviderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */