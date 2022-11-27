package kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;

@Metadata(bv={1, 0, 3}, d1={"\000j\n\002\030\002\n\002\020\017\n\000\n\002\020\n\n\002\b\t\n\002\020\b\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\r\n\002\020\013\n\002\020\000\n\002\b\022\n\002\030\002\n\002\b\r\n\002\020\005\n\002\b\003\n\002\020\006\n\002\b\003\n\002\020\007\n\002\b\006\n\002\020\t\n\002\b\005\n\002\020\016\n\002\b\016\b@\030\000 f2\b\022\004\022\0020\0000\001:\001fB\024\b\001\022\006\020\002\032\0020\003ø\001\000¢\006\004\b\004\020\005J\033\020\b\032\0020\0002\006\020\t\032\0020\000H\fø\001\000¢\006\004\b\n\020\013J\033\020\f\032\0020\r2\006\020\t\032\0020\016H\nø\001\000¢\006\004\b\017\020\020J\033\020\f\032\0020\r2\006\020\t\032\0020\021H\nø\001\000¢\006\004\b\022\020\023J\033\020\f\032\0020\r2\006\020\t\032\0020\024H\nø\001\000¢\006\004\b\025\020\026J\033\020\f\032\0020\r2\006\020\t\032\0020\000H\nø\001\000¢\006\004\b\027\020\030J\023\020\031\032\0020\000H\nø\001\000¢\006\004\b\032\020\005J\033\020\033\032\0020\0212\006\020\t\032\0020\016H\nø\001\000¢\006\004\b\034\020\020J\033\020\033\032\0020\0212\006\020\t\032\0020\021H\nø\001\000¢\006\004\b\035\020\023J\033\020\033\032\0020\0242\006\020\t\032\0020\024H\nø\001\000¢\006\004\b\036\020\037J\033\020\033\032\0020\0212\006\020\t\032\0020\000H\nø\001\000¢\006\004\b \020\030J\023\020!\032\0020\"2\b\020\t\032\004\030\0010#HÖ\003J\t\020$\032\0020\rHÖ\001J\023\020%\032\0020\000H\nø\001\000¢\006\004\b&\020\005J\023\020'\032\0020\000H\bø\001\000¢\006\004\b(\020\005J\033\020)\032\0020\0212\006\020\t\032\0020\016H\nø\001\000¢\006\004\b*\020\020J\033\020)\032\0020\0212\006\020\t\032\0020\021H\nø\001\000¢\006\004\b+\020\023J\033\020)\032\0020\0242\006\020\t\032\0020\024H\nø\001\000¢\006\004\b,\020\037J\033\020)\032\0020\0212\006\020\t\032\0020\000H\nø\001\000¢\006\004\b-\020\030J\033\020.\032\0020\0002\006\020\t\032\0020\000H\fø\001\000¢\006\004\b/\020\013J\033\0200\032\0020\0212\006\020\t\032\0020\016H\nø\001\000¢\006\004\b1\020\020J\033\0200\032\0020\0212\006\020\t\032\0020\021H\nø\001\000¢\006\004\b2\020\023J\033\0200\032\0020\0242\006\020\t\032\0020\024H\nø\001\000¢\006\004\b3\020\037J\033\0200\032\0020\0212\006\020\t\032\0020\000H\nø\001\000¢\006\004\b4\020\030J\033\0205\032\002062\006\020\t\032\0020\000H\nø\001\000¢\006\004\b7\0208J\033\0209\032\0020\0212\006\020\t\032\0020\016H\nø\001\000¢\006\004\b:\020\020J\033\0209\032\0020\0212\006\020\t\032\0020\021H\nø\001\000¢\006\004\b;\020\023J\033\0209\032\0020\0242\006\020\t\032\0020\024H\nø\001\000¢\006\004\b<\020\037J\033\0209\032\0020\0212\006\020\t\032\0020\000H\nø\001\000¢\006\004\b=\020\030J\033\020>\032\0020\0212\006\020\t\032\0020\016H\nø\001\000¢\006\004\b?\020\020J\033\020>\032\0020\0212\006\020\t\032\0020\021H\nø\001\000¢\006\004\b@\020\023J\033\020>\032\0020\0242\006\020\t\032\0020\024H\nø\001\000¢\006\004\bA\020\037J\033\020>\032\0020\0212\006\020\t\032\0020\000H\nø\001\000¢\006\004\bB\020\030J\020\020C\032\0020DH\b¢\006\004\bE\020FJ\020\020G\032\0020HH\b¢\006\004\bI\020JJ\020\020K\032\0020LH\b¢\006\004\bM\020NJ\020\020O\032\0020\rH\b¢\006\004\bP\020QJ\020\020R\032\0020SH\b¢\006\004\bT\020UJ\020\020V\032\0020\003H\b¢\006\004\bW\020\005J\017\020X\032\0020YH\026¢\006\004\bZ\020[J\023\020\\\032\0020\016H\bø\001\000¢\006\004\b]\020FJ\023\020^\032\0020\021H\bø\001\000¢\006\004\b_\020QJ\023\020`\032\0020\024H\bø\001\000¢\006\004\ba\020UJ\023\020b\032\0020\000H\bø\001\000¢\006\004\bc\020\005J\033\020d\032\0020\0002\006\020\t\032\0020\000H\fø\001\000¢\006\004\be\020\013R\026\020\002\032\0020\0038\000X\004¢\006\b\n\000\022\004\b\006\020\007ø\001\000\002\004\n\002\b\031¨\006g"}, d2={"Lkotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "data$annotations", "()V", "and", "other", "and-xj2QHRw", "(SS)S", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "compareTo-xj2QHRw", "(SS)I", "dec", "dec-impl", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(SJ)J", "div-xj2QHRw", "equals", "", "", "hashCode", "inc", "inc-impl", "inv", "inv-impl", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-xj2QHRw", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(S)B", "toDouble", "", "toDouble-impl", "(S)D", "toFloat", "", "toFloat-impl", "(S)F", "toInt", "toInt-impl", "(S)I", "toLong", "", "toLong-impl", "(S)J", "toShort", "toShort-impl", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "toUByte", "toUByte-impl", "toUInt", "toUInt-impl", "toULong", "toULong-impl", "toUShort", "toUShort-impl", "xor", "xor-xj2QHRw", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class UShort
  implements Comparable<UShort>
{
  public static final Companion Companion = new Companion(null);
  public static final short MAX_VALUE = -1;
  public static final short MIN_VALUE = 0;
  public static final int SIZE_BITS = 16;
  public static final int SIZE_BYTES = 2;
  private final short data;
  
  private static final short and-xj2QHRw(short paramShort1, short paramShort2)
  {
    return constructor-impl((short)(paramShort1 & paramShort2));
  }
  
  private static final int compareTo-7apg3OU(short paramShort, byte paramByte)
  {
    return Intrinsics.compare(paramShort & 0xFFFF, paramByte & 0xFF);
  }
  
  private static final int compareTo-VKZWuLQ(short paramShort, long paramLong)
  {
    return UnsignedKt.ulongCompare(ULong.constructor-impl(paramShort & 0xFFFF), paramLong);
  }
  
  private static final int compareTo-WZ4Q5Ns(short paramShort, int paramInt)
  {
    return UnsignedKt.uintCompare(UInt.constructor-impl(paramShort & 0xFFFF), paramInt);
  }
  
  private int compareTo-xj2QHRw(short paramShort)
  {
    return compareTo-xj2QHRw(this.data, paramShort);
  }
  
  private static int compareTo-xj2QHRw(short paramShort1, short paramShort2)
  {
    return Intrinsics.compare(paramShort1 & 0xFFFF, paramShort2 & 0xFFFF);
  }
  
  public static short constructor-impl(short paramShort)
  {
    return paramShort;
  }
  
  private static final short dec-impl(short paramShort)
  {
    return constructor-impl((short)(paramShort - 1));
  }
  
  private static final int div-7apg3OU(short paramShort, byte paramByte)
  {
    return UnsignedKt.uintDivide-J1ME1BU(UInt.constructor-impl(paramShort & 0xFFFF), UInt.constructor-impl(paramByte & 0xFF));
  }
  
  private static final long div-VKZWuLQ(short paramShort, long paramLong)
  {
    return UnsignedKt.ulongDivide-eb3DHEI(ULong.constructor-impl(paramShort & 0xFFFF), paramLong);
  }
  
  private static final int div-WZ4Q5Ns(short paramShort, int paramInt)
  {
    return UnsignedKt.uintDivide-J1ME1BU(UInt.constructor-impl(paramShort & 0xFFFF), paramInt);
  }
  
  private static final int div-xj2QHRw(short paramShort1, short paramShort2)
  {
    return UnsignedKt.uintDivide-J1ME1BU(UInt.constructor-impl(paramShort1 & 0xFFFF), UInt.constructor-impl(paramShort2 & 0xFFFF));
  }
  
  public static boolean equals-impl(short paramShort, Object paramObject)
  {
    if ((paramObject instanceof UShort))
    {
      if (paramShort == ((UShort)paramObject).unbox-impl()) {
        paramShort = 1;
      } else {
        paramShort = 0;
      }
      if (paramShort != 0) {
        return true;
      }
    }
    return false;
  }
  
  public static final boolean equals-impl0(short paramShort1, short paramShort2)
  {
    throw null;
  }
  
  public static int hashCode-impl(short paramShort)
  {
    return paramShort;
  }
  
  private static final short inc-impl(short paramShort)
  {
    return constructor-impl((short)(paramShort + 1));
  }
  
  private static final short inv-impl(short paramShort)
  {
    return constructor-impl((short)paramShort);
  }
  
  private static final int minus-7apg3OU(short paramShort, byte paramByte)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramShort & 0xFFFF) - UInt.constructor-impl(paramByte & 0xFF));
  }
  
  private static final long minus-VKZWuLQ(short paramShort, long paramLong)
  {
    return ULong.constructor-impl(ULong.constructor-impl(paramShort & 0xFFFF) - paramLong);
  }
  
  private static final int minus-WZ4Q5Ns(short paramShort, int paramInt)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramShort & 0xFFFF) - paramInt);
  }
  
  private static final int minus-xj2QHRw(short paramShort1, short paramShort2)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramShort1 & 0xFFFF) - UInt.constructor-impl(paramShort2 & 0xFFFF));
  }
  
  private static final short or-xj2QHRw(short paramShort1, short paramShort2)
  {
    return constructor-impl((short)(paramShort1 | paramShort2));
  }
  
  private static final int plus-7apg3OU(short paramShort, byte paramByte)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramShort & 0xFFFF) + UInt.constructor-impl(paramByte & 0xFF));
  }
  
  private static final long plus-VKZWuLQ(short paramShort, long paramLong)
  {
    return ULong.constructor-impl(ULong.constructor-impl(paramShort & 0xFFFF) + paramLong);
  }
  
  private static final int plus-WZ4Q5Ns(short paramShort, int paramInt)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramShort & 0xFFFF) + paramInt);
  }
  
  private static final int plus-xj2QHRw(short paramShort1, short paramShort2)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramShort1 & 0xFFFF) + UInt.constructor-impl(paramShort2 & 0xFFFF));
  }
  
  private static final UIntRange rangeTo-xj2QHRw(short paramShort1, short paramShort2)
  {
    return new UIntRange(UInt.constructor-impl(paramShort1 & 0xFFFF), UInt.constructor-impl(paramShort2 & 0xFFFF), null);
  }
  
  private static final int rem-7apg3OU(short paramShort, byte paramByte)
  {
    return UnsignedKt.uintRemainder-J1ME1BU(UInt.constructor-impl(paramShort & 0xFFFF), UInt.constructor-impl(paramByte & 0xFF));
  }
  
  private static final long rem-VKZWuLQ(short paramShort, long paramLong)
  {
    return UnsignedKt.ulongRemainder-eb3DHEI(ULong.constructor-impl(paramShort & 0xFFFF), paramLong);
  }
  
  private static final int rem-WZ4Q5Ns(short paramShort, int paramInt)
  {
    return UnsignedKt.uintRemainder-J1ME1BU(UInt.constructor-impl(paramShort & 0xFFFF), paramInt);
  }
  
  private static final int rem-xj2QHRw(short paramShort1, short paramShort2)
  {
    return UnsignedKt.uintRemainder-J1ME1BU(UInt.constructor-impl(paramShort1 & 0xFFFF), UInt.constructor-impl(paramShort2 & 0xFFFF));
  }
  
  private static final int times-7apg3OU(short paramShort, byte paramByte)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramShort & 0xFFFF) * UInt.constructor-impl(paramByte & 0xFF));
  }
  
  private static final long times-VKZWuLQ(short paramShort, long paramLong)
  {
    return ULong.constructor-impl(ULong.constructor-impl(paramShort & 0xFFFF) * paramLong);
  }
  
  private static final int times-WZ4Q5Ns(short paramShort, int paramInt)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramShort & 0xFFFF) * paramInt);
  }
  
  private static final int times-xj2QHRw(short paramShort1, short paramShort2)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramShort1 & 0xFFFF) * UInt.constructor-impl(paramShort2 & 0xFFFF));
  }
  
  private static final byte toByte-impl(short paramShort)
  {
    return (byte)paramShort;
  }
  
  private static final double toDouble-impl(short paramShort)
  {
    return paramShort & 0xFFFF;
  }
  
  private static final float toFloat-impl(short paramShort)
  {
    return paramShort & 0xFFFF;
  }
  
  private static final int toInt-impl(short paramShort)
  {
    return paramShort & 0xFFFF;
  }
  
  private static final long toLong-impl(short paramShort)
  {
    return paramShort & 0xFFFF;
  }
  
  private static final short toShort-impl(short paramShort)
  {
    return paramShort;
  }
  
  public static String toString-impl(short paramShort)
  {
    return String.valueOf(paramShort & 0xFFFF);
  }
  
  private static final byte toUByte-impl(short paramShort)
  {
    return UByte.constructor-impl((byte)paramShort);
  }
  
  private static final int toUInt-impl(short paramShort)
  {
    return UInt.constructor-impl(paramShort & 0xFFFF);
  }
  
  private static final long toULong-impl(short paramShort)
  {
    return ULong.constructor-impl(paramShort & 0xFFFF);
  }
  
  private static final short toUShort-impl(short paramShort)
  {
    return paramShort;
  }
  
  private static final short xor-xj2QHRw(short paramShort1, short paramShort2)
  {
    return constructor-impl((short)(paramShort1 ^ paramShort2));
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
  
  @Metadata(bv={1, 0, 3}, d1={"\000\034\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\002\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\023\020\003\032\0020\004XTø\001\000¢\006\004\n\002\020\005R\023\020\006\032\0020\004XTø\001\000¢\006\004\n\002\020\005R\016\020\007\032\0020\bXT¢\006\002\n\000R\016\020\t\032\0020\bXT¢\006\002\n\000\002\004\n\002\b\031¨\006\n"}, d2={"Lkotlin/UShort$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UShort;", "S", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
  public static final class Companion {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\UShort.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */