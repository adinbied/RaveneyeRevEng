package org.bouncycastle.cms;

import java.io.IOException;
import java.io.OutputStream;

public abstract interface CMSProcessable
{
  public abstract Object getContent();
  
  public abstract void write(OutputStream paramOutputStream)
    throws IOException, CMSException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSProcessable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */