package org.bouncycastle.pqc.crypto.xmss;

public final class HashTreeAddress
  extends XMSSAddress
{
  private static final int PADDING = 0;
  private static final int TYPE = 2;
  private final int padding = 0;
  private final int treeHeight;
  private final int treeIndex;
  
  private HashTreeAddress(Builder paramBuilder)
  {
    super(paramBuilder);
    this.treeHeight = paramBuilder.treeHeight;
    this.treeIndex = paramBuilder.treeIndex;
  }
  
  protected int getPadding()
  {
    return this.padding;
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
    XMSSUtil.intToBytesBigEndianOffset(arrayOfByte, this.padding, 16);
    XMSSUtil.intToBytesBigEndianOffset(arrayOfByte, this.treeHeight, 20);
    XMSSUtil.intToBytesBigEndianOffset(arrayOfByte, this.treeIndex, 24);
    return arrayOfByte;
  }
  
  protected static class Builder
    extends XMSSAddress.Builder<Builder>
  {
    private int treeHeight = 0;
    private int treeIndex = 0;
    
    protected Builder()
    {
      super();
    }
    
    protected XMSSAddress build()
    {
      return new HashTreeAddress(this, null);
    }
    
    protected Builder getThis()
    {
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\xmss\HashTreeAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */