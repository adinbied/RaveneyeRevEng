package org.bouncycastle.operator.bc;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Signer;

public class BcSignerOutputStream
  extends OutputStream
{
  private Signer sig;
  
  BcSignerOutputStream(Signer paramSigner)
  {
    this.sig = paramSigner;
  }
  
  byte[] getSignature()
    throws CryptoException
  {
    return this.sig.generateSignature();
  }
  
  boolean verify(byte[] paramArrayOfByte)
  {
    return this.sig.verifySignature(paramArrayOfByte);
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.sig.update((byte)paramInt);
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    this.sig.update(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.sig.update(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\bc\BcSignerOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */