package org.bouncycastle.pqc.crypto.gmss;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.encoders.Hex;

public class GMSSRootCalc
{
  private byte[][] AuthPath;
  private int K;
  private GMSSDigestProvider digestProvider;
  private int heightOfNextSeed;
  private Vector heightOfNodes;
  private int heightOfTree;
  private int[] index;
  private int indexForNextSeed;
  private boolean isFinished;
  private boolean isInitialized;
  private int mdLength;
  private Digest messDigestTree;
  private Vector[] retain;
  private byte[] root;
  private Vector tailStack;
  private Treehash[] treehash;
  
  public GMSSRootCalc(int paramInt1, int paramInt2, GMSSDigestProvider paramGMSSDigestProvider)
  {
    this.heightOfTree = paramInt1;
    this.digestProvider = paramGMSSDigestProvider;
    paramGMSSDigestProvider = paramGMSSDigestProvider.get();
    this.messDigestTree = paramGMSSDigestProvider;
    int j = paramGMSSDigestProvider.getDigestSize();
    this.mdLength = j;
    this.K = paramInt2;
    this.index = new int[paramInt1];
    int i = 0;
    this.AuthPath = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { paramInt1, j }));
    this.root = new byte[this.mdLength];
    this.retain = new Vector[this.K - 1];
    paramInt1 = i;
    while (paramInt1 < paramInt2 - 1)
    {
      this.retain[paramInt1] = new Vector();
      paramInt1 += 1;
    }
  }
  
  public GMSSRootCalc(Digest paramDigest, byte[][] paramArrayOfByte, int[] paramArrayOfInt, Treehash[] paramArrayOfTreehash, Vector[] paramArrayOfVector)
  {
    this.messDigestTree = this.digestProvider.get();
    this.digestProvider = this.digestProvider;
    int j = 0;
    this.heightOfTree = paramArrayOfInt[0];
    this.mdLength = paramArrayOfInt[1];
    this.K = paramArrayOfInt[2];
    this.indexForNextSeed = paramArrayOfInt[3];
    this.heightOfNextSeed = paramArrayOfInt[4];
    if (paramArrayOfInt[5] == 1) {
      this.isFinished = true;
    } else {
      this.isFinished = false;
    }
    if (paramArrayOfInt[6] == 1) {
      this.isInitialized = true;
    } else {
      this.isInitialized = false;
    }
    int m = paramArrayOfInt[7];
    this.index = new int[this.heightOfTree];
    int i = 0;
    while (i < this.heightOfTree)
    {
      this.index[i] = paramArrayOfInt[(i + 8)];
      i += 1;
    }
    this.heightOfNodes = new Vector();
    i = 0;
    while (i < m)
    {
      this.heightOfNodes.addElement(Integers.valueOf(paramArrayOfInt[(this.heightOfTree + 8 + i)]));
      i += 1;
    }
    this.root = paramArrayOfByte[0];
    this.AuthPath = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { this.heightOfTree, this.mdLength }));
    int k;
    for (i = 0; i < this.heightOfTree; i = k)
    {
      paramDigest = this.AuthPath;
      k = i + 1;
      paramDigest[i] = paramArrayOfByte[k];
    }
    this.tailStack = new Vector();
    i = j;
    while (i < m)
    {
      this.tailStack.addElement(paramArrayOfByte[(this.heightOfTree + 1 + i)]);
      i += 1;
    }
    this.treehash = GMSSUtils.clone(paramArrayOfTreehash);
    this.retain = GMSSUtils.clone(paramArrayOfVector);
  }
  
  public byte[][] getAuthPath()
  {
    return GMSSUtils.clone(this.AuthPath);
  }
  
  public Vector[] getRetain()
  {
    return GMSSUtils.clone(this.retain);
  }
  
  public byte[] getRoot()
  {
    return Arrays.clone(this.root);
  }
  
  public Vector getStack()
  {
    Vector localVector = new Vector();
    Enumeration localEnumeration = this.tailStack.elements();
    while (localEnumeration.hasMoreElements()) {
      localVector.addElement(localEnumeration.nextElement());
    }
    return localVector;
  }
  
  public byte[][] getStatByte()
  {
    Object localObject = this.tailStack;
    int m = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((Vector)localObject).size();
    }
    localObject = (byte[][])Array.newInstance(Byte.TYPE, new int[] { this.heightOfTree + 1 + i, 64 });
    localObject[0] = this.root;
    int k;
    for (int j = 0;; j = k)
    {
      k = m;
      if (j >= this.heightOfTree) {
        break;
      }
      k = j + 1;
      localObject[k] = this.AuthPath[j];
    }
    while (k < i)
    {
      localObject[(this.heightOfTree + 1 + k)] = ((byte[])(byte[])this.tailStack.elementAt(k));
      k += 1;
    }
    return (byte[][])localObject;
  }
  
  public int[] getStatInt()
  {
    Object localObject = this.tailStack;
    int m = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((Vector)localObject).size();
    }
    int j = this.heightOfTree;
    localObject = new int[j + 8 + i];
    localObject[0] = j;
    localObject[1] = this.mdLength;
    localObject[2] = this.K;
    localObject[3] = this.indexForNextSeed;
    localObject[4] = this.heightOfNextSeed;
    if (this.isFinished) {
      localObject[5] = 1;
    } else {
      localObject[5] = 0;
    }
    if (this.isInitialized) {
      localObject[6] = 1;
    } else {
      localObject[6] = 0;
    }
    localObject[7] = i;
    j = 0;
    int k;
    for (;;)
    {
      k = m;
      if (j >= this.heightOfTree) {
        break;
      }
      localObject[(j + 8)] = this.index[j];
      j += 1;
    }
    while (k < i)
    {
      localObject[(this.heightOfTree + 8 + k)] = ((Integer)this.heightOfNodes.elementAt(k)).intValue();
      k += 1;
    }
    return (int[])localObject;
  }
  
  public Treehash[] getTreehash()
  {
    return GMSSUtils.clone(this.treehash);
  }
  
  public void initialize(Vector paramVector)
  {
    this.treehash = new Treehash[this.heightOfTree - this.K];
    int i = 0;
    int j;
    for (;;)
    {
      j = this.heightOfTree;
      if (i >= j - this.K) {
        break;
      }
      this.treehash[i] = new Treehash(paramVector, i, this.digestProvider.get());
      i += 1;
    }
    this.index = new int[j];
    this.AuthPath = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { j, this.mdLength }));
    this.root = new byte[this.mdLength];
    this.tailStack = new Vector();
    this.heightOfNodes = new Vector();
    this.isInitialized = true;
    this.isFinished = false;
    i = 0;
    while (i < this.heightOfTree)
    {
      this.index[i] = -1;
      i += 1;
    }
    this.retain = new Vector[this.K - 1];
    i = 0;
    while (i < this.K - 1)
    {
      this.retain[i] = new Vector();
      i += 1;
    }
    this.indexForNextSeed = 3;
    this.heightOfNextSeed = 0;
  }
  
  public void initializeTreehashSeed(byte[] paramArrayOfByte, int paramInt)
  {
    this.treehash[paramInt].initializeSeed(paramArrayOfByte);
  }
  
  public String toString()
  {
    Object localObject1 = this.tailStack;
    int m = 0;
    int i;
    if (localObject1 == null) {
      i = 0;
    } else {
      i = ((Vector)localObject1).size();
    }
    localObject1 = "";
    int j = 0;
    int k;
    Object localObject2;
    for (;;)
    {
      k = m;
      localObject2 = localObject1;
      if (j >= this.heightOfTree + 8 + i) {
        break;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(getStatInt()[j]);
      ((StringBuilder)localObject2).append(" ");
      localObject1 = ((StringBuilder)localObject2).toString();
      j += 1;
    }
    while (k < this.heightOfTree + 1 + i)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(new String(Hex.encode(getStatByte()[k])));
      ((StringBuilder)localObject1).append(" ");
      localObject2 = ((StringBuilder)localObject1).toString();
      k += 1;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("  ");
    ((StringBuilder)localObject1).append(this.digestProvider.get().getDigestSize());
    return ((StringBuilder)localObject1).toString();
  }
  
  public void update(byte[] paramArrayOfByte)
  {
    if (this.isFinished)
    {
      System.out.print("Too much updates for Tree!!");
      return;
    }
    if (!this.isInitialized)
    {
      System.err.println("GMSSRootCalc not initialized!");
      return;
    }
    Object localObject = this.index;
    localObject[0] += 1;
    if (localObject[0] == 1) {
      System.arraycopy(paramArrayOfByte, 0, this.AuthPath[0], 0, this.mdLength);
    } else if ((localObject[0] == 3) && (this.heightOfTree > this.K)) {
      this.treehash[0].setFirstNode(paramArrayOfByte);
    }
    localObject = this.index;
    if (((localObject[0] - 3) % 2 == 0) && (localObject[0] >= 3) && (this.heightOfTree == this.K)) {
      this.retain[0].insertElementAt(paramArrayOfByte, 0);
    }
    if (this.index[0] == 0)
    {
      this.tailStack.addElement(paramArrayOfByte);
      this.heightOfNodes.addElement(Integers.valueOf(0));
      return;
    }
    int i = this.mdLength;
    localObject = new byte[i];
    int k = i << 1;
    byte[] arrayOfByte = new byte[k];
    System.arraycopy(paramArrayOfByte, 0, localObject, 0, i);
    i = 0;
    paramArrayOfByte = (byte[])localObject;
    while ((this.tailStack.size() > 0) && (i == ((Integer)this.heightOfNodes.lastElement()).intValue()))
    {
      System.arraycopy(this.tailStack.lastElement(), 0, arrayOfByte, 0, this.mdLength);
      localObject = this.tailStack;
      ((Vector)localObject).removeElementAt(((Vector)localObject).size() - 1);
      localObject = this.heightOfNodes;
      ((Vector)localObject).removeElementAt(((Vector)localObject).size() - 1);
      int j = this.mdLength;
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, j, j);
      this.messDigestTree.update(arrayOfByte, 0, k);
      localObject = new byte[this.messDigestTree.getDigestSize()];
      this.messDigestTree.doFinal((byte[])localObject, 0);
      j = i + 1;
      paramArrayOfByte = (byte[])localObject;
      i = j;
      if (j < this.heightOfTree)
      {
        paramArrayOfByte = this.index;
        paramArrayOfByte[j] += 1;
        if (paramArrayOfByte[j] == 1) {
          System.arraycopy(localObject, 0, this.AuthPath[j], 0, this.mdLength);
        }
        if (j >= this.heightOfTree - this.K)
        {
          if (j == 0) {
            System.out.println("M���P");
          }
          int[] arrayOfInt = this.index;
          paramArrayOfByte = (byte[])localObject;
          i = j;
          if ((arrayOfInt[j] - 3) % 2 == 0)
          {
            paramArrayOfByte = (byte[])localObject;
            i = j;
            if (arrayOfInt[j] >= 3)
            {
              this.retain[(j - (this.heightOfTree - this.K))].insertElementAt(localObject, 0);
              paramArrayOfByte = (byte[])localObject;
              i = j;
            }
          }
        }
        else
        {
          paramArrayOfByte = (byte[])localObject;
          i = j;
          if (this.index[j] == 3)
          {
            this.treehash[j].setFirstNode((byte[])localObject);
            paramArrayOfByte = (byte[])localObject;
            i = j;
          }
        }
      }
    }
    this.tailStack.addElement(paramArrayOfByte);
    this.heightOfNodes.addElement(Integers.valueOf(i));
    if (i == this.heightOfTree)
    {
      this.isFinished = true;
      this.isInitialized = false;
      this.root = ((byte[])this.tailStack.lastElement());
    }
  }
  
  public void update(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = this.heightOfNextSeed;
    if ((i < this.heightOfTree - this.K) && (this.indexForNextSeed - 2 == this.index[0]))
    {
      initializeTreehashSeed(paramArrayOfByte1, i);
      this.heightOfNextSeed += 1;
      this.indexForNextSeed *= 2;
    }
    update(paramArrayOfByte2);
  }
  
  public boolean wasFinished()
  {
    return this.isFinished;
  }
  
  public boolean wasInitialized()
  {
    return this.isInitialized;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\gmss\GMSSRootCalc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */