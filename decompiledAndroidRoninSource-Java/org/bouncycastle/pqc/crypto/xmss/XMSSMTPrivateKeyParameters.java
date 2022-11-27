package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class XMSSMTPrivateKeyParameters
  implements XMSSStoreableObjectInterface
{
  private final Map<Integer, BDS> bdsState;
  private final long index;
  private final XMSSMTParameters params;
  private final byte[] publicSeed;
  private final byte[] root;
  private final byte[] secretKeyPRF;
  private final byte[] secretKeySeed;
  
  private XMSSMTPrivateKeyParameters(Builder paramBuilder)
    throws ParseException, ClassNotFoundException, IOException
  {
    Object localObject = paramBuilder.params;
    this.params = ((XMSSMTParameters)localObject);
    if (localObject != null)
    {
      int i = ((XMSSMTParameters)localObject).getDigestSize();
      localObject = paramBuilder.privateKey;
      if (localObject != null)
      {
        if (paramBuilder.xmss != null)
        {
          int j = this.params.getHeight();
          int k = (int)Math.ceil(j / 8.0D);
          long l = XMSSUtil.bytesToXBigEndian((byte[])localObject, 0, k);
          this.index = l;
          if (XMSSUtil.isIndexValid(j, l))
          {
            j = k + 0;
            this.secretKeySeed = XMSSUtil.extractBytesAtOffset((byte[])localObject, j, i);
            j += i;
            this.secretKeyPRF = XMSSUtil.extractBytesAtOffset((byte[])localObject, j, i);
            j += i;
            this.publicSeed = XMSSUtil.extractBytesAtOffset((byte[])localObject, j, i);
            j += i;
            this.root = XMSSUtil.extractBytesAtOffset((byte[])localObject, j, i);
            i = j + i;
            localObject = (TreeMap)XMSSUtil.deserialize(XMSSUtil.extractBytesAtOffset((byte[])localObject, i, localObject.length - i));
            Iterator localIterator = ((Map)localObject).keySet().iterator();
            while (localIterator.hasNext())
            {
              BDS localBDS = (BDS)((Map)localObject).get((Integer)localIterator.next());
              localBDS.setXMSS(paramBuilder.xmss);
              localBDS.validate();
            }
            this.bdsState = ((Map)localObject);
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
        paramBuilder = new TreeMap();
      }
      this.bdsState = paramBuilder;
      return;
    }
    throw new NullPointerException("params == null");
  }
  
  public Map<Integer, BDS> getBDSState()
  {
    return this.bdsState;
  }
  
  public long getIndex()
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
    int j = (int)Math.ceil(this.params.getHeight() / 8.0D);
    byte[] arrayOfByte1 = new byte[j + i + i + i + i];
    XMSSUtil.copyBytesAtOffset(arrayOfByte1, XMSSUtil.toBytesBigEndian(this.index, j), 0);
    j += 0;
    XMSSUtil.copyBytesAtOffset(arrayOfByte1, this.secretKeySeed, j);
    j += i;
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
    private Map<Integer, BDS> bdsState = null;
    private long index = 0L;
    private final XMSSMTParameters params;
    private byte[] privateKey = null;
    private byte[] publicSeed = null;
    private byte[] root = null;
    private byte[] secretKeyPRF = null;
    private byte[] secretKeySeed = null;
    private XMSS xmss = null;
    
    public Builder(XMSSMTParameters paramXMSSMTParameters)
    {
      this.params = paramXMSSMTParameters;
    }
    
    public XMSSMTPrivateKeyParameters build()
      throws ParseException, ClassNotFoundException, IOException
    {
      return new XMSSMTPrivateKeyParameters(this, null);
    }
    
    public Builder withBDSState(Map<Integer, BDS> paramMap)
    {
      this.bdsState = paramMap;
      return this;
    }
    
    public Builder withIndex(long paramLong)
    {
      this.index = paramLong;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\xmss\XMSSMTPrivateKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */