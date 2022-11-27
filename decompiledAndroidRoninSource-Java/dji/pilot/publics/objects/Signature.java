package dji.pilot.publics.objects;

import dji.midware.util.BytesUtil;
import java.security.SignatureException;
import java.util.Locale;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Signature
{
  private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
  
  public static String calculateRFC2104HMAC(String paramString1, String paramString2)
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilot\publics\objects\Signature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */