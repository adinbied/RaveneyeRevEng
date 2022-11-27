package kotlin.text;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\020\020\n\000\n\002\020\b\n\002\b\031\b\001\030\000 \0332\b\022\004\022\0020\0000\001:\001\033B\017\b\002\022\006\020\002\032\0020\003¢\006\002\020\004R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006j\002\b\007j\002\b\bj\002\b\tj\002\b\nj\002\b\013j\002\b\fj\002\b\rj\002\b\016j\002\b\017j\002\b\020j\002\b\021j\002\b\022j\002\b\023j\002\b\024j\002\b\025j\002\b\026j\002\b\027j\002\b\030j\002\b\031j\002\b\032¨\006\034"}, d2={"Lkotlin/text/CharDirectionality;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "UNDEFINED", "LEFT_TO_RIGHT", "RIGHT_TO_LEFT", "RIGHT_TO_LEFT_ARABIC", "EUROPEAN_NUMBER", "EUROPEAN_NUMBER_SEPARATOR", "EUROPEAN_NUMBER_TERMINATOR", "ARABIC_NUMBER", "COMMON_NUMBER_SEPARATOR", "NONSPACING_MARK", "BOUNDARY_NEUTRAL", "PARAGRAPH_SEPARATOR", "SEGMENT_SEPARATOR", "WHITESPACE", "OTHER_NEUTRALS", "LEFT_TO_RIGHT_EMBEDDING", "LEFT_TO_RIGHT_OVERRIDE", "RIGHT_TO_LEFT_EMBEDDING", "RIGHT_TO_LEFT_OVERRIDE", "POP_DIRECTIONAL_FORMAT", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public enum CharDirectionality
{
  public static final Companion Companion = new Companion(null);
  private static final Lazy directionalityMap$delegate = LazyKt.lazy((Function0)CharDirectionality.Companion.directionalityMap.2.INSTANCE);
  private final int value;
  
  static
  {
    CharDirectionality localCharDirectionality1 = new CharDirectionality("UNDEFINED", 0, -1);
    UNDEFINED = localCharDirectionality1;
    CharDirectionality localCharDirectionality2 = new CharDirectionality("LEFT_TO_RIGHT", 1, 0);
    LEFT_TO_RIGHT = localCharDirectionality2;
    CharDirectionality localCharDirectionality3 = new CharDirectionality("RIGHT_TO_LEFT", 2, 1);
    RIGHT_TO_LEFT = localCharDirectionality3;
    CharDirectionality localCharDirectionality4 = new CharDirectionality("RIGHT_TO_LEFT_ARABIC", 3, 2);
    RIGHT_TO_LEFT_ARABIC = localCharDirectionality4;
    CharDirectionality localCharDirectionality5 = new CharDirectionality("EUROPEAN_NUMBER", 4, 3);
    EUROPEAN_NUMBER = localCharDirectionality5;
    CharDirectionality localCharDirectionality6 = new CharDirectionality("EUROPEAN_NUMBER_SEPARATOR", 5, 4);
    EUROPEAN_NUMBER_SEPARATOR = localCharDirectionality6;
    CharDirectionality localCharDirectionality7 = new CharDirectionality("EUROPEAN_NUMBER_TERMINATOR", 6, 5);
    EUROPEAN_NUMBER_TERMINATOR = localCharDirectionality7;
    CharDirectionality localCharDirectionality8 = new CharDirectionality("ARABIC_NUMBER", 7, 6);
    ARABIC_NUMBER = localCharDirectionality8;
    CharDirectionality localCharDirectionality9 = new CharDirectionality("COMMON_NUMBER_SEPARATOR", 8, 7);
    COMMON_NUMBER_SEPARATOR = localCharDirectionality9;
    CharDirectionality localCharDirectionality10 = new CharDirectionality("NONSPACING_MARK", 9, 8);
    NONSPACING_MARK = localCharDirectionality10;
    CharDirectionality localCharDirectionality11 = new CharDirectionality("BOUNDARY_NEUTRAL", 10, 9);
    BOUNDARY_NEUTRAL = localCharDirectionality11;
    CharDirectionality localCharDirectionality12 = new CharDirectionality("PARAGRAPH_SEPARATOR", 11, 10);
    PARAGRAPH_SEPARATOR = localCharDirectionality12;
    CharDirectionality localCharDirectionality13 = new CharDirectionality("SEGMENT_SEPARATOR", 12, 11);
    SEGMENT_SEPARATOR = localCharDirectionality13;
    CharDirectionality localCharDirectionality14 = new CharDirectionality("WHITESPACE", 13, 12);
    WHITESPACE = localCharDirectionality14;
    CharDirectionality localCharDirectionality15 = new CharDirectionality("OTHER_NEUTRALS", 14, 13);
    OTHER_NEUTRALS = localCharDirectionality15;
    CharDirectionality localCharDirectionality16 = new CharDirectionality("LEFT_TO_RIGHT_EMBEDDING", 15, 14);
    LEFT_TO_RIGHT_EMBEDDING = localCharDirectionality16;
    CharDirectionality localCharDirectionality17 = new CharDirectionality("LEFT_TO_RIGHT_OVERRIDE", 16, 15);
    LEFT_TO_RIGHT_OVERRIDE = localCharDirectionality17;
    CharDirectionality localCharDirectionality18 = new CharDirectionality("RIGHT_TO_LEFT_EMBEDDING", 17, 16);
    RIGHT_TO_LEFT_EMBEDDING = localCharDirectionality18;
    CharDirectionality localCharDirectionality19 = new CharDirectionality("RIGHT_TO_LEFT_OVERRIDE", 18, 17);
    RIGHT_TO_LEFT_OVERRIDE = localCharDirectionality19;
    CharDirectionality localCharDirectionality20 = new CharDirectionality("POP_DIRECTIONAL_FORMAT", 19, 18);
    POP_DIRECTIONAL_FORMAT = localCharDirectionality20;
    $VALUES = new CharDirectionality[] { localCharDirectionality1, localCharDirectionality2, localCharDirectionality3, localCharDirectionality4, localCharDirectionality5, localCharDirectionality6, localCharDirectionality7, localCharDirectionality8, localCharDirectionality9, localCharDirectionality10, localCharDirectionality11, localCharDirectionality12, localCharDirectionality13, localCharDirectionality14, localCharDirectionality15, localCharDirectionality16, localCharDirectionality17, localCharDirectionality18, localCharDirectionality19, localCharDirectionality20 };
  }
  
  private CharDirectionality(int paramInt)
  {
    this.value = paramInt;
  }
  
  public final int getValue()
  {
    return this.value;
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\034\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020$\n\002\020\b\n\002\030\002\n\002\b\007\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\016\020\013\032\0020\0062\006\020\f\032\0020\005R'\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0060\0048BX\002¢\006\f\n\004\b\t\020\n\032\004\b\007\020\b¨\006\r"}, d2={"Lkotlin/text/CharDirectionality$Companion;", "", "()V", "directionalityMap", "", "", "Lkotlin/text/CharDirectionality;", "getDirectionalityMap", "()Ljava/util/Map;", "directionalityMap$delegate", "Lkotlin/Lazy;", "valueOf", "directionality", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    private final Map<Integer, CharDirectionality> getDirectionalityMap()
    {
      Lazy localLazy = CharDirectionality.access$getDirectionalityMap$cp();
      Object localObject = CharDirectionality.Companion;
      localObject = $$delegatedProperties[0];
      return (Map)localLazy.getValue();
    }
    
    public final CharDirectionality valueOf(int paramInt)
    {
      Object localObject = (CharDirectionality)((Companion)this).getDirectionalityMap().get(Integer.valueOf(paramInt));
      if (localObject != null) {
        return (CharDirectionality)localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Directionality #");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" is not defined.");
      throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString()));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\text\CharDirectionality.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */