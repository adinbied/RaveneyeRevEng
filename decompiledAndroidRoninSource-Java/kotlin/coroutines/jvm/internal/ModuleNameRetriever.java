package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\"\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\016\n\002\b\002\bÂ\002\030\0002\0020\001:\001\013B\007\b\002¢\006\002\020\002J\020\020\006\032\0020\0042\006\020\007\032\0020\bH\002J\020\020\t\032\004\030\0010\n2\006\020\007\032\0020\bR\024\020\003\032\004\030\0010\0048\006@\006X\016¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000¨\006\f"}, d2={"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "()V", "cache", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "notOnJava9", "buildCache", "continuation", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getModuleName", "", "Cache", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
final class ModuleNameRetriever
{
  public static final ModuleNameRetriever INSTANCE = new ModuleNameRetriever();
  public static Cache cache;
  private static final Cache notOnJava9 = new Cache(null, null, null);
  
  private final Cache buildCache(BaseContinuationImpl paramBaseContinuationImpl)
  {
    try
    {
      paramBaseContinuationImpl = new Cache(Class.class.getDeclaredMethod("getModule", new Class[0]), paramBaseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), paramBaseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
      cache = paramBaseContinuationImpl;
      return paramBaseContinuationImpl;
    }
    catch (Exception paramBaseContinuationImpl)
    {
      for (;;) {}
    }
    paramBaseContinuationImpl = notOnJava9;
    cache = paramBaseContinuationImpl;
    return paramBaseContinuationImpl;
  }
  
  public final String getModuleName(BaseContinuationImpl paramBaseContinuationImpl)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseContinuationImpl, "continuation");
    Object localObject1 = cache;
    if (localObject1 == null) {
      localObject1 = buildCache(paramBaseContinuationImpl);
    }
    Object localObject2 = notOnJava9;
    Object localObject4 = null;
    Object localObject3 = null;
    if (localObject1 == localObject2) {
      return null;
    }
    Method localMethod = ((Cache)localObject1).getModuleMethod;
    localObject2 = localObject4;
    if (localMethod != null)
    {
      paramBaseContinuationImpl = localMethod.invoke(paramBaseContinuationImpl.getClass(), new Object[0]);
      localObject2 = localObject4;
      if (paramBaseContinuationImpl != null)
      {
        localMethod = ((Cache)localObject1).getDescriptorMethod;
        localObject2 = localObject4;
        if (localMethod != null)
        {
          paramBaseContinuationImpl = localMethod.invoke(paramBaseContinuationImpl, new Object[0]);
          localObject2 = localObject4;
          if (paramBaseContinuationImpl != null)
          {
            localObject1 = ((Cache)localObject1).nameMethod;
            if (localObject1 != null) {
              paramBaseContinuationImpl = ((Method)localObject1).invoke(paramBaseContinuationImpl, new Object[0]);
            } else {
              paramBaseContinuationImpl = null;
            }
            if (!(paramBaseContinuationImpl instanceof String)) {
              paramBaseContinuationImpl = (BaseContinuationImpl)localObject3;
            }
            localObject2 = (String)paramBaseContinuationImpl;
          }
        }
      }
    }
    return (String)localObject2;
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\004\b\002\030\0002\0020\001B#\022\b\020\002\032\004\030\0010\003\022\b\020\004\032\004\030\0010\003\022\b\020\005\032\004\030\0010\003¢\006\002\020\006R\022\020\004\032\004\030\0010\0038\006X\004¢\006\002\n\000R\022\020\002\032\004\030\0010\0038\006X\004¢\006\002\n\000R\022\020\005\032\004\030\0010\0038\006X\004¢\006\002\n\000¨\006\007"}, d2={"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "", "getModuleMethod", "Ljava/lang/reflect/Method;", "getDescriptorMethod", "nameMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
  private static final class Cache
  {
    public final Method getDescriptorMethod;
    public final Method getModuleMethod;
    public final Method nameMethod;
    
    public Cache(Method paramMethod1, Method paramMethod2, Method paramMethod3)
    {
      this.getModuleMethod = paramMethod1;
      this.getDescriptorMethod = paramMethod2;
      this.nameMethod = paramMethod3;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\jvm\internal\ModuleNameRetriever.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */