package org.bouncycastle.est;

import java.io.IOException;

public abstract interface ESTHijacker
{
  public abstract ESTResponse hijack(ESTRequest paramESTRequest, Source paramSource)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\est\ESTHijacker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */