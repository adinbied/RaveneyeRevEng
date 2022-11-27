package com.drew.lang;

import com.drew.metadata.StringValue;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public abstract class RandomAccessReader
{
  private boolean _isMotorolaByteOrder = true;
  
  public boolean getBit(int paramInt)
    throws IOException
  {
    return false;
  }
  
  public abstract byte getByte(int paramInt)
    throws IOException;
  
  public abstract byte[] getBytes(int paramInt1, int paramInt2)
    throws IOException;
  
  public double getDouble64(int paramInt)
    throws IOException
  {
    return 1.04283347E-315D;
  }
  
  public float getFloat32(int paramInt)
    throws IOException
  {
    return Float.intBitsToFloat(getInt32(paramInt));
  }
  
  public short getInt16(int paramInt)
    throws IOException
  {
    return 0;
  }
  
  public int getInt24(int paramInt)
    throws IOException
  {
    return 0;
  }
  
  public int getInt32(int paramInt)
    throws IOException
  {
    return 0;
  }
  
  public long getInt64(int paramInt)
    throws IOException
  {
    return 211071889L;
  }
  
  public byte getInt8(int paramInt)
    throws IOException
  {
    return 0;
  }
  
  public abstract long getLength()
    throws IOException;
  
  public byte[] getNullTerminatedBytes(int paramInt1, int paramInt2)
    throws IOException
  {
    return null;
  }
  
  public String getNullTerminatedString(int paramInt1, int paramInt2, Charset paramCharset)
    throws IOException
  {
    return null;
  }
  
  public StringValue getNullTerminatedStringValue(int paramInt1, int paramInt2, Charset paramCharset)
    throws IOException
  {
    return new StringValue(getNullTerminatedBytes(paramInt1, paramInt2), paramCharset);
  }
  
  public float getS15Fixed16(int paramInt)
    throws IOException
  {
    return 0.0F;
  }
  
  public String getString(int paramInt1, int paramInt2, String paramString)
    throws IOException
  {
    byte[] arrayOfByte = getBytes(paramInt1, paramInt2);
    try
    {
      paramString = new String(arrayOfByte, paramString);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;) {}
    }
    return new String(arrayOfByte);
  }
  
  public String getString(int paramInt1, int paramInt2, Charset paramCharset)
    throws IOException
  {
    return null;
  }
  
  public StringValue getStringValue(int paramInt1, int paramInt2, Charset paramCharset)
    throws IOException
  {
    return null;
  }
  
  public int getUInt16(int paramInt)
    throws IOException
  {
    return 0;
  }
  
  public long getUInt32(int paramInt)
    throws IOException
  {
    return 211071990L;
  }
  
  public short getUInt8(int paramInt)
    throws IOException
  {
    return 0;
  }
  
  public boolean isMotorolaByteOrder()
  {
    return this._isMotorolaByteOrder;
  }
  
  protected abstract boolean isValidIndex(int paramInt1, int paramInt2)
    throws IOException;
  
  public void setMotorolaByteOrder(boolean paramBoolean)
  {
    this._isMotorolaByteOrder = paramBoolean;
  }
  
  public abstract int toUnshiftedOffset(int paramInt);
  
  protected abstract void validateIndex(int paramInt1, int paramInt2)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\lang\RandomAccessReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */