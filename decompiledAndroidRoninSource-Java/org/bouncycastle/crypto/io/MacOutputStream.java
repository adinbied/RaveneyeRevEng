package org.bouncycastle.crypto.io;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.Mac;

public class MacOutputStream
  extends OutputStream
{
  protected Mac mac;
  
  public MacOutputStream(Mac paramMac)
  {
    this.mac = paramMac;
  }
  
  public byte[] getMac()
  {
    byte[] arrayOfByte = new byte[this.mac.getMacSize()];
    this.mac.doFinal(arrayOfByte, 0);
    return arrayOfByte;
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.mac.update((byte)paramInt);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.mac.update(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\io\MacOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */