package kotlin.reflect;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\f\n\002\030\002\n\002\020\020\n\002\b\005\b\001\030\0002\b\022\004\022\0020\0000\001B\007\b\002¢\006\002\020\002j\002\b\003j\002\b\004j\002\b\005¨\006\006"}, d2={"Lkotlin/reflect/KVariance;", "", "(Ljava/lang/String;I)V", "INVARIANT", "IN", "OUT", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public enum KVariance
{
  static
  {
    KVariance localKVariance1 = new KVariance("INVARIANT", 0);
    INVARIANT = localKVariance1;
    KVariance localKVariance2 = new KVariance("IN", 1);
    IN = localKVariance2;
    KVariance localKVariance3 = new KVariance("OUT", 2);
    OUT = localKVariance3;
    $VALUES = new KVariance[] { localKVariance1, localKVariance2, localKVariance3 };
  }
  
  private KVariance() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\reflect\KVariance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */