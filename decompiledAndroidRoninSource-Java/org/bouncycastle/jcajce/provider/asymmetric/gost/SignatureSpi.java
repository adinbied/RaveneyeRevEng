package org.bouncycastle.jcajce.provider.asymmetric.gost;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.crypto.DSA;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.GOST3411Digest;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.signers.GOST3410Signer;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.GOST3410Util;
import org.bouncycastle.jce.interfaces.ECKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.interfaces.GOST3410Key;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class SignatureSpi
  extends java.security.SignatureSpi
  implements PKCSObjectIdentifiers, X509ObjectIdentifiers
{
  private Digest digest = new GOST3411Digest();
  private SecureRandom random;
  private DSA signer = new GOST3410Signer();
  
  protected Object engineGetParameter(String paramString)
  {
    throw new UnsupportedOperationException("engineSetParameter unsupported");
  }
  
  protected void engineInitSign(PrivateKey paramPrivateKey)
    throws InvalidKeyException
  {
    if ((paramPrivateKey instanceof ECKey)) {
      paramPrivateKey = ECUtil.generatePrivateKeyParameter(paramPrivateKey);
    } else {
      paramPrivateKey = GOST3410Util.generatePrivateKeyParameter(paramPrivateKey);
    }
    this.digest.reset();
    SecureRandom localSecureRandom = this.random;
    if (localSecureRandom != null)
    {
      this.signer.init(true, new ParametersWithRandom(paramPrivateKey, localSecureRandom));
      return;
    }
    this.signer.init(true, paramPrivateKey);
  }
  
  protected void engineInitSign(PrivateKey paramPrivateKey, SecureRandom paramSecureRandom)
    throws InvalidKeyException
  {
    this.random = paramSecureRandom;
    engineInitSign(paramPrivateKey);
  }
  
  protected void engineInitVerify(PublicKey paramPublicKey)
    throws InvalidKeyException
  {
    if ((paramPublicKey instanceof ECPublicKey)) {
      paramPublicKey = ECUtil.generatePublicKeyParameter(paramPublicKey);
    } else if ((paramPublicKey instanceof GOST3410Key)) {
      paramPublicKey = GOST3410Util.generatePublicKeyParameter(paramPublicKey);
    }
    try
    {
      paramPublicKey = BouncyCastleProvider.getPublicKey(SubjectPublicKeyInfo.getInstance(paramPublicKey.getEncoded()));
      if ((paramPublicKey instanceof ECPublicKey))
      {
        paramPublicKey = ECUtil.generatePublicKeyParameter(paramPublicKey);
        this.digest.reset();
        this.signer.init(false, paramPublicKey);
        return;
      }
      throw new InvalidKeyException("can't recognise key type in DSA based signer");
    }
    catch (Exception paramPublicKey)
    {
      for (;;) {}
    }
    throw new InvalidKeyException("can't recognise key type in DSA based signer");
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
    byte[] arrayOfByte2 = new byte[this.digest.getDigestSize()];
    this.digest.doFinal(arrayOfByte2, 0);
    try
    {
      byte[] arrayOfByte1 = new byte[64];
      Object localObject = this.signer.generateSignature(arrayOfByte2);
      arrayOfByte2 = localObject[0].toByteArray();
      localObject = localObject[1].toByteArray();
      if (localObject[0] != 0) {
        System.arraycopy(localObject, 0, arrayOfByte1, 32 - localObject.length, localObject.length);
      } else {
        System.arraycopy(localObject, 1, arrayOfByte1, 32 - (localObject.length - 1), localObject.length - 1);
      }
      if (arrayOfByte2[0] != 0)
      {
        System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 64 - arrayOfByte2.length, arrayOfByte2.length);
        return arrayOfByte1;
      }
      System.arraycopy(arrayOfByte2, 1, arrayOfByte1, 64 - (arrayOfByte2.length - 1), arrayOfByte2.length - 1);
      return arrayOfByte1;
    }
    catch (Exception localException)
    {
      throw new SignatureException(localException.toString());
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
    byte[] arrayOfByte1 = new byte[this.digest.getDigestSize()];
    this.digest.doFinal(arrayOfByte1, 0);
    try
    {
      byte[] arrayOfByte2 = new byte[32];
      byte[] arrayOfByte3 = new byte[32];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte3, 0, 32);
      System.arraycopy(paramArrayOfByte, 32, arrayOfByte2, 0, 32);
      paramArrayOfByte = new BigInteger[2];
      paramArrayOfByte[0] = new BigInteger(1, arrayOfByte2);
      paramArrayOfByte[1] = new BigInteger(1, arrayOfByte3);
      return this.signer.verifySignature(arrayOfByte1, paramArrayOfByte[0], paramArrayOfByte[1]);
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;) {}
    }
    throw new SignatureException("error decoding signature bytes.");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\gost\SignatureSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */