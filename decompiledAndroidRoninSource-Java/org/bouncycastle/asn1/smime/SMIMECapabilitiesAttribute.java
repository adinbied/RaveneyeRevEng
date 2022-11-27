package org.bouncycastle.asn1.smime;

import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.cms.Attribute;

public class SMIMECapabilitiesAttribute
  extends Attribute
{
  public SMIMECapabilitiesAttribute(SMIMECapabilityVector paramSMIMECapabilityVector)
  {
    super(SMIMEAttributes.smimeCapabilities, new DERSet(new DERSequence(paramSMIMECapabilityVector.toASN1EncodableVector())));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\smime\SMIMECapabilitiesAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */