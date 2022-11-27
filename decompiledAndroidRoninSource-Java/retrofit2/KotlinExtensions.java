package retrofit2;

import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.Continuation<*>;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Request;

@Metadata(bv={1, 0, 3}, d1={"\000.\n\002\b\002\n\002\020\000\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\001\n\002\030\002\n\002\030\002\n\002\b\002\032%\020\000\032\002H\001\"\b\b\000\020\001*\0020\002*\b\022\004\022\002H\0010\003H@ø\001\000¢\006\002\020\004\032+\020\000\032\004\030\001H\001\"\b\b\000\020\001*\0020\002*\n\022\006\022\004\030\001H\0010\003H@ø\001\000¢\006\004\b\005\020\004\032'\020\006\032\b\022\004\022\002H\0010\007\"\004\b\000\020\001*\b\022\004\022\002H\0010\003H@ø\001\000¢\006\002\020\004\032\032\020\b\032\002H\001\"\006\b\000\020\001\030\001*\0020\tH\b¢\006\002\020\n\032\031\020\013\032\0020\f*\0060\rj\002`\016H@ø\001\000¢\006\002\020\017\002\004\n\002\b\031¨\006\020"}, d2={"await", "T", "", "Lretrofit2/Call;", "(Lretrofit2/Call;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitNullable", "awaitResponse", "Lretrofit2/Response;", "create", "Lretrofit2/Retrofit;", "(Lretrofit2/Retrofit;)Ljava/lang/Object;", "suspendAndThrow", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retrofit"}, k=2, mv={1, 1, 15})
public final class KotlinExtensions
{
  public static final <T> Object await(Call<T> paramCall, Continuation<? super T> paramContinuation)
  {
    CancellableContinuationImpl localCancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(paramContinuation), 1);
    CancellableContinuation localCancellableContinuation = (CancellableContinuation)localCancellableContinuationImpl;
    localCancellableContinuation.invokeOnCancellation((Function1)new Lambda(paramCall)
    {
      public final void invoke(Throwable paramAnonymousThrowable)
      {
        this.$this_await$inlined.cancel();
      }
    });
    paramCall.enqueue((Callback)new Callback()
    {
      public void onFailure(Call<T> paramAnonymousCall, Throwable paramAnonymousThrowable)
      {
        Intrinsics.checkParameterIsNotNull(paramAnonymousCall, "call");
        Intrinsics.checkParameterIsNotNull(paramAnonymousThrowable, "t");
        paramAnonymousCall = (Continuation)this.$continuation;
        Result.Companion localCompanion = Result.Companion;
        paramAnonymousCall.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramAnonymousThrowable)));
      }
      
      public void onResponse(Call<T> paramAnonymousCall, Response<T> paramAnonymousResponse)
      {
        Intrinsics.checkParameterIsNotNull(paramAnonymousCall, "call");
        Intrinsics.checkParameterIsNotNull(paramAnonymousResponse, "response");
        if (paramAnonymousResponse.isSuccessful())
        {
          paramAnonymousResponse = paramAnonymousResponse.body();
          if (paramAnonymousResponse == null)
          {
            paramAnonymousCall = paramAnonymousCall.request().tag(Invocation.class);
            if (paramAnonymousCall == null) {
              Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(paramAnonymousCall, "call.request().tag(Invocation::class.java)!!");
            paramAnonymousCall = ((Invocation)paramAnonymousCall).method();
            paramAnonymousResponse = new StringBuilder();
            paramAnonymousResponse.append("Response from ");
            Intrinsics.checkExpressionValueIsNotNull(paramAnonymousCall, "method");
            localObject = paramAnonymousCall.getDeclaringClass();
            Intrinsics.checkExpressionValueIsNotNull(localObject, "method.declaringClass");
            paramAnonymousResponse.append(((Class)localObject).getName());
            paramAnonymousResponse.append('.');
            paramAnonymousResponse.append(paramAnonymousCall.getName());
            paramAnonymousResponse.append(" was null but response body type was declared as non-null");
            paramAnonymousCall = new KotlinNullPointerException(paramAnonymousResponse.toString());
            paramAnonymousResponse = (Continuation)this.$continuation;
            localObject = Result.Companion;
            paramAnonymousResponse.resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable)paramAnonymousCall)));
            return;
          }
          paramAnonymousCall = (Continuation)this.$continuation;
          localObject = Result.Companion;
          paramAnonymousCall.resumeWith(Result.constructor-impl(paramAnonymousResponse));
          return;
        }
        paramAnonymousCall = (Continuation)this.$continuation;
        paramAnonymousResponse = (Throwable)new HttpException(paramAnonymousResponse);
        Object localObject = Result.Companion;
        paramAnonymousCall.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramAnonymousResponse)));
      }
    });
    paramCall = localCancellableContinuationImpl.getResult();
    if (paramCall == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    return paramCall;
  }
  
  public static final <T> Object awaitNullable(Call<T> paramCall, Continuation<? super T> paramContinuation)
  {
    CancellableContinuationImpl localCancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(paramContinuation), 1);
    CancellableContinuation localCancellableContinuation = (CancellableContinuation)localCancellableContinuationImpl;
    localCancellableContinuation.invokeOnCancellation((Function1)new Lambda(paramCall)
    {
      public final void invoke(Throwable paramAnonymousThrowable)
      {
        this.$this_await$inlined.cancel();
      }
    });
    paramCall.enqueue((Callback)new Callback()
    {
      public void onFailure(Call<T> paramAnonymousCall, Throwable paramAnonymousThrowable)
      {
        Intrinsics.checkParameterIsNotNull(paramAnonymousCall, "call");
        Intrinsics.checkParameterIsNotNull(paramAnonymousThrowable, "t");
        paramAnonymousCall = (Continuation)this.$continuation;
        Result.Companion localCompanion = Result.Companion;
        paramAnonymousCall.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramAnonymousThrowable)));
      }
      
      public void onResponse(Call<T> paramAnonymousCall, Response<T> paramAnonymousResponse)
      {
        Intrinsics.checkParameterIsNotNull(paramAnonymousCall, "call");
        Intrinsics.checkParameterIsNotNull(paramAnonymousResponse, "response");
        if (paramAnonymousResponse.isSuccessful())
        {
          paramAnonymousCall = (Continuation)this.$continuation;
          paramAnonymousResponse = paramAnonymousResponse.body();
          localCompanion = Result.Companion;
          paramAnonymousCall.resumeWith(Result.constructor-impl(paramAnonymousResponse));
          return;
        }
        paramAnonymousCall = (Continuation)this.$continuation;
        paramAnonymousResponse = (Throwable)new HttpException(paramAnonymousResponse);
        Result.Companion localCompanion = Result.Companion;
        paramAnonymousCall.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramAnonymousResponse)));
      }
    });
    paramCall = localCancellableContinuationImpl.getResult();
    if (paramCall == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    return paramCall;
  }
  
  public static final <T> Object awaitResponse(Call<T> paramCall, Continuation<? super Response<T>> paramContinuation)
  {
    CancellableContinuationImpl localCancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(paramContinuation), 1);
    CancellableContinuation localCancellableContinuation = (CancellableContinuation)localCancellableContinuationImpl;
    localCancellableContinuation.invokeOnCancellation((Function1)new Lambda(paramCall)
    {
      public final void invoke(Throwable paramAnonymousThrowable)
      {
        this.$this_awaitResponse$inlined.cancel();
      }
    });
    paramCall.enqueue((Callback)new Callback()
    {
      public void onFailure(Call<T> paramAnonymousCall, Throwable paramAnonymousThrowable)
      {
        Intrinsics.checkParameterIsNotNull(paramAnonymousCall, "call");
        Intrinsics.checkParameterIsNotNull(paramAnonymousThrowable, "t");
        paramAnonymousCall = (Continuation)this.$continuation;
        Result.Companion localCompanion = Result.Companion;
        paramAnonymousCall.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramAnonymousThrowable)));
      }
      
      public void onResponse(Call<T> paramAnonymousCall, Response<T> paramAnonymousResponse)
      {
        Intrinsics.checkParameterIsNotNull(paramAnonymousCall, "call");
        Intrinsics.checkParameterIsNotNull(paramAnonymousResponse, "response");
        paramAnonymousCall = (Continuation)this.$continuation;
        Result.Companion localCompanion = Result.Companion;
        paramAnonymousCall.resumeWith(Result.constructor-impl(paramAnonymousResponse));
      }
    });
    paramCall = localCancellableContinuationImpl.getResult();
    if (paramCall == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    return paramCall;
  }
  
  public static final Object suspendAndThrow(final Exception paramException, Continuation<?> paramContinuation)
  {
    if ((paramContinuation instanceof suspendAndThrow.1))
    {
      localObject1 = (suspendAndThrow.1)paramContinuation;
      if ((((suspendAndThrow.1)localObject1).label & 0x80000000) != 0)
      {
        ((suspendAndThrow.1)localObject1).label += Integer.MIN_VALUE;
        paramContinuation = (Continuation<?>)localObject1;
        break label47;
      }
    }
    paramContinuation = new ContinuationImpl(paramContinuation)
    {
      Object L$0;
      int label;
      
      public final Object invokeSuspend(Object paramAnonymousObject)
      {
        this.result = paramAnonymousObject;
        this.label |= 0x80000000;
        return KotlinExtensions.suspendAndThrow(null, this);
      }
    };
    label47:
    Object localObject2 = paramContinuation.result;
    Object localObject1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    if (i != 0)
    {
      if (i == 1)
      {
        paramException = (Exception)paramContinuation.L$0;
        ResultKt.throwOnFailure(localObject2);
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(localObject2);
      paramContinuation.L$0 = paramException;
      paramContinuation.label = 1;
      paramContinuation = (Continuation)paramContinuation;
      Dispatchers.getDefault().dispatch(paramContinuation.getContext(), (Runnable)new Runnable()
      {
        public final void run()
        {
          Continuation localContinuation = IntrinsicsKt.intercepted(this.$continuation);
          Throwable localThrowable = (Throwable)paramException;
          Result.Companion localCompanion = Result.Companion;
          localContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(localThrowable)));
        }
      });
      paramException = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      if (paramException == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        DebugProbesKt.probeCoroutineSuspended(paramContinuation);
      }
      if (paramException == localObject1) {
        return localObject1;
      }
    }
    return Unit.INSTANCE;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\retrofit2\KotlinExtensions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */