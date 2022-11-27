package org.bouncycastle.pqc.jcajce.provider.util;

import java.io.ByteArrayOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;

public abstract class AsymmetricBlockCipher
  extends CipherSpiExt
{
  protected ByteArrayOutputStream buf = new ByteArrayOutputStream();
  protected int cipherTextSize;
  protected int maxPlainTextSize;
  protected AlgorithmParameterSpec paramSpec;
  
  protected void checkLength(int paramInt)
    throws IllegalBlockSizeException
  {
    paramInt += this.buf.size();
    StringBuilder localStringBuilder;
    if (this.opMode == 1)
    {
      if (paramInt <= this.maxPlainTextSize) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("The length of the plaintext (");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" bytes) is not supported by ");
      localStringBuilder.append("the cipher (max. ");
      localStringBuilder.append(this.maxPlainTextSize);
      localStringBuilder.append(" bytes).");
      throw new IllegalBlockSizeException(localStringBuilder.toString());
    }
    if (this.opMode == 2)
    {
      if (paramInt == this.cipherTextSize) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Illegal ciphertext length (expected ");
      localStringBuilder.append(this.cipherTextSize);
      localStringBuilder.append(" bytes, was ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" bytes).");
      throw new IllegalBlockSizeException(localStringBuilder.toString());
    }
  }
  
  public final int doFinal(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws ShortBufferException, IllegalBlockSizeException, BadPaddingException
  {
    if (paramArrayOfByte2.length >= getOutputSize(paramInt2))
    {
      paramArrayOfByte1 = doFinal(paramArrayOfByte1, paramInt1, paramInt2);
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, paramInt3, paramArrayOfByte1.length);
      return paramArrayOfByte1.length;
    }
    throw new ShortBufferException("Output buffer too short.");
  }
  
  public final byte[] doFinal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IllegalBlockSizeException, BadPaddingException
  {
    checkLength(paramInt2);
    update(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte = this.buf.toByteArray();
    this.buf.reset();
    paramInt1 = this.opMode;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2) {
        return null;
      }
      return messageDecrypt(paramArrayOfByte);
    }
    return messageEncrypt(paramArrayOfByte);
  }
  
  public final int getBlockSize()
  {
    if (this.opMode == 1) {
      return this.maxPlainTextSize;
    }
    return this.cipherTextSize;
  }
  
  public final byte[] getIV()
  {
    return null;
  }
  
  public final int getOutputSize(int paramInt)
  {
    int i = this.buf.size();
    int j = getBlockSize();
    if (paramInt + i > j) {
      return 0;
    }
    return j;
  }
  
  public final AlgorithmParameterSpec getParameters()
  {
    return this.paramSpec;
  }
  
  protected abstract void initCipherDecrypt(Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec)
    throws InvalidKeyException, InvalidAlgorithmParameterException;
  
  protected abstract void initCipherEncrypt(Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidKeyException, InvalidAlgorithmParameterException;
  
  public final void initDecrypt(Key paramKey)
    throws InvalidKeyException
  {
    try
    {
      initDecrypt(paramKey, null);
      return;
    }
    catch (InvalidAlgorithmParameterException paramKey)
    {
      for (;;) {}
    }
    throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
  }
  
  public final void initDecrypt(Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec)
    throws InvalidKeyException, InvalidAlgorithmParameterException
  {
    this.opMode = 2;
    initCipherDecrypt(paramKey, paramAlgorithmParameterSpec);
  }
  
  public final void initEncrypt(Key paramKey)
    throws InvalidKeyException
  {
    try
    {
      initEncrypt(paramKey, null, new SecureRandom());
      return;
    }
    catch (InvalidAlgorithmParameterException paramKey)
    {
      for (;;) {}
    }
    throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
  }
  
  public final void initEncrypt(Key paramKey, SecureRandom paramSecureRandom)
    throws InvalidKeyException
  {
    try
    {
      initEncrypt(paramKey, null, paramSecureRandom);
      return;
    }
    catch (InvalidAlgorithmParameterException paramKey)
    {
      for (;;) {}
    }
    throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
  }
  
  public final void initEncrypt(Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec)
    throws InvalidKeyException, InvalidAlgorithmParameterException
  {
    initEncrypt(paramKey, paramAlgorithmParameterSpec, new SecureRandom());
  }
  
  public final void initEncrypt(Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidKeyException, InvalidAlgorithmParameterException
  {
    this.opMode = 1;
    initCipherEncrypt(paramKey, paramAlgorithmParameterSpec, paramSecureRandom);
  }
  
  protected abstract byte[] messageDecrypt(byte[] paramArrayOfByte)
    throws IllegalBlockSizeException, BadPaddingException;
  
  protected abstract byte[] messageEncrypt(byte[] paramArrayOfByte)
    throws IllegalBlockSizeException, BadPaddingException;
  
  protected final void setMode(String paramString) {}
  
  protected final void setPadding(String paramString) {}
  
  public final int update(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    update(paramArrayOfByte1, paramInt1, paramInt2);
    return 0;
  }
  
  public final byte[] update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0) {
      this.buf.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    return new byte[0];
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provide\\util\AsymmetricBlockCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */