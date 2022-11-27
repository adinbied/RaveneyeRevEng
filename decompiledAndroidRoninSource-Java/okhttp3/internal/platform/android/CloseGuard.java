package okhttp3.internal.platform.android;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000 \n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\005\n\002\020\016\n\000\n\002\020\013\n\002\b\003\b\000\030\000 \r2\0020\001:\001\rB#\022\b\020\002\032\004\030\0010\003\022\b\020\004\032\004\030\0010\003\022\b\020\005\032\004\030\0010\003¢\006\002\020\006J\020\020\007\032\004\030\0010\0012\006\020\b\032\0020\tJ\020\020\n\032\0020\0132\b\020\f\032\004\030\0010\001R\020\020\002\032\004\030\0010\003X\004¢\006\002\n\000R\020\020\004\032\004\030\0010\003X\004¢\006\002\n\000R\020\020\005\032\004\030\0010\003X\004¢\006\002\n\000¨\006\016"}, d2={"Lokhttp3/internal/platform/android/CloseGuard;", "", "getMethod", "Ljava/lang/reflect/Method;", "openMethod", "warnIfOpenMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "createAndOpen", "closer", "", "warnIfOpen", "", "closeGuardInstance", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public final class CloseGuard
{
  public static final Companion Companion = new Companion(null);
  private final Method getMethod;
  private final Method openMethod;
  private final Method warnIfOpenMethod;
  
  public CloseGuard(Method paramMethod1, Method paramMethod2, Method paramMethod3)
  {
    this.getMethod = paramMethod1;
    this.openMethod = paramMethod2;
    this.warnIfOpenMethod = paramMethod3;
  }
  
  public final Object createAndOpen(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "closer");
    Object localObject = this.getMethod;
    if (localObject != null) {}
    try
    {
      localObject = ((Method)localObject).invoke(null, new Object[0]);
      Method localMethod = this.openMethod;
      if (localMethod == null) {
        Intrinsics.throwNpe();
      }
      localMethod.invoke(localObject, new Object[] { paramString });
      return localObject;
    }
    catch (Exception paramString) {}
    return null;
    return null;
  }
  
  public final boolean warnIfOpen(Object paramObject)
  {
    boolean bool = false;
    if (paramObject != null) {}
    try
    {
      Method localMethod = this.warnIfOpenMethod;
      if (localMethod == null) {
        Intrinsics.throwNpe();
      }
      localMethod.invoke(paramObject, new Object[0]);
      bool = true;
      return bool;
    }
    catch (Exception paramObject) {}
    return false;
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\006\020\003\032\0020\004¨\006\005"}, d2={"Lokhttp3/internal/platform/android/CloseGuard$Companion;", "", "()V", "get", "Lokhttp3/internal/platform/android/CloseGuard;", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    public final CloseGuard get()
    {
      try
      {
        localObject1 = Class.forName("dalvik.system.CloseGuard");
        localMethod = ((Class)localObject1).getMethod("get", new Class[0]);
        localObject2 = ((Class)localObject1).getMethod("open", new Class[] { String.class });
        localObject1 = ((Class)localObject1).getMethod("warnIfOpen", new Class[0]);
      }
      catch (Exception localException)
      {
        Object localObject1;
        Method localMethod;
        Object localObject2;
        for (;;) {}
      }
      localMethod = (Method)null;
      localObject1 = localMethod;
      localObject2 = localObject1;
      return new CloseGuard(localMethod, (Method)localObject2, (Method)localObject1);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\platform\android\CloseGuard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */