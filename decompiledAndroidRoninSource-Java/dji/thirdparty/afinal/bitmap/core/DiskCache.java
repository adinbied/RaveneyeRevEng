package dji.thirdparty.afinal.bitmap.core;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.zip.Adler32;

public class DiskCache
  implements Closeable
{
  private static final int BH_CHECKSUM = 8;
  private static final int BH_KEY = 0;
  private static final int BH_LENGTH = 16;
  private static final int BH_OFFSET = 12;
  private static final int BLOB_HEADER_SIZE = 20;
  private static final int DATA_HEADER_SIZE = 4;
  private static final int IH_ACTIVE_BYTES = 20;
  private static final int IH_ACTIVE_ENTRIES = 16;
  private static final int IH_ACTIVE_REGION = 12;
  private static final int IH_CHECKSUM = 28;
  private static final int IH_MAGIC = 0;
  private static final int IH_MAX_BYTES = 8;
  private static final int IH_MAX_ENTRIES = 4;
  private static final int IH_VERSION = 24;
  private static final int INDEX_HEADER_SIZE = 32;
  private static final int MAGIC_DATA_FILE = -1121680112;
  private static final int MAGIC_INDEX_FILE = -1289277392;
  private static final String TAG = DiskCache.class.getSimpleName();
  private int mActiveBytes;
  private RandomAccessFile mActiveDataFile;
  private int mActiveEntries;
  private int mActiveHashStart;
  private int mActiveRegion;
  private Adler32 mAdler32 = new Adler32();
  private byte[] mBlobHeader = new byte[20];
  private RandomAccessFile mDataFile0;
  private RandomAccessFile mDataFile1;
  private int mFileOffset;
  private RandomAccessFile mInactiveDataFile;
  private int mInactiveHashStart;
  private MappedByteBuffer mIndexBuffer;
  private FileChannel mIndexChannel;
  private RandomAccessFile mIndexFile;
  private byte[] mIndexHeader = new byte[32];
  private LookupRequest mLookupRequest = new LookupRequest();
  private int mMaxBytes;
  private int mMaxEntries;
  private String mPath;
  private int mSlotOffset;
  private int mVersion;
  
  public DiskCache(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
    throws IOException
  {
    this(paramString, paramInt1, paramInt2, paramBoolean, 0);
  }
  
  public DiskCache(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    throws IOException
  {
    Object localObject = new File(paramString);
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
      throw new IOException("unable to make dirs");
    }
    this.mPath = paramString;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".idx");
    this.mIndexFile = new RandomAccessFile(((StringBuilder)localObject).toString(), "rw");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".0");
    this.mDataFile0 = new RandomAccessFile(((StringBuilder)localObject).toString(), "rw");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".1");
    this.mDataFile1 = new RandomAccessFile(((StringBuilder)localObject).toString(), "rw");
    this.mVersion = paramInt3;
    if ((!paramBoolean) && (loadIndex())) {
      return;
    }
    resetCache(paramInt1, paramInt2);
    if (loadIndex()) {
      return;
    }
    closeAll();
    throw new IOException("unable to load index");
  }
  
  /* Error */
  private void clearHash(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void closeAll()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static void closeSilently(Closeable paramCloseable)
  {
    if (paramCloseable == null) {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    finally {}
  }
  
  private static void deleteFileSilently(String paramString)
  {
    try
    {
      new File(paramString).delete();
      return;
    }
    finally {}
  }
  
  /* Error */
  private void flipRegion()
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean getBlob(RandomAccessFile paramRandomAccessFile, int paramInt, LookupRequest paramLookupRequest)
    throws IOException
  {
    return false;
  }
  
  /* Error */
  private void insertInternal(long arg1, byte[] arg3, int arg4)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  private boolean loadIndex()
  {
    return false;
  }
  
  private boolean lookupInternal(long paramLong, int paramInt)
  {
    return false;
  }
  
  static int readInt(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramArrayOfByte[(paramInt + 1)];
    int k = paramArrayOfByte[(paramInt + 2)];
    return (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  static long readLong(byte[] paramArrayOfByte, int paramInt)
  {
    long l = paramArrayOfByte[(paramInt + 7)] & 0xFF;
    int i = 6;
    while (i >= 0)
    {
      l = l << 8 | paramArrayOfByte[(paramInt + i)] & 0xFF;
      i -= 1;
    }
    return l;
  }
  
  /* Error */
  private void resetCache(int arg1, int arg2)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setActiveVariables()
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateIndexHeader()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static void writeInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = 0;
    int i = paramInt2;
    paramInt2 = j;
    while (paramInt2 < 4)
    {
      paramArrayOfByte[(paramInt1 + paramInt2)] = ((byte)(i & 0xFF));
      i >>= 8;
      paramInt2 += 1;
    }
  }
  
  static void writeLong(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    int i = 0;
    while (i < 8)
    {
      paramArrayOfByte[(paramInt + i)] = ((byte)(int)(0xFF & paramLong));
      paramLong >>= 8;
      i += 1;
    }
  }
  
  int checkSum(byte[] paramArrayOfByte)
  {
    return 0;
  }
  
  int checkSum(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public void close()
  {
    syncAll();
    closeAll();
  }
  
  /* Error */
  public void delete()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  int getActiveCount()
  {
    return 0;
  }
  
  /* Error */
  public void insert(long arg1, byte[] arg3)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public boolean lookup(LookupRequest paramLookupRequest)
    throws IOException
  {
    return false;
  }
  
  public byte[] lookup(long paramLong)
    throws IOException
  {
    return null;
  }
  
  /* Error */
  public void syncAll()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void syncIndex()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static class LookupRequest
  {
    public byte[] buffer;
    public long key;
    public int length;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\bitmap\core\DiskCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */