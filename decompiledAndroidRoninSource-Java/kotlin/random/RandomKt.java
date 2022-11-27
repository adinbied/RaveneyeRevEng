package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;

@Metadata(bv={1, 0, 3}, d1={"\000:\n\000\n\002\030\002\n\000\n\002\020\b\n\002\020\t\n\000\n\002\020\016\n\000\n\002\020\000\n\002\b\002\n\002\020\002\n\002\020\006\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\002\b\003\032\020\020\000\032\0020\0012\006\020\002\032\0020\003H\007\032\020\020\000\032\0020\0012\006\020\002\032\0020\004H\007\032\030\020\005\032\0020\0062\006\020\007\032\0020\b2\006\020\t\032\0020\bH\000\032\030\020\n\032\0020\0132\006\020\007\032\0020\f2\006\020\t\032\0020\fH\000\032\030\020\n\032\0020\0132\006\020\007\032\0020\0032\006\020\t\032\0020\003H\000\032\030\020\n\032\0020\0132\006\020\007\032\0020\0042\006\020\t\032\0020\004H\000\032\020\020\r\032\0020\0032\006\020\016\032\0020\003H\000\032\024\020\017\032\0020\003*\0020\0012\006\020\020\032\0020\021H\007\032\024\020\022\032\0020\004*\0020\0012\006\020\020\032\0020\023H\007\032\024\020\024\032\0020\003*\0020\0032\006\020\025\032\0020\003H\000¨\006\026"}, d2={"Random", "Lkotlin/random/Random;", "seed", "", "", "boundsErrorMessage", "", "from", "", "until", "checkRangeBounds", "", "", "fastLog2", "value", "nextInt", "range", "Lkotlin/ranges/IntRange;", "nextLong", "Lkotlin/ranges/LongRange;", "takeUpperBits", "bitCount", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class RandomKt
{
  public static final Random Random(int paramInt)
  {
    return (Random)new XorWowRandom(paramInt, paramInt >> 31);
  }
  
  public static final Random Random(long paramLong)
  {
    return (Random)new XorWowRandom((int)paramLong, (int)(paramLong >> 32));
  }
  
  public static final String boundsErrorMessage(Object paramObject1, Object paramObject2)
  {
    Intrinsics.checkParameterIsNotNull(paramObject1, "from");
    Intrinsics.checkParameterIsNotNull(paramObject2, "until");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Random range is empty: [");
    localStringBuilder.append(paramObject1);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramObject2);
    localStringBuilder.append(").");
    return localStringBuilder.toString();
  }
  
  public static final void checkRangeBounds(double paramDouble1, double paramDouble2)
  {
    int i;
    if (paramDouble2 > paramDouble1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    throw ((Throwable)new IllegalArgumentException(boundsErrorMessage(Double.valueOf(paramDouble1), Double.valueOf(paramDouble2)).toString()));
  }
  
  public static final void checkRangeBounds(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt2 > paramInt1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    throw ((Throwable)new IllegalArgumentException(boundsErrorMessage(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)).toString()));
  }
  
  public static final void checkRangeBounds(long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 > paramLong1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    throw ((Throwable)new IllegalArgumentException(boundsErrorMessage(Long.valueOf(paramLong1), Long.valueOf(paramLong2)).toString()));
  }
  
  public static final int fastLog2(int paramInt)
  {
    return 31 - Integer.numberOfLeadingZeros(paramInt);
  }
  
  public static final int nextInt(Random paramRandom, IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$nextInt");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "range");
    if (!paramIntRange.isEmpty())
    {
      if (paramIntRange.getLast() < Integer.MAX_VALUE) {
        return paramRandom.nextInt(paramIntRange.getFirst(), paramIntRange.getLast() + 1);
      }
      if (paramIntRange.getFirst() > Integer.MIN_VALUE) {
        return paramRandom.nextInt(paramIntRange.getFirst() - 1, paramIntRange.getLast()) + 1;
      }
      return paramRandom.nextInt();
    }
    paramRandom = new StringBuilder();
    paramRandom.append("Cannot get random in empty range: ");
    paramRandom.append(paramIntRange);
    throw ((Throwable)new IllegalArgumentException(paramRandom.toString()));
  }
  
  public static final long nextLong(Random paramRandom, LongRange paramLongRange)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$nextLong");
    Intrinsics.checkParameterIsNotNull(paramLongRange, "range");
    if (!paramLongRange.isEmpty())
    {
      if (paramLongRange.getLast() < Long.MAX_VALUE) {
        return paramRandom.nextLong(paramLongRange.getFirst(), paramLongRange.getLast() + 1L);
      }
      if (paramLongRange.getFirst() > Long.MIN_VALUE) {
        return paramRandom.nextLong(paramLongRange.getFirst() - 1L, paramLongRange.getLast()) + 1L;
      }
      return paramRandom.nextLong();
    }
    paramRandom = new StringBuilder();
    paramRandom.append("Cannot get random in empty range: ");
    paramRandom.append(paramLongRange);
    throw ((Throwable)new IllegalArgumentException(paramRandom.toString()));
  }
  
  public static final int takeUpperBits(int paramInt1, int paramInt2)
  {
    return paramInt1 >>> 32 - paramInt2 & -paramInt2 >> 31;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\random\RandomKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */