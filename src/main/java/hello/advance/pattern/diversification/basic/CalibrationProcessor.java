package hello.advance.pattern.diversification.basic;

import hello.advance.pattern.diversification.pojo.NodeData;
import hello.advance.pattern.diversification.processor.chain.CollectionProcessorAdapter;

import java.util.List;


public class CalibrationProcessor extends CollectionProcessorAdapter<List<NodeData>> {


    /**
     * 进行归零操作
     *
     * @param nodeDataList 要保证 nodeDataList 里的nodeId 都相同
     */
    @Override
    protected List<NodeData> doProcess(List<NodeData> nodeDataList) {
            return nodeDataList;
    }


    @Override
    public void exceptionCaught(NextProcessor nextProcessor, Throwable e) throws Exception {
        System.out.println("3");
        super.exceptionCaught(nextProcessor, e);
    }
}
