package aima.core.logic.propositional.inference;
package solver;

import java.util.ArrayList;
import java.util.List;

import aima.core.logic.propositional.kb.KnowledgeBase;
import aima.core.logic.propositional.kb.data.Model;
import aima.core.logic.propositional.parsing.ast.PropositionSymbol;
import aima.core.logic.propositional.parsing.ast.Sentence;
import aima.core.logic.propositional.visitors.SymbolCollector;
import aima.core.util.Util;

public class TT {

  public boolean TTEntails(Sentence q, KnowledgeBase kb){ //q == alpha

    // list of symbols from KB - List<symbols1> KBsymbols = extractfrom KB
    // (p2=> p3; p3 => p1; c => e; b&e => f; f&g => h; p1=>d; p1&p3 => c; a; b; p2;)
    // list of symbols from Q  - List<symbols2> Qsymbols = extractfrom Q  (d)
    // list of symbols together  - concatenate(symbols1, symbols 2)

    List<PropositionSymbol> symbols = new ArrayList<PropositionSymbol>(     //List of symbols in KB and Q
      SymbolCollector.getSymbolsFrom(kb.asSentence(), q));

    return TTCheck(kb, q, symbols, new Model());  //calls TTcheck which checks entailment
  }

  public boolean TTCheck(Sentence q, KnowledgeBase kb, List<PropositionSymbol> symbols, Model model){

    if (symbols.isEmpty()){                      //If symbols in empty
      if (model.isTrue(kb.asSentence())){
        return model.isTrue(q);                 //
      }
      else {
        return true;
      }
    }

    PSymbol p = Util.first(symbols);   // first symbol

    List<PropositionSymbol> rest = Util.rest(symbols);  // rest of the symbol

    // return with first symbol as true and false and cylce back through for next symbol
    return TTCheck(kb, q, rest, model.union(p, true)) && TTCheck(kb, q, rest, model.union(p, false));

    // exampple walkthrough

    // Symbols - ((p2=> p3; p3 => p1; c => e; b&e => f; f&g => h; p1=>d; p1&p3 => c; a; b; p2;))
    // model {}

    // Symbols - (( p3 => p1; c => e; b&e => f; f&g => h; p1=>d; p1&p3 => c; a; b; p2;))
    // model {p2=> p3; = F} && {p2=> p3; = T}

    // Store models that meet criterea, through list and diaply results?

  }

}

