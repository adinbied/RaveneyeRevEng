package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv={1, 0, 3}, d1={"\000L\n\002\030\002\n\002\020$\n\002\020\000\n\002\020\001\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\"\n\002\020&\n\002\b\005\n\002\020\t\n\000\n\002\020\b\n\002\b\003\n\002\020\036\n\002\b\003\n\002\020\013\n\002\b\n\n\002\020\016\n\000\bÂ\002\030\0002\020\022\006\022\004\030\0010\002\022\004\022\0020\0030\0012\0060\004j\002`\005B\007\b\002¢\006\002\020\006J\022\020\030\032\0020\0312\b\020\032\032\004\030\0010\002H\026J\020\020\033\032\0020\0312\006\020\034\032\0020\003H\026J\023\020\035\032\0020\0312\b\020\036\032\004\030\0010\002H\002J\025\020\037\032\004\030\0010\0032\b\020\032\032\004\030\0010\002H\002J\b\020 \032\0020\021H\026J\b\020!\032\0020\031H\026J\b\020\"\032\0020\002H\002J\b\020#\032\0020$H\026R(\020\007\032\026\022\022\022\020\022\006\022\004\030\0010\002\022\004\022\0020\0030\t0\b8VX\004¢\006\006\032\004\b\n\020\013R\034\020\f\032\n\022\006\022\004\030\0010\0020\b8VX\004¢\006\006\032\004\b\r\020\013R\016\020\016\032\0020\017XT¢\006\002\n\000R\024\020\020\032\0020\0218VX\004¢\006\006\032\004\b\022\020\023R\032\020\024\032\b\022\004\022\0020\0030\0258VX\004¢\006\006\032\004\b\026\020\027¨\006%"}, d2={"Lkotlin/collections/EmptyMap;", "", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "serialVersionUID", "", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", "key", "containsValue", "value", "equals", "other", "get", "hashCode", "isEmpty", "readResolve", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
final class EmptyMap
  implements Map, Serializable, KMappedMarker
{
  public static final EmptyMap INSTANCE = new EmptyMap();
  private static final long serialVersionUID = 8246714829545688274L;
  
  private final Object readResolve()
  {
    return INSTANCE;
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean containsKey(Object paramObject)
  {
    return false;
  }
  
  public boolean containsValue(Void paramVoid)
  {
    Intrinsics.checkParameterIsNotNull(paramVoid, "value");
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof Map)) && (((Map)paramObject).isEmpty());
  }
  
  public Void get(Object paramObject)
  {
    return null;
  }
  
  public Set<Map.Entry> getEntries()
  {
    return (Set)EmptySet.INSTANCE;
  }
  
  public Set<Object> getKeys()
  {
    return (Set)EmptySet.INSTANCE;
  }
  
  public int getSize()
  {
    return 0;
  }
  
  public Collection getValues()
  {
    return (Collection)EmptyList.INSTANCE;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public Void put(Object paramObject, Void paramVoid)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void putAll(Map paramMap)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public Object remove(Object paramObject)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public String toString()
  {
    return "{}";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\EmptyMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */