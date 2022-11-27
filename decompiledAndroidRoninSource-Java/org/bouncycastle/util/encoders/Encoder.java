package org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;

public abstract interface Encoder
{
  public abstract int decode(String paramString, OutputStream paramOutputStream)
    throws IOException;
  
  public abstract int decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, OutputStream paramOutputStream)
    throws IOException;
  
  public abstract int encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, OutputStream paramOutputStream)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\encoders\Encoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */