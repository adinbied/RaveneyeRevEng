package dji.thirdparty.retrofit2;

import dji.thirdparty.okhttp3.Call.Factory;
import dji.thirdparty.okhttp3.Headers;
import dji.thirdparty.okhttp3.HttpUrl;
import dji.thirdparty.okhttp3.MediaType;
import dji.thirdparty.okhttp3.Request;
import dji.thirdparty.okhttp3.ResponseBody;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class ServiceMethod<T>
{
  static final String PARAM = "[a-zA-Z][a-zA-Z0-9_-]*";
  static final Pattern PARAM_NAME_REGEX = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
  static final Pattern PARAM_URL_REGEX = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
  private final HttpUrl baseUrl;
  final CallAdapter<?> callAdapter;
  final Call.Factory callFactory;
  private final MediaType contentType;
  private final boolean hasBody;
  private final Headers headers;
  private final String httpMethod;
  private final boolean isFormEncoded;
  private final boolean isMultipart;
  private final ParameterHandler<?>[] parameterHandlers;
  private final String relativeUrl;
  private final Converter<ResponseBody, T> responseConverter;
  
  ServiceMethod(Builder<T> paramBuilder)
  {
    this.callFactory = paramBuilder.retrofit.callFactory();
    this.callAdapter = paramBuilder.callAdapter;
    this.baseUrl = paramBuilder.retrofit.baseUrl();
    this.responseConverter = paramBuilder.responseConverter;
    this.httpMethod = paramBuilder.httpMethod;
    this.relativeUrl = paramBuilder.relativeUrl;
    this.headers = paramBuilder.headers;
    this.contentType = paramBuilder.contentType;
    this.hasBody = paramBuilder.hasBody;
    this.isFormEncoded = paramBuilder.isFormEncoded;
    this.isMultipart = paramBuilder.isMultipart;
    this.parameterHandlers = paramBuilder.parameterHandlers;
  }
  
  static Class<?> boxIfPrimitive(Class<?> paramClass)
  {
    if (Boolean.TYPE == paramClass) {
      return Boolean.class;
    }
    if (Byte.TYPE == paramClass) {
      return Byte.class;
    }
    if (Character.TYPE == paramClass) {
      return Character.class;
    }
    if (Double.TYPE == paramClass) {
      return Double.class;
    }
    if (Float.TYPE == paramClass) {
      return Float.class;
    }
    if (Integer.TYPE == paramClass) {
      return Integer.class;
    }
    if (Long.TYPE == paramClass) {
      return Long.class;
    }
    Object localObject = paramClass;
    if (Short.TYPE == paramClass) {
      localObject = Short.class;
    }
    return (Class<?>)localObject;
  }
  
  static Set<String> parsePathParameters(String paramString)
  {
    paramString = PARAM_URL_REGEX.matcher(paramString);
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    while (paramString.find()) {
      localLinkedHashSet.add(paramString.group(1));
    }
    return localLinkedHashSet;
  }
  
  Request toRequest(Object... paramVarArgs)
    throws IOException
  {
    return null;
  }
  
  T toResponse(ResponseBody paramResponseBody)
    throws IOException
  {
    return (T)this.responseConverter.convert(paramResponseBody);
  }
  
  static final class Builder<T>
  {
    CallAdapter<?> callAdapter;
    MediaType contentType;
    boolean gotBody;
    boolean gotField;
    boolean gotPart;
    boolean gotPath;
    boolean gotQuery;
    boolean gotUrl;
    boolean hasBody;
    Headers headers;
    String httpMethod;
    boolean isFormEncoded;
    boolean isMultipart;
    final Method method;
    final Annotation[] methodAnnotations;
    final Annotation[][] parameterAnnotationsArray;
    ParameterHandler<?>[] parameterHandlers;
    final Type[] parameterTypes;
    String relativeUrl;
    Set<String> relativeUrlParamNames;
    Converter<ResponseBody, T> responseConverter;
    Type responseType;
    final Retrofit retrofit;
    
    public Builder(Retrofit paramRetrofit, Method paramMethod)
    {
      this.retrofit = paramRetrofit;
      this.method = paramMethod;
      this.methodAnnotations = paramMethod.getAnnotations();
      this.parameterTypes = paramMethod.getGenericParameterTypes();
      this.parameterAnnotationsArray = paramMethod.getParameterAnnotations();
    }
    
    private CallAdapter<?> createCallAdapter()
    {
      return null;
    }
    
    private Converter<ResponseBody, T> createResponseConverter()
    {
      return null;
    }
    
    private RuntimeException methodError(String paramString, Object... paramVarArgs)
    {
      return methodError(null, paramString, paramVarArgs);
    }
    
    private RuntimeException methodError(Throwable paramThrowable, String paramString, Object... paramVarArgs)
    {
      return null;
    }
    
    private RuntimeException parameterError(int paramInt, String paramString, Object... paramVarArgs)
    {
      return null;
    }
    
    private RuntimeException parameterError(Throwable paramThrowable, int paramInt, String paramString, Object... paramVarArgs)
    {
      return null;
    }
    
    private Headers parseHeaders(String[] paramArrayOfString)
    {
      return null;
    }
    
    /* Error */
    private void parseHttpMethodAndPath(String arg1, String arg2, boolean arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void parseMethodAnnotation(Annotation arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    private ParameterHandler<?> parseParameter(int paramInt, Type paramType, Annotation[] paramArrayOfAnnotation)
    {
      return null;
    }
    
    private ParameterHandler<?> parseParameterAnnotation(int paramInt, Type paramType, Annotation[] paramArrayOfAnnotation, Annotation paramAnnotation)
    {
      return null;
    }
    
    /* Error */
    private void validatePathName(int arg1, String arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    public ServiceMethod build()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\retrofit2\ServiceMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */