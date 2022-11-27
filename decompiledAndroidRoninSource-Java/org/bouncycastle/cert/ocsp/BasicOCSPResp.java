package org.bouncycastle.cert.ocsp;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.ocsp.BasicOCSPResponse;
import org.bouncycastle.asn1.ocsp.ResponseData;
import org.bouncycastle.asn1.ocsp.SingleResponse;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.util.Encodable;

public class BasicOCSPResp
  implements Encodable
{
  private ResponseData data;
  private Extensions extensions;
  private BasicOCSPResponse resp;
  
  public BasicOCSPResp(BasicOCSPResponse paramBasicOCSPResponse)
  {
    this.resp = paramBasicOCSPResponse;
    this.data = paramBasicOCSPResponse.getTbsResponseData();
    this.extensions = Extensions.getInstance(paramBasicOCSPResponse.getTbsResponseData().getResponseExtensions());
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof BasicOCSPResp)) {
      return false;
    }
    paramObject = (BasicOCSPResp)paramObject;
    return this.resp.equals(((BasicOCSPResp)paramObject).resp);
  }
  
  public X509CertificateHolder[] getCerts()
  {
    if (this.resp.getCerts() != null)
    {
      ASN1Sequence localASN1Sequence = this.resp.getCerts();
      if (localASN1Sequence != null)
      {
        int j = localASN1Sequence.size();
        X509CertificateHolder[] arrayOfX509CertificateHolder = new X509CertificateHolder[j];
        int i = 0;
        while (i != j)
        {
          arrayOfX509CertificateHolder[i] = new X509CertificateHolder(Certificate.getInstance(localASN1Sequence.getObjectAt(i)));
          i += 1;
        }
        return arrayOfX509CertificateHolder;
      }
      return OCSPUtils.EMPTY_CERTS;
    }
    return OCSPUtils.EMPTY_CERTS;
  }
  
  public Set getCriticalExtensionOIDs()
  {
    return OCSPUtils.getCriticalExtensionOIDs(this.extensions);
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return this.resp.getEncoded();
  }
  
  public Extension getExtension(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    Extensions localExtensions = this.extensions;
    if (localExtensions != null) {
      return localExtensions.getExtension(paramASN1ObjectIdentifier);
    }
    return null;
  }
  
  public List getExtensionOIDs()
  {
    return OCSPUtils.getExtensionOIDs(this.extensions);
  }
  
  public Set getNonCriticalExtensionOIDs()
  {
    return OCSPUtils.getNonCriticalExtensionOIDs(this.extensions);
  }
  
  public Date getProducedAt()
  {
    return OCSPUtils.extractDate(this.data.getProducedAt());
  }
  
  public RespID getResponderId()
  {
    return new RespID(this.data.getResponderID());
  }
  
  public SingleResp[] getResponses()
  {
    ASN1Sequence localASN1Sequence = this.data.getResponses();
    int j = localASN1Sequence.size();
    SingleResp[] arrayOfSingleResp = new SingleResp[j];
    int i = 0;
    while (i != j)
    {
      arrayOfSingleResp[i] = new SingleResp(SingleResponse.getInstance(localASN1Sequence.getObjectAt(i)));
      i += 1;
    }
    return arrayOfSingleResp;
  }
  
  public byte[] getSignature()
  {
    return this.resp.getSignature().getOctets();
  }
  
  public ASN1ObjectIdentifier getSignatureAlgOID()
  {
    return this.resp.getSignatureAlgorithm().getAlgorithm();
  }
  
  public AlgorithmIdentifier getSignatureAlgorithmID()
  {
    return this.resp.getSignatureAlgorithm();
  }
  
  public byte[] getTBSResponseData()
  {
    try
    {
      byte[] arrayOfByte = this.resp.getTbsResponseData().getEncoded("DER");
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    return null;
  }
  
  public int getVersion()
  {
    return this.data.getVersion().getValue().intValue() + 1;
  }
  
  public boolean hasExtensions()
  {
    return this.extensions != null;
  }
  
  public int hashCode()
  {
    return this.resp.hashCode();
  }
  
  public boolean isSignatureValid(ContentVerifierProvider paramContentVerifierProvider)
    throws OCSPException
  {
    try
    {
      paramContentVerifierProvider = paramContentVerifierProvider.get(this.resp.getSignatureAlgorithm());
      localObject = paramContentVerifierProvider.getOutputStream();
      ((OutputStream)localObject).write(this.resp.getTbsResponseData().getEncoded("DER"));
      ((OutputStream)localObject).close();
      boolean bool = paramContentVerifierProvider.verify(getSignature());
      return bool;
    }
    catch (Exception paramContentVerifierProvider)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("exception processing sig: ");
      ((StringBuilder)localObject).append(paramContentVerifierProvider);
      throw new OCSPException(((StringBuilder)localObject).toString(), paramContentVerifierProvider);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\ocsp\BasicOCSPResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */