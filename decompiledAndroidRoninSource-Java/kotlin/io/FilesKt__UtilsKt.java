package kotlin.io;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={"\000<\n\000\n\002\020\016\n\002\030\002\n\002\b\f\n\002\020\013\n\002\b\003\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\004\n\002\020 \n\000\n\002\030\002\n\002\b\f\032(\020\t\032\0020\0022\b\b\002\020\n\032\0020\0012\n\b\002\020\013\032\004\030\0010\0012\n\b\002\020\f\032\004\030\0010\002\032(\020\r\032\0020\0022\b\b\002\020\n\032\0020\0012\n\b\002\020\013\032\004\030\0010\0012\n\b\002\020\f\032\004\030\0010\002\0328\020\016\032\0020\017*\0020\0022\006\020\020\032\0020\0022\b\b\002\020\021\032\0020\0172\032\b\002\020\022\032\024\022\004\022\0020\002\022\004\022\0020\024\022\004\022\0020\0250\023\032&\020\026\032\0020\002*\0020\0022\006\020\020\032\0020\0022\b\b\002\020\021\032\0020\0172\b\b\002\020\027\032\0020\030\032\n\020\031\032\0020\017*\0020\002\032\022\020\032\032\0020\017*\0020\0022\006\020\033\032\0020\002\032\022\020\032\032\0020\017*\0020\0022\006\020\033\032\0020\001\032\n\020\034\032\0020\002*\0020\002\032\035\020\034\032\b\022\004\022\0020\0020\035*\b\022\004\022\0020\0020\035H\002¢\006\002\b\036\032\021\020\034\032\0020\037*\0020\037H\002¢\006\002\b\036\032\022\020 \032\0020\002*\0020\0022\006\020!\032\0020\002\032\024\020\"\032\004\030\0010\002*\0020\0022\006\020!\032\0020\002\032\022\020#\032\0020\002*\0020\0022\006\020!\032\0020\002\032\022\020$\032\0020\002*\0020\0022\006\020%\032\0020\002\032\022\020$\032\0020\002*\0020\0022\006\020%\032\0020\001\032\022\020&\032\0020\002*\0020\0022\006\020%\032\0020\002\032\022\020&\032\0020\002*\0020\0022\006\020%\032\0020\001\032\022\020'\032\0020\017*\0020\0022\006\020\033\032\0020\002\032\022\020'\032\0020\017*\0020\0022\006\020\033\032\0020\001\032\022\020(\032\0020\001*\0020\0022\006\020!\032\0020\002\032\033\020)\032\004\030\0010\001*\0020\0022\006\020!\032\0020\002H\002¢\006\002\b*\"\025\020\000\032\0020\001*\0020\0028F¢\006\006\032\004\b\003\020\004\"\025\020\005\032\0020\001*\0020\0028F¢\006\006\032\004\b\006\020\004\"\025\020\007\032\0020\001*\0020\0028F¢\006\006\032\004\b\b\020\004¨\006+"}, d2={"extension", "", "Ljava/io/File;", "getExtension", "(Ljava/io/File;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath", "nameWithoutExtension", "getNameWithoutExtension", "createTempDir", "prefix", "suffix", "directory", "createTempFile", "copyRecursively", "", "target", "overwrite", "onError", "Lkotlin/Function2;", "Ljava/io/IOException;", "Lkotlin/io/OnErrorAction;", "copyTo", "bufferSize", "", "deleteRecursively", "endsWith", "other", "normalize", "", "normalize$FilesKt__UtilsKt", "Lkotlin/io/FilePathComponents;", "relativeTo", "base", "relativeToOrNull", "relativeToOrSelf", "resolve", "relative", "resolveSibling", "startsWith", "toRelativeString", "toRelativeStringOrNull", "toRelativeStringOrNull$FilesKt__UtilsKt", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/io/FilesKt")
class FilesKt__UtilsKt
  extends FilesKt__FileTreeWalkKt
{
  public static final boolean copyRecursively(File paramFile1, File paramFile2, boolean paramBoolean, Function2<? super File, ? super IOException, ? extends OnErrorAction> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "$this$copyRecursively");
    Intrinsics.checkParameterIsNotNull(paramFile2, "target");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "onError");
    if (!paramFile1.exists()) {
      return (OnErrorAction)paramFunction2.invoke(paramFile1, new NoSuchFileException(paramFile1, null, "The source file doesn't exist.", 2, null)) != OnErrorAction.TERMINATE;
    }
    for (;;)
    {
      int i;
      try
      {
        Iterator localIterator = FilesKt.walkTopDown(paramFile1).onFail((Function2)new Lambda(paramFunction2)
        {
          public final void invoke(File paramAnonymousFile, IOException paramAnonymousIOException)
          {
            Intrinsics.checkParameterIsNotNull(paramAnonymousFile, "f");
            Intrinsics.checkParameterIsNotNull(paramAnonymousIOException, "e");
            if ((OnErrorAction)this.$onError.invoke(paramAnonymousFile, paramAnonymousIOException) != OnErrorAction.TERMINATE) {
              return;
            }
            throw ((Throwable)new TerminateException(paramAnonymousFile));
          }
        }).iterator();
        if (localIterator.hasNext())
        {
          Object localObject1 = (File)localIterator.next();
          if (!((File)localObject1).exists())
          {
            if ((OnErrorAction)paramFunction2.invoke(localObject1, new NoSuchFileException((File)localObject1, null, "The source file doesn't exist.", 2, null)) != OnErrorAction.TERMINATE) {
              continue;
            }
            return false;
          }
          Object localObject2 = new File(paramFile2, FilesKt.toRelativeString((File)localObject1, paramFile1));
          if (((File)localObject2).exists())
          {
            if (!((File)localObject1).isDirectory()) {
              break label335;
            }
            if (!((File)localObject2).isDirectory())
            {
              break label335;
              if (((File)localObject2).isDirectory())
              {
                if (FilesKt.deleteRecursively((File)localObject2)) {
                  break label345;
                }
                break label339;
              }
              if (((File)localObject2).delete()) {
                break label345;
              }
              break label339;
              if (i != 0)
              {
                if ((OnErrorAction)paramFunction2.invoke(localObject2, new FileAlreadyExistsException((File)localObject1, (File)localObject2, "The destination file already exists.")) != OnErrorAction.TERMINATE) {
                  continue;
                }
                return false;
              }
            }
          }
          if (((File)localObject1).isDirectory())
          {
            ((File)localObject2).mkdirs();
            continue;
          }
          if (FilesKt.copyTo$default((File)localObject1, (File)localObject2, paramBoolean, 0, 4, null).length() == ((File)localObject1).length()) {
            continue;
          }
          localObject1 = (OnErrorAction)paramFunction2.invoke(localObject1, new IOException("Source file wasn't copied completely, length of destination file differs."));
          localObject2 = OnErrorAction.TERMINATE;
          if (localObject1 != localObject2) {
            continue;
          }
          return false;
        }
        else
        {
          return true;
        }
      }
      catch (TerminateException paramFile1)
      {
        return false;
      }
      label335:
      if (!paramBoolean)
      {
        label339:
        i = 1;
        continue;
        label345:
        i = 0;
      }
    }
  }
  
  public static final File copyTo(File paramFile1, File paramFile2, boolean paramBoolean, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "$this$copyTo");
    Intrinsics.checkParameterIsNotNull(paramFile2, "target");
    if (paramFile1.exists())
    {
      if (paramFile2.exists()) {
        if (paramBoolean)
        {
          if (!paramFile2.delete()) {
            throw ((Throwable)new FileAlreadyExistsException(paramFile1, paramFile2, "Tried to overwrite the destination, but failed to delete it."));
          }
        }
        else {
          throw ((Throwable)new FileAlreadyExistsException(paramFile1, paramFile2, "The destination file already exists."));
        }
      }
      if (paramFile1.isDirectory())
      {
        if (paramFile2.mkdirs()) {
          return paramFile2;
        }
        throw ((Throwable)new FileSystemException(paramFile1, paramFile2, "Failed to create target directory."));
      }
      Object localObject1 = paramFile2.getParentFile();
      if (localObject1 != null) {
        ((File)localObject1).mkdirs();
      }
      paramFile1 = (Closeable)new FileInputStream(paramFile1);
      Throwable localThrowable1 = (Throwable)null;
      try
      {
        FileInputStream localFileInputStream = (FileInputStream)paramFile1;
        localObject1 = (Closeable)new FileOutputStream(paramFile2);
        Throwable localThrowable2 = (Throwable)null;
        try
        {
          FileOutputStream localFileOutputStream = (FileOutputStream)localObject1;
          ByteStreamsKt.copyTo((InputStream)localFileInputStream, (OutputStream)localFileOutputStream, paramInt);
          CloseableKt.closeFinally((Closeable)localObject1, localThrowable2);
          CloseableKt.closeFinally(paramFile1, localThrowable1);
          return paramFile2;
        }
        finally
        {
          try
          {
            throw paramFile2;
          }
          finally
          {
            CloseableKt.closeFinally((Closeable)localObject1, paramFile2);
          }
        }
        throw ((Throwable)new NoSuchFileException(paramFile1, null, "The source file doesn't exist.", 2, null));
      }
      finally
      {
        try
        {
          throw paramFile2;
        }
        finally
        {
          CloseableKt.closeFinally(paramFile1, paramFile2);
        }
      }
    }
  }
  
  public static final File createTempDir(String paramString1, String paramString2, File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "prefix");
    paramString1 = File.createTempFile(paramString1, paramString2, paramFile);
    paramString1.delete();
    if (paramString1.mkdir())
    {
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "dir");
      return paramString1;
    }
    paramString2 = new StringBuilder();
    paramString2.append("Unable to create temporary directory ");
    paramString2.append(paramString1);
    paramString2.append('.');
    throw ((Throwable)new IOException(paramString2.toString()));
  }
  
  public static final File createTempFile(String paramString1, String paramString2, File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "prefix");
    paramString1 = File.createTempFile(paramString1, paramString2, paramFile);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "File.createTempFile(prefix, suffix, directory)");
    return paramString1;
  }
  
  public static final boolean deleteRecursively(File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$deleteRecursively");
    paramFile = ((Sequence)FilesKt.walkBottomUp(paramFile)).iterator();
    for (boolean bool = true;; bool = false)
    {
      if (!paramFile.hasNext()) {
        return bool;
      }
      File localFile = (File)paramFile.next();
      if (((localFile.delete()) || (!localFile.exists())) && (bool)) {
        break;
      }
    }
    return bool;
  }
  
  public static final boolean endsWith(File paramFile1, File paramFile2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "$this$endsWith");
    Intrinsics.checkParameterIsNotNull(paramFile2, "other");
    FilePathComponents localFilePathComponents1 = FilesKt.toComponents(paramFile1);
    FilePathComponents localFilePathComponents2 = FilesKt.toComponents(paramFile2);
    if (localFilePathComponents2.isRooted()) {
      return Intrinsics.areEqual(paramFile1, paramFile2);
    }
    int i = localFilePathComponents1.getSize() - localFilePathComponents2.getSize();
    if (i < 0) {
      return false;
    }
    return localFilePathComponents1.getSegments().subList(i, localFilePathComponents1.getSize()).equals(localFilePathComponents2.getSegments());
  }
  
  public static final boolean endsWith(File paramFile, String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$endsWith");
    Intrinsics.checkParameterIsNotNull(paramString, "other");
    return FilesKt.endsWith(paramFile, new File(paramString));
  }
  
  public static final String getExtension(File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$extension");
    paramFile = paramFile.getName();
    Intrinsics.checkExpressionValueIsNotNull(paramFile, "name");
    return StringsKt.substringAfterLast(paramFile, '.', "");
  }
  
  public static final String getInvariantSeparatorsPath(File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$invariantSeparatorsPath");
    if (File.separatorChar != '/')
    {
      paramFile = paramFile.getPath();
      Intrinsics.checkExpressionValueIsNotNull(paramFile, "path");
      return StringsKt.replace$default(paramFile, File.separatorChar, '/', false, 4, null);
    }
    paramFile = paramFile.getPath();
    Intrinsics.checkExpressionValueIsNotNull(paramFile, "path");
    return paramFile;
  }
  
  public static final String getNameWithoutExtension(File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$nameWithoutExtension");
    paramFile = paramFile.getName();
    Intrinsics.checkExpressionValueIsNotNull(paramFile, "name");
    return StringsKt.substringBeforeLast$default(paramFile, ".", null, 2, null);
  }
  
  public static final File normalize(File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$normalize");
    Object localObject = FilesKt.toComponents(paramFile);
    paramFile = ((FilePathComponents)localObject).getRoot();
    localObject = (Iterable)normalize$FilesKt__UtilsKt(((FilePathComponents)localObject).getSegments());
    String str = File.separator;
    Intrinsics.checkExpressionValueIsNotNull(str, "File.separator");
    return FilesKt.resolve(paramFile, CollectionsKt.joinToString$default((Iterable)localObject, (CharSequence)str, null, null, 0, null, null, 62, null));
  }
  
  private static final List<File> normalize$FilesKt__UtilsKt(List<? extends File> paramList)
  {
    List localList = (List)new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      File localFile = (File)paramList.next();
      String str = localFile.getName();
      if (str != null)
      {
        int i = str.hashCode();
        if (i != 46)
        {
          if ((i == 1472) && (str.equals("..")))
          {
            if ((!localList.isEmpty()) && ((Intrinsics.areEqual(((File)CollectionsKt.last(localList)).getName(), "..") ^ true)))
            {
              localList.remove(localList.size() - 1);
              continue;
            }
            localList.add(localFile);
          }
        }
        else {
          if (str.equals(".")) {
            continue;
          }
        }
      }
      localList.add(localFile);
    }
    return localList;
  }
  
  private static final FilePathComponents normalize$FilesKt__UtilsKt(FilePathComponents paramFilePathComponents)
  {
    return new FilePathComponents(paramFilePathComponents.getRoot(), normalize$FilesKt__UtilsKt(paramFilePathComponents.getSegments()));
  }
  
  public static final File relativeTo(File paramFile1, File paramFile2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "$this$relativeTo");
    Intrinsics.checkParameterIsNotNull(paramFile2, "base");
    return new File(FilesKt.toRelativeString(paramFile1, paramFile2));
  }
  
  public static final File relativeToOrNull(File paramFile1, File paramFile2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "$this$relativeToOrNull");
    Intrinsics.checkParameterIsNotNull(paramFile2, "base");
    paramFile1 = toRelativeStringOrNull$FilesKt__UtilsKt(paramFile1, paramFile2);
    if (paramFile1 != null) {
      return new File(paramFile1);
    }
    return null;
  }
  
  public static final File relativeToOrSelf(File paramFile1, File paramFile2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "$this$relativeToOrSelf");
    Intrinsics.checkParameterIsNotNull(paramFile2, "base");
    paramFile2 = toRelativeStringOrNull$FilesKt__UtilsKt(paramFile1, paramFile2);
    if (paramFile2 != null) {
      paramFile1 = new File(paramFile2);
    }
    return paramFile1;
  }
  
  public static final File resolve(File paramFile1, File paramFile2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "$this$resolve");
    Intrinsics.checkParameterIsNotNull(paramFile2, "relative");
    if (FilesKt.isRooted(paramFile2)) {
      return paramFile2;
    }
    paramFile1 = paramFile1.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramFile1, "this.toString()");
    Object localObject = (CharSequence)paramFile1;
    int i;
    if (((CharSequence)localObject).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i == 0) && (!StringsKt.endsWith$default((CharSequence)localObject, File.separatorChar, false, 2, null)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramFile1);
      ((StringBuilder)localObject).append(File.separatorChar);
      ((StringBuilder)localObject).append(paramFile2);
      return new File(((StringBuilder)localObject).toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramFile1);
    ((StringBuilder)localObject).append(paramFile2);
    return new File(((StringBuilder)localObject).toString());
  }
  
  public static final File resolve(File paramFile, String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$resolve");
    Intrinsics.checkParameterIsNotNull(paramString, "relative");
    return FilesKt.resolve(paramFile, new File(paramString));
  }
  
  public static final File resolveSibling(File paramFile1, File paramFile2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "$this$resolveSibling");
    Intrinsics.checkParameterIsNotNull(paramFile2, "relative");
    FilePathComponents localFilePathComponents = FilesKt.toComponents(paramFile1);
    if (localFilePathComponents.getSize() == 0) {
      paramFile1 = new File("..");
    } else {
      paramFile1 = localFilePathComponents.subPath(0, localFilePathComponents.getSize() - 1);
    }
    return FilesKt.resolve(FilesKt.resolve(localFilePathComponents.getRoot(), paramFile1), paramFile2);
  }
  
  public static final File resolveSibling(File paramFile, String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$resolveSibling");
    Intrinsics.checkParameterIsNotNull(paramString, "relative");
    return FilesKt.resolveSibling(paramFile, new File(paramString));
  }
  
  public static final boolean startsWith(File paramFile1, File paramFile2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "$this$startsWith");
    Intrinsics.checkParameterIsNotNull(paramFile2, "other");
    paramFile1 = FilesKt.toComponents(paramFile1);
    paramFile2 = FilesKt.toComponents(paramFile2);
    if ((Intrinsics.areEqual(paramFile1.getRoot(), paramFile2.getRoot()) ^ true)) {
      return false;
    }
    if (paramFile1.getSize() < paramFile2.getSize()) {
      return false;
    }
    return paramFile1.getSegments().subList(0, paramFile2.getSize()).equals(paramFile2.getSegments());
  }
  
  public static final boolean startsWith(File paramFile, String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$startsWith");
    Intrinsics.checkParameterIsNotNull(paramString, "other");
    return FilesKt.startsWith(paramFile, new File(paramString));
  }
  
  public static final String toRelativeString(File paramFile1, File paramFile2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "$this$toRelativeString");
    Intrinsics.checkParameterIsNotNull(paramFile2, "base");
    Object localObject = toRelativeStringOrNull$FilesKt__UtilsKt(paramFile1, paramFile2);
    if (localObject != null) {
      return (String)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("this and base files have different roots: ");
    ((StringBuilder)localObject).append(paramFile1);
    ((StringBuilder)localObject).append(" and ");
    ((StringBuilder)localObject).append(paramFile2);
    ((StringBuilder)localObject).append('.');
    throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString()));
  }
  
  private static final String toRelativeStringOrNull$FilesKt__UtilsKt(File paramFile1, File paramFile2)
  {
    Object localObject = normalize$FilesKt__UtilsKt(FilesKt.toComponents(paramFile1));
    paramFile2 = normalize$FilesKt__UtilsKt(FilesKt.toComponents(paramFile2));
    if ((Intrinsics.areEqual(((FilePathComponents)localObject).getRoot(), paramFile2.getRoot()) ^ true)) {
      return null;
    }
    int k = paramFile2.getSize();
    int m = ((FilePathComponents)localObject).getSize();
    int i = 0;
    int j = Math.min(m, k);
    while ((i < j) && (Intrinsics.areEqual((File)((FilePathComponents)localObject).getSegments().get(i), (File)paramFile2.getSegments().get(i)))) {
      i += 1;
    }
    paramFile1 = new StringBuilder();
    j = k - 1;
    if (j >= i) {
      for (;;)
      {
        if (Intrinsics.areEqual(((File)paramFile2.getSegments().get(j)).getName(), "..")) {
          return null;
        }
        paramFile1.append("..");
        if (j != i) {
          paramFile1.append(File.separatorChar);
        }
        if (j == i) {
          break;
        }
        j -= 1;
      }
    }
    if (i < m)
    {
      if (i < k) {
        paramFile1.append(File.separatorChar);
      }
      paramFile2 = (Iterable)CollectionsKt.drop((Iterable)((FilePathComponents)localObject).getSegments(), i);
      localObject = (Appendable)paramFile1;
      String str = File.separator;
      Intrinsics.checkExpressionValueIsNotNull(str, "File.separator");
      CollectionsKt.joinTo$default(paramFile2, (Appendable)localObject, (CharSequence)str, null, null, 0, null, null, 124, null);
    }
    return paramFile1.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\io\FilesKt__UtilsKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */