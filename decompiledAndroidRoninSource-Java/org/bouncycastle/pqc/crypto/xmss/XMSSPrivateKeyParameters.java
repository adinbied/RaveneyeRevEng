package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import java.text.ParseException;
import org.bouncycastle.util.Pack;

public final class XMSSPrivateKeyParameters
  implements XMSSStoreableObjectInterface
{
  private final BDS bdsState;
  private final int index;
  private final XMSSParameters params;
  private final byte[] publicSeed;
  private final byte[] root;
  private final byte[] secretKeyPRF;
  private final byte[] secretKeySeed;
  
  private XMSSPrivateKeyParameters(Builder paramBuilder)
    throws ParseException, ClassNotFoundException, IOException
  {
    Object localObject = paramBuilder.params;
    this.params = ((XMSSParameters)localObject);
    if (localObject != null)
    {
      int i = ((XMSSParameters)localObject).getDigestSize();
      localObject = paramBuilder.privateKey;
      if (localObject != null)
      {
        if (paramBuilder.xmss != null)
        {
          int j = this.params.getHeight();
          int k = Pack.bigEndianToInt((byte[])localObject, 0);
          this.index = k;
          if (XMSSUtil.isIndexValid(j, k))
          {
            this.secretKeySeed = XMSSUtil.extractBytesAtOffset((byte[])localObject, 4, i);
            j = 4 + i;
            this.secretKeyPRF = XMSSUtil.extractBytesAtOffset((byte[])localObject, j, i);
            j += i;
            this.publicSeed = XMSSUtil.extractBytesAtOffset((byte[])localObject, j, i);
            j += i;
            this.root = XMSSUtil.extractBytesAtOffset((byte[])localObject, j, i);
            i = j + i;
            localObject = (BDS)XMSSUtil.deserialize(XMSSUtil.extractBytesAtOffset((byte[])localObject, i, localObject.length - i));
            ((BDS)localObject).setXMSS(paramBuilder.xmss);
            ((BDS)localObject).validate();
            this.bdsState = ((BDS)localObject);
            return;
          }
          throw new ParseException("index out of bounds", 0);
        }
        throw new NullPointerException("xmss == null");
      }
      this.index = paramBuilder.index;
      localObject = paramBuilder.secretKeySeed;
      if (localObject != null)
      {
        if (localObject.length == i) {
          this.secretKeySeed = ((byte[])localObject);
        } else {
          throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
        }
      }
      else {
        this.secretKeySeed = new byte[i];
      }
      localObject = paramBuilder.secretKeyPRF;
      if (localObject != null)
      {
        if (localObject.length == i) {
          this.secretKeyPRF = ((byte[])localObject);
        } else {
          throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
        }
      }
      else {
        this.secretKeyPRF = new byte[i];
      }
      localObject = paramBuilder.publicSeed;
      if (localObject != null)
      {
        if (localObject.length == i) {
          this.publicSeed = ((byte[])localObject);
        } else {
          throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
        }
      }
      else {
        this.publicSeed = new byte[i];
      }
      localObject = paramBuilder.root;
      if (localObject != null)
      {
        if (localObject.length == i) {
          this.root = ((byte[])localObject);
        } else {
          throw new IllegalArgumentException("size of root needs to be equal size of digest");
        }
      }
      else {
        this.root = new byte[i];
      }
      paramBuilder = paramBuilder.bdsState;
      if (paramBuilder == null) {
        paramBuilder = new BDS(new XMSS(this.params));
      }
      this.bdsState = paramBuilder;
      return;
    }
    throw new NullPointerException("params == null");
  }
  
  public BDS getBDSState()
  {
    return this.bdsState;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public byte[] getPublicSeed()
  {
    return XMSSUtil.cloneArray(this.publicSeed);
  }
  
  public byte[] getRoot()
  {
    return XMSSUtil.cloneArray(this.root);
  }
  
  public byte[] getSecretKeyPRF()
  {
    return XMSSUtil.cloneArray(this.secretKeyPRF);
  }
  
  public byte[] getSecretKeySeed()
  {
    return XMSSUtil.cloneArray(this.secretKeySeed);
  }
  
  public byte[] toByteArray()
  {
    int i = this.params.getDigestSize();
    byte[] arrayOfByte1 = new byte[i + 4 + i + i + i];
    XMSSUtil.intToBytesBigEndianOffset(arrayOfByte1, this.index, 0);
    XMSSUtil.copyBytesAtOffset(arrayOfByte1, this.secretKeySeed, 4);
    int j = 4 + i;
    XMSSUtil.copyBytesAtOffset(arrayOfByte1, this.secretKeyPRF, j);
    j += i;
    XMSSUtil.copyBytesAtOffset(arrayOfByte1, this.publicSeed, j);
    XMSSUtil.copyBytesAtOffset(arrayOfByte1, this.root, j + i);
    try
    {
      byte[] arrayOfByte2 = XMSSUtil.serialize(this.bdsState);
      return XMSSUtil.concat(new byte[][] { arrayOfByte1, arrayOfByte2 });
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      throw new RuntimeException("error serializing bds state");
    }
  }
  
  public static class Builder
  {
    private BDS bdsState = null;
    private int index = 0;
    private final XMSSParameters params;
    private byte[] privateKey = null;
    private byte[] publicSeed = null;
    private byte[] root = null;
    private byte[] secretKeyPRF = null;
    private byte[] secretKeySeed = null;
    private XMSS xmss = null;
    
    public Builder(XMSSParameters paramXMSSParameters)
    {
      this.params = paramXMSSParameters;
    }
    
    public XMSSPrivateKeyParameters build()
      throws ParseException, ClassNotFoundException, IOException
    {
      return new XMSSPrivateKeyParameters(this, null);
    }
    
    public Builder withBDSState(BDS paramBDS)
    {
      this.bdsState = paramBDS;
      return this;
    }
    
    public Builder withIndex(int paramInt)
    {
      this.index = paramInt;
      return this;
    }
    
    public Builder withPrivateKey(byte[] paramArrayOfByte, XMSS paramXMSS)
    {
      this.privateKey = XMSSUtil.cloneArray(paramArrayOfByte);
      this.xmss = paramXMSS;
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
    
    public Builder withSecretKeyPRF(byte[] paramArrayOfByte)
    {
      this.secretKeyPRF = XMSSUtil.cloneArray(paramArrayOfByte);
      return this;
    }
    
    public Builder withSecretKeySeed(byte[] paramArrayOfByte)
    {
      this.secretKeySeed = XMSSUtil.cloneArray(paramArrayOfByte);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\xmss\XMSSPrivateKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */