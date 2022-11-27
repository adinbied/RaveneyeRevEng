package org.bouncycastle.crypto.io;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.Signer;

public class SignerOutputStream
  extends OutputStream
{
  protected Signer signer;
  
  public SignerOutputStream(Signer paramSigner)
  {
    this.signer = paramSigner;
  }
  
  public Signer getSigner()
  {
    return this.signer;
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.signer.update((byte)paramInt);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.signer.update(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\io\SignerOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */