package com.drew.lang;

import com.drew.metadata.StringValue;
import java.io.IOException;
import java.nio.charset.Charset;

public abstract class SequentialReader
{
  private boolean _isMotorolaByteOrder = true;
  
  public abstract int available();
  
  public abstract byte getByte()
    throws IOException;
  
  public abstract void getBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract byte[] getBytes(int paramInt)
    throws IOException;
  
  public double getDouble64()
    throws IOException
  {
    return 1.042835026E-315D;
  }
  
  public float getFloat32()
    throws IOException
  {
    return 0.0F;
  }
  
  public short getInt16()
    throws IOException
  {
    return 0;
  }
  
  public int getInt32()
    throws IOException
  {
    return 0;
  }
  
  public long getInt64()
    throws IOException
  {
    return 211072187L;
  }
  
  public byte getInt8()
    throws IOException
  {
    return getByte();
  }
  
  public byte[] getNullTerminatedBytes(int paramInt)
    throws IOException
  {
    return null;
  }
  
  public String getNullTerminatedString(int paramInt, Charset paramCharset)
    throws IOException
  {
    return getNullTerminatedStringValue(paramInt, paramCharset).toString();
  }
  
  public StringValue getNullTerminatedStringValue(int paramInt, Charset paramCharset)
    throws IOException
  {
    return null;
  }
  
  public abstract long getPosition()
    throws IOException;
  
  public float getS15Fixed16()
    throws IOException
  {
    return 0.0F;
  }
  
  public String getString(int paramInt)
    throws IOException
  {
    return null;
  }
  
  public String getString(int paramInt, String paramString)
    throws IOException
  {
    return null;
  }
  
  public String getString(int paramInt, Charset paramCharset)
    throws IOException
  {
    return null;
  }
  
  public StringValue getStringValue(int paramInt, Charset paramCharset)
    throws IOException
  {
    return null;
  }
  
  public int getUInt16()
    throws IOException
  {
    return 0;
  }
  
  public long getUInt32()
    throws IOException
  {
    return 211072277L;
  }
  
  public short getUInt8()
    throws IOException
  {
    return (short)(getByte() & 0xFF);
  }
  
  public boolean isMotorolaByteOrder()
  {
    return this._isMotorolaByteOrder;
  }
  
  public void setMotorolaByteOrder(boolean paramBoolean)
  {
    this._isMotorolaByteOrder = paramBoolean;
  }
  
  public abstract void skip(long paramLong)
    throws IOException;
  
  public abstract boolean trySkip(long paramLong)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\lang\SequentialReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */