package com.xiaomi.clientreport.manager;

import android.content.Context;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class a
{
  private static volatile a jdField_a_of_type_ComXiaomiClientreportManagerA;
  private Context jdField_a_of_type_AndroidContentContext;
  private Config jdField_a_of_type_ComXiaomiClientreportDataConfig;
  private IEventProcessor jdField_a_of_type_ComXiaomiClientreportProcessorIEventProcessor;
  private IPerfProcessor jdField_a_of_type_ComXiaomiClientreportProcessorIPerfProcessor;
  private HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
  private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> b = new HashMap();
  
  private a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static a a(Context paramContext)
  {
    if (jdField_a_of_type_ComXiaomiClientreportManagerA == null) {
      try
      {
        if (jdField_a_of_type_ComXiaomiClientreportManagerA == null) {
          jdField_a_of_type_ComXiaomiClientreportManagerA = new a(paramContext);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComXiaomiClientreportManagerA;
  }
  
  /* Error */
  private void a(Runnable arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public Config a()
  {
    return null;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void a(Config paramConfig, IEventProcessor paramIEventProcessor, IPerfProcessor paramIPerfProcessor)
  {
    this.jdField_a_of_type_ComXiaomiClientreportDataConfig = paramConfig;
    this.jdField_a_of_type_ComXiaomiClientreportProcessorIEventProcessor = paramIEventProcessor;
    this.jdField_a_of_type_ComXiaomiClientreportProcessorIPerfProcessor = paramIPerfProcessor;
    paramIEventProcessor.setEventMap(this.b);
    this.jdField_a_of_type_ComXiaomiClientreportProcessorIPerfProcessor.setPerfMap(this.jdField_a_of_type_JavaUtilHashMap);
  }
  
  /* Error */
  public void a(com.xiaomi.clientreport.data.EventClientReport arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(com.xiaomi.clientreport.data.PerfClientReport arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(boolean arg1, boolean arg2, long arg3, long arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore 7
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\clientreport\manager\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */