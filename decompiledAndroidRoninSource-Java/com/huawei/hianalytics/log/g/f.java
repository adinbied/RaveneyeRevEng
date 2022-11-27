package com.huawei.hianalytics.log.g;

import com.huawei.hianalytics.log.b.a.a;
import com.huawei.hianalytics.log.c.a;
import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

public class f
  implements e
{
  private a b;
  private String c;
  private String d;
  private Throwable e;
  
  public f(a parama, Throwable paramThrowable, String paramString)
  {
    this.b = parama;
    parama = new StringBuilder();
    parama.append(paramString);
    parama.append(a.a.b);
    this.d = parama.toString();
    this.e = paramThrowable;
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: goto +12 -> 12
    //   3: goto +9 -> 12
    //   6: goto +6 -> 12
    //   9: return
    //   10: astore_1
    //   11: return
    //   12: goto -3 -> 9
  }
  
  /* Error */
  private void a(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private static class a
    implements Serializable, Comparator<File>
  {
    public int a(File paramFile1, File paramFile2)
    {
      return 0;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\log\g\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */