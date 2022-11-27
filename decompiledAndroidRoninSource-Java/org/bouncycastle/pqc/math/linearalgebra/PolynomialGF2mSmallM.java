package org.bouncycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;

public class PolynomialGF2mSmallM
{
  public static final char RANDOM_IRREDUCIBLE_POLYNOMIAL = 'I';
  private int[] coefficients;
  private int degree;
  private GF2mField field;
  
  public PolynomialGF2mSmallM(GF2mField paramGF2mField)
  {
    this.field = paramGF2mField;
    this.degree = -1;
    this.coefficients = new int[1];
  }
  
  public PolynomialGF2mSmallM(GF2mField paramGF2mField, int paramInt)
  {
    this.field = paramGF2mField;
    this.degree = paramInt;
    paramGF2mField = new int[paramInt + 1];
    this.coefficients = paramGF2mField;
    paramGF2mField[paramInt] = 1;
  }
  
  public PolynomialGF2mSmallM(GF2mField paramGF2mField, int paramInt, char paramChar, SecureRandom paramSecureRandom)
  {
    this.field = paramGF2mField;
    if (paramChar == 'I')
    {
      this.coefficients = createRandomIrreduciblePolynomial(paramInt, paramSecureRandom);
      computeDegree();
      return;
    }
    paramGF2mField = new StringBuilder();
    paramGF2mField.append(" Error: type ");
    paramGF2mField.append(paramChar);
    paramGF2mField.append(" is not defined for GF2smallmPolynomial");
    throw new IllegalArgumentException(paramGF2mField.toString());
  }
  
  public PolynomialGF2mSmallM(GF2mField paramGF2mField, byte[] paramArrayOfByte)
  {
    this.field = paramGF2mField;
    int i = 8;
    int j = 1;
    while (paramGF2mField.getDegree() > i)
    {
      j += 1;
      i += 8;
    }
    if (paramArrayOfByte.length % j == 0)
    {
      this.coefficients = new int[paramArrayOfByte.length / j];
      j = 0;
      int k = 0;
      for (;;)
      {
        paramGF2mField = this.coefficients;
        if (j >= paramGF2mField.length) {
          break label164;
        }
        int m = 0;
        while (m < i)
        {
          paramGF2mField = this.coefficients;
          int n = paramGF2mField[j];
          paramGF2mField[j] = ((paramArrayOfByte[k] & 0xFF) << m ^ n);
          m += 8;
          k += 1;
        }
        if (!this.field.isElementOfThisField(this.coefficients[j])) {
          break;
        }
        j += 1;
      }
      throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
      label164:
      if ((paramGF2mField.length != 1) && (paramGF2mField[(paramGF2mField.length - 1)] == 0)) {
        throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
      }
      computeDegree();
      return;
    }
    throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
  }
  
  public PolynomialGF2mSmallM(GF2mField paramGF2mField, int[] paramArrayOfInt)
  {
    this.field = paramGF2mField;
    this.coefficients = normalForm(paramArrayOfInt);
    computeDegree();
  }
  
  public PolynomialGF2mSmallM(GF2mVector paramGF2mVector)
  {
    this(paramGF2mVector.getField(), paramGF2mVector.getIntArrayForm());
  }
  
  public PolynomialGF2mSmallM(PolynomialGF2mSmallM paramPolynomialGF2mSmallM)
  {
    this.field = paramPolynomialGF2mSmallM.field;
    this.degree = paramPolynomialGF2mSmallM.degree;
    this.coefficients = IntUtils.clone(paramPolynomialGF2mSmallM.coefficients);
  }
  
  private int[] add(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt;
    if (paramArrayOfInt1.length < paramArrayOfInt2.length)
    {
      arrayOfInt = new int[paramArrayOfInt2.length];
      System.arraycopy(paramArrayOfInt2, 0, arrayOfInt, 0, paramArrayOfInt2.length);
      paramArrayOfInt2 = arrayOfInt;
    }
    else
    {
      arrayOfInt = new int[paramArrayOfInt1.length];
      System.arraycopy(paramArrayOfInt1, 0, arrayOfInt, 0, paramArrayOfInt1.length);
      paramArrayOfInt1 = paramArrayOfInt2;
      paramArrayOfInt2 = arrayOfInt;
    }
    int i = paramArrayOfInt1.length - 1;
    while (i >= 0)
    {
      paramArrayOfInt2[i] = this.field.add(paramArrayOfInt2[i], paramArrayOfInt1[i]);
      i -= 1;
    }
    return paramArrayOfInt2;
  }
  
  private static int computeDegree(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length - 1;
    while ((i >= 0) && (paramArrayOfInt[i] == 0)) {
      i -= 1;
    }
    return i;
  }
  
  private void computeDegree()
  {
    int i = this.coefficients.length;
    do
    {
      this.degree = (i - 1);
      i = this.degree;
    } while ((i >= 0) && (this.coefficients[i] == 0));
  }
  
  private int[] createRandomIrreduciblePolynomial(int paramInt, SecureRandom paramSecureRandom)
  {
    int[] arrayOfInt = new int[paramInt + 1];
    int i = 1;
    arrayOfInt[paramInt] = 1;
    arrayOfInt[0] = this.field.getRandomNonZeroElement(paramSecureRandom);
    while (i < paramInt)
    {
      arrayOfInt[i] = this.field.getRandomElement(paramSecureRandom);
      i += 1;
    }
    while (!isIrreducible(arrayOfInt))
    {
      i = RandUtils.nextInt(paramSecureRandom, paramInt);
      if (i == 0) {
        arrayOfInt[0] = this.field.getRandomNonZeroElement(paramSecureRandom);
      } else {
        arrayOfInt[i] = this.field.getRandomElement(paramSecureRandom);
      }
    }
    return arrayOfInt;
  }
  
  private int[][] div(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = computeDegree(paramArrayOfInt2);
    int j = computeDegree(paramArrayOfInt1);
    if (i != -1)
    {
      int[][] arrayOfInt = new int[2][];
      arrayOfInt[0] = new int[1];
      arrayOfInt[1] = new int[j + 1];
      j = headCoefficient(paramArrayOfInt2);
      j = this.field.inverse(j);
      arrayOfInt[0][0] = 0;
      System.arraycopy(paramArrayOfInt1, 0, arrayOfInt[1], 0, arrayOfInt[1].length);
      while (i <= computeDegree(arrayOfInt[1]))
      {
        paramArrayOfInt1 = new int[1];
        paramArrayOfInt1[0] = this.field.mult(headCoefficient(arrayOfInt[1]), j);
        int[] arrayOfInt1 = multWithElement(paramArrayOfInt2, paramArrayOfInt1[0]);
        int k = computeDegree(arrayOfInt[1]) - i;
        arrayOfInt1 = multWithMonomial(arrayOfInt1, k);
        arrayOfInt[0] = add(multWithMonomial(paramArrayOfInt1, k), arrayOfInt[0]);
        arrayOfInt[1] = add(arrayOfInt1, arrayOfInt[1]);
      }
      return arrayOfInt;
    }
    throw new ArithmeticException("Division by zero.");
  }
  
  private int[] gcd(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt2 = paramArrayOfInt1;
    int[] arrayOfInt1 = paramArrayOfInt2;
    if (computeDegree(paramArrayOfInt1) == -1) {
      return paramArrayOfInt2;
    }
    while (computeDegree(arrayOfInt1) != -1)
    {
      paramArrayOfInt1 = mod(arrayOfInt2, arrayOfInt1);
      int i = arrayOfInt1.length;
      arrayOfInt2 = new int[i];
      System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, i);
      i = paramArrayOfInt1.length;
      arrayOfInt1 = new int[i];
      System.arraycopy(paramArrayOfInt1, 0, arrayOfInt1, 0, i);
    }
    return multWithElement(arrayOfInt2, this.field.inverse(headCoefficient(arrayOfInt2)));
  }
  
  private static int headCoefficient(int[] paramArrayOfInt)
  {
    int i = computeDegree(paramArrayOfInt);
    if (i == -1) {
      return 0;
    }
    return paramArrayOfInt[i];
  }
  
  private static boolean isEqual(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int j = computeDegree(paramArrayOfInt1);
    if (j != computeDegree(paramArrayOfInt2)) {
      return false;
    }
    int i = 0;
    while (i <= j)
    {
      if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private boolean isIrreducible(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt[0] == 0) {
      return false;
    }
    int k = computeDegree(paramArrayOfInt);
    int[] arrayOfInt = new int[2];
    int[] tmp21_19 = arrayOfInt;
    tmp21_19[0] = 0;
    int[] tmp25_21 = tmp21_19;
    tmp25_21[1] = 1;
    tmp25_21;
    int m = this.field.getDegree();
    int i = 0;
    while (i < k >> 1)
    {
      int j = m - 1;
      while (j >= 0)
      {
        arrayOfInt = modMultiply(arrayOfInt, arrayOfInt, paramArrayOfInt);
        j -= 1;
      }
      arrayOfInt = normalForm(arrayOfInt);
      if (computeDegree(gcd(add(arrayOfInt, new int[] { 0, 1 }), paramArrayOfInt)) != 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private int[] mod(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = computeDegree(paramArrayOfInt2);
    if (i != -1)
    {
      int j = paramArrayOfInt1.length;
      int[] arrayOfInt = new int[j];
      int k = headCoefficient(paramArrayOfInt2);
      k = this.field.inverse(k);
      System.arraycopy(paramArrayOfInt1, 0, arrayOfInt, 0, j);
      for (paramArrayOfInt1 = arrayOfInt; i <= computeDegree(paramArrayOfInt1); paramArrayOfInt1 = add(multWithElement(multWithMonomial(paramArrayOfInt2, computeDegree(paramArrayOfInt1) - i), j), paramArrayOfInt1)) {
        j = this.field.mult(headCoefficient(paramArrayOfInt1), k);
      }
      return paramArrayOfInt1;
    }
    throw new ArithmeticException("Division by zero");
  }
  
  private int[] modDiv(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int[] arrayOfInt2 = normalForm(paramArrayOfInt3);
    int[] arrayOfInt1 = mod(paramArrayOfInt2, paramArrayOfInt3);
    paramArrayOfInt2 = new int[1];
    paramArrayOfInt2[0] = 0;
    Object localObject;
    for (paramArrayOfInt1 = mod(paramArrayOfInt1, paramArrayOfInt3); computeDegree(arrayOfInt1) != -1; paramArrayOfInt1 = normalForm((int[])localObject))
    {
      localObject = div(arrayOfInt2, arrayOfInt1);
      arrayOfInt2 = normalForm(arrayOfInt1);
      arrayOfInt1 = normalForm(localObject[1]);
      localObject = add(paramArrayOfInt2, modMultiply(localObject[0], paramArrayOfInt1, paramArrayOfInt3));
      paramArrayOfInt2 = normalForm(paramArrayOfInt1);
    }
    int i = headCoefficient(arrayOfInt2);
    return multWithElement(paramArrayOfInt2, this.field.inverse(i));
  }
  
  private int[] modMultiply(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    return mod(multiply(paramArrayOfInt1, paramArrayOfInt2), paramArrayOfInt3);
  }
  
  private int[] multWithElement(int[] paramArrayOfInt, int paramInt)
  {
    int i = computeDegree(paramArrayOfInt);
    if ((i != -1) && (paramInt != 0))
    {
      if (paramInt == 1) {
        return IntUtils.clone(paramArrayOfInt);
      }
      int[] arrayOfInt = new int[i + 1];
      while (i >= 0)
      {
        arrayOfInt[i] = this.field.mult(paramArrayOfInt[i], paramInt);
        i -= 1;
      }
      return arrayOfInt;
    }
    return new int[1];
  }
  
  private static int[] multWithMonomial(int[] paramArrayOfInt, int paramInt)
  {
    int i = computeDegree(paramArrayOfInt);
    if (i == -1) {
      return new int[1];
    }
    int[] arrayOfInt = new int[i + paramInt + 1];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, paramInt, i + 1);
    return arrayOfInt;
  }
  
  private int[] multiply(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt2 = paramArrayOfInt1;
    int[] arrayOfInt1 = paramArrayOfInt2;
    if (computeDegree(paramArrayOfInt1) < computeDegree(paramArrayOfInt2))
    {
      arrayOfInt1 = paramArrayOfInt1;
      arrayOfInt2 = paramArrayOfInt2;
    }
    paramArrayOfInt1 = normalForm(arrayOfInt2);
    arrayOfInt2 = normalForm(arrayOfInt1);
    if (arrayOfInt2.length == 1) {
      return multWithElement(paramArrayOfInt1, arrayOfInt2[0]);
    }
    int i = paramArrayOfInt1.length;
    int j = arrayOfInt2.length;
    paramArrayOfInt2 = new int[i + j - 1];
    if (j != i)
    {
      paramArrayOfInt2 = new int[j];
      i -= j;
      arrayOfInt1 = new int[i];
      System.arraycopy(paramArrayOfInt1, 0, paramArrayOfInt2, 0, j);
      System.arraycopy(paramArrayOfInt1, j, arrayOfInt1, 0, i);
      return add(multiply(paramArrayOfInt2, arrayOfInt2), multWithMonomial(multiply(arrayOfInt1, arrayOfInt2), j));
    }
    j = i + 1 >>> 1;
    i -= j;
    int[] arrayOfInt3 = new int[j];
    int[] arrayOfInt4 = new int[j];
    paramArrayOfInt2 = new int[i];
    arrayOfInt1 = new int[i];
    System.arraycopy(paramArrayOfInt1, 0, arrayOfInt3, 0, j);
    System.arraycopy(paramArrayOfInt1, j, paramArrayOfInt2, 0, i);
    System.arraycopy(arrayOfInt2, 0, arrayOfInt4, 0, j);
    System.arraycopy(arrayOfInt2, j, arrayOfInt1, 0, i);
    paramArrayOfInt1 = add(arrayOfInt3, paramArrayOfInt2);
    arrayOfInt2 = add(arrayOfInt4, arrayOfInt1);
    arrayOfInt3 = multiply(arrayOfInt3, arrayOfInt4);
    paramArrayOfInt1 = multiply(paramArrayOfInt1, arrayOfInt2);
    try
    {
      paramArrayOfInt2 = multiply(paramArrayOfInt2, arrayOfInt1);
      return add(multWithMonomial(add(add(add(paramArrayOfInt1, arrayOfInt3), paramArrayOfInt2), multWithMonomial(paramArrayOfInt2, j)), j), arrayOfInt3);
    }
    finally {}
  }
  
  private static int[] normalForm(int[] paramArrayOfInt)
  {
    int j = computeDegree(paramArrayOfInt);
    if (j == -1) {
      return new int[1];
    }
    int i = paramArrayOfInt.length;
    j += 1;
    if (i == j) {
      return IntUtils.clone(paramArrayOfInt);
    }
    int[] arrayOfInt = new int[j];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, j);
    return arrayOfInt;
  }
  
  public PolynomialGF2mSmallM add(PolynomialGF2mSmallM paramPolynomialGF2mSmallM)
  {
    paramPolynomialGF2mSmallM = add(this.coefficients, paramPolynomialGF2mSmallM.coefficients);
    return new PolynomialGF2mSmallM(this.field, paramPolynomialGF2mSmallM);
  }
  
  public PolynomialGF2mSmallM addMonomial(int paramInt)
  {
    int[] arrayOfInt = new int[paramInt + 1];
    arrayOfInt[paramInt] = 1;
    arrayOfInt = add(this.coefficients, arrayOfInt);
    return new PolynomialGF2mSmallM(this.field, arrayOfInt);
  }
  
  public void addToThis(PolynomialGF2mSmallM paramPolynomialGF2mSmallM)
  {
    this.coefficients = add(this.coefficients, paramPolynomialGF2mSmallM.coefficients);
    computeDegree();
  }
  
  public PolynomialGF2mSmallM[] div(PolynomialGF2mSmallM paramPolynomialGF2mSmallM)
  {
    paramPolynomialGF2mSmallM = div(this.coefficients, paramPolynomialGF2mSmallM.coefficients);
    return new PolynomialGF2mSmallM[] { new PolynomialGF2mSmallM(this.field, paramPolynomialGF2mSmallM[0]), new PolynomialGF2mSmallM(this.field, paramPolynomialGF2mSmallM[1]) };
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof PolynomialGF2mSmallM)) {
        return false;
      }
      paramObject = (PolynomialGF2mSmallM)paramObject;
      if ((this.field.equals(((PolynomialGF2mSmallM)paramObject).field)) && (this.degree == ((PolynomialGF2mSmallM)paramObject).degree) && (isEqual(this.coefficients, ((PolynomialGF2mSmallM)paramObject).coefficients))) {
        return true;
      }
    }
    return false;
  }
  
  public int evaluateAt(int paramInt)
  {
    int[] arrayOfInt = this.coefficients;
    int i = this.degree;
    int j = arrayOfInt[i];
    i -= 1;
    while (i >= 0)
    {
      j = this.field.mult(j, paramInt) ^ this.coefficients[i];
      i -= 1;
    }
    return j;
  }
  
  public PolynomialGF2mSmallM gcd(PolynomialGF2mSmallM paramPolynomialGF2mSmallM)
  {
    paramPolynomialGF2mSmallM = gcd(this.coefficients, paramPolynomialGF2mSmallM.coefficients);
    return new PolynomialGF2mSmallM(this.field, paramPolynomialGF2mSmallM);
  }
  
  public int getCoefficient(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.degree)) {
      return this.coefficients[paramInt];
    }
    return 0;
  }
  
  public int getDegree()
  {
    int[] arrayOfInt = this.coefficients;
    int i = arrayOfInt.length - 1;
    if (arrayOfInt[i] == 0) {
      return -1;
    }
    return i;
  }
  
  public byte[] getEncoded()
  {
    int i = 8;
    int j = 1;
    while (this.field.getDegree() > i)
    {
      j += 1;
      i += 8;
    }
    byte[] arrayOfByte = new byte[this.coefficients.length * j];
    j = 0;
    int k = 0;
    while (j < this.coefficients.length)
    {
      int m = 0;
      while (m < i)
      {
        arrayOfByte[k] = ((byte)(this.coefficients[j] >>> m));
        m += 8;
        k += 1;
      }
      j += 1;
    }
    return arrayOfByte;
  }
  
  public int getHeadCoefficient()
  {
    int i = this.degree;
    if (i == -1) {
      return 0;
    }
    return this.coefficients[i];
  }
  
  public int hashCode()
  {
    int j = this.field.hashCode();
    int i = 0;
    for (;;)
    {
      int[] arrayOfInt = this.coefficients;
      if (i >= arrayOfInt.length) {
        break;
      }
      j = j * 31 + arrayOfInt[i];
      i += 1;
    }
    return j;
  }
  
  public PolynomialGF2mSmallM mod(PolynomialGF2mSmallM paramPolynomialGF2mSmallM)
  {
    paramPolynomialGF2mSmallM = mod(this.coefficients, paramPolynomialGF2mSmallM.coefficients);
    return new PolynomialGF2mSmallM(this.field, paramPolynomialGF2mSmallM);
  }
  
  public PolynomialGF2mSmallM modDiv(PolynomialGF2mSmallM paramPolynomialGF2mSmallM1, PolynomialGF2mSmallM paramPolynomialGF2mSmallM2)
  {
    paramPolynomialGF2mSmallM1 = modDiv(this.coefficients, paramPolynomialGF2mSmallM1.coefficients, paramPolynomialGF2mSmallM2.coefficients);
    return new PolynomialGF2mSmallM(this.field, paramPolynomialGF2mSmallM1);
  }
  
  public PolynomialGF2mSmallM modInverse(PolynomialGF2mSmallM paramPolynomialGF2mSmallM)
  {
    int[] arrayOfInt = this.coefficients;
    paramPolynomialGF2mSmallM = paramPolynomialGF2mSmallM.coefficients;
    paramPolynomialGF2mSmallM = modDiv(new int[] { 1 }, arrayOfInt, paramPolynomialGF2mSmallM);
    return new PolynomialGF2mSmallM(this.field, paramPolynomialGF2mSmallM);
  }
  
  public PolynomialGF2mSmallM modMultiply(PolynomialGF2mSmallM paramPolynomialGF2mSmallM1, PolynomialGF2mSmallM paramPolynomialGF2mSmallM2)
  {
    paramPolynomialGF2mSmallM1 = modMultiply(this.coefficients, paramPolynomialGF2mSmallM1.coefficients, paramPolynomialGF2mSmallM2.coefficients);
    return new PolynomialGF2mSmallM(this.field, paramPolynomialGF2mSmallM1);
  }
  
  public PolynomialGF2mSmallM[] modPolynomialToFracton(PolynomialGF2mSmallM paramPolynomialGF2mSmallM)
  {
    int i = paramPolynomialGF2mSmallM.degree;
    Object localObject1 = normalForm(paramPolynomialGF2mSmallM.coefficients);
    int[] arrayOfInt = mod(this.coefficients, paramPolynomialGF2mSmallM.coefficients);
    Object localObject3 = { 0 };
    Object localObject2 = { 1 };
    Object localObject4 = localObject1;
    for (localObject1 = arrayOfInt; computeDegree((int[])localObject1) > i >> 1; localObject1 = arrayOfInt)
    {
      localObject4 = div((int[])localObject4, (int[])localObject1);
      arrayOfInt = localObject4[1];
      localObject4 = add((int[])localObject3, modMultiply(localObject4[0], (int[])localObject2, paramPolynomialGF2mSmallM.coefficients));
      localObject3 = localObject2;
      localObject2 = localObject4;
      localObject4 = localObject1;
    }
    return new PolynomialGF2mSmallM[] { new PolynomialGF2mSmallM(this.field, (int[])localObject1), new PolynomialGF2mSmallM(this.field, (int[])localObject2) };
  }
  
  public PolynomialGF2mSmallM modSquareMatrix(PolynomialGF2mSmallM[] paramArrayOfPolynomialGF2mSmallM)
  {
    int k = paramArrayOfPolynomialGF2mSmallM.length;
    int[] arrayOfInt1 = new int[k];
    int[] arrayOfInt2 = new int[k];
    int i = 0;
    for (;;)
    {
      int[] arrayOfInt3 = this.coefficients;
      if (i >= arrayOfInt3.length) {
        break;
      }
      arrayOfInt2[i] = this.field.mult(arrayOfInt3[i], arrayOfInt3[i]);
      i += 1;
    }
    i = 0;
    while (i < k)
    {
      int j = 0;
      while (j < k)
      {
        if (i < paramArrayOfPolynomialGF2mSmallM[j].coefficients.length)
        {
          int m = this.field.mult(paramArrayOfPolynomialGF2mSmallM[j].coefficients[i], arrayOfInt2[j]);
          arrayOfInt1[i] = this.field.add(arrayOfInt1[i], m);
        }
        j += 1;
      }
      i += 1;
    }
    return new PolynomialGF2mSmallM(this.field, arrayOfInt1);
  }
  
  public PolynomialGF2mSmallM modSquareRoot(PolynomialGF2mSmallM paramPolynomialGF2mSmallM)
  {
    int[] arrayOfInt1 = IntUtils.clone(this.coefficients);
    for (int[] arrayOfInt2 = modMultiply(arrayOfInt1, arrayOfInt1, paramPolynomialGF2mSmallM.coefficients); !isEqual(arrayOfInt2, this.coefficients); arrayOfInt2 = modMultiply(arrayOfInt1, arrayOfInt1, paramPolynomialGF2mSmallM.coefficients)) {
      arrayOfInt1 = normalForm(arrayOfInt2);
    }
    return new PolynomialGF2mSmallM(this.field, arrayOfInt1);
  }
  
  public PolynomialGF2mSmallM modSquareRootMatrix(PolynomialGF2mSmallM[] paramArrayOfPolynomialGF2mSmallM)
  {
    int m = paramArrayOfPolynomialGF2mSmallM.length;
    int[] arrayOfInt1 = new int[m];
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      j = 0;
      while (j < m)
      {
        if (i < paramArrayOfPolynomialGF2mSmallM[j].coefficients.length)
        {
          int[] arrayOfInt2 = this.coefficients;
          if (j < arrayOfInt2.length)
          {
            int n = this.field.mult(paramArrayOfPolynomialGF2mSmallM[j].coefficients[i], arrayOfInt2[j]);
            arrayOfInt1[i] = this.field.add(arrayOfInt1[i], n);
          }
        }
        j += 1;
      }
      i += 1;
    }
    while (j < m)
    {
      arrayOfInt1[j] = this.field.sqRoot(arrayOfInt1[j]);
      j += 1;
    }
    return new PolynomialGF2mSmallM(this.field, arrayOfInt1);
  }
  
  public void multThisWithElement(int paramInt)
  {
    if (this.field.isElementOfThisField(paramInt))
    {
      this.coefficients = multWithElement(this.coefficients, paramInt);
      computeDegree();
      return;
    }
    throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
  }
  
  public PolynomialGF2mSmallM multWithElement(int paramInt)
  {
    if (this.field.isElementOfThisField(paramInt))
    {
      int[] arrayOfInt = multWithElement(this.coefficients, paramInt);
      return new PolynomialGF2mSmallM(this.field, arrayOfInt);
    }
    throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
  }
  
  public PolynomialGF2mSmallM multWithMonomial(int paramInt)
  {
    int[] arrayOfInt = multWithMonomial(this.coefficients, paramInt);
    return new PolynomialGF2mSmallM(this.field, arrayOfInt);
  }
  
  public PolynomialGF2mSmallM multiply(PolynomialGF2mSmallM paramPolynomialGF2mSmallM)
  {
    paramPolynomialGF2mSmallM = multiply(this.coefficients, paramPolynomialGF2mSmallM.coefficients);
    return new PolynomialGF2mSmallM(this.field, paramPolynomialGF2mSmallM);
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" Polynomial over ");
    ((StringBuilder)localObject).append(this.field.toString());
    ((StringBuilder)localObject).append(": \n");
    localObject = ((StringBuilder)localObject).toString();
    int i = 0;
    while (i < this.coefficients.length)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(this.field.elementToStr(this.coefficients[i]));
      localStringBuilder.append("Y^");
      localStringBuilder.append(i);
      localStringBuilder.append("+");
      localObject = localStringBuilder.toString();
      i += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(";");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\PolynomialGF2mSmallM.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */