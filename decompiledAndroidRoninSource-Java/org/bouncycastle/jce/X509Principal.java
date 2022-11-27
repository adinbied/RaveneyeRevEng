package org.bouncycastle.jce;

import java.io.IOException;
import java.security.Principal;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.X509Name;

public class X509Principal
  extends X509Name
  implements Principal
{
  public X509Principal(String paramString)
  {
    super(paramString);
  }
  
  public X509Principal(Hashtable paramHashtable)
  {
    super(paramHashtable);
  }
  
  public X509Principal(Vector paramVector, Hashtable paramHashtable)
  {
    super(paramVector, paramHashtable);
  }
  
  public X509Principal(Vector paramVector1, Vector paramVector2)
  {
    super(paramVector1, paramVector2);
  }
  
  public X509Principal(X500Name paramX500Name)
  {
    super((ASN1Sequence)paramX500Name.toASN1Primitive());
  }
  
  public X509Principal(X509Name paramX509Name)
  {
    super((ASN1Sequence)paramX509Name.toASN1Primitive());
  }
  
  public X509Principal(boolean paramBoolean, String paramString)
  {
    super(paramBoolean, paramString);
  }
  
  public X509Principal(boolean paramBoolean, Hashtable paramHashtable, String paramString)
  {
    super(paramBoolean, paramHashtable, paramString);
  }
  
  public X509Principal(byte[] paramArrayOfByte)
    throws IOException
  {
    super(readSequence(new ASN1InputStream(paramArrayOfByte)));
  }
  
  private static ASN1Sequence readSequence(ASN1InputStream paramASN1InputStream)
    throws IOException
  {
    try
    {
      paramASN1InputStream = ASN1Sequence.getInstance(paramASN1InputStream.readObject());
      return paramASN1InputStream;
    }
    catch (IllegalArgumentException paramASN1InputStream)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("not an ASN.1 Sequence: ");
      localStringBuilder.append(paramASN1InputStream);
      throw new IOException(localStringBuilder.toString());
    }
  }
  
  public byte[] getEncoded()
  {
    try
    {
      byte[] arrayOfByte = getEncoded("DER");
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException.toString());
    }
  }
  
  public String getName()
  {
    return toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\X509Principal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */