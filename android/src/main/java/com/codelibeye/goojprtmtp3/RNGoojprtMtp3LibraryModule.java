
package com.codelibeye.goojprtmtp3;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.ParcelFileDescriptor;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.github.barteksc.pdfviewer.util.FileUtils;
import com.lvrenyang.io.BTPrinting;
import com.lvrenyang.io.Page;
import com.lvrenyang.io.Pos;
import com.lvrenyang.io.base.IOCallBack;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RNGoojprtMtp3LibraryModule extends ReactContextBaseJavaModule implements IOCallBack {

  private final ReactApplicationContext reactContext;

  private BroadcastReceiver broadcastReceiver = null;
  private IntentFilter intentFilter = null;
  private Pos mPos = new Pos();
  private BTPrinting mBt = new BTPrinting();
  private Page mPage = new Page();
  private ExecutorService es = Executors.newScheduledThreadPool(30);

  public RNGoojprtMtp3LibraryModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;

    mPage.Set(mBt);
    mBt.SetCallBack(this);
  }

  @Override
  public String getName() {
    return "RNGoojprtMtp3Library";
  }

  @ReactMethod
  public void print(String mac_addr, String path, Callback successCallback, Callback errorCallback) {
    mBt.Open(mac_addr, reactContext);
    Bitmap bmp = filetoBitmap(path);
//    Bitmap bmp = base64toBitmap(base64);
    if (bmp != null) {
      mBt.Open(mac_addr, reactContext);
      mPos.Set(mBt);
      es.submit(new TaskPrint(mPos, bmp));
      successCallback.invoke("Success");
    } else {
      errorCallback.invoke("File cannot be found");
    }
  }

  public class TaskPrint implements Runnable
  {
    Pos pos = null;
    Bitmap bmp = null;

    public TaskPrint(Pos pos, Bitmap bmp)
    {
      this.pos = pos;
      this.bmp = bmp;
    }

    @Override
    public void run() {
      pos.POS_PrintPicture(bmp, 576, 0, 1);
//      pos.POS_Beep(1, 5);
//      pos.POS_KickDrawer(0, 1000);
      pos.POS_TicketSucceed(0, 30000);

    }
  }

  private Bitmap filetoBitmap(String path) {
    int pageNumber = 0;
    PdfiumCore pdfiumCore = new PdfiumCore(reactContext);
    try {
      File f = new File(path);
//      byte[] data = getByte(path);
      ParcelFileDescriptor fd = ParcelFileDescriptor.open(f, ParcelFileDescriptor.MODE_READ_ONLY);
      PdfDocument pdfDocument = pdfiumCore.newDocument(fd);
      pdfiumCore.openPage(pdfDocument, pageNumber);
      int width = pdfiumCore.getPageWidthPoint(pdfDocument, pageNumber);
      int height = pdfiumCore.getPageHeightPoint(pdfDocument, pageNumber);
      Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
      pdfiumCore.renderPageBitmap(pdfDocument, bmp, pageNumber, 0, 0, width, height);
      pdfiumCore.closeDocument(pdfDocument);

      return bmp;
    } catch(Exception e) {
      //todo with exception
      e.printStackTrace();
    }
    return null;
  }

  private byte[] getByte(String path) {
    byte[] getBytes = {};
    try {
      File file = new File(path);
      getBytes = new byte[(int) file.length()];
      InputStream is = new FileInputStream(file);
      is.read(getBytes);
      is.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return getBytes;
  }

  @Override
  public void OnOpen() {

  }

  @Override
  public void OnOpenFailed() {

  }

  @Override
  public void OnClose() {

  }
}