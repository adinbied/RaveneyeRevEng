package org.bouncycastle.crypto;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public abstract interface KeyParser
{
  public abstract AsymmetricKeyParameter readKey(InputStream paramInputStream)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\KeyParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */