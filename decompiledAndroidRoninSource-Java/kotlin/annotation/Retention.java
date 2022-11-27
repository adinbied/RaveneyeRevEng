package kotlin.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
@java.lang.annotation.Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
@Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\020\033\n\000\n\002\030\002\n\002\b\002\b\002\030\0002\0020\001B\n\022\b\b\002\020\002\032\0020\003R\017\020\002\032\0020\003¢\006\006\032\004\b\002\020\004¨\006\005"}, d2={"Lkotlin/annotation/Retention;", "", "value", "Lkotlin/annotation/AnnotationRetention;", "()Lkotlin/annotation/AnnotationRetention;", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
@Target(allowedTargets={AnnotationTarget.ANNOTATION_CLASS})
public @interface Retention
{
  AnnotationRetention value() default AnnotationRetention.RUNTIME;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\annotation\Retention.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */