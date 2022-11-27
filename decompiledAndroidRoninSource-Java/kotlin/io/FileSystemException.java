package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\032\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\007\b\026\030\0002\0020\001B%\022\006\020\002\032\0020\003\022\n\b\002\020\004\032\004\030\0010\003\022\n\b\002\020\005\032\004\030\0010\006¢\006\002\020\007R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\b\020\tR\023\020\004\032\004\030\0010\003¢\006\b\n\000\032\004\b\n\020\tR\023\020\005\032\004\030\0010\006¢\006\b\n\000\032\004\b\013\020\f¨\006\r"}, d2={"Lkotlin/io/FileSystemException;", "Ljava/io/IOException;", "file", "Ljava/io/File;", "other", "reason", "", "(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V", "getFile", "()Ljava/io/File;", "getOther", "getReason", "()Ljava/lang/String;", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public class FileSystemException
  extends IOException
{
  private final File file;
  private final File other;
  private final String reason;
  
  public FileSystemException(File paramFile1, File paramFile2, String paramString)
  {
    super(ExceptionsKt.access$constructMessage(paramFile1, paramFile2, paramString));
    this.file = paramFile1;
    this.other = paramFile2;
    this.reason = paramString;
  }
  
  public final File getFile()
  {
    return this.file;
  }
  
  public final File getOther()
  {
    return this.other;
  }
  
  public final String getReason()
  {
    return this.reason;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\io\FileSystemException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */