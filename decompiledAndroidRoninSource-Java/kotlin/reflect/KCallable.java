package kotlin.reflect;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000T\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\002\b\n\n\002\020\016\n\002\b\003\n\002\020 \n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\n\002\020\021\n\002\020\000\n\002\b\002\n\002\020$\n\002\b\002\bf\030\000*\006\b\000\020\001 \0012\0020\002J%\020$\032\0028\0002\026\020%\032\f\022\b\b\001\022\004\030\0010'0&\"\004\030\0010'H&¢\006\002\020(J#\020)\032\0028\0002\024\020%\032\020\022\004\022\0020\024\022\006\022\004\030\0010'0*H&¢\006\002\020+R\032\020\003\032\0020\0048&X§\004¢\006\f\022\004\b\005\020\006\032\004\b\003\020\007R\032\020\b\032\0020\0048&X§\004¢\006\f\022\004\b\t\020\006\032\004\b\b\020\007R\032\020\n\032\0020\0048&X§\004¢\006\f\022\004\b\013\020\006\032\004\b\n\020\007R\032\020\f\032\0020\0048&X§\004¢\006\f\022\004\b\r\020\006\032\004\b\f\020\007R\022\020\016\032\0020\017X¦\004¢\006\006\032\004\b\020\020\021R\030\020\022\032\b\022\004\022\0020\0240\023X¦\004¢\006\006\032\004\b\025\020\026R\022\020\027\032\0020\030X¦\004¢\006\006\032\004\b\031\020\032R \020\033\032\b\022\004\022\0020\0340\0238&X§\004¢\006\f\022\004\b\035\020\006\032\004\b\036\020\026R\034\020\037\032\004\030\0010 8&X§\004¢\006\f\022\004\b!\020\006\032\004\b\"\020#¨\006,"}, d2={"Lkotlin/reflect/KCallable;", "R", "Lkotlin/reflect/KAnnotatedElement;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isFinal", "isFinal$annotations", "isOpen", "isOpen$annotations", "isSuspend", "isSuspend$annotations", "name", "", "getName", "()Ljava/lang/String;", "parameters", "", "Lkotlin/reflect/KParameter;", "getParameters", "()Ljava/util/List;", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "typeParameters$annotations", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "visibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "call", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callBy", "", "(Ljava/util/Map;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public abstract interface KCallable<R>
  extends KAnnotatedElement
{
  public abstract R call(Object... paramVarArgs);
  
  public abstract R callBy(Map<KParameter, ? extends Object> paramMap);
  
  public abstract String getName();
  
  public abstract List<KParameter> getParameters();
  
  public abstract KType getReturnType();
  
  public abstract List<KTypeParameter> getTypeParameters();
  
  public abstract KVisibility getVisibility();
  
  public abstract boolean isAbstract();
  
  public abstract boolean isFinal();
  
  public abstract boolean isOpen();
  
  public abstract boolean isSuspend();
  
  @Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 15})
  public static final class DefaultImpls {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\reflect\KCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */