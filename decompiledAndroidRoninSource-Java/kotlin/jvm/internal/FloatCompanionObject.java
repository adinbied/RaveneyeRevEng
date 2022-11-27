package kotlin.jvm.internal;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\007\n\002\b\013\bÀ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002R\024\020\003\032\0020\004XD¢\006\b\n\000\032\004\b\005\020\006R\024\020\007\032\0020\004XD¢\006\b\n\000\032\004\b\b\020\006R\024\020\t\032\0020\004XD¢\006\b\n\000\032\004\b\n\020\006R\024\020\013\032\0020\004XD¢\006\b\n\000\032\004\b\f\020\006R\024\020\r\032\0020\004XD¢\006\b\n\000\032\004\b\016\020\006¨\006\017"}, d2={"Lkotlin/jvm/internal/FloatCompanionObject;", "", "()V", "MAX_VALUE", "", "getMAX_VALUE", "()F", "MIN_VALUE", "getMIN_VALUE", "NEGATIVE_INFINITY", "getNEGATIVE_INFINITY", "NaN", "getNaN", "POSITIVE_INFINITY", "getPOSITIVE_INFINITY", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class FloatCompanionObject
{
  public static final FloatCompanionObject INSTANCE = new FloatCompanionObject();
  private static final float MAX_VALUE = Float.MAX_VALUE;
  private static final float MIN_VALUE = Float.MIN_VALUE;
  private static final float NEGATIVE_INFINITY = Float.NEGATIVE_INFINITY;
  private static final float NaN = NaN.0F;
  private static final float POSITIVE_INFINITY = Float.POSITIVE_INFINITY;
  
  static
  {
    MAX_VALUE = Float.MAX_VALUE;
    POSITIVE_INFINITY = Float.POSITIVE_INFINITY;
  }
  
  public final float getMAX_VALUE()
  {
    return MAX_VALUE;
  }
  
  public final float getMIN_VALUE()
  {
    return MIN_VALUE;
  }
  
  public final float getNEGATIVE_INFINITY()
  {
    return NEGATIVE_INFINITY;
  }
  
  public final float getNaN()
  {
    return NaN;
  }
  
  public final float getPOSITIVE_INFINITY()
  {
    return POSITIVE_INFINITY;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\jvm\internal\FloatCompanionObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */