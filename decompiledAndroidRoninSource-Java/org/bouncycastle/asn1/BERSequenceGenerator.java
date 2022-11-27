package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

public class BERSequenceGenerator
  extends BERGenerator
{
  public BERSequenceGenerator(OutputStream paramOutputStream)
    throws IOException
  {
    super(paramOutputStream);
    writeBERHeader(48);
  }
  
  public BERSequenceGenerator(OutputStream paramOutputStream, int paramInt, boolean paramBoolean)
    throws IOException
  {
    super(paramOutputStream, paramInt, paramBoolean);
    writeBERHeader(48);
  }
  
  public void addObject(ASN1Encodable paramASN1Encodable)
    throws IOException
  {
    paramASN1Encodable.toASN1Primitive().encode(new BEROutputStream(this._out));
  }
  
  public void close()
    throws IOException
  {
    writeBEREnd();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\BERSequenceGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */