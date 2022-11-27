package org.bouncycastle.est.jcajce;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.bouncycastle.est.ESTClient;
import org.bouncycastle.est.ESTClientSourceProvider;
import org.bouncycastle.est.ESTException;
import org.bouncycastle.est.ESTHijacker;
import org.bouncycastle.est.ESTRequest;
import org.bouncycastle.est.ESTRequestBuilder;
import org.bouncycastle.est.ESTResponse;
import org.bouncycastle.est.ESTSourceConnectionListener;
import org.bouncycastle.est.Source;
import org.bouncycastle.util.Properties;

class DefaultESTClient
  implements ESTClient
{
  private static byte[] CRLF = { 13, 10 };
  private static final Charset utf8 = Charset.forName("UTF-8");
  private final ESTClientSourceProvider sslSocketProvider;
  
  public DefaultESTClient(ESTClientSourceProvider paramESTClientSourceProvider)
  {
    this.sslSocketProvider = paramESTClientSourceProvider;
  }
  
  private static void writeLine(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    paramOutputStream.write(paramString.getBytes());
    paramOutputStream.write(CRLF);
  }
  
  public ESTResponse doRequest(ESTRequest paramESTRequest)
    throws IOException
  {
    int i = 15;
    ESTResponse localESTResponse;
    int j;
    for (;;)
    {
      localESTResponse = performRequest(paramESTRequest);
      paramESTRequest = redirectURL(localESTResponse);
      j = i;
      if (paramESTRequest == null) {
        break;
      }
      i -= 1;
      if (i <= 0)
      {
        j = i;
        break;
      }
    }
    if (j != 0) {
      return localESTResponse;
    }
    throw new ESTException("Too many redirects..");
  }
  
  public ESTResponse performRequest(ESTRequest paramESTRequest)
    throws IOException
  {
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        Source localSource = this.sslSocketProvider.makeSource(paramESTRequest.getURL().getHost(), paramESTRequest.getURL().getPort());
        Object localObject2 = paramESTRequest;
        localObject1 = localSource;
        if (paramESTRequest.getListener() != null)
        {
          localObject1 = localSource;
          localObject2 = paramESTRequest.getListener().onConnection(localSource, paramESTRequest);
        }
        localObject1 = localSource;
        paramESTRequest = Properties.asKeySet("org.bouncycastle.debug.est");
        localObject1 = localSource;
        if (!paramESTRequest.contains("output"))
        {
          localObject1 = localSource;
          if (!paramESTRequest.contains("all"))
          {
            localObject1 = localSource;
            paramESTRequest = localSource.getOutputStream();
            continue;
          }
        }
        localObject1 = localSource;
        paramESTRequest = new PrintingOutputStream(localSource.getOutputStream());
        localObject1 = localSource;
        Object localObject4 = new StringBuilder();
        localObject1 = localSource;
        ((StringBuilder)localObject4).append(((ESTRequest)localObject2).getURL().getPath());
        localObject1 = localSource;
        if (((ESTRequest)localObject2).getURL().getQuery() != null)
        {
          localObject1 = localSource;
          localObject3 = ((ESTRequest)localObject2).getURL().getQuery();
          localObject1 = localSource;
          ((StringBuilder)localObject4).append((String)localObject3);
          localObject1 = localSource;
          localObject3 = ((StringBuilder)localObject4).toString();
          localObject1 = localSource;
          localObject4 = new ESTRequestBuilder((ESTRequest)localObject2);
          localObject1 = localSource;
          if (!((ESTRequest)localObject2).getHeaders().containsKey("Connection"))
          {
            localObject1 = localSource;
            ((ESTRequestBuilder)localObject4).addHeader("Connection", "close");
          }
          localObject1 = localSource;
          localObject2 = ((ESTRequest)localObject2).getURL();
          localObject1 = localSource;
          int i = ((URL)localObject2).getPort();
          if (i > -1)
          {
            localObject1 = localSource;
            localObject2 = String.format("%s:%d", new Object[] { ((URL)localObject2).getHost(), Integer.valueOf(((URL)localObject2).getPort()) });
            localObject1 = localSource;
            ((ESTRequestBuilder)localObject4).setHeader("Host", (String)localObject2);
          }
          else
          {
            localObject1 = localSource;
            localObject2 = ((URL)localObject2).getHost();
            continue;
          }
          localObject1 = localSource;
          localObject2 = ((ESTRequestBuilder)localObject4).build();
          localObject1 = localSource;
          localObject4 = new StringBuilder();
          localObject1 = localSource;
          ((StringBuilder)localObject4).append(((ESTRequest)localObject2).getMethod());
          localObject1 = localSource;
          ((StringBuilder)localObject4).append(" ");
          localObject1 = localSource;
          ((StringBuilder)localObject4).append((String)localObject3);
          localObject1 = localSource;
          ((StringBuilder)localObject4).append(" HTTP/1.1");
          localObject1 = localSource;
          writeLine(paramESTRequest, ((StringBuilder)localObject4).toString());
          localObject1 = localSource;
          localObject3 = ((ESTRequest)localObject2).getHeaders().entrySet().iterator();
          localObject1 = localSource;
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = localSource;
            localObject4 = (Map.Entry)((Iterator)localObject3).next();
            localObject1 = localSource;
            String[] arrayOfString = (String[])((Map.Entry)localObject4).getValue();
            i = 0;
            localObject1 = localSource;
            if (i == arrayOfString.length) {
              continue;
            }
            localObject1 = localSource;
            StringBuilder localStringBuilder = new StringBuilder();
            localObject1 = localSource;
            localStringBuilder.append((String)((Map.Entry)localObject4).getKey());
            localObject1 = localSource;
            localStringBuilder.append(": ");
            localObject1 = localSource;
            localStringBuilder.append(arrayOfString[i]);
            localObject1 = localSource;
            writeLine(paramESTRequest, localStringBuilder.toString());
            i += 1;
            continue;
          }
          localObject1 = localSource;
          paramESTRequest.write(CRLF);
          localObject1 = localSource;
          paramESTRequest.flush();
          localObject1 = localSource;
          ((ESTRequest)localObject2).writeData(paramESTRequest);
          localObject1 = localSource;
          paramESTRequest.flush();
          localObject1 = localSource;
          if (((ESTRequest)localObject2).getHijacker() != null)
          {
            localObject1 = localSource;
            paramESTRequest = ((ESTRequest)localObject2).getHijacker().hijack((ESTRequest)localObject2, localSource);
            if ((localSource != null) && (paramESTRequest == null)) {
              localSource.close();
            }
            return paramESTRequest;
          }
          localObject1 = localSource;
          paramESTRequest = new ESTResponse((ESTRequest)localObject2, localSource);
          return paramESTRequest;
        }
      }
      finally
      {
        if (localObject1 != null) {
          ((Source)localObject1).close();
        }
      }
      Object localObject3 = "";
    }
  }
  
  protected ESTRequest redirectURL(ESTResponse paramESTResponse)
    throws IOException
  {
    Object localObject;
    if ((paramESTResponse.getStatusCode() >= 300) && (paramESTResponse.getStatusCode() <= 399))
    {
      switch (paramESTResponse.getStatusCode())
      {
      case 304: 
      case 305: 
      default: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Client does not handle http status code: ");
        ((StringBuilder)localObject).append(paramESTResponse.getStatusCode());
        throw new ESTException(((StringBuilder)localObject).toString());
      }
      localObject = paramESTResponse.getHeader("Location");
      if (!"".equals(localObject))
      {
        ESTRequestBuilder localESTRequestBuilder = new ESTRequestBuilder(paramESTResponse.getOriginalRequest());
        if (((String)localObject).startsWith("http"))
        {
          localObject = localESTRequestBuilder.withURL(new URL((String)localObject));
        }
        else
        {
          URL localURL = paramESTResponse.getOriginalRequest().getURL();
          localObject = localESTRequestBuilder.withURL(new URL(localURL.getProtocol(), localURL.getHost(), localURL.getPort(), (String)localObject));
        }
        localObject = ((ESTRequestBuilder)localObject).build();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Redirect status type: ");
        ((StringBuilder)localObject).append(paramESTResponse.getStatusCode());
        ((StringBuilder)localObject).append(" but no location header");
        throw new ESTException(((StringBuilder)localObject).toString());
      }
    }
    else
    {
      localObject = null;
    }
    if (localObject != null) {
      paramESTResponse.close();
    }
    return (ESTRequest)localObject;
  }
  
  private class PrintingOutputStream
    extends OutputStream
  {
    private final OutputStream tgt;
    
    public PrintingOutputStream(OutputStream paramOutputStream)
    {
      this.tgt = paramOutputStream;
    }
    
    public void write(int paramInt)
      throws IOException
    {
      System.out.print(String.valueOf((char)paramInt));
      this.tgt.write(paramInt);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\est\jcajce\DefaultESTClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */