package dji.thirdparty.okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Logger;

public final class Okio
{
  static final Logger logger = Logger.getLogger(Okio.class.getName());
  
  public static Sink appendingSink(File paramFile)
    throws FileNotFoundException
  {
    if (paramFile != null) {
      return sink(new FileOutputStream(paramFile, true));
    }
    throw new IllegalArgumentException("file == null");
  }
  
  public static BufferedSink buffer(Sink paramSink)
  {
    if (paramSink != null) {
      return new RealBufferedSink(paramSink);
    }
    throw new IllegalArgumentException("sink == null");
  }
  
  public static BufferedSource buffer(Source paramSource)
  {
    if (paramSource != null) {
      return new RealBufferedSource(paramSource);
    }
    throw new IllegalArgumentException("source == null");
  }
  
  static boolean isAndroidGetsocknameError(AssertionError paramAssertionError)
  {
    return (paramAssertionError.getCause() != null) && (paramAssertionError.getMessage() != null) && (paramAssertionError.getMessage().contains("getsockname failed"));
  }
  
  public static Sink sink(File paramFile)
    throws FileNotFoundException
  {
    if (paramFile != null) {
      return sink(new FileOutputStream(paramFile));
    }
    throw new IllegalArgumentException("file == null");
  }
  
  public static Sink sink(OutputStream paramOutputStream)
  {
    return sink(paramOutputStream, new Timeout());
  }
  
  private static Sink sink(final OutputStream paramOutputStream, Timeout paramTimeout)
  {
    if (paramOutputStream != null)
    {
      if (paramTimeout != null) {
        new Sink()
        {
          public void close()
            throws IOException
          {
            paramOutputStream.close();
          }
          
          public void flush()
            throws IOException
          {
            paramOutputStream.flush();
          }
          
          public Timeout timeout()
          {
            return this.val$timeout;
          }
          
          public String toString()
          {
            return null;
          }
          
          /* Error */
          public void write(Buffer arg1, long arg2)
            throws IOException
          {
            // Byte code:
            //   0: return
            //   1: astore_1
            //   2: goto -2 -> 0
          }
        };
      }
      throw new IllegalArgumentException("timeout == null");
    }
    throw new IllegalArgumentException("out == null");
  }
  
  public static Sink sink(Socket paramSocket)
    throws IOException
  {
    if (paramSocket != null)
    {
      AsyncTimeout localAsyncTimeout = timeout(paramSocket);
      return localAsyncTimeout.sink(sink(paramSocket.getOutputStream(), localAsyncTimeout));
    }
    throw new IllegalArgumentException("socket == null");
  }
  
  public static Sink sink(Path paramPath, OpenOption... paramVarArgs)
    throws IOException
  {
    if (paramPath != null) {
      return sink(Files.newOutputStream(paramPath, paramVarArgs));
    }
    throw new IllegalArgumentException("path == null");
  }
  
  public static Source source(File paramFile)
    throws FileNotFoundException
  {
    if (paramFile != null) {
      return source(new FileInputStream(paramFile));
    }
    throw new IllegalArgumentException("file == null");
  }
  
  public static Source source(InputStream paramInputStream)
  {
    return source(paramInputStream, new Timeout());
  }
  
  private static Source source(final InputStream paramInputStream, Timeout paramTimeout)
  {
    if (paramInputStream != null)
    {
      if (paramTimeout != null) {
        new Source()
        {
          public void close()
            throws IOException
          {
            paramInputStream.close();
          }
          
          public long read(Buffer paramAnonymousBuffer, long paramAnonymousLong)
            throws IOException
          {
            return 277870171L;
          }
          
          public Timeout timeout()
          {
            return this.val$timeout;
          }
          
          public String toString()
          {
            return null;
          }
        };
      }
      throw new IllegalArgumentException("timeout == null");
    }
    throw new IllegalArgumentException("in == null");
  }
  
  public static Source source(Socket paramSocket)
    throws IOException
  {
    if (paramSocket != null)
    {
      AsyncTimeout localAsyncTimeout = timeout(paramSocket);
      return localAsyncTimeout.source(source(paramSocket.getInputStream(), localAsyncTimeout));
    }
    throw new IllegalArgumentException("socket == null");
  }
  
  public static Source source(Path paramPath, OpenOption... paramVarArgs)
    throws IOException
  {
    if (paramPath != null) {
      return source(Files.newInputStream(paramPath, paramVarArgs));
    }
    throw new IllegalArgumentException("path == null");
  }
  
  private static AsyncTimeout timeout(Socket paramSocket)
  {
    new AsyncTimeout()
    {
      protected IOException newTimeoutException(IOException paramAnonymousIOException)
      {
        return null;
      }
      
      /* Error */
      protected void timedOut()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okio\Okio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */