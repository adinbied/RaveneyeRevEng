package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import kotlin.coroutines.Continuation;
import okhttp3.Call.Factory;
import okhttp3.ResponseBody;

abstract class HttpServiceMethod<ResponseT, ReturnT>
  extends ServiceMethod<ReturnT>
{
  private final Call.Factory callFactory;
  private final RequestFactory requestFactory;
  private final Converter<ResponseBody, ResponseT> responseConverter;
  
  HttpServiceMethod(RequestFactory paramRequestFactory, Call.Factory paramFactory, Converter<ResponseBody, ResponseT> paramConverter)
  {
    this.requestFactory = paramRequestFactory;
    this.callFactory = paramFactory;
    this.responseConverter = paramConverter;
  }
  
  private static <ResponseT, ReturnT> CallAdapter<ResponseT, ReturnT> createCallAdapter(Retrofit paramRetrofit, Method paramMethod, Type paramType, Annotation[] paramArrayOfAnnotation)
  {
    try
    {
      paramRetrofit = paramRetrofit.callAdapter(paramType, paramArrayOfAnnotation);
      return paramRetrofit;
    }
    catch (RuntimeException paramRetrofit)
    {
      throw Utils.methodError(paramMethod, paramRetrofit, "Unable to create call adapter for %s", new Object[] { paramType });
    }
  }
  
  private static <ResponseT> Converter<ResponseBody, ResponseT> createResponseConverter(Retrofit paramRetrofit, Method paramMethod, Type paramType)
  {
    Annotation[] arrayOfAnnotation = paramMethod.getAnnotations();
    try
    {
      paramRetrofit = paramRetrofit.responseBodyConverter(paramType, arrayOfAnnotation);
      return paramRetrofit;
    }
    catch (RuntimeException paramRetrofit)
    {
      throw Utils.methodError(paramMethod, paramRetrofit, "Unable to create converter for %s", new Object[] { paramType });
    }
  }
  
  static <ResponseT, ReturnT> HttpServiceMethod<ResponseT, ReturnT> parseAnnotations(Retrofit paramRetrofit, Method paramMethod, RequestFactory paramRequestFactory)
  {
    boolean bool = paramRequestFactory.isKotlinSuspendFunction;
    Annotation[] arrayOfAnnotation = paramMethod.getAnnotations();
    int i;
    if (bool)
    {
      localObject1 = paramMethod.getGenericParameterTypes();
      localObject1 = Utils.getParameterLowerBound(0, (ParameterizedType)localObject1[(localObject1.length - 1)]);
      if ((Utils.getRawType((Type)localObject1) == Response.class) && ((localObject1 instanceof ParameterizedType)))
      {
        localObject1 = Utils.getParameterUpperBound(0, (ParameterizedType)localObject1);
        i = 1;
      }
      else
      {
        i = 0;
      }
      localObject2 = new Utils.ParameterizedTypeImpl(null, Call.class, new Type[] { localObject1 });
      localObject1 = SkipCallbackExecutorImpl.ensurePresent(arrayOfAnnotation);
    }
    else
    {
      localObject2 = paramMethod.getGenericReturnType();
      i = 0;
      localObject1 = arrayOfAnnotation;
    }
    Object localObject1 = createCallAdapter(paramRetrofit, paramMethod, (Type)localObject2, (Annotation[])localObject1);
    Object localObject2 = ((CallAdapter)localObject1).responseType();
    if (localObject2 != okhttp3.Response.class)
    {
      if (localObject2 != Response.class)
      {
        if ((paramRequestFactory.httpMethod.equals("HEAD")) && (!Void.class.equals(localObject2))) {
          throw Utils.methodError(paramMethod, "HEAD method must use Void as response type.", new Object[0]);
        }
        paramMethod = createResponseConverter(paramRetrofit, paramMethod, (Type)localObject2);
        paramRetrofit = paramRetrofit.callFactory;
        if (!bool) {
          return new CallAdapted(paramRequestFactory, paramRetrofit, paramMethod, (CallAdapter)localObject1);
        }
        if (i != 0) {
          return new SuspendForResponse(paramRequestFactory, paramRetrofit, paramMethod, (CallAdapter)localObject1);
        }
        return new SuspendForBody(paramRequestFactory, paramRetrofit, paramMethod, (CallAdapter)localObject1, false);
      }
      throw Utils.methodError(paramMethod, "Response must include generic type (e.g., Response<String>)", new Object[0]);
    }
    paramRetrofit = new StringBuilder();
    paramRetrofit.append("'");
    paramRetrofit.append(Utils.getRawType((Type)localObject2).getName());
    paramRetrofit.append("' is not a valid response body type. Did you mean ResponseBody?");
    throw Utils.methodError(paramMethod, paramRetrofit.toString(), new Object[0]);
  }
  
  @Nullable
  protected abstract ReturnT adapt(Call<ResponseT> paramCall, Object[] paramArrayOfObject);
  
  @Nullable
  final ReturnT invoke(Object[] paramArrayOfObject)
  {
    return (ReturnT)adapt(new OkHttpCall(this.requestFactory, paramArrayOfObject, this.callFactory, this.responseConverter), paramArrayOfObject);
  }
  
  static final class CallAdapted<ResponseT, ReturnT>
    extends HttpServiceMethod<ResponseT, ReturnT>
  {
    private final CallAdapter<ResponseT, ReturnT> callAdapter;
    
    CallAdapted(RequestFactory paramRequestFactory, Call.Factory paramFactory, Converter<ResponseBody, ResponseT> paramConverter, CallAdapter<ResponseT, ReturnT> paramCallAdapter)
    {
      super(paramFactory, paramConverter);
      this.callAdapter = paramCallAdapter;
    }
    
    protected ReturnT adapt(Call<ResponseT> paramCall, Object[] paramArrayOfObject)
    {
      return (ReturnT)this.callAdapter.adapt(paramCall);
    }
  }
  
  static final class SuspendForBody<ResponseT>
    extends HttpServiceMethod<ResponseT, Object>
  {
    private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;
    private final boolean isNullable;
    
    SuspendForBody(RequestFactory paramRequestFactory, Call.Factory paramFactory, Converter<ResponseBody, ResponseT> paramConverter, CallAdapter<ResponseT, Call<ResponseT>> paramCallAdapter, boolean paramBoolean)
    {
      super(paramFactory, paramConverter);
      this.callAdapter = paramCallAdapter;
      this.isNullable = paramBoolean;
    }
    
    protected Object adapt(Call<ResponseT> paramCall, Object[] paramArrayOfObject)
    {
      Call localCall = (Call)this.callAdapter.adapt(paramCall);
      paramCall = (Continuation)paramArrayOfObject[(paramArrayOfObject.length - 1)];
      try
      {
        if (this.isNullable) {
          return KotlinExtensions.awaitNullable(localCall, paramCall);
        }
        paramArrayOfObject = KotlinExtensions.await(localCall, paramCall);
        return paramArrayOfObject;
      }
      catch (Exception paramArrayOfObject) {}
      return KotlinExtensions.suspendAndThrow(paramArrayOfObject, paramCall);
    }
  }
  
  static final class SuspendForResponse<ResponseT>
    extends HttpServiceMethod<ResponseT, Object>
  {
    private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;
    
    SuspendForResponse(RequestFactory paramRequestFactory, Call.Factory paramFactory, Converter<ResponseBody, ResponseT> paramConverter, CallAdapter<ResponseT, Call<ResponseT>> paramCallAdapter)
    {
      super(paramFactory, paramConverter);
      this.callAdapter = paramCallAdapter;
    }
    
    protected Object adapt(Call<ResponseT> paramCall, Object[] paramArrayOfObject)
    {
      Call localCall = (Call)this.callAdapter.adapt(paramCall);
      paramCall = (Continuation)paramArrayOfObject[(paramArrayOfObject.length - 1)];
      try
      {
        paramArrayOfObject = KotlinExtensions.awaitResponse(localCall, paramCall);
        return paramArrayOfObject;
      }
      catch (Exception paramArrayOfObject) {}
      return KotlinExtensions.suspendAndThrow(paramArrayOfObject, paramCall);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\retrofit2\HttpServiceMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */