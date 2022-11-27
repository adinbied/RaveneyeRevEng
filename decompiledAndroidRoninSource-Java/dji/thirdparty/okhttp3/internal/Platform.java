package dji.thirdparty.okhttp3.internal;

import dji.thirdparty.okhttp3.Protocol;
import dji.thirdparty.okhttp3.internal.tls.TrustRootIndex;
import dji.thirdparty.okio.Buffer;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class Platform
{
  private static final Platform PLATFORM = ;
  
  static byte[] concatLengthPrefixed(List<Protocol> paramList)
  {
    Buffer localBuffer = new Buffer();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Protocol localProtocol = (Protocol)paramList.get(i);
      if (localProtocol != Protocol.HTTP_1_0)
      {
        localBuffer.writeByte(localProtocol.toString().length());
        localBuffer.writeUtf8(localProtocol.toString());
      }
      i += 1;
    }
    return localBuffer.readByteArray();
  }
  
  private static Platform findPlatform()
  {
    for (;;)
    {
      try
      {
        localObject2 = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        Object localObject2;
        Object localObject4;
        OptionalMethod localOptionalMethod;
        continue;
      }
      try
      {
        localObject2 = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
      }
      catch (ClassNotFoundException localClassNotFoundException2) {}
    }
    localObject4 = new OptionalMethod(null, "setUseSessionTickets", new Class[] { Boolean.TYPE });
    localOptionalMethod = new OptionalMethod(null, "setHostname", new Class[] { String.class });
    for (;;)
    {
      try
      {
        Class.forName("android.net.Network");
        localObject1 = new OptionalMethod(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
      }
      catch (ClassNotFoundException localClassNotFoundException3)
      {
        Object localObject1;
        Object localObject3;
        continue;
      }
      try
      {
        localObject3 = new OptionalMethod(null, "setAlpnProtocols", new Class[] { byte[].class });
      }
      catch (ClassNotFoundException localClassNotFoundException5) {}
    }
    localObject1 = null;
    localObject3 = null;
    localObject1 = new Android((Class)localObject2, (OptionalMethod)localObject4, localOptionalMethod, (OptionalMethod)localObject1, (OptionalMethod)localObject3);
    return (Platform)localObject1;
    try
    {
      localObject1 = Class.forName("org.eclipse.jetty.alpn.ALPN");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("org.eclipse.jetty.alpn.ALPN");
      ((StringBuilder)localObject2).append("$Provider");
      localObject2 = Class.forName(((StringBuilder)localObject2).toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("org.eclipse.jetty.alpn.ALPN");
      ((StringBuilder)localObject3).append("$ClientProvider");
      localObject3 = Class.forName(((StringBuilder)localObject3).toString());
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("org.eclipse.jetty.alpn.ALPN");
      ((StringBuilder)localObject4).append("$ServerProvider");
      localObject4 = Class.forName(((StringBuilder)localObject4).toString());
      localObject1 = new JdkWithJettyBootPlatform(((Class)localObject1).getMethod("put", new Class[] { SSLSocket.class, localObject2 }), ((Class)localObject1).getMethod("get", new Class[] { SSLSocket.class }), ((Class)localObject1).getMethod("remove", new Class[] { SSLSocket.class }), (Class)localObject3, (Class)localObject4);
      return (Platform)localObject1;
    }
    catch (ClassNotFoundException|NoSuchMethodException localClassNotFoundException4)
    {
      for (;;) {}
    }
    return new Platform();
  }
  
  public static Platform get()
  {
    return PLATFORM;
  }
  
  static <T> T readFieldOrNull(Object paramObject, Class<T> paramClass, String paramString)
  {
    for (Class localClass = paramObject.getClass(); localClass != Object.class; localClass = localClass.getSuperclass())
    {
      try
      {
        Object localObject = localClass.getDeclaredField(paramString);
        ((Field)localObject).setAccessible(true);
        localObject = ((Field)localObject).get(paramObject);
        if (localObject != null)
        {
          if (!paramClass.isInstance(localObject)) {
            return null;
          }
          localObject = paramClass.cast(localObject);
          return (T)localObject;
        }
        return null;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        continue;
      }
      catch (IllegalAccessException paramObject)
      {
        for (;;) {}
      }
      throw new AssertionError();
    }
    if (!paramString.equals("delegate"))
    {
      paramObject = readFieldOrNull(paramObject, Object.class, "delegate");
      if (paramObject != null) {
        return (T)readFieldOrNull(paramObject, paramClass, paramString);
      }
    }
    return null;
  }
  
  public void afterHandshake(SSLSocket paramSSLSocket) {}
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList) {}
  
  public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
    throws IOException
  {
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }
  
  public String getPrefix()
  {
    return "OkHttp";
  }
  
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    return null;
  }
  
  public void log(String paramString)
  {
    System.out.println(paramString);
  }
  
  public void logW(String paramString)
  {
    System.out.println(paramString);
  }
  
  public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
  {
    return null;
  }
  
  public TrustRootIndex trustRootIndex(X509TrustManager paramX509TrustManager)
  {
    return null;
  }
  
  private static class Android
    extends Platform
  {
    private static final int MAX_LOG_LENGTH = 4000;
    private final OptionalMethod<Socket> getAlpnSelectedProtocol;
    private final OptionalMethod<Socket> setAlpnProtocols;
    private final OptionalMethod<Socket> setHostname;
    private final OptionalMethod<Socket> setUseSessionTickets;
    private final Class<?> sslParametersClass;
    
    public Android(Class<?> paramClass, OptionalMethod<Socket> paramOptionalMethod1, OptionalMethod<Socket> paramOptionalMethod2, OptionalMethod<Socket> paramOptionalMethod3, OptionalMethod<Socket> paramOptionalMethod4)
    {
      this.sslParametersClass = paramClass;
      this.setUseSessionTickets = paramOptionalMethod1;
      this.setHostname = paramOptionalMethod2;
      this.getAlpnSelectedProtocol = paramOptionalMethod3;
      this.setAlpnProtocols = paramOptionalMethod4;
    }
    
    /* Error */
    public void configureTlsExtensions(SSLSocket arg1, String arg2, List<Protocol> arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
      throws IOException
    {
      try
      {
        paramSocket.connect(paramInetSocketAddress, paramInt);
        return;
      }
      catch (SecurityException paramSocket)
      {
        paramInetSocketAddress = new IOException("Exception in connect");
        paramInetSocketAddress.initCause(paramSocket);
        throw paramInetSocketAddress;
      }
      catch (AssertionError paramSocket)
      {
        if (Util.isAndroidGetsocknameError(paramSocket)) {
          throw new IOException(paramSocket);
        }
        throw paramSocket;
      }
    }
    
    public String getSelectedProtocol(SSLSocket paramSSLSocket)
    {
      return null;
    }
    
    /* Error */
    public void log(String arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
    {
      return null;
    }
    
    public TrustRootIndex trustRootIndex(X509TrustManager paramX509TrustManager)
    {
      return null;
    }
  }
  
  private static class JdkWithJettyBootPlatform
    extends Platform
  {
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class<?> serverProviderClass;
    
    public JdkWithJettyBootPlatform(Method paramMethod1, Method paramMethod2, Method paramMethod3, Class<?> paramClass1, Class<?> paramClass2)
    {
      this.putMethod = paramMethod1;
      this.getMethod = paramMethod2;
      this.removeMethod = paramMethod3;
      this.clientProviderClass = paramClass1;
      this.serverProviderClass = paramClass2;
    }
    
    /* Error */
    public void afterHandshake(SSLSocket arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void configureTlsExtensions(SSLSocket arg1, String arg2, List<Protocol> arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public String getSelectedProtocol(SSLSocket paramSSLSocket)
    {
      return null;
    }
  }
  
  private static class JettyNegoProvider
    implements InvocationHandler
  {
    private final List<String> protocols;
    private String selected;
    private boolean unsupported;
    
    public JettyNegoProvider(List<String> paramList)
    {
      this.protocols = paramList;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */