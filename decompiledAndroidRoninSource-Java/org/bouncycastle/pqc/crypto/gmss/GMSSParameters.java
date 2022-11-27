package org.bouncycastle.pqc.crypto.gmss;

import org.bouncycastle.util.Arrays;

public class GMSSParameters
{
  private int[] K;
  private int[] heightOfTrees;
  private int numOfLayers;
  private int[] winternitzParameter;
  
  public GMSSParameters(int paramInt)
    throws IllegalArgumentException
  {
    if (paramInt <= 10)
    {
      init(1, new int[] { 10 }, new int[] { 3 }, new int[] { 2 });
      return;
    }
    if (paramInt <= 20)
    {
      init(2, new int[] { 10, 10 }, new int[] { 5, 4 }, new int[] { 2, 2 });
      return;
    }
    init(4, new int[] { 10, 10, 10, 10 }, new int[] { 9, 9, 9, 3 }, new int[] { 2, 2, 2, 2 });
  }
  
  public GMSSParameters(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
    throws IllegalArgumentException
  {
    init(paramInt, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
  }
  
  private void init(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
    throws IllegalArgumentException
  {
    this.numOfLayers = paramInt;
    String str;
    if ((paramInt == paramArrayOfInt2.length) && (paramInt == paramArrayOfInt1.length) && (paramInt == paramArrayOfInt3.length))
    {
      paramInt = 1;
      str = "";
    }
    else
    {
      str = "Unexpected parameterset format";
      paramInt = 0;
    }
    int i = 0;
    while (i < this.numOfLayers)
    {
      if ((paramArrayOfInt3[i] < 2) || ((paramArrayOfInt1[i] - paramArrayOfInt3[i]) % 2 != 0))
      {
        str = "Wrong parameter K (K >= 2 and H-K even required)!";
        paramInt = 0;
      }
      if ((paramArrayOfInt1[i] < 4) || (paramArrayOfInt2[i] < 2))
      {
        str = "Wrong parameter H or w (H > 3 and w > 1 required)!";
        paramInt = 0;
      }
      i += 1;
    }
    if (paramInt != 0)
    {
      this.heightOfTrees = Arrays.clone(paramArrayOfInt1);
      this.winternitzParameter = Arrays.clone(paramArrayOfInt2);
      this.K = Arrays.clone(paramArrayOfInt3);
      return;
    }
    throw new IllegalArgumentException(str);
  }
  
  public int[] getHeightOfTrees()
  {
    return Arrays.clone(this.heightOfTrees);
  }
  
  public int[] getK()
  {
    return Arrays.clone(this.K);
  }
  
  public int getNumOfLayers()
  {
    return this.numOfLayers;
  }
  
  public int[] getWinternitzParameter()
  {
    return Arrays.clone(this.winternitzParameter);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\gmss\GMSSParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */