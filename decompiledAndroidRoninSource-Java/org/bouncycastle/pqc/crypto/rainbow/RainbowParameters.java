package org.bouncycastle.pqc.crypto.rainbow;

import org.bouncycastle.crypto.CipherParameters;

public class RainbowParameters
  implements CipherParameters
{
  private final int[] DEFAULT_VI;
  private int[] vi;
  
  public RainbowParameters()
  {
    int[] arrayOfInt = new int[5];
    int[] tmp9_8 = arrayOfInt;
    tmp9_8[0] = 6;
    int[] tmp14_9 = tmp9_8;
    tmp14_9[1] = 12;
    int[] tmp19_14 = tmp14_9;
    tmp19_14[2] = 17;
    int[] tmp24_19 = tmp19_14;
    tmp24_19[3] = 22;
    int[] tmp29_24 = tmp24_19;
    tmp29_24[4] = 33;
    tmp29_24;
    this.DEFAULT_VI = arrayOfInt;
    this.vi = arrayOfInt;
  }
  
  public RainbowParameters(int[] paramArrayOfInt)
  {
    this.DEFAULT_VI = new int[] { 6, 12, 17, 22, 33 };
    this.vi = paramArrayOfInt;
    try
    {
      checkParams();
      return;
    }
    catch (Exception paramArrayOfInt)
    {
      paramArrayOfInt.printStackTrace();
    }
  }
  
  private void checkParams()
    throws Exception
  {
    int[] arrayOfInt = this.vi;
    if (arrayOfInt != null)
    {
      if (arrayOfInt.length > 1)
      {
        int i = 0;
        int j;
        do
        {
          arrayOfInt = this.vi;
          if (i >= arrayOfInt.length - 1) {
            break;
          }
          j = arrayOfInt[i];
          i += 1;
        } while (j < arrayOfInt[i]);
        throw new Exception("v[i] has to be smaller than v[i+1]");
        return;
      }
      throw new Exception("Rainbow needs at least 1 layer, such that v1 < v2.");
    }
    throw new Exception("no layers defined.");
  }
  
  public int getDocLength()
  {
    int[] arrayOfInt = this.vi;
    return arrayOfInt[(arrayOfInt.length - 1)] - arrayOfInt[0];
  }
  
  public int getNumOfLayers()
  {
    return this.vi.length - 1;
  }
  
  public int[] getVi()
  {
    return this.vi;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\rainbow\RainbowParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */