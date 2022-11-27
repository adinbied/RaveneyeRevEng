package kotlin.contracts;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\f\n\002\030\002\n\002\020\020\n\002\b\006\b\001\030\0002\b\022\004\022\0020\0000\001B\007\b\002¢\006\002\020\002j\002\b\003j\002\b\004j\002\b\005j\002\b\006¨\006\007"}, d2={"Lkotlin/contracts/InvocationKind;", "", "(Ljava/lang/String;I)V", "AT_MOST_ONCE", "AT_LEAST_ONCE", "EXACTLY_ONCE", "UNKNOWN", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public enum InvocationKind
{
  static
  {
    InvocationKind localInvocationKind1 = new InvocationKind("AT_MOST_ONCE", 0);
    AT_MOST_ONCE = localInvocationKind1;
    InvocationKind localInvocationKind2 = new InvocationKind("AT_LEAST_ONCE", 1);
    AT_LEAST_ONCE = localInvocationKind2;
    InvocationKind localInvocationKind3 = new InvocationKind("EXACTLY_ONCE", 2);
    EXACTLY_ONCE = localInvocationKind3;
    InvocationKind localInvocationKind4 = new InvocationKind("UNKNOWN", 3);
    UNKNOWN = localInvocationKind4;
    $VALUES = new InvocationKind[] { localInvocationKind1, localInvocationKind2, localInvocationKind3, localInvocationKind4 };
  }
  
  private InvocationKind() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\contracts\InvocationKind.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */