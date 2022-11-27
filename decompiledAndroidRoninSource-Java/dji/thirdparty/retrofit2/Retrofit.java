package dji.thirdparty.retrofit2;

import dji.thirdparty.okhttp3.Call.Factory;
import dji.thirdparty.okhttp3.HttpUrl;
import dji.thirdparty.okhttp3.OkHttpClient;
import dji.thirdparty.okhttp3.RequestBody;
import dji.thirdparty.okhttp3.ResponseBody;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

public final class Retrofit
{
  private final List<CallAdapter.Factory> adapterFactories;
  private final HttpUrl baseUrl;
  private final Call.Factory callFactory;
  private final Executor callbackExecutor;
  private final List<Converter.Factory> converterFactories;
  private final Map<Method, ServiceMethod> serviceMethodCache = new LinkedHashMap();
  private final boolean validateEagerly;
  
  Retrofit(Call.Factory paramFactory, HttpUrl paramHttpUrl, List<Converter.Factory> paramList, List<CallAdapter.Factory> paramList1, Executor paramExecutor, boolean paramBoolean)
  {
    this.callFactory = paramFactory;
    this.baseUrl = paramHttpUrl;
    this.converterFactories = Collections.unmodifiableList(paramList);
    this.adapterFactories = Collections.unmodifiableList(paramList1);
    this.callbackExecutor = paramExecutor;
    this.validateEagerly = paramBoolean;
  }
  
  /* Error */
  private void eagerlyValidateMethods(Class<?> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public HttpUrl baseUrl()
  {
    return this.baseUrl;
  }
  
  public CallAdapter<?> callAdapter(Type paramType, Annotation[] paramArrayOfAnnotation)
  {
    return nextCallAdapter(null, paramType, paramArrayOfAnnotation);
  }
  
  public List<CallAdapter.Factory> callAdapterFactories()
  {
    return this.adapterFactories;
  }
  
  public Call.Factory callFactory()
  {
    return this.callFactory;
  }
  
  public Executor callbackExecutor()
  {
    return this.callbackExecutor;
  }
  
  public List<Converter.Factory> converterFactories()
  {
    return this.converterFactories;
  }
  
  public <T> T create(Class<T> paramClass)
  {
    return null;
  }
  
  ServiceMethod loadServiceMethod(Method paramMethod)
  {
    return null;
  }
  
  public CallAdapter<?> nextCallAdapter(CallAdapter.Factory paramFactory, Type paramType, Annotation[] paramArrayOfAnnotation)
  {
    return null;
  }
  
  public <T> Converter<T, RequestBody> nextRequestBodyConverter(Converter.Factory paramFactory, Type paramType, Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2)
  {
    return null;
  }
  
  public <T> Converter<ResponseBody, T> nextResponseBodyConverter(Converter.Factory paramFactory, Type paramType, Annotation[] paramArrayOfAnnotation)
  {
    return null;
  }
  
  public <T> Converter<T, RequestBody> requestBodyConverter(Type paramType, Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2)
  {
    return nextRequestBodyConverter(null, paramType, paramArrayOfAnnotation1, paramArrayOfAnnotation2);
  }
  
  public <T> Converter<ResponseBody, T> responseBodyConverter(Type paramType, Annotation[] paramArrayOfAnnotation)
  {
    return nextResponseBodyConverter(null, paramType, paramArrayOfAnnotation);
  }
  
  public <T> Converter<T, String> stringConverter(Type paramType, Annotation[] paramArrayOfAnnotation)
  {
    return null;
  }
  
  public static final class Builder
  {
    private List<CallAdapter.Factory> adapterFactories = new ArrayList();
    private HttpUrl baseUrl;
    private Call.Factory callFactory;
    private Executor callbackExecutor;
    private List<Converter.Factory> converterFactories = new ArrayList();
    private Platform platform;
    private boolean validateEagerly;
    
    public Builder()
    {
      this(Platform.get());
    }
    
    Builder(Platform paramPlatform)
    {
      this.platform = paramPlatform;
      this.converterFactories.add(new BuiltInConverters());
    }
    
    public Builder addCallAdapterFactory(CallAdapter.Factory paramFactory)
    {
      return null;
    }
    
    public Builder addConverterFactory(Converter.Factory paramFactory)
    {
      return null;
    }
    
    public Builder baseUrl(HttpUrl paramHttpUrl)
    {
      return null;
    }
    
    public Builder baseUrl(String paramString)
    {
      return null;
    }
    
    public Retrofit build()
    {
      return null;
    }
    
    public Builder callFactory(Call.Factory paramFactory)
    {
      return null;
    }
    
    public Builder callbackExecutor(Executor paramExecutor)
    {
      return null;
    }
    
    public Builder client(OkHttpClient paramOkHttpClient)
    {
      return null;
    }
    
    public Builder validateEagerly(boolean paramBoolean)
    {
      this.validateEagerly = paramBoolean;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\retrofit2\Retrofit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */