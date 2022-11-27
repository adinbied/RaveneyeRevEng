package com.facebook.soloader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Process;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public final class SysUtil
{
  private static final byte APK_SIGNATURE_VERSION = 1;
  private static final String TAG = "SysUtil";
  
  static int copyBytes(RandomAccessFile paramRandomAccessFile, InputStream paramInputStream, int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    int i = 0;
    while (i < paramInt)
    {
      int j = paramInputStream.read(paramArrayOfByte, 0, Math.min(paramArrayOfByte.length, paramInt - i));
      if (j == -1) {
        break;
      }
      paramRandomAccessFile.write(paramArrayOfByte, 0, j);
      i += j;
    }
    return i;
  }
  
  public static void deleteOrThrow(File paramFile)
    throws IOException
  {
    if (paramFile.delete()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("could not delete file ");
    localStringBuilder.append(paramFile);
    throw new IOException(localStringBuilder.toString());
  }
  
  public static void dumbDeleteRecursive(File paramFile)
    throws IOException
  {
    Object localObject;
    if (paramFile.isDirectory())
    {
      localObject = paramFile.listFiles();
      if (localObject == null) {
        return;
      }
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        dumbDeleteRecursive(localObject[i]);
        i += 1;
      }
    }
    if (!paramFile.delete())
    {
      if (!paramFile.exists()) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("could not delete: ");
      ((StringBuilder)localObject).append(paramFile);
      throw new IOException(((StringBuilder)localObject).toString());
    }
  }
  
  public static void fallocateIfSupported(FileDescriptor paramFileDescriptor, long paramLong)
    throws IOException
  {
    if (Build.VERSION.SDK_INT >= 21) {
      LollipopSysdeps.fallocateIfSupported(paramFileDescriptor, paramLong);
    }
  }
  
  public static int findAbiScore(String[] paramArrayOfString, String paramString)
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      if ((paramArrayOfString[i] != null) && (paramString.equals(paramArrayOfString[i]))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  /* Error */
  static void fsyncRecursive(File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 76	java/io/File:isDirectory	()Z
    //   4: ifeq +66 -> 70
    //   7: aload_0
    //   8: invokevirtual 80	java/io/File:listFiles	()[Ljava/io/File;
    //   11: astore_2
    //   12: aload_2
    //   13: ifnull +24 -> 37
    //   16: iconst_0
    //   17: istore_1
    //   18: iload_1
    //   19: aload_2
    //   20: arraylength
    //   21: if_icmpge +84 -> 105
    //   24: aload_2
    //   25: iload_1
    //   26: aaload
    //   27: invokestatic 108	com/facebook/soloader/SysUtil:fsyncRecursive	(Ljava/io/File;)V
    //   30: iload_1
    //   31: iconst_1
    //   32: iadd
    //   33: istore_1
    //   34: goto -16 -> 18
    //   37: new 55	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   44: astore_2
    //   45: aload_2
    //   46: ldc 110
    //   48: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_2
    //   53: aload_0
    //   54: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: new 26	java/io/IOException
    //   61: dup
    //   62: aload_2
    //   63: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokespecial 72	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   69: athrow
    //   70: aload_0
    //   71: invokevirtual 113	java/io/File:getPath	()Ljava/lang/String;
    //   74: ldc 115
    //   76: invokevirtual 119	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   79: ifeq +4 -> 83
    //   82: return
    //   83: new 40	java/io/RandomAccessFile
    //   86: dup
    //   87: aload_0
    //   88: ldc 121
    //   90: invokespecial 124	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   93: astore_3
    //   94: aload_3
    //   95: invokevirtual 128	java/io/RandomAccessFile:getFD	()Ljava/io/FileDescriptor;
    //   98: invokevirtual 133	java/io/FileDescriptor:sync	()V
    //   101: aload_3
    //   102: invokevirtual 136	java/io/RandomAccessFile:close	()V
    //   105: return
    //   106: astore_0
    //   107: aload_0
    //   108: athrow
    //   109: astore_2
    //   110: aload_3
    //   111: invokevirtual 136	java/io/RandomAccessFile:close	()V
    //   114: goto +9 -> 123
    //   117: astore_3
    //   118: aload_0
    //   119: aload_3
    //   120: invokevirtual 142	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   123: aload_2
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramFile	File
    //   17	17	1	i	int
    //   11	52	2	localObject1	Object
    //   109	15	2	localObject2	Object
    //   93	18	3	localRandomAccessFile	RandomAccessFile
    //   117	3	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   94	101	106	finally
    //   107	109	109	finally
    //   110	114	117	finally
  }
  
  public static int getAppVersionCode(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager != null) {}
    try
    {
      int i = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException|RuntimeException paramContext) {}
    return 0;
    return 0;
  }
  
  public static String[] getSupportedAbis()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return MarshmallowSysdeps.getSupportedAbis();
    }
    if (Build.VERSION.SDK_INT >= 21) {
      return LollipopSysdeps.getSupportedAbis();
    }
    return new String[] { Build.CPU_ABI, Build.CPU_ABI2 };
  }
  
  public static boolean is64Bit()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return MarshmallowSysdeps.is64Bit();
    }
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        boolean bool = LollipopSysdeps.is64Bit();
        return bool;
      }
      catch (Exception localException)
      {
        Log.e("SysUtil", String.format("Could not read /proc/self/exe. Err msg: %s", new Object[] { localException.getMessage() }));
      }
    }
    return false;
  }
  
  public static byte[] makeApkDepBlock(File paramFile, Context paramContext)
    throws IOException
  {
    File localFile = paramFile.getCanonicalFile();
    paramFile = Parcel.obtain();
    try
    {
      paramFile.writeByte((byte)1);
      paramFile.writeString(localFile.getPath());
      paramFile.writeLong(localFile.lastModified());
      paramFile.writeInt(getAppVersionCode(paramContext));
      paramContext = paramFile.marshall();
      return paramContext;
    }
    finally
    {
      paramFile.recycle();
    }
  }
  
  static void mkdirOrThrow(File paramFile)
    throws IOException
  {
    if (!paramFile.mkdirs())
    {
      if (paramFile.isDirectory()) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cannot mkdir: ");
      localStringBuilder.append(paramFile);
      throw new IOException(localStringBuilder.toString());
    }
  }
  
  private static final class LollipopSysdeps
  {
    public static void fallocateIfSupported(FileDescriptor paramFileDescriptor, long paramLong)
      throws IOException
    {
      try
      {
        Os.posix_fallocate(paramFileDescriptor, 0L, paramLong);
        return;
      }
      catch (ErrnoException paramFileDescriptor)
      {
        if ((paramFileDescriptor.errno != OsConstants.EOPNOTSUPP) && (paramFileDescriptor.errno != OsConstants.ENOSYS))
        {
          if (paramFileDescriptor.errno == OsConstants.EINVAL) {
            return;
          }
          throw new IOException(paramFileDescriptor.toString(), paramFileDescriptor);
        }
      }
    }
    
    public static String[] getSupportedAbis()
    {
      String[] arrayOfString = Build.SUPPORTED_ABIS;
      TreeSet localTreeSet = new TreeSet();
      int i = 0;
      try
      {
        if (is64Bit())
        {
          localTreeSet.add(MinElf.ISA.AARCH64.toString());
          localTreeSet.add(MinElf.ISA.X86_64.toString());
        }
        else
        {
          localTreeSet.add(MinElf.ISA.ARM.toString());
          localTreeSet.add(MinElf.ISA.X86.toString());
        }
        ArrayList localArrayList = new ArrayList();
        int j = arrayOfString.length;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (localTreeSet.contains(str)) {
            localArrayList.add(str);
          }
          i += 1;
        }
        return (String[])localArrayList.toArray(new String[localArrayList.size()]);
      }
      catch (ErrnoException localErrnoException)
      {
        Log.e("SysUtil", String.format("Could not read /proc/self/exe. Falling back to default ABI list: %s. errno: %d Err msg: %s", new Object[] { Arrays.toString(arrayOfString), Integer.valueOf(localErrnoException.errno), localErrnoException.getMessage() }));
      }
      return Build.SUPPORTED_ABIS;
    }
    
    public static boolean is64Bit()
      throws ErrnoException
    {
      return Os.readlink("/proc/self/exe").contains("64");
    }
  }
  
  private static final class MarshmallowSysdeps
  {
    public static String[] getSupportedAbis()
    {
      String[] arrayOfString = Build.SUPPORTED_ABIS;
      TreeSet localTreeSet = new TreeSet();
      if (is64Bit())
      {
        localTreeSet.add(MinElf.ISA.AARCH64.toString());
        localTreeSet.add(MinElf.ISA.X86_64.toString());
      }
      else
      {
        localTreeSet.add(MinElf.ISA.ARM.toString());
        localTreeSet.add(MinElf.ISA.X86.toString());
      }
      ArrayList localArrayList = new ArrayList();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (localTreeSet.contains(str)) {
          localArrayList.add(str);
        }
        i += 1;
      }
      return (String[])localArrayList.toArray(new String[localArrayList.size()]);
    }
    
    public static boolean is64Bit()
    {
      return Process.is64Bit();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\soloader\SysUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */