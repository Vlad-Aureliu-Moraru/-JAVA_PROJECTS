public class OL {
    private String omega;
    private RuleSet rules = new RuleSet();
    private String result;

    public void generateResult(int steps) {
        if (omega!=null) {
            result = new String(omega);
            for (int i = 0; i <steps; i++) {
//                System.out.println(i);
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < result.length(); j++) {
                    String toSearch = result.charAt(j)+"";
//                    System.out.println("char :"+toSearch);
                    String toReplace = rules.searchRightRule(toSearch);
//                    System.out.println("replace char:"+toReplace);
                    if (toReplace!=null) {
                        stringBuilder.append(toReplace);
                    }else{
                        stringBuilder.append(toSearch);
                    }
                }
                result = stringBuilder.toString();
//                System.out.println(result);
            }
        }else {
            System.out.println("init omega");
        }
    }

    public void setOmega(String omega) {
        this.omega = omega;
    }
    public void setRules(RuleSet rules) {
        this.rules = rules;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public String getOmega() {
        return omega;
    }
    public RuleSet getRules() {
        return rules;
    }
    public String getResult() {
        return result;
    }
}
