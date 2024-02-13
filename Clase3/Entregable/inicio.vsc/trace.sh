#!/bin/bash

if [ -z "$1" ]; then
    echo "Falta el nombre del fichero de entrada (por ejemplo, \"source.txt\")."
    exit 1
else
    java -cp "bin:antlr/antlr-4.7.2-complete.jar" org.antlr.v4.gui.TestRig parser.Grammar start -trace -diagnostics "$1"
fi

