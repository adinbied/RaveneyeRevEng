package kotlin.experimental;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\020\n\000\n\002\020\005\n\000\n\002\020\n\n\002\b\004\032\025\020\000\032\0020\001*\0020\0012\006\020\002\032\0020\001H\f\032\025\020\000\032\0020\003*\0020\0032\006\020\002\032\0020\003H\f\032\r\020\004\032\0020\001*\0020\001H\b\032\r\020\004\032\0020\003*\0020\003H\b\032\025\020\005\032\0020\001*\0020\0012\006\020\002\032\0020\001H\f\032\025\020\005\032\0020\003*\0020\0032\006\020\002\032\0020\003H\f\032\025\020\006\032\0020\001*\0020\0012\006\020\002\032\0020\001H\f\032\025\020\006\032\0020\003*\0020\0032\006\020\002\032\0020\003H\f¨\006\007"}, d2={"and", "", "other", "", "inv", "or", "xor", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class BitwiseOperationsKt
{
  private static final byte and(byte paramByte1, byte paramByte2)
  {
    return (byte)(paramByte1 & paramByte2);
  }
  
  private static final short and(short paramShort1, short paramShort2)
  {
    return (short)(paramShort1 & paramShort2);
  }
  
  private static final byte inv(byte paramByte)
  {
    return (byte)paramByte;
  }
  
  private static final short inv(short paramShort)
  {
    return (short)paramShort;
  }
  
  private static final byte or(byte paramByte1, byte paramByte2)
  {
    return (byte)(paramByte1 | paramByte2);
  }
  
  private static final short or(short paramShort1, short paramShort2)
  {
    return (short)(paramShort1 | paramShort2);
  }
  
  private static final byte xor(byte paramByte1, byte paramByte2)
  {
    return (byte)(paramByte1 ^ paramByte2);
  }
  
  private static final short xor(short paramShort1, short paramShort2)
  {
    return (short)(paramShort1 ^ paramShort2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\experimental\BitwiseOperationsKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */