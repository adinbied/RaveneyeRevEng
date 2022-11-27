package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class fn
{
  private static long jdField_a_of_type_Long = 0L;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private static String jdField_b_of_type_JavaLangString;
  private em.a jdField_a_of_type_ComXiaomiPushEm$a;
  String jdField_a_of_type_JavaLangString = null;
  private short jdField_a_of_type_Short = 2;
  private byte[] jdField_b_of_type_ArrayOfByte = jdField_a_of_type_ArrayOfByte;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(gw.a(5));
    localStringBuilder.append("-");
    jdField_b_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public fn()
  {
    this.jdField_a_of_type_ComXiaomiPushEm$a = new em.a();
  }
  
  fn(em.a parama, short paramShort, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComXiaomiPushEm$a = parama;
    this.jdField_a_of_type_Short = paramShort;
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  @Deprecated
  public static fn a(gl paramgl, String paramString)
  {
    fn localfn = new fn();
    int i;
    try
    {
      i = Integer.parseInt(paramgl.k());
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Blob parse chid err ");
      localStringBuilder.append(localException.getMessage());
      b.a(localStringBuilder.toString());
      i = 1;
    }
    localfn.a(i);
    localfn.a(paramgl.j());
    localfn.c(paramgl.m());
    localfn.b(paramgl.n());
    localfn.a("XMLMSG", null);
    try
    {
      localfn.a(paramgl.a().getBytes("utf8"), paramString);
      if (TextUtils.isEmpty(paramString))
      {
        localfn.a((short)3);
        return localfn;
      }
      localfn.a((short)2);
      localfn.a("SECMSG", null);
      return localfn;
    }
    catch (UnsupportedEncodingException paramgl)
    {
      paramString = new StringBuilder();
      paramString.append("Blob setPayload err： ");
      paramString.append(paramgl.getMessage());
      b.a(paramString.toString());
    }
    return localfn;
  }
  
  static fn a(ByteBuffer paramByteBuffer)
  {
    try
    {
      paramByteBuffer = paramByteBuffer.slice();
      short s = paramByteBuffer.getShort(0);
      int i = paramByteBuffer.getShort(2);
      int j = paramByteBuffer.getInt(4);
      localObject = new em.a();
      ((em.a)localObject).a(paramByteBuffer.array(), paramByteBuffer.arrayOffset() + 8, i);
      byte[] arrayOfByte = new byte[j];
      paramByteBuffer.position(i + 8);
      paramByteBuffer.get(arrayOfByte, 0, j);
      paramByteBuffer = new fn((em.a)localObject, s, arrayOfByte);
      return paramByteBuffer;
    }
    catch (Exception paramByteBuffer)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("read Blob err :");
      ((StringBuilder)localObject).append(paramByteBuffer.getMessage());
      b.a(((StringBuilder)localObject).toString());
      throw new IOException("Malformed Input");
    }
  }
  
  public static String d()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(jdField_b_of_type_JavaLangString);
      long l = jdField_a_of_type_Long;
      jdField_a_of_type_Long = 1L + l;
      ((StringBuilder)localObject1).append(Long.toString(l));
      localObject1 = ((StringBuilder)localObject1).toString();
      return (String)localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComXiaomiPushEm$a.c();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComXiaomiPushEm$a.c();
  }
  
  ByteBuffer a(ByteBuffer paramByteBuffer)
  {
    return null;
  }
  
  public short a()
  {
    return this.jdField_a_of_type_Short;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComXiaomiPushEm$a.a(paramInt);
  }
  
  /* Error */
  public void a(long arg1, String arg3, String arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComXiaomiPushEm$a.e(paramString);
  }
  
  /* Error */
  public void a(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void a(short paramShort)
  {
    this.jdField_a_of_type_Short = paramShort;
  }
  
  /* Error */
  public void a(byte[] arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComXiaomiPushEm$a.j();
  }
  
  public byte[] a()
  {
    return this.jdField_b_of_type_ArrayOfByte;
  }
  
  public byte[] a(String paramString)
  {
    return null;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComXiaomiPushEm$a.f();
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComXiaomiPushEm$a.d();
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int c()
  {
    return 0;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComXiaomiPushEm$a.f();
  }
  
  /* Error */
  public void c(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public String e()
  {
    return null;
  }
  
  public String f()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String g()
  {
    return null;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\fn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */