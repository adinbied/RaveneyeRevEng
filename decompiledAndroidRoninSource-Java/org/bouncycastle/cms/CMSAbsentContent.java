package org.bouncycastle.cms;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;

public class CMSAbsentContent
  implements CMSTypedData, CMSReadable
{
  private final ASN1ObjectIdentifier type;
  
  public CMSAbsentContent()
  {
    this(CMSObjectIdentifiers.data);
  }
  
  public CMSAbsentContent(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this.type = paramASN1ObjectIdentifier;
  }
  
  public Object getContent()
  {
    return null;
  }
  
  public ASN1ObjectIdentifier getContentType()
  {
    return this.type;
  }
  
  public InputStream getInputStream()
  {
    return null;
  }
  
  public void write(OutputStream paramOutputStream)
    throws IOException, CMSException
  {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSAbsentContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */