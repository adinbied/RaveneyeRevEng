package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Call.Factory;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public final class Retrofit
{
  final HttpUrl baseUrl;
  final List<CallAdapter.Factory> callAdapterFactories;
  final Call.Factory callFactory;
  @Nullable
  final Executor callbackExecutor;
  final List<Converter.Factory> converterFactories;
  private final Map<Method, ServiceMethod<?>> serviceMethodCache = new ConcurrentHashMap();
  final boolean validateEagerly;
  
  Retrofit(Call.Factory paramFactory, HttpUrl paramHttpUrl, List<Converter.Factory> paramList, List<CallAdapter.Factory> paramList1, @Nullable Executor paramExecutor, boolean paramBoolean)
  {
    this.callFactory = paramFactory;
    this.baseUrl = paramHttpUrl;
    this.converterFactories = paramList;
    this.callAdapterFactories = paramList1;
    this.callbackExecutor = paramExecutor;
    this.validateEagerly = paramBoolean;
  }
  
  private void validateServiceInterface(Class<?> paramClass)
  {
    if (paramClass.isInterface())
    {
      Object localObject2 = new ArrayDeque(1);
      ((Deque)localObject2).add(paramClass);
      Object localObject1;
      while (!((Deque)localObject2).isEmpty())
      {
        localObject1 = (Class)((Deque)localObject2).removeFirst();
        if (((Class)localObject1).getTypeParameters().length != 0)
        {
          localObject2 = new StringBuilder("Type parameters are unsupported on ");
          ((StringBuilder)localObject2).append(((Class)localObject1).getName());
          if (localObject1 != paramClass)
          {
            ((StringBuilder)localObject2).append(" which is an interface of ");
            ((StringBuilder)localObject2).append(paramClass.getName());
          }
          throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
        }
        Collections.addAll((Collection)localObject2, ((Class)localObject1).getInterfaces());
      }
      if (this.validateEagerly)
      {
        localObject1 = Platform.get();
        paramClass = paramClass.getDeclaredMethods();
        int j = paramClass.length;
        int i = 0;
        while (i < j)
        {
          localObject2 = paramClass[i];
          if ((!((Platform)localObject1).isDefaultMethod((Method)localObject2)) && (!Modifier.isStatic(((Method)localObject2).getModifiers()))) {
            loadServiceMethod((Method)localObject2);
          }
          i += 1;
        }
      }
      return;
    }
    throw new IllegalArgumentException("API declarations must be interfaces.");
  }
  
  public HttpUrl baseUrl()
  {
    return this.baseUrl;
  }
  
  public CallAdapter<?, ?> callAdapter(Type paramType, Annotation[] paramArrayOfAnnotation)
  {
    return nextCallAdapter(null, paramType, paramArrayOfAnnotation);
  }
  
  public List<CallAdapter.Factory> callAdapterFactories()
  {
    return this.callAdapterFactories;
  }
  
  public Call.Factory callFactory()
  {
    return this.callFactory;
  }
  
  @Nullable
  public Executor callbackExecutor()
  {
    return this.callbackExecutor;
  }
  
  public List<Converter.Factory> converterFactories()
  {
    return this.converterFactories;
  }
  
  public <T> T create(final Class<T> paramClass)
  {
    validateServiceInterface(paramClass);
    ClassLoader localClassLoader = paramClass.getClassLoader();
    InvocationHandler local1 = new InvocationHandler()
    {
      private final Object[] emptyArgs = new Object[0];
      private final Platform platform = Platform.get();
      
      @Nullable
      public Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, @Nullable Object[] paramAnonymousArrayOfObject)
        throws Throwable
      {
        if (paramAnonymousMethod.getDeclaringClass() == Object.class) {
          return paramAnonymousMethod.invoke(this, paramAnonymousArrayOfObject);
        }
        if (paramAnonymousArrayOfObject == null) {
          paramAnonymousArrayOfObject = this.emptyArgs;
        }
        if (this.platform.isDefaultMethod(paramAnonymousMethod)) {
          return this.platform.invokeDefaultMethod(paramAnonymousMethod, paramClass, paramAnonymousObject, paramAnonymousArrayOfObject);
        }
        return this.this$0.loadServiceMethod(paramAnonymousMethod).invoke(paramAnonymousArrayOfObject);
      }
    };
    return (T)Proxy.newProxyInstance(localClassLoader, new Class[] { paramClass }, local1);
  }
  
  ServiceMethod<?> loadServiceMethod(Method paramMethod)
  {
    Object localObject = (ServiceMethod)this.serviceMethodCache.get(paramMethod);
    if (localObject != null) {
      return (ServiceMethod<?>)localObject;
    }
    synchronized (this.serviceMethodCache)
    {
      ServiceMethod localServiceMethod = (ServiceMethod)this.serviceMethodCache.get(paramMethod);
      localObject = localServiceMethod;
      if (localServiceMethod == null)
      {
        localObject = ServiceMethod.parseAnnotations(this, paramMethod);
        this.serviceMethodCache.put(paramMethod, localObject);
      }
      return (ServiceMethod<?>)localObject;
    }
  }
  
  public Builder newBuilder()
  {
    return new Builder(this);
  }
  
  public CallAdapter<?, ?> nextCallAdapter(@Nullable CallAdapter.Factory paramFactory, Type paramType, Annotation[] paramArrayOfAnnotation)
  {
    Objects.requireNonNull(paramType, "returnType == null");
    Objects.requireNonNull(paramArrayOfAnnotation, "annotations == null");
    int i = this.callAdapterFactories.indexOf(paramFactory) + 1;
    int k = this.callAdapterFactories.size();
    int j = i;
    while (j < k)
    {
      CallAdapter localCallAdapter = ((CallAdapter.Factory)this.callAdapterFactories.get(j)).get(paramType, paramArrayOfAnnotation, this);
      if (localCallAdapter != null) {
        return localCallAdapter;
      }
      j += 1;
    }
    paramArrayOfAnnotation = new StringBuilder("Could not locate call adapter for ");
    paramArrayOfAnnotation.append(paramType);
    paramArrayOfAnnotation.append(".\n");
    if (paramFactory != null)
    {
      paramArrayOfAnnotation.append("  Skipped:");
      j = 0;
      while (j < i)
      {
        paramArrayOfAnnotation.append("\n   * ");
        paramArrayOfAnnotation.append(((CallAdapter.Factory)this.callAdapterFactories.get(j)).getClass().getName());
        j += 1;
      }
      paramArrayOfAnnotation.append('\n');
    }
    paramArrayOfAnnotation.append("  Tried:");
    j = this.callAdapterFactories.size();
    while (i < j)
    {
      paramArrayOfAnnotation.append("\n   * ");
      paramArrayOfAnnotation.append(((CallAdapter.Factory)this.callAdapterFactories.get(i)).getClass().getName());
      i += 1;
    }
    throw new IllegalArgumentException(paramArrayOfAnnotation.toString());
  }
  
  public <T> Converter<T, RequestBody> nextRequestBodyConverter(@Nullable Converter.Factory paramFactory, Type paramType, Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2)
  {
    Objects.requireNonNull(paramType, "type == null");
    Objects.requireNonNull(paramArrayOfAnnotation1, "parameterAnnotations == null");
    Objects.requireNonNull(paramArrayOfAnnotation2, "methodAnnotations == null");
    int i = this.converterFactories.indexOf(paramFactory) + 1;
    int k = this.converterFactories.size();
    int j = i;
    while (j < k)
    {
      Converter localConverter = ((Converter.Factory)this.converterFactories.get(j)).requestBodyConverter(paramType, paramArrayOfAnnotation1, paramArrayOfAnnotation2, this);
      if (localConverter != null) {
        return localConverter;
      }
      j += 1;
    }
    paramArrayOfAnnotation1 = new StringBuilder("Could not locate RequestBody converter for ");
    paramArrayOfAnnotation1.append(paramType);
    paramArrayOfAnnotation1.append(".\n");
    if (paramFactory != null)
    {
      paramArrayOfAnnotation1.append("  Skipped:");
      j = 0;
      while (j < i)
      {
        paramArrayOfAnnotation1.append("\n   * ");
        paramArrayOfAnnotation1.append(((Converter.Factory)this.converterFactories.get(j)).getClass().getName());
        j += 1;
      }
      paramArrayOfAnnotation1.append('\n');
    }
    paramArrayOfAnnotation1.append("  Tried:");
    j = this.converterFactories.size();
    while (i < j)
    {
      paramArrayOfAnnotation1.append("\n   * ");
      paramArrayOfAnnotation1.append(((Converter.Factory)this.converterFactories.get(i)).getClass().getName());
      i += 1;
    }
    throw new IllegalArgumentException(paramArrayOfAnnotation1.toString());
  }
  
  public <T> Converter<ResponseBody, T> nextResponseBodyConverter(@Nullable Converter.Factory paramFactory, Type paramType, Annotation[] paramArrayOfAnnotation)
  {
    Objects.requireNonNull(paramType, "type == null");
    Objects.requireNonNull(paramArrayOfAnnotation, "annotations == null");
    int i = this.converterFactories.indexOf(paramFactory) + 1;
    int k = this.converterFactories.size();
    int j = i;
    while (j < k)
    {
      Converter localConverter = ((Converter.Factory)this.converterFactories.get(j)).responseBodyConverter(paramType, paramArrayOfAnnotation, this);
      if (localConverter != null) {
        return localConverter;
      }
      j += 1;
    }
    paramArrayOfAnnotation = new StringBuilder("Could not locate ResponseBody converter for ");
    paramArrayOfAnnotation.append(paramType);
    paramArrayOfAnnotation.append(".\n");
    if (paramFactory != null)
    {
      paramArrayOfAnnotation.append("  Skipped:");
      j = 0;
      while (j < i)
      {
        paramArrayOfAnnotation.append("\n   * ");
        paramArrayOfAnnotation.append(((Converter.Factory)this.converterFactories.get(j)).getClass().getName());
        j += 1;
      }
      paramArrayOfAnnotation.append('\n');
    }
    paramArrayOfAnnotation.append("  Tried:");
    j = this.converterFactories.size();
    while (i < j)
    {
      paramArrayOfAnnotation.append("\n   * ");
      paramArrayOfAnnotation.append(((Converter.Factory)this.converterFactories.get(i)).getClass().getName());
      i += 1;
    }
    throw new IllegalArgumentException(paramArrayOfAnnotation.toString());
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
    Objects.requireNonNull(paramType, "type == null");
    Objects.requireNonNull(paramArrayOfAnnotation, "annotations == null");
    int j = this.converterFactories.size();
    int i = 0;
    while (i < j)
    {
      Converter localConverter = ((Converter.Factory)this.converterFactories.get(i)).stringConverter(paramType, paramArrayOfAnnotation, this);
      if (localConverter != null) {
        return localConverter;
      }
      i += 1;
    }
    return BuiltInConverters.ToStringConverter.INSTANCE;
  }
  
  public static final class Builder
  {
    @Nullable
    private HttpUrl baseUrl;
    private final List<CallAdapter.Factory> callAdapterFactories = new ArrayList();
    @Nullable
    private Call.Factory callFactory;
    @Nullable
    private Executor callbackExecutor;
    private final List<Converter.Factory> converterFactories = new ArrayList();
    private final Platform platform;
    private boolean validateEagerly;
    
    public Builder()
    {
      this(Platform.get());
    }
    
    Builder(Platform paramPlatform)
    {
      this.platform = paramPlatform;
    }
    
    Builder(Retrofit paramRetrofit)
    {
      this.platform = Platform.get();
      this.callFactory = paramRetrofit.callFactory;
      this.baseUrl = paramRetrofit.baseUrl;
      int j = paramRetrofit.converterFactories.size();
      int k = this.platform.defaultConverterFactoriesSize();
      int i = 1;
      while (i < j - k)
      {
        this.converterFactories.add((Converter.Factory)paramRetrofit.converterFactories.get(i));
        i += 1;
      }
      i = 0;
      j = paramRetrofit.callAdapterFactories.size();
      k = this.platform.defaultCallAdapterFactoriesSize();
      while (i < j - k)
      {
        this.callAdapterFactories.add((CallAdapter.Factory)paramRetrofit.callAdapterFactories.get(i));
        i += 1;
      }
      this.callbackExecutor = paramRetrofit.callbackExecutor;
      this.validateEagerly = paramRetrofit.validateEagerly;
    }
    
    public Builder addCallAdapterFactory(CallAdapter.Factory paramFactory)
    {
      this.callAdapterFactories.add((CallAdapter.Factory)Objects.requireNonNull(paramFactory, "factory == null"));
      return this;
    }
    
    public Builder addConverterFactory(Converter.Factory paramFactory)
    {
      this.converterFactories.add((Converter.Factory)Objects.requireNonNull(paramFactory, "factory == null"));
      return this;
    }
    
    public Builder baseUrl(String paramString)
    {
      Objects.requireNonNull(paramString, "baseUrl == null");
      return baseUrl(HttpUrl.get(paramString));
    }
    
    public Builder baseUrl(URL paramURL)
    {
      Objects.requireNonNull(paramURL, "baseUrl == null");
      return baseUrl(HttpUrl.get(paramURL.toString()));
    }
    
    public Builder baseUrl(HttpUrl paramHttpUrl)
    {
      Objects.requireNonNull(paramHttpUrl, "baseUrl == null");
      Object localObject = paramHttpUrl.pathSegments();
      if ("".equals(((List)localObject).get(((List)localObject).size() - 1)))
      {
        this.baseUrl = paramHttpUrl;
        return this;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("baseUrl must end in /: ");
      ((StringBuilder)localObject).append(paramHttpUrl);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    public Retrofit build()
    {
      if (this.baseUrl != null)
      {
        Object localObject2 = this.callFactory;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new OkHttpClient();
        }
        Object localObject3 = this.callbackExecutor;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = this.platform.defaultCallbackExecutor();
        }
        localObject3 = new ArrayList(this.callAdapterFactories);
        ((List)localObject3).addAll(this.platform.defaultCallAdapterFactories((Executor)localObject2));
        ArrayList localArrayList = new ArrayList(this.converterFactories.size() + 1 + this.platform.defaultConverterFactoriesSize());
        localArrayList.add(new BuiltInConverters());
        localArrayList.addAll(this.converterFactories);
        localArrayList.addAll(this.platform.defaultConverterFactories());
        return new Retrofit((Call.Factory)localObject1, this.baseUrl, Collections.unmodifiableList(localArrayList), Collections.unmodifiableList((List)localObject3), (Executor)localObject2, this.validateEagerly);
      }
      throw new IllegalStateException("Base URL required.");
    }
    
    public List<CallAdapter.Factory> callAdapterFactories()
    {
      return this.callAdapterFactories;
    }
    
    public Builder callFactory(Call.Factory paramFactory)
    {
      this.callFactory = ((Call.Factory)Objects.requireNonNull(paramFactory, "factory == null"));
      return this;
    }
    
    public Builder callbackExecutor(Executor paramExecutor)
    {
      this.callbackExecutor = ((Executor)Objects.requireNonNull(paramExecutor, "executor == null"));
      return this;
    }
    
    public Builder client(OkHttpClient paramOkHttpClient)
    {
      return callFactory((Call.Factory)Objects.requireNonNull(paramOkHttpClient, "client == null"));
    }
    
    public List<Converter.Factory> converterFactories()
    {
      return this.converterFactories;
    }
    
    public Builder validateEagerly(boolean paramBoolean)
    {
      this.validateEagerly = paramBoolean;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\retrofit2\Retrofit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */