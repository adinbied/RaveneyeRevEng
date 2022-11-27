package kotlin.text;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\bÂ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002R\020\020\003\032\0020\0048\006X\004¢\006\002\n\000¨\006\005"}, d2={"Lkotlin/text/ScreenFloatValueRegEx;", "", "()V", "value", "Lkotlin/text/Regex;", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
final class ScreenFloatValueRegEx
{
  public static final ScreenFloatValueRegEx INSTANCE = new ScreenFloatValueRegEx();
  public static final Regex value;
  
  static
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append('(');
    ((StringBuilder)localObject).append("(\\p{Digit}+)");
    ((StringBuilder)localObject).append("(\\.)?(");
    ((StringBuilder)localObject).append("(\\p{Digit}+)");
    ((StringBuilder)localObject).append("?)(");
    ((StringBuilder)localObject).append("[eE][+-]?(\\p{Digit}+)");
    ((StringBuilder)localObject).append(")?)|");
    ((StringBuilder)localObject).append("(\\.(");
    ((StringBuilder)localObject).append("(\\p{Digit}+)");
    ((StringBuilder)localObject).append(")(");
    ((StringBuilder)localObject).append("[eE][+-]?(\\p{Digit}+)");
    ((StringBuilder)localObject).append(")?)|");
    ((StringBuilder)localObject).append("((");
    ((StringBuilder)localObject).append("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))");
    ((StringBuilder)localObject).append(")[pP][+-]?");
    ((StringBuilder)localObject).append("(\\p{Digit}+)");
    ((StringBuilder)localObject).append(')');
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[\\x00-\\x20]*[+-]?(NaN|Infinity|((");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(")[fFdD]?))[\\x00-\\x20]*");
    value = new Regex(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\text\ScreenFloatValueRegEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */