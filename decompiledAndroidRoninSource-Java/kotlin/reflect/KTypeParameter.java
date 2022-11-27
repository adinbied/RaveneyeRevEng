package kotlin.reflect;

import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000.\n\002\030\002\n\002\030\002\n\000\n\002\020\013\n\002\b\002\n\002\020\016\n\002\b\003\n\002\020 \n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\bg\030\0002\0020\001R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\002\020\004R\022\020\005\032\0020\006X¦\004¢\006\006\032\004\b\007\020\bR\030\020\t\032\b\022\004\022\0020\0130\nX¦\004¢\006\006\032\004\b\f\020\rR\022\020\016\032\0020\017X¦\004¢\006\006\032\004\b\020\020\021¨\006\022"}, d2={"Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/KClassifier;", "isReified", "", "()Z", "name", "", "getName", "()Ljava/lang/String;", "upperBounds", "", "Lkotlin/reflect/KType;", "getUpperBounds", "()Ljava/util/List;", "variance", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public abstract interface KTypeParameter
  extends KClassifier
{
  public abstract String getName();
  
  public abstract List<KType> getUpperBounds();
  
  public abstract KVariance getVariance();
  
  public abstract boolean isReified();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\reflect\KTypeParameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */