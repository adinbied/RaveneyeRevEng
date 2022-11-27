package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class OtherHash
  extends ASN1Object
  implements ASN1Choice
{
  private OtherHashAlgAndValue otherHash;
  private ASN1OctetString sha1Hash;
  
  private OtherHash(ASN1OctetString paramASN1OctetString)
  {
    this.sha1Hash = paramASN1OctetString;
  }
  
  public OtherHash(OtherHashAlgAndValue paramOtherHashAlgAndValue)
  {
    this.otherHash = paramOtherHashAlgAndValue;
  }
  
  public OtherHash(byte[] paramArrayOfByte)
  {
    this.sha1Hash = new DEROctetString(paramArrayOfByte);
  }
  
  public static OtherHash getInstance(Object paramObject)
  {
    if ((paramObject instanceof OtherHash)) {
      return (OtherHash)paramObject;
    }
    if ((paramObject instanceof ASN1OctetString)) {
      return new OtherHash((ASN1OctetString)paramObject);
    }
    return new OtherHash(OtherHashAlgAndValue.getInstance(paramObject));
  }
  
  public AlgorithmIdentifier getHashAlgorithm()
  {
    OtherHashAlgAndValue localOtherHashAlgAndValue = this.otherHash;
    if (localOtherHashAlgAndValue == null) {
      return new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1);
    }
    return localOtherHashAlgAndValue.getHashAlgorithm();
  }
  
  public byte[] getHashValue()
  {
    Object localObject = this.otherHash;
    if (localObject == null) {}
    for (localObject = this.sha1Hash;; localObject = ((OtherHashAlgAndValue)localObject).getHashValue()) {
      return ((ASN1OctetString)localObject).getOctets();
    }
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    OtherHashAlgAndValue localOtherHashAlgAndValue = this.otherHash;
    if (localOtherHashAlgAndValue == null) {
      return this.sha1Hash;
    }
    return localOtherHashAlgAndValue.toASN1Primitive();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\esf\OtherHash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */