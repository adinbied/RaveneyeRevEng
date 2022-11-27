package dji.thirdparty.sanselan.formats.jpeg.segments;

import dji.thirdparty.sanselan.ImageReadException;
import dji.thirdparty.sanselan.util.Debug;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class SOSSegment
  extends Segment
{
  public SOSSegment(int paramInt1, int paramInt2, InputStream paramInputStream)
    throws ImageReadException, IOException
  {
    super(paramInt1, paramInt2);
    if (getDebug())
    {
      PrintStream localPrintStream = System.out;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SOSSegment marker_length: ");
      localStringBuilder.append(paramInt2);
      localPrintStream.println(localStringBuilder.toString());
    }
    Debug.debug("SOS", paramInt2);
    paramInt2 = readByte("number_of_components_in_scan", paramInputStream, "Not a Valid JPEG File");
    Debug.debug("number_of_components_in_scan", paramInt2);
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      Debug.debug("scan_component_selector", readByte("scan_component_selector", paramInputStream, "Not a Valid JPEG File"));
      Debug.debug("ac_dc_entrooy_coding_table_selector", readByte("ac_dc_entrooy_coding_table_selector", paramInputStream, "Not a Valid JPEG File"));
      paramInt1 += 1;
    }
    Debug.debug("start_of_spectral_selection", readByte("start_of_spectral_selection", paramInputStream, "Not a Valid JPEG File"));
    Debug.debug("end_of_spectral_selection", readByte("end_of_spectral_selection", paramInputStream, "Not a Valid JPEG File"));
    Debug.debug("successive_approximation_bit_position", readByte("successive_approximation_bit_position", paramInputStream, "Not a Valid JPEG File"));
    if (getDebug()) {
      System.out.println("");
    }
  }
  
  public String getDescription()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\jpeg\segments\SOSSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */