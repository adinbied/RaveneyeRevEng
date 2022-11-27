package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class gi
  implements gm
{
  private String jdField_a_of_type_JavaLangString;
  private List<gi> jdField_a_of_type_JavaUtilList = null;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = null;
  private String jdField_b_of_type_JavaLangString;
  private String[] jdField_b_of_type_ArrayOfJavaLangString = null;
  private String c;
  
  public gi(String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString1;
    this.jdField_b_of_type_ArrayOfJavaLangString = paramArrayOfString2;
  }
  
  public gi(String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString3, List<gi> paramList)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString1;
    this.jdField_b_of_type_ArrayOfJavaLangString = paramArrayOfString2;
    this.c = paramString3;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public static gi a(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("ext_ele_name");
    String str2 = paramBundle.getString("ext_ns");
    String str3 = paramBundle.getString("ext_text");
    Object localObject1 = paramBundle.getBundle("attributes");
    Object localObject2 = ((Bundle)localObject1).keySet();
    String[] arrayOfString1 = new String[((Set)localObject2).size()];
    String[] arrayOfString2 = new String[((Set)localObject2).size()];
    localObject2 = ((Set)localObject2).iterator();
    int j = 0;
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      String str4 = (String)((Iterator)localObject2).next();
      arrayOfString1[i] = str4;
      arrayOfString2[i] = ((Bundle)localObject1).getString(str4);
      i += 1;
    }
    if (paramBundle.containsKey("children"))
    {
      localObject1 = paramBundle.getParcelableArray("children");
      paramBundle = new ArrayList(localObject1.length);
      int k = localObject1.length;
      i = j;
      while (i < k)
      {
        paramBundle.add(a((Bundle)localObject1[i]));
        i += 1;
      }
    }
    else
    {
      paramBundle = null;
    }
    return new gi(str1, str2, arrayOfString1, arrayOfString2, str3, paramBundle);
  }
  
  public static Parcelable[] a(List<gi> paramList)
  {
    return a((gi[])paramList.toArray(new gi[paramList.size()]));
  }
  
  public static Parcelable[] a(gi[] paramArrayOfgi)
  {
    if (paramArrayOfgi == null) {
      return null;
    }
    Parcelable[] arrayOfParcelable = new Parcelable[paramArrayOfgi.length];
    int i = 0;
    while (i < paramArrayOfgi.length)
    {
      arrayOfParcelable[i] = paramArrayOfgi[i].a();
      i += 1;
    }
    return arrayOfParcelable;
  }
  
  public Bundle a()
  {
    return null;
  }
  
  public Parcelable a()
  {
    return a();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString)
  {
    return null;
  }
  
  /* Error */
  public void a(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String c()
  {
    return null;
  }
  
  public String d()
  {
    return null;
  }
  
  public String toString()
  {
    return d();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\gi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */