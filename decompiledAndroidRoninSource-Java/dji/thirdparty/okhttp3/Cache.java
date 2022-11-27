package dji.thirdparty.okhttp3;

import dji.thirdparty.okhttp3.internal.DiskLruCache;
import dji.thirdparty.okhttp3.internal.DiskLruCache.Editor;
import dji.thirdparty.okhttp3.internal.DiskLruCache.Snapshot;
import dji.thirdparty.okhttp3.internal.InternalCache;
import dji.thirdparty.okhttp3.internal.Util;
import dji.thirdparty.okhttp3.internal.http.CacheRequest;
import dji.thirdparty.okhttp3.internal.http.CacheStrategy;
import dji.thirdparty.okhttp3.internal.http.OkHeaders;
import dji.thirdparty.okhttp3.internal.http.StatusLine;
import dji.thirdparty.okhttp3.internal.io.FileSystem;
import dji.thirdparty.okio.BufferedSource;
import dji.thirdparty.okio.ForwardingSink;
import dji.thirdparty.okio.ForwardingSource;
import dji.thirdparty.okio.Okio;
import dji.thirdparty.okio.Sink;
import dji.thirdparty.okio.Source;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Iterator;
import java.util.List;

public final class Cache
  implements Closeable, Flushable
{
  private static final int ENTRY_BODY = 1;
  private static final int ENTRY_COUNT = 2;
  private static final int ENTRY_METADATA = 0;
  private static final int VERSION = 201105;
  private final DiskLruCache cache;
  private int hitCount;
  final InternalCache internalCache = new InternalCache()
  {
    public Response get(Request paramAnonymousRequest)
      throws IOException
    {
      return Cache.this.get(paramAnonymousRequest);
    }
    
    public CacheRequest put(Response paramAnonymousResponse)
      throws IOException
    {
      return Cache.this.put(paramAnonymousResponse);
    }
    
    public void remove(Request paramAnonymousRequest)
      throws IOException
    {
      Cache.this.remove(paramAnonymousRequest);
    }
    
    public void trackConditionalCacheHit()
    {
      Cache.this.trackConditionalCacheHit();
    }
    
    public void trackResponse(CacheStrategy paramAnonymousCacheStrategy)
    {
      Cache.this.trackResponse(paramAnonymousCacheStrategy);
    }
    
    public void update(Response paramAnonymousResponse1, Response paramAnonymousResponse2)
      throws IOException
    {
      Cache.this.update(paramAnonymousResponse1, paramAnonymousResponse2);
    }
  };
  private int networkCount;
  private int requestCount;
  private int writeAbortCount;
  private int writeSuccessCount;
  
  public Cache(File paramFile, long paramLong)
  {
    this(paramFile, paramLong, FileSystem.SYSTEM);
  }
  
  Cache(File paramFile, long paramLong, FileSystem paramFileSystem)
  {
    this.cache = DiskLruCache.create(paramFileSystem, paramFile, 201105, 2, paramLong);
  }
  
  private void abortQuietly(DiskLruCache.Editor paramEditor)
  {
    if (paramEditor != null) {}
    try
    {
      paramEditor.abort();
      return;
    }
    catch (IOException paramEditor) {}
  }
  
  private CacheRequest put(Response paramResponse)
    throws IOException
  {
    return null;
  }
  
  private static int readInt(BufferedSource paramBufferedSource)
    throws IOException
  {
    try
    {
      long l = paramBufferedSource.readDecimalLong();
      paramBufferedSource = paramBufferedSource.readUtf8LineStrict();
      if ((l >= 0L) && (l <= 2147483647L) && (paramBufferedSource.isEmpty())) {
        return (int)l;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("expected an int but was \"");
      localStringBuilder.append(l);
      localStringBuilder.append(paramBufferedSource);
      localStringBuilder.append("\"");
      throw new IOException(localStringBuilder.toString());
    }
    catch (NumberFormatException paramBufferedSource)
    {
      throw new IOException(paramBufferedSource.getMessage());
    }
  }
  
  /* Error */
  private void remove(Request arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void trackConditionalCacheHit()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void trackResponse(CacheStrategy arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void update(Response arg1, Response arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private static String urlToKey(Request paramRequest)
  {
    return Util.md5Hex(paramRequest.url().toString());
  }
  
  public void close()
    throws IOException
  {
    this.cache.close();
  }
  
  public void delete()
    throws IOException
  {
    this.cache.delete();
  }
  
  public File directory()
  {
    return this.cache.getDirectory();
  }
  
  public void evictAll()
    throws IOException
  {
    this.cache.evictAll();
  }
  
  public void flush()
    throws IOException
  {
    this.cache.flush();
  }
  
  Response get(Request paramRequest)
  {
    return null;
  }
  
  public int hitCount()
  {
    try
    {
      int i = this.hitCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void initialize()
    throws IOException
  {
    this.cache.initialize();
  }
  
  public boolean isClosed()
  {
    return this.cache.isClosed();
  }
  
  public long maxSize()
  {
    return this.cache.getMaxSize();
  }
  
  public int networkCount()
  {
    try
    {
      int i = this.networkCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int requestCount()
  {
    try
    {
      int i = this.requestCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long size()
    throws IOException
  {
    return this.cache.size();
  }
  
  public Iterator<String> urls()
    throws IOException
  {
    new Iterator()
    {
      boolean canRemove;
      final Iterator<DiskLruCache.Snapshot> delegate = Cache.this.cache.snapshots();
      String nextUrl;
      
      public boolean hasNext()
      {
        return false;
      }
      
      public String next()
      {
        return null;
      }
      
      /* Error */
      public void remove()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    };
  }
  
  public int writeAbortCount()
  {
    try
    {
      int i = this.writeAbortCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int writeSuccessCount()
  {
    try
    {
      int i = this.writeSuccessCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private final class CacheRequestImpl
    implements CacheRequest
  {
    private Sink body;
    private Sink cacheOut;
    private boolean done;
    private final DiskLruCache.Editor editor;
    
    public CacheRequestImpl(final DiskLruCache.Editor paramEditor)
      throws IOException
    {
      this.editor = paramEditor;
      Sink localSink = paramEditor.newSink(1);
      this.cacheOut = localSink;
      this.body = new ForwardingSink(localSink)
      {
        /* Error */
        public void close()
          throws IOException
        {
          // Byte code:
          //   0: return
          //   1: astore_1
          //   2: return
        }
      };
    }
    
    /* Error */
    public void abort()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public Sink body()
    {
      return this.body;
    }
  }
  
  private static class CacheResponseBody
    extends ResponseBody
  {
    private final BufferedSource bodySource;
    private final String contentLength;
    private final String contentType;
    private final DiskLruCache.Snapshot snapshot;
    
    public CacheResponseBody(final DiskLruCache.Snapshot paramSnapshot, String paramString1, String paramString2)
    {
      this.snapshot = paramSnapshot;
      this.contentType = paramString1;
      this.contentLength = paramString2;
      this.bodySource = Okio.buffer(new ForwardingSource(paramSnapshot.getSource(1))
      {
        /* Error */
        public void close()
          throws IOException
        {
          // Byte code:
          //   0: return
          //   1: astore_1
          //   2: goto -2 -> 0
        }
      });
    }
    
    public long contentLength()
    {
      return 277865635L;
    }
    
    public MediaType contentType()
    {
      return null;
    }
    
    public BufferedSource source()
    {
      return this.bodySource;
    }
  }
  
  private static final class Entry
  {
    private final int code;
    private final Handshake handshake;
    private final String message;
    private final Protocol protocol;
    private final String requestMethod;
    private final Headers responseHeaders;
    private final String url;
    private final Headers varyHeaders;
    
    public Entry(Response paramResponse)
    {
      this.url = paramResponse.request().url().toString();
      this.varyHeaders = OkHeaders.varyHeaders(paramResponse);
      this.requestMethod = paramResponse.request().method();
      this.protocol = paramResponse.protocol();
      this.code = paramResponse.code();
      this.message = paramResponse.message();
      this.responseHeaders = paramResponse.headers();
      this.handshake = paramResponse.handshake();
    }
    
    public Entry(Source paramSource)
      throws IOException
    {
      try
      {
        BufferedSource localBufferedSource = Okio.buffer(paramSource);
        this.url = localBufferedSource.readUtf8LineStrict();
        this.requestMethod = localBufferedSource.readUtf8LineStrict();
        Object localObject1 = new Headers.Builder();
        int k = Cache.readInt(localBufferedSource);
        int j = 0;
        int i = 0;
        while (i < k)
        {
          ((Headers.Builder)localObject1).addLenient(localBufferedSource.readUtf8LineStrict());
          i += 1;
        }
        this.varyHeaders = ((Headers.Builder)localObject1).build();
        localObject1 = StatusLine.parse(localBufferedSource.readUtf8LineStrict());
        this.protocol = ((StatusLine)localObject1).protocol;
        this.code = ((StatusLine)localObject1).code;
        this.message = ((StatusLine)localObject1).message;
        localObject1 = new Headers.Builder();
        k = Cache.readInt(localBufferedSource);
        i = j;
        while (i < k)
        {
          ((Headers.Builder)localObject1).addLenient(localBufferedSource.readUtf8LineStrict());
          i += 1;
        }
        this.responseHeaders = ((Headers.Builder)localObject1).build();
        boolean bool = isHttps();
        localObject1 = null;
        if (bool)
        {
          Object localObject3 = localBufferedSource.readUtf8LineStrict();
          if (((String)localObject3).length() <= 0)
          {
            localObject3 = CipherSuite.forJavaName(localBufferedSource.readUtf8LineStrict());
            List localList1 = readCertificateList(localBufferedSource);
            List localList2 = readCertificateList(localBufferedSource);
            if (!localBufferedSource.exhausted()) {
              localObject1 = TlsVersion.forJavaName(localBufferedSource.readUtf8LineStrict());
            }
            this.handshake = Handshake.get((TlsVersion)localObject1, (CipherSuite)localObject3, localList1, localList2);
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("expected \"\" but was \"");
            ((StringBuilder)localObject1).append((String)localObject3);
            ((StringBuilder)localObject1).append("\"");
            throw new IOException(((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          this.handshake = null;
        }
        return;
      }
      finally
      {
        paramSource.close();
      }
    }
    
    private boolean isHttps()
    {
      return false;
    }
    
    private List<Certificate> readCertificateList(BufferedSource paramBufferedSource)
      throws IOException
    {
      return null;
    }
    
    /* Error */
    private void writeCertList(dji.thirdparty.okio.BufferedSink arg1, List<Certificate> arg2)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public boolean matches(Request paramRequest, Response paramResponse)
    {
      return false;
    }
    
    public Response response(DiskLruCache.Snapshot paramSnapshot)
    {
      return null;
    }
    
    /* Error */
    public void writeTo(DiskLruCache.Editor arg1)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\Cache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */