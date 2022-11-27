package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;

@Metadata(bv={1, 0, 3}, d1={"\000p\n\002\030\002\n\002\030\002\n\002\020\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020 \n\002\020\033\n\002\b\003\n\002\020\036\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\022\n\002\030\002\n\002\b\007\n\002\020\016\n\002\b\b\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\006\n\002\020\001\n\000\n\002\020\b\n\002\b\004\030\0002\b\022\004\022\0020\0020\0012\0020\003B\021\022\n\020\004\032\006\022\002\b\0030\005¢\006\002\020\006J\023\020B\032\0020\0222\b\020C\032\004\030\0010\002H\002J\b\020D\032\0020EH\002J\b\020F\032\0020GH\026J\022\020H\032\0020\0222\b\020I\032\004\030\0010\002H\027J\b\020J\032\0020-H\026R\032\020\007\032\b\022\004\022\0020\t0\b8VX\004¢\006\006\032\004\b\n\020\013R \020\f\032\016\022\n\022\b\022\004\022\0020\0020\0160\r8VX\004¢\006\006\032\004\b\017\020\020R\032\020\021\032\0020\0228VX\004¢\006\f\022\004\b\023\020\024\032\004\b\021\020\025R\032\020\026\032\0020\0228VX\004¢\006\f\022\004\b\027\020\024\032\004\b\026\020\025R\032\020\030\032\0020\0228VX\004¢\006\f\022\004\b\031\020\024\032\004\b\030\020\025R\032\020\032\032\0020\0228VX\004¢\006\f\022\004\b\033\020\024\032\004\b\032\020\025R\032\020\034\032\0020\0228VX\004¢\006\f\022\004\b\035\020\024\032\004\b\034\020\025R\032\020\036\032\0020\0228VX\004¢\006\f\022\004\b\037\020\024\032\004\b\036\020\025R\032\020 \032\0020\0228VX\004¢\006\f\022\004\b!\020\024\032\004\b \020\025R\030\020\004\032\006\022\002\b\0030\005X\004¢\006\b\n\000\032\004\b\"\020#R\036\020$\032\f\022\b\022\006\022\002\b\0030%0\r8VX\004¢\006\006\032\004\b&\020\020R\036\020'\032\f\022\b\022\006\022\002\b\0030\0010\r8VX\004¢\006\006\032\004\b(\020\020R\026\020)\032\004\030\0010\0028VX\004¢\006\006\032\004\b*\020+R\026\020,\032\004\030\0010-8VX\004¢\006\006\032\004\b.\020/R(\0200\032\020\022\f\022\n\022\006\b\001\022\0020\0020\0010\b8VX\004¢\006\f\022\004\b1\020\024\032\004\b2\020\013R\026\0203\032\004\030\0010-8VX\004¢\006\006\032\004\b4\020/R \0205\032\b\022\004\022\002060\b8VX\004¢\006\f\022\004\b7\020\024\032\004\b8\020\013R \0209\032\b\022\004\022\0020:0\b8VX\004¢\006\f\022\004\b;\020\024\032\004\b<\020\013R\034\020=\032\004\030\0010>8VX\004¢\006\f\022\004\b?\020\024\032\004\b@\020A¨\006K"}, d2={"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "sealedSubclasses$annotations", "getSealedSubclasses", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "supertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "typeParameters$annotations", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "visibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "error", "", "hashCode", "", "isInstance", "value", "toString", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class ClassReference
  implements KClass<Object>, ClassBasedDeclarationContainer
{
  private final Class<?> jClass;
  
  public ClassReference(Class<?> paramClass)
  {
    this.jClass = paramClass;
  }
  
  private final Void error()
  {
    throw ((Throwable)new KotlinReflectionNotSupportedError());
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof ClassReference)) && (Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType((KClass)paramObject)));
  }
  
  public List<Annotation> getAnnotations()
  {
    error();
    throw null;
  }
  
  public Collection<KFunction<Object>> getConstructors()
  {
    error();
    throw null;
  }
  
  public Class<?> getJClass()
  {
    return this.jClass;
  }
  
  public Collection<KCallable<?>> getMembers()
  {
    error();
    throw null;
  }
  
  public Collection<KClass<?>> getNestedClasses()
  {
    error();
    throw null;
  }
  
  public Object getObjectInstance()
  {
    error();
    throw null;
  }
  
  public String getQualifiedName()
  {
    error();
    throw null;
  }
  
  public List<KClass<? extends Object>> getSealedSubclasses()
  {
    error();
    throw null;
  }
  
  public String getSimpleName()
  {
    error();
    throw null;
  }
  
  public List<KType> getSupertypes()
  {
    error();
    throw null;
  }
  
  public List<KTypeParameter> getTypeParameters()
  {
    error();
    throw null;
  }
  
  public KVisibility getVisibility()
  {
    error();
    throw null;
  }
  
  public int hashCode()
  {
    return JvmClassMappingKt.getJavaObjectType(this).hashCode();
  }
  
  public boolean isAbstract()
  {
    error();
    throw null;
  }
  
  public boolean isCompanion()
  {
    error();
    throw null;
  }
  
  public boolean isData()
  {
    error();
    throw null;
  }
  
  public boolean isFinal()
  {
    error();
    throw null;
  }
  
  public boolean isInner()
  {
    error();
    throw null;
  }
  
  public boolean isInstance(Object paramObject)
  {
    error();
    throw null;
  }
  
  public boolean isOpen()
  {
    error();
    throw null;
  }
  
  public boolean isSealed()
  {
    error();
    throw null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getJClass().toString());
    localStringBuilder.append(" (Kotlin reflection is not available)");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\jvm\internal\ClassReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */