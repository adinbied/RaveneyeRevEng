package org.bouncycastle.crypto.engines;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Vector;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.params.NaccacheSternKeyParameters;
import org.bouncycastle.crypto.params.NaccacheSternPrivateKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;

public class NaccacheSternEngine
  implements AsymmetricBlockCipher
{
  private static BigInteger ONE = BigInteger.valueOf(1L);
  private static BigInteger ZERO = BigInteger.valueOf(0L);
  private boolean debug = false;
  private boolean forEncryption;
  private NaccacheSternKeyParameters key;
  private Vector[] lookup = null;
  
  private static BigInteger chineseRemainder(Vector paramVector1, Vector paramVector2)
  {
    BigInteger localBigInteger3 = ZERO;
    BigInteger localBigInteger1 = ONE;
    int k = 0;
    int i = 0;
    BigInteger localBigInteger2;
    int j;
    for (;;)
    {
      localBigInteger2 = localBigInteger3;
      j = k;
      if (i >= paramVector2.size()) {
        break;
      }
      localBigInteger1 = localBigInteger1.multiply((BigInteger)paramVector2.elementAt(i));
      i += 1;
    }
    while (j < paramVector2.size())
    {
      localBigInteger3 = (BigInteger)paramVector2.elementAt(j);
      BigInteger localBigInteger4 = localBigInteger1.divide(localBigInteger3);
      localBigInteger2 = localBigInteger2.add(localBigInteger4.multiply(localBigInteger4.modInverse(localBigInteger3)).multiply((BigInteger)paramVector1.elementAt(j)));
      j += 1;
    }
    return localBigInteger2.mod(localBigInteger1);
  }
  
  public byte[] addCryptedBlocks(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws InvalidCipherTextException
  {
    if (this.forEncryption)
    {
      if ((paramArrayOfByte1.length > getOutputBlockSize()) || (paramArrayOfByte2.length > getOutputBlockSize())) {
        throw new InvalidCipherTextException("BlockLength too large for simple addition.\n");
      }
    }
    else {
      if ((paramArrayOfByte1.length > getInputBlockSize()) || (paramArrayOfByte2.length > getInputBlockSize())) {
        break label248;
      }
    }
    Object localObject1 = new BigInteger(1, paramArrayOfByte1);
    paramArrayOfByte2 = new BigInteger(1, paramArrayOfByte2);
    paramArrayOfByte1 = ((BigInteger)localObject1).multiply(paramArrayOfByte2).mod(this.key.getModulus());
    if (this.debug)
    {
      Object localObject2 = System.out;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("c(m1) as BigInteger:....... ");
      localStringBuilder.append(localObject1);
      ((PrintStream)localObject2).println(localStringBuilder.toString());
      localObject1 = System.out;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("c(m2) as BigInteger:....... ");
      ((StringBuilder)localObject2).append(paramArrayOfByte2);
      ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
      paramArrayOfByte2 = System.out;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("c(m1)*c(m2)%n = c(m1+m2)%n: ");
      ((StringBuilder)localObject1).append(paramArrayOfByte1);
      paramArrayOfByte2.println(((StringBuilder)localObject1).toString());
    }
    paramArrayOfByte2 = this.key.getModulus().toByteArray();
    Arrays.fill(paramArrayOfByte2, (byte)0);
    System.arraycopy(paramArrayOfByte1.toByteArray(), 0, paramArrayOfByte2, paramArrayOfByte2.length - paramArrayOfByte1.toByteArray().length, paramArrayOfByte1.toByteArray().length);
    return paramArrayOfByte2;
    label248:
    throw new InvalidCipherTextException("BlockLength too large for simple addition.\n");
  }
  
  public byte[] encrypt(BigInteger paramBigInteger)
  {
    byte[] arrayOfByte = this.key.getModulus().toByteArray();
    Arrays.fill(arrayOfByte, (byte)0);
    paramBigInteger = this.key.getG().modPow(paramBigInteger, this.key.getModulus()).toByteArray();
    System.arraycopy(paramBigInteger, 0, arrayOfByte, arrayOfByte.length - paramBigInteger.length, paramBigInteger.length);
    if (this.debug)
    {
      paramBigInteger = System.out;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Encrypted value is:  ");
      localStringBuilder.append(new BigInteger(arrayOfByte));
      paramBigInteger.println(localStringBuilder.toString());
    }
    return arrayOfByte;
  }
  
  public int getInputBlockSize()
  {
    if (this.forEncryption) {
      return (this.key.getLowerSigmaBound() + 7) / 8 - 1;
    }
    return this.key.getModulus().toByteArray().length;
  }
  
  public int getOutputBlockSize()
  {
    if (this.forEncryption) {
      return this.key.getModulus().toByteArray().length;
    }
    return (this.key.getLowerSigmaBound() + 7) / 8 - 1;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    this.forEncryption = paramBoolean;
    Object localObject1 = paramCipherParameters;
    if ((paramCipherParameters instanceof ParametersWithRandom)) {
      localObject1 = ((ParametersWithRandom)paramCipherParameters).getParameters();
    }
    this.key = ((NaccacheSternKeyParameters)localObject1);
    if (!this.forEncryption)
    {
      if (this.debug) {
        System.out.println("Constructing lookup Array");
      }
      localObject1 = (NaccacheSternPrivateKeyParameters)this.key;
      Vector localVector = ((NaccacheSternPrivateKeyParameters)localObject1).getSmallPrimes();
      this.lookup = new Vector[localVector.size()];
      int i = 0;
      while (i < localVector.size())
      {
        BigInteger localBigInteger = (BigInteger)localVector.elementAt(i);
        int k = localBigInteger.intValue();
        this.lookup[i] = new Vector();
        this.lookup[i].addElement(ONE);
        Object localObject2;
        if (this.debug)
        {
          paramCipherParameters = System.out;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Constructing lookup ArrayList for ");
          ((StringBuilder)localObject2).append(k);
          paramCipherParameters.println(((StringBuilder)localObject2).toString());
        }
        paramCipherParameters = ZERO;
        int j = 1;
        while (j < k)
        {
          paramCipherParameters = paramCipherParameters.add(((NaccacheSternPrivateKeyParameters)localObject1).getPhi_n());
          localObject2 = paramCipherParameters.divide(localBigInteger);
          this.lookup[i].addElement(((NaccacheSternPrivateKeyParameters)localObject1).getG().modPow((BigInteger)localObject2, ((NaccacheSternPrivateKeyParameters)localObject1).getModulus()));
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  public byte[] processBlock(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidCipherTextException
  {
    if (this.key != null)
    {
      if (paramInt2 <= getInputBlockSize() + 1)
      {
        if ((!this.forEncryption) && (paramInt2 < getInputBlockSize())) {
          throw new InvalidCipherTextException("BlockLength does not match modulus for Naccache-Stern cipher.\n");
        }
        int i = 0;
        Object localObject1;
        if (paramInt1 == 0)
        {
          localObject1 = paramArrayOfByte;
          if (paramInt2 == paramArrayOfByte.length) {}
        }
        else
        {
          localObject1 = new byte[paramInt2];
          System.arraycopy(paramArrayOfByte, paramInt1, localObject1, 0, paramInt2);
        }
        Object localObject2 = new BigInteger(1, (byte[])localObject1);
        if (this.debug)
        {
          paramArrayOfByte = System.out;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("input as BigInteger: ");
          ((StringBuilder)localObject1).append(localObject2);
          paramArrayOfByte.println(((StringBuilder)localObject1).toString());
        }
        if (this.forEncryption) {
          return encrypt((BigInteger)localObject2);
        }
        Vector localVector = new Vector();
        NaccacheSternPrivateKeyParameters localNaccacheSternPrivateKeyParameters = (NaccacheSternPrivateKeyParameters)this.key;
        paramArrayOfByte = localNaccacheSternPrivateKeyParameters.getSmallPrimes();
        paramInt1 = 0;
        while (paramInt1 < paramArrayOfByte.size())
        {
          localObject1 = ((BigInteger)localObject2).modPow(localNaccacheSternPrivateKeyParameters.getPhi_n().divide((BigInteger)paramArrayOfByte.elementAt(paramInt1)), localNaccacheSternPrivateKeyParameters.getModulus());
          Vector[] arrayOfVector = this.lookup;
          Object localObject3 = arrayOfVector[paramInt1];
          if (arrayOfVector[paramInt1].size() != ((BigInteger)paramArrayOfByte.elementAt(paramInt1)).intValue())
          {
            if (this.debug)
            {
              localObject1 = System.out;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("Prime is ");
              ((StringBuilder)localObject2).append(paramArrayOfByte.elementAt(paramInt1));
              ((StringBuilder)localObject2).append(", lookup table has size ");
              ((StringBuilder)localObject2).append(((Vector)localObject3).size());
              ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Error in lookup Array for ");
            ((StringBuilder)localObject1).append(((BigInteger)paramArrayOfByte.elementAt(paramInt1)).intValue());
            ((StringBuilder)localObject1).append(": Size mismatch. Expected ArrayList with length ");
            ((StringBuilder)localObject1).append(((BigInteger)paramArrayOfByte.elementAt(paramInt1)).intValue());
            ((StringBuilder)localObject1).append(" but found ArrayList of length ");
            ((StringBuilder)localObject1).append(this.lookup[paramInt1].size());
            throw new InvalidCipherTextException(((StringBuilder)localObject1).toString());
          }
          paramInt2 = ((Vector)localObject3).indexOf(localObject1);
          if (paramInt2 == -1)
          {
            if (this.debug)
            {
              localObject2 = System.out;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("Actual prime is ");
              ((StringBuilder)localObject3).append(paramArrayOfByte.elementAt(paramInt1));
              ((PrintStream)localObject2).println(((StringBuilder)localObject3).toString());
              localObject2 = System.out;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("Decrypted value is ");
              ((StringBuilder)localObject3).append(localObject1);
              ((PrintStream)localObject2).println(((StringBuilder)localObject3).toString());
              localObject1 = System.out;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("LookupList for ");
              ((StringBuilder)localObject2).append(paramArrayOfByte.elementAt(paramInt1));
              ((StringBuilder)localObject2).append(" with size ");
              ((StringBuilder)localObject2).append(this.lookup[paramInt1].size());
              ((StringBuilder)localObject2).append(" is: ");
              ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
              paramInt2 = i;
              while (paramInt2 < this.lookup[paramInt1].size())
              {
                System.out.println(this.lookup[paramInt1].elementAt(paramInt2));
                paramInt2 += 1;
              }
            }
            throw new InvalidCipherTextException("Lookup failed");
          }
          localVector.addElement(BigInteger.valueOf(paramInt2));
          paramInt1 += 1;
        }
        return chineseRemainder(localVector, paramArrayOfByte).toByteArray();
      }
      throw new DataLengthException("input too large for Naccache-Stern cipher.\n");
    }
    throw new IllegalStateException("NaccacheStern engine not initialised");
  }
  
  public byte[] processData(byte[] paramArrayOfByte)
    throws InvalidCipherTextException
  {
    if (this.debug) {
      System.out.println();
    }
    if (paramArrayOfByte.length > getInputBlockSize())
    {
      int m = getInputBlockSize();
      int i = getOutputBlockSize();
      Object localObject1;
      if (this.debug)
      {
        localObject1 = System.out;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Input blocksize is:  ");
        ((StringBuilder)localObject2).append(m);
        ((StringBuilder)localObject2).append(" bytes");
        ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
        localObject1 = System.out;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Output blocksize is: ");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" bytes");
        ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
        localObject1 = System.out;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Data has length:.... ");
        ((StringBuilder)localObject2).append(paramArrayOfByte.length);
        ((StringBuilder)localObject2).append(" bytes");
        ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
      }
      Object localObject2 = new byte[(paramArrayOfByte.length / m + 1) * i];
      i = 0;
      int j = 0;
      while (i < paramArrayOfByte.length)
      {
        int k = i + m;
        if (k < paramArrayOfByte.length)
        {
          localObject1 = processBlock(paramArrayOfByte, i, m);
          i = k;
        }
        else
        {
          localObject1 = processBlock(paramArrayOfByte, i, paramArrayOfByte.length - i);
          i += paramArrayOfByte.length - i;
        }
        if (this.debug)
        {
          PrintStream localPrintStream = System.out;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("new datapos is ");
          localStringBuilder.append(i);
          localPrintStream.println(localStringBuilder.toString());
        }
        if (localObject1 != null)
        {
          System.arraycopy(localObject1, 0, localObject2, j, localObject1.length);
          j += localObject1.length;
        }
        else
        {
          if (this.debug) {
            System.out.println("cipher returned null");
          }
          throw new InvalidCipherTextException("cipher returned null");
        }
      }
      paramArrayOfByte = new byte[j];
      System.arraycopy(localObject2, 0, paramArrayOfByte, 0, j);
      if (this.debug)
      {
        localObject1 = System.out;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("returning ");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append(" bytes");
        ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
      }
      return paramArrayOfByte;
    }
    if (this.debug) {
      System.out.println("data size is less then input block size, processing directly");
    }
    return processBlock(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void setDebug(boolean paramBoolean)
  {
    this.debug = paramBoolean;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\NaccacheSternEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */