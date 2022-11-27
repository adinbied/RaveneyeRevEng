package kotlin.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000&\n\000\n\002\020$\n\000\n\002\020\b\n\000\n\002\030\002\n\000\n\002\020%\n\002\b\003\n\002\030\002\n\002\020&\n\000\0320\020\000\032\016\022\004\022\002H\002\022\004\022\0020\0030\001\"\004\b\000\020\004\"\004\b\001\020\002*\016\022\004\022\002H\004\022\004\022\002H\0020\005H\007\032W\020\006\032\016\022\004\022\002H\002\022\004\022\002H\b0\007\"\004\b\000\020\002\"\004\b\001\020\t\"\004\b\002\020\b*\016\022\004\022\002H\002\022\004\022\002H\t0\0072\036\020\n\032\032\022\020\022\016\022\004\022\002H\002\022\004\022\002H\t0\f\022\004\022\002H\b0\013H\b¨\006\r"}, d2={"eachCount", "", "K", "", "T", "Lkotlin/collections/Grouping;", "mapValuesInPlace", "", "R", "V", "f", "Lkotlin/Function1;", "", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/collections/GroupingKt")
class GroupingKt__GroupingJVMKt
{
  public static final <T, K> Map<K, Integer> eachCount(Grouping<T, ? extends K> paramGrouping)
  {
    Intrinsics.checkParameterIsNotNull(paramGrouping, "$this$eachCount");
    Map localMap = (Map)new LinkedHashMap();
    Iterator localIterator = paramGrouping.sourceIterator();
    Object localObject1;
    while (localIterator.hasNext())
    {
      Object localObject2 = paramGrouping.keyOf(localIterator.next());
      localObject1 = localMap.get(localObject2);
      int i;
      if ((localObject1 == null) && (!localMap.containsKey(localObject2))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        localObject1 = new Ref.IntRef();
      }
      localObject1 = (Ref.IntRef)localObject1;
      ((Ref.IntRef)localObject1).element += 1;
      localMap.put(localObject2, localObject1);
    }
    paramGrouping = ((Iterable)localMap.entrySet()).iterator();
    while (paramGrouping.hasNext())
    {
      localObject1 = (Map.Entry)paramGrouping.next();
      if (localObject1 != null) {
        TypeIntrinsics.asMutableMapEntry(localObject1).setValue(Integer.valueOf(((Ref.IntRef)((Map.Entry)localObject1).getValue()).element));
      } else {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K, R>");
      }
    }
    return TypeIntrinsics.asMutableMap(localMap);
  }
  
  private static final <K, V, R> Map<K, R> mapValuesInPlace(Map<K, V> paramMap, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> paramFunction1)
  {
    Iterator localIterator = ((Iterable)paramMap.entrySet()).iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry != null) {
        TypeIntrinsics.asMutableMapEntry(localEntry).setValue(paramFunction1.invoke(localEntry));
      } else {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K, R>");
      }
    }
    if (paramMap != null) {
      return TypeIntrinsics.asMutableMap(paramMap);
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, R>");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\GroupingKt__GroupingJVMKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */