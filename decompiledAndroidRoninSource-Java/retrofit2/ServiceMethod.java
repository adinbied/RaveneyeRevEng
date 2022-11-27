package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

abstract class ServiceMethod<T>
{
  static <T> ServiceMethod<T> parseAnnotations(Retrofit paramRetrofit, Method paramMethod)
  {
    RequestFactory localRequestFactory = RequestFactory.parseAnnotations(paramRetrofit, paramMethod);
    Type localType = paramMethod.getGenericReturnType();
    if (!Utils.hasUnresolvableType(localType))
    {
      if (localType != Void.TYPE) {
        return HttpServiceMethod.parseAnnotations(paramRetrofit, paramMethod, localRequestFactory);
      }
      throw Utils.methodError(paramMethod, "Service methods cannot return void.", new Object[0]);
    }
    throw Utils.methodError(paramMethod, "Method return type must not include a type variable or wildcard: %s", new Object[] { localType });
  }
  
  @Nullable
  abstract T invoke(Object[] paramArrayOfObject);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\retrofit2\ServiceMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */