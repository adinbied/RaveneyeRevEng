package com.drew.metadata.iptc;

import com.drew.imaging.jpeg.JpegSegmentMetadataReader;
import com.drew.imaging.jpeg.JpegSegmentType;
import java.util.Collections;

public class IptcReader
  implements JpegSegmentMetadataReader
{
  private static final byte IptcMarkerByte = 28;
  
  /* Error */
  private void processTag(com.drew.lang.SequentialReader arg1, com.drew.metadata.Directory arg2, int arg3, int arg4, int arg5)
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void extract(com.drew.lang.SequentialReader arg1, com.drew.metadata.Metadata arg2, long arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void extract(com.drew.lang.SequentialReader arg1, com.drew.metadata.Metadata arg2, long arg3, com.drew.metadata.Directory arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public Iterable<JpegSegmentType> getSegmentTypes()
  {
    return Collections.singletonList(JpegSegmentType.APPD);
  }
  
  /* Error */
  public void readJpegSegments(Iterable<byte[]> arg1, com.drew.metadata.Metadata arg2, JpegSegmentType arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\iptc\IptcReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */