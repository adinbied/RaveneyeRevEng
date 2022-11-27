package org.bouncycastle.operator;

import java.io.OutputStream;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public abstract interface ContentVerifier
{
  public abstract AlgorithmIdentifier getAlgorithmIdentifier();
  
  public abstract OutputStream getOutputStream();
  
  public abstract boolean verify(byte[] paramArrayOfByte);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\ContentVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */