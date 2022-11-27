package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000T\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\002\020\005\n\000\n\002\030\002\n\002\020\f\n\000\n\002\030\002\n\002\020\006\n\000\n\002\030\002\n\002\020\007\n\000\n\002\030\002\n\002\020\b\n\000\n\002\030\002\n\002\020\t\n\000\n\002\030\002\n\002\020\n\n\000\032\020\020\000\032\0020\0012\006\020\002\032\0020\003H\001\032\020\020\004\032\0020\0052\006\020\002\032\0020\006H\001\032\020\020\007\032\0020\b2\006\020\002\032\0020\tH\001\032\020\020\n\032\0020\0132\006\020\002\032\0020\fH\001\032\020\020\r\032\0020\0162\006\020\002\032\0020\017H\001\032\020\020\020\032\0020\0212\006\020\002\032\0020\022H\001\032\020\020\023\032\0020\0242\006\020\002\032\0020\025H\001\032\020\020\026\032\0020\0272\006\020\002\032\0020\030H\001¨\006\031"}, d2={"boxBoolean", "Ljava/lang/Boolean;", "primitive", "", "boxByte", "Ljava/lang/Byte;", "", "boxChar", "Ljava/lang/Character;", "", "boxDouble", "Ljava/lang/Double;", "", "boxFloat", "Ljava/lang/Float;", "", "boxInt", "Ljava/lang/Integer;", "", "boxLong", "Ljava/lang/Long;", "", "boxShort", "Ljava/lang/Short;", "", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class Boxing
{
  public static final Boolean boxBoolean(boolean paramBoolean)
  {
    return Boolean.valueOf(paramBoolean);
  }
  
  public static final Byte boxByte(byte paramByte)
  {
    return Byte.valueOf(paramByte);
  }
  
  public static final Character boxChar(char paramChar)
  {
    return new Character(paramChar);
  }
  
  public static final Double boxDouble(double paramDouble)
  {
    return new Double(paramDouble);
  }
  
  public static final Float boxFloat(float paramFloat)
  {
    return new Float(paramFloat);
  }
  
  public static final Integer boxInt(int paramInt)
  {
    return new Integer(paramInt);
  }
  
  public static final Long boxLong(long paramLong)
  {
    return new Long(paramLong);
  }
  
  public static final Short boxShort(short paramShort)
  {
    return new Short(paramShort);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\jvm\internal\Boxing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */