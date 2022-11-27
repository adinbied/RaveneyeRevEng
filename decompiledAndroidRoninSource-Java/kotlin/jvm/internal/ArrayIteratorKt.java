package kotlin.jvm.internal;

import java.util.Iterator;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\022\n\000\n\002\020(\n\002\b\002\n\002\020\021\n\002\b\002\032%\020\000\032\b\022\004\022\002H\0020\001\"\004\b\000\020\0022\f\020\003\032\b\022\004\022\002H\0020\004¢\006\002\020\005¨\006\006"}, d2={"iterator", "", "T", "array", "", "([Ljava/lang/Object;)Ljava/util/Iterator;", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class ArrayIteratorKt
{
  public static final <T> Iterator<T> iterator(T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "array");
    return (Iterator)new ArrayIterator(paramArrayOfT);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\jvm\internal\ArrayIteratorKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */