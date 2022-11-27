package org.bouncycastle.cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;

public class PKCS7TypedStream
  extends CMSTypedStream
{
  private final ASN1Encodable content;
  
  public PKCS7TypedStream(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
    throws IOException
  {
    super(paramASN1ObjectIdentifier);
    this.content = paramASN1Encodable;
  }
  
  private InputStream getContentStream(ASN1Encodable paramASN1Encodable)
    throws IOException
  {
    paramASN1Encodable = paramASN1Encodable.toASN1Primitive().getEncoded("DER");
    int i = 1;
    while ((paramASN1Encodable[i] & 0xFF) > Byte.MAX_VALUE) {
      i += 1;
    }
    i += 1;
    return new ByteArrayInputStream(paramASN1Encodable, i, paramASN1Encodable.length - i);
  }
  
  public void drain()
    throws IOException
  {
    getContentStream(this.content);
  }
  
  public ASN1Encodable getContent()
  {
    return this.content;
  }
  
  public InputStream getContentStream()
  {
    try
    {
      InputStream localInputStream = getContentStream(this.content);
      return localInputStream;
    }
    catch (IOException localIOException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unable to convert content to stream: ");
      localStringBuilder.append(localIOException.getMessage());
      throw new CMSRuntimeException(localStringBuilder.toString(), localIOException);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\PKCS7TypedStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */