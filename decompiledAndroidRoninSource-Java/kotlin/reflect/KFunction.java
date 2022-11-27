package kotlin.reflect;

import kotlin.Function;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\030\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\020\013\n\002\b\f\bf\030\000*\006\b\000\020\001 \0012\b\022\004\022\002H\0010\0022\b\022\004\022\002H\0010\003R\032\020\004\032\0020\0058&X§\004¢\006\f\022\004\b\006\020\007\032\004\b\004\020\bR\032\020\t\032\0020\0058&X§\004¢\006\f\022\004\b\n\020\007\032\004\b\t\020\bR\032\020\013\032\0020\0058&X§\004¢\006\f\022\004\b\f\020\007\032\004\b\013\020\bR\032\020\r\032\0020\0058&X§\004¢\006\f\022\004\b\016\020\007\032\004\b\r\020\bR\032\020\017\032\0020\0058&X§\004¢\006\f\022\004\b\020\020\007\032\004\b\017\020\b¨\006\021"}, d2={"Lkotlin/reflect/KFunction;", "R", "Lkotlin/reflect/KCallable;", "Lkotlin/Function;", "isExternal", "", "isExternal$annotations", "()V", "()Z", "isInfix", "isInfix$annotations", "isInline", "isInline$annotations", "isOperator", "isOperator$annotations", "isSuspend", "isSuspend$annotations", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public abstract interface KFunction<R>
  extends KCallable<R>, Function<R>
{
  public abstract boolean isExternal();
  
  public abstract boolean isInfix();
  
  public abstract boolean isInline();
  
  public abstract boolean isOperator();
  
  public abstract boolean isSuspend();
  
  @Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 15})
  public static final class DefaultImpls {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\reflect\KFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */