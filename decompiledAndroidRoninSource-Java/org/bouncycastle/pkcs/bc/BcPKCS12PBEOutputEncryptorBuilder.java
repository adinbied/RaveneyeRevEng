package org.bouncycastle.pkcs.bc;

import java.io.OutputStream;
import java.security.SecureRandom;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCS12PBEParams;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.generators.PKCS12ParametersGenerator;
import org.bouncycastle.crypto.io.CipherOutputStream;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OutputEncryptor;

public class BcPKCS12PBEOutputEncryptorBuilder
{
  private ASN1ObjectIdentifier algorithm;
  private ExtendedDigest digest;
  private BufferedBlockCipher engine;
  private int iterationCount = 1024;
  private SecureRandom random;
  
  public BcPKCS12PBEOutputEncryptorBuilder(ASN1ObjectIdentifier paramASN1ObjectIdentifier, BlockCipher paramBlockCipher)
  {
    this(paramASN1ObjectIdentifier, paramBlockCipher, new SHA1Digest());
  }
  
  public BcPKCS12PBEOutputEncryptorBuilder(ASN1ObjectIdentifier paramASN1ObjectIdentifier, BlockCipher paramBlockCipher, ExtendedDigest paramExtendedDigest)
  {
    this.algorithm = paramASN1ObjectIdentifier;
    this.engine = new PaddedBufferedBlockCipher(paramBlockCipher, new PKCS7Padding());
    this.digest = paramExtendedDigest;
  }
  
  public OutputEncryptor build(final char[] paramArrayOfChar)
  {
    if (this.random == null) {
      this.random = new SecureRandom();
    }
    final Object localObject = new byte[20];
    this.random.nextBytes((byte[])localObject);
    localObject = new PKCS12PBEParams((byte[])localObject, this.iterationCount);
    CipherParameters localCipherParameters = PKCS12PBEUtils.createCipherParameters(this.algorithm, this.digest, this.engine.getBlockSize(), (PKCS12PBEParams)localObject, paramArrayOfChar);
    this.engine.init(true, localCipherParameters);
    new OutputEncryptor()
    {
      public AlgorithmIdentifier getAlgorithmIdentifier()
      {
        return new AlgorithmIdentifier(BcPKCS12PBEOutputEncryptorBuilder.this.algorithm, localObject);
      }
      
      public GenericKey getKey()
      {
        return new GenericKey(new AlgorithmIdentifier(BcPKCS12PBEOutputEncryptorBuilder.this.algorithm, localObject), PKCS12ParametersGenerator.PKCS12PasswordToBytes(paramArrayOfChar));
      }
      
      public OutputStream getOutputStream(OutputStream paramAnonymousOutputStream)
      {
        return new CipherOutputStream(paramAnonymousOutputStream, BcPKCS12PBEOutputEncryptorBuilder.this.engine);
      }
    };
  }
  
  public BcPKCS12PBEOutputEncryptorBuilder setIterationCount(int paramInt)
  {
    this.iterationCount = paramInt;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkcs\bc\BcPKCS12PBEOutputEncryptorBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */