package okhttp3.internal.http2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

@Metadata(bv={1, 0, 3}, d1={"\000(\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020$\n\002\030\002\n\002\020\b\n\002\b\t\n\002\020\021\n\002\030\002\n\002\b\t\bÆ\002\030\0002\0020\001:\002\030\031B\007\b\002¢\006\002\020\002J\016\020\025\032\0020\0052\006\020\026\032\0020\005J\024\020\027\032\016\022\004\022\0020\005\022\004\022\0020\0060\004H\002R\035\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0060\004¢\006\b\n\000\032\004\b\007\020\bR\016\020\t\032\0020\006XT¢\006\002\n\000R\016\020\n\032\0020\006XT¢\006\002\n\000R\016\020\013\032\0020\006XT¢\006\002\n\000R\016\020\f\032\0020\006XT¢\006\002\n\000R\016\020\r\032\0020\006XT¢\006\002\n\000R\016\020\016\032\0020\006XT¢\006\002\n\000R\031\020\017\032\b\022\004\022\0020\0210\020¢\006\n\n\002\020\024\032\004\b\022\020\023¨\006\032"}, d2={"Lokhttp3/internal/http2/Hpack;", "", "()V", "NAME_TO_FIRST_INDEX", "", "Lokio/ByteString;", "", "getNAME_TO_FIRST_INDEX", "()Ljava/util/Map;", "PREFIX_4_BITS", "PREFIX_5_BITS", "PREFIX_6_BITS", "PREFIX_7_BITS", "SETTINGS_HEADER_TABLE_SIZE", "SETTINGS_HEADER_TABLE_SIZE_LIMIT", "STATIC_HEADER_TABLE", "", "Lokhttp3/internal/http2/Header;", "getSTATIC_HEADER_TABLE", "()[Lokhttp3/internal/http2/Header;", "[Lokhttp3/internal/http2/Header;", "checkLowercase", "name", "nameToFirstIndex", "Reader", "Writer", "okhttp"}, k=1, mv={1, 1, 16})
public final class Hpack
{
  public static final Hpack INSTANCE;
  private static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;
  private static final int PREFIX_4_BITS = 15;
  private static final int PREFIX_5_BITS = 31;
  private static final int PREFIX_6_BITS = 63;
  private static final int PREFIX_7_BITS = 127;
  private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
  private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
  private static final Header[] STATIC_HEADER_TABLE;
  
  static
  {
    Hpack localHpack = new Hpack();
    INSTANCE = localHpack;
    STATIC_HEADER_TABLE = new Header[] { new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, "GET"), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, "/"), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, "http"), new Header(Header.TARGET_SCHEME, "https"), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "") };
    NAME_TO_FIRST_INDEX = localHpack.nameToFirstIndex();
  }
  
  private final Map<ByteString, Integer> nameToFirstIndex()
  {
    Object localObject = new LinkedHashMap(STATIC_HEADER_TABLE.length);
    int j = STATIC_HEADER_TABLE.length;
    int i = 0;
    while (i < j)
    {
      if (!((LinkedHashMap)localObject).containsKey(STATIC_HEADER_TABLE[i].name)) {
        ((Map)localObject).put(STATIC_HEADER_TABLE[i].name, Integer.valueOf(i));
      }
      i += 1;
    }
    localObject = Collections.unmodifiableMap((Map)localObject);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Collections.unmodifiableMap(result)");
    return (Map<ByteString, Integer>)localObject;
  }
  
  public final ByteString checkLowercase(ByteString paramByteString)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "name");
    int j = paramByteString.size();
    int i = 0;
    while (i < j)
    {
      int k = (byte)65;
      int m = (byte)90;
      int n = paramByteString.getByte(i);
      if ((k > n) || (m < n))
      {
        i += 1;
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PROTOCOL_ERROR response malformed: mixed case name: ");
        localStringBuilder.append(paramByteString.utf8());
        throw ((Throwable)new IOException(localStringBuilder.toString()));
      }
    }
    return paramByteString;
  }
  
  public final Map<ByteString, Integer> getNAME_TO_FIRST_INDEX()
  {
    return NAME_TO_FIRST_INDEX;
  }
  
  public final Header[] getSTATIC_HEADER_TABLE()
  {
    return STATIC_HEADER_TABLE;
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000N\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\003\n\002\020\021\n\002\030\002\n\002\b\004\n\002\020!\n\000\n\002\030\002\n\000\n\002\020\002\n\002\b\006\n\002\020 \n\000\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\r\030\0002\0020\001B!\b\007\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\b\b\002\020\006\032\0020\005¢\006\002\020\007J\b\020\022\032\0020\023H\002J\b\020\024\032\0020\023H\002J\020\020\025\032\0020\0052\006\020\026\032\0020\005H\002J\020\020\027\032\0020\0052\006\020\030\032\0020\005H\002J\f\020\031\032\b\022\004\022\0020\n0\032J\020\020\033\032\0020\0342\006\020\026\032\0020\005H\002J\030\020\035\032\0020\0232\006\020\026\032\0020\0052\006\020\036\032\0020\nH\002J\020\020\037\032\0020 2\006\020\026\032\0020\005H\002J\006\020\006\032\0020\005J\b\020!\032\0020\005H\002J\006\020\"\032\0020\034J\006\020#\032\0020\023J\020\020$\032\0020\0232\006\020\026\032\0020\005H\002J\026\020%\032\0020\0052\006\020&\032\0020\0052\006\020'\032\0020\005J\020\020(\032\0020\0232\006\020)\032\0020\005H\002J\b\020*\032\0020\023H\002J\020\020+\032\0020\0232\006\020\026\032\0020\005H\002J\b\020,\032\0020\023H\002R\034\020\b\032\n\022\006\022\004\030\0010\n0\t8\006@\006X\016¢\006\004\n\002\020\013R\022\020\f\032\0020\0058\006@\006X\016¢\006\002\n\000R\022\020\r\032\0020\0058\006@\006X\016¢\006\002\n\000R\024\020\016\032\b\022\004\022\0020\n0\017X\004¢\006\002\n\000R\016\020\004\032\0020\005X\004¢\006\002\n\000R\016\020\006\032\0020\005X\016¢\006\002\n\000R\016\020\020\032\0020\005X\016¢\006\002\n\000R\016\020\002\032\0020\021X\004¢\006\002\n\000¨\006-"}, d2={"Lokhttp3/internal/http2/Hpack$Reader;", "", "source", "Lokio/Source;", "headerTableSizeSetting", "", "maxDynamicTableByteCount", "(Lokio/Source;II)V", "dynamicTable", "", "Lokhttp3/internal/http2/Header;", "[Lokhttp3/internal/http2/Header;", "dynamicTableByteCount", "headerCount", "headerList", "", "nextHeaderIndex", "Lokio/BufferedSource;", "adjustDynamicTableByteCount", "", "clearDynamicTable", "dynamicTableIndex", "index", "evictToRecoverBytes", "bytesToRecover", "getAndResetHeaderList", "", "getName", "Lokio/ByteString;", "insertIntoDynamicTable", "entry", "isStaticHeader", "", "readByte", "readByteString", "readHeaders", "readIndexedHeader", "readInt", "firstByte", "prefixMask", "readLiteralHeaderWithIncrementalIndexingIndexedName", "nameIndex", "readLiteralHeaderWithIncrementalIndexingNewName", "readLiteralHeaderWithoutIndexingIndexedName", "readLiteralHeaderWithoutIndexingNewName", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Reader
  {
    public Header[] dynamicTable;
    public int dynamicTableByteCount;
    public int headerCount;
    private final List<Header> headerList;
    private final int headerTableSizeSetting;
    private int maxDynamicTableByteCount;
    private int nextHeaderIndex;
    private final BufferedSource source;
    
    public Reader(Source paramSource, int paramInt)
    {
      this(paramSource, paramInt, 0, 4, null);
    }
    
    public Reader(Source paramSource, int paramInt1, int paramInt2)
    {
      this.headerTableSizeSetting = paramInt1;
      this.maxDynamicTableByteCount = paramInt2;
      this.headerList = ((List)new ArrayList());
      this.source = Okio.buffer(paramSource);
      paramSource = new Header[8];
      this.dynamicTable = paramSource;
      this.nextHeaderIndex = (paramSource.length - 1);
    }
    
    private final void adjustDynamicTableByteCount()
    {
      int i = this.maxDynamicTableByteCount;
      int j = this.dynamicTableByteCount;
      if (i < j)
      {
        if (i == 0)
        {
          clearDynamicTable();
          return;
        }
        evictToRecoverBytes(j - i);
      }
    }
    
    private final void clearDynamicTable()
    {
      ArraysKt.fill$default(this.dynamicTable, null, 0, 0, 6, null);
      this.nextHeaderIndex = (this.dynamicTable.length - 1);
      this.headerCount = 0;
      this.dynamicTableByteCount = 0;
    }
    
    private final int dynamicTableIndex(int paramInt)
    {
      return this.nextHeaderIndex + 1 + paramInt;
    }
    
    private final int evictToRecoverBytes(int paramInt)
    {
      int i = 0;
      int k = 0;
      if (paramInt > 0)
      {
        i = this.dynamicTable.length - 1;
        int j = paramInt;
        paramInt = k;
        while ((i >= this.nextHeaderIndex) && (j > 0))
        {
          localObject = this.dynamicTable[i];
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          j -= ((Header)localObject).hpackSize;
          this.dynamicTableByteCount -= ((Header)localObject).hpackSize;
          this.headerCount -= 1;
          paramInt += 1;
          i -= 1;
        }
        Object localObject = this.dynamicTable;
        i = this.nextHeaderIndex;
        System.arraycopy(localObject, i + 1, localObject, i + 1 + paramInt, this.headerCount);
        this.nextHeaderIndex += paramInt;
        i = paramInt;
      }
      return i;
    }
    
    private final ByteString getName(int paramInt)
      throws IOException
    {
      if (isStaticHeader(paramInt)) {
        return Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[paramInt].name;
      }
      int i = dynamicTableIndex(paramInt - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
      if (i >= 0)
      {
        localObject = this.dynamicTable;
        if (i < localObject.length)
        {
          localObject = localObject[i];
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          return ((Header)localObject).name;
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Header index too large ");
      ((StringBuilder)localObject).append(paramInt + 1);
      throw ((Throwable)new IOException(((StringBuilder)localObject).toString()));
    }
    
    private final void insertIntoDynamicTable(int paramInt, Header paramHeader)
    {
      this.headerList.add(paramHeader);
      int j = paramHeader.hpackSize;
      int i = j;
      Object localObject;
      if (paramInt != -1)
      {
        localObject = this.dynamicTable[dynamicTableIndex(paramInt)];
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        i = j - ((Header)localObject).hpackSize;
      }
      j = this.maxDynamicTableByteCount;
      if (i > j)
      {
        clearDynamicTable();
        return;
      }
      j = evictToRecoverBytes(this.dynamicTableByteCount + i - j);
      if (paramInt == -1)
      {
        paramInt = this.headerCount;
        localObject = this.dynamicTable;
        if (paramInt + 1 > localObject.length)
        {
          Header[] arrayOfHeader = new Header[localObject.length * 2];
          System.arraycopy(localObject, 0, arrayOfHeader, localObject.length, localObject.length);
          this.nextHeaderIndex = (this.dynamicTable.length - 1);
          this.dynamicTable = arrayOfHeader;
        }
        paramInt = this.nextHeaderIndex;
        this.nextHeaderIndex = (paramInt - 1);
        this.dynamicTable[paramInt] = paramHeader;
        this.headerCount += 1;
      }
      else
      {
        int k = dynamicTableIndex(paramInt);
        this.dynamicTable[(paramInt + (k + j))] = paramHeader;
      }
      this.dynamicTableByteCount += i;
    }
    
    private final boolean isStaticHeader(int paramInt)
    {
      return (paramInt >= 0) && (paramInt <= Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length - 1);
    }
    
    private final int readByte()
      throws IOException
    {
      return Util.and(this.source.readByte(), 255);
    }
    
    private final void readIndexedHeader(int paramInt)
      throws IOException
    {
      if (isStaticHeader(paramInt))
      {
        localObject1 = Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[paramInt];
        this.headerList.add(localObject1);
        return;
      }
      int i = dynamicTableIndex(paramInt - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
      if (i >= 0)
      {
        Object localObject2 = this.dynamicTable;
        if (i < localObject2.length)
        {
          localObject1 = (Collection)this.headerList;
          localObject2 = localObject2[i];
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          ((Collection)localObject1).add(localObject2);
          return;
        }
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Header index too large ");
      ((StringBuilder)localObject1).append(paramInt + 1);
      throw ((Throwable)new IOException(((StringBuilder)localObject1).toString()));
    }
    
    private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int paramInt)
      throws IOException
    {
      insertIntoDynamicTable(-1, new Header(getName(paramInt), readByteString()));
    }
    
    private final void readLiteralHeaderWithIncrementalIndexingNewName()
      throws IOException
    {
      insertIntoDynamicTable(-1, new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
    }
    
    private final void readLiteralHeaderWithoutIndexingIndexedName(int paramInt)
      throws IOException
    {
      ByteString localByteString1 = getName(paramInt);
      ByteString localByteString2 = readByteString();
      this.headerList.add(new Header(localByteString1, localByteString2));
    }
    
    private final void readLiteralHeaderWithoutIndexingNewName()
      throws IOException
    {
      ByteString localByteString1 = Hpack.INSTANCE.checkLowercase(readByteString());
      ByteString localByteString2 = readByteString();
      this.headerList.add(new Header(localByteString1, localByteString2));
    }
    
    public final List<Header> getAndResetHeaderList()
    {
      List localList = CollectionsKt.toList((Iterable)this.headerList);
      this.headerList.clear();
      return localList;
    }
    
    public final int maxDynamicTableByteCount()
    {
      return this.maxDynamicTableByteCount;
    }
    
    public final ByteString readByteString()
      throws IOException
    {
      int j = readByte();
      int i;
      if ((j & 0x80) == 128) {
        i = 1;
      } else {
        i = 0;
      }
      long l = readInt(j, 127);
      if (i != 0)
      {
        Buffer localBuffer = new Buffer();
        Huffman.INSTANCE.decode(this.source, l, (BufferedSink)localBuffer);
        return localBuffer.readByteString();
      }
      return this.source.readByteString(l);
    }
    
    public final void readHeaders()
      throws IOException
    {
      while (!this.source.exhausted())
      {
        int i = Util.and(this.source.readByte(), 255);
        if (i != 128)
        {
          if ((i & 0x80) == 128)
          {
            readIndexedHeader(readInt(i, 127) - 1);
          }
          else if (i == 64)
          {
            readLiteralHeaderWithIncrementalIndexingNewName();
          }
          else if ((i & 0x40) == 64)
          {
            readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(i, 63) - 1);
          }
          else if ((i & 0x20) == 32)
          {
            i = readInt(i, 31);
            this.maxDynamicTableByteCount = i;
            if ((i >= 0) && (i <= this.headerTableSizeSetting))
            {
              adjustDynamicTableByteCount();
            }
            else
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Invalid dynamic table size update ");
              localStringBuilder.append(this.maxDynamicTableByteCount);
              throw ((Throwable)new IOException(localStringBuilder.toString()));
            }
          }
          else if ((i != 16) && (i != 0))
          {
            readLiteralHeaderWithoutIndexingIndexedName(readInt(i, 15) - 1);
          }
          else
          {
            readLiteralHeaderWithoutIndexingNewName();
          }
        }
        else {
          throw ((Throwable)new IOException("index == 0"));
        }
      }
    }
    
    public final int readInt(int paramInt1, int paramInt2)
      throws IOException
    {
      paramInt1 &= paramInt2;
      if (paramInt1 < paramInt2) {
        return paramInt1;
      }
      paramInt1 = 0;
      int i;
      for (;;)
      {
        i = readByte();
        if ((i & 0x80) == 0) {
          break;
        }
        paramInt2 += ((i & 0x7F) << paramInt1);
        paramInt1 += 7;
      }
      return paramInt2 + (i << paramInt1);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000B\n\002\030\002\n\002\020\000\n\000\n\002\020\b\n\000\n\002\020\013\n\000\n\002\030\002\n\002\b\002\n\002\020\021\n\002\030\002\n\002\b\b\n\002\020\002\n\002\b\b\n\002\030\002\n\002\b\002\n\002\020 \n\002\b\005\030\0002\0020\001B#\b\007\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\005\022\006\020\006\032\0020\007¢\006\002\020\bJ\b\020\023\032\0020\024H\002J\b\020\025\032\0020\024H\002J\020\020\026\032\0020\0032\006\020\027\032\0020\003H\002J\020\020\030\032\0020\0242\006\020\031\032\0020\013H\002J\016\020\032\032\0020\0242\006\020\002\032\0020\003J\016\020\033\032\0020\0242\006\020\034\032\0020\035J\024\020\036\032\0020\0242\f\020\037\032\b\022\004\022\0020\0130 J\036\020!\032\0020\0242\006\020\"\032\0020\0032\006\020#\032\0020\0032\006\020$\032\0020\003R\034\020\t\032\n\022\006\022\004\030\0010\0130\n8\006@\006X\016¢\006\004\n\002\020\fR\022\020\r\032\0020\0038\006@\006X\016¢\006\002\n\000R\016\020\016\032\0020\005X\016¢\006\002\n\000R\022\020\017\032\0020\0038\006@\006X\016¢\006\002\n\000R\022\020\002\032\0020\0038\006@\006X\016¢\006\002\n\000R\022\020\020\032\0020\0038\006@\006X\016¢\006\002\n\000R\016\020\021\032\0020\003X\016¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\022\032\0020\003X\016¢\006\002\n\000R\016\020\004\032\0020\005X\004¢\006\002\n\000¨\006%"}, d2={"Lokhttp3/internal/http2/Hpack$Writer;", "", "headerTableSizeSetting", "", "useCompression", "", "out", "Lokio/Buffer;", "(IZLokio/Buffer;)V", "dynamicTable", "", "Lokhttp3/internal/http2/Header;", "[Lokhttp3/internal/http2/Header;", "dynamicTableByteCount", "emitDynamicTableSizeUpdate", "headerCount", "maxDynamicTableByteCount", "nextHeaderIndex", "smallestHeaderTableSizeSetting", "adjustDynamicTableByteCount", "", "clearDynamicTable", "evictToRecoverBytes", "bytesToRecover", "insertIntoDynamicTable", "entry", "resizeHeaderTable", "writeByteString", "data", "Lokio/ByteString;", "writeHeaders", "headerBlock", "", "writeInt", "value", "prefixMask", "bits", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Writer
  {
    public Header[] dynamicTable;
    public int dynamicTableByteCount;
    private boolean emitDynamicTableSizeUpdate;
    public int headerCount;
    public int headerTableSizeSetting;
    public int maxDynamicTableByteCount;
    private int nextHeaderIndex;
    private final Buffer out;
    private int smallestHeaderTableSizeSetting;
    private final boolean useCompression;
    
    public Writer(int paramInt, Buffer paramBuffer)
    {
      this(paramInt, false, paramBuffer, 2, null);
    }
    
    public Writer(int paramInt, boolean paramBoolean, Buffer paramBuffer)
    {
      this.headerTableSizeSetting = paramInt;
      this.useCompression = paramBoolean;
      this.out = paramBuffer;
      this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
      this.maxDynamicTableByteCount = paramInt;
      paramBuffer = new Header[8];
      this.dynamicTable = paramBuffer;
      this.nextHeaderIndex = (paramBuffer.length - 1);
    }
    
    public Writer(Buffer paramBuffer)
    {
      this(0, false, paramBuffer, 3, null);
    }
    
    private final void adjustDynamicTableByteCount()
    {
      int i = this.maxDynamicTableByteCount;
      int j = this.dynamicTableByteCount;
      if (i < j)
      {
        if (i == 0)
        {
          clearDynamicTable();
          return;
        }
        evictToRecoverBytes(j - i);
      }
    }
    
    private final void clearDynamicTable()
    {
      ArraysKt.fill$default(this.dynamicTable, null, 0, 0, 6, null);
      this.nextHeaderIndex = (this.dynamicTable.length - 1);
      this.headerCount = 0;
      this.dynamicTableByteCount = 0;
    }
    
    private final int evictToRecoverBytes(int paramInt)
    {
      int i = 0;
      int k = 0;
      if (paramInt > 0)
      {
        i = this.dynamicTable.length - 1;
        int j = paramInt;
        paramInt = k;
        while ((i >= this.nextHeaderIndex) && (j > 0))
        {
          localObject = this.dynamicTable[i];
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          j -= ((Header)localObject).hpackSize;
          k = this.dynamicTableByteCount;
          localObject = this.dynamicTable[i];
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          this.dynamicTableByteCount = (k - ((Header)localObject).hpackSize);
          this.headerCount -= 1;
          paramInt += 1;
          i -= 1;
        }
        Object localObject = this.dynamicTable;
        i = this.nextHeaderIndex;
        System.arraycopy(localObject, i + 1, localObject, i + 1 + paramInt, this.headerCount);
        localObject = this.dynamicTable;
        i = this.nextHeaderIndex;
        Arrays.fill((Object[])localObject, i + 1, i + 1 + paramInt, null);
        this.nextHeaderIndex += paramInt;
        i = paramInt;
      }
      return i;
    }
    
    private final void insertIntoDynamicTable(Header paramHeader)
    {
      int i = paramHeader.hpackSize;
      int j = this.maxDynamicTableByteCount;
      if (i > j)
      {
        clearDynamicTable();
        return;
      }
      evictToRecoverBytes(this.dynamicTableByteCount + i - j);
      j = this.headerCount;
      Header[] arrayOfHeader1 = this.dynamicTable;
      if (j + 1 > arrayOfHeader1.length)
      {
        Header[] arrayOfHeader2 = new Header[arrayOfHeader1.length * 2];
        System.arraycopy(arrayOfHeader1, 0, arrayOfHeader2, arrayOfHeader1.length, arrayOfHeader1.length);
        this.nextHeaderIndex = (this.dynamicTable.length - 1);
        this.dynamicTable = arrayOfHeader2;
      }
      j = this.nextHeaderIndex;
      this.nextHeaderIndex = (j - 1);
      this.dynamicTable[j] = paramHeader;
      this.headerCount += 1;
      this.dynamicTableByteCount += i;
    }
    
    public final void resizeHeaderTable(int paramInt)
    {
      this.headerTableSizeSetting = paramInt;
      paramInt = Math.min(paramInt, 16384);
      int i = this.maxDynamicTableByteCount;
      if (i == paramInt) {
        return;
      }
      if (paramInt < i) {
        this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, paramInt);
      }
      this.emitDynamicTableSizeUpdate = true;
      this.maxDynamicTableByteCount = paramInt;
      adjustDynamicTableByteCount();
    }
    
    public final void writeByteString(ByteString paramByteString)
      throws IOException
    {
      Intrinsics.checkParameterIsNotNull(paramByteString, "data");
      if ((this.useCompression) && (Huffman.INSTANCE.encodedLength(paramByteString) < paramByteString.size()))
      {
        Buffer localBuffer = new Buffer();
        Huffman.INSTANCE.encode(paramByteString, (BufferedSink)localBuffer);
        paramByteString = localBuffer.readByteString();
        writeInt(paramByteString.size(), 127, 128);
        this.out.write(paramByteString);
        return;
      }
      writeInt(paramByteString.size(), 127, 0);
      this.out.write(paramByteString);
    }
    
    public final void writeHeaders(List<Header> paramList)
      throws IOException
    {
      Intrinsics.checkParameterIsNotNull(paramList, "headerBlock");
      int i;
      if (this.emitDynamicTableSizeUpdate)
      {
        i = this.smallestHeaderTableSizeSetting;
        if (i < this.maxDynamicTableByteCount) {
          writeInt(i, 31, 32);
        }
        this.emitDynamicTableSizeUpdate = false;
        this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
        writeInt(this.maxDynamicTableByteCount, 31, 32);
      }
      int i2 = paramList.size();
      int k = 0;
      while (k < i2)
      {
        Header localHeader = (Header)paramList.get(k);
        ByteString localByteString1 = localHeader.name.toAsciiLowercase();
        ByteString localByteString2 = localHeader.value;
        Object localObject = (Integer)Hpack.INSTANCE.getNAME_TO_FIRST_INDEX().get(localByteString1);
        int j;
        if (localObject != null)
        {
          j = ((Integer)localObject).intValue() + 1;
          if ((2 <= j) && (7 >= j))
          {
            if (Intrinsics.areEqual(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[(j - 1)].value, localByteString2))
            {
              i = j;
              break label216;
            }
            if (Intrinsics.areEqual(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[j].value, localByteString2))
            {
              i = j;
              j += 1;
              break label216;
            }
          }
          i = j;
          j = -1;
        }
        else
        {
          j = -1;
          i = -1;
        }
        label216:
        int n = j;
        int i1 = i;
        if (j == -1)
        {
          int m = this.nextHeaderIndex + 1;
          int i3 = this.dynamicTable.length;
          for (;;)
          {
            n = j;
            i1 = i;
            if (m >= i3) {
              break;
            }
            localObject = this.dynamicTable[m];
            if (localObject == null) {
              Intrinsics.throwNpe();
            }
            n = i;
            if (Intrinsics.areEqual(((Header)localObject).name, localByteString1))
            {
              localObject = this.dynamicTable[m];
              if (localObject == null) {
                Intrinsics.throwNpe();
              }
              if (Intrinsics.areEqual(((Header)localObject).value, localByteString2))
              {
                j = this.nextHeaderIndex;
                n = Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length + (m - j);
                i1 = i;
                break;
              }
              n = i;
              if (i == -1) {
                n = m - this.nextHeaderIndex + Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length;
              }
            }
            m += 1;
            i = n;
          }
        }
        if (n != -1)
        {
          writeInt(n, 127, 128);
        }
        else if (i1 == -1)
        {
          this.out.writeByte(64);
          writeByteString(localByteString1);
          writeByteString(localByteString2);
          insertIntoDynamicTable(localHeader);
        }
        else if ((localByteString1.startsWith(Header.PSEUDO_PREFIX)) && ((Intrinsics.areEqual(Header.TARGET_AUTHORITY, localByteString1) ^ true)))
        {
          writeInt(i1, 15, 0);
          writeByteString(localByteString2);
        }
        else
        {
          writeInt(i1, 63, 64);
          writeByteString(localByteString2);
          insertIntoDynamicTable(localHeader);
        }
        k += 1;
      }
    }
    
    public final void writeInt(int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt1 < paramInt2)
      {
        this.out.writeByte(paramInt1 | paramInt3);
        return;
      }
      this.out.writeByte(paramInt3 | paramInt2);
      paramInt1 -= paramInt2;
      while (paramInt1 >= 128)
      {
        this.out.writeByte(0x80 | paramInt1 & 0x7F);
        paramInt1 >>>= 7;
      }
      this.out.writeByte(paramInt1);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\http2\Hpack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */