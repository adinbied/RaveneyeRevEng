package kotlin.contracts;

import kotlin.Function;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000,\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\bg\030\0002\0020\001J&\020\002\032\0020\003\"\004\b\000\020\0042\f\020\005\032\b\022\004\022\002H\0040\0062\b\b\002\020\007\032\0020\bH'J\b\020\t\032\0020\nH'J\022\020\t\032\0020\n2\b\020\013\032\004\030\0010\001H'J\b\020\f\032\0020\rH'¨\006\016"}, d2={"Lkotlin/contracts/ContractBuilder;", "", "callsInPlace", "Lkotlin/contracts/CallsInPlace;", "R", "lambda", "Lkotlin/Function;", "kind", "Lkotlin/contracts/InvocationKind;", "returns", "Lkotlin/contracts/Returns;", "value", "returnsNotNull", "Lkotlin/contracts/ReturnsNotNull;", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public abstract interface ContractBuilder
{
  public abstract <R> CallsInPlace callsInPlace(Function<? extends R> paramFunction, InvocationKind paramInvocationKind);
  
  public abstract Returns returns();
  
  public abstract Returns returns(Object paramObject);
  
  public abstract ReturnsNotNull returnsNotNull();
  
  @Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 15})
  public static final class DefaultImpls {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\contracts\ContractBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */