package org.bouncycastle.cert.ocsp;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.ocsp.BasicOCSPResponse;
import org.bouncycastle.asn1.ocsp.CertStatus;
import org.bouncycastle.asn1.ocsp.ResponseData;
import org.bouncycastle.asn1.ocsp.RevokedInfo;
import org.bouncycastle.asn1.ocsp.SingleResponse;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.CRLReason;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.DigestCalculator;

public class BasicOCSPRespBuilder
{
  private List list = new ArrayList();
  private RespID responderID;
  private Extensions responseExtensions = null;
  
  public BasicOCSPRespBuilder(SubjectPublicKeyInfo paramSubjectPublicKeyInfo, DigestCalculator paramDigestCalculator)
    throws OCSPException
  {
    this.responderID = new RespID(paramSubjectPublicKeyInfo, paramDigestCalculator);
  }
  
  public BasicOCSPRespBuilder(RespID paramRespID)
  {
    this.responderID = paramRespID;
  }
  
  public BasicOCSPRespBuilder addResponse(CertificateID paramCertificateID, CertificateStatus paramCertificateStatus)
  {
    addResponse(paramCertificateID, paramCertificateStatus, new Date(), null, null);
    return this;
  }
  
  public BasicOCSPRespBuilder addResponse(CertificateID paramCertificateID, CertificateStatus paramCertificateStatus, Date paramDate1, Date paramDate2)
  {
    addResponse(paramCertificateID, paramCertificateStatus, paramDate1, paramDate2, null);
    return this;
  }
  
  public BasicOCSPRespBuilder addResponse(CertificateID paramCertificateID, CertificateStatus paramCertificateStatus, Date paramDate1, Date paramDate2, Extensions paramExtensions)
  {
    this.list.add(new ResponseObject(paramCertificateID, paramCertificateStatus, paramDate1, paramDate2, paramExtensions));
    return this;
  }
  
  public BasicOCSPRespBuilder addResponse(CertificateID paramCertificateID, CertificateStatus paramCertificateStatus, Date paramDate, Extensions paramExtensions)
  {
    addResponse(paramCertificateID, paramCertificateStatus, new Date(), paramDate, paramExtensions);
    return this;
  }
  
  public BasicOCSPRespBuilder addResponse(CertificateID paramCertificateID, CertificateStatus paramCertificateStatus, Extensions paramExtensions)
  {
    addResponse(paramCertificateID, paramCertificateStatus, new Date(), null, paramExtensions);
    return this;
  }
  
  public BasicOCSPResp build(ContentSigner paramContentSigner, X509CertificateHolder[] paramArrayOfX509CertificateHolder, Date paramDate)
    throws OCSPException
  {
    Object localObject1 = this.list.iterator();
    Object localObject2 = new ASN1EncodableVector();
    while (((Iterator)localObject1).hasNext()) {
      try
      {
        ((ASN1EncodableVector)localObject2).add(((ResponseObject)((Iterator)localObject1).next()).toResponse());
      }
      catch (Exception paramContentSigner)
      {
        throw new OCSPException("exception creating Request", paramContentSigner);
      }
    }
    localObject1 = new ResponseData(this.responderID.toASN1Primitive(), new ASN1GeneralizedTime(paramDate), new DERSequence((ASN1EncodableVector)localObject2), this.responseExtensions);
    try
    {
      paramDate = paramContentSigner.getOutputStream();
      paramDate.write(((ResponseData)localObject1).getEncoded("DER"));
      paramDate.close();
      localObject2 = new DERBitString(paramContentSigner.getSignature());
      AlgorithmIdentifier localAlgorithmIdentifier = paramContentSigner.getAlgorithmIdentifier();
      paramDate = null;
      paramContentSigner = paramDate;
      if (paramArrayOfX509CertificateHolder != null)
      {
        paramContentSigner = paramDate;
        if (paramArrayOfX509CertificateHolder.length > 0)
        {
          paramContentSigner = new ASN1EncodableVector();
          int i = 0;
          while (i != paramArrayOfX509CertificateHolder.length)
          {
            paramContentSigner.add(paramArrayOfX509CertificateHolder[i].toASN1Structure());
            i += 1;
          }
          paramContentSigner = new DERSequence(paramContentSigner);
        }
      }
      return new BasicOCSPResp(new BasicOCSPResponse((ResponseData)localObject1, localAlgorithmIdentifier, (DERBitString)localObject2, paramContentSigner));
    }
    catch (Exception paramContentSigner)
    {
      paramArrayOfX509CertificateHolder = new StringBuilder();
      paramArrayOfX509CertificateHolder.append("exception processing TBSRequest: ");
      paramArrayOfX509CertificateHolder.append(paramContentSigner.getMessage());
      throw new OCSPException(paramArrayOfX509CertificateHolder.toString(), paramContentSigner);
    }
  }
  
  public BasicOCSPRespBuilder setResponseExtensions(Extensions paramExtensions)
  {
    this.responseExtensions = paramExtensions;
    return this;
  }
  
  private class ResponseObject
  {
    CertificateID certId;
    CertStatus certStatus;
    Extensions extensions;
    ASN1GeneralizedTime nextUpdate;
    ASN1GeneralizedTime thisUpdate;
    
    public ResponseObject(CertificateID paramCertificateID, CertificateStatus paramCertificateStatus, Date paramDate1, Date paramDate2, Extensions paramExtensions)
    {
      this.certId = paramCertificateID;
      paramCertificateID = null;
      if (paramCertificateStatus == null) {
        this$1 = new CertStatus();
      }
      for (;;)
      {
        this.certStatus = BasicOCSPRespBuilder.this;
        break;
        if ((paramCertificateStatus instanceof UnknownStatus))
        {
          this$1 = new CertStatus(2, DERNull.INSTANCE);
        }
        else
        {
          this$1 = (RevokedStatus)paramCertificateStatus;
          if (BasicOCSPRespBuilder.this.hasRevocationReason()) {
            this$1 = new CertStatus(new RevokedInfo(new ASN1GeneralizedTime(BasicOCSPRespBuilder.this.getRevocationTime()), CRLReason.lookup(BasicOCSPRespBuilder.this.getRevocationReason())));
          } else {
            this$1 = new CertStatus(new RevokedInfo(new ASN1GeneralizedTime(BasicOCSPRespBuilder.this.getRevocationTime()), null));
          }
        }
      }
      this.thisUpdate = new DERGeneralizedTime(paramDate1);
      this$1 = paramCertificateID;
      if (paramDate2 != null) {
        this$1 = new DERGeneralizedTime(paramDate2);
      }
      this.nextUpdate = BasicOCSPRespBuilder.this;
      this.extensions = paramExtensions;
    }
    
    public SingleResponse toResponse()
      throws Exception
    {
      return new SingleResponse(this.certId.toASN1Primitive(), this.certStatus, this.thisUpdate, this.nextUpdate, this.extensions);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\ocsp\BasicOCSPRespBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */