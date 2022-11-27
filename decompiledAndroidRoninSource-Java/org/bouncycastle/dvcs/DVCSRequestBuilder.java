package org.bouncycastle.dvcs;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.bouncycastle.asn1.dvcs.DVCSRequestInformationBuilder;
import org.bouncycastle.asn1.dvcs.Data;
import org.bouncycastle.asn1.x509.ExtensionsGenerator;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.cms.CMSSignedDataGenerator;

public abstract class DVCSRequestBuilder
{
  private final ExtensionsGenerator extGenerator = new ExtensionsGenerator();
  protected final DVCSRequestInformationBuilder requestInformationBuilder;
  private final CMSSignedDataGenerator signedDataGen = new CMSSignedDataGenerator();
  
  protected DVCSRequestBuilder(DVCSRequestInformationBuilder paramDVCSRequestInformationBuilder)
  {
    this.requestInformationBuilder = paramDVCSRequestInformationBuilder;
  }
  
  public void addExtension(ASN1ObjectIdentifier paramASN1ObjectIdentifier, boolean paramBoolean, ASN1Encodable paramASN1Encodable)
    throws DVCSException
  {
    try
    {
      this.extGenerator.addExtension(paramASN1ObjectIdentifier, paramBoolean, paramASN1Encodable);
      return;
    }
    catch (IOException paramASN1ObjectIdentifier)
    {
      paramASN1Encodable = new StringBuilder();
      paramASN1Encodable.append("cannot encode extension: ");
      paramASN1Encodable.append(paramASN1ObjectIdentifier.getMessage());
      throw new DVCSException(paramASN1Encodable.toString(), paramASN1ObjectIdentifier);
    }
  }
  
  protected DVCSRequest createDVCRequest(Data paramData)
    throws DVCSException
  {
    if (!this.extGenerator.isEmpty()) {
      this.requestInformationBuilder.setExtensions(this.extGenerator.generate());
    }
    paramData = new org.bouncycastle.asn1.dvcs.DVCSRequest(this.requestInformationBuilder.build(), paramData);
    return new DVCSRequest(new ContentInfo(DVCSObjectIdentifiers.id_ct_DVCSRequestData, paramData));
  }
  
  public void setDVCS(GeneralName paramGeneralName)
  {
    this.requestInformationBuilder.setDVCS(paramGeneralName);
  }
  
  public void setDVCS(GeneralNames paramGeneralNames)
  {
    this.requestInformationBuilder.setDVCS(paramGeneralNames);
  }
  
  public void setDataLocations(GeneralName paramGeneralName)
  {
    this.requestInformationBuilder.setDataLocations(paramGeneralName);
  }
  
  public void setDataLocations(GeneralNames paramGeneralNames)
  {
    this.requestInformationBuilder.setDataLocations(paramGeneralNames);
  }
  
  public void setNonce(BigInteger paramBigInteger)
  {
    this.requestInformationBuilder.setNonce(paramBigInteger);
  }
  
  public void setRequester(GeneralName paramGeneralName)
  {
    this.requestInformationBuilder.setRequester(paramGeneralName);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\dvcs\DVCSRequestBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */