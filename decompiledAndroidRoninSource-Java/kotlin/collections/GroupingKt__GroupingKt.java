package kotlin.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000@\n\000\n\002\020$\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\004\n\002\020\013\n\002\b\003\n\002\020%\n\002\b\003\n\002\020\b\n\002\b\003\n\002\030\002\n\002\030\002\n\002\b\n\032\001\020\000\032\016\022\004\022\002H\002\022\004\022\002H\0030\001\"\004\b\000\020\004\"\004\b\001\020\002\"\004\b\002\020\003*\016\022\004\022\002H\004\022\004\022\002H\0020\0052b\020\006\032^\022\023\022\021H\002¢\006\f\b\b\022\b\b\t\022\004\b\b(\n\022\025\022\023\030\001H\003¢\006\f\b\b\022\b\b\t\022\004\b\b(\013\022\023\022\021H\004¢\006\f\b\b\022\b\b\t\022\004\b\b(\f\022\023\022\0210\r¢\006\f\b\b\022\b\b\t\022\004\b\b(\016\022\004\022\002H\0030\007H\b\032´\001\020\017\032\002H\020\"\004\b\000\020\004\"\004\b\001\020\002\"\004\b\002\020\003\"\026\b\003\020\020*\020\022\006\b\000\022\002H\002\022\004\022\002H\0030\021*\016\022\004\022\002H\004\022\004\022\002H\0020\0052\006\020\022\032\002H\0202b\020\006\032^\022\023\022\021H\002¢\006\f\b\b\022\b\b\t\022\004\b\b(\n\022\025\022\023\030\001H\003¢\006\f\b\b\022\b\b\t\022\004\b\b(\013\022\023\022\021H\004¢\006\f\b\b\022\b\b\t\022\004\b\b(\f\022\023\022\0210\r¢\006\f\b\b\022\b\b\t\022\004\b\b(\016\022\004\022\002H\0030\007H\b¢\006\002\020\023\032I\020\024\032\002H\020\"\004\b\000\020\004\"\004\b\001\020\002\"\026\b\002\020\020*\020\022\006\b\000\022\002H\002\022\004\022\0020\0250\021*\016\022\004\022\002H\004\022\004\022\002H\0020\0052\006\020\022\032\002H\020H\007¢\006\002\020\026\032¼\001\020\027\032\016\022\004\022\002H\002\022\004\022\002H\0030\001\"\004\b\000\020\004\"\004\b\001\020\002\"\004\b\002\020\003*\016\022\004\022\002H\004\022\004\022\002H\0020\00526\020\030\0322\022\023\022\021H\002¢\006\f\b\b\022\b\b\t\022\004\b\b(\n\022\023\022\021H\004¢\006\f\b\b\022\b\b\t\022\004\b\b(\f\022\004\022\002H\0030\0312K\020\006\032G\022\023\022\021H\002¢\006\f\b\b\022\b\b\t\022\004\b\b(\n\022\023\022\021H\003¢\006\f\b\b\022\b\b\t\022\004\b\b(\013\022\023\022\021H\004¢\006\f\b\b\022\b\b\t\022\004\b\b(\f\022\004\022\002H\0030\032H\b\032|\020\027\032\016\022\004\022\002H\002\022\004\022\002H\0030\001\"\004\b\000\020\004\"\004\b\001\020\002\"\004\b\002\020\003*\016\022\004\022\002H\004\022\004\022\002H\0020\0052\006\020\033\032\002H\00326\020\006\0322\022\023\022\021H\003¢\006\f\b\b\022\b\b\t\022\004\b\b(\013\022\023\022\021H\004¢\006\f\b\b\022\b\b\t\022\004\b\b(\f\022\004\022\002H\0030\031H\b¢\006\002\020\034\032Õ\001\020\035\032\002H\020\"\004\b\000\020\004\"\004\b\001\020\002\"\004\b\002\020\003\"\026\b\003\020\020*\020\022\006\b\000\022\002H\002\022\004\022\002H\0030\021*\016\022\004\022\002H\004\022\004\022\002H\0020\0052\006\020\022\032\002H\02026\020\030\0322\022\023\022\021H\002¢\006\f\b\b\022\b\b\t\022\004\b\b(\n\022\023\022\021H\004¢\006\f\b\b\022\b\b\t\022\004\b\b(\f\022\004\022\002H\0030\0312K\020\006\032G\022\023\022\021H\002¢\006\f\b\b\022\b\b\t\022\004\b\b(\n\022\023\022\021H\003¢\006\f\b\b\022\b\b\t\022\004\b\b(\013\022\023\022\021H\004¢\006\f\b\b\022\b\b\t\022\004\b\b(\f\022\004\022\002H\0030\032H\b¢\006\002\020\036\032\001\020\035\032\002H\020\"\004\b\000\020\004\"\004\b\001\020\002\"\004\b\002\020\003\"\026\b\003\020\020*\020\022\006\b\000\022\002H\002\022\004\022\002H\0030\021*\016\022\004\022\002H\004\022\004\022\002H\0020\0052\006\020\022\032\002H\0202\006\020\033\032\002H\00326\020\006\0322\022\023\022\021H\003¢\006\f\b\b\022\b\b\t\022\004\b\b(\013\022\023\022\021H\004¢\006\f\b\b\022\b\b\t\022\004\b\b(\f\022\004\022\002H\0030\031H\b¢\006\002\020\037\032\001\020 \032\016\022\004\022\002H\002\022\004\022\002H!0\001\"\004\b\000\020!\"\b\b\001\020\004*\002H!\"\004\b\002\020\002*\016\022\004\022\002H\004\022\004\022\002H\0020\0052K\020\006\032G\022\023\022\021H\002¢\006\f\b\b\022\b\b\t\022\004\b\b(\n\022\023\022\021H!¢\006\f\b\b\022\b\b\t\022\004\b\b(\013\022\023\022\021H\004¢\006\f\b\b\022\b\b\t\022\004\b\b(\f\022\004\022\002H!0\032H\b\032¡\001\020\"\032\002H\020\"\004\b\000\020!\"\b\b\001\020\004*\002H!\"\004\b\002\020\002\"\026\b\003\020\020*\020\022\006\b\000\022\002H\002\022\004\022\002H!0\021*\016\022\004\022\002H\004\022\004\022\002H\0020\0052\006\020\022\032\002H\0202K\020\006\032G\022\023\022\021H\002¢\006\f\b\b\022\b\b\t\022\004\b\b(\n\022\023\022\021H!¢\006\f\b\b\022\b\b\t\022\004\b\b(\013\022\023\022\021H\004¢\006\f\b\b\022\b\b\t\022\004\b\b(\f\022\004\022\002H!0\032H\b¢\006\002\020#¨\006$"}, d2={"aggregate", "", "K", "R", "T", "Lkotlin/collections/Grouping;", "operation", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "key", "accumulator", "element", "", "first", "aggregateTo", "M", "", "destination", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function4;)Ljava/util/Map;", "eachCountTo", "", "(Lkotlin/collections/Grouping;Ljava/util/Map;)Ljava/util/Map;", "fold", "initialValueSelector", "Lkotlin/Function2;", "Lkotlin/Function3;", "initialValue", "(Lkotlin/collections/Grouping;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "foldTo", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "(Lkotlin/collections/Grouping;Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "reduce", "S", "reduceTo", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/collections/GroupingKt")
class GroupingKt__GroupingKt
  extends GroupingKt__GroupingJVMKt
{
  public static final <T, K, R> Map<K, R> aggregate(Grouping<T, ? extends K> paramGrouping, Function4<? super K, ? super R, ? super T, ? super Boolean, ? extends R> paramFunction4)
  {
    Intrinsics.checkParameterIsNotNull(paramGrouping, "$this$aggregate");
    Intrinsics.checkParameterIsNotNull(paramFunction4, "operation");
    Map localMap = (Map)new LinkedHashMap();
    Iterator localIterator = paramGrouping.sourceIterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = paramGrouping.keyOf(localObject1);
      Object localObject3 = localMap.get(localObject2);
      boolean bool;
      if ((localObject3 == null) && (!localMap.containsKey(localObject2))) {
        bool = true;
      } else {
        bool = false;
      }
      localMap.put(localObject2, paramFunction4.invoke(localObject2, localObject3, localObject1, Boolean.valueOf(bool)));
    }
    return localMap;
  }
  
  public static final <T, K, R, M extends Map<? super K, R>> M aggregateTo(Grouping<T, ? extends K> paramGrouping, M paramM, Function4<? super K, ? super R, ? super T, ? super Boolean, ? extends R> paramFunction4)
  {
    Intrinsics.checkParameterIsNotNull(paramGrouping, "$this$aggregateTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction4, "operation");
    Iterator localIterator = paramGrouping.sourceIterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = paramGrouping.keyOf(localObject1);
      Object localObject3 = paramM.get(localObject2);
      boolean bool;
      if ((localObject3 == null) && (!paramM.containsKey(localObject2))) {
        bool = true;
      } else {
        bool = false;
      }
      paramM.put(localObject2, paramFunction4.invoke(localObject2, localObject3, localObject1, Boolean.valueOf(bool)));
    }
    return paramM;
  }
  
  public static final <T, K, M extends Map<? super K, Integer>> M eachCountTo(Grouping<T, ? extends K> paramGrouping, M paramM)
  {
    Intrinsics.checkParameterIsNotNull(paramGrouping, "$this$eachCountTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Iterator localIterator = paramGrouping.sourceIterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = paramGrouping.keyOf(localIterator.next());
      Object localObject1 = paramM.get(localObject2);
      int i;
      if ((localObject1 == null) && (!paramM.containsKey(localObject2))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        localObject1 = Integer.valueOf(0);
      }
      paramM.put(localObject2, Integer.valueOf(((Number)localObject1).intValue() + 1));
    }
    return paramM;
  }
  
  public static final <T, K, R> Map<K, R> fold(Grouping<T, ? extends K> paramGrouping, R paramR, Function2<? super R, ? super T, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramGrouping, "$this$fold");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    Map localMap = (Map)new LinkedHashMap();
    Iterator localIterator = paramGrouping.sourceIterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      Object localObject3 = paramGrouping.keyOf(localObject2);
      Object localObject1 = localMap.get(localObject3);
      int i;
      if ((localObject1 == null) && (!localMap.containsKey(localObject3))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        localObject1 = paramR;
      }
      localMap.put(localObject3, paramFunction2.invoke(localObject1, localObject2));
    }
    return localMap;
  }
  
  public static final <T, K, R> Map<K, R> fold(Grouping<T, ? extends K> paramGrouping, Function2<? super K, ? super T, ? extends R> paramFunction2, Function3<? super K, ? super R, ? super T, ? extends R> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramGrouping, "$this$fold");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "initialValueSelector");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    Map localMap = (Map)new LinkedHashMap();
    Iterator localIterator = paramGrouping.sourceIterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      Object localObject3 = paramGrouping.keyOf(localObject2);
      Object localObject1 = localMap.get(localObject3);
      int i;
      if ((localObject1 == null) && (!localMap.containsKey(localObject3))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        localObject1 = paramFunction2.invoke(localObject3, localObject2);
      }
      localMap.put(localObject3, paramFunction3.invoke(localObject3, localObject1, localObject2));
    }
    return localMap;
  }
  
  public static final <T, K, R, M extends Map<? super K, R>> M foldTo(Grouping<T, ? extends K> paramGrouping, M paramM, R paramR, Function2<? super R, ? super T, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramGrouping, "$this$foldTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    Iterator localIterator = paramGrouping.sourceIterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      Object localObject3 = paramGrouping.keyOf(localObject2);
      Object localObject1 = paramM.get(localObject3);
      int i;
      if ((localObject1 == null) && (!paramM.containsKey(localObject3))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        localObject1 = paramR;
      }
      paramM.put(localObject3, paramFunction2.invoke(localObject1, localObject2));
    }
    return paramM;
  }
  
  public static final <T, K, R, M extends Map<? super K, R>> M foldTo(Grouping<T, ? extends K> paramGrouping, M paramM, Function2<? super K, ? super T, ? extends R> paramFunction2, Function3<? super K, ? super R, ? super T, ? extends R> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramGrouping, "$this$foldTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "initialValueSelector");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    Iterator localIterator = paramGrouping.sourceIterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      Object localObject3 = paramGrouping.keyOf(localObject2);
      Object localObject1 = paramM.get(localObject3);
      int i;
      if ((localObject1 == null) && (!paramM.containsKey(localObject3))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        localObject1 = paramFunction2.invoke(localObject3, localObject2);
      }
      paramM.put(localObject3, paramFunction3.invoke(localObject3, localObject1, localObject2));
    }
    return paramM;
  }
  
  public static final <S, T extends S, K> Map<K, S> reduce(Grouping<T, ? extends K> paramGrouping, Function3<? super K, ? super S, ? super T, ? extends S> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramGrouping, "$this$reduce");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    Map localMap = (Map)new LinkedHashMap();
    Iterator localIterator = paramGrouping.sourceIterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = paramGrouping.keyOf(localObject1);
      Object localObject3 = localMap.get(localObject2);
      int i;
      if ((localObject3 == null) && (!localMap.containsKey(localObject2))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        localObject1 = paramFunction3.invoke(localObject2, localObject3, localObject1);
      }
      localMap.put(localObject2, localObject1);
    }
    return localMap;
  }
  
  public static final <S, T extends S, K, M extends Map<? super K, S>> M reduceTo(Grouping<T, ? extends K> paramGrouping, M paramM, Function3<? super K, ? super S, ? super T, ? extends S> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramGrouping, "$this$reduceTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    Iterator localIterator = paramGrouping.sourceIterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = paramGrouping.keyOf(localObject1);
      Object localObject3 = paramM.get(localObject2);
      int i;
      if ((localObject3 == null) && (!paramM.containsKey(localObject2))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        localObject1 = paramFunction3.invoke(localObject2, localObject3, localObject1);
      }
      paramM.put(localObject2, localObject1);
    }
    return paramM;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\GroupingKt__GroupingKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */