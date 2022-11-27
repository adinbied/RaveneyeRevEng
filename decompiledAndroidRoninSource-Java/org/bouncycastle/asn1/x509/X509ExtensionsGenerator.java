package org.bouncycastle.asn1.x509;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;

public class X509ExtensionsGenerator
{
  private Vector extOrdering = new Vector();
  private Hashtable extensions = new Hashtable();
  
  public void addExtension(ASN1ObjectIdentifier paramASN1ObjectIdentifier, boolean paramBoolean, ASN1Encodable paramASN1Encodable)
  {
    try
    {
      addExtension(paramASN1ObjectIdentifier, paramBoolean, paramASN1Encodable.toASN1Primitive().getEncoded("DER"));
      return;
    }
    catch (IOException paramASN1ObjectIdentifier)
    {
      paramASN1Encodable = new StringBuilder();
      paramASN1Encodable.append("error encoding value: ");
      paramASN1Encodable.append(paramASN1ObjectIdentifier);
      throw new IllegalArgumentException(paramASN1Encodable.toString());
    }
  }
  
  public void addExtension(ASN1ObjectIdentifier paramASN1ObjectIdentifier, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (!this.extensions.containsKey(paramASN1ObjectIdentifier))
    {
      this.extOrdering.addElement(paramASN1ObjectIdentifier);
      this.extensions.put(paramASN1ObjectIdentifier, new X509Extension(paramBoolean, new DEROctetString(paramArrayOfByte)));
      return;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("extension ");
    paramArrayOfByte.append(paramASN1ObjectIdentifier);
    paramArrayOfByte.append(" already added");
    throw new IllegalArgumentException(paramArrayOfByte.toString());
  }
  
  public X509Extensions generate()
  {
    return new X509Extensions(this.extOrdering, this.extensions);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\X509ExtensionsGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */