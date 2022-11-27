package lecho.lib.hellocharts.renderer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import lecho.lib.hellocharts.formatter.PieChartValueFormatter;
import lecho.lib.hellocharts.model.SelectedValue;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.provider.PieChartDataProvider;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.Chart;

public class PieChartRenderer
  extends AbstractChartRenderer
{
  private static final float DEFAULT_LABEL_INSIDE_RADIUS_FACTOR = 0.7F;
  private static final float DEFAULT_LABEL_OUTSIDE_RADIUS_FACTOR = 1.0F;
  private static final int DEFAULT_START_ROTATION = 45;
  private static final int DEFAULT_TOUCH_ADDITIONAL_DP = 8;
  private static final float MAX_WIDTH_HEIGHT = 100.0F;
  private static final int MODE_DRAW = 0;
  private static final int MODE_HIGHLIGHT = 1;
  private Paint centerCirclePaint = new Paint();
  private float centerCircleScale;
  private Paint.FontMetricsInt centerCircleText1FontMetrics = new Paint.FontMetricsInt();
  private Paint centerCircleText1Paint = new Paint();
  private Paint.FontMetricsInt centerCircleText2FontMetrics = new Paint.FontMetricsInt();
  private Paint centerCircleText2Paint = new Paint();
  private float circleFillRatio = 1.0F;
  private PieChartDataProvider dataProvider;
  private RectF drawCircleOval = new RectF();
  private boolean hasCenterCircle;
  private boolean hasLabels;
  private boolean hasLabelsOnlyForSelected;
  private boolean hasLabelsOutside;
  private float maxSum;
  private RectF originCircleOval = new RectF();
  private int rotation = 45;
  private Paint separationLinesPaint = new Paint();
  private Paint slicePaint = new Paint();
  private PointF sliceVector = new PointF();
  private Bitmap softwareBitmap;
  private Canvas softwareCanvas = new Canvas();
  private Viewport tempMaximumViewport = new Viewport();
  private int touchAdditional;
  private PieChartValueFormatter valueFormatter;
  
  public PieChartRenderer(Context paramContext, Chart paramChart, PieChartDataProvider paramPieChartDataProvider)
  {
    super(paramContext, paramChart);
    this.dataProvider = paramPieChartDataProvider;
    this.touchAdditional = ChartUtils.dp2px(this.density, 8);
    this.slicePaint.setAntiAlias(true);
    this.slicePaint.setStyle(Paint.Style.FILL);
    this.centerCirclePaint.setAntiAlias(true);
    this.centerCirclePaint.setStyle(Paint.Style.FILL);
    this.centerCirclePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    this.centerCircleText1Paint.setAntiAlias(true);
    this.centerCircleText1Paint.setTextAlign(Paint.Align.CENTER);
    this.centerCircleText2Paint.setAntiAlias(true);
    this.centerCircleText2Paint.setTextAlign(Paint.Align.CENTER);
    this.separationLinesPaint.setAntiAlias(true);
    this.separationLinesPaint.setStyle(Paint.Style.STROKE);
    this.separationLinesPaint.setStrokeCap(Paint.Cap.ROUND);
    this.separationLinesPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.separationLinesPaint.setColor(0);
  }
  
  /* Error */
  private void calculateCircleOval()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void calculateMaxViewport()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void drawCenterCircle(Canvas arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void drawLabel(Canvas arg1, SliceValue arg2, float arg3, float arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void drawSeparationLines(Canvas arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void drawSlice(Canvas arg1, SliceValue arg2, float arg3, float arg4, int arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void drawSlices(Canvas arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void normalizeVector(PointF arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private float pointToAngle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return 0.0F;
  }
  
  public boolean checkTouch(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  /* Error */
  public void draw(Canvas arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void drawLabels(Canvas arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void drawUnclipped(Canvas paramCanvas) {}
  
  public int getChartRotation()
  {
    return this.rotation;
  }
  
  public float getCircleFillRatio()
  {
    return this.circleFillRatio;
  }
  
  public RectF getCircleOval()
  {
    return this.originCircleOval;
  }
  
  public SliceValue getValueForAngle(int paramInt, SelectedValue paramSelectedValue)
  {
    return null;
  }
  
  /* Error */
  public void onChartDataChanged()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onChartSizeChanged()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onChartViewportChanged()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setChartRotation(int paramInt)
  {
    this.rotation = ((paramInt % 360 + 360) % 360);
  }
  
  /* Error */
  public void setCircleFillRatio(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setCircleOval(RectF paramRectF)
  {
    this.originCircleOval = paramRectF;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\renderer\PieChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */