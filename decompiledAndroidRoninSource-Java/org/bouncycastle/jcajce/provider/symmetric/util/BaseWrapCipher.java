package org.bouncycastle.jcajce.provider.symmetric.util;

import java.io.PrintStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;

public abstract class BaseWrapCipher
  extends CipherSpi
  implements PBE
{
  private Class[] availableSpecs = { IvParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class };
  protected AlgorithmParameters engineParams = null;
  private final JcaJceHelper helper = new BCJcaJceHelper();
  private byte[] iv;
  private int ivSize;
  protected int pbeHash = 1;
  protected int pbeIvSize;
  protected int pbeKeySize;
  protected int pbeType = 2;
  protected Wrapper wrapEngine = null;
  
  protected BaseWrapCipher() {}
  
  protected BaseWrapCipher(Wrapper paramWrapper)
  {
    this(paramWrapper, 0);
  }
  
  protected BaseWrapCipher(Wrapper paramWrapper, int paramInt)
  {
    this.wrapEngine = paramWrapper;
    this.ivSize = paramInt;
  }
  
  protected final AlgorithmParameters createParametersInstance(String paramString)
    throws NoSuchAlgorithmException, NoSuchProviderException
  {
    return this.helper.createAlgorithmParameters(paramString);
  }
  
  protected int engineDoFinal(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws IllegalBlockSizeException, BadPaddingException, ShortBufferException
  {
    return 0;
  }
  
  protected byte[] engineDoFinal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IllegalBlockSizeException, BadPaddingException
  {
    return null;
  }
  
  protected int engineGetBlockSize()
  {
    return 0;
  }
  
  protected byte[] engineGetIV()
  {
    return Arrays.clone(this.iv);
  }
  
  protected int engineGetKeySize(Key paramKey)
  {
    return paramKey.getEncoded().length * 8;
  }
  
  protected int engineGetOutputSize(int paramInt)
  {
    return -1;
  }
  
  protected AlgorithmParameters engineGetParameters()
  {
    return null;
  }
  
  protected void engineInit(int paramInt, Key paramKey, AlgorithmParameters paramAlgorithmParameters, SecureRandom paramSecureRandom)
    throws InvalidKeyException, InvalidAlgorithmParameterException
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramAlgorithmParameters != null)
    {
      int i = 0;
      for (;;)
      {
        Class[] arrayOfClass = this.availableSpecs;
        localObject1 = localObject2;
        if (i == arrayOfClass.length) {
          break;
        }
        try
        {
          localObject1 = paramAlgorithmParameters.getParameterSpec(arrayOfClass[i]);
        }
        catch (Exception localException)
        {
          for (;;) {}
        }
        i += 1;
      }
      if (localObject1 == null)
      {
        paramKey = new StringBuilder();
        paramKey.append("can't handle parameter ");
        paramKey.append(paramAlgorithmParameters.toString());
        throw new InvalidAlgorithmParameterException(paramKey.toString());
      }
    }
    this.engineParams = paramAlgorithmParameters;
    engineInit(paramInt, paramKey, (AlgorithmParameterSpec)localObject1, paramSecureRandom);
  }
  
  protected void engineInit(int paramInt, Key paramKey, SecureRandom paramSecureRandom)
    throws InvalidKeyException
  {
    try
    {
      engineInit(paramInt, paramKey, (AlgorithmParameterSpec)null, paramSecureRandom);
      return;
    }
    catch (InvalidAlgorithmParameterException paramKey)
    {
      throw new IllegalArgumentException(paramKey.getMessage());
    }
  }
  
  protected void engineInit(int paramInt, Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidKeyException, InvalidAlgorithmParameterException
  {
    if ((paramKey instanceof BCPBEKey))
    {
      paramKey = (BCPBEKey)paramKey;
      if ((paramAlgorithmParameterSpec instanceof PBEParameterSpec)) {
        paramKey = PBE.Util.makePBEParameters(paramKey, paramAlgorithmParameterSpec, this.wrapEngine.getAlgorithmName());
      } else if (paramKey.getParam() != null) {
        paramKey = paramKey.getParam();
      } else {
        throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
      }
    }
    else
    {
      paramKey = new KeyParameter(paramKey.getEncoded());
    }
    Object localObject = paramKey;
    if ((paramAlgorithmParameterSpec instanceof IvParameterSpec)) {
      localObject = new ParametersWithIV(paramKey, ((IvParameterSpec)paramAlgorithmParameterSpec).getIV());
    }
    paramKey = (Key)localObject;
    if ((localObject instanceof KeyParameter))
    {
      int i = this.ivSize;
      paramKey = (Key)localObject;
      if (i != 0)
      {
        paramKey = new byte[i];
        this.iv = paramKey;
        paramSecureRandom.nextBytes(paramKey);
        paramKey = new ParametersWithIV((CipherParameters)localObject, this.iv);
      }
    }
    paramAlgorithmParameterSpec = paramKey;
    if (paramSecureRandom != null) {
      paramAlgorithmParameterSpec = new ParametersWithRandom(paramKey, paramSecureRandom);
    }
    boolean bool = true;
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          System.out.println("eeek!");
          return;
        }
        paramKey = this.wrapEngine;
        bool = false;
      }
      else
      {
        paramKey = this.wrapEngine;
      }
      paramKey.init(bool, paramAlgorithmParameterSpec);
      return;
    }
    throw new IllegalArgumentException("engine only valid for wrapping");
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
  
  protected Key engineUnwrap(byte[] paramArrayOfByte, String paramString, int paramInt)
    throws InvalidKeyException, NoSuchAlgorithmException
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
        throw new InvalidKeyException(paramArrayOfByte.getMessage());
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
    catch (InvalidKeySpecException paramArrayOfByte)
    {
      paramString = new StringBuilder();
      paramString.append("Unknown key type ");
      paramString.append(paramArrayOfByte.getMessage());
      throw new InvalidKeyException(paramString.toString());
    }
    catch (NoSuchProviderException paramArrayOfByte)
    {
      paramString = new StringBuilder();
      paramString.append("Unknown key type ");
      paramString.append(paramArrayOfByte.getMessage());
      throw new InvalidKeyException(paramString.toString());
    }
  }
  
  protected int engineUpdate(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws ShortBufferException
  {
    throw new RuntimeException("not supported for wrapping");
  }
  
  protected byte[] engineUpdate(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    throw new RuntimeException("not supported for wrapping");
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetri\\util\BaseWrapCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */