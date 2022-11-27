package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import java.security.SecureRandom;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public final class XMSSMT
{
  private KeyedHashFunctions khf;
  private XMSSMTParameters params;
  private XMSSMTPrivateKeyParameters privateKey;
  private SecureRandom prng;
  private XMSSMTPublicKeyParameters publicKey;
  private XMSS xmss;
  
  public XMSSMT(XMSSMTParameters paramXMSSMTParameters)
  {
    if (paramXMSSMTParameters != null)
    {
      this.params = paramXMSSMTParameters;
      this.xmss = paramXMSSMTParameters.getXMSS();
      this.prng = paramXMSSMTParameters.getXMSS().getParams().getPRNG();
      this.khf = this.xmss.getKhf();
      try
      {
        this.privateKey = new XMSSMTPrivateKeyParameters.Builder(paramXMSSMTParameters).build();
        this.publicKey = new XMSSMTPublicKeyParameters.Builder(paramXMSSMTParameters).build();
        return;
      }
      catch (IOException paramXMSSMTParameters)
      {
        paramXMSSMTParameters.printStackTrace();
        return;
      }
      catch (ClassNotFoundException paramXMSSMTParameters)
      {
        paramXMSSMTParameters.printStackTrace();
        return;
      }
      catch (ParseException paramXMSSMTParameters)
      {
        paramXMSSMTParameters.printStackTrace();
        return;
      }
    }
    throw new NullPointerException("params == null");
  }
  
  private XMSSMTPrivateKeyParameters generatePrivateKey()
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
      localObject = new XMSSMTPrivateKeyParameters.Builder(this.params).withSecretKeySeed((byte[])localObject).withSecretKeyPRF(arrayOfByte1).withPublicSeed(arrayOfByte2).withBDSState(this.privateKey.getBDSState()).build();
      return (XMSSMTPrivateKeyParameters)localObject;
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
    Object localObject4 = null;
    XMSSPrivateKeyParameters localXMSSPrivateKeyParameters;
    try
    {
      localXMSSPrivateKeyParameters = new XMSSPrivateKeyParameters.Builder(this.xmss.getParams()).withSecretKeySeed(this.privateKey.getSecretKeySeed()).withSecretKeyPRF(this.privateKey.getSecretKeyPRF()).withPublicSeed(this.privateKey.getPublicSeed()).withBDSState(new BDS(this.xmss)).build();
      try
      {
        XMSSPublicKeyParameters localXMSSPublicKeyParameters = new XMSSPublicKeyParameters.Builder(this.xmss.getParams()).withPublicSeed(getPublicSeed()).build();
      }
      catch (IOException localIOException3) {}catch (ClassNotFoundException localClassNotFoundException3) {}catch (ParseException localParseException3) {}
      Object localObject1;
      Object localObject2;
      localParseException4.printStackTrace();
    }
    catch (IOException localIOException4)
    {
      localXMSSPrivateKeyParameters = null;
      localIOException4.printStackTrace();
      localObject1 = localObject4;
    }
    catch (ClassNotFoundException localClassNotFoundException4)
    {
      localXMSSPrivateKeyParameters = null;
      localClassNotFoundException4.printStackTrace();
      localObject2 = localObject4;
    }
    catch (ParseException localParseException4)
    {
      localXMSSPrivateKeyParameters = null;
    }
    Object localObject3 = localObject4;
    try
    {
      this.xmss.importState(localXMSSPrivateKeyParameters.toByteArray(), ((XMSSPublicKeyParameters)localObject3).toByteArray());
    }
    catch (IOException localIOException1)
    {
      localIOException1.printStackTrace();
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      localClassNotFoundException1.printStackTrace();
    }
    catch (ParseException localParseException1)
    {
      localParseException1.printStackTrace();
    }
    int i = this.params.getLayers() - 1;
    localObject3 = (OTSHashAddress)((OTSHashAddress.Builder)new OTSHashAddress.Builder().withLayerAddress(i)).build();
    BDS localBDS = new BDS(this.xmss);
    localObject3 = localBDS.initialize((OTSHashAddress)localObject3);
    getBDSState().put(Integer.valueOf(i), localBDS);
    this.xmss.setRoot(((XMSSNode)localObject3).getValue());
    try
    {
      this.privateKey = new XMSSMTPrivateKeyParameters.Builder(this.params).withSecretKeySeed(this.privateKey.getSecretKeySeed()).withSecretKeyPRF(this.privateKey.getSecretKeyPRF()).withPublicSeed(this.privateKey.getPublicSeed()).withRoot(this.xmss.getRoot()).withBDSState(this.privateKey.getBDSState()).build();
      this.publicKey = new XMSSMTPublicKeyParameters.Builder(this.params).withRoot(((XMSSNode)localObject3).getValue()).withPublicSeed(getPublicSeed()).build();
      return;
    }
    catch (IOException localIOException2)
    {
      localIOException2.printStackTrace();
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException2)
    {
      localClassNotFoundException2.printStackTrace();
      return;
    }
    catch (ParseException localParseException2)
    {
      localParseException2.printStackTrace();
    }
  }
  
  protected Map<Integer, BDS> getBDSState()
  {
    return this.privateKey.getBDSState();
  }
  
  public long getIndex()
  {
    return this.privateKey.getIndex();
  }
  
  public XMSSMTParameters getParams()
  {
    return this.params;
  }
  
  public byte[] getPublicSeed()
  {
    return this.privateKey.getPublicSeed();
  }
  
  protected XMSS getXMSS()
  {
    return this.xmss;
  }
  
  public void importState(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws ParseException, ClassNotFoundException, IOException
  {
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte2 != null)
      {
        paramArrayOfByte1 = new XMSSMTPrivateKeyParameters.Builder(this.params).withPrivateKey(paramArrayOfByte1, this.xmss).build();
        paramArrayOfByte2 = new XMSSMTPublicKeyParameters.Builder(this.params).withPublicKey(paramArrayOfByte2).build();
        if (XMSSUtil.compareByteArray(paramArrayOfByte1.getRoot(), paramArrayOfByte2.getRoot()))
        {
          if (XMSSUtil.compareByteArray(paramArrayOfByte1.getPublicSeed(), paramArrayOfByte2.getPublicSeed()))
          {
            XMSSPrivateKeyParameters localXMSSPrivateKeyParameters = new XMSSPrivateKeyParameters.Builder(this.xmss.getParams()).withSecretKeySeed(paramArrayOfByte1.getSecretKeySeed()).withSecretKeyPRF(paramArrayOfByte1.getSecretKeyPRF()).withPublicSeed(paramArrayOfByte1.getPublicSeed()).withRoot(paramArrayOfByte1.getRoot()).withBDSState(new BDS(this.xmss)).build();
            XMSSPublicKeyParameters localXMSSPublicKeyParameters = new XMSSPublicKeyParameters.Builder(this.xmss.getParams()).withRoot(paramArrayOfByte1.getRoot()).withPublicSeed(getPublicSeed()).build();
            this.xmss.importState(localXMSSPrivateKeyParameters.toByteArray(), localXMSSPublicKeyParameters.toByteArray());
            this.privateKey = paramArrayOfByte1;
            this.publicKey = paramArrayOfByte2;
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
  
  public byte[] sign(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (!getBDSState().isEmpty())
      {
        long l3 = getIndex();
        int i = this.params.getHeight();
        int k = this.xmss.getParams().getHeight();
        if (XMSSUtil.isIndexValid(i, l3))
        {
          byte[] arrayOfByte = this.khf.PRF(this.privateKey.getSecretKeyPRF(), XMSSUtil.toBytesBigEndian(l3, 32));
          Object localObject2 = this.privateKey.getRoot();
          int j = 1;
          localObject2 = XMSSUtil.concat(new byte[][] { arrayOfByte, localObject2, XMSSUtil.toBytesBigEndian(l3, this.params.getDigestSize()) });
          paramArrayOfByte = this.khf.HMsg((byte[])localObject2, paramArrayOfByte);
          try
          {
            localObject2 = new XMSSMTSignature.Builder(this.params).withIndex(l3).withRandom(arrayOfByte).build();
          }
          catch (ParseException localParseException1)
          {
            localParseException1.printStackTrace();
            localObject2 = null;
          }
          long l2 = XMSSUtil.getTreeIndex(l3, k);
          int n = XMSSUtil.getLeafIndex(l3, k);
          this.xmss.setIndex(n);
          this.xmss.setPublicSeed(getPublicSeed());
          OTSHashAddress localOTSHashAddress = (OTSHashAddress)((OTSHashAddress.Builder)new OTSHashAddress.Builder().withTreeAddress(l2)).withOTSAddress(n).build();
          paramArrayOfByte = this.xmss.wotsSign(paramArrayOfByte, localOTSHashAddress);
          if ((getBDSState().get(Integer.valueOf(0)) == null) || (n == 0))
          {
            getBDSState().put(Integer.valueOf(0), new BDS(this.xmss));
            ((BDS)getBDSState().get(Integer.valueOf(0))).initialize(localOTSHashAddress);
          }
          Object localObject1;
          try
          {
            localObject1 = new XMSSReducedSignature.Builder(this.xmss.getParams()).withWOTSPlusSignature(paramArrayOfByte).withAuthPath(((BDS)getBDSState().get(Integer.valueOf(0))).getAuthenticationPath()).build();
          }
          catch (ParseException paramArrayOfByte)
          {
            paramArrayOfByte.printStackTrace();
            localObject1 = null;
          }
          ((XMSSMTSignature)localObject2).getReducedSignatures().add(localObject1);
          int m = (1 << k) - 1;
          paramArrayOfByte = (byte[])localObject1;
          i = j;
          long l1 = l2;
          if (n < m)
          {
            ((BDS)getBDSState().get(Integer.valueOf(0))).nextAuthenticationPath(localOTSHashAddress);
            l1 = l2;
            i = j;
            paramArrayOfByte = (byte[])localObject1;
          }
          while (i < this.params.getLayers())
          {
            localObject1 = ((BDS)getBDSState().get(Integer.valueOf(i - 1))).getRoot();
            j = XMSSUtil.getLeafIndex(l1, k);
            l1 = XMSSUtil.getTreeIndex(l1, k);
            this.xmss.setIndex(j);
            localOTSHashAddress = (OTSHashAddress)((OTSHashAddress.Builder)((OTSHashAddress.Builder)new OTSHashAddress.Builder().withLayerAddress(i)).withTreeAddress(l1)).withOTSAddress(j).build();
            localObject1 = this.xmss.wotsSign(((XMSSNode)localObject1).getValue(), localOTSHashAddress);
            if ((getBDSState().get(Integer.valueOf(i)) != null) && (!XMSSUtil.isNewBDSInitNeeded(l3, k, i))) {
              break label626;
            }
            getBDSState().put(Integer.valueOf(i), new BDS(this.xmss));
            ((BDS)getBDSState().get(Integer.valueOf(i))).initialize(localOTSHashAddress);
            try
            {
              label626:
              localObject1 = new XMSSReducedSignature.Builder(this.xmss.getParams()).withWOTSPlusSignature((WOTSPlusSignature)localObject1).withAuthPath(((BDS)getBDSState().get(Integer.valueOf(i))).getAuthenticationPath()).build();
              paramArrayOfByte = (byte[])localObject1;
            }
            catch (ParseException localParseException2)
            {
              localParseException2.printStackTrace();
            }
            ((XMSSMTSignature)localObject2).getReducedSignatures().add(paramArrayOfByte);
            if ((j < m) && (XMSSUtil.isNewAuthenticationPathNeeded(l3, k, i))) {
              ((BDS)getBDSState().get(Integer.valueOf(i))).nextAuthenticationPath(localOTSHashAddress);
            }
            i += 1;
          }
          try
          {
            this.privateKey = new XMSSMTPrivateKeyParameters.Builder(this.params).withIndex(l3 + 1L).withSecretKeySeed(this.privateKey.getSecretKeySeed()).withSecretKeyPRF(this.privateKey.getSecretKeyPRF()).withPublicSeed(this.privateKey.getPublicSeed()).withRoot(this.privateKey.getRoot()).withBDSState(this.privateKey.getBDSState()).build();
          }
          catch (IOException paramArrayOfByte)
          {
            paramArrayOfByte.printStackTrace();
          }
          catch (ClassNotFoundException paramArrayOfByte)
          {
            paramArrayOfByte.printStackTrace();
          }
          catch (ParseException paramArrayOfByte)
          {
            paramArrayOfByte.printStackTrace();
          }
          return ((XMSSMTSignature)localObject2).toByteArray();
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
          paramArrayOfByte2 = new XMSSMTSignature.Builder(this.params).withSignature(paramArrayOfByte2).build();
          paramArrayOfByte3 = new XMSSMTPublicKeyParameters.Builder(this.params).withPublicKey(paramArrayOfByte3).build();
          Object localObject1 = paramArrayOfByte2.getRandom();
          Object localObject2 = paramArrayOfByte3.getRoot();
          int i = 1;
          localObject1 = XMSSUtil.concat(new byte[][] { localObject1, localObject2, XMSSUtil.toBytesBigEndian(paramArrayOfByte2.getIndex(), this.params.getDigestSize()) });
          paramArrayOfByte1 = this.khf.HMsg((byte[])localObject1, paramArrayOfByte1);
          long l2 = paramArrayOfByte2.getIndex();
          int j = this.xmss.getParams().getHeight();
          long l1 = XMSSUtil.getTreeIndex(l2, j);
          int k = XMSSUtil.getLeafIndex(l2, j);
          this.xmss.setIndex(k);
          this.xmss.setPublicSeed(paramArrayOfByte3.getPublicSeed());
          localObject1 = (OTSHashAddress)((OTSHashAddress.Builder)new OTSHashAddress.Builder().withTreeAddress(l1)).withOTSAddress(k).build();
          localObject2 = (XMSSReducedSignature)paramArrayOfByte2.getReducedSignatures().get(0);
          paramArrayOfByte1 = this.xmss.getRootNodeFromSignature(paramArrayOfByte1, (XMSSReducedSignature)localObject2, (OTSHashAddress)localObject1);
          while (i < this.params.getLayers())
          {
            localObject1 = (XMSSReducedSignature)paramArrayOfByte2.getReducedSignatures().get(i);
            k = XMSSUtil.getLeafIndex(l1, j);
            l1 = XMSSUtil.getTreeIndex(l1, j);
            this.xmss.setIndex(k);
            localObject2 = (OTSHashAddress)((OTSHashAddress.Builder)((OTSHashAddress.Builder)new OTSHashAddress.Builder().withLayerAddress(i)).withTreeAddress(l1)).withOTSAddress(k).build();
            paramArrayOfByte1 = this.xmss.getRootNodeFromSignature(paramArrayOfByte1.getValue(), (XMSSReducedSignature)localObject1, (OTSHashAddress)localObject2);
            i += 1;
          }
          return XMSSUtil.compareByteArray(paramArrayOfByte1.getValue(), paramArrayOfByte3.getRoot());
        }
        throw new NullPointerException("publicKey == null");
      }
      throw new NullPointerException("signature == null");
    }
    throw new NullPointerException("message == null");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\xmss\XMSSMT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */