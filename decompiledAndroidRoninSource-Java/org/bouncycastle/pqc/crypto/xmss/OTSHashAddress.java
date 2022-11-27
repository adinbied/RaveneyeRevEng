package org.bouncycastle.pqc.crypto.xmss;

public final class OTSHashAddress
  extends XMSSAddress
{
  private static final int TYPE = 0;
  private final int chainAddress;
  private final int hashAddress;
  private final int otsAddress;
  
  private OTSHashAddress(Builder paramBuilder)
  {
    super(paramBuilder);
    this.otsAddress = paramBuilder.otsAddress;
    this.chainAddress = paramBuilder.chainAddress;
    this.hashAddress = paramBuilder.hashAddress;
  }
  
  protected int getChainAddress()
  {
    return this.chainAddress;
  }
  
  protected int getHashAddress()
  {
    return this.hashAddress;
  }
  
  protected int getOTSAddress()
  {
    return this.otsAddress;
  }
  
  protected byte[] toByteArray()
  {
    byte[] arrayOfByte = super.toByteArray();
    XMSSUtil.intToBytesBigEndianOffset(arrayOfByte, this.otsAddress, 16);
    XMSSUtil.intToBytesBigEndianOffset(arrayOfByte, this.chainAddress, 20);
    XMSSUtil.intToBytesBigEndianOffset(arrayOfByte, this.hashAddress, 24);
    return arrayOfByte;
  }
  
  protected static class Builder
    extends XMSSAddress.Builder<Builder>
  {
    private int chainAddress = 0;
    private int hashAddress = 0;
    private int otsAddress = 0;
    
    protected Builder()
    {
      super();
    }
    
    protected XMSSAddress build()
    {
      return new OTSHashAddress(this, null);
    }
    
    protected Builder getThis()
    {
      return this;
    }
    
    protected Builder withChainAddress(int paramInt)
    {
      this.chainAddress = paramInt;
      return this;
    }
    
    protected Builder withHashAddress(int paramInt)
    {
      this.hashAddress = paramInt;
      return this;
    }
    
    protected Builder withOTSAddress(int paramInt)
    {
      this.otsAddress = paramInt;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\xmss\OTSHashAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */