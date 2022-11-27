package kotlin.io;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\f\n\002\030\002\n\002\020\020\n\002\b\004\b\001\030\0002\b\022\004\022\0020\0000\001B\007\b\002¢\006\002\020\002j\002\b\003j\002\b\004¨\006\005"}, d2={"Lkotlin/io/OnErrorAction;", "", "(Ljava/lang/String;I)V", "SKIP", "TERMINATE", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public enum OnErrorAction
{
  static
  {
    OnErrorAction localOnErrorAction1 = new OnErrorAction("SKIP", 0);
    SKIP = localOnErrorAction1;
    OnErrorAction localOnErrorAction2 = new OnErrorAction("TERMINATE", 1);
    TERMINATE = localOnErrorAction2;
    $VALUES = new OnErrorAction[] { localOnErrorAction1, localOnErrorAction2 };
  }
  
  private OnErrorAction() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\io\OnErrorAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */