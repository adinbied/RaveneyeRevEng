package org.bouncycastle.cert.dane;

public class DANEEntryStoreBuilder
{
  private final DANEEntryFetcherFactory daneEntryFetcher;
  
  public DANEEntryStoreBuilder(DANEEntryFetcherFactory paramDANEEntryFetcherFactory)
  {
    this.daneEntryFetcher = paramDANEEntryFetcherFactory;
  }
  
  public DANEEntryStore build(String paramString)
    throws DANEException
  {
    return new DANEEntryStore(this.daneEntryFetcher.build(paramString).getEntries());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\dane\DANEEntryStoreBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */