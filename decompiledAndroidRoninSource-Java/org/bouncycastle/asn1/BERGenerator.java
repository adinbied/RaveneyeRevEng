package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

public class BERGenerator
  extends ASN1Generator
{
  private boolean _isExplicit;
  private int _tagNo;
  private boolean _tagged = false;
  
  protected BERGenerator(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  protected BERGenerator(OutputStream paramOutputStream, int paramInt, boolean paramBoolean)
  {
    super(paramOutputStream);
    this._tagged = true;
    this._isExplicit = paramBoolean;
    this._tagNo = paramInt;
  }
  
  private void writeHdr(int paramInt)
    throws IOException
  {
    this._out.write(paramInt);
    this._out.write(128);
  }
  
  public OutputStream getRawOutputStream()
  {
    return this._out;
  }
  
  protected void writeBEREnd()
    throws IOException
  {
    this._out.write(0);
    this._out.write(0);
    if ((this._tagged) && (this._isExplicit))
    {
      this._out.write(0);
      this._out.write(0);
    }
  }
  
  protected void writeBERHeader(int paramInt)
    throws IOException
  {
    int i = paramInt;
    if (this._tagged)
    {
      i = this._tagNo | 0x80;
      if (this._isExplicit)
      {
        writeHdr(i | 0x20);
        i = paramInt;
      }
      else if ((paramInt & 0x20) != 0)
      {
        i |= 0x20;
      }
      else
      {
        writeHdr(i);
        return;
      }
    }
    writeHdr(i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\BERGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */