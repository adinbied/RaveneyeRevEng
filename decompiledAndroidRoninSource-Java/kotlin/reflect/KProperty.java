package kotlin.reflect;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\034\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\b\bf\030\000*\006\b\000\020\001 \0012\b\022\004\022\002H\0010\002:\002\016\017R\030\020\003\032\b\022\004\022\0028\0000\004X¦\004¢\006\006\032\004\b\005\020\006R\032\020\007\032\0020\b8&X§\004¢\006\f\022\004\b\t\020\n\032\004\b\007\020\013R\032\020\f\032\0020\b8&X§\004¢\006\f\022\004\b\r\020\n\032\004\b\f\020\013¨\006\020"}, d2={"Lkotlin/reflect/KProperty;", "R", "Lkotlin/reflect/KCallable;", "getter", "Lkotlin/reflect/KProperty$Getter;", "getGetter", "()Lkotlin/reflect/KProperty$Getter;", "isConst", "", "isConst$annotations", "()V", "()Z", "isLateinit", "isLateinit$annotations", "Accessor", "Getter", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public abstract interface KProperty<R>
  extends KCallable<R>
{
  public abstract Getter<R> getGetter();
  
  public abstract boolean isConst();
  
  public abstract boolean isLateinit();
  
  @Metadata(bv={1, 0, 3}, d1={"\000\024\n\002\030\002\n\000\n\002\020\000\n\000\n\002\030\002\n\002\b\003\bf\030\000*\006\b\001\020\001 \0012\0020\002R\030\020\003\032\b\022\004\022\0028\0010\004X¦\004¢\006\006\032\004\b\005\020\006¨\006\007"}, d2={"Lkotlin/reflect/KProperty$Accessor;", "R", "", "property", "Lkotlin/reflect/KProperty;", "getProperty", "()Lkotlin/reflect/KProperty;", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
  public static abstract interface Accessor<R>
  {
    public abstract KProperty<R> getProperty();
  }
  
  @Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 15})
  public static final class DefaultImpls {}
  
  @Metadata(bv={1, 0, 3}, d1={"\000\020\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\bf\030\000*\006\b\001\020\001 \0012\b\022\004\022\002H\0010\0022\b\022\004\022\002H\0010\003¨\006\004"}, d2={"Lkotlin/reflect/KProperty$Getter;", "R", "Lkotlin/reflect/KProperty$Accessor;", "Lkotlin/reflect/KFunction;", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
  public static abstract interface Getter<R>
    extends KProperty.Accessor<R>, KFunction<R>
  {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\reflect\KProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */