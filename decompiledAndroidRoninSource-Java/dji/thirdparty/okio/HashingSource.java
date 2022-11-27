package dji.thirdparty.okio;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class HashingSource
  extends ForwardingSource
{
  private final MessageDigest messageDigest;
  
  private HashingSource(Source paramSource, String paramString)
  {
    super(paramSource);
    try
    {
      this.messageDigest = MessageDigest.getInstance(paramString);
      return;
    }
    catch (NoSuchAlgorithmException paramSource)
    {
      for (;;) {}
    }
    throw new AssertionError();
  }
  
  public static HashingSource md5(Source paramSource)
  {
    return new HashingSource(paramSource, "MD5");
  }
  
  public static HashingSource sha1(Source paramSource)
  {
    return new HashingSource(paramSource, "SHA-1");
  }
  
  public static HashingSource sha256(Source paramSource)
  {
    return new HashingSource(paramSource, "SHA-256");
  }
  
  public ByteString hash()
  {
    return null;
  }
  
  public long read(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    return 277962839L;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okio\HashingSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */