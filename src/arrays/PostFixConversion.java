package arrays;

import java.util.Stack;

public class PostFixConversion {
    static boolean isOperand(char x)
    {
        return (x >= 'a' && x <= 'z') ||
                (x >= 'A' && x <= 'Z');
    }

    // Get Infix for a given postfix
// expression
    static String getInfix(String exp)
    {
        Stack<String> s = new Stack<String>();

        for (int i = 0; i < exp.length(); i++)
        {
            // Push operands
            if (isOperand(exp.charAt(i)))
            {
                s.push(exp.charAt(i) + "");
            }

            // We assume that input is
            // a valid postfix and expect
            // an operator.
            else
            {
                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();
                s.push("(" + op2 + exp.charAt(i) +
                        op1 + ")");
            }
        }

        // There must be a single element
        // in stack now which is the required
        // infix.
        return s.peek();
    }

    // Driver code
    public static void main(String args[])
    {
        String exp = "ab*c+";
        System.out.println( getInfix(exp));

        String exp1="231*+9-";
        System.out.println(evaluatePostfix(exp1));
    }

    // Method to evaluate value of a postfix expression
    // String exp="231*+9-";
    static int evaluatePostfix(String exp)
    {
        //create a stack
        Stack<Integer> stack=new Stack<>();

        // Scan all characters one by one
        for(int i=0;i<exp.length();i++)
        {
            char c=exp.charAt(i);

            // If the scanned character is an operand (number here),
            // push it to the stack.
            if(Character.isDigit(c))
                stack.push(Integer.parseInt(String.valueOf(c))); //OR c - '0'

                //  If the scanned character is an operator, pop two
                // elements from stack apply the operator
            else
            {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch(c)
                {
                    case '+':
                        stack.push(val2+val1);
                        break;

                    case '-':
                        stack.push(val2- val1);
                        break;

                    case '/':
                        stack.push(val2/val1);
                        break;

                    case '*':
                        stack.push(val2*val1);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
