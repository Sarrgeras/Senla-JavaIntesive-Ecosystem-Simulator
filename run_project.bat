@echo off
set "JAVA_FILES=src\model\*.java src\view\*.java src\controller\*.java src\Main.java"
set LOG_FILE=ecosystem_log.txt

echo compiling...
javac -d bin %JAVA_FILES%
if errorlevel 1 (
    echo error compiling
    pause
    exit /b 1
)

echo starting ecosystem simulator...
java -cp bin Main
if errorlevel 1 (
    echo error
    pause
    exit /b 1
)

if exist "%LOG_FILE%" (
    echo open log file...
    start notepad "%LOG_FILE%"
) else (
    echo error, log file is not found
)

pause
