public class MyStack{

    private Character[] stack;
    private int top;

    public MyStack(){
        top = -1;
        stack = new Character[50];
    }

    public Character pop(){
        Character temp = stack[top];
        top = top - 1;
        return temp;
    }

    public void push(char enity){
        top = top + 1;
        stack[top] = enity;
    }

    public char peek(){
        return stack[top];
    }

    public boolean isEmpty(){
        if(top > -1){
            return false;
        }
        return true;
    }
}
