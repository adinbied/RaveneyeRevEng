package com.drew.metadata.jpeg;

import com.drew.imaging.jpeg.JpegSegmentMetadataReader;
import com.drew.imaging.jpeg.JpegSegmentType;
import com.drew.lang.SequentialReader;
import java.io.IOException;
import java.util.Collections;

public class JpegDhtReader
  implements JpegSegmentMetadataReader
{
  private byte[] getBytes(SequentialReader paramSequentialReader, int paramInt)
    throws IOException
  {
    return null;
  }
  
  /* Error */
  public void extract(SequentialReader arg1, com.drew.metadata.Metadata arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public Iterable<JpegSegmentType> getSegmentTypes()
  {
    return Collections.singletonList(JpegSegmentType.DHT);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\jpeg\JpegDhtReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */