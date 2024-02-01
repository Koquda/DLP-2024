/*
Añadir EN ESTE ORDEN:
- Literales reales: 3.15, 78.23, ... (parte entera obligatoria/parte decimal OPCIONAL)
- Operadores aritméticos y otros simbolos:  + - * / . : = ; [ ] ( ) { } < >
- Palabras reservadas: if, while, read, print, int y float
*/

package lexer;


import java.io.IOException;
import java.io.Reader;

public class Lexico {
    public static final int END = 0;
    public static final int LITENT = 256;
    public static final int IDENT = 257;
    public static final int LITREAL = 258;
    public static final int IF = 259;
    public static final int WHILE = 260;
    public static final int READ = 261;
    public static final int PRINT = 262;
    public static final int INT = 263;
    public static final int FLOAT = 264;

    private Reader input;
    private int currentChar;

    public Lexico(Reader reader) throws IOException {
        input = reader;
        readNext();
    }

    // Funciones auxiliares -------------------------------
    private int readNext() throws IOException {
        currentChar = input.read();
        return currentChar;
    }

    private int getChar() throws IOException {
        return currentChar;
    }

    // Aquí empieza el Analizador Léxico ------------------
    public Token nextToken() throws IOException {

        while (true) {
            while (Character.isWhitespace(getChar()))
                readNext();

            if (getChar() == -1)
                return new Token(END, null);

            if (getChar() == '*') {
                readNext();
                return new Token('*', "*");
            }

            if (Character.isDigit(getChar())) {
                StringBuffer buffer = new StringBuffer();
                buffer.append((char) getChar());
                while (Character.isDigit(readNext())) {
                    buffer.append((char) getChar());
                }

                // Check if it is LITREAL
                if (getChar() == '.') {
                    buffer.append((char) getChar());
                    while (Character.isDigit(readNext()))
                        buffer.append((char) getChar());
                    return new Token(LITREAL, buffer.toString());
                }
                return new Token(LITENT, buffer.toString());
            }

            if (isArithmeticOrSymbol(getChar())) {
                StringBuffer buffer = new StringBuffer();
                buffer.append((char) getChar());
                readNext();
                return new Token(getChar(), buffer.toString());
            }

            if (Character.isLetter(getChar())) {
                StringBuffer buffer = new StringBuffer();
                buffer.append((char) getChar());
                while (Character.isLetterOrDigit(readNext()))
                    buffer.append((char) getChar());

                // Look if there are reserved words
                return switch (buffer.toString()) {
                    case "if" -> new Token(IF, buffer.toString());
                    case "while" -> new Token(WHILE, buffer.toString());
                    case "read" -> new Token(READ, buffer.toString());
                    case "print" -> new Token(PRINT, buffer.toString());
                    case "int" -> new Token(INT, buffer.toString());
                    case "float" -> new Token(FLOAT, buffer.toString());
                    default -> new Token(IDENT, buffer.toString());
                };
            }

            System.out.println("Error léxico: " + (char) getChar());
            readNext();
        }
    }

    private boolean isArithmeticOrSymbol(int ch) {
        char[] symbols = new char[]{ '+', '-', '*', '/', '.', ':', '=', ';', '[', ']', '(', ')', '{', '}', '<', '>' };
        for (char symbol : symbols) {
            if (symbol == (char) ch)
                return true;
        }
        return false;
    }
}
