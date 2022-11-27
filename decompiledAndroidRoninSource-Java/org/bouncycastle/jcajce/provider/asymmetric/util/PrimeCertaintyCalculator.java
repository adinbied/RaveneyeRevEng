package org.bouncycastle.jcajce.provider.asymmetric.util;

public class PrimeCertaintyCalculator
{
  public static int getDefaultCertainty(int paramInt)
  {
    if (paramInt <= 1024) {
      return 80;
    }
    return (paramInt - 1) / 1024 * 16 + 96;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetri\\util\PrimeCertaintyCalculator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */