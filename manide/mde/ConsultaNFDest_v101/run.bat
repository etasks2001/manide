SET srcjava=.\src\main\java
SET schdir=.\

rmdir /s /q .\src
md .\%srcjava%






xjc -XautoNameResolution -d %srcjava% -p com.manide.xml.consnfedest               	%schdir%\consNFeDest_v1.01.xsd -b %schdir%\consNFeDest_v1.01_binding.xml -extension







