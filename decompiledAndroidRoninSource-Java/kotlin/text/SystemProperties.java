package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\000\bÂ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002R\020\020\003\032\0020\0048\006X\004¢\006\002\n\000¨\006\005"}, d2={"Lkotlin/text/SystemProperties;", "", "()V", "LINE_SEPARATOR", "", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
final class SystemProperties
{
  public static final SystemProperties INSTANCE = new SystemProperties();
  public static final String LINE_SEPARATOR;
  
  static
  {
    String str = System.getProperty("line.separator");
    if (str == null) {
      Intrinsics.throwNpe();
    }
    LINE_SEPARATOR = str;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\text\SystemProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */