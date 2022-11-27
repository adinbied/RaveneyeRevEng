package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.util.Arrays;

public class SubjectKeyIdentifier
  extends ASN1Object
{
  private byte[] keyidentifier;
  
  protected SubjectKeyIdentifier(ASN1OctetString paramASN1OctetString)
  {
    this(paramASN1OctetString.getOctets());
  }
  
  public SubjectKeyIdentifier(byte[] paramArrayOfByte)
  {
    this.keyidentifier = Arrays.clone(paramArrayOfByte);
  }
  
  public static SubjectKeyIdentifier fromExtensions(Extensions paramExtensions)
  {
    return getInstance(paramExtensions.getExtensionParsedValue(Extension.subjectKeyIdentifier));
  }
  
  public static SubjectKeyIdentifier getInstance(Object paramObject)
  {
    if ((paramObject instanceof SubjectKeyIdentifier)) {
      return (SubjectKeyIdentifier)paramObject;
    }
    if (paramObject != null) {
      return new SubjectKeyIdentifier(ASN1OctetString.getInstance(paramObject));
    }
    return null;
  }
  
  public static SubjectKeyIdentifier getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1OctetString.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public byte[] getKeyIdentifier()
  {
    return Arrays.clone(this.keyidentifier);
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return new DEROctetString(getKeyIdentifier());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\SubjectKeyIdentifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */