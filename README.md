
# react-native-goojprt-mtp3-library

## Getting started

`$ npm install react-native-goojprt-mtp3-library --save`

### Mostly automatic installation

`$ react-native link react-native-goojprt-mtp3-library`

### Manual installation

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.codelibeye.goojprtmtp3.RNGoojprtMtp3LibraryPackage;` to the imports at the top of the file
  - Add `new RNGoojprtMtp3LibraryPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-goojprt-mtp3-library'
  	project(':react-native-goojprt-mtp3-library').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-goojprt-mtp3-library/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-goojprt-mtp3-library')
  	```


## Usage

1. Open bluetooth android and make sure bluetooth printer device is available
2. Pair bluetooth printer device
3. Make sure bluetooth device name MTP-3 !important
4. 
```javascript
import BTPrint from 'react-native-goojprt-mtp3-library';

BTPrint("<BT Device Mac Address>", "<PDF Local File Path>")
```