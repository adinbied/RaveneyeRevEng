package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000$\n\000\n\002\020\b\n\002\b\004\n\002\020\005\n\002\b\004\n\002\020\013\n\002\b\002\n\002\030\002\n\002\030\002\n\000\032\025\020\n\032\0020\013*\0020\0012\006\020\f\032\0020\001H\b\032\r\020\r\032\0020\016*\0020\017H\b\"\016\020\000\032\0020\001XT¢\006\002\n\000\"\016\020\002\032\0020\001XT¢\006\002\n\000\"\016\020\003\032\0020\001XT¢\006\002\n\000\"\016\020\004\032\0020\001XT¢\006\002\n\000\"\016\020\005\032\0020\006XT¢\006\002\n\000\"\016\020\007\032\0020\006XT¢\006\002\n\000\"\016\020\b\032\0020\006XT¢\006\002\n\000\"\016\020\t\032\0020\006XT¢\006\002\n\000¨\006\020"}, d2={"FCOMMENT", "", "FEXTRA", "FHCRC", "FNAME", "SECTION_BODY", "", "SECTION_DONE", "SECTION_HEADER", "SECTION_TRAILER", "getBit", "", "bit", "gzip", "Lokio/GzipSource;", "Lokio/Source;", "okio"}, k=2, mv={1, 1, 16})
public final class -GzipSourceExtensions
{
  private static final int FCOMMENT = 4;
  private static final int FEXTRA = 2;
  private static final int FHCRC = 1;
  private static final int FNAME = 3;
  private static final byte SECTION_BODY = 1;
  private static final byte SECTION_DONE = 3;
  private static final byte SECTION_HEADER = 0;
  private static final byte SECTION_TRAILER = 2;
  
  private static final boolean getBit(int paramInt1, int paramInt2)
  {
    return (paramInt1 >> paramInt2 & 0x1) == 1;
  }
  
  public static final GzipSource gzip(Source paramSource)
  {
    Intrinsics.checkParameterIsNotNull(paramSource, "$this$gzip");
    return new GzipSource(paramSource);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\-GzipSourceExtensions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */