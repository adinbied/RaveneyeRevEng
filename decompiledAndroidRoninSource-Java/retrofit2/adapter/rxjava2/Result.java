package retrofit2.adapter.rxjava2;

import javax.annotation.Nullable;
import retrofit2.Response;

public final class Result<T>
{
  @Nullable
  private final Throwable error;
  @Nullable
  private final Response<T> response;
  
  private Result(@Nullable Response<T> paramResponse, @Nullable Throwable paramThrowable)
  {
    this.response = paramResponse;
    this.error = paramThrowable;
  }
  
  public static <T> Result<T> error(Throwable paramThrowable)
  {
    if (paramThrowable != null) {
      return new Result(null, paramThrowable);
    }
    throw new NullPointerException("error == null");
  }
  
  public static <T> Result<T> response(Response<T> paramResponse)
  {
    if (paramResponse != null) {
      return new Result(paramResponse, null);
    }
    throw new NullPointerException("response == null");
  }
  
  @Nullable
  public Throwable error()
  {
    return this.error;
  }
  
  public boolean isError()
  {
    return this.error != null;
  }
  
  @Nullable
  public Response<T> response()
  {
    return this.response;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\retrofit2\adapter\rxjava2\Result.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */