package dji.thirdparty.okhttp3.internal.framed;

public final class Settings
{
  static final int CLIENT_CERTIFICATE_VECTOR_SIZE = 8;
  static final int COUNT = 10;
  static final int CURRENT_CWND = 5;
  static final int DEFAULT_INITIAL_WINDOW_SIZE = 65536;
  static final int DOWNLOAD_BANDWIDTH = 2;
  static final int DOWNLOAD_RETRANS_RATE = 6;
  static final int ENABLE_PUSH = 2;
  static final int FLAG_CLEAR_PREVIOUSLY_PERSISTED_SETTINGS = 1;
  static final int FLOW_CONTROL_OPTIONS = 10;
  static final int FLOW_CONTROL_OPTIONS_DISABLED = 1;
  static final int HEADER_TABLE_SIZE = 1;
  static final int INITIAL_WINDOW_SIZE = 7;
  static final int MAX_CONCURRENT_STREAMS = 4;
  static final int MAX_FRAME_SIZE = 5;
  static final int MAX_HEADER_LIST_SIZE = 6;
  static final int PERSISTED = 2;
  static final int PERSIST_VALUE = 1;
  static final int ROUND_TRIP_TIME = 3;
  static final int UPLOAD_BANDWIDTH = 1;
  private int persistValue;
  private int persisted;
  private int set;
  private final int[] values = new int[10];
  
  /* Error */
  void clear()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  int flags(int paramInt)
  {
    return 0;
  }
  
  int get(int paramInt)
  {
    return this.values[paramInt];
  }
  
  int getClientCertificateVectorSize(int paramInt)
  {
    return 0;
  }
  
  int getCurrentCwnd(int paramInt)
  {
    return 0;
  }
  
  int getDownloadBandwidth(int paramInt)
  {
    return 0;
  }
  
  int getDownloadRetransRate(int paramInt)
  {
    return 0;
  }
  
  boolean getEnablePush(boolean paramBoolean)
  {
    return false;
  }
  
  int getHeaderTableSize()
  {
    return 0;
  }
  
  int getInitialWindowSize(int paramInt)
  {
    return 0;
  }
  
  int getMaxConcurrentStreams(int paramInt)
  {
    return 0;
  }
  
  int getMaxFrameSize(int paramInt)
  {
    return 0;
  }
  
  int getMaxHeaderListSize(int paramInt)
  {
    return 0;
  }
  
  int getRoundTripTime(int paramInt)
  {
    return 0;
  }
  
  int getUploadBandwidth(int paramInt)
  {
    return 0;
  }
  
  boolean isFlowControlDisabled()
  {
    return false;
  }
  
  boolean isPersisted(int paramInt)
  {
    return false;
  }
  
  boolean isSet(int paramInt)
  {
    return false;
  }
  
  /* Error */
  void merge(Settings arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  boolean persistValue(int paramInt)
  {
    return false;
  }
  
  Settings set(int paramInt1, int paramInt2, int paramInt3)
  {
    return null;
  }
  
  int size()
  {
    return Integer.bitCount(this.set);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\framed\Settings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */