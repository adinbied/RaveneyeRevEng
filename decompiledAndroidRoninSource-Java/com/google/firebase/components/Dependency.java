package com.google.firebase.components;

public final class Dependency
{
  private final Class<?> anInterface;
  private final int injection;
  private final int type;
  
  private Dependency(Class<?> paramClass, int paramInt1, int paramInt2)
  {
    this.anInterface = ((Class)Preconditions.checkNotNull(paramClass, "Null dependency anInterface."));
    this.type = paramInt1;
    this.injection = paramInt2;
  }
  
  public static Dependency optional(Class<?> paramClass)
  {
    return new Dependency(paramClass, 0, 0);
  }
  
  public static Dependency optionalProvider(Class<?> paramClass)
  {
    return new Dependency(paramClass, 0, 1);
  }
  
  public static Dependency required(Class<?> paramClass)
  {
    return new Dependency(paramClass, 1, 0);
  }
  
  public static Dependency requiredProvider(Class<?> paramClass)
  {
    return new Dependency(paramClass, 1, 1);
  }
  
  public static Dependency setOf(Class<?> paramClass)
  {
    return new Dependency(paramClass, 2, 0);
  }
  
  public static Dependency setOfProvider(Class<?> paramClass)
  {
    return new Dependency(paramClass, 2, 1);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof Dependency;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (Dependency)paramObject;
      bool1 = bool2;
      if (this.anInterface == ((Dependency)paramObject).anInterface)
      {
        bool1 = bool2;
        if (this.type == ((Dependency)paramObject).type)
        {
          bool1 = bool2;
          if (this.injection == ((Dependency)paramObject).injection) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public Class<?> getInterface()
  {
    return this.anInterface;
  }
  
  public int hashCode()
  {
    return ((this.anInterface.hashCode() ^ 0xF4243) * 1000003 ^ this.type) * 1000003 ^ this.injection;
  }
  
  public boolean isDirectInjection()
  {
    return this.injection == 0;
  }
  
  public boolean isRequired()
  {
    return this.type == 1;
  }
  
  public boolean isSet()
  {
    return this.type == 2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Dependency{anInterface=");
    localStringBuilder.append(this.anInterface);
    localStringBuilder.append(", type=");
    int i = this.type;
    boolean bool = true;
    String str;
    if (i == 1) {
      str = "required";
    } else if (i == 0) {
      str = "optional";
    } else {
      str = "set";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(", direct=");
    if (this.injection != 0) {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\components\Dependency.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */