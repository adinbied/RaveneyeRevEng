package kotlin;

import kotlin.ranges.UIntRange;

@Metadata(bv={1, 0, 3}, d1={"\000n\n\002\030\002\n\002\020\017\n\000\n\002\020\b\n\002\b\t\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\013\n\002\020\013\n\002\020\000\n\002\b\022\n\002\030\002\n\002\b\022\n\002\020\005\n\002\b\003\n\002\020\006\n\002\b\003\n\002\020\007\n\002\b\005\n\002\020\t\n\002\b\003\n\002\020\n\n\002\b\003\n\002\020\016\n\002\b\016\b@\030\000 j2\b\022\004\022\0020\0000\001:\001jB\024\b\001\022\006\020\002\032\0020\003ø\001\000¢\006\004\b\004\020\005J\033\020\b\032\0020\0002\006\020\t\032\0020\000H\fø\001\000¢\006\004\b\n\020\013J\033\020\f\032\0020\0032\006\020\t\032\0020\rH\nø\001\000¢\006\004\b\016\020\017J\033\020\f\032\0020\0032\006\020\t\032\0020\000H\nø\001\000¢\006\004\b\020\020\013J\033\020\f\032\0020\0032\006\020\t\032\0020\021H\nø\001\000¢\006\004\b\022\020\023J\033\020\f\032\0020\0032\006\020\t\032\0020\024H\nø\001\000¢\006\004\b\025\020\026J\023\020\027\032\0020\000H\nø\001\000¢\006\004\b\030\020\005J\033\020\031\032\0020\0002\006\020\t\032\0020\rH\nø\001\000¢\006\004\b\032\020\017J\033\020\031\032\0020\0002\006\020\t\032\0020\000H\nø\001\000¢\006\004\b\033\020\013J\033\020\031\032\0020\0212\006\020\t\032\0020\021H\nø\001\000¢\006\004\b\034\020\035J\033\020\031\032\0020\0002\006\020\t\032\0020\024H\nø\001\000¢\006\004\b\036\020\026J\023\020\037\032\0020 2\b\020\t\032\004\030\0010!HÖ\003J\t\020\"\032\0020\003HÖ\001J\023\020#\032\0020\000H\nø\001\000¢\006\004\b$\020\005J\023\020%\032\0020\000H\bø\001\000¢\006\004\b&\020\005J\033\020'\032\0020\0002\006\020\t\032\0020\rH\nø\001\000¢\006\004\b(\020\017J\033\020'\032\0020\0002\006\020\t\032\0020\000H\nø\001\000¢\006\004\b)\020\013J\033\020'\032\0020\0212\006\020\t\032\0020\021H\nø\001\000¢\006\004\b*\020\035J\033\020'\032\0020\0002\006\020\t\032\0020\024H\nø\001\000¢\006\004\b+\020\026J\033\020,\032\0020\0002\006\020\t\032\0020\000H\fø\001\000¢\006\004\b-\020\013J\033\020.\032\0020\0002\006\020\t\032\0020\rH\nø\001\000¢\006\004\b/\020\017J\033\020.\032\0020\0002\006\020\t\032\0020\000H\nø\001\000¢\006\004\b0\020\013J\033\020.\032\0020\0212\006\020\t\032\0020\021H\nø\001\000¢\006\004\b1\020\035J\033\020.\032\0020\0002\006\020\t\032\0020\024H\nø\001\000¢\006\004\b2\020\026J\033\0203\032\002042\006\020\t\032\0020\000H\nø\001\000¢\006\004\b5\0206J\033\0207\032\0020\0002\006\020\t\032\0020\rH\nø\001\000¢\006\004\b8\020\017J\033\0207\032\0020\0002\006\020\t\032\0020\000H\nø\001\000¢\006\004\b9\020\013J\033\0207\032\0020\0212\006\020\t\032\0020\021H\nø\001\000¢\006\004\b:\020\035J\033\0207\032\0020\0002\006\020\t\032\0020\024H\nø\001\000¢\006\004\b;\020\026J\033\020<\032\0020\0002\006\020=\032\0020\003H\fø\001\000¢\006\004\b>\020\013J\033\020?\032\0020\0002\006\020=\032\0020\003H\fø\001\000¢\006\004\b@\020\013J\033\020A\032\0020\0002\006\020\t\032\0020\rH\nø\001\000¢\006\004\bB\020\017J\033\020A\032\0020\0002\006\020\t\032\0020\000H\nø\001\000¢\006\004\bC\020\013J\033\020A\032\0020\0212\006\020\t\032\0020\021H\nø\001\000¢\006\004\bD\020\035J\033\020A\032\0020\0002\006\020\t\032\0020\024H\nø\001\000¢\006\004\bE\020\026J\020\020F\032\0020GH\b¢\006\004\bH\020IJ\020\020J\032\0020KH\b¢\006\004\bL\020MJ\020\020N\032\0020OH\b¢\006\004\bP\020QJ\020\020R\032\0020\003H\b¢\006\004\bS\020\005J\020\020T\032\0020UH\b¢\006\004\bV\020WJ\020\020X\032\0020YH\b¢\006\004\bZ\020[J\017\020\\\032\0020]H\026¢\006\004\b^\020_J\023\020`\032\0020\rH\bø\001\000¢\006\004\ba\020IJ\023\020b\032\0020\000H\bø\001\000¢\006\004\bc\020\005J\023\020d\032\0020\021H\bø\001\000¢\006\004\be\020WJ\023\020f\032\0020\024H\bø\001\000¢\006\004\bg\020[J\033\020h\032\0020\0002\006\020\t\032\0020\000H\fø\001\000¢\006\004\bi\020\013R\026\020\002\032\0020\0038\000X\004¢\006\b\n\000\022\004\b\006\020\007ø\001\000\002\004\n\002\b\031¨\006k"}, d2={"Lkotlin/UInt;", "", "data", "", "constructor-impl", "(I)I", "data$annotations", "()V", "and", "other", "and-WZ4Q5Ns", "(II)I", "compareTo", "Lkotlin/UByte;", "compareTo-7apg3OU", "(IB)I", "compareTo-WZ4Q5Ns", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "dec", "dec-impl", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(IJ)J", "div-xj2QHRw", "equals", "", "", "hashCode", "inc", "inc-impl", "inv", "inv-impl", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-WZ4Q5Ns", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-impl", "shr", "shr-impl", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(I)B", "toDouble", "", "toDouble-impl", "(I)D", "toFloat", "", "toFloat-impl", "(I)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(I)J", "toShort", "", "toShort-impl", "(I)S", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "toUByte", "toUByte-impl", "toUInt", "toUInt-impl", "toULong", "toULong-impl", "toUShort", "toUShort-impl", "xor", "xor-WZ4Q5Ns", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class UInt
  implements Comparable<UInt>
{
  public static final Companion Companion = new Companion(null);
  public static final int MAX_VALUE = -1;
  public static final int MIN_VALUE = 0;
  public static final int SIZE_BITS = 32;
  public static final int SIZE_BYTES = 4;
  private final int data;
  
  private static final int and-WZ4Q5Ns(int paramInt1, int paramInt2)
  {
    return constructor-impl(paramInt1 & paramInt2);
  }
  
  private static final int compareTo-7apg3OU(int paramInt, byte paramByte)
  {
    return UnsignedKt.uintCompare(paramInt, constructor-impl(paramByte & 0xFF));
  }
  
  private static final int compareTo-VKZWuLQ(int paramInt, long paramLong)
  {
    return UnsignedKt.ulongCompare(ULong.constructor-impl(paramInt & 0xFFFFFFFF), paramLong);
  }
  
  private int compareTo-WZ4Q5Ns(int paramInt)
  {
    return compareTo-WZ4Q5Ns(this.data, paramInt);
  }
  
  private static int compareTo-WZ4Q5Ns(int paramInt1, int paramInt2)
  {
    return UnsignedKt.uintCompare(paramInt1, paramInt2);
  }
  
  private static final int compareTo-xj2QHRw(int paramInt, short paramShort)
  {
    return UnsignedKt.uintCompare(paramInt, constructor-impl(paramShort & 0xFFFF));
  }
  
  public static int constructor-impl(int paramInt)
  {
    return paramInt;
  }
  
  private static final int dec-impl(int paramInt)
  {
    return constructor-impl(paramInt - 1);
  }
  
  private static final int div-7apg3OU(int paramInt, byte paramByte)
  {
    return UnsignedKt.uintDivide-J1ME1BU(paramInt, constructor-impl(paramByte & 0xFF));
  }
  
  private static final long div-VKZWuLQ(int paramInt, long paramLong)
  {
    return UnsignedKt.ulongDivide-eb3DHEI(ULong.constructor-impl(paramInt & 0xFFFFFFFF), paramLong);
  }
  
  private static final int div-WZ4Q5Ns(int paramInt1, int paramInt2)
  {
    return UnsignedKt.uintDivide-J1ME1BU(paramInt1, paramInt2);
  }
  
  private static final int div-xj2QHRw(int paramInt, short paramShort)
  {
    return UnsignedKt.uintDivide-J1ME1BU(paramInt, constructor-impl(paramShort & 0xFFFF));
  }
  
  public static boolean equals-impl(int paramInt, Object paramObject)
  {
    if ((paramObject instanceof UInt))
    {
      if (paramInt == ((UInt)paramObject).unbox-impl()) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        return true;
      }
    }
    return false;
  }
  
  public static final boolean equals-impl0(int paramInt1, int paramInt2)
  {
    throw null;
  }
  
  public static int hashCode-impl(int paramInt)
  {
    return paramInt;
  }
  
  private static final int inc-impl(int paramInt)
  {
    return constructor-impl(paramInt + 1);
  }
  
  private static final int inv-impl(int paramInt)
  {
    return constructor-impl(paramInt);
  }
  
  private static final int minus-7apg3OU(int paramInt, byte paramByte)
  {
    return constructor-impl(paramInt - constructor-impl(paramByte & 0xFF));
  }
  
  private static final long minus-VKZWuLQ(int paramInt, long paramLong)
  {
    return ULong.constructor-impl(ULong.constructor-impl(paramInt & 0xFFFFFFFF) - paramLong);
  }
  
  private static final int minus-WZ4Q5Ns(int paramInt1, int paramInt2)
  {
    return constructor-impl(paramInt1 - paramInt2);
  }
  
  private static final int minus-xj2QHRw(int paramInt, short paramShort)
  {
    return constructor-impl(paramInt - constructor-impl(paramShort & 0xFFFF));
  }
  
  private static final int or-WZ4Q5Ns(int paramInt1, int paramInt2)
  {
    return constructor-impl(paramInt1 | paramInt2);
  }
  
  private static final int plus-7apg3OU(int paramInt, byte paramByte)
  {
    return constructor-impl(paramInt + constructor-impl(paramByte & 0xFF));
  }
  
  private static final long plus-VKZWuLQ(int paramInt, long paramLong)
  {
    return ULong.constructor-impl(ULong.constructor-impl(paramInt & 0xFFFFFFFF) + paramLong);
  }
  
  private static final int plus-WZ4Q5Ns(int paramInt1, int paramInt2)
  {
    return constructor-impl(paramInt1 + paramInt2);
  }
  
  private static final int plus-xj2QHRw(int paramInt, short paramShort)
  {
    return constructor-impl(paramInt + constructor-impl(paramShort & 0xFFFF));
  }
  
  private static final UIntRange rangeTo-WZ4Q5Ns(int paramInt1, int paramInt2)
  {
    return new UIntRange(paramInt1, paramInt2, null);
  }
  
  private static final int rem-7apg3OU(int paramInt, byte paramByte)
  {
    return UnsignedKt.uintRemainder-J1ME1BU(paramInt, constructor-impl(paramByte & 0xFF));
  }
  
  private static final long rem-VKZWuLQ(int paramInt, long paramLong)
  {
    return UnsignedKt.ulongRemainder-eb3DHEI(ULong.constructor-impl(paramInt & 0xFFFFFFFF), paramLong);
  }
  
  private static final int rem-WZ4Q5Ns(int paramInt1, int paramInt2)
  {
    return UnsignedKt.uintRemainder-J1ME1BU(paramInt1, paramInt2);
  }
  
  private static final int rem-xj2QHRw(int paramInt, short paramShort)
  {
    return UnsignedKt.uintRemainder-J1ME1BU(paramInt, constructor-impl(paramShort & 0xFFFF));
  }
  
  private static final int shl-impl(int paramInt1, int paramInt2)
  {
    return constructor-impl(paramInt1 << paramInt2);
  }
  
  private static final int shr-impl(int paramInt1, int paramInt2)
  {
    return constructor-impl(paramInt1 >>> paramInt2);
  }
  
  private static final int times-7apg3OU(int paramInt, byte paramByte)
  {
    return constructor-impl(paramInt * constructor-impl(paramByte & 0xFF));
  }
  
  private static final long times-VKZWuLQ(int paramInt, long paramLong)
  {
    return ULong.constructor-impl(ULong.constructor-impl(paramInt & 0xFFFFFFFF) * paramLong);
  }
  
  private static final int times-WZ4Q5Ns(int paramInt1, int paramInt2)
  {
    return constructor-impl(paramInt1 * paramInt2);
  }
  
  private static final int times-xj2QHRw(int paramInt, short paramShort)
  {
    return constructor-impl(paramInt * constructor-impl(paramShort & 0xFFFF));
  }
  
  private static final byte toByte-impl(int paramInt)
  {
    return (byte)paramInt;
  }
  
  private static final double toDouble-impl(int paramInt)
  {
    return UnsignedKt.uintToDouble(paramInt);
  }
  
  private static final float toFloat-impl(int paramInt)
  {
    return (float)UnsignedKt.uintToDouble(paramInt);
  }
  
  private static final int toInt-impl(int paramInt)
  {
    return paramInt;
  }
  
  private static final long toLong-impl(int paramInt)
  {
    return paramInt & 0xFFFFFFFF;
  }
  
  private static final short toShort-impl(int paramInt)
  {
    return (short)paramInt;
  }
  
  public static String toString-impl(int paramInt)
  {
    return String.valueOf(paramInt & 0xFFFFFFFF);
  }
  
  private static final byte toUByte-impl(int paramInt)
  {
    return UByte.constructor-impl((byte)paramInt);
  }
  
  private static final int toUInt-impl(int paramInt)
  {
    return paramInt;
  }
  
  private static final long toULong-impl(int paramInt)
  {
    return ULong.constructor-impl(paramInt & 0xFFFFFFFF);
  }
  
  private static final short toUShort-impl(int paramInt)
  {
    return UShort.constructor-impl((short)paramInt);
  }
  
  private static final int xor-WZ4Q5Ns(int paramInt1, int paramInt2)
  {
    return constructor-impl(paramInt1 ^ paramInt2);
  }
  
  public boolean equals(Object paramObject)
  {
    return equals-impl(this.data, paramObject);
  }
  
  public int hashCode()
  {
    return hashCode-impl(this.data);
  }
  
  public String toString()
  {
    return toString-impl(this.data);
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\034\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\002\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\023\020\003\032\0020\004XTø\001\000¢\006\004\n\002\020\005R\023\020\006\032\0020\004XTø\001\000¢\006\004\n\002\020\005R\016\020\007\032\0020\bXT¢\006\002\n\000R\016\020\t\032\0020\bXT¢\006\002\n\000\002\004\n\002\b\031¨\006\n"}, d2={"Lkotlin/UInt$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UInt;", "I", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
  public static final class Companion {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\UInt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */