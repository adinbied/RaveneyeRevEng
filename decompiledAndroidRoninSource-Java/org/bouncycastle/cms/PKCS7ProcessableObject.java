package org.bouncycastle.cms;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;

public class PKCS7ProcessableObject
  implements CMSTypedData
{
  private final ASN1Encodable structure;
  private final ASN1ObjectIdentifier type;
  
  public PKCS7ProcessableObject(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.type = paramASN1ObjectIdentifier;
    this.structure = paramASN1Encodable;
  }
  
  public Object getContent()
  {
    return this.structure;
  }
  
  public ASN1ObjectIdentifier getContentType()
  {
    return this.type;
  }
  
  public void write(OutputStream paramOutputStream)
    throws IOException, CMSException
  {
    Object localObject = this.structure;
    if ((localObject instanceof ASN1Sequence))
    {
      localObject = ASN1Sequence.getInstance(localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramOutputStream.write(((ASN1Encodable)((Iterator)localObject).next()).toASN1Primitive().getEncoded("DER"));
      }
    }
    localObject = ((ASN1Encodable)localObject).toASN1Primitive().getEncoded("DER");
    int i = 1;
    while ((localObject[i] & 0xFF) > Byte.MAX_VALUE) {
      i += 1;
    }
    i += 1;
    paramOutputStream.write((byte[])localObject, i, localObject.length - i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\PKCS7ProcessableObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */