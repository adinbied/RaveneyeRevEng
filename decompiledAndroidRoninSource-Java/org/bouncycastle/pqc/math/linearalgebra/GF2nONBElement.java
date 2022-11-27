package org.bouncycastle.pqc.math.linearalgebra;

import java.math.BigInteger;
import java.security.SecureRandom;

public class GF2nONBElement
  extends GF2nElement
{
  private static final int MAXLONG = 64;
  private static final long[] mBitmask = { 1L, 2L, 4L, 8L, 16L, 32L, 64L, 128L, 256L, 512L, 1024L, 2048L, 4096L, 8192L, 16384L, 32768L, 65536L, 131072L, 262144L, 524288L, 1048576L, 2097152L, 4194304L, 8388608L, 16777216L, 33554432L, 67108864L, 134217728L, 268435456L, 536870912L, 1073741824L, 2147483648L, 4294967296L, 8589934592L, 17179869184L, 34359738368L, 68719476736L, 137438953472L, 274877906944L, 549755813888L, 1099511627776L, 2199023255552L, 4398046511104L, 8796093022208L, 17592186044416L, 35184372088832L, 70368744177664L, 140737488355328L, 281474976710656L, 562949953421312L, 1125899906842624L, 2251799813685248L, 4503599627370496L, 9007199254740992L, 18014398509481984L, 36028797018963968L, 72057594037927936L, 144115188075855872L, 288230376151711744L, 576460752303423488L, 1152921504606846976L, 2305843009213693952L, 4611686018427387904L, Long.MIN_VALUE };
  private static final int[] mIBY64 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
  private static final long[] mMaxmask = { 1L, 3L, 7L, 15L, 31L, 63L, 127L, 255L, 511L, 1023L, 2047L, 4095L, 8191L, 16383L, 32767L, 65535L, 131071L, 262143L, 524287L, 1048575L, 2097151L, 4194303L, 8388607L, 16777215L, 33554431L, 67108863L, 134217727L, 268435455L, 536870911L, 1073741823L, 2147483647L, 4294967295L, 8589934591L, 17179869183L, 34359738367L, 68719476735L, 137438953471L, 274877906943L, 549755813887L, 1099511627775L, 2199023255551L, 4398046511103L, 8796093022207L, 17592186044415L, 35184372088831L, 70368744177663L, 140737488355327L, 281474976710655L, 562949953421311L, 1125899906842623L, 2251799813685247L, 4503599627370495L, 9007199254740991L, 18014398509481983L, 36028797018963967L, 72057594037927935L, 144115188075855871L, 288230376151711743L, 576460752303423487L, 1152921504606846975L, 2305843009213693951L, 4611686018427387903L, Long.MAX_VALUE, -1L };
  private int mBit;
  private int mLength;
  private long[] mPol;
  
  public GF2nONBElement(GF2nONBElement paramGF2nONBElement)
  {
    this.mField = paramGF2nONBElement.mField;
    this.mDegree = this.mField.getDegree();
    this.mLength = ((GF2nONBField)this.mField).getONBLength();
    this.mBit = ((GF2nONBField)this.mField).getONBBit();
    this.mPol = new long[this.mLength];
    assign(paramGF2nONBElement.getElement());
  }
  
  public GF2nONBElement(GF2nONBField paramGF2nONBField, BigInteger paramBigInteger)
  {
    this.mField = paramGF2nONBField;
    this.mDegree = this.mField.getDegree();
    this.mLength = paramGF2nONBField.getONBLength();
    this.mBit = paramGF2nONBField.getONBBit();
    this.mPol = new long[this.mLength];
    assign(paramBigInteger);
  }
  
  public GF2nONBElement(GF2nONBField paramGF2nONBField, SecureRandom paramSecureRandom)
  {
    this.mField = paramGF2nONBField;
    this.mDegree = this.mField.getDegree();
    this.mLength = paramGF2nONBField.getONBLength();
    this.mBit = paramGF2nONBField.getONBBit();
    int j = this.mLength;
    paramGF2nONBField = new long[j];
    this.mPol = paramGF2nONBField;
    int i = 0;
    if (j > 1)
    {
      while (i < this.mLength - 1)
      {
        this.mPol[i] = paramSecureRandom.nextLong();
        i += 1;
      }
      long l = paramSecureRandom.nextLong();
      this.mPol[(this.mLength - 1)] = (l >>> 64 - this.mBit);
      return;
    }
    paramGF2nONBField[0] = paramSecureRandom.nextLong();
    paramGF2nONBField = this.mPol;
    paramGF2nONBField[0] >>>= 64 - this.mBit;
  }
  
  public GF2nONBElement(GF2nONBField paramGF2nONBField, byte[] paramArrayOfByte)
  {
    this.mField = paramGF2nONBField;
    this.mDegree = this.mField.getDegree();
    this.mLength = paramGF2nONBField.getONBLength();
    this.mBit = paramGF2nONBField.getONBBit();
    this.mPol = new long[this.mLength];
    assign(paramArrayOfByte);
  }
  
  private GF2nONBElement(GF2nONBField paramGF2nONBField, long[] paramArrayOfLong)
  {
    this.mField = paramGF2nONBField;
    this.mDegree = this.mField.getDegree();
    this.mLength = paramGF2nONBField.getONBLength();
    this.mBit = paramGF2nONBField.getONBBit();
    this.mPol = paramArrayOfLong;
  }
  
  public static GF2nONBElement ONE(GF2nONBField paramGF2nONBField)
  {
    int j = paramGF2nONBField.getONBLength();
    long[] arrayOfLong = new long[j];
    int i = 0;
    int k;
    for (;;)
    {
      k = j - 1;
      if (i >= k) {
        break;
      }
      arrayOfLong[i] = -1L;
      i += 1;
    }
    arrayOfLong[k] = mMaxmask[(paramGF2nONBField.getONBBit() - 1)];
    return new GF2nONBElement(paramGF2nONBField, arrayOfLong);
  }
  
  public static GF2nONBElement ZERO(GF2nONBField paramGF2nONBField)
  {
    return new GF2nONBElement(paramGF2nONBField, new long[paramGF2nONBField.getONBLength()]);
  }
  
  private void assign(BigInteger paramBigInteger)
  {
    assign(paramBigInteger.toByteArray());
  }
  
  private void assign(byte[] paramArrayOfByte)
  {
    this.mPol = new long[this.mLength];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      long[] arrayOfLong = this.mPol;
      int j = i >>> 3;
      arrayOfLong[j] |= (paramArrayOfByte[(paramArrayOfByte.length - 1 - i)] & 0xFF) << ((i & 0x7) << 3);
      i += 1;
    }
  }
  
  private void assign(long[] paramArrayOfLong)
  {
    System.arraycopy(paramArrayOfLong, 0, this.mPol, 0, this.mLength);
  }
  
  private long[] getElement()
  {
    long[] arrayOfLong1 = this.mPol;
    long[] arrayOfLong2 = new long[arrayOfLong1.length];
    System.arraycopy(arrayOfLong1, 0, arrayOfLong2, 0, arrayOfLong1.length);
    return arrayOfLong2;
  }
  
  private long[] getElementReverseOrder()
  {
    long[] arrayOfLong = new long[this.mPol.length];
    int i = 0;
    while (i < this.mDegree)
    {
      if (testBit(this.mDegree - i - 1))
      {
        int j = i >>> 6;
        arrayOfLong[j] |= mBitmask[(i & 0x3F)];
      }
      i += 1;
    }
    return arrayOfLong;
  }
  
  public GFElement add(GFElement paramGFElement)
    throws RuntimeException
  {
    GF2nONBElement localGF2nONBElement = new GF2nONBElement(this);
    localGF2nONBElement.addToThis(paramGFElement);
    return localGF2nONBElement;
  }
  
  public void addToThis(GFElement paramGFElement)
    throws RuntimeException
  {
    if ((paramGFElement instanceof GF2nONBElement))
    {
      Object localObject = this.mField;
      paramGFElement = (GF2nONBElement)paramGFElement;
      if (((GF2nField)localObject).equals(paramGFElement.mField))
      {
        int i = 0;
        while (i < this.mLength)
        {
          localObject = this.mPol;
          localObject[i] ^= paramGFElement.mPol[i];
          i += 1;
        }
        return;
      }
      throw new RuntimeException();
    }
    throw new RuntimeException();
  }
  
  void assignOne()
  {
    int i = 0;
    int j;
    for (;;)
    {
      j = this.mLength;
      if (i >= j - 1) {
        break;
      }
      this.mPol[i] = -1L;
      i += 1;
    }
    this.mPol[(j - 1)] = mMaxmask[(this.mBit - 1)];
  }
  
  void assignZero()
  {
    this.mPol = new long[this.mLength];
  }
  
  public Object clone()
  {
    return new GF2nONBElement(this);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof GF2nONBElement)) {
        return false;
      }
      paramObject = (GF2nONBElement)paramObject;
      int i = 0;
      while (i < this.mLength)
      {
        if (this.mPol[i] != paramObject.mPol[i]) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.mPol.hashCode();
  }
  
  public GF2nElement increase()
  {
    GF2nONBElement localGF2nONBElement = new GF2nONBElement(this);
    localGF2nONBElement.increaseThis();
    return localGF2nONBElement;
  }
  
  public void increaseThis()
  {
    addToThis(ONE((GF2nONBField)this.mField));
  }
  
  public GFElement invert()
    throws ArithmeticException
  {
    GF2nONBElement localGF2nONBElement = new GF2nONBElement(this);
    localGF2nONBElement.invertThis();
    return localGF2nONBElement;
  }
  
  public void invertThis()
    throws ArithmeticException
  {
    if (!isZero())
    {
      int i = 31;
      int j = 0;
      while ((j == 0) && (i >= 0))
      {
        if ((this.mDegree - 1 & mBitmask[i]) != 0L) {
          j = 1;
        }
        i -= 1;
      }
      ZERO((GF2nONBField)this.mField);
      GF2nONBElement localGF2nONBElement = new GF2nONBElement(this);
      j = i + 1 - 1;
      i = 1;
      while (j >= 0)
      {
        GF2nElement localGF2nElement = (GF2nElement)localGF2nONBElement.clone();
        int k = 1;
        while (k <= i)
        {
          localGF2nElement.squareThis();
          k += 1;
        }
        localGF2nONBElement.multiplyThisBy(localGF2nElement);
        k = i << 1;
        i = k;
        if ((this.mDegree - 1 & mBitmask[j]) != 0L)
        {
          localGF2nONBElement.squareThis();
          localGF2nONBElement.multiplyThisBy(this);
          i = k + 1;
        }
        j -= 1;
      }
      localGF2nONBElement.squareThis();
      return;
    }
    throw new ArithmeticException();
  }
  
  public boolean isOne()
  {
    boolean bool3 = false;
    int i = 0;
    boolean bool1 = true;
    while ((i < this.mLength - 1) && (bool1))
    {
      if ((bool1) && ((this.mPol[i] & 0xFFFFFFFFFFFFFFFF) == -1L)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      i += 1;
    }
    boolean bool2 = bool1;
    if (bool1)
    {
      bool2 = bool3;
      if (bool1)
      {
        long l = this.mPol[(this.mLength - 1)];
        long[] arrayOfLong = mMaxmask;
        i = this.mBit;
        bool2 = bool3;
        if ((l & arrayOfLong[(i - 1)]) == arrayOfLong[(i - 1)]) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  public boolean isZero()
  {
    int i = 0;
    boolean bool = true;
    while ((i < this.mLength) && (bool))
    {
      if ((bool) && ((this.mPol[i] & 0xFFFFFFFFFFFFFFFF) == 0L)) {
        bool = true;
      } else {
        bool = false;
      }
      i += 1;
    }
    return bool;
  }
  
  public GFElement multiply(GFElement paramGFElement)
    throws RuntimeException
  {
    GF2nONBElement localGF2nONBElement = new GF2nONBElement(this);
    localGF2nONBElement.multiplyThisBy(paramGFElement);
    return localGF2nONBElement;
  }
  
  public void multiplyThisBy(GFElement paramGFElement)
    throws RuntimeException
  {
    if ((paramGFElement instanceof GF2nONBElement))
    {
      Object localObject2 = this.mField;
      Object localObject1 = (GF2nONBElement)paramGFElement;
      if (((GF2nField)localObject2).equals(((GF2nONBElement)localObject1).mField))
      {
        if (equals(paramGFElement))
        {
          squareThis();
          return;
        }
        paramGFElement = this.mPol;
        localObject1 = ((GF2nONBElement)localObject1).mPol;
        localObject2 = new long[this.mLength];
        int[][] arrayOfInt = ((GF2nONBField)this.mField).mMult;
        int i1 = this.mLength - 1;
        int i = this.mBit;
        Object localObject3 = mBitmask;
        long l1 = localObject3[63];
        long l2 = localObject3[(i - 1)];
        int m = 0;
        while (m < this.mDegree)
        {
          int n = 0;
          int k;
          for (i = 0; n < this.mDegree; i = j)
          {
            localObject3 = mIBY64;
            j = localObject3[n];
            int i2 = localObject3[arrayOfInt[n][0]];
            int i3 = arrayOfInt[n][0];
            long l3 = paramGFElement[j];
            localObject3 = mBitmask;
            j = i;
            if ((l3 & localObject3[(n & 0x3F)]) != 0L)
            {
              k = i;
              if ((localObject1[i2] & localObject3[(i3 & 0x3F)]) != 0L) {
                k = i ^ 0x1;
              }
              j = k;
              if (arrayOfInt[n][1] != -1)
              {
                i = mIBY64[arrayOfInt[n][1]];
                i2 = arrayOfInt[n][1];
                j = k;
                if ((localObject1[i] & mBitmask[(i2 & 0x3F)]) != 0L) {
                  j = k ^ 0x1;
                }
              }
            }
            n += 1;
          }
          int j = mIBY64[m];
          if (i != 0) {
            localObject2[j] ^= mBitmask[(m & 0x3F)];
          }
          if (this.mLength > 1)
          {
            if ((paramGFElement[i1] & 1L) == 1L) {
              i = 1;
            } else {
              i = 0;
            }
            j = i1 - 1;
            n = j;
            for (k = i; n >= 0; k = i)
            {
              if ((paramGFElement[n] & 1L) != 0L) {
                i = 1;
              } else {
                i = 0;
              }
              paramGFElement[n] >>>= 1;
              if (k != 0) {
                paramGFElement[n] ^= l1;
              }
              n -= 1;
            }
            paramGFElement[i1] >>>= 1;
            if (k != 0) {
              paramGFElement[i1] ^= l2;
            }
            if ((localObject1[i1] & 1L) == 1L)
            {
              i = 1;
              k = j;
            }
            else
            {
              i = 0;
              k = j;
            }
            while (k >= 0)
            {
              if ((localObject1[k] & 1L) != 0L) {
                j = 1;
              } else {
                j = 0;
              }
              localObject1[k] >>>= 1;
              if (i != 0) {
                localObject1[k] ^= l1;
              }
              k -= 1;
              i = j;
            }
            localObject1[i1] >>>= 1;
            if (i != 0) {
              localObject1[i1] ^= l2;
            }
          }
          else
          {
            if ((paramGFElement[0] & 1L) == 1L) {
              i = 1;
            } else {
              i = 0;
            }
            paramGFElement[0] >>>= 1;
            if (i != 0) {
              paramGFElement[0] ^= l2;
            }
            if ((localObject1[0] & 1L) == 1L) {
              i = 1;
            } else {
              i = 0;
            }
            localObject1[0] >>>= 1;
            if (i != 0) {
              localObject1[0] ^= l2;
            }
          }
          m += 1;
        }
        assign((long[])localObject2);
        return;
      }
      throw new RuntimeException();
    }
    throw new RuntimeException("The elements have different representation: not yet implemented");
  }
  
  void reverseOrder()
  {
    this.mPol = getElementReverseOrder();
  }
  
  public GF2nElement solveQuadraticEquation()
    throws RuntimeException
  {
    if (trace() != 1)
    {
      long l3 = mBitmask[63];
      long[] arrayOfLong1 = new long[this.mLength];
      int i = 0;
      long l1 = 0L;
      long[] arrayOfLong2;
      long l2;
      while (i < this.mLength - 1)
      {
        int j = 1;
        while (j < 64)
        {
          arrayOfLong2 = mBitmask;
          if ((arrayOfLong2[j] & this.mPol[i]) != 0L)
          {
            l2 = l1;
            if ((l1 & arrayOfLong2[(j - 1)]) != 0L) {}
          }
          else
          {
            l2 = this.mPol[i];
            arrayOfLong2 = mBitmask;
            if ((l2 & arrayOfLong2[j]) == 0L)
            {
              l2 = l1;
              if ((arrayOfLong2[(j - 1)] & l1) == 0L) {}
            }
            else
            {
              l2 = l1 ^ mBitmask[j];
            }
          }
          j += 1;
          l1 = l2;
        }
        arrayOfLong1[i] = l1;
        boolean bool = (l1 & l3) < 0L;
        if (((bool) && ((1L & this.mPol[(i + 1)]) == 1L)) || ((!bool) && ((this.mPol[(i + 1)] & 1L) == 0L))) {
          l1 = 0L;
        } else {
          l1 = 1L;
        }
        i += 1;
      }
      int k = this.mDegree;
      l3 = this.mPol[(this.mLength - 1)];
      i = 1;
      while (i < (k & 0x3F))
      {
        arrayOfLong2 = mBitmask;
        if ((arrayOfLong2[i] & l3) != 0L)
        {
          l2 = l1;
          if ((arrayOfLong2[(i - 1)] & l1) != 0L) {}
        }
        else
        {
          arrayOfLong2 = mBitmask;
          if ((arrayOfLong2[i] & l3) == 0L)
          {
            l2 = l1;
            if ((arrayOfLong2[(i - 1)] & l1) == 0L) {}
          }
          else
          {
            l2 = l1 ^ mBitmask[i];
          }
        }
        i += 1;
        l1 = l2;
      }
      arrayOfLong1[(this.mLength - 1)] = l1;
      return new GF2nONBElement((GF2nONBField)this.mField, arrayOfLong1);
    }
    throw new RuntimeException();
  }
  
  public GF2nElement square()
  {
    GF2nONBElement localGF2nONBElement = new GF2nONBElement(this);
    localGF2nONBElement.squareThis();
    return localGF2nONBElement;
  }
  
  public GF2nElement squareRoot()
  {
    GF2nONBElement localGF2nONBElement = new GF2nONBElement(this);
    localGF2nONBElement.squareRootThis();
    return localGF2nONBElement;
  }
  
  public void squareRootThis()
  {
    long[] arrayOfLong = getElement();
    int m = this.mLength - 1;
    int n = this.mBit;
    long l = mBitmask[63];
    int i;
    if ((arrayOfLong[0] & 1L) != 0L) {
      i = 1;
    } else {
      i = 0;
    }
    int k = m;
    for (int j = i; k >= 0; j = i)
    {
      if ((arrayOfLong[k] & 1L) != 0L) {
        i = 1;
      } else {
        i = 0;
      }
      arrayOfLong[k] >>>= 1;
      if (j != 0) {
        if (k == m) {
          arrayOfLong[k] ^= mBitmask[(n - 1)];
        } else {
          arrayOfLong[k] ^= l;
        }
      }
      k -= 1;
    }
    assign(arrayOfLong);
  }
  
  public void squareThis()
  {
    long[] arrayOfLong1 = getElement();
    int n = this.mLength - 1;
    int i1 = this.mBit - 1;
    long[] arrayOfLong2 = mBitmask;
    long l1 = arrayOfLong2[63];
    long l2 = arrayOfLong1[n];
    long l3 = arrayOfLong2[i1];
    int m = 0;
    if ((l2 & l3) != 0L) {
      i = 1;
    } else {
      i = 0;
    }
    int k = 0;
    for (int j = i; k < n; j = i)
    {
      if ((arrayOfLong1[k] & l1) != 0L) {
        i = 1;
      } else {
        i = 0;
      }
      arrayOfLong1[k] <<= 1;
      if (j != 0) {
        arrayOfLong1[k] = (1L ^ arrayOfLong1[k]);
      }
      k += 1;
    }
    int i = m;
    if ((arrayOfLong1[n] & mBitmask[i1]) != 0L) {
      i = 1;
    }
    arrayOfLong1[n] <<= 1;
    if (j != 0) {
      arrayOfLong1[n] ^= 1L;
    }
    if (i != 0)
    {
      l1 = arrayOfLong1[n];
      arrayOfLong1[n] = (mBitmask[(i1 + 1)] ^ l1);
    }
    assign(arrayOfLong1);
  }
  
  boolean testBit(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      if (paramInt > this.mDegree) {
        return false;
      }
      bool1 = bool2;
      if ((this.mPol[(paramInt >>> 6)] & mBitmask[(paramInt & 0x3F)]) != 0L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean testRightmostBit()
  {
    return (this.mPol[(this.mLength - 1)] & mBitmask[(this.mBit - 1)]) != 0L;
  }
  
  public byte[] toByteArray()
  {
    int j = (this.mDegree - 1 >> 3) + 1;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      long l = this.mPol[(i >>> 3)];
      int k = (i & 0x7) << 3;
      arrayOfByte[(j - i - 1)] = ((byte)(int)((l & 255L << k) >>> k));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public BigInteger toFlexiBigInt()
  {
    return new BigInteger(1, toByteArray());
  }
  
  public String toString()
  {
    return toString(16);
  }
  
  public String toString(int paramInt)
  {
    long[] arrayOfLong = getElement();
    int i = this.mBit;
    Object localObject2 = "";
    if (paramInt == 2)
    {
      paramInt = i - 1;
      while (paramInt >= 0)
      {
        if ((arrayOfLong[(arrayOfLong.length - 1)] & 1L << paramInt) == 0L)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("0");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("1");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        paramInt -= 1;
        localObject2 = localObject1;
      }
      paramInt = arrayOfLong.length - 2;
      for (;;)
      {
        localObject1 = localObject2;
        if (paramInt < 0) {
          break;
        }
        i = 63;
        while (i >= 0)
        {
          if ((arrayOfLong[paramInt] & mBitmask[i]) == 0L)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append("0");
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append("1");
          }
          localObject2 = ((StringBuilder)localObject1).toString();
          i -= 1;
        }
        paramInt -= 1;
      }
    }
    Object localObject1 = localObject2;
    if (paramInt == 16)
    {
      char[] arrayOfChar = new char[16];
      char[] tmp236_234 = arrayOfChar;
      tmp236_234[0] = 48;
      char[] tmp242_236 = tmp236_234;
      tmp242_236[1] = 49;
      char[] tmp248_242 = tmp242_236;
      tmp248_242[2] = 50;
      char[] tmp254_248 = tmp248_242;
      tmp254_248[3] = 51;
      char[] tmp260_254 = tmp254_248;
      tmp260_254[4] = 52;
      char[] tmp266_260 = tmp260_254;
      tmp266_260[5] = 53;
      char[] tmp272_266 = tmp266_260;
      tmp272_266[6] = 54;
      char[] tmp279_272 = tmp272_266;
      tmp279_272[7] = 55;
      char[] tmp286_279 = tmp279_272;
      tmp286_279[8] = 56;
      char[] tmp293_286 = tmp286_279;
      tmp293_286[9] = 57;
      char[] tmp300_293 = tmp293_286;
      tmp300_293[10] = 97;
      char[] tmp307_300 = tmp300_293;
      tmp307_300[11] = 98;
      char[] tmp314_307 = tmp307_300;
      tmp314_307[12] = 99;
      char[] tmp321_314 = tmp314_307;
      tmp321_314[13] = 100;
      char[] tmp328_321 = tmp321_314;
      tmp328_321[14] = 101;
      char[] tmp335_328 = tmp328_321;
      tmp335_328[15] = 102;
      tmp335_328;
      paramInt = arrayOfLong.length - 1;
      for (;;)
      {
        localObject1 = localObject2;
        if (paramInt < 0) {
          break;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(arrayOfChar[((int)(arrayOfLong[paramInt] >>> 60) & 0xF)]);
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(arrayOfChar[((int)(arrayOfLong[paramInt] >>> 56) & 0xF)]);
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(arrayOfChar[((int)(arrayOfLong[paramInt] >>> 52) & 0xF)]);
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(arrayOfChar[((int)(arrayOfLong[paramInt] >>> 48) & 0xF)]);
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(arrayOfChar[((int)(arrayOfLong[paramInt] >>> 44) & 0xF)]);
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(arrayOfChar[((int)(arrayOfLong[paramInt] >>> 40) & 0xF)]);
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(arrayOfChar[((int)(arrayOfLong[paramInt] >>> 36) & 0xF)]);
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(arrayOfChar[((int)(arrayOfLong[paramInt] >>> 32) & 0xF)]);
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(arrayOfChar[((int)(arrayOfLong[paramInt] >>> 28) & 0xF)]);
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(arrayOfChar[((int)(arrayOfLong[paramInt] >>> 24) & 0xF)]);
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(arrayOfChar[((int)(arrayOfLong[paramInt] >>> 20) & 0xF)]);
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(arrayOfChar[((int)(arrayOfLong[paramInt] >>> 16) & 0xF)]);
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(arrayOfChar[((int)(arrayOfLong[paramInt] >>> 12) & 0xF)]);
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(arrayOfChar[((int)(arrayOfLong[paramInt] >>> 8) & 0xF)]);
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(arrayOfChar[((int)(arrayOfLong[paramInt] >>> 4) & 0xF)]);
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(arrayOfChar[((int)arrayOfLong[paramInt] & 0xF)]);
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" ");
        localObject2 = ((StringBuilder)localObject2).toString();
        paramInt -= 1;
      }
    }
    return (String)localObject1;
  }
  
  public int trace()
  {
    int i1 = this.mLength - 1;
    int n = 0;
    int j = 0;
    int i = 0;
    int k;
    while (j < i1)
    {
      k = 0;
      while (k < 64)
      {
        m = i;
        if ((this.mPol[j] & mBitmask[k]) != 0L) {
          m = i ^ 0x1;
        }
        k += 1;
        i = m;
      }
      j += 1;
    }
    int m = this.mBit;
    j = i;
    i = n;
    while (i < m)
    {
      k = j;
      if ((this.mPol[i1] & mBitmask[i]) != 0L) {
        k = j ^ 0x1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\GF2nONBElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */