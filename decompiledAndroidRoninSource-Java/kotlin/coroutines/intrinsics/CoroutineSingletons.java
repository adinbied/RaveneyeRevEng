package kotlin.coroutines.intrinsics;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\f\n\002\030\002\n\002\020\020\n\002\b\005\b\001\030\0002\b\022\004\022\0020\0000\001B\007\b\002¢\006\002\020\002j\002\b\003j\002\b\004j\002\b\005¨\006\006"}, d2={"Lkotlin/coroutines/intrinsics/CoroutineSingletons;", "", "(Ljava/lang/String;I)V", "COROUTINE_SUSPENDED", "UNDECIDED", "RESUMED", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public enum CoroutineSingletons
{
  static
  {
    CoroutineSingletons localCoroutineSingletons1 = new CoroutineSingletons("COROUTINE_SUSPENDED", 0);
    COROUTINE_SUSPENDED = localCoroutineSingletons1;
    CoroutineSingletons localCoroutineSingletons2 = new CoroutineSingletons("UNDECIDED", 1);
    UNDECIDED = localCoroutineSingletons2;
    CoroutineSingletons localCoroutineSingletons3 = new CoroutineSingletons("RESUMED", 2);
    RESUMED = localCoroutineSingletons3;
    $VALUES = new CoroutineSingletons[] { localCoroutineSingletons1, localCoroutineSingletons2, localCoroutineSingletons3 };
  }
  
  private CoroutineSingletons() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\intrinsics\CoroutineSingletons.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */