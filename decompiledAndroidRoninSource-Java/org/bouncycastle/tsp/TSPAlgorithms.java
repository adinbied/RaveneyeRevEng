package org.bouncycastle.tsp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;

public abstract interface TSPAlgorithms
{
  public static final Set ALLOWED = new HashSet(Arrays.asList(new ASN1ObjectIdentifier[] { GOST3411, MD5, SHA1, SHA224, SHA256, SHA384, SHA512, RIPEMD128, RIPEMD160, RIPEMD256 }));
  public static final ASN1ObjectIdentifier GOST3411;
  public static final ASN1ObjectIdentifier MD5 = PKCSObjectIdentifiers.md5;
  public static final ASN1ObjectIdentifier RIPEMD128;
  public static final ASN1ObjectIdentifier RIPEMD160;
  public static final ASN1ObjectIdentifier RIPEMD256;
  public static final ASN1ObjectIdentifier SHA1 = OIWObjectIdentifiers.idSHA1;
  public static final ASN1ObjectIdentifier SHA224 = NISTObjectIdentifiers.id_sha224;
  public static final ASN1ObjectIdentifier SHA256 = NISTObjectIdentifiers.id_sha256;
  public static final ASN1ObjectIdentifier SHA384 = NISTObjectIdentifiers.id_sha384;
  public static final ASN1ObjectIdentifier SHA512 = NISTObjectIdentifiers.id_sha512;
  
  static
  {
    RIPEMD128 = TeleTrusTObjectIdentifiers.ripemd128;
    RIPEMD160 = TeleTrusTObjectIdentifiers.ripemd160;
    RIPEMD256 = TeleTrusTObjectIdentifiers.ripemd256;
    GOST3411 = CryptoProObjectIdentifiers.gostR3411;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\tsp\TSPAlgorithms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */