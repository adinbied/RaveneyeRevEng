package dji.thirdparty.afinal.http.entityhandler;

import java.io.IOException;
import org.apache.http.HttpEntity;

public class FileEntityHandler
{
  private boolean mStop = false;
  
  public Object handleEntity(HttpEntity paramHttpEntity, EntityCallBack paramEntityCallBack, String paramString, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    return null;
  }
  
  public boolean isStop()
  {
    return this.mStop;
  }
  
  public void setStop(boolean paramBoolean)
  {
    this.mStop = paramBoolean;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\http\entityhandler\FileEntityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */