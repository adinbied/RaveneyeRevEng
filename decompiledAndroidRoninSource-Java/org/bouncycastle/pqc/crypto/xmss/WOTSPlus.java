package org.bouncycastle.pqc.crypto.xmss;

import java.util.ArrayList;
import java.util.List;

public final class WOTSPlus
{
  private final KeyedHashFunctions khf;
  private final WOTSPlusParameters params;
  private byte[] publicSeed;
  private byte[] secretKeySeed;
  
  protected WOTSPlus(WOTSPlusParameters paramWOTSPlusParameters)
  {
    if (paramWOTSPlusParameters != null)
    {
      this.params = paramWOTSPlusParameters;
      int i = paramWOTSPlusParameters.getDigestSize();
      this.khf = new KeyedHashFunctions(paramWOTSPlusParameters.getDigest(), i);
      this.secretKeySeed = new byte[i];
      this.publicSeed = new byte[i];
      return;
    }
    throw new NullPointerException("params == null");
  }
  
  private byte[] chain(byte[] paramArrayOfByte, int paramInt1, int paramInt2, OTSHashAddress paramOTSHashAddress)
  {
    int i = this.params.getDigestSize();
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == i)
      {
        if (paramOTSHashAddress != null)
        {
          if (paramOTSHashAddress.toByteArray() != null)
          {
            int j = paramInt1 + paramInt2;
            if (j <= this.params.getWinternitzParameter() - 1)
            {
              if (paramInt2 == 0) {
                return paramArrayOfByte;
              }
              paramArrayOfByte = chain(paramArrayOfByte, paramInt1, paramInt2 - 1, paramOTSHashAddress);
              paramOTSHashAddress = ((OTSHashAddress.Builder)((OTSHashAddress.Builder)new OTSHashAddress.Builder().withLayerAddress(paramOTSHashAddress.getLayerAddress())).withTreeAddress(paramOTSHashAddress.getTreeAddress())).withOTSAddress(paramOTSHashAddress.getOTSAddress()).withChainAddress(paramOTSHashAddress.getChainAddress()).withHashAddress(j - 1);
              paramInt1 = 0;
              Object localObject = (OTSHashAddress)((OTSHashAddress.Builder)paramOTSHashAddress.withKeyAndMask(0)).build();
              paramOTSHashAddress = this.khf.PRF(this.publicSeed, ((OTSHashAddress)localObject).toByteArray());
              localObject = (OTSHashAddress)((OTSHashAddress.Builder)((OTSHashAddress.Builder)((OTSHashAddress.Builder)new OTSHashAddress.Builder().withLayerAddress(((OTSHashAddress)localObject).getLayerAddress())).withTreeAddress(((OTSHashAddress)localObject).getTreeAddress())).withOTSAddress(((OTSHashAddress)localObject).getOTSAddress()).withChainAddress(((OTSHashAddress)localObject).getChainAddress()).withHashAddress(((OTSHashAddress)localObject).getHashAddress()).withKeyAndMask(1)).build();
              localObject = this.khf.PRF(this.publicSeed, ((OTSHashAddress)localObject).toByteArray());
              byte[] arrayOfByte = new byte[i];
              while (paramInt1 < i)
              {
                arrayOfByte[paramInt1] = ((byte)(paramArrayOfByte[paramInt1] ^ localObject[paramInt1]));
                paramInt1 += 1;
              }
              return this.khf.F(paramOTSHashAddress, arrayOfByte);
            }
            throw new IllegalArgumentException("max chain length must not be greater than w");
          }
          throw new NullPointerException("otsHashAddress byte array == null");
        }
        throw new NullPointerException("otsHashAddress == null");
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("startHash needs to be ");
      paramArrayOfByte.append(i);
      paramArrayOfByte.append("bytes");
      throw new IllegalArgumentException(paramArrayOfByte.toString());
    }
    throw new NullPointerException("startHash == null");
  }
  
  private List<Integer> convertToBaseW(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      if ((paramInt1 != 4) && (paramInt1 != 16)) {
        throw new IllegalArgumentException("w needs to be 4 or 16");
      }
      int k = XMSSUtil.log2(paramInt1);
      if (paramInt2 <= paramArrayOfByte.length * 8 / k)
      {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < paramArrayOfByte.length)
        {
          int j = 8 - k;
          while (j >= 0)
          {
            localArrayList.add(Integer.valueOf(paramArrayOfByte[i] >> j & paramInt1 - 1));
            if (localArrayList.size() == paramInt2) {
              return localArrayList;
            }
            j -= k;
          }
          i += 1;
        }
        return localArrayList;
      }
      throw new IllegalArgumentException("outLength too big");
    }
    throw new NullPointerException("msg == null");
  }
  
  private byte[] expandSecretKeySeed(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.params.getLen())) {
      return this.khf.PRF(this.secretKeySeed, XMSSUtil.toBytesBigEndian(paramInt, 32));
    }
    throw new IllegalArgumentException("index out of bounds");
  }
  
  protected KeyedHashFunctions getKhf()
  {
    return this.khf;
  }
  
  protected WOTSPlusParameters getParams()
  {
    return this.params;
  }
  
  protected WOTSPlusPrivateKeyParameters getPrivateKey()
  {
    int j = this.params.getLen();
    byte[][] arrayOfByte = new byte[j][];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[i] = expandSecretKeySeed(i);
      i += 1;
    }
    return new WOTSPlusPrivateKeyParameters(this.params, arrayOfByte);
  }
  
  protected WOTSPlusPublicKeyParameters getPublicKey(OTSHashAddress paramOTSHashAddress)
  {
    if (paramOTSHashAddress != null)
    {
      byte[][] arrayOfByte = new byte[this.params.getLen()][];
      int i = 0;
      while (i < this.params.getLen())
      {
        paramOTSHashAddress = (OTSHashAddress)((OTSHashAddress.Builder)((OTSHashAddress.Builder)((OTSHashAddress.Builder)new OTSHashAddress.Builder().withLayerAddress(paramOTSHashAddress.getLayerAddress())).withTreeAddress(paramOTSHashAddress.getTreeAddress())).withOTSAddress(paramOTSHashAddress.getOTSAddress()).withChainAddress(i).withHashAddress(paramOTSHashAddress.getHashAddress()).withKeyAndMask(paramOTSHashAddress.getKeyAndMask())).build();
        arrayOfByte[i] = chain(expandSecretKeySeed(i), 0, this.params.getWinternitzParameter() - 1, paramOTSHashAddress);
        i += 1;
      }
      return new WOTSPlusPublicKeyParameters(this.params, arrayOfByte);
    }
    throw new NullPointerException("otsHashAddress == null");
  }
  
  protected WOTSPlusPublicKeyParameters getPublicKeyFromSignature(byte[] paramArrayOfByte, WOTSPlusSignature paramWOTSPlusSignature, OTSHashAddress paramOTSHashAddress)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == this.params.getDigestSize())
      {
        if (paramWOTSPlusSignature != null)
        {
          if (paramOTSHashAddress != null)
          {
            paramArrayOfByte = convertToBaseW(paramArrayOfByte, this.params.getWinternitzParameter(), this.params.getLen1());
            int k = 0;
            int j = 0;
            int i = 0;
            while (j < this.params.getLen1())
            {
              i += this.params.getWinternitzParameter() - 1 - ((Integer)paramArrayOfByte.get(j)).intValue();
              j += 1;
            }
            j = this.params.getLen2();
            int m = XMSSUtil.log2(this.params.getWinternitzParameter());
            int n = (int)Math.ceil(this.params.getLen2() * XMSSUtil.log2(this.params.getWinternitzParameter()) / 8.0D);
            paramArrayOfByte.addAll(convertToBaseW(XMSSUtil.toBytesBigEndian(i << 8 - j * m % 8, n), this.params.getWinternitzParameter(), this.params.getLen2()));
            byte[][] arrayOfByte = new byte[this.params.getLen()][];
            i = k;
            while (i < this.params.getLen())
            {
              paramOTSHashAddress = (OTSHashAddress)((OTSHashAddress.Builder)((OTSHashAddress.Builder)((OTSHashAddress.Builder)new OTSHashAddress.Builder().withLayerAddress(paramOTSHashAddress.getLayerAddress())).withTreeAddress(paramOTSHashAddress.getTreeAddress())).withOTSAddress(paramOTSHashAddress.getOTSAddress()).withChainAddress(i).withHashAddress(paramOTSHashAddress.getHashAddress()).withKeyAndMask(paramOTSHashAddress.getKeyAndMask())).build();
              arrayOfByte[i] = chain(paramWOTSPlusSignature.toByteArray()[i], ((Integer)paramArrayOfByte.get(i)).intValue(), this.params.getWinternitzParameter() - 1 - ((Integer)paramArrayOfByte.get(i)).intValue(), paramOTSHashAddress);
              i += 1;
            }
            return new WOTSPlusPublicKeyParameters(this.params, arrayOfByte);
          }
          throw new NullPointerException("otsHashAddress == null");
        }
        throw new NullPointerException("signature == null");
      }
      throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
    }
    throw new NullPointerException("messageDigest == null");
  }
  
  protected byte[] getPublicSeed()
  {
    return XMSSUtil.cloneArray(this.publicSeed);
  }
  
  protected byte[] getSecretKeySeed()
  {
    return XMSSUtil.cloneArray(getSecretKeySeed());
  }
  
  protected void importKeys(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte1.length == this.params.getDigestSize())
      {
        if (paramArrayOfByte2 != null)
        {
          if (paramArrayOfByte2.length == this.params.getDigestSize())
          {
            this.secretKeySeed = paramArrayOfByte1;
            this.publicSeed = paramArrayOfByte2;
            return;
          }
          throw new IllegalArgumentException("size of publicSeed needs to be equal to size of digest");
        }
        throw new NullPointerException("publicSeed == null");
      }
      throw new IllegalArgumentException("size of secretKeySeed needs to be equal to size of digest");
    }
    throw new NullPointerException("secretKeySeed == null");
  }
  
  protected WOTSPlusSignature sign(byte[] paramArrayOfByte, OTSHashAddress paramOTSHashAddress)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == this.params.getDigestSize())
      {
        if (paramOTSHashAddress != null)
        {
          paramArrayOfByte = convertToBaseW(paramArrayOfByte, this.params.getWinternitzParameter(), this.params.getLen1());
          int j = 0;
          int i = 0;
          while (j < this.params.getLen1())
          {
            i += this.params.getWinternitzParameter() - 1 - ((Integer)paramArrayOfByte.get(j)).intValue();
            j += 1;
          }
          j = this.params.getLen2();
          int k = XMSSUtil.log2(this.params.getWinternitzParameter());
          int m = (int)Math.ceil(this.params.getLen2() * XMSSUtil.log2(this.params.getWinternitzParameter()) / 8.0D);
          paramArrayOfByte.addAll(convertToBaseW(XMSSUtil.toBytesBigEndian(i << 8 - j * k % 8, m), this.params.getWinternitzParameter(), this.params.getLen2()));
          byte[][] arrayOfByte = new byte[this.params.getLen()][];
          i = 0;
          while (i < this.params.getLen())
          {
            paramOTSHashAddress = (OTSHashAddress)((OTSHashAddress.Builder)((OTSHashAddress.Builder)((OTSHashAddress.Builder)new OTSHashAddress.Builder().withLayerAddress(paramOTSHashAddress.getLayerAddress())).withTreeAddress(paramOTSHashAddress.getTreeAddress())).withOTSAddress(paramOTSHashAddress.getOTSAddress()).withChainAddress(i).withHashAddress(paramOTSHashAddress.getHashAddress()).withKeyAndMask(paramOTSHashAddress.getKeyAndMask())).build();
            arrayOfByte[i] = chain(expandSecretKeySeed(i), 0, ((Integer)paramArrayOfByte.get(i)).intValue(), paramOTSHashAddress);
            i += 1;
          }
          return new WOTSPlusSignature(this.params, arrayOfByte);
        }
        throw new NullPointerException("otsHashAddress == null");
      }
      throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
    }
    throw new NullPointerException("messageDigest == null");
  }
  
  protected boolean verifySignature(byte[] paramArrayOfByte, WOTSPlusSignature paramWOTSPlusSignature, OTSHashAddress paramOTSHashAddress)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == this.params.getDigestSize())
      {
        if (paramWOTSPlusSignature != null)
        {
          if (paramOTSHashAddress != null) {
            return XMSSUtil.compareByteArray(getPublicKeyFromSignature(paramArrayOfByte, paramWOTSPlusSignature, paramOTSHashAddress).toByteArray(), getPublicKey(paramOTSHashAddress).toByteArray());
          }
          throw new NullPointerException("otsHashAddress == null");
        }
        throw new NullPointerException("signature == null");
      }
      throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
    }
    throw new NullPointerException("messageDigest == null");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\xmss\WOTSPlus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */