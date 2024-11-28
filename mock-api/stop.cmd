@echo off

REM Define a URL para o shutdown do WireMock
set url=http://localhost:8081/__admin/shutdown

REM Faz a chamada POST com o curl
curl -X POST %url%

REM Verifica se a chamada foi bem-sucedida
if %errorlevel% equ 0 (
    echo Shutdown request sent successfully to %url%.
) else (
    echo Failed to send shutdown request to %url%.
)
