package kotlin.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={"\000R\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020$\n\000\n\002\030\002\n\002\030\002\n\002\b\004\n\002\020\"\n\002\020&\n\002\b\007\n\002\020\b\n\002\b\003\n\002\020\036\n\002\b\003\n\002\020\013\n\002\b\005\n\002\020\000\n\002\b\006\n\002\020\016\n\000\b\002\030\000*\004\b\000\020\001*\006\b\001\020\002 \0012\016\022\004\022\002H\001\022\004\022\002H\0020\003B<\022\022\020\004\032\016\022\004\022\0028\000\022\004\022\0028\0010\005\022!\020\006\032\035\022\023\022\0218\000¢\006\f\b\b\022\b\b\t\022\004\b\b(\n\022\004\022\0028\0010\007¢\006\002\020\013J\025\020\035\032\0020\0362\006\020\n\032\0028\000H\026¢\006\002\020\037J\025\020 \032\0020\0362\006\020!\032\0028\001H\026¢\006\002\020\037J\023\020\"\032\0020\0362\b\020#\032\004\030\0010$H\002J\030\020%\032\004\030\0018\0012\006\020\n\032\0028\000H\002¢\006\002\020&J\025\020'\032\0028\0012\006\020\n\032\0028\000H\026¢\006\002\020&J\b\020(\032\0020\026H\026J\b\020)\032\0020\036H\026J\b\020*\032\0020+H\026R)\020\006\032\035\022\023\022\0218\000¢\006\f\b\b\022\b\b\t\022\004\b\b(\n\022\004\022\0028\0010\007X\004¢\006\002\n\000R&\020\f\032\024\022\020\022\016\022\004\022\0028\000\022\004\022\0028\0010\0160\r8VX\004¢\006\006\032\004\b\017\020\020R\032\020\021\032\b\022\004\022\0028\0000\r8VX\004¢\006\006\032\004\b\022\020\020R \020\004\032\016\022\004\022\0028\000\022\004\022\0028\0010\005X\004¢\006\b\n\000\032\004\b\023\020\024R\024\020\025\032\0020\0268VX\004¢\006\006\032\004\b\027\020\030R\032\020\031\032\b\022\004\022\0028\0010\0328VX\004¢\006\006\032\004\b\033\020\034¨\006,"}, d2={"Lkotlin/collections/MapWithDefaultImpl;", "K", "V", "Lkotlin/collections/MapWithDefault;", "map", "", "default", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "key", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "getMap", "()Ljava/util/Map;", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", "(Ljava/lang/Object;)Z", "containsValue", "value", "equals", "other", "", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrImplicitDefault", "hashCode", "isEmpty", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
final class MapWithDefaultImpl<K, V>
  implements MapWithDefault<K, V>
{
  private final Function1<K, V> jdField_default;
  private final Map<K, V> map;
  
  public MapWithDefaultImpl(Map<K, ? extends V> paramMap, Function1<? super K, ? extends V> paramFunction1)
  {
    this.map = paramMap;
    this.jdField_default = paramFunction1;
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean containsKey(Object paramObject)
  {
    return getMap().containsKey(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return getMap().containsValue(paramObject);
  }
  
  public boolean equals(Object paramObject)
  {
    return getMap().equals(paramObject);
  }
  
  public V get(Object paramObject)
  {
    return (V)getMap().get(paramObject);
  }
  
  public Set<Map.Entry<K, V>> getEntries()
  {
    return getMap().entrySet();
  }
  
  public Set<K> getKeys()
  {
    return getMap().keySet();
  }
  
  public Map<K, V> getMap()
  {
    return this.map;
  }
  
  public V getOrImplicitDefault(K paramK)
  {
    Map localMap = getMap();
    Object localObject2 = localMap.get(paramK);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (!localMap.containsKey(paramK)) {
        localObject1 = this.jdField_default.invoke(paramK);
      }
    }
    return (V)localObject1;
  }
  
  public int getSize()
  {
    return getMap().size();
  }
  
  public Collection<V> getValues()
  {
    return getMap().values();
  }
  
  public int hashCode()
  {
    return getMap().hashCode();
  }
  
  public boolean isEmpty()
  {
    return getMap().isEmpty();
  }
  
  public V put(K paramK, V paramV)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public V remove(Object paramObject)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public String toString()
  {
    return getMap().toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\MapWithDefaultImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */