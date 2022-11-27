package com.dji.video.framing.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtil
{
  private static final String TAG = "TestUtil";
  private static DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
  
  public static String getTimeString()
  {
    return dateFormat.format(new Date());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\demo\TestUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */