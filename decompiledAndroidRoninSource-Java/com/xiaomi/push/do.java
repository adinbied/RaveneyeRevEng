package com.xiaomi.push;

import android.content.Context;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class do
  implements LoggerInterface
{
  private static al jdField_a_of_type_ComXiaomiPushAl;
  public static String a;
  private static final SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");
  private static List<Pair<String, Throwable>> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private Context jdField_a_of_type_AndroidContentContext;
  private String b;
  private String c = "";
  
  static
  {
    jdField_a_of_type_ComXiaomiPushAl = new al(true);
    jdField_a_of_type_JavaLangString = "/MiPushLog";
  }
  
  public do(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramContext.getApplicationContext() != null) {
      this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    }
    this.b = this.jdField_a_of_type_AndroidContentContext.getPackageName();
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public final void log(String paramString)
  {
    log(paramString, null);
  }
  
  /* Error */
  public final void log(String arg1, Throwable arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public final void setTag(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\do.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */