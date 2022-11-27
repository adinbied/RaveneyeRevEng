package org.bouncycastle.pqc.jcajce.provider.util;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

public abstract class CipherSpiExt
  extends CipherSpi
{
  public static final int DECRYPT_MODE = 2;
  public static final int ENCRYPT_MODE = 1;
  protected int opMode;
  
  public abstract int doFinal(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws ShortBufferException, IllegalBlockSizeException, BadPaddingException;
  
  public final byte[] doFinal()
    throws IllegalBlockSizeException, BadPaddingException
  {
    return doFinal(null, 0, 0);
  }
  
  public final byte[] doFinal(byte[] paramArrayOfByte)
    throws IllegalBlockSizeException, BadPaddingException
  {
    return doFinal(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public abstract byte[] doFinal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IllegalBlockSizeException, BadPaddingException;
  
  protected final int engineDoFinal(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws ShortBufferException, IllegalBlockSizeException, BadPaddingException
  {
    return doFinal(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, paramInt3);
  }
  
  protected final byte[] engineDoFinal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IllegalBlockSizeException, BadPaddingException
  {
    return doFinal(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  protected final int engineGetBlockSize()
  {
    return getBlockSize();
  }
  
  protected final byte[] engineGetIV()
  {
    return getIV();
  }
  
  protected final int engineGetKeySize(Key paramKey)
    throws InvalidKeyException
  {
    if ((paramKey instanceof Key)) {
      return getKeySize(paramKey);
    }
    throw new InvalidKeyException("Unsupported key.");
  }
  
  protected final int engineGetOutputSize(int paramInt)
  {
    return getOutputSize(paramInt);
  }
  
  protected final AlgorithmParameters engineGetParameters()
  {
    return null;
  }
  
  protected final void engineInit(int paramInt, Key paramKey, AlgorithmParameters paramAlgorithmParameters, SecureRandom paramSecureRandom)
    throws InvalidKeyException, InvalidAlgorithmParameterException
  {
    if (paramAlgorithmParameters == null)
    {
      engineInit(paramInt, paramKey, paramSecureRandom);
      return;
    }
    engineInit(paramInt, paramKey, null, paramSecureRandom);
  }
  
  protected final void engineInit(int paramInt, Key paramKey, SecureRandom paramSecureRandom)
    throws InvalidKeyException
  {
    try
    {
      engineInit(paramInt, paramKey, (AlgorithmParameterSpec)null, paramSecureRandom);
      return;
    }
    catch (InvalidAlgorithmParameterException paramKey)
    {
      throw new InvalidParameterException(paramKey.getMessage());
    }
  }
  
  protected void engineInit(int paramInt, Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidKeyException, InvalidAlgorithmParameterException
  {
    if ((paramAlgorithmParameterSpec != null) && (!(paramAlgorithmParameterSpec instanceof AlgorithmParameterSpec))) {
      throw new InvalidAlgorithmParameterException();
    }
    if ((paramKey != null) && ((paramKey instanceof Key)))
    {
      this.opMode = paramInt;
      if (paramInt == 1)
      {
        initEncrypt(paramKey, paramAlgorithmParameterSpec, paramSecureRandom);
        return;
      }
      if (paramInt == 2) {
        initDecrypt(paramKey, paramAlgorithmParameterSpec);
      }
      return;
    }
    throw new InvalidKeyException();
  }
  
  protected final void engineSetMode(String paramString)
    throws NoSuchAlgorithmException
  {
    setMode(paramString);
  }
  
  protected final void engineSetPadding(String paramString)
    throws NoSuchPaddingException
  {
    setPadding(paramString);
  }
  
  protected final int engineUpdate(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws ShortBufferException
  {
    return update(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, paramInt3);
  }
  
  protected final byte[] engineUpdate(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return update(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public abstract int getBlockSize();
  
  public abstract byte[] getIV();
  
  public abstract int getKeySize(Key paramKey)
    throws InvalidKeyException;
  
  public abstract String getName();
  
  public abstract int getOutputSize(int paramInt);
  
  public abstract AlgorithmParameterSpec getParameters();
  
  public abstract void initDecrypt(Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec)
    throws InvalidKeyException, InvalidAlgorithmParameterException;
  
  public abstract void initEncrypt(Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidKeyException, InvalidAlgorithmParameterException;
  
  protected abstract void setMode(String paramString)
    throws NoSuchAlgorithmException;
  
  protected abstract void setPadding(String paramString)
    throws NoSuchPaddingException;
  
  public abstract int update(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws ShortBufferException;
  
  public final byte[] update(byte[] paramArrayOfByte)
  {
    return update(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public abstract byte[] update(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provide\\util\CipherSpiExt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */