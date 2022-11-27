package org.bouncycastle.pqc.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.util.Arrays;

public class RainbowParameterSpec
  implements AlgorithmParameterSpec
{
  private static final int[] DEFAULT_VI = { 6, 12, 17, 22, 33 };
  private int[] vi;
  
  public RainbowParameterSpec()
  {
    this.vi = DEFAULT_VI;
  }
  
  public RainbowParameterSpec(int[] paramArrayOfInt)
  {
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
        throw new IllegalArgumentException("v[i] has to be smaller than v[i+1]");
        return;
      }
      throw new IllegalArgumentException("Rainbow needs at least 1 layer, such that v1 < v2.");
    }
    throw new IllegalArgumentException("no layers defined.");
  }
  
  public int getDocumentLength()
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
    return Arrays.clone(this.vi);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\spec\RainbowParameterSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */