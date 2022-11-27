package org.bouncycastle.est.jcajce;

import java.io.IOException;
import javax.net.ssl.SSLSession;

public abstract interface JsseHostnameAuthorizer
{
  public abstract boolean verified(String paramString, SSLSession paramSSLSession)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\est\jcajce\JsseHostnameAuthorizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */