package dji.thirdparty.sanselan.formats.jpeg;

import dji.thirdparty.sanselan.ImageReadException;
import dji.thirdparty.sanselan.common.BinaryFileParser;
import dji.thirdparty.sanselan.util.Debug;
import java.io.IOException;
import java.io.InputStream;

public class JpegUtils
  extends BinaryFileParser
  implements JpegConstants
{
  public JpegUtils()
  {
    setByteOrder(77);
  }
  
  public static String getMarkerName(int paramInt)
  {
    if (paramInt != 65498)
    {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            return "Unknown";
          case 65519: 
            return "JPEG_APP15_Marker";
          case 65518: 
            return "JPEG_APP14_Marker";
          }
          return "JPEG_APP13_Marker";
        case 65506: 
          return "JPEG_APP2_Marker";
        case 65505: 
          return "JPEG_APP1_Marker";
        }
        return "JFIFMarker";
      case 65487: 
        return "SOF15Marker";
      case 65486: 
        return "SOF14Marker";
      case 65485: 
        return "SOF13Marker";
      case 65484: 
        return "SOF12Marker";
      case 65483: 
        return "SOF11Marker";
      case 65482: 
        return "SOF10Marker";
      case 65481: 
        return "SOF9Marker";
      case 65480: 
        return "SOF8Marker";
      case 65479: 
        return "SOF7Marker";
      case 65478: 
        return "SOF6Marker";
      case 65477: 
        return "SOF5Marker";
      case 65476: 
        return "SOF4Marker";
      case 65475: 
        return "SOF3Marker";
      case 65474: 
        return "SOF2Marker";
      case 65473: 
        return "SOF1Marker";
      }
      return "SOF0Marker";
    }
    return "SOS_Marker";
  }
  
  /* Error */
  public void dumpJFIF(dji.thirdparty.sanselan.common.byteSources.ByteSource arg1)
    throws ImageReadException, IOException, dji.thirdparty.sanselan.ImageWriteException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void traverseJFIF(dji.thirdparty.sanselan.common.byteSources.ByteSource arg1, Visitor arg2)
    throws ImageReadException, IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static abstract interface Visitor
  {
    public abstract boolean beginSOS();
    
    public abstract void visitSOS(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
    
    public abstract boolean visitSOS(int paramInt, byte[] paramArrayOfByte, InputStream paramInputStream);
    
    public abstract boolean visitSegment(int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
      throws ImageReadException, IOException;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\jpeg\JpegUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */