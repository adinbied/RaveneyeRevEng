package org.bouncycastle.pqc.crypto.xmss;

public final class LTreeAddress
  extends XMSSAddress
{
  private static final int TYPE = 1;
  private final int lTreeAddress;
  private final int treeHeight;
  private final int treeIndex;
  
  private LTreeAddress(Builder paramBuilder)
  {
    super(paramBuilder);
    this.lTreeAddress = paramBuilder.lTreeAddress;
    this.treeHeight = paramBuilder.treeHeight;
    this.treeIndex = paramBuilder.treeIndex;
  }
  
  protected int getLTreeAddress()
  {
    return this.lTreeAddress;
  }
  
  protected int getTreeHeight()
  {
    return this.treeHeight;
  }
  
  protected int getTreeIndex()
  {
    return this.treeIndex;
  }
  
  protected byte[] toByteArray()
  {
    byte[] arrayOfByte = super.toByteArray();
    XMSSUtil.intToBytesBigEndianOffset(arrayOfByte, this.lTreeAddress, 16);
    XMSSUtil.intToBytesBigEndianOffset(arrayOfByte, this.treeHeight, 20);
    XMSSUtil.intToBytesBigEndianOffset(arrayOfByte, this.treeIndex, 24);
    return arrayOfByte;
  }
  
  protected static class Builder
    extends XMSSAddress.Builder<Builder>
  {
    private int lTreeAddress = 0;
    private int treeHeight = 0;
    private int treeIndex = 0;
    
    protected Builder()
    {
      super();
    }
    
    protected XMSSAddress build()
    {
      return new LTreeAddress(this, null);
    }
    
    protected Builder getThis()
    {
      return this;
    }
    
    protected Builder withLTreeAddress(int paramInt)
    {
      this.lTreeAddress = paramInt;
      return this;
    }
    
    protected Builder withTreeHeight(int paramInt)
    {
      this.treeHeight = paramInt;
      return this;
    }
    
    protected Builder withTreeIndex(int paramInt)
    {
      this.treeIndex = paramInt;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\xmss\LTreeAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */