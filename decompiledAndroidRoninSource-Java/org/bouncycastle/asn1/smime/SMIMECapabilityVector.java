package org.bouncycastle.asn1.smime;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;

public class SMIMECapabilityVector
{
  private ASN1EncodableVector capabilities = new ASN1EncodableVector();
  
  public void addCapability(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this.capabilities.add(new DERSequence(paramASN1ObjectIdentifier));
  }
  
  public void addCapability(ASN1ObjectIdentifier paramASN1ObjectIdentifier, int paramInt)
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(paramASN1ObjectIdentifier);
    localASN1EncodableVector.add(new ASN1Integer(paramInt));
    this.capabilities.add(new DERSequence(localASN1EncodableVector));
  }
  
  public void addCapability(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(paramASN1ObjectIdentifier);
    localASN1EncodableVector.add(paramASN1Encodable);
    this.capabilities.add(new DERSequence(localASN1EncodableVector));
  }
  
  public ASN1EncodableVector toASN1EncodableVector()
  {
    return this.capabilities;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\smime\SMIMECapabilityVector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */