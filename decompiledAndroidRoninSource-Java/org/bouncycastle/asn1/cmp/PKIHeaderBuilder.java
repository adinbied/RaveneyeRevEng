package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.GeneralName;

public class PKIHeaderBuilder
{
  private PKIFreeText freeText;
  private ASN1Sequence generalInfo;
  private ASN1GeneralizedTime messageTime;
  private AlgorithmIdentifier protectionAlg;
  private ASN1Integer pvno;
  private ASN1OctetString recipKID;
  private ASN1OctetString recipNonce;
  private GeneralName recipient;
  private GeneralName sender;
  private ASN1OctetString senderKID;
  private ASN1OctetString senderNonce;
  private ASN1OctetString transactionID;
  
  public PKIHeaderBuilder(int paramInt, GeneralName paramGeneralName1, GeneralName paramGeneralName2)
  {
    this(new ASN1Integer(paramInt), paramGeneralName1, paramGeneralName2);
  }
  
  private PKIHeaderBuilder(ASN1Integer paramASN1Integer, GeneralName paramGeneralName1, GeneralName paramGeneralName2)
  {
    this.pvno = paramASN1Integer;
    this.sender = paramGeneralName1;
    this.recipient = paramGeneralName2;
  }
  
  private void addOptional(ASN1EncodableVector paramASN1EncodableVector, int paramInt, ASN1Encodable paramASN1Encodable)
  {
    if (paramASN1Encodable != null) {
      paramASN1EncodableVector.add(new DERTaggedObject(true, paramInt, paramASN1Encodable));
    }
  }
  
  private static ASN1Sequence makeGeneralInfoSeq(InfoTypeAndValue paramInfoTypeAndValue)
  {
    return new DERSequence(paramInfoTypeAndValue);
  }
  
  private static ASN1Sequence makeGeneralInfoSeq(InfoTypeAndValue[] paramArrayOfInfoTypeAndValue)
  {
    if (paramArrayOfInfoTypeAndValue != null)
    {
      ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
      int i = 0;
      while (i < paramArrayOfInfoTypeAndValue.length)
      {
        localASN1EncodableVector.add(paramArrayOfInfoTypeAndValue[i]);
        i += 1;
      }
      return new DERSequence(localASN1EncodableVector);
    }
    return null;
  }
  
  public PKIHeader build()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.pvno);
    localASN1EncodableVector.add(this.sender);
    localASN1EncodableVector.add(this.recipient);
    addOptional(localASN1EncodableVector, 0, this.messageTime);
    addOptional(localASN1EncodableVector, 1, this.protectionAlg);
    addOptional(localASN1EncodableVector, 2, this.senderKID);
    addOptional(localASN1EncodableVector, 3, this.recipKID);
    addOptional(localASN1EncodableVector, 4, this.transactionID);
    addOptional(localASN1EncodableVector, 5, this.senderNonce);
    addOptional(localASN1EncodableVector, 6, this.recipNonce);
    addOptional(localASN1EncodableVector, 7, this.freeText);
    addOptional(localASN1EncodableVector, 8, this.generalInfo);
    this.messageTime = null;
    this.protectionAlg = null;
    this.senderKID = null;
    this.recipKID = null;
    this.transactionID = null;
    this.senderNonce = null;
    this.recipNonce = null;
    this.freeText = null;
    this.generalInfo = null;
    return PKIHeader.getInstance(new DERSequence(localASN1EncodableVector));
  }
  
  public PKIHeaderBuilder setFreeText(PKIFreeText paramPKIFreeText)
  {
    this.freeText = paramPKIFreeText;
    return this;
  }
  
  public PKIHeaderBuilder setGeneralInfo(ASN1Sequence paramASN1Sequence)
  {
    this.generalInfo = paramASN1Sequence;
    return this;
  }
  
  public PKIHeaderBuilder setGeneralInfo(InfoTypeAndValue paramInfoTypeAndValue)
  {
    return setGeneralInfo(makeGeneralInfoSeq(paramInfoTypeAndValue));
  }
  
  public PKIHeaderBuilder setGeneralInfo(InfoTypeAndValue[] paramArrayOfInfoTypeAndValue)
  {
    return setGeneralInfo(makeGeneralInfoSeq(paramArrayOfInfoTypeAndValue));
  }
  
  public PKIHeaderBuilder setMessageTime(ASN1GeneralizedTime paramASN1GeneralizedTime)
  {
    this.messageTime = paramASN1GeneralizedTime;
    return this;
  }
  
  public PKIHeaderBuilder setProtectionAlg(AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    this.protectionAlg = paramAlgorithmIdentifier;
    return this;
  }
  
  public PKIHeaderBuilder setRecipKID(DEROctetString paramDEROctetString)
  {
    this.recipKID = paramDEROctetString;
    return this;
  }
  
  public PKIHeaderBuilder setRecipKID(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    } else {
      paramArrayOfByte = new DEROctetString(paramArrayOfByte);
    }
    return setRecipKID(paramArrayOfByte);
  }
  
  public PKIHeaderBuilder setRecipNonce(ASN1OctetString paramASN1OctetString)
  {
    this.recipNonce = paramASN1OctetString;
    return this;
  }
  
  public PKIHeaderBuilder setRecipNonce(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    } else {
      paramArrayOfByte = new DEROctetString(paramArrayOfByte);
    }
    return setRecipNonce(paramArrayOfByte);
  }
  
  public PKIHeaderBuilder setSenderKID(ASN1OctetString paramASN1OctetString)
  {
    this.senderKID = paramASN1OctetString;
    return this;
  }
  
  public PKIHeaderBuilder setSenderKID(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    } else {
      paramArrayOfByte = new DEROctetString(paramArrayOfByte);
    }
    return setSenderKID(paramArrayOfByte);
  }
  
  public PKIHeaderBuilder setSenderNonce(ASN1OctetString paramASN1OctetString)
  {
    this.senderNonce = paramASN1OctetString;
    return this;
  }
  
  public PKIHeaderBuilder setSenderNonce(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    } else {
      paramArrayOfByte = new DEROctetString(paramArrayOfByte);
    }
    return setSenderNonce(paramArrayOfByte);
  }
  
  public PKIHeaderBuilder setTransactionID(ASN1OctetString paramASN1OctetString)
  {
    this.transactionID = paramASN1OctetString;
    return this;
  }
  
  public PKIHeaderBuilder setTransactionID(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    } else {
      paramArrayOfByte = new DEROctetString(paramArrayOfByte);
    }
    return setTransactionID(paramArrayOfByte);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\PKIHeaderBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */