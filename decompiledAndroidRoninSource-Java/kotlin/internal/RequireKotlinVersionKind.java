package kotlin.internal;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\f\n\002\030\002\n\002\020\020\n\002\b\005\b\001\030\0002\b\022\004\022\0020\0000\001B\007\b\002¢\006\002\020\002j\002\b\003j\002\b\004j\002\b\005¨\006\006"}, d2={"Lkotlin/internal/RequireKotlinVersionKind;", "", "(Ljava/lang/String;I)V", "LANGUAGE_VERSION", "COMPILER_VERSION", "API_VERSION", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public enum RequireKotlinVersionKind
{
  static
  {
    RequireKotlinVersionKind localRequireKotlinVersionKind1 = new RequireKotlinVersionKind("LANGUAGE_VERSION", 0);
    LANGUAGE_VERSION = localRequireKotlinVersionKind1;
    RequireKotlinVersionKind localRequireKotlinVersionKind2 = new RequireKotlinVersionKind("COMPILER_VERSION", 1);
    COMPILER_VERSION = localRequireKotlinVersionKind2;
    RequireKotlinVersionKind localRequireKotlinVersionKind3 = new RequireKotlinVersionKind("API_VERSION", 2);
    API_VERSION = localRequireKotlinVersionKind3;
    $VALUES = new RequireKotlinVersionKind[] { localRequireKotlinVersionKind1, localRequireKotlinVersionKind2, localRequireKotlinVersionKind3 };
  }
  
  private RequireKotlinVersionKind() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\internal\RequireKotlinVersionKind.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */