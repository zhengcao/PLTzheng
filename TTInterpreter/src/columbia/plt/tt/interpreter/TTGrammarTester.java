package columbia.plt.tt.interpreter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import columbia.plt.tt.TTGrammarEvaluator;
import columbia.plt.tt.TTGrammarLexer;
import columbia.plt.tt.TTGrammarParser;
import columbia.plt.tt.TTGrammarParser.declarationStatement_return;
import columbia.plt.tt.TTGrammarParser.everyFromToByStatement_return;

public class TTGrammarTester {

  public static void main(String[] args) throws RecognitionException {
    try {
      CharStream stream = new ANTLRInputStream(new FileInputStream("C:/eclipse/workspace/TTInterpreter/src/columbia/plt/tt/Program1.tt"));
      //CharStream stream = new ANTLRStringStream(	"Calendar x;");
      //CharStream stream = new ANTLRStringStream( "Calendar x; every Date d from 2013.01.01 to 2013.01.03 by tf { }");
      TTGrammarLexer lexer = new TTGrammarLexer(stream);
      TokenStream tokenStream = new CommonTokenStream(lexer);
      TTGrammarParser parser = new TTGrammarParser(tokenStream);
  	
      declarationStatement_return declaration = parser.declarationStatement();
      System.out.println(declaration.getTree().toStringTree());
  	
      everyFromToByStatement_return every = parser.everyFromToByStatement();
      System.out.println(every.getTree().toStringTree());
  	
      TTGrammarEvaluator evaluator = new TTGrammarEvaluator(new CommonTreeNodeStream(every.getTree()));//declaration.tree));
  	//evaluator.declarationStatement();
      evaluator.everyFromToByStatement();
      
      for (int i = 0; i < lexer.getErrors().size(); i ++) {
        System.out.println(lexer.getErrors().get(i));
      }
        		
      for (int i = 0; i < parser.getErrors().size(); i ++) {
      	System.out.println(lexer.getErrors().get(i));
      }
                    		
      for (int i = 0; i < evaluator.getErrors().size(); i ++) {
        System.out.println(evaluator.getErrors().get(i));
      }
    } 
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}

