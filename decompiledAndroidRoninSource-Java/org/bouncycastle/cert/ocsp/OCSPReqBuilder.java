package org.bouncycastle.cert.ocsp;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.ocsp.OCSPRequest;
import org.bouncycastle.asn1.ocsp.Request;
import org.bouncycastle.asn1.ocsp.Signature;
import org.bouncycastle.asn1.ocsp.TBSRequest;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.ContentSigner;

public class OCSPReqBuilder
{
  private List list = new ArrayList();
  private Extensions requestExtensions = null;
  private GeneralName requestorName = null;
  
  private OCSPReq generateRequest(ContentSigner paramContentSigner, X509CertificateHolder[] paramArrayOfX509CertificateHolder)
    throws OCSPException
  {
    Object localObject1 = this.list.iterator();
    Object localObject2 = new ASN1EncodableVector();
    while (((Iterator)localObject1).hasNext()) {
      try
      {
        ((ASN1EncodableVector)localObject2).add(((RequestObject)((Iterator)localObject1).next()).toRequest());
      }
      catch (Exception paramContentSigner)
      {
        throw new OCSPException("exception creating Request", paramContentSigner);
      }
    }
    localObject2 = new TBSRequest(this.requestorName, new DERSequence((ASN1EncodableVector)localObject2), this.requestExtensions);
    localObject1 = null;
    if (paramContentSigner != null)
    {
      if (this.requestorName != null) {
        try
        {
          localObject1 = paramContentSigner.getOutputStream();
          ((OutputStream)localObject1).write(((TBSRequest)localObject2).getEncoded("DER"));
          ((OutputStream)localObject1).close();
          localObject1 = new DERBitString(paramContentSigner.getSignature());
          paramContentSigner = paramContentSigner.getAlgorithmIdentifier();
          if ((paramArrayOfX509CertificateHolder != null) && (paramArrayOfX509CertificateHolder.length > 0))
          {
            ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
            int i = 0;
            while (i != paramArrayOfX509CertificateHolder.length)
            {
              localASN1EncodableVector.add(paramArrayOfX509CertificateHolder[i].toASN1Structure());
              i += 1;
            }
            paramContentSigner = new Signature(paramContentSigner, (DERBitString)localObject1, new DERSequence(localASN1EncodableVector));
          }
          else
          {
            paramContentSigner = new Signature(paramContentSigner, (DERBitString)localObject1);
          }
          localObject1 = paramContentSigner;
        }
        catch (Exception paramContentSigner)
        {
          paramArrayOfX509CertificateHolder = new StringBuilder();
          paramArrayOfX509CertificateHolder.append("exception processing TBSRequest: ");
          paramArrayOfX509CertificateHolder.append(paramContentSigner);
          throw new OCSPException(paramArrayOfX509CertificateHolder.toString(), paramContentSigner);
        }
      }
      throw new OCSPException("requestorName must be specified if request is signed.");
    }
    return new OCSPReq(new OCSPRequest((TBSRequest)localObject2, (Signature)localObject1));
  }
  
  public OCSPReqBuilder addRequest(CertificateID paramCertificateID)
  {
    this.list.add(new RequestObject(paramCertificateID, null));
    return this;
  }
  
  public OCSPReqBuilder addRequest(CertificateID paramCertificateID, Extensions paramExtensions)
  {
    this.list.add(new RequestObject(paramCertificateID, paramExtensions));
    return this;
  }
  
  public OCSPReq build()
    throws OCSPException
  {
    return generateRequest(null, null);
  }
  
  public OCSPReq build(ContentSigner paramContentSigner, X509CertificateHolder[] paramArrayOfX509CertificateHolder)
    throws OCSPException, IllegalArgumentException
  {
    if (paramContentSigner != null) {
      return generateRequest(paramContentSigner, paramArrayOfX509CertificateHolder);
    }
    throw new IllegalArgumentException("no signer specified");
  }
  
  public OCSPReqBuilder setRequestExtensions(Extensions paramExtensions)
  {
    this.requestExtensions = paramExtensions;
    return this;
  }
  
  public OCSPReqBuilder setRequestorName(X500Name paramX500Name)
  {
    this.requestorName = new GeneralName(4, paramX500Name);
    return this;
  }
  
  public OCSPReqBuilder setRequestorName(GeneralName paramGeneralName)
  {
    this.requestorName = paramGeneralName;
    return this;
  }
  
  private class RequestObject
  {
    CertificateID certId;
    Extensions extensions;
    
    public RequestObject(CertificateID paramCertificateID, Extensions paramExtensions)
    {
      this.certId = paramCertificateID;
      this.extensions = paramExtensions;
    }
    
    public Request toRequest()
      throws Exception
    {
      return new Request(this.certId.toASN1Primitive(), this.extensions);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\ocsp\OCSPReqBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */