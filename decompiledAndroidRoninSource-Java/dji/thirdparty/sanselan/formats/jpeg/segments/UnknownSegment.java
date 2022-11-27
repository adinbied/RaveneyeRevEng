package dji.thirdparty.sanselan.formats.jpeg.segments;

import dji.thirdparty.sanselan.ImageReadException;
import java.io.IOException;
import java.io.InputStream;

public class UnknownSegment
  extends GenericSegment
{
  public UnknownSegment(int paramInt1, int paramInt2, InputStream paramInputStream)
    throws ImageReadException, IOException
  {
    super(paramInt1, paramInt2, paramInputStream);
  }
  
  public UnknownSegment(int paramInt, byte[] paramArrayOfByte)
    throws ImageReadException, IOException
  {
    super(paramInt, paramArrayOfByte);
  }
  
  public String getDescription()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\jpeg\segments\UnknownSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */