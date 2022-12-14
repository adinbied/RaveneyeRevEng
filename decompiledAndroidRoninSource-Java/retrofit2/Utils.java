package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

final class Utils
{
  static final Type[] EMPTY_TYPE_ARRAY = new Type[0];
  
  static ResponseBody buffer(ResponseBody paramResponseBody)
    throws IOException
  {
    Buffer localBuffer = new Buffer();
    paramResponseBody.source().readAll(localBuffer);
    return ResponseBody.create(paramResponseBody.contentType(), paramResponseBody.contentLength(), localBuffer);
  }
  
  static void checkNotPrimitive(Type paramType)
  {
    if ((paramType instanceof Class))
    {
      if (!((Class)paramType).isPrimitive()) {
        return;
      }
      throw new IllegalArgumentException();
    }
  }
  
  @Nullable
  private static Class<?> declaringClassOf(TypeVariable<?> paramTypeVariable)
  {
    paramTypeVariable = paramTypeVariable.getGenericDeclaration();
    if ((paramTypeVariable instanceof Class)) {
      return (Class)paramTypeVariable;
    }
    return null;
  }
  
  static boolean equals(Type paramType1, Type paramType2)
  {
    if (paramType1 == paramType2) {
      return true;
    }
    if ((paramType1 instanceof Class)) {
      return paramType1.equals(paramType2);
    }
    if ((paramType1 instanceof ParameterizedType))
    {
      if (!(paramType2 instanceof ParameterizedType)) {
        return false;
      }
      paramType1 = (ParameterizedType)paramType1;
      paramType2 = (ParameterizedType)paramType2;
      Type localType1 = paramType1.getOwnerType();
      Type localType2 = paramType2.getOwnerType();
      return ((localType1 == localType2) || ((localType1 != null) && (localType1.equals(localType2)))) && (paramType1.getRawType().equals(paramType2.getRawType())) && (Arrays.equals(paramType1.getActualTypeArguments(), paramType2.getActualTypeArguments()));
    }
    if ((paramType1 instanceof GenericArrayType))
    {
      if (!(paramType2 instanceof GenericArrayType)) {
        return false;
      }
      paramType1 = (GenericArrayType)paramType1;
      paramType2 = (GenericArrayType)paramType2;
      return equals(paramType1.getGenericComponentType(), paramType2.getGenericComponentType());
    }
    if ((paramType1 instanceof WildcardType))
    {
      if (!(paramType2 instanceof WildcardType)) {
        return false;
      }
      paramType1 = (WildcardType)paramType1;
      paramType2 = (WildcardType)paramType2;
      return (Arrays.equals(paramType1.getUpperBounds(), paramType2.getUpperBounds())) && (Arrays.equals(paramType1.getLowerBounds(), paramType2.getLowerBounds()));
    }
    if ((paramType1 instanceof TypeVariable))
    {
      if (!(paramType2 instanceof TypeVariable)) {
        return false;
      }
      paramType1 = (TypeVariable)paramType1;
      paramType2 = (TypeVariable)paramType2;
      return (paramType1.getGenericDeclaration() == paramType2.getGenericDeclaration()) && (paramType1.getName().equals(paramType2.getName()));
    }
    return false;
  }
  
  static Type getGenericSupertype(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass2 == paramClass1) {
      return paramType;
    }
    if (paramClass2.isInterface())
    {
      paramType = paramClass1.getInterfaces();
      int i = 0;
      int j = paramType.length;
      while (i < j)
      {
        if (paramType[i] == paramClass2) {
          return paramClass1.getGenericInterfaces()[i];
        }
        if (paramClass2.isAssignableFrom(paramType[i])) {
          return getGenericSupertype(paramClass1.getGenericInterfaces()[i], paramType[i], paramClass2);
        }
        i += 1;
      }
    }
    if (!paramClass1.isInterface()) {
      while (paramClass1 != Object.class)
      {
        paramType = paramClass1.getSuperclass();
        if (paramType == paramClass2) {
          return paramClass1.getGenericSuperclass();
        }
        if (paramClass2.isAssignableFrom(paramType)) {
          return getGenericSupertype(paramClass1.getGenericSuperclass(), paramType, paramClass2);
        }
        paramClass1 = paramType;
      }
    }
    return paramClass2;
  }
  
  static Type getParameterLowerBound(int paramInt, ParameterizedType paramParameterizedType)
  {
    Type localType = paramParameterizedType.getActualTypeArguments()[paramInt];
    paramParameterizedType = localType;
    if ((localType instanceof WildcardType)) {
      paramParameterizedType = ((WildcardType)localType).getLowerBounds()[0];
    }
    return paramParameterizedType;
  }
  
  static Type getParameterUpperBound(int paramInt, ParameterizedType paramParameterizedType)
  {
    Object localObject = paramParameterizedType.getActualTypeArguments();
    if ((paramInt >= 0) && (paramInt < localObject.length))
    {
      localObject = localObject[paramInt];
      paramParameterizedType = (ParameterizedType)localObject;
      if ((localObject instanceof WildcardType)) {
        paramParameterizedType = ((WildcardType)localObject).getUpperBounds()[0];
      }
      return paramParameterizedType;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Index ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" not in range [0,");
    localStringBuilder.append(localObject.length);
    localStringBuilder.append(") for ");
    localStringBuilder.append(paramParameterizedType);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  static Class<?> getRawType(Type paramType)
  {
    Objects.requireNonNull(paramType, "type == null");
    if ((paramType instanceof Class)) {
      return (Class)paramType;
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = ((ParameterizedType)paramType).getRawType();
      if ((paramType instanceof Class)) {
        return (Class)paramType;
      }
      throw new IllegalArgumentException();
    }
    if ((paramType instanceof GenericArrayType)) {
      return Array.newInstance(getRawType(((GenericArrayType)paramType).getGenericComponentType()), 0).getClass();
    }
    if ((paramType instanceof TypeVariable)) {
      return Object.class;
    }
    if ((paramType instanceof WildcardType)) {
      return getRawType(((WildcardType)paramType).getUpperBounds()[0]);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
    localStringBuilder.append(paramType);
    localStringBuilder.append("> is of type ");
    localStringBuilder.append(paramType.getClass().getName());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  static Type getSupertype(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass2.isAssignableFrom(paramClass1)) {
      return resolve(paramType, paramClass1, getGenericSupertype(paramType, paramClass1, paramClass2));
    }
    throw new IllegalArgumentException();
  }
  
  static boolean hasUnresolvableType(@Nullable Type paramType)
  {
    if ((paramType instanceof Class)) {
      return false;
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = ((ParameterizedType)paramType).getActualTypeArguments();
      int j = paramType.length;
      int i = 0;
      while (i < j)
      {
        if (hasUnresolvableType(paramType[i])) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    if ((paramType instanceof GenericArrayType)) {
      return hasUnresolvableType(((GenericArrayType)paramType).getGenericComponentType());
    }
    if ((paramType instanceof TypeVariable)) {
      return true;
    }
    if ((paramType instanceof WildcardType)) {
      return true;
    }
    String str;
    if (paramType == null) {
      str = "null";
    } else {
      str = paramType.getClass().getName();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
    localStringBuilder.append(paramType);
    localStringBuilder.append("> is of type ");
    localStringBuilder.append(str);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private static int indexOf(Object[] paramArrayOfObject, Object paramObject)
  {
    int i = 0;
    while (i < paramArrayOfObject.length)
    {
      if (paramObject.equals(paramArrayOfObject[i])) {
        return i;
      }
      i += 1;
    }
    throw new NoSuchElementException();
  }
  
  static boolean isAnnotationPresent(Annotation[] paramArrayOfAnnotation, Class<? extends Annotation> paramClass)
  {
    int j = paramArrayOfAnnotation.length;
    int i = 0;
    while (i < j)
    {
      if (paramClass.isInstance(paramArrayOfAnnotation[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  static RuntimeException methodError(Method paramMethod, String paramString, Object... paramVarArgs)
  {
    return methodError(paramMethod, null, paramString, paramVarArgs);
  }
  
  static RuntimeException methodError(Method paramMethod, @Nullable Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    paramString = String.format(paramString, paramVarArgs);
    paramVarArgs = new StringBuilder();
    paramVarArgs.append(paramString);
    paramVarArgs.append("\n    for method ");
    paramVarArgs.append(paramMethod.getDeclaringClass().getSimpleName());
    paramVarArgs.append(".");
    paramVarArgs.append(paramMethod.getName());
    return new IllegalArgumentException(paramVarArgs.toString(), paramThrowable);
  }
  
  static RuntimeException parameterError(Method paramMethod, int paramInt, String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (parameter #");
    localStringBuilder.append(paramInt + 1);
    localStringBuilder.append(")");
    return methodError(paramMethod, localStringBuilder.toString(), paramVarArgs);
  }
  
  static RuntimeException parameterError(Method paramMethod, Throwable paramThrowable, int paramInt, String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (parameter #");
    localStringBuilder.append(paramInt + 1);
    localStringBuilder.append(")");
    return methodError(paramMethod, paramThrowable, localStringBuilder.toString(), paramVarArgs);
  }
  
  static Type resolve(Type paramType1, Class<?> paramClass, Type paramType2)
  {
    while ((paramType2 instanceof TypeVariable))
    {
      localObject1 = (TypeVariable)paramType2;
      paramType2 = resolveTypeVariable(paramType1, paramClass, (TypeVariable)localObject1);
      if (paramType2 == localObject1) {
        return paramType2;
      }
    }
    if ((paramType2 instanceof Class))
    {
      localObject1 = (Class)paramType2;
      if (((Class)localObject1).isArray())
      {
        paramType2 = ((Class)localObject1).getComponentType();
        paramType1 = resolve(paramType1, paramClass, paramType2);
        if (paramType2 == paramType1) {
          return (Type)localObject1;
        }
        return new GenericArrayTypeImpl(paramType1);
      }
    }
    if ((paramType2 instanceof GenericArrayType))
    {
      paramType2 = (GenericArrayType)paramType2;
      localObject1 = paramType2.getGenericComponentType();
      paramType1 = resolve(paramType1, paramClass, (Type)localObject1);
      if (localObject1 == paramType1) {
        return paramType2;
      }
      return new GenericArrayTypeImpl(paramType1);
    }
    boolean bool = paramType2 instanceof ParameterizedType;
    int k = 0;
    Object localObject2;
    Object localObject3;
    if (bool)
    {
      localObject2 = (ParameterizedType)paramType2;
      paramType2 = ((ParameterizedType)localObject2).getOwnerType();
      localObject3 = resolve(paramType1, paramClass, paramType2);
      int i;
      if (localObject3 != paramType2) {
        i = 1;
      } else {
        i = 0;
      }
      paramType2 = ((ParameterizedType)localObject2).getActualTypeArguments();
      int m = paramType2.length;
      while (k < m)
      {
        Type localType = resolve(paramType1, paramClass, paramType2[k]);
        int j = i;
        localObject1 = paramType2;
        if (localType != paramType2[k])
        {
          j = i;
          localObject1 = paramType2;
          if (i == 0)
          {
            localObject1 = (Type[])paramType2.clone();
            j = 1;
          }
          localObject1[k] = localType;
        }
        k += 1;
        i = j;
        paramType2 = (Type)localObject1;
      }
      paramType1 = (Type)localObject2;
      if (i != 0) {
        paramType1 = new ParameterizedTypeImpl((Type)localObject3, ((ParameterizedType)localObject2).getRawType(), paramType2);
      }
      return paramType1;
    }
    Object localObject1 = paramType2;
    if ((paramType2 instanceof WildcardType))
    {
      paramType2 = (WildcardType)paramType2;
      localObject3 = paramType2.getLowerBounds();
      localObject2 = paramType2.getUpperBounds();
      if (localObject3.length == 1)
      {
        paramType1 = resolve(paramType1, paramClass, localObject3[0]);
        localObject1 = paramType2;
        if (paramType1 != localObject3[0]) {
          return new WildcardTypeImpl(new Type[] { Object.class }, new Type[] { paramType1 });
        }
      }
      else
      {
        localObject1 = paramType2;
        if (localObject2.length == 1) {
          localObject1 = localObject2[0];
        }
      }
    }
    try
    {
      paramType1 = resolve(paramType1, paramClass, (Type)localObject1);
      localObject1 = paramType2;
      if (paramType1 != localObject2[0])
      {
        paramClass = EMPTY_TYPE_ARRAY;
        return new WildcardTypeImpl(new Type[] { paramType1 }, paramClass);
      }
      return (Type)localObject1;
    }
    finally {}
  }
  
  private static Type resolveTypeVariable(Type paramType, Class<?> paramClass, TypeVariable<?> paramTypeVariable)
  {
    Class localClass = declaringClassOf(paramTypeVariable);
    if (localClass == null) {
      return paramTypeVariable;
    }
    paramType = getGenericSupertype(paramType, paramClass, localClass);
    if ((paramType instanceof ParameterizedType))
    {
      int i = indexOf(localClass.getTypeParameters(), paramTypeVariable);
      return ((ParameterizedType)paramType).getActualTypeArguments()[i];
    }
    return paramTypeVariable;
  }
  
  static void throwIfFatal(Throwable paramThrowable)
  {
    if (!(paramThrowable instanceof VirtualMachineError))
    {
      if (!(paramThrowable instanceof ThreadDeath))
      {
        if (!(paramThrowable instanceof LinkageError)) {
          return;
        }
        throw ((LinkageError)paramThrowable);
      }
      throw ((ThreadDeath)paramThrowable);
    }
    throw ((VirtualMachineError)paramThrowable);
  }
  
  static String typeToString(Type paramType)
  {
    if ((paramType instanceof Class)) {
      return ((Class)paramType).getName();
    }
    return paramType.toString();
  }
  
  private static final class GenericArrayTypeImpl
    implements GenericArrayType
  {
    private final Type componentType;
    
    GenericArrayTypeImpl(Type paramType)
    {
      this.componentType = paramType;
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof GenericArrayType)) && (Utils.equals(this, (GenericArrayType)paramObject));
    }
    
    public Type getGenericComponentType()
    {
      return this.componentType;
    }
    
    public int hashCode()
    {
      return this.componentType.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Utils.typeToString(this.componentType));
      localStringBuilder.append("[]");
      return localStringBuilder.toString();
    }
  }
  
  static final class ParameterizedTypeImpl
    implements ParameterizedType
  {
    @Nullable
    private final Type ownerType;
    private final Type rawType;
    private final Type[] typeArguments;
    
    ParameterizedTypeImpl(@Nullable Type paramType1, Type paramType2, Type... paramVarArgs)
    {
      boolean bool = paramType2 instanceof Class;
      int k = 0;
      if (bool)
      {
        j = 1;
        if (paramType1 == null) {
          i = 1;
        } else {
          i = 0;
        }
        if (((Class)paramType2).getEnclosingClass() != null) {
          j = 0;
        }
        if (i != j) {
          throw new IllegalArgumentException();
        }
      }
      int j = paramVarArgs.length;
      int i = k;
      while (i < j)
      {
        Type localType = paramVarArgs[i];
        Objects.requireNonNull(localType, "typeArgument == null");
        Utils.checkNotPrimitive(localType);
        i += 1;
      }
      this.ownerType = paramType1;
      this.rawType = paramType2;
      this.typeArguments = ((Type[])paramVarArgs.clone());
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof ParameterizedType)) && (Utils.equals(this, (ParameterizedType)paramObject));
    }
    
    public Type[] getActualTypeArguments()
    {
      return (Type[])this.typeArguments.clone();
    }
    
    @Nullable
    public Type getOwnerType()
    {
      return this.ownerType;
    }
    
    public Type getRawType()
    {
      return this.rawType;
    }
    
    public int hashCode()
    {
      int j = Arrays.hashCode(this.typeArguments);
      int k = this.rawType.hashCode();
      Type localType = this.ownerType;
      int i;
      if (localType != null) {
        i = localType.hashCode();
      } else {
        i = 0;
      }
      return j ^ k ^ i;
    }
    
    public String toString()
    {
      Object localObject = this.typeArguments;
      if (localObject.length == 0) {
        return Utils.typeToString(this.rawType);
      }
      int j = localObject.length;
      int i = 1;
      localObject = new StringBuilder((j + 1) * 30);
      ((StringBuilder)localObject).append(Utils.typeToString(this.rawType));
      ((StringBuilder)localObject).append("<");
      ((StringBuilder)localObject).append(Utils.typeToString(this.typeArguments[0]));
      while (i < this.typeArguments.length)
      {
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(Utils.typeToString(this.typeArguments[i]));
        i += 1;
      }
      ((StringBuilder)localObject).append(">");
      return ((StringBuilder)localObject).toString();
    }
  }
  
  private static final class WildcardTypeImpl
    implements WildcardType
  {
    @Nullable
    private final Type lowerBound;
    private final Type upperBound;
    
    WildcardTypeImpl(Type[] paramArrayOfType1, Type[] paramArrayOfType2)
    {
      if (paramArrayOfType2.length <= 1)
      {
        if (paramArrayOfType1.length == 1)
        {
          if (paramArrayOfType2.length == 1)
          {
            if (paramArrayOfType2[0] != null)
            {
              Utils.checkNotPrimitive(paramArrayOfType2[0]);
              if (paramArrayOfType1[0] == Object.class)
              {
                this.lowerBound = paramArrayOfType2[0];
                this.upperBound = Object.class;
                return;
              }
              throw new IllegalArgumentException();
            }
            throw null;
          }
          if (paramArrayOfType1[0] != null)
          {
            Utils.checkNotPrimitive(paramArrayOfType1[0]);
            this.lowerBound = null;
            this.upperBound = paramArrayOfType1[0];
            return;
          }
          throw null;
        }
        throw new IllegalArgumentException();
      }
      throw new IllegalArgumentException();
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof WildcardType)) && (Utils.equals(this, (WildcardType)paramObject));
    }
    
    public Type[] getLowerBounds()
    {
      Type localType = this.lowerBound;
      if (localType != null) {
        return new Type[] { localType };
      }
      return Utils.EMPTY_TYPE_ARRAY;
    }
    
    public Type[] getUpperBounds()
    {
      return new Type[] { this.upperBound };
    }
    
    public int hashCode()
    {
      Type localType = this.lowerBound;
      int i;
      if (localType != null) {
        i = localType.hashCode() + 31;
      } else {
        i = 1;
      }
      return i ^ this.upperBound.hashCode() + 31;
    }
    
    public String toString()
    {
      if (this.lowerBound != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("? super ");
        localStringBuilder.append(Utils.typeToString(this.lowerBound));
        return localStringBuilder.toString();
      }
      if (this.upperBound == Object.class) {
        return "?";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("? extends ");
      localStringBuilder.append(Utils.typeToString(this.upperBound));
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\retrofit2\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */