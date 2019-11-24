//package CanYouGetTheLoop;
//
//import javax.xml.soap.Node;
//import java.util.HashMap;
//import java.util.Map;
//
//public class LoopInspector {
//
//    public int loopSize(Node node) {
//        int i = 0;
//        Map<Node, Node> nodes = new HashMap();
//        while(true) {
//            Node nodede = node.getNext();
//            if(nodes.containsKey(nodede)){
//                break;
//            }
//            nodes.put(nodede, nodede);
//            i++;
//        }
//        return i;
//    }
//
//
//}