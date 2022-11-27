package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

@Metadata(bv={1, 0, 3}, d1={"\000@\n\002\030\002\n\002\030\002\n\000\n\002\020 \n\002\020\016\n\002\b\003\n\002\020\b\n\002\b\002\n\002\020\t\n\000\n\002\030\002\n\002\b\b\n\002\030\002\n\000\n\002\020\013\n\000\n\002\020\002\n\002\b\003\030\000 \0342\0020\001:\002\033\034B#\b\000\022\f\020\002\032\b\022\004\022\0020\0040\003\022\f\020\005\032\b\022\004\022\0020\0040\003¢\006\002\020\006J\b\020\n\032\0020\013H\026J\b\020\f\032\0020\rH\026J\016\020\016\032\0020\0042\006\020\017\032\0020\bJ\016\020\020\032\0020\0042\006\020\017\032\0020\bJ\016\020\021\032\0020\0042\006\020\017\032\0020\bJ\r\020\007\032\0020\bH\007¢\006\002\b\022J\016\020\023\032\0020\0042\006\020\017\032\0020\bJ\032\020\024\032\0020\0132\b\020\025\032\004\030\0010\0262\006\020\027\032\0020\030H\002J\020\020\031\032\0020\0322\006\020\025\032\0020\026H\026R\024\020\002\032\b\022\004\022\0020\0040\003X\004¢\006\002\n\000R\024\020\005\032\b\022\004\022\0020\0040\003X\004¢\006\002\n\000R\021\020\007\032\0020\b8G¢\006\006\032\004\b\007\020\t¨\006\035"}, d2={"Lokhttp3/FormBody;", "Lokhttp3/RequestBody;", "encodedNames", "", "", "encodedValues", "(Ljava/util/List;Ljava/util/List;)V", "size", "", "()I", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "encodedName", "index", "encodedValue", "name", "-deprecated_size", "value", "writeOrCountBytes", "sink", "Lokio/BufferedSink;", "countBytes", "", "writeTo", "", "Builder", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public final class FormBody
  extends RequestBody
{
  private static final MediaType CONTENT_TYPE = MediaType.Companion.get("application/x-www-form-urlencoded");
  public static final Companion Companion = new Companion(null);
  private final List<String> encodedNames;
  private final List<String> encodedValues;
  
  public FormBody(List<String> paramList1, List<String> paramList2)
  {
    this.encodedNames = Util.toImmutableList(paramList1);
    this.encodedValues = Util.toImmutableList(paramList2);
  }
  
  private final long writeOrCountBytes(BufferedSink paramBufferedSink, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramBufferedSink = new Buffer();
    }
    else
    {
      if (paramBufferedSink == null) {
        Intrinsics.throwNpe();
      }
      paramBufferedSink = paramBufferedSink.getBuffer();
    }
    int i = 0;
    int j = this.encodedNames.size();
    while (i < j)
    {
      if (i > 0) {
        paramBufferedSink.writeByte(38);
      }
      paramBufferedSink.writeUtf8((String)this.encodedNames.get(i));
      paramBufferedSink.writeByte(61);
      paramBufferedSink.writeUtf8((String)this.encodedValues.get(i));
      i += 1;
    }
    if (paramBoolean)
    {
      long l = paramBufferedSink.size();
      paramBufferedSink.clear();
      return l;
    }
    return 0L;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="size", imports={}))
  public final int -deprecated_size()
  {
    return size();
  }
  
  public long contentLength()
  {
    return writeOrCountBytes(null, true);
  }
  
  public MediaType contentType()
  {
    return CONTENT_TYPE;
  }
  
  public final String encodedName(int paramInt)
  {
    return (String)this.encodedNames.get(paramInt);
  }
  
  public final String encodedValue(int paramInt)
  {
    return (String)this.encodedValues.get(paramInt);
  }
  
  public final String name(int paramInt)
  {
    return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedName(paramInt), 0, 0, true, 3, null);
  }
  
  public final int size()
  {
    return this.encodedNames.size();
  }
  
  public final String value(int paramInt)
  {
    return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedValue(paramInt), 0, 0, true, 3, null);
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramBufferedSink, "sink");
    writeOrCountBytes(paramBufferedSink, false);
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000$\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\002\n\002\020!\n\002\020\016\n\002\b\006\n\002\030\002\n\000\030\0002\0020\001B\023\b\007\022\n\b\002\020\002\032\004\030\0010\003¢\006\002\020\004J\026\020\t\032\0020\0002\006\020\n\032\0020\0072\006\020\013\032\0020\007J\026\020\f\032\0020\0002\006\020\n\032\0020\0072\006\020\013\032\0020\007J\006\020\r\032\0020\016R\020\020\002\032\004\030\0010\003X\004¢\006\002\n\000R\024\020\005\032\b\022\004\022\0020\0070\006X\004¢\006\002\n\000R\024\020\b\032\b\022\004\022\0020\0070\006X\004¢\006\002\n\000¨\006\017"}, d2={"Lokhttp3/FormBody$Builder;", "", "charset", "Ljava/nio/charset/Charset;", "(Ljava/nio/charset/Charset;)V", "names", "", "", "values", "add", "name", "value", "addEncoded", "build", "Lokhttp3/FormBody;", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Builder
  {
    private final Charset charset;
    private final List<String> names;
    private final List<String> values;
    
    public Builder()
    {
      this(null, 1, null);
    }
    
    public Builder(Charset paramCharset)
    {
      this.charset = paramCharset;
      this.names = ((List)new ArrayList());
      this.values = ((List)new ArrayList());
    }
    
    public final Builder add(String paramString1, String paramString2)
    {
      Intrinsics.checkParameterIsNotNull(paramString1, "name");
      Intrinsics.checkParameterIsNotNull(paramString2, "value");
      Builder localBuilder = (Builder)this;
      ((Collection)localBuilder.names).add(HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString1, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, localBuilder.charset, 91, null));
      ((Collection)localBuilder.values).add(HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString2, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, localBuilder.charset, 91, null));
      return localBuilder;
    }
    
    public final Builder addEncoded(String paramString1, String paramString2)
    {
      Intrinsics.checkParameterIsNotNull(paramString1, "name");
      Intrinsics.checkParameterIsNotNull(paramString2, "value");
      Builder localBuilder = (Builder)this;
      ((Collection)localBuilder.names).add(HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString1, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, localBuilder.charset, 83, null));
      ((Collection)localBuilder.values).add(HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, paramString2, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, localBuilder.charset, 83, null));
      return localBuilder;
    }
    
    public final FormBody build()
    {
      return new FormBody(this.names, this.values);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\005"}, d2={"Lokhttp3/FormBody$Companion;", "", "()V", "CONTENT_TYPE", "Lokhttp3/MediaType;", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\FormBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */