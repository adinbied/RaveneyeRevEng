package dagger.internal;

import java.util.Collections;
import java.util.Map;
import javax.inject.Provider;

public final class MapFactory<K, V>
  extends AbstractMapFactory<K, V, V>
{
  private static final Provider<Map<Object, Object>> EMPTY = InstanceFactory.create(Collections.emptyMap());
  
  private MapFactory(Map<K, Provider<V>> paramMap)
  {
    super(paramMap);
  }
  
  public static <K, V> Builder<K, V> builder(int paramInt)
  {
    return new Builder(paramInt, null);
  }
  
  public static <K, V> Provider<Map<K, V>> emptyMapProvider()
  {
    return EMPTY;
  }
  
  public Map<K, V> get()
  {
    return null;
  }
  
  public static final class Builder<K, V>
    extends AbstractMapFactory.Builder<K, V, V>
  {
    private Builder(int paramInt)
    {
      super();
    }
    
    public MapFactory<K, V> build()
    {
      return null;
    }
    
    public Builder<K, V> put(K paramK, Provider<V> paramProvider)
    {
      super.put(paramK, paramProvider);
      return this;
    }
    
    public Builder<K, V> putAll(Provider<Map<K, V>> paramProvider)
    {
      super.putAll(paramProvider);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dagger\internal\MapFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */