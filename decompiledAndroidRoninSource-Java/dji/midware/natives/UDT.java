package dji.midware.natives;

import dji.log.DJILog;
import dji.midware.wifi.DJIMultiNetworkMgr;

public class UDT
{
  private static final String TAG = "UDT";
  private static int sSocketFd;
  
  static
  {
    try
    {
      DJILog.d("FPVController", "try to load udt.so", new Object[0]);
      System.loadLibrary("udt");
      System.loadLibrary("udtjni");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;) {}
    }
    DJILog.e("UDT", "Couldn't load lib", new Object[0]);
  }
  
  public static native void SwUdpClose();
  
  public static native int SwUdpConnect(String paramString, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public static native boolean SwUdpIsConnected();
  
  public static native boolean SwUdpIsPortOccupied();
  
  public static native int SwUdpJoyStickSend(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native int SwUdpSend(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native void SwUdpStop();
  
  public static void bindSocketToNetwork(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" bindSocketToNetwork socketfd: ");
    localStringBuilder.append(paramInt);
    DJILog.d("UDT", localStringBuilder.toString(), new Object[0]);
    DJIMultiNetworkMgr.getInstance().bindSocketWithWIFI(paramInt);
  }
  
  public static synchronized native int cleanup();
  
  public static native int close(int paramInt);
  
  public static native int connect(int paramInt, String paramString1, String paramString2);
  
  public static native int connectWithLocal(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public static int getSocketFd()
  {
    return sSocketFd;
  }
  
  public static void loadLibrary() {}
  
  public static native int recv(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4);
  
  public static native int recvmsg(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
  
  public static native int send(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4);
  
  public static native int sendmsg(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
  
  public static native void setSwRecver(Object paramObject);
  
  public static native int socket();
  
  public static native int socketDgram();
  
  public static synchronized native int startup();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\natives\UDT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */