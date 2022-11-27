package org.bouncycastle.openssl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.util.io.pem.PemGenerationException;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemObjectGenerator;

public class PKCS8Generator
  implements PemObjectGenerator
{
  public static final ASN1ObjectIdentifier AES_128_CBC = NISTObjectIdentifiers.id_aes128_CBC;
  public static final ASN1ObjectIdentifier AES_192_CBC = NISTObjectIdentifiers.id_aes192_CBC;
  public static final ASN1ObjectIdentifier AES_256_CBC = NISTObjectIdentifiers.id_aes256_CBC;
  public static final ASN1ObjectIdentifier DES3_CBC = PKCSObjectIdentifiers.des_EDE3_CBC;
  public static final ASN1ObjectIdentifier PBE_SHA1_2DES = PKCSObjectIdentifiers.pbeWithSHAAnd2_KeyTripleDES_CBC;
  public static final ASN1ObjectIdentifier PBE_SHA1_3DES;
  public static final ASN1ObjectIdentifier PBE_SHA1_RC2_128 = PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC2_CBC;
  public static final ASN1ObjectIdentifier PBE_SHA1_RC2_40 = PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC2_CBC;
  public static final ASN1ObjectIdentifier PBE_SHA1_RC4_128 = PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC4;
  public static final ASN1ObjectIdentifier PBE_SHA1_RC4_40 = PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC4;
  private PrivateKeyInfo key;
  private OutputEncryptor outputEncryptor;
  
  static
  {
    PBE_SHA1_3DES = PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC;
  }
  
  public PKCS8Generator(PrivateKeyInfo paramPrivateKeyInfo, OutputEncryptor paramOutputEncryptor)
  {
    this.key = paramPrivateKeyInfo;
    this.outputEncryptor = paramOutputEncryptor;
  }
  
  private PemObject generate(PrivateKeyInfo paramPrivateKeyInfo, OutputEncryptor paramOutputEncryptor)
    throws PemGenerationException
  {
    try
    {
      Object localObject = paramPrivateKeyInfo.getEncoded();
      if (paramOutputEncryptor == null) {
        return new PemObject("PRIVATE KEY", (byte[])localObject);
      }
      localObject = new ByteArrayOutputStream();
      OutputStream localOutputStream = paramOutputEncryptor.getOutputStream((OutputStream)localObject);
      localOutputStream.write(paramPrivateKeyInfo.getEncoded());
      localOutputStream.close();
      paramPrivateKeyInfo = new PemObject("ENCRYPTED PRIVATE KEY", new EncryptedPrivateKeyInfo(paramOutputEncryptor.getAlgorithmIdentifier(), ((ByteArrayOutputStream)localObject).toByteArray()).getEncoded());
      return paramPrivateKeyInfo;
    }
    catch (IOException paramPrivateKeyInfo)
    {
      paramOutputEncryptor = new StringBuilder();
      paramOutputEncryptor.append("unable to process encoded key data: ");
      paramOutputEncryptor.append(paramPrivateKeyInfo.getMessage());
      throw new PemGenerationException(paramOutputEncryptor.toString(), paramPrivateKeyInfo);
    }
  }
  
  public PemObject generate()
    throws PemGenerationException
  {
    OutputEncryptor localOutputEncryptor = this.outputEncryptor;
    if (localOutputEncryptor != null) {
      return generate(this.key, localOutputEncryptor);
    }
    return generate(this.key, null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\openssl\PKCS8Generator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */