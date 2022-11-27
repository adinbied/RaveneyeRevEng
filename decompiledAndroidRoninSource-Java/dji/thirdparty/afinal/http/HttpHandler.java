package dji.thirdparty.afinal.http;

import dji.thirdparty.afinal.core.AsyncTask;
import dji.thirdparty.afinal.http.entityhandler.EntityCallBack;
import dji.thirdparty.afinal.http.entityhandler.FileEntityHandler;
import dji.thirdparty.afinal.http.entityhandler.StringEntityHandler;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class HttpHandler<T>
  extends AsyncTask<Object, Object, Object>
  implements EntityCallBack
{
  private static final int UPDATE_FAILURE = 3;
  private static final int UPDATE_LOADING = 2;
  private static final int UPDATE_START = 1;
  private static final int UPDATE_SUCCESS = 4;
  private final AjaxCallBack<T> callback;
  private String charset;
  private boolean checkContentLength = false;
  private final AbstractHttpClient client;
  private final HttpContext context;
  private int executionCount = 0;
  private boolean isResume = false;
  private final FileEntityHandler mFileEntityHandler = new FileEntityHandler();
  private final StringEntityHandler mStrEntityHandler = new StringEntityHandler();
  private String targetUrl = null;
  private long time;
  
  public HttpHandler(AbstractHttpClient paramAbstractHttpClient, HttpContext paramHttpContext, AjaxCallBack<T> paramAjaxCallBack, String paramString)
  {
    this.client = paramAbstractHttpClient;
    this.context = paramHttpContext;
    this.callback = paramAjaxCallBack;
    this.charset = paramString;
  }
  
  /* Error */
  private void handleResponse(org.apache.http.HttpResponse arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void makeRequestWithRetries(org.apache.http.client.methods.HttpUriRequest arg1)
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void callBack(long arg1, long arg3, boolean arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore 6
    //   3: goto -3 -> 0
  }
  
  protected Object doInBackground(Object... paramVarArgs)
  {
    return null;
  }
  
  public boolean isStop()
  {
    return this.mFileEntityHandler.isStop();
  }
  
  /* Error */
  protected void onProgressUpdate(Object... arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void stop()
  {
    this.mFileEntityHandler.setStop(true);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\http\HttpHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */