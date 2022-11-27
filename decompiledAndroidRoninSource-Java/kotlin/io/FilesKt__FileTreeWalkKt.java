package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\024\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\032\024\020\000\032\0020\001*\0020\0022\b\b\002\020\003\032\0020\004\032\n\020\005\032\0020\001*\0020\002\032\n\020\006\032\0020\001*\0020\002¨\006\007"}, d2={"walk", "Lkotlin/io/FileTreeWalk;", "Ljava/io/File;", "direction", "Lkotlin/io/FileWalkDirection;", "walkBottomUp", "walkTopDown", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/io/FilesKt")
class FilesKt__FileTreeWalkKt
  extends FilesKt__FileReadWriteKt
{
  public static final FileTreeWalk walk(File paramFile, FileWalkDirection paramFileWalkDirection)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$walk");
    Intrinsics.checkParameterIsNotNull(paramFileWalkDirection, "direction");
    return new FileTreeWalk(paramFile, paramFileWalkDirection);
  }
  
  public static final FileTreeWalk walkBottomUp(File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$walkBottomUp");
    return FilesKt.walk(paramFile, FileWalkDirection.BOTTOM_UP);
  }
  
  public static final FileTreeWalk walkTopDown(File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$walkTopDown");
    return FilesKt.walk(paramFile, FileWalkDirection.TOP_DOWN);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\io\FilesKt__FileTreeWalkKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */