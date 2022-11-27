package kotlin.math;

import kotlin.Metadata;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;

@Metadata(bv={1, 0, 3}, d1={"\000\"\n\000\n\002\020\006\n\002\b\004\n\002\020\007\n\002\b\002\n\002\020\b\n\002\b\002\n\002\020\t\n\002\b7\032\021\020\026\032\0020\0012\006\020\027\032\0020\001H\b\032\021\020\026\032\0020\0062\006\020\027\032\0020\006H\b\032\021\020\026\032\0020\t2\006\020\030\032\0020\tH\b\032\021\020\026\032\0020\f2\006\020\030\032\0020\fH\b\032\021\020\031\032\0020\0012\006\020\027\032\0020\001H\b\032\021\020\031\032\0020\0062\006\020\027\032\0020\006H\b\032\020\020\032\032\0020\0012\006\020\027\032\0020\001H\007\032\021\020\032\032\0020\0062\006\020\027\032\0020\006H\b\032\021\020\033\032\0020\0012\006\020\027\032\0020\001H\b\032\021\020\033\032\0020\0062\006\020\027\032\0020\006H\b\032\020\020\034\032\0020\0012\006\020\027\032\0020\001H\007\032\021\020\034\032\0020\0062\006\020\027\032\0020\006H\b\032\021\020\035\032\0020\0012\006\020\027\032\0020\001H\b\032\021\020\035\032\0020\0062\006\020\027\032\0020\006H\b\032\031\020\036\032\0020\0012\006\020\037\032\0020\0012\006\020\027\032\0020\001H\b\032\031\020\036\032\0020\0062\006\020\037\032\0020\0062\006\020\027\032\0020\006H\b\032\020\020 \032\0020\0012\006\020\027\032\0020\001H\007\032\021\020 \032\0020\0062\006\020\027\032\0020\006H\b\032\021\020!\032\0020\0012\006\020\027\032\0020\001H\b\032\021\020!\032\0020\0062\006\020\027\032\0020\006H\b\032\021\020\"\032\0020\0012\006\020\027\032\0020\001H\b\032\021\020\"\032\0020\0062\006\020\027\032\0020\006H\b\032\021\020#\032\0020\0012\006\020\027\032\0020\001H\b\032\021\020#\032\0020\0062\006\020\027\032\0020\006H\b\032\021\020$\032\0020\0012\006\020\027\032\0020\001H\b\032\021\020$\032\0020\0062\006\020\027\032\0020\006H\b\032\021\020%\032\0020\0012\006\020\027\032\0020\001H\b\032\021\020%\032\0020\0062\006\020\027\032\0020\006H\b\032\021\020&\032\0020\0012\006\020\027\032\0020\001H\b\032\021\020&\032\0020\0062\006\020\027\032\0020\006H\b\032\031\020'\032\0020\0012\006\020\027\032\0020\0012\006\020\037\032\0020\001H\b\032\031\020'\032\0020\0062\006\020\027\032\0020\0062\006\020\037\032\0020\006H\b\032\021\020(\032\0020\0012\006\020\027\032\0020\001H\b\032\021\020(\032\0020\0062\006\020\027\032\0020\006H\b\032\021\020)\032\0020\0012\006\020\027\032\0020\001H\b\032\021\020)\032\0020\0062\006\020\027\032\0020\006H\b\032\030\020*\032\0020\0012\006\020\027\032\0020\0012\006\020+\032\0020\001H\007\032\030\020*\032\0020\0062\006\020\027\032\0020\0062\006\020+\032\0020\006H\007\032\021\020,\032\0020\0012\006\020\027\032\0020\001H\b\032\021\020,\032\0020\0062\006\020\027\032\0020\006H\b\032\020\020-\032\0020\0012\006\020\027\032\0020\001H\007\032\020\020-\032\0020\0062\006\020\027\032\0020\006H\007\032\031\020.\032\0020\0012\006\020/\032\0020\0012\006\0200\032\0020\001H\b\032\031\020.\032\0020\0062\006\020/\032\0020\0062\006\0200\032\0020\006H\b\032\031\020.\032\0020\t2\006\020/\032\0020\t2\006\0200\032\0020\tH\b\032\031\020.\032\0020\f2\006\020/\032\0020\f2\006\0200\032\0020\fH\b\032\031\0201\032\0020\0012\006\020/\032\0020\0012\006\0200\032\0020\001H\b\032\031\0201\032\0020\0062\006\020/\032\0020\0062\006\0200\032\0020\006H\b\032\031\0201\032\0020\t2\006\020/\032\0020\t2\006\0200\032\0020\tH\b\032\031\0201\032\0020\f2\006\020/\032\0020\f2\006\0200\032\0020\fH\b\032\021\0202\032\0020\0012\006\020\027\032\0020\001H\b\032\021\0202\032\0020\0062\006\020\027\032\0020\006H\b\032\021\020\017\032\0020\0012\006\020\027\032\0020\001H\b\032\021\020\017\032\0020\0062\006\020\027\032\0020\006H\b\032\021\0203\032\0020\0012\006\020\027\032\0020\001H\b\032\021\0203\032\0020\0062\006\020\027\032\0020\006H\b\032\021\0204\032\0020\0012\006\020\027\032\0020\001H\b\032\021\0204\032\0020\0062\006\020\027\032\0020\006H\b\032\021\0205\032\0020\0012\006\020\027\032\0020\001H\b\032\021\0205\032\0020\0062\006\020\027\032\0020\006H\b\032\021\0206\032\0020\0012\006\020\027\032\0020\001H\b\032\021\0206\032\0020\0062\006\020\027\032\0020\006H\b\032\021\0207\032\0020\0012\006\020\027\032\0020\001H\b\032\021\0207\032\0020\0062\006\020\027\032\0020\006H\b\032\020\0208\032\0020\0012\006\020\027\032\0020\001H\007\032\020\0208\032\0020\0062\006\020\027\032\0020\006H\007\032\025\0209\032\0020\001*\0020\0012\006\020:\032\0020\001H\b\032\025\0209\032\0020\006*\0020\0062\006\020:\032\0020\006H\b\032\r\020;\032\0020\001*\0020\001H\b\032\r\020;\032\0020\006*\0020\006H\b\032\025\020<\032\0020\001*\0020\0012\006\020=\032\0020\001H\b\032\025\020<\032\0020\006*\0020\0062\006\020=\032\0020\006H\b\032\r\020>\032\0020\001*\0020\001H\b\032\r\020>\032\0020\006*\0020\006H\b\032\025\020?\032\0020\001*\0020\0012\006\020\027\032\0020\001H\b\032\025\020?\032\0020\001*\0020\0012\006\020\030\032\0020\tH\b\032\025\020?\032\0020\006*\0020\0062\006\020\027\032\0020\006H\b\032\025\020?\032\0020\006*\0020\0062\006\020\030\032\0020\tH\b\032\f\020@\032\0020\t*\0020\001H\007\032\f\020@\032\0020\t*\0020\006H\007\032\f\020A\032\0020\f*\0020\001H\007\032\f\020A\032\0020\f*\0020\006H\007\032\025\020B\032\0020\001*\0020\0012\006\020\017\032\0020\001H\b\032\025\020B\032\0020\001*\0020\0012\006\020\017\032\0020\tH\b\032\025\020B\032\0020\006*\0020\0062\006\020\017\032\0020\006H\b\032\025\020B\032\0020\006*\0020\0062\006\020\017\032\0020\tH\b\"\037\020\000\032\0020\001*\0020\0018Æ\002X\004¢\006\f\022\004\b\002\020\003\032\004\b\004\020\005\"\037\020\000\032\0020\006*\0020\0068Æ\002X\004¢\006\f\022\004\b\002\020\007\032\004\b\004\020\b\"\037\020\000\032\0020\t*\0020\t8Æ\002X\004¢\006\f\022\004\b\002\020\n\032\004\b\004\020\013\"\037\020\000\032\0020\f*\0020\f8Æ\002X\004¢\006\f\022\004\b\002\020\r\032\004\b\004\020\016\"\037\020\017\032\0020\001*\0020\0018Æ\002X\004¢\006\f\022\004\b\020\020\003\032\004\b\021\020\005\"\037\020\017\032\0020\006*\0020\0068Æ\002X\004¢\006\f\022\004\b\020\020\007\032\004\b\021\020\b\"\036\020\017\032\0020\t*\0020\t8FX\004¢\006\f\022\004\b\020\020\n\032\004\b\021\020\013\"\036\020\017\032\0020\t*\0020\f8FX\004¢\006\f\022\004\b\020\020\r\032\004\b\021\020\022\"\037\020\023\032\0020\001*\0020\0018Æ\002X\004¢\006\f\022\004\b\024\020\003\032\004\b\025\020\005\"\037\020\023\032\0020\006*\0020\0068Æ\002X\004¢\006\f\022\004\b\024\020\007\032\004\b\025\020\b¨\006C"}, d2={"absoluteValue", "", "absoluteValue$annotations", "(D)V", "getAbsoluteValue", "(D)D", "", "(F)V", "(F)F", "", "(I)V", "(I)I", "", "(J)V", "(J)J", "sign", "sign$annotations", "getSign", "(J)I", "ulp", "ulp$annotations", "getUlp", "abs", "x", "n", "acos", "acosh", "asin", "asinh", "atan", "atan2", "y", "atanh", "ceil", "cos", "cosh", "exp", "expm1", "floor", "hypot", "ln", "ln1p", "log", "base", "log10", "log2", "max", "a", "b", "min", "round", "sin", "sinh", "sqrt", "tan", "tanh", "truncate", "IEEErem", "divisor", "nextDown", "nextTowards", "to", "nextUp", "pow", "roundToInt", "roundToLong", "withSign", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/math/MathKt")
class MathKt__MathJVMKt
  extends MathKt__MathHKt
{
  private static final double IEEErem(double paramDouble1, double paramDouble2)
  {
    return Math.IEEEremainder(paramDouble1, paramDouble2);
  }
  
  private static final float IEEErem(float paramFloat1, float paramFloat2)
  {
    return (float)Math.IEEEremainder(paramFloat1, paramFloat2);
  }
  
  private static final double abs(double paramDouble)
  {
    return Math.abs(paramDouble);
  }
  
  private static final float abs(float paramFloat)
  {
    return Math.abs(paramFloat);
  }
  
  private static final int abs(int paramInt)
  {
    return Math.abs(paramInt);
  }
  
  private static final long abs(long paramLong)
  {
    return Math.abs(paramLong);
  }
  
  private static final double acos(double paramDouble)
  {
    return Math.acos(paramDouble);
  }
  
  private static final float acos(float paramFloat)
  {
    return (float)Math.acos(paramFloat);
  }
  
  public static final double acosh(double paramDouble)
  {
    double d1 = 1;
    if (paramDouble < d1) {
      return DoubleCompanionObject.INSTANCE.getNaN();
    }
    if (paramDouble > Constants.upper_taylor_2_bound) {
      return Math.log(paramDouble) + Constants.LN2;
    }
    double d2 = paramDouble - d1;
    if (d2 >= Constants.taylor_n_bound) {
      return Math.log(paramDouble + Math.sqrt(paramDouble * paramDouble - d1));
    }
    d1 = Math.sqrt(d2);
    paramDouble = d1;
    if (d1 >= Constants.taylor_2_bound) {
      paramDouble = d1 - d1 * d1 * d1 / 12;
    }
    return paramDouble * Math.sqrt(2.0D);
  }
  
  private static final float acosh(float paramFloat)
  {
    return (float)MathKt.acosh(paramFloat);
  }
  
  private static final double asin(double paramDouble)
  {
    return Math.asin(paramDouble);
  }
  
  private static final float asin(float paramFloat)
  {
    return (float)Math.asin(paramFloat);
  }
  
  public static final double asinh(double paramDouble)
  {
    if (paramDouble >= Constants.taylor_n_bound)
    {
      if (paramDouble > Constants.upper_taylor_n_bound)
      {
        if (paramDouble > Constants.upper_taylor_2_bound) {
          return Math.log(paramDouble) + Constants.LN2;
        }
        paramDouble *= 2;
        return Math.log(paramDouble + 1 / paramDouble);
      }
      return Math.log(paramDouble + Math.sqrt(paramDouble * paramDouble + 1));
    }
    if (paramDouble <= -Constants.taylor_n_bound) {
      return -MathKt.asinh(-paramDouble);
    }
    double d = paramDouble;
    if (Math.abs(paramDouble) >= Constants.taylor_2_bound) {
      d = paramDouble - paramDouble * paramDouble * paramDouble / 6;
    }
    return d;
  }
  
  private static final float asinh(float paramFloat)
  {
    return (float)MathKt.asinh(paramFloat);
  }
  
  private static final double atan(double paramDouble)
  {
    return Math.atan(paramDouble);
  }
  
  private static final float atan(float paramFloat)
  {
    return (float)Math.atan(paramFloat);
  }
  
  private static final double atan2(double paramDouble1, double paramDouble2)
  {
    return Math.atan2(paramDouble1, paramDouble2);
  }
  
  private static final float atan2(float paramFloat1, float paramFloat2)
  {
    return (float)Math.atan2(paramFloat1, paramFloat2);
  }
  
  public static final double atanh(double paramDouble)
  {
    if (Math.abs(paramDouble) < Constants.taylor_n_bound)
    {
      d = paramDouble;
      if (Math.abs(paramDouble) > Constants.taylor_2_bound) {
        d = paramDouble + paramDouble * paramDouble * paramDouble / 3;
      }
      return d;
    }
    double d = 1;
    return Math.log((d + paramDouble) / (d - paramDouble)) / 2;
  }
  
  private static final float atanh(float paramFloat)
  {
    return (float)MathKt.atanh(paramFloat);
  }
  
  private static final double ceil(double paramDouble)
  {
    return Math.ceil(paramDouble);
  }
  
  private static final float ceil(float paramFloat)
  {
    return (float)Math.ceil(paramFloat);
  }
  
  private static final double cos(double paramDouble)
  {
    return Math.cos(paramDouble);
  }
  
  private static final float cos(float paramFloat)
  {
    return (float)Math.cos(paramFloat);
  }
  
  private static final double cosh(double paramDouble)
  {
    return Math.cosh(paramDouble);
  }
  
  private static final float cosh(float paramFloat)
  {
    return (float)Math.cosh(paramFloat);
  }
  
  private static final double exp(double paramDouble)
  {
    return Math.exp(paramDouble);
  }
  
  private static final float exp(float paramFloat)
  {
    return (float)Math.exp(paramFloat);
  }
  
  private static final double expm1(double paramDouble)
  {
    return Math.expm1(paramDouble);
  }
  
  private static final float expm1(float paramFloat)
  {
    return (float)Math.expm1(paramFloat);
  }
  
  private static final double floor(double paramDouble)
  {
    return Math.floor(paramDouble);
  }
  
  private static final float floor(float paramFloat)
  {
    return (float)Math.floor(paramFloat);
  }
  
  private static final double getAbsoluteValue(double paramDouble)
  {
    return Math.abs(paramDouble);
  }
  
  private static final float getAbsoluteValue(float paramFloat)
  {
    return Math.abs(paramFloat);
  }
  
  private static final int getAbsoluteValue(int paramInt)
  {
    return Math.abs(paramInt);
  }
  
  private static final long getAbsoluteValue(long paramLong)
  {
    return Math.abs(paramLong);
  }
  
  private static final double getSign(double paramDouble)
  {
    return Math.signum(paramDouble);
  }
  
  private static final float getSign(float paramFloat)
  {
    return Math.signum(paramFloat);
  }
  
  public static final int getSign(int paramInt)
  {
    if (paramInt < 0) {
      return -1;
    }
    if (paramInt > 0) {
      return 1;
    }
    return 0;
  }
  
  public static final int getSign(long paramLong)
  {
    boolean bool = paramLong < 0L;
    if (bool) {
      return -1;
    }
    if (bool) {
      return 1;
    }
    return 0;
  }
  
  private static final double getUlp(double paramDouble)
  {
    return Math.ulp(paramDouble);
  }
  
  private static final float getUlp(float paramFloat)
  {
    return Math.ulp(paramFloat);
  }
  
  private static final double hypot(double paramDouble1, double paramDouble2)
  {
    return Math.hypot(paramDouble1, paramDouble2);
  }
  
  private static final float hypot(float paramFloat1, float paramFloat2)
  {
    return (float)Math.hypot(paramFloat1, paramFloat2);
  }
  
  private static final double ln(double paramDouble)
  {
    return Math.log(paramDouble);
  }
  
  private static final float ln(float paramFloat)
  {
    return (float)Math.log(paramFloat);
  }
  
  private static final double ln1p(double paramDouble)
  {
    return Math.log1p(paramDouble);
  }
  
  private static final float ln1p(float paramFloat)
  {
    return (float)Math.log1p(paramFloat);
  }
  
  public static final double log(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble2 > 0.0D) && (paramDouble2 != 1.0D)) {
      return Math.log(paramDouble1) / Math.log(paramDouble2);
    }
    return DoubleCompanionObject.INSTANCE.getNaN();
  }
  
  public static final float log(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat2 > 0.0F) && (paramFloat2 != 1.0F)) {
      return (float)(Math.log(paramFloat1) / Math.log(paramFloat2));
    }
    return FloatCompanionObject.INSTANCE.getNaN();
  }
  
  private static final double log10(double paramDouble)
  {
    return Math.log10(paramDouble);
  }
  
  private static final float log10(float paramFloat)
  {
    return (float)Math.log10(paramFloat);
  }
  
  public static final double log2(double paramDouble)
  {
    return Math.log(paramDouble) / Constants.LN2;
  }
  
  public static final float log2(float paramFloat)
  {
    return (float)(Math.log(paramFloat) / Constants.LN2);
  }
  
  private static final double max(double paramDouble1, double paramDouble2)
  {
    return Math.max(paramDouble1, paramDouble2);
  }
  
  private static final float max(float paramFloat1, float paramFloat2)
  {
    return Math.max(paramFloat1, paramFloat2);
  }
  
  private static final int max(int paramInt1, int paramInt2)
  {
    return Math.max(paramInt1, paramInt2);
  }
  
  private static final long max(long paramLong1, long paramLong2)
  {
    return Math.max(paramLong1, paramLong2);
  }
  
  private static final double min(double paramDouble1, double paramDouble2)
  {
    return Math.min(paramDouble1, paramDouble2);
  }
  
  private static final float min(float paramFloat1, float paramFloat2)
  {
    return Math.min(paramFloat1, paramFloat2);
  }
  
  private static final int min(int paramInt1, int paramInt2)
  {
    return Math.min(paramInt1, paramInt2);
  }
  
  private static final long min(long paramLong1, long paramLong2)
  {
    return Math.min(paramLong1, paramLong2);
  }
  
  private static final double nextDown(double paramDouble)
  {
    return Math.nextAfter(paramDouble, DoubleCompanionObject.INSTANCE.getNEGATIVE_INFINITY());
  }
  
  private static final float nextDown(float paramFloat)
  {
    return Math.nextAfter(paramFloat, DoubleCompanionObject.INSTANCE.getNEGATIVE_INFINITY());
  }
  
  private static final double nextTowards(double paramDouble1, double paramDouble2)
  {
    return Math.nextAfter(paramDouble1, paramDouble2);
  }
  
  private static final float nextTowards(float paramFloat1, float paramFloat2)
  {
    return Math.nextAfter(paramFloat1, paramFloat2);
  }
  
  private static final double nextUp(double paramDouble)
  {
    return Math.nextUp(paramDouble);
  }
  
  private static final float nextUp(float paramFloat)
  {
    return Math.nextUp(paramFloat);
  }
  
  private static final double pow(double paramDouble1, double paramDouble2)
  {
    return Math.pow(paramDouble1, paramDouble2);
  }
  
  private static final double pow(double paramDouble, int paramInt)
  {
    return Math.pow(paramDouble, paramInt);
  }
  
  private static final float pow(float paramFloat1, float paramFloat2)
  {
    return (float)Math.pow(paramFloat1, paramFloat2);
  }
  
  private static final float pow(float paramFloat, int paramInt)
  {
    return (float)Math.pow(paramFloat, paramInt);
  }
  
  private static final double round(double paramDouble)
  {
    return Math.rint(paramDouble);
  }
  
  private static final float round(float paramFloat)
  {
    return (float)Math.rint(paramFloat);
  }
  
  public static final int roundToInt(double paramDouble)
  {
    if (!Double.isNaN(paramDouble))
    {
      if (paramDouble > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      }
      if (paramDouble < Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
      }
      return (int)Math.round(paramDouble);
    }
    throw ((Throwable)new IllegalArgumentException("Cannot round NaN value."));
  }
  
  public static final int roundToInt(float paramFloat)
  {
    if (!Float.isNaN(paramFloat)) {
      return Math.round(paramFloat);
    }
    throw ((Throwable)new IllegalArgumentException("Cannot round NaN value."));
  }
  
  public static final long roundToLong(double paramDouble)
  {
    if (!Double.isNaN(paramDouble)) {
      return Math.round(paramDouble);
    }
    throw ((Throwable)new IllegalArgumentException("Cannot round NaN value."));
  }
  
  public static final long roundToLong(float paramFloat)
  {
    return MathKt.roundToLong(paramFloat);
  }
  
  private static final double sign(double paramDouble)
  {
    return Math.signum(paramDouble);
  }
  
  private static final float sign(float paramFloat)
  {
    return Math.signum(paramFloat);
  }
  
  private static final double sin(double paramDouble)
  {
    return Math.sin(paramDouble);
  }
  
  private static final float sin(float paramFloat)
  {
    return (float)Math.sin(paramFloat);
  }
  
  private static final double sinh(double paramDouble)
  {
    return Math.sinh(paramDouble);
  }
  
  private static final float sinh(float paramFloat)
  {
    return (float)Math.sinh(paramFloat);
  }
  
  private static final double sqrt(double paramDouble)
  {
    return Math.sqrt(paramDouble);
  }
  
  private static final float sqrt(float paramFloat)
  {
    return (float)Math.sqrt(paramFloat);
  }
  
  private static final double tan(double paramDouble)
  {
    return Math.tan(paramDouble);
  }
  
  private static final float tan(float paramFloat)
  {
    return (float)Math.tan(paramFloat);
  }
  
  private static final double tanh(double paramDouble)
  {
    return Math.tanh(paramDouble);
  }
  
  private static final float tanh(float paramFloat)
  {
    return (float)Math.tanh(paramFloat);
  }
  
  public static final double truncate(double paramDouble)
  {
    double d = paramDouble;
    if (!Double.isNaN(paramDouble))
    {
      if (Double.isInfinite(paramDouble)) {
        return paramDouble;
      }
      if (paramDouble > 0) {
        return Math.floor(paramDouble);
      }
      d = Math.ceil(paramDouble);
    }
    return d;
  }
  
  public static final float truncate(float paramFloat)
  {
    float f = paramFloat;
    if (!Float.isNaN(paramFloat))
    {
      if (Float.isInfinite(paramFloat)) {
        return paramFloat;
      }
      double d;
      if (paramFloat > 0) {
        d = Math.floor(paramFloat);
      } else {
        d = Math.ceil(paramFloat);
      }
      f = (float)d;
    }
    return f;
  }
  
  private static final double withSign(double paramDouble1, double paramDouble2)
  {
    return Math.copySign(paramDouble1, paramDouble2);
  }
  
  private static final double withSign(double paramDouble, int paramInt)
  {
    return Math.copySign(paramDouble, paramInt);
  }
  
  private static final float withSign(float paramFloat1, float paramFloat2)
  {
    return Math.copySign(paramFloat1, paramFloat2);
  }
  
  private static final float withSign(float paramFloat, int paramInt)
  {
    return Math.copySign(paramFloat, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\math\MathKt__MathJVMKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */