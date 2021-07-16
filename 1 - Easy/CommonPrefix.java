class CommonPrefix {
    
    public String longestCommonPrefix(String[] strs) {
        
        if(strs.length == 0 || strs[0].isEmpty()) return "";
        
        int i = 0;
        String base = strs[0];
        char ch;
        
        loop: for (; i < base.length(); i++) {
            ch = base.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != ch)
                    break loop;
            }
        }
        return base.substring(0, i);
    }
}