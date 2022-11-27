package dagger.internal;

import java.util.Map;

public final class MapBuilder<K, V>
{
  private final Map<K, V> contributions;
  
  private MapBuilder(int paramInt)
  {
    this.contributions = DaggerCollections.newLinkedHashMapWithExpectedSize(paramInt);
  }
  
  public static <K, V> MapBuilder<K, V> newMapBuilder(int paramInt)
  {
    return new MapBuilder(paramInt);
  }
  
  public Map<K, V> build()
  {
    return null;
  }
  
  public MapBuilder<K, V> put(K paramK, V paramV)
  {
    this.contributions.put(paramK, paramV);
    return this;
  }
  
  public MapBuilder<K, V> putAll(Map<K, V> paramMap)
  {
    this.contributions.putAll(paramMap);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dagger\internal\MapBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */