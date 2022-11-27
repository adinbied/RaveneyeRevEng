package kotlin.text;

import kotlin.Metadata;
import kotlin.ranges.IntRange;

@Metadata(bv={1, 0, 3}, d1={"\000&\n\000\n\002\030\002\n\002\020\f\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\004\n\002\020\013\n\002\b\021\032\020\020\t\032\0020\n2\006\020\013\032\0020\nH\001\032\030\020\f\032\0020\n2\006\020\r\032\0020\0022\006\020\013\032\0020\nH\000\032\r\020\016\032\0020\017*\0020\002H\b\032\r\020\020\032\0020\017*\0020\002H\b\032\r\020\021\032\0020\017*\0020\002H\b\032\r\020\022\032\0020\017*\0020\002H\b\032\r\020\023\032\0020\017*\0020\002H\b\032\r\020\024\032\0020\017*\0020\002H\b\032\r\020\025\032\0020\017*\0020\002H\b\032\r\020\026\032\0020\017*\0020\002H\b\032\r\020\027\032\0020\017*\0020\002H\b\032\r\020\030\032\0020\017*\0020\002H\b\032\r\020\031\032\0020\017*\0020\002H\b\032\r\020\032\032\0020\017*\0020\002H\b\032\r\020\033\032\0020\017*\0020\002H\b\032\n\020\034\032\0020\017*\0020\002\032\r\020\035\032\0020\002*\0020\002H\b\032\r\020\036\032\0020\002*\0020\002H\b\032\r\020\037\032\0020\002*\0020\002H\b\"\025\020\000\032\0020\001*\0020\0028F¢\006\006\032\004\b\003\020\004\"\025\020\005\032\0020\006*\0020\0028F¢\006\006\032\004\b\007\020\b¨\006 "}, d2={"category", "Lkotlin/text/CharCategory;", "", "getCategory", "(C)Lkotlin/text/CharCategory;", "directionality", "Lkotlin/text/CharDirectionality;", "getDirectionality", "(C)Lkotlin/text/CharDirectionality;", "checkRadix", "", "radix", "digitOf", "char", "isDefined", "", "isDigit", "isHighSurrogate", "isISOControl", "isIdentifierIgnorable", "isJavaIdentifierPart", "isJavaIdentifierStart", "isLetter", "isLetterOrDigit", "isLowSurrogate", "isLowerCase", "isTitleCase", "isUpperCase", "isWhitespace", "toLowerCase", "toTitleCase", "toUpperCase", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/text/CharsKt")
class CharsKt__CharJVMKt
{
  public static final int checkRadix(int paramInt)
  {
    if ((2 <= paramInt) && (36 >= paramInt)) {
      return paramInt;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("radix ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" was not in valid range ");
    localStringBuilder.append(new IntRange(2, 36));
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString()));
  }
  
  public static final int digitOf(char paramChar, int paramInt)
  {
    return Character.digit(paramChar, paramInt);
  }
  
  public static final CharCategory getCategory(char paramChar)
  {
    return CharCategory.Companion.valueOf(Character.getType(paramChar));
  }
  
  public static final CharDirectionality getDirectionality(char paramChar)
  {
    return CharDirectionality.Companion.valueOf(Character.getDirectionality(paramChar));
  }
  
  private static final boolean isDefined(char paramChar)
  {
    return Character.isDefined(paramChar);
  }
  
  private static final boolean isDigit(char paramChar)
  {
    return Character.isDigit(paramChar);
  }
  
  private static final boolean isHighSurrogate(char paramChar)
  {
    return Character.isHighSurrogate(paramChar);
  }
  
  private static final boolean isISOControl(char paramChar)
  {
    return Character.isISOControl(paramChar);
  }
  
  private static final boolean isIdentifierIgnorable(char paramChar)
  {
    return Character.isIdentifierIgnorable(paramChar);
  }
  
  private static final boolean isJavaIdentifierPart(char paramChar)
  {
    return Character.isJavaIdentifierPart(paramChar);
  }
  
  private static final boolean isJavaIdentifierStart(char paramChar)
  {
    return Character.isJavaIdentifierStart(paramChar);
  }
  
  private static final boolean isLetter(char paramChar)
  {
    return Character.isLetter(paramChar);
  }
  
  private static final boolean isLetterOrDigit(char paramChar)
  {
    return Character.isLetterOrDigit(paramChar);
  }
  
  private static final boolean isLowSurrogate(char paramChar)
  {
    return Character.isLowSurrogate(paramChar);
  }
  
  private static final boolean isLowerCase(char paramChar)
  {
    return Character.isLowerCase(paramChar);
  }
  
  private static final boolean isTitleCase(char paramChar)
  {
    return Character.isTitleCase(paramChar);
  }
  
  private static final boolean isUpperCase(char paramChar)
  {
    return Character.isUpperCase(paramChar);
  }
  
  public static final boolean isWhitespace(char paramChar)
  {
    return (Character.isWhitespace(paramChar)) || (Character.isSpaceChar(paramChar));
  }
  
  private static final char toLowerCase(char paramChar)
  {
    return Character.toLowerCase(paramChar);
  }
  
  private static final char toTitleCase(char paramChar)
  {
    return Character.toTitleCase(paramChar);
  }
  
  private static final char toUpperCase(char paramChar)
  {
    return Character.toUpperCase(paramChar);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\text\CharsKt__CharJVMKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */