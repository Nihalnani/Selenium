set projectLocation=F:\selinium\FrameWork_Design
cd%projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG%projectLocation%\testng.xml