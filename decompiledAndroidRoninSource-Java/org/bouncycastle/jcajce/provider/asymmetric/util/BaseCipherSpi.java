package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public abstract class BaseCipherSpi
  extends CipherSpi
{
  private Class[] availableSpecs = { IvParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class };
  protected AlgorithmParameters engineParams = null;
  private final JcaJceHelper helper = new BCJcaJceHelper();
  private byte[] iv;
  private int ivSize;
  protected Wrapper wrapEngine = null;
  
  protected final AlgorithmParameters createParametersInstance(String paramString)
    throws NoSuchAlgorithmException, NoSuchProviderException
  {
    return this.helper.createAlgorithmParameters(paramString);
  }
  
  protected int engineGetBlockSize()
  {
    return 0;
  }
  
  protected byte[] engineGetIV()
  {
    return null;
  }
  
  protected int engineGetKeySize(Key paramKey)
  {
    return paramKey.getEncoded().length;
  }
  
  protected int engineGetOutputSize(int paramInt)
  {
    return -1;
  }
  
  protected AlgorithmParameters engineGetParameters()
  {
    return null;
  }
  
  protected void engineSetMode(String paramString)
    throws NoSuchAlgorithmException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("can't support mode ");
    localStringBuilder.append(paramString);
    throw new NoSuchAlgorithmException(localStringBuilder.toString());
  }
  
  protected void engineSetPadding(String paramString)
    throws NoSuchPaddingException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Padding ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" unknown.");
    throw new NoSuchPaddingException(localStringBuilder.toString());
  }
  
  protected Key engineUnwrap(final byte[] paramArrayOfByte, String paramString, int paramInt)
    throws InvalidKeyException
  {
    for (;;)
    {
      try
      {
        if (this.wrapEngine == null) {
          paramArrayOfByte = engineDoFinal(paramArrayOfByte, 0, paramArrayOfByte.length);
        } else {
          paramArrayOfByte = this.wrapEngine.unwrap(paramArrayOfByte, 0, paramArrayOfByte.length);
        }
        if (paramInt == 3) {
          return new SecretKeySpec(paramArrayOfByte, paramString);
        }
        if ((!paramString.equals("")) || (paramInt != 2)) {}
      }
      catch (IllegalBlockSizeException paramArrayOfByte)
      {
        throw new InvalidKeyException(paramArrayOfByte.getMessage());
      }
      catch (BadPaddingException paramArrayOfByte)
      {
        throw new InvalidKeyException("unable to unwrap")
        {
          public Throwable getCause()
          {
            try
            {
              BadPaddingException localBadPaddingException = paramArrayOfByte;
              return localBadPaddingException;
            }
            finally
            {
              localObject = finally;
              throw ((Throwable)localObject);
            }
          }
        };
      }
      catch (InvalidCipherTextException paramArrayOfByte)
      {
        throw new InvalidKeyException(paramArrayOfByte.getMessage());
      }
      try
      {
        paramArrayOfByte = PrivateKeyInfo.getInstance(paramArrayOfByte);
        paramString = BouncyCastleProvider.getPrivateKey(paramArrayOfByte);
        if (paramString != null) {
          return paramString;
        }
        paramString = new StringBuilder();
        paramString.append("algorithm ");
        paramString.append(paramArrayOfByte.getPrivateKeyAlgorithm().getAlgorithm());
        paramString.append(" not supported");
        throw new InvalidKeyException(paramString.toString());
      }
      catch (Exception paramArrayOfByte) {}
    }
    throw new InvalidKeyException("Invalid key encoding.");
    try
    {
      paramString = this.helper.createKeyFactory(paramString);
      if (paramInt == 1) {
        return paramString.generatePublic(new X509EncodedKeySpec(paramArrayOfByte));
      }
      if (paramInt == 2)
      {
        paramArrayOfByte = paramString.generatePrivate(new PKCS8EncodedKeySpec(paramArrayOfByte));
        return paramArrayOfByte;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("Unknown key type ");
      paramArrayOfByte.append(paramInt);
      throw new InvalidKeyException(paramArrayOfByte.toString());
    }
    catch (NoSuchProviderException paramArrayOfByte)
    {
      paramString = new StringBuilder();
      paramString.append("Unknown key type ");
      paramString.append(paramArrayOfByte.getMessage());
      throw new InvalidKeyException(paramString.toString());
    }
    catch (InvalidKeySpecException paramArrayOfByte)
    {
      paramString = new StringBuilder();
      paramString.append("Unknown key type ");
      paramString.append(paramArrayOfByte.getMessage());
      throw new InvalidKeyException(paramString.toString());
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      paramString = new StringBuilder();
      paramString.append("Unknown key type ");
      paramString.append(paramArrayOfByte.getMessage());
      throw new InvalidKeyException(paramString.toString());
    }
  }
  
  protected byte[] engineWrap(Key paramKey)
    throws IllegalBlockSizeException, InvalidKeyException
  {
    paramKey = paramKey.getEncoded();
    if (paramKey != null) {
      try
      {
        if (this.wrapEngine == null) {
          return engineDoFinal(paramKey, 0, paramKey.length);
        }
        paramKey = this.wrapEngine.wrap(paramKey, 0, paramKey.length);
        return paramKey;
      }
      catch (BadPaddingException paramKey)
      {
        throw new IllegalBlockSizeException(paramKey.getMessage());
      }
    }
    throw new InvalidKeyException("Cannot wrap key, null encoding.");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetri\\util\BaseCipherSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */