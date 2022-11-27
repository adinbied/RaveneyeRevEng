package org.bouncycastle.cert.cmp;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cmp.CMPCertificate;
import org.bouncycastle.asn1.cmp.InfoTypeAndValue;
import org.bouncycastle.asn1.cmp.PKIBody;
import org.bouncycastle.asn1.cmp.PKIFreeText;
import org.bouncycastle.asn1.cmp.PKIHeader;
import org.bouncycastle.asn1.cmp.PKIHeaderBuilder;
import org.bouncycastle.asn1.cmp.PKIMessage;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.MacCalculator;

public class ProtectedPKIMessageBuilder
{
  private PKIBody body;
  private List extraCerts = new ArrayList();
  private List generalInfos = new ArrayList();
  private PKIHeaderBuilder hdrBuilder;
  
  public ProtectedPKIMessageBuilder(int paramInt, GeneralName paramGeneralName1, GeneralName paramGeneralName2)
  {
    this.hdrBuilder = new PKIHeaderBuilder(paramInt, paramGeneralName1, paramGeneralName2);
  }
  
  public ProtectedPKIMessageBuilder(GeneralName paramGeneralName1, GeneralName paramGeneralName2)
  {
    this(2, paramGeneralName1, paramGeneralName2);
  }
  
  private byte[] calculateMac(MacCalculator paramMacCalculator, PKIHeader paramPKIHeader, PKIBody paramPKIBody)
    throws IOException
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(paramPKIHeader);
    localASN1EncodableVector.add(paramPKIBody);
    paramPKIHeader = paramMacCalculator.getOutputStream();
    paramPKIHeader.write(new DERSequence(localASN1EncodableVector).getEncoded("DER"));
    paramPKIHeader.close();
    return paramMacCalculator.getMac();
  }
  
  private byte[] calculateSignature(ContentSigner paramContentSigner, PKIHeader paramPKIHeader, PKIBody paramPKIBody)
    throws IOException
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(paramPKIHeader);
    localASN1EncodableVector.add(paramPKIBody);
    paramPKIHeader = paramContentSigner.getOutputStream();
    paramPKIHeader.write(new DERSequence(localASN1EncodableVector).getEncoded("DER"));
    paramPKIHeader.close();
    return paramContentSigner.getSignature();
  }
  
  private void finaliseHeader(AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    this.hdrBuilder.setProtectionAlg(paramAlgorithmIdentifier);
    if (!this.generalInfos.isEmpty())
    {
      paramAlgorithmIdentifier = new InfoTypeAndValue[this.generalInfos.size()];
      this.hdrBuilder.setGeneralInfo((InfoTypeAndValue[])this.generalInfos.toArray(paramAlgorithmIdentifier));
    }
  }
  
  private ProtectedPKIMessage finaliseMessage(PKIHeader paramPKIHeader, DERBitString paramDERBitString)
  {
    if (!this.extraCerts.isEmpty())
    {
      int j = this.extraCerts.size();
      CMPCertificate[] arrayOfCMPCertificate = new CMPCertificate[j];
      int i = 0;
      while (i != j)
      {
        arrayOfCMPCertificate[i] = new CMPCertificate(((X509CertificateHolder)this.extraCerts.get(i)).toASN1Structure());
        i += 1;
      }
      return new ProtectedPKIMessage(new PKIMessage(paramPKIHeader, this.body, paramDERBitString, arrayOfCMPCertificate));
    }
    return new ProtectedPKIMessage(new PKIMessage(paramPKIHeader, this.body, paramDERBitString));
  }
  
  public ProtectedPKIMessageBuilder addCMPCertificate(X509CertificateHolder paramX509CertificateHolder)
  {
    this.extraCerts.add(paramX509CertificateHolder);
    return this;
  }
  
  public ProtectedPKIMessageBuilder addGeneralInfo(InfoTypeAndValue paramInfoTypeAndValue)
  {
    this.generalInfos.add(paramInfoTypeAndValue);
    return this;
  }
  
  public ProtectedPKIMessage build(ContentSigner paramContentSigner)
    throws CMPException
  {
    finaliseHeader(paramContentSigner.getAlgorithmIdentifier());
    Object localObject = this.hdrBuilder.build();
    try
    {
      paramContentSigner = finaliseMessage((PKIHeader)localObject, new DERBitString(calculateSignature(paramContentSigner, (PKIHeader)localObject, this.body)));
      return paramContentSigner;
    }
    catch (IOException paramContentSigner)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unable to encode signature input: ");
      ((StringBuilder)localObject).append(paramContentSigner.getMessage());
      throw new CMPException(((StringBuilder)localObject).toString(), paramContentSigner);
    }
  }
  
  public ProtectedPKIMessage build(MacCalculator paramMacCalculator)
    throws CMPException
  {
    finaliseHeader(paramMacCalculator.getAlgorithmIdentifier());
    Object localObject = this.hdrBuilder.build();
    try
    {
      paramMacCalculator = finaliseMessage((PKIHeader)localObject, new DERBitString(calculateMac(paramMacCalculator, (PKIHeader)localObject, this.body)));
      return paramMacCalculator;
    }
    catch (IOException paramMacCalculator)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unable to encode MAC input: ");
      ((StringBuilder)localObject).append(paramMacCalculator.getMessage());
      throw new CMPException(((StringBuilder)localObject).toString(), paramMacCalculator);
    }
  }
  
  public ProtectedPKIMessageBuilder setBody(PKIBody paramPKIBody)
  {
    this.body = paramPKIBody;
    return this;
  }
  
  public ProtectedPKIMessageBuilder setFreeText(PKIFreeText paramPKIFreeText)
  {
    this.hdrBuilder.setFreeText(paramPKIFreeText);
    return this;
  }
  
  public ProtectedPKIMessageBuilder setMessageTime(Date paramDate)
  {
    this.hdrBuilder.setMessageTime(new ASN1GeneralizedTime(paramDate));
    return this;
  }
  
  public ProtectedPKIMessageBuilder setRecipKID(byte[] paramArrayOfByte)
  {
    this.hdrBuilder.setRecipKID(paramArrayOfByte);
    return this;
  }
  
  public ProtectedPKIMessageBuilder setRecipNonce(byte[] paramArrayOfByte)
  {
    this.hdrBuilder.setRecipNonce(paramArrayOfByte);
    return this;
  }
  
  public ProtectedPKIMessageBuilder setSenderKID(byte[] paramArrayOfByte)
  {
    this.hdrBuilder.setSenderKID(paramArrayOfByte);
    return this;
  }
  
  public ProtectedPKIMessageBuilder setSenderNonce(byte[] paramArrayOfByte)
  {
    this.hdrBuilder.setSenderNonce(paramArrayOfByte);
    return this;
  }
  
  public ProtectedPKIMessageBuilder setTransactionID(byte[] paramArrayOfByte)
  {
    this.hdrBuilder.setTransactionID(paramArrayOfByte);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\cmp\ProtectedPKIMessageBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */