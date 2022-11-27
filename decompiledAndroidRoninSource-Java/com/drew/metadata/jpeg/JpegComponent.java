package com.drew.metadata.jpeg;

import java.io.Serializable;

public class JpegComponent
  implements Serializable
{
  private static final long serialVersionUID = 61121257899091914L;
  private final int _componentId;
  private final int _quantizationTableNumber;
  private final int _samplingFactorByte;
  
  public JpegComponent(int paramInt1, int paramInt2, int paramInt3)
  {
    this._componentId = paramInt1;
    this._samplingFactorByte = paramInt2;
    this._quantizationTableNumber = paramInt3;
  }
  
  public int getComponentId()
  {
    return this._componentId;
  }
  
  public String getComponentName()
  {
    return null;
  }
  
  public int getHorizontalSamplingFactor()
  {
    return this._samplingFactorByte >> 4 & 0xF;
  }
  
  public int getQuantizationTableNumber()
  {
    return this._quantizationTableNumber;
  }
  
  public int getVerticalSamplingFactor()
  {
    return this._samplingFactorByte & 0xF;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\jpeg\JpegComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */