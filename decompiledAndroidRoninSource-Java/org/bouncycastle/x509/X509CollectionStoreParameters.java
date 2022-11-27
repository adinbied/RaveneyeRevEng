package org.bouncycastle.x509;

import java.util.ArrayList;
import java.util.Collection;

public class X509CollectionStoreParameters
  implements X509StoreParameters
{
  private Collection collection;
  
  public X509CollectionStoreParameters(Collection paramCollection)
  {
    if (paramCollection != null)
    {
      this.collection = paramCollection;
      return;
    }
    throw new NullPointerException("collection cannot be null");
  }
  
  public Object clone()
  {
    return new X509CollectionStoreParameters(this.collection);
  }
  
  public Collection getCollection()
  {
    return new ArrayList(this.collection);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("X509CollectionStoreParameters: [\n");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("  collection: ");
    localStringBuilder.append(this.collection);
    localStringBuilder.append("\n");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuffer.append("]");
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\X509CollectionStoreParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */