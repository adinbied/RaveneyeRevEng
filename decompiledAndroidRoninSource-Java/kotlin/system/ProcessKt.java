package kotlin.system;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\016\n\000\n\002\020\001\n\000\n\002\020\b\n\000\032\021\020\000\032\0020\0012\006\020\002\032\0020\003H\b¨\006\004"}, d2={"exitProcess", "", "status", "", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class ProcessKt
{
  private static final Void exitProcess(int paramInt)
  {
    System.exit(paramInt);
    throw ((Throwable)new RuntimeException("System.exit returned normally, while it was supposed to halt JVM."));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\system\ProcessKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */