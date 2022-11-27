package okio;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Deprecated(message="changed in Okio 2.x")
@Metadata(bv={1, 0, 3}, d1={"\000 \n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\t\n\000\n\002\020\016\n\000\n\002\020\b\n\002\b\002\bÇ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\006H\007J \020\003\032\0020\0042\006\020\005\032\0020\0062\006\020\007\032\0020\b2\006\020\t\032\0020\bH\007¨\006\n"}, d2={"Lokio/-DeprecatedUtf8;", "", "()V", "size", "", "string", "", "beginIndex", "", "endIndex", "okio"}, k=1, mv={1, 1, 16})
public final class -DeprecatedUtf8
{
  public static final -DeprecatedUtf8 INSTANCE = new -DeprecatedUtf8();
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="string.utf8Size()", imports={"okio.utf8Size"}))
  public final long size(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    return Utf8.size$default(paramString, 0, 0, 3, null);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="string.utf8Size(beginIndex, endIndex)", imports={"okio.utf8Size"}))
  public final long size(String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    return Utf8.size(paramString, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\-DeprecatedUtf8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */