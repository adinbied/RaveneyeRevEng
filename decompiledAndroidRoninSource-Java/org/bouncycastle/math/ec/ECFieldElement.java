package org.bouncycastle.math.ec;

import java.math.BigInteger;
import java.util.Random;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

public abstract class ECFieldElement
  implements ECConstants
{
  public abstract ECFieldElement add(ECFieldElement paramECFieldElement);
  
  public abstract ECFieldElement addOne();
  
  public int bitLength()
  {
    return toBigInteger().bitLength();
  }
  
  public abstract ECFieldElement divide(ECFieldElement paramECFieldElement);
  
  public byte[] getEncoded()
  {
    return BigIntegers.asUnsignedByteArray((getFieldSize() + 7) / 8, toBigInteger());
  }
  
  public abstract String getFieldName();
  
  public abstract int getFieldSize();
  
  public abstract ECFieldElement invert();
  
  public boolean isOne()
  {
    return bitLength() == 1;
  }
  
  public boolean isZero()
  {
    return toBigInteger().signum() == 0;
  }
  
  public abstract ECFieldElement multiply(ECFieldElement paramECFieldElement);
  
  public ECFieldElement multiplyMinusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement paramECFieldElement3)
  {
    return multiply(paramECFieldElement1).subtract(paramECFieldElement2.multiply(paramECFieldElement3));
  }
  
  public ECFieldElement multiplyPlusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement paramECFieldElement3)
  {
    return multiply(paramECFieldElement1).add(paramECFieldElement2.multiply(paramECFieldElement3));
  }
  
  public abstract ECFieldElement negate();
  
  public abstract ECFieldElement sqrt();
  
  public abstract ECFieldElement square();
  
  public ECFieldElement squareMinusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
  {
    return square().subtract(paramECFieldElement1.multiply(paramECFieldElement2));
  }
  
  public ECFieldElement squarePlusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
  {
    return square().add(paramECFieldElement1.multiply(paramECFieldElement2));
  }
  
  public ECFieldElement squarePow(int paramInt)
  {
    int i = 0;
    ECFieldElement localECFieldElement = this;
    while (i < paramInt)
    {
      localECFieldElement = localECFieldElement.square();
      i += 1;
    }
    return localECFieldElement;
  }
  
  public abstract ECFieldElement subtract(ECFieldElement paramECFieldElement);
  
  public boolean testBitZero()
  {
    return toBigInteger().testBit(0);
  }
  
  public abstract BigInteger toBigInteger();
  
  public String toString()
  {
    return toBigInteger().toString(16);
  }
  
  public static class F2m
    extends ECFieldElement
  {
    public static final int GNB = 1;
    public static final int PPB = 3;
    public static final int TPB = 2;
    private int[] ks;
    private int m;
    private int representation;
    private LongArray x;
    
    public F2m(int paramInt1, int paramInt2, int paramInt3, int paramInt4, BigInteger paramBigInteger)
    {
      if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= paramInt1))
      {
        if ((paramInt3 == 0) && (paramInt4 == 0))
        {
          this.representation = 2;
          this.ks = new int[] { paramInt2 };
        }
        else
        {
          if (paramInt3 >= paramInt4) {
            break label118;
          }
          if (paramInt3 <= 0) {
            break label108;
          }
          this.representation = 3;
          this.ks = new int[] { paramInt2, paramInt3, paramInt4 };
        }
        this.m = paramInt1;
        this.x = new LongArray(paramBigInteger);
        return;
        label108:
        throw new IllegalArgumentException("k2 must be larger than 0");
        label118:
        throw new IllegalArgumentException("k2 must be smaller than k3");
      }
      throw new IllegalArgumentException("x value invalid in F2m field element");
    }
    
    public F2m(int paramInt1, int paramInt2, BigInteger paramBigInteger)
    {
      this(paramInt1, paramInt2, 0, 0, paramBigInteger);
    }
    
    private F2m(int paramInt, int[] paramArrayOfInt, LongArray paramLongArray)
    {
      this.m = paramInt;
      if (paramArrayOfInt.length == 1) {
        paramInt = 2;
      } else {
        paramInt = 3;
      }
      this.representation = paramInt;
      this.ks = paramArrayOfInt;
      this.x = paramLongArray;
    }
    
    public static void checkFieldElements(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
    {
      if (((paramECFieldElement1 instanceof F2m)) && ((paramECFieldElement2 instanceof F2m)))
      {
        paramECFieldElement1 = (F2m)paramECFieldElement1;
        paramECFieldElement2 = (F2m)paramECFieldElement2;
        if (paramECFieldElement1.representation == paramECFieldElement2.representation)
        {
          if ((paramECFieldElement1.m == paramECFieldElement2.m) && (Arrays.areEqual(paramECFieldElement1.ks, paramECFieldElement2.ks))) {
            return;
          }
          throw new IllegalArgumentException("Field elements are not elements of the same field F2m");
        }
        throw new IllegalArgumentException("One of the F2m field elements has incorrect representation");
      }
      throw new IllegalArgumentException("Field elements are not both instances of ECFieldElement.F2m");
    }
    
    public ECFieldElement add(ECFieldElement paramECFieldElement)
    {
      LongArray localLongArray = (LongArray)this.x.clone();
      localLongArray.addShiftedByWords(((F2m)paramECFieldElement).x, 0);
      return new F2m(this.m, this.ks, localLongArray);
    }
    
    public ECFieldElement addOne()
    {
      return new F2m(this.m, this.ks, this.x.addOne());
    }
    
    public int bitLength()
    {
      return this.x.degree();
    }
    
    public ECFieldElement divide(ECFieldElement paramECFieldElement)
    {
      return multiply(paramECFieldElement.invert());
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof F2m)) {
        return false;
      }
      paramObject = (F2m)paramObject;
      return (this.m == ((F2m)paramObject).m) && (this.representation == ((F2m)paramObject).representation) && (Arrays.areEqual(this.ks, ((F2m)paramObject).ks)) && (this.x.equals(((F2m)paramObject).x));
    }
    
    public String getFieldName()
    {
      return "F2m";
    }
    
    public int getFieldSize()
    {
      return this.m;
    }
    
    public int getK1()
    {
      return this.ks[0];
    }
    
    public int getK2()
    {
      int[] arrayOfInt = this.ks;
      if (arrayOfInt.length >= 2) {
        return arrayOfInt[1];
      }
      return 0;
    }
    
    public int getK3()
    {
      int[] arrayOfInt = this.ks;
      if (arrayOfInt.length >= 3) {
        return arrayOfInt[2];
      }
      return 0;
    }
    
    public int getM()
    {
      return this.m;
    }
    
    public int getRepresentation()
    {
      return this.representation;
    }
    
    public int hashCode()
    {
      return this.x.hashCode() ^ this.m ^ Arrays.hashCode(this.ks);
    }
    
    public ECFieldElement invert()
    {
      int i = this.m;
      int[] arrayOfInt = this.ks;
      return new F2m(i, arrayOfInt, this.x.modInverse(i, arrayOfInt));
    }
    
    public boolean isOne()
    {
      return this.x.isOne();
    }
    
    public boolean isZero()
    {
      return this.x.isZero();
    }
    
    public ECFieldElement multiply(ECFieldElement paramECFieldElement)
    {
      int i = this.m;
      int[] arrayOfInt = this.ks;
      return new F2m(i, arrayOfInt, this.x.modMultiply(((F2m)paramECFieldElement).x, i, arrayOfInt));
    }
    
    public ECFieldElement multiplyMinusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement paramECFieldElement3)
    {
      return multiplyPlusProduct(paramECFieldElement1, paramECFieldElement2, paramECFieldElement3);
    }
    
    public ECFieldElement multiplyPlusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement paramECFieldElement3)
    {
      LongArray localLongArray1 = this.x;
      LongArray localLongArray2 = ((F2m)paramECFieldElement1).x;
      paramECFieldElement1 = ((F2m)paramECFieldElement2).x;
      paramECFieldElement3 = ((F2m)paramECFieldElement3).x;
      paramECFieldElement2 = localLongArray1.multiply(localLongArray2, this.m, this.ks);
      paramECFieldElement3 = paramECFieldElement1.multiply(paramECFieldElement3, this.m, this.ks);
      if (paramECFieldElement2 != localLongArray1)
      {
        paramECFieldElement1 = paramECFieldElement2;
        if (paramECFieldElement2 != localLongArray2) {}
      }
      else
      {
        paramECFieldElement1 = (LongArray)paramECFieldElement2.clone();
      }
      paramECFieldElement1.addShiftedByWords(paramECFieldElement3, 0);
      paramECFieldElement1.reduce(this.m, this.ks);
      return new F2m(this.m, this.ks, paramECFieldElement1);
    }
    
    public ECFieldElement negate()
    {
      return this;
    }
    
    public ECFieldElement sqrt()
    {
      if ((!this.x.isZero()) && (!this.x.isOne())) {
        return squarePow(this.m - 1);
      }
      return this;
    }
    
    public ECFieldElement square()
    {
      int i = this.m;
      int[] arrayOfInt = this.ks;
      return new F2m(i, arrayOfInt, this.x.modSquare(i, arrayOfInt));
    }
    
    public ECFieldElement squareMinusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
    {
      return squarePlusProduct(paramECFieldElement1, paramECFieldElement2);
    }
    
    public ECFieldElement squarePlusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
    {
      LongArray localLongArray1 = this.x;
      paramECFieldElement1 = ((F2m)paramECFieldElement1).x;
      LongArray localLongArray2 = ((F2m)paramECFieldElement2).x;
      paramECFieldElement2 = localLongArray1.square(this.m, this.ks);
      localLongArray2 = paramECFieldElement1.multiply(localLongArray2, this.m, this.ks);
      paramECFieldElement1 = paramECFieldElement2;
      if (paramECFieldElement2 == localLongArray1) {
        paramECFieldElement1 = (LongArray)paramECFieldElement2.clone();
      }
      paramECFieldElement1.addShiftedByWords(localLongArray2, 0);
      paramECFieldElement1.reduce(this.m, this.ks);
      return new F2m(this.m, this.ks, paramECFieldElement1);
    }
    
    public ECFieldElement squarePow(int paramInt)
    {
      if (paramInt < 1) {
        return this;
      }
      int i = this.m;
      int[] arrayOfInt = this.ks;
      return new F2m(i, arrayOfInt, this.x.modSquareN(paramInt, i, arrayOfInt));
    }
    
    public ECFieldElement subtract(ECFieldElement paramECFieldElement)
    {
      return add(paramECFieldElement);
    }
    
    public boolean testBitZero()
    {
      return this.x.testBitZero();
    }
    
    public BigInteger toBigInteger()
    {
      return this.x.toBigInteger();
    }
  }
  
  public static class Fp
    extends ECFieldElement
  {
    BigInteger q;
    BigInteger r;
    BigInteger x;
    
    public Fp(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
    {
      this(paramBigInteger1, calculateResidue(paramBigInteger1), paramBigInteger2);
    }
    
    Fp(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
    {
      if ((paramBigInteger3 != null) && (paramBigInteger3.signum() >= 0) && (paramBigInteger3.compareTo(paramBigInteger1) < 0))
      {
        this.q = paramBigInteger1;
        this.r = paramBigInteger2;
        this.x = paramBigInteger3;
        return;
      }
      throw new IllegalArgumentException("x value invalid in Fp field element");
    }
    
    static BigInteger calculateResidue(BigInteger paramBigInteger)
    {
      int i = paramBigInteger.bitLength();
      if ((i >= 96) && (paramBigInteger.shiftRight(i - 64).longValue() == -1L)) {
        return ONE.shiftLeft(i).subtract(paramBigInteger);
      }
      return null;
    }
    
    private ECFieldElement checkSqrt(ECFieldElement paramECFieldElement)
    {
      if (paramECFieldElement.square().equals(this)) {
        return paramECFieldElement;
      }
      return null;
    }
    
    private BigInteger[] lucasSequence(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
    {
      int i = paramBigInteger3.bitLength();
      int j = paramBigInteger3.getLowestSetBit();
      BigInteger localBigInteger4 = ECConstants.ONE;
      BigInteger localBigInteger3 = ECConstants.TWO;
      BigInteger localBigInteger5 = ECConstants.ONE;
      BigInteger localBigInteger2 = ECConstants.ONE;
      i -= 1;
      BigInteger localBigInteger1 = paramBigInteger1;
      while (i >= j + 1)
      {
        localBigInteger5 = modMult(localBigInteger5, localBigInteger2);
        if (paramBigInteger3.testBit(i))
        {
          localBigInteger2 = modMult(localBigInteger5, paramBigInteger2);
          localBigInteger4 = modMult(localBigInteger4, localBigInteger1);
          localBigInteger3 = modReduce(localBigInteger1.multiply(localBigInteger3).subtract(paramBigInteger1.multiply(localBigInteger5)));
          localBigInteger1 = modReduce(localBigInteger1.multiply(localBigInteger1).subtract(localBigInteger2.shiftLeft(1)));
        }
        else
        {
          localBigInteger4 = modReduce(localBigInteger4.multiply(localBigInteger3).subtract(localBigInteger5));
          localBigInteger1 = modReduce(localBigInteger1.multiply(localBigInteger3).subtract(paramBigInteger1.multiply(localBigInteger5)));
          localBigInteger3 = modReduce(localBigInteger3.multiply(localBigInteger3).subtract(localBigInteger5.shiftLeft(1)));
          localBigInteger2 = localBigInteger5;
        }
        i -= 1;
      }
      localBigInteger2 = modMult(localBigInteger5, localBigInteger2);
      localBigInteger5 = modMult(localBigInteger2, paramBigInteger2);
      paramBigInteger3 = modReduce(localBigInteger4.multiply(localBigInteger3).subtract(localBigInteger2));
      paramBigInteger2 = modReduce(localBigInteger1.multiply(localBigInteger3).subtract(paramBigInteger1.multiply(localBigInteger2)));
      paramBigInteger1 = modMult(localBigInteger2, localBigInteger5);
      i = 1;
      while (i <= j)
      {
        paramBigInteger3 = modMult(paramBigInteger3, paramBigInteger2);
        paramBigInteger2 = modReduce(paramBigInteger2.multiply(paramBigInteger2).subtract(paramBigInteger1.shiftLeft(1)));
        paramBigInteger1 = modMult(paramBigInteger1, paramBigInteger1);
        i += 1;
      }
      return new BigInteger[] { paramBigInteger3, paramBigInteger2 };
    }
    
    public ECFieldElement add(ECFieldElement paramECFieldElement)
    {
      return new Fp(this.q, this.r, modAdd(this.x, paramECFieldElement.toBigInteger()));
    }
    
    public ECFieldElement addOne()
    {
      BigInteger localBigInteger2 = this.x.add(ECConstants.ONE);
      BigInteger localBigInteger1 = localBigInteger2;
      if (localBigInteger2.compareTo(this.q) == 0) {
        localBigInteger1 = ECConstants.ZERO;
      }
      return new Fp(this.q, this.r, localBigInteger1);
    }
    
    public ECFieldElement divide(ECFieldElement paramECFieldElement)
    {
      return new Fp(this.q, this.r, modMult(this.x, modInverse(paramECFieldElement.toBigInteger())));
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof Fp)) {
        return false;
      }
      paramObject = (Fp)paramObject;
      return (this.q.equals(((Fp)paramObject).q)) && (this.x.equals(((Fp)paramObject).x));
    }
    
    public String getFieldName()
    {
      return "Fp";
    }
    
    public int getFieldSize()
    {
      return this.q.bitLength();
    }
    
    public BigInteger getQ()
    {
      return this.q;
    }
    
    public int hashCode()
    {
      return this.q.hashCode() ^ this.x.hashCode();
    }
    
    public ECFieldElement invert()
    {
      return new Fp(this.q, this.r, modInverse(this.x));
    }
    
    protected BigInteger modAdd(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
    {
      paramBigInteger2 = paramBigInteger1.add(paramBigInteger2);
      paramBigInteger1 = paramBigInteger2;
      if (paramBigInteger2.compareTo(this.q) >= 0) {
        paramBigInteger1 = paramBigInteger2.subtract(this.q);
      }
      return paramBigInteger1;
    }
    
    protected BigInteger modDouble(BigInteger paramBigInteger)
    {
      BigInteger localBigInteger = paramBigInteger.shiftLeft(1);
      paramBigInteger = localBigInteger;
      if (localBigInteger.compareTo(this.q) >= 0) {
        paramBigInteger = localBigInteger.subtract(this.q);
      }
      return paramBigInteger;
    }
    
    protected BigInteger modHalf(BigInteger paramBigInteger)
    {
      BigInteger localBigInteger = paramBigInteger;
      if (paramBigInteger.testBit(0)) {
        localBigInteger = this.q.add(paramBigInteger);
      }
      return localBigInteger.shiftRight(1);
    }
    
    protected BigInteger modHalfAbs(BigInteger paramBigInteger)
    {
      BigInteger localBigInteger = paramBigInteger;
      if (paramBigInteger.testBit(0)) {
        localBigInteger = this.q.subtract(paramBigInteger);
      }
      return localBigInteger.shiftRight(1);
    }
    
    protected BigInteger modInverse(BigInteger paramBigInteger)
    {
      int i = getFieldSize();
      int j = i + 31 >> 5;
      int[] arrayOfInt1 = Nat.fromBigInteger(i, this.q);
      paramBigInteger = Nat.fromBigInteger(i, paramBigInteger);
      int[] arrayOfInt2 = Nat.create(j);
      Mod.invert(arrayOfInt1, paramBigInteger, arrayOfInt2);
      return Nat.toBigInteger(j, arrayOfInt2);
    }
    
    protected BigInteger modMult(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
    {
      return modReduce(paramBigInteger1.multiply(paramBigInteger2));
    }
    
    protected BigInteger modReduce(BigInteger paramBigInteger)
    {
      if (this.r != null)
      {
        int i;
        if (paramBigInteger.signum() < 0) {
          i = 1;
        } else {
          i = 0;
        }
        BigInteger localBigInteger1 = paramBigInteger;
        if (i != 0) {
          localBigInteger1 = paramBigInteger.abs();
        }
        int j = this.q.bitLength();
        boolean bool = this.r.equals(ECConstants.ONE);
        BigInteger localBigInteger2;
        for (paramBigInteger = localBigInteger1;; paramBigInteger = paramBigInteger.add(localBigInteger2))
        {
          localBigInteger1 = paramBigInteger;
          if (paramBigInteger.bitLength() <= j + 1) {
            break;
          }
          localBigInteger1 = paramBigInteger.shiftRight(j);
          localBigInteger2 = paramBigInteger.subtract(localBigInteger1.shiftLeft(j));
          paramBigInteger = localBigInteger1;
          if (!bool) {
            paramBigInteger = localBigInteger1.multiply(this.r);
          }
        }
        while (localBigInteger1.compareTo(this.q) >= 0) {
          localBigInteger1 = localBigInteger1.subtract(this.q);
        }
        paramBigInteger = localBigInteger1;
        if (i != 0)
        {
          paramBigInteger = localBigInteger1;
          if (localBigInteger1.signum() != 0) {
            return this.q.subtract(localBigInteger1);
          }
        }
      }
      else
      {
        paramBigInteger = paramBigInteger.mod(this.q);
      }
      return paramBigInteger;
    }
    
    protected BigInteger modSubtract(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
    {
      paramBigInteger2 = paramBigInteger1.subtract(paramBigInteger2);
      paramBigInteger1 = paramBigInteger2;
      if (paramBigInteger2.signum() < 0) {
        paramBigInteger1 = paramBigInteger2.add(this.q);
      }
      return paramBigInteger1;
    }
    
    public ECFieldElement multiply(ECFieldElement paramECFieldElement)
    {
      return new Fp(this.q, this.r, modMult(this.x, paramECFieldElement.toBigInteger()));
    }
    
    public ECFieldElement multiplyMinusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement paramECFieldElement3)
    {
      BigInteger localBigInteger = this.x;
      paramECFieldElement1 = paramECFieldElement1.toBigInteger();
      paramECFieldElement2 = paramECFieldElement2.toBigInteger();
      paramECFieldElement3 = paramECFieldElement3.toBigInteger();
      paramECFieldElement1 = localBigInteger.multiply(paramECFieldElement1);
      paramECFieldElement2 = paramECFieldElement2.multiply(paramECFieldElement3);
      return new Fp(this.q, this.r, modReduce(paramECFieldElement1.subtract(paramECFieldElement2)));
    }
    
    public ECFieldElement multiplyPlusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement paramECFieldElement3)
    {
      BigInteger localBigInteger = this.x;
      paramECFieldElement1 = paramECFieldElement1.toBigInteger();
      paramECFieldElement2 = paramECFieldElement2.toBigInteger();
      paramECFieldElement3 = paramECFieldElement3.toBigInteger();
      paramECFieldElement1 = localBigInteger.multiply(paramECFieldElement1);
      paramECFieldElement2 = paramECFieldElement2.multiply(paramECFieldElement3);
      return new Fp(this.q, this.r, modReduce(paramECFieldElement1.add(paramECFieldElement2)));
    }
    
    public ECFieldElement negate()
    {
      if (this.x.signum() == 0) {
        return this;
      }
      BigInteger localBigInteger = this.q;
      return new Fp(localBigInteger, this.r, localBigInteger.subtract(this.x));
    }
    
    public ECFieldElement sqrt()
    {
      if (!isZero())
      {
        if (isOne()) {
          return this;
        }
        if (this.q.testBit(0))
        {
          if (this.q.testBit(1))
          {
            localBigInteger1 = this.q.shiftRight(2).add(ECConstants.ONE);
            localBigInteger2 = this.q;
            return checkSqrt(new Fp(localBigInteger2, this.r, this.x.modPow(localBigInteger1, localBigInteger2)));
          }
          if (this.q.testBit(2))
          {
            localBigInteger1 = this.x.modPow(this.q.shiftRight(3), this.q);
            localBigInteger2 = modMult(localBigInteger1, this.x);
            if (modMult(localBigInteger2, localBigInteger1).equals(ECConstants.ONE)) {
              return checkSqrt(new Fp(this.q, this.r, localBigInteger2));
            }
            localBigInteger1 = modMult(localBigInteger2, ECConstants.TWO.modPow(this.q.shiftRight(2), this.q));
            return checkSqrt(new Fp(this.q, this.r, localBigInteger1));
          }
          BigInteger localBigInteger1 = this.q.shiftRight(1);
          if (!this.x.modPow(localBigInteger1, this.q).equals(ECConstants.ONE)) {
            return null;
          }
          BigInteger localBigInteger2 = this.x;
          BigInteger localBigInteger3 = modDouble(modDouble(localBigInteger2));
          BigInteger localBigInteger4 = localBigInteger1.add(ECConstants.ONE);
          BigInteger localBigInteger5 = this.q.subtract(ECConstants.ONE);
          Random localRandom = new Random();
          BigInteger localBigInteger6;
          do
          {
            do
            {
              localBigInteger6 = new BigInteger(this.q.bitLength(), localRandom);
            } while ((localBigInteger6.compareTo(this.q) >= 0) || (!modReduce(localBigInteger6.multiply(localBigInteger6).subtract(localBigInteger3)).modPow(localBigInteger1, this.q).equals(localBigInteger5)));
            Object localObject = lucasSequence(localBigInteger6, localBigInteger2, localBigInteger4);
            localBigInteger6 = localObject[0];
            localObject = localObject[1];
            if (modMult((BigInteger)localObject, (BigInteger)localObject).equals(localBigInteger3)) {
              return new Fp(this.q, this.r, modHalfAbs((BigInteger)localObject));
            }
          } while ((localBigInteger6.equals(ECConstants.ONE)) || (localBigInteger6.equals(localBigInteger5)));
          return null;
        }
        throw new RuntimeException("not done yet");
      }
      return this;
    }
    
    public ECFieldElement square()
    {
      BigInteger localBigInteger1 = this.q;
      BigInteger localBigInteger2 = this.r;
      BigInteger localBigInteger3 = this.x;
      return new Fp(localBigInteger1, localBigInteger2, modMult(localBigInteger3, localBigInteger3));
    }
    
    public ECFieldElement squareMinusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
    {
      BigInteger localBigInteger = this.x;
      paramECFieldElement1 = paramECFieldElement1.toBigInteger();
      paramECFieldElement2 = paramECFieldElement2.toBigInteger();
      localBigInteger = localBigInteger.multiply(localBigInteger);
      paramECFieldElement1 = paramECFieldElement1.multiply(paramECFieldElement2);
      return new Fp(this.q, this.r, modReduce(localBigInteger.subtract(paramECFieldElement1)));
    }
    
    public ECFieldElement squarePlusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
    {
      BigInteger localBigInteger = this.x;
      paramECFieldElement1 = paramECFieldElement1.toBigInteger();
      paramECFieldElement2 = paramECFieldElement2.toBigInteger();
      localBigInteger = localBigInteger.multiply(localBigInteger);
      paramECFieldElement1 = paramECFieldElement1.multiply(paramECFieldElement2);
      return new Fp(this.q, this.r, modReduce(localBigInteger.add(paramECFieldElement1)));
    }
    
    public ECFieldElement subtract(ECFieldElement paramECFieldElement)
    {
      return new Fp(this.q, this.r, modSubtract(this.x, paramECFieldElement.toBigInteger()));
    }
    
    public BigInteger toBigInteger()
    {
      return this.x;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\ECFieldElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */