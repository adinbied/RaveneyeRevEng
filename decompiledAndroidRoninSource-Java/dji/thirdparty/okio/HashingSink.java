package dji.thirdparty.okio;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class HashingSink
  extends ForwardingSink
{
  private final MessageDigest messageDigest;
  
  private HashingSink(Sink paramSink, String paramString)
  {
    super(paramSink);
    try
    {
      this.messageDigest = MessageDigest.getInstance(paramString);
      return;
    }
    catch (NoSuchAlgorithmException paramSink)
    {
      for (;;) {}
    }
    throw new AssertionError();
  }
  
  public static HashingSink md5(Sink paramSink)
  {
    return new HashingSink(paramSink, "MD5");
  }
  
  public static HashingSink sha1(Sink paramSink)
  {
    return new HashingSink(paramSink, "SHA-1");
  }
  
  public static HashingSink sha256(Sink paramSink)
  {
    return new HashingSink(paramSink, "SHA-256");
  }
  
  public ByteString hash()
  {
    return null;
  }
  
  /* Error */
  public void write(Buffer arg1, long arg2)
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okio\HashingSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */