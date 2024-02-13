#!/bin/bash

# Clear the terminal
clear

# Run Java with ANTLR
java -jar antlr/antlr-4.7.2-complete.jar -no-listener -package parser src/parser/Grammar.g4

# Delete .tokens and .interp files
rm src/parser/*.tokens
rm src/parser/*.interp
