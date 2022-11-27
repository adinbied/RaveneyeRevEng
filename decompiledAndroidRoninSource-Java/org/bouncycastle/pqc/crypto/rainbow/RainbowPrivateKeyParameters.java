package org.bouncycastle.pqc.crypto.rainbow;

public class RainbowPrivateKeyParameters
  extends RainbowKeyParameters
{
  private short[][] A1inv;
  private short[][] A2inv;
  private short[] b1;
  private short[] b2;
  private Layer[] layers;
  private int[] vi;
  
  public RainbowPrivateKeyParameters(short[][] paramArrayOfShort1, short[] paramArrayOfShort2, short[][] paramArrayOfShort3, short[] paramArrayOfShort4, int[] paramArrayOfInt, Layer[] paramArrayOfLayer)
  {
    super(true, paramArrayOfInt[(paramArrayOfInt.length - 1)] - paramArrayOfInt[0]);
    this.A1inv = paramArrayOfShort1;
    this.b1 = paramArrayOfShort2;
    this.A2inv = paramArrayOfShort3;
    this.b2 = paramArrayOfShort4;
    this.vi = paramArrayOfInt;
    this.layers = paramArrayOfLayer;
  }
  
  public short[] getB1()
  {
    return this.b1;
  }
  
  public short[] getB2()
  {
    return this.b2;
  }
  
  public short[][] getInvA1()
  {
    return this.A1inv;
  }
  
  public short[][] getInvA2()
  {
    return this.A2inv;
  }
  
  public Layer[] getLayers()
  {
    return this.layers;
  }
  
  public int[] getVi()
  {
    return this.vi;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\rainbow\RainbowPrivateKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */