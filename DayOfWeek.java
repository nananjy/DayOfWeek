
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * java获取一段时间内每个月的某一天是星期几，并统计星期一、星期二...星期日出现的次数
 * @author zywang
 * 输入年份n(1<=n<=40)，起始时间为1900-01-01，统计这n年内每个月13号的星期
 * 输出这n年内星期一、星期二...星期日出现的次数
 */
public class DayOfWeek {
	
	/*函数实现将星期转换为数字
	 *星期日为1、星期一为2、星期二为3、星期三为4、星期四为5、星期五为6、星期六为7
	 *输入date为当前日期
	 *输出int为星期对应的数字
	 */
	public static int dayOfWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	
	public static void main(String[] args) throws Exception {
		System.out.print("输入一个int型的年份，范围在1~40间，包括1和40\n:");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();//输入的n年
		//判断输入的n是否满足1<=n<=40,若满足则跳过while循环，继续；否则执行while直到符合条件
		while (n < 1 || n > 40) {
			System.out.print("输入有误，请重新输入\n:");
			n = scanner.nextInt();
		}
		scanner.close();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//设置日期的格式
		Date varDate;//定义varDate变量存放n年的日期
		int[] dayNum = new int[7];//存放1900-01-01之后的n年里，星期一、星期二...星期日出现的次数，初始为0
		for (int i = 1; i <= (n * 12); i++) {
			varDate = sdf.parse("1900-" + i + "-13");//将字符串转为日期
			//判断当前日期是星期几，并将当前星期的出现次数加一
			switch (dayOfWeek(varDate)) {
			case 1:
				System.out.println("星期日");
				dayNum[0]++;
				break;
			case 2:
				System.out.println("星期一");
				dayNum[1]++;
				break;
			case 3:
				System.out.println("星期二");
				dayNum[2]++;
				break;
			case 4:
				System.out.println("星期三");
				dayNum[3]++;
				break;
			case 5:
				System.out.println("星期四");
				dayNum[4]++;
				break;
			case 6:
				System.out.println("星期五");
				dayNum[5]++;
				break;
			case 7:
				System.out.println("星期六");
				dayNum[6]++;
				break;
			default:
				System.out.println("默认情况可以省略~");
				break;
			}
		}
		//将星期出现的次数输出，次序为：星期日、星期一、星期二、星期三、星期四、星期五、星期六
		for (int i : dayNum) {
			System.out.print(i + "\t");
		}
	}
}
