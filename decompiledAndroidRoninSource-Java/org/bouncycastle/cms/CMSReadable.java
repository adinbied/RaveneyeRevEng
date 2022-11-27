package org.bouncycastle.cms;

import java.io.IOException;
import java.io.InputStream;

abstract interface CMSReadable
{
  public abstract InputStream getInputStream()
    throws IOException, CMSException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSReadable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */