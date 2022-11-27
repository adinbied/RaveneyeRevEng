package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD2Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.NullDigest;
import org.bouncycastle.crypto.digests.RIPEMD128Digest;
import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.crypto.digests.RIPEMD256Digest;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.RSABlindedEngine;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.util.Arrays;

public class DigestSignatureSpi
  extends SignatureSpi
{
  private AlgorithmIdentifier algId;
  private AsymmetricBlockCipher cipher;
  private Digest digest;
  
  protected DigestSignatureSpi(ASN1ObjectIdentifier paramASN1ObjectIdentifier, Digest paramDigest, AsymmetricBlockCipher paramAsymmetricBlockCipher)
  {
    this.digest = paramDigest;
    this.cipher = paramAsymmetricBlockCipher;
    this.algId = new AlgorithmIdentifier(paramASN1ObjectIdentifier, DERNull.INSTANCE);
  }
  
  protected DigestSignatureSpi(Digest paramDigest, AsymmetricBlockCipher paramAsymmetricBlockCipher)
  {
    this.digest = paramDigest;
    this.cipher = paramAsymmetricBlockCipher;
    this.algId = null;
  }
  
  private byte[] derEncode(byte[] paramArrayOfByte)
    throws IOException
  {
    AlgorithmIdentifier localAlgorithmIdentifier = this.algId;
    if (localAlgorithmIdentifier == null) {
      return paramArrayOfByte;
    }
    return new DigestInfo(localAlgorithmIdentifier, paramArrayOfByte).getEncoded("DER");
  }
  
  private String getType(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return paramObject.getClass().getName();
  }
  
  protected Object engineGetParameter(String paramString)
  {
    return null;
  }
  
  protected AlgorithmParameters engineGetParameters()
  {
    return null;
  }
  
  protected void engineInitSign(PrivateKey paramPrivateKey)
    throws InvalidKeyException
  {
    if ((paramPrivateKey instanceof RSAPrivateKey))
    {
      paramPrivateKey = RSAUtil.generatePrivateKeyParameter((RSAPrivateKey)paramPrivateKey);
      this.digest.reset();
      this.cipher.init(true, paramPrivateKey);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Supplied key (");
    localStringBuilder.append(getType(paramPrivateKey));
    localStringBuilder.append(") is not a RSAPrivateKey instance");
    throw new InvalidKeyException(localStringBuilder.toString());
  }
  
  protected void engineInitVerify(PublicKey paramPublicKey)
    throws InvalidKeyException
  {
    if ((paramPublicKey instanceof RSAPublicKey))
    {
      paramPublicKey = RSAUtil.generatePublicKeyParameter((RSAPublicKey)paramPublicKey);
      this.digest.reset();
      this.cipher.init(false, paramPublicKey);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Supplied key (");
    localStringBuilder.append(getType(paramPublicKey));
    localStringBuilder.append(") is not a RSAPublicKey instance");
    throw new InvalidKeyException(localStringBuilder.toString());
  }
  
  protected void engineSetParameter(String paramString, Object paramObject)
  {
    throw new UnsupportedOperationException("engineSetParameter unsupported");
  }
  
  protected void engineSetParameter(AlgorithmParameterSpec paramAlgorithmParameterSpec)
  {
    throw new UnsupportedOperationException("engineSetParameter unsupported");
  }
  
  protected byte[] engineSign()
    throws SignatureException
  {
    byte[] arrayOfByte = new byte[this.digest.getDigestSize()];
    this.digest.doFinal(arrayOfByte, 0);
    try
    {
      arrayOfByte = derEncode(arrayOfByte);
      arrayOfByte = this.cipher.processBlock(arrayOfByte, 0, arrayOfByte.length);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      throw new SignatureException(localException.toString());
      throw new SignatureException("key too small for signature type");
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      for (;;) {}
    }
  }
  
  protected void engineUpdate(byte paramByte)
    throws SignatureException
  {
    this.digest.update(paramByte);
  }
  
  protected void engineUpdate(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws SignatureException
  {
    this.digest.update(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  protected boolean engineVerify(byte[] paramArrayOfByte)
    throws SignatureException
  {
    int k = this.digest.getDigestSize();
    byte[] arrayOfByte = new byte[k];
    Digest localDigest = this.digest;
    boolean bool = false;
    localDigest.doFinal(arrayOfByte, 0);
    try
    {
      paramArrayOfByte = this.cipher.processBlock(paramArrayOfByte, 0, paramArrayOfByte.length);
      arrayOfByte = derEncode(arrayOfByte);
      if (paramArrayOfByte.length == arrayOfByte.length) {
        return Arrays.constantTimeAreEqual(paramArrayOfByte, arrayOfByte);
      }
      if (paramArrayOfByte.length == arrayOfByte.length - 2)
      {
        int m = paramArrayOfByte.length - k - 2;
        int n = arrayOfByte.length;
        arrayOfByte[1] = ((byte)(arrayOfByte[1] - 2));
        arrayOfByte[3] = ((byte)(arrayOfByte[3] - 2));
        int j = 0;
        int i = 0;
        while (j < k)
        {
          i |= paramArrayOfByte[(m + j)] ^ arrayOfByte[(n - k - 2 + j)];
          j += 1;
        }
        k = 0;
        j = i;
        i = k;
        while (i < m)
        {
          j |= paramArrayOfByte[i] ^ arrayOfByte[i];
          i += 1;
        }
        if (j == 0) {
          bool = true;
        }
        return bool;
      }
      Arrays.constantTimeAreEqual(arrayOfByte, arrayOfByte);
      return false;
    }
    catch (Exception paramArrayOfByte) {}
    return false;
  }
  
  public static class MD2
    extends DigestSignatureSpi
  {
    public MD2()
    {
      super(new MD2Digest(), new PKCS1Encoding(new RSABlindedEngine()));
    }
  }
  
  public static class MD4
    extends DigestSignatureSpi
  {
    public MD4()
    {
      super(new MD4Digest(), new PKCS1Encoding(new RSABlindedEngine()));
    }
  }
  
  public static class MD5
    extends DigestSignatureSpi
  {
    public MD5()
    {
      super(DigestFactory.createMD5(), new PKCS1Encoding(new RSABlindedEngine()));
    }
  }
  
  public static class RIPEMD128
    extends DigestSignatureSpi
  {
    public RIPEMD128()
    {
      super(new RIPEMD128Digest(), new PKCS1Encoding(new RSABlindedEngine()));
    }
  }
  
  public static class RIPEMD160
    extends DigestSignatureSpi
  {
    public RIPEMD160()
    {
      super(new RIPEMD160Digest(), new PKCS1Encoding(new RSABlindedEngine()));
    }
  }
  
  public static class RIPEMD256
    extends DigestSignatureSpi
  {
    public RIPEMD256()
    {
      super(new RIPEMD256Digest(), new PKCS1Encoding(new RSABlindedEngine()));
    }
  }
  
  public static class SHA1
    extends DigestSignatureSpi
  {
    public SHA1()
    {
      super(DigestFactory.createSHA1(), new PKCS1Encoding(new RSABlindedEngine()));
    }
  }
  
  public static class SHA224
    extends DigestSignatureSpi
  {
    public SHA224()
    {
      super(DigestFactory.createSHA224(), new PKCS1Encoding(new RSABlindedEngine()));
    }
  }
  
  public static class SHA256
    extends DigestSignatureSpi
  {
    public SHA256()
    {
      super(DigestFactory.createSHA256(), new PKCS1Encoding(new RSABlindedEngine()));
    }
  }
  
  public static class SHA384
    extends DigestSignatureSpi
  {
    public SHA384()
    {
      super(DigestFactory.createSHA384(), new PKCS1Encoding(new RSABlindedEngine()));
    }
  }
  
  public static class SHA3_224
    extends DigestSignatureSpi
  {
    public SHA3_224()
    {
      super(DigestFactory.createSHA3_224(), new PKCS1Encoding(new RSABlindedEngine()));
    }
  }
  
  public static class SHA3_256
    extends DigestSignatureSpi
  {
    public SHA3_256()
    {
      super(DigestFactory.createSHA3_256(), new PKCS1Encoding(new RSABlindedEngine()));
    }
  }
  
  public static class SHA3_384
    extends DigestSignatureSpi
  {
    public SHA3_384()
    {
      super(DigestFactory.createSHA3_384(), new PKCS1Encoding(new RSABlindedEngine()));
    }
  }
  
  public static class SHA3_512
    extends DigestSignatureSpi
  {
    public SHA3_512()
    {
      super(DigestFactory.createSHA3_512(), new PKCS1Encoding(new RSABlindedEngine()));
    }
  }
  
  public static class SHA512
    extends DigestSignatureSpi
  {
    public SHA512()
    {
      super(DigestFactory.createSHA512(), new PKCS1Encoding(new RSABlindedEngine()));
    }
  }
  
  public static class SHA512_224
    extends DigestSignatureSpi
  {
    public SHA512_224()
    {
      super(DigestFactory.createSHA512_224(), new PKCS1Encoding(new RSABlindedEngine()));
    }
  }
  
  public static class SHA512_256
    extends DigestSignatureSpi
  {
    public SHA512_256()
    {
      super(DigestFactory.createSHA512_256(), new PKCS1Encoding(new RSABlindedEngine()));
    }
  }
  
  public static class noneRSA
    extends DigestSignatureSpi
  {
    public noneRSA()
    {
      super(new PKCS1Encoding(new RSABlindedEngine()));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\rsa\DigestSignatureSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */