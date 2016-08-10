public class Solution233 {
    //Given an integer n, count the total number of digit 1
    // appearing in all non-negative integers less than or equal to n.

    //position is the digit we on
    //count is how many digits from (0~position-1) like 000~999
    //for example we have 1000 numbers here 000~999    count = 3
    //and every digit is 0,1,2... or 9, so there are 10 choices. so choice '1' is 1/10
    //and there are 3 digits which '1' can show up 1xx x1x xx1
    //so the total number of '1' is 1000/10 * 3

    //for example the given number is 317456
    //first we deal with 6  position = 1   count = 0
    //because 6 > 1 so sum += position which is 1 and sum += digit * position/10*count
    //then we do 5 position = 10   count = 1  ...
    //then we do 4 position = 100  count = 2  ...

    //lets show some details when we deal with 7 and position = 1000 count = 3 like the example before
    //because we already done with 456, so we only consider 7000 here
    //7 > 1
    //so there are 1000 nums from 1000~1999 so sum += position(1000)
    //and for the last 3 digits, there are 7 * (000~999)
    //which is digit * position/10 * count   (the number of '1')
    //           7   * 1000    /10 * 3       (the reason is shown above)
    //sum += digit * position/10 * count

    //then we deal with 1 position = 10000 count = 4
    //because 1 is equal to 1    :0
    //so int the example we only have 10000~17456 instead of 10000~19999
    //so there is 7456 + 1 's '1' there
    //and we also need to deal with the 0000~9999 as above
    //which is sum += position/10 * count;

    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        int count = 0;          //how many digits (0~position-1)
                                //for example  0~99 count is 2
        int position = 1;       //the digit we on
        int sum = 0;
        int lastDigits = n;     //the last digits need to deal with
        while( n >= position ){
            int digit = lastDigits % 10;
            lastDigits /= 10;
            if( digit > 1 ){
                sum += position;
                sum += digit * position/10 * count;
            }
            else if( digit == 1 ){              //for example 1456
                sum += n % position +1;         //1000~1456 contains (456+1)'s1
                sum += position/10 * count;     //000~999 (3 digits) contains 1000/10 * 3
                                                //1000/10 10 means 10 diff Integer 0~9
            }
            position *= 10;
            count++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution233 test = new Solution233();
        System.out.println(test.countDigitOne(100));
    }
}
