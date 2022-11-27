package org.bouncycastle.cms;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;

public class CMSProcessableFile
  implements CMSTypedData, CMSReadable
{
  private static final int DEFAULT_BUF_SIZE = 32768;
  private final byte[] buf;
  private final File file;
  private final ASN1ObjectIdentifier type;
  
  public CMSProcessableFile(File paramFile)
  {
    this(paramFile, 32768);
  }
  
  public CMSProcessableFile(File paramFile, int paramInt)
  {
    this(new ASN1ObjectIdentifier(CMSObjectIdentifiers.data.getId()), paramFile, paramInt);
  }
  
  public CMSProcessableFile(ASN1ObjectIdentifier paramASN1ObjectIdentifier, File paramFile, int paramInt)
  {
    this.type = paramASN1ObjectIdentifier;
    this.file = paramFile;
    this.buf = new byte[paramInt];
  }
  
  public Object getContent()
  {
    return this.file;
  }
  
  public ASN1ObjectIdentifier getContentType()
  {
    return this.type;
  }
  
  public InputStream getInputStream()
    throws IOException, CMSException
  {
    return new BufferedInputStream(new FileInputStream(this.file), 32768);
  }
  
  public void write(OutputStream paramOutputStream)
    throws IOException, CMSException
  {
    FileInputStream localFileInputStream = new FileInputStream(this.file);
    for (;;)
    {
      byte[] arrayOfByte = this.buf;
      int i = localFileInputStream.read(arrayOfByte, 0, arrayOfByte.length);
      if (i <= 0) {
        break;
      }
      paramOutputStream.write(this.buf, 0, i);
    }
    localFileInputStream.close();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSProcessableFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */