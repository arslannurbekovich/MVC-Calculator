public class ReversePolishNotation {

    public double getAnswer(String exp){
        return calculateReversePolishNotation(expressionToReversePolishNotation(exp));
    }

    private String expressionToReversePolishNotation(String expression) {
        MyStack stack = new MyStack();
        String current = " ";
        int priority;

        for (int i = 0; i < expression.length(); i++) {
            priority = getPriority(expression.charAt(i));

            if (priority == -1) {
                current = current +  ' ';
                while (getPriority(stack.peek()) != 1) {
                    current = current + stack.pop();
                }
                stack.pop();
            }

            if (priority == 0) {
                current = current + expression.charAt(i);
            }

            if (priority == 1) {
                stack.push(expression.charAt(i));
            }

            if (priority == 2 || priority == 3) {
                current = current + ' ';
                while (!stack.isEmpty()) {
                    if (getPriority(stack.peek()) >= priority) {
                        current = current + stack.pop();
                    }
                    else break;
                }
                stack.push(expression.charAt(i));
            }
        }
        while (!stack.isEmpty())
            current = current + stack.pop();
        return current;
    }

    private int getPriority(char sign) {
        if (sign == '*' || sign == '/')
            return 3;
        else if (sign == '+' || sign == '-')
            return 2;
        else if (sign == '(')
            return 1;
        else if (sign == ')')
            return -1;
        else
            return 0;
    }

    private double calculateReversePolishNotation(String rpn) {
        String operand = "";
        StackDouble stack = new StackDouble();

        for (int i = 0; i < rpn.length(); i++) {
            if (rpn.charAt(i) == ' ') {
                continue;
            }

            if (getPriority(rpn.charAt(i)) == 0) {
                while (rpn.charAt(i) != ' ' && getPriority(rpn.charAt(i)) == 0) {
                    operand = operand + rpn.charAt(i++);
                    if (i == rpn.length()) {
                        break;
                    }
                }
                stack.push(Double.parseDouble(operand));
                operand = new String();
            }
            if (getPriority(rpn.charAt(i)) > 1) {
                double a = stack.pop();
                double b = stack.pop();
                if (rpn.charAt(i) == '+') {
                    stack.push(b + a);
                }
                if (rpn.charAt(i) == '-') {
                    stack.push(b - a);
                }
                if (rpn.charAt(i) == '*') {
                    stack.push(b * a);
                }
                if (rpn.charAt(i) == '/') {
                    stack.push(b / a);
                }
            }
        }
        return stack.pop();
    }
}
