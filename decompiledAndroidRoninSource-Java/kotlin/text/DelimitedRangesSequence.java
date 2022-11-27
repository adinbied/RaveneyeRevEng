package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;

@Metadata(bv={1, 0, 3}, d1={"\000:\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\r\n\000\n\002\020\b\n\002\b\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020(\n\000\b\002\030\0002\b\022\004\022\0020\0020\001BY\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\006\020\007\032\0020\006\022:\020\b\0326\022\004\022\0020\004\022\023\022\0210\006¢\006\f\b\n\022\b\b\013\022\004\b\b(\f\022\022\022\020\022\004\022\0020\006\022\004\022\0020\006\030\0010\r0\t¢\006\002\b\016¢\006\002\020\017J\017\020\020\032\b\022\004\022\0020\0020\021H\002RB\020\b\0326\022\004\022\0020\004\022\023\022\0210\006¢\006\f\b\n\022\b\b\013\022\004\b\b(\f\022\022\022\020\022\004\022\0020\006\022\004\022\0020\006\030\0010\r0\t¢\006\002\b\016X\004¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\007\032\0020\006X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000¨\006\022"}, d2={"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
final class DelimitedRangesSequence
  implements Sequence<IntRange>
{
  private final Function2<CharSequence, Integer, Pair<Integer, Integer>> getNextMatch;
  private final CharSequence input;
  private final int limit;
  private final int startIndex;
  
  public DelimitedRangesSequence(CharSequence paramCharSequence, int paramInt1, int paramInt2, Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>> paramFunction2)
  {
    this.input = paramCharSequence;
    this.startIndex = paramInt1;
    this.limit = paramInt2;
    this.getNextMatch = paramFunction2;
  }
  
  public Iterator<IntRange> iterator()
  {
    (Iterator)new Iterator()
    {
      private int counter;
      private int currentStartIndex;
      private IntRange nextItem;
      private int nextSearchIndex;
      private int nextState = -1;
      
      private final void calcNext()
      {
        int j = this.nextSearchIndex;
        int i = 0;
        if (j < 0)
        {
          this.nextState = 0;
          this.nextItem = ((IntRange)null);
          return;
        }
        if (DelimitedRangesSequence.access$getLimit$p(this.this$0) > 0)
        {
          j = this.counter + 1;
          this.counter = j;
          if (j >= DelimitedRangesSequence.access$getLimit$p(this.this$0)) {}
        }
        else
        {
          if (this.nextSearchIndex <= DelimitedRangesSequence.access$getInput$p(this.this$0).length()) {
            break label110;
          }
        }
        this.nextItem = new IntRange(this.currentStartIndex, StringsKt.getLastIndex(DelimitedRangesSequence.access$getInput$p(this.this$0)));
        this.nextSearchIndex = -1;
        break label237;
        label110:
        Pair localPair = (Pair)DelimitedRangesSequence.access$getGetNextMatch$p(this.this$0).invoke(DelimitedRangesSequence.access$getInput$p(this.this$0), Integer.valueOf(this.nextSearchIndex));
        if (localPair == null)
        {
          this.nextItem = new IntRange(this.currentStartIndex, StringsKt.getLastIndex(DelimitedRangesSequence.access$getInput$p(this.this$0)));
          this.nextSearchIndex = -1;
        }
        else
        {
          int k = ((Number)localPair.component1()).intValue();
          j = ((Number)localPair.component2()).intValue();
          this.nextItem = RangesKt.until(this.currentStartIndex, k);
          k += j;
          this.currentStartIndex = k;
          if (j == 0) {
            i = 1;
          }
          this.nextSearchIndex = (k + i);
        }
        label237:
        this.nextState = 1;
      }
      
      public final int getCounter()
      {
        return this.counter;
      }
      
      public final int getCurrentStartIndex()
      {
        return this.currentStartIndex;
      }
      
      public final IntRange getNextItem()
      {
        return this.nextItem;
      }
      
      public final int getNextSearchIndex()
      {
        return this.nextSearchIndex;
      }
      
      public final int getNextState()
      {
        return this.nextState;
      }
      
      public boolean hasNext()
      {
        if (this.nextState == -1) {
          calcNext();
        }
        return this.nextState == 1;
      }
      
      public IntRange next()
      {
        if (this.nextState == -1) {
          calcNext();
        }
        if (this.nextState != 0)
        {
          IntRange localIntRange = this.nextItem;
          if (localIntRange != null)
          {
            this.nextItem = ((IntRange)null);
            this.nextState = -1;
            return localIntRange;
          }
          throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
        }
        throw ((Throwable)new NoSuchElementException());
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
      }
      
      public final void setCounter(int paramAnonymousInt)
      {
        this.counter = paramAnonymousInt;
      }
      
      public final void setCurrentStartIndex(int paramAnonymousInt)
      {
        this.currentStartIndex = paramAnonymousInt;
      }
      
      public final void setNextItem(IntRange paramAnonymousIntRange)
      {
        this.nextItem = paramAnonymousIntRange;
      }
      
      public final void setNextSearchIndex(int paramAnonymousInt)
      {
        this.nextSearchIndex = paramAnonymousInt;
      }
      
      public final void setNextState(int paramAnonymousInt)
      {
        this.nextState = paramAnonymousInt;
      }
    };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\text\DelimitedRangesSequence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */