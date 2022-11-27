package org.bouncycastle.crypto.engines;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.EphemeralKeyPair;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.KeyParser;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.generators.EphemeralKeyPairGenerator;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.IESParameters;
import org.bouncycastle.crypto.params.IESWithCipherParameters;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Pack;

public class IESEngine
{
  private byte[] IV;
  byte[] V;
  BasicAgreement agree;
  BufferedBlockCipher cipher;
  boolean forEncryption;
  DerivationFunction kdf;
  private EphemeralKeyPairGenerator keyPairGenerator;
  private KeyParser keyParser;
  Mac mac;
  byte[] macBuf;
  IESParameters param;
  CipherParameters privParam;
  CipherParameters pubParam;
  
  public IESEngine(BasicAgreement paramBasicAgreement, DerivationFunction paramDerivationFunction, Mac paramMac)
  {
    this.agree = paramBasicAgreement;
    this.kdf = paramDerivationFunction;
    this.mac = paramMac;
    this.macBuf = new byte[paramMac.getMacSize()];
    this.cipher = null;
  }
  
  public IESEngine(BasicAgreement paramBasicAgreement, DerivationFunction paramDerivationFunction, Mac paramMac, BufferedBlockCipher paramBufferedBlockCipher)
  {
    this.agree = paramBasicAgreement;
    this.kdf = paramDerivationFunction;
    this.mac = paramMac;
    this.macBuf = new byte[paramMac.getMacSize()];
    this.cipher = paramBufferedBlockCipher;
  }
  
  private byte[] decryptBlock(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidCipherTextException
  {
    if (paramInt2 >= this.V.length + this.mac.getMacSize())
    {
      int i;
      int k;
      Object localObject1;
      if (this.cipher == null)
      {
        j = paramInt2 - this.V.length - this.mac.getMacSize();
        arrayOfByte1 = new byte[j];
        i = this.param.getMacKeySize() / 8;
        localObject2 = new byte[i];
        k = j + i;
        localObject1 = new byte[k];
        this.kdf.generateBytes((byte[])localObject1, 0, k);
        if (this.V.length != 0)
        {
          System.arraycopy(localObject1, 0, localObject2, 0, i);
          System.arraycopy(localObject1, i, arrayOfByte1, 0, j);
        }
        else
        {
          System.arraycopy(localObject1, 0, arrayOfByte1, 0, j);
          System.arraycopy(localObject1, j, localObject2, 0, i);
        }
        localObject1 = new byte[j];
        i = 0;
        while (i != j)
        {
          localObject1[i] = ((byte)(paramArrayOfByte[(this.V.length + paramInt1 + i)] ^ arrayOfByte1[i]));
          i += 1;
        }
        i = 0;
      }
      else
      {
        i = ((IESWithCipherParameters)this.param).getCipherKeySize() / 8;
        localObject2 = new byte[i];
        j = this.param.getMacKeySize() / 8;
        arrayOfByte1 = new byte[j];
        k = i + j;
        localObject1 = new byte[k];
        this.kdf.generateBytes((byte[])localObject1, 0, k);
        System.arraycopy(localObject1, 0, localObject2, 0, i);
        System.arraycopy(localObject1, i, arrayOfByte1, 0, j);
        if (this.IV != null)
        {
          localObject1 = this.cipher;
          localObject2 = new ParametersWithIV(new KeyParameter((byte[])localObject2), this.IV);
        }
        else
        {
          localObject1 = this.cipher;
          localObject2 = new KeyParameter((byte[])localObject2);
        }
        ((BufferedBlockCipher)localObject1).init(false, (CipherParameters)localObject2);
        localObject1 = new byte[this.cipher.getOutputSize(paramInt2 - this.V.length - this.mac.getMacSize())];
        localObject2 = this.cipher;
        arrayOfByte2 = this.V;
        i = ((BufferedBlockCipher)localObject2).processBytes(paramArrayOfByte, paramInt1 + arrayOfByte2.length, paramInt2 - arrayOfByte2.length - this.mac.getMacSize(), (byte[])localObject1, 0);
        localObject2 = arrayOfByte1;
      }
      byte[] arrayOfByte2 = this.param.getEncodingV();
      byte[] arrayOfByte1 = null;
      if (this.V.length != 0) {
        arrayOfByte1 = getLengthTag(arrayOfByte2);
      }
      int j = paramInt1 + paramInt2;
      byte[] arrayOfByte3 = Arrays.copyOfRange(paramArrayOfByte, j - this.mac.getMacSize(), j);
      j = arrayOfByte3.length;
      byte[] arrayOfByte4 = new byte[j];
      this.mac.init(new KeyParameter((byte[])localObject2));
      Object localObject2 = this.mac;
      byte[] arrayOfByte5 = this.V;
      ((Mac)localObject2).update(paramArrayOfByte, paramInt1 + arrayOfByte5.length, paramInt2 - arrayOfByte5.length - j);
      if (arrayOfByte2 != null) {
        this.mac.update(arrayOfByte2, 0, arrayOfByte2.length);
      }
      if (this.V.length != 0) {
        this.mac.update(arrayOfByte1, 0, arrayOfByte1.length);
      }
      this.mac.doFinal(arrayOfByte4, 0);
      if (Arrays.constantTimeAreEqual(arrayOfByte3, arrayOfByte4))
      {
        paramArrayOfByte = this.cipher;
        if (paramArrayOfByte == null) {
          return (byte[])localObject1;
        }
        return Arrays.copyOfRange((byte[])localObject1, 0, i + paramArrayOfByte.doFinal((byte[])localObject1, i));
      }
      throw new InvalidCipherTextException("invalid MAC");
    }
    throw new InvalidCipherTextException("Length of input must be greater than the MAC and V combined");
  }
  
  private byte[] encryptBlock(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidCipherTextException
  {
    if (this.cipher == null)
    {
      byte[] arrayOfByte3 = new byte[paramInt2];
      i = this.param.getMacKeySize() / 8;
      arrayOfByte1 = new byte[i];
      j = paramInt2 + i;
      localObject1 = new byte[j];
      this.kdf.generateBytes((byte[])localObject1, 0, j);
      if (this.V.length != 0)
      {
        System.arraycopy(localObject1, 0, arrayOfByte1, 0, i);
        System.arraycopy(localObject1, i, arrayOfByte3, 0, paramInt2);
      }
      else
      {
        System.arraycopy(localObject1, 0, arrayOfByte3, 0, paramInt2);
        System.arraycopy(localObject1, paramInt2, arrayOfByte1, 0, i);
      }
      arrayOfByte2 = new byte[paramInt2];
      j = 0;
      for (;;)
      {
        localObject1 = arrayOfByte2;
        localObject2 = arrayOfByte1;
        i = paramInt2;
        if (j == paramInt2) {
          break;
        }
        arrayOfByte2[j] = ((byte)(paramArrayOfByte[(paramInt1 + j)] ^ arrayOfByte3[j]));
        j += 1;
      }
    }
    int i = ((IESWithCipherParameters)this.param).getCipherKeySize() / 8;
    Object localObject2 = new byte[i];
    int j = this.param.getMacKeySize() / 8;
    byte[] arrayOfByte1 = new byte[j];
    int k = i + j;
    Object localObject1 = new byte[k];
    this.kdf.generateBytes((byte[])localObject1, 0, k);
    System.arraycopy(localObject1, 0, localObject2, 0, i);
    System.arraycopy(localObject1, i, arrayOfByte1, 0, j);
    if (this.IV != null)
    {
      localObject1 = this.cipher;
      localObject2 = new ParametersWithIV(new KeyParameter((byte[])localObject2), this.IV);
    }
    else
    {
      localObject1 = this.cipher;
      localObject2 = new KeyParameter((byte[])localObject2);
    }
    ((BufferedBlockCipher)localObject1).init(true, (CipherParameters)localObject2);
    localObject1 = new byte[this.cipher.getOutputSize(paramInt2)];
    paramInt1 = this.cipher.processBytes(paramArrayOfByte, paramInt1, paramInt2, (byte[])localObject1, 0);
    i = paramInt1 + this.cipher.doFinal((byte[])localObject1, paramInt1);
    localObject2 = arrayOfByte1;
    arrayOfByte1 = this.param.getEncodingV();
    paramArrayOfByte = null;
    if (this.V.length != 0) {
      paramArrayOfByte = getLengthTag(arrayOfByte1);
    }
    paramInt1 = this.mac.getMacSize();
    byte[] arrayOfByte2 = new byte[paramInt1];
    this.mac.init(new KeyParameter((byte[])localObject2));
    this.mac.update((byte[])localObject1, 0, localObject1.length);
    if (arrayOfByte1 != null) {
      this.mac.update(arrayOfByte1, 0, arrayOfByte1.length);
    }
    if (this.V.length != 0) {
      this.mac.update(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    this.mac.doFinal(arrayOfByte2, 0);
    paramArrayOfByte = this.V;
    localObject2 = new byte[paramArrayOfByte.length + i + paramInt1];
    System.arraycopy(paramArrayOfByte, 0, localObject2, 0, paramArrayOfByte.length);
    System.arraycopy(localObject1, 0, localObject2, this.V.length, i);
    System.arraycopy(arrayOfByte2, 0, localObject2, this.V.length + i, paramInt1);
    return (byte[])localObject2;
  }
  
  private void extractParams(CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof ParametersWithIV))
    {
      paramCipherParameters = (ParametersWithIV)paramCipherParameters;
      this.IV = paramCipherParameters.getIV();
      paramCipherParameters = paramCipherParameters.getParameters();
    }
    else
    {
      this.IV = null;
    }
    this.param = ((IESParameters)paramCipherParameters);
  }
  
  public BufferedBlockCipher getCipher()
  {
    return this.cipher;
  }
  
  protected byte[] getLengthTag(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[8];
    if (paramArrayOfByte != null) {
      Pack.longToBigEndian(paramArrayOfByte.length * 8L, arrayOfByte, 0);
    }
    return arrayOfByte;
  }
  
  public Mac getMac()
  {
    return this.mac;
  }
  
  public void init(AsymmetricKeyParameter paramAsymmetricKeyParameter, CipherParameters paramCipherParameters, KeyParser paramKeyParser)
  {
    this.forEncryption = false;
    this.privParam = paramAsymmetricKeyParameter;
    this.keyParser = paramKeyParser;
    extractParams(paramCipherParameters);
  }
  
  public void init(AsymmetricKeyParameter paramAsymmetricKeyParameter, CipherParameters paramCipherParameters, EphemeralKeyPairGenerator paramEphemeralKeyPairGenerator)
  {
    this.forEncryption = true;
    this.pubParam = paramAsymmetricKeyParameter;
    this.keyPairGenerator = paramEphemeralKeyPairGenerator;
    extractParams(paramCipherParameters);
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters1, CipherParameters paramCipherParameters2, CipherParameters paramCipherParameters3)
  {
    this.forEncryption = paramBoolean;
    this.privParam = paramCipherParameters1;
    this.pubParam = paramCipherParameters2;
    this.V = new byte[0];
    extractParams(paramCipherParameters3);
  }
  
  public byte[] processBlock(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidCipherTextException
  {
    if (this.forEncryption)
    {
      localObject1 = this.keyPairGenerator;
      if (localObject1 != null)
      {
        localObject1 = ((EphemeralKeyPairGenerator)localObject1).generate();
        this.privParam = ((EphemeralKeyPair)localObject1).getKeyPair().getPrivate();
        this.V = ((EphemeralKeyPair)localObject1).getEncodedPublicKey();
      }
    }
    else if (this.keyParser != null)
    {
      localObject1 = new ByteArrayInputStream(paramArrayOfByte, paramInt1, paramInt2);
      try
      {
        this.pubParam = this.keyParser.readKey((InputStream)localObject1);
        this.V = Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt2 - ((ByteArrayInputStream)localObject1).available() + paramInt1);
      }
      catch (IllegalArgumentException paramArrayOfByte)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("unable to recover ephemeral public key: ");
        ((StringBuilder)localObject1).append(paramArrayOfByte.getMessage());
        throw new InvalidCipherTextException(((StringBuilder)localObject1).toString(), paramArrayOfByte);
      }
      catch (IOException paramArrayOfByte)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("unable to recover ephemeral public key: ");
        ((StringBuilder)localObject1).append(paramArrayOfByte.getMessage());
        throw new InvalidCipherTextException(((StringBuilder)localObject1).toString(), paramArrayOfByte);
      }
    }
    this.agree.init(this.privParam);
    Object localObject1 = this.agree.calculateAgreement(this.pubParam);
    Object localObject2 = BigIntegers.asUnsignedByteArray(this.agree.getFieldSize(), (BigInteger)localObject1);
    byte[] arrayOfByte = this.V;
    localObject1 = localObject2;
    if (arrayOfByte.length != 0)
    {
      localObject1 = Arrays.concatenate(arrayOfByte, (byte[])localObject2);
      Arrays.fill((byte[])localObject2, (byte)0);
    }
    try
    {
      localObject2 = new KDFParameters((byte[])localObject1, this.param.getDerivationV());
      this.kdf.init((DerivationParameters)localObject2);
      if (this.forEncryption) {
        paramArrayOfByte = encryptBlock(paramArrayOfByte, paramInt1, paramInt2);
      } else {
        paramArrayOfByte = decryptBlock(paramArrayOfByte, paramInt1, paramInt2);
      }
      return paramArrayOfByte;
    }
    finally
    {
      Arrays.fill((byte[])localObject1, (byte)0);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\IESEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */