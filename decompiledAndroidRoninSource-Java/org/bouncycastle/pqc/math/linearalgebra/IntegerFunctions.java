package org.bouncycastle.pqc.math.linearalgebra;

import java.io.PrintStream;
import java.math.BigInteger;
import java.security.SecureRandom;

public final class IntegerFunctions
{
  private static final BigInteger FOUR;
  private static final BigInteger ONE;
  private static final int[] SMALL_PRIMES;
  private static final long SMALL_PRIME_PRODUCT = 152125131763605L;
  private static final BigInteger TWO;
  private static final BigInteger ZERO = BigInteger.valueOf(0L);
  private static final int[] jacobiTable = { 0, 1, 0, -1, 0, -1, 0, 1 };
  private static SecureRandom sr;
  
  static
  {
    ONE = BigInteger.valueOf(1L);
    TWO = BigInteger.valueOf(2L);
    FOUR = BigInteger.valueOf(4L);
    SMALL_PRIMES = new int[] { 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41 };
    sr = null;
  }
  
  public static BigInteger binomial(int paramInt1, int paramInt2)
  {
    BigInteger localBigInteger = ONE;
    if (paramInt1 == 0)
    {
      if (paramInt2 == 0) {
        return localBigInteger;
      }
      return ZERO;
    }
    int i = paramInt2;
    if (paramInt2 > paramInt1 >>> 1) {
      i = paramInt1 - paramInt2;
    }
    paramInt2 = 1;
    while (paramInt2 <= i)
    {
      localBigInteger = localBigInteger.multiply(BigInteger.valueOf(paramInt1 - (paramInt2 - 1))).divide(BigInteger.valueOf(paramInt2));
      paramInt2 += 1;
    }
    return localBigInteger;
  }
  
  public static int bitCount(int paramInt)
  {
    int i = 0;
    while (paramInt != 0)
    {
      i += (paramInt & 0x1);
      paramInt >>>= 1;
    }
    return i;
  }
  
  public static int ceilLog(int paramInt)
  {
    int j = 1;
    int i = 0;
    while (j < paramInt)
    {
      j <<= 1;
      i += 1;
    }
    return i;
  }
  
  public static int ceilLog(BigInteger paramBigInteger)
  {
    BigInteger localBigInteger = ONE;
    int i = 0;
    while (localBigInteger.compareTo(paramBigInteger) < 0)
    {
      i += 1;
      localBigInteger = localBigInteger.shiftLeft(1);
    }
    return i;
  }
  
