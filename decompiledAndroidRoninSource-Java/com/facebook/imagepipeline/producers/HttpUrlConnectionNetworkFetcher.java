package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

public class HttpUrlConnectionNetworkFetcher
  extends BaseNetworkFetcher<HttpUrlConnectionNetworkFetchState>
{
  private static final String FETCH_TIME = "fetch_time";
  public static final int HTTP_DEFAULT_TIMEOUT = 30000;
  public static final int HTTP_PERMANENT_REDIRECT = 308;
  public static final int HTTP_TEMPORARY_REDIRECT = 307;
  private static final String IMAGE_SIZE = "image_size";
  private static final int MAX_REDIRECTS = 5;
  private static final int NUM_NETWORK_THREADS = 3;
  private static final String QUEUE_TIME = "queue_time";
  private static final String TOTAL_TIME = "total_time";
  private final ExecutorService mExecutorService = Executors.newFixedThreadPool(3);
  private int mHttpConnectionTimeout;
  private final MonotonicClock mMonotonicClock;
  @Nullable
  private final Map<String, String> mRequestHeaders;
  @Nullable
  private String mUserAgent;
  
  public HttpUrlConnectionNetworkFetcher()
  {
    this(null, null, RealtimeSinceBootClock.get());
  }
  
  public HttpUrlConnectionNetworkFetcher(int paramInt)
  {
    this(null, null, RealtimeSinceBootClock.get());
    this.mHttpConnectionTimeout = paramInt;
  }
  
  public HttpUrlConnectionNetworkFetcher(String paramString, int paramInt)
  {
    this(paramString, null, RealtimeSinceBootClock.get());
    this.mHttpConnectionTimeout = paramInt;
  }
  
  public HttpUrlConnectionNetworkFetcher(String paramString, @Nullable Map<String, String> paramMap, int paramInt)
  {
    this(paramString, paramMap, RealtimeSinceBootClock.get());
    this.mHttpConnectionTimeout = paramInt;
  }
  
  HttpUrlConnectionNetworkFetcher(@Nullable String paramString, @Nullable Map<String, String> paramMap, MonotonicClock paramMonotonicClock)
  {
    this.mMonotonicClock = paramMonotonicClock;
    this.mRequestHeaders = paramMap;
    this.mUserAgent = paramString;
  }
  
  private HttpURLConnection downloadFrom(Uri paramUri, int paramInt)
    throws IOException
  {
    Object localObject1 = openConnectionTo(paramUri);
    Object localObject2 = this.mUserAgent;
    if (localObject2 != null) {
      ((HttpURLConnection)localObject1).setRequestProperty("User-Agent", (String)localObject2);
    }
    localObject2 = this.mRequestHeaders;
    if (localObject2 != null)
    {
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        ((HttpURLConnection)localObject1).setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    ((HttpURLConnection)localObject1).setConnectTimeout(this.mHttpConnectionTimeout);
    int i = ((HttpURLConnection)localObject1).getResponseCode();
    if (isHttpSuccess(i)) {
      return (HttpURLConnection)localObject1;
    }
    if (isHttpRedirect(i))
    {
      localObject2 = ((HttpURLConnection)localObject1).getHeaderField("Location");
      ((HttpURLConnection)localObject1).disconnect();
      if (localObject2 == null) {
        localObject1 = null;
      } else {
        localObject1 = Uri.parse((String)localObject2);
      }
      localObject2 = paramUri.getScheme();
      if ((paramInt > 0) && (localObject1 != null) && (!((Uri)localObject1).getScheme().equals(localObject2))) {
        return downloadFrom((Uri)localObject1, paramInt - 1);
      }
      if (paramInt == 0) {
        paramUri = error("URL %s follows too many redirects", new Object[] { paramUri.toString() });
      } else {
        paramUri = error("URL %s returned %d without a valid redirect", new Object[] { paramUri.toString(), Integer.valueOf(i) });
      }
      throw new IOException(paramUri);
    }
    ((HttpURLConnection)localObject1).disconnect();
    throw new IOException(String.format("Image URL %s returned HTTP code %d", new Object[] { paramUri.toString(), Integer.valueOf(i) }));
  }
  
  private static String error(String paramString, Object... paramVarArgs)
  {
    return String.format(Locale.getDefault(), paramString, paramVarArgs);
  }
  
  private static boolean isHttpRedirect(int paramInt)
  {
    if ((paramInt != 307) && (paramInt != 308)) {
      switch (paramInt)
      {
      default: 
        return false;
      }
    }
    return true;
  }
  
  private static boolean isHttpSuccess(int paramInt)
  {
    return (paramInt >= 200) && (paramInt < 300);
  }
  
  static HttpURLConnection openConnectionTo(Uri paramUri)
    throws IOException
  {
    return (HttpURLConnection)UriUtil.uriToUrl(paramUri).openConnection();
  }
  
  public HttpUrlConnectionNetworkFetchState createFetchState(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    return new HttpUrlConnectionNetworkFetchState(paramConsumer, paramProducerContext);
  }
  
  public void fetch(final HttpUrlConnectionNetworkFetchState paramHttpUrlConnectionNetworkFetchState, final NetworkFetcher.Callback paramCallback)
  {
    HttpUrlConnectionNetworkFetchState.access$002(paramHttpUrlConnectionNetworkFetchState, this.mMonotonicClock.now());
    final Future localFuture = this.mExecutorService.submit(new Runnable()
    {
      public void run()
      {
        HttpUrlConnectionNetworkFetcher.this.fetchSync(paramHttpUrlConnectionNetworkFetchState, paramCallback);
      }
    });
    paramHttpUrlConnectionNetworkFetchState.getContext().addCallbacks(new BaseProducerContextCallbacks()
    {
      public void onCancellationRequested()
      {
        if (localFuture.cancel(false)) {
          paramCallback.onCancellation();
        }
      }
    });
  }
  
  /* Error */
  void fetchSync(HttpUrlConnectionNetworkFetchState paramHttpUrlConnectionNetworkFetchState, NetworkFetcher.Callback paramCallback)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore 9
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 270	com/facebook/imagepipeline/producers/HttpUrlConnectionNetworkFetcher$HttpUrlConnectionNetworkFetchState:getUri	()Landroid/net/Uri;
    //   19: iconst_5
    //   20: invokespecial 170	com/facebook/imagepipeline/producers/HttpUrlConnectionNetworkFetcher:downloadFrom	(Landroid/net/Uri;I)Ljava/net/HttpURLConnection;
    //   23: astore 4
    //   25: aload 7
    //   27: astore 6
    //   29: aload 8
    //   31: astore_3
    //   32: aload 4
    //   34: astore 5
    //   36: aload_1
    //   37: aload_0
    //   38: getfield 78	com/facebook/imagepipeline/producers/HttpUrlConnectionNetworkFetcher:mMonotonicClock	Lcom/facebook/common/time/MonotonicClock;
    //   41: invokeinterface 239 1 0
    //   46: invokestatic 273	com/facebook/imagepipeline/producers/HttpUrlConnectionNetworkFetcher$HttpUrlConnectionNetworkFetchState:access$102	(Lcom/facebook/imagepipeline/producers/HttpUrlConnectionNetworkFetcher$HttpUrlConnectionNetworkFetchState;J)J
    //   49: pop2
    //   50: aload 9
    //   52: astore_1
    //   53: aload 4
    //   55: ifnull +37 -> 92
    //   58: aload 7
    //   60: astore 6
    //   62: aload 8
    //   64: astore_3
    //   65: aload 4
    //   67: astore 5
    //   69: aload 4
    //   71: invokevirtual 277	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   74: astore_1
    //   75: aload_1
    //   76: astore 6
    //   78: aload_1
    //   79: astore_3
    //   80: aload 4
    //   82: astore 5
    //   84: aload_2
    //   85: aload_1
    //   86: iconst_m1
    //   87: invokeinterface 283 3 0
    //   92: aload_1
    //   93: ifnull +10 -> 103
    //   96: aload_1
    //   97: invokevirtual 288	java/io/InputStream:close	()V
    //   100: goto +3 -> 103
    //   103: aload 4
    //   105: ifnull +65 -> 170
    //   108: aload 4
    //   110: astore_1
    //   111: goto +55 -> 166
    //   114: astore_3
    //   115: aload 4
    //   117: astore_1
    //   118: aload_3
    //   119: astore 4
    //   121: goto +14 -> 135
    //   124: astore_1
    //   125: aconst_null
    //   126: astore 5
    //   128: goto +44 -> 172
    //   131: astore 4
    //   133: aconst_null
    //   134: astore_1
    //   135: aload 6
    //   137: astore_3
    //   138: aload_1
    //   139: astore 5
    //   141: aload_2
    //   142: aload 4
    //   144: invokeinterface 292 2 0
    //   149: aload 6
    //   151: ifnull +11 -> 162
    //   154: aload 6
    //   156: invokevirtual 288	java/io/InputStream:close	()V
    //   159: goto +3 -> 162
    //   162: aload_1
    //   163: ifnull +7 -> 170
    //   166: aload_1
    //   167: invokevirtual 154	java/net/HttpURLConnection:disconnect	()V
    //   170: return
    //   171: astore_1
    //   172: aload_3
    //   173: ifnull +10 -> 183
    //   176: aload_3
    //   177: invokevirtual 288	java/io/InputStream:close	()V
    //   180: goto +3 -> 183
    //   183: aload 5
    //   185: ifnull +8 -> 193
    //   188: aload 5
    //   190: invokevirtual 154	java/net/HttpURLConnection:disconnect	()V
    //   193: aload_1
    //   194: athrow
    //   195: astore_1
    //   196: goto -93 -> 103
    //   199: astore_2
    //   200: goto -38 -> 162
    //   203: astore_2
    //   204: goto -21 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	HttpUrlConnectionNetworkFetcher
    //   0	207	1	paramHttpUrlConnectionNetworkFetchState	HttpUrlConnectionNetworkFetchState
    //   0	207	2	paramCallback	NetworkFetcher.Callback
    //   10	70	3	localObject1	Object
    //   114	5	3	localIOException1	IOException
    //   137	40	3	localObject2	Object
    //   23	97	4	localObject3	Object
    //   131	12	4	localIOException2	IOException
    //   34	155	5	localObject4	Object
    //   4	151	6	localObject5	Object
    //   1	58	7	localObject6	Object
    //   7	56	8	localObject7	Object
    //   12	39	9	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   36	50	114	java/io/IOException
    //   69	75	114	java/io/IOException
    //   84	92	114	java/io/IOException
    //   14	25	124	finally
    //   14	25	131	java/io/IOException
    //   36	50	171	finally
    //   69	75	171	finally
    //   84	92	171	finally
    //   141	149	171	finally
    //   96	100	195	java/io/IOException
    //   154	159	199	java/io/IOException
    //   176	180	203	java/io/IOException
  }
  
  public Map<String, String> getExtraMap(HttpUrlConnectionNetworkFetchState paramHttpUrlConnectionNetworkFetchState, int paramInt)
  {
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("queue_time", Long.toString(paramHttpUrlConnectionNetworkFetchState.responseTime - paramHttpUrlConnectionNetworkFetchState.submitTime));
    localHashMap.put("fetch_time", Long.toString(paramHttpUrlConnectionNetworkFetchState.fetchCompleteTime - paramHttpUrlConnectionNetworkFetchState.responseTime));
    localHashMap.put("total_time", Long.toString(paramHttpUrlConnectionNetworkFetchState.fetchCompleteTime - paramHttpUrlConnectionNetworkFetchState.submitTime));
    localHashMap.put("image_size", Integer.toString(paramInt));
    return localHashMap;
  }
  
  public void onFetchCompletion(HttpUrlConnectionNetworkFetchState paramHttpUrlConnectionNetworkFetchState, int paramInt)
  {
    HttpUrlConnectionNetworkFetchState.access$202(paramHttpUrlConnectionNetworkFetchState, this.mMonotonicClock.now());
  }
  
  public static class HttpUrlConnectionNetworkFetchState
    extends FetchState
  {
    private long fetchCompleteTime;
    private long responseTime;
    private long submitTime;
    
    public HttpUrlConnectionNetworkFetchState(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
    {
      super(paramProducerContext);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\HttpUrlConnectionNetworkFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */