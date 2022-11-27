package org.bouncycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.Streams;

class DefiniteLengthInputStream
  extends LimitedInputStream
{
  private static final byte[] EMPTY_BYTES = new byte[0];
  private final int _originalLength;
  private int _remaining;
  
  DefiniteLengthInputStream(InputStream paramInputStream, int paramInt)
  {
    super(paramInputStream, paramInt);
    if (paramInt >= 0)
    {
      this._originalLength = paramInt;
      this._remaining = paramInt;
      if (paramInt == 0) {
        setParentEofDetect(true);
      }
      return;
    }
    throw new IllegalArgumentException("negative lengths not allowed");
  }
  
  int getRemaining()
  {
    return this._remaining;
  }
  
  public int read()
    throws IOException
  {
    if (this._remaining == 0) {
      return -1;
    }
    int i = this._in.read();
    if (i >= 0)
    {
      int j = this._remaining - 1;
      this._remaining = j;
      if (j == 0) {
        setParentEofDetect(true);
      }
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DEF length ");
    localStringBuilder.append(this._originalLength);
    localStringBuilder.append(" object truncated by ");
    localStringBuilder.append(this._remaining);
    throw new EOFException(localStringBuilder.toString());
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = this._remaining;
    if (i == 0) {
      return -1;
    }
    paramInt2 = Math.min(paramInt2, i);
    paramInt1 = this._in.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 >= 0)
    {
      paramInt2 = this._remaining - paramInt1;
      this._remaining = paramInt2;
      if (paramInt2 == 0) {
        setParentEofDetect(true);
      }
      return paramInt1;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("DEF length ");
    paramArrayOfByte.append(this._originalLength);
    paramArrayOfByte.append(" object truncated by ");
    paramArrayOfByte.append(this._remaining);
    throw new EOFException(paramArrayOfByte.toString());
  }
  
  byte[] toByteArray()
    throws IOException
  {
    int i = this._remaining;
    if (i == 0) {
      return EMPTY_BYTES;
    }
    Object localObject = new byte[i];
    i -= Streams.readFully(this._in, (byte[])localObject);
    this._remaining = i;
    if (i == 0)
    {
      setParentEofDetect(true);
      return (byte[])localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DEF length ");
    ((StringBuilder)localObject).append(this._originalLength);
    ((StringBuilder)localObject).append(" object truncated by ");
    ((StringBuilder)localObject).append(this._remaining);
    throw new EOFException(((StringBuilder)localObject).toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\DefiniteLengthInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */