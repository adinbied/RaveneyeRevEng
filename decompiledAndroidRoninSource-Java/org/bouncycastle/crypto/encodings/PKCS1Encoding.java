package org.bouncycastle.crypto.encodings;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;

public class PKCS1Encoding
  implements AsymmetricBlockCipher
{
  private static final int HEADER_LENGTH = 10;
  public static final String NOT_STRICT_LENGTH_ENABLED_PROPERTY = "org.bouncycastle.pkcs1.not_strict";
  public static final String STRICT_LENGTH_ENABLED_PROPERTY = "org.bouncycastle.pkcs1.strict";
  private byte[] blockBuffer;
  private AsymmetricBlockCipher engine;
  private byte[] fallback = null;
  private boolean forEncryption;
  private boolean forPrivateKey;
  private int pLen = -1;
  private SecureRandom random;
  private boolean useStrictLength;
  
  public PKCS1Encoding(AsymmetricBlockCipher paramAsymmetricBlockCipher)
  {
    this.engine = paramAsymmetricBlockCipher;
    this.useStrictLength = useStrict();
  }
  
  public PKCS1Encoding(AsymmetricBlockCipher paramAsymmetricBlockCipher, int paramInt)
  {
    this.engine = paramAsymmetricBlockCipher;
    this.useStrictLength = useStrict();
    this.pLen = paramInt;
  }
  
  public PKCS1Encoding(AsymmetricBlockCipher paramAsymmetricBlockCipher, byte[] paramArrayOfByte)
  {
    this.engine = paramAsymmetricBlockCipher;
    this.useStrictLength = useStrict();
    this.fallback = paramArrayOfByte;
    this.pLen = paramArrayOfByte.length;
  }
  
  private static int checkPkcs1Encoding(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0x0 | paramArrayOfByte[0] ^ 0x2;
    int j = paramArrayOfByte.length;
    int k = paramInt + 1;
    paramInt = 1;
    while (paramInt < j - k)
    {
      int m = paramArrayOfByte[paramInt];
      m |= m >> 1;
      m |= m >> 2;
      i |= ((m | m >> 4) & 0x1) - 1;
      paramInt += 1;
    }
    paramInt = paramArrayOfByte[(paramArrayOfByte.length - k)] | i;
    paramInt |= paramInt >> 1;
    paramInt |= paramInt >> 2;
    return ((paramInt | paramInt >> 4) & 0x1) - 1;
  }
  
  private byte[] decodeBlock(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidCipherTextException
  {
    if (this.pLen != -1) {
      return decodeBlockOrRandom(paramArrayOfByte, paramInt1, paramInt2);
    }
    byte[] arrayOfByte = this.engine.processBlock(paramArrayOfByte, paramInt1, paramInt2);
    int k = this.useStrictLength;
    paramInt1 = arrayOfByte.length;
    paramInt2 = this.engine.getOutputBlockSize();
    int i = 1;
    if (paramInt1 != paramInt2) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    paramArrayOfByte = arrayOfByte;
    if (arrayOfByte.length < getOutputBlockSize()) {
      paramArrayOfByte = this.blockBuffer;
    }
    byte b = paramArrayOfByte[0];
    if (this.forPrivateKey) {
      if (b == 2) {}
    }
    for (;;)
    {
      paramInt2 = 1;
      break;
      do
      {
        paramInt2 = 0;
        break;
      } while (b == 1);
    }
    int j = findStart(b, paramArrayOfByte) + 1;
    if (j >= 10) {
      i = 0;
    }
    if ((paramInt2 | i) == 0)
    {
      if ((k & paramInt1) == 0)
      {
        paramInt1 = paramArrayOfByte.length - j;
        arrayOfByte = new byte[paramInt1];
        System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, paramInt1);
        return arrayOfByte;
      }
      Arrays.fill(paramArrayOfByte, (byte)0);
      throw new InvalidCipherTextException("block incorrect size");
    }
    Arrays.fill(paramArrayOfByte, (byte)0);
    throw new InvalidCipherTextException("block incorrect");
  }
  
  private byte[] decodeBlockOrRandom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidCipherTextException
  {
    if (this.forPrivateKey)
    {
      byte[] arrayOfByte1 = this.engine.processBlock(paramArrayOfByte, paramInt1, paramInt2);
      byte[] arrayOfByte2 = this.fallback;
      paramArrayOfByte = arrayOfByte2;
      if (arrayOfByte2 == null)
      {
        paramArrayOfByte = new byte[this.pLen];
        this.random.nextBytes(paramArrayOfByte);
      }
      int j = this.useStrictLength;
      if (arrayOfByte1.length != this.engine.getOutputBlockSize()) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if ((j & paramInt1) != 0) {
        arrayOfByte1 = this.blockBuffer;
      }
      paramInt2 = checkPkcs1Encoding(arrayOfByte1, this.pLen);
      arrayOfByte2 = new byte[this.pLen];
      paramInt1 = 0;
      for (;;)
      {
        int i = this.pLen;
        if (paramInt1 >= i) {
          break;
        }
        arrayOfByte2[paramInt1] = ((byte)(arrayOfByte1[(arrayOfByte1.length - i + paramInt1)] & paramInt2 | paramArrayOfByte[paramInt1] & paramInt2));
        paramInt1 += 1;
      }
      Arrays.fill(arrayOfByte1, (byte)0);
      return arrayOfByte2;
    }
    throw new InvalidCipherTextException("sorry, this method is only for decryption, not for signing");
  }
  
  private byte[] encodeBlock(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidCipherTextException
  {
    if (paramInt2 <= getInputBlockSize())
    {
      int j = this.engine.getInputBlockSize();
      byte[] arrayOfByte = new byte[j];
      if (this.forPrivateKey)
      {
        arrayOfByte[0] = 1;
        i = 1;
        while (i != j - paramInt2 - 1)
        {
          arrayOfByte[i] = -1;
          i += 1;
        }
      }
      this.random.nextBytes(arrayOfByte);
      arrayOfByte[0] = 2;
      int i = 1;
      while (i != j - paramInt2 - 1)
      {
        while (arrayOfByte[i] == 0) {
          arrayOfByte[i] = ((byte)this.random.nextInt());
        }
        i += 1;
      }
      i = j - paramInt2;
      arrayOfByte[(i - 1)] = 0;
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, i, paramInt2);
      return this.engine.processBlock(arrayOfByte, 0, j);
    }
    throw new IllegalArgumentException("input data too large");
  }
  
  private int findStart(byte paramByte, byte[] paramArrayOfByte)
    throws InvalidCipherTextException
  {
    int i = 1;
    int j = 0;
    int k = -1;
    while (i != paramArrayOfByte.length)
    {
      int i1 = paramArrayOfByte[i];
      int m;
      if (i1 == 0) {
        m = 1;
      } else {
        m = 0;
      }
      int n;
      if (k < 0) {
        n = 1;
      } else {
        n = 0;
      }
      if ((m & n) != 0) {
        k = i;
      }
      if (paramByte == 1) {
        m = 1;
      } else {
        m = 0;
      }
      if (k < 0) {
        n = 1;
      } else {
        n = 0;
      }
      if (i1 != -1) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      j |= i1 & m & n;
      i += 1;
    }
    if (j != 0) {
      return -1;
    }
    return k;
  }
  
  private boolean useStrict()
  {
    String str1 = (String)AccessController.doPrivileged(new PrivilegedAction()
    {
      public Object run()
      {
        return System.getProperty("org.bouncycastle.pkcs1.strict");
      }
    });
    String str2 = (String)AccessController.doPrivileged(new PrivilegedAction()
    {
      public Object run()
      {
        return System.getProperty("org.bouncycastle.pkcs1.not_strict");
      }
    });
    boolean bool = true;
    if (str2 != null) {
      return str2.equals("true") ^ true;
    }
    if (str1 != null)
    {
      if (str1.equals("true")) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public int getInputBlockSize()
  {
    int j = this.engine.getInputBlockSize();
    int i = j;
    if (this.forEncryption) {
      i = j - 10;
    }
    return i;
  }
  
  public int getOutputBlockSize()
  {
    int i = this.engine.getOutputBlockSize();
    if (this.forEncryption) {
      return i;
    }
    return i - 10;
  }
  
  public AsymmetricBlockCipher getUnderlyingCipher()
  {
    return this.engine;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    Object localObject;
    if ((paramCipherParameters instanceof ParametersWithRandom))
    {
      localObject = (ParametersWithRandom)paramCipherParameters;
      this.random = ((ParametersWithRandom)localObject).getRandom();
      localObject = (AsymmetricKeyParameter)((ParametersWithRandom)localObject).getParameters();
    }
    else
    {
      AsymmetricKeyParameter localAsymmetricKeyParameter = (AsymmetricKeyParameter)paramCipherParameters;
      localObject = localAsymmetricKeyParameter;
      if (!localAsymmetricKeyParameter.isPrivate())
      {
        localObject = localAsymmetricKeyParameter;
        if (paramBoolean)
        {
          this.random = new SecureRandom();
          localObject = localAsymmetricKeyParameter;
        }
      }
    }
    this.engine.init(paramBoolean, paramCipherParameters);
    this.forPrivateKey = ((AsymmetricKeyParameter)localObject).isPrivate();
    this.forEncryption = paramBoolean;
    this.blockBuffer = new byte[this.engine.getOutputBlockSize()];
    if ((this.pLen > 0) && (this.fallback == null))
    {
      if (this.random != null) {
        return;
      }
      throw new IllegalArgumentException("encoder requires random");
    }
  }
  
  public byte[] processBlock(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidCipherTextException
  {
    if (this.forEncryption) {
      return encodeBlock(paramArrayOfByte, paramInt1, paramInt2);
    }
    return decodeBlock(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\encodings\PKCS1Encoding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */