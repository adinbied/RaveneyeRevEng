package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;

class Utils
{
  static Digest getDigest(String paramString)
  {
    if (paramString.equals("SHA-1")) {
      return new SHA1Digest();
    }
    if (paramString.equals("SHA-224")) {
      return new SHA224Digest();
    }
    if (paramString.equals("SHA-256")) {
      return new SHA256Digest();
    }
    if (paramString.equals("SHA-384")) {
      return new SHA384Digest();
    }
    if (paramString.equals("SHA-512")) {
      return new SHA512Digest();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unrecognised digest algorithm: ");
    localStringBuilder.append(paramString);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\mceliece\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */