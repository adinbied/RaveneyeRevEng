package org.bouncycastle.est;

public abstract interface ESTClientProvider
{
  public abstract boolean isTrusted();
  
  public abstract ESTClient makeClient()
    throws ESTException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\est\ESTClientProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */