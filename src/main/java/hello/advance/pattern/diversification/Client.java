package hello.advance.pattern.diversification;

import com.google.common.collect.Lists;
import hello.advance.pattern.diversification.pojo.NodeData;
import hello.advance.pattern.diversification.processor.chain.DefaultProcessChain;
import hello.advance.pattern.diversification.processor.chain.DefaultProcessChainBuilder;
import hello.advance.pattern.diversification.processor.chain.ProcessChain;

import java.util.Date;

/**
 * @author karl xie
 * Created on 2021-02-04 09:48
 */
public class Client {

    public static void main(String[] args) {

        ChainManager chainManager = new ChainManager();
        DefaultProcessChainBuilder defaultProcessChainBuilder = chainManager.defaultProcessChainBuilder();
        ProcessChain processChain = defaultProcessChainBuilder.buildProcessChain(new DefaultProcessChain());
        processChain.fireProcess(Lists
                .newArrayList(NodeData.builder().id(1L).data(8.0).tenant("paas").time(new Date()).item("rain").build()));

    }
}