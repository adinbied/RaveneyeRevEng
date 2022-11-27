package com.xiaomi.push;

import java.util.Collections;
import java.util.List;

public final class el
{
  public static final class a
    extends e
  {
    private int jdField_a_of_type_Int = 0;
    private List<String> jdField_a_of_type_JavaUtilList = Collections.emptyList();
    private boolean jdField_a_of_type_Boolean;
    private int jdField_b_of_type_Int = 0;
    private boolean jdField_b_of_type_Boolean;
    private int jdField_c_of_type_Int = -1;
    private boolean jdField_c_of_type_Boolean = false;
    private boolean d;
    private boolean e;
    private boolean f = false;
    
    public static a a(byte[] paramArrayOfByte)
    {
      return (a)new a().a(paramArrayOfByte);
    }
    
    public static a b(b paramb)
    {
      return new a().a(paramb);
    }
    
    public int a()
    {
      return 0;
    }
    
    public a a(int paramInt)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = paramInt;
      return this;
    }
    
    public a a(b paramb)
    {
      return null;
    }
    
    public a a(String paramString)
    {
      return null;
    }
    
    public a a(boolean paramBoolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_c_of_type_Boolean = paramBoolean;
      return this;
    }
    
    public List<String> a()
    {
      return this.jdField_a_of_type_JavaUtilList;
    }
    
    /* Error */
    public void a(c arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean a()
    {
      return this.jdField_a_of_type_Boolean;
    }
    
    public int b()
    {
      return 0;
    }
    
    public a b(int paramInt)
    {
      this.d = true;
      this.jdField_b_of_type_Int = paramInt;
      return this;
    }
    
    public a b(boolean paramBoolean)
    {
      this.e = true;
      this.f = paramBoolean;
      return this;
    }
    
    public boolean b()
    {
      return this.jdField_c_of_type_Boolean;
    }
    
    public int c()
    {
      return this.jdField_a_of_type_Int;
    }
    
    public boolean c()
    {
      return this.jdField_b_of_type_Boolean;
    }
    
    public int d()
    {
      return this.jdField_b_of_type_Int;
    }
    
    public boolean d()
    {
      return this.d;
    }
    
    public int e()
    {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    
    public boolean e()
    {
      return this.f;
    }
    
    public boolean f()
    {
      return this.e;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\el.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */