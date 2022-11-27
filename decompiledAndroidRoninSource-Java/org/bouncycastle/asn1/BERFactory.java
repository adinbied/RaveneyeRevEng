package org.bouncycastle.asn1;

class BERFactory
{
  static final BERSequence EMPTY_SEQUENCE = new BERSequence();
  static final BERSet EMPTY_SET = new BERSet();
  
  static BERSequence createSequence(ASN1EncodableVector paramASN1EncodableVector)
  {
    if (paramASN1EncodableVector.size() < 1) {
      return EMPTY_SEQUENCE;
    }
    return new BERSequence(paramASN1EncodableVector);
  }
  
  static BERSet createSet(ASN1EncodableVector paramASN1EncodableVector)
  {
    if (paramASN1EncodableVector.size() < 1) {
      return EMPTY_SET;
    }
    return new BERSet(paramASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\BERFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */