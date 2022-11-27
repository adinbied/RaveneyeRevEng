package retrofit2;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

class Platform
{
  private static final Platform PLATFORM = ;
  private final boolean hasJava8Types;
  @Nullable
  private final Constructor<MethodHandles.Lookup> lookupConstructor;
  
  Platform(boolean paramBoolean)
  {
    this.hasJava8Types = paramBoolean;
    Constructor localConstructor2 = null;
    Constructor localConstructor1 = null;
    if (paramBoolean) {
      localConstructor1 = localConstructor2;
    }
    try
    {
      localConstructor2 = MethodHandles.Lookup.class.getDeclaredConstructor(new Class[] { Class.class, Integer.TYPE });
      localConstructor1 = localConstructor2;
      localConstructor2.setAccessible(true);
      localConstructor1 = localConstructor2;
    }
    catch (NoClassDefFoundError|NoSuchMethodException localNoClassDefFoundError)
    {
      for (;;) {}
    }
    this.lookupConstructor = localConstructor1;
  }
  
  private static Platform findPlatform()
  {
    if ("Dalvik".equals(System.getProperty("java.vm.name"))) {
      return new Android();
    }
    return new Platform(true);
  }
  
  static Platform get()
  {
    return PLATFORM;
  }
  
  List<? extends CallAdapter.Factory> defaultCallAdapterFactories(@Nullable Executor paramExecutor)
  {
    paramExecutor = new DefaultCallAdapterFactory(paramExecutor);
    if (this.hasJava8Types) {
      return Arrays.asList(new CallAdapter.Factory[] { CompletableFutureCallAdapterFactory.INSTANCE, paramExecutor });
    }
    return Collections.singletonList(paramExecutor);
  }
  
  int defaultCallAdapterFactoriesSize()
  {
    if (this.hasJava8Types) {
      return 2;
    }
    return 1;
  }
  
  @Nullable
  Executor defaultCallbackExecutor()
  {
    return null;
  }
  
  List<? extends Converter.Factory> defaultConverterFactories()
  {
    if (this.hasJava8Types) {
      return Collections.singletonList(OptionalConverterFactory.INSTANCE);
    }
    return Collections.emptyList();
  }
  
  int defaultConverterFactoriesSize()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @Nullable
  Object invokeDefaultMethod(Method paramMethod, Class<?> paramClass, Object paramObject, Object... paramVarArgs)
    throws Throwable
  {
    Object localObject = this.lookupConstructor;
    if (localObject != null) {
      localObject = (MethodHandles.Lookup)((Constructor)localObject).newInstance(new Object[] { paramClass, Integer.valueOf(-1) });
    } else {
      localObject = MethodHandles.lookup();
    }
    return ((MethodHandles.Lookup)localObject).unreflectSpecial(paramMethod, paramClass).bindTo(paramObject).invokeWithArguments(paramVarArgs);
  }
  
  boolean isDefaultMethod(Method paramMethod)
  {
    return (this.hasJava8Types) && (paramMethod.isDefault());
  }
  
  static final class Android
    extends Platform
  {
    Android()
    {
      super();
    }
    
    public Executor defaultCallbackExecutor()
    {
      return new MainThreadExecutor();
    }
    
    @Nullable
    Object invokeDefaultMethod(Method paramMethod, Class<?> paramClass, Object paramObject, Object... paramVarArgs)
      throws Throwable
    {
      if (Build.VERSION.SDK_INT >= 26) {
        return super.invokeDefaultMethod(paramMethod, paramClass, paramObject, paramVarArgs);
      }
      throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
    }
    
    static final class MainThreadExecutor
      implements Executor
    {
      private final Handler handler = new Handler(Looper.getMainLooper());
      
      public void execute(Runnable paramRunnable)
      {
        this.handler.post(paramRunnable);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\retrofit2\Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */