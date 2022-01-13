import java.util.HashMap;
import java.util.Map;

/**
 * Project name(项目名称)：算法_Longest_Substring_Without_Repeating_Characters
 * Package(包名): PACKAGE_NAME
 * Class(类名): test2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/13
 * Time(创建时间)： 14:13
 * Version(版本): 1.0
 * Description(描述)： 解法三
 * 我们将 set 改为 map ，将字符存为 key ，将对应的下标存到 value 里
 */

public class test2
{
    public int lengthOfLongestSubstring(String s)
    {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++)
        {
            if (map.containsKey(s.charAt(j)))
            {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);//下标 + 1 代表 i 要移动的下个位置
        }
        return ans;
    }

    public static void main(String[] args)
    {
        test2 t2 = new test2();
        System.out.println("解法三:");
        String str = "abcabcbb";
        System.out.print(str);
        System.out.print(":");
        //------------------------------------------------------
        long startTime = System.nanoTime();   //获取开始时间
        //------------------------------------------------------
        System.out.println(t2.lengthOfLongestSubstring(str));
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
