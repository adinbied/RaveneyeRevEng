package kotlin.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={"\000$\n\000\n\002\020\013\n\002\030\002\n\002\b\005\n\002\020\016\n\002\b\003\n\002\020\b\n\002\b\005\n\002\030\002\n\000\032\021\020\013\032\0020\f*\0020\bH\002¢\006\002\b\r\032\034\020\016\032\0020\002*\0020\0022\006\020\017\032\0020\f2\006\020\020\032\0020\fH\000\032\f\020\021\032\0020\022*\0020\002H\000\"\025\020\000\032\0020\001*\0020\0028F¢\006\006\032\004\b\000\020\003\"\030\020\004\032\0020\002*\0020\0028@X\004¢\006\006\032\004\b\005\020\006\"\030\020\007\032\0020\b*\0020\0028@X\004¢\006\006\032\004\b\t\020\n¨\006\023"}, d2={"isRooted", "", "Ljava/io/File;", "(Ljava/io/File;)Z", "root", "getRoot", "(Ljava/io/File;)Ljava/io/File;", "rootName", "", "getRootName", "(Ljava/io/File;)Ljava/lang/String;", "getRootLength", "", "getRootLength$FilesKt__FilePathComponentsKt", "subPath", "beginIndex", "endIndex", "toComponents", "Lkotlin/io/FilePathComponents;", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/io/FilesKt")
class FilesKt__FilePathComponentsKt
{
  public static final File getRoot(File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$root");
    return new File(FilesKt.getRootName(paramFile));
  }
  
  private static final int getRootLength$FilesKt__FilePathComponentsKt(String paramString)
  {
    CharSequence localCharSequence = (CharSequence)paramString;
    int i = StringsKt.indexOf$default(localCharSequence, File.separatorChar, 0, false, 4, null);
    if (i == 0)
    {
      if ((paramString.length() > 1) && (paramString.charAt(1) == File.separatorChar))
      {
        i = StringsKt.indexOf$default(localCharSequence, File.separatorChar, 2, false, 4, null);
        if (i >= 0)
        {
          i = StringsKt.indexOf$default(localCharSequence, File.separatorChar, i + 1, false, 4, null);
          if (i >= 0) {
            return i + 1;
          }
          return paramString.length();
        }
      }
      return 1;
    }
    if ((i > 0) && (paramString.charAt(i - 1) == ':')) {
      return i + 1;
    }
    if ((i == -1) && (StringsKt.endsWith$default(localCharSequence, ':', false, 2, null))) {
      return paramString.length();
    }
    return 0;
  }
  
  public static final String getRootName(File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$rootName");
    String str = paramFile.getPath();
    Intrinsics.checkExpressionValueIsNotNull(str, "path");
    paramFile = paramFile.getPath();
    Intrinsics.checkExpressionValueIsNotNull(paramFile, "path");
    int i = getRootLength$FilesKt__FilePathComponentsKt(paramFile);
    if (str != null)
    {
      paramFile = str.substring(0, i);
      Intrinsics.checkExpressionValueIsNotNull(paramFile, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      return paramFile;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  public static final boolean isRooted(File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$isRooted");
    paramFile = paramFile.getPath();
    Intrinsics.checkExpressionValueIsNotNull(paramFile, "path");
    return getRootLength$FilesKt__FilePathComponentsKt(paramFile) > 0;
  }
  
  public static final File subPath(File paramFile, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$subPath");
    return FilesKt.toComponents(paramFile).subPath(paramInt1, paramInt2);
  }
  
  public static final FilePathComponents toComponents(File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$toComponents");
    paramFile = paramFile.getPath();
    Intrinsics.checkExpressionValueIsNotNull(paramFile, "path");
    int i = getRootLength$FilesKt__FilePathComponentsKt(paramFile);
    String str = paramFile.substring(0, i);
    Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    paramFile = paramFile.substring(i);
    Intrinsics.checkExpressionValueIsNotNull(paramFile, "(this as java.lang.String).substring(startIndex)");
    paramFile = (CharSequence)paramFile;
    if (paramFile.length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramFile = CollectionsKt.emptyList();
    }
    else
    {
      Object localObject = (Iterable)StringsKt.split$default(paramFile, new char[] { File.separatorChar }, false, 0, 6, null);
      paramFile = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramFile.add(new File((String)((Iterator)localObject).next()));
      }
      paramFile = (List)paramFile;
    }
    return new FilePathComponents(new File(str), paramFile);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\io\FilesKt__FilePathComponentsKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */