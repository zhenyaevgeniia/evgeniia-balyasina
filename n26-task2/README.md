Appium Cucumber Prototype for CoCoin.apk
======

Environment setup
------

To run tests locally, be sure that you local environment is set up and running as described below

1. Install [Java >= 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html). Ensure successful installation by typing 'java --version' in your console
1. Install [Gradle](https://docs.gradle.org/current/userguide/installation.html). Ensure successful installation by typing 'gradle --version' in your console
2. Install [Appium Desktop](https://github.com/appium/appium-desktop)
3. Install any free Android emulator. E.g. you can use preinstalled emulator in [Android Studio](https://developer.android.com/studio/index.html)
4. Be sure, that you have ANDROID_HOME in PATH. 
E.g. for Mac users it is usually located under '~/Library/Android/sdk' where ~ equals /Users/<USERNAME>
To simplify work with ANDROID_HOME, add the following lines to your ~/.bash_profile
```
export PATH=”/usr/local/bin:$PATH
export ANDROID_HOME=/Users/<USERNAME>/Library/Android/sdk
export PATH=$ANDROID_HOME/platform-tools:$PATH
export PATH=$ANDROID_HOME/tools:$PATH
```
5. Run an android emulator and create a test device. For the further example the following device (Nexus 5X, Android 7.1.1) will be used:
```
AvdId=Nexus_5X_API_27
PlayStore.enabled=true
hw.device.name=Nexus 5X
hw.lcd.height=1920
hw.lcd.width=1080
abi.type=x86
```
6. Run Appium Desktop. Start default server

Application debug
------

Application debug to explore behaviour and extract desired element locators can be easily performed through Appium desktop.
First launch can take longer time (~5 min), because an application will be installed from scratch.

After server is started, press 'Start Inspector' session button above the console.

To debug an application, create the following desired capabilities for 'Automatic Server' tab:
```
{
  "app": "<APK_PATH>/CoCoin.apk",
  "platformName": "Android",
  "platformVersion": "8.1",
  "deviceName": "Nexus 5X",
  "Automation Name": "Appium"
}
```
and press 'Start Session' button. Desired capabilities can also be saved for further usage.

After session is started, you can observe appium debug log in console and wait until an inspector is started.

Test run
------

After application behaviour is observed and all necessary step definitions are implemented, open console, go to project root folder and execute the following command:
```
gradle cucumber
```
The command above will run a full suite.
You can also specify precise tags in cucumber task in build.gradle file.
It is necessary to have up and running emulator device and appium server on your local machine before tests are started.
