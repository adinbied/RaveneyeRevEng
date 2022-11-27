package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import java.security.SecureRandom;
import java.text.ParseException;
import java.util.List;

public class XMSS
{
  private KeyedHashFunctions khf;
  private XMSSParameters params;
  private XMSSPrivateKeyParameters privateKey;
  private SecureRandom prng;
  private XMSSPublicKeyParameters publicKey;
  private WOTSPlus wotsPlus;
  
  public XMSS(XMSSParameters paramXMSSParameters)
  {
    if (paramXMSSParameters != null)
    {
      this.params = paramXMSSParameters;
      this.wotsPlus = paramXMSSParameters.getWOTSPlus();
      this.prng = paramXMSSParameters.getPRNG();
      this.khf = this.wotsPlus.getKhf();
      try
      {
        this.privateKey = new XMSSPrivateKeyParameters.Builder(paramXMSSParameters).withBDSState(new BDS(this)).build();
        this.publicKey = new XMSSPublicKeyParameters.Builder(paramXMSSParameters).build();
        return;
      }
      catch (IOException paramXMSSParameters)
      {
        paramXMSSParameters.printStackTrace();
        return;
      }
      catch (ClassNotFoundException paramXMSSParameters)
      {
        paramXMSSParameters.printStackTrace();
        return;
      }
      catch (ParseException paramXMSSParameters)
      {
        paramXMSSParameters.printStackTrace();
        return;
      }
    }
    throw new NullPointerException("params == null");
  }
  
  private XMSSPrivateKeyParameters generatePrivateKey()
  {
    int i = this.params.getDigestSize();
    Object localObject = new byte[i];
    this.prng.nextBytes((byte[])localObject);
    byte[] arrayOfByte1 = new byte[i];
    this.prng.nextBytes(arrayOfByte1);
    byte[] arrayOfByte2 = new byte[i];
    this.prng.nextBytes(arrayOfByte2);
    try
    {
      localObject = new XMSSPrivateKeyParameters.Builder(this.params).withSecretKeySeed((byte[])localObject).withSecretKeyPRF(arrayOfByte1).withPublicSeed(arrayOfByte2).withBDSState(this.privateKey.getBDSState()).build();
      return (XMSSPrivateKeyParameters)localObject;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return null;
  }
  
  public byte[] exportPrivateKey()
  {
    return this.privateKey.toByteArray();
  }
  
  public byte[] exportPublicKey()
  {
    return this.publicKey.toByteArray();
  }
  
  public void generateKeys()
  {
    this.privateKey = generatePrivateKey();
    XMSSNode localXMSSNode = getBDSState().initialize((OTSHashAddress)new OTSHashAddress.Builder().build());
    try
    {
      this.privateKey = new XMSSPrivateKeyParameters.Builder(this.params).withIndex(this.privateKey.getIndex()).withSecretKeySeed(this.privateKey.getSecretKeySeed()).withSecretKeyPRF(this.privateKey.getSecretKeyPRF()).withPublicSeed(this.privateKey.getPublicSeed()).withRoot(localXMSSNode.getValue()).withBDSState(this.privateKey.getBDSState()).build();
      this.publicKey = new XMSSPublicKeyParameters.Builder(this.params).withRoot(localXMSSNode.getValue()).withPublicSeed(getPublicSeed()).build();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
      return;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
  }
  
  protected BDS getBDSState()
  {
    return this.privateKey.getBDSState();
  }
  
  public int getIndex()
  {
    return this.privateKey.getIndex();
  }
  
  protected KeyedHashFunctions getKhf()
  {
    return this.khf;
  }
  
  public XMSSParameters getParams()
  {
    return this.params;
  }
  
  public byte[] getPublicSeed()
  {
    return this.privateKey.getPublicSeed();
  }
  
  public byte[] getRoot()
  {
    return this.privateKey.getRoot();
  }
  
  protected XMSSNode getRootNodeFromSignature(byte[] paramArrayOfByte, XMSSReducedSignature paramXMSSReducedSignature, OTSHashAddress paramOTSHashAddress)
  {
    if (paramArrayOfByte.length == this.params.getDigestSize())
    {
      if (paramXMSSReducedSignature != null)
      {
        if (paramOTSHashAddress != null)
        {
          LTreeAddress localLTreeAddress = (LTreeAddress)((LTreeAddress.Builder)((LTreeAddress.Builder)new LTreeAddress.Builder().withLayerAddress(paramOTSHashAddress.getLayerAddress())).withTreeAddress(paramOTSHashAddress.getTreeAddress())).withLTreeAddress(paramOTSHashAddress.getOTSAddress()).build();
          HashTreeAddress localHashTreeAddress = (HashTreeAddress)((HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(paramOTSHashAddress.getLayerAddress())).withTreeAddress(paramOTSHashAddress.getTreeAddress())).withTreeIndex(paramOTSHashAddress.getOTSAddress()).build();
          paramArrayOfByte = this.wotsPlus.getPublicKeyFromSignature(paramArrayOfByte, paramXMSSReducedSignature.getWOTSPlusSignature(), paramOTSHashAddress);
          paramOTSHashAddress = new XMSSNode[2];
          paramOTSHashAddress[0] = lTree(paramArrayOfByte, localLTreeAddress);
          int i = 0;
          paramArrayOfByte = localHashTreeAddress;
          while (i < this.params.getHeight())
          {
            paramArrayOfByte = (HashTreeAddress)((HashTreeAddress.Builder)((HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(paramArrayOfByte.getLayerAddress())).withTreeAddress(paramArrayOfByte.getTreeAddress())).withTreeHeight(i).withTreeIndex(paramArrayOfByte.getTreeIndex()).withKeyAndMask(paramArrayOfByte.getKeyAndMask())).build();
            if (Math.floor(this.privateKey.getIndex() / (1 << i)) % 2.0D == 0.0D)
            {
              paramArrayOfByte = (HashTreeAddress)((HashTreeAddress.Builder)((HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(paramArrayOfByte.getLayerAddress())).withTreeAddress(paramArrayOfByte.getTreeAddress())).withTreeHeight(paramArrayOfByte.getTreeHeight()).withTreeIndex(paramArrayOfByte.getTreeIndex() / 2).withKeyAndMask(paramArrayOfByte.getKeyAndMask())).build();
              paramOTSHashAddress[1] = randomizeHash(paramOTSHashAddress[0], (XMSSNode)paramXMSSReducedSignature.getAuthPath().get(i), paramArrayOfByte);
              paramOTSHashAddress[1] = new XMSSNode(paramOTSHashAddress[1].getHeight() + 1, paramOTSHashAddress[1].getValue());
            }
            else
            {
              paramArrayOfByte = (HashTreeAddress)((HashTreeAddress.Builder)((HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(paramArrayOfByte.getLayerAddress())).withTreeAddress(paramArrayOfByte.getTreeAddress())).withTreeHeight(paramArrayOfByte.getTreeHeight()).withTreeIndex((paramArrayOfByte.getTreeIndex() - 1) / 2).withKeyAndMask(paramArrayOfByte.getKeyAndMask())).build();
              paramOTSHashAddress[1] = randomizeHash((XMSSNode)paramXMSSReducedSignature.getAuthPath().get(i), paramOTSHashAddress[0], paramArrayOfByte);
              paramOTSHashAddress[1] = new XMSSNode(paramOTSHashAddress[1].getHeight() + 1, paramOTSHashAddress[1].getValue());
            }
            paramOTSHashAddress[0] = paramOTSHashAddress[1];
            i += 1;
          }
          return paramOTSHashAddress[0];
        }
        throw new NullPointerException("otsHashAddress == null");
      }
      throw new NullPointerException("signature == null");
    }
    throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
  }
  
  protected WOTSPlus getWOTSPlus()
  {
    return this.wotsPlus;
  }
  
  protected byte[] getWOTSPlusSecretKey(OTSHashAddress paramOTSHashAddress)
  {
    paramOTSHashAddress = (OTSHashAddress)((OTSHashAddress.Builder)((OTSHashAddress.Builder)new OTSHashAddress.Builder().withLayerAddress(paramOTSHashAddress.getLayerAddress())).withTreeAddress(paramOTSHashAddress.getTreeAddress())).withOTSAddress(paramOTSHashAddress.getOTSAddress()).build();
    return this.khf.PRF(this.privateKey.getSecretKeySeed(), paramOTSHashAddress.toByteArray());
  }
  
  public void importState(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws ParseException, ClassNotFoundException, IOException
  {
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte2 != null)
      {
        paramArrayOfByte1 = new XMSSPrivateKeyParameters.Builder(this.params).withPrivateKey(paramArrayOfByte1, this).build();
        paramArrayOfByte2 = new XMSSPublicKeyParameters.Builder(this.params).withPublicKey(paramArrayOfByte2).build();
        if (XMSSUtil.compareByteArray(paramArrayOfByte1.getRoot(), paramArrayOfByte2.getRoot()))
        {
          if (XMSSUtil.compareByteArray(paramArrayOfByte1.getPublicSeed(), paramArrayOfByte2.getPublicSeed()))
          {
            this.privateKey = paramArrayOfByte1;
            this.publicKey = paramArrayOfByte2;
            this.wotsPlus.importKeys(new byte[this.params.getDigestSize()], this.privateKey.getPublicSeed());
            return;
          }
          throw new IllegalStateException("public seed of private key and public key do not match");
        }
        throw new IllegalStateException("root of private key and public key do not match");
      }
      throw new NullPointerException("publicKey == null");
    }
    throw new NullPointerException("privateKey == null");
  }
  
  protected XMSSNode lTree(WOTSPlusPublicKeyParameters paramWOTSPlusPublicKeyParameters, LTreeAddress paramLTreeAddress)
  {
    if (paramWOTSPlusPublicKeyParameters != null)
    {
      if (paramLTreeAddress != null)
      {
        int j = this.wotsPlus.getParams().getLen();
        paramWOTSPlusPublicKeyParameters = paramWOTSPlusPublicKeyParameters.toByteArray();
        XMSSNode[] arrayOfXMSSNode = new XMSSNode[paramWOTSPlusPublicKeyParameters.length];
        int i = 0;
        while (i < paramWOTSPlusPublicKeyParameters.length)
        {
          arrayOfXMSSNode[i] = new XMSSNode(0, paramWOTSPlusPublicKeyParameters[i]);
          i += 1;
        }
        paramWOTSPlusPublicKeyParameters = ((LTreeAddress.Builder)((LTreeAddress.Builder)new LTreeAddress.Builder().withLayerAddress(paramLTreeAddress.getLayerAddress())).withTreeAddress(paramLTreeAddress.getTreeAddress())).withLTreeAddress(paramLTreeAddress.getLTreeAddress()).withTreeHeight(0).withTreeIndex(paramLTreeAddress.getTreeIndex()).withKeyAndMask(paramLTreeAddress.getKeyAndMask());
        i = j;
        for (;;)
        {
          paramWOTSPlusPublicKeyParameters = (LTreeAddress)((LTreeAddress.Builder)paramWOTSPlusPublicKeyParameters).build();
          if (i <= 1) {
            break;
          }
          j = 0;
          double d;
          for (;;)
          {
            d = i / 2;
            if (j >= (int)Math.floor(d)) {
              break;
            }
            paramWOTSPlusPublicKeyParameters = (LTreeAddress)((LTreeAddress.Builder)((LTreeAddress.Builder)((LTreeAddress.Builder)new LTreeAddress.Builder().withLayerAddress(paramWOTSPlusPublicKeyParameters.getLayerAddress())).withTreeAddress(paramWOTSPlusPublicKeyParameters.getTreeAddress())).withLTreeAddress(paramWOTSPlusPublicKeyParameters.getLTreeAddress()).withTreeHeight(paramWOTSPlusPublicKeyParameters.getTreeHeight()).withTreeIndex(j).withKeyAndMask(paramWOTSPlusPublicKeyParameters.getKeyAndMask())).build();
            int k = j * 2;
            arrayOfXMSSNode[j] = randomizeHash(arrayOfXMSSNode[k], arrayOfXMSSNode[(k + 1)], paramWOTSPlusPublicKeyParameters);
            j += 1;
          }
          if (i % 2 == 1) {
            arrayOfXMSSNode[((int)Math.floor(d))] = arrayOfXMSSNode[(i - 1)];
          }
          i = (int)Math.ceil(i / 2.0D);
          paramWOTSPlusPublicKeyParameters = ((LTreeAddress.Builder)((LTreeAddress.Builder)new LTreeAddress.Builder().withLayerAddress(paramWOTSPlusPublicKeyParameters.getLayerAddress())).withTreeAddress(paramWOTSPlusPublicKeyParameters.getTreeAddress())).withLTreeAddress(paramWOTSPlusPublicKeyParameters.getLTreeAddress()).withTreeHeight(paramWOTSPlusPublicKeyParameters.getTreeHeight() + 1).withTreeIndex(paramWOTSPlusPublicKeyParameters.getTreeIndex()).withKeyAndMask(paramWOTSPlusPublicKeyParameters.getKeyAndMask());
        }
        return arrayOfXMSSNode[0];
      }
      throw new NullPointerException("address == null");
    }
    throw new NullPointerException("publicKey == null");
  }
  
  protected XMSSNode randomizeHash(XMSSNode paramXMSSNode1, XMSSNode paramXMSSNode2, XMSSAddress paramXMSSAddress)
  {
    if (paramXMSSNode1 != null)
    {
      if (paramXMSSNode2 != null)
      {
        if (paramXMSSNode1.getHeight() == paramXMSSNode2.getHeight())
        {
          if (paramXMSSAddress != null)
          {
            byte[] arrayOfByte1 = getPublicSeed();
            boolean bool = paramXMSSAddress instanceof LTreeAddress;
            int k = 0;
            if (bool)
            {
              paramXMSSAddress = (LTreeAddress)paramXMSSAddress;
              localObject = (LTreeAddress)((LTreeAddress.Builder)((LTreeAddress.Builder)((LTreeAddress.Builder)new LTreeAddress.Builder().withLayerAddress(paramXMSSAddress.getLayerAddress())).withTreeAddress(paramXMSSAddress.getTreeAddress())).withLTreeAddress(paramXMSSAddress.getLTreeAddress()).withTreeHeight(paramXMSSAddress.getTreeHeight()).withTreeIndex(paramXMSSAddress.getTreeIndex()).withKeyAndMask(0)).build();
            }
            else
            {
              localObject = paramXMSSAddress;
              if ((paramXMSSAddress instanceof HashTreeAddress))
              {
                paramXMSSAddress = (HashTreeAddress)paramXMSSAddress;
                localObject = (HashTreeAddress)((HashTreeAddress.Builder)((HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(paramXMSSAddress.getLayerAddress())).withTreeAddress(paramXMSSAddress.getTreeAddress())).withTreeHeight(paramXMSSAddress.getTreeHeight()).withTreeIndex(paramXMSSAddress.getTreeIndex()).withKeyAndMask(0)).build();
              }
            }
            byte[] arrayOfByte2 = this.khf.PRF(arrayOfByte1, ((XMSSAddress)localObject).toByteArray());
            if ((localObject instanceof LTreeAddress))
            {
              paramXMSSAddress = (LTreeAddress)localObject;
              paramXMSSAddress = (LTreeAddress)((LTreeAddress.Builder)((LTreeAddress.Builder)((LTreeAddress.Builder)new LTreeAddress.Builder().withLayerAddress(paramXMSSAddress.getLayerAddress())).withTreeAddress(paramXMSSAddress.getTreeAddress())).withLTreeAddress(paramXMSSAddress.getLTreeAddress()).withTreeHeight(paramXMSSAddress.getTreeHeight()).withTreeIndex(paramXMSSAddress.getTreeIndex()).withKeyAndMask(1)).build();
            }
            else
            {
              paramXMSSAddress = (XMSSAddress)localObject;
              if ((localObject instanceof HashTreeAddress))
              {
                paramXMSSAddress = (HashTreeAddress)localObject;
                paramXMSSAddress = (HashTreeAddress)((HashTreeAddress.Builder)((HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(paramXMSSAddress.getLayerAddress())).withTreeAddress(paramXMSSAddress.getTreeAddress())).withTreeHeight(paramXMSSAddress.getTreeHeight()).withTreeIndex(paramXMSSAddress.getTreeIndex()).withKeyAndMask(1)).build();
              }
            }
            byte[] arrayOfByte3 = this.khf.PRF(arrayOfByte1, paramXMSSAddress.toByteArray());
            if ((paramXMSSAddress instanceof LTreeAddress))
            {
              paramXMSSAddress = (LTreeAddress)paramXMSSAddress;
              localObject = (LTreeAddress)((LTreeAddress.Builder)((LTreeAddress.Builder)((LTreeAddress.Builder)new LTreeAddress.Builder().withLayerAddress(paramXMSSAddress.getLayerAddress())).withTreeAddress(paramXMSSAddress.getTreeAddress())).withLTreeAddress(paramXMSSAddress.getLTreeAddress()).withTreeHeight(paramXMSSAddress.getTreeHeight()).withTreeIndex(paramXMSSAddress.getTreeIndex()).withKeyAndMask(2)).build();
            }
            else
            {
              localObject = paramXMSSAddress;
              if ((paramXMSSAddress instanceof HashTreeAddress))
              {
                paramXMSSAddress = (HashTreeAddress)paramXMSSAddress;
                localObject = (HashTreeAddress)((HashTreeAddress.Builder)((HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(paramXMSSAddress.getLayerAddress())).withTreeAddress(paramXMSSAddress.getTreeAddress())).withTreeHeight(paramXMSSAddress.getTreeHeight()).withTreeIndex(paramXMSSAddress.getTreeIndex()).withKeyAndMask(2)).build();
              }
            }
            paramXMSSAddress = this.khf.PRF(arrayOfByte1, ((XMSSAddress)localObject).toByteArray());
            int m = this.params.getDigestSize();
            Object localObject = new byte[m * 2];
            int i = 0;
            int j;
            for (;;)
            {
              j = k;
              if (i >= m) {
                break;
              }
              localObject[i] = ((byte)(paramXMSSNode1.getValue()[i] ^ arrayOfByte3[i]));
              i += 1;
            }
            while (j < m)
            {
              localObject[(j + m)] = ((byte)(paramXMSSNode2.getValue()[j] ^ paramXMSSAddress[j]));
              j += 1;
            }
            paramXMSSNode2 = this.khf.H(arrayOfByte2, (byte[])localObject);
            return new XMSSNode(paramXMSSNode1.getHeight(), paramXMSSNode2);
          }
          throw new NullPointerException("address == null");
        }
        throw new IllegalStateException("height of both nodes must be equal");
      }
      throw new NullPointerException("right == null");
    }
    throw new NullPointerException("left == null");
  }
  
  protected void setIndex(int paramInt)
  {
    try
    {
      this.privateKey = new XMSSPrivateKeyParameters.Builder(this.params).withIndex(paramInt).withSecretKeySeed(this.privateKey.getSecretKeySeed()).withSecretKeyPRF(this.privateKey.getSecretKeyPRF()).withPublicSeed(this.privateKey.getPublicSeed()).withRoot(this.privateKey.getRoot()).withBDSState(this.privateKey.getBDSState()).build();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
      return;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
  }
  
  protected void setPublicSeed(byte[] paramArrayOfByte)
  {
    try
    {
      this.privateKey = new XMSSPrivateKeyParameters.Builder(this.params).withIndex(this.privateKey.getIndex()).withSecretKeySeed(this.privateKey.getSecretKeySeed()).withSecretKeyPRF(this.privateKey.getSecretKeyPRF()).withPublicSeed(paramArrayOfByte).withRoot(getRoot()).withBDSState(this.privateKey.getBDSState()).build();
      this.publicKey = new XMSSPublicKeyParameters.Builder(this.params).withRoot(getRoot()).withPublicSeed(paramArrayOfByte).build();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    this.wotsPlus.importKeys(new byte[this.params.getDigestSize()], paramArrayOfByte);
  }
  
  protected void setRoot(byte[] paramArrayOfByte)
  {
    try
    {
      this.privateKey = new XMSSPrivateKeyParameters.Builder(this.params).withIndex(this.privateKey.getIndex()).withSecretKeySeed(this.privateKey.getSecretKeySeed()).withSecretKeyPRF(this.privateKey.getSecretKeyPRF()).withPublicSeed(getPublicSeed()).withRoot(paramArrayOfByte).withBDSState(this.privateKey.getBDSState()).build();
      this.publicKey = new XMSSPublicKeyParameters.Builder(this.params).withRoot(paramArrayOfByte).withPublicSeed(getPublicSeed()).build();
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return;
    }
    catch (ClassNotFoundException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return;
    }
    catch (ParseException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public byte[] sign(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (!getBDSState().getAuthenticationPath().isEmpty())
      {
        int i = this.privateKey.getIndex();
        int j = getParams().getHeight();
        long l = i;
        if (XMSSUtil.isIndexValid(j, l))
        {
          Object localObject1 = this.khf.PRF(this.privateKey.getSecretKeyPRF(), XMSSUtil.toBytesBigEndian(l, 32));
          Object localObject2 = XMSSUtil.concat(new byte[][] { localObject1, this.privateKey.getRoot(), XMSSUtil.toBytesBigEndian(l, this.params.getDigestSize()) });
          localObject2 = wotsSign(this.khf.HMsg((byte[])localObject2, paramArrayOfByte), (OTSHashAddress)new OTSHashAddress.Builder().withOTSAddress(i).build());
          paramArrayOfByte = null;
          try
          {
            localObject1 = (XMSSSignature)new XMSSSignature.Builder(this.params).withIndex(i).withRandom((byte[])localObject1).withWOTSPlusSignature((WOTSPlusSignature)localObject2).withAuthPath(getBDSState().getAuthenticationPath()).build();
            paramArrayOfByte = (byte[])localObject1;
          }
          catch (ParseException localParseException)
          {
            localParseException.printStackTrace();
          }
          if (i < (1 << getParams().getHeight()) - 1) {
            getBDSState().nextAuthenticationPath((OTSHashAddress)new OTSHashAddress.Builder().build());
          }
          setIndex(i + 1);
          return paramArrayOfByte.toByteArray();
        }
        throw new IllegalArgumentException("index out of bounds");
      }
      throw new IllegalStateException("not initialized");
    }
    throw new NullPointerException("message == null");
  }
  
  public boolean verifySignature(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
    throws ParseException
  {
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte2 != null)
      {
        if (paramArrayOfByte3 != null)
        {
          paramArrayOfByte2 = new XMSSSignature.Builder(this.params).withSignature(paramArrayOfByte2).build();
          paramArrayOfByte3 = new XMSSPublicKeyParameters.Builder(this.params).withPublicKey(paramArrayOfByte3).build();
          int i = this.privateKey.getIndex();
          byte[] arrayOfByte1 = this.privateKey.getPublicSeed();
          int j = paramArrayOfByte2.getIndex();
          setIndex(j);
          setPublicSeed(paramArrayOfByte3.getPublicSeed());
          this.wotsPlus.importKeys(new byte[this.params.getDigestSize()], getPublicSeed());
          byte[] arrayOfByte2 = XMSSUtil.concat(new byte[][] { paramArrayOfByte2.getRandom(), paramArrayOfByte3.getRoot(), XMSSUtil.toBytesBigEndian(j, this.params.getDigestSize()) });
          paramArrayOfByte1 = getRootNodeFromSignature(this.khf.HMsg(arrayOfByte2, paramArrayOfByte1), paramArrayOfByte2, (OTSHashAddress)new OTSHashAddress.Builder().withOTSAddress(j).build());
          setIndex(i);
          setPublicSeed(arrayOfByte1);
          return XMSSUtil.compareByteArray(paramArrayOfByte1.getValue(), paramArrayOfByte3.getRoot());
        }
        throw new NullPointerException("publicKey == null");
      }
      throw new NullPointerException("signature == null");
    }
    throw new NullPointerException("message == null");
  }
  
  protected WOTSPlusSignature wotsSign(byte[] paramArrayOfByte, OTSHashAddress paramOTSHashAddress)
  {
    if (paramArrayOfByte.length == this.params.getDigestSize())
    {
      if (paramOTSHashAddress != null)
      {
        this.wotsPlus.importKeys(getWOTSPlusSecretKey(paramOTSHashAddress), getPublicSeed());
        return this.wotsPlus.sign(paramArrayOfByte, paramOTSHashAddress);
      }
      throw new NullPointerException("otsHashAddress == null");
    }
    throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\xmss\XMSS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */