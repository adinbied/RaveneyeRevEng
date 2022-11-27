package dagger.internal;

import dagger.MembersInjector;

public final class MembersInjectors
{
  public static <T> MembersInjector<T> noOp()
  {
    return NoOpMembersInjector.INSTANCE;
  }
  
  private static enum NoOpMembersInjector
    implements MembersInjector<Object>
  {
    static
    {
      NoOpMembersInjector localNoOpMembersInjector = new NoOpMembersInjector("INSTANCE", 0);
      INSTANCE = localNoOpMembersInjector;
      $VALUES = new NoOpMembersInjector[] { localNoOpMembersInjector };
    }
    
    private NoOpMembersInjector() {}
    
    public void injectMembers(Object paramObject)
    {
      Preconditions.checkNotNull(paramObject, "Cannot inject members into a null reference");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dagger\internal\MembersInjectors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */