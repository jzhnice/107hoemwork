import jdk.nashorn.internal.ir.WhileNode;

import java.util.*;

/**
 * @author jzh
 * @version 1.0
 * @date 2022/1/7 9:10
 * Java基础-集合：综合
 * 郑州一号线站编号和站名对应关系如下：
 * 1=河南工业大学站
 * 2=郑大科技园站
 * 3=郑州大学站
 * 4=梧桐街站
 * 5=兰寨站
 * 6=...
 * 将以上对应关系的数据存储到map集合中，key：表示站编号，value：表示站名，并遍历打印(可以不按顺序打印)：
 * 第10站: 秦岭路站
 * 第6站: 铁炉站
 * 第12站: 碧沙岗站
 * 第13站: 绿城广场站
 * 2.计算地铁票价规则：
 * 总行程 ：3站以内，共收 2 元
 * 3站 到 10站 ， 每站加收0.5元
 * 10站以上，每两站加收0.5元，
 * 封顶10元。
 * 3.打印格式（需要对键盘录入的上车站和到达站进行判断，如果没有该站，提示重新输入，直到站名存在为止）：
 * 注意：每站需要2分钟
 * 请输入上车站：
 * 西二旗
 * 您输入的上车站：西二旗不存在，请重新输入上车站：
 * 体育西路
 * 您输入的上车站：体育西路不存在，请重新输入上车站：
 * 郑州火车站
 * 请输入到达站：
 * 西二旗
 * 您输入的到达站：西二旗不存在，请重新输入到达站：
 * 体育西路
 * 您输入的到达站：体育西路不存在，请重新输入到达站：
 * 郑州东站
 * 从郑州火车站到郑州东站共经过10站收费5.5元，大约需要 20分钟
 */
public class Main {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 10, 12, 13};
        String[] strings = {"河南工业大学站", "郑大科技园站", "郑州大学站", "梧桐街站", "兰寨站", "铁炉站", "秦岭路站", "碧沙岗站", "绿城广场站"};
        HashMap<Integer, String> hashMap = new HashMap();
        for (int i = 0; i < ints.length; i++) {
            hashMap.put(ints[i], strings[i]);
        }
        Scanner scanner = new Scanner(System.in);
        Iterator iterator = hashMap.keySet().iterator();
        ArrayList arrayList = new ArrayList<String>();
        ArrayList arrayList1 = new ArrayList<Integer>();
        while (iterator.hasNext()) {
            Object next1 = iterator.next();
            Object o = hashMap.get(next1);
            arrayList1.add(next1);
            arrayList.add(o);
        }
        System.out.println(hashMap);
        int c = 0;
        String next = null;
        while (c < arrayList.size()) {
            c++;
            System.out.println("请输入上车站");
            next = scanner.next();
//            containsValue 检查 hashMap 中是否存在指定的 value
            if (hashMap.containsValue(next)) {
                break;
            } else {
                System.out.println("您输入的上车：" + next + "不存在，请重新输入上车站");
            }
        }
            String string = null;
            while (c < arrayList.size()) {
                c++;
                System.out.println("请输入下车站");
                string = scanner.next();
                if (hashMap.containsValue(string)) {
                    break;
                } else {
                    System.out.println("您输入的到达站：" + string + "不存在，请重新输入到达站");
                }
            }
            //花费的车费
            double maney = 0;
            //花费的时间
            int time = 0;
            //做的站数
            int m = 0;
            for (int i = 0; i < arrayList.size(); i++) {
                for (int j = 0; j < arrayList.size(); j++) {
                    if (arrayList.get(i).equals(next) && arrayList.get(j).equals(string)) {
                        // 下面两个是他们的站号 因为站号不全
                        Integer o = (Integer) arrayList1.get(j);
                        Integer o1 = (Integer) arrayList1.get(i);
                        m = o - o1;
                        if (m <= 3) {
                            maney = 2;
                            time = m * 2;
                            System.out.println("从" + next + "到" + string + "共经过" + m + "站收费" + maney + "元，大约需要" + time + "分钟");
                            return;
                        } else if (3 < m && m < 10) {
                            int i1 = m - 3;
                            maney = i1 * 0.5 + 2;
                            time = m * 2;
                            System.out.println("从" + next + "到" + string + "共经过" + m + "站收费" + maney + "元，大约需要" + time + "分钟");
                            return;
                        } else if (m > 10) {
                            int i1 = m - 3;
                            maney = i1 / 2 * 0.5 + 2;
                            time = m * 2;
                            System.out.println("从" + next + "到" + string + "共经过" + m + "站收费" + maney + "元，大约需要" + time + "分钟");
                            return;
                        }
                    }
                }
            }
        }
    }
