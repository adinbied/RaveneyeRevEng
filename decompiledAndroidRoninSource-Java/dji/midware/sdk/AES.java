package dji.midware.sdk;

import android.content.Context;
import android.util.Base64;
import dji.log.RoninLog;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES
{
  private static String TAG = "AES";
  private static byte[] iv = new byte[16];
  
  public static String decrypt(String paramString1, String paramString2)
    throws Exception
  {
    paramString2 = new SecretKeySpec(paramString2.getBytes("utf-8"), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(2, paramString2, new IvParameterSpec(iv));
    return new String(localCipher.doFinal(Base64.decode(paramString1, 8)));
  }
  
  public static byte[] decrypt(byte[] paramArrayOfByte, SecretKeySpec paramSecretKeySpec, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      localObject = Cipher.getInstance("AES/CBC/PKCS7Padding");
      byte[] arrayOfByte = new byte[16];
      Arrays.fill(arrayOfByte, (byte)0);
      ((Cipher)localObject).init(2, paramSecretKeySpec, new IvParameterSpec(arrayOfByte));
      paramSecretKeySpec = (SecretKeySpec)localObject;
      break label56;
      localObject = Cipher.getInstance("AES");
      ((Cipher)localObject).init(2, paramSecretKeySpec);
      paramSecretKeySpec = (SecretKeySpec)localObject;
      label56:
      paramArrayOfByte = paramSecretKeySpec.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramSecretKeySpec = TAG;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decrypt failed: ");
      ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
      RoninLog.d(paramSecretKeySpec, ((StringBuilder)localObject).toString(), new Object[0]);
    }
    return null;
  }
  
  public static byte[] decrypt1860Database(byte[] paramArrayOfByte, SecretKeySpec paramSecretKeySpec)
  {
    return decrypt(paramArrayOfByte, paramSecretKeySpec, true);
  }
  
  public static void decryptToFile(Context paramContext, byte[] paramArrayOfByte, SecretKeySpec paramSecretKeySpec, String paramString)
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
      byte[] arrayOfByte = new byte[16];
      Arrays.fill(arrayOfByte, (byte)0);
      localCipher.init(2, paramSecretKeySpec, new IvParameterSpec(arrayOfByte));
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      paramContext = paramContext.openFileOutput(paramString, 0);
      paramContext.write(paramArrayOfByte);
      paramContext.close();
      return;
    }
    catch (Exception paramContext)
    {
      paramArrayOfByte = TAG;
      paramSecretKeySpec = new StringBuilder();
      paramSecretKeySpec.append("decrypt to file() failed: ");
      paramSecretKeySpec.append(paramContext.getMessage());
      RoninLog.d(paramArrayOfByte, paramSecretKeySpec.toString(), new Object[0]);
    }
  }
  
  public static String encrypt(String paramString1, String paramString2)
    throws Exception
  {
    paramString1 = paramString1.getBytes("utf-8");
    paramString2 = new SecretKeySpec(paramString2.getBytes("utf-8"), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(1, paramString2, new IvParameterSpec(iv));
    return Base64.encodeToString(localCipher.doFinal(paramString1), 8).replace("\n", "");
  }
  
  public static void encrypt(Context paramContext, byte[] paramArrayOfByte, SecretKeySpec paramSecretKeySpec, String paramString)
  {
    try
    {
      Object localObject = Cipher.getInstance("AES/CBC/PKCS7Padding");
      ((Cipher)localObject).init(1, paramSecretKeySpec);
      paramSecretKeySpec = new ByteArrayOutputStream();
      localObject = new CipherOutputStream(paramSecretKeySpec, (Cipher)localObject);
      ((CipherOutputStream)localObject).write(paramArrayOfByte);
      ((CipherOutputStream)localObject).flush();
      ((CipherOutputStream)localObject).close();
      paramContext = paramContext.openFileOutput(paramString, 0);
      paramContext.write(paramSecretKeySpec.toByteArray());
      paramContext.close();
      return;
    }
    catch (Exception paramContext)
    {
      paramArrayOfByte = TAG;
      paramSecretKeySpec = new StringBuilder();
      paramSecretKeySpec.append("encrypt failed: ");
      paramSecretKeySpec.append(paramContext.getMessage());
      RoninLog.d(paramArrayOfByte, paramSecretKeySpec.toString(), new Object[0]);
    }
  }
  
  public static String encryptHmacSha256(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new SecretKeySpec(paramString2.getBytes(), "HmacSha256");
      Mac localMac = Mac.getInstance(paramString2.getAlgorithm());
      localMac.init(paramString2);
      paramString1 = localMac.doFinal(paramString1.getBytes());
      paramString2 = new StringBuilder();
      paramString2.append("%0");
      paramString2.append(paramString1.length * 2);
      paramString2.append("X");
      paramString1 = String.format(paramString2.toString(), new Object[] { new BigInteger(1, paramString1) });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\sdk\AES.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */