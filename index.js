
import { NativeModules } from 'react-native';

const { RNGoojprtMtp3Library } = NativeModules;

export default (mac_address, base64) => RNGoojprtMtp3Library.print(mac_address, base64, console.log, console.log)
