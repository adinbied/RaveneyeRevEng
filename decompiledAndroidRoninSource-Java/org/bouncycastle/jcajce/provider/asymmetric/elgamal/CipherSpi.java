package org.bouncycastle.jcajce.provider.asymmetric.elgamal;

import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.interfaces.DHKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource.PSpecified;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.BufferedAsymmetricBlockCipher;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.encodings.ISO9796d1Encoding;
import org.bouncycastle.crypto.encodings.OAEPEncoding;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.ElGamalEngine;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi;
import org.bouncycastle.jcajce.provider.util.BadBlockException;
import org.bouncycastle.jcajce.provider.util.DigestFactory;
import org.bouncycastle.jce.interfaces.ElGamalKey;
import org.bouncycastle.jce.interfaces.ElGamalPrivateKey;
import org.bouncycastle.jce.interfaces.ElGamalPublicKey;
import org.bouncycastle.jce.spec.ElGamalParameterSpec;
import org.bouncycastle.util.Strings;

public class CipherSpi
  extends BaseCipherSpi
{
  private BufferedAsymmetricBlockCipher cipher;
  private AlgorithmParameters engineParams;
  private AlgorithmParameterSpec paramSpec;
  
  public CipherSpi(AsymmetricBlockCipher paramAsymmetricBlockCipher)
  {
    this.cipher = new BufferedAsymmetricBlockCipher(paramAsymmetricBlockCipher);
  }
  
  private byte[] getOutput()
    throws BadPaddingException
  {
    try
    {
      byte[] arrayOfByte = this.cipher.doFinal();
      return arrayOfByte;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw new BadBlockException("unable to decrypt block", localArrayIndexOutOfBoundsException);
    }
    catch (InvalidCipherTextException localInvalidCipherTextException)
    {
      throw new BadPaddingException("unable to decrypt block")
      {
        public Throwable getCause()
        {
          try
          {
            InvalidCipherTextException localInvalidCipherTextException = localInvalidCipherTextException;
            return localInvalidCipherTextException;
          }
          finally
          {
            localObject = finally;
            throw ((Throwable)localObject);
          }
        }
      };
    }
  }
  
  private void initFromSpec(OAEPParameterSpec paramOAEPParameterSpec)
    throws NoSuchPaddingException
  {
    MGF1ParameterSpec localMGF1ParameterSpec = (MGF1ParameterSpec)paramOAEPParameterSpec.getMGFParameters();
    Digest localDigest = DigestFactory.getDigest(localMGF1ParameterSpec.getDigestAlgorithm());
    if (localDigest != null)
    {
      this.cipher = new BufferedAsymmetricBlockCipher(new OAEPEncoding(new ElGamalEngine(), localDigest, ((PSource.PSpecified)paramOAEPParameterSpec.getPSource()).getValue()));
      this.paramSpec = paramOAEPParameterSpec;
      return;
    }
    paramOAEPParameterSpec = new StringBuilder();
    paramOAEPParameterSpec.append("no match on OAEP constructor for digest algorithm: ");
    paramOAEPParameterSpec.append(localMGF1ParameterSpec.getDigestAlgorithm());
    throw new NoSuchPaddingException(paramOAEPParameterSpec.toString());
  }
  
  protected int engineDoFinal(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws IllegalBlockSizeException, BadPaddingException
  {
    this.cipher.processBytes(paramArrayOfByte1, paramInt1, paramInt2);
    paramArrayOfByte1 = getOutput();
    paramInt1 = 0;
    while (paramInt1 != paramArrayOfByte1.length)
    {
      paramArrayOfByte2[(paramInt3 + paramInt1)] = paramArrayOfByte1[paramInt1];
      paramInt1 += 1;
    }
    return paramArrayOfByte1.length;
  }
  
  protected byte[] engineDoFinal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IllegalBlockSizeException, BadPaddingException
  {
    this.cipher.processBytes(paramArrayOfByte, paramInt1, paramInt2);
    return getOutput();
  }
  
  protected int engineGetBlockSize()
  {
    return this.cipher.getInputBlockSize();
  }
  
  protected int engineGetKeySize(Key paramKey)
  {
    if ((paramKey instanceof ElGamalKey)) {}
    for (paramKey = ((ElGamalKey)paramKey).getParameters().getP();; paramKey = ((DHKey)paramKey).getParams().getP())
    {
      return paramKey.bitLength();
      if (!(paramKey instanceof DHKey)) {
        break;
      }
    }
    throw new IllegalArgumentException("not an ElGamal key!");
  }
  
  protected int engineGetOutputSize(int paramInt)
  {
    return this.cipher.getOutputBlockSize();
  }
  
  protected AlgorithmParameters engineGetParameters()
  {
    if ((this.engineParams == null) && (this.paramSpec != null)) {
      try
      {
        AlgorithmParameters localAlgorithmParameters = createParametersInstance("OAEP");
        this.engineParams = localAlgorithmParameters;
        localAlgorithmParameters.init(this.paramSpec);
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException.toString());
      }
    }
    return this.engineParams;
  }
  
  protected void engineInit(int paramInt, Key paramKey, AlgorithmParameters paramAlgorithmParameters, SecureRandom paramSecureRandom)
    throws InvalidKeyException, InvalidAlgorithmParameterException
  {
    throw new InvalidAlgorithmParameterException("can't handle parameters in ElGamal");
  }
  
  protected void engineInit(int paramInt, Key paramKey, SecureRandom paramSecureRandom)
    throws InvalidKeyException
  {
    engineInit(paramInt, paramKey, (AlgorithmParameterSpec)null, paramSecureRandom);
  }
  
  protected void engineInit(int paramInt, Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidKeyException
  {
    if (paramAlgorithmParameterSpec == null)
    {
      if ((paramKey instanceof ElGamalPublicKey))
      {
        paramKey = ElGamalUtil.generatePublicKeyParameter((PublicKey)paramKey);
      }
      else
      {
        if (!(paramKey instanceof ElGamalPrivateKey)) {
          break label145;
        }
        paramKey = ElGamalUtil.generatePrivateKeyParameter((PrivateKey)paramKey);
      }
      paramAlgorithmParameterSpec = paramKey;
      if (paramSecureRandom != null) {
        paramAlgorithmParameterSpec = new ParametersWithRandom(paramKey, paramSecureRandom);
      }
      boolean bool = true;
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3) {
            break label132;
          }
          if (paramInt != 4)
          {
            paramKey = new StringBuilder();
            paramKey.append("unknown opmode ");
            paramKey.append(paramInt);
            paramKey.append(" passed to ElGamal");
            throw new InvalidParameterException(paramKey.toString());
          }
        }
        paramKey = this.cipher;
        bool = false;
        break label137;
      }
      label132:
      paramKey = this.cipher;
      label137:
      paramKey.init(bool, paramAlgorithmParameterSpec);
      return;
      label145:
      throw new InvalidKeyException("unknown key type passed to ElGamal");
    }
    throw new IllegalArgumentException("unknown parameter type.");
  }
  
  protected void engineSetMode(String paramString)
    throws NoSuchAlgorithmException
  {
    Object localObject = Strings.toUpperCase(paramString);
    if (!((String)localObject).equals("NONE"))
    {
      if (((String)localObject).equals("ECB")) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("can't support mode ");
      ((StringBuilder)localObject).append(paramString);
      throw new NoSuchAlgorithmException(((StringBuilder)localObject).toString());
    }
  }
  
  protected void engineSetPadding(String paramString)
    throws NoSuchPaddingException
  {
    Object localObject = Strings.toUpperCase(paramString);
    if (((String)localObject).equals("NOPADDING")) {
      paramString = new BufferedAsymmetricBlockCipher(new ElGamalEngine());
    }
    for (;;)
    {
      this.cipher = paramString;
      return;
      if (((String)localObject).equals("PKCS1PADDING"))
      {
        paramString = new BufferedAsymmetricBlockCipher(new PKCS1Encoding(new ElGamalEngine()));
      }
      else
      {
        if (!((String)localObject).equals("ISO9796-1PADDING")) {
          break;
        }
        paramString = new BufferedAsymmetricBlockCipher(new ISO9796d1Encoding(new ElGamalEngine()));
      }
    }
    if (((String)localObject).equals("OAEPPADDING")) {
      paramString = OAEPParameterSpec.DEFAULT;
    }
    for (;;)
    {
      initFromSpec(paramString);
      return;
      if (((String)localObject).equals("OAEPWITHMD5ANDMGF1PADDING"))
      {
        paramString = new OAEPParameterSpec("MD5", "MGF1", new MGF1ParameterSpec("MD5"), PSource.PSpecified.DEFAULT);
      }
      else
      {
        if (((String)localObject).equals("OAEPWITHSHA1ANDMGF1PADDING")) {
          break;
        }
        if (((String)localObject).equals("OAEPWITHSHA224ANDMGF1PADDING"))
        {
          paramString = new OAEPParameterSpec("SHA-224", "MGF1", new MGF1ParameterSpec("SHA-224"), PSource.PSpecified.DEFAULT);
        }
        else if (((String)localObject).equals("OAEPWITHSHA256ANDMGF1PADDING"))
        {
          paramString = new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT);
        }
        else if (((String)localObject).equals("OAEPWITHSHA384ANDMGF1PADDING"))
        {
          paramString = new OAEPParameterSpec("SHA-384", "MGF1", MGF1ParameterSpec.SHA384, PSource.PSpecified.DEFAULT);
        }
        else
        {
          if (!((String)localObject).equals("OAEPWITHSHA512ANDMGF1PADDING")) {
            break label318;
          }
          paramString = new OAEPParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, PSource.PSpecified.DEFAULT);
        }
      }
    }
    label318:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" unavailable with ElGamal.");
    throw new NoSuchPaddingException(((StringBuilder)localObject).toString());
  }
  
  protected int engineUpdate(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    this.cipher.processBytes(paramArrayOfByte1, paramInt1, paramInt2);
    return 0;
  }
  
  protected byte[] engineUpdate(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.cipher.processBytes(paramArrayOfByte, paramInt1, paramInt2);
    return null;
  }
  
  public static class NoPadding
    extends CipherSpi
  {
    public NoPadding()
    {
      super();
    }
  }
  
  public static class PKCS1v1_5Padding
    extends CipherSpi
  {
    public PKCS1v1_5Padding()
    {
      super();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\elgamal\CipherSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */