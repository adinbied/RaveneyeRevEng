package org.bouncycastle.pqc.crypto.xmss;

public abstract class XMSSAddress
{
  private final int keyAndMask;
  private final int layerAddress;
  private final long treeAddress;
  private final int type;
  
  protected XMSSAddress(Builder paramBuilder)
  {
    this.layerAddress = paramBuilder.layerAddress;
    this.treeAddress = paramBuilder.treeAddress;
    this.type = paramBuilder.type;
    this.keyAndMask = paramBuilder.keyAndMask;
  }
  
  public final int getKeyAndMask()
  {
    return this.keyAndMask;
  }
  
  protected final int getLayerAddress()
  {
    return this.layerAddress;
  }
  
  protected final long getTreeAddress()
  {
    return this.treeAddress;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  protected byte[] toByteArray()
  {
    byte[] arrayOfByte = new byte[32];
    XMSSUtil.intToBytesBigEndianOffset(arrayOfByte, this.layerAddress, 0);
    XMSSUtil.longToBytesBigEndianOffset(arrayOfByte, this.treeAddress, 4);
    XMSSUtil.intToBytesBigEndianOffset(arrayOfByte, this.type, 12);
    XMSSUtil.intToBytesBigEndianOffset(arrayOfByte, this.keyAndMask, 28);
    return arrayOfByte;
  }
  
  protected static abstract class Builder<T extends Builder>
  {
    private int keyAndMask = 0;
    private int layerAddress = 0;
    private long treeAddress = 0L;
    private final int type;
    
    protected Builder(int paramInt)
    {
      this.type = paramInt;
    }
    
    protected abstract XMSSAddress build();
    
    protected abstract T getThis();
    
    protected T withKeyAndMask(int paramInt)
    {
      this.keyAndMask = paramInt;
      return getThis();
    }
    
    protected T withLayerAddress(int paramInt)
    {
      this.layerAddress = paramInt;
      return getThis();
    }
    
    protected T withTreeAddress(long paramLong)
    {
      this.treeAddress = paramLong;
      return getThis();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\xmss\XMSSAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */