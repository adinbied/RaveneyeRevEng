package kotlin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000$\n\000\n\002\030\002\n\002\b\t\n\002\020\006\n\000\n\002\030\002\n\002\020\007\n\002\020\b\n\002\020\t\n\002\b\002\032\r\020\000\032\0020\001*\0020\001H\n\032\025\020\002\032\0020\001*\0020\0012\006\020\003\032\0020\001H\n\032\r\020\004\032\0020\001*\0020\001H\n\032\025\020\005\032\0020\001*\0020\0012\006\020\003\032\0020\001H\n\032\025\020\006\032\0020\001*\0020\0012\006\020\003\032\0020\001H\n\032\025\020\007\032\0020\001*\0020\0012\006\020\003\032\0020\001H\n\032\025\020\b\032\0020\001*\0020\0012\006\020\003\032\0020\001H\n\032\025\020\t\032\0020\001*\0020\0012\006\020\003\032\0020\001H\n\032\r\020\n\032\0020\001*\0020\013H\b\032\025\020\n\032\0020\001*\0020\0132\006\020\f\032\0020\rH\b\032\r\020\n\032\0020\001*\0020\016H\b\032\025\020\n\032\0020\001*\0020\0162\006\020\f\032\0020\rH\b\032\r\020\n\032\0020\001*\0020\017H\b\032\025\020\n\032\0020\001*\0020\0172\006\020\f\032\0020\rH\b\032\r\020\n\032\0020\001*\0020\020H\b\032\025\020\n\032\0020\001*\0020\0202\006\020\f\032\0020\rH\b\032\r\020\021\032\0020\001*\0020\001H\n¨\006\022"}, d2={"dec", "Ljava/math/BigDecimal;", "div", "other", "inc", "minus", "mod", "plus", "rem", "times", "toBigDecimal", "", "mathContext", "Ljava/math/MathContext;", "", "", "", "unaryMinus", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/NumbersKt")
class NumbersKt__BigDecimalsKt
{
  private static final BigDecimal dec(BigDecimal paramBigDecimal)
  {
    Intrinsics.checkParameterIsNotNull(paramBigDecimal, "$this$dec");
    paramBigDecimal = paramBigDecimal.subtract(BigDecimal.ONE);
    Intrinsics.checkExpressionValueIsNotNull(paramBigDecimal, "this.subtract(BigDecimal.ONE)");
    return paramBigDecimal;
  }
  
  private static final BigDecimal div(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2)
  {
    Intrinsics.checkParameterIsNotNull(paramBigDecimal1, "$this$div");
    paramBigDecimal1 = paramBigDecimal1.divide(paramBigDecimal2, RoundingMode.HALF_EVEN);
    Intrinsics.checkExpressionValueIsNotNull(paramBigDecimal1, "this.divide(other, RoundingMode.HALF_EVEN)");
    return paramBigDecimal1;
  }
  
  private static final BigDecimal inc(BigDecimal paramBigDecimal)
  {
    Intrinsics.checkParameterIsNotNull(paramBigDecimal, "$this$inc");
    paramBigDecimal = paramBigDecimal.add(BigDecimal.ONE);
    Intrinsics.checkExpressionValueIsNotNull(paramBigDecimal, "this.add(BigDecimal.ONE)");
    return paramBigDecimal;
  }
  
  private static final BigDecimal minus(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2)
  {
    Intrinsics.checkParameterIsNotNull(paramBigDecimal1, "$this$minus");
    paramBigDecimal1 = paramBigDecimal1.subtract(paramBigDecimal2);
    Intrinsics.checkExpressionValueIsNotNull(paramBigDecimal1, "this.subtract(other)");
    return paramBigDecimal1;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Use rem(other) instead", replaceWith=@ReplaceWith(expression="rem(other)", imports={}))
  private static final BigDecimal mod(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2)
  {
    Intrinsics.checkParameterIsNotNull(paramBigDecimal1, "$this$mod");
    paramBigDecimal1 = paramBigDecimal1.remainder(paramBigDecimal2);
    Intrinsics.checkExpressionValueIsNotNull(paramBigDecimal1, "this.remainder(other)");
    return paramBigDecimal1;
  }
  
  private static final BigDecimal plus(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2)
  {
    Intrinsics.checkParameterIsNotNull(paramBigDecimal1, "$this$plus");
    paramBigDecimal1 = paramBigDecimal1.add(paramBigDecimal2);
    Intrinsics.checkExpressionValueIsNotNull(paramBigDecimal1, "this.add(other)");
    return paramBigDecimal1;
  }
  
  private static final BigDecimal rem(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2)
  {
    Intrinsics.checkParameterIsNotNull(paramBigDecimal1, "$this$rem");
    paramBigDecimal1 = paramBigDecimal1.remainder(paramBigDecimal2);
    Intrinsics.checkExpressionValueIsNotNull(paramBigDecimal1, "this.remainder(other)");
    return paramBigDecimal1;
  }
  
  private static final BigDecimal times(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2)
  {
    Intrinsics.checkParameterIsNotNull(paramBigDecimal1, "$this$times");
    paramBigDecimal1 = paramBigDecimal1.multiply(paramBigDecimal2);
    Intrinsics.checkExpressionValueIsNotNull(paramBigDecimal1, "this.multiply(other)");
    return paramBigDecimal1;
  }
  
  private static final BigDecimal toBigDecimal(double paramDouble)
  {
    return new BigDecimal(String.valueOf(paramDouble));
  }
  
  private static final BigDecimal toBigDecimal(double paramDouble, MathContext paramMathContext)
  {
    return new BigDecimal(String.valueOf(paramDouble), paramMathContext);
  }
  
  private static final BigDecimal toBigDecimal(float paramFloat)
  {
    return new BigDecimal(String.valueOf(paramFloat));
  }
  
  private static final BigDecimal toBigDecimal(float paramFloat, MathContext paramMathContext)
  {
    return new BigDecimal(String.valueOf(paramFloat), paramMathContext);
  }
  
  private static final BigDecimal toBigDecimal(int paramInt)
  {
    BigDecimal localBigDecimal = BigDecimal.valueOf(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localBigDecimal, "BigDecimal.valueOf(this.toLong())");
    return localBigDecimal;
  }
  
  private static final BigDecimal toBigDecimal(int paramInt, MathContext paramMathContext)
  {
    return new BigDecimal(paramInt, paramMathContext);
  }
  
  private static final BigDecimal toBigDecimal(long paramLong)
  {
    BigDecimal localBigDecimal = BigDecimal.valueOf(paramLong);
    Intrinsics.checkExpressionValueIsNotNull(localBigDecimal, "BigDecimal.valueOf(this)");
    return localBigDecimal;
  }
  
  private static final BigDecimal toBigDecimal(long paramLong, MathContext paramMathContext)
  {
    return new BigDecimal(paramLong, paramMathContext);
  }
  
  private static final BigDecimal unaryMinus(BigDecimal paramBigDecimal)
  {
    Intrinsics.checkParameterIsNotNull(paramBigDecimal, "$this$unaryMinus");
    paramBigDecimal = paramBigDecimal.negate();
    Intrinsics.checkExpressionValueIsNotNull(paramBigDecimal, "this.negate()");
    return paramBigDecimal;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\NumbersKt__BigDecimalsKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */