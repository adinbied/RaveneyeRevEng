package kotlin.text;

import java.util.Iterator;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(bv={1, 0, 3}, d1={"\000>\n\000\n\002\020\"\n\000\n\002\030\002\n\002\020\020\n\000\n\002\020\b\n\000\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\r\n\002\b\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\034\n\000\032-\020\000\032\b\022\004\022\002H\0020\001\"\024\b\000\020\002\030\001*\0020\003*\b\022\004\022\002H\0020\0042\006\020\005\032\0020\006H\b\032\036\020\007\032\004\030\0010\b*\0020\t2\006\020\n\032\0020\0062\006\020\013\032\0020\fH\002\032\026\020\r\032\004\030\0010\b*\0020\t2\006\020\013\032\0020\fH\002\032\f\020\016\032\0020\017*\0020\020H\002\032\024\020\016\032\0020\017*\0020\0202\006\020\021\032\0020\006H\002\032\022\020\022\032\0020\006*\b\022\004\022\0020\0030\023H\002¨\006\024"}, d2={"fromInt", "", "T", "Lkotlin/text/FlagEnum;", "", "value", "", "findNext", "Lkotlin/text/MatchResult;", "Ljava/util/regex/Matcher;", "from", "input", "", "matchEntire", "range", "Lkotlin/ranges/IntRange;", "Ljava/util/regex/MatchResult;", "groupIndex", "toInt", "", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class RegexKt
{
  private static final MatchResult findNext(Matcher paramMatcher, int paramInt, CharSequence paramCharSequence)
  {
    if (!paramMatcher.find(paramInt)) {
      return null;
    }
    return (MatchResult)new MatcherMatchResult(paramMatcher, paramCharSequence);
  }
  
  private static final MatchResult matchEntire(Matcher paramMatcher, CharSequence paramCharSequence)
  {
    if (!paramMatcher.matches()) {
      return null;
    }
    return (MatchResult)new MatcherMatchResult(paramMatcher, paramCharSequence);
  }
  
  private static final IntRange range(java.util.regex.MatchResult paramMatchResult)
  {
    return RangesKt.until(paramMatchResult.start(), paramMatchResult.end());
  }
  
  private static final IntRange range(java.util.regex.MatchResult paramMatchResult, int paramInt)
  {
    return RangesKt.until(paramMatchResult.start(paramInt), paramMatchResult.end(paramInt));
  }
  
  private static final int toInt(Iterable<? extends FlagEnum> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext()) {
      i |= ((FlagEnum)paramIterable.next()).getValue();
    }
    return i;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\text\RegexKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */