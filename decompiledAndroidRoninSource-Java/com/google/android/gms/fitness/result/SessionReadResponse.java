package com.google.android.gms.fitness.result;

import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import java.util.List;

public class SessionReadResponse
  extends Response<SessionReadResult>
{
  public SessionReadResponse() {}
  
  protected SessionReadResponse(SessionReadResult paramSessionReadResult)
  {
    super(paramSessionReadResult);
  }
  
  public List<DataSet> getDataSet(Session paramSession)
  {
    return ((SessionReadResult)getResult()).getDataSet(paramSession);
  }
  
  public List<DataSet> getDataSet(Session paramSession, DataType paramDataType)
  {
    return ((SessionReadResult)getResult()).getDataSet(paramSession, paramDataType);
  }
  
  public List<Session> getSessions()
  {
    return ((SessionReadResult)getResult()).getSessions();
  }
  
  public Status getStatus()
  {
    return ((SessionReadResult)getResult()).getStatus();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\result\SessionReadResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */