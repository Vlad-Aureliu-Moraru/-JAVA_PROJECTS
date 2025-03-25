import java.util.ArrayList;

public class RuleSet {
    private ArrayList<Rule> rules = new ArrayList<>();

    public ArrayList<Rule> getRules() {
        return rules;
    }
    public void setRules(ArrayList<Rule> rules) {
        this.rules = rules;
    }
    public void addRule(Rule rule) {
        rules.add(rule);
    }
    public String searchRightRule(String left){
        for(Rule rule : rules){
            if(rule.getLeft().equals(left)){
                return rule.getRight();
            }
        }
        return null;
    }
}
