package org.bouncycastle.asn1.tsp;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.GeneralName;

public class TSTInfo
  extends ASN1Object
{
  private Accuracy accuracy;
  private Extensions extensions;
  private ASN1GeneralizedTime genTime;
  private MessageImprint messageImprint;
  private ASN1Integer nonce;
  private ASN1Boolean ordering;
  private ASN1Integer serialNumber;
  private GeneralName tsa;
  private ASN1ObjectIdentifier tsaPolicyId;
  private ASN1Integer version;
  
  public TSTInfo(ASN1ObjectIdentifier paramASN1ObjectIdentifier, MessageImprint paramMessageImprint, ASN1Integer paramASN1Integer1, ASN1GeneralizedTime paramASN1GeneralizedTime, Accuracy paramAccuracy, ASN1Boolean paramASN1Boolean, ASN1Integer paramASN1Integer2, GeneralName paramGeneralName, Extensions paramExtensions)
  {
    this.version = new ASN1Integer(1L);
    this.tsaPolicyId = paramASN1ObjectIdentifier;
    this.messageImprint = paramMessageImprint;
    this.serialNumber = paramASN1Integer1;
    this.genTime = paramASN1GeneralizedTime;
    this.accuracy = paramAccuracy;
    this.ordering = paramASN1Boolean;
    this.nonce = paramASN1Integer2;
    this.tsa = paramGeneralName;
    this.extensions = paramExtensions;
  }
  
  private TSTInfo(ASN1Sequence paramASN1Sequence)
  {
    Object localObject = paramASN1Sequence.getObjects();
    this.version = ASN1Integer.getInstance(((Enumeration)localObject).nextElement());
    this.tsaPolicyId = ASN1ObjectIdentifier.getInstance(((Enumeration)localObject).nextElement());
    this.messageImprint = MessageImprint.getInstance(((Enumeration)localObject).nextElement());
    this.serialNumber = ASN1Integer.getInstance(((Enumeration)localObject).nextElement());
    this.genTime = ASN1GeneralizedTime.getInstance(((Enumeration)localObject).nextElement());
    paramASN1Sequence = ASN1Boolean.getInstance(false);
    this.ordering = paramASN1Sequence;
    for (;;)
    {
      if (!((Enumeration)localObject).hasMoreElements()) {
        return;
      }
      paramASN1Sequence = (ASN1Object)((Enumeration)localObject).nextElement();
      if ((paramASN1Sequence instanceof ASN1TaggedObject))
      {
        paramASN1Sequence = (ASN1TaggedObject)paramASN1Sequence;
        int i = paramASN1Sequence.getTagNo();
        if (i != 0)
        {
          if (i == 1)
          {
            this.extensions = Extensions.getInstance(paramASN1Sequence, false);
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Unknown tag value ");
            ((StringBuilder)localObject).append(paramASN1Sequence.getTagNo());
            throw new IllegalArgumentException(((StringBuilder)localObject).toString());
          }
        }
        else {
          this.tsa = GeneralName.getInstance(paramASN1Sequence, true);
        }
      }
      else
      {
        if ((!(paramASN1Sequence instanceof ASN1Sequence)) && (!(paramASN1Sequence instanceof Accuracy)))
        {
          if ((paramASN1Sequence instanceof ASN1Boolean))
          {
            paramASN1Sequence = ASN1Boolean.getInstance(paramASN1Sequence);
            break;
          }
          if (!(paramASN1Sequence instanceof ASN1Integer)) {
            continue;
          }
          this.nonce = ASN1Integer.getInstance(paramASN1Sequence);
          continue;
        }
        this.accuracy = Accuracy.getInstance(paramASN1Sequence);
      }
    }
  }
  
  public static TSTInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof TSTInfo)) {
      return (TSTInfo)paramObject;
    }
    if (paramObject != null) {
      return new TSTInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public Accuracy getAccuracy()
  {
    return this.accuracy;
  }
  
  public Extensions getExtensions()
  {
    return this.extensions;
  }
  
  public ASN1GeneralizedTime getGenTime()
  {
    return this.genTime;
  }
  
  public MessageImprint getMessageImprint()
  {
    return this.messageImprint;
  }
  
  public ASN1Integer getNonce()
  {
    return this.nonce;
  }
  
  public ASN1Boolean getOrdering()
  {
    return this.ordering;
  }
  
  public ASN1ObjectIdentifier getPolicy()
  {
    return this.tsaPolicyId;
  }
  
  public ASN1Integer getSerialNumber()
  {
    return this.serialNumber;
  }
  
  public GeneralName getTsa()
  {
    return this.tsa;
  }
  
  public ASN1Integer getVersion()
  {
    return this.version;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.version);
    localASN1EncodableVector.add(this.tsaPolicyId);
    localASN1EncodableVector.add(this.messageImprint);
    localASN1EncodableVector.add(this.serialNumber);
    localASN1EncodableVector.add(this.genTime);
    Object localObject = this.accuracy;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.ordering;
    if ((localObject != null) && (((ASN1Boolean)localObject).isTrue())) {
      localASN1EncodableVector.add(this.ordering);
    }
    localObject = this.nonce;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.tsa;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 0, (ASN1Encodable)localObject));
    }
    localObject = this.extensions;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 1, (ASN1Encodable)localObject));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\tsp\TSTInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */