package org.junit.rules;

import java.io.File;
import java.io.IOException;

public class TemporaryFolder
  extends ExternalResource
{
  private File folder;
  private final File parentFolder;
  
  public TemporaryFolder()
  {
    this(null);
  }
  
  public TemporaryFolder(File paramFile)
  {
    this.parentFolder = paramFile;
  }
  
  private File createTemporaryFolderIn(File paramFile)
    throws IOException
  {
    paramFile = File.createTempFile("junit", "", paramFile);
    paramFile.delete();
    paramFile.mkdir();
    return paramFile;
  }
  
  private boolean isLastElementInArray(int paramInt, String[] paramArrayOfString)
  {
    return paramInt == paramArrayOfString.length - 1;
  }
  
  private void recursiveDelete(File paramFile)
  {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        recursiveDelete(arrayOfFile[i]);
        i += 1;
      }
    }
    paramFile.delete();
  }
  
  private void validateFolderName(String paramString)
    throws IOException
  {
    if (new File(paramString).getParent() == null) {
      return;
    }
    throw new IOException("Folder name cannot consist of multiple path components separated by a file separator. Please use newFolder('MyParentFolder','MyFolder') to create hierarchies of folders");
  }
  
  protected void after()
  {
    delete();
  }
  
  protected void before()
    throws Throwable
  {
    create();
  }
  
  public void create()
    throws IOException
  {
    this.folder = createTemporaryFolderIn(this.parentFolder);
  }
  
  public void delete()
  {
    File localFile = this.folder;
    if (localFile != null) {
      recursiveDelete(localFile);
    }
  }
  
  public File getRoot()
  {
    File localFile = this.folder;
    if (localFile != null) {
      return localFile;
    }
    throw new IllegalStateException("the temporary folder has not yet been created");
  }
  
  public File newFile()
    throws IOException
  {
    return File.createTempFile("junit", null, getRoot());
  }
  
  public File newFile(String paramString)
    throws IOException
  {
    Object localObject = new File(getRoot(), paramString);
    if (((File)localObject).createNewFile()) {
      return (File)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("a file with the name '");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("' already exists in the test folder");
    throw new IOException(((StringBuilder)localObject).toString());
  }
  
  public File newFolder()
    throws IOException
  {
    return createTemporaryFolderIn(getRoot());
  }
  
  public File newFolder(String paramString)
    throws IOException
  {
    return newFolder(new String[] { paramString });
  }
  
  public File newFolder(String... paramVarArgs)
    throws IOException
  {
    File localFile = getRoot();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      String str = paramVarArgs[i];
      validateFolderName(str);
      localFile = new File(localFile, str);
      if ((!localFile.mkdir()) && (isLastElementInArray(i, paramVarArgs)))
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("a folder with the name '");
        paramVarArgs.append(str);
        paramVarArgs.append("' already exists");
        throw new IOException(paramVarArgs.toString());
      }
      i += 1;
    }
    return localFile;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\rules\TemporaryFolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */