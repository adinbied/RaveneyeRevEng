package com.google.firebase.crashlytics.internal.network;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl.Builder;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Builder;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;

public class HttpRequest
{
  private static final OkHttpClient CLIENT = new OkHttpClient().newBuilder().callTimeout(10000L, TimeUnit.MILLISECONDS).build();
  private static final int DEFAULT_TIMEOUT_MS = 10000;
  private MultipartBody.Builder bodyBuilder = null;
  private final Map<String, String> headers;
  private final HttpMethod method;
  private final Map<String, String> queryParams;
  private final String url;
  
  public HttpRequest(HttpMethod paramHttpMethod, String paramString, Map<String, String> paramMap)
  {
    this.method = paramHttpMethod;
    this.url = paramString;
    this.queryParams = paramMap;
    this.headers = new HashMap();
  }
  
  private Request build()
  {
    Object localObject2 = new Request.Builder().cacheControl(new CacheControl.Builder().noCache().build());
    Object localObject1 = HttpUrl.parse(this.url).newBuilder();
    Object localObject3 = this.queryParams.entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
      localObject1 = ((HttpUrl.Builder)localObject1).addEncodedQueryParameter((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    localObject1 = ((Request.Builder)localObject2).url(((HttpUrl.Builder)localObject1).build());
    localObject2 = this.headers.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      localObject1 = ((Request.Builder)localObject1).header((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
    }
    localObject2 = this.bodyBuilder;
    if (localObject2 == null) {
      localObject2 = null;
    } else {
      localObject2 = ((MultipartBody.Builder)localObject2).build();
    }
    return ((Request.Builder)localObject1).method(this.method.name(), (RequestBody)localObject2).build();
  }
  
  private MultipartBody.Builder getOrCreateBodyBuilder()
  {
    if (this.bodyBuilder == null) {
      this.bodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
    }
    return this.bodyBuilder;
  }
  
  public HttpResponse execute()
    throws IOException
  {
    Request localRequest = build();
    return HttpResponse.create(CLIENT.newCall(localRequest).execute());
  }
  
  public HttpRequest header(String paramString1, String paramString2)
  {
    this.headers.put(paramString1, paramString2);
    return this;
  }
  
  public HttpRequest header(Map.Entry<String, String> paramEntry)
  {
    return header((String)paramEntry.getKey(), (String)paramEntry.getValue());
  }
  
  public String method()
  {
    return this.method.name();
  }
  
  public HttpRequest part(String paramString1, String paramString2)
  {
    this.bodyBuilder = getOrCreateBodyBuilder().addFormDataPart(paramString1, paramString2);
    return this;
  }
  
  public HttpRequest part(String paramString1, String paramString2, String paramString3, File paramFile)
  {
    paramString3 = RequestBody.create(MediaType.parse(paramString3), paramFile);
    this.bodyBuilder = getOrCreateBodyBuilder().addFormDataPart(paramString1, paramString2, paramString3);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\network\HttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */