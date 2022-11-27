package com.google.android.gms.common.internal;

import android.accounts.Account;

public class AccountAccessor
  extends IAccountAccessor.Stub
{
  /* Error */
  public static Account getAccountBinderSafe(IAccountAccessor paramIAccountAccessor)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +45 -> 46
    //   4: invokestatic 14	android/os/Binder:clearCallingIdentity	()J
    //   7: lstore_1
    //   8: aload_0
    //   9: invokeinterface 20 1 0
    //   14: astore_0
    //   15: lload_1
    //   16: invokestatic 24	android/os/Binder:restoreCallingIdentity	(J)V
    //   19: aload_0
    //   20: areturn
    //   21: astore_0
    //   22: goto +18 -> 40
    //   25: ldc 26
    //   27: ldc 28
    //   29: invokestatic 34	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   32: pop
    //   33: lload_1
    //   34: invokestatic 24	android/os/Binder:restoreCallingIdentity	(J)V
    //   37: goto +9 -> 46
    //   40: lload_1
    //   41: invokestatic 24	android/os/Binder:restoreCallingIdentity	(J)V
    //   44: aload_0
    //   45: athrow
    //   46: aconst_null
    //   47: areturn
    //   48: astore_0
    //   49: goto -24 -> 25
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	paramIAccountAccessor	IAccountAccessor
    //   7	34	1	l	long
    // Exception table:
    //   from	to	target	type
    //   8	15	21	finally
    //   25	33	21	finally
    //   8	15	48	android/os/RemoteException
  }
  
  public boolean equals(Object paramObject)
  {
    throw new NoSuchMethodError();
  }
  
  public final Account getAccount()
  {
    throw new NoSuchMethodError();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\internal\AccountAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */