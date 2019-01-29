
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NoRepeatString {
    
    public static List<String> getNoRepeatString (String str){
            //存放可能多个的最长子串  
            List<String> longlists=new ArrayList<String>();  
            //存放无重复字符所在的最后位置  
            HashMap<Object, Object> map=new HashMap<Object, Object>();  
            //开始位置  
            int start=0;  
            //最大长度  
            int maxlen=0;  
            int pre=0;  
            int i;  
              
            //一次遍历字符串  
            for(i=0;i<str.length();i++)  
            {  
                //如果map中包含这个字符  
                if(map.containsKey(str.charAt(i)))  
                {  
                    //当前子串的长度  
                    int nowlen=i-start;  
                    //子串存在map中的次最新的位置  
                    pre=(int) map.get(str.charAt(i));  
                    //找到了最新的串,>=是为了解决多个相等的最长子串问题,比如"abab"  
                    if(nowlen>=maxlen)  
                    {  
                        //这是为了在有最长子串的情况下，清除之前存的子串，比如"ababc"  
                        if(nowlen>maxlen)  
                        {  
                            longlists.clear();  
                        }  
                        //设置最长子串和其长度  
                        maxlen=nowlen;  
                        longlists.add(str.substring(start,i));  
                    }  
                    //只要包含重复的字符,就更新map中的最新位置  
                    //将起始位置设置为重复字符第一次出现位置的后一个位置  
                    start=pre+1;  
                    map.put(str.charAt(i), i);  
                }  
                else  
                {  
                    //不包含之间放进map中标记最新位置  
                    map.put(str.charAt(i), i);  
                }  
            }  
            //是为了解决从来不包含重复字符的情况  
            if(i-start>=maxlen)  
            {  
                if(i-start>maxlen)  
                {  
                    longlists.clear();  
                }  
                longlists.add(str.substring(start,i));  
            }  
            return longlists;  
        }
    
    

}
