package com.drew.metadata.icc;

import com.drew.imaging.jpeg.JpegSegmentMetadataReader;
import com.drew.imaging.jpeg.JpegSegmentType;
import com.drew.lang.RandomAccessReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataReader;
import java.io.IOException;
import java.util.Collections;

public class IccReader
  implements JpegSegmentMetadataReader, MetadataReader
{
  public static final String JPEG_SEGMENT_PREAMBLE = "ICC_PROFILE";
  
  public static String getStringFromInt32(int paramInt)
  {
    return new String(new byte[] { (byte)((0xFF000000 & paramInt) >> 24), (byte)((0xFF0000 & paramInt) >> 16), (byte)((0xFF00 & paramInt) >> 8), (byte)(paramInt & 0xFF) });
  }
  
  private void set4ByteString(Directory paramDirectory, int paramInt, RandomAccessReader paramRandomAccessReader)
    throws IOException
  {
    int i = paramRandomAccessReader.getInt32(paramInt);
    if (i != 0) {
      paramDirectory.setString(paramInt, getStringFromInt32(i));
    }
  }
  
  /* Error */
  private void setDate(IccDirectory arg1, int arg2, RandomAccessReader arg3)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void setInt32(Directory paramDirectory, int paramInt, RandomAccessReader paramRandomAccessReader)
    throws IOException
  {
    int i = paramRandomAccessReader.getInt32(paramInt);
    if (i != 0) {
      paramDirectory.setInt(paramInt, i);
    }
  }
  
  /* Error */
  private void setInt64(Directory arg1, int arg2, RandomAccessReader arg3)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void extract(RandomAccessReader paramRandomAccessReader, Metadata paramMetadata)
  {
    extract(paramRandomAccessReader, paramMetadata, null);
  }
  
  /* Error */
  public void extract(RandomAccessReader arg1, Metadata arg2, Directory arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public Iterable<JpegSegmentType> getSegmentTypes()
  {
    return Collections.singletonList(JpegSegmentType.APP2);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\icc\IccReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */