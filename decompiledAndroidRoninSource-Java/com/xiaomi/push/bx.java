package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;

public class bx
  extends bz
{
  public bx(String paramString1, String paramString2, String[] paramArrayOfString, String paramString3)
  {
    super(paramString1, paramString2, paramArrayOfString, paramString3);
  }
  
  public static bx a(Context paramContext, String paramString, int paramInt)
  {
    b.b("delete  messages when db size is too bigger");
    paramContext = cd.a(paramContext).a(paramString);
    if (TextUtils.isEmpty(paramContext)) {
      return null;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("rowDataId in (select ");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("rowDataId from ");
    localStringBuilder2.append(paramContext);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(" order by createTimeStamp asc");
    localStringBuilder1.append(" limit ?)");
    return new bx(paramString, localStringBuilder1.toString(), new String[] { String.valueOf(paramInt) }, "a job build to delete history message");
  }
  
  /* Error */
  private void a(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(Context arg1, Object arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */