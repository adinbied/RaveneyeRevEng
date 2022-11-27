package com.xiaomi.push;

import android.text.TextUtils;

public enum fi
{
  public final String a;
  
  static
  {
    jdField_a_of_type_ComXiaomiPushFi = new fi("COMMAND_REGISTER", 0, "register");
    b = new fi("COMMAND_UNREGISTER", 1, "unregister");
    c = new fi("COMMAND_SET_ALIAS", 2, "set-alias");
    d = new fi("COMMAND_UNSET_ALIAS", 3, "unset-alias");
    e = new fi("COMMAND_SET_ACCOUNT", 4, "set-account");
    f = new fi("COMMAND_UNSET_ACCOUNT", 5, "unset-account");
    g = new fi("COMMAND_SUBSCRIBE_TOPIC", 6, "subscribe-topic");
    h = new fi("COMMAND_UNSUBSCRIBE_TOPIC", 7, "unsubscibe-topic");
    i = new fi("COMMAND_SET_ACCEPT_TIME", 8, "accept-time");
    fi localfi = new fi("COMMAND_CHK_VDEVID", 9, "check-vdeviceid");
    j = localfi;
    jdField_a_of_type_ArrayOfComXiaomiPushFi = new fi[] { jdField_a_of_type_ComXiaomiPushFi, b, c, d, e, f, g, h, i, localfi };
  }
  
  private fi(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static int a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int m = -1;
    if (bool) {
      return -1;
    }
    fi[] arrayOffi = values();
    int n = arrayOffi.length;
    int k = 0;
    while (k < n)
    {
      fi localfi = arrayOffi[k];
      if (localfi.jdField_a_of_type_JavaLangString.equals(paramString)) {
        m = fc.a(localfi);
      }
      k += 1;
    }
    return m;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\fi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */