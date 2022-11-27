package dji.internal.network;

public class MockRemoteServerController
  extends RemoteServerController
{
  public static MockRemoteServerController getInstance()
  {
    return LazyHolder.INSTANCE;
  }
  
  private static class LazyHolder
  {
    private static final MockRemoteServerController INSTANCE = new MockRemoteServerController(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\network\MockRemoteServerController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */