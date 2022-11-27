package dji.midware.encryption.util;

import android.text.TextUtils;
import android.util.Base64;
import dji.log.RoninLog;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES256Encryption
{
  private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
  private static final String KEY_ALGORITHM = "AES";
  public static final String RSA_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAy2lB/iaW3KSx8IR2H74g\nk25qQqwRA1eNa7kAjGQ7mswtkcVayF2ftP7xSDeOvlmzoBpzvB6dopZbF5qcVYlk\nRN330ao6P09tnZ7416eB91fF1jWivo+y0uSvIP1+rv93r5aJOnMoCTRmaBIira0a\n++/mCsp800Lp5/qUViGdSUpNzMRn7f7d99bgEbOXPu2Ig0zIelbLL1vAuepaOQKf\n7lpvQVNpl4IhoIvWI7KvOahMuNKVzAfNa53N1vNGT1F/o0sqvun/AfejX7pQog0D\n58WvHpySXlQOtbLCvmoaZFyVos8dCgmRRCGxE4VG45Lt0teK1I2vFVYLwNyXbNtK\nuQIDAQAB";
  private static final String TAG = AES256Encryption.class.getSimpleName();
  private static byte[] ivBytes = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  
  public static boolean RSAVerifyWithPublicKey(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i < 6) {
        try
        {
          localObject = Signature.getInstance(new String[] { "MD5withRSA", "SHA1withRSA", "SHA224withRSA", "SHA256withRSA", "SHA384withRSA", "SHA512withRSA" }[i]);
          ((Signature)localObject).initVerify(createRSAPublicKey());
          boolean bool = ((Signature)localObject).verify(paramString.getBytes());
          if (bool) {
            return true;
          }
          i += 1;
        }
        catch (Exception paramString)
        {
          Object localObject = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Error encrypting secret key ");
          localStringBuilder.append(paramString.getMessage());
          RoninLog.e((String)localObject, localStringBuilder.toString(), new Object[0]);
        }
      }
    }
    return false;
  }
  
  public static PublicKey createRSAPublicKey()
    throws NoSuchAlgorithmException, InvalidKeySpecException
  {
    byte[] arrayOfByte = Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAy2lB/iaW3KSx8IR2H74g\nk25qQqwRA1eNa7kAjGQ7mswtkcVayF2ftP7xSDeOvlmzoBpzvB6dopZbF5qcVYlk\nRN330ao6P09tnZ7416eB91fF1jWivo+y0uSvIP1+rv93r5aJOnMoCTRmaBIira0a\n++/mCsp800Lp5/qUViGdSUpNzMRn7f7d99bgEbOXPu2Ig0zIelbLL1vAuepaOQKf\n7lpvQVNpl4IhoIvWI7KvOahMuNKVzAfNa53N1vNGT1F/o0sqvun/AfejX7pQog0D\n58WvHpySXlQOtbLCvmoaZFyVos8dCgmRRCGxE4VG45Lt0teK1I2vFVYLwNyXbNtK\nuQIDAQAB".getBytes(), 2);
    return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(arrayOfByte));
  }
  
  public static byte[] decrypt(byte[] paramArrayOfByte, String paramString)
    throws Exception
  {
    paramString = toKey(initKey(paramString));
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "BC");
    localCipher.init(2, paramString, new IvParameterSpec(ivBytes));
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte, String paramString)
    throws Exception
  {
    paramString = toKey(initKey(paramString));
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "BC");
    localCipher.init(1, paramString, new IvParameterSpec(ivBytes));
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static String encryptHmacSha256(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new SecretKeySpec(paramString2.getBytes(), "HmacSha256");
      Object localObject = Mac.getInstance(paramString2.getAlgorithm());
      ((Mac)localObject).init(paramString2);
      paramString1 = ((Mac)localObject).doFinal(paramString1.getBytes());
      paramString2 = Locale.US;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("%0");
      ((StringBuilder)localObject).append(paramString1.length * 2);
      ((StringBuilder)localObject).append("X");
      paramString1 = String.format(paramString2, ((StringBuilder)localObject).toString(), new Object[] { new BigInteger(1, paramString1) });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public static byte[] getAESKeyFromString(String paramString)
  {
    byte[] arrayOfByte = new byte[32];
    int j;
    for (int i = 0; i < 32; i = j)
    {
      j = i + 1;
      if (j <= paramString.length()) {
        arrayOfByte[i] = ((byte)paramString.charAt(i));
      } else {
        arrayOfByte[i] = 0;
      }
    }
    return arrayOfByte;
  }
  
  private static byte[] initKey(String paramString)
    throws Exception
  {
    return paramString.getBytes();
  }
  
  public static boolean isValid()
  {
    try
    {
      int i = Cipher.getMaxAllowedKeyLength("AES");
      if (i >= 256) {
        return true;
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
    }
    return false;
  }
  
  private static Key toKey(byte[] paramArrayOfByte)
    throws Exception
  {
    return new SecretKeySpec(paramArrayOfByte, "AES");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\encryptio\\util\AES256Encryption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */