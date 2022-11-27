package com.drew.metadata.jpeg;

import com.drew.imaging.jpeg.JpegSegmentMetadataReader;
import com.drew.imaging.jpeg.JpegSegmentType;

public class JpegReader
  implements JpegSegmentMetadataReader
{
  /* Error */
  public void extract(byte[] arg1, com.drew.metadata.Metadata arg2, JpegSegmentType arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public Iterable<JpegSegmentType> getSegmentTypes()
  {
    return null;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\jpeg\JpegReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */