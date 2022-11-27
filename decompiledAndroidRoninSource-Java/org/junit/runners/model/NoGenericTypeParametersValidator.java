package org.junit.runners.model;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.List;

class NoGenericTypeParametersValidator
{
  private final Method method;
  
  NoGenericTypeParametersValidator(Method paramMethod)
  {
    this.method = paramMethod;
  }
  
  private void validateNoTypeParameterOnGenericArrayType(GenericArrayType paramGenericArrayType, List<Throwable> paramList)
  {
    validateNoTypeParameterOnType(paramGenericArrayType.getGenericComponentType(), paramList);
  }
  
  private void validateNoTypeParameterOnParameterizedType(ParameterizedType paramParameterizedType, List<Throwable> paramList)
  {
    paramParameterizedType = paramParameterizedType.getActualTypeArguments();
    int j = paramParameterizedType.length;
    int i = 0;
    while (i < j)
    {
      validateNoTypeParameterOnType(paramParameterizedType[i], paramList);
      i += 1;
    }
  }
  
  private void validateNoTypeParameterOnType(Type paramType, List<Throwable> paramList)
  {
    if ((paramType instanceof TypeVariable))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Method ");
      localStringBuilder.append(this.method.getName());
      localStringBuilder.append("() contains unresolved type variable ");
      localStringBuilder.append(paramType);
      paramList.add(new Exception(localStringBuilder.toString()));
      return;
    }
    if ((paramType instanceof ParameterizedType))
    {
      validateNoTypeParameterOnParameterizedType((ParameterizedType)paramType, paramList);
      return;
    }
    if ((paramType instanceof WildcardType))
    {
      validateNoTypeParameterOnWildcardType((WildcardType)paramType, paramList);
      return;
    }
    if ((paramType instanceof GenericArrayType)) {
      validateNoTypeParameterOnGenericArrayType((GenericArrayType)paramType, paramList);
    }
  }
  
  private void validateNoTypeParameterOnWildcardType(WildcardType paramWildcardType, List<Throwable> paramList)
  {
    Type[] arrayOfType = paramWildcardType.getUpperBounds();
    int k = arrayOfType.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      validateNoTypeParameterOnType(arrayOfType[i], paramList);
      i += 1;
    }
    paramWildcardType = paramWildcardType.getLowerBounds();
    k = paramWildcardType.length;
    i = j;
    while (i < k)
    {
      validateNoTypeParameterOnType(paramWildcardType[i], paramList);
      i += 1;
    }
  }
  
  void validate(List<Throwable> paramList)
  {
    Type[] arrayOfType = this.method.getGenericParameterTypes();
    int j = arrayOfType.length;
    int i = 0;
    while (i < j)
    {
      validateNoTypeParameterOnType(arrayOfType[i], paramList);
      i += 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\runners\model\NoGenericTypeParametersValidator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */