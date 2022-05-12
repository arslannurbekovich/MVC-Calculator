public class Model {

    private Viewer viewer;
    private String temp;
    private ReversePolishNotation decide;
    private String leftValue;
    double number;
    private String infix;

    public Model(Viewer viewer) {
        infix = "";
        this.viewer = viewer;
        temp = "";
        leftValue = "";

    }

    public void doAction(String command) {
        if (command.equals("One")) { ;
            temp = temp + "1";
            infix = infix + "1";
        }
        if (command.equals("Two")) {
            temp = temp + "2";
            infix = infix + "2";

        }
        if (command.equals("Three")) {
            temp = temp + "3";
            infix = infix + "3";

        }
        if (command.equals("Four")) {
            temp = temp + "4";
            infix = infix + "4";

        }
        if (command.equals("Five")) { ;
            temp = temp + "5";
            infix = infix + "5";

        }
        if (command.equals("Six")) {
            temp = temp + "6";
            infix = infix + "6";

        }
        if (command.equals("Seven")) {
            temp = temp + "7";
            infix = infix + "7";

        }
        if (command.equals("Eight")) {
            temp = temp + "8";
            infix = infix + "8";

        }
        if (command.equals("Nine")) {
            temp = temp + "9";
            infix = infix + "9";

        }
        if (command.equals("Zero")) {
            temp = temp + "0";
            infix = infix + "0";

        }
        if (command.equals("Plus")) {
            infix = infix + "+";
            leftValue = temp;
            temp = "";
            return;

        }
        if (command.equals("Minus")) {
            infix = infix + "-";
            leftValue = temp;
            temp = "";
            return;

        }
        if (command.equals("Divide")) {
            infix = infix + "/";
            leftValue = temp;
            temp = "";
            return;

        }
        if (command.equals("Multiple")) {
            infix = infix + "*";
            leftValue = temp;
            temp = "";
            return;

        }
        if (command.equals("Percent")) {
            number = Double.parseDouble(temp);
            number = number / 100;
            temp = checkToInt(number);
        }
        if (command.equals("Sqrt")) {
            number = Double.parseDouble(temp);
            number = Math.sqrt(number);
            temp = checkToInt(number);
        }
        if (command.equals("Sqr")) {
            number =Double.parseDouble(temp);
            number = Math.pow(number, 2);
            temp = checkToInt(number);
        }
        if (command.equals("OneToX")) {
            number = Double.parseDouble(temp);
            temp = 1 / number + "";

        }
        if (command.equals("Sign")) {
            number = Double.parseDouble(temp);
            temp = (-1) * number + "";

        }
        if (command.equals("Point")) {
            if (!temp.substring(temp.lastIndexOf(" ") + 1).contains(".")) {
                if (!temp.equals("") && !temp.endsWith(" ")) {
                    infix = infix + ".";
                    temp = temp + ".";
                }
            }

        }
        if (command.equals("X")) {
            if (temp.length() > 0)
                infix = infix.substring(0, temp.length() - 1);
            temp = temp.substring(0, temp.length() - 1);

        }
        if (command.equals("C")) {
            infix = "";
            temp = "";
        }

        if (command.equals("Equal")) {
            decide= new ReversePolishNotation();
            double result = decide.getAnswer(infix);
            temp = "" + result;
            checkToInt(result);
            infix = temp;

        }

        viewer.update(temp);

    }

    private String checkToInt(double answer){
        if(answer%1 == 0){
            temp = "" + (int)answer;
        }
        else {
            temp = "" + answer;
        }
        return temp;
    }
}