  public static int ceilLog256(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = -paramInt;
    }
    paramInt = 0;
    while (i > 0)
    {
      paramInt += 1;
      i >>>= 8;
    }
    return paramInt;
  }
  
  public static int ceilLog256(long paramLong)
  {
    boolean bool = paramLong < 0L;
    if (!bool) {
      return 1;
    }
    long l = paramLong;
    if (bool) {
      l = -paramLong;
    }
    bool = false;
    int i;
    while (l > 0L)
    {
      bool += true;
      l >>>= 8;
    }
    return i;
  }
  
  public static BigInteger divideAndRound(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    if (paramBigInteger1.signum() < 0) {
      return divideAndRound(paramBigInteger1.negate(), paramBigInteger2).negate();
    }
    if (paramBigInteger2.signum() < 0) {
      return divideAndRound(paramBigInteger1, paramBigInteger2.negate()).negate();
    }
    return paramBigInteger1.shiftLeft(1).add(paramBigInteger2).divide(paramBigInteger2.shiftLeft(1));
  }
  
  public static BigInteger[] divideAndRound(BigInteger[] paramArrayOfBigInteger, BigInteger paramBigInteger)
  {
    BigInteger[] arrayOfBigInteger = new BigInteger[paramArrayOfBigInteger.length];
    int i = 0;
    while (i < paramArrayOfBigInteger.length)
    {
      arrayOfBigInteger[i] = divideAndRound(paramArrayOfBigInteger[i], paramBigInteger);
      i += 1;
    }
    return arrayOfBigInteger;
  }
  
  public static int[] extGCD(int paramInt1, int paramInt2)
  {
    BigInteger[] arrayOfBigInteger = extgcd(BigInteger.valueOf(paramInt1), BigInteger.valueOf(paramInt2));
    return new int[] { arrayOfBigInteger[0].intValue(), arrayOfBigInteger[1].intValue(), arrayOfBigInteger[2].intValue() };
  }
  
  public static BigInteger[] extgcd(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    Object localObject1 = ONE;
    Object localObject4 = ZERO;
    Object localObject3 = localObject1;
    Object localObject2 = paramBigInteger1;
    if (paramBigInteger2.signum() != 0)
    {
      localObject4 = ZERO;
      localObject3 = paramBigInteger1;
      localObject2 = paramBigInteger2;
      while (((BigInteger)localObject2).signum() != 0)
      {
        Object localObject5 = ((BigInteger)localObject3).divideAndRemainder((BigInteger)localObject2);
        localObject3 = localObject5[0];
        localObject5 = localObject5[1];
        BigInteger localBigInteger = ((BigInteger)localObject1).subtract(((BigInteger)localObject3).multiply((BigInteger)localObject4));
        localObject1 = localObject4;
        localObject3 = localObject2;
        localObject2 = localObject5;
        localObject4 = localBigInteger;
      }
      localObject4 = ((BigInteger)localObject3).subtract(paramBigInteger1.multiply((BigInteger)localObject1)).divide(paramBigInteger2);
      localObject2 = localObject3;
      localObject3 = localObject1;
    }
    return new BigInteger[] { localObject2, localObject3, localObject4 };
  }
  
  public static float floatPow(float paramFloat, int paramInt)
  {
    float f = 1.0F;
    while (paramInt > 0)
    {
      f *= paramFloat;
      paramInt -= 1;
    }
    return f;
  }
  
  public static int floorLog(int paramInt)
  {
    if (paramInt <= 0) {
      return -1;
    }
    paramInt >>>= 1;
    int i = 0;
    while (paramInt > 0)
    {
      i += 1;
      paramInt >>>= 1;
    }
    return i;
  }
  
  public static int floorLog(BigInteger paramBigInteger)
  {
    BigInteger localBigInteger = ONE;
    int i = -1;
    while (localBigInteger.compareTo(paramBigInteger) <= 0)
    {
      i += 1;
      localBigInteger = localBigInteger.shiftLeft(1);
    }
    return i;
  }
  
  public static int gcd(int paramInt1, int paramInt2)
  {
    return BigInteger.valueOf(paramInt1).gcd(BigInteger.valueOf(paramInt2)).intValue();
  }
  
  public static float intRoot(int paramInt1, int paramInt2)
  {
    float f1 = paramInt1 / paramInt2;
    float f2 = 0.0F;
    while (Math.abs(f2 - f1) > 1.0E-4D)
    {
      for (;;)
      {
        f3 = floatPow(f1, paramInt2);
        if (!Float.isInfinite(f3)) {
          break;
        }
        f1 = (f1 + f2) / 2.0F;
      }
      float f3 = (f3 - paramInt1) / (paramInt2 * floatPow(f1, paramInt2 - 1));
      f2 = f1;
      f1 -= f3;
    }
    return f1;
  }
  
  public static byte[] integerToOctets(BigInteger paramBigInteger)
  {
    byte[] arrayOfByte = paramBigInteger.abs().toByteArray();
    if ((paramBigInteger.bitLength() & 0x7) != 0) {
      return arrayOfByte;
    }
    int i = paramBigInteger.bitLength() >> 3;
    paramBigInteger = new byte[i];
    System.arraycopy(arrayOfByte, 1, paramBigInteger, 0, i);
    return paramBigInteger;
  }
  
  public static boolean isIncreasing(int[] paramArrayOfInt)
  {
    int i = 1;
    while (i < paramArrayOfInt.length)
    {
      int j = i - 1;
      if (paramArrayOfInt[j] >= paramArrayOfInt[i])
      {
        PrintStream localPrintStream = System.out;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("a[");
        localStringBuilder.append(j);
        localStringBuilder.append("] = ");
        localStringBuilder.append(paramArrayOfInt[j]);
        localStringBuilder.append(" >= ");
        localStringBuilder.append(paramArrayOfInt[i]);
        localStringBuilder.append(" = a[");
        localStringBuilder.append(i);
        localStringBuilder.append("]");
        localPrintStream.println(localStringBuilder.toString());
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static int isPower(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0) {
      return -1;
    }
    int j = 0;
    int i = paramInt1;
    paramInt1 = j;
    while (i > 1)
    {
      if (i % paramInt2 != 0) {
        return -1;
      }
      i /= paramInt2;
      paramInt1 += 1;
    }
    return paramInt1;
  }
  
  public static boolean isPrime(int paramInt)
  {
    if (paramInt < 2) {
      return false;
    }
    if (paramInt == 2) {
      return true;
    }
    if ((paramInt & 0x1) == 0) {
      return false;
    }
    if (paramInt < 42)
    {
      int i = 0;
      for (;;)
      {
        int[] arrayOfInt = SMALL_PRIMES;
        if (i >= arrayOfInt.length) {
          break;
        }
        if (paramInt == arrayOfInt[i]) {
          return true;
        }
        i += 1;
      }
    }
    if ((paramInt % 3 != 0) && (paramInt % 5 != 0) && (paramInt % 7 != 0) && (paramInt % 11 != 0) && (paramInt % 13 != 0) && (paramInt % 17 != 0) && (paramInt % 19 != 0) && (paramInt % 23 != 0) && (paramInt % 29 != 0) && (paramInt % 31 != 0) && (paramInt % 37 != 0))
    {
      if (paramInt % 41 == 0) {
        return false;
      }
      return BigInteger.valueOf(paramInt).isProbablePrime(20);
    }
    return false;
  }
  
  public static int jacobi(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static BigInteger leastCommonMultiple(BigInteger[] paramArrayOfBigInteger)
  {
    int j = paramArrayOfBigInteger.length;
    BigInteger localBigInteger1 = paramArrayOfBigInteger[0];
    int i = 1;
    while (i < j)
    {
      BigInteger localBigInteger2 = localBigInteger1.gcd(paramArrayOfBigInteger[i]);
      localBigInteger1 = localBigInteger1.multiply(paramArrayOfBigInteger[i]).divide(localBigInteger2);
      i += 1;
    }
    return localBigInteger1;
  }
  
  public static int leastDiv(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = -paramInt;
    }
    if (i == 0) {
      return 1;
    }
    if ((i & 0x1) == 0) {
      return 2;
    }
    paramInt = 3;
    while (paramInt <= i / paramInt)
    {
      if (i % paramInt == 0) {
        return paramInt;
      }
      paramInt += 2;
    }
    return i;
  }
  
  public static double log(double paramDouble)
  {
    double d1 = 1.0D;
    if ((paramDouble > 0.0D) && (paramDouble < 1.0D)) {
      return -log(1.0D / paramDouble);
    }
    int i = 0;
    double d2 = paramDouble;
    while (d2 > 2.0D)
    {
      d2 /= 2.0D;
      i += 1;
      d1 *= 2.0D;
    }
    paramDouble = logBKM(paramDouble / d1);
    return i + paramDouble;
  }
  
  public static double log(long paramLong)
  {
    int i = floorLog(BigInteger.valueOf(paramLong));
    long l = 1 << i;
    double d = logBKM(paramLong / l);
    return i + d;
  }
  
  private static double logBKM(double paramDouble)
  {
    double d4 = 1.0D;
    double d2 = 0.0D;
    int i = 0;
    double d1 = 1.0D;
    while (i < 53)
    {
      double d5 = d4 * d1 + d4;
      double d3 = d2;
      if (d5 <= paramDouble)
      {
        d3 = d2 + new double[] { 1.0D, 0.5849625007211562D, 0.32192809488736235D, 0.16992500144231237D, 0.0874628412503394D, 0.044394119358453436D, 0.02236781302845451D, 0.01122725542325412D, 0.005624549193878107D, 0.0028150156070540383D, 0.0014081943928083889D, 7.042690112466433E-4D, 3.5217748030102726E-4D, 1.7609948644250602E-4D, 8.80524301221769E-5D, 4.4026886827316716E-5D, 2.2013611360340496E-5D, 1.1006847667481442E-5D, 5.503434330648604E-6D, 2.751719789561283E-6D, 1.375860550841138E-6D, 6.879304394358497E-7D, 3.4396526072176454E-7D, 1.7198264061184464E-7D, 8.599132286866321E-8D, 4.299566207501687E-8D, 2.1497831197679756E-8D, 1.0748915638882709E-8D, 5.374457829452062E-9D, 2.687228917228708E-9D, 1.3436144592400231E-9D, 6.718072297764289E-10D, 3.3590361492731876E-10D, 1.6795180747343547E-10D, 8.397590373916176E-11D, 4.1987951870191886E-11D, 2.0993975935248694E-11D, 1.0496987967662534E-11D, 5.2484939838408146E-12D, 2.624246991922794E-12D, 1.3121234959619935E-12D, 6.56061747981146E-13D, 3.2803087399061026E-13D, 1.6401543699531447E-13D, 8.200771849765956E-14D, 4.1003859248830365E-14D, 2.0501929624415328E-14D, 1.02509648122077E-14D, 5.1254824061038595E-15D, 2.5627412030519317E-15D, 1.2813706015259665E-15D, 6.406853007629834E-16D, 3.203426503814917E-16D, 1.6017132519074588E-16D, 8.008566259537294E-17D, 4.004283129768647E-17D, 2.0021415648843235E-17D, 1.0010707824421618E-17D, 5.005353912210809E-18D, 2.5026769561054044E-18D, 1.2513384780527022E-18D, 6.256692390263511E-19D, 3.1283461951317555E-19D, 1.5641730975658778E-19D, 7.820865487829389E-20D, 3.9104327439146944E-20D, 1.9552163719573472E-20D, 9.776081859786736E-21D, 4.888040929893368E-21D, 2.444020464946684E-21D, 1.222010232473342E-21D, 6.11005116236671E-22D, 3.055025581183355E-22D, 1.5275127905916775E-22D, 7.637563952958387E-23D, 3.818781976479194E-23D, 1.909390988239597E-23D, 9.546954941197984E-24D, 4.773477470598992E-24D, 2.386738735299496E-24D, 1.193369367649748E-24D, 5.96684683824874E-25D, 2.98342341912437E-25D, 1.491711709562185E-25D, 7.458558547810925E-26D, 3.7292792739054626E-26D, 1.8646396369527313E-26D, 9.323198184763657E-27D, 4.661599092381828E-27D, 2.330799546190914E-27D, 1.165399773095457E-27D, 5.826998865477285E-28D, 2.9134994327386427E-28D, 1.4567497163693213E-28D, 7.283748581846607E-29D, 3.6418742909233034E-29D, 1.8209371454616517E-29D, 9.104685727308258E-30D, 4.552342863654129E-30D, 2.2761714318270646E-30D }[i];
        d4 = d5;
      }
      d1 *= 0.5D;
      i += 1;
      d2 = d3;
    }
    return d2;
  }
  
  public static int maxPower(int paramInt)
  {
    int k = 0;
    int i = 0;
    if (paramInt != 0)
    {
      int j = 1;
      for (;;)
      {
        k = i;
        if ((paramInt & j) != 0) {
          break;
        }
        i += 1;
        j <<= 1;
      }
    }
    return k;
  }
  
  public static long mod(long paramLong1, long paramLong2)
  {
    long l = paramLong1 % paramLong2;
    paramLong1 = l;
    if (l < 0L) {
      paramLong1 = l + paramLong2;
    }
    return paramLong1;
  }
  
  public static int modInverse(int paramInt1, int paramInt2)
  {
    return BigInteger.valueOf(paramInt1).modInverse(BigInteger.valueOf(paramInt2)).intValue();
  }
  
  public static long modInverse(long paramLong1, long paramLong2)
  {
    return BigInteger.valueOf(paramLong1).modInverse(BigInteger.valueOf(paramLong2)).longValue();
  }
  
  public static int modPow(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 > 0) && (paramInt3 * paramInt3 <= Integer.MAX_VALUE) && (paramInt2 >= 0))
    {
      paramInt1 = (paramInt1 % paramInt3 + paramInt3) % paramInt3;
      int j;
      for (int i = 1; paramInt2 > 0; i = j)
      {
        j = i;
        if ((paramInt2 & 0x1) == 1) {
          j = i * paramInt1 % paramInt3;
        }
        paramInt1 = paramInt1 * paramInt1 % paramInt3;
        paramInt2 >>>= 1;
      }
      return i;
    }
    return 0;
  }
  
  public static BigInteger nextPrime(long paramLong)
  {
    if (paramLong <= 1L) {
      return BigInteger.valueOf(2L);
    }
    if (paramLong == 2L) {
      return BigInteger.valueOf(3L);
    }
    long l1 = paramLong + 1L + (paramLong & 1L);
    int i = 0;
    long l2 = 0L;
    while ((l1 <= paramLong << 1) && (i == 0))
    {
      for (long l3 = 3L; (l3 <= l1 >> 1) && (i == 0); l3 += 2L) {
        if (l1 % l3 == 0L) {
          i = 1;
        }
      }
      if (i == 0) {
        l2 = l1;
      }
      i ^= 0x1;
      l1 += 2L;
    }
    return BigInteger.valueOf(l2);
  }
  
  public static BigInteger nextProbablePrime(BigInteger paramBigInteger)
  {
    return nextProbablePrime(paramBigInteger, 20);
  }
  
  public static BigInteger nextProbablePrime(BigInteger paramBigInteger, int paramInt)
  {
    if ((paramBigInteger.signum() >= 0) && (paramBigInteger.signum() != 0) && (!paramBigInteger.equals(ONE)))
    {
      Object localObject = paramBigInteger.add(ONE);
      paramBigInteger = (BigInteger)localObject;
      if (!((BigInteger)localObject).testBit(0))
      {
        BigInteger localBigInteger = ONE;
        paramBigInteger = (BigInteger)localObject;
        localObject = localBigInteger;
        paramBigInteger = paramBigInteger.add((BigInteger)localObject);
      }
      if (paramBigInteger.bitLength() > 6)
      {
        long l = paramBigInteger.remainder(BigInteger.valueOf(152125131763605L)).longValue();
        if ((l % 3L != 0L) && (l % 5L != 0L) && (l % 7L != 0L) && (l % 11L != 0L) && (l % 13L != 0L) && (l % 17L != 0L) && (l % 19L != 0L) && (l % 23L != 0L) && (l % 29L != 0L) && (l % 31L != 0L) && (l % 37L != 0L) && (l % 41L != 0L)) {}
      }
      do
      {
        localObject = TWO;
        break;
        if (paramBigInteger.bitLength() < 4) {
          return paramBigInteger;
        }
      } while (!paramBigInteger.isProbablePrime(paramInt));
      return paramBigInteger;
    }
    return TWO;
  }
  
  public static int nextSmallerPrime(int paramInt)
  {
    if (paramInt <= 2) {
      return 1;
    }
    if (paramInt == 3) {
      return 2;
    }
    int i = paramInt;
    if ((paramInt & 0x1) == 0) {
      paramInt -= 1;
    }
    for (;;)
    {
      paramInt = i - 2;
      if (paramInt > 3) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i & (isPrime(paramInt) ^ true)) == 0) {
        break;
      }
      i = paramInt;
    }
    return paramInt;
  }
  
  public static BigInteger octetsToInteger(byte[] paramArrayOfByte)
  {
    return octetsToInteger(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static BigInteger octetsToInteger(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2 + 1];
    arrayOfByte[0] = 0;
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 1, paramInt2);
    return new BigInteger(arrayOfByte);
  }
  
  public static int order(int paramInt1, int paramInt2)
  {
    int i = paramInt1 % paramInt2;
    if (i != 0)
    {
      int j = 1;
      while (i != 1)
      {
        int k = i * paramInt1 % paramInt2;
        i = k;
        if (k < 0) {
          i = k + paramInt2;
        }
        j += 1;
      }
      return j;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" is not an element of Z/(");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("Z)^*; it is not meaningful to compute its order.");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static boolean passesSmallPrimeTest(BigInteger paramBigInteger)
  {
    int i = 0;
    while (i < 239)
    {
      if (paramBigInteger.mod(BigInteger.valueOf(new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997, 1009, 1013, 1019, 1021, 1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069, 1087, 1091, 1093, 1097, 1103, 1109, 1117, 1123, 1129, 1151, 1153, 1163, 1171, 1181, 1187, 1193, 1201, 1213, 1217, 1223, 1229, 1231, 1237, 1249, 1259, 1277, 1279, 1283, 1289, 1291, 1297, 1301, 1303, 1307, 1319, 1321, 1327, 1361, 1367, 1373, 1381, 1399, 1409, 1423, 1427, 1429, 1433, 1439, 1447, 1451, 1453, 1459, 1471, 1481, 1483, 1487, 1489, 1493, 1499 }[i])).equals(ZERO)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static int pow(int paramInt1, int paramInt2)
  {
    int j;
    for (int i = 1; paramInt2 > 0; i = j)
    {
      j = i;
      if ((paramInt2 & 0x1) == 1) {
        j = i * paramInt1;
      }
      paramInt1 *= paramInt1;
      paramInt2 >>>= 1;
    }
    return i;
  }
  
  public static long pow(long paramLong, int paramInt)
  {
    long l2;
    for (long l1 = 1L; paramInt > 0; l1 = l2)
    {
      l2 = l1;
      if ((paramInt & 0x1) == 1) {
        l2 = l1 * paramLong;
      }
      paramLong *= paramLong;
      paramInt >>>= 1;
    }
    return l1;
  }
  
  public static BigInteger randomize(BigInteger paramBigInteger)
  {
    if (sr == null) {
      sr = new SecureRandom();
    }
    return randomize(paramBigInteger, sr);
  }
  
  public static BigInteger randomize(BigInteger paramBigInteger, SecureRandom paramSecureRandom)
  {
    int j = paramBigInteger.bitLength();
    BigInteger localBigInteger = BigInteger.valueOf(0L);
    SecureRandom localSecureRandom = paramSecureRandom;
    if (paramSecureRandom == null)
    {
      localSecureRandom = sr;
      if (localSecureRandom == null) {
        localSecureRandom = new SecureRandom();
      }
    }
    int i = 0;
    paramSecureRandom = localBigInteger;
    while (i < 20)
    {
      paramSecureRandom = new BigInteger(j, localSecureRandom);
      if (paramSecureRandom.compareTo(paramBigInteger) < 0) {
        return paramSecureRandom;
      }
      i += 1;
    }
    return paramSecureRandom.mod(paramBigInteger);
  }
  
  public static BigInteger reduceInto(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
  {
    return paramBigInteger1.subtract(paramBigInteger2).mod(paramBigInteger3.subtract(paramBigInteger2)).add(paramBigInteger2);
  }
  
  public static BigInteger ressol(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
    throws IllegalArgumentException
  {
    BigInteger localBigInteger1;
    if (paramBigInteger1.compareTo(ZERO) < 0) {
      localBigInteger1 = paramBigInteger1.add(paramBigInteger2);
    } else {
      localBigInteger1 = paramBigInteger1;
    }
    if (localBigInteger1.equals(ZERO)) {
      return ZERO;
    }
    if (paramBigInteger2.equals(TWO)) {
      return localBigInteger1;
    }
    if ((paramBigInteger2.testBit(0)) && (paramBigInteger2.testBit(1)))
    {
      if (jacobi(localBigInteger1, paramBigInteger2) == 1) {
        return localBigInteger1.modPow(paramBigInteger2.add(ONE).shiftRight(2), paramBigInteger2);
      }
      paramBigInteger1 = new StringBuilder();
      paramBigInteger1.append("No quadratic residue: ");
      paramBigInteger1.append(localBigInteger1);
      paramBigInteger1.append(", ");
      paramBigInteger1.append(paramBigInteger2);
      throw new IllegalArgumentException(paramBigInteger1.toString());
    }
    paramBigInteger1 = paramBigInteger2.subtract(ONE);
    long l1 = 0L;
    while (!paramBigInteger1.testBit(0))
    {
      l1 += 1L;
      paramBigInteger1 = paramBigInteger1.shiftRight(1);
    }
    BigInteger localBigInteger3 = paramBigInteger1.subtract(ONE).shiftRight(1);
    paramBigInteger1 = localBigInteger1.modPow(localBigInteger3, paramBigInteger2);
    Object localObject = paramBigInteger1.multiply(paramBigInteger1).remainder(paramBigInteger2).multiply(localBigInteger1).remainder(paramBigInteger2);
    BigInteger localBigInteger2 = paramBigInteger1.multiply(localBigInteger1).remainder(paramBigInteger2);
    if (((BigInteger)localObject).equals(ONE)) {
      return localBigInteger2;
    }
    for (paramBigInteger1 = TWO; jacobi(paramBigInteger1, paramBigInteger2) == 1; paramBigInteger1 = paramBigInteger1.add(ONE)) {}
    localBigInteger3 = paramBigInteger1.modPow(localBigInteger3.multiply(TWO).add(ONE), paramBigInteger2);
    paramBigInteger1 = (BigInteger)localObject;
    long l2 = l1;
    localObject = localBigInteger2;
    localBigInteger2 = localBigInteger3;
    while (paramBigInteger1.compareTo(ONE) == 1)
    {
      localBigInteger3 = paramBigInteger1;
      for (l1 = 0L; !localBigInteger3.equals(ONE); l1 += 1L) {
        localBigInteger3 = localBigInteger3.multiply(localBigInteger3).mod(paramBigInteger2);
      }
      long l3 = l2 - l1;
      if (l3 != 0L)
      {
        localBigInteger3 = ONE;
        for (l2 = 0L; l2 < l3 - 1L; l2 += 1L) {
          localBigInteger3 = localBigInteger3.shiftLeft(1);
        }
        localBigInteger2 = localBigInteger2.modPow(localBigInteger3, paramBigInteger2);
        localObject = ((BigInteger)localObject).multiply(localBigInteger2).remainder(paramBigInteger2);
        localBigInteger2 = localBigInteger2.multiply(localBigInteger2).remainder(paramBigInteger2);
        paramBigInteger1 = paramBigInteger1.multiply(localBigInteger2).mod(paramBigInteger2);
        l2 = l1;
      }
      else
      {
        paramBigInteger1 = new StringBuilder();
        paramBigInteger1.append("No quadratic residue: ");
        paramBigInteger1.append(localBigInteger1);
        paramBigInteger1.append(", ");
        paramBigInteger1.append(paramBigInteger2);
        throw new IllegalArgumentException(paramBigInteger1.toString());
      }
    }
    return (BigInteger)localObject;
  }
  
  public static BigInteger squareRoot(BigInteger paramBigInteger)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:539)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\IntegerFunctions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */