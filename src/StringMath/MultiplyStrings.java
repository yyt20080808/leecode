package StringMath;


//Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
//
//        Example 1:
//
//        Input: num1 = "2", num2 = "3"
//        Output: "6"
//        Example 2:
//
//        Input: num1 = "123", num2 = "456"
//        Output: "56088"
//        Note:
//
//        The length of both num1 and num2 is < 110.
//        Both num1 and num2 contain only digits 0-9.
//        Both num1 and num2 do not contain any leading zero, except the number 0 itself.
//        You must not use any built-in BigInteger library or convert the inputs to integer directly.
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals( "0" ) || num2.equals( "0" ))
            return "0";
        int length = num1.length() + num2.length();
        int[] res = new int[length];
        int pos = length-1;
        for (int i = num1.length()-1; i >=0 ; i--) {
            int tempPos = pos;
            for (int j = num2.length()-1; j >=0 ; j--) {
                int a = num1.charAt( i )- 48;
                int b = num2.charAt( j )-48;
                res[tempPos] += a*b;
                res[tempPos-1] += res[tempPos] /10;
                res[tempPos] = res[tempPos]%10;
                tempPos-=1;
            }
            pos-=1;
        }
        StringBuilder resString = new StringBuilder(  );
        int start = 0;
        for(start = 0;start < length;start++){
            if(res[start]!=0)
                break;
        }
        for (int i = start;i < length;i++){
            resString.append( res[i] );
        }

        return resString.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings m = new MultiplyStrings();
        System.out.println(m.multiply( "1002","2221" ));
    }
}
