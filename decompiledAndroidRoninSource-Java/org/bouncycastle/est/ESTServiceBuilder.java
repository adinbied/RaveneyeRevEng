package org.bouncycastle.est;

public class ESTServiceBuilder
{
  protected ESTClientProvider clientProvider;
  protected String label;
  protected final String server;
  
  public ESTServiceBuilder(String paramString)
  {
    this.server = paramString;
  }
  
  public ESTService build()
  {
    return new ESTService(this.server, this.label, this.clientProvider);
  }
  
  public ESTServiceBuilder withClientProvider(ESTClientProvider paramESTClientProvider)
  {
    this.clientProvider = paramESTClientProvider;
    return this;
  }
  
  public ESTServiceBuilder withLabel(String paramString)
  {
    this.label = paramString;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\est\ESTServiceBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */