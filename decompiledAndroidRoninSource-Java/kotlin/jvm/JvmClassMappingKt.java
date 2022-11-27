package kotlin.jvm;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(bv={1, 0, 3}, d1={"\000,\n\000\n\002\030\002\n\000\n\002\020\033\n\002\b\003\n\002\030\002\n\002\b\005\n\002\020\000\n\002\b\013\n\002\020\013\n\002\020\021\n\002\b\002\032\037\020\030\032\0020\031\"\n\b\000\020\002\030\001*\0020\r*\006\022\002\b\0030\032¢\006\002\020\033\"'\020\000\032\n\022\006\b\001\022\002H\0020\001\"\b\b\000\020\002*\0020\003*\002H\0028F¢\006\006\032\004\b\004\020\005\"-\020\006\032\b\022\004\022\002H\0020\007\"\004\b\000\020\002*\b\022\004\022\002H\0020\0018G¢\006\f\022\004\b\b\020\t\032\004\b\n\020\013\"&\020\f\032\b\022\004\022\002H\0020\007\"\b\b\000\020\002*\0020\r*\002H\0028Æ\002¢\006\006\032\004\b\n\020\016\";\020\f\032\016\022\n\022\b\022\004\022\002H\0020\0010\007\"\b\b\000\020\002*\0020\r*\b\022\004\022\002H\0020\0018Ç\002X\004¢\006\f\022\004\b\017\020\t\032\004\b\020\020\013\"+\020\021\032\b\022\004\022\002H\0020\007\"\b\b\000\020\002*\0020\r*\b\022\004\022\002H\0020\0018F¢\006\006\032\004\b\022\020\013\"-\020\023\032\n\022\004\022\002H\002\030\0010\007\"\b\b\000\020\002*\0020\r*\b\022\004\022\002H\0020\0018F¢\006\006\032\004\b\024\020\013\"+\020\025\032\b\022\004\022\002H\0020\001\"\b\b\000\020\002*\0020\r*\b\022\004\022\002H\0020\0078G¢\006\006\032\004\b\026\020\027¨\006\034"}, d2={"annotationClass", "Lkotlin/reflect/KClass;", "T", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "java", "Ljava/lang/Class;", "java$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaClass", "", "(Ljava/lang/Object;)Ljava/lang/Class;", "javaClass$annotations", "getRuntimeClassOfKClassInstance", "javaObjectType", "getJavaObjectType", "javaPrimitiveType", "getJavaPrimitiveType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class JvmClassMappingKt
{
  public static final <T extends Annotation> KClass<? extends T> getAnnotationClass(T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "$this$annotationClass");
    paramT = paramT.annotationType();
    Intrinsics.checkExpressionValueIsNotNull(paramT, "(this as java.lang.annot…otation).annotationType()");
    paramT = getKotlinClass(paramT);
    if (paramT != null) {
      return paramT;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
  }
  
  public static final <T> Class<T> getJavaClass(T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "$this$javaClass");
    paramT = paramT.getClass();
    if (paramT != null) {
      return paramT;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
  }
  
  public static final <T> Class<T> getJavaClass(KClass<T> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$java");
    paramKClass = ((ClassBasedDeclarationContainer)paramKClass).getJClass();
    if (paramKClass != null) {
      return paramKClass;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
  }
  
  public static final <T> Class<T> getJavaObjectType(KClass<T> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$javaObjectType");
    paramKClass = ((ClassBasedDeclarationContainer)paramKClass).getJClass();
    if (!paramKClass.isPrimitive())
    {
      if (paramKClass != null) {
        return paramKClass;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
    }
    String str = paramKClass.getName();
    if (str != null) {
      switch (str.hashCode())
      {
      default: 
        break;
      case 109413500: 
        if (str.equals("short")) {
          paramKClass = Short.class;
        }
        break;
      case 97526364: 
        if (str.equals("float")) {
          paramKClass = Float.class;
        }
        break;
      case 64711720: 
        if (str.equals("boolean")) {
          paramKClass = Boolean.class;
        }
        break;
      case 3625364: 
        if (str.equals("void")) {
          paramKClass = Void.class;
        }
        break;
      case 3327612: 
        if (str.equals("long")) {
          paramKClass = Long.class;
        }
        break;
      case 3052374: 
        if (str.equals("char")) {
          paramKClass = Character.class;
        }
        break;
      case 3039496: 
        if (str.equals("byte")) {
          paramKClass = Byte.class;
        }
        break;
      case 104431: 
        if (str.equals("int")) {
          paramKClass = Integer.class;
        }
        break;
      case -1325958191: 
        if (str.equals("double")) {
          paramKClass = Double.class;
        }
        break;
      }
    }
    if (paramKClass != null) {
      return paramKClass;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
  }
  
  public static final <T> Class<T> getJavaPrimitiveType(KClass<T> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$javaPrimitiveType");
    paramKClass = ((ClassBasedDeclarationContainer)paramKClass).getJClass();
    if (paramKClass.isPrimitive())
    {
      if (paramKClass != null) {
        return paramKClass;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
    }
    paramKClass = paramKClass.getName();
    if (paramKClass != null) {
      switch (paramKClass.hashCode())
      {
      default: 
        break;
      case 761287205: 
        if (paramKClass.equals("java.lang.Double")) {
          return Double.TYPE;
        }
        break;
      case 399092968: 
        if (paramKClass.equals("java.lang.Void")) {
          return Void.TYPE;
        }
        break;
      case 398795216: 
        if (paramKClass.equals("java.lang.Long")) {
          return Long.TYPE;
        }
        break;
      case 398507100: 
        if (paramKClass.equals("java.lang.Byte")) {
          return Byte.TYPE;
        }
        break;
      case 344809556: 
        if (paramKClass.equals("java.lang.Boolean")) {
          return Boolean.TYPE;
        }
        break;
      case 155276373: 
        if (paramKClass.equals("java.lang.Character")) {
          return Character.TYPE;
        }
        break;
      case -515992664: 
        if (paramKClass.equals("java.lang.Short")) {
          return Short.TYPE;
        }
        break;
      case -527879800: 
        if (paramKClass.equals("java.lang.Float")) {
          return Float.TYPE;
        }
        break;
      case -2056817302: 
        if (paramKClass.equals("java.lang.Integer")) {
          return Integer.TYPE;
        }
        break;
      }
    }
    return null;
  }
  
  public static final <T> KClass<T> getKotlinClass(Class<T> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "$this$kotlin");
    return Reflection.getOrCreateKotlinClass(paramClass);
  }
  
  public static final <T> Class<KClass<T>> getRuntimeClassOfKClassInstance(KClass<T> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$javaClass");
    paramKClass = ((Object)paramKClass).getClass();
    if (paramKClass != null) {
      return paramKClass;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T>>");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\jvm\JvmClassMappingKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */