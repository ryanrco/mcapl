// $ANTLR 3.5.1 /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g 2014-06-19 15:22:57

package eass.parser;

import ail.syntax.ast.*;
import eass.syntax.ast.*;
import gwendolen.syntax.ast.*;
import java.util.HashMap;


import mcaplantlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class EASSParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ABSTRACTION", "ACHIEVE", "ACHIEVEGOAL", 
		"ARROW", "BELIEFRULES", "BELIEFS", "BELIEVE", "BRULEARROW", "CALCULATE", 
		"CAPABILITIES", "CAPABILITY", "CLOSE", "COLON", "COMMA", "COMMENT", "CONST", 
		"CURLYCLOSE", "CURLYOPEN", "DIV", "DOUBLEQUOTE", "EASS", "EQ", "EQ_ASSGN", 
		"GOAL", "GOALS", "IMPLICATION", "LESS", "LINE_COMMENT", "LOCK", "MINUS", 
		"MOD", "MULT", "NAME", "NEWLINE", "NOT", "NUMBER", "OPEN", "PERFORM", 
		"PERFORMGOAL", "PLAN", "PLANS", "PLUS", "POINT", "QUERY", "QUERYCOM", 
		"RECEIVED", "RULEARROW", "SEMI", "SEND", "SENT", "SHRIEK", "SQCLOSE", 
		"SQOPEN", "STRING", "SUBSTITUTE", "TELL", "TRUE", "UPDATE", "VAR", "WAIT", 
		"WS"
	};
	public static final int EOF=-1;
	public static final int ABSTRACTION=4;
	public static final int ACHIEVE=5;
	public static final int ACHIEVEGOAL=6;
	public static final int ARROW=7;
	public static final int BELIEFRULES=8;
	public static final int BELIEFS=9;
	public static final int BELIEVE=10;
	public static final int BRULEARROW=11;
	public static final int CALCULATE=12;
	public static final int CAPABILITIES=13;
	public static final int CAPABILITY=14;
	public static final int CLOSE=15;
	public static final int COLON=16;
	public static final int COMMA=17;
	public static final int COMMENT=18;
	public static final int CONST=19;
	public static final int CURLYCLOSE=20;
	public static final int CURLYOPEN=21;
	public static final int DIV=22;
	public static final int DOUBLEQUOTE=23;
	public static final int EASS=24;
	public static final int EQ=25;
	public static final int EQ_ASSGN=26;
	public static final int GOAL=27;
	public static final int GOALS=28;
	public static final int IMPLICATION=29;
	public static final int LESS=30;
	public static final int LINE_COMMENT=31;
	public static final int LOCK=32;
	public static final int MINUS=33;
	public static final int MOD=34;
	public static final int MULT=35;
	public static final int NAME=36;
	public static final int NEWLINE=37;
	public static final int NOT=38;
	public static final int NUMBER=39;
	public static final int OPEN=40;
	public static final int PERFORM=41;
	public static final int PERFORMGOAL=42;
	public static final int PLAN=43;
	public static final int PLANS=44;
	public static final int PLUS=45;
	public static final int POINT=46;
	public static final int QUERY=47;
	public static final int QUERYCOM=48;
	public static final int RECEIVED=49;
	public static final int RULEARROW=50;
	public static final int SEMI=51;
	public static final int SEND=52;
	public static final int SENT=53;
	public static final int SHRIEK=54;
	public static final int SQCLOSE=55;
	public static final int SQOPEN=56;
	public static final int STRING=57;
	public static final int SUBSTITUTE=58;
	public static final int TELL=59;
	public static final int TRUE=60;
	public static final int UPDATE=61;
	public static final int VAR=62;
	public static final int WAIT=63;
	public static final int WS=64;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public EASSParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public EASSParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return EASSParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g"; }


		private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
		private Abstract_StringTerm agentname = new Abstract_StringTermImpl("");
		


	// $ANTLR start "mas"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:59:1: mas returns [Abstract_MAS mas] :glist= eassagents ;
	public final Abstract_MAS mas() throws RecognitionException {
		Abstract_MAS mas = null;


		ArrayList<Abstract_EASSAgent> glist =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:59:32: (glist= eassagents )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:59:34: glist= eassagents
			{
			mas = new Abstract_MAS();
			pushFollow(FOLLOW_eassagents_in_mas89);
			glist=eassagents();
			state._fsp--;

			mas.setAgs(glist);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return mas;
	}
	// $ANTLR end "mas"



	// $ANTLR start "eassagents"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:62:1: eassagents returns [ArrayList<Abstract_EASSAgent> gags] : EASS (g= eassagent )+ ;
	public final ArrayList<Abstract_EASSAgent> eassagents() throws RecognitionException {
		ArrayList<Abstract_EASSAgent> gags = null;


		Abstract_EASSAgent g =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:62:55: ( EASS (g= eassagent )+ )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:62:57: EASS (g= eassagent )+
			{
			match(input,EASS,FOLLOW_EASS_in_eassagents102); 
			gags=new ArrayList<Abstract_EASSAgent>();
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:63:2: (g= eassagent )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==ABSTRACTION||LA1_0==NAME) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:63:3: g= eassagent
					{
					pushFollow(FOLLOW_eassagent_in_eassagents111);
					g=eassagent();
					state._fsp--;

					gags.add(g);
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return gags;
	}
	// $ANTLR end "eassagents"



	// $ANTLR start "eassagent"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:65:1: eassagent returns [Abstract_EASSAgent g] : ( NAME w= word | ABSTRACTION w= word ) BELIEFS (l= literal )* ( BELIEFRULES (r= brule )* )? ( CAPABILITIES (c= capability )* )? GOALS (gl= goal )* PLANS (p= plan )* ;
	public final Abstract_EASSAgent eassagent() throws RecognitionException {
		Abstract_EASSAgent g = null;


		String w =null;
		Abstract_Literal l =null;
		Abstract_Rule r =null;
		Abstract_Capability c =null;
		Abstract_Goal gl =null;
		Abstract_GPlan p =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:65:42: ( ( NAME w= word | ABSTRACTION w= word ) BELIEFS (l= literal )* ( BELIEFRULES (r= brule )* )? ( CAPABILITIES (c= capability )* )? GOALS (gl= goal )* PLANS (p= plan )* )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:66:2: ( NAME w= word | ABSTRACTION w= word ) BELIEFS (l= literal )* ( BELIEFRULES (r= brule )* )? ( CAPABILITIES (c= capability )* )? GOALS (gl= goal )* PLANS (p= plan )*
			{
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:66:2: ( NAME w= word | ABSTRACTION w= word )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==NAME) ) {
				alt2=1;
			}
			else if ( (LA2_0==ABSTRACTION) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:66:3: NAME w= word
					{
					match(input,NAME,FOLLOW_NAME_in_eassagent130); 
					pushFollow(FOLLOW_word_in_eassagent134);
					w=word();
					state._fsp--;

					try {g = new Abstract_EASSAgent(w);} catch (Exception e) {System.err.println(e);}
						              agentname = new Abstract_StringTermImpl(w);
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:68:2: ABSTRACTION w= word
					{
					match(input,ABSTRACTION,FOLLOW_ABSTRACTION_in_eassagent141); 
					pushFollow(FOLLOW_word_in_eassagent145);
					w=word();
					state._fsp--;

					String s = "abstraction_" + w; g = new Abstract_EASSAgent(s); g.setAbstraction(w);
					}
					break;

			}

			match(input,BELIEFS,FOLLOW_BELIEFS_in_eassagent157); 
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:70:10: (l= literal )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==CONST||LA3_0==NOT||LA3_0==TRUE||LA3_0==VAR) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:70:11: l= literal
					{
					pushFollow(FOLLOW_literal_in_eassagent162);
					l=literal();
					state._fsp--;

					g.addInitialBel(l);
					}
					break;

				default :
					break loop3;
				}
			}

			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:71:2: ( BELIEFRULES (r= brule )* )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==BELIEFRULES) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:71:3: BELIEFRULES (r= brule )*
					{
					match(input,BELIEFRULES,FOLLOW_BELIEFRULES_in_eassagent170); 
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:71:15: (r= brule )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0==CONST||LA4_0==VAR) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:71:16: r= brule
							{
							pushFollow(FOLLOW_brule_in_eassagent175);
							r=brule();
							state._fsp--;

							g.addRule(r);
							}
							break;

						default :
							break loop4;
						}
					}

					}
					break;

			}

			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:72:2: ( CAPABILITIES (c= capability )* )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==CAPABILITIES) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:72:3: CAPABILITIES (c= capability )*
					{
					match(input,CAPABILITIES,FOLLOW_CAPABILITIES_in_eassagent185); 
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:72:16: (c= capability )*
					loop6:
					while (true) {
						int alt6=2;
						int LA6_0 = input.LA(1);
						if ( (LA6_0==CURLYOPEN) ) {
							alt6=1;
						}

						switch (alt6) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:72:17: c= capability
							{
							pushFollow(FOLLOW_capability_in_eassagent190);
							c=capability();
							state._fsp--;

							g.addCap(c);
							}
							break;

						default :
							break loop6;
						}
					}

					}
					break;

			}

			match(input,GOALS,FOLLOW_GOALS_in_eassagent199); 
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:73:8: (gl= goal )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==CONST||LA8_0==NOT||LA8_0==TRUE||LA8_0==VAR) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:73:9: gl= goal
					{
					pushFollow(FOLLOW_goal_in_eassagent204);
					gl=goal();
					state._fsp--;

					g.addInitialGoal(gl);
					}
					break;

				default :
					break loop8;
				}
			}

			match(input,PLANS,FOLLOW_PLANS_in_eassagent211); 
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:74:8: (p= plan )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==MINUS||LA9_0==PLUS) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:74:9: p= plan
					{
					pushFollow(FOLLOW_plan_in_eassagent216);
					p=plan();
					state._fsp--;

					try {g.addPlan(p);} catch (Exception e) {System.err.println(e);}
					}
					break;

				default :
					break loop9;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return g;
	}
	// $ANTLR end "eassagent"



	// $ANTLR start "goal"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:77:1: goal returns [Abstract_Goal g] : l= literal SQOPEN ( ACHIEVEGOAL | PERFORMGOAL ) SQCLOSE ;
	public final Abstract_Goal goal() throws RecognitionException {
		Abstract_Goal g = null;


		Abstract_Literal l =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:77:32: (l= literal SQOPEN ( ACHIEVEGOAL | PERFORMGOAL ) SQCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:77:34: l= literal SQOPEN ( ACHIEVEGOAL | PERFORMGOAL ) SQCLOSE
			{
			pushFollow(FOLLOW_literal_in_goal236);
			l=literal();
			state._fsp--;

			match(input,SQOPEN,FOLLOW_SQOPEN_in_goal238); 
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:77:51: ( ACHIEVEGOAL | PERFORMGOAL )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==ACHIEVEGOAL) ) {
				alt10=1;
			}
			else if ( (LA10_0==PERFORMGOAL) ) {
				alt10=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:77:52: ACHIEVEGOAL
					{
					match(input,ACHIEVEGOAL,FOLLOW_ACHIEVEGOAL_in_goal241); 
					g = new Abstract_Goal(l, Abstract_Goal.achieveGoal);
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:78:2: PERFORMGOAL
					{
					match(input,PERFORMGOAL,FOLLOW_PERFORMGOAL_in_goal249); 
					g = new Abstract_Goal(l, Abstract_Goal.performGoal);
					}
					break;

			}

			match(input,SQCLOSE,FOLLOW_SQCLOSE_in_goal254); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return g;
	}
	// $ANTLR end "goal"



	// $ANTLR start "capability"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:80:1: capability returns [Abstract_Capability c] : CURLYOPEN (p= logicalfmla )? CURLYCLOSE cap= pred CURLYOPEN (pp= logicalfmla )? CURLYCLOSE ;
	public final Abstract_Capability capability() throws RecognitionException {
		Abstract_Capability c = null;


		Abstract_LogicalFormula p =null;
		Abstract_Predicate cap =null;
		Abstract_LogicalFormula pp =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:80:44: ( CURLYOPEN (p= logicalfmla )? CURLYCLOSE cap= pred CURLYOPEN (pp= logicalfmla )? CURLYCLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:81:2: CURLYOPEN (p= logicalfmla )? CURLYCLOSE cap= pred CURLYOPEN (pp= logicalfmla )? CURLYCLOSE
			{
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_capability269); 
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:81:12: (p= logicalfmla )?
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==CONST||LA11_0==NOT||LA11_0==VAR) ) {
				alt11=1;
			}
			switch (alt11) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:81:13: p= logicalfmla
					{
					pushFollow(FOLLOW_logicalfmla_in_capability274);
					p=logicalfmla();
					state._fsp--;

					}
					break;

			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_capability278); 
			pushFollow(FOLLOW_pred_in_capability284);
			cap=pred();
			state._fsp--;

			c = new Abstract_Capability(cap); if (p != null) {c.addPre(p);}
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_capability289); 
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:83:12: (pp= logicalfmla )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==CONST||LA12_0==NOT||LA12_0==VAR) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:83:13: pp= logicalfmla
					{
					pushFollow(FOLLOW_logicalfmla_in_capability294);
					pp=logicalfmla();
					state._fsp--;

					c.addPost(pp);
					}
					break;

			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_capability300); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return c;
	}
	// $ANTLR end "capability"



	// $ANTLR start "plan"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:86:1: plan returns [Abstract_GPlan p] : e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed[deeds] ( ',' d= deed[deeds] )* )? SEMI ;
	public final Abstract_GPlan plan() throws RecognitionException {
		Abstract_GPlan p = null;


		Abstract_Event e =null;
		Abstract_GLogicalFormula gb =null;
		Abstract_Deed d =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:87:2: (e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed[deeds] ( ',' d= deed[deeds] )* )? SEMI )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:87:4: e= event COLON CURLYOPEN ( NOT )? gb= guard_atom ( COMMA ( NOT )? gb= guard_atom )* CURLYCLOSE ( RULEARROW d= deed[deeds] ( ',' d= deed[deeds] )* )? SEMI
			{
			pushFollow(FOLLOW_event_in_plan316);
			e=event();
			state._fsp--;

			ArrayList<Abstract_Deed> deeds=new ArrayList<Abstract_Deed>(); Abstract_Guard g = new Abstract_Guard();
			match(input,COLON,FOLLOW_COLON_in_plan324); 
			match(input,CURLYOPEN,FOLLOW_CURLYOPEN_in_plan326); 
			boolean gneg=true;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:88:40: ( NOT )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==NOT) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:88:41: NOT
					{
					match(input,NOT,FOLLOW_NOT_in_plan331); 
					gneg=false;
					}
					break;

			}

			pushFollow(FOLLOW_guard_atom_in_plan339);
			gb=guard_atom();
			state._fsp--;

			g.add(gb, gneg);
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:89:3: ( COMMA ( NOT )? gb= guard_atom )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==COMMA) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:89:4: COMMA ( NOT )? gb= guard_atom
					{
					match(input,COMMA,FOLLOW_COMMA_in_plan347); 
					gneg=true;
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:89:23: ( NOT )?
					int alt14=2;
					int LA14_0 = input.LA(1);
					if ( (LA14_0==NOT) ) {
						alt14=1;
					}
					switch (alt14) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:89:24: NOT
							{
							match(input,NOT,FOLLOW_NOT_in_plan352); 
							gneg=false;
							}
							break;

					}

					pushFollow(FOLLOW_guard_atom_in_plan360);
					gb=guard_atom();
					state._fsp--;

					g.add(gb, gneg);
					}
					break;

				default :
					break loop15;
				}
			}

			match(input,CURLYCLOSE,FOLLOW_CURLYCLOSE_in_plan366); 
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:89:93: ( RULEARROW d= deed[deeds] ( ',' d= deed[deeds] )* )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==RULEARROW) ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:89:94: RULEARROW d= deed[deeds] ( ',' d= deed[deeds] )*
					{
					match(input,RULEARROW,FOLLOW_RULEARROW_in_plan369); 
					pushFollow(FOLLOW_deed_in_plan374);
					d=deed(deeds);
					state._fsp--;

					deeds.add(d);
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:90:35: ( ',' d= deed[deeds] )*
					loop16:
					while (true) {
						int alt16=2;
						int LA16_0 = input.LA(1);
						if ( (LA16_0==COMMA) ) {
							alt16=1;
						}

						switch (alt16) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:90:36: ',' d= deed[deeds]
							{
							match(input,COMMA,FOLLOW_COMMA_in_plan380); 
							pushFollow(FOLLOW_deed_in_plan384);
							d=deed(deeds);
							state._fsp--;

							deeds.add(d);
							}
							break;

						default :
							break loop16;
						}
					}

					}
					break;

			}

			match(input,SEMI,FOLLOW_SEMI_in_plan395); 
			p = new Abstract_GPlan(e, g, deeds); p.reverseBody(); variables.clear();
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return p;
	}
	// $ANTLR end "plan"



	// $ANTLR start "event"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:93:1: event returns [Abstract_Event e] : ( PLUS ( RECEIVED OPEN p= performative ',' t= pred ')' | (l= literal | SHRIEK g= goal ) ) | MINUS (l= literal | SHRIEK g= goal ) ) ;
	public final Abstract_Event event() throws RecognitionException {
		Abstract_Event e = null;


		int p =0;
		Abstract_Predicate t =null;
		Abstract_Literal l =null;
		Abstract_Goal g =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:93:34: ( ( PLUS ( RECEIVED OPEN p= performative ',' t= pred ')' | (l= literal | SHRIEK g= goal ) ) | MINUS (l= literal | SHRIEK g= goal ) ) )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:93:36: ( PLUS ( RECEIVED OPEN p= performative ',' t= pred ')' | (l= literal | SHRIEK g= goal ) ) | MINUS (l= literal | SHRIEK g= goal ) )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:93:36: ( PLUS ( RECEIVED OPEN p= performative ',' t= pred ')' | (l= literal | SHRIEK g= goal ) ) | MINUS (l= literal | SHRIEK g= goal ) )
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==PLUS) ) {
				alt21=1;
			}
			else if ( (LA21_0==MINUS) ) {
				alt21=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}

			switch (alt21) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:93:37: PLUS ( RECEIVED OPEN p= performative ',' t= pred ')' | (l= literal | SHRIEK g= goal ) )
					{
					match(input,PLUS,FOLLOW_PLUS_in_event411); 
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:93:42: ( RECEIVED OPEN p= performative ',' t= pred ')' | (l= literal | SHRIEK g= goal ) )
					int alt19=2;
					int LA19_0 = input.LA(1);
					if ( (LA19_0==RECEIVED) ) {
						alt19=1;
					}
					else if ( (LA19_0==CONST||LA19_0==NOT||LA19_0==SHRIEK||LA19_0==TRUE||LA19_0==VAR) ) {
						alt19=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 19, 0, input);
						throw nvae;
					}

					switch (alt19) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:93:43: RECEIVED OPEN p= performative ',' t= pred ')'
							{
							match(input,RECEIVED,FOLLOW_RECEIVED_in_event414); 
							match(input,OPEN,FOLLOW_OPEN_in_event416); 
							pushFollow(FOLLOW_performative_in_event420);
							p=performative();
							state._fsp--;

							match(input,COMMA,FOLLOW_COMMA_in_event422); 
							pushFollow(FOLLOW_pred_in_event426);
							t=pred();
							state._fsp--;

							match(input,CLOSE,FOLLOW_CLOSE_in_event428); 
							Abstract_GMessage message = new Abstract_GMessage(new Abstract_VarTerm("From"), 
												new Abstract_VarTerm("To"), p, t); 
												e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILReceived, message);
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:97:5: (l= literal | SHRIEK g= goal )
							{
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:97:5: (l= literal | SHRIEK g= goal )
							int alt18=2;
							int LA18_0 = input.LA(1);
							if ( (LA18_0==CONST||LA18_0==NOT||LA18_0==TRUE||LA18_0==VAR) ) {
								alt18=1;
							}
							else if ( (LA18_0==SHRIEK) ) {
								alt18=2;
							}

							else {
								NoViableAltException nvae =
									new NoViableAltException("", 18, 0, input);
								throw nvae;
							}

							switch (alt18) {
								case 1 :
									// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:97:6: l= literal
									{
									pushFollow(FOLLOW_literal_in_event446);
									l=literal();
									state._fsp--;

									e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILBel, l);
									}
									break;
								case 2 :
									// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:98:5: SHRIEK g= goal
									{
									match(input,SHRIEK,FOLLOW_SHRIEK_in_event456); 
									pushFollow(FOLLOW_goal_in_event460);
									g=goal();
									state._fsp--;

									e = new Abstract_Event(Abstract_Event.AILAddition, g);
									}
									break;

							}

							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:99:7: MINUS (l= literal | SHRIEK g= goal )
					{
					match(input,MINUS,FOLLOW_MINUS_in_event474); 
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:99:13: (l= literal | SHRIEK g= goal )
					int alt20=2;
					int LA20_0 = input.LA(1);
					if ( (LA20_0==CONST||LA20_0==NOT||LA20_0==TRUE||LA20_0==VAR) ) {
						alt20=1;
					}
					else if ( (LA20_0==SHRIEK) ) {
						alt20=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 20, 0, input);
						throw nvae;
					}

					switch (alt20) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:99:14: l= literal
							{
							pushFollow(FOLLOW_literal_in_event479);
							l=literal();
							state._fsp--;

							e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILBel, l);
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:100:5: SHRIEK g= goal
							{
							match(input,SHRIEK,FOLLOW_SHRIEK_in_event489); 
							pushFollow(FOLLOW_goal_in_event493);
							g=goal();
							state._fsp--;

							e = new Abstract_Event(Abstract_Event.AILDeletion, g);
							}
							break;

					}

					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return e;
	}
	// $ANTLR end "event"



	// $ANTLR start "guard_atom"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:102:1: guard_atom returns [Abstract_GLogicalFormula g] : ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (st= stringterm |v= var ) COMMA (an2= stringterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | CAPABILITY OPEN pre= pred COMMA cap= pred COMMA pst= pred CLOSE | PLAN OPEN (v= var |s= numberstring ) COMMA ga= pred COMMA c= pred COMMA post= pred CLOSE | IMPLICATION OPEN ant= logicalfmla ARROW cons= logicalfmla CLOSE | TRUE ) ;
	public final Abstract_GLogicalFormula guard_atom() throws RecognitionException {
		Abstract_GLogicalFormula g = null;


		Abstract_Literal l =null;
		Abstract_Goal gl =null;
		Abstract_StringTerm st =null;
		Abstract_VarTerm v =null;
		Abstract_StringTerm an2 =null;
		int p =0;
		Abstract_Predicate t =null;
		Abstract_Equation eq =null;
		Abstract_Predicate pre =null;
		Abstract_Predicate cap =null;
		Abstract_Predicate pst =null;
		String s =null;
		Abstract_Predicate ga =null;
		Abstract_Predicate c =null;
		Abstract_Predicate post =null;
		Abstract_LogicalFormula ant =null;
		Abstract_LogicalFormula cons =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:102:49: ( ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (st= stringterm |v= var ) COMMA (an2= stringterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | CAPABILITY OPEN pre= pred COMMA cap= pred COMMA pst= pred CLOSE | PLAN OPEN (v= var |s= numberstring ) COMMA ga= pred COMMA c= pred COMMA post= pred CLOSE | IMPLICATION OPEN ant= logicalfmla ARROW cons= logicalfmla CLOSE | TRUE ) )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:102:51: ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (st= stringterm |v= var ) COMMA (an2= stringterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | CAPABILITY OPEN pre= pred COMMA cap= pred COMMA pst= pred CLOSE | PLAN OPEN (v= var |s= numberstring ) COMMA ga= pred COMMA c= pred COMMA post= pred CLOSE | IMPLICATION OPEN ant= logicalfmla ARROW cons= logicalfmla CLOSE | TRUE )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:102:51: ( BELIEVE l= literal | GOAL gl= goal | SENT OPEN (st= stringterm |v= var ) COMMA (an2= stringterm COMMA )? p= performative COMMA t= pred CLOSE |eq= equation | CAPABILITY OPEN pre= pred COMMA cap= pred COMMA pst= pred CLOSE | PLAN OPEN (v= var |s= numberstring ) COMMA ga= pred COMMA c= pred COMMA post= pred CLOSE | IMPLICATION OPEN ant= logicalfmla ARROW cons= logicalfmla CLOSE | TRUE )
			int alt25=8;
			switch ( input.LA(1) ) {
			case BELIEVE:
				{
				alt25=1;
				}
				break;
			case GOAL:
				{
				alt25=2;
				}
				break;
			case SENT:
				{
				alt25=3;
				}
				break;
			case MINUS:
			case NUMBER:
			case OPEN:
			case VAR:
				{
				alt25=4;
				}
				break;
			case CAPABILITY:
				{
				alt25=5;
				}
				break;
			case PLAN:
				{
				alt25=6;
				}
				break;
			case IMPLICATION:
				{
				alt25=7;
				}
				break;
			case TRUE:
				{
				alt25=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				throw nvae;
			}
			switch (alt25) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:102:52: BELIEVE l= literal
					{
					match(input,BELIEVE,FOLLOW_BELIEVE_in_guard_atom514); 
					pushFollow(FOLLOW_literal_in_guard_atom518);
					l=literal();
					state._fsp--;

					g = new Abstract_GBelief(l);
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:103:5: GOAL gl= goal
					{
					match(input,GOAL,FOLLOW_GOAL_in_guard_atom528); 
					pushFollow(FOLLOW_goal_in_guard_atom532);
					gl=goal();
					state._fsp--;

					g = new Abstract_Goal(gl);
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:104:5: SENT OPEN (st= stringterm |v= var ) COMMA (an2= stringterm COMMA )? p= performative COMMA t= pred CLOSE
					{
					match(input,SENT,FOLLOW_SENT_in_guard_atom542); 
					match(input,OPEN,FOLLOW_OPEN_in_guard_atom544); 
					Abstract_StringTerm an1=agentname;
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:104:52: (st= stringterm |v= var )
					int alt22=2;
					int LA22_0 = input.LA(1);
					if ( (LA22_0==DOUBLEQUOTE) ) {
						alt22=1;
					}
					else if ( (LA22_0==VAR) ) {
						alt22=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 22, 0, input);
						throw nvae;
					}

					switch (alt22) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:104:53: st= stringterm
							{
							pushFollow(FOLLOW_stringterm_in_guard_atom551);
							st=stringterm();
							state._fsp--;

							an1=st;
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:104:79: v= var
							{
							pushFollow(FOLLOW_var_in_guard_atom559);
							v=var();
							state._fsp--;

							an1 = v;
							}
							break;

					}

					match(input,COMMA,FOLLOW_COMMA_in_guard_atom564); 
					Abstract_StringTerm agn = agentname;
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:104:142: (an2= stringterm COMMA )?
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0==DOUBLEQUOTE) ) {
						alt23=1;
					}
					switch (alt23) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:104:143: an2= stringterm COMMA
							{
							pushFollow(FOLLOW_stringterm_in_guard_atom571);
							an2=stringterm();
							state._fsp--;

							match(input,COMMA,FOLLOW_COMMA_in_guard_atom579); 
							agn = an2;
							}
							break;

					}

					pushFollow(FOLLOW_performative_in_guard_atom587);
					p=performative();
					state._fsp--;

					match(input,COMMA,FOLLOW_COMMA_in_guard_atom595); 
					pushFollow(FOLLOW_pred_in_guard_atom599);
					t=pred();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_guard_atom601); 
					g = new Abstract_GuardMessage(Abstract_BaseAILStructure.AILSent, agn, an1, p, t);
					}
					break;
				case 4 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:107:5: eq= equation
					{
					pushFollow(FOLLOW_equation_in_guard_atom615);
					eq=equation();
					state._fsp--;

					g = eq;
					}
					break;
				case 5 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:108:5: CAPABILITY OPEN pre= pred COMMA cap= pred COMMA pst= pred CLOSE
					{
					match(input,CAPABILITY,FOLLOW_CAPABILITY_in_guard_atom625); 
					match(input,OPEN,FOLLOW_OPEN_in_guard_atom627); 
					pushFollow(FOLLOW_pred_in_guard_atom631);
					pre=pred();
					state._fsp--;

					match(input,COMMA,FOLLOW_COMMA_in_guard_atom633); 
					pushFollow(FOLLOW_pred_in_guard_atom637);
					cap=pred();
					state._fsp--;

					match(input,COMMA,FOLLOW_COMMA_in_guard_atom639); 
					pushFollow(FOLLOW_pred_in_guard_atom643);
					pst=pred();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_guard_atom645); 
					g = new Abstract_GuardCap(pre, cap, pst);
					}
					break;
				case 6 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:110:5: PLAN OPEN (v= var |s= numberstring ) COMMA ga= pred COMMA c= pred COMMA post= pred CLOSE
					{
					match(input,PLAN,FOLLOW_PLAN_in_guard_atom661); 
					match(input,OPEN,FOLLOW_OPEN_in_guard_atom663); 
					Abstract_NumberTerm n=new Abstract_NumberTermImpl("0");
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:110:73: (v= var |s= numberstring )
					int alt24=2;
					int LA24_0 = input.LA(1);
					if ( (LA24_0==VAR) ) {
						alt24=1;
					}
					else if ( (LA24_0==MINUS||LA24_0==NUMBER) ) {
						alt24=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 24, 0, input);
						throw nvae;
					}

					switch (alt24) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:110:74: v= var
							{
							pushFollow(FOLLOW_var_in_guard_atom670);
							v=var();
							state._fsp--;

							n = v;
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:110:93: s= numberstring
							{
							pushFollow(FOLLOW_numberstring_in_guard_atom677);
							s=numberstring();
							state._fsp--;

							n = new Abstract_NumberTermImpl(s);
							}
							break;

					}

					match(input,COMMA,FOLLOW_COMMA_in_guard_atom682); 
					pushFollow(FOLLOW_pred_in_guard_atom730);
					ga=pred();
					state._fsp--;

					match(input,COMMA,FOLLOW_COMMA_in_guard_atom732); 
					pushFollow(FOLLOW_pred_in_guard_atom781);
					c=pred();
					state._fsp--;

					match(input,COMMA,FOLLOW_COMMA_in_guard_atom783); 
					pushFollow(FOLLOW_pred_in_guard_atom787);
					post=pred();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_guard_atom789); 
					g = new Abstract_GuardPlan(n, c, ga, post);
					}
					break;
				case 7 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:114:5: IMPLICATION OPEN ant= logicalfmla ARROW cons= logicalfmla CLOSE
					{
					match(input,IMPLICATION,FOLLOW_IMPLICATION_in_guard_atom846); 
					match(input,OPEN,FOLLOW_OPEN_in_guard_atom848); 
					pushFollow(FOLLOW_logicalfmla_in_guard_atom852);
					ant=logicalfmla();
					state._fsp--;

					match(input,ARROW,FOLLOW_ARROW_in_guard_atom854); 
					pushFollow(FOLLOW_logicalfmla_in_guard_atom858);
					cons=logicalfmla();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_guard_atom860); 
					g = new Abstract_GuardImplication(ant, cons);
					}
					break;
				case 8 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:115:5: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_guard_atom870); 
					g = new Abstract_GBelief();
					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return g;
	}
	// $ANTLR end "guard_atom"



	// $ANTLR start "deed"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:117:1: deed[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d] : ( ( ( PLUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) | MINUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) ) | UPDATE (l= literal ) | CALCULATE c= calculation[ds] | QUERYCOM q= query[ds] | WAIT w= wait[ds] |a= action ) |wf= waitfor | SUBSTITUTE s= substitution[ds] ) ;
	public final Abstract_Deed deed(ArrayList<Abstract_Deed> ds) throws RecognitionException {
		Abstract_Deed d = null;


		Abstract_Literal l =null;
		Abstract_Goal g =null;
		Abstract_Predicate p =null;
		Abstract_Deed c =null;
		Abstract_Deed q =null;
		Abstract_Deed w =null;
		Abstract_Action a =null;
		Abstract_Literal wf =null;
		Abstract_Deed s =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:117:61: ( ( ( ( PLUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) | MINUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) ) | UPDATE (l= literal ) | CALCULATE c= calculation[ds] | QUERYCOM q= query[ds] | WAIT w= wait[ds] |a= action ) |wf= waitfor | SUBSTITUTE s= substitution[ds] ) )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:117:63: ( ( ( PLUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) | MINUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) ) | UPDATE (l= literal ) | CALCULATE c= calculation[ds] | QUERYCOM q= query[ds] | WAIT w= wait[ds] |a= action ) |wf= waitfor | SUBSTITUTE s= substitution[ds] )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:117:63: ( ( ( PLUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) | MINUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) ) | UPDATE (l= literal ) | CALCULATE c= calculation[ds] | QUERYCOM q= query[ds] | WAIT w= wait[ds] |a= action ) |wf= waitfor | SUBSTITUTE s= substitution[ds] )
			int alt30=3;
			switch ( input.LA(1) ) {
			case CALCULATE:
			case CONST:
			case MINUS:
			case NUMBER:
			case OPEN:
			case PLUS:
			case QUERYCOM:
			case SEND:
			case UPDATE:
			case VAR:
			case WAIT:
				{
				alt30=1;
				}
				break;
			case MULT:
				{
				alt30=2;
				}
				break;
			case SUBSTITUTE:
				{
				alt30=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}
			switch (alt30) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:117:64: ( ( PLUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) | MINUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) ) | UPDATE (l= literal ) | CALCULATE c= calculation[ds] | QUERYCOM q= query[ds] | WAIT w= wait[ds] |a= action )
					{
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:117:64: ( ( PLUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) | MINUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) ) | UPDATE (l= literal ) | CALCULATE c= calculation[ds] | QUERYCOM q= query[ds] | WAIT w= wait[ds] |a= action )
					int alt29=6;
					switch ( input.LA(1) ) {
					case PLUS:
						{
						alt29=1;
						}
						break;
					case MINUS:
						{
						int LA29_2 = input.LA(2);
						if ( (LA29_2==CONST||LA29_2==LOCK||LA29_2==NOT||LA29_2==PLAN||LA29_2==SHRIEK||LA29_2==TRUE||LA29_2==VAR) ) {
							alt29=1;
						}
						else if ( (LA29_2==NUMBER) ) {
							alt29=6;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 29, 2, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case UPDATE:
						{
						alt29=2;
						}
						break;
					case CALCULATE:
						{
						alt29=3;
						}
						break;
					case QUERYCOM:
						{
						alt29=4;
						}
						break;
					case WAIT:
						{
						alt29=5;
						}
						break;
					case CONST:
					case NUMBER:
					case OPEN:
					case SEND:
					case VAR:
						{
						alt29=6;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 29, 0, input);
						throw nvae;
					}
					switch (alt29) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:117:65: ( PLUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) | MINUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) )
							{
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:117:65: ( PLUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) | MINUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE ) )
							int alt28=2;
							int LA28_0 = input.LA(1);
							if ( (LA28_0==PLUS) ) {
								alt28=1;
							}
							else if ( (LA28_0==MINUS) ) {
								alt28=2;
							}

							else {
								NoViableAltException nvae =
									new NoViableAltException("", 28, 0, input);
								throw nvae;
							}

							switch (alt28) {
								case 1 :
									// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:117:66: PLUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE )
									{
									match(input,PLUS,FOLLOW_PLUS_in_deed894); 
									// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:117:71: (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE )
									int alt26=4;
									switch ( input.LA(1) ) {
									case CONST:
									case NOT:
									case TRUE:
									case VAR:
										{
										alt26=1;
										}
										break;
									case SHRIEK:
										{
										alt26=2;
										}
										break;
									case LOCK:
										{
										alt26=3;
										}
										break;
									case PLAN:
										{
										alt26=4;
										}
										break;
									default:
										NoViableAltException nvae =
											new NoViableAltException("", 26, 0, input);
										throw nvae;
									}
									switch (alt26) {
										case 1 :
											// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:117:72: l= literal
											{
											pushFollow(FOLLOW_literal_in_deed899);
											l=literal();
											state._fsp--;

											d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILBel, l);
											}
											break;
										case 2 :
											// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:118:5: SHRIEK g= goal
											{
											match(input,SHRIEK,FOLLOW_SHRIEK_in_deed909); 
											pushFollow(FOLLOW_goal_in_deed913);
											g=goal();
											state._fsp--;

											d = new Abstract_Deed(Abstract_Deed.AILAddition, g);
											}
											break;
										case 3 :
											// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:119:5: LOCK
											{
											match(input,LOCK,FOLLOW_LOCK_in_deed923); 
											d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dlock);
											}
											break;
										case 4 :
											// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:120:5: PLAN OPEN p= pred CLOSE
											{
											match(input,PLAN,FOLLOW_PLAN_in_deed932); 
											match(input,OPEN,FOLLOW_OPEN_in_deed934); 
											pushFollow(FOLLOW_pred_in_deed938);
											p=pred();
											state._fsp--;

											match(input,CLOSE,FOLLOW_CLOSE_in_deed940); 
											d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.DPlan, p);
											}
											break;

									}

									}
									break;
								case 2 :
									// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:121:7: MINUS (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE )
									{
									match(input,MINUS,FOLLOW_MINUS_in_deed953); 
									// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:121:13: (l= literal | SHRIEK g= goal | LOCK | PLAN OPEN p= pred CLOSE )
									int alt27=4;
									switch ( input.LA(1) ) {
									case CONST:
									case NOT:
									case TRUE:
									case VAR:
										{
										alt27=1;
										}
										break;
									case SHRIEK:
										{
										alt27=2;
										}
										break;
									case LOCK:
										{
										alt27=3;
										}
										break;
									case PLAN:
										{
										alt27=4;
										}
										break;
									default:
										NoViableAltException nvae =
											new NoViableAltException("", 27, 0, input);
										throw nvae;
									}
									switch (alt27) {
										case 1 :
											// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:121:14: l= literal
											{
											pushFollow(FOLLOW_literal_in_deed958);
											l=literal();
											state._fsp--;

											d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILBel, l);
											}
											break;
										case 2 :
											// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:122:5: SHRIEK g= goal
											{
											match(input,SHRIEK,FOLLOW_SHRIEK_in_deed968); 
											pushFollow(FOLLOW_goal_in_deed972);
											g=goal();
											state._fsp--;

											d = new Abstract_Deed(Abstract_Deed.AILDeletion, g);
											}
											break;
										case 3 :
											// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:123:5: LOCK
											{
											match(input,LOCK,FOLLOW_LOCK_in_deed982); 
											d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.Dlock);
											}
											break;
										case 4 :
											// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:124:5: PLAN OPEN p= pred CLOSE
											{
											match(input,PLAN,FOLLOW_PLAN_in_deed992); 
											match(input,OPEN,FOLLOW_OPEN_in_deed994); 
											pushFollow(FOLLOW_pred_in_deed998);
											p=pred();
											state._fsp--;

											match(input,CLOSE,FOLLOW_CLOSE_in_deed1000); 
											d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.DPlan, p);
											}
											break;

									}

									}
									break;

							}

							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:126:5: UPDATE (l= literal )
							{
							match(input,UPDATE,FOLLOW_UPDATE_in_deed1017); 
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:126:12: (l= literal )
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:126:13: l= literal
							{
							pushFollow(FOLLOW_literal_in_deed1022);
							l=literal();
							state._fsp--;

							d = new Abstract_Deed(Abstract_Deed.AILUpdate, Abstract_Deed.AILBel, l);
							}

							}
							break;
						case 3 :
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:127:5: CALCULATE c= calculation[ds]
							{
							match(input,CALCULATE,FOLLOW_CALCULATE_in_deed1033); 
							pushFollow(FOLLOW_calculation_in_deed1037);
							c=calculation(ds);
							state._fsp--;

							d = c;
							}
							break;
						case 4 :
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:128:5: QUERYCOM q= query[ds]
							{
							match(input,QUERYCOM,FOLLOW_QUERYCOM_in_deed1048); 
							pushFollow(FOLLOW_query_in_deed1052);
							q=query(ds);
							state._fsp--;

							d = q;
							}
							break;
						case 5 :
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:129:5: WAIT w= wait[ds]
							{
							match(input,WAIT,FOLLOW_WAIT_in_deed1063); 
							pushFollow(FOLLOW_wait_in_deed1067);
							w=wait(ds);
							state._fsp--;

							d = w;
							}
							break;
						case 6 :
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:130:5: a= action
							{
							pushFollow(FOLLOW_action_in_deed1080);
							a=action();
							state._fsp--;

							d = new Abstract_Deed(a);
							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:131:5: wf= waitfor
					{
					pushFollow(FOLLOW_waitfor_in_deed1093);
					wf=waitfor();
					state._fsp--;

					d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dwaitfor, wf);
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:132:5: SUBSTITUTE s= substitution[ds]
					{
					match(input,SUBSTITUTE,FOLLOW_SUBSTITUTE_in_deed1103); 
					pushFollow(FOLLOW_substitution_in_deed1107);
					s=substitution(ds);
					state._fsp--;

					d = s;
					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return d;
	}
	// $ANTLR end "deed"



	// $ANTLR start "substitution"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:136:1: substitution[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d] : OPEN pl1= pred COMMA c1= pred COMMA c2= pred COMMA pl2= pred CLOSE ;
	public final Abstract_Deed substitution(ArrayList<Abstract_Deed> ds) throws RecognitionException {
		Abstract_Deed d = null;


		Abstract_Predicate pl1 =null;
		Abstract_Predicate c1 =null;
		Abstract_Predicate c2 =null;
		Abstract_Predicate pl2 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:136:69: ( OPEN pl1= pred COMMA c1= pred COMMA c2= pred COMMA pl2= pred CLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:136:71: OPEN pl1= pred COMMA c1= pred COMMA c2= pred COMMA pl2= pred CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_substitution1138); 
			pushFollow(FOLLOW_pred_in_substitution1142);
			pl1=pred();
			state._fsp--;

			match(input,COMMA,FOLLOW_COMMA_in_substitution1144); 
			pushFollow(FOLLOW_pred_in_substitution1150);
			c1=pred();
			state._fsp--;

			match(input,COMMA,FOLLOW_COMMA_in_substitution1152); 
			pushFollow(FOLLOW_pred_in_substitution1157);
			c2=pred();
			state._fsp--;

			match(input,COMMA,FOLLOW_COMMA_in_substitution1159); 
			pushFollow(FOLLOW_pred_in_substitution1165);
			pl2=pred();
			state._fsp--;

			match(input,CLOSE,FOLLOW_CLOSE_in_substitution1167); 
			Abstract_Action a = new Abstract_Action("substitute"); a.addTerm(pl1); a.addTerm(c1); a.addTerm(c2); a.addTerm(pl2); d = new Abstract_Deed(a);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return d;
	}
	// $ANTLR end "substitution"



	// $ANTLR start "calculation"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:139:1: calculation[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d] : OPEN l1= literal COMMA v= var CLOSE ;
	public final Abstract_Deed calculation(ArrayList<Abstract_Deed> ds) throws RecognitionException {
		Abstract_Deed d = null;


		Abstract_Literal l1 =null;
		Abstract_VarTerm v =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:139:68: ( OPEN l1= literal COMMA v= var CLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:139:70: OPEN l1= literal COMMA v= var CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_calculation1187); 
			pushFollow(FOLLOW_literal_in_calculation1193);
			l1=literal();
			state._fsp--;

			match(input,COMMA,FOLLOW_COMMA_in_calculation1195); 
			pushFollow(FOLLOW_var_in_calculation1199);
			v=var();
			state._fsp--;

			match(input,CLOSE,FOLLOW_CLOSE_in_calculation1201); 
			Abstract_Action a = new Abstract_Action("calculate"); a.addTerm(l1); a.addTerm(new Abstract_VarTerm("NewVarForCalculate")); ds.add(new Abstract_Deed(a));
				Abstract_Literal wf = new Abstract_Literal("result"); wf.addTerm(l1); wf.addTerm(v); ds.add(new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dwaitfor, wf));
				Abstract_Action rs = new Abstract_Action("remove_shared"); rs.addTerm(wf); d = new Abstract_Deed(rs);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return d;
	}
	// $ANTLR end "calculation"



	// $ANTLR start "query"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:144:1: query[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d] : OPEN l1= literal CLOSE ;
	public final Abstract_Deed query(ArrayList<Abstract_Deed> ds) throws RecognitionException {
		Abstract_Deed d = null;


		Abstract_Literal l1 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:144:62: ( OPEN l1= literal CLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:144:64: OPEN l1= literal CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_query1219); 
			pushFollow(FOLLOW_literal_in_query1225);
			l1=literal();
			state._fsp--;

			match(input,CLOSE,FOLLOW_CLOSE_in_query1228); 
			Abstract_Action a = new Abstract_Action("query"); a.addTerm(l1); ds.add(new Abstract_Deed(a));
				ds.add(new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dwaitfor, l1));
				Abstract_Action rs = new Abstract_Action("remove_shared"); rs.addTerm(l1); d = new Abstract_Deed(rs);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return d;
	}
	// $ANTLR end "query"



	// $ANTLR start "wait"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:149:1: wait[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d] : OPEN l1= term COMMA l2= literal CLOSE ;
	public final Abstract_Deed wait(ArrayList<Abstract_Deed> ds) throws RecognitionException {
		Abstract_Deed d = null;


		Abstract_Term l1 =null;
		Abstract_Literal l2 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:149:61: ( OPEN l1= term COMMA l2= literal CLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:149:63: OPEN l1= term COMMA l2= literal CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_wait1246); 
			pushFollow(FOLLOW_term_in_wait1252);
			l1=term();
			state._fsp--;

			match(input,COMMA,FOLLOW_COMMA_in_wait1254); 
			pushFollow(FOLLOW_literal_in_wait1258);
			l2=literal();
			state._fsp--;

			match(input,CLOSE,FOLLOW_CLOSE_in_wait1260); 
			Abstract_Action a = new Abstract_Action("wait"); a.addTerm(l1); a.addTerm(l2); ds.add(new Abstract_Deed(a));
				Abstract_Literal wf = new Abstract_Literal("waited"); wf.addTerm(l2); ds.add(new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dwaitfor, wf));
				Abstract_Action rs = new Abstract_Action("remove_shared"); rs.addTerm(wf); d = new Abstract_Deed(rs);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return d;
	}
	// $ANTLR end "wait"



	// $ANTLR start "brule"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:154:1: brule returns [Abstract_Rule r] : head= pred ( BRULEARROW f= logicalfmla SEMI | SEMI ) ;
	public final Abstract_Rule brule() throws RecognitionException {
		Abstract_Rule r = null;


		Abstract_Predicate head =null;
		Abstract_LogicalFormula f =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:154:33: (head= pred ( BRULEARROW f= logicalfmla SEMI | SEMI ) )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:154:35: head= pred ( BRULEARROW f= logicalfmla SEMI | SEMI )
			{
			pushFollow(FOLLOW_pred_in_brule1282);
			head=pred();
			state._fsp--;

			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:154:45: ( BRULEARROW f= logicalfmla SEMI | SEMI )
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==BRULEARROW) ) {
				alt31=1;
			}
			else if ( (LA31_0==SEMI) ) {
				alt31=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}

			switch (alt31) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:154:46: BRULEARROW f= logicalfmla SEMI
					{
					match(input,BRULEARROW,FOLLOW_BRULEARROW_in_brule1285); 
					pushFollow(FOLLOW_logicalfmla_in_brule1289);
					f=logicalfmla();
					state._fsp--;

					r = new Abstract_Rule(head, f);
					match(input,SEMI,FOLLOW_SEMI_in_brule1293); 
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:154:116: SEMI
					{
					match(input,SEMI,FOLLOW_SEMI_in_brule1297); 
					r = new Abstract_Rule(head);
					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return r;
	}
	// $ANTLR end "brule"



	// $ANTLR start "logicalfmla"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:156:1: logicalfmla returns [Abstract_LogicalFormula f] : n= notfmla ( COMMA n2= notfmla )* ;
	public final Abstract_LogicalFormula logicalfmla() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		Abstract_LogicalFormula n =null;
		Abstract_LogicalFormula n2 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:156:49: (n= notfmla ( COMMA n2= notfmla )* )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:156:51: n= notfmla ( COMMA n2= notfmla )*
			{
			pushFollow(FOLLOW_notfmla_in_logicalfmla1314);
			n=notfmla();
			state._fsp--;

			f = n;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:157:16: ( COMMA n2= notfmla )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==COMMA) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:157:17: COMMA n2= notfmla
					{
					match(input,COMMA,FOLLOW_COMMA_in_logicalfmla1334); 
					pushFollow(FOLLOW_notfmla_in_logicalfmla1338);
					n2=notfmla();
					state._fsp--;

					f = new Abstract_LogExpr(f, Abstract_LogExpr.and, n2);
					}
					break;

				default :
					break loop32;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return f;
	}
	// $ANTLR end "logicalfmla"



	// $ANTLR start "notfmla"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:159:1: notfmla returns [Abstract_LogicalFormula f] : (gb= pred | NOT (gb2= pred |lf= subfmla ) );
	public final Abstract_LogicalFormula notfmla() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		Abstract_Predicate gb =null;
		Abstract_Predicate gb2 =null;
		Abstract_LogicalFormula lf =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:159:45: (gb= pred | NOT (gb2= pred |lf= subfmla ) )
			int alt34=2;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==CONST||LA34_0==VAR) ) {
				alt34=1;
			}
			else if ( (LA34_0==NOT) ) {
				alt34=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 34, 0, input);
				throw nvae;
			}

			switch (alt34) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:159:47: gb= pred
					{
					pushFollow(FOLLOW_pred_in_notfmla1373);
					gb=pred();
					state._fsp--;

					f = gb;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:160:79: NOT (gb2= pred |lf= subfmla )
					{
					match(input,NOT,FOLLOW_NOT_in_notfmla1458); 
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:160:83: (gb2= pred |lf= subfmla )
					int alt33=2;
					int LA33_0 = input.LA(1);
					if ( (LA33_0==CONST||LA33_0==VAR) ) {
						alt33=1;
					}
					else if ( (LA33_0==OPEN) ) {
						alt33=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 33, 0, input);
						throw nvae;
					}

					switch (alt33) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:160:84: gb2= pred
							{
							pushFollow(FOLLOW_pred_in_notfmla1465);
							gb2=pred();
							state._fsp--;

							f = new Abstract_LogExpr(Abstract_LogExpr.not, gb2);
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:160:153: lf= subfmla
							{
							pushFollow(FOLLOW_subfmla_in_notfmla1475);
							lf=subfmla();
							state._fsp--;

							f = new Abstract_LogExpr(Abstract_LogExpr.not, lf);
							}
							break;

					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return f;
	}
	// $ANTLR end "notfmla"



	// $ANTLR start "subfmla"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:161:1: subfmla returns [Abstract_LogicalFormula f] : OPEN lf= logicalfmla CLOSE ;
	public final Abstract_LogicalFormula subfmla() throws RecognitionException {
		Abstract_LogicalFormula f = null;


		Abstract_LogicalFormula lf =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:161:45: ( OPEN lf= logicalfmla CLOSE )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:161:47: OPEN lf= logicalfmla CLOSE
			{
			match(input,OPEN,FOLLOW_OPEN_in_subfmla1489); 
			pushFollow(FOLLOW_logicalfmla_in_subfmla1495);
			lf=logicalfmla();
			state._fsp--;

			f = lf;
			match(input,CLOSE,FOLLOW_CLOSE_in_subfmla1499); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return f;
	}
	// $ANTLR end "subfmla"



	// $ANTLR start "waitfor"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:163:1: waitfor returns [Abstract_Literal wf] : MULT l= literal ;
	public final Abstract_Literal waitfor() throws RecognitionException {
		Abstract_Literal wf = null;


		Abstract_Literal l =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:163:39: ( MULT l= literal )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:163:42: MULT l= literal
			{
			match(input,MULT,FOLLOW_MULT_in_waitfor1513); 
			pushFollow(FOLLOW_literal_in_waitfor1517);
			l=literal();
			state._fsp--;

			wf = l;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return wf;
	}
	// $ANTLR end "waitfor"



	// $ANTLR start "action"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:165:1: action returns [Abstract_Action a] : ( (a1= atom PLUS a2= atom EQ_ASSGN v= var ) | ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE ) |t= pred );
	public final Abstract_Action action() throws RecognitionException {
		Abstract_Action a = null;


		Abstract_NumberTerm a1 =null;
		Abstract_NumberTerm a2 =null;
		Abstract_VarTerm v =null;
		Abstract_Literal an =null;
		int p =0;
		Abstract_Predicate t =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:165:36: ( (a1= atom PLUS a2= atom EQ_ASSGN v= var ) | ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE ) |t= pred )
			int alt35=3;
			switch ( input.LA(1) ) {
			case MINUS:
			case NUMBER:
			case OPEN:
				{
				alt35=1;
				}
				break;
			case VAR:
				{
				int LA35_3 = input.LA(2);
				if ( (LA35_3==PLUS) ) {
					alt35=1;
				}
				else if ( (LA35_3==COMMA||LA35_3==SEMI) ) {
					alt35=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 35, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case SEND:
				{
				alt35=2;
				}
				break;
			case CONST:
				{
				alt35=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 35, 0, input);
				throw nvae;
			}
			switch (alt35) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:166:2: (a1= atom PLUS a2= atom EQ_ASSGN v= var )
					{
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:166:2: (a1= atom PLUS a2= atom EQ_ASSGN v= var )
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:166:3: a1= atom PLUS a2= atom EQ_ASSGN v= var
					{
					pushFollow(FOLLOW_atom_in_action1536);
					a1=atom();
					state._fsp--;

					match(input,PLUS,FOLLOW_PLUS_in_action1538); 
					pushFollow(FOLLOW_atom_in_action1542);
					a2=atom();
					state._fsp--;

					match(input,EQ_ASSGN,FOLLOW_EQ_ASSGN_in_action1544); 
					pushFollow(FOLLOW_var_in_action1548);
					v=var();
					state._fsp--;

					a = new Abstract_Action("sum"); a.addTerm(a1); a.addTerm(a2); a.addTerm(v); 
					}

					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:167:2: ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE )
					{
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:167:2: ( SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE )
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:167:3: SEND OPEN an= literal COMMA p= performative COMMA t= pred CLOSE
					{
					match(input,SEND,FOLLOW_SEND_in_action1557); 
					match(input,OPEN,FOLLOW_OPEN_in_action1559); 
					pushFollow(FOLLOW_literal_in_action1563);
					an=literal();
					state._fsp--;

					match(input,COMMA,FOLLOW_COMMA_in_action1565); 
					pushFollow(FOLLOW_performative_in_action1569);
					p=performative();
					state._fsp--;

					match(input,COMMA,FOLLOW_COMMA_in_action1571); 
					pushFollow(FOLLOW_pred_in_action1575);
					t=pred();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_action1577); 
					a = new Abstract_SendAction(an, p, t);
					}

					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:168:2: t= pred
					{
					pushFollow(FOLLOW_pred_in_action1588);
					t=pred();
					state._fsp--;

					a = new Abstract_Action(t, Abstract_Action.normalAction);
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return a;
	}
	// $ANTLR end "action"



	// $ANTLR start "performative"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:170:1: performative returns [int b] : ( TELL | PERFORM | ACHIEVE ) ;
	public final int performative() throws RecognitionException {
		int b = 0;


		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:170:30: ( ( TELL | PERFORM | ACHIEVE ) )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:170:32: ( TELL | PERFORM | ACHIEVE )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:170:32: ( TELL | PERFORM | ACHIEVE )
			int alt36=3;
			switch ( input.LA(1) ) {
			case TELL:
				{
				alt36=1;
				}
				break;
			case PERFORM:
				{
				alt36=2;
				}
				break;
			case ACHIEVE:
				{
				alt36=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 36, 0, input);
				throw nvae;
			}
			switch (alt36) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:170:33: TELL
					{
					match(input,TELL,FOLLOW_TELL_in_performative1603); 
					b =1;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:170:48: PERFORM
					{
					match(input,PERFORM,FOLLOW_PERFORM_in_performative1609); 
					b =2;
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:170:66: ACHIEVE
					{
					match(input,ACHIEVE,FOLLOW_ACHIEVE_in_performative1615); 
					b = 3;
					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return b;
	}
	// $ANTLR end "performative"



	// $ANTLR start "environment"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:213:1: environment returns [String env] : w= classpath ;
	public final String environment() throws RecognitionException {
		String env = null;


		String w =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:213:34: (w= classpath )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:213:36: w= classpath
			{
			pushFollow(FOLLOW_classpath_in_environment1906);
			w=classpath();
			state._fsp--;

			env = w;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return env;
	}
	// $ANTLR end "environment"



	// $ANTLR start "classpath"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:214:1: classpath returns [String s] : w= word ( POINT w1= word )+ ;
	public final String classpath() throws RecognitionException {
		String s = null;


		String w =null;
		String w1 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:214:30: (w= word ( POINT w1= word )+ )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:214:32: w= word ( POINT w1= word )+
			{
			pushFollow(FOLLOW_word_in_classpath1921);
			w=word();
			state._fsp--;

			s = w;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:214:52: ( POINT w1= word )+
			int cnt37=0;
			loop37:
			while (true) {
				int alt37=2;
				int LA37_0 = input.LA(1);
				if ( (LA37_0==POINT) ) {
					alt37=1;
				}

				switch (alt37) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:214:53: POINT w1= word
					{
					match(input,POINT,FOLLOW_POINT_in_classpath1926); 
					pushFollow(FOLLOW_word_in_classpath1930);
					w1=word();
					state._fsp--;

					s+="."; s+=w1;
					}
					break;

				default :
					if ( cnt37 >= 1 ) break loop37;
					EarlyExitException eee = new EarlyExitException(37, input);
					throw eee;
				}
				cnt37++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return s;
	}
	// $ANTLR end "classpath"



	// $ANTLR start "word"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:215:1: word returns [String s] : ( CONST | VAR ) ;
	public final String word() throws RecognitionException {
		String s = null;


		Token CONST1=null;
		Token VAR2=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:215:25: ( ( CONST | VAR ) )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:215:27: ( CONST | VAR )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:215:27: ( CONST | VAR )
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( (LA38_0==CONST) ) {
				alt38=1;
			}
			else if ( (LA38_0==VAR) ) {
				alt38=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 38, 0, input);
				throw nvae;
			}

			switch (alt38) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:215:28: CONST
					{
					CONST1=(Token)match(input,CONST,FOLLOW_CONST_in_word2031); 
					s =CONST1.getText();
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:215:59: VAR
					{
					VAR2=(Token)match(input,VAR,FOLLOW_VAR_in_word2037); 
					s =VAR2.getText();
					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return s;
	}
	// $ANTLR end "word"



	// $ANTLR start "agentnameterm"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:217:1: agentnameterm returns [Abstract_StringTerm s] : ( CONST |v= var );
	public final Abstract_StringTerm agentnameterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		Token CONST3=null;
		Abstract_VarTerm v =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:217:47: ( CONST |v= var )
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( (LA39_0==CONST) ) {
				alt39=1;
			}
			else if ( (LA39_0==VAR) ) {
				alt39=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 39, 0, input);
				throw nvae;
			}

			switch (alt39) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:217:49: CONST
					{
					CONST3=(Token)match(input,CONST,FOLLOW_CONST_in_agentnameterm2137); 
					s = new Abstract_StringTermImpl(CONST3.getText());
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:217:111: v= var
					{
					pushFollow(FOLLOW_var_in_agentnameterm2145);
					v=var();
					state._fsp--;

					s = v;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return s;
	}
	// $ANTLR end "agentnameterm"



	// $ANTLR start "literal"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:220:1: literal returns [Abstract_Literal l] : ( ( TRUE | NOT nt= pred ) |t= pred );
	public final Abstract_Literal literal() throws RecognitionException {
		Abstract_Literal l = null;


		Abstract_Predicate nt =null;
		Abstract_Predicate t =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:220:37: ( ( TRUE | NOT nt= pred ) |t= pred )
			int alt41=2;
			int LA41_0 = input.LA(1);
			if ( (LA41_0==NOT||LA41_0==TRUE) ) {
				alt41=1;
			}
			else if ( (LA41_0==CONST||LA41_0==VAR) ) {
				alt41=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 41, 0, input);
				throw nvae;
			}

			switch (alt41) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:220:40: ( TRUE | NOT nt= pred )
					{
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:220:40: ( TRUE | NOT nt= pred )
					int alt40=2;
					int LA40_0 = input.LA(1);
					if ( (LA40_0==TRUE) ) {
						alt40=1;
					}
					else if ( (LA40_0==NOT) ) {
						alt40=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 40, 0, input);
						throw nvae;
					}

					switch (alt40) {
						case 1 :
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:220:41: TRUE
							{
							match(input,TRUE,FOLLOW_TRUE_in_literal2161); 
							l = new Abstract_Literal(Abstract_Literal.LTrue);
							}
							break;
						case 2 :
							// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:221:5: NOT nt= pred
							{
							match(input,NOT,FOLLOW_NOT_in_literal2172); 
							pushFollow(FOLLOW_pred_in_literal2176);
							nt=pred();
							state._fsp--;


											if (nt instanceof Abstract_VarTerm) 
												{l = (Abstract_VarTerm) nt; l.setNegated(false);}
												else { l = new Abstract_Literal(Abstract_Literal.LNeg, new Abstract_Pred(nt));}
							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:225:5: t= pred
					{
					pushFollow(FOLLOW_pred_in_literal2190);
					t=pred();
					state._fsp--;

					if (t instanceof Abstract_VarTerm) 
									            {l = (Abstract_VarTerm) t;} 
									            else {l = new Abstract_Literal(Abstract_Literal.LPos, new Abstract_Pred(t));}
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return l;
	}
	// $ANTLR end "literal"



	// $ANTLR start "pred"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:229:1: pred returns [Abstract_Predicate t] : (v= var |f= function );
	public final Abstract_Predicate pred() throws RecognitionException {
		Abstract_Predicate t = null;


		Abstract_VarTerm v =null;
		Abstract_Predicate f =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:229:37: (v= var |f= function )
			int alt42=2;
			int LA42_0 = input.LA(1);
			if ( (LA42_0==VAR) ) {
				alt42=1;
			}
			else if ( (LA42_0==CONST) ) {
				alt42=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 42, 0, input);
				throw nvae;
			}

			switch (alt42) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:229:39: v= var
					{
					pushFollow(FOLLOW_var_in_pred2206);
					v=var();
					state._fsp--;

					t = v;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:229:59: f= function
					{
					pushFollow(FOLLOW_function_in_pred2213);
					f=function();
					state._fsp--;

					t = f;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return t;
	}
	// $ANTLR end "pred"



	// $ANTLR start "function"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:230:1: function returns [Abstract_Predicate f] : CONST ( OPEN terms[$f] CLOSE )? ;
	public final Abstract_Predicate function() throws RecognitionException {
		Abstract_Predicate f = null;


		Token CONST4=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:230:40: ( CONST ( OPEN terms[$f] CLOSE )? )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:230:42: CONST ( OPEN terms[$f] CLOSE )?
			{
			CONST4=(Token)match(input,CONST,FOLLOW_CONST_in_function2225); 
			f = new Abstract_Predicate(CONST4.getText());
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:230:97: ( OPEN terms[$f] CLOSE )?
			int alt43=2;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==OPEN) ) {
				alt43=1;
			}
			switch (alt43) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:230:98: OPEN terms[$f] CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_function2230); 
					pushFollow(FOLLOW_terms_in_function2232);
					terms(f);
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_function2235); 
					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return f;
	}
	// $ANTLR end "function"



	// $ANTLR start "terms"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:232:1: terms[Abstract_Predicate f] : t= term ( COMMA terms[$f] )? ;
	public final void terms(Abstract_Predicate f) throws RecognitionException {
		Abstract_Term t =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:232:29: (t= term ( COMMA terms[$f] )? )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:232:31: t= term ( COMMA terms[$f] )?
			{
			pushFollow(FOLLOW_term_in_terms2248);
			t=term();
			state._fsp--;

			f.addTerm(t);
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:232:58: ( COMMA terms[$f] )?
			int alt44=2;
			int LA44_0 = input.LA(1);
			if ( (LA44_0==COMMA) ) {
				alt44=1;
			}
			switch (alt44) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:232:59: COMMA terms[$f]
					{
					match(input,COMMA,FOLLOW_COMMA_in_terms2253); 
					pushFollow(FOLLOW_terms_in_terms2255);
					terms(f);
					state._fsp--;

					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "terms"



	// $ANTLR start "term"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:233:1: term returns [Abstract_Term t] : (a= atom |s= stringterm |f= function );
	public final Abstract_Term term() throws RecognitionException {
		Abstract_Term t = null;


		Abstract_NumberTerm a =null;
		Abstract_StringTerm s =null;
		Abstract_Predicate f =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:233:31: (a= atom |s= stringterm |f= function )
			int alt45=3;
			switch ( input.LA(1) ) {
			case MINUS:
			case NUMBER:
			case OPEN:
			case VAR:
				{
				alt45=1;
				}
				break;
			case DOUBLEQUOTE:
				{
				alt45=2;
				}
				break;
			case CONST:
				{
				alt45=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 45, 0, input);
				throw nvae;
			}
			switch (alt45) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:233:34: a= atom
					{
					pushFollow(FOLLOW_atom_in_term2274);
					a=atom();
					state._fsp--;

					t = a;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:233:58: s= stringterm
					{
					pushFollow(FOLLOW_stringterm_in_term2284);
					s=stringterm();
					state._fsp--;

					t = s;
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:233:88: f= function
					{
					pushFollow(FOLLOW_function_in_term2292);
					f=function();
					state._fsp--;

					t = f;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return t;
	}
	// $ANTLR end "term"



	// $ANTLR start "atom"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:235:1: atom returns [Abstract_NumberTerm t] : (n= numberstring |v= var | OPEN a= arithexpr CLOSE );
	public final Abstract_NumberTerm atom() throws RecognitionException {
		Abstract_NumberTerm t = null;


		String n =null;
		Abstract_VarTerm v =null;
		Abstract_NumberTerm a =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:235:38: (n= numberstring |v= var | OPEN a= arithexpr CLOSE )
			int alt46=3;
			switch ( input.LA(1) ) {
			case MINUS:
			case NUMBER:
				{
				alt46=1;
				}
				break;
			case VAR:
				{
				alt46=2;
				}
				break;
			case OPEN:
				{
				alt46=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 46, 0, input);
				throw nvae;
			}
			switch (alt46) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:235:40: n= numberstring
					{
					pushFollow(FOLLOW_numberstring_in_atom2310);
					n=numberstring();
					state._fsp--;

					t = new Abstract_NumberTermImpl(n);
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:236:6: v= var
					{
					pushFollow(FOLLOW_var_in_atom2323);
					v=var();
					state._fsp--;

					t = v;
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:236:27: OPEN a= arithexpr CLOSE
					{
					match(input,OPEN,FOLLOW_OPEN_in_atom2329); 
					pushFollow(FOLLOW_arithexpr_in_atom2333);
					a=arithexpr();
					state._fsp--;

					match(input,CLOSE,FOLLOW_CLOSE_in_atom2335); 
					t = a;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return t;
	}
	// $ANTLR end "atom"



	// $ANTLR start "stringterm"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:237:1: stringterm returns [Abstract_StringTerm s] : DOUBLEQUOTE STRING DOUBLEQUOTE ;
	public final Abstract_StringTerm stringterm() throws RecognitionException {
		Abstract_StringTerm s = null;


		Token STRING5=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:237:44: ( DOUBLEQUOTE STRING DOUBLEQUOTE )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:237:46: DOUBLEQUOTE STRING DOUBLEQUOTE
			{
			match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm2348); 
			STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_stringterm2351); 
			match(input,DOUBLEQUOTE,FOLLOW_DOUBLEQUOTE_in_stringterm2353); 
			s = new Abstract_StringTermImpl(STRING5.getText());
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return s;
	}
	// $ANTLR end "stringterm"



	// $ANTLR start "var"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:239:1: var returns [Abstract_VarTerm v] : VAR ;
	public final Abstract_VarTerm var() throws RecognitionException {
		Abstract_VarTerm v = null;


		Token VAR6=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:239:34: ( VAR )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:239:36: VAR
			{
			VAR6=(Token)match(input,VAR,FOLLOW_VAR_in_var2367); 

				if (variables.containsKey(VAR6.getText())) {
					v = variables.get(VAR6.getText());
					} else {
					v = new Abstract_VarTerm(VAR6.getText());
					variables.put(VAR6.getText(), v);
					}
				
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return v;
	}
	// $ANTLR end "var"



	// $ANTLR start "numberstring"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:248:1: numberstring returns [String s] : ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) ;
	public final String numberstring() throws RecognitionException {
		String s = null;


		Token n1=null;
		Token n2=null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:248:33: ( ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? ) )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:248:35: ( MINUS )? (n1= NUMBER ( POINT n2= NUMBER )? )
			{
			s = "";
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:248:46: ( MINUS )?
			int alt47=2;
			int LA47_0 = input.LA(1);
			if ( (LA47_0==MINUS) ) {
				alt47=1;
			}
			switch (alt47) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:248:47: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_numberstring2384); 
					s += "-";
					}
					break;

			}

			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:248:68: (n1= NUMBER ( POINT n2= NUMBER )? )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:248:69: n1= NUMBER ( POINT n2= NUMBER )?
			{
			n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2393); 
			s += n1.getText();
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:249:6: ( POINT n2= NUMBER )?
			int alt48=2;
			int LA48_0 = input.LA(1);
			if ( (LA48_0==POINT) ) {
				alt48=1;
			}
			switch (alt48) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:249:7: POINT n2= NUMBER
					{
					match(input,POINT,FOLLOW_POINT_in_numberstring2403); 
					s += ".";
					n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberstring2409); 
					s += n2.getText();
					}
					break;

			}

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return s;
	}
	// $ANTLR end "numberstring"



	// $ANTLR start "equation"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:250:1: equation returns [Abstract_Equation eq] : a1= arithexpr oper= eqoper a2= arithexpr ;
	public final Abstract_Equation equation() throws RecognitionException {
		Abstract_Equation eq = null;


		Abstract_NumberTerm a1 =null;
		int oper =0;
		Abstract_NumberTerm a2 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:250:40: (a1= arithexpr oper= eqoper a2= arithexpr )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:250:42: a1= arithexpr oper= eqoper a2= arithexpr
			{
			pushFollow(FOLLOW_arithexpr_in_equation2426);
			a1=arithexpr();
			state._fsp--;

			pushFollow(FOLLOW_eqoper_in_equation2430);
			oper=eqoper();
			state._fsp--;

			pushFollow(FOLLOW_arithexpr_in_equation2434);
			a2=arithexpr();
			state._fsp--;

			eq = new Abstract_Equation(a1, oper, a2);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return eq;
	}
	// $ANTLR end "equation"



	// $ANTLR start "eqoper"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:251:1: eqoper returns [int oper] : ( LESS | EQ );
	public final int eqoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:251:27: ( LESS | EQ )
			int alt49=2;
			int LA49_0 = input.LA(1);
			if ( (LA49_0==LESS) ) {
				alt49=1;
			}
			else if ( (LA49_0==EQ) ) {
				alt49=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 49, 0, input);
				throw nvae;
			}

			switch (alt49) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:251:29: LESS
					{
					match(input,LESS,FOLLOW_LESS_in_eqoper2448); 
					oper =Abstract_Equation.less;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:251:68: EQ
					{
					match(input,EQ,FOLLOW_EQ_in_eqoper2454); 
					oper =Abstract_Equation.equal;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return oper;
	}
	// $ANTLR end "eqoper"



	// $ANTLR start "arithexpr"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:253:1: arithexpr returns [Abstract_NumberTerm t] : m= multexpr (oper= addoper m1= multexpr )? ;
	public final Abstract_NumberTerm arithexpr() throws RecognitionException {
		Abstract_NumberTerm t = null;


		Abstract_NumberTerm m =null;
		int oper =0;
		Abstract_NumberTerm m1 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:253:43: (m= multexpr (oper= addoper m1= multexpr )? )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:253:45: m= multexpr (oper= addoper m1= multexpr )?
			{
			pushFollow(FOLLOW_multexpr_in_arithexpr2470);
			m=multexpr();
			state._fsp--;

			t = m;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:253:69: (oper= addoper m1= multexpr )?
			int alt50=2;
			int LA50_0 = input.LA(1);
			if ( (LA50_0==MINUS||LA50_0==PLUS) ) {
				alt50=1;
			}
			switch (alt50) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:253:71: oper= addoper m1= multexpr
					{
					pushFollow(FOLLOW_addoper_in_arithexpr2478);
					oper=addoper();
					state._fsp--;

					pushFollow(FOLLOW_multexpr_in_arithexpr2482);
					m1=multexpr();
					state._fsp--;

					t = new Abstract_ArithExpr(m, oper, m1);
					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return t;
	}
	// $ANTLR end "arithexpr"



	// $ANTLR start "multexpr"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:254:1: multexpr returns [Abstract_NumberTerm t] : a= atom (oper= multoper a1= atom )? ;
	public final Abstract_NumberTerm multexpr() throws RecognitionException {
		Abstract_NumberTerm t = null;


		Abstract_NumberTerm a =null;
		int oper =0;
		Abstract_NumberTerm a1 =null;

		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:254:42: (a= atom (oper= multoper a1= atom )? )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:254:44: a= atom (oper= multoper a1= atom )?
			{
			pushFollow(FOLLOW_atom_in_multexpr2499);
			a=atom();
			state._fsp--;

			t = a;
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:254:64: (oper= multoper a1= atom )?
			int alt51=2;
			int LA51_0 = input.LA(1);
			if ( (LA51_0==DIV||(LA51_0 >= MOD && LA51_0 <= MULT)) ) {
				alt51=1;
			}
			switch (alt51) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:254:65: oper= multoper a1= atom
					{
					pushFollow(FOLLOW_multoper_in_multexpr2506);
					oper=multoper();
					state._fsp--;

					pushFollow(FOLLOW_atom_in_multexpr2510);
					a1=atom();
					state._fsp--;

					t = new Abstract_ArithExpr(a, oper, a1);
					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return t;
	}
	// $ANTLR end "multexpr"



	// $ANTLR start "addoper"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:256:1: addoper returns [int oper] : ( PLUS | MINUS ) ;
	public final int addoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:256:28: ( ( PLUS | MINUS ) )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:256:30: ( PLUS | MINUS )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:256:30: ( PLUS | MINUS )
			int alt52=2;
			int LA52_0 = input.LA(1);
			if ( (LA52_0==PLUS) ) {
				alt52=1;
			}
			else if ( (LA52_0==MINUS) ) {
				alt52=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 52, 0, input);
				throw nvae;
			}

			switch (alt52) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:256:31: PLUS
					{
					match(input,PLUS,FOLLOW_PLUS_in_addoper2527); 
					oper =Abstract_ArithExpr.plus;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:256:70: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_addoper2532); 
					oper =Abstract_ArithExpr.minus;
					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return oper;
	}
	// $ANTLR end "addoper"



	// $ANTLR start "multoper"
	// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:257:1: multoper returns [int oper] : ( MULT | DIV | MOD ) ;
	public final int multoper() throws RecognitionException {
		int oper = 0;


		try {
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:257:29: ( ( MULT | DIV | MOD ) )
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:257:31: ( MULT | DIV | MOD )
			{
			// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:257:31: ( MULT | DIV | MOD )
			int alt53=3;
			switch ( input.LA(1) ) {
			case MULT:
				{
				alt53=1;
				}
				break;
			case DIV:
				{
				alt53=2;
				}
				break;
			case MOD:
				{
				alt53=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 53, 0, input);
				throw nvae;
			}
			switch (alt53) {
				case 1 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:257:32: MULT
					{
					match(input,MULT,FOLLOW_MULT_in_multoper2547); 
					oper =Abstract_ArithExpr.times;
					}
					break;
				case 2 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:257:73: DIV
					{
					match(input,DIV,FOLLOW_DIV_in_multoper2553); 
					oper =Abstract_ArithExpr.div;
					}
					break;
				case 3 :
					// /Users/lad/Eclipse/mcapl/src/classes/eass/parser/EASS.g:257:111: MOD
					{
					match(input,MOD,FOLLOW_MOD_in_multoper2559); 
					oper =Abstract_ArithExpr.mod;
					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return oper;
	}
	// $ANTLR end "multoper"

	// Delegated rules



	public static final BitSet FOLLOW_eassagents_in_mas89 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EASS_in_eassagents102 = new BitSet(new long[]{0x0000001000000010L});
	public static final BitSet FOLLOW_eassagent_in_eassagents111 = new BitSet(new long[]{0x0000001000000012L});
	public static final BitSet FOLLOW_NAME_in_eassagent130 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_word_in_eassagent134 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_ABSTRACTION_in_eassagent141 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_word_in_eassagent145 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_BELIEFS_in_eassagent157 = new BitSet(new long[]{0x5000004010082100L});
	public static final BitSet FOLLOW_literal_in_eassagent162 = new BitSet(new long[]{0x5000004010082100L});
	public static final BitSet FOLLOW_BELIEFRULES_in_eassagent170 = new BitSet(new long[]{0x4000000010082000L});
	public static final BitSet FOLLOW_brule_in_eassagent175 = new BitSet(new long[]{0x4000000010082000L});
	public static final BitSet FOLLOW_CAPABILITIES_in_eassagent185 = new BitSet(new long[]{0x0000000010200000L});
	public static final BitSet FOLLOW_capability_in_eassagent190 = new BitSet(new long[]{0x0000000010200000L});
	public static final BitSet FOLLOW_GOALS_in_eassagent199 = new BitSet(new long[]{0x5000104000080000L});
	public static final BitSet FOLLOW_goal_in_eassagent204 = new BitSet(new long[]{0x5000104000080000L});
	public static final BitSet FOLLOW_PLANS_in_eassagent211 = new BitSet(new long[]{0x0000200200000002L});
	public static final BitSet FOLLOW_plan_in_eassagent216 = new BitSet(new long[]{0x0000200200000002L});
	public static final BitSet FOLLOW_literal_in_goal236 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_SQOPEN_in_goal238 = new BitSet(new long[]{0x0000040000000040L});
	public static final BitSet FOLLOW_ACHIEVEGOAL_in_goal241 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_PERFORMGOAL_in_goal249 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_SQCLOSE_in_goal254 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CURLYOPEN_in_capability269 = new BitSet(new long[]{0x4000004000180000L});
	public static final BitSet FOLLOW_logicalfmla_in_capability274 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_capability278 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_capability284 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_capability289 = new BitSet(new long[]{0x4000004000180000L});
	public static final BitSet FOLLOW_logicalfmla_in_capability294 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_capability300 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_event_in_plan316 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_COLON_in_plan324 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_CURLYOPEN_in_plan326 = new BitSet(new long[]{0x502009C228004400L});
	public static final BitSet FOLLOW_NOT_in_plan331 = new BitSet(new long[]{0x5020098228004400L});
	public static final BitSet FOLLOW_guard_atom_in_plan339 = new BitSet(new long[]{0x0000000000120000L});
	public static final BitSet FOLLOW_COMMA_in_plan347 = new BitSet(new long[]{0x502009C228004400L});
	public static final BitSet FOLLOW_NOT_in_plan352 = new BitSet(new long[]{0x5020098228004400L});
	public static final BitSet FOLLOW_guard_atom_in_plan360 = new BitSet(new long[]{0x0000000000120000L});
	public static final BitSet FOLLOW_CURLYCLOSE_in_plan366 = new BitSet(new long[]{0x000C000000000000L});
	public static final BitSet FOLLOW_RULEARROW_in_plan369 = new BitSet(new long[]{0xE411218A00081000L});
	public static final BitSet FOLLOW_deed_in_plan374 = new BitSet(new long[]{0x0008000000020000L});
	public static final BitSet FOLLOW_COMMA_in_plan380 = new BitSet(new long[]{0xE411218A00081000L});
	public static final BitSet FOLLOW_deed_in_plan384 = new BitSet(new long[]{0x0008000000020000L});
	public static final BitSet FOLLOW_SEMI_in_plan395 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_event411 = new BitSet(new long[]{0x5042004000080000L});
	public static final BitSet FOLLOW_RECEIVED_in_event414 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_event416 = new BitSet(new long[]{0x0800020000000020L});
	public static final BitSet FOLLOW_performative_in_event420 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_event422 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_event426 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_event428 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_in_event446 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHRIEK_in_event456 = new BitSet(new long[]{0x5000004000080000L});
	public static final BitSet FOLLOW_goal_in_event460 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_event474 = new BitSet(new long[]{0x5040004000080000L});
	public static final BitSet FOLLOW_literal_in_event479 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHRIEK_in_event489 = new BitSet(new long[]{0x5000004000080000L});
	public static final BitSet FOLLOW_goal_in_event493 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BELIEVE_in_guard_atom514 = new BitSet(new long[]{0x5000004000080000L});
	public static final BitSet FOLLOW_literal_in_guard_atom518 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GOAL_in_guard_atom528 = new BitSet(new long[]{0x5000004000080000L});
	public static final BitSet FOLLOW_goal_in_guard_atom532 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SENT_in_guard_atom542 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_guard_atom544 = new BitSet(new long[]{0x4000000000800000L});
	public static final BitSet FOLLOW_stringterm_in_guard_atom551 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_var_in_guard_atom559 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom564 = new BitSet(new long[]{0x0800020000800020L});
	public static final BitSet FOLLOW_stringterm_in_guard_atom571 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom579 = new BitSet(new long[]{0x0800020000000020L});
	public static final BitSet FOLLOW_performative_in_guard_atom587 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom595 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_guard_atom599 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_guard_atom601 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_equation_in_guard_atom615 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CAPABILITY_in_guard_atom625 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_guard_atom627 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_guard_atom631 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom633 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_guard_atom637 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom639 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_guard_atom643 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_guard_atom645 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLAN_in_guard_atom661 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_guard_atom663 = new BitSet(new long[]{0x4000008200000000L});
	public static final BitSet FOLLOW_var_in_guard_atom670 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_numberstring_in_guard_atom677 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom682 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_guard_atom730 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom732 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_guard_atom781 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_guard_atom783 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_guard_atom787 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_guard_atom789 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IMPLICATION_in_guard_atom846 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_guard_atom848 = new BitSet(new long[]{0x4000004000080000L});
	public static final BitSet FOLLOW_logicalfmla_in_guard_atom852 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_ARROW_in_guard_atom854 = new BitSet(new long[]{0x4000004000080000L});
	public static final BitSet FOLLOW_logicalfmla_in_guard_atom858 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_guard_atom860 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_guard_atom870 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_deed894 = new BitSet(new long[]{0x5040084100080000L});
	public static final BitSet FOLLOW_literal_in_deed899 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHRIEK_in_deed909 = new BitSet(new long[]{0x5000004000080000L});
	public static final BitSet FOLLOW_goal_in_deed913 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOCK_in_deed923 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLAN_in_deed932 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_deed934 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_deed938 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_deed940 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_deed953 = new BitSet(new long[]{0x5040084100080000L});
	public static final BitSet FOLLOW_literal_in_deed958 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHRIEK_in_deed968 = new BitSet(new long[]{0x5000004000080000L});
	public static final BitSet FOLLOW_goal_in_deed972 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOCK_in_deed982 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLAN_in_deed992 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_deed994 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_deed998 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_deed1000 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UPDATE_in_deed1017 = new BitSet(new long[]{0x5000004000080000L});
	public static final BitSet FOLLOW_literal_in_deed1022 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CALCULATE_in_deed1033 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_calculation_in_deed1037 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QUERYCOM_in_deed1048 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_query_in_deed1052 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WAIT_in_deed1063 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_wait_in_deed1067 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_action_in_deed1080 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_waitfor_in_deed1093 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SUBSTITUTE_in_deed1103 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_substitution_in_deed1107 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_substitution1138 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_substitution1142 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_substitution1144 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_substitution1150 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_substitution1152 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_substitution1157 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_substitution1159 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_substitution1165 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_substitution1167 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_calculation1187 = new BitSet(new long[]{0x5000004000080000L});
	public static final BitSet FOLLOW_literal_in_calculation1193 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_calculation1195 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_var_in_calculation1199 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_calculation1201 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_query1219 = new BitSet(new long[]{0x5000004000080000L});
	public static final BitSet FOLLOW_literal_in_query1225 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_query1228 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_wait1246 = new BitSet(new long[]{0x4000018200880000L});
	public static final BitSet FOLLOW_term_in_wait1252 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_wait1254 = new BitSet(new long[]{0x5000004000080000L});
	public static final BitSet FOLLOW_literal_in_wait1258 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_wait1260 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pred_in_brule1282 = new BitSet(new long[]{0x0008000000000800L});
	public static final BitSet FOLLOW_BRULEARROW_in_brule1285 = new BitSet(new long[]{0x4000004000080000L});
	public static final BitSet FOLLOW_logicalfmla_in_brule1289 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_SEMI_in_brule1293 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEMI_in_brule1297 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_notfmla_in_logicalfmla1314 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_COMMA_in_logicalfmla1334 = new BitSet(new long[]{0x4000004000080000L});
	public static final BitSet FOLLOW_notfmla_in_logicalfmla1338 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_pred_in_notfmla1373 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_notfmla1458 = new BitSet(new long[]{0x4000010000080000L});
	public static final BitSet FOLLOW_pred_in_notfmla1465 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_subfmla_in_notfmla1475 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_subfmla1489 = new BitSet(new long[]{0x4000004000080000L});
	public static final BitSet FOLLOW_logicalfmla_in_subfmla1495 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_subfmla1499 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_waitfor1513 = new BitSet(new long[]{0x5000004000080000L});
	public static final BitSet FOLLOW_literal_in_waitfor1517 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_action1536 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_PLUS_in_action1538 = new BitSet(new long[]{0x4000018200000000L});
	public static final BitSet FOLLOW_atom_in_action1542 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_EQ_ASSGN_in_action1544 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_var_in_action1548 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEND_in_action1557 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OPEN_in_action1559 = new BitSet(new long[]{0x5000004000080000L});
	public static final BitSet FOLLOW_literal_in_action1563 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_action1565 = new BitSet(new long[]{0x0800020000000020L});
	public static final BitSet FOLLOW_performative_in_action1569 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_action1571 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_action1575 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_action1577 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pred_in_action1588 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TELL_in_performative1603 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PERFORM_in_performative1609 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACHIEVE_in_performative1615 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_classpath_in_environment1906 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_word_in_classpath1921 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_POINT_in_classpath1926 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_word_in_classpath1930 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_CONST_in_word2031 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_word2037 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_agentnameterm2137 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_agentnameterm2145 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_literal2161 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_literal2172 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_pred_in_literal2176 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pred_in_literal2190 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_pred2206 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_pred2213 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONST_in_function2225 = new BitSet(new long[]{0x0000010000000002L});
	public static final BitSet FOLLOW_OPEN_in_function2230 = new BitSet(new long[]{0x4000018200880000L});
	public static final BitSet FOLLOW_terms_in_function2232 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_function2235 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_terms2248 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_COMMA_in_terms2253 = new BitSet(new long[]{0x4000018200880000L});
	public static final BitSet FOLLOW_terms_in_terms2255 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_term2274 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stringterm_in_term2284 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_term2292 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberstring_in_atom2310 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_atom2323 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_atom2329 = new BitSet(new long[]{0x4000018200000000L});
	public static final BitSet FOLLOW_arithexpr_in_atom2333 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_CLOSE_in_atom2335 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm2348 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STRING_in_stringterm2351 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_DOUBLEQUOTE_in_stringterm2353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_var2367 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_numberstring2384 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring2393 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_POINT_in_numberstring2403 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_NUMBER_in_numberstring2409 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithexpr_in_equation2426 = new BitSet(new long[]{0x0000000042000000L});
	public static final BitSet FOLLOW_eqoper_in_equation2430 = new BitSet(new long[]{0x4000018200000000L});
	public static final BitSet FOLLOW_arithexpr_in_equation2434 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESS_in_eqoper2448 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EQ_in_eqoper2454 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr2470 = new BitSet(new long[]{0x0000200200000002L});
	public static final BitSet FOLLOW_addoper_in_arithexpr2478 = new BitSet(new long[]{0x4000018200000000L});
	public static final BitSet FOLLOW_multexpr_in_arithexpr2482 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_multexpr2499 = new BitSet(new long[]{0x0000000C00400002L});
	public static final BitSet FOLLOW_multoper_in_multexpr2506 = new BitSet(new long[]{0x4000018200000000L});
	public static final BitSet FOLLOW_atom_in_multexpr2510 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_addoper2527 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_addoper2532 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_multoper2547 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DIV_in_multoper2553 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MOD_in_multoper2559 = new BitSet(new long[]{0x0000000000000002L});
}
