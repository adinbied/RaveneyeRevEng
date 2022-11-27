package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;

@Metadata(bv={1, 0, 3}, d1={"\000:\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\000\n\002\020 \n\002\030\002\n\002\b\004\030\000 \0262\0020\001:\002\025\026B5\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003\022\006\020\005\032\0020\003\022\n\020\006\032\006\022\002\b\0030\007\022\n\020\b\032\006\022\002\b\0030\007¢\006\002\020\tJ\020\020\n\032\0020\0132\006\020\f\032\0020\rH\026J(\020\016\032\0020\0132\006\020\f\032\0020\r2\b\020\017\032\004\030\0010\0202\f\020\021\032\b\022\004\022\0020\0230\022H\026J\022\020\024\032\004\030\0010\0202\006\020\f\032\0020\rH\026R\022\020\006\032\006\022\002\b\0030\007X\004¢\006\002\n\000R\016\020\004\032\0020\003X\004¢\006\002\n\000R\016\020\002\032\0020\003X\004¢\006\002\n\000R\016\020\005\032\0020\003X\004¢\006\002\n\000R\022\020\b\032\006\022\002\b\0030\007X\004¢\006\002\n\000¨\006\027"}, d2={"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform;", "Lokhttp3/internal/platform/Platform;", "putMethod", "Ljava/lang/reflect/Method;", "getMethod", "removeMethod", "clientProviderClass", "Ljava/lang/Class;", "serverProviderClass", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V", "afterHandshake", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "configureTlsExtensions", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "getSelectedProtocol", "AlpnProvider", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public final class Jdk8WithJettyBootPlatform
  extends Platform
{
  public static final Companion Companion = new Companion(null);
  private final Class<?> clientProviderClass;
  private final Method getMethod;
  private final Method putMethod;
  private final Method removeMethod;
  private final Class<?> serverProviderClass;
  
  public Jdk8WithJettyBootPlatform(Method paramMethod1, Method paramMethod2, Method paramMethod3, Class<?> paramClass1, Class<?> paramClass2)
  {
    this.putMethod = paramMethod1;
    this.getMethod = paramMethod2;
    this.removeMethod = paramMethod3;
    this.clientProviderClass = paramClass1;
    this.serverProviderClass = paramClass2;
  }
  
  public void afterHandshake(SSLSocket paramSSLSocket)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocket, "sslSocket");
    try
    {
      this.removeMethod.invoke(null, new Object[] { paramSSLSocket });
      return;
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      throw ((Throwable)new AssertionError("failed to remove ALPN", (Throwable)paramSSLSocket));
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      throw ((Throwable)new AssertionError("failed to remove ALPN", (Throwable)paramSSLSocket));
    }
  }
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<? extends Protocol> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocket, "sslSocket");
    Intrinsics.checkParameterIsNotNull(paramList, "protocols");
    Object localObject = Platform.Companion.alpnProtocolNames(paramList);
    try
    {
      paramString = Platform.class.getClassLoader();
      paramList = this.clientProviderClass;
      Class localClass = this.serverProviderClass;
      localObject = (InvocationHandler)new AlpnProvider((List)localObject);
      paramString = Proxy.newProxyInstance(paramString, new Class[] { paramList, localClass }, (InvocationHandler)localObject);
      this.putMethod.invoke(null, new Object[] { paramSSLSocket, paramString });
      return;
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      throw ((Throwable)new AssertionError("failed to set ALPN", (Throwable)paramSSLSocket));
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      throw ((Throwable)new AssertionError("failed to set ALPN", (Throwable)paramSSLSocket));
    }
  }
  
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocket, "sslSocket");
    try
    {
      paramSSLSocket = Proxy.getInvocationHandler(this.getMethod.invoke(null, new Object[] { paramSSLSocket }));
      if (paramSSLSocket != null)
      {
        paramSSLSocket = (AlpnProvider)paramSSLSocket;
        if ((!paramSSLSocket.getUnsupported$okhttp()) && (paramSSLSocket.getSelected$okhttp() == null))
        {
          Platform.log$default(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
          return null;
        }
        if (paramSSLSocket.getUnsupported$okhttp()) {
          return null;
        }
        return paramSSLSocket.getSelected$okhttp();
      }
      throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      throw ((Throwable)new AssertionError("failed to get ALPN selected protocol", (Throwable)paramSSLSocket));
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      throw ((Throwable)new AssertionError("failed to get ALPN selected protocol", (Throwable)paramSSLSocket));
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\0004\n\002\030\002\n\002\030\002\n\000\n\002\020 \n\002\020\016\n\002\b\007\n\002\020\013\n\002\b\005\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\020\021\n\002\b\002\b\002\030\0002\0020\001B\025\b\000\022\f\020\002\032\b\022\004\022\0020\0040\003¢\006\002\020\005J0\020\021\032\004\030\0010\0222\006\020\023\032\0020\0222\006\020\024\032\0020\0252\016\020\026\032\n\022\004\022\0020\022\030\0010\027H\002¢\006\002\020\030R\024\020\002\032\b\022\004\022\0020\0040\003X\004¢\006\002\n\000R\034\020\006\032\004\030\0010\004X\016¢\006\016\n\000\032\004\b\007\020\b\"\004\b\t\020\nR\032\020\013\032\0020\fX\016¢\006\016\n\000\032\004\b\r\020\016\"\004\b\017\020\020¨\006\031"}, d2={"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform$AlpnProvider;", "Ljava/lang/reflect/InvocationHandler;", "protocols", "", "", "(Ljava/util/List;)V", "selected", "getSelected$okhttp", "()Ljava/lang/String;", "setSelected$okhttp", "(Ljava/lang/String;)V", "unsupported", "", "getUnsupported$okhttp", "()Z", "setUnsupported$okhttp", "(Z)V", "invoke", "", "proxy", "method", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "okhttp"}, k=1, mv={1, 1, 16})
  private static final class AlpnProvider
    implements InvocationHandler
  {
    private final List<String> protocols;
    private String selected;
    private boolean unsupported;
    
    public AlpnProvider(List<String> paramList)
    {
      this.protocols = paramList;
    }
    
    public final String getSelected$okhttp()
    {
      return this.selected;
    }
    
    public final boolean getUnsupported$okhttp()
    {
      return this.unsupported;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      Intrinsics.checkParameterIsNotNull(paramObject, "proxy");
      Intrinsics.checkParameterIsNotNull(paramMethod, "method");
      if (paramArrayOfObject == null) {
        paramArrayOfObject = new Object[0];
      }
      paramObject = paramMethod.getName();
      Class localClass = paramMethod.getReturnType();
      if ((Intrinsics.areEqual(paramObject, "supports")) && (Intrinsics.areEqual(Boolean.TYPE, localClass))) {
        return Boolean.valueOf(true);
      }
      if ((Intrinsics.areEqual(paramObject, "unsupported")) && (Intrinsics.areEqual(Void.TYPE, localClass)))
      {
        this.unsupported = true;
        return null;
      }
      int i;
      if (Intrinsics.areEqual(paramObject, "protocols"))
      {
        if (paramArrayOfObject.length == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          return this.protocols;
        }
      }
      if (((Intrinsics.areEqual(paramObject, "selectProtocol")) || (Intrinsics.areEqual(paramObject, "select"))) && (Intrinsics.areEqual(String.class, localClass)) && (paramArrayOfObject.length == 1) && ((paramArrayOfObject[0] instanceof List)))
      {
        paramObject = paramArrayOfObject[0];
        if (paramObject != null)
        {
          paramObject = (List)paramObject;
          int j = ((List)paramObject).size();
          if (j >= 0)
          {
            i = 0;
            for (;;)
            {
              paramMethod = ((List)paramObject).get(i);
              if (paramMethod == null) {
                break;
              }
              paramMethod = (String)paramMethod;
              if (this.protocols.contains(paramMethod))
              {
                this.selected = paramMethod;
                return paramMethod;
              }
              if (i == j) {
                break label256;
              }
              i += 1;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
          }
          label256:
          paramObject = (String)this.protocols.get(0);
          this.selected = ((String)paramObject);
          return paramObject;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<*>");
      }
      if (((Intrinsics.areEqual(paramObject, "protocolSelected")) || (Intrinsics.areEqual(paramObject, "selected"))) && (paramArrayOfObject.length == 1))
      {
        paramObject = paramArrayOfObject[0];
        if (paramObject != null)
        {
          this.selected = ((String)paramObject);
          return null;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
      }
      return paramMethod.invoke(this, Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length));
    }
    
    public final void setSelected$okhttp(String paramString)
    {
      this.selected = paramString;
    }
    
    public final void setUnsupported$okhttp(boolean paramBoolean)
    {
      this.unsupported = paramBoolean;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\b\020\003\032\004\030\0010\004¨\006\005"}, d2={"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform$Companion;", "", "()V", "buildIfSupported", "Lokhttp3/internal/platform/Platform;", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    public final Platform buildIfSupported()
    {
      Object localObject1 = System.getProperty("java.specification.version", "unknown");
      try
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "jvmVersion");
        int i = Integer.parseInt((String)localObject1);
        if (i >= 9) {
          return null;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          try
          {
            localObject1 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("org.eclipse.jetty.alpn.ALPN");
            ((StringBuilder)localObject2).append("$Provider");
            Object localObject4 = Class.forName(((StringBuilder)localObject2).toString(), true, null);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("org.eclipse.jetty.alpn.ALPN");
            ((StringBuilder)localObject2).append("$ClientProvider");
            localObject2 = Class.forName(((StringBuilder)localObject2).toString(), true, null);
            Object localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("org.eclipse.jetty.alpn.ALPN");
            ((StringBuilder)localObject3).append("$ServerProvider");
            localObject3 = Class.forName(((StringBuilder)localObject3).toString(), true, null);
            localObject4 = ((Class)localObject1).getMethod("put", new Class[] { SSLSocket.class, localObject4 });
            Method localMethod = ((Class)localObject1).getMethod("get", new Class[] { SSLSocket.class });
            localObject1 = ((Class)localObject1).getMethod("remove", new Class[] { SSLSocket.class });
            Intrinsics.checkExpressionValueIsNotNull(localObject4, "putMethod");
            Intrinsics.checkExpressionValueIsNotNull(localMethod, "getMethod");
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "removeMethod");
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "clientProviderClass");
            Intrinsics.checkExpressionValueIsNotNull(localObject3, "serverProviderClass");
            localObject1 = (Platform)new Jdk8WithJettyBootPlatform((Method)localObject4, localMethod, (Method)localObject1, (Class)localObject2, (Class)localObject3);
            return (Platform)localObject1;
          }
          catch (ClassNotFoundException|NoSuchMethodException localClassNotFoundException) {}
          localNumberFormatException = localNumberFormatException;
        }
      }
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\platform\Jdk8WithJettyBootPlatform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */