package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={"\000*\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\002\b\005\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\002\n\002\020\b\n\002\b\005\030\000 \0232\0020\001:\001\023B)\b\002\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003\022\006\020\005\032\0020\003\022\b\020\006\032\004\030\0010\003¢\006\002\020\007J\026\020\006\032\004\030\0010\t2\n\b\002\020\n\032\004\030\0010\tH\007J\023\020\013\032\0020\f2\b\020\r\032\004\030\0010\001H\002J\b\020\016\032\0020\017H\026J\r\020\005\032\0020\003H\007¢\006\002\b\020J\b\020\021\032\0020\003H\026J\r\020\004\032\0020\003H\007¢\006\002\b\022R\020\020\006\032\004\030\0010\003X\004¢\006\002\n\000R\016\020\002\032\0020\003X\004¢\006\002\n\000R\023\020\005\032\0020\0038\007¢\006\b\n\000\032\004\b\005\020\bR\023\020\004\032\0020\0038\007¢\006\b\n\000\032\004\b\004\020\b¨\006\024"}, d2={"Lokhttp3/MediaType;", "", "mediaType", "", "type", "subtype", "charset", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()Ljava/lang/String;", "Ljava/nio/charset/Charset;", "defaultValue", "equals", "", "other", "hashCode", "", "-deprecated_subtype", "toString", "-deprecated_type", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public final class MediaType
{
  public static final Companion Companion = new Companion(null);
  private static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
  private static final String QUOTED = "\"([^\"]*)\"";
  private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
  private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
  private final String charset;
  private final String mediaType;
  private final String subtype;
  private final String type;
  
  private MediaType(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mediaType = paramString1;
    this.type = paramString2;
    this.subtype = paramString3;
    this.charset = paramString4;
  }
  
  @JvmStatic
  public static final MediaType get(String paramString)
  {
    return Companion.get(paramString);
  }
  
  @JvmStatic
  public static final MediaType parse(String paramString)
  {
    return Companion.parse(paramString);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="subtype", imports={}))
  public final String -deprecated_subtype()
  {
    return this.subtype;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="type", imports={}))
  public final String -deprecated_type()
  {
    return this.type;
  }
  
  public final Charset charset()
  {
    return charset$default(this, null, 1, null);
  }
  
  public final Charset charset(Charset paramCharset)
  {
    Charset localCharset = paramCharset;
    try
    {
      if (this.charset != null) {
        localCharset = Charset.forName(this.charset);
      }
      return localCharset;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
    return paramCharset;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof MediaType)) && (Intrinsics.areEqual(((MediaType)paramObject).mediaType, this.mediaType));
  }
  
  public int hashCode()
  {
    return this.mediaType.hashCode();
  }
  
  public final String subtype()
  {
    return this.subtype;
  }
  
  public String toString()
  {
    return this.mediaType;
  }
  
  public final String type()
  {
    return this.type;
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000$\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\007\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\025\020\n\032\0020\0132\006\020\f\032\0020\007H\007¢\006\002\b\rJ\027\020\016\032\004\030\0010\0132\006\020\f\032\0020\007H\007¢\006\002\b\017J\021\020\020\032\0020\013*\0020\007H\007¢\006\002\b\nJ\023\020\021\032\004\030\0010\013*\0020\007H\007¢\006\002\b\016R\026\020\003\032\n \005*\004\030\0010\0040\004X\004¢\006\002\n\000R\016\020\006\032\0020\007XT¢\006\002\n\000R\016\020\b\032\0020\007XT¢\006\002\n\000R\026\020\t\032\n \005*\004\030\0010\0040\004X\004¢\006\002\n\000¨\006\022"}, d2={"Lokhttp3/MediaType$Companion;", "", "()V", "PARAMETER", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "QUOTED", "", "TOKEN", "TYPE_SUBTYPE", "get", "Lokhttp3/MediaType;", "mediaType", "-deprecated_get", "parse", "-deprecated_parse", "toMediaType", "toMediaTypeOrNull", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="mediaType.toMediaType()", imports={"okhttp3.MediaType.Companion.toMediaType"}))
    public final MediaType -deprecated_get(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "mediaType");
      return ((Companion)this).get(paramString);
    }
    
    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="mediaType.toMediaTypeOrNull()", imports={"okhttp3.MediaType.Companion.toMediaTypeOrNull"}))
    public final MediaType -deprecated_parse(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "mediaType");
      return ((Companion)this).parse(paramString);
    }
    
    @JvmStatic
    public final MediaType get(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "$this$toMediaType");
      Object localObject2 = MediaType.access$getTYPE_SUBTYPE$cp();
      Object localObject1 = (CharSequence)paramString;
      Object localObject3 = ((Pattern)localObject2).matcher((CharSequence)localObject1);
      if (((Matcher)localObject3).lookingAt())
      {
        localObject2 = ((Matcher)localObject3).group(1);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "typeSubtype.group(1)");
        Object localObject4 = Locale.US;
        Intrinsics.checkExpressionValueIsNotNull(localObject4, "Locale.US");
        if (localObject2 != null)
        {
          localObject4 = ((String)localObject2).toLowerCase((Locale)localObject4);
          Intrinsics.checkExpressionValueIsNotNull(localObject4, "(this as java.lang.String).toLowerCase(locale)");
          localObject2 = ((Matcher)localObject3).group(2);
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "typeSubtype.group(2)");
          Object localObject5 = Locale.US;
          Intrinsics.checkExpressionValueIsNotNull(localObject5, "Locale.US");
          if (localObject2 != null)
          {
            localObject5 = ((String)localObject2).toLowerCase((Locale)localObject5);
            Intrinsics.checkExpressionValueIsNotNull(localObject5, "(this as java.lang.String).toLowerCase(locale)");
            localObject2 = (String)null;
            Matcher localMatcher = MediaType.access$getPARAMETER$cp().matcher((CharSequence)localObject1);
            int i = ((Matcher)localObject3).end();
            while (i < paramString.length())
            {
              localMatcher.region(i, paramString.length());
              if (localMatcher.lookingAt())
              {
                localObject1 = localMatcher.group(1);
                if ((localObject1 != null) && (StringsKt.equals((String)localObject1, "charset", true)))
                {
                  localObject3 = localMatcher.group(2);
                  i = 0;
                  if (localObject3 == null)
                  {
                    localObject1 = localMatcher.group(3);
                    Intrinsics.checkExpressionValueIsNotNull(localObject1, "parameter.group(3)");
                  }
                  else
                  {
                    localObject1 = localObject3;
                    if (StringsKt.startsWith$default((String)localObject3, "'", false, 2, null))
                    {
                      localObject1 = localObject3;
                      if (StringsKt.endsWith$default((String)localObject3, "'", false, 2, null))
                      {
                        localObject1 = localObject3;
                        if (((String)localObject3).length() > 2)
                        {
                          localObject1 = ((String)localObject3).substring(1, ((String)localObject3).length() - 1);
                          Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        }
                      }
                    }
                  }
                  if ((localObject2 == null) || (StringsKt.equals((String)localObject1, (String)localObject2, true))) {
                    i = 1;
                  }
                  if (i != 0)
                  {
                    i = localMatcher.end();
                    localObject2 = localObject1;
                  }
                  else
                  {
                    localObject3 = new StringBuilder();
                    ((StringBuilder)localObject3).append("Multiple charsets defined: \"");
                    ((StringBuilder)localObject3).append((String)localObject2);
                    ((StringBuilder)localObject3).append("\" and: \"");
                    ((StringBuilder)localObject3).append((String)localObject1);
                    ((StringBuilder)localObject3).append("\" for: \"");
                    ((StringBuilder)localObject3).append(paramString);
                    ((StringBuilder)localObject3).append('"');
                    throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject3).toString().toString()));
                  }
                }
                else
                {
                  i = localMatcher.end();
                }
              }
              else
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("Parameter is not formatted correctly: \"");
                localObject2 = paramString.substring(i);
                Intrinsics.checkExpressionValueIsNotNull(localObject2, "(this as java.lang.String).substring(startIndex)");
                ((StringBuilder)localObject1).append((String)localObject2);
                ((StringBuilder)localObject1).append("\" for: \"");
                ((StringBuilder)localObject1).append(paramString);
                ((StringBuilder)localObject1).append('"');
                throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject1).toString().toString()));
              }
            }
            return new MediaType(paramString, (String)localObject4, (String)localObject5, (String)localObject2, null);
          }
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("No subtype found for: \"");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append('"');
      throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject1).toString().toString()));
    }
    
    @JvmStatic
    public final MediaType parse(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "$this$toMediaTypeOrNull");
      try
      {
        paramString = ((Companion)this).get(paramString);
        return paramString;
      }
      catch (IllegalArgumentException paramString)
      {
        for (;;) {}
      }
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\MediaType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */