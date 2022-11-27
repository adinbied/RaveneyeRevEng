package com.drew.imaging.png;

import com.drew.lang.SequentialByteArrayReader;
import java.io.IOException;

public class PngChromaticities
{
  private final int _blueX;
  private final int _blueY;
  private final int _greenX;
  private final int _greenY;
  private final int _redX;
  private final int _redY;
  private final int _whitePointX;
  private final int _whitePointY;
  
  public PngChromaticities(byte[] paramArrayOfByte)
    throws PngProcessingException
  {
    if (paramArrayOfByte.length == 32)
    {
      paramArrayOfByte = new SequentialByteArrayReader(paramArrayOfByte);
      try
      {
        this._whitePointX = paramArrayOfByte.getInt32();
        this._whitePointY = paramArrayOfByte.getInt32();
        this._redX = paramArrayOfByte.getInt32();
        this._redY = paramArrayOfByte.getInt32();
        this._greenX = paramArrayOfByte.getInt32();
        this._greenY = paramArrayOfByte.getInt32();
        this._blueX = paramArrayOfByte.getInt32();
        this._blueY = paramArrayOfByte.getInt32();
        return;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new PngProcessingException(paramArrayOfByte);
      }
    }
    throw new PngProcessingException("Invalid number of bytes");
  }
  
  public int getBlueX()
  {
    return this._blueX;
  }
  
  public int getBlueY()
  {
    return this._blueY;
  }
  
  public int getGreenX()
  {
    return this._greenX;
  }
  
  public int getGreenY()
  {
    return this._greenY;
  }
  
  public int getRedX()
  {
    return this._redX;
  }
  
  public int getRedY()
  {
    return this._redY;
  }
  
  public int getWhitePointX()
  {
    return this._whitePointX;
  }
  
  public int getWhitePointY()
  {
    return this._whitePointY;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\imaging\png\PngChromaticities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */