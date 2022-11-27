package kotlin;

@Metadata(bv={1, 0, 3}, d1={"\000&\n\000\n\002\020\b\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b)\032\027\020\000\032\0020\001*\0020\002H\bø\001\000¢\006\004\b\003\020\004\032\027\020\000\032\0020\001*\0020\005H\bø\001\000¢\006\004\b\006\020\007\032\027\020\000\032\0020\001*\0020\bH\bø\001\000¢\006\004\b\t\020\n\032\027\020\000\032\0020\001*\0020\013H\bø\001\000¢\006\004\b\f\020\r\032\027\020\016\032\0020\001*\0020\002H\bø\001\000¢\006\004\b\017\020\004\032\027\020\016\032\0020\001*\0020\005H\bø\001\000¢\006\004\b\020\020\007\032\027\020\016\032\0020\001*\0020\bH\bø\001\000¢\006\004\b\021\020\n\032\027\020\016\032\0020\001*\0020\013H\bø\001\000¢\006\004\b\022\020\r\032\027\020\023\032\0020\001*\0020\002H\bø\001\000¢\006\004\b\024\020\004\032\027\020\023\032\0020\001*\0020\005H\bø\001\000¢\006\004\b\025\020\007\032\027\020\023\032\0020\001*\0020\bH\bø\001\000¢\006\004\b\026\020\n\032\027\020\023\032\0020\001*\0020\013H\bø\001\000¢\006\004\b\027\020\r\032\037\020\030\032\0020\002*\0020\0022\006\020\031\032\0020\001H\bø\001\000¢\006\004\b\032\020\033\032\037\020\030\032\0020\005*\0020\0052\006\020\031\032\0020\001H\bø\001\000¢\006\004\b\034\020\035\032\037\020\030\032\0020\b*\0020\b2\006\020\031\032\0020\001H\bø\001\000¢\006\004\b\036\020\037\032\037\020\030\032\0020\013*\0020\0132\006\020\031\032\0020\001H\bø\001\000¢\006\004\b \020!\032\037\020\"\032\0020\002*\0020\0022\006\020\031\032\0020\001H\bø\001\000¢\006\004\b#\020\033\032\037\020\"\032\0020\005*\0020\0052\006\020\031\032\0020\001H\bø\001\000¢\006\004\b$\020\035\032\037\020\"\032\0020\b*\0020\b2\006\020\031\032\0020\001H\bø\001\000¢\006\004\b%\020\037\032\037\020\"\032\0020\013*\0020\0132\006\020\031\032\0020\001H\bø\001\000¢\006\004\b&\020!\032\027\020'\032\0020\002*\0020\002H\bø\001\000¢\006\004\b(\020)\032\027\020'\032\0020\005*\0020\005H\bø\001\000¢\006\004\b*\020\007\032\027\020'\032\0020\b*\0020\bH\bø\001\000¢\006\004\b+\020,\032\027\020'\032\0020\013*\0020\013H\bø\001\000¢\006\004\b-\020.\032\027\020/\032\0020\002*\0020\002H\bø\001\000¢\006\004\b0\020)\032\027\020/\032\0020\005*\0020\005H\bø\001\000¢\006\004\b1\020\007\032\027\020/\032\0020\b*\0020\bH\bø\001\000¢\006\004\b2\020,\032\027\020/\032\0020\013*\0020\013H\bø\001\000¢\006\004\b3\020.\002\004\n\002\b\031¨\0064"}, d2={"countLeadingZeroBits", "", "Lkotlin/UByte;", "countLeadingZeroBits-7apg3OU", "(B)I", "Lkotlin/UInt;", "countLeadingZeroBits-WZ4Q5Ns", "(I)I", "Lkotlin/ULong;", "countLeadingZeroBits-VKZWuLQ", "(J)I", "Lkotlin/UShort;", "countLeadingZeroBits-xj2QHRw", "(S)I", "countOneBits", "countOneBits-7apg3OU", "countOneBits-WZ4Q5Ns", "countOneBits-VKZWuLQ", "countOneBits-xj2QHRw", "countTrailingZeroBits", "countTrailingZeroBits-7apg3OU", "countTrailingZeroBits-WZ4Q5Ns", "countTrailingZeroBits-VKZWuLQ", "countTrailingZeroBits-xj2QHRw", "rotateLeft", "bitCount", "rotateLeft-LxnNnR4", "(BI)B", "rotateLeft-V7xB4Y4", "(II)I", "rotateLeft-JSWoG40", "(JI)J", "rotateLeft-olVBNx4", "(SI)S", "rotateRight", "rotateRight-LxnNnR4", "rotateRight-V7xB4Y4", "rotateRight-JSWoG40", "rotateRight-olVBNx4", "takeHighestOneBit", "takeHighestOneBit-7apg3OU", "(B)B", "takeHighestOneBit-WZ4Q5Ns", "takeHighestOneBit-VKZWuLQ", "(J)J", "takeHighestOneBit-xj2QHRw", "(S)S", "takeLowestOneBit", "takeLowestOneBit-7apg3OU", "takeLowestOneBit-WZ4Q5Ns", "takeLowestOneBit-VKZWuLQ", "takeLowestOneBit-xj2QHRw", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class UNumbersKt
{
  private static final int countLeadingZeroBits-7apg3OU(byte paramByte)
  {
    return Integer.numberOfLeadingZeros(paramByte & 0xFF) - 24;
  }
  
  private static final int countLeadingZeroBits-VKZWuLQ(long paramLong)
  {
    return Long.numberOfLeadingZeros(paramLong);
  }
  
  private static final int countLeadingZeroBits-WZ4Q5Ns(int paramInt)
  {
    return Integer.numberOfLeadingZeros(paramInt);
  }
  
  private static final int countLeadingZeroBits-xj2QHRw(short paramShort)
  {
    return Integer.numberOfLeadingZeros(paramShort & 0xFFFF) - 16;
  }
  
  private static final int countOneBits-7apg3OU(byte paramByte)
  {
    return Integer.bitCount(UInt.constructor-impl(paramByte & 0xFF));
  }
  
  private static final int countOneBits-VKZWuLQ(long paramLong)
  {
    return Long.bitCount(paramLong);
  }
  
  private static final int countOneBits-WZ4Q5Ns(int paramInt)
  {
    return Integer.bitCount(paramInt);
  }
  
  private static final int countOneBits-xj2QHRw(short paramShort)
  {
    return Integer.bitCount(UInt.constructor-impl(paramShort & 0xFFFF));
  }
  
  private static final int countTrailingZeroBits-7apg3OU(byte paramByte)
  {
    return Integer.numberOfTrailingZeros(paramByte | 0x100);
  }
  
  private static final int countTrailingZeroBits-VKZWuLQ(long paramLong)
  {
    return Long.numberOfTrailingZeros(paramLong);
  }
  
  private static final int countTrailingZeroBits-WZ4Q5Ns(int paramInt)
  {
    return Integer.numberOfTrailingZeros(paramInt);
  }
  
  private static final int countTrailingZeroBits-xj2QHRw(short paramShort)
  {
    return Integer.numberOfTrailingZeros(paramShort | 0x10000);
  }
  
  private static final long rotateLeft-JSWoG40(long paramLong, int paramInt)
  {
    return ULong.constructor-impl(Long.rotateLeft(paramLong, paramInt));
  }
  
  private static final byte rotateLeft-LxnNnR4(byte paramByte, int paramInt)
  {
    return UByte.constructor-impl(NumbersKt.rotateLeft(paramByte, paramInt));
  }
  
  private static final int rotateLeft-V7xB4Y4(int paramInt1, int paramInt2)
  {
    return UInt.constructor-impl(Integer.rotateLeft(paramInt1, paramInt2));
  }
  
  private static final short rotateLeft-olVBNx4(short paramShort, int paramInt)
  {
    return UShort.constructor-impl(NumbersKt.rotateLeft(paramShort, paramInt));
  }
  
  private static final long rotateRight-JSWoG40(long paramLong, int paramInt)
  {
    return ULong.constructor-impl(Long.rotateRight(paramLong, paramInt));
  }
  
  private static final byte rotateRight-LxnNnR4(byte paramByte, int paramInt)
  {
    return UByte.constructor-impl(NumbersKt.rotateRight(paramByte, paramInt));
  }
  
  private static final int rotateRight-V7xB4Y4(int paramInt1, int paramInt2)
  {
    return UInt.constructor-impl(Integer.rotateRight(paramInt1, paramInt2));
  }
  
  private static final short rotateRight-olVBNx4(short paramShort, int paramInt)
  {
    return UShort.constructor-impl(NumbersKt.rotateRight(paramShort, paramInt));
  }
  
  private static final byte takeHighestOneBit-7apg3OU(byte paramByte)
  {
    return UByte.constructor-impl((byte)Integer.highestOneBit(paramByte & 0xFF));
  }
  
  private static final long takeHighestOneBit-VKZWuLQ(long paramLong)
  {
    return ULong.constructor-impl(Long.highestOneBit(paramLong));
  }
  
  private static final int takeHighestOneBit-WZ4Q5Ns(int paramInt)
  {
    return UInt.constructor-impl(Integer.highestOneBit(paramInt));
  }
  
  private static final short takeHighestOneBit-xj2QHRw(short paramShort)
  {
    return UShort.constructor-impl((short)Integer.highestOneBit(paramShort & 0xFFFF));
  }
  
  private static final byte takeLowestOneBit-7apg3OU(byte paramByte)
  {
    return UByte.constructor-impl((byte)Integer.lowestOneBit(paramByte & 0xFF));
  }
  
  private static final long takeLowestOneBit-VKZWuLQ(long paramLong)
  {
    return ULong.constructor-impl(Long.lowestOneBit(paramLong));
  }
  
  private static final int takeLowestOneBit-WZ4Q5Ns(int paramInt)
  {
    return UInt.constructor-impl(Integer.lowestOneBit(paramInt));
  }
  
  private static final short takeLowestOneBit-xj2QHRw(short paramShort)
  {
    return UShort.constructor-impl((short)Integer.lowestOneBit(paramShort & 0xFFFF));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\UNumbersKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */