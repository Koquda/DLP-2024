package main;

import lexer.Lexico;
import lexer.Token;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {

//            Lexico lex = new Lexico(new FileReader("source.txt"));
            Lexico lex = new Lexico(new FileReader("test.txt"));

            Token token;
            while ((token = lex.nextToken()).getType() != Lexico.END) {
                System.out.print("Token: " + token.getType());
                System.out.println("\t Lexema: " + token.getText());
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
