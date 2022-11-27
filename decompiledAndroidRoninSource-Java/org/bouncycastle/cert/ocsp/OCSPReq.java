package org.bouncycastle.cert.ocsp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Exception;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.ocsp.OCSPRequest;
import org.bouncycastle.asn1.ocsp.Request;
import org.bouncycastle.asn1.ocsp.Signature;
import org.bouncycastle.asn1.ocsp.TBSRequest;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.cert.CertIOException;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.ContentVerifierProvider;

public class OCSPReq
{
  private static final X509CertificateHolder[] EMPTY_CERTS = new X509CertificateHolder[0];
  private Extensions extensions;
  private OCSPRequest req;
  
  private OCSPReq(ASN1InputStream paramASN1InputStream)
    throws IOException
  {
    try
    {
      paramASN1InputStream = OCSPRequest.getInstance(paramASN1InputStream.readObject());
      this.req = paramASN1InputStream;
      if (paramASN1InputStream != null)
      {
        this.extensions = paramASN1InputStream.getTbsRequest().getRequestExtensions();
        return;
      }
      throw new CertIOException("malformed request: no request data found");
    }
    catch (ASN1Exception paramASN1InputStream)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed request: ");
      localStringBuilder.append(paramASN1InputStream.getMessage());
      throw new CertIOException(localStringBuilder.toString(), paramASN1InputStream);
    }
    catch (ClassCastException paramASN1InputStream)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed request: ");
      localStringBuilder.append(paramASN1InputStream.getMessage());
      throw new CertIOException(localStringBuilder.toString(), paramASN1InputStream);
    }
    catch (IllegalArgumentException paramASN1InputStream)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed request: ");
      localStringBuilder.append(paramASN1InputStream.getMessage());
      throw new CertIOException(localStringBuilder.toString(), paramASN1InputStream);
    }
  }
  
  public OCSPReq(OCSPRequest paramOCSPRequest)
  {
    this.req = paramOCSPRequest;
    this.extensions = paramOCSPRequest.getTbsRequest().getRequestExtensions();
  }
  
  public OCSPReq(byte[] paramArrayOfByte)
    throws IOException
  {
    this(new ASN1InputStream(paramArrayOfByte));
  }
  
  public X509CertificateHolder[] getCerts()
  {
    if (this.req.getOptionalSignature() != null)
    {
      ASN1Sequence localASN1Sequence = this.req.getOptionalSignature().getCerts();
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
      return EMPTY_CERTS;
    }
    return EMPTY_CERTS;
  }
  
  public Set getCriticalExtensionOIDs()
  {
    return OCSPUtils.getCriticalExtensionOIDs(this.extensions);
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    new ASN1OutputStream(localByteArrayOutputStream).writeObject(this.req);
    return localByteArrayOutputStream.toByteArray();
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
  
  public Req[] getRequestList()
  {
    ASN1Sequence localASN1Sequence = this.req.getTbsRequest().getRequestList();
    int j = localASN1Sequence.size();
    Req[] arrayOfReq = new Req[j];
    int i = 0;
    while (i != j)
    {
      arrayOfReq[i] = new Req(Request.getInstance(localASN1Sequence.getObjectAt(i)));
      i += 1;
    }
    return arrayOfReq;
  }
  
  public GeneralName getRequestorName()
  {
    return GeneralName.getInstance(this.req.getTbsRequest().getRequestorName());
  }
  
  public byte[] getSignature()
  {
    if (!isSigned()) {
      return null;
    }
    return this.req.getOptionalSignature().getSignature().getOctets();
  }
  
  public ASN1ObjectIdentifier getSignatureAlgOID()
  {
    if (!isSigned()) {
      return null;
    }
    return this.req.getOptionalSignature().getSignatureAlgorithm().getAlgorithm();
  }
  
  public int getVersionNumber()
  {
    return this.req.getTbsRequest().getVersion().getValue().intValue() + 1;
  }
  
  public boolean hasExtensions()
  {
    return this.extensions != null;
  }
  
  public boolean isSignatureValid(ContentVerifierProvider paramContentVerifierProvider)
    throws OCSPException
  {
    if (isSigned()) {
      try
      {
        paramContentVerifierProvider = paramContentVerifierProvider.get(this.req.getOptionalSignature().getSignatureAlgorithm());
        paramContentVerifierProvider.getOutputStream().write(this.req.getTbsRequest().getEncoded("DER"));
        boolean bool = paramContentVerifierProvider.verify(getSignature());
        return bool;
      }
      catch (Exception paramContentVerifierProvider)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("exception processing signature: ");
        localStringBuilder.append(paramContentVerifierProvider);
        throw new OCSPException(localStringBuilder.toString(), paramContentVerifierProvider);
      }
    }
    throw new OCSPException("attempt to verify signature on unsigned object");
  }
  
  public boolean isSigned()
  {
    return this.req.getOptionalSignature() != null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\ocsp\OCSPReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */