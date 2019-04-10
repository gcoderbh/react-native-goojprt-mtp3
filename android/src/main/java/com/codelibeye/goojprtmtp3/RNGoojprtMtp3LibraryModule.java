
package com.codelibeye.goojprtmtp3;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class RNGoojprtMtp3LibraryModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNGoojprtMtp3LibraryModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNGoojprtMtp3Library";
  }
}