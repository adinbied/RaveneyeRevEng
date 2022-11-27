package dji.thirdparty.rx.plugins;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class RxJavaPlugins
{
  static final RxJavaErrorHandler DEFAULT_ERROR_HANDLER = new RxJavaErrorHandler() {};
  private static final RxJavaPlugins INSTANCE = new RxJavaPlugins();
  private final AtomicReference<RxJavaErrorHandler> errorHandler = new AtomicReference();
  private final AtomicReference<RxJavaObservableExecutionHook> observableExecutionHook = new AtomicReference();
  private final AtomicReference<RxJavaSchedulersHook> schedulersHook = new AtomicReference();
  private final AtomicReference<RxJavaSingleExecutionHook> singleExecutionHook = new AtomicReference();
  
  public static RxJavaPlugins getInstance()
  {
    return INSTANCE;
  }
  
  static Object getPluginImplementationViaProperty(Class<?> paramClass, Properties paramProperties)
  {
    String str1 = paramClass.getSimpleName();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("rxjava.plugin.");
    ((StringBuilder)localObject1).append(str1);
    ((StringBuilder)localObject1).append(".implementation");
    Object localObject2 = paramProperties.getProperty(((StringBuilder)localObject1).toString());
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      Iterator localIterator = paramProperties.entrySet().iterator();
      String str2;
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (Map.Entry)localIterator.next();
        str2 = ((Map.Entry)localObject1).getKey().toString();
      } while ((!str2.startsWith("rxjava.plugin.")) || (!str2.endsWith(".class")) || (!str1.equals(((Map.Entry)localObject1).getValue().toString())));
      localObject1 = str2.substring(0, str2.length() - 6).substring(14);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("rxjava.plugin.");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(".impl");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = paramProperties.getProperty((String)localObject2);
      if (localObject1 == null)
      {
        paramClass = new StringBuilder();
        paramClass.append("Implementing class declaration for ");
        paramClass.append(str1);
        paramClass.append(" missing: ");
        paramClass.append((String)localObject2);
        throw new RuntimeException(paramClass.toString());
      }
    }
    if (localObject1 != null) {}
    try
    {
      paramClass = Class.forName((String)localObject1).asSubclass(paramClass).newInstance();
      return paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      paramProperties = new StringBuilder();
      paramProperties.append(str1);
      paramProperties.append(" implementation not able to be accessed: ");
      paramProperties.append((String)localObject1);
      throw new RuntimeException(paramProperties.toString(), paramClass);
    }
    catch (InstantiationException paramClass)
    {
      paramProperties = new StringBuilder();
      paramProperties.append(str1);
      paramProperties.append(" implementation not able to be instantiated: ");
      paramProperties.append((String)localObject1);
      throw new RuntimeException(paramProperties.toString(), paramClass);
    }
    catch (ClassNotFoundException paramClass)
    {
      paramProperties = new StringBuilder();
      paramProperties.append(str1);
      paramProperties.append(" implementation class not found: ");
      paramProperties.append((String)localObject1);
      throw new RuntimeException(paramProperties.toString(), paramClass);
      paramClass = new StringBuilder();
      paramClass.append(str1);
      paramClass.append(" implementation is not an instance of ");
      paramClass.append(str1);
      paramClass.append(": ");
      paramClass.append((String)localObject1);
      throw new RuntimeException(paramClass.toString());
      return null;
    }
    catch (ClassCastException paramClass)
    {
      for (;;) {}
    }
  }
  
  public RxJavaErrorHandler getErrorHandler()
  {
    return null;
  }
  
  public RxJavaObservableExecutionHook getObservableExecutionHook()
  {
    return null;
  }
  
  public RxJavaSchedulersHook getSchedulersHook()
  {
    return null;
  }
  
  public RxJavaSingleExecutionHook getSingleExecutionHook()
  {
    return null;
  }
  
  /* Error */
  public void registerErrorHandler(RxJavaErrorHandler arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void registerObservableExecutionHook(RxJavaObservableExecutionHook arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void registerSchedulersHook(RxJavaSchedulersHook arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void registerSingleExecutionHook(RxJavaSingleExecutionHook arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void reset()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\plugins\RxJavaPlugins.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */