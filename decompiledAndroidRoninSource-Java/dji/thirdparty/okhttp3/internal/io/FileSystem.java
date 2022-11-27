package dji.thirdparty.okhttp3.internal.io;

import dji.thirdparty.okio.Okio;
import dji.thirdparty.okio.Sink;
import dji.thirdparty.okio.Source;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract interface FileSystem
{
  public static final FileSystem SYSTEM = new FileSystem()
  {
    public Sink appendingSink(File paramAnonymousFile)
      throws FileNotFoundException
    {
      return null;
    }
    
    /* Error */
    public void delete(File arg1)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void deleteContents(File arg1)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean exists(File paramAnonymousFile)
    {
      return paramAnonymousFile.exists();
    }
    
    /* Error */
    public void rename(File arg1, File arg2)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public Sink sink(File paramAnonymousFile)
      throws FileNotFoundException
    {
      return null;
    }
    
    public long size(File paramAnonymousFile)
    {
      return paramAnonymousFile.length();
    }
    
    public Source source(File paramAnonymousFile)
      throws FileNotFoundException
    {
      return Okio.source(paramAnonymousFile);
    }
  };
  
  public abstract Sink appendingSink(File paramFile)
    throws FileNotFoundException;
  
  public abstract void delete(File paramFile)
    throws IOException;
  
  public abstract void deleteContents(File paramFile)
    throws IOException;
  
  public abstract boolean exists(File paramFile);
  
  public abstract void rename(File paramFile1, File paramFile2)
    throws IOException;
  
  public abstract Sink sink(File paramFile)
    throws FileNotFoundException;
  
  public abstract long size(File paramFile);
  
  public abstract Source source(File paramFile)
    throws FileNotFoundException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\io\FileSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */