package hello.advance.others;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author karl xie
 */
public interface SpiderBeansHandle<T> {

    /**
     * 获取Url
     */
    String getUrl();

    /**
     * 获取Cookie
     */
    String getCookie();

    /***
     * 获取CSS selector
     */
    String getSelector();

    /***
     * 解析Element
     * @param element  element
     */
    T parseElement(MultipleTwoReturn element);

    /***
     * Get Beans
     * @param handle  Bean对象 | handle对象
     * @param <T>     Bean类型
     * @return List<Beans>
     */
    static <T> List<T> getBeans(SpiderBeansHandle<T> handle) {
        List<T> list = new ArrayList<>();
        // List<Element> elements = SpiderUtils.getElementWithCookie(handle.getUrl(), handle.getSelector(), handle.getCookie());
        List<MultipleTwoReturn> elements = Lists.newArrayList();
        for (MultipleTwoReturn element : elements) {
            T bean = handle.parseElement(element);
            if (bean != null) {
                list.add(bean);
            }
        }
        return list;
    }


}
