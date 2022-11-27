package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000D\n\000\n\002\020$\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\020\017\n\000\n\002\020\021\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\020\016\n\002\b\004\n\002\030\002\n\000\0322\020\000\032\016\022\004\022\002H\002\022\004\022\002H\0030\001\"\004\b\000\020\002\"\004\b\001\020\0032\022\020\004\032\016\022\004\022\002H\002\022\004\022\002H\0030\005\032Y\020\006\032\016\022\004\022\002H\002\022\004\022\002H\0030\007\"\016\b\000\020\002*\b\022\004\022\002H\0020\b\"\004\b\001\020\0032*\020\t\032\026\022\022\b\001\022\016\022\004\022\002H\002\022\004\022\002H\0030\0050\n\"\016\022\004\022\002H\002\022\004\022\002H\0030\005¢\006\002\020\013\032@\020\f\032\002H\003\"\004\b\000\020\002\"\004\b\001\020\003*\016\022\004\022\002H\002\022\004\022\002H\0030\r2\006\020\016\032\002H\0022\f\020\017\032\b\022\004\022\002H\0030\020H\b¢\006\002\020\021\032\031\020\022\032\0020\023*\016\022\004\022\0020\024\022\004\022\0020\0240\001H\b\0322\020\025\032\016\022\004\022\002H\002\022\004\022\002H\0030\001\"\004\b\000\020\002\"\004\b\001\020\003*\020\022\006\b\001\022\002H\002\022\004\022\002H\0030\001H\000\0321\020\026\032\016\022\004\022\002H\002\022\004\022\002H\0030\001\"\004\b\000\020\002\"\004\b\001\020\003*\016\022\004\022\002H\002\022\004\022\002H\0030\001H\b\032:\020\027\032\016\022\004\022\002H\002\022\004\022\002H\0030\007\"\016\b\000\020\002*\b\022\004\022\002H\0020\b\"\004\b\001\020\003*\020\022\006\b\001\022\002H\002\022\004\022\002H\0030\001\032@\020\027\032\016\022\004\022\002H\002\022\004\022\002H\0030\007\"\004\b\000\020\002\"\004\b\001\020\003*\020\022\006\b\001\022\002H\002\022\004\022\002H\0030\0012\016\020\030\032\n\022\006\b\000\022\002H\0020\031¨\006\032"}, d2={"mapOf", "", "K", "V", "pair", "Lkotlin/Pair;", "sortedMapOf", "Ljava/util/SortedMap;", "", "pairs", "", "([Lkotlin/Pair;)Ljava/util/SortedMap;", "getOrPut", "Ljava/util/concurrent/ConcurrentMap;", "key", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/concurrent/ConcurrentMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "toProperties", "Ljava/util/Properties;", "", "toSingletonMap", "toSingletonMapOrSelf", "toSortedMap", "comparator", "Ljava/util/Comparator;", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/collections/MapsKt")
class MapsKt__MapsJVMKt
  extends MapsKt__MapWithDefaultKt
{
  public static final <K, V> V getOrPut(ConcurrentMap<K, V> paramConcurrentMap, K paramK, Function0<? extends V> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramConcurrentMap, "$this$getOrPut");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "defaultValue");
    Object localObject = paramConcurrentMap.get(paramK);
    if (localObject != null) {
      return (V)localObject;
    }
    paramFunction0 = paramFunction0.invoke();
    paramK = paramConcurrentMap.putIfAbsent(paramK, paramFunction0);
    paramConcurrentMap = paramFunction0;
    if (paramK != null) {
      paramConcurrentMap = paramK;
    }
    return paramConcurrentMap;
  }
  
  public static final <K, V> Map<K, V> mapOf(Pair<? extends K, ? extends V> paramPair)
  {
    Intrinsics.checkParameterIsNotNull(paramPair, "pair");
    paramPair = Collections.singletonMap(paramPair.getFirst(), paramPair.getSecond());
    Intrinsics.checkExpressionValueIsNotNull(paramPair, "java.util.Collections.si…(pair.first, pair.second)");
    return paramPair;
  }
  
  public static final <K extends Comparable<? super K>, V> SortedMap<K, V> sortedMapOf(Pair<? extends K, ? extends V>... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "pairs");
    TreeMap localTreeMap = new TreeMap();
    MapsKt.putAll((Map)localTreeMap, paramVarArgs);
    return (SortedMap)localTreeMap;
  }
  
  private static final Properties toProperties(Map<String, String> paramMap)
  {
    Properties localProperties = new Properties();
    localProperties.putAll(paramMap);
    return localProperties;
  }
  
  public static final <K, V> Map<K, V> toSingletonMap(Map<? extends K, ? extends V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$toSingletonMap");
    paramMap = (Map.Entry)paramMap.entrySet().iterator().next();
    paramMap = Collections.singletonMap(paramMap.getKey(), paramMap.getValue());
    Intrinsics.checkExpressionValueIsNotNull(paramMap, "java.util.Collections.singletonMap(key, value)");
    Intrinsics.checkExpressionValueIsNotNull(paramMap, "with(entries.iterator().…ingletonMap(key, value) }");
    return paramMap;
  }
  
  private static final <K, V> Map<K, V> toSingletonMapOrSelf(Map<K, ? extends V> paramMap)
  {
    return MapsKt.toSingletonMap(paramMap);
  }
  
  public static final <K extends Comparable<? super K>, V> SortedMap<K, V> toSortedMap(Map<? extends K, ? extends V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$toSortedMap");
    return (SortedMap)new TreeMap(paramMap);
  }
  
  public static final <K, V> SortedMap<K, V> toSortedMap(Map<? extends K, ? extends V> paramMap, Comparator<? super K> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$toSortedMap");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    paramComparator = new TreeMap(paramComparator);
    paramComparator.putAll(paramMap);
    return (SortedMap)paramComparator;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\MapsKt__MapsJVMKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */