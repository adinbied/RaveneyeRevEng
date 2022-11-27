package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.crypto.DSA;
import org.bouncycastle.crypto.Digest;

public abstract class DSABase
  extends SignatureSpi
  implements PKCSObjectIdentifiers, X509ObjectIdentifiers
{
  protected Digest digest;
  protected DSAEncoder encoder;
  protected DSA signer;
  
  protected DSABase(Digest paramDigest, DSA paramDSA, DSAEncoder paramDSAEncoder)
  {
    this.digest = paramDigest;
    this.signer = paramDSA;
    this.encoder = paramDSAEncoder;
  }
  
  protected Object engineGetParameter(String paramString)
  {
    throw new UnsupportedOperationException("engineSetParameter unsupported");
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
    Object localObject = new byte[this.digest.getDigestSize()];
    this.digest.doFinal((byte[])localObject, 0);
    try
    {
      localObject = this.signer.generateSignature((byte[])localObject);
      localObject = this.encoder.encode(localObject[0], localObject[1]);
      return (byte[])localObject;
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
    byte[] arrayOfByte = new byte[this.digest.getDigestSize()];
    this.digest.doFinal(arrayOfByte, 0);
    try
    {
      paramArrayOfByte = this.encoder.decode(paramArrayOfByte);
      return this.signer.verifySignature(arrayOfByte, paramArrayOfByte[0], paramArrayOfByte[1]);
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;) {}
    }
    throw new SignatureException("error decoding signature bytes.");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetri\\util\DSABase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */