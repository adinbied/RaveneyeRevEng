package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.Metadata;
import okio.Sink;
import okio.Source;

@Metadata(bv={1, 0, 3}, d1={"\0004\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\002\b\003\n\002\020\013\n\002\b\005\n\002\020\t\n\000\n\002\030\002\n\002\b\002\bf\030\000 \0242\0020\001:\001\024J\020\020\002\032\0020\0032\006\020\004\032\0020\005H&J\020\020\006\032\0020\0072\006\020\004\032\0020\005H&J\020\020\b\032\0020\0072\006\020\t\032\0020\005H&J\020\020\n\032\0020\0132\006\020\004\032\0020\005H&J\030\020\f\032\0020\0072\006\020\r\032\0020\0052\006\020\016\032\0020\005H&J\020\020\017\032\0020\0032\006\020\004\032\0020\005H&J\020\020\020\032\0020\0212\006\020\004\032\0020\005H&J\020\020\022\032\0020\0232\006\020\004\032\0020\005H&\002\007\n\005\bF0\001¨\006\025"}, d2={"Lokhttp3/internal/io/FileSystem;", "", "appendingSink", "Lokio/Sink;", "file", "Ljava/io/File;", "delete", "", "deleteContents", "directory", "exists", "", "rename", "from", "to", "sink", "size", "", "source", "Lokio/Source;", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public abstract interface FileSystem
{
  public static final Companion Companion = new Companion(null);
  public static final FileSystem SYSTEM = (FileSystem)new FileSystem.Companion.SYSTEM.1();
  
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
  
  @Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\026\020\003\032\0020\0048\006X\004ø\001\000¢\006\002\n\000¨\006\001\002\007\n\005\bF0\001¨\006\005"}, d2={"Lokhttp3/internal/io/FileSystem$Companion;", "", "()V", "SYSTEM", "Lokhttp3/internal/io/FileSystem;", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\io\FileSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */