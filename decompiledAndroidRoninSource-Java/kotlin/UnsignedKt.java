package kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

@Metadata(bv={1, 0, 3}, d1={"\0000\n\000\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\t\n\002\020\t\n\002\b\007\n\002\020\016\n\002\b\002\032\030\020\000\032\0020\0012\006\020\002\032\0020\003H\001ø\001\000¢\006\002\020\004\032\030\020\005\032\0020\0062\006\020\002\032\0020\003H\001ø\001\000¢\006\002\020\007\032\030\020\b\032\0020\t2\006\020\n\032\0020\t2\006\020\013\032\0020\tH\001\032\"\020\f\032\0020\0012\006\020\n\032\0020\0012\006\020\013\032\0020\001H\001ø\001\000¢\006\004\b\r\020\016\032\"\020\017\032\0020\0012\006\020\n\032\0020\0012\006\020\013\032\0020\001H\001ø\001\000¢\006\004\b\020\020\016\032\020\020\021\032\0020\0032\006\020\002\032\0020\tH\001\032\030\020\022\032\0020\t2\006\020\n\032\0020\0232\006\020\013\032\0020\023H\001\032\"\020\024\032\0020\0062\006\020\n\032\0020\0062\006\020\013\032\0020\006H\001ø\001\000¢\006\004\b\025\020\026\032\"\020\027\032\0020\0062\006\020\n\032\0020\0062\006\020\013\032\0020\006H\001ø\001\000¢\006\004\b\030\020\026\032\020\020\031\032\0020\0032\006\020\002\032\0020\023H\001\032\020\020\032\032\0020\0332\006\020\002\032\0020\023H\000\032\030\020\032\032\0020\0332\006\020\002\032\0020\0232\006\020\034\032\0020\tH\000\002\004\n\002\b\031¨\006\035"}, d2={"doubleToUInt", "Lkotlin/UInt;", "v", "", "(D)I", "doubleToULong", "Lkotlin/ULong;", "(D)J", "uintCompare", "", "v1", "v2", "uintDivide", "uintDivide-J1ME1BU", "(II)I", "uintRemainder", "uintRemainder-J1ME1BU", "uintToDouble", "ulongCompare", "", "ulongDivide", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "ulongToDouble", "ulongToString", "", "base", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class UnsignedKt
{
  public static final int doubleToUInt(double paramDouble)
  {
    if (Double.isNaN(paramDouble)) {}
    while (paramDouble <= uintToDouble(0)) {
      return 0;
    }
    if (paramDouble >= uintToDouble(-1)) {
      return -1;
    }
    double d = Integer.MAX_VALUE;
    if (paramDouble <= d) {
      return UInt.constructor-impl((int)paramDouble);
    }
    return UInt.constructor-impl(UInt.constructor-impl((int)(paramDouble - d)) + UInt.constructor-impl(Integer.MAX_VALUE));
  }
  
  public static final long doubleToULong(double paramDouble)
  {
    if (Double.isNaN(paramDouble)) {}
    while (paramDouble <= ulongToDouble(0L)) {
      return 0L;
    }
    if (paramDouble >= ulongToDouble(-1L)) {
      return -1L;
    }
    if (paramDouble < Long.MAX_VALUE) {
      return ULong.constructor-impl(paramDouble);
    }
    return ULong.constructor-impl(ULong.constructor-impl((paramDouble - 9.223372036854776E18D)) - Long.MIN_VALUE);
  }
  
  public static final int uintCompare(int paramInt1, int paramInt2)
  {
    return Intrinsics.compare(paramInt1 ^ 0x80000000, paramInt2 ^ 0x80000000);
  }
  
  public static final int uintDivide-J1ME1BU(int paramInt1, int paramInt2)
  {
    return UInt.constructor-impl((int)((paramInt1 & 0xFFFFFFFF) / (paramInt2 & 0xFFFFFFFF)));
  }
  
  public static final int uintRemainder-J1ME1BU(int paramInt1, int paramInt2)
  {
    return UInt.constructor-impl((int)((paramInt1 & 0xFFFFFFFF) % (paramInt2 & 0xFFFFFFFF)));
  }
  
  public static final double uintToDouble(int paramInt)
  {
    return (0x7FFFFFFF & paramInt) + (paramInt >>> 31 << 30) * 2;
  }
  
  public static final int ulongCompare(long paramLong1, long paramLong2)
  {
    return (paramLong1 ^ 0x8000000000000000) < (paramLong2 ^ 0x8000000000000000);
  }
  
  public static final long ulongDivide-eb3DHEI(long paramLong1, long paramLong2)
  {
    if (paramLong2 < 0L)
    {
      if (ulongCompare(paramLong1, paramLong2) < 0) {
        return ULong.constructor-impl(0L);
      }
      return ULong.constructor-impl(1L);
    }
    if (paramLong1 >= 0L) {
      return ULong.constructor-impl(paramLong1 / paramLong2);
    }
    int i = 1;
    long l = (paramLong1 >>> 1) / paramLong2 << 1;
    if (ulongCompare(ULong.constructor-impl(paramLong1 - l * paramLong2), ULong.constructor-impl(paramLong2)) < 0) {
      i = 0;
    }
    return ULong.constructor-impl(l + i);
  }
  
  public static final long ulongRemainder-eb3DHEI(long paramLong1, long paramLong2)
  {
    if (paramLong2 < 0L)
    {
      if (ulongCompare(paramLong1, paramLong2) < 0) {
        return paramLong1;
      }
      return ULong.constructor-impl(paramLong1 - paramLong2);
    }
    if (paramLong1 >= 0L) {
      return ULong.constructor-impl(paramLong1 % paramLong2);
    }
    paramLong1 -= ((paramLong1 >>> 1) / paramLong2 << 1) * paramLong2;
    if (ulongCompare(ULong.constructor-impl(paramLong1), ULong.constructor-impl(paramLong2)) < 0) {
      paramLong2 = 0L;
    }
    return ULong.constructor-impl(paramLong1 - paramLong2);
  }
  
  public static final double ulongToDouble(long paramLong)
  {
    return (paramLong >>> 11) * 'ࠀ' + (paramLong & 0x7FF);
  }
  
  public static final String ulongToString(long paramLong)
  {
    return ulongToString(paramLong, 10);
  }
  
  public static final String ulongToString(long paramLong, int paramInt)
  {
    if (paramLong >= 0L)
    {
      localObject = Long.toString(paramLong, CharsKt.checkRadix(paramInt));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.Long.toString(this, checkRadix(radix))");
      return (String)localObject;
    }
    long l4 = paramInt;
    long l2 = (paramLong >>> 1) / l4 << 1;
    long l3 = paramLong - l2 * l4;
    long l1 = l2;
    paramLong = l3;
    if (l3 >= l4)
    {
      paramLong = l3 - l4;
      l1 = l2 + 1L;
    }
    Object localObject = new StringBuilder();
    String str = Long.toString(l1, CharsKt.checkRadix(paramInt));
    Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.Long.toString(this, checkRadix(radix))");
    ((StringBuilder)localObject).append(str);
    str = Long.toString(paramLong, CharsKt.checkRadix(paramInt));
    Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.Long.toString(this, checkRadix(radix))");
    ((StringBuilder)localObject).append(str);
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\UnsignedKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */