
# react-native-goojprt-mtp3-library

## Getting started

`$ npm install react-native-goojprt-mtp3-library --save`

### Mostly automatic installation

`$ react-native link react-native-goojprt-mtp3-library`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-goojprt-mtp3-library` and add `RNGoojprtMtp3Library.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNGoojprtMtp3Library.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

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

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNGoojprtMtp3Library.sln` in `node_modules/react-native-goojprt-mtp3-library/windows/RNGoojprtMtp3Library.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Goojprt.Mtp3.Library.RNGoojprtMtp3Library;` to the usings at the top of the file
  - Add `new RNGoojprtMtp3LibraryPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNGoojprtMtp3Library from 'react-native-goojprt-mtp3-library';

// TODO: What to do with the module?
RNGoojprtMtp3Library;
```
  