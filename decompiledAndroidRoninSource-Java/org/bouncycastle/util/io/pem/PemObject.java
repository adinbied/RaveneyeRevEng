package org.bouncycastle.util.io.pem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PemObject
  implements PemObjectGenerator
{
  private static final List EMPTY_LIST = Collections.unmodifiableList(new ArrayList());
  private byte[] content;
  private List headers;
  private String type;
  
  public PemObject(String paramString, List paramList, byte[] paramArrayOfByte)
  {
    this.type = paramString;
    this.headers = Collections.unmodifiableList(paramList);
    this.content = paramArrayOfByte;
  }
  
  public PemObject(String paramString, byte[] paramArrayOfByte)
  {
    this(paramString, EMPTY_LIST, paramArrayOfByte);
  }
  
  public PemObject generate()
    throws PemGenerationException
  {
    return this;
  }
  
  public byte[] getContent()
  {
    return this.content;
  }
  
  public List getHeaders()
  {
    return this.headers;
  }
  
  public String getType()
  {
    return this.type;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\io\pem\PemObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */