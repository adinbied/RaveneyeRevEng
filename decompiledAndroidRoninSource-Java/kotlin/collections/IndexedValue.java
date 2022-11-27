package kotlin.collections;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\"\n\002\030\002\n\000\n\002\020\000\n\000\n\002\020\b\n\002\b\f\n\002\020\013\n\002\b\003\n\002\020\016\n\000\b\b\030\000*\006\b\000\020\001 \0012\0020\002B\025\022\006\020\003\032\0020\004\022\006\020\005\032\0028\000¢\006\002\020\006J\t\020\f\032\0020\004HÆ\003J\016\020\r\032\0028\000HÆ\003¢\006\002\020\nJ(\020\016\032\b\022\004\022\0028\0000\0002\b\b\002\020\003\032\0020\0042\b\b\002\020\005\032\0028\000HÆ\001¢\006\002\020\017J\023\020\020\032\0020\0212\b\020\022\032\004\030\0010\002HÖ\003J\t\020\023\032\0020\004HÖ\001J\t\020\024\032\0020\025HÖ\001R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\007\020\bR\023\020\005\032\0028\000¢\006\n\n\002\020\013\032\004\b\t\020\n¨\006\026"}, d2={"Lkotlin/collections/IndexedValue;", "T", "", "index", "", "value", "(ILjava/lang/Object;)V", "getIndex", "()I", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(ILjava/lang/Object;)Lkotlin/collections/IndexedValue;", "equals", "", "other", "hashCode", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class IndexedValue<T>
{
  private final int index;
  private final T value;
  
  public IndexedValue(int paramInt, T paramT)
  {
    this.index = paramInt;
    this.value = paramT;
  }
  
  public final int component1()
  {
    return this.index;
  }
  
  public final T component2()
  {
    return (T)this.value;
  }
  
  public final IndexedValue<T> copy(int paramInt, T paramT)
  {
    return new IndexedValue(paramInt, paramT);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof IndexedValue))
      {
        paramObject = (IndexedValue)paramObject;
        int i;
        if (this.index == ((IndexedValue)paramObject).index) {
          i = 1;
        } else {
          i = 0;
        }
        if ((i != 0) && (Intrinsics.areEqual(this.value, ((IndexedValue)paramObject).value))) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  public final int getIndex()
  {
    return this.index;
  }
  
  public final T getValue()
  {
    return (T)this.value;
  }
  
  public int hashCode()
  {
    int j = this.index;
    Object localObject = this.value;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IndexedValue(index=");
    localStringBuilder.append(this.index);
    localStringBuilder.append(", value=");
    localStringBuilder.append(this.value);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\IndexedValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */