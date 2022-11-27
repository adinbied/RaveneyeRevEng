package org.bouncycastle.asn1;

class DERFactory
{
  static final ASN1Sequence EMPTY_SEQUENCE = new DERSequence();
  static final ASN1Set EMPTY_SET = new DERSet();
  
  static ASN1Sequence createSequence(ASN1EncodableVector paramASN1EncodableVector)
  {
    if (paramASN1EncodableVector.size() < 1) {
      return EMPTY_SEQUENCE;
    }
    return new DLSequence(paramASN1EncodableVector);
  }
  
  static ASN1Set createSet(ASN1EncodableVector paramASN1EncodableVector)
  {
    if (paramASN1EncodableVector.size() < 1) {
      return EMPTY_SET;
    }
    return new DLSet(paramASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\DERFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */