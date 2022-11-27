package dji.thirdparty.okhttp3.internal.framed;

import dji.thirdparty.okio.Buffer;
import dji.thirdparty.okio.BufferedSource;
import dji.thirdparty.okio.ByteString;
import dji.thirdparty.okio.Okio;
import dji.thirdparty.okio.Source;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class Hpack
{
  private static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX = nameToFirstIndex();
  private static final int PREFIX_4_BITS = 15;
  private static final int PREFIX_5_BITS = 31;
  private static final int PREFIX_6_BITS = 63;
  private static final int PREFIX_7_BITS = 127;
  private static final Header[] STATIC_HEADER_TABLE = { new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, "GET"), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, "/"), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, "http"), new Header(Header.TARGET_SCHEME, "https"), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "") };
  
  private static ByteString checkLowercase(ByteString paramByteString)
    throws IOException
  {
    int j = paramByteString.size();
    int i = 0;
    while (i < j)
    {
      int k = paramByteString.getByte(i);
      if ((k >= 65) && (k <= 90))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PROTOCOL_ERROR response malformed: mixed case name: ");
        localStringBuilder.append(paramByteString.utf8());
        throw new IOException(localStringBuilder.toString());
      }
      i += 1;
    }
    return paramByteString;
  }
  
  private static Map<ByteString, Integer> nameToFirstIndex()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
    int i = 0;
    for (;;)
    {
      Header[] arrayOfHeader = STATIC_HEADER_TABLE;
      if (i >= arrayOfHeader.length) {
        break;
      }
      if (!localLinkedHashMap.containsKey(arrayOfHeader[i].name)) {
        localLinkedHashMap.put(STATIC_HEADER_TABLE[i].name, Integer.valueOf(i));
      }
      i += 1;
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  static final class Reader
  {
    Header[] dynamicTable;
    int dynamicTableByteCount;
    int headerCount;
    private final List<Header> headerList = new ArrayList();
    private int headerTableSizeSetting;
    private int maxDynamicTableByteCount;
    int nextHeaderIndex;
    private final BufferedSource source;
    
    Reader(int paramInt, Source paramSource)
    {
      Header[] arrayOfHeader = new Header[8];
      this.dynamicTable = arrayOfHeader;
      this.nextHeaderIndex = (arrayOfHeader.length - 1);
      this.headerCount = 0;
      this.dynamicTableByteCount = 0;
      this.headerTableSizeSetting = paramInt;
      this.maxDynamicTableByteCount = paramInt;
      this.source = Okio.buffer(paramSource);
    }
    
    /* Error */
    private void adjustDynamicTableByteCount()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void clearDynamicTable()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    private int dynamicTableIndex(int paramInt)
    {
      return this.nextHeaderIndex + 1 + paramInt;
    }
    
    private int evictToRecoverBytes(int paramInt)
    {
      return 0;
    }
    
    private ByteString getName(int paramInt)
    {
      return null;
    }
    
    /* Error */
    private void insertIntoDynamicTable(int arg1, Header arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    private boolean isStaticHeader(int paramInt)
    {
      return false;
    }
    
    private int readByte()
      throws IOException
    {
      return 0;
    }
    
    /* Error */
    private void readIndexedHeader(int arg1)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void readLiteralHeaderWithIncrementalIndexingIndexedName(int arg1)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void readLiteralHeaderWithIncrementalIndexingNewName()
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void readLiteralHeaderWithoutIndexingIndexedName(int arg1)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void readLiteralHeaderWithoutIndexingNewName()
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public List<Header> getAndResetHeaderList()
    {
      return null;
    }
    
    void headerTableSizeSetting(int paramInt)
    {
      this.headerTableSizeSetting = paramInt;
      this.maxDynamicTableByteCount = paramInt;
      adjustDynamicTableByteCount();
    }
    
    int maxDynamicTableByteCount()
    {
      return this.maxDynamicTableByteCount;
    }
    
    ByteString readByteString()
      throws IOException
    {
      return null;
    }
    
    /* Error */
    void readHeaders()
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    int readInt(int paramInt1, int paramInt2)
      throws IOException
    {
      return 0;
    }
  }
  
  static final class Writer
  {
    private final Buffer out;
    
    Writer(Buffer paramBuffer)
    {
      this.out = paramBuffer;
    }
    
    /* Error */
    void writeByteString(ByteString arg1)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void writeHeaders(List<Header> arg1)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void writeInt(int arg1, int arg2, int arg3)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore 4
      //   3: goto -3 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\framed\Hpack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */