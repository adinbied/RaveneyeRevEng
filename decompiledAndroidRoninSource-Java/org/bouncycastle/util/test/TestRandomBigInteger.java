package org.bouncycastle.util.test;

import java.math.BigInteger;
import org.bouncycastle.util.BigIntegers;

public class TestRandomBigInteger
  extends FixedSecureRandom
{
  public TestRandomBigInteger(int paramInt, byte[] paramArrayOfByte)
  {
    super(new FixedSecureRandom.Source[] { new FixedSecureRandom.BigInteger(paramInt, paramArrayOfByte) });
  }
  
  public TestRandomBigInteger(String paramString)
  {
    this(paramString, 10);
  }
  
  public TestRandomBigInteger(String paramString, int paramInt)
  {
    super(new FixedSecureRandom.Source[] { new FixedSecureRandom.BigInteger(BigIntegers.asUnsignedByteArray(new BigInteger(paramString, paramInt))) });
  }
  
  public TestRandomBigInteger(byte[] paramArrayOfByte)
  {
    super(new FixedSecureRandom.Source[] { new FixedSecureRandom.BigInteger(paramArrayOfByte) });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\test\TestRandomBigInteger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */