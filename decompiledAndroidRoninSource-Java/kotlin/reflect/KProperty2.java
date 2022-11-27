package kotlin.reflect;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(bv={1, 0, 3}, d1={"\000\"\n\002\030\002\n\002\b\003\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\007\n\002\020\000\n\002\b\002\bf\030\000*\004\b\000\020\001*\004\b\001\020\002*\006\b\002\020\003 \0012\b\022\004\022\002H\0030\0042\024\022\004\022\002H\001\022\004\022\002H\002\022\004\022\002H\0030\005:\001\020J\035\020\n\032\0028\0022\006\020\013\032\0028\0002\006\020\f\032\0028\001H&¢\006\002\020\rJ\037\020\016\032\004\030\0010\0172\006\020\013\032\0028\0002\006\020\f\032\0028\001H'¢\006\002\020\rR$\020\006\032\024\022\004\022\0028\000\022\004\022\0028\001\022\004\022\0028\0020\007X¦\004¢\006\006\032\004\b\b\020\t¨\006\021"}, d2={"Lkotlin/reflect/KProperty2;", "D", "E", "R", "Lkotlin/reflect/KProperty;", "Lkotlin/Function2;", "getter", "Lkotlin/reflect/KProperty2$Getter;", "getGetter", "()Lkotlin/reflect/KProperty2$Getter;", "get", "receiver1", "receiver2", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getDelegate", "", "Getter", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public abstract interface KProperty2<D, E, R>
  extends KProperty<R>, Function2<D, E, R>
{
  public abstract R get(D paramD, E paramE);
  
  public abstract Object getDelegate(D paramD, E paramE);
  
  public abstract Getter<D, E, R> getGetter();
  
  @Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\b\003\n\002\030\002\n\002\030\002\n\000\bf\030\000*\004\b\003\020\001*\004\b\004\020\002*\006\b\005\020\003 \0012\b\022\004\022\002H\0030\0042\024\022\004\022\002H\001\022\004\022\002H\002\022\004\022\002H\0030\005¨\006\006"}, d2={"Lkotlin/reflect/KProperty2$Getter;", "D", "E", "R", "Lkotlin/reflect/KProperty$Getter;", "Lkotlin/Function2;", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
  public static abstract interface Getter<D, E, R>
    extends KProperty.Getter<R>, Function2<D, E, R>
  {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\reflect\KProperty2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */