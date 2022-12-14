package org.bouncycastle.operator;

import java.io.OutputStream;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.io.BufferingOutputStream;

public class BufferingContentSigner
  implements ContentSigner
{
  private final ContentSigner contentSigner;
  private final OutputStream output;
  
  public BufferingContentSigner(ContentSigner paramContentSigner)
  {
    this.contentSigner = paramContentSigner;
    this.output = new BufferingOutputStream(paramContentSigner.getOutputStream());
  }
  
  public BufferingContentSigner(ContentSigner paramContentSigner, int paramInt)
  {
    this.contentSigner = paramContentSigner;
    this.output = new BufferingOutputStream(paramContentSigner.getOutputStream(), paramInt);
  }
  
  public AlgorithmIdentifier getAlgorithmIdentifier()
  {
    return this.contentSigner.getAlgorithmIdentifier();
  }
  
  public OutputStream getOutputStream()
  {
    return this.output;
  }
  
  public byte[] getSignature()
  {
    return this.contentSigner.getSignature();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\BufferingContentSigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */