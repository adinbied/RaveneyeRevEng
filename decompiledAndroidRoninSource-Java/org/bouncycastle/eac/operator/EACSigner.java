package org.bouncycastle.eac.operator;

import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public abstract interface EACSigner
{
  public abstract OutputStream getOutputStream();
  
  public abstract byte[] getSignature();
  
  public abstract ASN1ObjectIdentifier getUsageIdentifier();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\eac\operator\EACSigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */