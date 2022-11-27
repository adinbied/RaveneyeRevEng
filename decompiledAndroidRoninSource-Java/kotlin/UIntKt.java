package kotlin;

@Metadata(bv={1, 0, 3}, d1={"\000,\n\000\n\002\030\002\n\002\020\005\n\000\n\002\020\006\n\000\n\002\020\007\n\000\n\002\020\b\n\000\n\002\020\t\n\000\n\002\020\n\n\002\b\002\032\025\020\000\032\0020\001*\0020\002H\bø\001\000¢\006\002\020\003\032\025\020\000\032\0020\001*\0020\004H\bø\001\000¢\006\002\020\005\032\025\020\000\032\0020\001*\0020\006H\bø\001\000¢\006\002\020\007\032\025\020\000\032\0020\001*\0020\bH\bø\001\000¢\006\002\020\t\032\025\020\000\032\0020\001*\0020\nH\bø\001\000¢\006\002\020\013\032\025\020\000\032\0020\001*\0020\fH\bø\001\000¢\006\002\020\r\002\004\n\002\b\031¨\006\016"}, d2={"toUInt", "Lkotlin/UInt;", "", "(B)I", "", "(D)I", "", "(F)I", "", "(I)I", "", "(J)I", "", "(S)I", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class UIntKt
{
  private static final int toUInt(byte paramByte)
  {
    return UInt.constructor-impl(paramByte);
  }
  
  private static final int toUInt(double paramDouble)
  {
    return UnsignedKt.doubleToUInt(paramDouble);
  }
  
  private static final int toUInt(float paramFloat)
  {
    return UnsignedKt.doubleToUInt(paramFloat);
  }
  
  private static final int toUInt(int paramInt)
  {
    return UInt.constructor-impl(paramInt);
  }
  
  private static final int toUInt(long paramLong)
  {
    return UInt.constructor-impl((int)paramLong);
  }
  
  private static final int toUInt(short paramShort)
  {
    return UInt.constructor-impl(paramShort);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\UIntKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */