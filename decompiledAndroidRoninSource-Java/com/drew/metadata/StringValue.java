package com.drew.metadata;

import java.nio.charset.Charset;

public final class StringValue
{
  private final byte[] _bytes;
  private final Charset _charset;
  
  public StringValue(byte[] paramArrayOfByte, Charset paramCharset)
  {
    this._bytes = paramArrayOfByte;
    this._charset = paramCharset;
  }
  
  public byte[] getBytes()
  {
    return this._bytes;
  }
  
  public Charset getCharset()
  {
    return this._charset;
  }
  
  public String toString()
  {
    return toString(this._charset);
  }
  
  public String toString(Charset paramCharset)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\StringValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */