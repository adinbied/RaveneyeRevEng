package dji.thirdparty.sanselan.formats.jpeg.segments;

import dji.thirdparty.sanselan.ImageReadException;
import dji.thirdparty.sanselan.formats.jpeg.JpegImageParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class App2Segment
  extends APPNSegment
  implements Comparable
{
  public final int cur_marker;
  public final byte[] icc_bytes;
  public final int num_markers;
  
  public App2Segment(int paramInt1, int paramInt2, InputStream paramInputStream)
    throws ImageReadException, IOException
  {
    super(paramInt1, paramInt2, paramInputStream);
    if (startsWith(this.bytes, JpegImageParser.icc_profile_label))
    {
      paramInputStream = new ByteArrayInputStream(this.bytes);
      readAndVerifyBytes(paramInputStream, JpegImageParser.icc_profile_label, "Not a Valid App2 Segment: missing ICC Profile label");
      this.cur_marker = readByte("cur_marker", paramInputStream, "Not a valid App2 Marker");
      this.num_markers = readByte("num_markers", paramInputStream, "Not a valid App2 Marker");
      this.icc_bytes = readByteArray("App2 Data", paramInt2 - JpegImageParser.icc_profile_label.length - 2, paramInputStream, "Invalid App2 Segment: insufficient data");
      return;
    }
    this.cur_marker = -1;
    this.num_markers = -1;
    this.icc_bytes = null;
  }
  
  public App2Segment(int paramInt, byte[] paramArrayOfByte)
    throws ImageReadException, IOException
  {
    this(paramInt, paramArrayOfByte.length, new ByteArrayInputStream(paramArrayOfByte));
  }
  
  public int compareTo(Object paramObject)
  {
    paramObject = (App2Segment)paramObject;
    return this.cur_marker - ((App2Segment)paramObject).cur_marker;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\jpeg\segments\App2Segment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */