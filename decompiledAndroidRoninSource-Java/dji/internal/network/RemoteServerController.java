package dji.internal.network;

import android.content.Context;

public class RemoteServerController
{
  private static final String TAG = "RemoteServerController";
  private static boolean isDJIBlocked;
  private static RemoteService remoteService;
  private Context context;
  
  protected RemoteServerController()
  {
    remoteService = RemoteService.getInstance();
  }
  
  public static void checkIsDJIBlocked()
  {
    new Thread(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    }).start();
  }
  
  public static RemoteServerController getInstance()
  {
    
    if ("release".toLowerCase().equals("mock")) {
      return MockRemoteServerController.getInstance();
    }
    return LazyHolder.INSTANCE;
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void getCountryCodeByGPSCoordinate(double arg1, double arg3, BaseRemoteService.SDKRemoteServiceCallback arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore 5
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void getCountryCodeByIPAddress(BaseRemoteService.SDKRemoteServiceCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void getFlagsFromServer(String arg1, String arg2, String arg3, String arg4, String arg5, BaseRemoteService.SDKRemoteServiceCallback arg6)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void init(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public boolean isOnline(Context paramContext)
  {
    return false;
  }
  
  /* Error */
  public void sendToServer(java.util.List<DJIAnalyticsEvent> arg1, BaseRemoteService.SDKRemoteServiceCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void uploadLogZipFile(String arg1, String arg2, String arg3, BaseRemoteService.SDKRemoteServiceCallback arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static class LazyHolder
  {
    private static final RemoteServerController INSTANCE = new RemoteServerController();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\network\RemoteServerController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */