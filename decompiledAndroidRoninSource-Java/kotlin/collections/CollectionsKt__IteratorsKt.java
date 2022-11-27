package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\034\n\000\n\002\020\002\n\000\n\002\020(\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\032-\020\000\032\0020\001\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\022\020\004\032\016\022\004\022\002H\002\022\004\022\0020\0010\005H\b\032\037\020\006\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\003H\n\032\"\020\007\032\016\022\n\022\b\022\004\022\002H\0020\b0\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\003¨\006\t"}, d2={"forEach", "", "T", "", "operation", "Lkotlin/Function1;", "iterator", "withIndex", "Lkotlin/collections/IndexedValue;", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/collections/CollectionsKt")
class CollectionsKt__IteratorsKt
  extends CollectionsKt__IteratorsJVMKt
{
  public static final <T> void forEach(Iterator<? extends T> paramIterator, Function1<? super T, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterator, "$this$forEach");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "operation");
    while (paramIterator.hasNext()) {
      paramFunction1.invoke(paramIterator.next());
    }
  }
  
  private static final <T> Iterator<T> iterator(Iterator<? extends T> paramIterator)
  {
    Intrinsics.checkParameterIsNotNull(paramIterator, "$this$iterator");
    return paramIterator;
  }
  
  public static final <T> Iterator<IndexedValue<T>> withIndex(Iterator<? extends T> paramIterator)
  {
    Intrinsics.checkParameterIsNotNull(paramIterator, "$this$withIndex");
    return (Iterator)new IndexingIterator(paramIterator);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\CollectionsKt__IteratorsKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */