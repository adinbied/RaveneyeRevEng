package dji.common.remotecontroller;

import dji.common.Stick;
import dji.midware.data.config.P3.ProductType;

public class HardwareState
{
  private Button c1Button;
  private Button c2Button;
  private FiveDButton fiveDButton;
  private FlightModeSwitch flightModeSwitch;
  private Button goHomeButton;
  private Stick left;
  private int leftWheel;
  private Button pauseButton;
  private Button playbackButton;
  private Button recordButton;
  private Stick right;
  private RightWheel rightWheel;
  private Button shutterButton;
  private TransformationSwitch transformationSwitch;
  
  private HardwareState(Builder paramBuilder)
  {
    this.left = paramBuilder.left;
    this.right = paramBuilder.right;
    this.leftWheel = paramBuilder.leftWheel;
    this.rightWheel = paramBuilder.rightWheel;
    this.transformationSwitch = paramBuilder.transformationSwitch;
    this.flightModeSwitch = paramBuilder.flightModeSwitch;
    this.goHomeButton = paramBuilder.goHomeButton;
    this.recordButton = paramBuilder.recordButton;
    this.shutterButton = paramBuilder.shutterButton;
    this.playbackButton = paramBuilder.playbackButton;
    this.pauseButton = paramBuilder.pauseButton;
    this.c1Button = paramBuilder.c1Button;
    this.c2Button = paramBuilder.c2Button;
    this.fiveDButton = paramBuilder.fiveDButton;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public Button getC1Button()
  {
    return this.c1Button;
  }
  
  public Button getC2Button()
  {
    return this.c2Button;
  }
  
  public FiveDButton getFiveDButton()
  {
    return this.fiveDButton;
  }
  
  public FlightModeSwitch getFlightModeSwitch()
  {
    return this.flightModeSwitch;
  }
  
  public Button getGoHomeButton()
  {
    return this.goHomeButton;
  }
  
  public Stick getLeftStick()
  {
    return this.left;
  }
  
  public int getLeftWheel()
  {
    return this.leftWheel;
  }
  
  public Button getPauseButton()
  {
    return this.pauseButton;
  }
  
  public Button getPlaybackButton()
  {
    return this.playbackButton;
  }
  
  public Button getRecordButton()
  {
    return this.recordButton;
  }
  
  public Stick getRightStick()
  {
    return this.right;
  }
  
  public RightWheel getRightWheel()
  {
    return this.rightWheel;
  }
  
  public Button getShutterButton()
  {
    return this.shutterButton;
  }
  
  public TransformationSwitch getTransformationSwitch()
  {
    return this.transformationSwitch;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public void setC1Button(Button paramButton)
  {
    this.c1Button = paramButton;
  }
  
  public void setC2Button(Button paramButton)
  {
    this.c2Button = paramButton;
  }
  
  public void setFiveDButton(FiveDButton paramFiveDButton)
  {
    this.fiveDButton = paramFiveDButton;
  }
  
  public void setFlightModeSwitch(FlightModeSwitch paramFlightModeSwitch)
  {
    this.flightModeSwitch = paramFlightModeSwitch;
  }
  
  public void setGoHomeButton(Button paramButton)
  {
    this.goHomeButton = paramButton;
  }
  
  public void setLeft(Stick paramStick)
  {
    this.left = paramStick;
  }
  
  public void setLeftWheel(int paramInt)
  {
    this.leftWheel = paramInt;
  }
  
  public void setPauseButton(Button paramButton)
  {
    this.pauseButton = paramButton;
  }
  
  public void setPlaybackButton(Button paramButton)
  {
    this.playbackButton = paramButton;
  }
  
  public void setRecordButton(Button paramButton)
  {
    this.recordButton = paramButton;
  }
  
  public void setRight(Stick paramStick)
  {
    this.right = paramStick;
  }
  
  public void setRightWheel(RightWheel paramRightWheel)
  {
    this.rightWheel = paramRightWheel;
  }
  
  public void setShutterButton(Button paramButton)
  {
    this.shutterButton = paramButton;
  }
  
  public void setTransformationSwitch(TransformationSwitch paramTransformationSwitch)
  {
    this.transformationSwitch = paramTransformationSwitch;
  }
  
  public static final class Builder
  {
    private HardwareState.Button c1Button = new HardwareState.Button(false, false);
    private HardwareState.Button c2Button = new HardwareState.Button(false, false);
    private HardwareState.FiveDButton fiveDButton = new HardwareState.FiveDButton(false);
    private HardwareState.FlightModeSwitch flightModeSwitch;
    private HardwareState.Button goHomeButton = new HardwareState.Button(false, false);
    private Stick left;
    private int leftWheel;
    private HardwareState.Button pauseButton = new HardwareState.Button(false, false);
    private HardwareState.Button playbackButton = new HardwareState.Button(false, false);
    private HardwareState.Button recordButton = new HardwareState.Button(false, false);
    private Stick right;
    private HardwareState.RightWheel rightWheel = new HardwareState.RightWheel();
    private HardwareState.Button shutterButton = new HardwareState.Button(false, false);
    private HardwareState.TransformationSwitch transformationSwitch = new HardwareState.TransformationSwitch();
    
    public HardwareState build()
    {
      return new HardwareState(this, null);
    }
    
    public Builder c1Button(HardwareState.Button paramButton)
    {
      this.c1Button = paramButton;
      return this;
    }
    
    public Builder c2Button(HardwareState.Button paramButton)
    {
      this.c2Button = paramButton;
      return this;
    }
    
    public Builder fiveDButton(HardwareState.FiveDButton paramFiveDButton)
    {
      this.fiveDButton = paramFiveDButton;
      return this;
    }
    
    public Builder flightModeSwitch(HardwareState.FlightModeSwitch paramFlightModeSwitch)
    {
      this.flightModeSwitch = paramFlightModeSwitch;
      return this;
    }
    
    public Builder goHomeButton(HardwareState.Button paramButton)
    {
      this.goHomeButton = paramButton;
      return this;
    }
    
    public Builder leftStick(Stick paramStick)
    {
      this.left = paramStick;
      return this;
    }
    
    public Builder leftWheel(int paramInt)
    {
      this.leftWheel = paramInt;
      return this;
    }
    
    public Builder pauseButton(HardwareState.Button paramButton)
    {
      this.pauseButton = paramButton;
      return this;
    }
    
    public Builder playbackButton(HardwareState.Button paramButton)
    {
      this.playbackButton = paramButton;
      return this;
    }
    
    public Builder recordButton(HardwareState.Button paramButton)
    {
      this.recordButton = paramButton;
      return this;
    }
    
    public Builder rightStick(Stick paramStick)
    {
      this.right = paramStick;
      return this;
    }
    
    public Builder rightWheel(HardwareState.RightWheel paramRightWheel)
    {
      this.rightWheel = paramRightWheel;
      return this;
    }
    
    public Builder shutterButton(HardwareState.Button paramButton)
    {
      this.shutterButton = paramButton;
      return this;
    }
    
    public Builder transformationSwitch(HardwareState.TransformationSwitch paramTransformationSwitch)
    {
      this.transformationSwitch = paramTransformationSwitch;
      return this;
    }
  }
  
  public static class Button
  {
    private boolean clicked;
    private boolean present;
    
    public Button() {}
    
    public Button(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.present = paramBoolean1;
      this.clicked = paramBoolean2;
    }
    
    public boolean equals(Object paramObject)
    {
      return false;
    }
    
    public int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public boolean isClicked()
    {
      return this.clicked;
    }
    
    public boolean isPresent()
    {
      return this.present;
    }
    
    public void setClicked(boolean paramBoolean)
    {
      this.clicked = paramBoolean;
    }
    
    public void setPresent(boolean paramBoolean)
    {
      this.present = paramBoolean;
    }
  }
  
  public static class FiveDButton
    extends HardwareState.Button
  {
    private boolean clicked;
    private HardwareState.FiveDButtonDirection horizontalDirection;
    private boolean present;
    private HardwareState.FiveDButtonDirection verticalDirection;
    
    public FiveDButton(boolean paramBoolean)
    {
      this.present = paramBoolean;
    }
    
    public FiveDButton(boolean paramBoolean1, boolean paramBoolean2)
    {
      super(paramBoolean2);
      this.present = paramBoolean1;
      this.clicked = paramBoolean2;
    }
    
    public FiveDButton(boolean paramBoolean1, boolean paramBoolean2, HardwareState.FiveDButtonDirection paramFiveDButtonDirection1, HardwareState.FiveDButtonDirection paramFiveDButtonDirection2)
    {
      this.clicked = paramBoolean1;
      this.present = paramBoolean2;
      this.verticalDirection = paramFiveDButtonDirection1;
      this.horizontalDirection = paramFiveDButtonDirection2;
    }
    
    public boolean equals(Object paramObject)
    {
      return false;
    }
    
    public HardwareState.FiveDButtonDirection getHorizontalDirection()
    {
      return this.horizontalDirection;
    }
    
    public HardwareState.FiveDButtonDirection getVerticalDirection()
    {
      return this.verticalDirection;
    }
    
    public int hashCode()
    {
      return 0;
    }
    
    public boolean isClicked()
    {
      return this.clicked;
    }
    
    public boolean isPresent()
    {
      return this.present;
    }
    
    public void setClicked(boolean paramBoolean)
    {
      this.clicked = paramBoolean;
    }
    
    public void setHorizontalDirection(HardwareState.FiveDButtonDirection paramFiveDButtonDirection)
    {
      this.horizontalDirection = paramFiveDButtonDirection;
    }
    
    public void setPresent(boolean paramBoolean)
    {
      this.present = paramBoolean;
    }
    
    public void setVerticalDirection(HardwareState.FiveDButtonDirection paramFiveDButtonDirection)
    {
      this.verticalDirection = paramFiveDButtonDirection;
    }
  }
  
  public static enum FiveDButtonDirection
  {
    private int value;
    
    static
    {
      FiveDButtonDirection localFiveDButtonDirection = new FiveDButtonDirection("NEGATIVE", 2, 2);
      NEGATIVE = localFiveDButtonDirection;
      $VALUES = new FiveDButtonDirection[] { MIDDLE, POSITIVE, localFiveDButtonDirection };
    }
    
    private FiveDButtonDirection(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static FiveDButtonDirection find(int paramInt)
    {
      FiveDButtonDirection localFiveDButtonDirection = MIDDLE;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localFiveDButtonDirection;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum FlightModeSwitch
  {
    private int value;
    
    static
    {
      FlightModeSwitch localFlightModeSwitch = new FlightModeSwitch("POSITION_THREE", 2, 2);
      POSITION_THREE = localFlightModeSwitch;
      $VALUES = new FlightModeSwitch[] { POSITION_ONE, POSITION_TWO, localFlightModeSwitch };
    }
    
    private FlightModeSwitch(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static FlightModeSwitch find(ProductType paramProductType, int paramInt)
    {
      if ((paramProductType != ProductType.KumquatS) && (paramProductType != ProductType.KumquatX))
      {
        if (paramInt != 0)
        {
          if (paramInt != 1)
          {
            if (paramInt != 2) {
              return POSITION_ONE;
            }
            return POSITION_ONE;
          }
          return POSITION_THREE;
        }
        return POSITION_TWO;
      }
      if (paramInt != 0)
      {
        if (paramInt != 1) {
          return POSITION_ONE;
        }
        return POSITION_TWO;
      }
      return POSITION_ONE;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static abstract interface HardwareStateCallback
  {
    public abstract void onUpdate(HardwareState paramHardwareState);
  }
  
  public static class RightWheel
    extends HardwareState.Button
  {
    private boolean isTurned;
    private int value;
    
    public RightWheel() {}
    
    public RightWheel(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
    {
      this.isTurned = paramBoolean1;
      super.setClicked(paramBoolean2);
      this.value = paramInt;
    }
    
    public RightWheel(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
    {
      this.isTurned = paramBoolean2;
      HardwareState.Button.access$1502(this, paramBoolean1);
      super.setClicked(paramBoolean3);
      this.value = paramInt;
    }
    
    public boolean equals(Object paramObject)
    {
      return false;
    }
    
    public int getValue()
    {
      return this.value;
    }
    
    public int hashCode()
    {
      return 0;
    }
    
    public boolean isTurned()
    {
      return this.isTurned;
    }
    
    public String toString()
    {
      return null;
    }
  }
  
  public static class TransformationSwitch
  {
    private boolean isPresent;
    private State state;
    
    public TransformationSwitch() {}
    
    public TransformationSwitch(State paramState)
    {
      this.state = paramState;
    }
    
    public TransformationSwitch(boolean paramBoolean, State paramState)
    {
      this.isPresent = paramBoolean;
      this.state = paramState;
    }
    
    public boolean equals(Object paramObject)
    {
      return false;
    }
    
    public State getState()
    {
      return this.state;
    }
    
    public int hashCode()
    {
      return 0;
    }
    
    public boolean isPresent()
    {
      return this.isPresent;
    }
    
    public TransformationSwitch setPresent(boolean paramBoolean)
    {
      this.isPresent = paramBoolean;
      return this;
    }
    
    public void setState(State paramState)
    {
      this.state = paramState;
    }
    
    public static enum State
    {
      private int value;
      
      static
      {
        State localState = new State("DEPLOY", 1, 1);
        DEPLOY = localState;
        $VALUES = new State[] { RETRACT, localState };
      }
      
      private State(int paramInt)
      {
        this.value = paramInt;
      }
      
      private boolean _equals(int paramInt)
      {
        return this.value == paramInt;
      }
      
      public static State find(int paramInt)
      {
        State localState = RETRACT;
        int i = 0;
        while (i < values().length)
        {
          if (values()[i]._equals(paramInt)) {
            return values()[i];
          }
          i += 1;
        }
        return localState;
      }
      
      public int value()
      {
        return this.value;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\remotecontroller\HardwareState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */