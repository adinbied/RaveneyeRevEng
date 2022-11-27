package org.bouncycastle.x509.util;

import java.util.Collection;

public abstract interface StreamParser
{
  public abstract Object read()
    throws StreamParsingException;
  
  public abstract Collection readAll()
    throws StreamParsingException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x50\\util\StreamParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */