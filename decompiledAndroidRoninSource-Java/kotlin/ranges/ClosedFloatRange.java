package kotlin.ranges;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000,\n\002\030\002\n\002\030\002\n\002\020\007\n\002\b\t\n\002\020\013\n\002\b\003\n\002\020\000\n\000\n\002\020\b\n\002\b\005\n\002\020\016\n\000\b\002\030\0002\b\022\004\022\0020\0020\001B\025\022\006\020\003\032\0020\002\022\006\020\004\032\0020\002¢\006\002\020\005J\021\020\013\032\0020\f2\006\020\r\032\0020\002H\002J\023\020\016\032\0020\f2\b\020\017\032\004\030\0010\020H\002J\b\020\021\032\0020\022H\026J\b\020\023\032\0020\fH\026J\030\020\024\032\0020\f2\006\020\025\032\0020\0022\006\020\026\032\0020\002H\026J\b\020\027\032\0020\030H\026R\016\020\006\032\0020\002X\004¢\006\002\n\000R\016\020\007\032\0020\002X\004¢\006\002\n\000R\024\020\004\032\0020\0028VX\004¢\006\006\032\004\b\b\020\tR\024\020\003\032\0020\0028VX\004¢\006\006\032\004\b\n\020\t¨\006\031"}, d2={"Lkotlin/ranges/ClosedFloatRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "start", "endInclusive", "(FF)V", "_endInclusive", "_start", "getEndInclusive", "()Ljava/lang/Float;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
final class ClosedFloatRange
  implements ClosedFloatingPointRange<Float>
{
  private final float _endInclusive;
  private final float _start;
  
  public ClosedFloatRange(float paramFloat1, float paramFloat2)
  {
    this._start = paramFloat1;
    this._endInclusive = paramFloat2;
  }
  
  public boolean contains(float paramFloat)
  {
    return (paramFloat >= this._start) && (paramFloat <= this._endInclusive);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof ClosedFloatRange)) {
      if ((!isEmpty()) || (!((ClosedFloatRange)paramObject).isEmpty()))
      {
        float f = this._start;
        paramObject = (ClosedFloatRange)paramObject;
        if ((f != ((ClosedFloatRange)paramObject)._start) || (this._endInclusive != ((ClosedFloatRange)paramObject)._endInclusive)) {}
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  public Float getEndInclusive()
  {
    return Float.valueOf(this._endInclusive);
  }
  
  public Float getStart()
  {
    return Float.valueOf(this._start);
  }
  
  public int hashCode()
  {
    if (isEmpty()) {
      return -1;
    }
    return Float.valueOf(this._start).hashCode() * 31 + Float.valueOf(this._endInclusive).hashCode();
  }
  
  public boolean isEmpty()
  {
    return this._start > this._endInclusive;
  }
  
  public boolean lessThanOrEquals(float paramFloat1, float paramFloat2)
  {
    return paramFloat1 <= paramFloat2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this._start);
    localStringBuilder.append("..");
    localStringBuilder.append(this._endInclusive);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\ranges\ClosedFloatRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */