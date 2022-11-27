package retrofit2.adapter.rxjava2;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.Call;
import retrofit2.CallAdapter;

final class RxJava2CallAdapter<R>
  implements CallAdapter<R, Object>
{
  private final boolean isAsync;
  private final boolean isBody;
  private final boolean isCompletable;
  private final boolean isFlowable;
  private final boolean isMaybe;
  private final boolean isResult;
  private final boolean isSingle;
  private final Type responseType;
  @Nullable
  private final Scheduler scheduler;
  
  RxJava2CallAdapter(Type paramType, @Nullable Scheduler paramScheduler, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    this.responseType = paramType;
    this.scheduler = paramScheduler;
    this.isAsync = paramBoolean1;
    this.isResult = paramBoolean2;
    this.isBody = paramBoolean3;
    this.isFlowable = paramBoolean4;
    this.isSingle = paramBoolean5;
    this.isMaybe = paramBoolean6;
    this.isCompletable = paramBoolean7;
  }
  
  public Object adapt(Call<R> paramCall)
  {
    if (this.isAsync) {
      localObject = new CallEnqueueObservable(paramCall);
    } else {
      localObject = new CallExecuteObservable(paramCall);
    }
    if (this.isResult) {}
    for (paramCall = new ResultObservable((Observable)localObject);; paramCall = new BodyObservable((Observable)localObject))
    {
      break;
      paramCall = (Call<R>)localObject;
      if (!this.isBody) {
        break;
      }
    }
    Scheduler localScheduler = this.scheduler;
    Object localObject = paramCall;
    if (localScheduler != null) {
      localObject = paramCall.subscribeOn(localScheduler);
    }
    if (this.isFlowable) {
      return ((Observable)localObject).toFlowable(BackpressureStrategy.LATEST);
    }
    if (this.isSingle) {
      return ((Observable)localObject).singleOrError();
    }
    if (this.isMaybe) {
      return ((Observable)localObject).singleElement();
    }
    if (this.isCompletable) {
      return ((Observable)localObject).ignoreElements();
    }
    return RxJavaPlugins.onAssembly((Observable)localObject);
  }
  
  public Type responseType()
  {
    return this.responseType;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\retrofit2\adapter\rxjava2\RxJava2CallAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */