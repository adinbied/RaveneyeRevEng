package org.bouncycastle.crypto.signers;

import java.io.IOException;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.RSABlindedEngine;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;

public class RSADigestSigner
  implements Signer
{
  private static final Hashtable oidMap;
  private final AlgorithmIdentifier algId;
  private final Digest digest;
  private boolean forSigning;
  private final AsymmetricBlockCipher rsaEngine = new PKCS1Encoding(new RSABlindedEngine());
  
  static
  {
    Hashtable localHashtable = new Hashtable();
    oidMap = localHashtable;
    localHashtable.put("RIPEMD128", TeleTrusTObjectIdentifiers.ripemd128);
    oidMap.put("RIPEMD160", TeleTrusTObjectIdentifiers.ripemd160);
    oidMap.put("RIPEMD256", TeleTrusTObjectIdentifiers.ripemd256);
    oidMap.put("SHA-1", X509ObjectIdentifiers.id_SHA1);
    oidMap.put("SHA-224", NISTObjectIdentifiers.id_sha224);
    oidMap.put("SHA-256", NISTObjectIdentifiers.id_sha256);
    oidMap.put("SHA-384", NISTObjectIdentifiers.id_sha384);
    oidMap.put("SHA-512", NISTObjectIdentifiers.id_sha512);
    oidMap.put("SHA-512/224", NISTObjectIdentifiers.id_sha512_224);
    oidMap.put("SHA-512/256", NISTObjectIdentifiers.id_sha512_256);
    oidMap.put("SHA3-224", NISTObjectIdentifiers.id_sha3_224);
    oidMap.put("SHA3-256", NISTObjectIdentifiers.id_sha3_256);
    oidMap.put("SHA3-384", NISTObjectIdentifiers.id_sha3_384);
    oidMap.put("SHA3-512", NISTObjectIdentifiers.id_sha3_512);
    oidMap.put("MD2", PKCSObjectIdentifiers.md2);
    oidMap.put("MD4", PKCSObjectIdentifiers.md4);
    oidMap.put("MD5", PKCSObjectIdentifiers.md5);
  }
  
  public RSADigestSigner(Digest paramDigest)
  {
    this(paramDigest, (ASN1ObjectIdentifier)oidMap.get(paramDigest.getAlgorithmName()));
  }
  
  public RSADigestSigner(Digest paramDigest, ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this.digest = paramDigest;
    this.algId = new AlgorithmIdentifier(paramASN1ObjectIdentifier, DERNull.INSTANCE);
  }
  
  private byte[] derEncode(byte[] paramArrayOfByte)
    throws IOException
  {
    return new DigestInfo(this.algId, paramArrayOfByte).getEncoded("DER");
  }
  
  public byte[] generateSignature()
    throws CryptoException, DataLengthException
  {
    if (this.forSigning)
    {
      byte[] arrayOfByte = new byte[this.digest.getDigestSize()];
      this.digest.doFinal(arrayOfByte, 0);
      try
      {
        arrayOfByte = derEncode(arrayOfByte);
        arrayOfByte = this.rsaEngine.processBlock(arrayOfByte, 0, arrayOfByte.length);
        return arrayOfByte;
      }
      catch (IOException localIOException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unable to encode signature: ");
        localStringBuilder.append(localIOException.getMessage());
        throw new CryptoException(localStringBuilder.toString(), localIOException);
      }
    }
    throw new IllegalStateException("RSADigestSigner not initialised for signature generation.");
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.digest.getAlgorithmName());
    localStringBuilder.append("withRSA");
    return localStringBuilder.toString();
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    this.forSigning = paramBoolean;
    AsymmetricKeyParameter localAsymmetricKeyParameter;
    if ((paramCipherParameters instanceof ParametersWithRandom)) {
      localAsymmetricKeyParameter = (AsymmetricKeyParameter)((ParametersWithRandom)paramCipherParameters).getParameters();
    } else {
      localAsymmetricKeyParameter = (AsymmetricKeyParameter)paramCipherParameters;
    }
    if ((paramBoolean) && (!localAsymmetricKeyParameter.isPrivate())) {
      throw new IllegalArgumentException("signing requires private key");
    }
    if ((!paramBoolean) && (localAsymmetricKeyParameter.isPrivate())) {
      throw new IllegalArgumentException("verification requires public key");
    }
    reset();
    this.rsaEngine.init(paramBoolean, paramCipherParameters);
  }
  
  public void reset()
  {
    this.digest.reset();
  }
  
  public void update(byte paramByte)
  {
    this.digest.update(paramByte);
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.digest.update(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public boolean verifySignature(byte[] paramArrayOfByte)
  {
    int k;
    byte[] arrayOfByte;
    boolean bool;
    if (!this.forSigning)
    {
      k = this.digest.getDigestSize();
      arrayOfByte = new byte[k];
      Digest localDigest = this.digest;
      bool = false;
      localDigest.doFinal(arrayOfByte, 0);
    }
    try
    {
      paramArrayOfByte = this.rsaEngine.processBlock(paramArrayOfByte, 0, paramArrayOfByte.length);
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
    throw new IllegalStateException("RSADigestSigner not initialised for verification");
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\signers\RSADigestSigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */