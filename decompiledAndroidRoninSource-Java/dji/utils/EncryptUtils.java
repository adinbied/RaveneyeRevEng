package dji.utils;

import android.text.TextUtils;
import android.util.Base64;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class EncryptUtils
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  private static String bytes2HexString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    int k = paramArrayOfByte.length;
    if (k <= 0) {
      return "";
    }
    char[] arrayOfChar1 = new char[k << 1];
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = j + 1;
      char[] arrayOfChar2 = HEX_DIGITS;
      arrayOfChar1[j] = arrayOfChar2[(paramArrayOfByte[i] >> 4 & 0xF)];
      j = m + 1;
      arrayOfChar1[m] = arrayOfChar2[(paramArrayOfByte[i] & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar1);
  }
  
  public static String decodeBase64(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      String str = new String(Base64.decode(paramString.getBytes("UTF-8"), 2), "UTF-8");
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramString;
  }
  
  public static String encodeBase64(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      String str = new String(Base64.encode(paramString.getBytes("UTF-8"), 2), "UTF-8");
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramString;
  }
  
  public static byte[] encryptHmacSHA256(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      try
      {
        paramString2 = new SecretKeySpec(paramString2.getBytes("UTF-8"), "HmacSHA256");
        Mac localMac = Mac.getInstance("HmacSHA256");
        localMac.init(paramString2);
        paramString1 = localMac.doFinal(paramString1.getBytes("UTF-8"));
        return paramString1;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return null;
  }
  
  public static byte[] encryptMD5(byte[] paramArrayOfByte)
  {
    return hashTemplate(paramArrayOfByte, "MD5");
  }
  
  /* Error */
  public static byte[] encryptMD5File(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: ifnonnull +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: new 107	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 110	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   16: astore_1
    //   17: aload_1
    //   18: astore_0
    //   19: new 112	java/security/DigestInputStream
    //   22: dup
    //   23: aload_1
    //   24: ldc 95
    //   26: invokestatic 117	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   29: invokespecial 120	java/security/DigestInputStream:<init>	(Ljava/io/InputStream;Ljava/security/MessageDigest;)V
    //   32: astore_2
    //   33: aload_1
    //   34: astore_0
    //   35: ldc 121
    //   37: newarray <illegal type>
    //   39: astore_3
    //   40: aload_1
    //   41: astore_0
    //   42: aload_2
    //   43: aload_3
    //   44: invokevirtual 125	java/security/DigestInputStream:read	([B)I
    //   47: ifgt -7 -> 40
    //   50: aload_1
    //   51: astore_0
    //   52: aload_2
    //   53: invokevirtual 129	java/security/DigestInputStream:getMessageDigest	()Ljava/security/MessageDigest;
    //   56: invokevirtual 133	java/security/MessageDigest:digest	()[B
    //   59: astore_2
    //   60: aload_1
    //   61: invokevirtual 136	java/io/FileInputStream:close	()V
    //   64: aload_2
    //   65: areturn
    //   66: astore_0
    //   67: aload_0
    //   68: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   71: aload_2
    //   72: areturn
    //   73: astore_2
    //   74: goto +20 -> 94
    //   77: astore_2
    //   78: goto +16 -> 94
    //   81: astore_0
    //   82: aload_2
    //   83: astore_1
    //   84: goto +38 -> 122
    //   87: astore_2
    //   88: goto +4 -> 92
    //   91: astore_2
    //   92: aconst_null
    //   93: astore_1
    //   94: aload_1
    //   95: astore_0
    //   96: aload_2
    //   97: invokevirtual 67	java/lang/Exception:printStackTrace	()V
    //   100: aload_1
    //   101: ifnull +14 -> 115
    //   104: aload_1
    //   105: invokevirtual 136	java/io/FileInputStream:close	()V
    //   108: aconst_null
    //   109: areturn
    //   110: astore_0
    //   111: aload_0
    //   112: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   115: aconst_null
    //   116: areturn
    //   117: astore_2
    //   118: aload_0
    //   119: astore_1
    //   120: aload_2
    //   121: astore_0
    //   122: aload_1
    //   123: ifnull +15 -> 138
    //   126: aload_1
    //   127: invokevirtual 136	java/io/FileInputStream:close	()V
    //   130: goto +8 -> 138
    //   133: astore_1
    //   134: aload_1
    //   135: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   138: aload_0
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramFile	File
    //   16	111	1	localObject1	Object
    //   133	2	1	localIOException1	java.io.IOException
    //   1	71	2	localObject2	Object
    //   73	1	2	localIOException2	java.io.IOException
    //   77	6	2	localNoSuchAlgorithmException1	NoSuchAlgorithmException
    //   87	1	2	localIOException3	java.io.IOException
    //   91	6	2	localNoSuchAlgorithmException2	NoSuchAlgorithmException
    //   117	4	2	localObject3	Object
    //   39	5	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   60	64	66	java/io/IOException
    //   19	33	73	java/io/IOException
    //   35	40	73	java/io/IOException
    //   42	50	73	java/io/IOException
    //   52	60	73	java/io/IOException
    //   19	33	77	java/security/NoSuchAlgorithmException
    //   35	40	77	java/security/NoSuchAlgorithmException
    //   42	50	77	java/security/NoSuchAlgorithmException
    //   52	60	77	java/security/NoSuchAlgorithmException
    //   8	17	81	finally
    //   8	17	87	java/io/IOException
    //   8	17	91	java/security/NoSuchAlgorithmException
    //   104	108	110	java/io/IOException
    //   19	33	117	finally
    //   35	40	117	finally
    //   42	50	117	finally
    //   52	60	117	finally
    //   96	100	117	finally
    //   126	130	133	java/io/IOException
  }
  
  public static byte[] encryptMD5File(String paramString)
  {
    if (hasSpace(paramString)) {
      paramString = null;
    } else {
      paramString = new File(paramString);
    }
    return encryptMD5File(paramString);
  }
  
  public static String encryptMD5File2String(File paramFile)
  {
    return bytes2HexString(encryptMD5File(paramFile));
  }
  
  public static String encryptMD5File2String(String paramString)
  {
    if (hasSpace(paramString)) {
      paramString = null;
    } else {
      paramString = new File(paramString);
    }
    return encryptMD5File2String(paramString);
  }
  
  public static String encryptMD5ToString(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0)) {
      return encryptMD5ToString(paramString.getBytes());
    }
    return "";
  }
  
  public static String encryptMD5ToString(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 == null)) {
      return "";
    }
    if (paramString2 == null) {
      return bytes2HexString(encryptMD5(paramString1.getBytes()));
    }
    if (paramString1 == null) {
      return bytes2HexString(encryptMD5(paramString2.getBytes()));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return bytes2HexString(encryptMD5(localStringBuilder.toString().getBytes()));
  }
  
  public static String encryptMD5ToString(byte[] paramArrayOfByte)
  {
    return bytes2HexString(encryptMD5(paramArrayOfByte));
  }
  
  public static String encryptMD5ToString(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) && (paramArrayOfByte2 == null)) {
      return "";
    }
    if (paramArrayOfByte2 == null) {
      return bytes2HexString(encryptMD5(paramArrayOfByte1));
    }
    if (paramArrayOfByte1 == null) {
      return bytes2HexString(encryptMD5(paramArrayOfByte2));
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    return bytes2HexString(encryptMD5(arrayOfByte));
  }
  
  public static byte[] encryptSHA1(byte[] paramArrayOfByte)
  {
    return hashTemplate(paramArrayOfByte, "SHA-1");
  }
  
  public static String encryptSHA1ToString(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0)) {
      return encryptSHA1ToString(paramString.getBytes());
    }
    return "";
  }
  
  public static String encryptSHA1ToString(byte[] paramArrayOfByte)
  {
    return bytes2HexString(encryptSHA1(paramArrayOfByte));
  }
  
  public static byte[] encryptSHA256(byte[] paramArrayOfByte)
  {
    return hashTemplate(paramArrayOfByte, "SHA-256");
  }
  
  public static String encryptSHA256ToString(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0)) {
      return encryptSHA256ToString(paramString.getBytes());
    }
    return "";
  }
  
  public static String encryptSHA256ToString(byte[] paramArrayOfByte)
  {
    return bytes2HexString(encryptSHA256(paramArrayOfByte));
  }
  
  private static boolean hasSpace(String paramString)
  {
    if (paramString == null) {
      return true;
    }
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if (!Character.isWhitespace(paramString.charAt(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static byte[] hashTemplate(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 0) {
        return null;
      }
      try
      {
        paramString = MessageDigest.getInstance(paramString);
        paramString.update(paramArrayOfByte);
        paramArrayOfByte = paramString.digest();
        return paramArrayOfByte;
      }
      catch (NoSuchAlgorithmException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\EncryptUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */