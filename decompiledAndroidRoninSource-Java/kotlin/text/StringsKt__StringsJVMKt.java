package kotlin.text;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractList.Companion;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.sequences.SequencesKt;

@Metadata(bv={1, 0, 3}, d1={"\000~\n\000\n\002\030\002\n\002\020\016\n\002\030\002\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\022\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\002\n\002\020\031\n\000\n\002\020\025\n\002\b\002\n\002\030\002\n\002\b\t\n\002\020\013\n\002\b\004\n\002\020\r\n\002\b\t\n\002\020\021\n\002\020\000\n\002\b\b\n\002\020\f\n\002\b\021\n\002\020 \n\000\n\002\030\002\n\002\b\r\032\021\020\007\032\0020\0022\006\020\b\032\0020\tH\b\032\021\020\007\032\0020\0022\006\020\n\032\0020\013H\b\032\021\020\007\032\0020\0022\006\020\f\032\0020\rH\b\032\031\020\007\032\0020\0022\006\020\f\032\0020\r2\006\020\016\032\0020\017H\b\032!\020\007\032\0020\0022\006\020\f\032\0020\r2\006\020\020\032\0020\0212\006\020\022\032\0020\021H\b\032)\020\007\032\0020\0022\006\020\f\032\0020\r2\006\020\020\032\0020\0212\006\020\022\032\0020\0212\006\020\016\032\0020\017H\b\032\021\020\007\032\0020\0022\006\020\023\032\0020\024H\b\032!\020\007\032\0020\0022\006\020\023\032\0020\0242\006\020\020\032\0020\0212\006\020\022\032\0020\021H\b\032!\020\007\032\0020\0022\006\020\025\032\0020\0262\006\020\020\032\0020\0212\006\020\022\032\0020\021H\b\032\n\020\027\032\0020\002*\0020\002\032\024\020\027\032\0020\002*\0020\0022\006\020\030\032\0020\031H\007\032\025\020\032\032\0020\021*\0020\0022\006\020\033\032\0020\021H\b\032\025\020\034\032\0020\021*\0020\0022\006\020\033\032\0020\021H\b\032\035\020\035\032\0020\021*\0020\0022\006\020\036\032\0020\0212\006\020\037\032\0020\021H\b\032\034\020 \032\0020\021*\0020\0022\006\020!\032\0020\0022\b\b\002\020\"\032\0020#\032\f\020$\032\0020\002*\0020\024H\007\032 \020$\032\0020\002*\0020\0242\b\b\002\020%\032\0020\0212\b\b\002\020\037\032\0020\021H\007\032\025\020&\032\0020#*\0020\0022\006\020\n\032\0020\tH\b\032\025\020&\032\0020#*\0020\0022\006\020'\032\0020(H\b\032\n\020)\032\0020\002*\0020\002\032\024\020)\032\0020\002*\0020\0022\006\020\030\032\0020\031H\007\032\f\020*\032\0020\002*\0020\rH\007\032*\020*\032\0020\002*\0020\r2\b\b\002\020%\032\0020\0212\b\b\002\020\037\032\0020\0212\b\b\002\020+\032\0020#H\007\032\f\020,\032\0020\r*\0020\002H\007\032*\020,\032\0020\r*\0020\0022\b\b\002\020%\032\0020\0212\b\b\002\020\037\032\0020\0212\b\b\002\020+\032\0020#H\007\032\034\020-\032\0020#*\0020\0022\006\020.\032\0020\0022\b\b\002\020\"\032\0020#\032 \020/\032\0020#*\004\030\0010\0022\b\020!\032\004\030\0010\0022\b\b\002\020\"\032\0020#\0322\0200\032\0020\002*\0020\0022\006\020\030\032\0020\0312\026\0201\032\f\022\b\b\001\022\004\030\0010302\"\004\030\00103H\b¢\006\002\0204\032*\0200\032\0020\002*\0020\0022\026\0201\032\f\022\b\b\001\022\004\030\0010302\"\004\030\00103H\b¢\006\002\0205\032:\0200\032\0020\002*\0020\0042\006\020\030\032\0020\0312\006\0200\032\0020\0022\026\0201\032\f\022\b\b\001\022\004\030\0010302\"\004\030\00103H\b¢\006\002\0206\0322\0200\032\0020\002*\0020\0042\006\0200\032\0020\0022\026\0201\032\f\022\b\b\001\022\004\030\0010302\"\004\030\00103H\b¢\006\002\0207\032\r\0208\032\0020\002*\0020\002H\b\032\n\0209\032\0020#*\0020(\032\035\020:\032\0020\021*\0020\0022\006\020;\032\0020<2\006\020=\032\0020\021H\b\032\035\020:\032\0020\021*\0020\0022\006\020>\032\0020\0022\006\020=\032\0020\021H\b\032\035\020?\032\0020\021*\0020\0022\006\020;\032\0020<2\006\020=\032\0020\021H\b\032\035\020?\032\0020\021*\0020\0022\006\020>\032\0020\0022\006\020=\032\0020\021H\b\032\035\020@\032\0020\021*\0020\0022\006\020\033\032\0020\0212\006\020A\032\0020\021H\b\0324\020B\032\0020#*\0020(2\006\020C\032\0020\0212\006\020!\032\0020(2\006\020D\032\0020\0212\006\020\022\032\0020\0212\b\b\002\020\"\032\0020#\0324\020B\032\0020#*\0020\0022\006\020C\032\0020\0212\006\020!\032\0020\0022\006\020D\032\0020\0212\006\020\022\032\0020\0212\b\b\002\020\"\032\0020#\032\022\020E\032\0020\002*\0020(2\006\020F\032\0020\021\032$\020G\032\0020\002*\0020\0022\006\020H\032\0020<2\006\020I\032\0020<2\b\b\002\020\"\032\0020#\032$\020G\032\0020\002*\0020\0022\006\020J\032\0020\0022\006\020K\032\0020\0022\b\b\002\020\"\032\0020#\032$\020L\032\0020\002*\0020\0022\006\020H\032\0020<2\006\020I\032\0020<2\b\b\002\020\"\032\0020#\032$\020L\032\0020\002*\0020\0022\006\020J\032\0020\0022\006\020K\032\0020\0022\b\b\002\020\"\032\0020#\032\"\020M\032\b\022\004\022\0020\0020N*\0020(2\006\020O\032\0020P2\b\b\002\020Q\032\0020\021\032\034\020R\032\0020#*\0020\0022\006\020S\032\0020\0022\b\b\002\020\"\032\0020#\032$\020R\032\0020#*\0020\0022\006\020S\032\0020\0022\006\020%\032\0020\0212\b\b\002\020\"\032\0020#\032\025\020T\032\0020\002*\0020\0022\006\020%\032\0020\021H\b\032\035\020T\032\0020\002*\0020\0022\006\020%\032\0020\0212\006\020\037\032\0020\021H\b\032\027\020U\032\0020\r*\0020\0022\b\b\002\020\016\032\0020\017H\b\032\r\020V\032\0020\024*\0020\002H\b\0323\020V\032\0020\024*\0020\0022\006\020W\032\0020\0242\b\b\002\020X\032\0020\0212\b\b\002\020%\032\0020\0212\b\b\002\020\037\032\0020\021H\b\032 \020V\032\0020\024*\0020\0022\b\b\002\020%\032\0020\0212\b\b\002\020\037\032\0020\021H\007\032\r\020Y\032\0020\002*\0020\002H\b\032\025\020Y\032\0020\002*\0020\0022\006\020\030\032\0020\031H\b\032\027\020Z\032\0020P*\0020\0022\b\b\002\020[\032\0020\021H\b\032\r\020\\\032\0020\002*\0020\002H\b\032\025\020\\\032\0020\002*\0020\0022\006\020\030\032\0020\031H\b\"%\020\000\032\022\022\004\022\0020\0020\001j\b\022\004\022\0020\002`\003*\0020\0048F¢\006\006\032\004\b\005\020\006¨\006]"}, d2={"CASE_INSENSITIVE_ORDER", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", "Lkotlin/String$Companion;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "String", "stringBuffer", "Ljava/lang/StringBuffer;", "stringBuilder", "Ljava/lang/StringBuilder;", "bytes", "", "charset", "Ljava/nio/charset/Charset;", "offset", "", "length", "chars", "", "codePoints", "", "capitalize", "locale", "Ljava/util/Locale;", "codePointAt", "index", "codePointBefore", "codePointCount", "beginIndex", "endIndex", "compareTo", "other", "ignoreCase", "", "concatToString", "startIndex", "contentEquals", "charSequence", "", "decapitalize", "decodeToString", "throwOnInvalidSequence", "encodeToByteArray", "endsWith", "suffix", "equals", "format", "args", "", "", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "intern", "isBlank", "nativeIndexOf", "ch", "", "fromIndex", "str", "nativeLastIndexOf", "offsetByCodePoints", "codePointOffset", "regionMatches", "thisOffset", "otherOffset", "repeat", "n", "replace", "oldChar", "newChar", "oldValue", "newValue", "replaceFirst", "split", "", "regex", "Ljava/util/regex/Pattern;", "limit", "startsWith", "prefix", "substring", "toByteArray", "toCharArray", "destination", "destinationOffset", "toLowerCase", "toPattern", "flags", "toUpperCase", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/text/StringsKt")
class StringsKt__StringsJVMKt
  extends StringsKt__StringNumberConversionsKt
{
  private static final String String(StringBuffer paramStringBuffer)
  {
    return new String(paramStringBuffer);
  }
  
  private static final String String(StringBuilder paramStringBuilder)
  {
    return new String(paramStringBuilder);
  }
  
  private static final String String(byte[] paramArrayOfByte)
  {
    return new String(paramArrayOfByte, Charsets.UTF_8);
  }
  
  private static final String String(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new String(paramArrayOfByte, paramInt1, paramInt2, Charsets.UTF_8);
  }
  
  private static final String String(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Charset paramCharset)
  {
    return new String(paramArrayOfByte, paramInt1, paramInt2, paramCharset);
  }
  
  private static final String String(byte[] paramArrayOfByte, Charset paramCharset)
  {
    return new String(paramArrayOfByte, paramCharset);
  }
  
  private static final String String(char[] paramArrayOfChar)
  {
    return new String(paramArrayOfChar);
  }
  
  private static final String String(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    return new String(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  private static final String String(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    return new String(paramArrayOfInt, paramInt1, paramInt2);
  }
  
  public static final String capitalize(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$capitalize");
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (Character.isLowerCase(paramString.charAt(0))))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String str = paramString.substring(0, 1);
      Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      if (str != null)
      {
        str = str.toUpperCase();
        Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).toUpperCase()");
        localStringBuilder.append(str);
        paramString = paramString.substring(1);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
        localStringBuilder.append(paramString);
        return localStringBuilder.toString();
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    return paramString;
  }
  
  public static final String capitalize(String paramString, Locale paramLocale)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$capitalize");
    Intrinsics.checkParameterIsNotNull(paramLocale, "locale");
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      char c1 = paramString.charAt(0);
      if (Character.isLowerCase(c1))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        char c2 = Character.toTitleCase(c1);
        if (c2 != Character.toUpperCase(c1))
        {
          localStringBuilder.append(c2);
        }
        else
        {
          String str = paramString.substring(0, 1);
          Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          if (str == null) {
            break label156;
          }
          paramLocale = str.toUpperCase(paramLocale);
          Intrinsics.checkExpressionValueIsNotNull(paramLocale, "(this as java.lang.String).toUpperCase(locale)");
          localStringBuilder.append(paramLocale);
        }
        paramString = paramString.substring(1);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
        localStringBuilder.append(paramString);
        paramString = localStringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(paramString, "StringBuilder().apply(builderAction).toString()");
        return paramString;
        label156:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    return paramString;
  }
  
  private static final int codePointAt(String paramString, int paramInt)
  {
    if (paramString != null) {
      return paramString.codePointAt(paramInt);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private static final int codePointBefore(String paramString, int paramInt)
  {
    if (paramString != null) {
      return paramString.codePointBefore(paramInt);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private static final int codePointCount(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString != null) {
      return paramString.codePointCount(paramInt1, paramInt2);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  public static final int compareTo(String paramString1, String paramString2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$compareTo");
    Intrinsics.checkParameterIsNotNull(paramString2, "other");
    if (paramBoolean) {
      return paramString1.compareToIgnoreCase(paramString2);
    }
    return paramString1.compareTo(paramString2);
  }
  
  public static final String concatToString(char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$concatToString");
    return new String(paramArrayOfChar);
  }
  
  public static final String concatToString(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$concatToString");
    AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(paramInt1, paramInt2, paramArrayOfChar.length);
    return new String(paramArrayOfChar, paramInt1, paramInt2 - paramInt1);
  }
  
  private static final boolean contentEquals(String paramString, CharSequence paramCharSequence)
  {
    if (paramString != null) {
      return paramString.contentEquals(paramCharSequence);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private static final boolean contentEquals(String paramString, StringBuffer paramStringBuffer)
  {
    if (paramString != null) {
      return paramString.contentEquals(paramStringBuffer);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  public static final String decapitalize(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$decapitalize");
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (Character.isUpperCase(paramString.charAt(0))))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String str = paramString.substring(0, 1);
      Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      if (str != null)
      {
        str = str.toLowerCase();
        Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).toLowerCase()");
        localStringBuilder.append(str);
        paramString = paramString.substring(1);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
        localStringBuilder.append(paramString);
        return localStringBuilder.toString();
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    return paramString;
  }
  
  public static final String decapitalize(String paramString, Locale paramLocale)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$decapitalize");
    Intrinsics.checkParameterIsNotNull(paramLocale, "locale");
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (!Character.isLowerCase(paramString.charAt(0))))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String str = paramString.substring(0, 1);
      Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      if (str != null)
      {
        paramLocale = str.toLowerCase(paramLocale);
        Intrinsics.checkExpressionValueIsNotNull(paramLocale, "(this as java.lang.String).toLowerCase(locale)");
        localStringBuilder.append(paramLocale);
        paramString = paramString.substring(1);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
        localStringBuilder.append(paramString);
        return localStringBuilder.toString();
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    return paramString;
  }
  
  public static final String decodeToString(byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$decodeToString");
    return new String(paramArrayOfByte, Charsets.UTF_8);
  }
  
  public static final String decodeToString(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$decodeToString");
    AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(paramInt1, paramInt2, paramArrayOfByte.length);
    if (!paramBoolean) {
      return new String(paramArrayOfByte, paramInt1, paramInt2 - paramInt1, Charsets.UTF_8);
    }
    paramArrayOfByte = Charsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2 - paramInt1)).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "decoder.decode(ByteBuffe…- startIndex)).toString()");
    return paramArrayOfByte;
  }
  
  public static final byte[] encodeToByteArray(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$encodeToByteArray");
    paramString = paramString.getBytes(Charsets.UTF_8);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
    return paramString;
  }
  
  public static final byte[] encodeToByteArray(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$encodeToByteArray");
    AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(paramInt1, paramInt2, paramString.length());
    if (!paramBoolean)
    {
      paramString = paramString.substring(paramInt1, paramInt2);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localObject = Charsets.UTF_8;
      if (paramString != null)
      {
        paramString = paramString.getBytes((Charset)localObject);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
        return paramString;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    paramString = Charsets.UTF_8.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).encode(CharBuffer.wrap((CharSequence)paramString, paramInt1, paramInt2));
    if ((paramString.hasArray()) && (paramString.arrayOffset() == 0))
    {
      paramInt1 = paramString.remaining();
      localObject = paramString.array();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      if (paramInt1 == localObject.length)
      {
        paramString = paramString.array();
        Intrinsics.checkExpressionValueIsNotNull(paramString, "byteBuffer.array()");
        return paramString;
      }
    }
    Object localObject = new byte[paramString.remaining()];
    paramString.get((byte[])localObject);
    return (byte[])localObject;
  }
  
  public static final boolean endsWith(String paramString1, String paramString2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$endsWith");
    Intrinsics.checkParameterIsNotNull(paramString2, "suffix");
    if (!paramBoolean) {
      return paramString1.endsWith(paramString2);
    }
    return StringsKt.regionMatches(paramString1, paramString1.length() - paramString2.length(), paramString2, 0, paramString2.length(), true);
  }
  
  public static final boolean equals(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramString1 == null) {
      return paramString2 == null;
    }
    if (!paramBoolean) {
      return paramString1.equals(paramString2);
    }
    return paramString1.equalsIgnoreCase(paramString2);
  }
  
  private static final String format(String paramString, Locale paramLocale, Object... paramVarArgs)
  {
    paramString = String.format(paramLocale, paramString, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    Intrinsics.checkExpressionValueIsNotNull(paramString, "java.lang.String.format(locale, this, *args)");
    return paramString;
  }
  
  private static final String format(String paramString, Object... paramVarArgs)
  {
    paramString = String.format(paramString, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    Intrinsics.checkExpressionValueIsNotNull(paramString, "java.lang.String.format(this, *args)");
    return paramString;
  }
  
  private static final String format(StringCompanionObject paramStringCompanionObject, String paramString, Object... paramVarArgs)
  {
    paramStringCompanionObject = String.format(paramString, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    Intrinsics.checkExpressionValueIsNotNull(paramStringCompanionObject, "java.lang.String.format(format, *args)");
    return paramStringCompanionObject;
  }
  
  private static final String format(StringCompanionObject paramStringCompanionObject, Locale paramLocale, String paramString, Object... paramVarArgs)
  {
    paramStringCompanionObject = String.format(paramLocale, paramString, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    Intrinsics.checkExpressionValueIsNotNull(paramStringCompanionObject, "java.lang.String.format(locale, format, *args)");
    return paramStringCompanionObject;
  }
  
  public static final Comparator<String> getCASE_INSENSITIVE_ORDER(StringCompanionObject paramStringCompanionObject)
  {
    Intrinsics.checkParameterIsNotNull(paramStringCompanionObject, "$this$CASE_INSENSITIVE_ORDER");
    paramStringCompanionObject = String.CASE_INSENSITIVE_ORDER;
    Intrinsics.checkExpressionValueIsNotNull(paramStringCompanionObject, "java.lang.String.CASE_INSENSITIVE_ORDER");
    return paramStringCompanionObject;
  }
  
  private static final String intern(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.intern();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).intern()");
      return paramString;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  public static final boolean isBlank(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$isBlank");
    int i = paramCharSequence.length();
    boolean bool = false;
    if (i != 0)
    {
      Object localObject = (Iterable)StringsKt.getIndices(paramCharSequence);
      if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty())) {}
      do
      {
        while (!((Iterator)localObject).hasNext())
        {
          i = 1;
          break;
          localObject = ((Iterable)localObject).iterator();
        }
      } while (CharsKt.isWhitespace(paramCharSequence.charAt(((IntIterator)localObject).nextInt())));
      i = 0;
      if (i == 0) {}
    }
    else
    {
      bool = true;
    }
    return bool;
  }
  
  private static final int nativeIndexOf(String paramString, char paramChar, int paramInt)
  {
    if (paramString != null) {
      return paramString.indexOf(paramChar, paramInt);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private static final int nativeIndexOf(String paramString1, String paramString2, int paramInt)
  {
    if (paramString1 != null) {
      return paramString1.indexOf(paramString2, paramInt);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private static final int nativeLastIndexOf(String paramString, char paramChar, int paramInt)
  {
    if (paramString != null) {
      return paramString.lastIndexOf(paramChar, paramInt);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private static final int nativeLastIndexOf(String paramString1, String paramString2, int paramInt)
  {
    if (paramString1 != null) {
      return paramString1.lastIndexOf(paramString2, paramInt);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private static final int offsetByCodePoints(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString != null) {
      return paramString.offsetByCodePoints(paramInt1, paramInt2);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  public static final boolean regionMatches(CharSequence paramCharSequence1, int paramInt1, CharSequence paramCharSequence2, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$regionMatches");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "other");
    if (((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String))) {
      return StringsKt.regionMatches((String)paramCharSequence1, paramInt1, (String)paramCharSequence2, paramInt2, paramInt3, paramBoolean);
    }
    return StringsKt.regionMatchesImpl(paramCharSequence1, paramInt1, paramCharSequence2, paramInt2, paramInt3, paramBoolean);
  }
  
  public static final boolean regionMatches(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$regionMatches");
    Intrinsics.checkParameterIsNotNull(paramString2, "other");
    if (!paramBoolean) {
      return paramString1.regionMatches(paramInt1, paramString2, paramInt2, paramInt3);
    }
    return paramString1.regionMatches(paramBoolean, paramInt1, paramString2, paramInt2, paramInt3);
  }
  
  public static final String repeat(CharSequence paramCharSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$repeat");
    int k = 0;
    int m = 1;
    int j;
    if (paramInt >= 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      String str = "";
      Object localObject = str;
      if (paramInt != 0) {
        if (paramInt != 1)
        {
          j = paramCharSequence.length();
          localObject = str;
          if (j != 0)
          {
            if (j != 1)
            {
              localObject = new StringBuilder(paramCharSequence.length() * paramInt);
              if (1 <= paramInt)
              {
                j = m;
                for (;;)
                {
                  ((StringBuilder)localObject).append(paramCharSequence);
                  if (j == paramInt) {
                    break;
                  }
                  j += 1;
                }
              }
              paramCharSequence = ((StringBuilder)localObject).toString();
              Intrinsics.checkExpressionValueIsNotNull(paramCharSequence, "sb.toString()");
              return paramCharSequence;
            }
            int i = paramCharSequence.charAt(0);
            paramCharSequence = new char[paramInt];
            j = k;
            while (j < paramInt)
            {
              paramCharSequence[j] = i;
              j += 1;
            }
            return new String(paramCharSequence);
          }
        }
        else
        {
          localObject = paramCharSequence.toString();
        }
      }
      return (String)localObject;
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("Count 'n' must be non-negative, but was ");
    paramCharSequence.append(paramInt);
    paramCharSequence.append('.');
    throw ((Throwable)new IllegalArgumentException(paramCharSequence.toString().toString()));
  }
  
  public static final String replace(String paramString, char paramChar1, char paramChar2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$replace");
    if (!paramBoolean)
    {
      paramString = paramString.replace(paramChar1, paramChar2);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…replace(oldChar, newChar)");
      return paramString;
    }
    return SequencesKt.joinToString$default(StringsKt.splitToSequence$default((CharSequence)paramString, new char[] { paramChar1 }, paramBoolean, 0, 4, null), (CharSequence)String.valueOf(paramChar2), null, null, 0, null, null, 62, null);
  }
  
  public static final String replace(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$replace");
    Intrinsics.checkParameterIsNotNull(paramString2, "oldValue");
    Intrinsics.checkParameterIsNotNull(paramString3, "newValue");
    return SequencesKt.joinToString$default(StringsKt.splitToSequence$default((CharSequence)paramString1, new String[] { paramString2 }, paramBoolean, 0, 4, null), (CharSequence)paramString3, null, null, 0, null, null, 62, null);
  }
  
  public static final String replaceFirst(String paramString, char paramChar1, char paramChar2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$replaceFirst");
    CharSequence localCharSequence = (CharSequence)paramString;
    int i = StringsKt.indexOf$default(localCharSequence, paramChar1, 0, paramBoolean, 2, null);
    if (i < 0) {
      return paramString;
    }
    return StringsKt.replaceRange(localCharSequence, i, i + 1, (CharSequence)String.valueOf(paramChar2)).toString();
  }
  
  public static final String replaceFirst(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$replaceFirst");
    Intrinsics.checkParameterIsNotNull(paramString2, "oldValue");
    Intrinsics.checkParameterIsNotNull(paramString3, "newValue");
    CharSequence localCharSequence = (CharSequence)paramString1;
    int i = StringsKt.indexOf$default(localCharSequence, paramString2, 0, paramBoolean, 2, null);
    if (i < 0) {
      return paramString1;
    }
    return StringsKt.replaceRange(localCharSequence, i, paramString2.length() + i, (CharSequence)paramString3).toString();
  }
  
  public static final List<String> split(CharSequence paramCharSequence, Pattern paramPattern, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$split");
    Intrinsics.checkParameterIsNotNull(paramPattern, "regex");
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      i = paramInt;
      if (paramInt == 0) {
        i = -1;
      }
      paramCharSequence = paramPattern.split(paramCharSequence, i);
      Intrinsics.checkExpressionValueIsNotNull(paramCharSequence, "regex.split(this, if (limit == 0) -1 else limit)");
      return ArraysKt.asList(paramCharSequence);
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("Limit must be non-negative, but was ");
    paramCharSequence.append(paramInt);
    paramCharSequence.append('.');
    throw ((Throwable)new IllegalArgumentException(paramCharSequence.toString().toString()));
  }
  
  public static final boolean startsWith(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$startsWith");
    Intrinsics.checkParameterIsNotNull(paramString2, "prefix");
    if (!paramBoolean) {
      return paramString1.startsWith(paramString2, paramInt);
    }
    return StringsKt.regionMatches(paramString1, paramInt, paramString2, 0, paramString2.length(), paramBoolean);
  }
  
  public static final boolean startsWith(String paramString1, String paramString2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$startsWith");
    Intrinsics.checkParameterIsNotNull(paramString2, "prefix");
    if (!paramBoolean) {
      return paramString1.startsWith(paramString2);
    }
    return StringsKt.regionMatches(paramString1, 0, paramString2, 0, paramString2.length(), paramBoolean);
  }
  
  private static final String substring(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      paramString = paramString.substring(paramInt);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
      return paramString;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private static final String substring(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString != null)
    {
      paramString = paramString.substring(paramInt1, paramInt2);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      return paramString;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private static final byte[] toByteArray(String paramString, Charset paramCharset)
  {
    if (paramString != null)
    {
      paramString = paramString.getBytes(paramCharset);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
      return paramString;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private static final char[] toCharArray(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.toCharArray();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).toCharArray()");
      return paramString;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  public static final char[] toCharArray(String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toCharArray");
    AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(paramInt1, paramInt2, paramString.length());
    char[] arrayOfChar = new char[paramInt2 - paramInt1];
    paramString.getChars(paramInt1, paramInt2, arrayOfChar, 0);
    return arrayOfChar;
  }
  
  private static final char[] toCharArray(String paramString, char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramString != null)
    {
      paramString.getChars(paramInt2, paramInt3, paramArrayOfChar, paramInt1);
      return paramArrayOfChar;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private static final String toLowerCase(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.toLowerCase();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).toLowerCase()");
      return paramString;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private static final String toLowerCase(String paramString, Locale paramLocale)
  {
    if (paramString != null)
    {
      paramString = paramString.toLowerCase(paramLocale);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).toLowerCase(locale)");
      return paramString;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private static final Pattern toPattern(String paramString, int paramInt)
  {
    paramString = Pattern.compile(paramString, paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "java.util.regex.Pattern.compile(this, flags)");
    return paramString;
  }
  
  private static final String toUpperCase(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.toUpperCase();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).toUpperCase()");
      return paramString;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private static final String toUpperCase(String paramString, Locale paramLocale)
  {
    if (paramString != null)
    {
      paramString = paramString.toUpperCase(paramLocale);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).toUpperCase(locale)");
      return paramString;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\text\StringsKt__StringsJVMKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */