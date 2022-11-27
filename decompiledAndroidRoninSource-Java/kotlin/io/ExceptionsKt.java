package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\020\n\000\n\002\020\016\n\000\n\002\030\002\n\002\b\003\032$\020\000\032\0020\0012\006\020\002\032\0020\0032\b\020\004\032\004\030\0010\0032\b\020\005\032\004\030\0010\001H\002¨\006\006"}, d2={"constructMessage", "", "file", "Ljava/io/File;", "other", "reason", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class ExceptionsKt
{
  private static final String constructMessage(File paramFile1, File paramFile2, String paramString)
  {
    paramFile1 = new StringBuilder(paramFile1.toString());
    if (paramFile2 != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" -> ");
      localStringBuilder.append(paramFile2);
      paramFile1.append(localStringBuilder.toString());
    }
    if (paramString != null)
    {
      paramFile2 = new StringBuilder();
      paramFile2.append(": ");
      paramFile2.append(paramString);
      paramFile1.append(paramFile2.toString());
    }
    paramFile1 = paramFile1.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramFile1, "sb.toString()");
    return paramFile1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\io\ExceptionsKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */