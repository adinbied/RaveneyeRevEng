package dji.thirdparty.sanselan.formats.jpeg.segments;

import dji.thirdparty.sanselan.ImageReadException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class SOFNSegment
  extends Segment
{
  public final int height;
  public final int numberOfComponents;
  public final int precision;
  public final int width;
  
  public SOFNSegment(int paramInt1, int paramInt2, InputStream paramInputStream)
    throws ImageReadException, IOException
  {
    super(paramInt1, paramInt2);
    if (getDebug())
    {
      PrintStream localPrintStream = System.out;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SOF0Segment marker_length: ");
      localStringBuilder.append(paramInt2);
      localPrintStream.println(localStringBuilder.toString());
    }
    this.precision = readByte("Data_precision", paramInputStream, "Not a Valid JPEG File");
    this.height = read2Bytes("Image_height", paramInputStream, "Not a Valid JPEG File");
    this.width = read2Bytes("Image_Width", paramInputStream, "Not a Valid JPEG File");
    this.numberOfComponents = readByte("Number_of_components", paramInputStream, "Not a Valid JPEG File");
    skipBytes(paramInputStream, paramInt2 - 6, "Not a Valid JPEG File: SOF0 Segment");
    if (getDebug()) {
      System.out.println("");
    }
  }
  
  public SOFNSegment(int paramInt, byte[] paramArrayOfByte)
    throws ImageReadException, IOException
  {
    this(paramInt, paramArrayOfByte.length, new ByteArrayInputStream(paramArrayOfByte));
  }
  
  public String getDescription()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\jpeg\segments\SOFNSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */