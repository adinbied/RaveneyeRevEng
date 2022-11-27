package org.bouncycastle.est.jcajce;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.bouncycastle.est.ESTClientSourceProvider;
import org.bouncycastle.est.Source;
import org.bouncycastle.util.Strings;

class DefaultESTClientSourceProvider
  implements ESTClientSourceProvider
{
  private final Long absoluteLimit;
  private final ChannelBindingProvider bindingProvider;
  private final Set<String> cipherSuites;
  private final boolean filterSupportedSuites;
  private final JsseHostnameAuthorizer hostNameAuthorizer;
  private final SSLSocketFactory sslSocketFactory;
  private final int timeout;
  
  public DefaultESTClientSourceProvider(SSLSocketFactory paramSSLSocketFactory, JsseHostnameAuthorizer paramJsseHostnameAuthorizer, int paramInt, ChannelBindingProvider paramChannelBindingProvider, Set<String> paramSet, Long paramLong, boolean paramBoolean)
    throws GeneralSecurityException
  {
    this.sslSocketFactory = paramSSLSocketFactory;
    this.hostNameAuthorizer = paramJsseHostnameAuthorizer;
    this.timeout = paramInt;
    this.bindingProvider = paramChannelBindingProvider;
    this.cipherSuites = paramSet;
    this.absoluteLimit = paramLong;
    this.filterSupportedSuites = paramBoolean;
  }
  
  public Source makeSource(String paramString, int paramInt)
    throws IOException
  {
    Object localObject1 = (SSLSocket)this.sslSocketFactory.createSocket(paramString, paramInt);
    ((SSLSocket)localObject1).setSoTimeout(this.timeout);
    Object localObject2 = this.cipherSuites;
    if ((localObject2 != null) && (!((Set)localObject2).isEmpty())) {
      if (this.filterSupportedSuites)
      {
        localObject2 = new HashSet();
        Object localObject3 = ((SSLSocket)localObject1).getSupportedCipherSuites();
        paramInt = 0;
        while (paramInt != localObject3.length)
        {
          ((HashSet)localObject2).add(localObject3[paramInt]);
          paramInt += 1;
        }
        localObject3 = new ArrayList();
        Iterator localIterator = this.cipherSuites.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (((HashSet)localObject2).contains(str)) {
            ((List)localObject3).add(str);
          }
        }
        if (!((List)localObject3).isEmpty()) {
          ((SSLSocket)localObject1).setEnabledCipherSuites((String[])((List)localObject3).toArray(new String[((List)localObject3).size()]));
        } else {
          throw new IllegalStateException("No supplied cipher suite is supported by the provider.");
        }
      }
      else
      {
        localObject2 = this.cipherSuites;
        ((SSLSocket)localObject1).setEnabledCipherSuites((String[])((Set)localObject2).toArray(new String[((Set)localObject2).size()]));
      }
    }
    ((SSLSocket)localObject1).startHandshake();
    localObject2 = this.hostNameAuthorizer;
    if ((localObject2 != null) && (!((JsseHostnameAuthorizer)localObject2).verified(paramString, ((SSLSocket)localObject1).getSession()))) {
      throw new IOException("Host name could not be verified.");
    }
    localObject2 = Strings.toLowerCase(((SSLSocket)localObject1).getSession().getCipherSuite());
    if ((!((String)localObject2).contains("_des_")) && (!((String)localObject2).contains("_des40_")) && (!((String)localObject2).contains("_3des_"))) {
      if (!Strings.toLowerCase(((SSLSocket)localObject1).getSession().getCipherSuite()).contains("null")) {
        if (!Strings.toLowerCase(((SSLSocket)localObject1).getSession().getCipherSuite()).contains("anon")) {
          if (!Strings.toLowerCase(((SSLSocket)localObject1).getSession().getCipherSuite()).contains("export")) {
            if (!((SSLSocket)localObject1).getSession().getProtocol().equalsIgnoreCase("tlsv1"))
            {
              localObject2 = this.hostNameAuthorizer;
              if ((localObject2 != null) && (!((JsseHostnameAuthorizer)localObject2).verified(paramString, ((SSLSocket)localObject1).getSession())))
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("Hostname was not verified: ");
                ((StringBuilder)localObject1).append(paramString);
                throw new IOException(((StringBuilder)localObject1).toString());
              }
              return new LimitedSSLSocketSource((SSLSocket)localObject1, this.bindingProvider, this.absoluteLimit);
            }
          }
        }
      }
    }
    try
    {
      ((SSLSocket)localObject1).close();
      throw new IOException("EST clients must not use TLSv1");
      throw new IOException("EST clients must not use export ciphers");
      throw new IOException("EST clients must not use anon ciphers");
      throw new IOException("EST clients must not use NULL ciphers");
      throw new IOException("EST clients must not use DES ciphers");
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\est\jcajce\DefaultESTClientSourceProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */