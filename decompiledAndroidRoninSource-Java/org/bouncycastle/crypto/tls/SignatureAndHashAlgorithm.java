package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SignatureAndHashAlgorithm
{
  protected short hash;
  protected short signature;
  
  public SignatureAndHashAlgorithm(short paramShort1, short paramShort2)
  {
    if (TlsUtils.isValidUint8(paramShort1))
    {
      if (TlsUtils.isValidUint8(paramShort2))
      {
        if (paramShort2 != 0)
        {
          this.hash = paramShort1;
          this.signature = paramShort2;
          return;
        }
        throw new IllegalArgumentException("'signature' MUST NOT be \"anonymous\"");
      }
      throw new IllegalArgumentException("'signature' should be a uint8");
    }
    throw new IllegalArgumentException("'hash' should be a uint8");
  }
  
  public static SignatureAndHashAlgorithm parse(InputStream paramInputStream)
    throws IOException
  {
    return new SignatureAndHashAlgorithm(TlsUtils.readUint8(paramInputStream), TlsUtils.readUint8(paramInputStream));
  }
  
  public void encode(OutputStream paramOutputStream)
    throws IOException
  {
    TlsUtils.writeUint8(getHash(), paramOutputStream);
    TlsUtils.writeUint8(getSignature(), paramOutputStream);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof SignatureAndHashAlgorithm;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (SignatureAndHashAlgorithm)paramObject;
    bool1 = bool2;
    if (((SignatureAndHashAlgorithm)paramObject).getHash() == getHash())
    {
      bool1 = bool2;
      if (((SignatureAndHashAlgorithm)paramObject).getSignature() == getSignature()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public short getHash()
  {
    return this.hash;
  }
  
  public short getSignature()
  {
    return this.signature;
  }
  
  public int hashCode()
  {
    return getHash() << 16 | getSignature();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\SignatureAndHashAlgorithm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */