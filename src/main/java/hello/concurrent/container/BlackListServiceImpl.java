package hello.concurrent.container;

import java.util.Map;

/**
 *
 * 字眼黑名单实现
 * 这⾥需要各位⼩伙伴特别特别注意⼀个问题，此处的场景是每晚凌晨“⿊名单”定时 更新，原因是CopyOnWrite容器有数据⼀致性的问题，
 * 它只能保证最终数据⼀致 性。所以如果我们希望写⼊的数据⻢上能准确地读取，请不要使⽤CopyOnWrite容器。
 *
 * @author karl xie
 * Created on 2020-04-18 13:11
 */
public class BlackListServiceImpl {

    private static CopyOnWriteMap<String, Boolean> blackListMap =
            new CopyOnWriteMap<>();

    public static Boolean isBlackList(String id) {
        return blackListMap.get(id) == null ? false : true;
    }

    public static void addBlackList(String id) {
        blackListMap.put(id, Boolean.TRUE);
    }


    public static void addBlackList(Map<String, Boolean> ids) {
        blackListMap.putAll(ids);
    }
}