package dagger.internal;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;

abstract class AbstractMapFactory<K, V, V2>
  implements Factory<Map<K, V2>>
{
  private final Map<K, Provider<V>> contributingMap;
  
  AbstractMapFactory(Map<K, Provider<V>> paramMap)
  {
    this.contributingMap = Collections.unmodifiableMap(paramMap);
  }
  
  final Map<K, Provider<V>> contributingMap()
  {
    return this.contributingMap;
  }
  
  public static abstract class Builder<K, V, V2>
  {
    final LinkedHashMap<K, Provider<V>> map;
    
    Builder(int paramInt)
    {
      this.map = DaggerCollections.newLinkedHashMapWithExpectedSize(paramInt);
    }
    
    Builder<K, V, V2> put(K paramK, Provider<V> paramProvider)
    {
      return null;
    }
    
    Builder<K, V, V2> putAll(Provider<Map<K, V2>> paramProvider)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dagger\internal\AbstractMapFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */