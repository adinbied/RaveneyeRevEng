package com.drew.imaging.raf;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Metadata;
import java.io.IOException;
import java.io.InputStream;

public class RafMetadataReader
{
  private RafMetadataReader()
    throws Exception
  {
    throw new Exception("Not intended for instantiation");
  }
  
  public static Metadata readMetadata(InputStream paramInputStream)
    throws JpegProcessingException, IOException
  {
    if (paramInputStream.markSupported())
    {
      paramInputStream.mark(512);
      byte[] arrayOfByte = new byte['Ȁ'];
      int j = paramInputStream.read(arrayOfByte);
      if (j != -1)
      {
        paramInputStream.reset();
        int i = 0;
        while (i < j - 2)
        {
          if ((arrayOfByte[i] == -1) && (arrayOfByte[(i + 1)] == -40) && (arrayOfByte[(i + 2)] == -1))
          {
            long l = i;
            if (paramInputStream.skip(l) == l) {
              break;
            }
            throw new IOException("Skipping stream bytes failed");
          }
          i += 1;
        }
        return JpegMetadataReader.readMetadata(paramInputStream);
      }
      throw new IOException("Stream is empty");
    }
    throw new IOException("Stream must support mark/reset");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\imaging\raf\RafMetadataReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */