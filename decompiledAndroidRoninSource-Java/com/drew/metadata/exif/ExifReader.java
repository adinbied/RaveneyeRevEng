package com.drew.metadata.exif;

import com.drew.imaging.jpeg.JpegSegmentMetadataReader;
import com.drew.imaging.jpeg.JpegSegmentType;
import com.drew.lang.RandomAccessReader;
import com.drew.metadata.Metadata;
import java.util.Collections;

public class ExifReader
  implements JpegSegmentMetadataReader
{
  public static final String JPEG_SEGMENT_PREAMBLE = "Exif\000\000";
  
  public void extract(RandomAccessReader paramRandomAccessReader, Metadata paramMetadata)
  {
    extract(paramRandomAccessReader, paramMetadata, 0);
  }
  
  public void extract(RandomAccessReader paramRandomAccessReader, Metadata paramMetadata, int paramInt)
  {
    extract(paramRandomAccessReader, paramMetadata, paramInt, null);
  }
  
  /* Error */
  public void extract(RandomAccessReader arg1, Metadata arg2, int arg3, com.drew.metadata.Directory arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public Iterable<JpegSegmentType> getSegmentTypes()
  {
    return Collections.singletonList(JpegSegmentType.APP1);
  }
  
  /* Error */
  public void readJpegSegments(Iterable<byte[]> arg1, Metadata arg2, JpegSegmentType arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\ExifReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */