package kotlin.coroutines.experimental;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(bv={1, 0, 3}, d1={"\000:\n\000\n\002\020\b\n\002\030\002\n\002\b\006\n\002\020(\n\002\b\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\020\002\n\002\020\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\032M\020\b\032\b\022\004\022\002H\n0\t\"\004\b\000\020\n2/\b\001\020\013\032)\b\001\022\n\022\b\022\004\022\002H\n0\r\022\n\022\b\022\004\022\0020\0170\016\022\006\022\004\030\0010\0200\f¢\006\002\b\021H\007ø\001\000¢\006\002\020\022\032M\020\023\032\b\022\004\022\002H\n0\024\"\004\b\000\020\n2/\b\001\020\013\032)\b\001\022\n\022\b\022\004\022\002H\n0\r\022\n\022\b\022\004\022\0020\0170\016\022\006\022\004\030\0010\0200\f¢\006\002\b\021H\007ø\001\000¢\006\002\020\025\"\022\020\000\032\0060\001j\002`\002XT¢\006\002\n\000\"\022\020\003\032\0060\001j\002`\002XT¢\006\002\n\000\"\022\020\004\032\0060\001j\002`\002XT¢\006\002\n\000\"\022\020\005\032\0060\001j\002`\002XT¢\006\002\n\000\"\022\020\006\032\0060\001j\002`\002XT¢\006\002\n\000\"\022\020\007\032\0060\001j\002`\002XT¢\006\002\n\000*\f\b\002\020\026\"\0020\0012\0020\001\002\004\n\002\b\t¨\006\027"}, d2={"State_Done", "", "Lkotlin/coroutines/experimental/State;", "State_Failed", "State_ManyNotReady", "State_ManyReady", "State_NotReady", "State_Ready", "buildIterator", "", "T", "builderAction", "Lkotlin/Function2;", "Lkotlin/coroutines/experimental/SequenceBuilder;", "Lkotlin/coroutines/experimental/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Ljava/util/Iterator;", "buildSequence", "Lkotlin/sequences/Sequence;", "(Lkotlin/jvm/functions/Function2;)Lkotlin/sequences/Sequence;", "State", "kotlin-stdlib-coroutines"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/coroutines/experimental/SequenceBuilderKt")
class SequenceBuilderKt__SequenceBuilderKt
{
  private static final int State_Done = 4;
  private static final int State_Failed = 5;
  private static final int State_ManyNotReady = 1;
  private static final int State_ManyReady = 2;
  private static final int State_NotReady = 0;
  private static final int State_Ready = 3;
  
  public static final <T> Iterator<T> buildIterator(Function2<? super SequenceBuilder<? super T>, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "builderAction");
    SequenceBuilderIterator localSequenceBuilderIterator = new SequenceBuilderIterator();
    localSequenceBuilderIterator.setNextStep(IntrinsicsKt.createCoroutineUnchecked(paramFunction2, localSequenceBuilderIterator, (Continuation)localSequenceBuilderIterator));
    return (Iterator)localSequenceBuilderIterator;
  }
  
  public static final <T> Sequence<T> buildSequence(Function2<? super SequenceBuilder<? super T>, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "builderAction");
    (Sequence)new Sequence()
    {
      public Iterator<T> iterator()
      {
        return SequenceBuilderKt.buildIterator(this.$builderAction$inlined);
      }
    };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\experimental\SequenceBuilderKt__SequenceBuilderKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */