package com.huawei.hms.support.api.push.a.d;

import android.content.Context;
import android.content.res.Resources;
import com.huawei.hms.support.log.a;
import java.lang.reflect.Field;

public class b
{
  public static int a(Context paramContext, String paramString)
  {
    return a(paramContext, "layout", paramString);
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      int j = paramContext.getResources().getIdentifier(paramString2, paramString1, paramContext.getPackageName());
      int i = j;
      if (j == 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramContext.getPackageName());
        localStringBuilder.append(".R$");
        localStringBuilder.append(paramString1);
        paramContext = Class.forName(localStringBuilder.toString()).getField(paramString2);
        j = Integer.parseInt(paramContext.get(paramContext.getName()).toString());
        i = j;
        if (j == 0)
        {
          paramContext = new StringBuilder();
          paramContext.append("Error-resourceType=");
          paramContext.append(paramString1);
          paramContext.append("--resourceName=");
          paramContext.append(paramString2);
          paramContext.append("--resourceId =");
          paramContext.append(j);
          a.b("ResourceLoader", paramContext.toString());
          i = j;
        }
      }
      return i;
    }
    catch (IllegalArgumentException paramContext)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("!!!! ResourceLoader: IllegalArgumentException-resourceType=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("--resourceName=");
      localStringBuilder.append(paramString2);
      a.a("ResourceLoader", localStringBuilder.toString(), paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("!!!! ResourceLoader: IllegalAccessException-resourceType=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("--resourceName=");
      localStringBuilder.append(paramString2);
      a.a("ResourceLoader", localStringBuilder.toString(), paramContext);
    }
    catch (NumberFormatException paramContext)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("!!!! ResourceLoader: NumberFormatException-resourceType=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("--resourceName=");
      localStringBuilder.append(paramString2);
      a.a("ResourceLoader", localStringBuilder.toString(), paramContext);
    }
    catch (NoSuchFieldException paramContext)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("!!!! ResourceLoader: NoSuchFieldException-resourceType=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("--resourceName=");
      localStringBuilder.append(paramString2);
      a.a("ResourceLoader", localStringBuilder.toString(), paramContext);
    }
    catch (ClassNotFoundException paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("!!!! ResourceLoader: ClassNotFoundException-resourceType=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("--resourceName=");
      localStringBuilder.append(paramString2);
      a.a("ResourceLoader", localStringBuilder.toString(), paramContext);
    }
    return 0;
  }
  
  public static int b(Context paramContext, String paramString)
  {
    return a(paramContext, "id", paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\a\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */