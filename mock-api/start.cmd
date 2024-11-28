@echo off
set host=localhost
set port=8081

REM Executa o WireMock em background e redireciona a saída para wiremock.log
start /B java -jar wiremock-standalone-2.14.0.jar --port %port% --verbose > wiremock.log 2>&1

REM Obtém o PID do último comando
for /f "tokens=2" %%i in ('tasklist /FI "IMAGENAME eq java.exe" /FO LIST ^| find "PID"') do set PID=%%i

echo Wiremock started on host %host% and port %port%. PID: %PID%

