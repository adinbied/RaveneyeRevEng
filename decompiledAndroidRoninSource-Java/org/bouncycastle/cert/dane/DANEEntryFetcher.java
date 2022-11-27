package org.bouncycastle.cert.dane;

import java.util.List;

public abstract interface DANEEntryFetcher
{
  public abstract List getEntries()
    throws DANEException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\dane\DANEEntryFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */