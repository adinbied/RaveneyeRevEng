package com.xiaomi.push;

import java.net.UnknownHostException;

final class he
{
  static a a(Exception paramException)
  {
    a(paramException);
    Object localObject1 = paramException;
    if ((paramException instanceof gf))
    {
      localObject2 = (gf)paramException;
      localObject1 = paramException;
      if (((gf)localObject2).a() != null) {
        localObject1 = ((gf)localObject2).a();
      }
    }
    Object localObject2 = new a();
    paramException = ((Throwable)localObject1).getMessage();
    if (((Throwable)localObject1).getCause() != null) {
      paramException = ((Throwable)localObject1).getCause().getMessage();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localObject1.getClass().getSimpleName());
    localStringBuilder.append(":");
    localStringBuilder.append(paramException);
    paramException = localStringBuilder.toString();
    int i = fw.a((Throwable)localObject1);
    if (i != 0) {
      ((a)localObject2).jdField_a_of_type_ComXiaomiPushFj = fj.a(fj.i.a() + i);
    }
    if (((a)localObject2).jdField_a_of_type_ComXiaomiPushFj == null) {
      ((a)localObject2).jdField_a_of_type_ComXiaomiPushFj = fj.q;
    }
    if (((a)localObject2).jdField_a_of_type_ComXiaomiPushFj == fj.q) {
      ((a)localObject2).jdField_a_of_type_JavaLangString = paramException;
    }
    return (a)localObject2;
  }
  
  private static void a(Exception paramException)
  {
    if (paramException != null) {
      return;
    }
    throw null;
  }
  
  static a b(Exception paramException)
  {
    a(paramException);
    Object localObject1 = paramException;
    if ((paramException instanceof gf))
    {
      localObject2 = (gf)paramException;
      localObject1 = paramException;
      if (((gf)localObject2).a() != null) {
        localObject1 = ((gf)localObject2).a();
      }
    }
    Object localObject2 = new a();
    paramException = ((Throwable)localObject1).getMessage();
    if (((Throwable)localObject1).getCause() != null) {
      paramException = ((Throwable)localObject1).getCause().getMessage();
    }
    int i = fw.a((Throwable)localObject1);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(localObject1.getClass().getSimpleName());
    ((StringBuilder)localObject3).append(":");
    ((StringBuilder)localObject3).append(paramException);
    localObject3 = ((StringBuilder)localObject3).toString();
    if (i != 0)
    {
      ((a)localObject2).jdField_a_of_type_ComXiaomiPushFj = fj.a(fj.s.a() + i);
      if (((a)localObject2).jdField_a_of_type_ComXiaomiPushFj != fj.D) {
        break label170;
      }
      paramException = ((Throwable)localObject1).getCause();
      if ((paramException == null) || (!(paramException instanceof UnknownHostException))) {
        break label170;
      }
      paramException = fj.C;
    }
    else
    {
      paramException = fj.B;
    }
    ((a)localObject2).jdField_a_of_type_ComXiaomiPushFj = paramException;
    label170:
    if ((((a)localObject2).jdField_a_of_type_ComXiaomiPushFj == fj.A) || (((a)localObject2).jdField_a_of_type_ComXiaomiPushFj == fj.B) || (((a)localObject2).jdField_a_of_type_ComXiaomiPushFj == fj.D)) {
      ((a)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject3);
    }
    return (a)localObject2;
  }
  
  static a c(Exception paramException)
  {
    a(paramException);
    Object localObject1 = paramException;
    if ((paramException instanceof gf))
    {
      localObject2 = (gf)paramException;
      localObject1 = paramException;
      if (((gf)localObject2).a() != null) {
        localObject1 = ((gf)localObject2).a();
      }
    }
    Object localObject2 = new a();
    paramException = ((Throwable)localObject1).getMessage();
    if (((Throwable)localObject1).getCause() != null) {
      paramException = ((Throwable)localObject1).getCause().getMessage();
    }
    int i = fw.a((Throwable)localObject1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localObject1.getClass().getSimpleName());
    localStringBuilder.append(":");
    localStringBuilder.append(paramException);
    localObject1 = localStringBuilder.toString();
    if (i != 105)
    {
      if (i != 199)
      {
        if (i != 499)
        {
          if (i != 109)
          {
            if (i != 110) {
              paramException = fj.M;
            } else {
              paramException = fj.K;
            }
          }
          else {
            paramException = fj.J;
          }
        }
        else
        {
          ((a)localObject2).jdField_a_of_type_ComXiaomiPushFj = fj.O;
          if (!paramException.startsWith("Terminal binding condition encountered: item-not-found")) {
            break label200;
          }
          paramException = fj.N;
        }
      }
      else {
        paramException = fj.L;
      }
    }
    else {
      paramException = fj.I;
    }
    ((a)localObject2).jdField_a_of_type_ComXiaomiPushFj = paramException;
    label200:
    if ((((a)localObject2).jdField_a_of_type_ComXiaomiPushFj == fj.L) || (((a)localObject2).jdField_a_of_type_ComXiaomiPushFj == fj.M) || (((a)localObject2).jdField_a_of_type_ComXiaomiPushFj == fj.O)) {
      ((a)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
    }
    return (a)localObject2;
  }
  
  static a d(Exception paramException)
  {
    a(paramException);
    Object localObject1 = paramException;
    if ((paramException instanceof gf))
    {
      localObject2 = (gf)paramException;
      localObject1 = paramException;
      if (((gf)localObject2).a() != null) {
        localObject1 = ((gf)localObject2).a();
      }
    }
    Object localObject2 = new a();
    paramException = ((Throwable)localObject1).getMessage();
    int i = fw.a((Throwable)localObject1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localObject1.getClass().getSimpleName());
    localStringBuilder.append(":");
    localStringBuilder.append(paramException);
    localObject1 = localStringBuilder.toString();
    if (i != 105)
    {
      if (i != 199)
      {
        if (i != 499)
        {
          if (i != 109)
          {
            if (i != 110) {
              paramException = fj.Y;
            } else {
              paramException = fj.W;
            }
          }
          else {
            paramException = fj.V;
          }
        }
        else
        {
          ((a)localObject2).jdField_a_of_type_ComXiaomiPushFj = fj.aa;
          if (!paramException.startsWith("Terminal binding condition encountered: item-not-found")) {
            break label185;
          }
          paramException = fj.Z;
        }
      }
      else {
        paramException = fj.X;
      }
    }
    else {
      paramException = fj.U;
    }
    ((a)localObject2).jdField_a_of_type_ComXiaomiPushFj = paramException;
    label185:
    if ((((a)localObject2).jdField_a_of_type_ComXiaomiPushFj == fj.X) || (((a)localObject2).jdField_a_of_type_ComXiaomiPushFj == fj.Y) || (((a)localObject2).jdField_a_of_type_ComXiaomiPushFj == fj.aa)) {
      ((a)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
    }
    return (a)localObject2;
  }
  
  static class a
  {
    fj jdField_a_of_type_ComXiaomiPushFj;
    String jdField_a_of_type_JavaLangString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\he.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */