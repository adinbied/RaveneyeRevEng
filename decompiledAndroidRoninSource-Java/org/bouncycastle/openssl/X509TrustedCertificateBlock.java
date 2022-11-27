package org.bouncycastle.openssl;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.util.Arrays;

public class X509TrustedCertificateBlock
{
  private final X509CertificateHolder certificateHolder;
  private final CertificateTrustBlock trustBlock;
  
  public X509TrustedCertificateBlock(X509CertificateHolder paramX509CertificateHolder, CertificateTrustBlock paramCertificateTrustBlock)
  {
    this.certificateHolder = paramX509CertificateHolder;
    this.trustBlock = paramCertificateTrustBlock;
  }
  
  public X509TrustedCertificateBlock(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new ASN1InputStream(paramArrayOfByte);
    this.certificateHolder = new X509CertificateHolder(paramArrayOfByte.readObject().getEncoded());
    this.trustBlock = new CertificateTrustBlock(paramArrayOfByte.readObject().getEncoded());
  }
  
  public X509CertificateHolder getCertificateHolder()
  {
    return this.certificateHolder;
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return Arrays.concatenate(this.certificateHolder.getEncoded(), this.trustBlock.toASN1Sequence().getEncoded());
  }
  
  public CertificateTrustBlock getTrustBlock()
  {
    return this.trustBlock;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\openssl\X509TrustedCertificateBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */