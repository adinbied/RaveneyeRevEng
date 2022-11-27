package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class cd
{
  private static volatile cd jdField_a_of_type_ComXiaomiPushCd;
  private Context jdField_a_of_type_AndroidContentContext;
  private cc jdField_a_of_type_ComXiaomiPushCc;
  private final ArrayList<a> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final HashMap<String, cb> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(1, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  
  private cd(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private cb a(String paramString)
  {
    return null;
  }
  
  public static cd a(Context paramContext)
  {
    if (jdField_a_of_type_ComXiaomiPushCd == null) {
      try
      {
        if (jdField_a_of_type_ComXiaomiPushCd == null) {
          jdField_a_of_type_ComXiaomiPushCd = new cd(paramContext);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComXiaomiPushCd;
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String a(String paramString)
  {
    return a(paramString).a();
  }
  
  /* Error */
  public void a(a arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(Runnable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(ArrayList<a> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void b(a arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static abstract class a
    implements Runnable
  {
    private int jdField_a_of_type_Int = 0;
    protected cb a;
    private a jdField_a_of_type_ComXiaomiPushCd$a;
    private String jdField_a_of_type_JavaLangString;
    private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
    private Random jdField_a_of_type_JavaUtilRandom = new Random();
    protected String b;
    
    public a(String paramString)
    {
      this.jdField_a_of_type_ComXiaomiPushCb = null;
      this.jdField_a_of_type_JavaLangString = paramString;
    }
    
    public SQLiteDatabase a()
    {
      return this.jdField_a_of_type_ComXiaomiPushCb.getWritableDatabase();
    }
    
    public Object a()
    {
      return null;
    }
    
    public String a()
    {
      return this.jdField_a_of_type_JavaLangString;
    }
    
    /* Error */
    void a(Context arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public abstract void a(Context paramContext, SQLiteDatabase paramSQLiteDatabase);
    
    public void a(Context paramContext, Object paramObject)
    {
      cd.a(paramContext).a(this);
    }
    
    void a(cb paramcb, Context paramContext)
    {
      this.jdField_a_of_type_ComXiaomiPushCb = paramcb;
      this.b = paramcb.a();
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    }
    
    public void a(a parama)
    {
      this.jdField_a_of_type_ComXiaomiPushCd$a = parama;
    }
    
    public boolean a()
    {
      return false;
    }
    
    public void b(Context paramContext) {}
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  public static abstract class b<T>
    extends cd.a
  {
    private int jdField_a_of_type_Int;
    private String jdField_a_of_type_JavaLangString;
    private List<String> jdField_a_of_type_JavaUtilList;
    private String[] jdField_a_of_type_ArrayOfJavaLangString;
    private List<T> b = new ArrayList();
    private String c;
    private String d;
    private String e;
    
    public b(String paramString1, List<String> paramList, String paramString2, String[] paramArrayOfString, String paramString3, String paramString4, String paramString5, int paramInt)
    {
      super();
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
      this.c = paramString3;
      this.d = paramString4;
      this.e = paramString5;
      this.jdField_a_of_type_Int = paramInt;
    }
    
    public SQLiteDatabase a()
    {
      return this.jdField_a_of_type_ComXiaomiPushCb.getReadableDatabase();
    }
    
    public abstract T a(Context paramContext, Cursor paramCursor);
    
    /* Error */
    public void a(Context arg1, SQLiteDatabase arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public abstract void a(Context paramContext, List<T> paramList);
  }
  
  public static class c
    extends cd.a
  {
    private ArrayList<cd.a> a;
    
    public c(String paramString, ArrayList<cd.a> paramArrayList)
    {
      super();
      paramString = new ArrayList();
      this.a = paramString;
      paramString.addAll(paramArrayList);
    }
    
    /* Error */
    public final void a(Context arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void a(Context arg1, SQLiteDatabase arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  public static class d
    extends cd.a
  {
    private String a;
    protected String[] a;
    
    public d(String paramString1, String paramString2, String[] paramArrayOfString)
    {
      super();
      this.jdField_a_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    }
    
    /* Error */
    public void a(Context arg1, SQLiteDatabase arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  public static class e
    extends cd.a
  {
    private ContentValues a;
    
    public e(String paramString, ContentValues paramContentValues)
    {
      super();
      this.a = paramContentValues;
    }
    
    /* Error */
    public void a(Context arg1, SQLiteDatabase arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */