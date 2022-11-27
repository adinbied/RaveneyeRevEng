package org.bouncycastle.dvcs;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.SignedData;
import org.bouncycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.bouncycastle.cms.CMSSignedData;

public class DVCSResponse
  extends DVCSMessage
{
  private org.bouncycastle.asn1.dvcs.DVCSResponse asn1;
  
  public DVCSResponse(ContentInfo paramContentInfo)
    throws DVCSConstructionException
  {
    super(paramContentInfo);
    if (DVCSObjectIdentifiers.id_ct_DVCSResponseData.equals(paramContentInfo.getContentType())) {
      try
      {
        if ((paramContentInfo.getContent().toASN1Primitive() instanceof ASN1Sequence)) {}
        for (paramContentInfo = org.bouncycastle.asn1.dvcs.DVCSResponse.getInstance(paramContentInfo.getContent());; paramContentInfo = org.bouncycastle.asn1.dvcs.DVCSResponse.getInstance(ASN1OctetString.getInstance(paramContentInfo.getContent()).getOctets()))
        {
          this.asn1 = paramContentInfo;
          return;
        }
        StringBuilder localStringBuilder;
        throw new DVCSConstructionException("ContentInfo not a DVCS Response");
      }
      catch (Exception paramContentInfo)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unable to parse content: ");
        localStringBuilder.append(paramContentInfo.getMessage());
        throw new DVCSConstructionException(localStringBuilder.toString(), paramContentInfo);
      }
    }
  }
  
  public DVCSResponse(CMSSignedData paramCMSSignedData)
    throws DVCSConstructionException
  {
    this(SignedData.getInstance(paramCMSSignedData.toASN1Structure().getContent()).getEncapContentInfo());
  }
  
  public ASN1Encodable getContent()
  {
    return this.asn1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\dvcs\DVCSResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */