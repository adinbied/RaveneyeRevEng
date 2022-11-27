package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(bv={1, 0, 3}, d1={"\000|\n\000\n\002\030\002\n\002\020\r\n\002\b\003\n\002\020\b\n\002\b\003\n\002\020\016\n\002\b\002\n\002\020\013\n\002\b\003\n\002\020\f\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\036\n\002\b\n\n\002\030\002\n\002\b\b\n\002\020\031\n\002\b\006\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020 \n\002\b\b\n\002\020\021\n\002\b\017\n\002\030\002\n\002\030\002\n\002\b\033\032\034\020\t\032\0020\n*\0020\0022\006\020\013\032\0020\0022\b\b\002\020\f\032\0020\r\032\034\020\016\032\0020\n*\0020\0022\006\020\013\032\0020\0022\b\b\002\020\f\032\0020\r\032\037\020\017\032\0020\r*\0020\0022\006\020\020\032\0020\0212\b\b\002\020\f\032\0020\rH\002\032\037\020\017\032\0020\r*\0020\0022\006\020\013\032\0020\0022\b\b\002\020\f\032\0020\rH\002\032\025\020\017\032\0020\r*\0020\0022\006\020\022\032\0020\023H\n\032\034\020\024\032\0020\r*\0020\0022\006\020\020\032\0020\0212\b\b\002\020\f\032\0020\r\032\034\020\024\032\0020\r*\0020\0022\006\020\025\032\0020\0022\b\b\002\020\f\032\0020\r\032:\020\026\032\020\022\004\022\0020\006\022\004\022\0020\n\030\0010\027*\0020\0022\f\020\030\032\b\022\004\022\0020\n0\0312\b\b\002\020\032\032\0020\0062\b\b\002\020\f\032\0020\r\032E\020\026\032\020\022\004\022\0020\006\022\004\022\0020\n\030\0010\027*\0020\0022\f\020\030\032\b\022\004\022\0020\n0\0312\006\020\032\032\0020\0062\006\020\f\032\0020\r2\006\020\033\032\0020\rH\002¢\006\002\b\034\032:\020\035\032\020\022\004\022\0020\006\022\004\022\0020\n\030\0010\027*\0020\0022\f\020\030\032\b\022\004\022\0020\n0\0312\b\b\002\020\032\032\0020\0062\b\b\002\020\f\032\0020\r\032\022\020\036\032\0020\r*\0020\0022\006\020\037\032\0020\006\0324\020 \032\002H!\"\f\b\000\020\"*\0020\002*\002H!\"\004\b\001\020!*\002H\"2\f\020#\032\b\022\004\022\002H!0$H\b¢\006\002\020%\0324\020&\032\002H!\"\f\b\000\020\"*\0020\002*\002H!\"\004\b\001\020!*\002H\"2\f\020#\032\b\022\004\022\002H!0$H\b¢\006\002\020%\032&\020'\032\0020\006*\0020\0022\006\020\020\032\0020\0212\b\b\002\020\032\032\0020\0062\b\b\002\020\f\032\0020\r\032;\020'\032\0020\006*\0020\0022\006\020\013\032\0020\0022\006\020\032\032\0020\0062\006\020(\032\0020\0062\006\020\f\032\0020\r2\b\b\002\020\033\032\0020\rH\002¢\006\002\b)\032&\020'\032\0020\006*\0020\0022\006\020*\032\0020\n2\b\b\002\020\032\032\0020\0062\b\b\002\020\f\032\0020\r\032&\020+\032\0020\006*\0020\0022\006\020,\032\0020-2\b\b\002\020\032\032\0020\0062\b\b\002\020\f\032\0020\r\032,\020+\032\0020\006*\0020\0022\f\020\030\032\b\022\004\022\0020\n0\0312\b\b\002\020\032\032\0020\0062\b\b\002\020\f\032\0020\r\032\r\020.\032\0020\r*\0020\002H\b\032\r\020/\032\0020\r*\0020\002H\b\032\r\0200\032\0020\r*\0020\002H\b\032 \0201\032\0020\r*\004\030\0010\002H\b\002\016\n\f\b\000\022\002\030\001\032\004\b\003\020\000\032 \0202\032\0020\r*\004\030\0010\002H\b\002\016\n\f\b\000\022\002\030\001\032\004\b\003\020\000\032\r\0203\032\00204*\0020\002H\002\032&\0205\032\0020\006*\0020\0022\006\020\020\032\0020\0212\b\b\002\020\032\032\0020\0062\b\b\002\020\f\032\0020\r\032&\0205\032\0020\006*\0020\0022\006\020*\032\0020\n2\b\b\002\020\032\032\0020\0062\b\b\002\020\f\032\0020\r\032&\0206\032\0020\006*\0020\0022\006\020,\032\0020-2\b\b\002\020\032\032\0020\0062\b\b\002\020\f\032\0020\r\032,\0206\032\0020\006*\0020\0022\f\020\030\032\b\022\004\022\0020\n0\0312\b\b\002\020\032\032\0020\0062\b\b\002\020\f\032\0020\r\032\020\0207\032\b\022\004\022\0020\n08*\0020\002\032\020\0209\032\b\022\004\022\0020\n0:*\0020\002\032\025\020;\032\0020\r*\0020\0022\006\020\022\032\0020\023H\f\032\017\020<\032\0020\n*\004\030\0010\nH\b\032\034\020=\032\0020\002*\0020\0022\006\020>\032\0020\0062\b\b\002\020?\032\0020\021\032\034\020=\032\0020\n*\0020\n2\006\020>\032\0020\0062\b\b\002\020?\032\0020\021\032\034\020@\032\0020\002*\0020\0022\006\020>\032\0020\0062\b\b\002\020?\032\0020\021\032\034\020@\032\0020\n*\0020\n2\006\020>\032\0020\0062\b\b\002\020?\032\0020\021\032G\020A\032\b\022\004\022\0020\00108*\0020\0022\016\020B\032\n\022\006\b\001\022\0020\n0C2\b\b\002\020\032\032\0020\0062\b\b\002\020\f\032\0020\r2\b\b\002\020D\032\0020\006H\002¢\006\004\bE\020F\032=\020A\032\b\022\004\022\0020\00108*\0020\0022\006\020B\032\0020-2\b\b\002\020\032\032\0020\0062\b\b\002\020\f\032\0020\r2\b\b\002\020D\032\0020\006H\002¢\006\002\bE\0324\020G\032\0020\r*\0020\0022\006\020H\032\0020\0062\006\020\013\032\0020\0022\006\020I\032\0020\0062\006\020>\032\0020\0062\006\020\f\032\0020\rH\000\032\022\020J\032\0020\002*\0020\0022\006\020K\032\0020\002\032\022\020J\032\0020\n*\0020\n2\006\020K\032\0020\002\032\032\020L\032\0020\002*\0020\0022\006\020\032\032\0020\0062\006\020(\032\0020\006\032\022\020L\032\0020\002*\0020\0022\006\020M\032\0020\001\032\035\020L\032\0020\n*\0020\n2\006\020\032\032\0020\0062\006\020(\032\0020\006H\b\032\025\020L\032\0020\n*\0020\n2\006\020M\032\0020\001H\b\032\022\020N\032\0020\002*\0020\0022\006\020\025\032\0020\002\032\022\020N\032\0020\n*\0020\n2\006\020\025\032\0020\002\032\022\020O\032\0020\002*\0020\0022\006\020P\032\0020\002\032\032\020O\032\0020\002*\0020\0022\006\020K\032\0020\0022\006\020\025\032\0020\002\032\022\020O\032\0020\n*\0020\n2\006\020P\032\0020\002\032\032\020O\032\0020\n*\0020\n2\006\020K\032\0020\0022\006\020\025\032\0020\002\032+\020Q\032\0020\n*\0020\0022\006\020\022\032\0020\0232\024\b\b\020R\032\016\022\004\022\0020T\022\004\022\0020\0020SH\b\032\035\020Q\032\0020\n*\0020\0022\006\020\022\032\0020\0232\006\020U\032\0020\nH\b\032$\020V\032\0020\n*\0020\n2\006\020P\032\0020\0212\006\020U\032\0020\n2\b\b\002\020W\032\0020\n\032$\020V\032\0020\n*\0020\n2\006\020P\032\0020\n2\006\020U\032\0020\n2\b\b\002\020W\032\0020\n\032$\020X\032\0020\n*\0020\n2\006\020P\032\0020\0212\006\020U\032\0020\n2\b\b\002\020W\032\0020\n\032$\020X\032\0020\n*\0020\n2\006\020P\032\0020\n2\006\020U\032\0020\n2\b\b\002\020W\032\0020\n\032$\020Y\032\0020\n*\0020\n2\006\020P\032\0020\0212\006\020U\032\0020\n2\b\b\002\020W\032\0020\n\032$\020Y\032\0020\n*\0020\n2\006\020P\032\0020\n2\006\020U\032\0020\n2\b\b\002\020W\032\0020\n\032$\020Z\032\0020\n*\0020\n2\006\020P\032\0020\0212\006\020U\032\0020\n2\b\b\002\020W\032\0020\n\032$\020Z\032\0020\n*\0020\n2\006\020P\032\0020\n2\006\020U\032\0020\n2\b\b\002\020W\032\0020\n\032\035\020[\032\0020\n*\0020\0022\006\020\022\032\0020\0232\006\020U\032\0020\nH\b\032\"\020\\\032\0020\002*\0020\0022\006\020\032\032\0020\0062\006\020(\032\0020\0062\006\020U\032\0020\002\032\032\020\\\032\0020\002*\0020\0022\006\020M\032\0020\0012\006\020U\032\0020\002\032%\020\\\032\0020\n*\0020\n2\006\020\032\032\0020\0062\006\020(\032\0020\0062\006\020U\032\0020\002H\b\032\035\020\\\032\0020\n*\0020\n2\006\020M\032\0020\0012\006\020U\032\0020\002H\b\032=\020]\032\b\022\004\022\0020\n0:*\0020\0022\022\020B\032\n\022\006\b\001\022\0020\n0C\"\0020\n2\b\b\002\020\f\032\0020\r2\b\b\002\020D\032\0020\006¢\006\002\020^\0320\020]\032\b\022\004\022\0020\n0:*\0020\0022\n\020B\032\0020-\"\0020\0212\b\b\002\020\f\032\0020\r2\b\b\002\020D\032\0020\006\032/\020]\032\b\022\004\022\0020\n0:*\0020\0022\006\020P\032\0020\n2\006\020\f\032\0020\r2\006\020D\032\0020\006H\002¢\006\002\b_\032%\020]\032\b\022\004\022\0020\n0:*\0020\0022\006\020\022\032\0020\0232\b\b\002\020D\032\0020\006H\b\032=\020`\032\b\022\004\022\0020\n08*\0020\0022\022\020B\032\n\022\006\b\001\022\0020\n0C\"\0020\n2\b\b\002\020\f\032\0020\r2\b\b\002\020D\032\0020\006¢\006\002\020a\0320\020`\032\b\022\004\022\0020\n08*\0020\0022\n\020B\032\0020-\"\0020\0212\b\b\002\020\f\032\0020\r2\b\b\002\020D\032\0020\006\032\034\020b\032\0020\r*\0020\0022\006\020\020\032\0020\0212\b\b\002\020\f\032\0020\r\032\034\020b\032\0020\r*\0020\0022\006\020K\032\0020\0022\b\b\002\020\f\032\0020\r\032$\020b\032\0020\r*\0020\0022\006\020K\032\0020\0022\006\020\032\032\0020\0062\b\b\002\020\f\032\0020\r\032\022\020c\032\0020\002*\0020\0022\006\020M\032\0020\001\032\035\020c\032\0020\002*\0020\n2\006\020d\032\0020\0062\006\020e\032\0020\006H\b\032\037\020f\032\0020\n*\0020\0022\006\020\032\032\0020\0062\b\b\002\020(\032\0020\006H\b\032\022\020f\032\0020\n*\0020\0022\006\020M\032\0020\001\032\022\020f\032\0020\n*\0020\n2\006\020M\032\0020\001\032\034\020g\032\0020\n*\0020\n2\006\020P\032\0020\0212\b\b\002\020W\032\0020\n\032\034\020g\032\0020\n*\0020\n2\006\020P\032\0020\n2\b\b\002\020W\032\0020\n\032\034\020h\032\0020\n*\0020\n2\006\020P\032\0020\0212\b\b\002\020W\032\0020\n\032\034\020h\032\0020\n*\0020\n2\006\020P\032\0020\n2\b\b\002\020W\032\0020\n\032\034\020i\032\0020\n*\0020\n2\006\020P\032\0020\0212\b\b\002\020W\032\0020\n\032\034\020i\032\0020\n*\0020\n2\006\020P\032\0020\n2\b\b\002\020W\032\0020\n\032\034\020j\032\0020\n*\0020\n2\006\020P\032\0020\0212\b\b\002\020W\032\0020\n\032\034\020j\032\0020\n*\0020\n2\006\020P\032\0020\n2\b\b\002\020W\032\0020\n\032\n\020k\032\0020\002*\0020\002\032!\020k\032\0020\002*\0020\0022\022\020l\032\016\022\004\022\0020\021\022\004\022\0020\r0SH\b\032\026\020k\032\0020\002*\0020\0022\n\020,\032\0020-\"\0020\021\032\r\020k\032\0020\n*\0020\nH\b\032!\020k\032\0020\n*\0020\n2\022\020l\032\016\022\004\022\0020\021\022\004\022\0020\r0SH\b\032\026\020k\032\0020\n*\0020\n2\n\020,\032\0020-\"\0020\021\032\n\020m\032\0020\002*\0020\002\032!\020m\032\0020\002*\0020\0022\022\020l\032\016\022\004\022\0020\021\022\004\022\0020\r0SH\b\032\026\020m\032\0020\002*\0020\0022\n\020,\032\0020-\"\0020\021\032\r\020m\032\0020\n*\0020\nH\b\032!\020m\032\0020\n*\0020\n2\022\020l\032\016\022\004\022\0020\021\022\004\022\0020\r0SH\b\032\026\020m\032\0020\n*\0020\n2\n\020,\032\0020-\"\0020\021\032\n\020n\032\0020\002*\0020\002\032!\020n\032\0020\002*\0020\0022\022\020l\032\016\022\004\022\0020\021\022\004\022\0020\r0SH\b\032\026\020n\032\0020\002*\0020\0022\n\020,\032\0020-\"\0020\021\032\r\020n\032\0020\n*\0020\nH\b\032!\020n\032\0020\n*\0020\n2\022\020l\032\016\022\004\022\0020\021\022\004\022\0020\r0SH\b\032\026\020n\032\0020\n*\0020\n2\n\020,\032\0020-\"\0020\021\"\025\020\000\032\0020\001*\0020\0028F¢\006\006\032\004\b\003\020\004\"\025\020\005\032\0020\006*\0020\0028F¢\006\006\032\004\b\007\020\b¨\006o"}, d2={"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "ifBlank", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "chars", "", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "limit", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/text/StringsKt")
class StringsKt__StringsKt
  extends StringsKt__StringsJVMKt
{
  public static final String commonPrefixWith(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$commonPrefixWith");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "other");
    int j = Math.min(paramCharSequence1.length(), paramCharSequence2.length());
    int i = 0;
    while ((i < j) && (CharsKt.equals(paramCharSequence1.charAt(i), paramCharSequence2.charAt(i), paramBoolean))) {
      i += 1;
    }
    int k = i - 1;
    if (!StringsKt.hasSurrogatePairAt(paramCharSequence1, k))
    {
      j = i;
      if (!StringsKt.hasSurrogatePairAt(paramCharSequence2, k)) {}
    }
    else
    {
      j = i - 1;
    }
    return paramCharSequence1.subSequence(0, j).toString();
  }
  
  public static final String commonSuffixWith(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$commonSuffixWith");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "other");
    int k = paramCharSequence1.length();
    int m = paramCharSequence2.length();
    int j = Math.min(k, m);
    int i = 0;
    while ((i < j) && (CharsKt.equals(paramCharSequence1.charAt(k - i - 1), paramCharSequence2.charAt(m - i - 1), paramBoolean))) {
      i += 1;
    }
    if (!StringsKt.hasSurrogatePairAt(paramCharSequence1, k - i - 1))
    {
      j = i;
      if (!StringsKt.hasSurrogatePairAt(paramCharSequence2, m - i - 1)) {}
    }
    else
    {
      j = i - 1;
    }
    return paramCharSequence1.subSequence(k - j, k).toString();
  }
  
  public static final boolean contains(CharSequence paramCharSequence, char paramChar, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$contains");
    return StringsKt.indexOf$default(paramCharSequence, paramChar, 0, paramBoolean, 2, null) >= 0;
  }
  
  public static final boolean contains(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$contains");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "other");
    if ((paramCharSequence2 instanceof String))
    {
      if (StringsKt.indexOf$default(paramCharSequence1, (String)paramCharSequence2, 0, paramBoolean, 2, null) >= 0) {
        return true;
      }
    }
    else if (indexOf$StringsKt__StringsKt$default(paramCharSequence1, paramCharSequence2, 0, paramCharSequence1.length(), paramBoolean, false, 16, null) >= 0) {
      return true;
    }
    return false;
  }
  
  private static final boolean contains(CharSequence paramCharSequence, Regex paramRegex)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$contains");
    return paramRegex.containsMatchIn(paramCharSequence);
  }
  
  public static final boolean endsWith(CharSequence paramCharSequence, char paramChar, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$endsWith");
    return (paramCharSequence.length() > 0) && (CharsKt.equals(paramCharSequence.charAt(StringsKt.getLastIndex(paramCharSequence)), paramChar, paramBoolean));
  }
  
  public static final boolean endsWith(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$endsWith");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "suffix");
    if ((!paramBoolean) && ((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String))) {
      return StringsKt.endsWith$default((String)paramCharSequence1, (String)paramCharSequence2, false, 2, null);
    }
    return StringsKt.regionMatchesImpl(paramCharSequence1, paramCharSequence1.length() - paramCharSequence2.length(), paramCharSequence2, 0, paramCharSequence2.length(), paramBoolean);
  }
  
  public static final Pair<Integer, String> findAnyOf(CharSequence paramCharSequence, Collection<String> paramCollection, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$findAnyOf");
    Intrinsics.checkParameterIsNotNull(paramCollection, "strings");
    return findAnyOf$StringsKt__StringsKt(paramCharSequence, paramCollection, paramInt, paramBoolean, false);
  }
  
  private static final Pair<Integer, String> findAnyOf$StringsKt__StringsKt(CharSequence paramCharSequence, Collection<String> paramCollection, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (paramCollection.size() == 1))
    {
      paramCollection = (String)CollectionsKt.single((Iterable)paramCollection);
      if (!paramBoolean2) {
        paramInt = StringsKt.indexOf$default(paramCharSequence, paramCollection, paramInt, false, 4, null);
      } else {
        paramInt = StringsKt.lastIndexOf$default(paramCharSequence, paramCollection, paramInt, false, 4, null);
      }
      if (paramInt < 0) {
        return null;
      }
      return TuplesKt.to(Integer.valueOf(paramInt), paramCollection);
    }
    Object localObject;
    if (!paramBoolean2) {
      localObject = (IntProgression)new IntRange(RangesKt.coerceAtLeast(paramInt, 0), paramCharSequence.length());
    } else {
      localObject = RangesKt.downTo(RangesKt.coerceAtMost(paramInt, StringsKt.getLastIndex(paramCharSequence)), 0);
    }
    int i;
    int j;
    Iterator localIterator;
    String str;
    if ((paramCharSequence instanceof String))
    {
      paramInt = ((IntProgression)localObject).getFirst();
      i = ((IntProgression)localObject).getLast();
      j = ((IntProgression)localObject).getStep();
      if (j >= 0 ? paramInt <= i : paramInt >= i) {
        for (;;)
        {
          localIterator = ((Iterable)paramCollection).iterator();
          while (localIterator.hasNext())
          {
            localObject = localIterator.next();
            str = (String)localObject;
            if (StringsKt.regionMatches(str, 0, (String)paramCharSequence, paramInt, str.length(), paramBoolean1)) {
              break label223;
            }
          }
          localObject = null;
          label223:
          localObject = (String)localObject;
          if (localObject != null) {
            return TuplesKt.to(Integer.valueOf(paramInt), localObject);
          }
          if (paramInt == i) {
            break;
          }
          paramInt += j;
        }
      }
    }
    else
    {
      paramInt = ((IntProgression)localObject).getFirst();
      i = ((IntProgression)localObject).getLast();
      j = ((IntProgression)localObject).getStep();
      if (j >= 0 ? paramInt <= i : paramInt >= i) {
        for (;;)
        {
          localIterator = ((Iterable)paramCollection).iterator();
          while (localIterator.hasNext())
          {
            localObject = localIterator.next();
            str = (String)localObject;
            if (StringsKt.regionMatchesImpl((CharSequence)str, 0, paramCharSequence, paramInt, str.length(), paramBoolean1)) {
              break label362;
            }
          }
          localObject = null;
          label362:
          localObject = (String)localObject;
          if (localObject != null) {
            return TuplesKt.to(Integer.valueOf(paramInt), localObject);
          }
          if (paramInt == i) {
            break;
          }
          paramInt += j;
        }
      }
    }
    return null;
  }
  
  public static final Pair<Integer, String> findLastAnyOf(CharSequence paramCharSequence, Collection<String> paramCollection, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$findLastAnyOf");
    Intrinsics.checkParameterIsNotNull(paramCollection, "strings");
    return findAnyOf$StringsKt__StringsKt(paramCharSequence, paramCollection, paramInt, paramBoolean, true);
  }
  
  public static final IntRange getIndices(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$indices");
    return new IntRange(0, paramCharSequence.length() - 1);
  }
  
  public static final int getLastIndex(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$lastIndex");
    return paramCharSequence.length() - 1;
  }
  
  public static final boolean hasSurrogatePairAt(CharSequence paramCharSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$hasSurrogatePairAt");
    int i = paramCharSequence.length();
    return (paramInt >= 0) && (i - 2 >= paramInt) && (Character.isHighSurrogate(paramCharSequence.charAt(paramInt))) && (Character.isLowSurrogate(paramCharSequence.charAt(paramInt + 1)));
  }
  
  private static final <C extends CharSequence,  extends R, R> R ifBlank(C paramC, Function0<? extends R> paramFunction0)
  {
    Object localObject = paramC;
    if (StringsKt.isBlank(paramC)) {
      localObject = paramFunction0.invoke();
    }
    return (R)localObject;
  }
  
  private static final <C extends CharSequence,  extends R, R> R ifEmpty(C paramC, Function0<? extends R> paramFunction0)
  {
    int i;
    if (paramC.length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramC = paramFunction0.invoke();
    }
    return paramC;
  }
  
  public static final int indexOf(CharSequence paramCharSequence, char paramChar, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$indexOf");
    if ((!paramBoolean) && ((paramCharSequence instanceof String))) {
      return ((String)paramCharSequence).indexOf(paramChar, paramInt);
    }
    return StringsKt.indexOfAny(paramCharSequence, new char[] { paramChar }, paramInt, paramBoolean);
  }
  
  public static final int indexOf(CharSequence paramCharSequence, String paramString, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$indexOf");
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    if ((!paramBoolean) && ((paramCharSequence instanceof String))) {
      return ((String)paramCharSequence).indexOf(paramString, paramInt);
    }
    return indexOf$StringsKt__StringsKt$default(paramCharSequence, (CharSequence)paramString, paramInt, paramCharSequence.length(), paramBoolean, false, 16, null);
  }
  
  private static final int indexOf$StringsKt__StringsKt(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    IntProgression localIntProgression;
    if (!paramBoolean2) {
      localIntProgression = (IntProgression)new IntRange(RangesKt.coerceAtLeast(paramInt1, 0), RangesKt.coerceAtMost(paramInt2, paramCharSequence1.length()));
    } else {
      localIntProgression = RangesKt.downTo(RangesKt.coerceAtMost(paramInt1, StringsKt.getLastIndex(paramCharSequence1)), RangesKt.coerceAtLeast(paramInt2, 0));
    }
    int i;
    if (((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String)))
    {
      paramInt1 = localIntProgression.getFirst();
      paramInt2 = localIntProgression.getLast();
      i = localIntProgression.getStep();
      if (i >= 0 ? paramInt1 <= paramInt2 : paramInt1 >= paramInt2) {
        for (;;)
        {
          if (StringsKt.regionMatches((String)paramCharSequence2, 0, (String)paramCharSequence1, paramInt1, paramCharSequence2.length(), paramBoolean1)) {
            return paramInt1;
          }
          if (paramInt1 == paramInt2) {
            break;
          }
          paramInt1 += i;
        }
      }
    }
    else
    {
      paramInt1 = localIntProgression.getFirst();
      paramInt2 = localIntProgression.getLast();
      i = localIntProgression.getStep();
      if (i >= 0 ? paramInt1 <= paramInt2 : paramInt1 >= paramInt2) {
        for (;;)
        {
          if (StringsKt.regionMatchesImpl(paramCharSequence2, 0, paramCharSequence1, paramInt1, paramCharSequence2.length(), paramBoolean1)) {
            return paramInt1;
          }
          if (paramInt1 == paramInt2) {
            break;
          }
          paramInt1 += i;
        }
      }
    }
    return -1;
  }
  
  public static final int indexOfAny(CharSequence paramCharSequence, Collection<String> paramCollection, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$indexOfAny");
    Intrinsics.checkParameterIsNotNull(paramCollection, "strings");
    paramCharSequence = findAnyOf$StringsKt__StringsKt(paramCharSequence, paramCollection, paramInt, paramBoolean, false);
    if (paramCharSequence != null)
    {
      paramCharSequence = (Integer)paramCharSequence.getFirst();
      if (paramCharSequence != null) {
        return paramCharSequence.intValue();
      }
    }
    return -1;
  }
  
  public static final int indexOfAny(CharSequence paramCharSequence, char[] paramArrayOfChar, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$indexOfAny");
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "chars");
    int i;
    if ((!paramBoolean) && (paramArrayOfChar.length == 1) && ((paramCharSequence instanceof String)))
    {
      i = ArraysKt.single(paramArrayOfChar);
      return ((String)paramCharSequence).indexOf(i, paramInt);
    }
    paramInt = RangesKt.coerceAtLeast(paramInt, 0);
    int j = StringsKt.getLastIndex(paramCharSequence);
    if (paramInt <= j) {
      for (;;)
      {
        char c = paramCharSequence.charAt(paramInt);
        int k = paramArrayOfChar.length;
        i = 0;
        while (i < k)
        {
          if (CharsKt.equals(paramArrayOfChar[i], c, paramBoolean))
          {
            i = 1;
            break label120;
          }
          i += 1;
        }
        i = 0;
        label120:
        if (i != 0) {
          return paramInt;
        }
        if (paramInt == j) {
          break;
        }
        paramInt += 1;
      }
    }
    return -1;
  }
  
  private static final boolean isEmpty(CharSequence paramCharSequence)
  {
    return paramCharSequence.length() == 0;
  }
  
  private static final boolean isNotBlank(CharSequence paramCharSequence)
  {
    return StringsKt.isBlank(paramCharSequence) ^ true;
  }
  
  private static final boolean isNotEmpty(CharSequence paramCharSequence)
  {
    return paramCharSequence.length() > 0;
  }
  
  private static final boolean isNullOrBlank(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (StringsKt.isBlank(paramCharSequence));
  }
  
  private static final boolean isNullOrEmpty(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (paramCharSequence.length() == 0);
  }
  
  public static final CharIterator iterator(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$iterator");
    (CharIterator)new CharIterator()
    {
      private int index;
      
      public boolean hasNext()
      {
        return this.index < this.$this_iterator.length();
      }
      
      public char nextChar()
      {
        CharSequence localCharSequence = this.$this_iterator;
        int i = this.index;
        this.index = (i + 1);
        return localCharSequence.charAt(i);
      }
    };
  }
  
  public static final int lastIndexOf(CharSequence paramCharSequence, char paramChar, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$lastIndexOf");
    if ((!paramBoolean) && ((paramCharSequence instanceof String))) {
      return ((String)paramCharSequence).lastIndexOf(paramChar, paramInt);
    }
    return StringsKt.lastIndexOfAny(paramCharSequence, new char[] { paramChar }, paramInt, paramBoolean);
  }
  
  public static final int lastIndexOf(CharSequence paramCharSequence, String paramString, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$lastIndexOf");
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    if ((!paramBoolean) && ((paramCharSequence instanceof String))) {
      return ((String)paramCharSequence).lastIndexOf(paramString, paramInt);
    }
    return indexOf$StringsKt__StringsKt(paramCharSequence, (CharSequence)paramString, paramInt, 0, paramBoolean, true);
  }
  
  public static final int lastIndexOfAny(CharSequence paramCharSequence, Collection<String> paramCollection, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$lastIndexOfAny");
    Intrinsics.checkParameterIsNotNull(paramCollection, "strings");
    paramCharSequence = findAnyOf$StringsKt__StringsKt(paramCharSequence, paramCollection, paramInt, paramBoolean, true);
    if (paramCharSequence != null)
    {
      paramCharSequence = (Integer)paramCharSequence.getFirst();
      if (paramCharSequence != null) {
        return paramCharSequence.intValue();
      }
    }
    return -1;
  }
  
  public static final int lastIndexOfAny(CharSequence paramCharSequence, char[] paramArrayOfChar, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$lastIndexOfAny");
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "chars");
    int i;
    if ((!paramBoolean) && (paramArrayOfChar.length == 1) && ((paramCharSequence instanceof String)))
    {
      i = ArraysKt.single(paramArrayOfChar);
      return ((String)paramCharSequence).lastIndexOf(i, paramInt);
    }
    paramInt = RangesKt.coerceAtMost(paramInt, StringsKt.getLastIndex(paramCharSequence));
    while (paramInt >= 0)
    {
      char c = paramCharSequence.charAt(paramInt);
      int m = paramArrayOfChar.length;
      int k = 0;
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        if (CharsKt.equals(paramArrayOfChar[i], c, paramBoolean))
        {
          j = 1;
          break;
        }
        i += 1;
      }
      if (j != 0) {
        return paramInt;
      }
      paramInt -= 1;
    }
    return -1;
  }
  
  public static final Sequence<String> lineSequence(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$lineSequence");
    return StringsKt.splitToSequence$default(paramCharSequence, new String[] { "\r\n", "\n", "\r" }, false, 0, 6, null);
  }
  
  public static final List<String> lines(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$lines");
    return SequencesKt.toList(StringsKt.lineSequence(paramCharSequence));
  }
  
  private static final boolean matches(CharSequence paramCharSequence, Regex paramRegex)
  {
    return paramRegex.matches(paramCharSequence);
  }
  
  private static final String orEmpty(String paramString)
  {
    if (paramString != null) {
      return paramString;
    }
    return "";
  }
  
  public static final CharSequence padEnd(CharSequence paramCharSequence, int paramInt, char paramChar)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$padEnd");
    if (paramInt >= 0)
    {
      if (paramInt <= paramCharSequence.length()) {
        return paramCharSequence.subSequence(0, paramCharSequence.length());
      }
      StringBuilder localStringBuilder = new StringBuilder(paramInt);
      localStringBuilder.append(paramCharSequence);
      int i = paramInt - paramCharSequence.length();
      paramInt = 1;
      if (1 <= i) {
        for (;;)
        {
          localStringBuilder.append(paramChar);
          if (paramInt == i) {
            break;
          }
          paramInt += 1;
        }
      }
      return (CharSequence)localStringBuilder;
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("Desired length ");
    paramCharSequence.append(paramInt);
    paramCharSequence.append(" is less than zero.");
    throw ((Throwable)new IllegalArgumentException(paramCharSequence.toString()));
  }
  
  public static final String padEnd(String paramString, int paramInt, char paramChar)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$padEnd");
    return StringsKt.padEnd((CharSequence)paramString, paramInt, paramChar).toString();
  }
  
  public static final CharSequence padStart(CharSequence paramCharSequence, int paramInt, char paramChar)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$padStart");
    if (paramInt >= 0)
    {
      if (paramInt <= paramCharSequence.length()) {
        return paramCharSequence.subSequence(0, paramCharSequence.length());
      }
      StringBuilder localStringBuilder = new StringBuilder(paramInt);
      int i = paramInt - paramCharSequence.length();
      paramInt = 1;
      if (1 <= i) {
        for (;;)
        {
          localStringBuilder.append(paramChar);
          if (paramInt == i) {
            break;
          }
          paramInt += 1;
        }
      }
      localStringBuilder.append(paramCharSequence);
      return (CharSequence)localStringBuilder;
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("Desired length ");
    paramCharSequence.append(paramInt);
    paramCharSequence.append(" is less than zero.");
    throw ((Throwable)new IllegalArgumentException(paramCharSequence.toString()));
  }
  
  public static final String padStart(String paramString, int paramInt, char paramChar)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$padStart");
    return StringsKt.padStart((CharSequence)paramString, paramInt, paramChar).toString();
  }
  
  private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence paramCharSequence, char[] paramArrayOfChar, int paramInt1, final boolean paramBoolean, int paramInt2)
  {
    int i;
    if (paramInt2 >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      (Sequence)new DelimitedRangesSequence(paramCharSequence, paramInt1, paramInt2, (Function2)new Lambda(paramArrayOfChar)
      {
        public final Pair<Integer, Integer> invoke(CharSequence paramAnonymousCharSequence, int paramAnonymousInt)
        {
          Intrinsics.checkParameterIsNotNull(paramAnonymousCharSequence, "$receiver");
          paramAnonymousInt = StringsKt.indexOfAny(paramAnonymousCharSequence, this.$delimiters, paramAnonymousInt, paramBoolean);
          if (paramAnonymousInt < 0) {
            return null;
          }
          return TuplesKt.to(Integer.valueOf(paramAnonymousInt), Integer.valueOf(1));
        }
      });
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("Limit must be non-negative, but was ");
    paramCharSequence.append(paramInt2);
    paramCharSequence.append('.');
    throw ((Throwable)new IllegalArgumentException(paramCharSequence.toString().toString()));
  }
  
  private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence paramCharSequence, String[] paramArrayOfString, int paramInt1, final boolean paramBoolean, int paramInt2)
  {
    int i;
    if (paramInt2 >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      (Sequence)new DelimitedRangesSequence(paramCharSequence, paramInt1, paramInt2, (Function2)new Lambda(ArraysKt.asList(paramArrayOfString))
      {
        public final Pair<Integer, Integer> invoke(CharSequence paramAnonymousCharSequence, int paramAnonymousInt)
        {
          Intrinsics.checkParameterIsNotNull(paramAnonymousCharSequence, "$receiver");
          paramAnonymousCharSequence = StringsKt__StringsKt.access$findAnyOf(paramAnonymousCharSequence, (Collection)this.$delimitersList, paramAnonymousInt, paramBoolean, false);
          if (paramAnonymousCharSequence != null) {
            return TuplesKt.to(paramAnonymousCharSequence.getFirst(), Integer.valueOf(((String)paramAnonymousCharSequence.getSecond()).length()));
          }
          return null;
        }
      });
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("Limit must be non-negative, but was ");
    paramCharSequence.append(paramInt2);
    paramCharSequence.append('.');
    throw ((Throwable)new IllegalArgumentException(paramCharSequence.toString().toString()));
  }
  
  public static final boolean regionMatchesImpl(CharSequence paramCharSequence1, int paramInt1, CharSequence paramCharSequence2, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$regionMatchesImpl");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "other");
    if ((paramInt2 >= 0) && (paramInt1 >= 0) && (paramInt1 <= paramCharSequence1.length() - paramInt3))
    {
      if (paramInt2 > paramCharSequence2.length() - paramInt3) {
        return false;
      }
      int i = 0;
      while (i < paramInt3)
      {
        if (!CharsKt.equals(paramCharSequence1.charAt(paramInt1 + i), paramCharSequence2.charAt(paramInt2 + i), paramBoolean)) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static final CharSequence removePrefix(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$removePrefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    if (StringsKt.startsWith$default(paramCharSequence1, paramCharSequence2, false, 2, null)) {
      return paramCharSequence1.subSequence(paramCharSequence2.length(), paramCharSequence1.length());
    }
    return paramCharSequence1.subSequence(0, paramCharSequence1.length());
  }
  
  public static final String removePrefix(String paramString, CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$removePrefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "prefix");
    String str = paramString;
    if (StringsKt.startsWith$default((CharSequence)paramString, paramCharSequence, false, 2, null))
    {
      str = paramString.substring(paramCharSequence.length());
      Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).substring(startIndex)");
    }
    return str;
  }
  
  public static final CharSequence removeRange(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$removeRange");
    if (paramInt2 >= paramInt1)
    {
      if (paramInt2 == paramInt1) {
        return paramCharSequence.subSequence(0, paramCharSequence.length());
      }
      StringBuilder localStringBuilder = new StringBuilder(paramCharSequence.length() - (paramInt2 - paramInt1));
      localStringBuilder.append(paramCharSequence, 0, paramInt1);
      localStringBuilder.append(paramCharSequence, paramInt2, paramCharSequence.length());
      return (CharSequence)localStringBuilder;
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("End index (");
    paramCharSequence.append(paramInt2);
    paramCharSequence.append(") is less than start index (");
    paramCharSequence.append(paramInt1);
    paramCharSequence.append(").");
    throw ((Throwable)new IndexOutOfBoundsException(paramCharSequence.toString()));
  }
  
  public static final CharSequence removeRange(CharSequence paramCharSequence, IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$removeRange");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "range");
    return StringsKt.removeRange(paramCharSequence, paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1);
  }
  
  private static final String removeRange(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString != null) {
      return StringsKt.removeRange((CharSequence)paramString, paramInt1, paramInt2).toString();
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
  }
  
  private static final String removeRange(String paramString, IntRange paramIntRange)
  {
    if (paramString != null) {
      return StringsKt.removeRange((CharSequence)paramString, paramIntRange).toString();
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
  }
  
  public static final CharSequence removeSuffix(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$removeSuffix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "suffix");
    if (StringsKt.endsWith$default(paramCharSequence1, paramCharSequence2, false, 2, null)) {
      return paramCharSequence1.subSequence(0, paramCharSequence1.length() - paramCharSequence2.length());
    }
    return paramCharSequence1.subSequence(0, paramCharSequence1.length());
  }
  
  public static final String removeSuffix(String paramString, CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$removeSuffix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "suffix");
    String str = paramString;
    if (StringsKt.endsWith$default((CharSequence)paramString, paramCharSequence, false, 2, null))
    {
      str = paramString.substring(0, paramString.length() - paramCharSequence.length());
      Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    return str;
  }
  
  public static final CharSequence removeSurrounding(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$removeSurrounding");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "delimiter");
    return StringsKt.removeSurrounding(paramCharSequence1, paramCharSequence2, paramCharSequence2);
  }
  
  public static final CharSequence removeSurrounding(CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$removeSurrounding");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence3, "suffix");
    if ((paramCharSequence1.length() >= paramCharSequence2.length() + paramCharSequence3.length()) && (StringsKt.startsWith$default(paramCharSequence1, paramCharSequence2, false, 2, null)) && (StringsKt.endsWith$default(paramCharSequence1, paramCharSequence3, false, 2, null))) {
      return paramCharSequence1.subSequence(paramCharSequence2.length(), paramCharSequence1.length() - paramCharSequence3.length());
    }
    return paramCharSequence1.subSequence(0, paramCharSequence1.length());
  }
  
  public static final String removeSurrounding(String paramString, CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$removeSurrounding");
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "delimiter");
    return StringsKt.removeSurrounding(paramString, paramCharSequence, paramCharSequence);
  }
  
  public static final String removeSurrounding(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$removeSurrounding");
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "suffix");
    String str = paramString;
    if (paramString.length() >= paramCharSequence1.length() + paramCharSequence2.length())
    {
      CharSequence localCharSequence = (CharSequence)paramString;
      str = paramString;
      if (StringsKt.startsWith$default(localCharSequence, paramCharSequence1, false, 2, null))
      {
        str = paramString;
        if (StringsKt.endsWith$default(localCharSequence, paramCharSequence2, false, 2, null))
        {
          str = paramString.substring(paramCharSequence1.length(), paramString.length() - paramCharSequence2.length());
          Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
      }
    }
    return str;
  }
  
  private static final String replace(CharSequence paramCharSequence, Regex paramRegex, String paramString)
  {
    return paramRegex.replace(paramCharSequence, paramString);
  }
  
  private static final String replace(CharSequence paramCharSequence, Regex paramRegex, Function1<? super MatchResult, ? extends CharSequence> paramFunction1)
  {
    return paramRegex.replace(paramCharSequence, paramFunction1);
  }
  
  public static final String replaceAfter(String paramString1, char paramChar, String paramString2, String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$replaceAfter");
    Intrinsics.checkParameterIsNotNull(paramString2, "replacement");
    Intrinsics.checkParameterIsNotNull(paramString3, "missingDelimiterValue");
    CharSequence localCharSequence = (CharSequence)paramString1;
    int i = StringsKt.indexOf$default(localCharSequence, paramChar, 0, false, 6, null);
    if (i == -1) {
      return paramString3;
    }
    return StringsKt.replaceRange(localCharSequence, i + 1, paramString1.length(), (CharSequence)paramString2).toString();
  }
  
  public static final String replaceAfter(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$replaceAfter");
    Intrinsics.checkParameterIsNotNull(paramString2, "delimiter");
    Intrinsics.checkParameterIsNotNull(paramString3, "replacement");
    Intrinsics.checkParameterIsNotNull(paramString4, "missingDelimiterValue");
    CharSequence localCharSequence = (CharSequence)paramString1;
    int i = StringsKt.indexOf$default(localCharSequence, paramString2, 0, false, 6, null);
    if (i == -1) {
      return paramString4;
    }
    return StringsKt.replaceRange(localCharSequence, i + paramString2.length(), paramString1.length(), (CharSequence)paramString3).toString();
  }
  
  public static final String replaceAfterLast(String paramString1, char paramChar, String paramString2, String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$replaceAfterLast");
    Intrinsics.checkParameterIsNotNull(paramString2, "replacement");
    Intrinsics.checkParameterIsNotNull(paramString3, "missingDelimiterValue");
    CharSequence localCharSequence = (CharSequence)paramString1;
    int i = StringsKt.lastIndexOf$default(localCharSequence, paramChar, 0, false, 6, null);
    if (i == -1) {
      return paramString3;
    }
    return StringsKt.replaceRange(localCharSequence, i + 1, paramString1.length(), (CharSequence)paramString2).toString();
  }
  
  public static final String replaceAfterLast(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$replaceAfterLast");
    Intrinsics.checkParameterIsNotNull(paramString2, "delimiter");
    Intrinsics.checkParameterIsNotNull(paramString3, "replacement");
    Intrinsics.checkParameterIsNotNull(paramString4, "missingDelimiterValue");
    CharSequence localCharSequence = (CharSequence)paramString1;
    int i = StringsKt.lastIndexOf$default(localCharSequence, paramString2, 0, false, 6, null);
    if (i == -1) {
      return paramString4;
    }
    return StringsKt.replaceRange(localCharSequence, i + paramString2.length(), paramString1.length(), (CharSequence)paramString3).toString();
  }
  
  public static final String replaceBefore(String paramString1, char paramChar, String paramString2, String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$replaceBefore");
    Intrinsics.checkParameterIsNotNull(paramString2, "replacement");
    Intrinsics.checkParameterIsNotNull(paramString3, "missingDelimiterValue");
    paramString1 = (CharSequence)paramString1;
    int i = StringsKt.indexOf$default(paramString1, paramChar, 0, false, 6, null);
    if (i == -1) {
      return paramString3;
    }
    return StringsKt.replaceRange(paramString1, 0, i, (CharSequence)paramString2).toString();
  }
  
  public static final String replaceBefore(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$replaceBefore");
    Intrinsics.checkParameterIsNotNull(paramString2, "delimiter");
    Intrinsics.checkParameterIsNotNull(paramString3, "replacement");
    Intrinsics.checkParameterIsNotNull(paramString4, "missingDelimiterValue");
    paramString1 = (CharSequence)paramString1;
    int i = StringsKt.indexOf$default(paramString1, paramString2, 0, false, 6, null);
    if (i == -1) {
      return paramString4;
    }
    return StringsKt.replaceRange(paramString1, 0, i, (CharSequence)paramString3).toString();
  }
  
  public static final String replaceBeforeLast(String paramString1, char paramChar, String paramString2, String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$replaceBeforeLast");
    Intrinsics.checkParameterIsNotNull(paramString2, "replacement");
    Intrinsics.checkParameterIsNotNull(paramString3, "missingDelimiterValue");
    paramString1 = (CharSequence)paramString1;
    int i = StringsKt.lastIndexOf$default(paramString1, paramChar, 0, false, 6, null);
    if (i == -1) {
      return paramString3;
    }
    return StringsKt.replaceRange(paramString1, 0, i, (CharSequence)paramString2).toString();
  }
  
  public static final String replaceBeforeLast(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$replaceBeforeLast");
    Intrinsics.checkParameterIsNotNull(paramString2, "delimiter");
    Intrinsics.checkParameterIsNotNull(paramString3, "replacement");
    Intrinsics.checkParameterIsNotNull(paramString4, "missingDelimiterValue");
    paramString1 = (CharSequence)paramString1;
    int i = StringsKt.lastIndexOf$default(paramString1, paramString2, 0, false, 6, null);
    if (i == -1) {
      return paramString4;
    }
    return StringsKt.replaceRange(paramString1, 0, i, (CharSequence)paramString3).toString();
  }
  
  private static final String replaceFirst(CharSequence paramCharSequence, Regex paramRegex, String paramString)
  {
    return paramRegex.replaceFirst(paramCharSequence, paramString);
  }
  
  public static final CharSequence replaceRange(CharSequence paramCharSequence1, int paramInt1, int paramInt2, CharSequence paramCharSequence2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$replaceRange");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "replacement");
    if (paramInt2 >= paramInt1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramCharSequence1, 0, paramInt1);
      localStringBuilder.append(paramCharSequence2);
      localStringBuilder.append(paramCharSequence1, paramInt2, paramCharSequence1.length());
      return (CharSequence)localStringBuilder;
    }
    paramCharSequence1 = new StringBuilder();
    paramCharSequence1.append("End index (");
    paramCharSequence1.append(paramInt2);
    paramCharSequence1.append(") is less than start index (");
    paramCharSequence1.append(paramInt1);
    paramCharSequence1.append(").");
    throw ((Throwable)new IndexOutOfBoundsException(paramCharSequence1.toString()));
  }
  
  public static final CharSequence replaceRange(CharSequence paramCharSequence1, IntRange paramIntRange, CharSequence paramCharSequence2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$replaceRange");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "range");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "replacement");
    return StringsKt.replaceRange(paramCharSequence1, paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1, paramCharSequence2);
  }
  
  private static final String replaceRange(String paramString, int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    if (paramString != null) {
      return StringsKt.replaceRange((CharSequence)paramString, paramInt1, paramInt2, paramCharSequence).toString();
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
  }
  
  private static final String replaceRange(String paramString, IntRange paramIntRange, CharSequence paramCharSequence)
  {
    if (paramString != null) {
      return StringsKt.replaceRange((CharSequence)paramString, paramIntRange, paramCharSequence).toString();
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
  }
  
  private static final List<String> split(CharSequence paramCharSequence, Regex paramRegex, int paramInt)
  {
    return paramRegex.split(paramCharSequence, paramInt);
  }
  
  public static final List<String> split(CharSequence paramCharSequence, char[] paramArrayOfChar, boolean paramBoolean, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$split");
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "delimiters");
    if (paramArrayOfChar.length == 1) {
      return split$StringsKt__StringsKt(paramCharSequence, String.valueOf(paramArrayOfChar[0]), paramBoolean, paramInt);
    }
    Object localObject = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(paramCharSequence, paramArrayOfChar, 0, paramBoolean, paramInt, 2, null));
    paramArrayOfChar = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramArrayOfChar.add(StringsKt.substring(paramCharSequence, (IntRange)((Iterator)localObject).next()));
    }
    return (List)paramArrayOfChar;
  }
  
  public static final List<String> split(CharSequence paramCharSequence, String[] paramArrayOfString, boolean paramBoolean, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$split");
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "delimiters");
    int j = paramArrayOfString.length;
    int i = 1;
    if (j == 1)
    {
      localObject = paramArrayOfString[0];
      if (((CharSequence)localObject).length() != 0) {
        i = 0;
      }
      if (i == 0) {
        return split$StringsKt__StringsKt(paramCharSequence, (String)localObject, paramBoolean, paramInt);
      }
    }
    Object localObject = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(paramCharSequence, paramArrayOfString, 0, paramBoolean, paramInt, 2, null));
    paramArrayOfString = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramArrayOfString.add(StringsKt.substring(paramCharSequence, (IntRange)((Iterator)localObject).next()));
    }
    return (List)paramArrayOfString;
  }
  
  private static final List<String> split$StringsKt__StringsKt(CharSequence paramCharSequence, String paramString, boolean paramBoolean, int paramInt)
  {
    int k = 0;
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      int m = StringsKt.indexOf(paramCharSequence, paramString, 0, paramBoolean);
      if ((m != -1) && (paramInt != 1))
      {
        if (paramInt > 0) {
          i = 1;
        } else {
          i = 0;
        }
        int j = 10;
        if (i != 0) {
          j = RangesKt.coerceAtMost(paramInt, 10);
        }
        ArrayList localArrayList = new ArrayList(j);
        j = m;
        int n;
        do
        {
          localArrayList.add(paramCharSequence.subSequence(k, j).toString());
          m = paramString.length() + j;
          if ((i != 0) && (localArrayList.size() == paramInt - 1)) {
            break;
          }
          n = StringsKt.indexOf(paramCharSequence, paramString, m, paramBoolean);
          k = m;
          j = n;
        } while (n != -1);
        localArrayList.add(paramCharSequence.subSequence(m, paramCharSequence.length()).toString());
        return (List)localArrayList;
      }
      return CollectionsKt.listOf(paramCharSequence.toString());
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("Limit must be non-negative, but was ");
    paramCharSequence.append(paramInt);
    paramCharSequence.append('.');
    throw ((Throwable)new IllegalArgumentException(paramCharSequence.toString().toString()));
  }
  
  public static final Sequence<String> splitToSequence(CharSequence paramCharSequence, char[] paramArrayOfChar, boolean paramBoolean, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$splitToSequence");
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "delimiters");
    SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(paramCharSequence, paramArrayOfChar, 0, paramBoolean, paramInt, 2, null), (Function1)new Lambda(paramCharSequence)
    {
      public final String invoke(IntRange paramAnonymousIntRange)
      {
        Intrinsics.checkParameterIsNotNull(paramAnonymousIntRange, "it");
        return StringsKt.substring(this.$this_splitToSequence, paramAnonymousIntRange);
      }
    });
  }
  
  public static final Sequence<String> splitToSequence(CharSequence paramCharSequence, String[] paramArrayOfString, boolean paramBoolean, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$splitToSequence");
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "delimiters");
    SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(paramCharSequence, paramArrayOfString, 0, paramBoolean, paramInt, 2, null), (Function1)new Lambda(paramCharSequence)
    {
      public final String invoke(IntRange paramAnonymousIntRange)
      {
        Intrinsics.checkParameterIsNotNull(paramAnonymousIntRange, "it");
        return StringsKt.substring(this.$this_splitToSequence, paramAnonymousIntRange);
      }
    });
  }
  
  public static final boolean startsWith(CharSequence paramCharSequence, char paramChar, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$startsWith");
    int i = paramCharSequence.length();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i > 0)
    {
      bool1 = bool2;
      if (CharsKt.equals(paramCharSequence.charAt(0), paramChar, paramBoolean)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static final boolean startsWith(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$startsWith");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    if ((!paramBoolean) && ((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String))) {
      return StringsKt.startsWith$default((String)paramCharSequence1, (String)paramCharSequence2, paramInt, false, 4, null);
    }
    return StringsKt.regionMatchesImpl(paramCharSequence1, paramInt, paramCharSequence2, 0, paramCharSequence2.length(), paramBoolean);
  }
  
  public static final boolean startsWith(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$startsWith");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    if ((!paramBoolean) && ((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String))) {
      return StringsKt.startsWith$default((String)paramCharSequence1, (String)paramCharSequence2, false, 2, null);
    }
    return StringsKt.regionMatchesImpl(paramCharSequence1, 0, paramCharSequence2, 0, paramCharSequence2.length(), paramBoolean);
  }
  
  public static final CharSequence subSequence(CharSequence paramCharSequence, IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$subSequence");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "range");
    return paramCharSequence.subSequence(paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1);
  }
  
  @Deprecated(message="Use parameters named startIndex and endIndex.", replaceWith=@ReplaceWith(expression="subSequence(startIndex = start, endIndex = end)", imports={}))
  private static final CharSequence subSequence(String paramString, int paramInt1, int paramInt2)
  {
    return paramString.subSequence(paramInt1, paramInt2);
  }
  
  private static final String substring(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    return paramCharSequence.subSequence(paramInt1, paramInt2).toString();
  }
  
  public static final String substring(CharSequence paramCharSequence, IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$substring");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "range");
    return paramCharSequence.subSequence(paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1).toString();
  }
  
  public static final String substring(String paramString, IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$substring");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "range");
    paramString = paramString.substring(paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    return paramString;
  }
  
  public static final String substringAfter(String paramString1, char paramChar, String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$substringAfter");
    Intrinsics.checkParameterIsNotNull(paramString2, "missingDelimiterValue");
    int i = StringsKt.indexOf$default((CharSequence)paramString1, paramChar, 0, false, 6, null);
    if (i == -1) {
      return paramString2;
    }
    paramString1 = paramString1.substring(i + 1, paramString1.length());
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    return paramString1;
  }
  
  public static final String substringAfter(String paramString1, String paramString2, String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$substringAfter");
    Intrinsics.checkParameterIsNotNull(paramString2, "delimiter");
    Intrinsics.checkParameterIsNotNull(paramString3, "missingDelimiterValue");
    int i = StringsKt.indexOf$default((CharSequence)paramString1, paramString2, 0, false, 6, null);
    if (i == -1) {
      return paramString3;
    }
    paramString1 = paramString1.substring(i + paramString2.length(), paramString1.length());
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    return paramString1;
  }
  
  public static final String substringAfterLast(String paramString1, char paramChar, String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$substringAfterLast");
    Intrinsics.checkParameterIsNotNull(paramString2, "missingDelimiterValue");
    int i = StringsKt.lastIndexOf$default((CharSequence)paramString1, paramChar, 0, false, 6, null);
    if (i == -1) {
      return paramString2;
    }
    paramString1 = paramString1.substring(i + 1, paramString1.length());
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    return paramString1;
  }
  
  public static final String substringAfterLast(String paramString1, String paramString2, String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$substringAfterLast");
    Intrinsics.checkParameterIsNotNull(paramString2, "delimiter");
    Intrinsics.checkParameterIsNotNull(paramString3, "missingDelimiterValue");
    int i = StringsKt.lastIndexOf$default((CharSequence)paramString1, paramString2, 0, false, 6, null);
    if (i == -1) {
      return paramString3;
    }
    paramString1 = paramString1.substring(i + paramString2.length(), paramString1.length());
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    return paramString1;
  }
  
  public static final String substringBefore(String paramString1, char paramChar, String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$substringBefore");
    Intrinsics.checkParameterIsNotNull(paramString2, "missingDelimiterValue");
    int i = StringsKt.indexOf$default((CharSequence)paramString1, paramChar, 0, false, 6, null);
    if (i == -1) {
      return paramString2;
    }
    paramString1 = paramString1.substring(0, i);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    return paramString1;
  }
  
  public static final String substringBefore(String paramString1, String paramString2, String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$substringBefore");
    Intrinsics.checkParameterIsNotNull(paramString2, "delimiter");
    Intrinsics.checkParameterIsNotNull(paramString3, "missingDelimiterValue");
    int i = StringsKt.indexOf$default((CharSequence)paramString1, paramString2, 0, false, 6, null);
    if (i == -1) {
      return paramString3;
    }
    paramString1 = paramString1.substring(0, i);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    return paramString1;
  }
  
  public static final String substringBeforeLast(String paramString1, char paramChar, String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$substringBeforeLast");
    Intrinsics.checkParameterIsNotNull(paramString2, "missingDelimiterValue");
    int i = StringsKt.lastIndexOf$default((CharSequence)paramString1, paramChar, 0, false, 6, null);
    if (i == -1) {
      return paramString2;
    }
    paramString1 = paramString1.substring(0, i);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    return paramString1;
  }
  
  public static final String substringBeforeLast(String paramString1, String paramString2, String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$substringBeforeLast");
    Intrinsics.checkParameterIsNotNull(paramString2, "delimiter");
    Intrinsics.checkParameterIsNotNull(paramString3, "missingDelimiterValue");
    int i = StringsKt.lastIndexOf$default((CharSequence)paramString1, paramString2, 0, false, 6, null);
    if (i == -1) {
      return paramString3;
    }
    paramString1 = paramString1.substring(0, i);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    return paramString1;
  }
  
  public static final CharSequence trim(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$trim");
    int j = paramCharSequence.length() - 1;
    int i = 0;
    int k = 0;
    while (i <= j)
    {
      int m;
      if (k == 0) {
        m = i;
      } else {
        m = j;
      }
      boolean bool = CharsKt.isWhitespace(paramCharSequence.charAt(m));
      if (k == 0)
      {
        if (!bool) {
          k = 1;
        } else {
          i += 1;
        }
      }
      else
      {
        if (!bool) {
          break;
        }
        j -= 1;
      }
    }
    return paramCharSequence.subSequence(i, j + 1);
  }
  
  public static final CharSequence trim(CharSequence paramCharSequence, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$trim");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramCharSequence.length() - 1;
    int i = 0;
    int k = 0;
    while (i <= j)
    {
      int m;
      if (k == 0) {
        m = i;
      } else {
        m = j;
      }
      boolean bool = ((Boolean)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(m)))).booleanValue();
      if (k == 0)
      {
        if (!bool) {
          k = 1;
        } else {
          i += 1;
        }
      }
      else
      {
        if (!bool) {
          break;
        }
        j -= 1;
      }
    }
    return paramCharSequence.subSequence(i, j + 1);
  }
  
  public static final CharSequence trim(CharSequence paramCharSequence, char... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$trim");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "chars");
    int j = paramCharSequence.length() - 1;
    int i = 0;
    int k = 0;
    while (i <= j)
    {
      int m;
      if (k == 0) {
        m = i;
      } else {
        m = j;
      }
      boolean bool = ArraysKt.contains(paramVarArgs, paramCharSequence.charAt(m));
      if (k == 0)
      {
        if (!bool) {
          k = 1;
        } else {
          i += 1;
        }
      }
      else
      {
        if (!bool) {
          break;
        }
        j -= 1;
      }
    }
    return paramCharSequence.subSequence(i, j + 1);
  }
  
  private static final String trim(String paramString)
  {
    if (paramString != null) {
      return StringsKt.trim((CharSequence)paramString).toString();
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
  }
  
  public static final String trim(String paramString, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$trim");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramString = (CharSequence)paramString;
    int j = paramString.length() - 1;
    int i = 0;
    int k = 0;
    while (i <= j)
    {
      int m;
      if (k == 0) {
        m = i;
      } else {
        m = j;
      }
      boolean bool = ((Boolean)paramFunction1.invoke(Character.valueOf(paramString.charAt(m)))).booleanValue();
      if (k == 0)
      {
        if (!bool) {
          k = 1;
        } else {
          i += 1;
        }
      }
      else
      {
        if (!bool) {
          break;
        }
        j -= 1;
      }
    }
    return paramString.subSequence(i, j + 1).toString();
  }
  
  public static final String trim(String paramString, char... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$trim");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "chars");
    paramString = (CharSequence)paramString;
    int j = paramString.length() - 1;
    int i = 0;
    int k = 0;
    while (i <= j)
    {
      int m;
      if (k == 0) {
        m = i;
      } else {
        m = j;
      }
      boolean bool = ArraysKt.contains(paramVarArgs, paramString.charAt(m));
      if (k == 0)
      {
        if (!bool) {
          k = 1;
        } else {
          i += 1;
        }
      }
      else
      {
        if (!bool) {
          break;
        }
        j -= 1;
      }
    }
    return paramString.subSequence(i, j + 1).toString();
  }
  
  public static final CharSequence trimEnd(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$trimEnd");
    int i = paramCharSequence.length();
    int j;
    do
    {
      j = i - 1;
      if (j < 0) {
        break;
      }
      i = j;
    } while (CharsKt.isWhitespace(paramCharSequence.charAt(j)));
    return paramCharSequence.subSequence(0, j + 1);
    return (CharSequence)"";
  }
  
  public static final CharSequence trimEnd(CharSequence paramCharSequence, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$trimEnd");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramCharSequence.length();
    int j;
    do
    {
      j = i - 1;
      if (j < 0) {
        break;
      }
      i = j;
    } while (((Boolean)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(j)))).booleanValue());
    return paramCharSequence.subSequence(0, j + 1);
    return (CharSequence)"";
  }
  
  public static final CharSequence trimEnd(CharSequence paramCharSequence, char... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$trimEnd");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "chars");
    int i = paramCharSequence.length();
    int j;
    do
    {
      j = i - 1;
      if (j < 0) {
        break;
      }
      i = j;
    } while (ArraysKt.contains(paramVarArgs, paramCharSequence.charAt(j)));
    return paramCharSequence.subSequence(0, j + 1);
    return (CharSequence)"";
  }
  
  private static final String trimEnd(String paramString)
  {
    if (paramString != null) {
      return StringsKt.trimEnd((CharSequence)paramString).toString();
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
  }
  
  public static final String trimEnd(String paramString, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$trimEnd");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramString = (CharSequence)paramString;
    int i = paramString.length();
    int j;
    do
    {
      j = i - 1;
      if (j < 0) {
        break;
      }
      i = j;
    } while (((Boolean)paramFunction1.invoke(Character.valueOf(paramString.charAt(j)))).booleanValue());
    paramString = paramString.subSequence(0, j + 1);
    break label82;
    paramString = (CharSequence)"";
    label82:
    return paramString.toString();
  }
  
  public static final String trimEnd(String paramString, char... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$trimEnd");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "chars");
    paramString = (CharSequence)paramString;
    int i = paramString.length();
    int j;
    do
    {
      j = i - 1;
      if (j < 0) {
        break;
      }
      i = j;
    } while (ArraysKt.contains(paramVarArgs, paramString.charAt(j)));
    paramString = paramString.subSequence(0, j + 1);
    break label71;
    paramString = (CharSequence)"";
    label71:
    return paramString.toString();
  }
  
  public static final CharSequence trimStart(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$trimStart");
    int j = paramCharSequence.length();
    int i = 0;
    while (i < j)
    {
      if (!CharsKt.isWhitespace(paramCharSequence.charAt(i))) {
        return paramCharSequence.subSequence(i, paramCharSequence.length());
      }
      i += 1;
    }
    return (CharSequence)"";
  }
  
  public static final CharSequence trimStart(CharSequence paramCharSequence, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$trimStart");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramCharSequence.length();
    int i = 0;
    while (i < j)
    {
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)))).booleanValue()) {
        return paramCharSequence.subSequence(i, paramCharSequence.length());
      }
      i += 1;
    }
    return (CharSequence)"";
  }
  
  public static final CharSequence trimStart(CharSequence paramCharSequence, char... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$trimStart");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "chars");
    int j = paramCharSequence.length();
    int i = 0;
    while (i < j)
    {
      if (!ArraysKt.contains(paramVarArgs, paramCharSequence.charAt(i))) {
        return paramCharSequence.subSequence(i, paramCharSequence.length());
      }
      i += 1;
    }
    return (CharSequence)"";
  }
  
  private static final String trimStart(String paramString)
  {
    if (paramString != null) {
      return StringsKt.trimStart((CharSequence)paramString).toString();
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
  }
  
  public static final String trimStart(String paramString, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$trimStart");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramString = (CharSequence)paramString;
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(paramString.charAt(i)))).booleanValue())
      {
        paramString = paramString.subSequence(i, paramString.length());
        break label89;
      }
      i += 1;
    }
    paramString = (CharSequence)"";
    label89:
    return paramString.toString();
  }
  
  public static final String trimStart(String paramString, char... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$trimStart");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "chars");
    paramString = (CharSequence)paramString;
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if (!ArraysKt.contains(paramVarArgs, paramString.charAt(i)))
      {
        paramString = paramString.subSequence(i, paramString.length());
        break label78;
      }
      i += 1;
    }
    paramString = (CharSequence)"";
    label78:
    return paramString.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\text\StringsKt__StringsKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */