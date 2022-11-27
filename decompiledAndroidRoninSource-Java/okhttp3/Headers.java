package okhttp3;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;

@Metadata(bv={1, 0, 3}, d1={"\000f\n\002\030\002\n\002\020\034\n\002\030\002\n\002\020\016\n\000\n\002\020\021\n\002\b\003\n\002\020\b\n\002\b\002\n\002\020\t\n\000\n\002\020\013\n\000\n\002\020\000\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020(\n\002\b\002\n\002\020\"\n\000\n\002\030\002\n\002\b\002\n\002\020$\n\002\020 \n\002\b\006\030\000 '2\024\022\020\022\016\022\004\022\0020\003\022\004\022\0020\0030\0020\001:\002&'B\025\b\002\022\f\020\004\032\b\022\004\022\0020\0030\005¢\006\002\020\006J\006\020\013\032\0020\fJ\023\020\r\032\0020\0162\b\020\017\032\004\030\0010\020H\002J\023\020\021\032\004\030\0010\0032\006\020\022\032\0020\003H\002J\020\020\023\032\004\030\0010\0242\006\020\022\032\0020\003J\022\020\025\032\004\030\0010\0262\006\020\022\032\0020\003H\007J\b\020\027\032\0020\tH\026J\033\020\030\032\024\022\020\022\016\022\004\022\0020\003\022\004\022\0020\0030\0020\031H\002J\016\020\022\032\0020\0032\006\020\032\032\0020\tJ\f\020\033\032\b\022\004\022\0020\0030\034J\006\020\035\032\0020\036J\r\020\b\032\0020\tH\007¢\006\002\b\037J\030\020 \032\024\022\004\022\0020\003\022\n\022\b\022\004\022\0020\0030\"0!J\b\020#\032\0020\003H\026J\016\020$\032\0020\0032\006\020\032\032\0020\tJ\024\020%\032\b\022\004\022\0020\0030\"2\006\020\022\032\0020\003R\026\020\004\032\b\022\004\022\0020\0030\005X\004¢\006\004\n\002\020\007R\021\020\b\032\0020\t8G¢\006\006\032\004\b\b\020\n¨\006("}, d2={"Lokhttp3/Headers;", "", "Lkotlin/Pair;", "", "namesAndValues", "", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "size", "", "()I", "byteCount", "", "equals", "", "other", "", "get", "name", "getDate", "Ljava/util/Date;", "getInstant", "Ljava/time/Instant;", "hashCode", "iterator", "", "index", "names", "", "newBuilder", "Lokhttp3/Headers$Builder;", "-deprecated_size", "toMultimap", "", "", "toString", "value", "values", "Builder", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public final class Headers
  implements Iterable<Pair<? extends String, ? extends String>>, KMappedMarker
{
  public static final Companion Companion = new Companion(null);
  private final String[] namesAndValues;
  
  private Headers(String[] paramArrayOfString)
  {
    this.namesAndValues = paramArrayOfString;
  }
  
  @JvmStatic
  public static final Headers of(Map<String, String> paramMap)
  {
    return Companion.of(paramMap);
  }
  
  @JvmStatic
  public static final Headers of(String... paramVarArgs)
  {
    return Companion.of(paramVarArgs);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="size", imports={}))
  public final int -deprecated_size()
  {
    return size();
  }
  
  public final long byteCount()
  {
    String[] arrayOfString = this.namesAndValues;
    long l = arrayOfString.length * 2;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      l += this.namesAndValues[i].length();
      i += 1;
    }
    return l;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof Headers)) && (Arrays.equals(this.namesAndValues, ((Headers)paramObject).namesAndValues));
  }
  
  public final String get(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    return Companion.access$get(Companion, this.namesAndValues, paramString);
  }
  
  public final Date getDate(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    paramString = get(paramString);
    if (paramString != null) {
      return DatesKt.toHttpDateOrNull(paramString);
    }
    return null;
  }
  
  public final Instant getInstant(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    paramString = getDate(paramString);
    if (paramString != null) {
      return paramString.toInstant();
    }
    return null;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.namesAndValues);
  }
  
  public Iterator<Pair<String, String>> iterator()
  {
    int j = size();
    Pair[] arrayOfPair = new Pair[j];
    int i = 0;
    while (i < j)
    {
      arrayOfPair[i] = TuplesKt.to(name(i), value(i));
      i += 1;
    }
    return ArrayIteratorKt.iterator(arrayOfPair);
  }
  
  public final String name(int paramInt)
  {
    return this.namesAndValues[(paramInt * 2)];
  }
  
  public final Set<String> names()
  {
    Object localObject = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
    int j = size();
    int i = 0;
    while (i < j)
    {
      ((TreeSet)localObject).add(name(i));
      i += 1;
    }
    localObject = Collections.unmodifiableSet((Set)localObject);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Collections.unmodifiableSet(result)");
    return (Set<String>)localObject;
  }
  
  public final Builder newBuilder()
  {
    Builder localBuilder = new Builder();
    CollectionsKt.addAll((Collection)localBuilder.getNamesAndValues$okhttp(), this.namesAndValues);
    return localBuilder;
  }
  
  public final int size()
  {
    return this.namesAndValues.length / 2;
  }
  
  public final Map<String, List<String>> toMultimap()
  {
    TreeMap localTreeMap = new TreeMap(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
    int j = size();
    int i = 0;
    while (i < j)
    {
      Object localObject1 = name(i);
      Object localObject2 = Locale.US;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "Locale.US");
      if (localObject1 != null)
      {
        String str = ((String)localObject1).toLowerCase((Locale)localObject2);
        Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).toLowerCase(locale)");
        localObject2 = (List)localTreeMap.get(str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = (List)new ArrayList(2);
          ((Map)localTreeMap).put(str, localObject1);
        }
        ((List)localObject1).add(value(i));
        i += 1;
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    return (Map)localTreeMap;
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    int j = size();
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject).append(name(i));
      ((StringBuilder)localObject).append(": ");
      ((StringBuilder)localObject).append(value(i));
      ((StringBuilder)localObject).append("\n");
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "StringBuilder().apply(builderAction).toString()");
    return (String)localObject;
  }
  
  public final String value(int paramInt)
  {
    return this.namesAndValues[(paramInt * 2 + 1)];
  }
  
  public final List<String> values(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Object localObject1 = (List)null;
    int j = size();
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1;
      if (StringsKt.equals(paramString, name(i), true))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = (List)new ArrayList(2);
        }
        ((List)localObject2).add(value(i));
      }
      i += 1;
      localObject1 = localObject2;
    }
    if (localObject1 != null)
    {
      paramString = Collections.unmodifiableList((List)localObject1);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "Collections.unmodifiableList(result)");
      return paramString;
    }
    return CollectionsKt.emptyList();
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000,\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020!\n\002\020\016\n\002\b\006\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\b\030\0002\0020\001B\005¢\006\002\020\002J\016\020\b\032\0020\0002\006\020\t\032\0020\005J\030\020\b\032\0020\0002\006\020\n\032\0020\0052\006\020\013\032\0020\fH\007J\026\020\b\032\0020\0002\006\020\n\032\0020\0052\006\020\013\032\0020\rJ\026\020\b\032\0020\0002\006\020\n\032\0020\0052\006\020\013\032\0020\005J\016\020\016\032\0020\0002\006\020\017\032\0020\020J\025\020\021\032\0020\0002\006\020\t\032\0020\005H\000¢\006\002\b\022J\035\020\021\032\0020\0002\006\020\n\032\0020\0052\006\020\013\032\0020\005H\000¢\006\002\b\022J\026\020\023\032\0020\0002\006\020\n\032\0020\0052\006\020\013\032\0020\005J\006\020\024\032\0020\020J\023\020\025\032\004\030\0010\0052\006\020\n\032\0020\005H\002J\016\020\026\032\0020\0002\006\020\n\032\0020\005J\031\020\027\032\0020\0002\006\020\n\032\0020\0052\006\020\013\032\0020\fH\002J\031\020\027\032\0020\0002\006\020\n\032\0020\0052\006\020\013\032\0020\rH\002J\031\020\027\032\0020\0002\006\020\n\032\0020\0052\006\020\013\032\0020\005H\002R\032\020\003\032\b\022\004\022\0020\0050\004X\004¢\006\b\n\000\032\004\b\006\020\007¨\006\030"}, d2={"Lokhttp3/Headers$Builder;", "", "()V", "namesAndValues", "", "", "getNamesAndValues$okhttp", "()Ljava/util/List;", "add", "line", "name", "value", "Ljava/time/Instant;", "Ljava/util/Date;", "addAll", "headers", "Lokhttp3/Headers;", "addLenient", "addLenient$okhttp", "addUnsafeNonAscii", "build", "get", "removeAll", "set", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Builder
  {
    private final List<String> namesAndValues = (List)new ArrayList(20);
    
    public final Builder add(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "line");
      Object localObject = (Builder)this;
      int j = StringsKt.indexOf$default((CharSequence)paramString, ':', 0, false, 6, null);
      int i;
      if (j != -1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        String str = paramString.substring(0, j);
        Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (str != null)
        {
          str = StringsKt.trim((CharSequence)str).toString();
          paramString = paramString.substring(j + 1);
          Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
          ((Builder)localObject).add(str, paramString);
          return (Builder)localObject;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unexpected header: ");
      ((StringBuilder)localObject).append(paramString);
      throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
    }
    
    public final Builder add(String paramString1, String paramString2)
    {
      Intrinsics.checkParameterIsNotNull(paramString1, "name");
      Intrinsics.checkParameterIsNotNull(paramString2, "value");
      Builder localBuilder = (Builder)this;
      Headers.Companion.access$checkName(Headers.Companion, paramString1);
      Headers.Companion.access$checkValue(Headers.Companion, paramString2, paramString1);
      localBuilder.addLenient$okhttp(paramString1, paramString2);
      return localBuilder;
    }
    
    public final Builder add(String paramString, Instant paramInstant)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "name");
      Intrinsics.checkParameterIsNotNull(paramInstant, "value");
      Builder localBuilder = (Builder)this;
      localBuilder.add(paramString, new Date(paramInstant.toEpochMilli()));
      return localBuilder;
    }
    
    public final Builder add(String paramString, Date paramDate)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "name");
      Intrinsics.checkParameterIsNotNull(paramDate, "value");
      Builder localBuilder = (Builder)this;
      localBuilder.add(paramString, DatesKt.toHttpDateString(paramDate));
      return localBuilder;
    }
    
    public final Builder addAll(Headers paramHeaders)
    {
      Intrinsics.checkParameterIsNotNull(paramHeaders, "headers");
      Builder localBuilder = (Builder)this;
      int j = paramHeaders.size();
      int i = 0;
      while (i < j)
      {
        localBuilder.addLenient$okhttp(paramHeaders.name(i), paramHeaders.value(i));
        i += 1;
      }
      return localBuilder;
    }
    
    public final Builder addLenient$okhttp(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "line");
      Builder localBuilder = (Builder)this;
      int i = StringsKt.indexOf$default((CharSequence)paramString, ':', 1, false, 4, null);
      if (i != -1)
      {
        String str = paramString.substring(0, i);
        Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        paramString = paramString.substring(i + 1);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
        localBuilder.addLenient$okhttp(str, paramString);
        return localBuilder;
      }
      if (paramString.charAt(0) == ':')
      {
        paramString = paramString.substring(1);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
        localBuilder.addLenient$okhttp("", paramString);
        return localBuilder;
      }
      localBuilder.addLenient$okhttp("", paramString);
      return localBuilder;
    }
    
    public final Builder addLenient$okhttp(String paramString1, String paramString2)
    {
      Intrinsics.checkParameterIsNotNull(paramString1, "name");
      Intrinsics.checkParameterIsNotNull(paramString2, "value");
      Builder localBuilder = (Builder)this;
      localBuilder.namesAndValues.add(paramString1);
      localBuilder.namesAndValues.add(StringsKt.trim((CharSequence)paramString2).toString());
      return localBuilder;
    }
    
    public final Builder addUnsafeNonAscii(String paramString1, String paramString2)
    {
      Intrinsics.checkParameterIsNotNull(paramString1, "name");
      Intrinsics.checkParameterIsNotNull(paramString2, "value");
      Builder localBuilder = (Builder)this;
      Headers.Companion.access$checkName(Headers.Companion, paramString1);
      localBuilder.addLenient$okhttp(paramString1, paramString2);
      return localBuilder;
    }
    
    public final Headers build()
    {
      Object[] arrayOfObject = ((Collection)this.namesAndValues).toArray(new String[0]);
      if (arrayOfObject != null) {
        return new Headers((String[])arrayOfObject, null);
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    
    public final String get(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "name");
      IntProgression localIntProgression = RangesKt.step(RangesKt.downTo(this.namesAndValues.size() - 2, 0), 2);
      int i = localIntProgression.getFirst();
      int j = localIntProgression.getLast();
      int k = localIntProgression.getStep();
      if (k >= 0 ? i <= j : i >= j) {
        for (;;)
        {
          if (StringsKt.equals(paramString, (String)this.namesAndValues.get(i), true)) {
            return (String)this.namesAndValues.get(i + 1);
          }
          if (i == j) {
            break;
          }
          i += k;
        }
      }
      return null;
    }
    
    public final List<String> getNamesAndValues$okhttp()
    {
      return this.namesAndValues;
    }
    
    public final Builder removeAll(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "name");
      Builder localBuilder = (Builder)this;
      int j;
      for (int i = 0; i < localBuilder.namesAndValues.size(); i = j + 2)
      {
        j = i;
        if (StringsKt.equals(paramString, (String)localBuilder.namesAndValues.get(i), true))
        {
          localBuilder.namesAndValues.remove(i);
          localBuilder.namesAndValues.remove(i);
          j = i - 2;
        }
      }
      return localBuilder;
    }
    
    public final Builder set(String paramString1, String paramString2)
    {
      Intrinsics.checkParameterIsNotNull(paramString1, "name");
      Intrinsics.checkParameterIsNotNull(paramString2, "value");
      Builder localBuilder = (Builder)this;
      Headers.Companion.access$checkName(Headers.Companion, paramString1);
      Headers.Companion.access$checkValue(Headers.Companion, paramString2, paramString1);
      localBuilder.removeAll(paramString1);
      localBuilder.addLenient$okhttp(paramString1, paramString2);
      return localBuilder;
    }
    
    public final Builder set(String paramString, Instant paramInstant)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "name");
      Intrinsics.checkParameterIsNotNull(paramInstant, "value");
      return ((Builder)this).set(paramString, new Date(paramInstant.toEpochMilli()));
    }
    
    public final Builder set(String paramString, Date paramDate)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "name");
      Intrinsics.checkParameterIsNotNull(paramDate, "value");
      Builder localBuilder = (Builder)this;
      localBuilder.set(paramString, DatesKt.toHttpDateString(paramDate));
      return localBuilder;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\0002\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\002\n\000\n\002\020\016\n\002\b\004\n\002\020\021\n\002\b\002\n\002\030\002\n\002\b\004\n\002\020$\n\002\b\002\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\006H\002J\030\020\007\032\0020\0042\006\020\b\032\0020\0062\006\020\005\032\0020\006H\002J%\020\t\032\004\030\0010\0062\f\020\n\032\b\022\004\022\0020\0060\0132\006\020\005\032\0020\006H\002¢\006\002\020\fJ#\020\r\032\0020\0162\022\020\n\032\n\022\006\b\001\022\0020\0060\013\"\0020\006H\007¢\006\004\b\017\020\020J#\020\017\032\0020\0162\022\020\n\032\n\022\006\b\001\022\0020\0060\013\"\0020\006H\007¢\006\004\b\021\020\020J!\020\017\032\0020\0162\022\020\022\032\016\022\004\022\0020\006\022\004\022\0020\0060\023H\007¢\006\002\b\021J\035\020\024\032\0020\016*\016\022\004\022\0020\006\022\004\022\0020\0060\023H\007¢\006\002\b\017¨\006\025"}, d2={"Lokhttp3/Headers$Companion;", "", "()V", "checkName", "", "name", "", "checkValue", "value", "get", "namesAndValues", "", "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "headersOf", "Lokhttp3/Headers;", "of", "([Ljava/lang/String;)Lokhttp3/Headers;", "-deprecated_of", "headers", "", "toHeaders", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    private final void checkName(String paramString)
    {
      int i;
      if (((CharSequence)paramString).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        int k = paramString.length();
        i = 0;
        while (i < k)
        {
          int m = paramString.charAt(i);
          int j;
          if ((33 <= m) && (126 >= m)) {
            j = 1;
          } else {
            j = 0;
          }
          if (j != 0) {
            i += 1;
          } else {
            throw ((Throwable)new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(i), paramString }).toString()));
          }
        }
        return;
      }
      throw ((Throwable)new IllegalArgumentException("name is empty".toString()));
    }
    
    private final void checkValue(String paramString1, String paramString2)
    {
      int k = paramString1.length();
      int i = 0;
      while (i < k)
      {
        int m = paramString1.charAt(i);
        int j;
        if ((m != 9) && ((32 > m) || (126 < m))) {
          j = 0;
        } else {
          j = 1;
        }
        if (j != 0) {
          i += 1;
        } else {
          throw ((Throwable)new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in %s value: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(i), paramString2, paramString1 }).toString()));
        }
      }
    }
    
    private final String get(String[] paramArrayOfString, String paramString)
    {
      IntProgression localIntProgression = RangesKt.step(RangesKt.downTo(paramArrayOfString.length - 2, 0), 2);
      int i = localIntProgression.getFirst();
      int j = localIntProgression.getLast();
      int k = localIntProgression.getStep();
      if (k >= 0 ? i <= j : i >= j) {
        for (;;)
        {
          if (StringsKt.equals(paramString, paramArrayOfString[i], true)) {
            return paramArrayOfString[(i + 1)];
          }
          if (i == j) {
            break;
          }
          i += k;
        }
      }
      return null;
    }
    
    @Deprecated(level=DeprecationLevel.ERROR, message="function moved to extension", replaceWith=@ReplaceWith(expression="headers.toHeaders()", imports={}))
    public final Headers -deprecated_of(Map<String, String> paramMap)
    {
      Intrinsics.checkParameterIsNotNull(paramMap, "headers");
      return ((Companion)this).of(paramMap);
    }
    
    @Deprecated(level=DeprecationLevel.ERROR, message="function name changed", replaceWith=@ReplaceWith(expression="headersOf(*namesAndValues)", imports={}))
    public final Headers -deprecated_of(String... paramVarArgs)
    {
      Intrinsics.checkParameterIsNotNull(paramVarArgs, "namesAndValues");
      return ((Companion)this).of((String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    }
    
    @JvmStatic
    public final Headers of(Map<String, String> paramMap)
    {
      Intrinsics.checkParameterIsNotNull(paramMap, "$this$toHeaders");
      String[] arrayOfString = new String[paramMap.size() * 2];
      paramMap = paramMap.entrySet().iterator();
      int i = 0;
      while (paramMap.hasNext())
      {
        Object localObject = (Map.Entry)paramMap.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        if (str != null)
        {
          str = StringsKt.trim((CharSequence)str).toString();
          if (localObject != null)
          {
            localObject = StringsKt.trim((CharSequence)localObject).toString();
            Companion localCompanion = (Companion)this;
            localCompanion.checkName(str);
            localCompanion.checkValue((String)localObject, str);
            arrayOfString[i] = str;
            arrayOfString[(i + 1)] = localObject;
            i += 2;
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
      }
      return new Headers(arrayOfString, null);
    }
    
    @JvmStatic
    public final Headers of(String... paramVarArgs)
    {
      Intrinsics.checkParameterIsNotNull(paramVarArgs, "namesAndValues");
      int i;
      if (paramVarArgs.length % 2 == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        paramVarArgs = paramVarArgs.clone();
        if (paramVarArgs != null)
        {
          paramVarArgs = (String[])paramVarArgs;
          int k = paramVarArgs.length;
          i = 0;
          while (i < k)
          {
            if (paramVarArgs[i] != null) {
              j = 1;
            } else {
              j = 0;
            }
            if (j != 0)
            {
              localObject = paramVarArgs[i];
              if (localObject != null)
              {
                paramVarArgs[i] = StringsKt.trim((CharSequence)localObject).toString();
                i += 1;
              }
              else
              {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
              }
            }
            else
            {
              throw ((Throwable)new IllegalArgumentException("Headers cannot be null".toString()));
            }
          }
          Object localObject = RangesKt.step((IntProgression)RangesKt.until(0, paramVarArgs.length), 2);
          i = ((IntProgression)localObject).getFirst();
          int j = ((IntProgression)localObject).getLast();
          k = ((IntProgression)localObject).getStep();
          if (k >= 0 ? i <= j : i >= j) {
            for (;;)
            {
              localObject = paramVarArgs[i];
              String str = paramVarArgs[(i + 1)];
              Companion localCompanion = (Companion)this;
              localCompanion.checkName((String)localObject);
              localCompanion.checkValue(str, (String)localObject);
              if (i == j) {
                break;
              }
              i += k;
            }
          }
          return new Headers(paramVarArgs, null);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
      }
      throw ((Throwable)new IllegalArgumentException("Expected alternating header names and values".toString()));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\Headers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */