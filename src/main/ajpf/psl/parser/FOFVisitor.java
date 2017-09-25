// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of Agent JPF (AJPF)
// 
// AJPF is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// AJPF is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with AJPF; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ajpf.psl.parser;

import java.util.ArrayList;
import java.util.HashMap;


import ail.syntax.ast.Abstract_ArithExpr;
import ail.syntax.ast.Abstract_Equation;
import ail.syntax.ast.Abstract_Literal;
import ail.syntax.ast.Abstract_LogExpr;
import ail.syntax.ast.Abstract_LogicalFormula;
import ail.syntax.ast.Abstract_NumberTerm;
import ail.syntax.ast.Abstract_NumberTermImpl;
import ail.syntax.ast.Abstract_Pred;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_Rule;
import ail.syntax.ast.Abstract_StringTermImpl;
import ail.syntax.ast.Abstract_Term;
import ail.syntax.ast.Abstract_VarTerm;
import ajpf.psl.ast.Abstract_MCAPLListTermImpl;
import ajpf.psl.ast.Abstract_MCAPLNumberTermImpl;
import ajpf.psl.ast.Abstract_MCAPLPredicate;
import ajpf.psl.ast.Abstract_MCAPLTerm;
import ajpf.psl.ast.Abstract_TermImpl;
import ajpf.psl.parser.LogicalFmlasBaseVisitor;
import ajpf.psl.parser.LogicalFmlasParser;

@SuppressWarnings("deprecation")
public class FOFVisitor extends LogicalFmlasBaseVisitor<Object> {

	//function returns [Abstract_Predicate f]: CONST {$f = new Abstract_Predicate($CONST.getText());} (OPEN terms[$f] CLOSE)?;
	@Override public Object visitFunction(LogicalFmlasParser.FunctionContext ctx) {
		Abstract_MCAPLPredicate f = new Abstract_MCAPLPredicate(ctx.CONST().getText());
		if (ctx.terms() != null) {
			@SuppressWarnings("unchecked")
			ArrayList<Abstract_MCAPLTerm> visitTerms = (ArrayList<Abstract_MCAPLTerm>) visitTerms(ctx.terms());
			for (Abstract_MCAPLTerm t: visitTerms) {
				f.addTerm(t);
			}
		}
		return f;
	}

	// terms[Abstract_Predicate f] : t=term {$f.addTerm($t.t);} (COMMA terms[$f])? ;	            
	@SuppressWarnings("unchecked")
	@Override public Object visitTerms(LogicalFmlasParser.TermsContext ctx) {
		ArrayList<Abstract_MCAPLTerm> terms = new ArrayList<Abstract_MCAPLTerm>();
		Abstract_MCAPLTerm t = (Abstract_MCAPLTerm) visitTerm(ctx.t);
		terms.add(t);
		if (ctx.terms() != null) {
			terms.addAll((ArrayList<Abstract_MCAPLTerm>) visitTerms(ctx.terms()));
		}
		return terms;
	}
	
	// term	returns [Abstract_Term t]:  a = atom {$t = $a.t;} | s = stringterm {$t = $s.s;} | f=function {$t = $f.f;};
	@Override public Object visitTerm(LogicalFmlasParser.TermContext ctx) {
		if (ctx.a != null) {
			return visitAtom(ctx.a);
		} else if (ctx.s != null) {
			System.err.println("Error: Should be no string terms");
			return null;
		} else if (ctx.l != null) {
			return visitListterm(ctx.l);
		} else {
			return visitFunction(ctx.f);
		}
	}

	
	//atom	returns [Abstract_NumberTerm t]	:	n = numberstring {$t = new Abstract_NumberTermImpl($n.s);}| 
	//		v=var {$t = $v.v;} | OPEN a=arithexpr CLOSE; // {$t = $a.t;};
	@Override public Object visitAtom(LogicalFmlasParser.AtomContext ctx) {
		if (ctx.n != null) {
			return new Abstract_MCAPLNumberTermImpl((String) visitNumberstring(ctx.n));
		} else if (ctx.v != null) {
			return visitVar(ctx.v);
		} else {
			System.err.println("Error: Should be no arithmetical expressions");
			return visitArithexpr(ctx.a);
		}
	}
		
	/* var 	returns [Abstract_VarTerm v]:	VAR {
		if (variables.containsKey($VAR.getText())) {
			$v = variables.get($VAR.getText());
			} else {
			$v = new Abstract_VarTerm($VAR.getText());
			variables.put($VAR.getText(), $v);
			}
		}; */
	@Override public Object visitVar( LogicalFmlasParser.VarContext ctx) {
		if (ctx.VAR() != null) {
			System.err.println("Error: Should be no variables");
			return null;
		} else {
			return new Abstract_TermImpl(ctx.UNNAMEDVAR().getText());
		}
	}

	// numberstring returns [String s] :	{$s = "";} (MINUS {$s += "-";})? (n1=NUMBER {$s += $n1.getText();}
	// (POINT {$s += ".";} n2=NUMBER {$s += $n2.getText();})?);
	@Override public Object visitNumberstring(LogicalFmlasParser.NumberstringContext ctx) {
		String s = "";
		if (ctx.MINUS() != null) {
			s += "-";
		}
		s += ctx.n1.getText();
		if (ctx.POINT() != null) {
			s += ".";
			s += ctx.n2.getText();
		}
		return s;
	}
	
	@Override public Object visitListterm(LogicalFmlasParser.ListtermContext ctx) {
		return visitListheads(ctx.listheads());
	}
	
	@Override public Object visitListheads(LogicalFmlasParser.ListheadsContext ctx) {
		Abstract_MCAPLListTermImpl list = new Abstract_MCAPLListTermImpl((Abstract_MCAPLTerm) visitTerm(ctx.term(0)));
		boolean first = true;
		for (LogicalFmlasParser.TermContext t_ctx: ctx.term()) {
			if (first) {
				first = false;
			} else {
				list.addEnd((Abstract_MCAPLTerm) visitTerm(t_ctx));
			}
		}
		return list;
	}


}
