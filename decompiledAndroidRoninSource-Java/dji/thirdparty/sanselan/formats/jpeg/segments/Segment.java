package dji.thirdparty.sanselan.formats.jpeg.segments;

import dji.thirdparty.sanselan.common.BinaryFileParser;
import java.io.PrintWriter;

public abstract class Segment
  extends BinaryFileParser
{
  public final int length;
  public final int marker;
  
  public Segment(int paramInt1, int paramInt2)
  {
    this.marker = paramInt1;
    this.length = paramInt2;
  }
  
  public void dump(PrintWriter paramPrintWriter) {}
  
  public abstract String getDescription();
  
  public String getSegmentType()
  {
    return null;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\jpeg\segments\Segment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */