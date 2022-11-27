package com.drew.imaging.png;

import com.drew.lang.SequentialReader;
import java.io.IOException;
import java.util.Set;

public class PngChunkReader
{
  private static final byte[] PNG_SIGNATURE_BYTES = { -119, 80, 78, 71, 13, 10, 26, 10 };
  
  public Iterable<PngChunk> extract(SequentialReader paramSequentialReader, Set<PngChunkType> paramSet)
    throws PngProcessingException, IOException
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\imaging\png\PngChunkReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */