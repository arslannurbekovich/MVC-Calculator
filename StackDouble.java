public class StackDouble{

    private Double[] stack;
    private int top;

    public StackDouble(){
        top = -1;
        stack = new Double[50];
    }

    public void push(Double enity){
        top = top + 1;
        stack[top] = enity;
    }
    public Double pop(){
        Double temp = stack[top];
        top = top - 1;
        return temp;
    }

}