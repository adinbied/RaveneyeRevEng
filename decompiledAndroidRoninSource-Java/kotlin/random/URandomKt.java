package kotlin.random;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongRange;

@Metadata(bv={1, 0, 3}, d1={"\000:\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\003\n\002\030\002\n\002\030\002\n\000\n\002\020\b\n\002\b\017\n\002\030\002\n\002\b\007\n\002\030\002\n\002\b\002\032\"\020\000\032\0020\0012\006\020\002\032\0020\0032\006\020\004\032\0020\003H\001ø\001\000¢\006\004\b\005\020\006\032\"\020\007\032\0020\0012\006\020\002\032\0020\b2\006\020\004\032\0020\bH\001ø\001\000¢\006\004\b\t\020\n\032\034\020\013\032\0020\f*\0020\r2\006\020\016\032\0020\017H\007ø\001\000¢\006\002\020\020\032\036\020\013\032\0020\f*\0020\r2\006\020\021\032\0020\fH\007ø\001\000¢\006\004\b\022\020\023\0322\020\013\032\0020\f*\0020\r2\006\020\021\032\0020\f2\b\b\002\020\024\032\0020\0172\b\b\002\020\025\032\0020\017H\007ø\001\000¢\006\004\b\026\020\027\032\024\020\030\032\0020\003*\0020\rH\007ø\001\000¢\006\002\020\031\032\036\020\030\032\0020\003*\0020\r2\006\020\004\032\0020\003H\007ø\001\000¢\006\004\b\032\020\033\032&\020\030\032\0020\003*\0020\r2\006\020\002\032\0020\0032\006\020\004\032\0020\003H\007ø\001\000¢\006\004\b\034\020\035\032\034\020\030\032\0020\003*\0020\r2\006\020\036\032\0020\037H\007ø\001\000¢\006\002\020 \032\024\020!\032\0020\b*\0020\rH\007ø\001\000¢\006\002\020\"\032\036\020!\032\0020\b*\0020\r2\006\020\004\032\0020\bH\007ø\001\000¢\006\004\b#\020$\032&\020!\032\0020\b*\0020\r2\006\020\002\032\0020\b2\006\020\004\032\0020\bH\007ø\001\000¢\006\004\b%\020&\032\034\020!\032\0020\b*\0020\r2\006\020\036\032\0020'H\007ø\001\000¢\006\002\020(\002\004\n\002\b\031¨\006)"}, d2={"checkUIntRangeBounds", "", "from", "Lkotlin/UInt;", "until", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkULongRangeBounds", "Lkotlin/ULong;", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "nextUBytes", "Lkotlin/UByteArray;", "Lkotlin/random/Random;", "size", "", "(Lkotlin/random/Random;I)[B", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "nextUInt", "(Lkotlin/random/Random;)I", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", "range", "Lkotlin/ranges/UIntRange;", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class URandomKt
{
  public static final void checkUIntRangeBounds-J1ME1BU(int paramInt1, int paramInt2)
  {
    int i;
    if (UnsignedKt.uintCompare(paramInt2, paramInt1) > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    throw ((Throwable)new IllegalArgumentException(RandomKt.boundsErrorMessage(UInt.box-impl(paramInt1), UInt.box-impl(paramInt2)).toString()));
  }
  
  public static final void checkULongRangeBounds-eb3DHEI(long paramLong1, long paramLong2)
  {
    int i;
    if (UnsignedKt.ulongCompare(paramLong2, paramLong1) > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    throw ((Throwable)new IllegalArgumentException(RandomKt.boundsErrorMessage(ULong.box-impl(paramLong1), ULong.box-impl(paramLong2)).toString()));
  }
  
  public static final byte[] nextUBytes(Random paramRandom, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$nextUBytes");
    return UByteArray.constructor-impl(paramRandom.nextBytes(paramInt));
  }
  
  public static final byte[] nextUBytes-EVgfTAA(Random paramRandom, byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$nextUBytes");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
    paramRandom.nextBytes(paramArrayOfByte);
    return paramArrayOfByte;
  }
  
  public static final byte[] nextUBytes-Wvrt4B4(Random paramRandom, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$nextUBytes");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
    paramRandom.nextBytes(paramArrayOfByte, paramInt1, paramInt2);
    return paramArrayOfByte;
  }
  
  public static final int nextUInt(Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$nextUInt");
    return UInt.constructor-impl(paramRandom.nextInt());
  }
  
  public static final int nextUInt(Random paramRandom, UIntRange paramUIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$nextUInt");
    Intrinsics.checkParameterIsNotNull(paramUIntRange, "range");
    if (!paramUIntRange.isEmpty())
    {
      if (UnsignedKt.uintCompare(paramUIntRange.getLast(), -1) < 0) {
        return nextUInt-a8DCA5k(paramRandom, paramUIntRange.getFirst(), UInt.constructor-impl(paramUIntRange.getLast() + 1));
      }
      if (UnsignedKt.uintCompare(paramUIntRange.getFirst(), 0) > 0) {
        return UInt.constructor-impl(nextUInt-a8DCA5k(paramRandom, UInt.constructor-impl(paramUIntRange.getFirst() - 1), paramUIntRange.getLast()) + 1);
      }
      return nextUInt(paramRandom);
    }
    paramRandom = new StringBuilder();
    paramRandom.append("Cannot get random in empty range: ");
    paramRandom.append(paramUIntRange);
    throw ((Throwable)new IllegalArgumentException(paramRandom.toString()));
  }
  
  public static final int nextUInt-a8DCA5k(Random paramRandom, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$nextUInt");
    checkUIntRangeBounds-J1ME1BU(paramInt1, paramInt2);
    return UInt.constructor-impl(paramRandom.nextInt(paramInt1 ^ 0x80000000, paramInt2 ^ 0x80000000) ^ 0x80000000);
  }
  
  public static final int nextUInt-qCasIEU(Random paramRandom, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$nextUInt");
    return nextUInt-a8DCA5k(paramRandom, 0, paramInt);
  }
  
  public static final long nextULong(Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$nextULong");
    return ULong.constructor-impl(paramRandom.nextLong());
  }
  
  public static final long nextULong(Random paramRandom, ULongRange paramULongRange)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$nextULong");
    Intrinsics.checkParameterIsNotNull(paramULongRange, "range");
    if (!paramULongRange.isEmpty())
    {
      if (UnsignedKt.ulongCompare(paramULongRange.getLast(), -1L) < 0) {
        return nextULong-jmpaW-c(paramRandom, paramULongRange.getFirst(), ULong.constructor-impl(paramULongRange.getLast() + ULong.constructor-impl(1 & 0xFFFFFFFF)));
      }
      if (UnsignedKt.ulongCompare(paramULongRange.getFirst(), 0L) > 0)
      {
        long l1 = paramULongRange.getFirst();
        long l2 = 1 & 0xFFFFFFFF;
        return ULong.constructor-impl(nextULong-jmpaW-c(paramRandom, ULong.constructor-impl(l1 - ULong.constructor-impl(l2)), paramULongRange.getLast()) + ULong.constructor-impl(l2));
      }
      return nextULong(paramRandom);
    }
    paramRandom = new StringBuilder();
    paramRandom.append("Cannot get random in empty range: ");
    paramRandom.append(paramULongRange);
    throw ((Throwable)new IllegalArgumentException(paramRandom.toString()));
  }
  
  public static final long nextULong-V1Xi4fY(Random paramRandom, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$nextULong");
    return nextULong-jmpaW-c(paramRandom, 0L, paramLong);
  }
  
  public static final long nextULong-jmpaW-c(Random paramRandom, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$nextULong");
    checkULongRangeBounds-eb3DHEI(paramLong1, paramLong2);
    return ULong.constructor-impl(paramRandom.nextLong(paramLong1 ^ 0x8000000000000000, paramLong2 ^ 0x8000000000000000) ^ 0x8000000000000000);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\random\URandomKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */