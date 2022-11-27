package dji.midware.util;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Locale;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class DJISafeUtil
{
  private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
  
  public static String calHMACsha1(String paramString1, String paramString2)
    throws SignatureException
  {
    try
    {
      paramString2 = new SecretKeySpec(paramString2.getBytes(), "HmacSHA1");
      Mac localMac = Mac.getInstance("HmacSHA1");
      localMac.init(paramString2);
      paramString1 = BytesUtil.byte2hexNoSep(localMac.doFinal(paramString1.getBytes())).toUpperCase(Locale.ENGLISH);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("Failed to generate HMAC : ");
      paramString2.append(paramString1.getMessage());
      throw new SignatureException(paramString2.toString());
    }
  }
  
  public static String getSingInfo(Context paramContext)
  {
    try
    {
      paramContext = new ByteArrayInputStream(paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures[0].toByteArray());
      paramContext = (X509Certificate)CertificateFactory.getInstance("X509").generateCertificate(paramContext);
      paramContext = BytesUtil.byte2hex(MessageDigest.getInstance("SHA1").digest(paramContext.getEncoded()), ":").toUpperCase(Locale.ENGLISH);
      return paramContext;
    }
    catch (NoSuchAlgorithmException paramContext)
    {
      paramContext.printStackTrace();
    }
    catch (CertificateException paramContext)
    {
      paramContext.printStackTrace();
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\util\DJISafeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */