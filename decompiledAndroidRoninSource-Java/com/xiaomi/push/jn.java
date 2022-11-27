package com.xiaomi.push;

public class jn
{
  private static int a = Integer.MAX_VALUE;
  
  public static void a(jk paramjk, byte paramByte)
  {
    a(paramjk, paramByte, jdField_a_of_type_Int);
  }
  
  public static void a(jk paramjk, byte paramByte, int paramInt)
  {
    Object localObject;
    byte b1;
    if (paramInt > 0)
    {
      byte b3 = 0;
      byte b4 = 0;
      byte b2 = 0;
      switch (paramByte)
      {
      case 5: 
      case 7: 
      case 9: 
      default: 
        return;
      case 15: 
        localObject = paramjk.a();
        paramByte = b2;
        while (paramByte < ((ji)localObject).jdField_a_of_type_Int)
        {
          a(paramjk, ((ji)localObject).jdField_a_of_type_Byte, paramInt - 1);
          paramByte += 1;
        }
        paramjk.i();
        return;
      case 14: 
        localObject = paramjk.a();
        paramByte = b3;
        while (paramByte < ((jo)localObject).jdField_a_of_type_Int)
        {
          a(paramjk, ((jo)localObject).jdField_a_of_type_Byte, paramInt - 1);
          paramByte += 1;
        }
        paramjk.j();
        return;
      case 13: 
        localObject = paramjk.a();
        paramByte = b4;
        while (paramByte < ((jj)localObject).jdField_a_of_type_Int)
        {
          b1 = ((jj)localObject).jdField_a_of_type_Byte;
          b2 = paramInt - 1;
          a(paramjk, b1, b2);
          a(paramjk, ((jj)localObject).b, b2);
          paramByte += 1;
        }
        paramjk.h();
        return;
      case 12: 
        paramjk.a();
      }
    }
    for (;;)
    {
      localObject = paramjk.a();
      if (((jh)localObject).jdField_a_of_type_Byte == 0)
      {
        paramjk.f();
        return;
      }
      b1 = ((jh)localObject).jdField_a_of_type_Byte;
      try
      {
        a(paramjk, b1, paramInt - 1);
        paramjk.g();
      }
      finally {}
    }
    paramjk.a();
    return;
    paramjk.a();
    return;
    paramjk.a();
    return;
    paramjk.a();
    return;
    paramjk.a();
    return;
    paramjk.a();
    return;
    paramjk.a();
    return;
    throw new je("Maximum skip depth exceeded");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\jn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */