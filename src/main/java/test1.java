import java.util.HashSet;
import java.util.Set;

/**
 * Project name(项目名称)：算法_Longest_Substring_Without_Repeating_Characters
 * Package(包名): PACKAGE_NAME
 * Class(类名): test1
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/13
 * Time(创建时间)： 14:06
 * Version(版本): 1.0
 * Description(描述)： 解法二
 * 假设当 i 取 0 的时候，
 * j 取 1，判断字符串 str[0,1) 中有没有重复的字符。
 * j 取 2，判断字符串 str[0,2) 中有没有重复的字符。
 * j 取 3，判断字符串 str[0,3) 中有没有重复的字符。
 * j 取 4，判断字符串 str[0,4) 中有没有重复的字符。
 * 做了很多重复的工作，因为如果 str[0,3) 中没有重复的字符，我们不需要再判断整个字符串 str[0,4) 中有没有重复的字符，
 * 而只需要判断 str[3] 在不在 str[0,3) 中，不在的话，就表明 str[0,4) 中没有重复的字符。
 * 如果在的话，那么 str[0,5) ，str[0,6) ，str[0,7)  一定有重复的字符，所以此时后边的 j 也不需要继续增加了。i ++ 进入下次的循环就可以了。
 * 此外，我们的 j 也不需要取 j + 1，而只需要从当前的 j 开始就可以了。
 * 综上，其实整个关于 j 的循环我们完全可以去掉了，此时可以理解变成了一个「滑动窗口」。
 */

public class test1
{
    public int lengthOfLongestSubstring(String s)
    {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n)
        {
            if (!set.contains(s.charAt(j)))
            {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else
            {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        test1 t1 = new test1();
        System.out.println("解法二:");
        String str = "abcabcbb";
        System.out.print(str);
        System.out.print(":");
        //------------------------------------------------------
        long startTime = System.nanoTime();   //获取开始时间
        //------------------------------------------------------
        System.out.println(t1.lengthOfLongestSubstring(str));
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
    }
}
