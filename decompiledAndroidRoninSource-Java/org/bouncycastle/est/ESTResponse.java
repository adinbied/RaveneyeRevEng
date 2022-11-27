package org.bouncycastle.est;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Set;
import org.bouncycastle.util.Properties;
import org.bouncycastle.util.Strings;

public class ESTResponse
{
  private static final Long ZERO = Long.valueOf(0L);
  private String HttpVersion;
  private Long absoluteReadLimit;
  private Long contentLength;
  private final HttpUtil.Headers headers;
  private InputStream inputStream;
  private final byte[] lineBuffer;
  private final ESTRequest originalRequest;
  private long read = 0L;
  private final Source source;
  private int statusCode;
  private String statusMessage;
  
  public ESTResponse(ESTRequest paramESTRequest, Source paramSource)
    throws IOException
  {
    this.originalRequest = paramESTRequest;
    this.source = paramSource;
    if ((paramSource instanceof LimitedSource)) {
      this.absoluteReadLimit = ((LimitedSource)paramSource).getAbsoluteReadLimit();
    }
    paramESTRequest = Properties.asKeySet("org.bouncycastle.debug.est");
    if ((!paramESTRequest.contains("input")) && (!paramESTRequest.contains("all"))) {
      paramESTRequest = paramSource.getInputStream();
    } else {
      paramESTRequest = new PrintingInputStream(paramSource.getInputStream(), null);
    }
    this.inputStream = paramESTRequest;
    this.headers = new HttpUtil.Headers();
    this.lineBuffer = new byte['Ѐ'];
    process();
  }
  
  private void process()
    throws IOException
  {
    this.HttpVersion = readStringIncluding(' ');
    this.statusCode = Integer.parseInt(readStringIncluding(' '));
    this.statusMessage = readStringIncluding('\n');
    for (;;)
    {
      localObject = readStringIncluding('\n');
      if (((String)localObject).length() <= 0) {
        break;
      }
      i = ((String)localObject).indexOf(':');
      if (i > -1)
      {
        String str = Strings.toLowerCase(((String)localObject).substring(0, i).trim());
        this.headers.add(str, ((String)localObject).substring(i + 1).trim());
      }
    }
    this.contentLength = getContentLength();
    int i = this.statusCode;
    if ((i == 204) || (i == 202))
    {
      localObject = this.contentLength;
      if (localObject == null) {
        this.contentLength = Long.valueOf(0L);
      } else if ((this.statusCode == 204) && (((Long)localObject).longValue() > 0L)) {
        throw new IOException("Got HTTP status 204 but Content-length > 0.");
      }
    }
    Object localObject = this.contentLength;
    if (localObject != null)
    {
      if (((Long)localObject).equals(ZERO)) {
        this.inputStream = new InputStream()
        {
          public int read()
            throws IOException
          {
            return -1;
          }
        };
      }
      localObject = this.contentLength;
      if (localObject != null) {
        if (((Long)localObject).longValue() >= 0L)
        {
          if ((this.absoluteReadLimit != null) && (this.contentLength.longValue() >= this.absoluteReadLimit.longValue()))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Content length longer than absolute read limit: ");
            ((StringBuilder)localObject).append(this.absoluteReadLimit);
            ((StringBuilder)localObject).append(" Content-Length: ");
            ((StringBuilder)localObject).append(this.contentLength);
            throw new IOException(((StringBuilder)localObject).toString());
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Server returned negative content length: ");
          ((StringBuilder)localObject).append(this.absoluteReadLimit);
          throw new IOException(((StringBuilder)localObject).toString());
        }
      }
      this.inputStream = wrapWithCounter(this.inputStream, this.absoluteReadLimit);
      if ("base64".equalsIgnoreCase(getHeader("content-transfer-encoding"))) {
        this.inputStream = new CTEBase64InputStream(this.inputStream, getContentLength());
      }
      return;
    }
    throw new IOException("No Content-length header.");
  }
  
  public void close()
    throws IOException
  {
    InputStream localInputStream = this.inputStream;
    if (localInputStream != null) {
      localInputStream.close();
    }
    this.source.close();
  }
  
  public Long getContentLength()
  {
    String str = this.headers.getFirstValue("Content-Length");
    if (str == null) {
      return null;
    }
    try
    {
      long l = Long.parseLong(str);
      return Long.valueOf(l);
    }
    catch (RuntimeException localRuntimeException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Content Length: '");
      localStringBuilder.append(str);
      localStringBuilder.append("' invalid. ");
      localStringBuilder.append(localRuntimeException.getMessage());
      throw new RuntimeException(localStringBuilder.toString());
    }
  }
  
  public String getHeader(String paramString)
  {
    return this.headers.getFirstValue(paramString);
  }
  
  public HttpUtil.Headers getHeaders()
  {
    return this.headers;
  }
  
  public String getHttpVersion()
  {
    return this.HttpVersion;
  }
  
  public InputStream getInputStream()
  {
    return this.inputStream;
  }
  
  public ESTRequest getOriginalRequest()
  {
    return this.originalRequest;
  }
  
  public Source getSource()
  {
    return this.source;
  }
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
  
  public String getStatusMessage()
  {
    return this.statusMessage;
  }
  
  protected String readStringIncluding(char paramChar)
    throws IOException
  {
    char c;
    int j;
    for (int i = 0;; i = j)
    {
      c = this.inputStream.read();
      localObject = this.lineBuffer;
      j = i + 1;
      localObject[i] = ((byte)c);
      if (j >= localObject.length) {
        break label86;
      }
      if ((c == paramChar) || (c <= '￿')) {
        break;
      }
    }
    if (c != '￿') {
      return new String(this.lineBuffer, 0, j).trim();
    }
    throw new EOFException();
    label86:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Server sent line > ");
    ((StringBuilder)localObject).append(this.lineBuffer.length);
    throw new IOException(((StringBuilder)localObject).toString());
  }
  
  protected InputStream wrapWithCounter(final InputStream paramInputStream, final Long paramLong)
  {
    new InputStream()
    {
      public void close()
        throws IOException
      {
        if ((ESTResponse.this.contentLength != null) && (ESTResponse.this.contentLength.longValue() - 1L > ESTResponse.this.read))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Stream closed before limit fully read, Read: ");
          localStringBuilder.append(ESTResponse.this.read);
          localStringBuilder.append(" ContentLength: ");
          localStringBuilder.append(ESTResponse.this.contentLength);
          throw new IOException(localStringBuilder.toString());
        }
        if (paramInputStream.available() <= 0)
        {
          paramInputStream.close();
          return;
        }
        throw new IOException("Stream closed with extra content in pipe that exceeds content length.");
      }
      
      public int read()
        throws IOException
      {
        int i = paramInputStream.read();
        if (i > -1)
        {
          ESTResponse.access$108(ESTResponse.this);
          if (paramLong != null)
          {
            if (ESTResponse.this.read < paramLong.longValue()) {
              return i;
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Absolute Read Limit exceeded: ");
            localStringBuilder.append(paramLong);
            throw new IOException(localStringBuilder.toString());
          }
        }
        return i;
      }
    };
  }
  
  private class PrintingInputStream
    extends InputStream
  {
    private final InputStream src;
    
    private PrintingInputStream(InputStream paramInputStream)
    {
      this.src = paramInputStream;
    }
    
    public int available()
      throws IOException
    {
      return this.src.available();
    }
    
    public void close()
      throws IOException
    {
      this.src.close();
    }
    
    public int read()
      throws IOException
    {
      int i = this.src.read();
      System.out.print(String.valueOf((char)i));
      return i;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\est\ESTResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */