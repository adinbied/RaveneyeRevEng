package kotlin;

@Metadata(bv={1, 0, 3}, d1={"\000\022\n\000\n\002\020\b\n\002\020\005\n\002\020\n\n\002\b\b\032\r\020\000\032\0020\001*\0020\002H\b\032\r\020\000\032\0020\001*\0020\003H\b\032\r\020\004\032\0020\001*\0020\002H\b\032\r\020\004\032\0020\001*\0020\003H\b\032\r\020\005\032\0020\001*\0020\002H\b\032\r\020\005\032\0020\001*\0020\003H\b\032\024\020\006\032\0020\002*\0020\0022\006\020\007\032\0020\001H\007\032\024\020\006\032\0020\003*\0020\0032\006\020\007\032\0020\001H\007\032\024\020\b\032\0020\002*\0020\0022\006\020\007\032\0020\001H\007\032\024\020\b\032\0020\003*\0020\0032\006\020\007\032\0020\001H\007\032\r\020\t\032\0020\002*\0020\002H\b\032\r\020\t\032\0020\003*\0020\003H\b\032\r\020\n\032\0020\002*\0020\002H\b\032\r\020\n\032\0020\003*\0020\003H\b¨\006\013"}, d2={"countLeadingZeroBits", "", "", "", "countOneBits", "countTrailingZeroBits", "rotateLeft", "bitCount", "rotateRight", "takeHighestOneBit", "takeLowestOneBit", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/NumbersKt")
class NumbersKt__NumbersKt
  extends NumbersKt__NumbersJVMKt
{
  private static final int countLeadingZeroBits(byte paramByte)
  {
    return Integer.numberOfLeadingZeros(paramByte & 0xFF) - 24;
  }
  
  private static final int countLeadingZeroBits(short paramShort)
  {
    return Integer.numberOfLeadingZeros(paramShort & 0xFFFF) - 16;
  }
  
  private static final int countOneBits(byte paramByte)
  {
    return Integer.bitCount(paramByte & 0xFF);
  }
  
  private static final int countOneBits(short paramShort)
  {
    return Integer.bitCount(paramShort & 0xFFFF);
  }
  
  private static final int countTrailingZeroBits(byte paramByte)
  {
    return Integer.numberOfTrailingZeros(paramByte | 0x100);
  }
  
  private static final int countTrailingZeroBits(short paramShort)
  {
    return Integer.numberOfTrailingZeros(paramShort | 0x10000);
  }
  
  public static final byte rotateLeft(byte paramByte, int paramInt)
  {
    paramInt &= 0x7;
    return (byte)((paramByte & 0xFF) >>> 8 - paramInt | paramByte << paramInt);
  }
  
  public static final short rotateLeft(short paramShort, int paramInt)
  {
    paramInt &= 0xF;
    return (short)((paramShort & 0xFFFF) >>> 16 - paramInt | paramShort << paramInt);
  }
  
  public static final byte rotateRight(byte paramByte, int paramInt)
  {
    paramInt &= 0x7;
    return (byte)((paramByte & 0xFF) >>> paramInt | paramByte << 8 - paramInt);
  }
  
  public static final short rotateRight(short paramShort, int paramInt)
  {
    paramInt &= 0xF;
    return (short)((paramShort & 0xFFFF) >>> paramInt | paramShort << 16 - paramInt);
  }
  
  private static final byte takeHighestOneBit(byte paramByte)
  {
    return (byte)Integer.highestOneBit(paramByte & 0xFF);
  }
  
  private static final short takeHighestOneBit(short paramShort)
  {
    return (short)Integer.highestOneBit(paramShort & 0xFFFF);
  }
  
  private static final byte takeLowestOneBit(byte paramByte)
  {
    return (byte)Integer.lowestOneBit(paramByte);
  }
  
  private static final short takeLowestOneBit(short paramShort)
  {
    return (short)Integer.lowestOneBit(paramShort);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\NumbersKt__NumbersKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */