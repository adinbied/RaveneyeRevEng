package org.bouncycastle.asn1.x509;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;

public class ExtensionsGenerator
{
  private Vector extOrdering = new Vector();
  private Hashtable extensions = new Hashtable();
  
  public void addExtension(ASN1ObjectIdentifier paramASN1ObjectIdentifier, boolean paramBoolean, ASN1Encodable paramASN1Encodable)
    throws IOException
  {
    addExtension(paramASN1ObjectIdentifier, paramBoolean, paramASN1Encodable.toASN1Primitive().getEncoded("DER"));
  }
  
  public void addExtension(ASN1ObjectIdentifier paramASN1ObjectIdentifier, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (!this.extensions.containsKey(paramASN1ObjectIdentifier))
    {
      this.extOrdering.addElement(paramASN1ObjectIdentifier);
      this.extensions.put(paramASN1ObjectIdentifier, new Extension(paramASN1ObjectIdentifier, paramBoolean, new DEROctetString(paramArrayOfByte)));
      return;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("extension ");
    paramArrayOfByte.append(paramASN1ObjectIdentifier);
    paramArrayOfByte.append(" already added");
    throw new IllegalArgumentException(paramArrayOfByte.toString());
  }
  
  public void addExtension(Extension paramExtension)
  {
    if (!this.extensions.containsKey(paramExtension.getExtnId()))
    {
      this.extOrdering.addElement(paramExtension.getExtnId());
      this.extensions.put(paramExtension.getExtnId(), paramExtension);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("extension ");
    localStringBuilder.append(paramExtension.getExtnId());
    localStringBuilder.append(" already added");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public Extensions generate()
  {
    Extension[] arrayOfExtension = new Extension[this.extOrdering.size()];
    int i = 0;
    while (i != this.extOrdering.size())
    {
      arrayOfExtension[i] = ((Extension)this.extensions.get(this.extOrdering.elementAt(i)));
      i += 1;
    }
    return new Extensions(arrayOfExtension);
  }
  
  public boolean isEmpty()
  {
    return this.extOrdering.isEmpty();
  }
  
  public void reset()
  {
    this.extensions = new Hashtable();
    this.extOrdering = new Vector();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\ExtensionsGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */