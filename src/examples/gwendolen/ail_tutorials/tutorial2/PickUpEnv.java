package gwendolen.ail_tutorials.tutorial2;

import ail.mas.DefaultEnvironment;
import ail.syntax.Action;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ail.util.AILexception;

public class PickUpEnv extends DefaultEnvironment {

    @Override
    public Unifier executeAction(String agName, Action act) throws AILexception {

        Unifier u = new Unifier();

        if (act.getFunctor().equals("pickup")) {
            addPercept(agName, new Predicate("holding_block"));
        }

        super.executeAction(agName, act);
        return u;
    }
}
