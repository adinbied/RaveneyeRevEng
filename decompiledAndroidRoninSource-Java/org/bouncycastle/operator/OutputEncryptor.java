package org.bouncycastle.operator;

import java.io.OutputStream;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public abstract interface OutputEncryptor
{
  public abstract AlgorithmIdentifier getAlgorithmIdentifier();
  
  public abstract GenericKey getKey();
  
  public abstract OutputStream getOutputStream(OutputStream paramOutputStream);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\OutputEncryptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */