package org.bouncycastle.crypto.engines;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;

class RSACoreEngine
{
  private boolean forEncryption;
  private RSAKeyParameters key;
  
  public BigInteger convertInput(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= getInputBlockSize() + 1)
    {
      if ((paramInt2 == getInputBlockSize() + 1) && (!this.forEncryption)) {
        throw new DataLengthException("input too large for RSA cipher.");
      }
      byte[] arrayOfByte;
      if (paramInt1 == 0)
      {
        arrayOfByte = paramArrayOfByte;
        if (paramInt2 == paramArrayOfByte.length) {}
      }
      else
      {
        arrayOfByte = new byte[paramInt2];
        System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
      }
      paramArrayOfByte = new BigInteger(1, arrayOfByte);
      if (paramArrayOfByte.compareTo(this.key.getModulus()) < 0) {
        return paramArrayOfByte;
      }
      throw new DataLengthException("input too large for RSA cipher.");
    }
    throw new DataLengthException("input too large for RSA cipher.");
  }
  
  public byte[] convertOutput(BigInteger paramBigInteger)
  {
    paramBigInteger = paramBigInteger.toByteArray();
    int i;
    byte[] arrayOfByte;
    if (this.forEncryption)
    {
      if ((paramBigInteger[0] == 0) && (paramBigInteger.length > getOutputBlockSize()))
      {
        i = paramBigInteger.length - 1;
        arrayOfByte = new byte[i];
        System.arraycopy(paramBigInteger, 1, arrayOfByte, 0, i);
        return arrayOfByte;
      }
      if (paramBigInteger.length < getOutputBlockSize())
      {
        i = getOutputBlockSize();
        arrayOfByte = new byte[i];
        System.arraycopy(paramBigInteger, 0, arrayOfByte, i - paramBigInteger.length, paramBigInteger.length);
        return arrayOfByte;
      }
    }
    else if (paramBigInteger[0] == 0)
    {
      i = paramBigInteger.length - 1;
      arrayOfByte = new byte[i];
      System.arraycopy(paramBigInteger, 1, arrayOfByte, 0, i);
      return arrayOfByte;
    }
    return paramBigInteger;
  }
  
  public int getInputBlockSize()
  {
    int i = this.key.getModulus().bitLength();
    boolean bool = this.forEncryption;
    int j = (i + 7) / 8;
    i = j;
    if (bool) {
      i = j - 1;
    }
    return i;
  }
  
  public int getOutputBlockSize()
  {
    int i = this.key.getModulus().bitLength();
    boolean bool = this.forEncryption;
    i = (i + 7) / 8;
    if (bool) {
      return i;
    }
    return i - 1;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    CipherParameters localCipherParameters = paramCipherParameters;
    if ((paramCipherParameters instanceof ParametersWithRandom)) {
      localCipherParameters = ((ParametersWithRandom)paramCipherParameters).getParameters();
    }
    this.key = ((RSAKeyParameters)localCipherParameters);
    this.forEncryption = paramBoolean;
  }
  
  public BigInteger processBlock(BigInteger paramBigInteger)
  {
    Object localObject1 = this.key;
    if ((localObject1 instanceof RSAPrivateCrtKeyParameters))
    {
      Object localObject2 = (RSAPrivateCrtKeyParameters)localObject1;
      localObject1 = ((RSAPrivateCrtKeyParameters)localObject2).getP();
      BigInteger localBigInteger1 = ((RSAPrivateCrtKeyParameters)localObject2).getQ();
      BigInteger localBigInteger3 = ((RSAPrivateCrtKeyParameters)localObject2).getDP();
      BigInteger localBigInteger2 = ((RSAPrivateCrtKeyParameters)localObject2).getDQ();
      localObject2 = ((RSAPrivateCrtKeyParameters)localObject2).getQInv();
      localBigInteger3 = paramBigInteger.remainder((BigInteger)localObject1).modPow(localBigInteger3, (BigInteger)localObject1);
      paramBigInteger = paramBigInteger.remainder(localBigInteger1).modPow(localBigInteger2, localBigInteger1);
      return localBigInteger3.subtract(paramBigInteger).multiply((BigInteger)localObject2).mod((BigInteger)localObject1).multiply(localBigInteger1).add(paramBigInteger);
    }
    return paramBigInteger.modPow(((RSAKeyParameters)localObject1).getExponent(), this.key.getModulus());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\RSACoreEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */