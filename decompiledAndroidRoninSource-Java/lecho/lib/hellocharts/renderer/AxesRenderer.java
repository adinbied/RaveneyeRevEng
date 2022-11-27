package lecho.lib.hellocharts.renderer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import java.lang.reflect.Array;
import lecho.lib.hellocharts.computator.ChartComputator;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.util.AxisAutoValues;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.Chart;

public class AxesRenderer
{
  private static final int BOTTOM = 3;
  private static final int DEFAULT_AXIS_MARGIN_DP = 2;
  private static final int LEFT = 1;
  private static final int RIGHT = 2;
  private static final int TOP = 0;
  private static final char[] labelWidthChars = { 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48 };
  private AxisAutoValues[] autoValuesBufferTab;
  private float[][] autoValuesToDrawTab;
  private int axisMargin;
  private Chart chart;
  private ChartComputator computator;
  private float density;
  private Paint.FontMetricsInt[] fontMetricsTab;
  private float[] labelBaselineTab;
  private char[] labelBuffer;
  private int[] labelDimensionForMarginsTab;
  private int[] labelDimensionForStepsTab;
  private Paint[] labelPaintTab;
  private int[] labelTextAscentTab;
  private int[] labelTextDescentTab;
  private int[] labelWidthTab;
  private Paint[] linePaintTab;
  private float[][] linesDrawBufferTab;
  private float[] nameBaselineTab;
  private Paint[] namePaintTab;
  private float[][] rawValuesTab;
  private float scaledDensity;
  private float[] separationLineTab;
  private int[] tiltedLabelXTranslation;
  private int[] tiltedLabelYTranslation;
  private int[] valuesToDrawNumTab;
  private AxisValue[][] valuesToDrawTab;
  
  public AxesRenderer(Context paramContext, Chart paramChart)
  {
    Paint localPaint = new Paint();
    int i = 0;
    this.labelPaintTab = new Paint[] { localPaint, new Paint(), new Paint(), new Paint() };
    this.namePaintTab = new Paint[] { new Paint(), new Paint(), new Paint(), new Paint() };
    this.linePaintTab = new Paint[] { new Paint(), new Paint(), new Paint(), new Paint() };
    this.nameBaselineTab = new float[4];
    this.labelBaselineTab = new float[4];
    this.separationLineTab = new float[4];
    this.labelWidthTab = new int[4];
    this.labelTextAscentTab = new int[4];
    this.labelTextDescentTab = new int[4];
    this.labelDimensionForMarginsTab = new int[4];
    this.labelDimensionForStepsTab = new int[4];
    this.tiltedLabelXTranslation = new int[4];
    this.tiltedLabelYTranslation = new int[4];
    this.fontMetricsTab = new Paint.FontMetricsInt[] { new Paint.FontMetricsInt(), new Paint.FontMetricsInt(), new Paint.FontMetricsInt(), new Paint.FontMetricsInt() };
    this.labelBuffer = new char[64];
    this.valuesToDrawNumTab = new int[4];
    this.rawValuesTab = ((float[][])Array.newInstance(Float.TYPE, new int[] { 4, 0 }));
    this.autoValuesToDrawTab = ((float[][])Array.newInstance(Float.TYPE, new int[] { 4, 0 }));
    this.valuesToDrawTab = ((AxisValue[][])Array.newInstance(AxisValue.class, new int[] { 4, 0 }));
    this.linesDrawBufferTab = ((float[][])Array.newInstance(Float.TYPE, new int[] { 4, 0 }));
    this.autoValuesBufferTab = new AxisAutoValues[] { new AxisAutoValues(), new AxisAutoValues(), new AxisAutoValues(), new AxisAutoValues() };
    this.chart = paramChart;
    this.computator = paramChart.getChartComputator();
    this.density = paramContext.getResources().getDisplayMetrics().density;
    this.scaledDensity = paramContext.getResources().getDisplayMetrics().scaledDensity;
    this.axisMargin = ChartUtils.dp2px(this.density, 2);
    while (i < 4)
    {
      this.labelPaintTab[i].setStyle(Paint.Style.FILL);
      this.labelPaintTab[i].setAntiAlias(true);
      this.namePaintTab[i].setStyle(Paint.Style.FILL);
      this.namePaintTab[i].setAntiAlias(true);
      this.linePaintTab[i].setStyle(Paint.Style.STROKE);
      this.linePaintTab[i].setAntiAlias(true);
      i += 1;
    }
  }
  
  private boolean checkRawValue(Rect paramRect, float paramFloat, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    return false;
  }
  
  /* Error */
  private void drawAxisLabelsAndName(android.graphics.Canvas arg1, Axis arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void drawAxisLines(android.graphics.Canvas arg1, Axis arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private int getAxisNameMargin(Axis paramAxis, int paramInt)
  {
    return 0;
  }
  
  private void initAxis(Axis paramAxis, int paramInt)
  {
    if (paramAxis == null) {
      return;
    }
    initAxisAttributes(paramAxis, paramInt);
    initAxisMargin(paramAxis, paramInt);
    initAxisMeasurements(paramAxis, paramInt);
  }
  
  /* Error */
  private void initAxisAttributes(Axis arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void initAxisDimension(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void initAxisDimensionForTiltedLabels(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void initAxisMargin(Axis arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void initAxisMeasurements(Axis arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void initAxisPaints(Axis arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void initAxisTextAlignment(Axis arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void insetContentRectWithAxesMargins(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void intiTiltedLabelsTranslation(Axis arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean isAxisVertical(int paramInt)
  {
    return false;
  }
  
  /* Error */
  private void onChartDataOrSizeChanged()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void prepareAutoGeneratedAxis(Axis arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void prepareAxisToDraw(Axis arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void prepareCustomAxis(Axis arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void drawInBackground(android.graphics.Canvas arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void drawInForeground(android.graphics.Canvas arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onChartDataChanged()
  {
    onChartDataOrSizeChanged();
  }
  
  public void onChartSizeChanged()
  {
    onChartDataOrSizeChanged();
  }
  
  /* Error */
  public void resetRenderer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\renderer\AxesRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */