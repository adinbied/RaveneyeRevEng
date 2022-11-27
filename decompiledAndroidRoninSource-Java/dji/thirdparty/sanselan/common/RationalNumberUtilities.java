package dji.thirdparty.sanselan.common;

public abstract class RationalNumberUtilities
  extends Number
{
  private static final double TOLERANCE = 1.0E-8D;
  
  public static final RationalNumber getRationalNumber(double paramDouble)
  {
    if (paramDouble >= 2.147483647E9D) {
      return new RationalNumber(Integer.MAX_VALUE, 1);
    }
    if (paramDouble <= -2.147483647E9D) {
      return new RationalNumber(-2147483647, 1);
    }
    int j = 0;
    int i;
    if (paramDouble < 0.0D)
    {
      paramDouble = Math.abs(paramDouble);
      i = 1;
    }
    else
    {
      i = 0;
    }
    if (paramDouble == 0.0D) {
      return new RationalNumber(0, 1);
    }
    int k;
    Object localObject2;
    if (paramDouble >= 1.0D)
    {
      k = (int)paramDouble;
      if (k < paramDouble)
      {
        localObject1 = new RationalNumber(k, 1);
        localObject2 = new RationalNumber(k + 1, 1);
      }
      else
      {
        localObject1 = new RationalNumber(k - 1, 1);
        localObject2 = new RationalNumber(k, 1);
      }
    }
    else
    {
      k = (int)(1.0D / paramDouble);
      if (1.0D / k < paramDouble)
      {
        localObject1 = new RationalNumber(1, k);
        localObject2 = new RationalNumber(1, k - 1);
      }
      else
      {
        localObject1 = new RationalNumber(1, k + 1);
        localObject2 = new RationalNumber(1, k);
      }
    }
    Object localObject3 = Option.factory((RationalNumber)localObject1, paramDouble);
    Object localObject4 = Option.factory((RationalNumber)localObject2, paramDouble);
    if (((Option)localObject3).error < ((Option)localObject4).error) {
      localObject1 = localObject3;
    }
    Object localObject5;
    for (Object localObject1 = localObject4; (((Option)localObject1).error > 1.0E-8D) && (j < 100); localObject1 = localObject5)
    {
      localObject5 = RationalNumber.factoryMethod(((Option)localObject3).rationalNumber.numerator + ((Option)localObject4).rationalNumber.numerator, ((Option)localObject3).rationalNumber.divisor + ((Option)localObject4).rationalNumber.divisor);
      localObject2 = Option.factory((RationalNumber)localObject5, paramDouble);
      if (paramDouble < ((RationalNumber)localObject5).doubleValue())
      {
        if (((Option)localObject4).error <= ((Option)localObject2).error) {
          break;
        }
        localObject4 = localObject2;
      }
      else
      {
        if (((Option)localObject3).error <= ((Option)localObject2).error) {
          break;
        }
        localObject3 = localObject2;
      }
      localObject5 = localObject1;
      if (((Option)localObject2).error < ((Option)localObject1).error) {
        localObject5 = localObject2;
      }
      j += 1;
    }
    if (i != 0) {
      return ((Option)localObject1).rationalNumber.negate();
    }
    return ((Option)localObject1).rationalNumber;
  }
  
  private static class Option
  {
    public final double error;
    public final RationalNumber rationalNumber;
    
    private Option(RationalNumber paramRationalNumber, double paramDouble)
    {
      this.rationalNumber = paramRationalNumber;
      this.error = paramDouble;
    }
    
    public static final Option factory(RationalNumber paramRationalNumber, double paramDouble)
    {
      return new Option(paramRationalNumber, Math.abs(paramRationalNumber.doubleValue() - paramDouble));
    }
    
    public String toString()
    {
      return this.rationalNumber.toString();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\common\RationalNumberUtilities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */