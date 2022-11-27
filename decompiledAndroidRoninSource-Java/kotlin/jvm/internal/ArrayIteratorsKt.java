package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.collections.BooleanIterator;
import kotlin.collections.ByteIterator;
import kotlin.collections.CharIterator;
import kotlin.collections.DoubleIterator;
import kotlin.collections.FloatIterator;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.collections.ShortIterator;

@Metadata(bv={1, 0, 3}, d1={"\000F\n\000\n\002\030\002\n\000\n\002\020\030\n\002\030\002\n\002\020\022\n\002\030\002\n\002\020\031\n\002\030\002\n\002\020\023\n\002\030\002\n\002\020\024\n\002\030\002\n\002\020\025\n\002\030\002\n\002\020\026\n\002\030\002\n\002\020\027\n\000\032\016\020\000\032\0020\0012\006\020\002\032\0020\003\032\016\020\000\032\0020\0042\006\020\002\032\0020\005\032\016\020\000\032\0020\0062\006\020\002\032\0020\007\032\016\020\000\032\0020\b2\006\020\002\032\0020\t\032\016\020\000\032\0020\n2\006\020\002\032\0020\013\032\016\020\000\032\0020\f2\006\020\002\032\0020\r\032\016\020\000\032\0020\0162\006\020\002\032\0020\017\032\016\020\000\032\0020\0202\006\020\002\032\0020\021¨\006\022"}, d2={"iterator", "Lkotlin/collections/BooleanIterator;", "array", "", "Lkotlin/collections/ByteIterator;", "", "Lkotlin/collections/CharIterator;", "", "Lkotlin/collections/DoubleIterator;", "", "Lkotlin/collections/FloatIterator;", "", "Lkotlin/collections/IntIterator;", "", "Lkotlin/collections/LongIterator;", "", "Lkotlin/collections/ShortIterator;", "", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class ArrayIteratorsKt
{
  public static final BooleanIterator iterator(boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "array");
    return (BooleanIterator)new ArrayBooleanIterator(paramArrayOfBoolean);
  }
  
  public static final ByteIterator iterator(byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
    return (ByteIterator)new ArrayByteIterator(paramArrayOfByte);
  }
  
  public static final CharIterator iterator(char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "array");
    return (CharIterator)new ArrayCharIterator(paramArrayOfChar);
  }
  
  public static final DoubleIterator iterator(double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "array");
    return (DoubleIterator)new ArrayDoubleIterator(paramArrayOfDouble);
  }
  
  public static final FloatIterator iterator(float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "array");
    return (FloatIterator)new ArrayFloatIterator(paramArrayOfFloat);
  }
  
  public static final IntIterator iterator(int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "array");
    return (IntIterator)new ArrayIntIterator(paramArrayOfInt);
  }
  
  public static final LongIterator iterator(long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "array");
    return (LongIterator)new ArrayLongIterator(paramArrayOfLong);
  }
  
  public static final ShortIterator iterator(short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "array");
    return (ShortIterator)new ArrayShortIterator(paramArrayOfShort);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\jvm\internal\ArrayIteratorsKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */