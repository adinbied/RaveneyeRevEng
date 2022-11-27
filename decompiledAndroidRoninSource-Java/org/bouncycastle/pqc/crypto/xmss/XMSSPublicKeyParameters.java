package org.bouncycastle.pqc.crypto.xmss;

import java.text.ParseException;

public final class XMSSPublicKeyParameters
  implements XMSSStoreableObjectInterface
{
  private final XMSSParameters params;
  private final byte[] publicSeed;
  private final byte[] root;
  
  private XMSSPublicKeyParameters(Builder paramBuilder)
    throws ParseException
  {
    Object localObject = paramBuilder.params;
    this.params = ((XMSSParameters)localObject);
    if (localObject != null)
    {
      int i = ((XMSSParameters)localObject).getDigestSize();
      localObject = paramBuilder.publicKey;
      if (localObject != null)
      {
        if (localObject.length == i + i)
        {
          this.root = XMSSUtil.extractBytesAtOffset((byte[])localObject, 0, i);
          this.publicSeed = XMSSUtil.extractBytesAtOffset((byte[])localObject, i + 0, i);
          return;
        }
        throw new ParseException("public key has wrong size", 0);
      }
      localObject = paramBuilder.root;
      if (localObject != null)
      {
        if (localObject.length == i) {
          this.root = ((byte[])localObject);
        } else {
          throw new IllegalArgumentException("length of root must be equal to length of digest");
        }
      }
      else {
        this.root = new byte[i];
      }
      paramBuilder = paramBuilder.publicSeed;
      if (paramBuilder != null)
      {
        if (paramBuilder.length == i)
        {
          this.publicSeed = paramBuilder;
          return;
        }
        throw new IllegalArgumentException("length of publicSeed must be equal to length of digest");
      }
      this.publicSeed = new byte[i];
      return;
    }
    throw new NullPointerException("params == null");
  }
  
  public byte[] getPublicSeed()
  {
    return XMSSUtil.cloneArray(this.publicSeed);
  }
  
  public byte[] getRoot()
  {
    return XMSSUtil.cloneArray(this.root);
  }
  
  public byte[] toByteArray()
  {
    int i = this.params.getDigestSize();
    byte[] arrayOfByte = new byte[i + i];
    XMSSUtil.copyBytesAtOffset(arrayOfByte, this.root, 0);
    XMSSUtil.copyBytesAtOffset(arrayOfByte, this.publicSeed, i + 0);
    return arrayOfByte;
  }
  
  public static class Builder
  {
    private final XMSSParameters params;
    private byte[] publicKey = null;
    private byte[] publicSeed = null;
    private byte[] root = null;
    
    public Builder(XMSSParameters paramXMSSParameters)
    {
      this.params = paramXMSSParameters;
    }
    
    public XMSSPublicKeyParameters build()
      throws ParseException
    {
      return new XMSSPublicKeyParameters(this, null);
    }
    
    public Builder withPublicKey(byte[] paramArrayOfByte)
    {
      this.publicKey = XMSSUtil.cloneArray(paramArrayOfByte);
      return this;
    }
    
    public Builder withPublicSeed(byte[] paramArrayOfByte)
    {
      this.publicSeed = XMSSUtil.cloneArray(paramArrayOfByte);
      return this;
    }
    
    public Builder withRoot(byte[] paramArrayOfByte)
    {
      this.root = XMSSUtil.cloneArray(paramArrayOfByte);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\xmss\XMSSPublicKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */