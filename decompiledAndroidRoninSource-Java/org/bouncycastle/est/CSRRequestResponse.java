package org.bouncycastle.est;

public class CSRRequestResponse
{
  private final CSRAttributesResponse attributesResponse;
  private final Source source;
  
  public CSRRequestResponse(CSRAttributesResponse paramCSRAttributesResponse, Source paramSource)
  {
    this.attributesResponse = paramCSRAttributesResponse;
    this.source = paramSource;
  }
  
  public CSRAttributesResponse getAttributesResponse()
  {
    CSRAttributesResponse localCSRAttributesResponse = this.attributesResponse;
    if (localCSRAttributesResponse != null) {
      return localCSRAttributesResponse;
    }
    throw new IllegalStateException("Response has no CSRAttributesResponse.");
  }
  
  public Object getSession()
  {
    return this.source.getSession();
  }
  
  public Source getSource()
  {
    return this.source;
  }
  
  public boolean hasAttributesResponse()
  {
    return this.attributesResponse != null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\est\CSRRequestResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */