package kotlin.text;

import java.util.Set;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\030\n\000\n\002\030\002\n\002\020\016\n\000\n\002\020\"\n\002\030\002\n\002\b\002\032\r\020\000\032\0020\001*\0020\002H\b\032\033\020\000\032\0020\001*\0020\0022\f\020\003\032\b\022\004\022\0020\0050\004H\b\032\025\020\000\032\0020\001*\0020\0022\006\020\006\032\0020\005H\b¨\006\007"}, d2={"toRegex", "Lkotlin/text/Regex;", "", "options", "", "Lkotlin/text/RegexOption;", "option", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/text/StringsKt")
class StringsKt__RegexExtensionsKt
  extends StringsKt__RegexExtensionsJVMKt
{
  private static final Regex toRegex(String paramString)
  {
    return new Regex(paramString);
  }
  
  private static final Regex toRegex(String paramString, Set<? extends RegexOption> paramSet)
  {
    return new Regex(paramString, paramSet);
  }
  
  private static final Regex toRegex(String paramString, RegexOption paramRegexOption)
  {
    return new Regex(paramString, paramRegexOption);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\text\StringsKt__RegexExtensionsKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */