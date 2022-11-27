package org.bouncycastle.jcajce.provider.asymmetric.dh;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.KeyEncoder;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.agreement.DHBasicAgreement;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.engines.DESedeEngine;
import org.bouncycastle.crypto.engines.IESEngine;
import org.bouncycastle.crypto.generators.DHKeyPairGenerator;
import org.bouncycastle.crypto.generators.EphemeralKeyPairGenerator;
import org.bouncycastle.crypto.generators.KDF2BytesGenerator;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DHKeyGenerationParameters;
import org.bouncycastle.crypto.params.DHKeyParameters;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.crypto.params.IESWithCipherParameters;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.parsers.DHIESPublicKeyParser;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.jcajce.provider.asymmetric.util.DHUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.IESUtil;
import org.bouncycastle.jcajce.provider.util.BadBlockException;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.interfaces.IESKey;
import org.bouncycastle.jce.spec.IESParameterSpec;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Strings;

public class IESCipher
  extends CipherSpi
{
  private ByteArrayOutputStream buffer = new ByteArrayOutputStream();
  private boolean dhaesMode = false;
  private IESEngine engine;
  private AlgorithmParameters engineParam = null;
  private IESParameterSpec engineSpec = null;
  private final JcaJceHelper helper = new BCJcaJceHelper();
  private final int ivLength;
  private AsymmetricKeyParameter key;
  private AsymmetricKeyParameter otherKeyParameter = null;
  private SecureRandom random;
  private int state = -1;
  
  public IESCipher(IESEngine paramIESEngine)
  {
    this.engine = paramIESEngine;
    this.ivLength = 0;
  }
  
  public IESCipher(IESEngine paramIESEngine, int paramInt)
  {
    this.engine = paramIESEngine;
    this.ivLength = paramInt;
  }
  
  public int engineDoFinal(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws ShortBufferException, IllegalBlockSizeException, BadPaddingException
  {
    paramArrayOfByte1 = engineDoFinal(paramArrayOfByte1, paramInt1, paramInt2);
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, paramInt3, paramArrayOfByte1.length);
    return paramArrayOfByte1.length;
  }
  
  public byte[] engineDoFinal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IllegalBlockSizeException, BadPaddingException
  {
    if (paramInt2 != 0) {
      this.buffer.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    byte[] arrayOfByte = this.buffer.toByteArray();
    this.buffer.reset();
    Object localObject1 = new IESWithCipherParameters(this.engineSpec.getDerivationV(), this.engineSpec.getEncodingV(), this.engineSpec.getMacKeySize(), this.engineSpec.getCipherKeySize());
    paramArrayOfByte = (byte[])localObject1;
    if (this.engineSpec.getNonce() != null) {
      paramArrayOfByte = new ParametersWithIV((CipherParameters)localObject1, this.engineSpec.getNonce());
    }
    localObject1 = ((DHKeyParameters)this.key).getParameters();
    Object localObject2 = this.otherKeyParameter;
    if (localObject2 != null) {
      try
      {
        if ((this.state != 1) && (this.state != 3)) {
          this.engine.init(false, this.key, (CipherParameters)localObject2, paramArrayOfByte);
        } else {
          this.engine.init(true, this.otherKeyParameter, this.key, paramArrayOfByte);
        }
        paramArrayOfByte = this.engine.processBlock(arrayOfByte, 0, arrayOfByte.length);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        throw new BadBlockException("unable to process block", paramArrayOfByte);
      }
    }
    paramInt1 = this.state;
    if ((paramInt1 != 1) && (paramInt1 != 3))
    {
      if ((paramInt1 != 2) && (paramInt1 != 4)) {
        throw new IllegalStateException("IESCipher not initialised");
      }
      try
      {
        this.engine.init(this.key, paramArrayOfByte, new DHIESPublicKeyParser(((DHKeyParameters)this.key).getParameters()));
        paramArrayOfByte = this.engine.processBlock(arrayOfByte, 0, arrayOfByte.length);
        return paramArrayOfByte;
      }
      catch (InvalidCipherTextException paramArrayOfByte)
      {
        throw new BadBlockException("unable to process block", paramArrayOfByte);
      }
    }
    localObject2 = new DHKeyPairGenerator();
    ((DHKeyPairGenerator)localObject2).init(new DHKeyGenerationParameters(this.random, (DHParameters)localObject1));
    localObject1 = new EphemeralKeyPairGenerator((AsymmetricCipherKeyPairGenerator)localObject2, new KeyEncoder()
    {
      public byte[] getEncoded(AsymmetricKeyParameter paramAnonymousAsymmetricKeyParameter)
      {
        int i = (((DHKeyParameters)paramAnonymousAsymmetricKeyParameter).getParameters().getP().bitLength() + 7) / 8;
        byte[] arrayOfByte = new byte[i];
        paramAnonymousAsymmetricKeyParameter = BigIntegers.asUnsignedByteArray(((DHPublicKeyParameters)paramAnonymousAsymmetricKeyParameter).getY());
        if (paramAnonymousAsymmetricKeyParameter.length <= i)
        {
          System.arraycopy(paramAnonymousAsymmetricKeyParameter, 0, arrayOfByte, i - paramAnonymousAsymmetricKeyParameter.length, paramAnonymousAsymmetricKeyParameter.length);
          return arrayOfByte;
        }
        throw new IllegalArgumentException("Senders's public key longer than expected.");
      }
    });
    try
    {
      this.engine.init(this.key, paramArrayOfByte, (EphemeralKeyPairGenerator)localObject1);
      paramArrayOfByte = this.engine.processBlock(arrayOfByte, 0, arrayOfByte.length);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new BadBlockException("unable to process block", paramArrayOfByte);
    }
  }
  
  public int engineGetBlockSize()
  {
    if (this.engine.getCipher() != null) {
      return this.engine.getCipher().getBlockSize();
    }
    return 0;
  }
  
  public byte[] engineGetIV()
  {
    IESParameterSpec localIESParameterSpec = this.engineSpec;
    if (localIESParameterSpec != null) {
      return localIESParameterSpec.getNonce();
    }
    return null;
  }
  
  public int engineGetKeySize(Key paramKey)
  {
    if ((paramKey instanceof DHKey)) {
      return ((DHKey)paramKey).getParams().getP().bitLength();
    }
    throw new IllegalArgumentException("not a DH key");
  }
  
  public int engineGetOutputSize(int paramInt)
  {
    if (this.key != null)
    {
      int j = this.engine.getMac().getMacSize();
      if (this.otherKeyParameter == null) {
        i = (((DHKeyParameters)this.key).getParameters().getP().bitLength() + 7) * 2 / 8 + 1;
      } else {
        i = 0;
      }
      if (this.engine.getCipher() != null)
      {
        k = this.state;
        BufferedBlockCipher localBufferedBlockCipher;
        if ((k != 1) && (k != 3))
        {
          if ((k != 2) && (k != 4)) {
            throw new IllegalStateException("cipher not initialised");
          }
          localBufferedBlockCipher = this.engine.getCipher();
          paramInt = paramInt - j - i;
        }
        else
        {
          localBufferedBlockCipher = this.engine.getCipher();
        }
        paramInt = localBufferedBlockCipher.getOutputSize(paramInt);
      }
      int k = this.state;
      if ((k != 1) && (k != 3)) {
        if ((k != 2) && (k != 4)) {
          throw new IllegalStateException("IESCipher not initialised");
        }
      }
      for (int i = this.buffer.size() - j - i;; i = this.buffer.size() + j + i) {
        return i + paramInt;
      }
    }
    throw new IllegalStateException("cipher not initialised");
  }
  
  public AlgorithmParameters engineGetParameters()
  {
    if ((this.engineParam == null) && (this.engineSpec != null)) {
      try
      {
        AlgorithmParameters localAlgorithmParameters = this.helper.createAlgorithmParameters("IES");
        this.engineParam = localAlgorithmParameters;
        localAlgorithmParameters.init(this.engineSpec);
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException.toString());
      }
    }
    return this.engineParam;
  }
  
  public void engineInit(int paramInt, Key paramKey, AlgorithmParameters paramAlgorithmParameters, SecureRandom paramSecureRandom)
    throws InvalidKeyException, InvalidAlgorithmParameterException
  {
    AlgorithmParameterSpec localAlgorithmParameterSpec;
    if (paramAlgorithmParameters != null) {
      try
      {
        localAlgorithmParameterSpec = paramAlgorithmParameters.getParameterSpec(IESParameterSpec.class);
      }
      catch (Exception paramKey)
      {
        paramAlgorithmParameters = new StringBuilder();
        paramAlgorithmParameters.append("cannot recognise parameters: ");
        paramAlgorithmParameters.append(paramKey.toString());
        throw new InvalidAlgorithmParameterException(paramAlgorithmParameters.toString());
      }
    } else {
      localAlgorithmParameterSpec = null;
    }
    this.engineParam = paramAlgorithmParameters;
    engineInit(paramInt, paramKey, localAlgorithmParameterSpec, paramSecureRandom);
  }
  
  public void engineInit(int paramInt, Key paramKey, SecureRandom paramSecureRandom)
    throws InvalidKeyException
  {
    try
    {
      engineInit(paramInt, paramKey, (AlgorithmParameterSpec)null, paramSecureRandom);
      return;
    }
    catch (InvalidAlgorithmParameterException paramKey)
    {
      paramSecureRandom = new StringBuilder();
      paramSecureRandom.append("cannot handle supplied parameter spec: ");
      paramSecureRandom.append(paramKey.getMessage());
      throw new IllegalArgumentException(paramSecureRandom.toString());
    }
  }
  
  public void engineInit(int paramInt, Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidAlgorithmParameterException, InvalidKeyException
  {
    if (paramAlgorithmParameterSpec == null)
    {
      Object localObject = null;
      i = this.ivLength;
      paramAlgorithmParameterSpec = (AlgorithmParameterSpec)localObject;
      if (i != 0)
      {
        paramAlgorithmParameterSpec = (AlgorithmParameterSpec)localObject;
        if (paramInt == 1)
        {
          paramAlgorithmParameterSpec = new byte[i];
          paramSecureRandom.nextBytes(paramAlgorithmParameterSpec);
        }
      }
      paramAlgorithmParameterSpec = IESUtil.guessParameterSpec(this.engine.getCipher(), paramAlgorithmParameterSpec);
    }
    else
    {
      if (!(paramAlgorithmParameterSpec instanceof IESParameterSpec)) {
        break label344;
      }
      paramAlgorithmParameterSpec = (IESParameterSpec)paramAlgorithmParameterSpec;
    }
    this.engineSpec = paramAlgorithmParameterSpec;
    paramAlgorithmParameterSpec = this.engineSpec.getNonce();
    int i = this.ivLength;
    if ((i != 0) && ((paramAlgorithmParameterSpec == null) || (paramAlgorithmParameterSpec.length != i)))
    {
      paramKey = new StringBuilder();
      paramKey.append("NONCE in IES Parameters needs to be ");
      paramKey.append(this.ivLength);
      paramKey.append(" bytes long");
      throw new InvalidAlgorithmParameterException(paramKey.toString());
    }
    if ((paramInt != 1) && (paramInt != 3))
    {
      if ((paramInt != 2) && (paramInt != 4)) {
        throw new InvalidKeyException("must be passed EC key");
      }
      if ((paramKey instanceof DHPrivateKey)) {}
      for (paramKey = (PrivateKey)paramKey;; paramKey = paramKey.getPrivate())
      {
        paramKey = DHUtil.generatePrivateKeyParameter(paramKey);
        break label268;
        if (!(paramKey instanceof IESKey)) {
          break;
        }
        paramKey = (IESKey)paramKey;
        this.otherKeyParameter = DHUtil.generatePublicKeyParameter(paramKey.getPublic());
      }
      throw new InvalidKeyException("must be passed recipient's private DH key for decryption");
    }
    if ((paramKey instanceof DHPublicKey))
    {
      paramKey = DHUtil.generatePublicKeyParameter((PublicKey)paramKey);
      label268:
      this.key = paramKey;
    }
    else
    {
      if (!(paramKey instanceof IESKey)) {
        break label333;
      }
      paramKey = (IESKey)paramKey;
      this.key = DHUtil.generatePublicKeyParameter(paramKey.getPublic());
      this.otherKeyParameter = DHUtil.generatePrivateKeyParameter(paramKey.getPrivate());
    }
    this.random = paramSecureRandom;
    this.state = paramInt;
    this.buffer.reset();
    return;
    label333:
    throw new InvalidKeyException("must be passed recipient's public DH key for encryption");
    label344:
    throw new InvalidAlgorithmParameterException("must be passed IES parameters");
  }
  
  public void engineSetMode(String paramString)
    throws NoSuchAlgorithmException
  {
    Object localObject = Strings.toUpperCase(paramString);
    if (((String)localObject).equals("NONE")) {}
    for (boolean bool = false;; bool = true)
    {
      this.dhaesMode = bool;
      return;
      if (!((String)localObject).equals("DHAES")) {
        break;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("can't support mode ");
    ((StringBuilder)localObject).append(paramString);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void engineSetPadding(String paramString)
    throws NoSuchPaddingException
  {
    paramString = Strings.toUpperCase(paramString);
    if (paramString.equals("NOPADDING")) {
      return;
    }
    if (!paramString.equals("PKCS5PADDING"))
    {
      if (paramString.equals("PKCS7PADDING")) {
        return;
      }
      throw new NoSuchPaddingException("padding not available with IESCipher");
    }
  }
  
  public int engineUpdate(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    this.buffer.write(paramArrayOfByte1, paramInt1, paramInt2);
    return 0;
  }
  
  public byte[] engineUpdate(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer.write(paramArrayOfByte, paramInt1, paramInt2);
    return null;
  }
  
  public static class IES
    extends IESCipher
  {
    public IES()
    {
      super();
    }
  }
  
  public static class IESwithAESCBC
    extends IESCipher
  {
    public IESwithAESCBC()
    {
      super(16);
    }
  }
  
  public static class IESwithDESedeCBC
    extends IESCipher
  {
    public IESwithDESedeCBC()
    {
      super(8);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\dh\IESCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */