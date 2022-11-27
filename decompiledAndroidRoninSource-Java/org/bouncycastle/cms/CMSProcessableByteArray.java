package org.bouncycastle.cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.util.Arrays;

public class CMSProcessableByteArray
  implements CMSTypedData, CMSReadable
{
  private final byte[] bytes;
  private final ASN1ObjectIdentifier type;
  
  public CMSProcessableByteArray(ASN1ObjectIdentifier paramASN1ObjectIdentifier, byte[] paramArrayOfByte)
  {
    this.type = paramASN1ObjectIdentifier;
    this.bytes = paramArrayOfByte;
  }
  
  public CMSProcessableByteArray(byte[] paramArrayOfByte)
  {
    this(new ASN1ObjectIdentifier(CMSObjectIdentifiers.data.getId()), paramArrayOfByte);
  }
  
  public Object getContent()
  {
    return Arrays.clone(this.bytes);
  }
  
  public ASN1ObjectIdentifier getContentType()
  {
    return this.type;
  }
  
  public InputStream getInputStream()
  {
    return new ByteArrayInputStream(this.bytes);
  }
  
  public void write(OutputStream paramOutputStream)
    throws IOException, CMSException
  {
    paramOutputStream.write(this.bytes);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSProcessableByteArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */