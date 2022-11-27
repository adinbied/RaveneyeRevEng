package com.drew.imaging.png;

import com.drew.lang.SequentialByteArrayReader;
import com.drew.lang.SequentialReader;
import java.io.IOException;

public class PngHeader
{
  private byte _bitsPerSample;
  private PngColorType _colorType;
  private byte _compressionType;
  private byte _filterMethod;
  private int _imageHeight;
  private int _imageWidth;
  private byte _interlaceMethod;
  
  public PngHeader(byte[] paramArrayOfByte)
    throws PngProcessingException
  {
    if (paramArrayOfByte.length == 13)
    {
      paramArrayOfByte = new SequentialByteArrayReader(paramArrayOfByte);
      try
      {
        this._imageWidth = paramArrayOfByte.getInt32();
        this._imageHeight = paramArrayOfByte.getInt32();
        this._bitsPerSample = paramArrayOfByte.getInt8();
        int i = paramArrayOfByte.getInt8();
        PngColorType localPngColorType = PngColorType.fromNumericValue(i);
        if (localPngColorType != null)
        {
          this._colorType = localPngColorType;
          this._compressionType = paramArrayOfByte.getInt8();
          this._filterMethod = paramArrayOfByte.getInt8();
          this._interlaceMethod = paramArrayOfByte.getInt8();
          return;
        }
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("Unexpected PNG color type: ");
        paramArrayOfByte.append(i);
        throw new PngProcessingException(paramArrayOfByte.toString());
      }
      catch (IOException paramArrayOfByte)
      {
        throw new PngProcessingException(paramArrayOfByte);
      }
    }
    throw new PngProcessingException("PNG header chunk must have 13 data bytes");
  }
  
  public byte getBitsPerSample()
  {
    return this._bitsPerSample;
  }
  
  public PngColorType getColorType()
  {
    return this._colorType;
  }
  
  public byte getCompressionType()
  {
    return this._compressionType;
  }
  
  public byte getFilterMethod()
  {
    return this._filterMethod;
  }
  
  public int getImageHeight()
  {
    return this._imageHeight;
  }
  
  public int getImageWidth()
  {
    return this._imageWidth;
  }
  
  public byte getInterlaceMethod()
  {
    return this._interlaceMethod;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\imaging\png\PngHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */