package kotlin.text;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\016\n\000\n\002\030\002\n\000\n\002\020\016\n\000\032\021\020\000\032\0020\0012\006\020\002\032\0020\003H\b¨\006\004"}, d2={"charset", "Ljava/nio/charset/Charset;", "charsetName", "", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class CharsetsKt
{
  private static final Charset charset(String paramString)
  {
    paramString = Charset.forName(paramString);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "Charset.forName(charsetName)");
    return paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\text\CharsetsKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */