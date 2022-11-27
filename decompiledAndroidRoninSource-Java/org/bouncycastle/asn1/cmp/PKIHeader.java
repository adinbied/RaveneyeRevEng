package org.bouncycastle.asn1.cmp;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.GeneralName;

public class PKIHeader
  extends ASN1Object
{
  public static final int CMP_1999 = 1;
  public static final int CMP_2000 = 2;
  public static final GeneralName NULL_NAME = new GeneralName(X500Name.getInstance(new DERSequence()));
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
  
  public PKIHeader(int paramInt, GeneralName paramGeneralName1, GeneralName paramGeneralName2)
  {
    this(new ASN1Integer(paramInt), paramGeneralName1, paramGeneralName2);
  }
  
  private PKIHeader(ASN1Integer paramASN1Integer, GeneralName paramGeneralName1, GeneralName paramGeneralName2)
  {
    this.pvno = paramASN1Integer;
    this.sender = paramGeneralName1;
    this.recipient = paramGeneralName2;
  }
  
  private PKIHeader(ASN1Sequence paramASN1Sequence)
  {
    Object localObject = paramASN1Sequence.getObjects();
    this.pvno = ASN1Integer.getInstance(((Enumeration)localObject).nextElement());
    this.sender = GeneralName.getInstance(((Enumeration)localObject).nextElement());
    this.recipient = GeneralName.getInstance(((Enumeration)localObject).nextElement());
    while (((Enumeration)localObject).hasMoreElements())
    {
      paramASN1Sequence = (ASN1TaggedObject)((Enumeration)localObject).nextElement();
      switch (paramASN1Sequence.getTagNo())
      {
      default: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("unknown tag number: ");
        ((StringBuilder)localObject).append(paramASN1Sequence.getTagNo());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      case 8: 
        this.generalInfo = ASN1Sequence.getInstance(paramASN1Sequence, true);
        break;
      case 7: 
        this.freeText = PKIFreeText.getInstance(paramASN1Sequence, true);
        break;
      case 6: 
        this.recipNonce = ASN1OctetString.getInstance(paramASN1Sequence, true);
        break;
      case 5: 
        this.senderNonce = ASN1OctetString.getInstance(paramASN1Sequence, true);
        break;
      case 4: 
        this.transactionID = ASN1OctetString.getInstance(paramASN1Sequence, true);
        break;
      case 3: 
        this.recipKID = ASN1OctetString.getInstance(paramASN1Sequence, true);
        break;
      case 2: 
        this.senderKID = ASN1OctetString.getInstance(paramASN1Sequence, true);
        break;
      case 1: 
        this.protectionAlg = AlgorithmIdentifier.getInstance(paramASN1Sequence, true);
        break;
      case 0: 
        this.messageTime = ASN1GeneralizedTime.getInstance(paramASN1Sequence, true);
      }
    }
  }
  
  private void addOptional(ASN1EncodableVector paramASN1EncodableVector, int paramInt, ASN1Encodable paramASN1Encodable)
  {
    if (paramASN1Encodable != null) {
      paramASN1EncodableVector.add(new DERTaggedObject(true, paramInt, paramASN1Encodable));
    }
  }
  
  public static PKIHeader getInstance(Object paramObject)
  {
    if ((paramObject instanceof PKIHeader)) {
      return (PKIHeader)paramObject;
    }
    if (paramObject != null) {
      return new PKIHeader(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public PKIFreeText getFreeText()
  {
    return this.freeText;
  }
  
  public InfoTypeAndValue[] getGeneralInfo()
  {
    Object localObject = this.generalInfo;
    if (localObject == null) {
      return null;
    }
    int j = ((ASN1Sequence)localObject).size();
    localObject = new InfoTypeAndValue[j];
    int i = 0;
    while (i < j)
    {
      localObject[i] = InfoTypeAndValue.getInstance(this.generalInfo.getObjectAt(i));
      i += 1;
    }
    return (InfoTypeAndValue[])localObject;
  }
  
  public ASN1GeneralizedTime getMessageTime()
  {
    return this.messageTime;
  }
  
  public AlgorithmIdentifier getProtectionAlg()
  {
    return this.protectionAlg;
  }
  
  public ASN1Integer getPvno()
  {
    return this.pvno;
  }
  
  public ASN1OctetString getRecipKID()
  {
    return this.recipKID;
  }
  
  public ASN1OctetString getRecipNonce()
  {
    return this.recipNonce;
  }
  
  public GeneralName getRecipient()
  {
    return this.recipient;
  }
  
  public GeneralName getSender()
  {
    return this.sender;
  }
  
  public ASN1OctetString getSenderKID()
  {
    return this.senderKID;
  }
  
  public ASN1OctetString getSenderNonce()
  {
    return this.senderNonce;
  }
  
  public ASN1OctetString getTransactionID()
  {
    return this.transactionID;
  }
  
  public ASN1Primitive toASN1Primitive()
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
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\PKIHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */