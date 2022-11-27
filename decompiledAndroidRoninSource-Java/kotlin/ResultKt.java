package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000:\n\000\n\002\020\000\n\000\n\002\020\003\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\002\030\002\n\002\b\017\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\003\032\020\020\000\032\0020\0012\006\020\002\032\0020\003H\001\032+\020\004\032\b\022\004\022\002H\0060\005\"\004\b\000\020\0062\f\020\007\032\b\022\004\022\002H\0060\bH\bø\001\000¢\006\002\020\t\032\001\020\n\032\002H\006\"\004\b\000\020\006\"\004\b\001\020\013*\b\022\004\022\002H\0130\0052!\020\f\032\035\022\023\022\021H\013¢\006\f\b\016\022\b\b\017\022\004\b\b(\020\022\004\022\002H\0060\r2!\020\021\032\035\022\023\022\0210\003¢\006\f\b\016\022\b\b\017\022\004\b\b(\002\022\004\022\002H\0060\rH\bø\001\000\002\024\n\b\b\001\022\002\020\001 \000\n\b\b\001\022\002\020\002 \000¢\006\002\020\022\0323\020\023\032\002H\006\"\004\b\000\020\006\"\b\b\001\020\013*\002H\006*\b\022\004\022\002H\0130\0052\006\020\024\032\002H\006H\bø\001\000¢\006\002\020\025\032[\020\026\032\002H\006\"\004\b\000\020\006\"\b\b\001\020\013*\002H\006*\b\022\004\022\002H\0130\0052!\020\021\032\035\022\023\022\0210\003¢\006\f\b\016\022\b\b\017\022\004\b\b(\002\022\004\022\002H\0060\rH\bø\001\000\002\n\n\b\b\001\022\002\020\001 \000¢\006\002\020\027\032!\020\030\032\002H\013\"\004\b\000\020\013*\b\022\004\022\002H\0130\005H\bø\001\000¢\006\002\020\031\032]\020\032\032\b\022\004\022\002H\0060\005\"\004\b\000\020\006\"\004\b\001\020\013*\b\022\004\022\002H\0130\0052!\020\033\032\035\022\023\022\021H\013¢\006\f\b\016\022\b\b\017\022\004\b\b(\020\022\004\022\002H\0060\rH\bø\001\000\002\n\n\b\b\001\022\002\020\001 \000¢\006\002\020\027\032P\020\034\032\b\022\004\022\002H\0060\005\"\004\b\000\020\006\"\004\b\001\020\013*\b\022\004\022\002H\0130\0052!\020\033\032\035\022\023\022\021H\013¢\006\f\b\016\022\b\b\017\022\004\b\b(\020\022\004\022\002H\0060\rH\bø\001\000¢\006\002\020\027\032W\020\021\032\b\022\004\022\002H\0130\005\"\004\b\000\020\013*\b\022\004\022\002H\0130\0052!\020\035\032\035\022\023\022\0210\003¢\006\f\b\016\022\b\b\017\022\004\b\b(\002\022\004\022\0020\0360\rH\bø\001\000\002\n\n\b\b\001\022\002\020\001 \000¢\006\002\020\027\032W\020\f\032\b\022\004\022\002H\0130\005\"\004\b\000\020\013*\b\022\004\022\002H\0130\0052!\020\035\032\035\022\023\022\021H\013¢\006\f\b\016\022\b\b\017\022\004\b\b(\020\022\004\022\0020\0360\rH\bø\001\000\002\n\n\b\b\001\022\002\020\001 \000¢\006\002\020\027\032a\020\037\032\b\022\004\022\002H\0060\005\"\004\b\000\020\006\"\b\b\001\020\013*\002H\006*\b\022\004\022\002H\0130\0052!\020\033\032\035\022\023\022\0210\003¢\006\f\b\016\022\b\b\017\022\004\b\b(\002\022\004\022\002H\0060\rH\bø\001\000\002\n\n\b\b\001\022\002\020\001 \000¢\006\002\020\027\032T\020 \032\b\022\004\022\002H\0060\005\"\004\b\000\020\006\"\b\b\001\020\013*\002H\006*\b\022\004\022\002H\0130\0052!\020\033\032\035\022\023\022\0210\003¢\006\f\b\016\022\b\b\017\022\004\b\b(\002\022\004\022\002H\0060\rH\bø\001\000¢\006\002\020\027\032@\020\004\032\b\022\004\022\002H\0060\005\"\004\b\000\020\013\"\004\b\001\020\006*\002H\0132\027\020\007\032\023\022\004\022\002H\013\022\004\022\002H\0060\r¢\006\002\b!H\bø\001\000¢\006\002\020\027\032\030\020\"\032\0020\036*\006\022\002\b\0030\005H\001ø\001\000¢\006\002\020#\002\004\n\002\b\031¨\006$"}, d2={"createFailure", "", "exception", "", "runCatching", "Lkotlin/Result;", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "fold", "T", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "onFailure", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrThrow", "(Ljava/lang/Object;)Ljava/lang/Object;", "map", "transform", "mapCatching", "action", "", "recover", "recoverCatching", "Lkotlin/ExtensionFunctionType;", "throwOnFailure", "(Ljava/lang/Object;)V", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class ResultKt
{
  public static final Object createFailure(Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramThrowable, "exception");
    return new Result.Failure(paramThrowable);
  }
  
  private static final <R, T> R fold(Object paramObject, Function1<? super T, ? extends R> paramFunction1, Function1<? super Throwable, ? extends R> paramFunction11)
  {
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable == null) {
      return (R)paramFunction1.invoke(paramObject);
    }
    return (R)paramFunction11.invoke(localThrowable);
  }
  
  private static final <R, T extends R> R getOrDefault(Object paramObject, R paramR)
  {
    if (Result.isFailure-impl(paramObject)) {
      return paramR;
    }
    return (R)paramObject;
  }
  
  private static final <R, T extends R> R getOrElse(Object paramObject, Function1<? super Throwable, ? extends R> paramFunction1)
  {
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable == null) {
      return (R)paramObject;
    }
    return (R)paramFunction1.invoke(localThrowable);
  }
  
  private static final <T> T getOrThrow(Object paramObject)
  {
    throwOnFailure(paramObject);
    return (T)paramObject;
  }
  
  private static final <R, T> Object map(Object paramObject, Function1<? super T, ? extends R> paramFunction1)
  {
    if (Result.isSuccess-impl(paramObject))
    {
      Result.Companion localCompanion = Result.Companion;
      return Result.constructor-impl(paramFunction1.invoke(paramObject));
    }
    return Result.constructor-impl(paramObject);
  }
  
  private static final <R, T> Object mapCatching(Object paramObject, Function1<? super T, ? extends R> paramFunction1)
  {
    if (Result.isSuccess-impl(paramObject)) {
      try
      {
        Result.Companion localCompanion = Result.Companion;
        paramObject = Result.constructor-impl(paramFunction1.invoke(paramObject));
        return paramObject;
      }
      finally
      {
        paramFunction1 = Result.Companion;
        return Result.constructor-impl(createFailure((Throwable)paramObject));
      }
    }
    return Result.constructor-impl(paramObject);
  }
  
  private static final <T> Object onFailure(Object paramObject, Function1<? super Throwable, Unit> paramFunction1)
  {
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable != null) {
      paramFunction1.invoke(localThrowable);
    }
    return paramObject;
  }
  
  private static final <T> Object onSuccess(Object paramObject, Function1<? super T, Unit> paramFunction1)
  {
    if (Result.isSuccess-impl(paramObject)) {
      paramFunction1.invoke(paramObject);
    }
    return paramObject;
  }
  
  private static final <R, T extends R> Object recover(Object paramObject, Function1<? super Throwable, ? extends R> paramFunction1)
  {
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable == null) {
      return paramObject;
    }
    paramObject = Result.Companion;
    return Result.constructor-impl(paramFunction1.invoke(localThrowable));
  }
  
  private static final <R, T extends R> Object recoverCatching(Object paramObject, Function1<? super Throwable, ? extends R> paramFunction1)
  {
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable == null) {
      return paramObject;
    }
    try
    {
      paramObject = Result.Companion;
      paramObject = Result.constructor-impl(paramFunction1.invoke(localThrowable));
      return paramObject;
    }
    finally
    {
      paramFunction1 = Result.Companion;
    }
    return Result.constructor-impl(createFailure((Throwable)paramObject));
  }
  
  private static final <T, R> Object runCatching(T paramT, Function1<? super T, ? extends R> paramFunction1)
  {
    try
    {
      Result.Companion localCompanion = Result.Companion;
      paramT = Result.constructor-impl(paramFunction1.invoke(paramT));
      return paramT;
    }
    finally
    {
      paramFunction1 = Result.Companion;
    }
    return Result.constructor-impl(createFailure(paramT));
  }
  
  private static final <R> Object runCatching(Function0<? extends R> paramFunction0)
  {
    try
    {
      localCompanion = Result.Companion;
      paramFunction0 = Result.constructor-impl(paramFunction0.invoke());
      return paramFunction0;
    }
    finally
    {
      Result.Companion localCompanion = Result.Companion;
    }
    return Result.constructor-impl(createFailure(paramFunction0));
  }
  
  public static final void throwOnFailure(Object paramObject)
  {
    if (!(paramObject instanceof Result.Failure)) {
      return;
    }
    throw ((Result.Failure)paramObject).exception;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\ResultKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */