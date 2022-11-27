package kotlin.jvm.internal;

import kotlin.reflect.KDeclarationContainer;

public class FunctionReferenceImpl
  extends FunctionReference
{
  private final String name;
  private final KDeclarationContainer owner;
  private final String signature;
  
  public FunctionReferenceImpl(int paramInt, KDeclarationContainer paramKDeclarationContainer, String paramString1, String paramString2)
  {
    super(paramInt);
    this.owner = paramKDeclarationContainer;
    this.name = paramString1;
    this.signature = paramString2;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public KDeclarationContainer getOwner()
  {
    return this.owner;
  }
  
  public String getSignature()
  {
    return this.signature;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\jvm\internal\FunctionReferenceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */