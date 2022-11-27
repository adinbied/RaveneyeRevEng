package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class PKCS5S1ParametersGenerator
  extends PBEParametersGenerator
{
  private Digest digest;
  
  public PKCS5S1ParametersGenerator(Digest paramDigest)
  {
    this.digest = paramDigest;
  }
  
  private byte[] generateDerivedKey()
  {
    int j = this.digest.getDigestSize();
    byte[] arrayOfByte = new byte[j];
    this.digest.update(this.password, 0, this.password.length);
    this.digest.update(this.salt, 0, this.salt.length);
    this.digest.doFinal(arrayOfByte, 0);
    int i = 1;
    while (i < this.iterationCount)
    {
      this.digest.update(arrayOfByte, 0, j);
      this.digest.doFinal(arrayOfByte, 0);
      i += 1;
    }
    return arrayOfByte;
  }
  
  public CipherParameters generateDerivedMacParameters(int paramInt)
  {
    return generateDerivedParameters(paramInt);
  }
  
  public CipherParameters generateDerivedParameters(int paramInt)
  {
    paramInt /= 8;
    if (paramInt <= this.digest.getDigestSize()) {
      return new KeyParameter(generateDerivedKey(), 0, paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Can't generate a derived key ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" bytes long.");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public CipherParameters generateDerivedParameters(int paramInt1, int paramInt2)
  {
    paramInt1 /= 8;
    paramInt2 /= 8;
    int i = paramInt1 + paramInt2;
    if (i <= this.digest.getDigestSize())
    {
      localObject = generateDerivedKey();
      return new ParametersWithIV(new KeyParameter((byte[])localObject, 0, paramInt1), (byte[])localObject, paramInt1, paramInt2);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Can't generate a derived key ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" bytes long.");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\PKCS5S1ParametersGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */