/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
// public class NestedIterator implements Iterator<Integer> {

//     Stack<NestedInteger> stack;
//     public NestedIterator(List<NestedInteger> nestedList) {
//        stack = new Stack<NestedInteger>();
//        int n = nestedList.size();
//        for(int i=n-1; i>=0; i--){
//             stack.push(nestedList.get(i));
//        }
//     }

//     @Override
//     public Integer next() {
//         if(hasNext()){
//             return stack.pop().getInteger();
//         }else{
//             return -1;
//         }
        
//     }

//     @Override
//     public boolean hasNext() {
//        if(stack.isEmpty()){
//             return false;
//         }else{
//             NestedInteger item = stack.peek();
//             if(item.isInteger()){
//                 return true;
//             }else{
//                 item = stack.pop();
//                 List<NestedInteger> list = item.getList();
//                 for(int i=list.size()-1; i>=0; i--){
//                     stack.push(list.get(i));
//                 }
//                 return hasNext();
//             }
//         }
//     }
// }
public class NestedIterator implements Iterator<Integer> {

    Queue<Integer> queue = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        dfs(nestedList);
    }

    @Override
    public Integer next() {
        return hasNext() ? queue.poll() : -1;
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    void dfs(List<NestedInteger> list) {
        for (NestedInteger item : list) {
            if (item.isInteger()) {
                queue.offer(item.getInteger());
            } else {
                dfs(item.getList());
            }
        }
    }
}


/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */