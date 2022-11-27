package org.bouncycastle.math.ec;

import java.math.BigInteger;
import java.util.Hashtable;
import java.util.Random;
import org.bouncycastle.math.ec.endo.ECEndomorphism;
import org.bouncycastle.math.ec.endo.GLVEndomorphism;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.FiniteFields;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Integers;

public abstract class ECCurve
{
  public static final int COORD_AFFINE = 0;
  public static final int COORD_HOMOGENEOUS = 1;
  public static final int COORD_JACOBIAN = 2;
  public static final int COORD_JACOBIAN_CHUDNOVSKY = 3;
  public static final int COORD_JACOBIAN_MODIFIED = 4;
  public static final int COORD_LAMBDA_AFFINE = 5;
  public static final int COORD_LAMBDA_PROJECTIVE = 6;
  public static final int COORD_SKEWED = 7;
  protected ECFieldElement a;
  protected ECFieldElement b;
  protected BigInteger cofactor;
  protected int coord = 0;
  protected ECEndomorphism endomorphism = null;
  protected FiniteField field;
  protected ECMultiplier multiplier = null;
  protected BigInteger order;
  
  protected ECCurve(FiniteField paramFiniteField)
  {
    this.field = paramFiniteField;
  }
  
  public static int[] getAllCoordinateSystems()
  {
    return new int[] { 0, 1, 2, 3, 4, 5, 6, 7 };
  }
  
  protected void checkPoint(ECPoint paramECPoint)
  {
    if ((paramECPoint != null) && (this == paramECPoint.getCurve())) {
      return;
    }
    throw new IllegalArgumentException("'point' must be non-null and on this curve");
  }
  
  protected void checkPoints(ECPoint[] paramArrayOfECPoint)
  {
    checkPoints(paramArrayOfECPoint, 0, paramArrayOfECPoint.length);
  }
  
  protected void checkPoints(ECPoint[] paramArrayOfECPoint, int paramInt1, int paramInt2)
  {
    if (paramArrayOfECPoint != null)
    {
      if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 <= paramArrayOfECPoint.length - paramInt2))
      {
        int i = 0;
        while (i < paramInt2)
        {
          ECPoint localECPoint = paramArrayOfECPoint[(paramInt1 + i)];
          if ((localECPoint != null) && (this != localECPoint.getCurve())) {
            throw new IllegalArgumentException("'points' entries must be null or on this curve");
          }
          i += 1;
        }
        return;
      }
      throw new IllegalArgumentException("invalid range specified for 'points'");
    }
    throw new IllegalArgumentException("'points' cannot be null");
  }
  
  protected abstract ECCurve cloneCurve();
  
  public Config configure()
  {
    try
    {
      Config localConfig = new Config(this.coord, this.endomorphism, this.multiplier);
      return localConfig;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected ECMultiplier createDefaultMultiplier()
  {
    ECEndomorphism localECEndomorphism = this.endomorphism;
    if ((localECEndomorphism instanceof GLVEndomorphism)) {
      return new GLVMultiplier(this, (GLVEndomorphism)localECEndomorphism);
    }
    return new WNafL2RMultiplier();
  }
  
  public ECPoint createPoint(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    return createPoint(paramBigInteger1, paramBigInteger2, false);
  }
  
  public ECPoint createPoint(BigInteger paramBigInteger1, BigInteger paramBigInteger2, boolean paramBoolean)
  {
    return createRawPoint(fromBigInteger(paramBigInteger1), fromBigInteger(paramBigInteger2), paramBoolean);
  }
  
  protected abstract ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, boolean paramBoolean);
  
  protected abstract ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement[] paramArrayOfECFieldElement, boolean paramBoolean);
  
  public ECPoint decodePoint(byte[] paramArrayOfByte)
  {
    int i = (getFieldSize() + 7) / 8;
    boolean bool1 = false;
    int j = paramArrayOfByte[0];
    if (j != 0)
    {
      if ((j != 2) && (j != 3))
      {
        if (j != 4)
        {
          if ((j != 6) && (j != 7))
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("Invalid point encoding 0x");
            paramArrayOfByte.append(Integer.toString(j, 16));
            throw new IllegalArgumentException(paramArrayOfByte.toString());
          }
          if (paramArrayOfByte.length == i * 2 + 1)
          {
            BigInteger localBigInteger = BigIntegers.fromUnsignedByteArray(paramArrayOfByte, 1, i);
            paramArrayOfByte = BigIntegers.fromUnsignedByteArray(paramArrayOfByte, i + 1, i);
            boolean bool2 = paramArrayOfByte.testBit(0);
            if (j == 7) {
              bool1 = true;
            }
            if (bool2 == bool1) {
              paramArrayOfByte = validatePoint(localBigInteger, paramArrayOfByte);
            } else {
              throw new IllegalArgumentException("Inconsistent Y coordinate in hybrid encoding");
            }
          }
          else
          {
            throw new IllegalArgumentException("Incorrect length for hybrid encoding");
          }
        }
        else if (paramArrayOfByte.length == i * 2 + 1)
        {
          paramArrayOfByte = validatePoint(BigIntegers.fromUnsignedByteArray(paramArrayOfByte, 1, i), BigIntegers.fromUnsignedByteArray(paramArrayOfByte, i + 1, i));
        }
        else
        {
          throw new IllegalArgumentException("Incorrect length for uncompressed encoding");
        }
      }
      else if (paramArrayOfByte.length == i + 1)
      {
        paramArrayOfByte = decompressPoint(j & 0x1, BigIntegers.fromUnsignedByteArray(paramArrayOfByte, 1, i));
        if (!paramArrayOfByte.satisfiesCofactor()) {
          throw new IllegalArgumentException("Invalid point");
        }
      }
      else
      {
        throw new IllegalArgumentException("Incorrect length for compressed encoding");
      }
    }
    else
    {
      if (paramArrayOfByte.length != 1) {
        break label301;
      }
      paramArrayOfByte = getInfinity();
    }
    if (j != 0)
    {
      if (!paramArrayOfByte.isInfinity()) {
        return paramArrayOfByte;
      }
      throw new IllegalArgumentException("Invalid infinity encoding");
    }
    return paramArrayOfByte;
    label301:
    throw new IllegalArgumentException("Incorrect length for infinity encoding");
  }
  
  protected abstract ECPoint decompressPoint(int paramInt, BigInteger paramBigInteger);
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof ECCurve)) && (equals((ECCurve)paramObject)));
  }
  
  public boolean equals(ECCurve paramECCurve)
  {
    return (this == paramECCurve) || ((paramECCurve != null) && (getField().equals(paramECCurve.getField())) && (getA().toBigInteger().equals(paramECCurve.getA().toBigInteger())) && (getB().toBigInteger().equals(paramECCurve.getB().toBigInteger())));
  }
  
  public abstract ECFieldElement fromBigInteger(BigInteger paramBigInteger);
  
  public ECFieldElement getA()
  {
    return this.a;
  }
  
  public ECFieldElement getB()
  {
    return this.b;
  }
  
  public BigInteger getCofactor()
  {
    return this.cofactor;
  }
  
  public int getCoordinateSystem()
  {
    return this.coord;
  }
  
  public ECEndomorphism getEndomorphism()
  {
    return this.endomorphism;
  }
  
  public FiniteField getField()
  {
    return this.field;
  }
  
  public abstract int getFieldSize();
  
  public abstract ECPoint getInfinity();
  
  public ECMultiplier getMultiplier()
  {
    try
    {
      if (this.multiplier == null) {
        this.multiplier = createDefaultMultiplier();
      }
      ECMultiplier localECMultiplier = this.multiplier;
      return localECMultiplier;
    }
    finally {}
  }
  
  public BigInteger getOrder()
  {
    return this.order;
  }
  
  public PreCompInfo getPreCompInfo(ECPoint paramECPoint, String paramString)
  {
    checkPoint(paramECPoint);
    try
    {
      Hashtable localHashtable = paramECPoint.preCompTable;
      if (localHashtable == null) {
        paramString = null;
      } else {
        paramString = (PreCompInfo)localHashtable.get(paramString);
      }
      return paramString;
    }
    finally {}
  }
  
  public int hashCode()
  {
    return getField().hashCode() ^ Integers.rotateLeft(getA().toBigInteger().hashCode(), 8) ^ Integers.rotateLeft(getB().toBigInteger().hashCode(), 16);
  }
  
  public ECPoint importPoint(ECPoint paramECPoint)
  {
    if (this == paramECPoint.getCurve()) {
      return paramECPoint;
    }
    if (paramECPoint.isInfinity()) {
      return getInfinity();
    }
    paramECPoint = paramECPoint.normalize();
    return validatePoint(paramECPoint.getXCoord().toBigInteger(), paramECPoint.getYCoord().toBigInteger(), paramECPoint.withCompression);
  }
  
  public abstract boolean isValidFieldElement(BigInteger paramBigInteger);
  
  public void normalizeAll(ECPoint[] paramArrayOfECPoint)
  {
    normalizeAll(paramArrayOfECPoint, 0, paramArrayOfECPoint.length, null);
  }
  
  public void normalizeAll(ECPoint[] paramArrayOfECPoint, int paramInt1, int paramInt2, ECFieldElement paramECFieldElement)
  {
    checkPoints(paramArrayOfECPoint, paramInt1, paramInt2);
    int i = getCoordinateSystem();
    if ((i != 0) && (i != 5))
    {
      ECFieldElement[] arrayOfECFieldElement = new ECFieldElement[paramInt2];
      int[] arrayOfInt = new int[paramInt2];
      int m = 0;
      int j = 0;
      int k;
      for (i = 0; j < paramInt2; i = k)
      {
        int n = paramInt1 + j;
        ECPoint localECPoint = paramArrayOfECPoint[n];
        k = i;
        if (localECPoint != null) {
          if (paramECFieldElement == null)
          {
            k = i;
            if (localECPoint.isNormalized()) {}
          }
          else
          {
            arrayOfECFieldElement[i] = localECPoint.getZCoord(0);
            arrayOfInt[i] = n;
            k = i + 1;
          }
        }
        j += 1;
      }
      if (i == 0) {
        return;
      }
      ECAlgorithms.montgomeryTrick(arrayOfECFieldElement, 0, i, paramECFieldElement);
      paramInt1 = m;
      while (paramInt1 < i)
      {
        paramInt2 = arrayOfInt[paramInt1];
        paramArrayOfECPoint[paramInt2] = paramArrayOfECPoint[paramInt2].normalize(arrayOfECFieldElement[paramInt1]);
        paramInt1 += 1;
      }
      return;
    }
    if (paramECFieldElement == null) {
      return;
    }
    throw new IllegalArgumentException("'iso' not valid for affine coordinates");
  }
  
  public void setPreCompInfo(ECPoint paramECPoint, String paramString, PreCompInfo paramPreCompInfo)
  {
    checkPoint(paramECPoint);
    try
    {
      Hashtable localHashtable2 = paramECPoint.preCompTable;
      Hashtable localHashtable1 = localHashtable2;
      if (localHashtable2 == null)
      {
        localHashtable1 = new Hashtable(4);
        paramECPoint.preCompTable = localHashtable1;
      }
      localHashtable1.put(paramString, paramPreCompInfo);
      return;
    }
    finally {}
  }
  
  public boolean supportsCoordinateSystem(int paramInt)
  {
    return paramInt == 0;
  }
  
  public ECPoint validatePoint(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    paramBigInteger1 = createPoint(paramBigInteger1, paramBigInteger2);
    if (paramBigInteger1.isValid()) {
      return paramBigInteger1;
    }
    throw new IllegalArgumentException("Invalid point coordinates");
  }
  
  public ECPoint validatePoint(BigInteger paramBigInteger1, BigInteger paramBigInteger2, boolean paramBoolean)
  {
    paramBigInteger1 = createPoint(paramBigInteger1, paramBigInteger2, paramBoolean);
    if (paramBigInteger1.isValid()) {
      return paramBigInteger1;
    }
    throw new IllegalArgumentException("Invalid point coordinates");
  }
  
  public static abstract class AbstractF2m
    extends ECCurve
  {
    private BigInteger[] si = null;
    
    protected AbstractF2m(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super();
    }
    
    private static FiniteField buildField(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (paramInt2 != 0)
      {
        if (paramInt3 == 0)
        {
          if (paramInt4 == 0) {
            return FiniteFields.getBinaryExtensionField(new int[] { 0, paramInt2, paramInt1 });
          }
          throw new IllegalArgumentException("k3 must be 0 if k2 == 0");
        }
        if (paramInt3 > paramInt2)
        {
          if (paramInt4 > paramInt3) {
            return FiniteFields.getBinaryExtensionField(new int[] { 0, paramInt2, paramInt3, paramInt4, paramInt1 });
          }
          throw new IllegalArgumentException("k3 must be > k2");
        }
        throw new IllegalArgumentException("k2 must be > k1");
      }
      throw new IllegalArgumentException("k1 must be > 0");
    }
    
    public static BigInteger inverse(int paramInt, int[] paramArrayOfInt, BigInteger paramBigInteger)
    {
      return new LongArray(paramBigInteger).modInverse(paramInt, paramArrayOfInt).toBigInteger();
    }
    
    private ECFieldElement solveQuadraticEquation(ECFieldElement paramECFieldElement)
    {
      if (paramECFieldElement.isZero()) {
        return paramECFieldElement;
      }
      ECFieldElement localECFieldElement3 = fromBigInteger(ECConstants.ZERO);
      int j = getFieldSize();
      Random localRandom = new Random();
      ECFieldElement localECFieldElement1;
      do
      {
        ECFieldElement localECFieldElement4 = fromBigInteger(new BigInteger(j, localRandom));
        int i = 1;
        ECFieldElement localECFieldElement2 = paramECFieldElement;
        localECFieldElement1 = localECFieldElement3;
        while (i < j)
        {
          localECFieldElement2 = localECFieldElement2.square();
          localECFieldElement1 = localECFieldElement1.square().add(localECFieldElement2.multiply(localECFieldElement4));
          localECFieldElement2 = localECFieldElement2.add(paramECFieldElement);
          i += 1;
        }
        if (!localECFieldElement2.isZero()) {
          return null;
        }
      } while (localECFieldElement1.square().add(localECFieldElement1).isZero());
      return localECFieldElement1;
    }
    
    public ECPoint createPoint(BigInteger paramBigInteger1, BigInteger paramBigInteger2, boolean paramBoolean)
    {
      ECFieldElement localECFieldElement = fromBigInteger(paramBigInteger1);
      paramBigInteger1 = fromBigInteger(paramBigInteger2);
      int i = getCoordinateSystem();
      if ((i == 5) || (i == 6)) {
        if (localECFieldElement.isZero())
        {
          if (!paramBigInteger1.square().equals(getB())) {
            throw new IllegalArgumentException();
          }
        }
        else {
          paramBigInteger1 = paramBigInteger1.divide(localECFieldElement).add(localECFieldElement);
        }
      }
      return createRawPoint(localECFieldElement, paramBigInteger1, paramBoolean);
    }
    
    protected ECPoint decompressPoint(int paramInt, BigInteger paramBigInteger)
    {
      ECFieldElement localECFieldElement2 = fromBigInteger(paramBigInteger);
      if (localECFieldElement2.isZero())
      {
        paramBigInteger = getB().sqrt();
      }
      else
      {
        ECFieldElement localECFieldElement1 = solveQuadraticEquation(localECFieldElement2.square().invert().multiply(getB()).add(getA()).add(localECFieldElement2));
        if (localECFieldElement1 != null)
        {
          boolean bool2 = localECFieldElement1.testBitZero();
          boolean bool1;
          if (paramInt == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          paramBigInteger = localECFieldElement1;
          if (bool2 != bool1) {
            paramBigInteger = localECFieldElement1.addOne();
          }
          paramInt = getCoordinateSystem();
          if ((paramInt != 5) && (paramInt != 6)) {
            paramBigInteger = paramBigInteger.multiply(localECFieldElement2);
          } else {
            paramBigInteger = paramBigInteger.add(localECFieldElement2);
          }
        }
        else
        {
          paramBigInteger = null;
        }
      }
      if (paramBigInteger != null) {
        return createRawPoint(localECFieldElement2, paramBigInteger, true);
      }
      throw new IllegalArgumentException("Invalid point compression");
    }
    
    BigInteger[] getSi()
    {
      try
      {
        if (this.si == null) {
          this.si = Tnaf.getSi(this);
        }
        BigInteger[] arrayOfBigInteger = this.si;
        return arrayOfBigInteger;
      }
      finally {}
    }
    
    public boolean isKoblitz()
    {
      return (this.order != null) && (this.cofactor != null) && (this.b.isOne()) && ((this.a.isZero()) || (this.a.isOne()));
    }
    
    public boolean isValidFieldElement(BigInteger paramBigInteger)
    {
      return (paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= getFieldSize());
    }
  }
  
  public static abstract class AbstractFp
    extends ECCurve
  {
    protected AbstractFp(BigInteger paramBigInteger)
    {
      super();
    }
    
    protected ECPoint decompressPoint(int paramInt, BigInteger paramBigInteger)
    {
      ECFieldElement localECFieldElement2 = fromBigInteger(paramBigInteger);
      ECFieldElement localECFieldElement1 = localECFieldElement2.square().add(this.a).multiply(localECFieldElement2).add(this.b).sqrt();
      if (localECFieldElement1 != null)
      {
        boolean bool2 = localECFieldElement1.testBitZero();
        boolean bool1;
        if (paramInt == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        paramBigInteger = localECFieldElement1;
        if (bool2 != bool1) {
          paramBigInteger = localECFieldElement1.negate();
        }
        return createRawPoint(localECFieldElement2, paramBigInteger, true);
      }
      throw new IllegalArgumentException("Invalid point compression");
    }
    
    public boolean isValidFieldElement(BigInteger paramBigInteger)
    {
      return (paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.compareTo(getField().getCharacteristic()) < 0);
    }
  }
  
  public class Config
  {
    protected int coord;
    protected ECEndomorphism endomorphism;
    protected ECMultiplier multiplier;
    
    Config(int paramInt, ECEndomorphism paramECEndomorphism, ECMultiplier paramECMultiplier)
    {
      this.coord = paramInt;
      this.endomorphism = paramECEndomorphism;
      this.multiplier = paramECMultiplier;
    }
    
    public ECCurve create()
    {
      if (ECCurve.this.supportsCoordinateSystem(this.coord))
      {
        ECCurve localECCurve = ECCurve.this.cloneCurve();
        if (localECCurve != ECCurve.this) {
          try
          {
            localECCurve.coord = this.coord;
            localECCurve.endomorphism = this.endomorphism;
            localECCurve.multiplier = this.multiplier;
            return localECCurve;
          }
          finally {}
        }
        throw new IllegalStateException("implementation returned current curve");
      }
      throw new IllegalStateException("unsupported coordinate system");
    }
    
    public Config setCoordinateSystem(int paramInt)
    {
      this.coord = paramInt;
      return this;
    }
    
    public Config setEndomorphism(ECEndomorphism paramECEndomorphism)
    {
      this.endomorphism = paramECEndomorphism;
      return this;
    }
    
    public Config setMultiplier(ECMultiplier paramECMultiplier)
    {
      this.multiplier = paramECMultiplier;
      return this;
    }
  }
  
  public static class F2m
    extends ECCurve.AbstractF2m
  {
    private static final int F2M_DEFAULT_COORDS = 6;
    private ECPoint.F2m infinity;
    private int k1;
    private int k2;
    private int k3;
    private int m;
    
    public F2m(int paramInt1, int paramInt2, int paramInt3, int paramInt4, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
    {
      this(paramInt1, paramInt2, paramInt3, paramInt4, paramBigInteger1, paramBigInteger2, null, null);
    }
    
    public F2m(int paramInt1, int paramInt2, int paramInt3, int paramInt4, BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4)
    {
      super(paramInt2, paramInt3, paramInt4);
      this.m = paramInt1;
      this.k1 = paramInt2;
      this.k2 = paramInt3;
      this.k3 = paramInt4;
      this.order = paramBigInteger3;
      this.cofactor = paramBigInteger4;
      this.infinity = new ECPoint.F2m(this, null, null);
      this.a = fromBigInteger(paramBigInteger1);
      this.b = fromBigInteger(paramBigInteger2);
      this.coord = 6;
    }
    
    protected F2m(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
    {
      super(paramInt2, paramInt3, paramInt4);
      this.m = paramInt1;
      this.k1 = paramInt2;
      this.k2 = paramInt3;
      this.k3 = paramInt4;
      this.order = paramBigInteger1;
      this.cofactor = paramBigInteger2;
      this.infinity = new ECPoint.F2m(this, null, null);
      this.a = paramECFieldElement1;
      this.b = paramECFieldElement2;
      this.coord = 6;
    }
    
    public F2m(int paramInt1, int paramInt2, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
    {
      this(paramInt1, paramInt2, 0, 0, paramBigInteger1, paramBigInteger2, null, null);
    }
    
    public F2m(int paramInt1, int paramInt2, BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4)
    {
      this(paramInt1, paramInt2, 0, 0, paramBigInteger1, paramBigInteger2, paramBigInteger3, paramBigInteger4);
    }
    
    protected ECCurve cloneCurve()
    {
      return new F2m(this.m, this.k1, this.k2, this.k3, this.a, this.b, this.order, this.cofactor);
    }
    
    protected ECMultiplier createDefaultMultiplier()
    {
      if (isKoblitz()) {
        return new WTauNafMultiplier();
      }
      return super.createDefaultMultiplier();
    }
    
    protected ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, boolean paramBoolean)
    {
      return new ECPoint.F2m(this, paramECFieldElement1, paramECFieldElement2, paramBoolean);
    }
    
    protected ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement[] paramArrayOfECFieldElement, boolean paramBoolean)
    {
      return new ECPoint.F2m(this, paramECFieldElement1, paramECFieldElement2, paramArrayOfECFieldElement, paramBoolean);
    }
    
    public ECFieldElement fromBigInteger(BigInteger paramBigInteger)
    {
      return new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, paramBigInteger);
    }
    
    public int getFieldSize()
    {
      return this.m;
    }
    
    public BigInteger getH()
    {
      return this.cofactor;
    }
    
    public ECPoint getInfinity()
    {
      return this.infinity;
    }
    
    public int getK1()
    {
      return this.k1;
    }
    
    public int getK2()
    {
      return this.k2;
    }
    
    public int getK3()
    {
      return this.k3;
    }
    
    public int getM()
    {
      return this.m;
    }
    
    public BigInteger getN()
    {
      return this.order;
    }
    
    public boolean isTrinomial()
    {
      return (this.k2 == 0) && (this.k3 == 0);
    }
    
    public boolean supportsCoordinateSystem(int paramInt)
    {
      return (paramInt == 0) || (paramInt == 1) || (paramInt == 6);
    }
  }
  
  public static class Fp
    extends ECCurve.AbstractFp
  {
    private static final int FP_DEFAULT_COORDS = 4;
    ECPoint.Fp infinity;
    BigInteger q;
    BigInteger r;
    
    public Fp(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
    {
      this(paramBigInteger1, paramBigInteger2, paramBigInteger3, null, null);
    }
    
    public Fp(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4, BigInteger paramBigInteger5)
    {
      super();
      this.q = paramBigInteger1;
      this.r = ECFieldElement.Fp.calculateResidue(paramBigInteger1);
      this.infinity = new ECPoint.Fp(this, null, null);
      this.a = fromBigInteger(paramBigInteger2);
      this.b = fromBigInteger(paramBigInteger3);
      this.order = paramBigInteger4;
      this.cofactor = paramBigInteger5;
      this.coord = 4;
    }
    
    protected Fp(BigInteger paramBigInteger1, BigInteger paramBigInteger2, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
    {
      this(paramBigInteger1, paramBigInteger2, paramECFieldElement1, paramECFieldElement2, null, null);
    }
    
    protected Fp(BigInteger paramBigInteger1, BigInteger paramBigInteger2, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, BigInteger paramBigInteger3, BigInteger paramBigInteger4)
    {
      super();
      this.q = paramBigInteger1;
      this.r = paramBigInteger2;
      this.infinity = new ECPoint.Fp(this, null, null);
      this.a = paramECFieldElement1;
      this.b = paramECFieldElement2;
      this.order = paramBigInteger3;
      this.cofactor = paramBigInteger4;
      this.coord = 4;
    }
    
    protected ECCurve cloneCurve()
    {
      return new Fp(this.q, this.r, this.a, this.b, this.order, this.cofactor);
    }
    
    protected ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, boolean paramBoolean)
    {
      return new ECPoint.Fp(this, paramECFieldElement1, paramECFieldElement2, paramBoolean);
    }
    
    protected ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement[] paramArrayOfECFieldElement, boolean paramBoolean)
    {
      return new ECPoint.Fp(this, paramECFieldElement1, paramECFieldElement2, paramArrayOfECFieldElement, paramBoolean);
    }
    
    public ECFieldElement fromBigInteger(BigInteger paramBigInteger)
    {
      return new ECFieldElement.Fp(this.q, this.r, paramBigInteger);
    }
    
    public int getFieldSize()
    {
      return this.q.bitLength();
    }
    
    public ECPoint getInfinity()
    {
      return this.infinity;
    }
    
    public BigInteger getQ()
    {
      return this.q;
    }
    
    public ECPoint importPoint(ECPoint paramECPoint)
    {
      if ((this != paramECPoint.getCurve()) && (getCoordinateSystem() == 2) && (!paramECPoint.isInfinity()))
      {
        int i = paramECPoint.getCurve().getCoordinateSystem();
        if ((i == 2) || (i == 3) || (i == 4))
        {
          ECFieldElement localECFieldElement1 = fromBigInteger(paramECPoint.x.toBigInteger());
          ECFieldElement localECFieldElement2 = fromBigInteger(paramECPoint.y.toBigInteger());
          ECFieldElement localECFieldElement3 = fromBigInteger(paramECPoint.zs[0].toBigInteger());
          boolean bool = paramECPoint.withCompression;
          return new ECPoint.Fp(this, localECFieldElement1, localECFieldElement2, new ECFieldElement[] { localECFieldElement3 }, bool);
        }
      }
      return super.importPoint(paramECPoint);
    }
    
    public boolean supportsCoordinateSystem(int paramInt)
    {
      return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 4);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\ECCurve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */