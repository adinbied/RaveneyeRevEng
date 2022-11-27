package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000*\n\002\030\002\n\000\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\r\n\002\020\013\n\002\b\002\n\002\020\b\n\000\n\002\020\016\n\000\b\b\030\000*\004\b\000\020\0012\0020\002B\030\022\006\020\003\032\0028\000\022\006\020\004\032\0020\005ø\001\000¢\006\002\020\006J\016\020\r\032\0028\000HÆ\003¢\006\002\020\013J\021\020\016\032\0020\005HÆ\003ø\001\000¢\006\002\020\bJ-\020\017\032\b\022\004\022\0028\0000\0002\b\b\002\020\003\032\0028\0002\b\b\002\020\004\032\0020\005HÆ\001ø\001\000¢\006\004\b\020\020\021J\023\020\022\032\0020\0232\b\020\024\032\004\030\0010\002HÖ\003J\t\020\025\032\0020\026HÖ\001J\t\020\027\032\0020\030HÖ\001R\026\020\004\032\0020\005ø\001\000¢\006\n\n\002\020\t\032\004\b\007\020\bR\023\020\003\032\0028\000¢\006\n\n\002\020\f\032\004\b\n\020\013\002\004\n\002\b\031¨\006\031"}, d2={"Lkotlin/time/TimedValue;", "T", "", "value", "duration", "Lkotlin/time/Duration;", "(Ljava/lang/Object;DLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDuration", "()D", "D", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "copy-RFiDyg4", "(Ljava/lang/Object;D)Lkotlin/time/TimedValue;", "equals", "", "other", "hashCode", "", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class TimedValue<T>
{
  private final double duration;
  private final T value;
  
  private TimedValue(T paramT, double paramDouble)
  {
    this.value = paramT;
    this.duration = paramDouble;
  }
  
  public final T component1()
  {
    return (T)this.value;
  }
  
  public final double component2()
  {
    return this.duration;
  }
  
  public final TimedValue<T> copy-RFiDyg4(T paramT, double paramDouble)
  {
    return new TimedValue(paramT, paramDouble);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof TimedValue))
      {
        paramObject = (TimedValue)paramObject;
        if ((Intrinsics.areEqual(this.value, ((TimedValue)paramObject).value)) && (Double.compare(this.duration, ((TimedValue)paramObject).duration) == 0)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final double getDuration()
  {
    return this.duration;
  }
  
  public final T getValue()
  {
    return (T)this.value;
  }
  
  public int hashCode()
  {
    Object localObject = this.value;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    long l = Double.doubleToLongBits(this.duration);
    return i * 31 + (int)(l ^ l >>> 32);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TimedValue(value=");
    localStringBuilder.append(this.value);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(Duration.toString-impl(this.duration));
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\time\TimedValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */