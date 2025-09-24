class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();

        if((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)){
            sb.append("-");
        }
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        long x = num / den;
        sb.append(x);
        long rem = num % den;
        if(rem == 0) return sb.toString();
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while(rem != 0){
            if(map.containsKey(rem)){
                int idx = map.get(rem);
                sb.insert(idx, "(");
                sb.append(")");
                break;
            }
            map.put(rem, sb.length());
            rem = rem * 10;
            sb.append(rem/den);
            rem = rem % den;
        }
        return sb.toString();
    }
}