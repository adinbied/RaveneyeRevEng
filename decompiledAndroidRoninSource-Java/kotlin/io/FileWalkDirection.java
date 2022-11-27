package kotlin.io;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\f\n\002\030\002\n\002\020\020\n\002\b\004\b\001\030\0002\b\022\004\022\0020\0000\001B\007\b\002¢\006\002\020\002j\002\b\003j\002\b\004¨\006\005"}, d2={"Lkotlin/io/FileWalkDirection;", "", "(Ljava/lang/String;I)V", "TOP_DOWN", "BOTTOM_UP", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public enum FileWalkDirection
{
  static
  {
    FileWalkDirection localFileWalkDirection1 = new FileWalkDirection("TOP_DOWN", 0);
    TOP_DOWN = localFileWalkDirection1;
    FileWalkDirection localFileWalkDirection2 = new FileWalkDirection("BOTTOM_UP", 1);
    BOTTOM_UP = localFileWalkDirection2;
    $VALUES = new FileWalkDirection[] { localFileWalkDirection1, localFileWalkDirection2 };
  }
  
  private FileWalkDirection() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\io\FileWalkDirection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */