package com.xiaomi.clientreport.processor;

import android.content.Context;
import com.xiaomi.clientreport.data.a;
import com.xiaomi.push.bl;
import java.util.HashMap;
import java.util.List;

public class b
  implements IPerfProcessor
{
  protected Context a;
  private HashMap<String, HashMap<String, a>> a;
  
  public b(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static String a(a parama)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(parama.production));
    localStringBuilder.append("#");
    localStringBuilder.append(parama.clientInterfaceId);
    return localStringBuilder.toString();
  }
  
  private String b(a parama)
  {
    return null;
  }
  
  private String c(a parama)
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
  
  /* Error */
  public void a(a arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void a(List<String> paramList)
  {
    bl.a(this.jdField_a_of_type_AndroidContentContext, paramList);
  }
  
  /* Error */
  public void a(a[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setPerfMap(HashMap<String, HashMap<String, a>> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\clientreport\processor\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */