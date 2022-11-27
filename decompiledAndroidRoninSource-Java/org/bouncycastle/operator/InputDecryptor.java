package org.bouncycastle.operator;

import java.io.InputStream;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public abstract interface InputDecryptor
{
  public abstract AlgorithmIdentifier getAlgorithmIdentifier();
  
  public abstract InputStream getInputStream(InputStream paramInputStream);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\InputDecryptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */