package org.bouncycastle.pqc.crypto.xmss;

import java.io.Serializable;

public final class XMSSNode
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final int height;
  private final byte[] value;
  
  protected XMSSNode(int paramInt, byte[] paramArrayOfByte)
  {
    this.height = paramInt;
    this.value = paramArrayOfByte;
  }
  
  protected XMSSNode clone()
  {
    return new XMSSNode(getHeight(), getValue());
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public byte[] getValue()
  {
    return XMSSUtil.cloneArray(this.value);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\xmss\XMSSNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */