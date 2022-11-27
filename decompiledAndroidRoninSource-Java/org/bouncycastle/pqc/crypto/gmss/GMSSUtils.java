package org.bouncycastle.pqc.crypto.gmss;

import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.util.Arrays;

class GMSSUtils
{
  static Vector[] clone(Vector[] paramArrayOfVector)
  {
    if (paramArrayOfVector == null) {
      return null;
    }
    Vector[] arrayOfVector = new Vector[paramArrayOfVector.length];
    int i = 0;
    while (i != paramArrayOfVector.length)
    {
      arrayOfVector[i] = new Vector();
      Enumeration localEnumeration = paramArrayOfVector[i].elements();
      while (localEnumeration.hasMoreElements()) {
        arrayOfVector[i].addElement(localEnumeration.nextElement());
      }
      i += 1;
    }
    return arrayOfVector;
  }
  
  static GMSSLeaf[] clone(GMSSLeaf[] paramArrayOfGMSSLeaf)
  {
    if (paramArrayOfGMSSLeaf == null) {
      return null;
    }
    GMSSLeaf[] arrayOfGMSSLeaf = new GMSSLeaf[paramArrayOfGMSSLeaf.length];
    System.arraycopy(paramArrayOfGMSSLeaf, 0, arrayOfGMSSLeaf, 0, paramArrayOfGMSSLeaf.length);
    return arrayOfGMSSLeaf;
  }
  
  static GMSSRootCalc[] clone(GMSSRootCalc[] paramArrayOfGMSSRootCalc)
  {
    if (paramArrayOfGMSSRootCalc == null) {
      return null;
    }
    GMSSRootCalc[] arrayOfGMSSRootCalc = new GMSSRootCalc[paramArrayOfGMSSRootCalc.length];
    System.arraycopy(paramArrayOfGMSSRootCalc, 0, arrayOfGMSSRootCalc, 0, paramArrayOfGMSSRootCalc.length);
    return arrayOfGMSSRootCalc;
  }
  
  static GMSSRootSig[] clone(GMSSRootSig[] paramArrayOfGMSSRootSig)
  {
    if (paramArrayOfGMSSRootSig == null) {
      return null;
    }
    GMSSRootSig[] arrayOfGMSSRootSig = new GMSSRootSig[paramArrayOfGMSSRootSig.length];
    System.arraycopy(paramArrayOfGMSSRootSig, 0, arrayOfGMSSRootSig, 0, paramArrayOfGMSSRootSig.length);
    return arrayOfGMSSRootSig;
  }
  
  static Treehash[] clone(Treehash[] paramArrayOfTreehash)
  {
    if (paramArrayOfTreehash == null) {
      return null;
    }
    Treehash[] arrayOfTreehash = new Treehash[paramArrayOfTreehash.length];
    System.arraycopy(paramArrayOfTreehash, 0, arrayOfTreehash, 0, paramArrayOfTreehash.length);
    return arrayOfTreehash;
  }
  
  static byte[][] clone(byte[][] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return (byte[][])null;
    }
    byte[][] arrayOfByte = new byte[paramArrayOfByte.length][];
    int i = 0;
    while (i != paramArrayOfByte.length)
    {
      arrayOfByte[i] = Arrays.clone(paramArrayOfByte[i]);
      i += 1;
    }
    return arrayOfByte;
  }
  
  static Vector[][] clone(Vector[][] paramArrayOfVector)
  {
    if (paramArrayOfVector == null) {
      return (Vector[][])null;
    }
    Vector[][] arrayOfVector = new Vector[paramArrayOfVector.length][];
    int i = 0;
    while (i != paramArrayOfVector.length)
    {
      arrayOfVector[i] = clone(paramArrayOfVector[i]);
      i += 1;
    }
    return arrayOfVector;
  }
  
  static Treehash[][] clone(Treehash[][] paramArrayOfTreehash)
  {
    if (paramArrayOfTreehash == null) {
      return (Treehash[][])null;
    }
    Treehash[][] arrayOfTreehash = new Treehash[paramArrayOfTreehash.length][];
    int i = 0;
    while (i != paramArrayOfTreehash.length)
    {
      arrayOfTreehash[i] = clone(paramArrayOfTreehash[i]);
      i += 1;
    }
    return arrayOfTreehash;
  }
  
  static byte[][][] clone(byte[][][] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return (byte[][][])null;
    }
    byte[][][] arrayOfByte = new byte[paramArrayOfByte.length][][];
    int i = 0;
    while (i != paramArrayOfByte.length)
    {
      arrayOfByte[i] = clone(paramArrayOfByte[i]);
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\gmss\GMSSUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */