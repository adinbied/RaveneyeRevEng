package org.bouncycastle.cms;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public class CMSConfig
{
  public static void setSigningDigestAlgorithmMapping(String paramString1, String paramString2)
  {
    paramString1 = new ASN1ObjectIdentifier(paramString1);
    CMSSignedHelper.INSTANCE.setSigningDigestAlgorithmMapping(paramString1, paramString2);
  }
  
  public static void setSigningEncryptionAlgorithmMapping(String paramString1, String paramString2)
  {
    paramString1 = new ASN1ObjectIdentifier(paramString1);
    CMSSignedHelper.INSTANCE.setSigningEncryptionAlgorithmMapping(paramString1, paramString2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */