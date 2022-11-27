package org.bouncycastle.cms;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;

class CMSAuthEnvelopedGenerator
{
  public static final String AES128_CCM = NISTObjectIdentifiers.id_aes128_CCM.getId();
  public static final String AES128_GCM = NISTObjectIdentifiers.id_aes128_GCM.getId();
  public static final String AES192_CCM = NISTObjectIdentifiers.id_aes192_CCM.getId();
  public static final String AES192_GCM = NISTObjectIdentifiers.id_aes192_GCM.getId();
  public static final String AES256_CCM = NISTObjectIdentifiers.id_aes256_CCM.getId();
  public static final String AES256_GCM = NISTObjectIdentifiers.id_aes256_GCM.getId();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSAuthEnvelopedGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */