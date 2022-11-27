package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource.PSpecified;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.encodings.ISO9796d1Encoding;
import org.bouncycastle.crypto.encodings.OAEPEncoding;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.RSABlindedEngine;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi;
import org.bouncycastle.jcajce.provider.util.DigestFactory;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.util.Strings;

public class CipherSpi
  extends BaseCipherSpi
{
  private ByteArrayOutputStream bOut = new ByteArrayOutputStream();
  private AsymmetricBlockCipher cipher;
  private AlgorithmParameters engineParams;
  private final JcaJceHelper helper = new BCJcaJceHelper();
  private AlgorithmParameterSpec paramSpec;
  private boolean privateKeyOnly = false;
  private boolean publicKeyOnly = false;
  
  public CipherSpi(OAEPParameterSpec paramOAEPParameterSpec)
  {
    try
    {
      initFromSpec(paramOAEPParameterSpec);
      return;
    }
    catch (NoSuchPaddingException paramOAEPParameterSpec)
    {
      throw new IllegalArgumentException(paramOAEPParameterSpec.getMessage());
    }
  }
  
  public CipherSpi(AsymmetricBlockCipher paramAsymmetricBlockCipher)
  {
    this.cipher = paramAsymmetricBlockCipher;
  }
  
  public CipherSpi(boolean paramBoolean1, boolean paramBoolean2, AsymmetricBlockCipher paramAsymmetricBlockCipher)
  {
    this.publicKeyOnly = paramBoolean1;
    this.privateKeyOnly = paramBoolean2;
    this.cipher = paramAsymmetricBlockCipher;
  }
  
  /* Error */
  private byte[] getOutput()
    throws BadPaddingException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 56	org/bouncycastle/jcajce/provider/asymmetric/rsa/CipherSpi:bOut	Ljava/io/ByteArrayOutputStream;
    //   4: invokevirtual 84	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 72	org/bouncycastle/jcajce/provider/asymmetric/rsa/CipherSpi:cipher	Lorg/bouncycastle/crypto/AsymmetricBlockCipher;
    //   12: aload_1
    //   13: iconst_0
    //   14: aload_1
    //   15: arraylength
    //   16: invokeinterface 90 4 0
    //   21: astore_1
    //   22: aload_0
    //   23: getfield 56	org/bouncycastle/jcajce/provider/asymmetric/rsa/CipherSpi:bOut	Ljava/io/ByteArrayOutputStream;
    //   26: invokevirtual 93	java/io/ByteArrayOutputStream:reset	()V
    //   29: aload_1
    //   30: areturn
    //   31: astore_1
    //   32: goto +27 -> 59
    //   35: astore_1
    //   36: new 95	org/bouncycastle/jcajce/provider/util/BadBlockException
    //   39: dup
    //   40: ldc 97
    //   42: aload_1
    //   43: invokespecial 100	org/bouncycastle/jcajce/provider/util/BadBlockException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   46: athrow
    //   47: astore_1
    //   48: new 95	org/bouncycastle/jcajce/provider/util/BadBlockException
    //   51: dup
    //   52: ldc 97
    //   54: aload_1
    //   55: invokespecial 100	org/bouncycastle/jcajce/provider/util/BadBlockException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   58: athrow
    //   59: aload_0
    //   60: getfield 56	org/bouncycastle/jcajce/provider/asymmetric/rsa/CipherSpi:bOut	Ljava/io/ByteArrayOutputStream;
    //   63: invokevirtual 93	java/io/ByteArrayOutputStream:reset	()V
    //   66: aload_1
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	CipherSpi
    //   7	23	1	arrayOfByte	byte[]
    //   31	1	1	localObject	Object
    //   35	8	1	localArrayIndexOutOfBoundsException	ArrayIndexOutOfBoundsException
    //   47	20	1	localInvalidCipherTextException	org.bouncycastle.crypto.InvalidCipherTextException
    // Exception table:
    //   from	to	target	type
    //   0	22	31	finally
    //   36	47	31	finally
    //   48	59	31	finally
    //   0	22	35	java/lang/ArrayIndexOutOfBoundsException
    //   0	22	47	org/bouncycastle/crypto/InvalidCipherTextException
  }
  
  private void initFromSpec(OAEPParameterSpec paramOAEPParameterSpec)
    throws NoSuchPaddingException
  {
    MGF1ParameterSpec localMGF1ParameterSpec = (MGF1ParameterSpec)paramOAEPParameterSpec.getMGFParameters();
    Digest localDigest = DigestFactory.getDigest(localMGF1ParameterSpec.getDigestAlgorithm());
    if (localDigest != null)
    {
      this.cipher = new OAEPEncoding(new RSABlindedEngine(), localDigest, ((PSource.PSpecified)paramOAEPParameterSpec.getPSource()).getValue());
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
    if (paramArrayOfByte1 != null) {
      this.bOut.write(paramArrayOfByte1, paramInt1, paramInt2);
    }
    if ((this.cipher instanceof RSABlindedEngine))
    {
      if (this.bOut.size() > this.cipher.getInputBlockSize() + 1) {
        throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
      }
    }
    else {
      if (this.bOut.size() > this.cipher.getInputBlockSize()) {
        break label110;
      }
    }
    paramArrayOfByte1 = getOutput();
    paramInt1 = 0;
    while (paramInt1 != paramArrayOfByte1.length)
    {
      paramArrayOfByte2[(paramInt3 + paramInt1)] = paramArrayOfByte1[paramInt1];
      paramInt1 += 1;
    }
    return paramArrayOfByte1.length;
    label110:
    throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
  }
  
  protected byte[] engineDoFinal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IllegalBlockSizeException, BadPaddingException
  {
    if (paramArrayOfByte != null) {
      this.bOut.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    if ((this.cipher instanceof RSABlindedEngine))
    {
      if (this.bOut.size() > this.cipher.getInputBlockSize() + 1) {
        throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
      }
    }
    else {
      if (this.bOut.size() > this.cipher.getInputBlockSize()) {
        break label82;
      }
    }
    return getOutput();
    label82:
    throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
  }
  
  protected int engineGetBlockSize()
  {
    try
    {
      int i = this.cipher.getInputBlockSize();
      return i;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;) {}
    }
    throw new IllegalStateException("RSA Cipher not initialised");
  }
  
  protected int engineGetKeySize(Key paramKey)
  {
    if ((paramKey instanceof RSAPrivateKey)) {}
    for (paramKey = ((RSAPrivateKey)paramKey).getModulus();; paramKey = ((RSAPublicKey)paramKey).getModulus())
    {
      return paramKey.bitLength();
      if (!(paramKey instanceof RSAPublicKey)) {
        break;
      }
    }
    throw new IllegalArgumentException("not an RSA key!");
  }
  
  protected int engineGetOutputSize(int paramInt)
  {
    try
    {
      paramInt = this.cipher.getOutputBlockSize();
      return paramInt;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;) {}
    }
    throw new IllegalStateException("RSA Cipher not initialised");
  }
  
  protected AlgorithmParameters engineGetParameters()
  {
    if ((this.engineParams == null) && (this.paramSpec != null)) {
      try
      {
        AlgorithmParameters localAlgorithmParameters = this.helper.createAlgorithmParameters("OAEP");
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
    AlgorithmParameterSpec localAlgorithmParameterSpec;
    if (paramAlgorithmParameters != null) {
      try
      {
        localAlgorithmParameterSpec = paramAlgorithmParameters.getParameterSpec(OAEPParameterSpec.class);
      }
      catch (InvalidParameterSpecException paramKey)
      {
        paramAlgorithmParameters = new StringBuilder();
        paramAlgorithmParameters.append("cannot recognise parameters: ");
        paramAlgorithmParameters.append(paramKey.toString());
        throw new InvalidAlgorithmParameterException(paramAlgorithmParameters.toString(), paramKey);
      }
    } else {
      localAlgorithmParameterSpec = null;
    }
    this.engineParams = paramAlgorithmParameters;
    engineInit(paramInt, paramKey, localAlgorithmParameterSpec, paramSecureRandom);
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
      paramSecureRandom = new StringBuilder();
      paramSecureRandom.append("Eeeek! ");
      paramSecureRandom.append(paramKey.toString());
      throw new InvalidKeyException(paramSecureRandom.toString(), paramKey);
    }
  }
  
  protected void engineInit(int paramInt, Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidKeyException, InvalidAlgorithmParameterException
  {
    if ((paramAlgorithmParameterSpec != null) && (!(paramAlgorithmParameterSpec instanceof OAEPParameterSpec)))
    {
      paramKey = new StringBuilder();
      paramKey.append("unknown parameter type: ");
      paramKey.append(paramAlgorithmParameterSpec.getClass().getName());
      throw new InvalidAlgorithmParameterException(paramKey.toString());
    }
    if ((paramKey instanceof RSAPublicKey))
    {
      if ((this.privateKeyOnly) && (paramInt == 1)) {
        throw new InvalidKeyException("mode 1 requires RSAPrivateKey");
      }
      paramKey = RSAUtil.generatePublicKeyParameter((RSAPublicKey)paramKey);
    }
    else
    {
      if (!(paramKey instanceof RSAPrivateKey)) {
        break label512;
      }
      if ((this.publicKeyOnly) && (paramInt == 1)) {
        throw new InvalidKeyException("mode 2 requires RSAPublicKey");
      }
      paramKey = RSAUtil.generatePrivateKeyParameter((RSAPrivateKey)paramKey);
    }
    if (paramAlgorithmParameterSpec != null)
    {
      OAEPParameterSpec localOAEPParameterSpec = (OAEPParameterSpec)paramAlgorithmParameterSpec;
      this.paramSpec = paramAlgorithmParameterSpec;
      if ((!localOAEPParameterSpec.getMGFAlgorithm().equalsIgnoreCase("MGF1")) && (!localOAEPParameterSpec.getMGFAlgorithm().equals(PKCSObjectIdentifiers.id_mgf1.getId()))) {
        throw new InvalidAlgorithmParameterException("unknown mask generation function specified");
      }
      if ((localOAEPParameterSpec.getMGFParameters() instanceof MGF1ParameterSpec))
      {
        Digest localDigest1 = DigestFactory.getDigest(localOAEPParameterSpec.getDigestAlgorithm());
        if (localDigest1 != null)
        {
          paramAlgorithmParameterSpec = (MGF1ParameterSpec)localOAEPParameterSpec.getMGFParameters();
          Digest localDigest2 = DigestFactory.getDigest(paramAlgorithmParameterSpec.getDigestAlgorithm());
          if (localDigest2 != null)
          {
            this.cipher = new OAEPEncoding(new RSABlindedEngine(), localDigest1, localDigest2, ((PSource.PSpecified)localOAEPParameterSpec.getPSource()).getValue());
          }
          else
          {
            paramKey = new StringBuilder();
            paramKey.append("no match on MGF digest algorithm: ");
            paramKey.append(paramAlgorithmParameterSpec.getDigestAlgorithm());
            throw new InvalidAlgorithmParameterException(paramKey.toString());
          }
        }
        else
        {
          paramKey = new StringBuilder();
          paramKey.append("no match on digest algorithm: ");
          paramKey.append(localOAEPParameterSpec.getDigestAlgorithm());
          throw new InvalidAlgorithmParameterException(paramKey.toString());
        }
      }
      else
      {
        throw new InvalidAlgorithmParameterException("unkown MGF parameters");
      }
    }
    paramAlgorithmParameterSpec = paramKey;
    if (!(this.cipher instanceof RSABlindedEngine)) {
      if (paramSecureRandom != null) {
        paramAlgorithmParameterSpec = new ParametersWithRandom(paramKey, paramSecureRandom);
      } else {
        paramAlgorithmParameterSpec = new ParametersWithRandom(paramKey, new SecureRandom());
      }
    }
    this.bOut.reset();
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3) {
          break label500;
        }
        if (paramInt != 4)
        {
          paramKey = new StringBuilder();
          paramKey.append("unknown opmode ");
          paramKey.append(paramInt);
          paramKey.append(" passed to RSA");
          throw new InvalidParameterException(paramKey.toString());
        }
      }
      this.cipher.init(false, paramAlgorithmParameterSpec);
      return;
    }
    label500:
    this.cipher.init(true, paramAlgorithmParameterSpec);
    return;
    label512:
    throw new InvalidKeyException("unknown key type passed to RSA");
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
      if (((String)localObject).equals("1"))
      {
        this.privateKeyOnly = true;
        this.publicKeyOnly = false;
        return;
      }
      if (((String)localObject).equals("2"))
      {
        this.privateKeyOnly = false;
        this.publicKeyOnly = true;
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
      paramString = new RSABlindedEngine();
    }
    for (;;)
    {
      this.cipher = paramString;
      return;
      if (((String)localObject).equals("PKCS1PADDING"))
      {
        paramString = new PKCS1Encoding(new RSABlindedEngine());
      }
      else
      {
        if (!((String)localObject).equals("ISO9796-1PADDING")) {
          break;
        }
        paramString = new ISO9796d1Encoding(new RSABlindedEngine());
      }
    }
    if (((String)localObject).equals("OAEPWITHMD5ANDMGF1PADDING")) {
      paramString = new OAEPParameterSpec("MD5", "MGF1", new MGF1ParameterSpec("MD5"), PSource.PSpecified.DEFAULT);
    }
    for (;;)
    {
      initFromSpec(paramString);
      return;
      if (((String)localObject).equals("OAEPPADDING")) {}
      while ((((String)localObject).equals("OAEPWITHSHA1ANDMGF1PADDING")) || (((String)localObject).equals("OAEPWITHSHA-1ANDMGF1PADDING")))
      {
        paramString = OAEPParameterSpec.DEFAULT;
        break;
      }
      if ((!((String)localObject).equals("OAEPWITHSHA224ANDMGF1PADDING")) && (!((String)localObject).equals("OAEPWITHSHA-224ANDMGF1PADDING")))
      {
        if ((!((String)localObject).equals("OAEPWITHSHA256ANDMGF1PADDING")) && (!((String)localObject).equals("OAEPWITHSHA-256ANDMGF1PADDING")))
        {
          if ((!((String)localObject).equals("OAEPWITHSHA384ANDMGF1PADDING")) && (!((String)localObject).equals("OAEPWITHSHA-384ANDMGF1PADDING")))
          {
            if ((!((String)localObject).equals("OAEPWITHSHA512ANDMGF1PADDING")) && (!((String)localObject).equals("OAEPWITHSHA-512ANDMGF1PADDING")))
            {
              if (((String)localObject).equals("OAEPWITHSHA3-224ANDMGF1PADDING"))
              {
                paramString = new OAEPParameterSpec("SHA3-224", "MGF1", new MGF1ParameterSpec("SHA3-224"), PSource.PSpecified.DEFAULT);
              }
              else if (((String)localObject).equals("OAEPWITHSHA3-256ANDMGF1PADDING"))
              {
                paramString = new OAEPParameterSpec("SHA3-256", "MGF1", new MGF1ParameterSpec("SHA3-256"), PSource.PSpecified.DEFAULT);
              }
              else if (((String)localObject).equals("OAEPWITHSHA3-384ANDMGF1PADDING"))
              {
                paramString = new OAEPParameterSpec("SHA3-384", "MGF1", new MGF1ParameterSpec("SHA3-384"), PSource.PSpecified.DEFAULT);
              }
              else if (((String)localObject).equals("OAEPWITHSHA3-512ANDMGF1PADDING"))
              {
                paramString = new OAEPParameterSpec("SHA3-512", "MGF1", new MGF1ParameterSpec("SHA3-512"), PSource.PSpecified.DEFAULT);
              }
              else
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(paramString);
                ((StringBuilder)localObject).append(" unavailable with RSA.");
                throw new NoSuchPaddingException(((StringBuilder)localObject).toString());
              }
            }
            else {
              paramString = new OAEPParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, PSource.PSpecified.DEFAULT);
            }
          }
          else {
            paramString = new OAEPParameterSpec("SHA-384", "MGF1", MGF1ParameterSpec.SHA384, PSource.PSpecified.DEFAULT);
          }
        }
        else {
          paramString = new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT);
        }
      }
      else {
        paramString = new OAEPParameterSpec("SHA-224", "MGF1", new MGF1ParameterSpec("SHA-224"), PSource.PSpecified.DEFAULT);
      }
    }
  }
  
  protected int engineUpdate(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    this.bOut.write(paramArrayOfByte1, paramInt1, paramInt2);
    if ((this.cipher instanceof RSABlindedEngine))
    {
      if (this.bOut.size() > this.cipher.getInputBlockSize() + 1) {
        throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
      }
    }
    else {
      if (this.bOut.size() > this.cipher.getInputBlockSize()) {
        break label75;
      }
    }
    return 0;
    label75:
    throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
  }
  
  protected byte[] engineUpdate(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.bOut.write(paramArrayOfByte, paramInt1, paramInt2);
    if ((this.cipher instanceof RSABlindedEngine))
    {
      if (this.bOut.size() > this.cipher.getInputBlockSize() + 1) {
        throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
      }
    }
    else {
      if (this.bOut.size() > this.cipher.getInputBlockSize()) {
        break label75;
      }
    }
    return null;
    label75:
    throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
  }
  
  public static class ISO9796d1Padding
    extends CipherSpi
  {
    public ISO9796d1Padding()
    {
      super();
    }
  }
  
  public static class NoPadding
    extends CipherSpi
  {
    public NoPadding()
    {
      super();
    }
  }
  
  public static class OAEPPadding
    extends CipherSpi
  {
    public OAEPPadding()
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
  
  public static class PKCS1v1_5Padding_PrivateOnly
    extends CipherSpi
  {
    public PKCS1v1_5Padding_PrivateOnly()
    {
      super(true, new PKCS1Encoding(new RSABlindedEngine()));
    }
  }
  
  public static class PKCS1v1_5Padding_PublicOnly
    extends CipherSpi
  {
    public PKCS1v1_5Padding_PublicOnly()
    {
      super(false, new PKCS1Encoding(new RSABlindedEngine()));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\rsa\CipherSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */