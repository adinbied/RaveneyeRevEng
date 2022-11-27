package org.junit.experimental.theories;

public abstract class PotentialAssignment
{
  public static PotentialAssignment forValue(final String paramString, Object paramObject)
  {
    new PotentialAssignment()
    {
      /* Error */
      public String getDescription()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 15	org/junit/experimental/theories/PotentialAssignment$1:val$value	Ljava/lang/Object;
        //   4: astore_1
        //   5: aload_1
        //   6: ifnonnull +9 -> 15
        //   9: ldc 25
        //   11: astore_1
        //   12: goto +48 -> 60
        //   15: ldc 27
        //   17: iconst_1
        //   18: anewarray 29	java/lang/Object
        //   21: dup
        //   22: iconst_0
        //   23: aload_1
        //   24: aastore
        //   25: invokestatic 35	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   28: astore_1
        //   29: goto +31 -> 60
        //   32: astore_1
        //   33: ldc 37
        //   35: iconst_2
        //   36: anewarray 29	java/lang/Object
        //   39: dup
        //   40: iconst_0
        //   41: aload_1
        //   42: invokevirtual 41	java/lang/Object:getClass	()Ljava/lang/Class;
        //   45: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
        //   48: aastore
        //   49: dup
        //   50: iconst_1
        //   51: aload_1
        //   52: invokevirtual 51	java/lang/Throwable:getMessage	()Ljava/lang/String;
        //   55: aastore
        //   56: invokestatic 35	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   59: astore_1
        //   60: ldc 53
        //   62: iconst_2
        //   63: anewarray 29	java/lang/Object
        //   66: dup
        //   67: iconst_0
        //   68: aload_1
        //   69: aastore
        //   70: dup
        //   71: iconst_1
        //   72: aload_0
        //   73: getfield 17	org/junit/experimental/theories/PotentialAssignment$1:val$name	Ljava/lang/String;
        //   76: aastore
        //   77: invokestatic 35	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   80: areturn
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	81	0	this	1
        //   4	25	1	localObject1	Object
        //   32	20	1	localObject2	Object
        //   59	10	1	str	String
        // Exception table:
        //   from	to	target	type
        //   15	29	32	finally
      }
      
      public Object getValue()
      {
        return this.val$value;
      }
      
      public String toString()
      {
        return String.format("[%s]", new Object[] { this.val$value });
      }
    };
  }
  
  public abstract String getDescription()
    throws PotentialAssignment.CouldNotGenerateValueException;
  
  public abstract Object getValue()
    throws PotentialAssignment.CouldNotGenerateValueException;
  
  public static class CouldNotGenerateValueException
    extends Exception
  {
    private static final long serialVersionUID = 1L;
    
    public CouldNotGenerateValueException() {}
    
    public CouldNotGenerateValueException(Throwable paramThrowable)
    {
      super();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\experimental\theories\PotentialAssignment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */