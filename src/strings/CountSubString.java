package strings;

class CountSubString
{

    //O(n2)
    int countSubStr(char str[],int n)
    {
        int res = 0;  // Initialize result

        // Pick a starting point
        for (int i = 0; i<n; i++)
        {
            if (str[i] == '1')
            {
                // Search for all possible ending point
                for (int j = i + 1; j< n; j++)
                {
                    if (str[j] == '1')
                        res++;
                }
            }
        }
        return res;
    }

    //O(n)

    int countSubStrLinear(char str[], int n)
    {
        int m = 0; // Count of 1's in input string

        // Traverse input string and count of 1's in it
        for (int i = 0; i < n; i++)
        {
            if (str[i] == '1')
                m++;
        }

        // Return count of possible pairs among m 1's
        return m * (m - 1) / 2;
    }

    // Driver program to test the above function
    public static void main(String[] args)
    {
        CountSubString count = new CountSubString();
        String string = "00100101";
        char str[] = string.toCharArray();
        int n = str.length;
        System.out.println(count.countSubStr(str,n));
    }
}
