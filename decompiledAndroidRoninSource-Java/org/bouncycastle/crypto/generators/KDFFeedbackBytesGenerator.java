package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.MacDerivationFunction;
import org.bouncycastle.crypto.params.KDFFeedbackParameters;
import org.bouncycastle.crypto.params.KeyParameter;

public class KDFFeedbackBytesGenerator
  implements MacDerivationFunction
{
  private static final BigInteger INTEGER_MAX = BigInteger.valueOf(2147483647L);
  private static final BigInteger TWO = BigInteger.valueOf(2L);
  private byte[] fixedInputData;
  private int generatedBytes;
  private final int h;
  private byte[] ios;
  private byte[] iv;
  private byte[] k;
  private int maxSizeExcl;
  private final Mac prf;
  private boolean useCounter;
  
  public KDFFeedbackBytesGenerator(Mac paramMac)
  {
    this.prf = paramMac;
    int i = paramMac.getMacSize();
    this.h = i;
    this.k = new byte[i];
  }
  
  private void generateNext()
  {
    if (this.generatedBytes == 0)
    {
      localObject = this.prf;
      arrayOfByte = this.iv;
      ((Mac)localObject).update(arrayOfByte, 0, arrayOfByte.length);
    }
    else
    {
      localObject = this.prf;
      arrayOfByte = this.k;
      ((Mac)localObject).update(arrayOfByte, 0, arrayOfByte.length);
    }
    if (this.useCounter)
    {
      int i = this.generatedBytes / this.h + 1;
      localObject = this.ios;
      int j = localObject.length;
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3) {
            if (j == 4) {
              localObject[0] = ((byte)(i >>> 24));
            } else {
              throw new IllegalStateException("Unsupported size of counter i");
            }
          }
          localObject = this.ios;
          localObject[(localObject.length - 3)] = ((byte)(i >>> 16));
        }
        localObject = this.ios;
        localObject[(localObject.length - 2)] = ((byte)(i >>> 8));
      }
      localObject = this.ios;
      localObject[(localObject.length - 1)] = ((byte)i);
      this.prf.update((byte[])localObject, 0, localObject.length);
    }
    Object localObject = this.prf;
    byte[] arrayOfByte = this.fixedInputData;
    ((Mac)localObject).update(arrayOfByte, 0, arrayOfByte.length);
    this.prf.doFinal(this.k, 0);
  }
  
  public int generateBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws DataLengthException, IllegalArgumentException
  {
    int i = this.generatedBytes;
    int j = i + paramInt2;
    if ((j >= 0) && (j < this.maxSizeExcl))
    {
      if (i % this.h == 0) {
        generateNext();
      }
      j = this.generatedBytes;
      int m = this.h;
      i = Math.min(m - j % m, paramInt2);
      System.arraycopy(this.k, j % m, paramArrayOfByte, paramInt1, i);
      this.generatedBytes += i;
      m = paramInt2 - i;
      j = paramInt1;
      paramInt1 = m;
      for (;;)
      {
        j += i;
        if (paramInt1 <= 0) {
          break;
        }
        generateNext();
        i = Math.min(this.h, paramInt1);
        System.arraycopy(this.k, 0, paramArrayOfByte, j, i);
        this.generatedBytes += i;
        paramInt1 -= i;
      }
      return paramInt2;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("Current KDFCTR may only be used for ");
    paramArrayOfByte.append(this.maxSizeExcl);
    paramArrayOfByte.append(" bytes");
    throw new DataLengthException(paramArrayOfByte.toString());
  }
  
  public Mac getMac()
  {
    return this.prf;
  }
  
  public void init(DerivationParameters paramDerivationParameters)
  {
    if ((paramDerivationParameters instanceof KDFFeedbackParameters))
    {
      paramDerivationParameters = (KDFFeedbackParameters)paramDerivationParameters;
      this.prf.init(new KeyParameter(paramDerivationParameters.getKI()));
      this.fixedInputData = paramDerivationParameters.getFixedInputData();
      int m = paramDerivationParameters.getR();
      this.ios = new byte[m / 8];
      boolean bool = paramDerivationParameters.useCounter();
      int j = Integer.MAX_VALUE;
      int i = j;
      if (bool)
      {
        BigInteger localBigInteger = TWO.pow(m).multiply(BigInteger.valueOf(this.h));
        if (localBigInteger.compareTo(INTEGER_MAX) == 1) {
          i = j;
        } else {
          i = localBigInteger.intValue();
        }
      }
      this.maxSizeExcl = i;
      this.iv = paramDerivationParameters.getIV();
      this.useCounter = paramDerivationParameters.useCounter();
      this.generatedBytes = 0;
      return;
    }
    throw new IllegalArgumentException("Wrong type of arguments given");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\KDFFeedbackBytesGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */