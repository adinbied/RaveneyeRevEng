package org.bouncycastle.crypto;

import org.bouncycastle.util.Strings;

public abstract class PBEParametersGenerator
{
  protected int iterationCount;
  protected byte[] password;
  protected byte[] salt;
  
  public static byte[] PKCS12PasswordToBytes(char[] paramArrayOfChar)
  {
    int i = 0;
    if ((paramArrayOfChar != null) && (paramArrayOfChar.length > 0))
    {
      byte[] arrayOfByte = new byte[(paramArrayOfChar.length + 1) * 2];
      while (i != paramArrayOfChar.length)
      {
        int j = i * 2;
        arrayOfByte[j] = ((byte)(paramArrayOfChar[i] >>> '\b'));
        arrayOfByte[(j + 1)] = ((byte)paramArrayOfChar[i]);
        i += 1;
      }
      return arrayOfByte;
    }
    return new byte[0];
  }
  
  public static byte[] PKCS5PasswordToBytes(char[] paramArrayOfChar)
  {
    int i = 0;
    if (paramArrayOfChar != null)
    {
      int j = paramArrayOfChar.length;
      byte[] arrayOfByte = new byte[j];
      while (i != j)
      {
        arrayOfByte[i] = ((byte)paramArrayOfChar[i]);
        i += 1;
      }
      return arrayOfByte;
    }
    return new byte[0];
  }
  
  public static byte[] PKCS5PasswordToUTF8Bytes(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar != null) {
      return Strings.toUTF8ByteArray(paramArrayOfChar);
    }
    return new byte[0];
  }
  
  public abstract CipherParameters generateDerivedMacParameters(int paramInt);
  
  public abstract CipherParameters generateDerivedParameters(int paramInt);
  
  public abstract CipherParameters generateDerivedParameters(int paramInt1, int paramInt2);
  
  public int getIterationCount()
  {
    return this.iterationCount;
  }
  
  public byte[] getPassword()
  {
    return this.password;
  }
  
  public byte[] getSalt()
  {
    return this.salt;
  }
  
  public void init(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    this.password = paramArrayOfByte1;
    this.salt = paramArrayOfByte2;
    this.iterationCount = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\PBEParametersGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */