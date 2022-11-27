package kotlin;

import kotlin.ranges.ULongRange;

@Metadata(bv={1, 0, 3}, d1={"\000j\n\002\030\002\n\002\020\017\n\000\n\002\020\t\n\002\b\t\n\002\020\b\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\r\n\002\020\013\n\002\020\000\n\002\b\022\n\002\030\002\n\002\b\022\n\002\020\005\n\002\b\003\n\002\020\006\n\002\b\003\n\002\020\007\n\002\b\b\n\002\020\n\n\002\b\003\n\002\020\016\n\002\b\016\b@\030\000 m2\b\022\004\022\0020\0000\001:\001mB\024\b\001\022\006\020\002\032\0020\003ø\001\000¢\006\004\b\004\020\005J\033\020\b\032\0020\0002\006\020\t\032\0020\000H\fø\001\000¢\006\004\b\n\020\013J\033\020\f\032\0020\r2\006\020\t\032\0020\016H\nø\001\000¢\006\004\b\017\020\020J\033\020\f\032\0020\r2\006\020\t\032\0020\021H\nø\001\000¢\006\004\b\022\020\023J\033\020\f\032\0020\r2\006\020\t\032\0020\000H\nø\001\000¢\006\004\b\024\020\025J\033\020\f\032\0020\r2\006\020\t\032\0020\026H\nø\001\000¢\006\004\b\027\020\030J\023\020\031\032\0020\000H\nø\001\000¢\006\004\b\032\020\005J\033\020\033\032\0020\0002\006\020\t\032\0020\016H\nø\001\000¢\006\004\b\034\020\035J\033\020\033\032\0020\0002\006\020\t\032\0020\021H\nø\001\000¢\006\004\b\036\020\037J\033\020\033\032\0020\0002\006\020\t\032\0020\000H\nø\001\000¢\006\004\b \020\013J\033\020\033\032\0020\0002\006\020\t\032\0020\026H\nø\001\000¢\006\004\b!\020\"J\023\020#\032\0020$2\b\020\t\032\004\030\0010%HÖ\003J\t\020&\032\0020\rHÖ\001J\023\020'\032\0020\000H\nø\001\000¢\006\004\b(\020\005J\023\020)\032\0020\000H\bø\001\000¢\006\004\b*\020\005J\033\020+\032\0020\0002\006\020\t\032\0020\016H\nø\001\000¢\006\004\b,\020\035J\033\020+\032\0020\0002\006\020\t\032\0020\021H\nø\001\000¢\006\004\b-\020\037J\033\020+\032\0020\0002\006\020\t\032\0020\000H\nø\001\000¢\006\004\b.\020\013J\033\020+\032\0020\0002\006\020\t\032\0020\026H\nø\001\000¢\006\004\b/\020\"J\033\0200\032\0020\0002\006\020\t\032\0020\000H\fø\001\000¢\006\004\b1\020\013J\033\0202\032\0020\0002\006\020\t\032\0020\016H\nø\001\000¢\006\004\b3\020\035J\033\0202\032\0020\0002\006\020\t\032\0020\021H\nø\001\000¢\006\004\b4\020\037J\033\0202\032\0020\0002\006\020\t\032\0020\000H\nø\001\000¢\006\004\b5\020\013J\033\0202\032\0020\0002\006\020\t\032\0020\026H\nø\001\000¢\006\004\b6\020\"J\033\0207\032\002082\006\020\t\032\0020\000H\nø\001\000¢\006\004\b9\020:J\033\020;\032\0020\0002\006\020\t\032\0020\016H\nø\001\000¢\006\004\b<\020\035J\033\020;\032\0020\0002\006\020\t\032\0020\021H\nø\001\000¢\006\004\b=\020\037J\033\020;\032\0020\0002\006\020\t\032\0020\000H\nø\001\000¢\006\004\b>\020\013J\033\020;\032\0020\0002\006\020\t\032\0020\026H\nø\001\000¢\006\004\b?\020\"J\033\020@\032\0020\0002\006\020A\032\0020\rH\fø\001\000¢\006\004\bB\020\037J\033\020C\032\0020\0002\006\020A\032\0020\rH\fø\001\000¢\006\004\bD\020\037J\033\020E\032\0020\0002\006\020\t\032\0020\016H\nø\001\000¢\006\004\bF\020\035J\033\020E\032\0020\0002\006\020\t\032\0020\021H\nø\001\000¢\006\004\bG\020\037J\033\020E\032\0020\0002\006\020\t\032\0020\000H\nø\001\000¢\006\004\bH\020\013J\033\020E\032\0020\0002\006\020\t\032\0020\026H\nø\001\000¢\006\004\bI\020\"J\020\020J\032\0020KH\b¢\006\004\bL\020MJ\020\020N\032\0020OH\b¢\006\004\bP\020QJ\020\020R\032\0020SH\b¢\006\004\bT\020UJ\020\020V\032\0020\rH\b¢\006\004\bW\020XJ\020\020Y\032\0020\003H\b¢\006\004\bZ\020\005J\020\020[\032\0020\\H\b¢\006\004\b]\020^J\017\020_\032\0020`H\026¢\006\004\ba\020bJ\023\020c\032\0020\016H\bø\001\000¢\006\004\bd\020MJ\023\020e\032\0020\021H\bø\001\000¢\006\004\bf\020XJ\023\020g\032\0020\000H\bø\001\000¢\006\004\bh\020\005J\023\020i\032\0020\026H\bø\001\000¢\006\004\bj\020^J\033\020k\032\0020\0002\006\020\t\032\0020\000H\fø\001\000¢\006\004\bl\020\013R\026\020\002\032\0020\0038\000X\004¢\006\b\n\000\022\004\b\006\020\007ø\001\000\002\004\n\002\b\031¨\006n"}, d2={"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "data$annotations", "()V", "and", "other", "and-VKZWuLQ", "(JJ)J", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "dec", "dec-impl", "div", "div-7apg3OU", "(JB)J", "div-WZ4Q5Ns", "(JI)J", "div-VKZWuLQ", "div-xj2QHRw", "(JS)J", "equals", "", "", "hashCode", "inc", "inc-impl", "inv", "inv-impl", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-VKZWuLQ", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-impl", "shr", "shr-impl", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(J)B", "toDouble", "", "toDouble-impl", "(J)D", "toFloat", "", "toFloat-impl", "(J)F", "toInt", "toInt-impl", "(J)I", "toLong", "toLong-impl", "toShort", "", "toShort-impl", "(J)S", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "toUByte", "toUByte-impl", "toUInt", "toUInt-impl", "toULong", "toULong-impl", "toUShort", "toUShort-impl", "xor", "xor-VKZWuLQ", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class ULong
  implements Comparable<ULong>
{
  public static final Companion Companion = new Companion(null);
  public static final long MAX_VALUE = -1L;
  public static final long MIN_VALUE = 0L;
  public static final int SIZE_BITS = 64;
  public static final int SIZE_BYTES = 8;
  private final long data;
  
  private static final long and-VKZWuLQ(long paramLong1, long paramLong2)
  {
    return constructor-impl(paramLong1 & paramLong2);
  }
  
  private static final int compareTo-7apg3OU(long paramLong, byte paramByte)
  {
    return UnsignedKt.ulongCompare(paramLong, constructor-impl(paramByte & 0xFF));
  }
  
  private int compareTo-VKZWuLQ(long paramLong)
  {
    return compareTo-VKZWuLQ(this.data, paramLong);
  }
  
  private static int compareTo-VKZWuLQ(long paramLong1, long paramLong2)
  {
    return UnsignedKt.ulongCompare(paramLong1, paramLong2);
  }
  
  private static final int compareTo-WZ4Q5Ns(long paramLong, int paramInt)
  {
    return UnsignedKt.ulongCompare(paramLong, constructor-impl(paramInt & 0xFFFFFFFF));
  }
  
  private static final int compareTo-xj2QHRw(long paramLong, short paramShort)
  {
    return UnsignedKt.ulongCompare(paramLong, constructor-impl(paramShort & 0xFFFF));
  }
  
  public static long constructor-impl(long paramLong)
  {
    return paramLong;
  }
  
  private static final long dec-impl(long paramLong)
  {
    return constructor-impl(paramLong - 1L);
  }
  
  private static final long div-7apg3OU(long paramLong, byte paramByte)
  {
    return UnsignedKt.ulongDivide-eb3DHEI(paramLong, constructor-impl(paramByte & 0xFF));
  }
  
  private static final long div-VKZWuLQ(long paramLong1, long paramLong2)
  {
    return UnsignedKt.ulongDivide-eb3DHEI(paramLong1, paramLong2);
  }
  
  private static final long div-WZ4Q5Ns(long paramLong, int paramInt)
  {
    return UnsignedKt.ulongDivide-eb3DHEI(paramLong, constructor-impl(paramInt & 0xFFFFFFFF));
  }
  
  private static final long div-xj2QHRw(long paramLong, short paramShort)
  {
    return UnsignedKt.ulongDivide-eb3DHEI(paramLong, constructor-impl(paramShort & 0xFFFF));
  }
  
  public static boolean equals-impl(long paramLong, Object paramObject)
  {
    if ((paramObject instanceof ULong))
    {
      int i;
      if (paramLong == ((ULong)paramObject).unbox-impl()) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return true;
      }
    }
    return false;
  }
  
  public static final boolean equals-impl0(long paramLong1, long paramLong2)
  {
    throw null;
  }
  
  public static int hashCode-impl(long paramLong)
  {
    return (int)(paramLong ^ paramLong >>> 32);
  }
  
  private static final long inc-impl(long paramLong)
  {
    return constructor-impl(paramLong + 1L);
  }
  
  private static final long inv-impl(long paramLong)
  {
    return constructor-impl(paramLong);
  }
  
  private static final long minus-7apg3OU(long paramLong, byte paramByte)
  {
    return constructor-impl(paramLong - constructor-impl(paramByte & 0xFF));
  }
  
  private static final long minus-VKZWuLQ(long paramLong1, long paramLong2)
  {
    return constructor-impl(paramLong1 - paramLong2);
  }
  
  private static final long minus-WZ4Q5Ns(long paramLong, int paramInt)
  {
    return constructor-impl(paramLong - constructor-impl(paramInt & 0xFFFFFFFF));
  }
  
  private static final long minus-xj2QHRw(long paramLong, short paramShort)
  {
    return constructor-impl(paramLong - constructor-impl(paramShort & 0xFFFF));
  }
  
  private static final long or-VKZWuLQ(long paramLong1, long paramLong2)
  {
    return constructor-impl(paramLong1 | paramLong2);
  }
  
  private static final long plus-7apg3OU(long paramLong, byte paramByte)
  {
    return constructor-impl(paramLong + constructor-impl(paramByte & 0xFF));
  }
  
  private static final long plus-VKZWuLQ(long paramLong1, long paramLong2)
  {
    return constructor-impl(paramLong1 + paramLong2);
  }
  
  private static final long plus-WZ4Q5Ns(long paramLong, int paramInt)
  {
    return constructor-impl(paramLong + constructor-impl(paramInt & 0xFFFFFFFF));
  }
  
  private static final long plus-xj2QHRw(long paramLong, short paramShort)
  {
    return constructor-impl(paramLong + constructor-impl(paramShort & 0xFFFF));
  }
  
  private static final ULongRange rangeTo-VKZWuLQ(long paramLong1, long paramLong2)
  {
    return new ULongRange(paramLong1, paramLong2, null);
  }
  
  private static final long rem-7apg3OU(long paramLong, byte paramByte)
  {
    return UnsignedKt.ulongRemainder-eb3DHEI(paramLong, constructor-impl(paramByte & 0xFF));
  }
  
  private static final long rem-VKZWuLQ(long paramLong1, long paramLong2)
  {
    return UnsignedKt.ulongRemainder-eb3DHEI(paramLong1, paramLong2);
  }
  
  private static final long rem-WZ4Q5Ns(long paramLong, int paramInt)
  {
    return UnsignedKt.ulongRemainder-eb3DHEI(paramLong, constructor-impl(paramInt & 0xFFFFFFFF));
  }
  
  private static final long rem-xj2QHRw(long paramLong, short paramShort)
  {
    return UnsignedKt.ulongRemainder-eb3DHEI(paramLong, constructor-impl(paramShort & 0xFFFF));
  }
  
  private static final long shl-impl(long paramLong, int paramInt)
  {
    return constructor-impl(paramLong << paramInt);
  }
  
  private static final long shr-impl(long paramLong, int paramInt)
  {
    return constructor-impl(paramLong >>> paramInt);
  }
  
  private static final long times-7apg3OU(long paramLong, byte paramByte)
  {
    return constructor-impl(paramLong * constructor-impl(paramByte & 0xFF));
  }
  
  private static final long times-VKZWuLQ(long paramLong1, long paramLong2)
  {
    return constructor-impl(paramLong1 * paramLong2);
  }
  
  private static final long times-WZ4Q5Ns(long paramLong, int paramInt)
  {
    return constructor-impl(paramLong * constructor-impl(paramInt & 0xFFFFFFFF));
  }
  
  private static final long times-xj2QHRw(long paramLong, short paramShort)
  {
    return constructor-impl(paramLong * constructor-impl(paramShort & 0xFFFF));
  }
  
  private static final byte toByte-impl(long paramLong)
  {
    return (byte)(int)paramLong;
  }
  
  private static final double toDouble-impl(long paramLong)
  {
    return UnsignedKt.ulongToDouble(paramLong);
  }
  
  private static final float toFloat-impl(long paramLong)
  {
    return (float)UnsignedKt.ulongToDouble(paramLong);
  }
  
  private static final int toInt-impl(long paramLong)
  {
    return (int)paramLong;
  }
  
  private static final long toLong-impl(long paramLong)
  {
    return paramLong;
  }
  
  private static final short toShort-impl(long paramLong)
  {
    return (short)(int)paramLong;
  }
  
  public static String toString-impl(long paramLong)
  {
    return UnsignedKt.ulongToString(paramLong);
  }
  
  private static final byte toUByte-impl(long paramLong)
  {
    return UByte.constructor-impl((byte)(int)paramLong);
  }
  
  private static final int toUInt-impl(long paramLong)
  {
    return UInt.constructor-impl((int)paramLong);
  }
  
  private static final long toULong-impl(long paramLong)
  {
    return paramLong;
  }
  
  private static final short toUShort-impl(long paramLong)
  {
    return UShort.constructor-impl((short)(int)paramLong);
  }
  
  private static final long xor-VKZWuLQ(long paramLong1, long paramLong2)
  {
    return constructor-impl(paramLong1 ^ paramLong2);
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
  
  @Metadata(bv={1, 0, 3}, d1={"\000\034\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\002\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\023\020\003\032\0020\004XTø\001\000¢\006\004\n\002\020\005R\023\020\006\032\0020\004XTø\001\000¢\006\004\n\002\020\005R\016\020\007\032\0020\bXT¢\006\002\n\000R\016\020\t\032\0020\bXT¢\006\002\n\000\002\004\n\002\b\031¨\006\n"}, d2={"Lkotlin/ULong$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/ULong;", "J", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
  public static final class Companion {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\ULong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */