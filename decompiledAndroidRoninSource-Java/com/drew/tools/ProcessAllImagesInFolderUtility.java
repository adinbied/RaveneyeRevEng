package com.drew.tools;

import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.exif.ExifThumbnailDirectory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ProcessAllImagesInFolderUtility
{
  public static void main(String[] paramArrayOfString)
    throws IOException, JpegProcessingException
  {
    ArrayList localArrayList = new ArrayList();
    PrintStream localPrintStream = System.out;
    Object localObject = null;
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      String str = paramArrayOfString[i];
      if (str.equalsIgnoreCase("--text"))
      {
        localObject = new TextFileOutputHandler();
      }
      else if (str.equalsIgnoreCase("--markdown"))
      {
        localObject = new MarkdownTableOutputHandler();
      }
      else if (str.equalsIgnoreCase("--unknown"))
      {
        localObject = new UnknownTagHandler();
      }
      else if (str.equalsIgnoreCase("--log-file"))
      {
        if (i == paramArrayOfString.length - 1)
        {
          printUsage();
          System.exit(1);
        }
        i += 1;
        localPrintStream = new PrintStream(new FileOutputStream(paramArrayOfString[i], false), true);
      }
      else
      {
        localArrayList.add(str);
      }
      i += 1;
    }
    if (localArrayList.isEmpty())
    {
      System.err.println("Expects one or more directories as arguments.");
      printUsage();
      System.exit(1);
    }
    paramArrayOfString = (String[])localObject;
    if (localObject == null) {
      paramArrayOfString = new BasicFileHandler();
    }
    long l = System.nanoTime();
    localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      processDirectory(new File((String)((Iterator)localObject).next()), paramArrayOfString, "", localPrintStream);
    }
    paramArrayOfString.onScanCompleted(localPrintStream);
    System.out.println(String.format("Completed in %d ms", new Object[] { Long.valueOf((System.nanoTime() - l) / 1000000L) }));
    if (localPrintStream != System.out) {
      localPrintStream.close();
    }
  }
  
  private static void printUsage()
  {
    System.out.println("Usage:");
    System.out.println();
    System.out.println("  java com.drew.tools.ProcessAllImagesInFolderUtility [--text|--markdown|--unknown] [--log-file <file-name>]");
  }
  
  /* Error */
  private static void processDirectory(File paramFile, FileHandler paramFileHandler, String paramString, PrintStream paramPrintStream)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_0
    //   2: invokeinterface 162 2 0
    //   7: aload_0
    //   8: invokevirtual 166	java/io/File:list	()[Ljava/lang/String;
    //   11: astore 7
    //   13: aload 7
    //   15: ifnonnull +4 -> 19
    //   18: return
    //   19: aload 7
    //   21: invokestatic 172	java/util/Arrays:sort	([Ljava/lang/Object;)V
    //   24: aload 7
    //   26: arraylength
    //   27: istore 5
    //   29: iconst_0
    //   30: istore 4
    //   32: iload 4
    //   34: iload 5
    //   36: if_icmpge +156 -> 192
    //   39: aload 7
    //   41: iload 4
    //   43: aaload
    //   44: astore 6
    //   46: new 118	java/io/File
    //   49: dup
    //   50: aload_0
    //   51: aload 6
    //   53: invokespecial 175	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   56: astore 8
    //   58: aload 8
    //   60: invokevirtual 178	java/io/File:isDirectory	()Z
    //   63: ifeq +64 -> 127
    //   66: aload_2
    //   67: invokevirtual 182	java/lang/String:length	()I
    //   70: ifne +6 -> 76
    //   73: goto +42 -> 115
    //   76: new 184	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   83: astore 9
    //   85: aload 9
    //   87: aload_2
    //   88: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 9
    //   94: ldc -65
    //   96: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 9
    //   102: aload 6
    //   104: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 9
    //   110: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: astore 6
    //   115: aload 8
    //   117: aload_1
    //   118: aload 6
    //   120: aload_3
    //   121: invokestatic 130	com/drew/tools/ProcessAllImagesInFolderUtility:processDirectory	(Ljava/io/File;Lcom/drew/tools/ProcessAllImagesInFolderUtility$FileHandler;Ljava/lang/String;Ljava/io/PrintStream;)V
    //   124: goto +59 -> 183
    //   127: aload_1
    //   128: aload 8
    //   130: invokeinterface 199 2 0
    //   135: ifeq +48 -> 183
    //   138: aload_1
    //   139: aload 8
    //   141: aload_3
    //   142: aload_2
    //   143: invokeinterface 203 4 0
    //   148: aload 8
    //   150: invokestatic 209	com/drew/imaging/ImageMetadataReader:readMetadata	(Ljava/io/File;)Lcom/drew/metadata/Metadata;
    //   153: astore 6
    //   155: aload_1
    //   156: aload 8
    //   158: aload 6
    //   160: aload_2
    //   161: aload_3
    //   162: invokeinterface 213 5 0
    //   167: goto +16 -> 183
    //   170: astore 6
    //   172: aload_1
    //   173: aload 8
    //   175: aload 6
    //   177: aload_3
    //   178: invokeinterface 217 4 0
    //   183: iload 4
    //   185: iconst_1
    //   186: iadd
    //   187: istore 4
    //   189: goto -157 -> 32
    //   192: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramFile	File
    //   0	193	1	paramFileHandler	FileHandler
    //   0	193	2	paramString	String
    //   0	193	3	paramPrintStream	PrintStream
    //   30	158	4	i	int
    //   27	10	5	j	int
    //   44	115	6	localObject	Object
    //   170	6	6	localThrowable	Throwable
    //   11	29	7	arrayOfString	String[]
    //   56	118	8	localFile	File
    //   83	26	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   148	155	170	finally
  }
  
  static class BasicFileHandler
    extends ProcessAllImagesInFolderUtility.FileHandlerBase
  {
    public void onExtractionSuccess(File paramFile, Metadata paramMetadata, String paramString, PrintStream paramPrintStream)
    {
      super.onExtractionSuccess(paramFile, paramMetadata, paramString, paramPrintStream);
      paramFile = paramMetadata.getDirectories().iterator();
      while (paramFile.hasNext())
      {
        paramMetadata = (Directory)paramFile.next();
        paramMetadata.getName();
        paramMetadata = paramMetadata.getTags().iterator();
        while (paramMetadata.hasNext())
        {
          paramString = (Tag)paramMetadata.next();
          paramString.getTagName();
          paramString.getDescription();
        }
      }
    }
  }
  
  static abstract interface FileHandler
  {
    public abstract void onBeforeExtraction(File paramFile, PrintStream paramPrintStream, String paramString);
    
    public abstract void onExtractionError(File paramFile, Throwable paramThrowable, PrintStream paramPrintStream);
    
    public abstract void onExtractionSuccess(File paramFile, Metadata paramMetadata, String paramString, PrintStream paramPrintStream);
    
    public abstract void onScanCompleted(PrintStream paramPrintStream);
    
    public abstract void onStartingDirectory(File paramFile);
    
    public abstract boolean shouldProcess(File paramFile);
  }
  
  static abstract class FileHandlerBase
    implements ProcessAllImagesInFolderUtility.FileHandler
  {
    private int _errorCount = 0;
    private int _exceptionCount = 0;
    private long _processedByteCount = 0L;
    private int _processedFileCount = 0;
    private final Set<String> _supportedExtensions = new HashSet(Arrays.asList(new String[] { "jpg", "jpeg", "png", "gif", "bmp", "ico", "webp", "pcx", "ai", "eps", "nef", "crw", "cr2", "orf", "arw", "raf", "srw", "x3f", "rw2", "rwl", "tif", "tiff", "psd", "dng" }));
    
    protected String getExtension(File paramFile)
    {
      return null;
    }
    
    /* Error */
    public void onBeforeExtraction(File arg1, PrintStream arg2, String arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onExtractionError(File arg1, Throwable arg2, PrintStream arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onExtractionSuccess(File arg1, Metadata arg2, String arg3, PrintStream arg4)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onScanCompleted(PrintStream arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onStartingDirectory(File paramFile) {}
    
    public boolean shouldProcess(File paramFile)
    {
      return false;
    }
  }
  
  static class MarkdownTableOutputHandler
    extends ProcessAllImagesInFolderUtility.FileHandlerBase
  {
    private final Map<String, String> _extensionEquivalence = new HashMap();
    private final Map<String, List<Row>> _rowListByExtension = new HashMap();
    
    public MarkdownTableOutputHandler()
    {
      this._extensionEquivalence.put("jpeg", "jpg");
    }
    
    /* Error */
    private void writeOutput(PrintStream arg1)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onExtractionSuccess(File arg1, Metadata arg2, String arg3, PrintStream arg4)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onScanCompleted(PrintStream arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    static class Row
    {
      private String exifVersion;
      final File file;
      private String makernote;
      private String manufacturer;
      final Metadata metadata;
      private String model;
      final String relativePath;
      private String thumbnail;
      
      Row(File paramFile, Metadata paramMetadata, String paramString)
      {
        this.file = paramFile;
        this.metadata = paramMetadata;
        this.relativePath = paramString;
        paramString = (ExifIFD0Directory)paramMetadata.getFirstDirectoryOfType(ExifIFD0Directory.class);
        ExifSubIFDDirectory localExifSubIFDDirectory = (ExifSubIFDDirectory)paramMetadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
        paramFile = (ExifThumbnailDirectory)paramMetadata.getFirstDirectoryOfType(ExifThumbnailDirectory.class);
        if (paramString != null)
        {
          this.manufacturer = paramString.getDescription(271);
          this.model = paramString.getDescription(272);
        }
        boolean bool;
        if (localExifSubIFDDirectory != null)
        {
          this.exifVersion = localExifSubIFDDirectory.getDescription(36864);
          bool = localExifSubIFDDirectory.containsTag(37500);
        }
        else
        {
          bool = false;
        }
        if (paramFile != null)
        {
          paramString = paramFile.getInteger(256);
          paramFile = paramFile.getInteger(257);
          if ((paramString != null) && (paramFile != null)) {
            paramFile = String.format("Yes (%s x %s)", new Object[] { paramString, paramFile });
          } else {
            paramFile = "Yes";
          }
          this.thumbnail = paramFile;
        }
        paramFile = paramMetadata.getDirectories().iterator();
        while (paramFile.hasNext())
        {
          paramMetadata = (Directory)paramFile.next();
          if (paramMetadata.getClass().getName().contains("Makernote")) {
            this.makernote = paramMetadata.getName().replace("Makernote", "").trim();
          }
        }
        if (this.makernote == null)
        {
          if (bool) {
            paramFile = "(Unknown)";
          } else {
            paramFile = "N/A";
          }
          this.makernote = paramFile;
        }
      }
    }
  }
  
  static class TextFileOutputHandler
    extends ProcessAllImagesInFolderUtility.FileHandlerBase
  {
    private static final String NEW_LINE = "\n";
    
    private static void closeWriter(Writer paramWriter)
      throws IOException
    {
      if (paramWriter != null)
      {
        paramWriter.write("Generated using metadata-extractor\n");
        paramWriter.write("https://drewnoakes.com/code/exif/\n");
        paramWriter.flush();
        paramWriter.close();
      }
    }
    
    private static void deleteRecursively(File paramFile)
    {
      if (paramFile.isDirectory())
      {
        if (paramFile.exists())
        {
          String[] arrayOfString = paramFile.list();
          if (arrayOfString != null)
          {
            int j = arrayOfString.length;
            int i = 0;
            while (i < j)
            {
              File localFile = new File(arrayOfString[i]);
              if (localFile.isDirectory()) {
                deleteRecursively(localFile);
              } else {
                localFile.delete();
              }
              i += 1;
            }
          }
        }
        paramFile.delete();
        return;
      }
      throw new IllegalArgumentException("Must be a directory.");
    }
    
    /* Error */
    private static PrintWriter openWriter(File paramFile)
      throws IOException
    {
      // Byte code:
      //   0: new 41	java/io/File
      //   3: dup
      //   4: ldc 68
      //   6: iconst_1
      //   7: anewarray 70	java/lang/Object
      //   10: dup
      //   11: iconst_0
      //   12: aload_0
      //   13: invokevirtual 74	java/io/File:getParent	()Ljava/lang/String;
      //   16: aastore
      //   17: invokestatic 80	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   20: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
      //   23: astore_1
      //   24: aload_1
      //   25: invokevirtual 48	java/io/File:exists	()Z
      //   28: ifne +8 -> 36
      //   31: aload_1
      //   32: invokevirtual 83	java/io/File:mkdir	()Z
      //   35: pop
      //   36: new 85	java/io/OutputStreamWriter
      //   39: dup
      //   40: new 87	java/io/FileOutputStream
      //   43: dup
      //   44: ldc 89
      //   46: iconst_2
      //   47: anewarray 70	java/lang/Object
      //   50: dup
      //   51: iconst_0
      //   52: aload_0
      //   53: invokevirtual 74	java/io/File:getParent	()Ljava/lang/String;
      //   56: aastore
      //   57: dup
      //   58: iconst_1
      //   59: aload_0
      //   60: invokevirtual 92	java/io/File:getName	()Ljava/lang/String;
      //   63: aastore
      //   64: invokestatic 80	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   67: invokespecial 93	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
      //   70: ldc 95
      //   72: invokespecial 98	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
      //   75: astore_1
      //   76: new 100	java/lang/StringBuilder
      //   79: dup
      //   80: invokespecial 101	java/lang/StringBuilder:<init>	()V
      //   83: astore_2
      //   84: aload_2
      //   85: ldc 103
      //   87: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   90: pop
      //   91: aload_2
      //   92: aload_0
      //   93: invokevirtual 92	java/io/File:getName	()Ljava/lang/String;
      //   96: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   99: pop
      //   100: aload_2
      //   101: ldc 11
      //   103: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   106: pop
      //   107: aload_1
      //   108: aload_2
      //   109: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   112: invokevirtual 28	java/io/Writer:write	(Ljava/lang/String;)V
      //   115: aconst_null
      //   116: astore_2
      //   117: new 112	java/io/BufferedInputStream
      //   120: dup
      //   121: new 114	java/io/FileInputStream
      //   124: dup
      //   125: aload_0
      //   126: invokespecial 116	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   129: invokespecial 119	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   132: astore_0
      //   133: aload_1
      //   134: ldc 121
      //   136: iconst_1
      //   137: anewarray 70	java/lang/Object
      //   140: dup
      //   141: iconst_0
      //   142: aload_0
      //   143: invokestatic 127	com/drew/imaging/FileTypeDetector:detectFileType	(Ljava/io/BufferedInputStream;)Lcom/drew/imaging/FileType;
      //   146: invokevirtual 130	com/drew/imaging/FileType:toString	()Ljava/lang/String;
      //   149: invokevirtual 133	java/lang/String:toUpperCase	()Ljava/lang/String;
      //   152: aastore
      //   153: invokestatic 80	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   156: invokevirtual 28	java/io/Writer:write	(Ljava/lang/String;)V
      //   159: aload_1
      //   160: ldc 11
      //   162: invokevirtual 28	java/io/Writer:write	(Ljava/lang/String;)V
      //   165: aload_0
      //   166: invokevirtual 134	java/io/BufferedInputStream:close	()V
      //   169: new 136	java/io/PrintWriter
      //   172: dup
      //   173: aload_1
      //   174: invokespecial 138	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
      //   177: areturn
      //   178: astore_1
      //   179: goto +6 -> 185
      //   182: astore_1
      //   183: aload_2
      //   184: astore_0
      //   185: aload_0
      //   186: ifnull +7 -> 193
      //   189: aload_0
      //   190: invokevirtual 134	java/io/BufferedInputStream:close	()V
      //   193: aload_1
      //   194: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	195	0	paramFile	File
      //   23	151	1	localObject1	Object
      //   178	1	1	localObject2	Object
      //   182	12	1	localObject3	Object
      //   83	101	2	localStringBuilder	StringBuilder
      // Exception table:
      //   from	to	target	type
      //   133	165	178	finally
      //   117	133	182	finally
    }
    
    private static void writeHierarchyLevel(Metadata paramMetadata, PrintWriter paramPrintWriter, Directory paramDirectory, int paramInt)
    {
      Iterator localIterator = paramMetadata.getDirectories().iterator();
      while (localIterator.hasNext())
      {
        Directory localDirectory = (Directory)localIterator.next();
        if (paramDirectory == null ? localDirectory.getParent() == null : paramDirectory.equals(localDirectory.getParent()))
        {
          int i = 0;
          while (i < paramInt * 4)
          {
            paramPrintWriter.write(32);
            i += 1;
          }
          paramPrintWriter.write("- ");
          paramPrintWriter.write(localDirectory.getName());
          paramPrintWriter.write("\n");
          writeHierarchyLevel(paramMetadata, paramPrintWriter, localDirectory, paramInt + 1);
        }
      }
    }
    
    public void onBeforeExtraction(File paramFile, PrintStream paramPrintStream, String paramString)
    {
      super.onBeforeExtraction(paramFile, paramPrintStream, paramString);
      paramPrintStream.print(paramFile.getAbsoluteFile());
      paramPrintStream.print("\n");
    }
    
    /* Error */
    public void onExtractionError(File arg1, Throwable arg2, PrintStream arg3)
    {
      // Byte code:
      //   0: goto +6 -> 6
      //   3: return
      //   4: astore_1
      //   5: return
      //   6: goto -3 -> 3
    }
    
    /* Error */
    public void onExtractionSuccess(File arg1, Metadata arg2, String arg3, PrintStream arg4)
    {
      // Byte code:
      //   0: goto +6 -> 6
      //   3: return
      //   4: astore_1
      //   5: return
      //   6: goto -3 -> 3
    }
    
    /* Error */
    public void onStartingDirectory(File arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static class UnknownTagHandler
    extends ProcessAllImagesInFolderUtility.FileHandlerBase
  {
    private HashMap<String, HashMap<Integer, Integer>> _occurrenceCountByTagByDirectory = new HashMap();
    
    /* Error */
    public void onExtractionSuccess(File arg1, Metadata arg2, String arg3, PrintStream arg4)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onScanCompleted(PrintStream arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\tools\ProcessAllImagesInFolderUtility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */