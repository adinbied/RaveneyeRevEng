package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(bv={1, 0, 3}, d1={"\000h\n\000\n\002\020\013\n\002\b\002\n\002\020$\n\000\n\002\030\002\n\002\020&\n\002\b\002\n\002\020\034\n\000\n\002\030\002\n\000\n\002\020\b\n\000\n\002\020 \n\002\b\004\n\002\020\037\n\002\b\003\n\002\020\002\n\002\b\003\n\002\020\000\n\002\b\003\n\002\020\017\n\002\b\003\n\002\030\002\n\002\030\002\n\002\b\007\n\002\030\002\n\000\032G\020\000\032\0020\001\"\004\b\000\020\002\"\004\b\001\020\003*\020\022\006\b\001\022\002H\002\022\004\022\002H\0030\0042\036\020\005\032\032\022\020\022\016\022\004\022\002H\002\022\004\022\002H\0030\007\022\004\022\0020\0010\006H\b\032$\020\b\032\0020\001\"\004\b\000\020\002\"\004\b\001\020\003*\020\022\006\b\001\022\002H\002\022\004\022\002H\0030\004\032G\020\b\032\0020\001\"\004\b\000\020\002\"\004\b\001\020\003*\020\022\006\b\001\022\002H\002\022\004\022\002H\0030\0042\036\020\005\032\032\022\020\022\016\022\004\022\002H\002\022\004\022\002H\0030\007\022\004\022\0020\0010\006H\b\0329\020\t\032\024\022\020\022\016\022\004\022\002H\002\022\004\022\002H\0030\0070\n\"\004\b\000\020\002\"\004\b\001\020\003*\020\022\006\b\001\022\002H\002\022\004\022\002H\0030\004H\b\0326\020\013\032\024\022\020\022\016\022\004\022\002H\002\022\004\022\002H\0030\0070\f\"\004\b\000\020\002\"\004\b\001\020\003*\020\022\006\b\001\022\002H\002\022\004\022\002H\0030\004\032'\020\r\032\0020\016\"\004\b\000\020\002\"\004\b\001\020\003*\020\022\006\b\001\022\002H\002\022\004\022\002H\0030\004H\b\032G\020\r\032\0020\016\"\004\b\000\020\002\"\004\b\001\020\003*\020\022\006\b\001\022\002H\002\022\004\022\002H\0030\0042\036\020\005\032\032\022\020\022\016\022\004\022\002H\002\022\004\022\002H\0030\007\022\004\022\0020\0010\006H\b\032Y\020\017\032\b\022\004\022\002H\0210\020\"\004\b\000\020\002\"\004\b\001\020\003\"\004\b\002\020\021*\020\022\006\b\001\022\002H\002\022\004\022\002H\0030\0042$\020\022\032 \022\020\022\016\022\004\022\002H\002\022\004\022\002H\0030\007\022\n\022\b\022\004\022\002H\0210\n0\006H\b\032r\020\023\032\002H\024\"\004\b\000\020\002\"\004\b\001\020\003\"\004\b\002\020\021\"\020\b\003\020\024*\n\022\006\b\000\022\002H\0210\025*\020\022\006\b\001\022\002H\002\022\004\022\002H\0030\0042\006\020\026\032\002H\0242$\020\022\032 \022\020\022\016\022\004\022\002H\002\022\004\022\002H\0030\007\022\n\022\b\022\004\022\002H\0210\n0\006H\b¢\006\002\020\027\032G\020\030\032\0020\031\"\004\b\000\020\002\"\004\b\001\020\003*\020\022\006\b\001\022\002H\002\022\004\022\002H\0030\0042\036\020\032\032\032\022\020\022\016\022\004\022\002H\002\022\004\022\002H\0030\007\022\004\022\0020\0310\006H\b\032S\020\033\032\b\022\004\022\002H\0210\020\"\004\b\000\020\002\"\004\b\001\020\003\"\004\b\002\020\021*\020\022\006\b\001\022\002H\002\022\004\022\002H\0030\0042\036\020\022\032\032\022\020\022\016\022\004\022\002H\002\022\004\022\002H\0030\007\022\004\022\002H\0210\006H\b\032Y\020\034\032\b\022\004\022\002H\0210\020\"\004\b\000\020\002\"\004\b\001\020\003\"\b\b\002\020\021*\0020\035*\020\022\006\b\001\022\002H\002\022\004\022\002H\0030\0042 \020\022\032\034\022\020\022\016\022\004\022\002H\002\022\004\022\002H\0030\007\022\006\022\004\030\001H\0210\006H\b\032r\020\036\032\002H\024\"\004\b\000\020\002\"\004\b\001\020\003\"\b\b\002\020\021*\0020\035\"\020\b\003\020\024*\n\022\006\b\000\022\002H\0210\025*\020\022\006\b\001\022\002H\002\022\004\022\002H\0030\0042\006\020\026\032\002H\0242 \020\022\032\034\022\020\022\016\022\004\022\002H\002\022\004\022\002H\0030\007\022\006\022\004\030\001H\0210\006H\b¢\006\002\020\027\032l\020\037\032\002H\024\"\004\b\000\020\002\"\004\b\001\020\003\"\004\b\002\020\021\"\020\b\003\020\024*\n\022\006\b\000\022\002H\0210\025*\020\022\006\b\001\022\002H\002\022\004\022\002H\0030\0042\006\020\026\032\002H\0242\036\020\022\032\032\022\020\022\016\022\004\022\002H\002\022\004\022\002H\0030\007\022\004\022\002H\0210\006H\b¢\006\002\020\027\032e\020 \032\020\022\004\022\002H\002\022\004\022\002H\003\030\0010\007\"\004\b\000\020\002\"\004\b\001\020\003\"\016\b\002\020\021*\b\022\004\022\002H\0210!*\020\022\006\b\001\022\002H\002\022\004\022\002H\0030\0042\036\020\"\032\032\022\020\022\016\022\004\022\002H\002\022\004\022\002H\0030\007\022\004\022\002H\0210\006H\b\032i\020#\032\020\022\004\022\002H\002\022\004\022\002H\003\030\0010\007\"\004\b\000\020\002\"\004\b\001\020\003*\020\022\006\b\001\022\002H\002\022\004\022\002H\0030\00422\020$\032.\022\022\b\000\022\016\022\004\022\002H\002\022\004\022\002H\0030\0070%j\026\022\022\b\000\022\016\022\004\022\002H\002\022\004\022\002H\0030\007`&H\b\032e\020'\032\020\022\004\022\002H\002\022\004\022\002H\003\030\0010\007\"\004\b\000\020\002\"\004\b\001\020\003\"\016\b\002\020\021*\b\022\004\022\002H\0210!*\020\022\006\b\001\022\002H\002\022\004\022\002H\0030\0042\036\020\"\032\032\022\020\022\016\022\004\022\002H\002\022\004\022\002H\0030\007\022\004\022\002H\0210\006H\b\032f\020(\032\020\022\004\022\002H\002\022\004\022\002H\003\030\0010\007\"\004\b\000\020\002\"\004\b\001\020\003*\020\022\006\b\001\022\002H\002\022\004\022\002H\0030\00422\020$\032.\022\022\b\000\022\016\022\004\022\002H\002\022\004\022\002H\0030\0070%j\026\022\022\b\000\022\016\022\004\022\002H\002\022\004\022\002H\0030\007`&\032$\020)\032\0020\001\"\004\b\000\020\002\"\004\b\001\020\003*\020\022\006\b\001\022\002H\002\022\004\022\002H\0030\004\032G\020)\032\0020\001\"\004\b\000\020\002\"\004\b\001\020\003*\020\022\006\b\001\022\002H\002\022\004\022\002H\0030\0042\036\020\005\032\032\022\020\022\016\022\004\022\002H\002\022\004\022\002H\0030\007\022\004\022\0020\0010\006H\b\032V\020*\032\002H+\"\004\b\000\020\002\"\004\b\001\020\003\"\026\b\002\020+*\020\022\006\b\001\022\002H\002\022\004\022\002H\0030\004*\002H+2\036\020\032\032\032\022\020\022\016\022\004\022\002H\002\022\004\022\002H\0030\007\022\004\022\0020\0310\006H\b¢\006\002\020,\0326\020-\032\024\022\020\022\016\022\004\022\002H\002\022\004\022\002H\0030.0\020\"\004\b\000\020\002\"\004\b\001\020\003*\020\022\006\b\001\022\002H\002\022\004\022\002H\0030\004¨\006/"}, d2={"all", "", "K", "V", "", "predicate", "Lkotlin/Function1;", "", "any", "asIterable", "", "asSequence", "Lkotlin/sequences/Sequence;", "count", "", "flatMap", "", "R", "transform", "flatMapTo", "C", "", "destination", "(Ljava/util/Map;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "forEach", "", "action", "map", "mapNotNull", "", "mapNotNullTo", "mapTo", "maxBy", "", "selector", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "minBy", "minWith", "none", "onEach", "M", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "toList", "Lkotlin/Pair;", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/collections/MapsKt")
class MapsKt___MapsKt
  extends MapsKt__MapsKt
{
  public static final <K, V> boolean all(Map<? extends K, ? extends V> paramMap, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$all");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    if (paramMap.isEmpty()) {
      return true;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext()) {
      if (!((Boolean)paramFunction1.invoke((Map.Entry)paramMap.next())).booleanValue()) {
        return false;
      }
    }
    return true;
  }
  
  public static final <K, V> boolean any(Map<? extends K, ? extends V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$any");
    return paramMap.isEmpty() ^ true;
  }
  
  public static final <K, V> boolean any(Map<? extends K, ? extends V> paramMap, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$any");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    if (paramMap.isEmpty()) {
      return false;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext()) {
      if (((Boolean)paramFunction1.invoke((Map.Entry)paramMap.next())).booleanValue()) {
        return true;
      }
    }
    return false;
  }
  
  private static final <K, V> Iterable<Map.Entry<K, V>> asIterable(Map<? extends K, ? extends V> paramMap)
  {
    return (Iterable)paramMap.entrySet();
  }
  
  public static final <K, V> Sequence<Map.Entry<K, V>> asSequence(Map<? extends K, ? extends V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$asSequence");
    return CollectionsKt.asSequence((Iterable)paramMap.entrySet());
  }
  
  private static final <K, V> int count(Map<? extends K, ? extends V> paramMap)
  {
    return paramMap.size();
  }
  
  public static final <K, V> int count(Map<? extends K, ? extends V> paramMap, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$count");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    boolean bool = paramMap.isEmpty();
    int i = 0;
    if (bool) {
      return 0;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext()) {
      if (((Boolean)paramFunction1.invoke((Map.Entry)paramMap.next())).booleanValue()) {
        i += 1;
      }
    }
    return i;
  }
  
  public static final <K, V, R> List<R> flatMap(Map<? extends K, ? extends V> paramMap, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$flatMap");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext()) {
      CollectionsKt.addAll(localCollection, (Iterable)paramFunction1.invoke((Map.Entry)paramMap.next()));
    }
    return (List)localCollection;
  }
  
  public static final <K, V, R, C extends Collection<? super R>> C flatMapTo(Map<? extends K, ? extends V> paramMap, C paramC, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$flatMapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext()) {
      CollectionsKt.addAll(paramC, (Iterable)paramFunction1.invoke((Map.Entry)paramMap.next()));
    }
    return paramC;
  }
  
  public static final <K, V> void forEach(Map<? extends K, ? extends V> paramMap, Function1<? super Map.Entry<? extends K, ? extends V>, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$forEach");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext()) {
      paramFunction1.invoke((Map.Entry)paramMap.next());
    }
  }
  
  public static final <K, V, R> List<R> map(Map<? extends K, ? extends V> paramMap, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$map");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext()) {
      localCollection.add(paramFunction1.invoke((Map.Entry)paramMap.next()));
    }
    return (List)localCollection;
  }
  
  public static final <K, V, R> List<R> mapNotNull(Map<? extends K, ? extends V> paramMap, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$mapNotNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = paramFunction1.invoke((Map.Entry)paramMap.next());
      if (localObject != null) {
        localCollection.add(localObject);
      }
    }
    return (List)localCollection;
  }
  
  public static final <K, V, R, C extends Collection<? super R>> C mapNotNullTo(Map<? extends K, ? extends V> paramMap, C paramC, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$mapNotNullTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = paramFunction1.invoke((Map.Entry)paramMap.next());
      if (localObject != null) {
        paramC.add(localObject);
      }
    }
    return paramC;
  }
  
  public static final <K, V, R, C extends Collection<? super R>> C mapTo(Map<? extends K, ? extends V> paramMap, C paramC, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$mapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext()) {
      paramC.add(paramFunction1.invoke((Map.Entry)paramMap.next()));
    }
    return paramC;
  }
  
  private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> maxBy(Map<? extends K, ? extends V> paramMap, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> paramFunction1)
  {
    Iterator localIterator = ((Iterable)paramMap.entrySet()).iterator();
    if (!localIterator.hasNext())
    {
      paramMap = null;
    }
    else
    {
      paramMap = localIterator.next();
      if (localIterator.hasNext()) {
        for (;;)
        {
          Object localObject1 = (Comparable)paramFunction1.invoke(paramMap);
          Map<? extends K, ? extends V> localMap = paramMap;
          do
          {
            Object localObject3 = localIterator.next();
            Comparable localComparable = (Comparable)paramFunction1.invoke(localObject3);
            paramMap = localMap;
            Object localObject2 = localObject1;
            if (((Comparable)localObject1).compareTo(localComparable) < 0)
            {
              paramMap = (Map<? extends K, ? extends V>)localObject3;
              localObject2 = localComparable;
            }
            localMap = paramMap;
            localObject1 = localObject2;
          } while (localIterator.hasNext());
        }
      }
    }
    return (Map.Entry)paramMap;
  }
  
  private static final <K, V> Map.Entry<K, V> maxWith(Map<? extends K, ? extends V> paramMap, Comparator<? super Map.Entry<? extends K, ? extends V>> paramComparator)
  {
    return (Map.Entry)CollectionsKt.maxWith((Iterable)paramMap.entrySet(), paramComparator);
  }
  
  public static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> minBy(Map<? extends K, ? extends V> paramMap, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$minBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    Iterator localIterator = ((Iterable)paramMap.entrySet()).iterator();
    if (!localIterator.hasNext())
    {
      paramMap = null;
    }
    else
    {
      paramMap = localIterator.next();
      if (localIterator.hasNext()) {
        for (;;)
        {
          Object localObject1 = (Comparable)paramFunction1.invoke(paramMap);
          Map<? extends K, ? extends V> localMap = paramMap;
          do
          {
            Object localObject3 = localIterator.next();
            Comparable localComparable = (Comparable)paramFunction1.invoke(localObject3);
            paramMap = localMap;
            Object localObject2 = localObject1;
            if (((Comparable)localObject1).compareTo(localComparable) > 0)
            {
              paramMap = (Map<? extends K, ? extends V>)localObject3;
              localObject2 = localComparable;
            }
            localMap = paramMap;
            localObject1 = localObject2;
          } while (localIterator.hasNext());
        }
      }
    }
    return (Map.Entry)paramMap;
  }
  
  public static final <K, V> Map.Entry<K, V> minWith(Map<? extends K, ? extends V> paramMap, Comparator<? super Map.Entry<? extends K, ? extends V>> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$minWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    return (Map.Entry)CollectionsKt.minWith((Iterable)paramMap.entrySet(), paramComparator);
  }
  
  public static final <K, V> boolean none(Map<? extends K, ? extends V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$none");
    return paramMap.isEmpty();
  }
  
  public static final <K, V> boolean none(Map<? extends K, ? extends V> paramMap, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$none");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    if (paramMap.isEmpty()) {
      return true;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext()) {
      if (((Boolean)paramFunction1.invoke((Map.Entry)paramMap.next())).booleanValue()) {
        return false;
      }
    }
    return true;
  }
  
  public static final <K, V, M extends Map<? extends K, ? extends V>> M onEach(M paramM, Function1<? super Map.Entry<? extends K, ? extends V>, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramM, "$this$onEach");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    Iterator localIterator = paramM.entrySet().iterator();
    while (localIterator.hasNext()) {
      paramFunction1.invoke((Map.Entry)localIterator.next());
    }
    return paramM;
  }
  
  public static final <K, V> List<Pair<K, V>> toList(Map<? extends K, ? extends V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$toList");
    if (paramMap.size() == 0) {
      return CollectionsKt.emptyList();
    }
    Iterator localIterator = paramMap.entrySet().iterator();
    if (!localIterator.hasNext()) {
      return CollectionsKt.emptyList();
    }
    Map.Entry localEntry = (Map.Entry)localIterator.next();
    if (!localIterator.hasNext()) {
      return CollectionsKt.listOf(new Pair(localEntry.getKey(), localEntry.getValue()));
    }
    paramMap = new ArrayList(paramMap.size());
    paramMap.add(new Pair(localEntry.getKey(), localEntry.getValue()));
    do
    {
      localEntry = (Map.Entry)localIterator.next();
      paramMap.add(new Pair(localEntry.getKey(), localEntry.getValue()));
    } while (localIterator.hasNext());
    return (List)paramMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\MapsKt___MapsKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */