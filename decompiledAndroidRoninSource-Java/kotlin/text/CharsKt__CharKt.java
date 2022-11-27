package kotlin.text;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\024\n\000\n\002\020\013\n\002\020\f\n\002\b\004\n\002\020\016\n\000\032\034\020\000\032\0020\001*\0020\0022\006\020\003\032\0020\0022\b\b\002\020\004\032\0020\001\032\n\020\005\032\0020\001*\0020\002\032\025\020\006\032\0020\007*\0020\0022\006\020\003\032\0020\007H\n¨\006\b"}, d2={"equals", "", "", "other", "ignoreCase", "isSurrogate", "plus", "", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/text/CharsKt")
class CharsKt__CharKt
  extends CharsKt__CharJVMKt
{
  public static final boolean equals(char paramChar1, char paramChar2, boolean paramBoolean)
  {
    if (paramChar1 == paramChar2) {
      return true;
    }
    if (!paramBoolean) {
      return false;
    }
    if (Character.toUpperCase(paramChar1) == Character.toUpperCase(paramChar2)) {
      return true;
    }
    return Character.toLowerCase(paramChar1) == Character.toLowerCase(paramChar2);
  }
  
  public static final boolean isSurrogate(char paramChar)
  {
    return (55296 <= paramChar) && (57343 >= paramChar);
  }
  
  private static final String plus(char paramChar, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramChar));
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\text\CharsKt__CharKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */