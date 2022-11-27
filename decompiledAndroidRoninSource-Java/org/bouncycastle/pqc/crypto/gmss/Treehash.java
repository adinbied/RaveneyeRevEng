package org.bouncycastle.pqc.crypto.gmss;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Vector;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.encoders.Hex;

public class Treehash
{
  private byte[] firstNode;
  private int firstNodeHeight;
  private Vector heightOfNodes;
  private boolean isFinished;
  private boolean isInitialized;
  private int maxHeight;
  private Digest messDigestTree;
  private byte[] seedActive;
  private boolean seedInitialized;
  private byte[] seedNext;
  private int tailLength;
  private Vector tailStack;
  
  public Treehash(Vector paramVector, int paramInt, Digest paramDigest)
  {
    this.tailStack = paramVector;
    this.maxHeight = paramInt;
    this.firstNode = null;
    this.isInitialized = false;
    this.isFinished = false;
    this.seedInitialized = false;
    this.messDigestTree = paramDigest;
    this.seedNext = new byte[paramDigest.getDigestSize()];
    this.seedActive = new byte[this.messDigestTree.getDigestSize()];
  }
  
  public Treehash(Digest paramDigest, byte[][] paramArrayOfByte, int[] paramArrayOfInt)
  {
    this.messDigestTree = paramDigest;
    int j = 0;
    this.maxHeight = paramArrayOfInt[0];
    this.tailLength = paramArrayOfInt[1];
    this.firstNodeHeight = paramArrayOfInt[2];
    if (paramArrayOfInt[3] == 1) {
      this.isFinished = true;
    } else {
      this.isFinished = false;
    }
    if (paramArrayOfInt[4] == 1) {
      this.isInitialized = true;
    } else {
      this.isInitialized = false;
    }
    if (paramArrayOfInt[5] == 1) {
      this.seedInitialized = true;
    } else {
      this.seedInitialized = false;
    }
    this.heightOfNodes = new Vector();
    int i = 0;
    while (i < this.tailLength)
    {
      this.heightOfNodes.addElement(Integers.valueOf(paramArrayOfInt[(i + 6)]));
      i += 1;
    }
    this.firstNode = paramArrayOfByte[0];
    this.seedActive = paramArrayOfByte[1];
    this.seedNext = paramArrayOfByte[2];
    this.tailStack = new Vector();
    i = j;
    while (i < this.tailLength)
    {
      this.tailStack.addElement(paramArrayOfByte[(i + 3)]);
      i += 1;
    }
  }
  
  public void destroy()
  {
    this.isInitialized = false;
    this.isFinished = false;
    this.firstNode = null;
    this.tailLength = 0;
    this.firstNodeHeight = -1;
  }
  
  public byte[] getFirstNode()
  {
    return this.firstNode;
  }
  
  public int getFirstNodeHeight()
  {
    if (this.firstNode == null) {
      return this.maxHeight;
    }
    return this.firstNodeHeight;
  }
  
  public int getLowestNodeHeight()
  {
    if (this.firstNode == null) {
      return this.maxHeight;
    }
    if (this.tailLength == 0) {
      return this.firstNodeHeight;
    }
    return Math.min(this.firstNodeHeight, ((Integer)this.heightOfNodes.lastElement()).intValue());
  }
  
  public byte[] getSeedActive()
  {
    return this.seedActive;
  }
  
  public byte[][] getStatByte()
  {
    int j = this.tailLength;
    int k = this.messDigestTree.getDigestSize();
    int i = 0;
    byte[][] arrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, new int[] { j + 3, k });
    arrayOfByte[0] = this.firstNode;
    arrayOfByte[1] = this.seedActive;
    arrayOfByte[2] = this.seedNext;
    while (i < this.tailLength)
    {
      arrayOfByte[(i + 3)] = ((byte[])(byte[])this.tailStack.elementAt(i));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public int[] getStatInt()
  {
    int j = this.tailLength;
    int[] arrayOfInt = new int[j + 6];
    int k = this.maxHeight;
    int i = 0;
    arrayOfInt[0] = k;
    arrayOfInt[1] = j;
    arrayOfInt[2] = this.firstNodeHeight;
    if (this.isFinished) {
      arrayOfInt[3] = 1;
    } else {
      arrayOfInt[3] = 0;
    }
    if (this.isInitialized) {
      arrayOfInt[4] = 1;
    } else {
      arrayOfInt[4] = 0;
    }
    if (this.seedInitialized) {
      arrayOfInt[5] = 1;
    } else {
      arrayOfInt[5] = 0;
    }
    while (i < this.tailLength)
    {
      arrayOfInt[(i + 6)] = ((Integer)this.heightOfNodes.elementAt(i)).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  public Vector getTailStack()
  {
    return this.tailStack;
  }
  
  public void initialize()
  {
    if (!this.seedInitialized)
    {
      PrintStream localPrintStream = System.err;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Seed ");
      localStringBuilder.append(this.maxHeight);
      localStringBuilder.append(" not initialized");
      localPrintStream.println(localStringBuilder.toString());
      return;
    }
    this.heightOfNodes = new Vector();
    this.tailLength = 0;
    this.firstNode = null;
    this.firstNodeHeight = -1;
    this.isInitialized = true;
    System.arraycopy(this.seedNext, 0, this.seedActive, 0, this.messDigestTree.getDigestSize());
  }
  
  public void initializeSeed(byte[] paramArrayOfByte)
  {
    System.arraycopy(paramArrayOfByte, 0, this.seedNext, 0, this.messDigestTree.getDigestSize());
    this.seedInitialized = true;
  }
  
  public void setFirstNode(byte[] paramArrayOfByte)
  {
    if (!this.isInitialized) {
      initialize();
    }
    this.firstNode = paramArrayOfByte;
    this.firstNodeHeight = this.maxHeight;
    this.isFinished = true;
  }
  
  public String toString()
  {
    int k = 0;
    Object localObject1 = "Treehash    : ";
    int i = 0;
    int j;
    Object localObject2;
    for (;;)
    {
      j = k;
      localObject2 = localObject1;
      if (i >= this.tailLength + 6) {
        break;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(getStatInt()[i]);
      ((StringBuilder)localObject2).append(" ");
      localObject1 = ((StringBuilder)localObject2).toString();
      i += 1;
    }
    while (j < this.tailLength + 3)
    {
      if (getStatByte()[j] != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(new String(Hex.encode(getStatByte()[j])));
        ((StringBuilder)localObject1).append(" ");
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("null ");
      }
      localObject2 = ((StringBuilder)localObject1).toString();
      j += 1;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("  ");
    ((StringBuilder)localObject1).append(this.messDigestTree.getDigestSize());
    return ((StringBuilder)localObject1).toString();
  }
  
  public void update(GMSSRandom paramGMSSRandom, byte[] paramArrayOfByte)
  {
    if (this.isFinished) {
      paramGMSSRandom = System.err;
    }
    for (paramArrayOfByte = "No more update possible for treehash instance!";; paramArrayOfByte = "Treehash instance not initialized before update")
    {
      paramGMSSRandom.println(paramArrayOfByte);
      return;
      if (this.isInitialized) {
        break;
      }
      paramGMSSRandom = System.err;
    }
    Object localObject = new byte[this.messDigestTree.getDigestSize()];
    paramGMSSRandom.nextSeed(this.seedActive);
    if (this.firstNode == null)
    {
      this.firstNode = paramArrayOfByte;
      this.firstNodeHeight = 0;
    }
    else
    {
      int i = 0;
      while ((this.tailLength > 0) && (i == ((Integer)this.heightOfNodes.lastElement()).intValue()))
      {
        int j = this.messDigestTree.getDigestSize() << 1;
        paramGMSSRandom = new byte[j];
        System.arraycopy(this.tailStack.lastElement(), 0, paramGMSSRandom, 0, this.messDigestTree.getDigestSize());
        localObject = this.tailStack;
        ((Vector)localObject).removeElementAt(((Vector)localObject).size() - 1);
        localObject = this.heightOfNodes;
        ((Vector)localObject).removeElementAt(((Vector)localObject).size() - 1);
        System.arraycopy(paramArrayOfByte, 0, paramGMSSRandom, this.messDigestTree.getDigestSize(), this.messDigestTree.getDigestSize());
        this.messDigestTree.update(paramGMSSRandom, 0, j);
        paramArrayOfByte = new byte[this.messDigestTree.getDigestSize()];
        this.messDigestTree.doFinal(paramArrayOfByte, 0);
        i += 1;
        this.tailLength -= 1;
      }
      this.tailStack.addElement(paramArrayOfByte);
      this.heightOfNodes.addElement(Integers.valueOf(i));
      this.tailLength += 1;
      if (((Integer)this.heightOfNodes.lastElement()).intValue() == this.firstNodeHeight)
      {
        i = this.messDigestTree.getDigestSize() << 1;
        paramGMSSRandom = new byte[i];
        System.arraycopy(this.firstNode, 0, paramGMSSRandom, 0, this.messDigestTree.getDigestSize());
        System.arraycopy(this.tailStack.lastElement(), 0, paramGMSSRandom, this.messDigestTree.getDigestSize(), this.messDigestTree.getDigestSize());
        paramArrayOfByte = this.tailStack;
        paramArrayOfByte.removeElementAt(paramArrayOfByte.size() - 1);
        paramArrayOfByte = this.heightOfNodes;
        paramArrayOfByte.removeElementAt(paramArrayOfByte.size() - 1);
        this.messDigestTree.update(paramGMSSRandom, 0, i);
        paramGMSSRandom = new byte[this.messDigestTree.getDigestSize()];
        this.firstNode = paramGMSSRandom;
        this.messDigestTree.doFinal(paramGMSSRandom, 0);
        this.firstNodeHeight += 1;
        this.tailLength = 0;
      }
    }
    if (this.firstNodeHeight == this.maxHeight) {
      this.isFinished = true;
    }
  }
  
  public void updateNextSeed(GMSSRandom paramGMSSRandom)
  {
    paramGMSSRandom.nextSeed(this.seedNext);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\gmss\Treehash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */