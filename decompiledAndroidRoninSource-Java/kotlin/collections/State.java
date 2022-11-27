package kotlin.collections;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\f\n\002\030\002\n\002\020\020\n\002\b\006\b\001\030\0002\b\022\004\022\0020\0000\001B\007\b\002¢\006\002\020\002j\002\b\003j\002\b\004j\002\b\005j\002\b\006¨\006\007"}, d2={"Lkotlin/collections/State;", "", "(Ljava/lang/String;I)V", "Ready", "NotReady", "Done", "Failed", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
 enum State
{
  static
  {
    State localState1 = new State("Ready", 0);
    Ready = localState1;
    State localState2 = new State("NotReady", 1);
    NotReady = localState2;
    State localState3 = new State("Done", 2);
    Done = localState3;
    State localState4 = new State("Failed", 3);
    Failed = localState4;
    $VALUES = new State[] { localState1, localState2, localState3, localState4 };
  }
  
  private State() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\State.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */