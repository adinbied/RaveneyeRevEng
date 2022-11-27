package io.flutter.plugin.editing;

import android.content.Context;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputMethodManager;
import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;

class InputConnectionAdaptor
  extends BaseInputConnection
{
  private final boolean isSamsung;
  private int mBatchCount;
  private final int mClient;
  private final Editable mEditable;
  private final EditorInfo mEditorInfo;
  private final View mFlutterView;
  private InputMethodManager mImm;
  private final Layout mLayout;
  private final TextInputChannel textInputChannel;
  
  public InputConnectionAdaptor(View paramView, int paramInt, TextInputChannel paramTextInputChannel, Editable paramEditable, EditorInfo paramEditorInfo)
  {
    super(paramView, true);
    this.mFlutterView = paramView;
    this.mClient = paramInt;
    this.textInputChannel = paramTextInputChannel;
    this.mEditable = paramEditable;
    this.mEditorInfo = paramEditorInfo;
    this.mBatchCount = 0;
    this.mLayout = new DynamicLayout(this.mEditable, new TextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.mImm = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
    this.isSamsung = isSamsung();
  }
  
  private static int clampIndexToEditable(int paramInt, Editable paramEditable)
  {
    int i = Math.max(0, Math.min(paramEditable.length(), paramInt));
    if (i != paramInt)
    {
      paramEditable = new StringBuilder();
      paramEditable.append("Text selection index was clamped (");
      paramEditable.append(paramInt);
      paramEditable.append("->");
      paramEditable.append(i);
      paramEditable.append(") to remain in bounds. This may not be your fault, as some keyboards may select outside of bounds.");
      Log.d("flutter", paramEditable.toString());
    }
    return i;
  }
  
  private boolean isSamsung()
  {
    return false;
  }
  
  /* Error */
  private void updateEditingState()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean beginBatchEdit()
  {
    return false;
  }
  
  public boolean commitText(CharSequence paramCharSequence, int paramInt)
  {
    boolean bool = super.commitText(paramCharSequence, paramInt);
    updateEditingState();
    return bool;
  }
  
  public boolean deleteSurroundingText(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean endBatchEdit()
  {
    return false;
  }
  
  public boolean finishComposingText()
  {
    return false;
  }
  
  public Editable getEditable()
  {
    return this.mEditable;
  }
  
  public ExtractedText getExtractedText(ExtractedTextRequest paramExtractedTextRequest, int paramInt)
  {
    paramExtractedTextRequest = new ExtractedText();
    paramExtractedTextRequest.selectionStart = Selection.getSelectionStart(this.mEditable);
    paramExtractedTextRequest.selectionEnd = Selection.getSelectionEnd(this.mEditable);
    paramExtractedTextRequest.text = this.mEditable.toString();
    return paramExtractedTextRequest;
  }
  
  public boolean performContextMenuAction(int paramInt)
  {
    return false;
  }
  
  public boolean performEditorAction(int paramInt)
  {
    return false;
  }
  
  public boolean sendKeyEvent(KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean setComposingRegion(int paramInt1, int paramInt2)
  {
    boolean bool = super.setComposingRegion(paramInt1, paramInt2);
    updateEditingState();
    return bool;
  }
  
  public boolean setComposingText(CharSequence paramCharSequence, int paramInt)
  {
    return false;
  }
  
  public boolean setSelection(int paramInt1, int paramInt2)
  {
    boolean bool = super.setSelection(paramInt1, paramInt2);
    updateEditingState();
    return bool;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\plugin\editing\InputConnectionAdaptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */