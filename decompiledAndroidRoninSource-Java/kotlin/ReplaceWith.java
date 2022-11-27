package kotlin;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.MustBeDocumented;

@Documented
@java.lang.annotation.Retention(RetentionPolicy.CLASS)
@java.lang.annotation.Target({})
@Metadata(bv={1, 0, 3}, d1={"\000\030\n\002\030\002\n\002\020\033\n\000\n\002\020\016\n\000\n\002\020\021\n\002\b\003\b\002\030\0002\0020\001B\034\022\006\020\002\032\0020\003\022\022\020\004\032\n\022\006\b\001\022\0020\0030\005\"\0020\003R\017\020\002\032\0020\003¢\006\006\032\004\b\002\020\006R\027\020\004\032\n\022\006\b\001\022\0020\0030\005¢\006\006\032\004\b\004\020\007¨\006\b"}, d2={"Lkotlin/ReplaceWith;", "", "expression", "", "imports", "", "()Ljava/lang/String;", "()[Ljava/lang/String;", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
@MustBeDocumented
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
@kotlin.annotation.Target(allowedTargets={})
public @interface ReplaceWith
{
  String expression();
  
  String[] imports();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\ReplaceWith.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */