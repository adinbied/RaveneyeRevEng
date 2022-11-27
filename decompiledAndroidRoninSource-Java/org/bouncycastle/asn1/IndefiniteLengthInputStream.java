package org.bouncycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

class IndefiniteLengthInputStream
  extends LimitedInputStream
{
  private int _b1;
  private int _b2;
  private boolean _eofOn00 = true;
  private boolean _eofReached = false;
  
  IndefiniteLengthInputStream(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    super(paramInputStream, paramInt);
    this._b1 = paramInputStream.read();
    paramInt = paramInputStream.read();
    this._b2 = paramInt;
    if (paramInt >= 0)
    {
      checkForEof();
      return;
    }
    throw new EOFException();
  }
  
  private boolean checkForEof()
  {
    if ((!this._eofReached) && (this._eofOn00) && (this._b1 == 0) && (this._b2 == 0))
    {
      this._eofReached = true;
      setParentEofDetect(true);
    }
    return this._eofReached;
  }
  
  public int read()
    throws IOException
  {
    if (checkForEof()) {
      return -1;
    }
    int i = this._in.read();
    if (i >= 0)
    {
      int j = this._b1;
      this._b1 = this._b2;
      this._b2 = i;
      return j;
    }
    throw new EOFException();
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if ((!this._eofOn00) && (paramInt2 >= 3))
    {
      if (this._eofReached) {
        return -1;
      }
      paramInt2 = this._in.read(paramArrayOfByte, paramInt1 + 2, paramInt2 - 2);
      if (paramInt2 >= 0)
      {
        paramArrayOfByte[paramInt1] = ((byte)this._b1);
        paramArrayOfByte[(paramInt1 + 1)] = ((byte)this._b2);
        this._b1 = this._in.read();
        paramInt1 = this._in.read();
        this._b2 = paramInt1;
        if (paramInt1 >= 0) {
          return paramInt2 + 2;
        }
        throw new EOFException();
      }
      throw new EOFException();
    }
    return super.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  void setEofOn00(boolean paramBoolean)
  {
    this._eofOn00 = paramBoolean;
    checkForEof();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\IndefiniteLengthInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */