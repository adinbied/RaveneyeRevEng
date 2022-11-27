package org.bouncycastle.operator;

import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class GenericKey
{
  private AlgorithmIdentifier algorithmIdentifier;
  private Object representation;
  
  public GenericKey(Object paramObject)
  {
    this.algorithmIdentifier = null;
    this.representation = paramObject;
  }
  
  protected GenericKey(AlgorithmIdentifier paramAlgorithmIdentifier, Object paramObject)
  {
    this.algorithmIdentifier = paramAlgorithmIdentifier;
    this.representation = paramObject;
  }
  
  public GenericKey(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte)
  {
    this.algorithmIdentifier = paramAlgorithmIdentifier;
    this.representation = paramArrayOfByte;
  }
  
  public AlgorithmIdentifier getAlgorithmIdentifier()
  {
    return this.algorithmIdentifier;
  }
  
  public Object getRepresentation()
  {
    return this.representation;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\GenericKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */