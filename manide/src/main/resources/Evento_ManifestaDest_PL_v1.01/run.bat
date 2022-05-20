SET srcjava=.\src\main\java
SET schdir=.\

rmdir /s /q .\src
md .\%srcjava%






xjc -XautoNameResolution -d %srcjava% -p com.manide.xml.envevento               	%schdir%\envConfRecebto_v1.00.xsd -b %schdir%\envConfRecebto_v1.00_binding.xml -extension







