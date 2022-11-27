package org.bouncycastle.util.test;

import org.bouncycastle.util.encoders.Hex;

public class TestRandomData
  extends FixedSecureRandom
{
  public TestRandomData(String paramString)
  {
    super(new FixedSecureRandom.Source[] { new FixedSecureRandom.Data(Hex.decode(paramString)) });
  }
  
  public TestRandomData(byte[] paramArrayOfByte)
  {
    super(new FixedSecureRandom.Source[] { new FixedSecureRandom.Data(paramArrayOfByte) });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\test\TestRandomData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */