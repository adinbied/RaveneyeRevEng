package dji.log;

import android.content.Context;
import android.os.SystemClock;
import dji.log.impl.SimpleConsoleFormat;
import dji.log.impl.SimpleEncryption;
import dji.log.impl.SimpleFileFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class DJILogExample
{
  private static final String DIR = "DJILogExample";
  private static final String TAG = "DJILogExample";
  private String example;
  
  private DJILogExample(String paramString)
  {
    this.example = paramString;
  }
  
  public static void example(Context paramContext)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        DJILogExample.execute(this.val$context);
      }
    }).start();
  }
  
  private static void execute(Context paramContext)
  {
    DJILog.setController(DJILog.newController().priority(6).save(false).warn(2));
    DJILog.init(paramContext, new DJILogFileConfig.Builder(paramContext).setLogTimeFormat("kk:mm:ss.SSS").setEncryption(new SimpleEncryption()).setFileFormat(new SimpleFileFormat()).setPathRoot("/sdcard/DJI/dji.go.v4/").setVersionName("4.3.0").setVersionCode(1000).build(), new DJILogConsoleConfig.Builder(paramContext).setConsoleFormat(new SimpleConsoleFormat()).build());
    DJILog.d("d:use class name as tag", new Object[0]);
    DJILog.d("DJILogExample", "d:assign tag", new Object[0]);
    paramContext = Integer.valueOf(1);
    Object localObject = Float.valueOf(2.0F);
    DJILog.d("DJILogExample", "d:format %d %f %s", new Object[] { paramContext, localObject, "d" });
    DJILog.e("e:use class name as tag", new Object[0]);
    DJILog.e("DJILogExample", "e:assign tag", new Object[0]);
    DJILog.e("DJILogExample", "e:format %d %f %s", new Object[] { paramContext, localObject, "e" });
    DJILog.w("DJILogExample", "w:with throwable", new NullPointerException("there is a null pointer exception"), new Object[0]);
    DJILog.i("DJILogExample", "i:with throwable", new UnsupportedOperationException("the operation is not supported"), new Object[0]);
    DJILog.saveLog("save message");
    DJILog.saveLog("save message", "DJILogExample");
    DJILog.saveExtraLog("save message", "DJILogExample");
    DJILog.logWriteD("DJILogExample", "d & save message", new Object[0]);
    DJILog.logWriteD("DJILogExample", "d & save message in DIR", "DJILogExample", new Object[0]);
    DJILog.logWriteW("DJILogExample", "w & save message", new Object[0]);
    DJILog.logWriteE("DJILogExample", "e & save message in DIR", "DJILogExample", new Object[0]);
    DJILog.logStack();
    DJILog.logStack(2);
    DJILog.logStack("DJILogExample", 4);
    DJILog.saveStack("DJILogExample");
    DJILog.saveStack("DJILogExample", 2);
    DJILog.d("", "tag is empty warn!", new Object[0]);
    DJILog.d("aabbccddeeffgghhiiggkkllmmnnooppqqrrssttuuvvwwxxyyzz", "tag is too long warn", new Object[0]);
    int i = 0;
    while (i < 101)
    {
      DJILog.w("DJILogExampleWarn", "%d", new Object[] { Integer.valueOf(i) });
      i += 1;
    }
    DJILog.countTime("DJILogExample", new DJILog.Callback()
    {
      public void doMethod() {}
    });
    paramContext = new DJILogExample("A");
    localObject = new DJILogExample("B");
    DJILogExample localDJILogExample1 = new DJILogExample("C");
    DJILogExample localDJILogExample2 = new DJILogExample("D");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramContext);
    localArrayList.add(localObject);
    localArrayList.add(localDJILogExample1);
    localArrayList.add(localDJILogExample2);
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramContext.example, paramContext);
    localHashMap.put(((DJILogExample)localObject).example, localObject);
    localHashMap.put(localDJILogExample1.example, localDJILogExample1);
    localHashMap.put(localDJILogExample2.example, localDJILogExample2);
    HashSet localHashSet = new HashSet();
    localHashSet.add(paramContext);
    localHashSet.add(localObject);
    localHashSet.add(localDJILogExample1);
    localHashSet.add(localDJILogExample2);
    DJILog.object(paramContext);
    DJILog.object("DJILogExample", localObject);
    DJILog.object(6, "DJILogExample", localDJILogExample1);
    DJILog.object(new DJILogExample[] { paramContext, localObject, localDJILogExample1, localDJILogExample2 });
    DJILog.object(localArrayList);
    DJILog.object(localHashMap);
    DJILog.object(localHashSet);
    DJILog.object(new int[] { 1, 2, 3, 4 });
    DJILog.object(new boolean[] { 1, 0, 0, 0 });
    DJILog.json("{\"query\":\"Pizza\",\"locations\":[94043,90210]}");
    DJILog.json("DJILogExample", "{\"query\":\"Pizza\",\"locations\":[94043,90210]}");
    DJILog.json(5, "DJILogExample", "{\"query\":\"Pizza\",\"locations\":[94043,90210]}");
    DJILog.json("[{\"query\":\"Pizza\",\"locations\":[94043,90210]},{\"query\":\"Pizza\",\"locations\":[94043,90210]}]");
    DJILog.json("DJILogExample", "[{\"query\":\"Pizza\",\"locations\":[94043,90210]},{\"query\":\"Pizza\",\"locations\":[94043,90210]}]");
    DJILog.json(6, "DJILogExample", "[{\"query\":\"Pizza\",\"locations\":[94043,90210]},{\"query\":\"Pizza\",\"locations\":[94043,90210]}]");
    DJILog.xml("<?xml version=\"1.0\" encoding=\"utf-8\"?><dji><device id=\"wm100\"><firmware formal=\"01.00.0701\"><release version=\"01.00.0701\" antirollback=\"1\" antirollback_ext=\"cn:3\" enforce=\"1\" enforce_ext=\"cn:3\" enforce_time=\"2017-10-31T12:31:43+00:00\" from=\"2017/10/31\" expire=\"2018/10/31\"><module id=\"0805\" version=\"01.01.01.70\" type=\"\" group=\"ac\" size=\"20285920\" md5=\"3aa9622a5ba485a4dbddd82163a40fe2\">wm100_0805_v01.01.01.70_20171020.pro.fw.sig</module></release></firmware></device></dji>");
    DJILog.xml("DJILogExample", "<?xml version=\"1.0\" encoding=\"utf-8\"?><dji><device id=\"wm100\"><firmware formal=\"01.00.0701\"><release version=\"01.00.0701\" antirollback=\"1\" antirollback_ext=\"cn:3\" enforce=\"1\" enforce_ext=\"cn:3\" enforce_time=\"2017-10-31T12:31:43+00:00\" from=\"2017/10/31\" expire=\"2018/10/31\"><module id=\"0805\" version=\"01.01.01.70\" type=\"\" group=\"ac\" size=\"20285920\" md5=\"3aa9622a5ba485a4dbddd82163a40fe2\">wm100_0805_v01.01.01.70_20171020.pro.fw.sig</module></release></firmware></device></dji>");
    DJILog.xml(6, "DJILogExample", "<?xml version=\"1.0\" encoding=\"utf-8\"?><dji><device id=\"wm100\"><firmware formal=\"01.00.0701\"><release version=\"01.00.0701\" antirollback=\"1\" antirollback_ext=\"cn:3\" enforce=\"1\" enforce_ext=\"cn:3\" enforce_time=\"2017-10-31T12:31:43+00:00\" from=\"2017/10/31\" expire=\"2018/10/31\"><module id=\"0805\" version=\"01.01.01.70\" type=\"\" group=\"ac\" size=\"20285920\" md5=\"3aa9622a5ba485a4dbddd82163a40fe2\">wm100_0805_v01.01.01.70_20171020.pro.fw.sig</module></release></firmware></device></dji>");
    DJILog.addInterceptor(new Interceptor()
    {
      /* Error */
      public void interceptor(DJILogEntry arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
  }
  
  private static void method()
  {
    SystemClock.sleep(5000L);
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\log\DJILogExample.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */