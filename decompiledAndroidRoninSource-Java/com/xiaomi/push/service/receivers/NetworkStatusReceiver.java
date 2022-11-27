package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NetworkStatusReceiver
  extends BroadcastReceiver
{
  private static int jdField_a_of_type_Int = 1;
  private static BlockingQueue<Runnable> jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue();
  private static ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(jdField_a_of_type_Int, jdField_b_of_type_Int, c, TimeUnit.SECONDS, jdField_a_of_type_JavaUtilConcurrentBlockingQueue);
  private static boolean jdField_a_of_type_Boolean = false;
  private static int jdField_b_of_type_Int = 1;
  private static int c = 2;
  private boolean jdField_b_of_type_Boolean = false;
  
  public NetworkStatusReceiver()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public NetworkStatusReceiver(Object paramObject)
  {
    jdField_a_of_type_Boolean = true;
  }
  
  /* Error */
  private void a(android.content.Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  /* Error */
  public void onReceive(android.content.Context arg1, android.content.Intent arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\receivers\NetworkStatusReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */