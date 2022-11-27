package org.bouncycastle.crypto.signers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Integers;

public class ISOTrailers
{
  public static final int TRAILER_IMPLICIT = 188;
  public static final int TRAILER_RIPEMD128 = 13004;
  public static final int TRAILER_RIPEMD160 = 12748;
  public static final int TRAILER_SHA1 = 13260;
  public static final int TRAILER_SHA224 = 14540;
  public static final int TRAILER_SHA256 = 13516;
  public static final int TRAILER_SHA384 = 14028;
  public static final int TRAILER_SHA512 = 13772;
  public static final int TRAILER_SHA512_224 = 14796;
  public static final int TRAILER_SHA512_256 = 16588;
  public static final int TRAILER_WHIRLPOOL = 14284;
  private static final Map<String, Integer> trailerMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("RIPEMD128", Integers.valueOf(13004));
    localHashMap.put("RIPEMD160", Integers.valueOf(12748));
    localHashMap.put("SHA-1", Integers.valueOf(13260));
    localHashMap.put("SHA-224", Integers.valueOf(14540));
    localHashMap.put("SHA-256", Integers.valueOf(13516));
    localHashMap.put("SHA-384", Integers.valueOf(14028));
    localHashMap.put("SHA-512", Integers.valueOf(13772));
    localHashMap.put("SHA-512/224", Integers.valueOf(14796));
    localHashMap.put("SHA-512/256", Integers.valueOf(16588));
    localHashMap.put("Whirlpool", Integers.valueOf(14284));
    trailerMap = Collections.unmodifiableMap(localHashMap);
  }
  
  public static Integer getTrailer(Digest paramDigest)
  {
    return (Integer)trailerMap.get(paramDigest.getAlgorithmName());
  }
  
  public static boolean noTrailerAvailable(Digest paramDigest)
  {
    return trailerMap.containsKey(paramDigest.getAlgorithmName()) ^ true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\signers\ISOTrailers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */