@echo off

IF [%1]==[] (
GOTO error_msg
) ELSE (
start javaw -cp "bin;tools\antlr\antlr-4.11.1-complete.jar" org.antlr.v4.gui.TestRig parser.Grammar program -gui -diagnostics %1
)
GOTO eof

:error_msg
echo Falta el nombre del fichero de entrada (por ejemplo, "source.txt").

:eof
