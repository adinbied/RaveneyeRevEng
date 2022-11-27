package com.drew.imaging.png;

public class PngChunk
{
  private final byte[] _bytes;
  private final PngChunkType _chunkType;
  
  public PngChunk(PngChunkType paramPngChunkType, byte[] paramArrayOfByte)
  {
    this._chunkType = paramPngChunkType;
    this._bytes = paramArrayOfByte;
  }
  
  public byte[] getBytes()
  {
    return this._bytes;
  }
  
  public PngChunkType getType()
  {
    return this._chunkType;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\imaging\png\PngChunk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */