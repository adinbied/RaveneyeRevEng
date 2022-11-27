package org.bouncycastle.util.io.pem;

import java.io.IOException;

public abstract interface PemObjectParser
{
  public abstract Object parseObject(PemObject paramPemObject)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\io\pem\PemObjectParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */