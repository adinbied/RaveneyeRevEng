package org.bouncycastle.operator.bc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.digests.GOST3411Digest;
import org.bouncycastle.crypto.digests.MD2Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.RIPEMD128Digest;
import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.crypto.digests.RIPEMD256Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA3Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.operator.OperatorCreationException;

public class BcDefaultDigestProvider
  implements BcDigestProvider
{
  public static final BcDigestProvider INSTANCE = new BcDefaultDigestProvider();
  private static final Map lookup = ;
  
  private static Map createTable()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(OIWObjectIdentifiers.idSHA1, new BcDigestProvider()
    {
      public ExtendedDigest get(AlgorithmIdentifier paramAnonymousAlgorithmIdentifier)
      {
        return new SHA1Digest();
      }
    });
    localHashMap.put(NISTObjectIdentifiers.id_sha224, new BcDigestProvider()
    {
      public ExtendedDigest get(AlgorithmIdentifier paramAnonymousAlgorithmIdentifier)
      {
        return new SHA224Digest();
      }
    });
    localHashMap.put(NISTObjectIdentifiers.id_sha256, new BcDigestProvider()
    {
      public ExtendedDigest get(AlgorithmIdentifier paramAnonymousAlgorithmIdentifier)
      {
        return new SHA256Digest();
      }
    });
    localHashMap.put(NISTObjectIdentifiers.id_sha384, new BcDigestProvider()
    {
      public ExtendedDigest get(AlgorithmIdentifier paramAnonymousAlgorithmIdentifier)
      {
        return new SHA384Digest();
      }
    });
    localHashMap.put(NISTObjectIdentifiers.id_sha512, new BcDigestProvider()
    {
      public ExtendedDigest get(AlgorithmIdentifier paramAnonymousAlgorithmIdentifier)
      {
        return new SHA512Digest();
      }
    });
    localHashMap.put(NISTObjectIdentifiers.id_sha3_224, new BcDigestProvider()
    {
      public ExtendedDigest get(AlgorithmIdentifier paramAnonymousAlgorithmIdentifier)
      {
        return new SHA3Digest(224);
      }
    });
    localHashMap.put(NISTObjectIdentifiers.id_sha3_256, new BcDigestProvider()
    {
      public ExtendedDigest get(AlgorithmIdentifier paramAnonymousAlgorithmIdentifier)
      {
        return new SHA3Digest(256);
      }
    });
    localHashMap.put(NISTObjectIdentifiers.id_sha3_384, new BcDigestProvider()
    {
      public ExtendedDigest get(AlgorithmIdentifier paramAnonymousAlgorithmIdentifier)
      {
        return new SHA3Digest(384);
      }
    });
    localHashMap.put(NISTObjectIdentifiers.id_sha3_512, new BcDigestProvider()
    {
      public ExtendedDigest get(AlgorithmIdentifier paramAnonymousAlgorithmIdentifier)
      {
        return new SHA3Digest(512);
      }
    });
    localHashMap.put(PKCSObjectIdentifiers.md5, new BcDigestProvider()
    {
      public ExtendedDigest get(AlgorithmIdentifier paramAnonymousAlgorithmIdentifier)
      {
        return new MD5Digest();
      }
    });
    localHashMap.put(PKCSObjectIdentifiers.md4, new BcDigestProvider()
    {
      public ExtendedDigest get(AlgorithmIdentifier paramAnonymousAlgorithmIdentifier)
      {
        return new MD4Digest();
      }
    });
    localHashMap.put(PKCSObjectIdentifiers.md2, new BcDigestProvider()
    {
      public ExtendedDigest get(AlgorithmIdentifier paramAnonymousAlgorithmIdentifier)
      {
        return new MD2Digest();
      }
    });
    localHashMap.put(CryptoProObjectIdentifiers.gostR3411, new BcDigestProvider()
    {
      public ExtendedDigest get(AlgorithmIdentifier paramAnonymousAlgorithmIdentifier)
      {
        return new GOST3411Digest();
      }
    });
    localHashMap.put(TeleTrusTObjectIdentifiers.ripemd128, new BcDigestProvider()
    {
      public ExtendedDigest get(AlgorithmIdentifier paramAnonymousAlgorithmIdentifier)
      {
        return new RIPEMD128Digest();
      }
    });
    localHashMap.put(TeleTrusTObjectIdentifiers.ripemd160, new BcDigestProvider()
    {
      public ExtendedDigest get(AlgorithmIdentifier paramAnonymousAlgorithmIdentifier)
      {
        return new RIPEMD160Digest();
      }
    });
    localHashMap.put(TeleTrusTObjectIdentifiers.ripemd256, new BcDigestProvider()
    {
      public ExtendedDigest get(AlgorithmIdentifier paramAnonymousAlgorithmIdentifier)
      {
        return new RIPEMD256Digest();
      }
    });
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public ExtendedDigest get(AlgorithmIdentifier paramAlgorithmIdentifier)
    throws OperatorCreationException
  {
    BcDigestProvider localBcDigestProvider = (BcDigestProvider)lookup.get(paramAlgorithmIdentifier.getAlgorithm());
    if (localBcDigestProvider != null) {
      return localBcDigestProvider.get(paramAlgorithmIdentifier);
    }
    throw new OperatorCreationException("cannot recognise digest");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\bc\BcDefaultDigestProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */