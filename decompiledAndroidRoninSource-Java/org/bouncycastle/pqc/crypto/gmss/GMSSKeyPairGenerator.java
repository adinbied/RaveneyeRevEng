package org.bouncycastle.pqc.crypto.gmss;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Vector;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.bouncycastle.pqc.crypto.gmss.util.WinternitzOTSVerify;
import org.bouncycastle.pqc.crypto.gmss.util.WinternitzOTSignature;

public class GMSSKeyPairGenerator
  implements AsymmetricCipherKeyPairGenerator
{
  public static final String OID = "1.3.6.1.4.1.8301.3.1.3.3";
  private int[] K;
  private byte[][] currentRootSigs;
  private byte[][] currentSeeds;
  private GMSSDigestProvider digestProvider;
  private GMSSParameters gmssPS;
  private GMSSKeyGenerationParameters gmssParams;
  private GMSSRandom gmssRandom;
  private int[] heightOfTrees;
  private boolean initialized = false;
  private int mdLength;
  private Digest messDigestTree;
  private byte[][] nextNextSeeds;
  private int numLayer;
  private int[] otsIndex;
  
  public GMSSKeyPairGenerator(GMSSDigestProvider paramGMSSDigestProvider)
  {
    this.digestProvider = paramGMSSDigestProvider;
    paramGMSSDigestProvider = paramGMSSDigestProvider.get();
    this.messDigestTree = paramGMSSDigestProvider;
    this.mdLength = paramGMSSDigestProvider.getDigestSize();
    this.gmssRandom = new GMSSRandom(this.messDigestTree);
  }
  
  private AsymmetricCipherKeyPair genKeyPair()
  {
    if (!this.initialized) {
      initializeDefault();
    }
    int i = this.numLayer;
    byte[][][] arrayOfByte1 = new byte[i][][];
    byte[][][] arrayOfByte2 = new byte[i - 1][][];
    Treehash[][] arrayOfTreehash1 = new Treehash[i][];
    Treehash[][] arrayOfTreehash2 = new Treehash[i - 1][];
    Vector[] arrayOfVector1 = new Vector[i];
    Vector[] arrayOfVector2 = new Vector[i - 1];
    Object localObject3 = new Vector[i][];
    Vector[][] arrayOfVector = new Vector[i - 1][];
    i = 0;
    int j;
    Object localObject1;
    for (;;)
    {
      j = this.numLayer;
      if (i >= j) {
        break;
      }
      arrayOfByte1[i] = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { this.heightOfTrees[i], this.mdLength }));
      localObject1 = this.heightOfTrees;
      arrayOfTreehash1[i] = new Treehash[localObject1[i] - this.K[i]];
      if (i > 0)
      {
        j = i - 1;
        arrayOfByte2[j] = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { localObject1[i], this.mdLength }));
        arrayOfTreehash2[j] = new Treehash[this.heightOfTrees[i] - this.K[i]];
      }
      arrayOfVector1[i] = new Vector();
      if (i > 0) {
        arrayOfVector2[(i - 1)] = new Vector();
      }
      i += 1;
    }
    byte[][] arrayOfByte3 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { j, this.mdLength });
    byte[][] arrayOfByte4 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { this.numLayer - 1, this.mdLength });
    byte[][] arrayOfByte5 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { this.numLayer, this.mdLength });
    i = 0;
    for (;;)
    {
      j = this.numLayer;
      if (i >= j) {
        break;
      }
      System.arraycopy(this.currentSeeds[i], 0, arrayOfByte5[i], 0, this.mdLength);
      i += 1;
    }
    this.currentRootSigs = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { j - 1, this.mdLength }));
    i = this.numLayer - 1;
    label481:
    Object localObject2;
    if (i >= 0)
    {
      GMSSRootCalc localGMSSRootCalc = new GMSSRootCalc(this.heightOfTrees[i], this.K[i], this.digestProvider);
      try
      {
        j = this.numLayer;
        if (i == j - 1) {}
        try
        {
          localObject1 = generateCurrentAuthpathAndRoot(null, arrayOfVector1[i], arrayOfByte5[i], i);
        }
        catch (Exception localException1)
        {
          break label481;
        }
        localObject1 = generateCurrentAuthpathAndRoot(arrayOfByte3[(i + 1)], arrayOfVector1[i], arrayOfByte5[i], i);
      }
      catch (Exception localException2) {}
      localException2.printStackTrace();
      localObject2 = localGMSSRootCalc;
    }
    for (;;)
    {
      j = 0;
      while (j < this.heightOfTrees[i])
      {
        System.arraycopy(localObject2.getAuthPath()[j], 0, arrayOfByte1[i][j], 0, this.mdLength);
        j += 1;
      }
      localObject3[i] = ((GMSSRootCalc)localObject2).getRetain();
      arrayOfTreehash1[i] = ((GMSSRootCalc)localObject2).getTreehash();
      System.arraycopy(((GMSSRootCalc)localObject2).getRoot(), 0, arrayOfByte3[i], 0, this.mdLength);
      i -= 1;
      break;
      i = this.numLayer - 2;
      localObject2 = localObject3;
      while (i >= 0)
      {
        localObject3 = arrayOfVector2[i];
        int k = i + 1;
        localObject3 = generateNextAuthpathAndRoot((Vector)localObject3, arrayOfByte5[k], k);
        j = 0;
        while (j < this.heightOfTrees[k])
        {
          System.arraycopy(localObject3.getAuthPath()[j], 0, arrayOfByte2[i][j], 0, this.mdLength);
          j += 1;
        }
        arrayOfVector[i] = ((GMSSRootCalc)localObject3).getRetain();
        arrayOfTreehash2[i] = ((GMSSRootCalc)localObject3).getTreehash();
        System.arraycopy(((GMSSRootCalc)localObject3).getRoot(), 0, arrayOfByte4[i], 0, this.mdLength);
        System.arraycopy(arrayOfByte5[k], 0, this.nextNextSeeds[i], 0, this.mdLength);
        i -= 1;
      }
      return new AsymmetricCipherKeyPair(new GMSSPublicKeyParameters(arrayOfByte3[0], this.gmssPS), new GMSSPrivateKeyParameters(this.currentSeeds, this.nextNextSeeds, arrayOfByte1, arrayOfByte2, arrayOfTreehash1, arrayOfTreehash2, arrayOfVector1, arrayOfVector2, (Vector[][])localObject2, arrayOfVector, arrayOfByte4, this.currentRootSigs, this.gmssPS, this.digestProvider));
    }
  }
  
  private GMSSRootCalc generateCurrentAuthpathAndRoot(byte[] paramArrayOfByte1, Vector paramVector, byte[] paramArrayOfByte2, int paramInt)
  {
    int i = this.mdLength;
    Object localObject = new byte[i];
    localObject = new byte[i];
    byte[] arrayOfByte = this.gmssRandom.nextSeed(paramArrayOfByte2);
    localObject = new GMSSRootCalc(this.heightOfTrees[paramInt], this.K[paramInt], this.digestProvider);
    ((GMSSRootCalc)localObject).initialize(paramVector);
    if (paramInt == this.numLayer - 1)
    {
      paramArrayOfByte1 = new WinternitzOTSignature(arrayOfByte, this.digestProvider.get(), this.otsIndex[paramInt]).getPublicKey();
    }
    else
    {
      paramVector = new WinternitzOTSignature(arrayOfByte, this.digestProvider.get(), this.otsIndex[paramInt]);
      this.currentRootSigs[paramInt] = paramVector.getSignature(paramArrayOfByte1);
      paramArrayOfByte1 = new WinternitzOTSVerify(this.digestProvider.get(), this.otsIndex[paramInt]).Verify(paramArrayOfByte1, this.currentRootSigs[paramInt]);
    }
    ((GMSSRootCalc)localObject).update(paramArrayOfByte1);
    int m = 3;
    i = 0;
    int j = 1;
    for (;;)
    {
      paramArrayOfByte1 = this.heightOfTrees;
      if (j >= 1 << paramArrayOfByte1[paramInt]) {
        break;
      }
      int n = m;
      int k = i;
      if (j == m)
      {
        n = m;
        k = i;
        if (i < paramArrayOfByte1[paramInt] - this.K[paramInt])
        {
          ((GMSSRootCalc)localObject).initializeTreehashSeed(paramArrayOfByte2, i);
          n = m * 2;
          k = i + 1;
        }
      }
      ((GMSSRootCalc)localObject).update(new WinternitzOTSignature(this.gmssRandom.nextSeed(paramArrayOfByte2), this.digestProvider.get(), this.otsIndex[paramInt]).getPublicKey());
      j += 1;
      m = n;
      i = k;
    }
    if (((GMSSRootCalc)localObject).wasFinished()) {
      return (GMSSRootCalc)localObject;
    }
    System.err.println("Baum noch nicht fertig konstruiert!!!");
    return null;
  }
  
  private GMSSRootCalc generateNextAuthpathAndRoot(Vector paramVector, byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = new byte[this.numLayer];
    localObject = new GMSSRootCalc(this.heightOfTrees[paramInt], this.K[paramInt], this.digestProvider);
    ((GMSSRootCalc)localObject).initialize(paramVector);
    int i = 0;
    int j = 0;
    int m;
    for (int k = 3;; k = m)
    {
      paramVector = this.heightOfTrees;
      if (i >= 1 << paramVector[paramInt]) {
        break;
      }
      int n = j;
      m = k;
      if (i == k)
      {
        n = j;
        m = k;
        if (j < paramVector[paramInt] - this.K[paramInt])
        {
          ((GMSSRootCalc)localObject).initializeTreehashSeed(paramArrayOfByte, j);
          m = k * 2;
          n = j + 1;
        }
      }
      ((GMSSRootCalc)localObject).update(new WinternitzOTSignature(this.gmssRandom.nextSeed(paramArrayOfByte), this.digestProvider.get(), this.otsIndex[paramInt]).getPublicKey());
      i += 1;
      j = n;
    }
    if (((GMSSRootCalc)localObject).wasFinished()) {
      return (GMSSRootCalc)localObject;
    }
    System.err.println("N�chster Baum noch nicht fertig konstruiert!!!");
    return null;
  }
  
  private void initializeDefault()
  {
    initialize(new GMSSKeyGenerationParameters(new SecureRandom(), new GMSSParameters(4, new int[] { 10, 10, 10, 10 }, new int[] { 3, 3, 3, 3 }, new int[] { 2, 2, 2, 2 })));
  }
  
  public AsymmetricCipherKeyPair generateKeyPair()
  {
    return genKeyPair();
  }
  
  public void init(KeyGenerationParameters paramKeyGenerationParameters)
  {
    initialize(paramKeyGenerationParameters);
  }
  
  public void initialize(int paramInt, SecureRandom paramSecureRandom)
  {
    if (paramInt <= 10) {
      paramSecureRandom = new GMSSKeyGenerationParameters(paramSecureRandom, new GMSSParameters(1, new int[] { 10 }, new int[] { 3 }, new int[] { 2 }));
    } else if (paramInt <= 20) {
      paramSecureRandom = new GMSSKeyGenerationParameters(paramSecureRandom, new GMSSParameters(2, new int[] { 10, 10 }, new int[] { 5, 4 }, new int[] { 2, 2 }));
    } else {
      paramSecureRandom = new GMSSKeyGenerationParameters(paramSecureRandom, new GMSSParameters(4, new int[] { 10, 10, 10, 10 }, new int[] { 9, 9, 9, 3 }, new int[] { 2, 2, 2, 2 }));
    }
    initialize(paramSecureRandom);
  }
  
  public void initialize(KeyGenerationParameters paramKeyGenerationParameters)
  {
    paramKeyGenerationParameters = (GMSSKeyGenerationParameters)paramKeyGenerationParameters;
    this.gmssParams = paramKeyGenerationParameters;
    paramKeyGenerationParameters = new GMSSParameters(paramKeyGenerationParameters.getParameters().getNumOfLayers(), this.gmssParams.getParameters().getHeightOfTrees(), this.gmssParams.getParameters().getWinternitzParameter(), this.gmssParams.getParameters().getK());
    this.gmssPS = paramKeyGenerationParameters;
    this.numLayer = paramKeyGenerationParameters.getNumOfLayers();
    this.heightOfTrees = this.gmssPS.getHeightOfTrees();
    this.otsIndex = this.gmssPS.getWinternitzParameter();
    this.K = this.gmssPS.getK();
    int j = this.numLayer;
    int k = this.mdLength;
    int i = 0;
    this.currentSeeds = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { j, k }));
    this.nextNextSeeds = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { this.numLayer - 1, this.mdLength }));
    paramKeyGenerationParameters = new SecureRandom();
    while (i < this.numLayer)
    {
      paramKeyGenerationParameters.nextBytes(this.currentSeeds[i]);
      this.gmssRandom.nextSeed(this.currentSeeds[i]);
      i += 1;
    }
    this.initialized = true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\gmss\GMSSKeyPairGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */