// class Solution {
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         int[] inDegree = new int[numCourses];
//         Map<Integer, List<Integer>> relation = new HashMap<>();
     

//         for(int[] courses : prerequisites){
//             int pre = courses[1];
//             int cur = courses[0];

//             inDegree[cur]++;//说明这个课需要前置课，就++

//             if(!relation.containsKey(pre)){
//                 //如果存这个pre的依赖关系，那就先new arraylist
//                 relation.put(pre, new ArrayList<>());
//             }
//             //然后再加这个next进list里
//             relation.get(pre).add(cur);
//         }

//         //入度关系和依赖关系都建立好之后开始bfs
//         //bfs的queue里面存的是入度为0的课程，也就是不需要依赖其他课的课
//         Queue<Integer> queue = new LinkedList<>();
//         for(int i=0; i<numCourses; i++){
//             if(inDegree[i] == 0){
//                 queue.offer(i);
//             }
//         }

//         int[] res= new int[numCourses];
//         int index = 0;

//         while(!queue.isEmpty()){
//             int cur = queue.poll();
//             res[index] = cur;
//             index++;

//             List<Integer> relyList = relation.get(cur);
//             if(relyList != null){
//                 for(int i: relyList){
//                     inDegree[i]--;
//                     if(inDegree[i] == 0){
//                         queue.add(i);
//                     }
//                 }
//             }
//         }

//         //return res.length == numCourses? res : new int[0];这个是错的！！因为res.length已经固定了！！是numCourses
//         //我们应该要看的是count是不是等于numCourses，因为count有可能等于numCourses，也有可能不等于
//         return index == numCourses? res : new int[0];
//     }
// }


class Solution{
    public int[] findOrder(int numCourses, int[][] prerequisites){
        int[] res = new int[numCourses];
        int[] inDegree = new int[numCourses];//how many prereq should take for each course
        List<Integer>[] outDegree = new ArrayList[numCourses];
        Queue<Integer> queue =  new LinkedList<>();//stored which course do not have pre/ have done all pre

        for(int i=0; i<numCourses; i++){
            outDegree[i] = new ArrayList<>();
        }

        for(int[] prerequisite: prerequisites){
            int cur = prerequisite[0];
            int pre = prerequisite[1];
            inDegree[cur]++;
            outDegree[pre].add(cur);
        }

        for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        int index = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int pre = queue.poll();
                res[index] = pre;
                index++;
                List<Integer> curList = outDegree[pre];
                for(int course : curList){
                    inDegree[course]--;
                    if(inDegree[course] == 0){
                        queue.offer(course);
                    }
                }
            }
        }
        return res;



    }
}
