package org.bouncycastle.x509;

import java.io.InputStream;
import java.util.Collection;
import org.bouncycastle.x509.util.StreamParsingException;

public abstract class X509StreamParserSpi
{
  public abstract void engineInit(InputStream paramInputStream);
  
  public abstract Object engineRead()
    throws StreamParsingException;
  
  public abstract Collection engineReadAll()
    throws StreamParsingException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\X509StreamParserSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */