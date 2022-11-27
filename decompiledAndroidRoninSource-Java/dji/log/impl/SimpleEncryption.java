package dji.log.impl;

import dji.log.IEncryption;
import javax.crypto.SecretKey;

public class SimpleEncryption
  implements IEncryption
{
  static final String ALGORITHM = "PBKDF2WithHmacSHA1";
  static final String CHARSET_NAME = "UTF-8";
  static final String HEX_STR = "0123456789abcdef";
  static final int ITERATION_COUNT = 1000;
  static final String IV_PARAMETER = "9d6c5cab5b0281255a222d1c861ddfdf";
  static final String KEY_ALGORITHM = "AES";
  static final int KEY_LENGTH = 128;
  static final String SALT = "c8570ac98cc615aa6a6b97b3f20f1b41";
  static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
  private SecretKey KEY;
  private final String KEY_STR;
  
  public SimpleEncryption()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DJILog@");
    localStringBuilder.append(getClass().getSimpleName());
    this.KEY_STR = localStringBuilder.toString();
  }
  
  public static String binaryToHexString(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length;
    String str = "";
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      char c = "0123456789abcdef".charAt((k & 0xF0) >> 4);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(String.valueOf(c));
      ((StringBuilder)localObject).append(String.valueOf("0123456789abcdef".charAt(k & 0xF)));
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append((String)localObject);
      str = localStringBuilder.toString();
      i += 1;
    }
    return str;
  }
  
  private boolean check()
  {
    return false;
  }
  
  public static byte[] hexStringToBinary(String paramString)
  {
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      int k = i * 2;
      int m = (byte)("0123456789abcdef".indexOf(paramString.charAt(k)) << 4);
      arrayOfByte[i] = ((byte)((byte)"0123456789abcdef".indexOf(paramString.charAt(k + 1)) | m));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public String decrypt(String paramString)
    throws Exception
  {
    return null;
  }
  
  public String encrypt(String paramString)
    throws Exception
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\log\impl\SimpleEncryption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */