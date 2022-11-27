package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.ArrayList;
import java.util.List;

public class ay
{
  private static ay jdField_a_of_type_ComXiaomiPushServiceAy;
  private static String jdField_a_of_type_JavaLangString;
  private Context jdField_a_of_type_AndroidContentContext;
  private Messenger jdField_a_of_type_AndroidOsMessenger;
  private List<Message> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private Messenger jdField_b_of_type_AndroidOsMessenger;
  private boolean jdField_b_of_type_Boolean = false;
  
  private ay(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_AndroidOsMessenger = new Messenger(new az(this, Looper.getMainLooper()));
    if (a())
    {
      b.c("use miui push service");
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private Message a(Intent paramIntent)
  {
    return null;
  }
  
  public static ay a(Context paramContext)
  {
    if (jdField_a_of_type_ComXiaomiPushServiceAy == null) {
      jdField_a_of_type_ComXiaomiPushServiceAy = new ay(paramContext);
    }
    return jdField_a_of_type_ComXiaomiPushServiceAy;
  }
  
  /* Error */
  private void a(Intent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private boolean a()
  {
    return false;
  }
  
  public boolean a(Intent paramIntent)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */