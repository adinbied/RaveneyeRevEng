package org.bouncycastle.dvcs;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.SignedData;
import org.bouncycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.bouncycastle.asn1.dvcs.ServiceType;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.cms.CMSSignedData;

public class DVCSRequest
  extends DVCSMessage
{
  private org.bouncycastle.asn1.dvcs.DVCSRequest asn1;
  private DVCSRequestData data;
  private DVCSRequestInfo reqInfo;
  
  public DVCSRequest(ContentInfo paramContentInfo)
    throws DVCSConstructionException
  {
    super(paramContentInfo);
    if (DVCSObjectIdentifiers.id_ct_DVCSRequestData.equals(paramContentInfo.getContentType())) {
      try
      {
        if ((paramContentInfo.getContent().toASN1Primitive() instanceof ASN1Sequence)) {}
        for (paramContentInfo = org.bouncycastle.asn1.dvcs.DVCSRequest.getInstance(paramContentInfo.getContent());; paramContentInfo = org.bouncycastle.asn1.dvcs.DVCSRequest.getInstance(ASN1OctetString.getInstance(paramContentInfo.getContent()).getOctets()))
        {
          this.asn1 = paramContentInfo;
          break;
        }
        paramContentInfo = new DVCSRequestInfo(this.asn1.getRequestInformation());
        this.reqInfo = paramContentInfo;
        int i = paramContentInfo.getServiceType();
        if (i == ServiceType.CPD.getValue().intValue()) {
          paramContentInfo = new CPDRequestData(this.asn1.getData());
        }
        for (;;)
        {
          this.data = paramContentInfo;
          return;
          if (i == ServiceType.VSD.getValue().intValue())
          {
            paramContentInfo = new VSDRequestData(this.asn1.getData());
          }
          else if (i == ServiceType.VPKC.getValue().intValue())
          {
            paramContentInfo = new VPKCRequestData(this.asn1.getData());
          }
          else
          {
            if (i != ServiceType.CCPD.getValue().intValue()) {
              break;
            }
            paramContentInfo = new CCPDRequestData(this.asn1.getData());
          }
        }
        paramContentInfo = new StringBuilder();
        paramContentInfo.append("Unknown service type: ");
        paramContentInfo.append(i);
        throw new DVCSConstructionException(paramContentInfo.toString());
      }
      catch (Exception paramContentInfo)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unable to parse content: ");
        localStringBuilder.append(paramContentInfo.getMessage());
        throw new DVCSConstructionException(localStringBuilder.toString(), paramContentInfo);
      }
    }
    throw new DVCSConstructionException("ContentInfo not a DVCS Request");
  }
  
  public DVCSRequest(CMSSignedData paramCMSSignedData)
    throws DVCSConstructionException
  {
    this(SignedData.getInstance(paramCMSSignedData.toASN1Structure().getContent()).getEncapContentInfo());
  }
  
  public ASN1Encodable getContent()
  {
    return this.asn1;
  }
  
  public DVCSRequestData getData()
  {
    return this.data;
  }
  
  public DVCSRequestInfo getRequestInfo()
  {
    return this.reqInfo;
  }
  
  public GeneralName getTransactionIdentifier()
  {
    return this.asn1.getTransactionIdentifier();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\dvcs\DVCSRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */