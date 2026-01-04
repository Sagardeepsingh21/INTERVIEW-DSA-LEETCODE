// LeetCode-1390
// four divisors
// Best for mathematical logics
// java solutions:-
class solutions {
   
    public int SumIfFourDivisors(int num){
        int divisors=0;
        int sum=0;
        for(int div=1;div*div<=num;div++){

            if(num % div ==0){
                int other=num/div;

                if(div == other){
                    divisors++;
                    sum += div;
                }else{
                    divisors +=2;
                    sum +=div+other;
                }
            }
            if(divisors>4){
                return 0;
            }
        }
        return divisors == 4 ? sum:0;
    }
    public int sumforDivisors(int[] nums){
        int result=0;
        for(int num:nums){
            result+= SumIfFourDivisors(num);
        }
        return result;
    }
}
