package kotlin.collections;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableMap;

@Metadata(bv={1, 0, 3}, d1={"\000\024\n\002\030\002\n\002\b\002\n\002\020%\n\002\030\002\n\002\b\006\b'\030\000*\004\b\000\020\001*\004\b\001\020\0022\016\022\004\022\002H\001\022\004\022\002H\0020\0032\016\022\004\022\002H\001\022\004\022\002H\0020\004B\007\b\004¢\006\002\020\005J\037\020\006\032\004\030\0018\0012\006\020\007\032\0028\0002\006\020\b\032\0028\001H&¢\006\002\020\t¨\006\n"}, d2={"Lkotlin/collections/AbstractMutableMap;", "K", "V", "", "Ljava/util/AbstractMap;", "()V", "put", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public abstract class AbstractMutableMap<K, V>
  extends AbstractMap<K, V>
  implements Map<K, V>, KMutableMap
{
  public abstract Set getEntries();
  
  public abstract V put(K paramK, V paramV);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\AbstractMutableMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */