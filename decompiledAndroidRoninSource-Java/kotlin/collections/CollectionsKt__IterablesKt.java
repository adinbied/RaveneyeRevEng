package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv={1, 0, 3}, d1={"\000:\n\000\n\002\020\034\n\002\b\002\n\002\030\002\n\002\020(\n\000\n\002\020\b\n\002\b\004\n\002\020\036\n\002\b\003\n\002\020 \n\000\n\002\020\013\n\002\b\002\n\002\030\002\n\002\b\002\032+\020\000\032\b\022\004\022\002H\0020\001\"\004\b\000\020\0022\024\b\004\020\003\032\016\022\n\022\b\022\004\022\002H\0020\0050\004H\b\032 \020\006\032\0020\007\"\004\b\000\020\002*\b\022\004\022\002H\0020\0012\006\020\b\032\0020\007H\001\032\037\020\t\032\004\030\0010\007\"\004\b\000\020\002*\b\022\004\022\002H\0020\001H\001¢\006\002\020\n\032\036\020\013\032\b\022\004\022\002H\0020\f\"\004\b\000\020\002*\b\022\004\022\002H\0020\001H\000\032,\020\r\032\b\022\004\022\002H\0020\f\"\004\b\000\020\002*\b\022\004\022\002H\0020\0012\f\020\016\032\b\022\004\022\002H\0020\001H\000\032\"\020\017\032\b\022\004\022\002H\0020\020\"\004\b\000\020\002*\016\022\n\022\b\022\004\022\002H\0020\0010\001\032\035\020\021\032\0020\022\"\004\b\000\020\002*\b\022\004\022\002H\0020\fH\002¢\006\002\b\023\032@\020\024\032\032\022\n\022\b\022\004\022\002H\0020\020\022\n\022\b\022\004\022\002H\0260\0200\025\"\004\b\000\020\002\"\004\b\001\020\026*\024\022\020\022\016\022\004\022\002H\002\022\004\022\002H\0260\0250\001¨\006\027"}, d2={"Iterable", "", "T", "iterator", "Lkotlin/Function0;", "", "collectionSizeOrDefault", "", "default", "collectionSizeOrNull", "(Ljava/lang/Iterable;)Ljava/lang/Integer;", "convertToSetForSetOperation", "", "convertToSetForSetOperationWith", "source", "flatten", "", "safeToConvertToSet", "", "safeToConvertToSet$CollectionsKt__IterablesKt", "unzip", "Lkotlin/Pair;", "R", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/collections/CollectionsKt")
class CollectionsKt__IterablesKt
  extends CollectionsKt__CollectionsKt
{
  private static final <T> Iterable<T> Iterable(Function0<? extends Iterator<? extends T>> paramFunction0)
  {
    (Iterable)new Iterable()
    {
      public Iterator<T> iterator()
      {
        return (Iterator)this.$iterator.invoke();
      }
    };
  }
  
  public static final <T> int collectionSizeOrDefault(Iterable<? extends T> paramIterable, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$collectionSizeOrDefault");
    if ((paramIterable instanceof Collection)) {
      paramInt = ((Collection)paramIterable).size();
    }
    return paramInt;
  }
  
  public static final <T> Integer collectionSizeOrNull(Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$collectionSizeOrNull");
    if ((paramIterable instanceof Collection)) {
      return Integer.valueOf(((Collection)paramIterable).size());
    }
    return null;
  }
  
  public static final <T> Collection<T> convertToSetForSetOperation(Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$convertToSetForSetOperation");
    if ((paramIterable instanceof Set)) {
      return (Collection)paramIterable;
    }
    if ((paramIterable instanceof Collection))
    {
      Collection localCollection = (Collection)paramIterable;
      if (safeToConvertToSet$CollectionsKt__IterablesKt(localCollection)) {
        return (Collection)CollectionsKt.toHashSet(paramIterable);
      }
      return localCollection;
    }
    return (Collection)CollectionsKt.toHashSet(paramIterable);
  }
  
  public static final <T> Collection<T> convertToSetForSetOperationWith(Iterable<? extends T> paramIterable1, Iterable<? extends T> paramIterable2)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable1, "$this$convertToSetForSetOperationWith");
    Intrinsics.checkParameterIsNotNull(paramIterable2, "source");
    if ((paramIterable1 instanceof Set)) {
      return (Collection)paramIterable1;
    }
    if ((paramIterable1 instanceof Collection))
    {
      if (((paramIterable2 instanceof Collection)) && (((Collection)paramIterable2).size() < 2)) {
        return (Collection)paramIterable1;
      }
      paramIterable2 = (Collection)paramIterable1;
      if (safeToConvertToSet$CollectionsKt__IterablesKt(paramIterable2)) {
        return (Collection)CollectionsKt.toHashSet(paramIterable1);
      }
      return paramIterable2;
    }
    return (Collection)CollectionsKt.toHashSet(paramIterable1);
  }
  
  public static final <T> List<T> flatten(Iterable<? extends Iterable<? extends T>> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$flatten");
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Iterable localIterable = (Iterable)paramIterable.next();
      CollectionsKt.addAll((Collection)localArrayList, localIterable);
    }
    return (List)localArrayList;
  }
  
  private static final <T> boolean safeToConvertToSet$CollectionsKt__IterablesKt(Collection<? extends T> paramCollection)
  {
    return (paramCollection.size() > 2) && ((paramCollection instanceof ArrayList));
  }
  
  public static final <T, R> Pair<List<T>, List<R>> unzip(Iterable<? extends Pair<? extends T, ? extends R>> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$unzip");
    int i = CollectionsKt.collectionSizeOrDefault(paramIterable, 10);
    ArrayList localArrayList1 = new ArrayList(i);
    ArrayList localArrayList2 = new ArrayList(i);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Pair localPair = (Pair)paramIterable.next();
      localArrayList1.add(localPair.getFirst());
      localArrayList2.add(localPair.getSecond());
    }
    return TuplesKt.to(localArrayList1, localArrayList2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\CollectionsKt__IterablesKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */