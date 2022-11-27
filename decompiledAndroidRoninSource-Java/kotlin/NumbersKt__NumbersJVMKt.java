package kotlin;

import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;

@Metadata(bv={1, 0, 3}, d1={"\000*\n\000\n\002\020\b\n\002\020\t\n\002\b\003\n\002\020\006\n\002\030\002\n\000\n\002\020\007\n\002\030\002\n\000\n\002\020\013\n\002\b\n\032\r\020\000\032\0020\001*\0020\001H\b\032\r\020\000\032\0020\001*\0020\002H\b\032\r\020\003\032\0020\001*\0020\001H\b\032\r\020\003\032\0020\001*\0020\002H\b\032\r\020\004\032\0020\001*\0020\001H\b\032\r\020\004\032\0020\001*\0020\002H\b\032\025\020\005\032\0020\006*\0020\0072\006\020\b\032\0020\002H\b\032\025\020\005\032\0020\t*\0020\n2\006\020\b\032\0020\001H\b\032\r\020\013\032\0020\f*\0020\006H\b\032\r\020\013\032\0020\f*\0020\tH\b\032\r\020\r\032\0020\f*\0020\006H\b\032\r\020\r\032\0020\f*\0020\tH\b\032\r\020\016\032\0020\f*\0020\006H\b\032\r\020\016\032\0020\f*\0020\tH\b\032\025\020\017\032\0020\001*\0020\0012\006\020\020\032\0020\001H\b\032\025\020\017\032\0020\002*\0020\0022\006\020\020\032\0020\001H\b\032\025\020\021\032\0020\001*\0020\0012\006\020\020\032\0020\001H\b\032\025\020\021\032\0020\002*\0020\0022\006\020\020\032\0020\001H\b\032\r\020\022\032\0020\001*\0020\001H\b\032\r\020\022\032\0020\002*\0020\002H\b\032\r\020\023\032\0020\001*\0020\001H\b\032\r\020\023\032\0020\002*\0020\002H\b\032\r\020\024\032\0020\002*\0020\006H\b\032\r\020\024\032\0020\001*\0020\tH\b\032\r\020\025\032\0020\002*\0020\006H\b\032\r\020\025\032\0020\001*\0020\tH\b¨\006\026"}, d2={"countLeadingZeroBits", "", "", "countOneBits", "countTrailingZeroBits", "fromBits", "", "Lkotlin/Double$Companion;", "bits", "", "Lkotlin/Float$Companion;", "isFinite", "", "isInfinite", "isNaN", "rotateLeft", "bitCount", "rotateRight", "takeHighestOneBit", "takeLowestOneBit", "toBits", "toRawBits", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/NumbersKt")
class NumbersKt__NumbersJVMKt
  extends NumbersKt__BigIntegersKt
{
  private static final int countLeadingZeroBits(int paramInt)
  {
    return Integer.numberOfLeadingZeros(paramInt);
  }
  
  private static final int countLeadingZeroBits(long paramLong)
  {
    return Long.numberOfLeadingZeros(paramLong);
  }
  
  private static final int countOneBits(int paramInt)
  {
    return Integer.bitCount(paramInt);
  }
  
  private static final int countOneBits(long paramLong)
  {
    return Long.bitCount(paramLong);
  }
  
  private static final int countTrailingZeroBits(int paramInt)
  {
    return Integer.numberOfTrailingZeros(paramInt);
  }
  
  private static final int countTrailingZeroBits(long paramLong)
  {
    return Long.numberOfTrailingZeros(paramLong);
  }
  
  private static final double fromBits(DoubleCompanionObject paramDoubleCompanionObject, long paramLong)
  {
    return Double.longBitsToDouble(paramLong);
  }
  
  private static final float fromBits(FloatCompanionObject paramFloatCompanionObject, int paramInt)
  {
    return Float.intBitsToFloat(paramInt);
  }
  
  private static final boolean isFinite(double paramDouble)
  {
    return (!Double.isInfinite(paramDouble)) && (!Double.isNaN(paramDouble));
  }
  
  private static final boolean isFinite(float paramFloat)
  {
    return (!Float.isInfinite(paramFloat)) && (!Float.isNaN(paramFloat));
  }
  
  private static final boolean isInfinite(double paramDouble)
  {
    return Double.isInfinite(paramDouble);
  }
  
  private static final boolean isInfinite(float paramFloat)
  {
    return Float.isInfinite(paramFloat);
  }
  
  private static final boolean isNaN(double paramDouble)
  {
    return Double.isNaN(paramDouble);
  }
  
  private static final boolean isNaN(float paramFloat)
  {
    return Float.isNaN(paramFloat);
  }
  
  private static final int rotateLeft(int paramInt1, int paramInt2)
  {
    return Integer.rotateLeft(paramInt1, paramInt2);
  }
  
  private static final long rotateLeft(long paramLong, int paramInt)
  {
    return Long.rotateLeft(paramLong, paramInt);
  }
  
  private static final int rotateRight(int paramInt1, int paramInt2)
  {
    return Integer.rotateRight(paramInt1, paramInt2);
  }
  
  private static final long rotateRight(long paramLong, int paramInt)
  {
    return Long.rotateRight(paramLong, paramInt);
  }
  
  private static final int takeHighestOneBit(int paramInt)
  {
    return Integer.highestOneBit(paramInt);
  }
  
  private static final long takeHighestOneBit(long paramLong)
  {
    return Long.highestOneBit(paramLong);
  }
  
  private static final int takeLowestOneBit(int paramInt)
  {
    return Integer.lowestOneBit(paramInt);
  }
  
  private static final long takeLowestOneBit(long paramLong)
  {
    return Long.lowestOneBit(paramLong);
  }
  
  private static final int toBits(float paramFloat)
  {
    return Float.floatToIntBits(paramFloat);
  }
  
  private static final long toBits(double paramDouble)
  {
    return Double.doubleToLongBits(paramDouble);
  }
  
  private static final int toRawBits(float paramFloat)
  {
    return Float.floatToRawIntBits(paramFloat);
  }
  
  private static final long toRawBits(double paramDouble)
  {
    return Double.doubleToRawLongBits(paramDouble);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\NumbersKt__NumbersJVMKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */