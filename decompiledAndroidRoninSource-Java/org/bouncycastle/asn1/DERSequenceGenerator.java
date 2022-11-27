package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DERSequenceGenerator
  extends DERGenerator
{
  private final ByteArrayOutputStream _bOut = new ByteArrayOutputStream();
  
  public DERSequenceGenerator(OutputStream paramOutputStream)
    throws IOException
  {
    super(paramOutputStream);
  }
  
  public DERSequenceGenerator(OutputStream paramOutputStream, int paramInt, boolean paramBoolean)
    throws IOException
  {
    super(paramOutputStream, paramInt, paramBoolean);
  }
  
  public void addObject(ASN1Encodable paramASN1Encodable)
    throws IOException
  {
    paramASN1Encodable.toASN1Primitive().encode(new DEROutputStream(this._bOut));
  }
  
  public void close()
    throws IOException
  {
    writeDEREncoded(48, this._bOut.toByteArray());
  }
  
  public OutputStream getRawOutputStream()
  {
    return this._bOut;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\DERSequenceGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */