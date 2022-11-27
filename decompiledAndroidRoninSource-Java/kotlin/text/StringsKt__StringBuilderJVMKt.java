package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000T\n\000\n\002\030\002\n\002\030\002\n\000\n\002\020\f\n\002\020\r\n\002\030\002\n\002\030\002\n\002\030\002\n\002\020\000\n\002\020\013\n\002\020\005\n\002\020\031\n\002\020\006\n\002\020\007\n\002\020\b\n\002\020\t\n\002\020\n\n\002\020\016\n\002\b\002\n\002\020\002\n\002\b\002\032\022\020\000\032\0060\001j\002`\002*\0060\001j\002`\002\032\035\020\000\032\0060\001j\002`\002*\0060\001j\002`\0022\006\020\003\032\0020\004H\b\032\037\020\000\032\0060\001j\002`\002*\0060\001j\002`\0022\b\020\003\032\004\030\0010\005H\b\032\022\020\000\032\0060\006j\002`\007*\0060\006j\002`\007\032\037\020\000\032\0060\006j\002`\007*\0060\006j\002`\0072\b\020\003\032\004\030\0010\bH\b\032\037\020\000\032\0060\006j\002`\007*\0060\006j\002`\0072\b\020\003\032\004\030\0010\tH\b\032\035\020\000\032\0060\006j\002`\007*\0060\006j\002`\0072\006\020\003\032\0020\nH\b\032\035\020\000\032\0060\006j\002`\007*\0060\006j\002`\0072\006\020\003\032\0020\013H\b\032\035\020\000\032\0060\006j\002`\007*\0060\006j\002`\0072\006\020\003\032\0020\004H\b\032\035\020\000\032\0060\006j\002`\007*\0060\006j\002`\0072\006\020\003\032\0020\fH\b\032\037\020\000\032\0060\006j\002`\007*\0060\006j\002`\0072\b\020\003\032\004\030\0010\005H\b\032\035\020\000\032\0060\006j\002`\007*\0060\006j\002`\0072\006\020\003\032\0020\rH\b\032\035\020\000\032\0060\006j\002`\007*\0060\006j\002`\0072\006\020\003\032\0020\016H\b\032\035\020\000\032\0060\006j\002`\007*\0060\006j\002`\0072\006\020\003\032\0020\017H\b\032\035\020\000\032\0060\006j\002`\007*\0060\006j\002`\0072\006\020\003\032\0020\020H\b\032\035\020\000\032\0060\006j\002`\007*\0060\006j\002`\0072\006\020\003\032\0020\021H\b\032\037\020\000\032\0060\006j\002`\007*\0060\006j\002`\0072\b\020\003\032\004\030\0010\022H\b\032%\020\000\032\0060\006j\002`\007*\0060\006j\002`\0072\016\020\003\032\n\030\0010\006j\004\030\001`\007H\b\032\024\020\023\032\0060\006j\002`\007*\0060\006j\002`\007H\007\032!\020\024\032\0020\025*\0060\006j\002`\0072\006\020\026\032\0020\0172\006\020\003\032\0020\004H\n¨\006\027"}, d2={"appendln", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "value", "", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Ljava/lang/StringBuffer;", "", "", "", "", "", "", "", "", "", "", "clear", "set", "", "index", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/text/StringsKt")
class StringsKt__StringBuilderJVMKt
  extends StringsKt__RegexExtensionsKt
{
  public static final Appendable appendln(Appendable paramAppendable)
  {
    Intrinsics.checkParameterIsNotNull(paramAppendable, "$this$appendln");
    paramAppendable = paramAppendable.append((CharSequence)SystemProperties.LINE_SEPARATOR);
    Intrinsics.checkExpressionValueIsNotNull(paramAppendable, "append(SystemProperties.LINE_SEPARATOR)");
    return paramAppendable;
  }
  
  private static final Appendable appendln(Appendable paramAppendable, char paramChar)
  {
    paramAppendable = paramAppendable.append(paramChar);
    Intrinsics.checkExpressionValueIsNotNull(paramAppendable, "append(value)");
    return StringsKt.appendln(paramAppendable);
  }
  
  private static final Appendable appendln(Appendable paramAppendable, CharSequence paramCharSequence)
  {
    paramAppendable = paramAppendable.append(paramCharSequence);
    Intrinsics.checkExpressionValueIsNotNull(paramAppendable, "append(value)");
    return StringsKt.appendln(paramAppendable);
  }
  
  public static final StringBuilder appendln(StringBuilder paramStringBuilder)
  {
    Intrinsics.checkParameterIsNotNull(paramStringBuilder, "$this$appendln");
    paramStringBuilder.append(SystemProperties.LINE_SEPARATOR);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(SystemProperties.LINE_SEPARATOR)");
    return paramStringBuilder;
  }
  
  private static final StringBuilder appendln(StringBuilder paramStringBuilder, byte paramByte)
  {
    paramStringBuilder.append(paramByte);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(value.toInt())");
    return StringsKt.appendln(paramStringBuilder);
  }
  
  private static final StringBuilder appendln(StringBuilder paramStringBuilder, char paramChar)
  {
    paramStringBuilder.append(paramChar);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(value)");
    return StringsKt.appendln(paramStringBuilder);
  }
  
  private static final StringBuilder appendln(StringBuilder paramStringBuilder, double paramDouble)
  {
    paramStringBuilder.append(paramDouble);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(value)");
    return StringsKt.appendln(paramStringBuilder);
  }
  
  private static final StringBuilder appendln(StringBuilder paramStringBuilder, float paramFloat)
  {
    paramStringBuilder.append(paramFloat);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(value)");
    return StringsKt.appendln(paramStringBuilder);
  }
  
  private static final StringBuilder appendln(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder.append(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(value)");
    return StringsKt.appendln(paramStringBuilder);
  }
  
  private static final StringBuilder appendln(StringBuilder paramStringBuilder, long paramLong)
  {
    paramStringBuilder.append(paramLong);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(value)");
    return StringsKt.appendln(paramStringBuilder);
  }
  
  private static final StringBuilder appendln(StringBuilder paramStringBuilder, CharSequence paramCharSequence)
  {
    paramStringBuilder.append(paramCharSequence);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(value)");
    return StringsKt.appendln(paramStringBuilder);
  }
  
  private static final StringBuilder appendln(StringBuilder paramStringBuilder, Object paramObject)
  {
    paramStringBuilder.append(paramObject);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(value)");
    return StringsKt.appendln(paramStringBuilder);
  }
  
  private static final StringBuilder appendln(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append(paramString);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(value)");
    return StringsKt.appendln(paramStringBuilder);
  }
  
  private static final StringBuilder appendln(StringBuilder paramStringBuilder, StringBuffer paramStringBuffer)
  {
    paramStringBuilder.append(paramStringBuffer);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(value)");
    return StringsKt.appendln(paramStringBuilder);
  }
  
  private static final StringBuilder appendln(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    paramStringBuilder1.append((CharSequence)paramStringBuilder2);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder1, "append(value)");
    return StringsKt.appendln(paramStringBuilder1);
  }
  
  private static final StringBuilder appendln(StringBuilder paramStringBuilder, short paramShort)
  {
    paramStringBuilder.append(paramShort);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(value.toInt())");
    return StringsKt.appendln(paramStringBuilder);
  }
  
  private static final StringBuilder appendln(StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    paramStringBuilder.append(paramBoolean);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(value)");
    return StringsKt.appendln(paramStringBuilder);
  }
  
  private static final StringBuilder appendln(StringBuilder paramStringBuilder, char[] paramArrayOfChar)
  {
    paramStringBuilder.append(paramArrayOfChar);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(value)");
    return StringsKt.appendln(paramStringBuilder);
  }
  
  public static final StringBuilder clear(StringBuilder paramStringBuilder)
  {
    Intrinsics.checkParameterIsNotNull(paramStringBuilder, "$this$clear");
    paramStringBuilder.setLength(0);
    return paramStringBuilder;
  }
  
  private static final void set(StringBuilder paramStringBuilder, int paramInt, char paramChar)
  {
    Intrinsics.checkParameterIsNotNull(paramStringBuilder, "$this$set");
    paramStringBuilder.setCharAt(paramInt, paramChar);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\text\StringsKt__StringBuilderJVMKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */