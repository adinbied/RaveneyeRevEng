package org.bouncycastle.cms;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.util.io.Streams;

class CMSProcessableInputStream
  implements CMSProcessable, CMSReadable
{
  private InputStream input;
  private boolean used = false;
  
  public CMSProcessableInputStream(InputStream paramInputStream)
  {
    this.input = paramInputStream;
  }
  
  private void checkSingleUsage()
  {
    try
    {
      if (!this.used)
      {
        this.used = true;
        return;
      }
      throw new IllegalStateException("CMSProcessableInputStream can only be used once");
    }
    finally {}
  }
  
  public Object getContent()
  {
    return getInputStream();
  }
  
  public InputStream getInputStream()
  {
    checkSingleUsage();
    return this.input;
  }
  
  public void write(OutputStream paramOutputStream)
    throws IOException, CMSException
  {
    checkSingleUsage();
    Streams.pipeAll(this.input, paramOutputStream);
    this.input.close();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSProcessableInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */