package strings;

import java.util.Stack;

/**
 *
 * Parenthesis Checker
 *
 *
 * Given an expression string exp. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
 * For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”
 *
 *
 * input : {([])}
 * output: balanced
 *
 * input: ([]
 * output: not balanced
 *
 */
public class ParenthesisChecker {

    public static void main(String args[]) {

        String str = "{([])}";
        Boolean result = isValidExpression(str.toCharArray());
        System.out.println(result ? "Balanced" : "Not Balanced");
    }

    public static Boolean isValidExpression(char exp[]){
        {
            /* Declare an empty character stack */
            Stack  st=new Stack();

       /* Traverse the given expression to
          check matching parenthesis */
            for(int i=0;i<exp.length;i++)
            {

          /*If the exp[i] is a starting
            parenthesis then push it*/
                if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[')
                    st.push(exp[i]);

          /* If exp[i] is an ending parenthesis
             then pop from stack and check if the
             popped parenthesis is a matching pair*/
                if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']')
                {

              /* If we see an ending parenthesis without
                 a pair then return false*/
                    if (st.isEmpty())
                    {
                        return false;
                    }

             /* Pop the top element from stack, if
                it is not a pair parenthesis of character
                then there is a mismatch. This happens for
                expressions like {(}) */
                    else if ( !isMatchingPair((Character) st.pop(), exp[i]) )
                    {
                        return false;
                    }
                }

            }

       /* If there is something left in expression
          then there is a starting parenthesis without
          a closing parenthesis */

            if (st.isEmpty())
                return true; /*balanced*/
            else
            {   /*not balanced*/
                return false;
            }
        }

    }

    /* Returns true if character1 and character2
       are matching left and right Parenthesis */
    static boolean isMatchingPair(char character1, char character2)
    {
        if (character1 == '(' && character2 == ')')
            return true;
        else if (character1 == '{' && character2 == '}')
            return true;
        else if (character1 == '[' && character2 == ']')
            return true;
        else
            return false;
    }

}
