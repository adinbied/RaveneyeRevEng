package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

class ConstructedOctetStream
  extends InputStream
{
  private InputStream _currentStream;
  private boolean _first = true;
  private final ASN1StreamParser _parser;
  
  ConstructedOctetStream(ASN1StreamParser paramASN1StreamParser)
  {
    this._parser = paramASN1StreamParser;
  }
  
  public int read()
    throws IOException
  {
    Object localObject;
    if (this._currentStream == null)
    {
      if (!this._first) {
        return -1;
      }
      localObject = (ASN1OctetStringParser)this._parser.readObject();
      if (localObject == null) {
        return -1;
      }
      this._first = false;
    }
    for (;;)
    {
      int i = this._currentStream.read();
      if (i >= 0) {
        return i;
      }
      ASN1OctetStringParser localASN1OctetStringParser = (ASN1OctetStringParser)this._parser.readObject();
      localObject = localASN1OctetStringParser;
      if (localASN1OctetStringParser == null)
      {
        this._currentStream = null;
        return -1;
      }
      this._currentStream = ((ASN1OctetStringParser)localObject).getOctetStream();
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    Object localObject = this._currentStream;
    int i = 0;
    int j = 0;
    if (localObject == null)
    {
      if (!this._first) {
        return -1;
      }
      localObject = (ASN1OctetStringParser)this._parser.readObject();
      if (localObject == null) {
        return -1;
      }
      this._first = false;
    }
    ASN1OctetStringParser localASN1OctetStringParser;
    do
    {
      this._currentStream = ((ASN1OctetStringParser)localObject).getOctetStream();
      i = j;
      do
      {
        j = this._currentStream.read(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
        if (j < 0) {
          break;
        }
        j = i + j;
        i = j;
      } while (j != paramInt2);
      return j;
      localASN1OctetStringParser = (ASN1OctetStringParser)this._parser.readObject();
      localObject = localASN1OctetStringParser;
      j = i;
    } while (localASN1OctetStringParser != null);
    this._currentStream = null;
    if (i < 1) {
      return -1;
    }
    return i;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ConstructedOctetStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */