package org.bouncycastle.crypto.engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.CramerShoupKeyParameters;
import org.bouncycastle.crypto.params.CramerShoupParameters;
import org.bouncycastle.crypto.params.CramerShoupPrivateKeyParameters;
import org.bouncycastle.crypto.params.CramerShoupPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.BigIntegers;

public class CramerShoupCoreEngine
{
  private static final BigInteger ONE = BigInteger.valueOf(1L);
  private boolean forEncryption;
  private CramerShoupKeyParameters key;
  private String label = null;
  private SecureRandom random;
  
  private BigInteger generateRandomElement(BigInteger paramBigInteger, SecureRandom paramSecureRandom)
  {
    BigInteger localBigInteger = ONE;
    return BigIntegers.createRandomInRange(localBigInteger, paramBigInteger.subtract(localBigInteger), paramSecureRandom);
  }
  
  private boolean isValidMessage(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    return paramBigInteger1.compareTo(paramBigInteger2) < 0;
  }
  
  public BigInteger convertInput(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= getInputBlockSize() + 1)
    {
      if ((paramInt2 == getInputBlockSize() + 1) && (this.forEncryption)) {
        throw new DataLengthException("input too large for Cramer Shoup cipher.");
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
      if (paramArrayOfByte.compareTo(this.key.getParameters().getP()) < 0) {
        return paramArrayOfByte;
      }
      throw new DataLengthException("input too large for Cramer Shoup cipher.");
    }
    throw new DataLengthException("input too large for Cramer Shoup cipher.");
  }
  
  public byte[] convertOutput(BigInteger paramBigInteger)
  {
    paramBigInteger = paramBigInteger.toByteArray();
    int i;
    byte[] arrayOfByte;
    if (!this.forEncryption)
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
  
  public BigInteger decryptBlock(CramerShoupCiphertext paramCramerShoupCiphertext)
    throws CramerShoupCoreEngine.CramerShoupCiphertextException
  {
    if ((this.key.isPrivate()) && (!this.forEncryption))
    {
      Object localObject1 = this.key;
      if ((localObject1 instanceof CramerShoupPrivateKeyParameters))
      {
        localObject1 = (CramerShoupPrivateKeyParameters)localObject1;
        BigInteger localBigInteger = ((CramerShoupPrivateKeyParameters)localObject1).getParameters().getP();
        Object localObject2 = ((CramerShoupPrivateKeyParameters)localObject1).getParameters().getH();
        Object localObject3 = paramCramerShoupCiphertext.getU1().toByteArray();
        ((Digest)localObject2).update((byte[])localObject3, 0, localObject3.length);
        localObject3 = paramCramerShoupCiphertext.getU2().toByteArray();
        ((Digest)localObject2).update((byte[])localObject3, 0, localObject3.length);
        localObject3 = paramCramerShoupCiphertext.getE().toByteArray();
        ((Digest)localObject2).update((byte[])localObject3, 0, localObject3.length);
        localObject3 = this.label;
        if (localObject3 != null)
        {
          localObject3 = ((String)localObject3).getBytes();
          ((Digest)localObject2).update((byte[])localObject3, 0, localObject3.length);
        }
        localObject3 = new byte[((Digest)localObject2).getDigestSize()];
        ((Digest)localObject2).doFinal((byte[])localObject3, 0);
        localObject2 = new BigInteger(1, (byte[])localObject3);
        localObject2 = paramCramerShoupCiphertext.u1.modPow(((CramerShoupPrivateKeyParameters)localObject1).getX1().add(((CramerShoupPrivateKeyParameters)localObject1).getY1().multiply((BigInteger)localObject2)), localBigInteger).multiply(paramCramerShoupCiphertext.u2.modPow(((CramerShoupPrivateKeyParameters)localObject1).getX2().add(((CramerShoupPrivateKeyParameters)localObject1).getY2().multiply((BigInteger)localObject2)), localBigInteger)).mod(localBigInteger);
        if (paramCramerShoupCiphertext.v.equals(localObject2)) {
          return paramCramerShoupCiphertext.e.multiply(paramCramerShoupCiphertext.u1.modPow(((CramerShoupPrivateKeyParameters)localObject1).getZ(), localBigInteger).modInverse(localBigInteger)).mod(localBigInteger);
        }
        throw new CramerShoupCiphertextException("Sorry, that ciphertext is not correct");
      }
    }
    return null;
  }
  
  public CramerShoupCiphertext encryptBlock(BigInteger paramBigInteger)
  {
    boolean bool = this.key.isPrivate();
    BigInteger localBigInteger1 = null;
    Object localObject1 = localBigInteger1;
    if (!bool)
    {
      localObject1 = localBigInteger1;
      if (this.forEncryption)
      {
        Object localObject2 = this.key;
        localObject1 = localBigInteger1;
        if ((localObject2 instanceof CramerShoupPublicKeyParameters))
        {
          localObject1 = (CramerShoupPublicKeyParameters)localObject2;
          localBigInteger1 = ((CramerShoupPublicKeyParameters)localObject1).getParameters().getP();
          BigInteger localBigInteger2 = ((CramerShoupPublicKeyParameters)localObject1).getParameters().getG1();
          BigInteger localBigInteger3 = ((CramerShoupPublicKeyParameters)localObject1).getParameters().getG2();
          Object localObject3 = ((CramerShoupPublicKeyParameters)localObject1).getH();
          if (!isValidMessage(paramBigInteger, localBigInteger1)) {
            return null;
          }
          localObject2 = generateRandomElement(localBigInteger1, this.random);
          localBigInteger2 = localBigInteger2.modPow((BigInteger)localObject2, localBigInteger1);
          localBigInteger3 = localBigInteger3.modPow((BigInteger)localObject2, localBigInteger1);
          paramBigInteger = ((BigInteger)localObject3).modPow((BigInteger)localObject2, localBigInteger1).multiply(paramBigInteger).mod(localBigInteger1);
          localObject3 = ((CramerShoupPublicKeyParameters)localObject1).getParameters().getH();
          Object localObject4 = localBigInteger2.toByteArray();
          ((Digest)localObject3).update((byte[])localObject4, 0, localObject4.length);
          localObject4 = localBigInteger3.toByteArray();
          ((Digest)localObject3).update((byte[])localObject4, 0, localObject4.length);
          localObject4 = paramBigInteger.toByteArray();
          ((Digest)localObject3).update((byte[])localObject4, 0, localObject4.length);
          localObject4 = this.label;
          if (localObject4 != null)
          {
            localObject4 = ((String)localObject4).getBytes();
            ((Digest)localObject3).update((byte[])localObject4, 0, localObject4.length);
          }
          localObject4 = new byte[((Digest)localObject3).getDigestSize()];
          ((Digest)localObject3).doFinal((byte[])localObject4, 0);
          localObject3 = new BigInteger(1, (byte[])localObject4);
          localObject1 = new CramerShoupCiphertext(localBigInteger2, localBigInteger3, paramBigInteger, ((CramerShoupPublicKeyParameters)localObject1).getC().modPow((BigInteger)localObject2, localBigInteger1).multiply(((CramerShoupPublicKeyParameters)localObject1).getD().modPow(((BigInteger)localObject2).multiply((BigInteger)localObject3), localBigInteger1)).mod(localBigInteger1));
        }
      }
    }
    return (CramerShoupCiphertext)localObject1;
  }
  
  public int getInputBlockSize()
  {
    int i = this.key.getParameters().getP().bitLength();
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
    int i = this.key.getParameters().getP().bitLength();
    boolean bool = this.forEncryption;
    i = (i + 7) / 8;
    if (bool) {
      return i;
    }
    return i - 1;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof ParametersWithRandom))
    {
      paramCipherParameters = (ParametersWithRandom)paramCipherParameters;
      this.key = ((CramerShoupKeyParameters)paramCipherParameters.getParameters());
      paramCipherParameters = paramCipherParameters.getRandom();
    }
    else
    {
      this.key = ((CramerShoupKeyParameters)paramCipherParameters);
      paramCipherParameters = null;
    }
    this.random = initSecureRandom(paramBoolean, paramCipherParameters);
    this.forEncryption = paramBoolean;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters, String paramString)
  {
    init(paramBoolean, paramCipherParameters);
    this.label = paramString;
  }
  
  protected SecureRandom initSecureRandom(boolean paramBoolean, SecureRandom paramSecureRandom)
  {
    if (!paramBoolean) {
      return null;
    }
    if (paramSecureRandom != null) {
      return paramSecureRandom;
    }
    return new SecureRandom();
  }
  
  public static class CramerShoupCiphertextException
    extends Exception
  {
    private static final long serialVersionUID = -6360977166495345076L;
    
    public CramerShoupCiphertextException(String paramString)
    {
      super();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\CramerShoupCoreEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */