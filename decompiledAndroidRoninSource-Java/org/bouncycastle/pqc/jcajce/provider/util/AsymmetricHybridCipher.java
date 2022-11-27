package org.bouncycastle.pqc.jcajce.provider.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.ShortBufferException;

public abstract class AsymmetricHybridCipher
  extends CipherSpiExt
{
  protected AlgorithmParameterSpec paramSpec;
  
  protected abstract int decryptOutputSize(int paramInt);
  
  public final int doFinal(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws ShortBufferException, BadPaddingException
  {
    if (paramArrayOfByte2.length >= getOutputSize(paramInt2))
    {
      paramArrayOfByte1 = doFinal(paramArrayOfByte1, paramInt1, paramInt2);
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, paramInt3, paramArrayOfByte1.length);
      return paramArrayOfByte1.length;
    }
    throw new ShortBufferException("Output buffer too short.");
  }
  
  public abstract byte[] doFinal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws BadPaddingException;
  
  protected abstract int encryptOutputSize(int paramInt);
  
  public final int getBlockSize()
  {
    return 0;
  }
  
  public final byte[] getIV()
  {
    return null;
  }
  
  public final int getOutputSize(int paramInt)
  {
    if (this.opMode == 1) {
      return encryptOutputSize(paramInt);
    }
    return decryptOutputSize(paramInt);
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
  
  protected final void setMode(String paramString) {}
  
  protected final void setPadding(String paramString) {}
  
  public final int update(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws ShortBufferException
  {
    if (paramArrayOfByte2.length >= getOutputSize(paramInt2))
    {
      paramArrayOfByte1 = update(paramArrayOfByte1, paramInt1, paramInt2);
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, paramInt3, paramArrayOfByte1.length);
      return paramArrayOfByte1.length;
    }
    throw new ShortBufferException("output");
  }
  
  public abstract byte[] update(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provide\\util\AsymmetricHybridCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */