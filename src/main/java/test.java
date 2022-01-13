import java.util.HashSet;
import java.util.Set;

/**
 * Project name(项目名称)：算法_Longest_Substring_Without_Repeating_Characters
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/13
 * Time(创建时间)： 13:51
 * Version(版本): 1.0
 * Description(描述)： 给定一个字符串，找到没有重复字符的最长子串，返回它的长度。
 * 解法一
 * 找一个最长子串，用两个循环穷举所有子串，然后再用一个函数判断该子串中有没有重复的字符。
 */

public class test
{
    public int lengthOfLongestSubstring(String s)
    {
        int n = s.length();
        int ans = 0;//保存当前得到满足条件的子串的最大值
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j <= n; j++) //之所以 j<= n，是因为我们子串是 [i,j),左闭右开
            {
                if (allUnique(s, i, j))
                {
                    ans = Math.max(ans, j - i); //更新 ans
                }
            }
        }
        return ans;
    }

    public boolean allUnique(String s, int start, int end)
    {
        Set<Character> set = new HashSet<>();//初始化 hash set
        for (int i = start; i < end; i++)
        {//遍历每个字符
            Character ch = s.charAt(i);
            if (set.contains(ch))
            {
                return false; //判断字符在不在 set 中
            }
            set.add(ch);//不在的话将该字符添加到 set 里边
        }
        return true;
    }

    public static void main(String[] args)
    {
        test t = new test();
        System.out.println("给定一个字符串，找到没有重复字符的最长子串，返回它的长度:");
        System.out.println("解法一:\n" +
                "找一个最长子串，用两个循环穷举所有子串，然后再用一个函数判断该子串中有没有重复的字符。");
        String str = "abcabcbb";
        System.out.print(str);
        System.out.print(":");
        //------------------------------------------------------
        long startTime = System.nanoTime();   //获取开始时间
        //------------------------------------------------------
        System.out.println(t.lengthOfLongestSubstring(str));
        //------------------------------------------------------
        long endTime = System.nanoTime(); //获取结束时间
        if ((endTime - startTime) < 1000000)
        {
            double final_runtime;
            final_runtime = (endTime - startTime);
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "微秒");
        }
        else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 1000;
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "毫秒");
        }
        else
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 10000;
            final_runtime = final_runtime / 100000;
            System.out.println("算法运行时间： " + final_runtime + "秒");
        }
        Runtime r = Runtime.getRuntime();
        float memory;
        memory = r.totalMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("JVM总内存：%.3fMB\n", memory);
        memory = r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf(" 空闲内存：%.3fMB\n", memory);
        memory = r.totalMemory() - r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("已使用的内存：%.4fMB\n", memory);
        //------------------------------------------------------

        System.out.println();
        test1.main(null);

        System.out.println();
        test2.main(null);

        System.out.println();
        test3.main(null);
    }
}
