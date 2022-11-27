package dji.thirdparty.sanselan.formats.jpeg.segments;

import dji.thirdparty.sanselan.ImageReadException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public abstract class GenericSegment
  extends Segment
{
  public final byte[] bytes;
  
  public GenericSegment(int paramInt1, int paramInt2, InputStream paramInputStream)
    throws ImageReadException, IOException
  {
    super(paramInt1, paramInt2);
    this.bytes = readByteArray("Segment Data", paramInt2, paramInputStream, "Invalid Segment: insufficient data");
  }
  
  public GenericSegment(int paramInt, byte[] paramArrayOfByte)
    throws ImageReadException, IOException
  {
    super(paramInt, paramArrayOfByte.length);
    this.bytes = paramArrayOfByte;
  }
  
  public void dump(PrintWriter paramPrintWriter)
  {
    dump(paramPrintWriter, 0);
  }
  
  /* Error */
  public void dump(PrintWriter arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\jpeg\segments\GenericSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */