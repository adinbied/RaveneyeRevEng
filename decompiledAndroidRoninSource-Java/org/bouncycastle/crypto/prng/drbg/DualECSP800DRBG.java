package org.bouncycastle.crypto.prng.drbg;

import java.math.BigInteger;
import org.bouncycastle.asn1.nist.NISTNamedCurves;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.prng.EntropySource;
import org.bouncycastle.math.ec.ECCurve.Fp;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

public class DualECSP800DRBG
  implements SP80090DRBG
{
  private static final int MAX_ADDITIONAL_INPUT = 4096;
  private static final int MAX_ENTROPY_LENGTH = 4096;
  private static final int MAX_PERSONALIZATION_STRING = 4096;
  private static final long RESEED_MAX = 2147483648L;
  private static final DualECPoints[] nistPoints;
  private static final BigInteger p256_Px = new BigInteger("6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", 16);
  private static final BigInteger p256_Py = new BigInteger("4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5", 16);
  private static final BigInteger p256_Qx = new BigInteger("c97445f45cdef9f0d3e05e1e585fc297235b82b5be8ff3efca67c59852018192", 16);
  private static final BigInteger p256_Qy = new BigInteger("b28ef557ba31dfcbdd21ac46e2a91e3c304f44cb87058ada2cb815151e610046", 16);
  private static final BigInteger p384_Px = new BigInteger("aa87ca22be8b05378eb1c71ef320ad746e1d3b628ba79b9859f741e082542a385502f25dbf55296c3a545e3872760ab7", 16);
  private static final BigInteger p384_Py = new BigInteger("3617de4a96262c6f5d9e98bf9292dc29f8f41dbd289a147ce9da3113b5f0b8c00a60b1ce1d7e819d7a431d7c90ea0e5f", 16);
  private static final BigInteger p384_Qx = new BigInteger("8e722de3125bddb05580164bfe20b8b432216a62926c57502ceede31c47816edd1e89769124179d0b695106428815065", 16);
  private static final BigInteger p384_Qy = new BigInteger("023b1660dd701d0839fd45eec36f9ee7b32e13b315dc02610aa1b636e346df671f790f84c5e09b05674dbb7e45c803dd", 16);
  private static final BigInteger p521_Px = new BigInteger("c6858e06b70404e9cd9e3ecb662395b4429c648139053fb521f828af606b4d3dbaa14b5e77efe75928fe1dc127a2ffa8de3348b3c1856a429bf97e7e31c2e5bd66", 16);
  private static final BigInteger p521_Py = new BigInteger("11839296a789a3bc0045c8a5fb42c7d1bd998f54449579b446817afbd17273e662c97ee72995ef42640c550b9013fad0761353c7086a272c24088be94769fd16650", 16);
  private static final BigInteger p521_Qx = new BigInteger("1b9fa3e518d683c6b65763694ac8efbaec6fab44f2276171a42726507dd08add4c3b3f4c1ebc5b1222ddba077f722943b24c3edfa0f85fe24d0c8c01591f0be6f63", 16);
  private static final BigInteger p521_Qy = new BigInteger("1f3bdba585295d9a1110d1df1f9430ef8442c5018976ff3437ef91b81dc0b8132c8d5c39c32d0e004a3092b7d327c0e7a4d26d2c7b69b58f9066652911e457779de", 16);
  private ECPoint _P;
  private ECPoint _Q;
  private ECCurve.Fp _curve;
  private Digest _digest;
  private EntropySource _entropySource;
  private ECMultiplier _fixedPointMultiplier = new FixedPointCombMultiplier();
  private int _outlen;
  private long _reseedCounter;
  private byte[] _s;
  private int _sLength;
  private int _securityStrength;
  private int _seedlen;
  
  static
  {
    nistPoints = new DualECPoints[3];
    ECCurve.Fp localFp = (ECCurve.Fp)NISTNamedCurves.getByName("P-256").getCurve();
    nistPoints[0] = new DualECPoints(128, localFp.createPoint(p256_Px, p256_Py), localFp.createPoint(p256_Qx, p256_Qy), 1);
    localFp = (ECCurve.Fp)NISTNamedCurves.getByName("P-384").getCurve();
    nistPoints[1] = new DualECPoints(192, localFp.createPoint(p384_Px, p384_Py), localFp.createPoint(p384_Qx, p384_Qy), 1);
    localFp = (ECCurve.Fp)NISTNamedCurves.getByName("P-521").getCurve();
    nistPoints[2] = new DualECPoints(256, localFp.createPoint(p521_Px, p521_Py), localFp.createPoint(p521_Qx, p521_Qy), 1);
  }
  
  public DualECSP800DRBG(Digest paramDigest, int paramInt, EntropySource paramEntropySource, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this(nistPoints, paramDigest, paramInt, paramEntropySource, paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public DualECSP800DRBG(DualECPoints[] paramArrayOfDualECPoints, Digest paramDigest, int paramInt, EntropySource paramEntropySource, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this._digest = paramDigest;
    this._entropySource = paramEntropySource;
    this._securityStrength = paramInt;
    if (!Utils.isTooLarge(paramArrayOfByte1, 512))
    {
      if ((paramEntropySource.entropySize() >= paramInt) && (paramEntropySource.entropySize() <= 4096))
      {
        paramEntropySource = Arrays.concatenate(getEntropy(), paramArrayOfByte2, paramArrayOfByte1);
        int i = 0;
        while (i != paramArrayOfDualECPoints.length)
        {
          if (paramInt <= paramArrayOfDualECPoints[i].getSecurityStrength())
          {
            if (Utils.getMaxSecurityStrength(paramDigest) >= paramArrayOfDualECPoints[i].getSecurityStrength())
            {
              this._seedlen = paramArrayOfDualECPoints[i].getSeedLen();
              this._outlen = (paramArrayOfDualECPoints[i].getMaxOutlen() / 8);
              this._P = paramArrayOfDualECPoints[i].getP();
              this._Q = paramArrayOfDualECPoints[i].getQ();
              break;
            }
            throw new IllegalArgumentException("Requested security strength is not supported by digest");
          }
          i += 1;
        }
        if (this._P != null)
        {
          paramArrayOfDualECPoints = Utils.hash_df(this._digest, paramEntropySource, this._seedlen);
          this._s = paramArrayOfDualECPoints;
          this._sLength = paramArrayOfDualECPoints.length;
          this._reseedCounter = 0L;
          return;
        }
        throw new IllegalArgumentException("security strength cannot be greater than 256 bits");
      }
      paramArrayOfDualECPoints = new StringBuilder();
      paramArrayOfDualECPoints.append("EntropySource must provide between ");
      paramArrayOfDualECPoints.append(paramInt);
      paramArrayOfDualECPoints.append(" and ");
      paramArrayOfDualECPoints.append(4096);
      paramArrayOfDualECPoints.append(" bits");
      throw new IllegalArgumentException(paramArrayOfDualECPoints.toString());
    }
    throw new IllegalArgumentException("Personalization string too large");
  }
  
  private byte[] getEntropy()
  {
    byte[] arrayOfByte = this._entropySource.getEntropy();
    if (arrayOfByte.length >= (this._securityStrength + 7) / 8) {
      return arrayOfByte;
    }
    throw new IllegalStateException("Insufficient entropy provided by entropy source");
  }
  
  private BigInteger getScalarMultipleXCoord(ECPoint paramECPoint, BigInteger paramBigInteger)
  {
    return this._fixedPointMultiplier.multiply(paramECPoint, paramBigInteger).normalize().getAffineXCoord().toBigInteger();
  }
  
  private byte[] pad8(byte[] paramArrayOfByte, int paramInt)
  {
    paramInt %= 8;
    if (paramInt == 0) {
      return paramArrayOfByte;
    }
    int k = 8 - paramInt;
    paramInt = 0;
    int i = paramArrayOfByte.length - 1;
    while (i >= 0)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      paramArrayOfByte[i] = ((byte)(paramInt >> 8 - k | j << k));
      i -= 1;
      paramInt = j;
    }
    return paramArrayOfByte;
  }
  
  private byte[] xor(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte2 == null) {
      return paramArrayOfByte1;
    }
    int j = paramArrayOfByte1.length;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i != j)
    {
      arrayOfByte[i] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[i]));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public int generate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    int m = paramArrayOfByte1.length;
    int n = paramArrayOfByte1.length / this._outlen;
    if (!Utils.isTooLarge(paramArrayOfByte2, 512))
    {
      if (this._reseedCounter + n > 2147483648L) {
        return -1;
      }
      Object localObject = paramArrayOfByte2;
      if (paramBoolean)
      {
        reseed(paramArrayOfByte2);
        localObject = null;
      }
      if (localObject != null)
      {
        paramArrayOfByte2 = Utils.hash_df(this._digest, (byte[])localObject, this._seedlen);
        paramArrayOfByte2 = new BigInteger(1, xor(this._s, paramArrayOfByte2));
      }
      else
      {
        paramArrayOfByte2 = new BigInteger(1, this._s);
      }
      int k = 0;
      Arrays.fill(paramArrayOfByte1, (byte)0);
      int j = 0;
      int i = 0;
      int i1;
      while (j < n)
      {
        paramArrayOfByte2 = getScalarMultipleXCoord(this._P, paramArrayOfByte2);
        localObject = getScalarMultipleXCoord(this._Q, paramArrayOfByte2).toByteArray();
        i1 = localObject.length;
        int i2 = this._outlen;
        if (i1 > i2) {
          System.arraycopy(localObject, localObject.length - i2, paramArrayOfByte1, i, i2);
        } else {
          System.arraycopy(localObject, 0, paramArrayOfByte1, i2 - localObject.length + i, localObject.length);
        }
        i += this._outlen;
        this._reseedCounter += 1L;
        j += 1;
      }
      localObject = paramArrayOfByte2;
      if (i < paramArrayOfByte1.length)
      {
        localObject = getScalarMultipleXCoord(this._P, paramArrayOfByte2);
        paramArrayOfByte2 = getScalarMultipleXCoord(this._Q, (BigInteger)localObject).toByteArray();
        n = paramArrayOfByte1.length;
        j = paramArrayOfByte2.length;
        i1 = this._outlen;
        if (j > i1)
        {
          k = paramArrayOfByte2.length - i1;
          j = i;
        }
        else
        {
          j = i + (i1 - paramArrayOfByte2.length);
        }
        System.arraycopy(paramArrayOfByte2, k, paramArrayOfByte1, j, n - i);
        this._reseedCounter += 1L;
      }
      this._s = BigIntegers.asUnsignedByteArray(this._sLength, getScalarMultipleXCoord(this._P, (BigInteger)localObject));
      return m * 8;
    }
    throw new IllegalArgumentException("Additional input too large");
  }
  
  public int getBlockSize()
  {
    return this._outlen * 8;
  }
  
  public void reseed(byte[] paramArrayOfByte)
  {
    if (!Utils.isTooLarge(paramArrayOfByte, 512))
    {
      byte[] arrayOfByte = getEntropy();
      paramArrayOfByte = Arrays.concatenate(pad8(this._s, this._seedlen), arrayOfByte, paramArrayOfByte);
      this._s = Utils.hash_df(this._digest, paramArrayOfByte, this._seedlen);
      this._reseedCounter = 0L;
      return;
    }
    throw new IllegalArgumentException("Additional input string too large");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\prng\drbg\DualECSP800DRBG.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */