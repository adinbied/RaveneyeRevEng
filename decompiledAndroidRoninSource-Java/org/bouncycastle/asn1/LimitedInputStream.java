package org.bouncycastle.asn1;

import java.io.InputStream;

abstract class LimitedInputStream
  extends InputStream
{
  protected final InputStream _in;
  private int _limit;
  
  LimitedInputStream(InputStream paramInputStream, int paramInt)
  {
    this._in = paramInputStream;
    this._limit = paramInt;
  }
  
  int getRemaining()
  {
    return this._limit;
  }
  
  protected void setParentEofDetect(boolean paramBoolean)
  {
    InputStream localInputStream = this._in;
    if ((localInputStream instanceof IndefiniteLengthInputStream)) {
      ((IndefiniteLengthInputStream)localInputStream).setEofOn00(paramBoolean);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\LimitedInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */