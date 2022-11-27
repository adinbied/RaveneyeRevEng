package kotlin.jvm.internal;

import java.util.Arrays;
import java.util.Collections;
import kotlin.collections.ArraysKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

public class Reflection
{
  private static final KClass[] EMPTY_K_CLASS_ARRAY = new KClass[0];
  static final String REFLECTION_NOT_AVAILABLE = " (Kotlin reflection is not available)";
  private static final ReflectionFactory factory;
  
  static
  {
    Object localObject = null;
    try
    {
      ReflectionFactory localReflectionFactory = (ReflectionFactory)Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
      localObject = localReflectionFactory;
    }
    catch (ClassCastException|ClassNotFoundException|InstantiationException|IllegalAccessException localClassCastException)
    {
      for (;;) {}
    }
    if (localObject == null) {
      localObject = new ReflectionFactory();
    }
    factory = (ReflectionFactory)localObject;
  }
  
  public static KClass createKotlinClass(Class paramClass)
  {
    return factory.createKotlinClass(paramClass);
  }
  
  public static KClass createKotlinClass(Class paramClass, String paramString)
  {
    return factory.createKotlinClass(paramClass, paramString);
  }
  
  public static KFunction function(FunctionReference paramFunctionReference)
  {
    return factory.function(paramFunctionReference);
  }
  
  public static KClass getOrCreateKotlinClass(Class paramClass)
  {
    return factory.getOrCreateKotlinClass(paramClass);
  }
  
  public static KClass getOrCreateKotlinClass(Class paramClass, String paramString)
  {
    return factory.getOrCreateKotlinClass(paramClass, paramString);
  }
  
  public static KClass[] getOrCreateKotlinClasses(Class[] paramArrayOfClass)
  {
    int j = paramArrayOfClass.length;
    if (j == 0) {
      return EMPTY_K_CLASS_ARRAY;
    }
    KClass[] arrayOfKClass = new KClass[j];
    int i = 0;
    while (i < j)
    {
      arrayOfKClass[i] = getOrCreateKotlinClass(paramArrayOfClass[i]);
      i += 1;
    }
    return arrayOfKClass;
  }
  
  public static KDeclarationContainer getOrCreateKotlinPackage(Class paramClass, String paramString)
  {
    return factory.getOrCreateKotlinPackage(paramClass, paramString);
  }
  
  public static KMutableProperty0 mutableProperty0(MutablePropertyReference0 paramMutablePropertyReference0)
  {
    return factory.mutableProperty0(paramMutablePropertyReference0);
  }
  
  public static KMutableProperty1 mutableProperty1(MutablePropertyReference1 paramMutablePropertyReference1)
  {
    return factory.mutableProperty1(paramMutablePropertyReference1);
  }
  
  public static KMutableProperty2 mutableProperty2(MutablePropertyReference2 paramMutablePropertyReference2)
  {
    return factory.mutableProperty2(paramMutablePropertyReference2);
  }
  
  public static KType nullableTypeOf(Class paramClass)
  {
    return factory.typeOf(getOrCreateKotlinClass(paramClass), Collections.emptyList(), true);
  }
  
  public static KType nullableTypeOf(Class paramClass, KTypeProjection paramKTypeProjection)
  {
    return factory.typeOf(getOrCreateKotlinClass(paramClass), Collections.singletonList(paramKTypeProjection), true);
  }
  
  public static KType nullableTypeOf(Class paramClass, KTypeProjection paramKTypeProjection1, KTypeProjection paramKTypeProjection2)
  {
    return factory.typeOf(getOrCreateKotlinClass(paramClass), Arrays.asList(new KTypeProjection[] { paramKTypeProjection1, paramKTypeProjection2 }), true);
  }
  
  public static KType nullableTypeOf(Class paramClass, KTypeProjection... paramVarArgs)
  {
    return factory.typeOf(getOrCreateKotlinClass(paramClass), ArraysKt.toList(paramVarArgs), true);
  }
  
  public static KProperty0 property0(PropertyReference0 paramPropertyReference0)
  {
    return factory.property0(paramPropertyReference0);
  }
  
  public static KProperty1 property1(PropertyReference1 paramPropertyReference1)
  {
    return factory.property1(paramPropertyReference1);
  }
  
  public static KProperty2 property2(PropertyReference2 paramPropertyReference2)
  {
    return factory.property2(paramPropertyReference2);
  }
  
  public static String renderLambdaToString(FunctionBase paramFunctionBase)
  {
    return factory.renderLambdaToString(paramFunctionBase);
  }
  
  public static String renderLambdaToString(Lambda paramLambda)
  {
    return factory.renderLambdaToString(paramLambda);
  }
  
  public static KType typeOf(Class paramClass)
  {
    return factory.typeOf(getOrCreateKotlinClass(paramClass), Collections.emptyList(), false);
  }
  
  public static KType typeOf(Class paramClass, KTypeProjection paramKTypeProjection)
  {
    return factory.typeOf(getOrCreateKotlinClass(paramClass), Collections.singletonList(paramKTypeProjection), false);
  }
  
  public static KType typeOf(Class paramClass, KTypeProjection paramKTypeProjection1, KTypeProjection paramKTypeProjection2)
  {
    return factory.typeOf(getOrCreateKotlinClass(paramClass), Arrays.asList(new KTypeProjection[] { paramKTypeProjection1, paramKTypeProjection2 }), false);
  }
  
  public static KType typeOf(Class paramClass, KTypeProjection... paramVarArgs)
  {
    return factory.typeOf(getOrCreateKotlinClass(paramClass), ArraysKt.toList(paramVarArgs), false);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\jvm\internal\Reflection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */