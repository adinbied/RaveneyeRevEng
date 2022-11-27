package org.bouncycastle.pqc.crypto.gmss;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Vector;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.bouncycastle.pqc.crypto.gmss.util.WinternitzOTSignature;
import org.bouncycastle.util.Arrays;

public class GMSSPrivateKeyParameters
  extends GMSSKeyParameters
{
  private int[] K;
  private byte[][][] currentAuthPaths;
  private Vector[][] currentRetain;
  private byte[][] currentRootSig;
  private byte[][] currentSeeds;
  private Vector[] currentStack;
  private Treehash[][] currentTreehash;
  private GMSSDigestProvider digestProvider;
  private GMSSParameters gmssPS;
  private GMSSRandom gmssRandom;
  private int[] heightOfTrees;
  private int[] index;
  private byte[][][] keep;
  private int mdLength;
  private Digest messDigestTrees;
  private int[] minTreehash;
  private byte[][][] nextAuthPaths;
  private GMSSLeaf[] nextNextLeaf;
  private GMSSRootCalc[] nextNextRoot;
  private byte[][] nextNextSeeds;
  private Vector[][] nextRetain;
  private byte[][] nextRoot;
  private GMSSRootSig[] nextRootSig;
  private Vector[] nextStack;
  private Treehash[][] nextTreehash;
  private int numLayer;
  private int[] numLeafs;
  private int[] otsIndex;
  private GMSSLeaf[] upperLeaf;
  private GMSSLeaf[] upperTreehashLeaf;
  private boolean used = false;
  
  private GMSSPrivateKeyParameters(GMSSPrivateKeyParameters paramGMSSPrivateKeyParameters)
  {
    super(true, paramGMSSPrivateKeyParameters.getParameters());
    this.index = Arrays.clone(paramGMSSPrivateKeyParameters.index);
    this.currentSeeds = Arrays.clone(paramGMSSPrivateKeyParameters.currentSeeds);
    this.nextNextSeeds = Arrays.clone(paramGMSSPrivateKeyParameters.nextNextSeeds);
    this.currentAuthPaths = Arrays.clone(paramGMSSPrivateKeyParameters.currentAuthPaths);
    this.nextAuthPaths = Arrays.clone(paramGMSSPrivateKeyParameters.nextAuthPaths);
    this.currentTreehash = paramGMSSPrivateKeyParameters.currentTreehash;
    this.nextTreehash = paramGMSSPrivateKeyParameters.nextTreehash;
    this.currentStack = paramGMSSPrivateKeyParameters.currentStack;
    this.nextStack = paramGMSSPrivateKeyParameters.nextStack;
    this.currentRetain = paramGMSSPrivateKeyParameters.currentRetain;
    this.nextRetain = paramGMSSPrivateKeyParameters.nextRetain;
    this.keep = Arrays.clone(paramGMSSPrivateKeyParameters.keep);
    this.nextNextLeaf = paramGMSSPrivateKeyParameters.nextNextLeaf;
    this.upperLeaf = paramGMSSPrivateKeyParameters.upperLeaf;
    this.upperTreehashLeaf = paramGMSSPrivateKeyParameters.upperTreehashLeaf;
    this.minTreehash = paramGMSSPrivateKeyParameters.minTreehash;
    this.gmssPS = paramGMSSPrivateKeyParameters.gmssPS;
    this.nextRoot = Arrays.clone(paramGMSSPrivateKeyParameters.nextRoot);
    this.nextNextRoot = paramGMSSPrivateKeyParameters.nextNextRoot;
    this.currentRootSig = paramGMSSPrivateKeyParameters.currentRootSig;
    this.nextRootSig = paramGMSSPrivateKeyParameters.nextRootSig;
    this.digestProvider = paramGMSSPrivateKeyParameters.digestProvider;
    this.heightOfTrees = paramGMSSPrivateKeyParameters.heightOfTrees;
    this.otsIndex = paramGMSSPrivateKeyParameters.otsIndex;
    this.K = paramGMSSPrivateKeyParameters.K;
    this.numLayer = paramGMSSPrivateKeyParameters.numLayer;
    this.messDigestTrees = paramGMSSPrivateKeyParameters.messDigestTrees;
    this.mdLength = paramGMSSPrivateKeyParameters.mdLength;
    this.gmssRandom = paramGMSSPrivateKeyParameters.gmssRandom;
    this.numLeafs = paramGMSSPrivateKeyParameters.numLeafs;
  }
  
  public GMSSPrivateKeyParameters(int[] paramArrayOfInt1, byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2, byte[][][] paramArrayOfByte3, byte[][][] paramArrayOfByte4, byte[][][] paramArrayOfByte5, Treehash[][] paramArrayOfTreehash1, Treehash[][] paramArrayOfTreehash2, Vector[] paramArrayOfVector1, Vector[] paramArrayOfVector2, Vector[][] paramArrayOfVector3, Vector[][] paramArrayOfVector4, GMSSLeaf[] paramArrayOfGMSSLeaf1, GMSSLeaf[] paramArrayOfGMSSLeaf2, GMSSLeaf[] paramArrayOfGMSSLeaf3, int[] paramArrayOfInt2, byte[][] paramArrayOfByte6, GMSSRootCalc[] paramArrayOfGMSSRootCalc, byte[][] paramArrayOfByte7, GMSSRootSig[] paramArrayOfGMSSRootSig, GMSSParameters paramGMSSParameters, GMSSDigestProvider paramGMSSDigestProvider)
  {
    super(true, paramGMSSParameters);
    Digest localDigest = paramGMSSDigestProvider.get();
    this.messDigestTrees = localDigest;
    this.mdLength = localDigest.getDigestSize();
    this.gmssPS = paramGMSSParameters;
    this.otsIndex = paramGMSSParameters.getWinternitzParameter();
    this.K = paramGMSSParameters.getK();
    this.heightOfTrees = paramGMSSParameters.getHeightOfTrees();
    int i = this.gmssPS.getNumOfLayers();
    this.numLayer = i;
    if (paramArrayOfInt1 == null)
    {
      this.index = new int[i];
      i = 0;
      while (i < this.numLayer)
      {
        this.index[i] = 0;
        i += 1;
      }
    }
    this.index = paramArrayOfInt1;
    this.currentSeeds = paramArrayOfByte1;
    this.nextNextSeeds = paramArrayOfByte2;
    this.currentAuthPaths = paramArrayOfByte3;
    this.nextAuthPaths = paramArrayOfByte4;
    if (paramArrayOfByte5 == null)
    {
      this.keep = new byte[this.numLayer][][];
      i = 0;
      while (i < this.numLayer)
      {
        this.keep[i] = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { (int)Math.floor(this.heightOfTrees[i] / 2), this.mdLength }));
        i += 1;
      }
    }
    this.keep = paramArrayOfByte5;
    if (paramArrayOfVector1 == null)
    {
      this.currentStack = new Vector[this.numLayer];
      i = 0;
      while (i < this.numLayer)
      {
        this.currentStack[i] = new Vector();
        i += 1;
      }
    }
    this.currentStack = paramArrayOfVector1;
    if (paramArrayOfVector2 == null)
    {
      this.nextStack = new Vector[this.numLayer - 1];
      i = 0;
      while (i < this.numLayer - 1)
      {
        this.nextStack[i] = new Vector();
        i += 1;
      }
    }
    this.nextStack = paramArrayOfVector2;
    this.currentTreehash = paramArrayOfTreehash1;
    this.nextTreehash = paramArrayOfTreehash2;
    this.currentRetain = paramArrayOfVector3;
    this.nextRetain = paramArrayOfVector4;
    this.nextRoot = paramArrayOfByte6;
    this.digestProvider = paramGMSSDigestProvider;
    int j;
    if (paramArrayOfGMSSRootCalc == null)
    {
      this.nextNextRoot = new GMSSRootCalc[this.numLayer - 1];
      for (i = 0; i < this.numLayer - 1; i = j)
      {
        paramArrayOfInt1 = this.nextNextRoot;
        paramArrayOfByte2 = this.heightOfTrees;
        j = i + 1;
        paramArrayOfInt1[i] = new GMSSRootCalc(paramArrayOfByte2[j], this.K[j], this.digestProvider);
      }
    }
    this.nextNextRoot = paramArrayOfGMSSRootCalc;
    this.currentRootSig = paramArrayOfByte7;
    this.numLeafs = new int[this.numLayer];
    i = 0;
    while (i < this.numLayer)
    {
      this.numLeafs[i] = (1 << this.heightOfTrees[i]);
      i += 1;
    }
    this.gmssRandom = new GMSSRandom(this.messDigestTrees);
    i = this.numLayer;
    if (i > 1)
    {
      if (paramArrayOfGMSSLeaf1 == null)
      {
        this.nextNextLeaf = new GMSSLeaf[i - 2];
        for (i = 0; i < this.numLayer - 2; i = j)
        {
          paramArrayOfInt1 = this.nextNextLeaf;
          paramArrayOfByte2 = paramGMSSDigestProvider.get();
          paramArrayOfByte3 = this.otsIndex;
          j = i + 1;
          paramArrayOfInt1[i] = new GMSSLeaf(paramArrayOfByte2, paramArrayOfByte3[j], this.numLeafs[(i + 2)], this.nextNextSeeds[i]);
        }
      }
      this.nextNextLeaf = paramArrayOfGMSSLeaf1;
    }
    else
    {
      this.nextNextLeaf = new GMSSLeaf[0];
    }
    int k;
    if (paramArrayOfGMSSLeaf2 == null)
    {
      this.upperLeaf = new GMSSLeaf[this.numLayer - 1];
      for (i = 0; i < this.numLayer - 1; i = j)
      {
        paramArrayOfInt1 = this.upperLeaf;
        paramArrayOfByte2 = paramGMSSDigestProvider.get();
        k = this.otsIndex[i];
        paramArrayOfByte3 = this.numLeafs;
        j = i + 1;
        paramArrayOfInt1[i] = new GMSSLeaf(paramArrayOfByte2, k, paramArrayOfByte3[j], this.currentSeeds[i]);
      }
    }
    this.upperLeaf = paramArrayOfGMSSLeaf2;
    if (paramArrayOfGMSSLeaf3 == null)
    {
      this.upperTreehashLeaf = new GMSSLeaf[this.numLayer - 1];
      for (i = 0; i < this.numLayer - 1; i = j)
      {
        paramArrayOfInt1 = this.upperTreehashLeaf;
        paramArrayOfByte2 = paramGMSSDigestProvider.get();
        k = this.otsIndex[i];
        paramArrayOfByte3 = this.numLeafs;
        j = i + 1;
        paramArrayOfInt1[i] = new GMSSLeaf(paramArrayOfByte2, k, paramArrayOfByte3[j]);
      }
    }
    this.upperTreehashLeaf = paramArrayOfGMSSLeaf3;
    if (paramArrayOfInt2 == null)
    {
      this.minTreehash = new int[this.numLayer - 1];
      i = 0;
      while (i < this.numLayer - 1)
      {
        this.minTreehash[i] = -1;
        i += 1;
      }
    }
    this.minTreehash = paramArrayOfInt2;
    i = this.mdLength;
    paramArrayOfInt1 = new byte[i];
    paramArrayOfByte2 = new byte[i];
    if (paramArrayOfGMSSRootSig == null)
    {
      this.nextRootSig = new GMSSRootSig[this.numLayer - 1];
      for (i = 0; i < this.numLayer - 1; i = j)
      {
        System.arraycopy(paramArrayOfByte1[i], 0, paramArrayOfInt1, 0, this.mdLength);
        this.gmssRandom.nextSeed(paramArrayOfInt1);
        paramArrayOfByte2 = this.gmssRandom.nextSeed(paramArrayOfInt1);
        paramArrayOfByte3 = this.nextRootSig;
        paramArrayOfByte4 = paramGMSSDigestProvider.get();
        k = this.otsIndex[i];
        paramArrayOfByte5 = this.heightOfTrees;
        j = i + 1;
        paramArrayOfByte3[i] = new GMSSRootSig(paramArrayOfByte4, k, paramArrayOfByte5[j]);
        this.nextRootSig[i].initSign(paramArrayOfByte2, paramArrayOfByte6[i]);
      }
    }
    this.nextRootSig = paramArrayOfGMSSRootSig;
  }
  
  public GMSSPrivateKeyParameters(byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2, byte[][][] paramArrayOfByte3, byte[][][] paramArrayOfByte4, Treehash[][] paramArrayOfTreehash1, Treehash[][] paramArrayOfTreehash2, Vector[] paramArrayOfVector1, Vector[] paramArrayOfVector2, Vector[][] paramArrayOfVector3, Vector[][] paramArrayOfVector4, byte[][] paramArrayOfByte5, byte[][] paramArrayOfByte6, GMSSParameters paramGMSSParameters, GMSSDigestProvider paramGMSSDigestProvider)
  {
    this(null, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, (byte[][][])null, paramArrayOfTreehash1, paramArrayOfTreehash2, paramArrayOfVector1, paramArrayOfVector2, paramArrayOfVector3, paramArrayOfVector4, null, null, null, null, paramArrayOfByte5, null, paramArrayOfByte6, null, paramGMSSParameters, paramGMSSDigestProvider);
  }
  
  private void computeAuthPaths(int paramInt)
  {
    int m = this.index[paramInt];
    int i2 = this.heightOfTrees[paramInt];
    int j = this.K[paramInt];
    int i = 0;
    int k;
    for (;;)
    {
      k = i2 - j;
      if (i >= k) {
        break;
      }
      this.currentTreehash[paramInt][i].updateNextSeed(this.gmssRandom);
      i += 1;
    }
    int n = heightOfPhi(m);
    Object localObject1 = new byte[this.mdLength];
    localObject1 = this.gmssRandom.nextSeed(this.currentSeeds[paramInt]);
    j = 1;
    int i1 = m >>> n + 1 & 0x1;
    i = this.mdLength;
    byte[] arrayOfByte = new byte[i];
    i2 -= 1;
    if ((n < i2) && (i1 == 0)) {
      System.arraycopy(this.currentAuthPaths[paramInt][n], 0, arrayOfByte, 0, i);
    }
    int i3 = this.mdLength;
    Object localObject2 = new byte[i3];
    if (n == 0)
    {
      if (paramInt == this.numLayer - 1)
      {
        localObject1 = new WinternitzOTSignature((byte[])localObject1, this.digestProvider.get(), this.otsIndex[paramInt]).getPublicKey();
      }
      else
      {
        localObject2 = new byte[i3];
        System.arraycopy(this.currentSeeds[paramInt], 0, localObject2, 0, i3);
        this.gmssRandom.nextSeed((byte[])localObject2);
        localObject1 = this.upperLeaf[paramInt].getLeaf();
        this.upperLeaf[paramInt].initLeafCalc((byte[])localObject2);
      }
      System.arraycopy(localObject1, 0, this.currentAuthPaths[paramInt][0], 0, this.mdLength);
    }
    else
    {
      i = i3 << 1;
      localObject1 = new byte[i];
      localObject2 = this.currentAuthPaths[paramInt];
      int i4 = n - 1;
      System.arraycopy(localObject2[i4], 0, localObject1, 0, i3);
      localObject2 = this.keep[paramInt][((int)Math.floor(i4 / 2))];
      i3 = this.mdLength;
      System.arraycopy(localObject2, 0, localObject1, i3, i3);
      this.messDigestTrees.update((byte[])localObject1, 0, i);
      this.currentAuthPaths[paramInt][n] = new byte[this.messDigestTrees.getDigestSize()];
      this.messDigestTrees.doFinal(this.currentAuthPaths[paramInt][n], 0);
      i = 0;
      while (i < n)
      {
        if (i < k) {
          if (this.currentTreehash[paramInt][i].wasFinished())
          {
            System.arraycopy(this.currentTreehash[paramInt][i].getFirstNode(), 0, this.currentAuthPaths[paramInt][i], 0, this.mdLength);
            this.currentTreehash[paramInt][i].destroy();
          }
          else
          {
            localObject1 = System.err;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Treehash (");
            ((StringBuilder)localObject2).append(paramInt);
            ((StringBuilder)localObject2).append(",");
            ((StringBuilder)localObject2).append(i);
            ((StringBuilder)localObject2).append(") not finished when needed in AuthPathComputation");
            ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
          }
        }
        if ((i < i2) && (i >= k))
        {
          localObject1 = this.currentRetain[paramInt];
          i3 = i - k;
          if (localObject1[i3].size() > 0)
          {
            System.arraycopy(this.currentRetain[paramInt][i3].lastElement(), 0, this.currentAuthPaths[paramInt][i], 0, this.mdLength);
            localObject1 = this.currentRetain;
            localObject1[paramInt][i3].removeElementAt(localObject1[paramInt][i3].size() - 1);
          }
        }
        if ((i < k) && ((1 << i) * 3 + m < this.numLeafs[paramInt])) {
          this.currentTreehash[paramInt][i].initialize();
        }
        i += 1;
      }
    }
    if ((n < i2) && (i1 == 0)) {
      System.arraycopy(arrayOfByte, 0, this.keep[paramInt][((int)Math.floor(n / 2))], 0, this.mdLength);
    }
    if (paramInt == this.numLayer - 1)
    {
      i = j;
      while (i <= k / 2)
      {
        j = getMinTreehashIndex(paramInt);
        if (j >= 0) {
          try
          {
            localObject1 = new byte[this.mdLength];
            System.arraycopy(this.currentTreehash[paramInt][j].getSeedActive(), 0, localObject1, 0, this.mdLength);
            localObject1 = new WinternitzOTSignature(this.gmssRandom.nextSeed((byte[])localObject1), this.digestProvider.get(), this.otsIndex[paramInt]).getPublicKey();
            this.currentTreehash[paramInt][j].update(this.gmssRandom, (byte[])localObject1);
          }
          catch (Exception localException)
          {
            System.out.println(localException);
          }
        }
        i += 1;
      }
    }
    this.minTreehash[paramInt] = getMinTreehashIndex(paramInt);
  }
  
  private int getMinTreehashIndex(int paramInt)
  {
    int i = 0;
    int k;
    for (int j = -1; i < this.heightOfTrees[paramInt] - this.K[paramInt]; j = k)
    {
      k = j;
      if (this.currentTreehash[paramInt][i].wasInitialized())
      {
        k = j;
        if (!this.currentTreehash[paramInt][i].wasFinished()) {
          if (j != -1)
          {
            k = j;
            if (this.currentTreehash[paramInt][i].getLowestNodeHeight() >= this.currentTreehash[paramInt][j].getLowestNodeHeight()) {}
          }
          else
          {
            k = i;
          }
        }
      }
      i += 1;
    }
    return j;
  }
  
  private int heightOfPhi(int paramInt)
  {
    if (paramInt == 0) {
      return -1;
    }
    int i = 0;
    int j = 1;
    while (paramInt % j == 0)
    {
      j *= 2;
      i += 1;
    }
    return i - 1;
  }
  
  private void nextKey(int paramInt)
  {
    if (paramInt == this.numLayer - 1)
    {
      int[] arrayOfInt = this.index;
      arrayOfInt[paramInt] += 1;
    }
    if (this.index[paramInt] == this.numLeafs[paramInt])
    {
      if (this.numLayer != 1)
      {
        nextTree(paramInt);
        this.index[paramInt] = 0;
      }
    }
    else {
      updateKey(paramInt);
    }
  }
  
  private void nextTree(int paramInt)
  {
    if (paramInt > 0)
    {
      Object localObject1 = this.index;
      int n = paramInt - 1;
      localObject1[n] += 1;
      int j = paramInt;
      int i = 1;
      int m;
      int k;
      do
      {
        m = j - 1;
        k = i;
        if (this.index[m] < this.numLeafs[m]) {
          k = 0;
        }
        if (k == 0) {
          break;
        }
        j = m;
        i = k;
      } while (m > 0);
      if (k == 0)
      {
        this.gmssRandom.nextSeed(this.currentSeeds[paramInt]);
        this.nextRootSig[n].updateSign();
        if (paramInt > 1)
        {
          localObject1 = this.nextNextLeaf;
          i = n - 1;
          localObject1[i] = localObject1[i].nextLeaf();
        }
        localObject1 = this.upperLeaf;
        localObject1[n] = localObject1[n].nextLeaf();
        if (this.minTreehash[n] >= 0)
        {
          localObject1 = this.upperTreehashLeaf;
          localObject1[n] = localObject1[n].nextLeaf();
          localObject1 = this.upperTreehashLeaf[n].getLeaf();
          try
          {
            this.currentTreehash[n][this.minTreehash[n]].update(this.gmssRandom, (byte[])localObject1);
            this.currentTreehash[n][this.minTreehash[n]].wasFinished();
          }
          catch (Exception localException)
          {
            System.out.println(localException);
          }
        }
        updateNextNextAuthRoot(paramInt);
        this.currentRootSig[n] = this.nextRootSig[n].getSig();
        i = 0;
        while (i < this.heightOfTrees[paramInt] - this.K[paramInt])
        {
          localObject2 = this.currentTreehash[paramInt];
          localObject3 = this.nextTreehash;
          localObject2[i] = localObject3[n][i];
          localObject3[n][i] = this.nextNextRoot[n].getTreehash()[i];
          i += 1;
        }
        i = 0;
        while (i < this.heightOfTrees[paramInt])
        {
          System.arraycopy(this.nextAuthPaths[n][i], 0, this.currentAuthPaths[paramInt][i], 0, this.mdLength);
          System.arraycopy(this.nextNextRoot[n].getAuthPath()[i], 0, this.nextAuthPaths[n][i], 0, this.mdLength);
          i += 1;
        }
        i = 0;
        while (i < this.K[paramInt] - 1)
        {
          localObject2 = this.currentRetain[paramInt];
          localObject3 = this.nextRetain;
          localObject2[i] = localObject3[n][i];
          localObject3[n][i] = this.nextNextRoot[n].getRetain()[i];
          i += 1;
        }
        Object localObject2 = this.currentStack;
        Object localObject3 = this.nextStack;
        localObject2[paramInt] = localObject3[n];
        localObject3[n] = this.nextNextRoot[n].getStack();
        this.nextRoot[n] = this.nextNextRoot[n].getRoot();
        paramInt = this.mdLength;
        localObject2 = new byte[paramInt];
        localObject2 = new byte[paramInt];
        System.arraycopy(this.currentSeeds[n], 0, localObject2, 0, paramInt);
        this.gmssRandom.nextSeed((byte[])localObject2);
        this.gmssRandom.nextSeed((byte[])localObject2);
        localObject2 = this.gmssRandom.nextSeed((byte[])localObject2);
        this.nextRootSig[n].initSign((byte[])localObject2, this.nextRoot[n]);
        nextKey(n);
      }
    }
  }
  
  private void updateKey(int paramInt)
  {
    computeAuthPaths(paramInt);
    if (paramInt > 0)
    {
      if (paramInt > 1)
      {
        localObject1 = this.nextNextLeaf;
        i = paramInt - 1 - 1;
        localObject1[i] = localObject1[i].nextLeaf();
      }
      Object localObject1 = this.upperLeaf;
      int i = paramInt - 1;
      localObject1[i] = localObject1[i].nextLeaf();
      int j = (int)Math.floor(getNumLeafs(paramInt) * 2 / (this.heightOfTrees[i] - this.K[i]));
      localObject1 = this.index;
      Object localObject2;
      if (localObject1[paramInt] % j == 1)
      {
        if ((localObject1[paramInt] > 1) && (this.minTreehash[i] >= 0))
        {
          localObject1 = this.upperTreehashLeaf[i].getLeaf();
          try
          {
            this.currentTreehash[i][this.minTreehash[i]].update(this.gmssRandom, (byte[])localObject1);
            this.currentTreehash[i][this.minTreehash[i]].wasFinished();
          }
          catch (Exception localException)
          {
            System.out.println(localException);
          }
        }
        this.minTreehash[i] = getMinTreehashIndex(i);
        localObject2 = this.minTreehash;
        if (localObject2[i] >= 0)
        {
          localObject2 = this.currentTreehash[i][localObject2[i]].getSeedActive();
          this.upperTreehashLeaf[i] = new GMSSLeaf(this.digestProvider.get(), this.otsIndex[i], j, (byte[])localObject2);
          localObject2 = this.upperTreehashLeaf;
          localObject2[i] = localObject2[i].nextLeaf();
        }
      }
      else if (this.minTreehash[i] >= 0)
      {
        localObject2 = this.upperTreehashLeaf;
        localObject2[i] = localObject2[i].nextLeaf();
      }
      this.nextRootSig[i].updateSign();
      if (this.index[paramInt] == 1) {
        this.nextNextRoot[i].initialize(new Vector());
      }
      updateNextNextAuthRoot(paramInt);
    }
  }
  
  private void updateNextNextAuthRoot(int paramInt)
  {
    Object localObject = new byte[this.mdLength];
    localObject = this.gmssRandom;
    byte[][] arrayOfByte = this.nextNextSeeds;
    int i = paramInt - 1;
    localObject = ((GMSSRandom)localObject).nextSeed(arrayOfByte[i]);
    if (paramInt == this.numLayer - 1)
    {
      localObject = new WinternitzOTSignature((byte[])localObject, this.digestProvider.get(), this.otsIndex[paramInt]);
      this.nextNextRoot[i].update(this.nextNextSeeds[i], ((WinternitzOTSignature)localObject).getPublicKey());
      return;
    }
    this.nextNextRoot[i].update(this.nextNextSeeds[i], this.nextNextLeaf[i].getLeaf());
    this.nextNextLeaf[i].initLeafCalc(this.nextNextSeeds[i]);
  }
  
  public byte[][][] getCurrentAuthPaths()
  {
    return Arrays.clone(this.currentAuthPaths);
  }
  
  public byte[][] getCurrentSeeds()
  {
    return Arrays.clone(this.currentSeeds);
  }
  
  public int getIndex(int paramInt)
  {
    return this.index[paramInt];
  }
  
  public int[] getIndex()
  {
    return this.index;
  }
  
  public GMSSDigestProvider getName()
  {
    return this.digestProvider;
  }
  
  public int getNumLeafs(int paramInt)
  {
    return this.numLeafs[paramInt];
  }
  
  public byte[] getSubtreeRootSig(int paramInt)
  {
    return this.currentRootSig[paramInt];
  }
  
  public boolean isUsed()
  {
    return this.used;
  }
  
  public void markUsed()
  {
    this.used = true;
  }
  
  public GMSSPrivateKeyParameters nextKey()
  {
    GMSSPrivateKeyParameters localGMSSPrivateKeyParameters = new GMSSPrivateKeyParameters(this);
    localGMSSPrivateKeyParameters.nextKey(this.gmssPS.getNumOfLayers() - 1);
    return localGMSSPrivateKeyParameters;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\gmss\GMSSPrivateKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */