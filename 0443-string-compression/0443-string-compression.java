class Solution {
    public int compress(char[] chars) {
        List <Character> list = new ArrayList<>();
        int count = 0;
        int sum = 0;
        for(int i=0; i<chars.length;){
            char c = chars[i];
            int j = i;
            count = 0;
            while(j<chars.length){
                if(c == chars[j]){
                    count++;
                } else {
                    break;
                }
                j++;
            }
            if(count == 1){
                list.add(chars[j-1]);
                i = j;
                sum++;
                continue;
            }
            String s = String.valueOf(count);
            char p[] = s.toCharArray();
            list.add(chars[j-1]);
            for(char num: p){
                list.add(num);
            }
            i = j;
        }
        for(int i=0; i<list.size(); i++){
            chars[i] = list.get(i);
        }
        return list.size();
    }
}