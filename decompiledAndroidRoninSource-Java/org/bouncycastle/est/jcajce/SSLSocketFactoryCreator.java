package org.bouncycastle.est.jcajce;

import javax.net.ssl.SSLSocketFactory;

public abstract interface SSLSocketFactoryCreator
{
  public abstract SSLSocketFactory createFactory()
    throws Exception;
  
  public abstract boolean isTrusted();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\est\jcajce\SSLSocketFactoryCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */