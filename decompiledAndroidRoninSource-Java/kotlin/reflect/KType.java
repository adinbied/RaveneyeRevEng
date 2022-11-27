package kotlin.reflect;

import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000&\n\002\030\002\n\002\030\002\n\000\n\002\020 \n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\004\n\002\020\013\n\002\b\002\bf\030\0002\0020\001R \020\002\032\b\022\004\022\0020\0040\0038&X§\004¢\006\f\022\004\b\005\020\006\032\004\b\007\020\bR\034\020\t\032\004\030\0010\n8&X§\004¢\006\f\022\004\b\013\020\006\032\004\b\f\020\rR\022\020\016\032\0020\017X¦\004¢\006\006\032\004\b\016\020\020¨\006\021"}, d2={"Lkotlin/reflect/KType;", "Lkotlin/reflect/KAnnotatedElement;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "arguments$annotations", "()V", "getArguments", "()Ljava/util/List;", "classifier", "Lkotlin/reflect/KClassifier;", "classifier$annotations", "getClassifier", "()Lkotlin/reflect/KClassifier;", "isMarkedNullable", "", "()Z", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public abstract interface KType
  extends KAnnotatedElement
{
  public abstract List<KTypeProjection> getArguments();
  
  public abstract KClassifier getClassifier();
  
  public abstract boolean isMarkedNullable();
  
  @Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 15})
  public static final class DefaultImpls {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\reflect\KType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */